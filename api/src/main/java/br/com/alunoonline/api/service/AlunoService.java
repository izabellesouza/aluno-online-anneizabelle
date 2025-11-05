package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public void criarAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }
    //criar um novo metodo para listar
    public List<Aluno> buscarTodosAlunos() {
        //injecao de dependencia para buscar todos os dados/alunos do bd que estao no service
        return alunoRepository.findAll();
    }
    //para retornar apenas um aluno eu uso Optional de opcional
    //usamos o long para o id
    public Optional<Aluno> buscarAlunoPorId(Long id) {
        //é o repository que busca no banco de dados
        //usando a injecao que é alunoRepository
        //findById para buscar apenas um id
        //return pois retorna ById de Aluno
        return alunoRepository.findById(id);
    }
    public void deletarAlunoPorId(Long id) {
        alunoRepository.deleteById(id);
    }
    public void atualizarAlunoPorId(Long id, Aluno alunoAtualizado) {
        // PRIMEIRO PASSO: Ver se o aluno existe no banco de dados
        Optional<Aluno> alunoDoBancoDeDados = buscarAlunoPorId(id);

        // E SE NAO EXISTIR O ALUNO COM ESSE ID?
        if (alunoDoBancoDeDados.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Aluno não encontrado no banco de dados");
        }
        // SE CHEGOU AQUI ENTAO SIGNIFICA QUE EXISTE ALUNO COM O ESSE ID
        // VOU ARMAZENÁ-LO EM UMA VARIÁVEL PARA DEPOIS EDITÁ-LO

        Aluno alunoParaEditar = alunoDoBancoDeDados.get();
        // COM ESSE ALUNO PARA SER EDITADO ACIMA, FAÇO
        // OS SETS NECESSARIOS PARA ATUALIZAR DELE

        alunoParaEditar.setNomeCompleto(alunoAtualizado.getNomeCompleto());
        alunoParaEditar.setEmail(alunoAtualizado.getEmail());
        alunoParaEditar.setCpf(alunoAtualizado.getCpf());

        // AGORA EU VOU LEVAZR ESSE ALUNO PARA EDITAR PARA O BD
        alunoRepository.save(alunoParaEditar);
    }
}

