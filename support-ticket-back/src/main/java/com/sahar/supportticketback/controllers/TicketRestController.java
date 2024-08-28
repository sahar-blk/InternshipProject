package com.sahar.supportticketback.controllers;

import com.sahar.supportticketback.entities.Ticket;
import com.sahar.supportticketback.entities.Worker;
import com.sahar.supportticketback.services.ITicketService;
import com.sahar.supportticketback.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(path = "/supportticket")


public class TicketRestController {
    @Autowired
    ITicketService iticketService;
    @Autowired
    private WorkerService workerService;


    @PostMapping ("/ajouterTicket")
    public void ajouterTicket(@RequestBody Ticket ticket) {

        iticketService.ajouterTicket(ticket);
    }
    @PutMapping ("/modifierTicket")
    public void modifierTicket(@RequestBody Ticket ticket) {
        iticketService.modifierTicket(ticket);
    }
    @DeleteMapping("/supprimerTicket")
    public void supprimerTicket(@RequestBody Ticket ticket) {
        iticketService.supprimerTicket(ticket);
    }
    @GetMapping("/getAllTickets")
    public List<Ticket> getTickets() {
        List<Ticket> l= iticketService.getTickets();
        return l;
    }
    @GetMapping ("/GetAllTicketsByEtat/{etat}")
    public List<Ticket> getTicketsByEtat(String etat) {
        List<Ticket> l= iticketService.getTicketsByEtat(etat);
        return l;
    }
    @PutMapping("/{ticketId}/assign/{workerId}")
    public ResponseEntity<Void> assignTicket(@PathVariable Long ticketId, @PathVariable Long workerId) {
        Worker user = workerService.getUserById(workerId);
        iticketService.assignTicket(ticketId, user);
        return ResponseEntity.ok().build();
    }
}
