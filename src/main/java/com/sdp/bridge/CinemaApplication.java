package com.sdp.bridge;

public class CinemaApplication {
    public static void main(String[] args) {
        TicketGenerator qrGenerator = new QrCodeGenerator();
        TicketGenerator barcodeGenerator = new BarcodeGenerator();

        MovieTicket standardTicket = new StandardTicket(
                "STD-101",
                "Interstellar",
                "A10",
                2500,
                qrGenerator);

        MovieTicket vipTicket = new VipTicket(
                "VIP-202",
                "Dune",
                "V5",
                5000,
                barcodeGenerator);

        System.out.println("Standard ticket with QR code");
        System.out.println(standardTicket.createTicket());

        System.out.println(System.lineSeparator() + "VIP ticket with barcode");
        System.out.println(vipTicket.createTicket());

        standardTicket.setTicketGenerator(barcodeGenerator);

        System.out.println(System.lineSeparator() + "Standard ticket after runtime switch");
        System.out.println(standardTicket.createTicket());
    }
}
