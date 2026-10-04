package com.sdp.bridge;

public class VipTicket extends MovieTicket {
    public VipTicket(
            String ticketNumber,
            String movieTitle,
            String seatNumber,
            int price,
            TicketGenerator ticketGenerator) {
        super(ticketNumber, movieTitle, seatNumber, price, ticketGenerator);
    }

    @Override
    protected String getTicketType() {
        return "VIP";
    }
}
