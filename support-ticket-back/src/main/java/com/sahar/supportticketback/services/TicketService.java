package com.sahar.supportticketback.services;

import com.sahar.supportticketback.entities.Ticket;
import com.sahar.supportticketback.entities.Worker;
import com.sahar.supportticketback.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements ITicketService{

    @Autowired
    private TicketRepository ticketRepository;


    @Override
    public void ajouterTicket(Ticket ticket) {
        ticket.setEtat("en attente");
        ticketRepository.save(ticket);


    }

    @Override
    public void supprimerTicket(Ticket ticket) {
        ticketRepository.delete(ticket);

    }

    @Override
    public void modifierTicket(Ticket ticket) {
        ticketRepository.save(ticket);


    }

    @Override
    public List<Ticket> getTickets() {
        List<Ticket> t= ticketRepository.findAll();
        return t;
    }

    @Override
    public List<Ticket> getTicketsByEtat(String etat) {
        List<Ticket> t= ticketRepository.findByEtatTicket(etat);
        return t;
    }
    @Override
    public void assignTicket(Long ticketId, Worker worker) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            ticket.setAssignedTo(worker);
            ticketRepository.save(ticket);
            // Notify the user about the assignment a faaaaaaire
        } else {
            // Handle the case where the ticket is not found, e.g., log an error or return a response indicating failure
            System.out.println("Ticket not found");
        }
    }

}
