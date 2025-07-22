import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrainPassengerManager {

    public static void main(String[] args) {

        List<String> passengers = new ArrayList<>();
        passengers.add("Ravi");
        passengers.add("Anita");
        passengers.add("Zoya");
        passengers.add("Karan");

        System.out.println("Initial Passengers: " + passengers);

        passengers.add("Meena"); // Station A
        passengers.add("Sahil"); // Station B
        System.out.println("After Boarding at Stations: " + passengers);


        passengers.remove("Ravi");  // Got off at Station C
        passengers.remove("Anita"); // Got off at Station D
        System.out.println("After Some Passengers Got Off: " + passengers);


        String toCheck = "Zoya";
        if (passengers.contains(toCheck)) {
            System.out.println(toCheck + " is still on the train.");
        } else {
            System.out.println(toCheck + " is not on the train.");
        }


        List<String> sortedPassengers = new ArrayList<>(passengers);
        Collections.sort(sortedPassengers);
        System.out.println("Passengers in Alphabetical Order: " + sortedPassengers);


        List<String> backupList = new ArrayList<>(passengers);
        System.out.println("Backup Passenger List: " + backupList);


        passengers.clear();
        System.out.println("Train emptied at final station: " + passengers);
    }
}
