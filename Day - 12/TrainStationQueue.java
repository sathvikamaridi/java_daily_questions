import java.util.LinkedList;
import java.util.Queue;

class Passenger {
    String name;
    int age;
    String ticketType;

    Passenger(String name, int age, String ticketType) {
        this.name = name;
        this.age = age;
        this.ticketType = ticketType;
    }

    @Override
    public String toString() {
        return name + " | Age: " + age + " | Ticket: " + ticketType;
    }
}

public class TrainStationQueue {
    Queue<Passenger> seniorQueue = new LinkedList<>();
    Queue<Passenger> regularQueue = new LinkedList<>();

    // 1. Add a passenger
    public void addPassenger(String name, int age, String ticketType) {
        Passenger p = new Passenger(name, age, ticketType);
        if (age >= 60) {
            seniorQueue.add(p);
            System.out.println("Added to Senior Queue: " + name);
        } else {
            regularQueue.add(p);
            System.out.println("Added to Regular Queue: " + name);
        }
    }

    // 2. Board next passenger
    public void boardPassenger() {
        if (!seniorQueue.isEmpty()) {
            Passenger p = seniorQueue.poll();
            System.out.println("Boarding Senior: " + p);
        } else if (!regularQueue.isEmpty()) {
            Passenger p = regularQueue.poll();
            System.out.println("Boarding Regular: " + p);
        } else {
            System.out.println("No passengers left to board.");
        }
    }

    // 3. Display passengers in both queues
    public void displayQueues() {
        System.out.println("\n👴 Senior Queue:");
        if (seniorQueue.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (Passenger p : seniorQueue) {
                System.out.println(p);
            }
        }

        System.out.println("\n🧑 Regular Queue:");
        if (regularQueue.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (Passenger p : regularQueue) {
                System.out.println(p);
            }
        }
    }

    // 4. Check if all queues are empty
    public boolean areAllQueuesEmpty() {
        return seniorQueue.isEmpty() && regularQueue.isEmpty();
    }

    // Sample execution
    public static void main(String[] args) {
        TrainStationQueue system = new TrainStationQueue();

        // Add passengers
        system.addPassenger("Ravi", 45, "General");
        system.addPassenger("Sita", 65, "Senior Citizen");
        system.addPassenger("Arjun", 30, "General");
        system.addPassenger("Meena", 72, "Senior Citizen");

        // Display queues
        system.displayQueues();

        // Board passengers
        System.out.println("\n🚆 Boarding:");
        system.boardPassenger(); // Meena
        system.boardPassenger(); // Sita
        system.boardPassenger(); // Ravi
        system.boardPassenger(); // Arjun
        system.boardPassenger(); // None left

        // Final status
        System.out.println("\nAre all queues empty? " + system.areAllQueuesEmpty());
    }
}
