package com.api_vagas.gestao_vagas.modules.company.useCases;

import com.api_vagas.gestao_vagas.modules.company.entities.JobEntity;
import com.api_vagas.gestao_vagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllJobsByFilterUseCase {

    @Autowired
    private JobRepository jobRepository;

    public List<JobEntity> execute(String filter){
       return this.jobRepository.findByDescriptionContaining(filter);
    }

}
