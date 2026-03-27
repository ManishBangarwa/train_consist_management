import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ============================================================
 * MAIN CLASS - TCM
 * ============================================================
 * * Use Case 9: Group Bogies by Type (Stream)
 * * Description:
 * This class groups passenger bogies based on their type
 * using the Collectors.groupingBy() operation of Stream API.
 * * At this stage, the application:
 * - Creates multiple bogie objects (including identical types)
 * - Groups bogies using Stream API
 * - Validates the Map structure (Key: Type, Value: List of Bogies)
 * - Ensures the original collection is not modified
 * * This maps categorization logic using Stream API.
 * * @author Developer
 * @version 9.0
 */
public class TCM {

    // Inner Bogie class (Consistent with previous Use Cases)
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {

        // Display banner
        System.out.println("==============================================");
        System.out.println(" UC9 - Group Bogies by Type (Stream) ");
        System.out.println("==============================================\n");

        // Initialize the bogie list with some duplicate types for grouping
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("Sleeper", 70)); // Second sleeper bogie
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("General", 90));

        // Display the original list
        System.out.println("Original Bogie List:");
        bogieList.forEach(System.out::println);

        // ---- STREAM GROUPING ----
        // 1. stream() converts the list
        // 2. collect() uses groupingBy to organize bogies by their 'name'
        // Result is a Map<String, List<Bogie>>
        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        // Display grouped results matching the expected output format
        System.out.println("\nGrouped Bogies (By Type):");
        groupedBogies.forEach((type, list) -> {
            System.out.println(type + " -> " + list);
        });

        // Integrity Check (Satisfying test case requirements)
        System.out.println("\nNote:");
        System.out.println("Original list size remains: " + bogieList.size());
        System.out.println("The operation successfully separated " + groupedBogies.size() + " distinct categories.");

        System.out.println("\nUC9 grouping operations completed...");
    }
}