package com.api_cursos.gestao_vagas.modules.company.useCases;

import com.api_cursos.gestao_vagas.exceptions.UserFoundException;
import com.api_cursos.gestao_vagas.modules.company.entities.CompanyEntity;
import com.api_cursos.gestao_vagas.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity){

        this.companyRepository
                .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException("Usuário já existe");
                });

        return this.companyRepository.save(companyEntity);

    }

}
