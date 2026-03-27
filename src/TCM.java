import java.util.ArrayList;
import java.util.List;
public class TCM {

    // Inner class to represent a Goods Bogie
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return String.format("[%s | Cargo: %s]", type, cargo);
        }
    }

    public static void main(String[] args) {

        // Display banner
        System.out.println("==============================================");
        System.out.println(" UC12 - Stream Safety Validation (allMatch) ");
        System.out.println("==============================================\n");

        // 1. Valid Train Formation
        List<GoodsBogie> validTrain = new ArrayList<>();
        validTrain.add(new GoodsBogie("Cylindrical", "Petroleum"));
        validTrain.add(new GoodsBogie("Open", "Coal"));
        validTrain.add(new GoodsBogie("Cylindrical", "Petroleum"));

        // 2. Invalid Train Formation (Violation: Cylindrical carrying Coal)
        List<GoodsBogie> invalidTrain = new ArrayList<>();
        invalidTrain.add(new GoodsBogie("Cylindrical", "Petroleum"));
        invalidTrain.add(new GoodsBogie("Cylindrical", "Coal")); // Violation
        invalidTrain.add(new GoodsBogie("Box", "Grain"));

        // 3. Empty Train
        List<GoodsBogie> emptyTrain = new ArrayList<>();

        // Execution of Validations
        runSafetyCheck(validTrain, "Standard Valid Train");
        runSafetyCheck(invalidTrain, "Train with Rule Violation");
        runSafetyCheck(emptyTrain, "Empty Bogie List");

        System.out.println("\nUC12 safety validation completed...");
    }

    private static void runSafetyCheck(List<GoodsBogie> train, String scenario) {
        System.out.println("Scenario: " + scenario);

        boolean isSafe = train.stream().allMatch(bogie ->
                !bogie.type.equals("Cylindrical") || bogie.cargo.equals("Petroleum")
        );

        System.out.println("Bogie List: " + train);
        System.out.println("Safety Validation Result: " + (isSafe ? "SAFE [PASS]" : "UNSAFE [FAIL]"));
        System.out.println("----------------------------------------------");
    }
}