package com.sahar.supportticketback.services;

import com.sahar.supportticketback.entities.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    public void ajouterClient(Client client);
    public void supprimerClient(Client client);
    public Optional<Client> getClient(Long id);
    public List<Client> getClients();
}
