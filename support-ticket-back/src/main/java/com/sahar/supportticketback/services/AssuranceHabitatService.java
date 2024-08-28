package com.sahar.supportticketback.services;

import com.sahar.supportticketback.entities.AssuranceHabitation;
import com.sahar.supportticketback.repositories.AssuranceHabitatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssuranceHabitatService implements IAssuranceHabitatService {
    @Autowired
    AssuranceHabitatRepository assuranceHabitatRepository;
    @Override
    public void ajouterAssuranceHabitat(AssuranceHabitation assuranceHabitat) {
        assuranceHabitatRepository.save(assuranceHabitat);
    }

    @Override
    public void supprimerAssuranceHabitat(AssuranceHabitation assuranceHabitat) {
        assuranceHabitatRepository.delete(assuranceHabitat);
    }

    @Override
    public Optional<AssuranceHabitation> getAssuranceHabitat(Long id) {
        return assuranceHabitatRepository.findById(id);
    }



    @Override
    public List<AssuranceHabitation> getAssuranceHabitats() {
        List<AssuranceHabitation> list = assuranceHabitatRepository.findAll();
        return list;
    }
}
