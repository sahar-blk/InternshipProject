package com.sahar.supportticketback.services;

import com.sahar.supportticketback.entities.AssuranceSante;
import com.sahar.supportticketback.repositories.AssuranceSanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssuranceSanteService implements IAssuranceSanteService {
    @Autowired
    private AssuranceSanteRepository assuranceSanteRepository;
    @Override
    public void ajouterAssuranceSante(AssuranceSante assuranceSante) {
        assuranceSanteRepository.save(assuranceSante);



    }

    @Override
    public void supprimerAssuranceSante(AssuranceSante assuranceSante) {
        assuranceSanteRepository.delete(assuranceSante);

    }

    @Override
    public Optional<AssuranceSante> getAssuranceSante(Long id) {
        return assuranceSanteRepository.findById(id);
    }



    @Override
    public List<AssuranceSante> getAssuranceSantes() {
        List<AssuranceSante> l=assuranceSanteRepository.findAll();
        return l;
    }
}
