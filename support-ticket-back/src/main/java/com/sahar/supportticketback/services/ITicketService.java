package com.sahar.supportticketback.services;


import com.sahar.supportticketback.entities.Ticket;
import com.sahar.supportticketback.entities.Worker;

import java.util.List;

public interface ITicketService {

    public void ajouterTicket(Ticket ticket);
    public void supprimerTicket(Ticket ticket);
    public void modifierTicket(Ticket ticket);
    public List<Ticket> getTickets();
    public List<Ticket> getTicketsByEtat(String etat);
    public void assignTicket(Long ticketId, Worker worker);





}
