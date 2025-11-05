package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    public Professor criar(Professor professor) {
        return professorRepository.save(professor);
    }

    public List<Professor> buscarTodos() {
        return professorRepository.findAll();
    }

    public Optional<Professor> buscarPorId(Long id) {
        return professorRepository.findById(id);
    }

    public void deletarPorId(Long id) {
        if (!professorRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor não encontrado");
        }
        professorRepository.deleteById(id);
    }

    public void atualizarPorId(Long id, Professor professorAtualizado) {
        Optional<Professor> professorDoBanco = professorRepository.findById(id);

        if (professorDoBanco.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor não encontrado");
        }

        Professor professorParaEditar = professorDoBanco.get();
        professorParaEditar.setNomeCompleto(professorAtualizado.getNomeCompleto());
        professorParaEditar.setEmail(professorAtualizado.getEmail());
        professorParaEditar.setCpf(professorAtualizado.getCpf());

        professorRepository.save(professorParaEditar);
    }
}