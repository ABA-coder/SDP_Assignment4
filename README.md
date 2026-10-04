# Cinema Tickets Bridge Pattern

This project demonstrates the Bridge structural design pattern in Java using cinema tickets.

The project separates two independent dimensions:

- Ticket types: standard and VIP
- Ticket code generators: QR code and barcode

Because these dimensions are separated, a ticket type can use any code generator. The generator can also be changed at runtime without changing the ticket class.

## Bridge roles

| Bridge role | Project class | Responsibility |
| --- | --- | --- |
| Abstraction | `MovieTicket` | Stores ticket information and a reference to a `TicketGenerator` |
| Refined Abstraction | `StandardTicket` | Represents a standard cinema ticket |
| Refined Abstraction | `VipTicket` | Represents a VIP cinema ticket |
| Implementor | `TicketGenerator` | Declares the low-level code generation operation |
| Concrete Implementor | `QrCodeGenerator` | Generates a simple QR-style ticket code |
| Concrete Implementor | `BarcodeGenerator` | Generates a simple barcode-style ticket code |
| Client | `CinemaApplication` | Combines ticket types with generators and switches a generator at runtime |

## Structure

```text
MovieTicket
|- StandardTicket
|- VipTicket
|
| uses
v
TicketGenerator
|- QrCodeGenerator
|- BarcodeGenerator
```

## How the program works

1. The client creates a ticket code generator.
2. The client passes the generator to a ticket object.
3. The ticket stores the generator through the `TicketGenerator` interface.
4. When `printTicket()` is called, the ticket delegates code generation to the selected generator.
5. The client can call `setTicketGenerator()` to switch the implementation at runtime.

## Clean Code principles

### 1. Separation of responsibilities

Ticket classes store cinema ticket data and define ticket types. Generator classes only create ticket codes. Neither side performs the other side's work.

### 2. Meaningful names

Names such as `MovieTicket`, `StandardTicket`, `TicketGenerator`, and `QrCodeGenerator` clearly describe the purpose of each class.

### 3. Small focused classes

Each class has one clear responsibility. This makes the code easier to read, explain, and test.

### 4. No duplicated ticket logic

Shared fields and printing logic are placed in `MovieTicket`. The concrete ticket classes only provide their specific ticket type.

### 5. Open Closed Principle

A new generator can be added by implementing `TicketGenerator` without changing `MovieTicket`, `StandardTicket`, or `VipTicket`.

### 6. Dependency on abstraction

`MovieTicket` depends on the `TicketGenerator` interface instead of depending directly on QR code or barcode classes.

## Why Bridge is suitable

Without Bridge, separate classes could be needed for every combination, such as `StandardQrTicket`, `StandardBarcodeTicket`, `VipQrTicket`, and `VipBarcodeTicket`. Bridge avoids this growing number of combined classes by connecting the two hierarchies through composition.

## Compile and run

Requirements: Java 17 or newer.

From the project root, run:

```powershell
javac -d out (Get-ChildItem src/main/java/com/sdp/bridge/*.java).FullName
java -cp out com.sdp.bridge.CinemaApplication
```

## Expected demonstration

The program creates:

- A standard ticket with a QR code
- A VIP ticket with a barcode
- The same standard ticket after switching its generator to barcode at runtime

This shows that ticket types and code generators can vary independently.
