package com.sdp.bridge;

public class BarcodeGenerator implements TicketGenerator {
    @Override
    public String generateCode(String ticketNumber) {
        return "BAR-" + ticketNumber.replace("-", "");
    }
}
