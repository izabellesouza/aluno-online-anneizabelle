package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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
}

