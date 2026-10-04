package com.sdp.bridge;

public class StandardTicket extends MovieTicket {
    public StandardTicket(
            String ticketNumber,
            String movieTitle,
            String seatNumber,
            int price,
            TicketGenerator ticketGenerator) {
        super(ticketNumber, movieTitle, seatNumber, price, ticketGenerator);
    }

    @Override
    protected String getTicketType() {
        return "Standard";
    }
}
