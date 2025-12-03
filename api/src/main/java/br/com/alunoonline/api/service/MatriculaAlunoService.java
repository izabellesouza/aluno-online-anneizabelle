package br.com.alunoonline.api.service;

import br.com.alunoonline.api.dtos.AtualizarNotasRequestDTO;
import br.com.alunoonline.api.enums.MatriculaStatusEnum;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MatriculaAlunoService {

    private static final Double MEDIA_PARA_APROVACAO = 7.0;

    @Autowired
    MatriculaAlunoRepository matriculaAlunoRepository;

    public void matricular(MatriculaAluno matriculaAluno){
        matriculaAluno.setStatus(MatriculaStatusEnum.MATRICULADO);
        matriculaAlunoRepository.save(matriculaAluno);
    }

    public void trancarMatricula(Long id){
        MatriculaAluno matriculaAluno =
                matriculaAlunoRepository.findById(id)
                        .orElseThrow(() ->
                                new ResponseStatusException(HttpStatus.NOT_FOUND,
                                        "Matrícula Aluno não encontrada!"));

        if (matriculaAluno.getStatus().equals(MatriculaStatusEnum.MATRICULADO)) {
            matriculaAluno.setStatus(MatriculaStatusEnum.TRANCADO);
            matriculaAlunoRepository.save(matriculaAluno);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Só é Possível trancar com o status MATRICULADO!");
        }
    }

    public void atualizarNotas(Long id, AtualizarNotasRequestDTO atualizarNotasRequestDTO){
        MatriculaAluno matriculaAluno =
                matriculaAlunoRepository.findById(id)
                        .orElseThrow(() ->
                                new ResponseStatusException(HttpStatus.NOT_FOUND,
                                        "Matrícula Aluno não encontrada!"));

        if (atualizarNotasRequestDTO.getNota1() != null) {
            matriculaAluno.setNota1(atualizarNotasRequestDTO.getNota1());
        }

        if (atualizarNotasRequestDTO.getNota2() != null) {
            matriculaAluno.setNota2(atualizarNotasRequestDTO.getNota2());
        }

        // Mudar status da matricula de acordo com a média
        atualizarStatus(matriculaAluno);

        // Agora vamos enviar a matricula atualizada ao BD
        matriculaAlunoRepository.save(matriculaAluno);
    }

    private void atualizarStatus(MatriculaAluno matriculaAluno) {
        Double nota1 =  matriculaAluno.getNota1();
        Double nota2 =  matriculaAluno.getNota2();

        if (nota1 != null && nota2 != null) {
            Double media = calcularMedia(nota1, nota2);
            matriculaAluno.setStatus(
                    media >= MEDIA_PARA_APROVACAO ?
                            MatriculaStatusEnum.APROVADO :
                            MatriculaStatusEnum.REPROVADO
            );
        }
    }

    private Double calcularMedia(Double nota1, Double nota2){
        return (nota1 != null && nota2 != null) ? (nota1 + nota2 ) / 2 : null;
    }
}
