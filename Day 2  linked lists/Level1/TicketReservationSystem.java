import java.time.LocalDateTime;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    LocalDateTime bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, LocalDateTime bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    Ticket head = null;

    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, LocalDateTime.now());
        if (head == null) {
            head = newTicket;
            head.next = head;
        } else {
            Ticket current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newTicket;
            newTicket.next = head;
        }
        System.out.println("Ticket booked successfully.");
    }

    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to delete.");
            return;
        }

        if (head.ticketId == ticketId && head.next == head) {
            head = null;
            System.out.println("Ticket removed.");
            return;
        }

        Ticket current = head;
        Ticket prev = null;

        do {
            if (current.ticketId == ticketId) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    Ticket last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = current.next;
                    last.next = head;
                }
                System.out.println("Ticket removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket not found.");
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket current = head;
        do {
            displayTicket(current);
            current = current.next;
        } while (current != head);
    }

    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(keyword) || current.movieName.equalsIgnoreCase(keyword)) {
                displayTicket(current);
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found) System.out.println("No matching tickets found.");
    }

    public int totalTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }

    private void displayTicket(Ticket t) {
        System.out.println("Ticket ID: " + t.ticketId + ", Customer: " + t.customerName +
                ", Movie: " + t.movieName + ", Seat: " + t.seatNumber + ", Time: " + t.bookingTime);
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(101, "Alice", "Inception", "A1");
        system.addTicket(102, "Bob", "Interstellar", "B2");
        system.addTicket(103, "Charlie", "Inception", "C3");

        System.out.println("\nAll Tickets:");
        system.displayTickets();

        System.out.println("\nSearch by Customer Name 'Alice':");
        system.searchTicket("Alice");

        System.out.println("\nSearch by Movie Name 'Inception':");
        system.searchTicket("Inception");

        System.out.println("\nTotal Tickets Booked: " + system.totalTickets());

        System.out.println("\nRemoving Ticket ID 102:");
        system.removeTicket(102);
        system.displayTickets();
    }
}


