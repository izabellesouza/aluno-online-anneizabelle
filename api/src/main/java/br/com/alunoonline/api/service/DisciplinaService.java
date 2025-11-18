package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    public void criarDisciplina(Disciplina disciplina){
        disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> buscarTodasDisciplinas(){
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> buscarDisciplinaPorId(long id){
        return disciplinaRepository.findById(id);
    }

    public void deletarDisciplinaPorId(long id){
        disciplinaRepository.deleteById(id);
    }

    public void atualizarDisciplinaPorId(long id, Disciplina disciplinaAtualizada){
        Optional<Disciplina> disciplinaDoBancoDeDados = buscarDisciplinaPorId(id);
        if(disciplinaDoBancoDeDados.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Disciplina não encontrada no banco de dados!");
        }

        Disciplina disciplinaParaEditar = disciplinaDoBancoDeDados.get();

        disciplinaParaEditar.setNome(disciplinaAtualizada.getNome());
        disciplinaParaEditar.setProfessor(disciplinaAtualizada.getProfessor());

        disciplinaRepository.save(disciplinaParaEditar);
    }

}