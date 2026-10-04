package com.sdp.bridge;

import java.util.Objects;

public abstract class MovieTicket {
    private final String ticketNumber;
    private final String movieTitle;
    private final String seatNumber;
    private final int price;
    private TicketGenerator ticketGenerator;

    protected MovieTicket(
            String ticketNumber,
            String movieTitle,
            String seatNumber,
            int price,
            TicketGenerator ticketGenerator) {
        this.ticketNumber = ticketNumber;
        this.movieTitle = movieTitle;
        this.seatNumber = seatNumber;
        this.price = price;
        this.ticketGenerator = Objects.requireNonNull(ticketGenerator);
    }

    public void setTicketGenerator(TicketGenerator ticketGenerator) {
        this.ticketGenerator = Objects.requireNonNull(ticketGenerator);
    }

    public String createTicket() {
        return "Ticket type: " + getTicketType()
                + System.lineSeparator() + "Movie: " + movieTitle
                + System.lineSeparator() + "Seat: " + seatNumber
                + System.lineSeparator() + "Price: " + price + " KZT"
                + System.lineSeparator() + "Code: " + ticketGenerator.generateCode(ticketNumber);
    }

    protected abstract String getTicketType();
}
