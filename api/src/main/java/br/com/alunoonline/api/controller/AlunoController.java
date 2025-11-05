package br.com.alunoonline.api.controller;


import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    //fazendo uma injecao de dependencia e para isso precisa fazer uma anotação
    //injecao que sai do service e vai para o controller
    @Autowired
    AlunoService alunoService;

    //criando um metódo, seguindo o mesmo padrao que tá na service criarAluno
    //mapeando o verbo da requisição
    //mapeando a response (resposta)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //Quando o front end mandar a requisição POST para criar o aluno, vamos pegar o aluno que chegou por json, e converter ele de JSON para Java.//

    public void criarAluno(@RequestBody Aluno aluno) {
       //injecao de dependencia
       alunoService.criarAluno(aluno);
    }
    //Para buscar usar o Get
    @GetMapping
    @ResponseStatus(HttpStatus.OK)

    //Criar metodo
    public List<Aluno> buscarTodosAlunos(){
        //o nome da injecao é AlunoService
       return alunoService.buscarTodosAlunos();
    }

    //preparar para receber o aluno no caminho do GetMapping
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    //criar metodo
    //PathVariable variavel que está no caminho
    //Quem é a variavel que está no caminho? id.
    //O id no Java se chama Long id
    public Optional<Aluno> buscarAlunoPorId(@PathVariable Long id) {
        //O nome da injecao de dependencia é AlunoService
        return alunoService.buscarAlunoPorId(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAlunoPorId(@PathVariable Long id) {
        alunoService.deletarAlunoPorId(id);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        alunoService.atualizarAlunoPorId(id, alunoAtualizado);
    }
}
