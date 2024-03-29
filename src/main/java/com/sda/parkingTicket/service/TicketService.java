package com.sda.parkingTicket.service;

import com.sda.parkingTicket.dto.TicketDto;
import com.sda.parkingTicket.model.Ticket;
import com.sda.parkingTicket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.Date;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public TicketDto createTicket() {
        Ticket ticket = new Ticket();
        ticket.setCode(generateTicketCode());
        ticket.setEnterDate(new Timestamp(new Date().getTime()));

        ticketRepository.save(ticket);
        TicketDto ticketDto = new TicketDto();
        ticketDto.setCode(ticket.getCode());
        return ticketDto;
    }

    private String generateTicketCode() {
        return "T" + (long) (Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000);
    }



}

