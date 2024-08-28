package com.sahar.supportticketback.controllers;

import com.sahar.supportticketback.entities.Ticket;
import com.sahar.supportticketback.entities.Worker;
import com.sahar.supportticketback.services.ITicketService;
import com.sahar.supportticketback.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    //chercher le ticket par id
    @GetMapping("/getTicket/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Optional<Ticket> ticket = iticketService.getTicketById(id);
        return ticket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    //liste des tickets par etat
    @GetMapping("/GetAllTicketsByEtat/{etat}")
    public List<Ticket> getTicketsByEtat(@PathVariable String etat) {
        return iticketService.getTicketsByEtat(etat);
    }
    @GetMapping("/GetTicketById/{id}")


    //assigner un ticket a un agent
    @PostMapping("/assignWorker")
    public void assignWorker(@RequestParam Long ticketId, @RequestParam Long workerId) {
        iticketService.assignWorkerToTicket(ticketId, workerId);
    }
    //changer l'etat du ticket de "en cours " a "terminé"
    @PostMapping("/changerEtat")
    public void changerEtat(@RequestBody Ticket ticket) {
        iticketService.changeStateTicket(ticket);
    }
    //liste des tickets par priorite
    @GetMapping("/GetAllTicketsByPriorite/{priorite}")
    public List<Ticket> getTicketsByPriorite(@PathVariable String priorite) {
        return iticketService.getTicketByPriority(priorite);
    }
    @PutMapping("/updateTicketStatus/{id}")
    public ResponseEntity<?> updateTicketStatus(@PathVariable Long id, @RequestBody Map<String, String> statusUpdate) {
        try {
            String newEtat = statusUpdate.get("etat");
            iticketService.updateTicketStatus(id, newEtat);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
