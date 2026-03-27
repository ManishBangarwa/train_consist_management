import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class TCM {

    // Inner Bogie class (Reusable model from UC7)
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
        System.out.println(" UC8 - Filter Bogies using Stream API ");
        System.out.println("==============================================\n");

        // Initialize the bogie list
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("General", 90));

        // Display the original list
        System.out.println("Original Bogie List:");
        bogieList.forEach(System.out::println);

        // ---- STREAM FILTERING ----
        // 1. stream() converts list to a stream
        // 2. filter() uses a lambda to check if capacity > 70
        // 3. collect() converts the stream back into a new List
        List<Bogie> filteredBogies = bogieList.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        // Display the filtered results
        System.out.println("\nFiltered Bogies (Capacity > 70):");
        if (filteredBogies.isEmpty()) {
            System.out.println("[No matching bogies found]");
        } else {
            filteredBogies.forEach(System.out::println);
        }

        // Integrity Check
        System.out.println("\nNote:");
        System.out.println("Original list remains unchanged after filtering.");
        System.out.println("Original list size: " + bogieList.size());

        System.out.println("\nUC8 stream filtering completed...");
    }
}