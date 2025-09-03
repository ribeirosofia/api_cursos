package com.api_cursos.gestao_vagas.modules.candidate.useCases;

import com.api_cursos.gestao_vagas.exceptions.UserFoundException;
import com.api_cursos.gestao_vagas.modules.candidate.CandidateEntity;
import com.api_cursos.gestao_vagas.modules.candidate.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity){
        this.candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException("Usuário já existe");
                });
        return this.candidateRepository.save(candidateEntity);
    }

}
