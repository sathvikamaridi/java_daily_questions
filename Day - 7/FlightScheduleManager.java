class Flight {
    String flightNumber;
    String destination;
    String departureTime;
    Flight prev, next;

    public Flight(String flightNumber, String destination, String departureTime) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.prev = this.next = null;
    }
}


public class FlightScheduleManager {
    private Flight head, tail;

   
    public void addAtBeginning(String flightNo, String dest, String time) {
        Flight newFlight = new Flight(flightNo, dest, time);
        if (head == null) {
            head = tail = newFlight;
        } else {
            newFlight.next = head;
            head.prev = newFlight;
            head = newFlight;
        }
        System.out.println("Added at beginning: " + flightNo);
    }

    public void addAtEnd(String flightNo, String dest, String time) {
        Flight newFlight = new Flight(flightNo, dest, time);
        if (tail == null) {
            head = tail = newFlight;
        } else {
            tail.next = newFlight;
            newFlight.prev = tail;
            tail = newFlight;
        }
        System.out.println("Added at end: " + flightNo);
    }


    public void addAtPosition(int pos, String flightNo, String dest, String time) {
        if (pos <= 1) {
            addAtBeginning(flightNo, dest, time);
            return;
        }

        Flight newFlight = new Flight(flightNo, dest, time);
        Flight current = head;
        int index = 1;

        while (current != null && index < pos - 1) {
            current = current.next;
            index++;
        }

        if (current == null || current.next == null) {
            addAtEnd(flightNo, dest, time);
        } else {
            newFlight.next = current.next;
            newFlight.prev = current;
            current.next.prev = newFlight;
            current.next = newFlight;
            System.out.println("Inserted at position " + pos + ": " + flightNo);
        }
    }

    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("Schedule is empty.");
            return;
        }
        System.out.println("Deleted from beginning: " + head.flightNumber);
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
    }

    public void deleteFromEnd() {
        if (tail == null) {
            System.out.println("Schedule is empty.");
            return;
        }
        System.out.println("Deleted from end: " + tail.flightNumber);
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
    }


    public void deleteFromPosition(int pos) {
        if (head == null) {
            System.out.println("Schedule is empty.");
            return;
        }
        if (pos <= 1) {
            deleteFromBeginning();
            return;
        }

        Flight current = head;
        int index = 1;

        while (current != null && index < pos) {
            current = current.next;
            index++;
        }

        if (current == null) {
            System.out.println("Position " + pos + " is out of bounds.");
            return;
        }

        System.out.println("Deleted from position " + pos + ": " + current.flightNumber);

        if (current.next != null)
            current.next.prev = current.prev;
        else
            tail = current.prev;

        if (current.prev != null)
            current.prev.next = current.next;
        else
            head = current.next;
    }


    public void displaySchedule() {
        if (head == null) {
            System.out.println("No flights scheduled.");
            return;
        }

        System.out.println("\n📋 Current Flight Schedule:");
        Flight current = head;
        while (current != null) {
            System.out.println("Flight: " + current.flightNumber +
                               " | Destination: " + current.destination +
                               " | Departure: " + current.departureTime);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FlightScheduleManager schedule = new FlightScheduleManager();

        schedule.addAtEnd("AI101", "Delhi", "10:00");
        schedule.addAtBeginning("BA202", "London", "08:30");
        schedule.addAtEnd("EM303", "Dubai", "12:15");
        schedule.addAtPosition(2, "QR404", "Doha", "09:45");

        schedule.displaySchedule();

        schedule.deleteFromBeginning();
        schedule.deleteFromEnd();
        schedule.deleteFromPosition(2);

        schedule.displaySchedule();
    }
}
