package com.sahar.supportticketback.services;

import com.sahar.supportticketback.entities.AssuranceVie;

import java.util.List;
import java.util.Optional;

public interface IAssuranceVieService {
    public void ajouterAssuranceVie(AssuranceVie assuranceVie);
    public void supprimerAssuranceVie(AssuranceVie assuranceVie);
    public Optional <AssuranceVie> getAssuranceVie(Long id);
    public List<AssuranceVie> getAllAssuranceVie();
}
