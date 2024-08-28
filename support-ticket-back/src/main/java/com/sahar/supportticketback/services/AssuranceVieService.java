package com.sahar.supportticketback.services;

import com.sahar.supportticketback.entities.AssuranceVie;
import com.sahar.supportticketback.repositories.AssuranceVieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssuranceVieService implements IAssuranceVieService {
    @Autowired
    private AssuranceVieRepository assuranceVieRepository;
    @Override
    public void ajouterAssuranceVie(AssuranceVie assuranceVie) {
        assuranceVieRepository.save(assuranceVie);

    }

    @Override
    public void supprimerAssuranceVie(AssuranceVie assuranceVie) {
        assuranceVieRepository.delete(assuranceVie);

    }

    @Override
    public Optional<AssuranceVie> getAssuranceVie(Long id) {
        return assuranceVieRepository.findById(id);
    }


    @Override
    public List<AssuranceVie> getAllAssuranceVie() {
        List<AssuranceVie> list = assuranceVieRepository.findAll();
        return list;
    }
}
