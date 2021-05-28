package com.example.projektai.controllers;

import com.example.projektai.entities.Client;
import com.example.projektai.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getClients(){
        List<Client> clients = clientService.getClients();
        return ResponseEntity.ok(clients);
    }
    @PostMapping
    public ResponseEntity<Client> createOpinion(@RequestBody Client client){
        Client createdClient = clientService.createClient(client);
        return ResponseEntity.status(201).body(createdClient);
    }

    @DeleteMapping
    public ResponseEntity<Client> deleteOpinion(@RequestBody Client client){
        Client deletedClient = clientService.deleteClient(client);
        return ResponseEntity.ok(deletedClient);
    }

    @PutMapping
    public ResponseEntity<Client> updateOpinion(@RequestBody Client client){
        Client updatedClient = clientService.updateClient(client);
        return ResponseEntity.ok(updatedClient);
    }
}
