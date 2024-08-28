package com.sahar.supportticketback.services;

import com.sahar.supportticketback.entities.Ticket;

import java.util.List;
import java.util.Optional;

public interface ITicketService {

    public void ajouterTicket(Ticket ticket);
    public Optional<Ticket> getTicketById(Long id);
    public void supprimerTicket(Ticket ticket);
    public void modifierTicket(Ticket ticket);
    public List<Ticket> getTickets();
    public List<Ticket> getTicketsByEtat(String etat);
    public void assignWorkerToTicket(Long ticketId, Long workerId);
    public void changeStateTicket(Ticket ticket);
    public List<Ticket> getTicketByPriority(String priorite);
    public void updateTicketStatus(Long id, String newEtat) throws Exception;






}
