package com.sahar.supportticketback.services;

import com.sahar.supportticketback.entities.Client;
import com.sahar.supportticketback.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public void ajouterClient(Client client) {
        clientRepository.save(client);

    }

    @Override
    public void supprimerClient(Client client) {
        clientRepository.delete(client);

    }

    @Override
    public Optional<Client> getClient(Long id) {
        return clientRepository.findById(id);
    }



    @Override
    public List<Client> getClients() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }
}
