
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

public class TCM {

    // Inner Bogie class with validation logic
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return String.format("Bogie[Type: %s, Capacity: %d]", type, capacity);
        }
    }

    public static void main(String[] args) {

        // Display banner
        System.out.println("==============================================");
        System.out.println(" UC14 - Custom Exception Validation ");
        System.out.println("==============================================\n");

        // --- Test Case 1: Valid Capacity ---
        System.out.println("Scenario: Creating bogie with valid capacity (72)");
        try {
            Bogie b1 = new Bogie("Sleeper", 72);
            System.out.println("Success: " + b1);
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // --- Test Case 2: Zero Capacity ---
        System.out.println("\nScenario: Creating bogie with zero capacity (0)");
        try {
            Bogie b2 = new Bogie("General", 0);
            System.out.println("Success: " + b2);
        } catch (InvalidCapacityException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }

        // --- Test Case 3: Negative Capacity ---
        System.out.println("\nScenario: Creating bogie with negative capacity (-10)");
        try {
            Bogie b3 = new Bogie("AC Chair", -10);
            System.out.println("Success: " + b3);
        } catch (InvalidCapacityException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }

        System.out.println("\nUC14 exception validation completed...");
    }
}