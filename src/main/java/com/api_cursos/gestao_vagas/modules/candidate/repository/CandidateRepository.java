package com.api_cursos.gestao_vagas.modules.candidate.repository;

import com.api_cursos.gestao_vagas.modules.candidate.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {

}
