package com.sahar.supportticketback.controllers;

import com.sahar.supportticketback.entities.Client;
import com.sahar.supportticketback.entities.Ticket;
import com.sahar.supportticketback.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/supportticket")
public class ClientRestController {
    @Autowired
    ClientService clientService;
    @Autowired
    private  AssuranceHabitatService AssuranceHabitatService;
    @PostMapping("/ajouterClient")
    public void ajouterClient(@RequestBody Client client) {

        clientService.ajouterClient(client);
    }






}
