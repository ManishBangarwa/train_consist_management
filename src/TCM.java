import java.util.LinkedList;

public class TCM {

    public static void main(String[] args) {

        // Display banner
        System.out.println("==============================================");
        System.out.println(" UC4 - Maintain Ordered Bogie Consist ");
        System.out.println("==============================================\n");

        // Create a LinkedList
        // LinkedList maintains insertion order and allows fast inserts
        LinkedList<String> trainConsist = new LinkedList<>();

        // Adding bogies in sequence
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist + "\n");

        // Inserting 'Pantry Car' at position 2 (0-indexed: Engine=0, Sleeper=1, Pantry Car=2)
        trainConsist.add(2, "Pantry Car");

        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist + "\n");

        // Removing bogies from front and rear
        trainConsist.removeFirst(); // Removes Engine
        trainConsist.removeLast();  // Removes Guard

        System.out.println("After Removing First and Last Bogie:");
        System.out.println(trainConsist + "\n");

        System.out.println("UC4 ordered consist operations completed...");
    }
}