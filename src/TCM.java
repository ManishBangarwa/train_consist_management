import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * MAIN CLASS - TCM
 * ============================================================
 * * Use Case 10: Aggregate Bogie Capacity (Stream)
 * * Description:
 * This class calculates the total seating capacity of a train
 * by aggregating individual bogie capacities using the
 * Stream API's map and reduce operations.
 * * At this stage, the application:
 * - Extracts capacity values using map()
 * - Performs numeric aggregation using reduce()
 * - Handles single, multiple, and empty bogie lists
 * - Maintains original collection integrity
 * * This maps terminal operations using Stream API.
 * * @author Developer
 * @version 10.0
 */
public class TCM {

    // Inner Bogie class
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (Capacity: " + capacity + ")";
        }
    }

    public static void main(String[] args) {

        // Display banner
        System.out.println("==============================================");
        System.out.println(" UC10 - Aggregate Bogie Capacity (Stream) ");
        System.out.println("==============================================\n");

        // Initialize the bogie list
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("General", 90));

        // Display the list of bogies
        System.out.println("Current Train Consist:");
        bogieList.forEach(System.out::println);

        // ---- STREAM AGGREGATION ----
        // 1. stream() - Starts the process
        // 2. map(b -> b.capacity) - Extracts the integer capacity from each Bogie object
        // 3. reduce(0, Integer::sum) - Starts at 0 and adds every capacity to the running total
        int totalCapacity = bogieList.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        // Display the aggregated result
        System.out.println("\n----------------------------------------------");
        System.out.println("Total Seating Capacity : " + totalCapacity);
        System.out.println("----------------------------------------------");

        // Integrity Check
        System.out.println("\nVerification:");
        System.out.println("Bogie count remains: " + bogieList.size());

        // Handling Empty Case (Requirement check)
        List<Bogie> emptyList = new ArrayList<>();
        int emptyTotal = emptyList.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
        System.out.println("Empty list aggregation result: " + emptyTotal);

        System.out.println("\nUC10 aggregation operations completed...");
    }
}