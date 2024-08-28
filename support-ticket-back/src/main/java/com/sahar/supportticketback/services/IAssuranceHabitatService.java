package com.sahar.supportticketback.services;

import com.sahar.supportticketback.entities.AssuranceHabitation;

import java.util.List;
import java.util.Optional;

public interface IAssuranceHabitatService {
    public void ajouterAssuranceHabitat(AssuranceHabitation assuranceHabitat);
    public void supprimerAssuranceHabitat( AssuranceHabitation assuranceHabitation);
    public Optional<AssuranceHabitation> getAssuranceHabitat(Long id);
    public List<AssuranceHabitation> getAssuranceHabitats();

}
