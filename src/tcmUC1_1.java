import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * MAIN CLASS - tcmUC2
 * ============================================================
 * * Use Case 1: Initialize Train and Display Consist Summary
 * * Description:
 * This class represents the entry point of the Train Consist
 * Management Application.
 * * At this stage, the application:
 * - Creates an empty train consist
 * - Uses a dynamic List to store bogies
 * - Displays initial bogie count
 * - Prints the current state of the train
 * * This use case introduces collection initialization and
 * basic program startup flow.
 * * @author Developer
 * @version 1.0
 */
public class tcmUC1_1 {

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("==============================================");
        System.out.println(" === Train Consist Management App === ");
        System.out.println("==============================================\n");

        // Create a dynamic list to store train bogies (using String to represent bogie IDs/Types)
        List<String> trainConsist = new ArrayList<>();

        // Display initial consist information
        System.out.println("Train initialized successfully...");

        // Display the count of bogies (should be 0 initially)
        System.out.println("Initial Bogie Count : " + trainConsist.size());

        // Print the current state of the train (empty list [])
        System.out.println("Current Train Consist : " + trainConsist);

        // Final status message
        System.out.println("\nSystem ready for operations...");
    }
}