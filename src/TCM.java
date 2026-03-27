import java.util.regex.Pattern;

public class TCM {

    public static void main(String[] args) {

        // Display banner
        System.out.println("==============================================");
        System.out.println(" UC11 - Regex Validation (ID & Cargo) ");
        System.out.println("==============================================\n");

        // Define Regex Patterns
        // ^ and $ ensure we match the entire string from start to end
        String trainIdRegex = "^TRN-\\d{4}$";
        String cargoCodeRegex = "^PET-[A-Z]{2}$";

        // --- Test Cases for Train ID ---
        System.out.println("--- Train ID Validation ---");
        validateInput("TRN-1234", trainIdRegex, "Valid Train ID");
        validateInput("TRN-123", trainIdRegex, "Invalid Digit Length (3)");
        validateInput("TRN-12345", trainIdRegex, "Invalid Digit Length (5)");
        validateInput("TRAIN12", trainIdRegex, "Invalid Prefix");
        validateInput("", trainIdRegex, "Empty Input");

        // --- Test Cases for Cargo Code ---
        System.out.println("\n--- Cargo Code Validation ---");
        validateInput("PET-AB", cargoCodeRegex, "Valid Cargo Code");
        validateInput("PET-ab", cargoCodeRegex, "Invalid Case (Lowercase)");
        validateInput("PET-12", cargoCodeRegex, "Invalid Suffix (Digits)");
        validateInput("PET-ABC", cargoCodeRegex, "Invalid Suffix Length");
        validateInput("AB-PET", cargoCodeRegex, "Invalid Format");

        System.out.println("\nUC11 regex validation completed...");
    }

    /**
     * Helper method to perform validation and print results
     */
    private static void validateInput(String input, String regex, String description) {
        // String.matches() performs an exact pattern check
        boolean isValid = input.matches(regex);
        String status = isValid ? "[PASS]" : "[FAIL]";

        System.out.printf("%-6s | Input: '%-10s' | Case: %-25s%n",
                status, input, description);
    }
}