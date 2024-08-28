package com.sahar.supportticketback.services;

import com.sahar.supportticketback.entities.AssuranceSante;

import java.util.List;
import java.util.Optional;

public interface IAssuranceSanteService {
    public void ajouterAssuranceSante(AssuranceSante assuranceSante);
    public void supprimerAssuranceSante(AssuranceSante assuranceSante);
    public Optional <AssuranceSante> getAssuranceSante(Long  id);
    public List<AssuranceSante> getAssuranceSantes();

}
