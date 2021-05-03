package com.example.projektai.services;

import com.example.projektai.entity.Client;
import com.example.projektai.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client deleteClient(Client client) {
        clientRepository.delete(client);
        return client;
    }

    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }
}
