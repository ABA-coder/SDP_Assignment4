package com.sdp.bridge;

public class QrCodeGenerator implements TicketGenerator {
    @Override
    public String generateCode(String ticketNumber) {
        return "QR[" + ticketNumber + "]";
    }
}
