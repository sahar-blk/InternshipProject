package com.sahar.supportticketback.services;

import com.sahar.supportticketback.entities.AssuranceProfessionnelle;
import com.sahar.supportticketback.repositories.AssuranceProRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssuranceProService implements IAssuranceProService {
    @Autowired
    private AssuranceProRepository assuranceProRepository;
    @Override
    public void ajouterAssurancePro(AssuranceProfessionnelle assuranceProfessionnelle) {
        assuranceProRepository.save(assuranceProfessionnelle);
    }

    @Override
    public void supprimerAssurancePro(AssuranceProfessionnelle assuranceProfessionnelle) {
        assuranceProRepository.delete(assuranceProfessionnelle);

    }

    @Override
    public Optional<AssuranceProfessionnelle> getAssurancePro(Long id) {
        return assuranceProRepository.findById(id);
    }


    @Override
    public List<AssuranceProfessionnelle> getAllAssurancePro() {
        List<AssuranceProfessionnelle> l = assuranceProRepository.findAll();
        return l;
    }
}
