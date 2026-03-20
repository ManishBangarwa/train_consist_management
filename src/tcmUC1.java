import java.util.ArrayList;

// Coach class representing each coach in the train
class Coach {
    private String coachId;
    private String coachType;

    public Coach(String coachId, String coachType) {
        this.coachId = coachId;
        this.coachType = coachType;
    }

    public String getCoachId() {
        return coachId;
    }

    public String getCoachType() {
        return coachType;
    }

    @Override
    public String toString() {
        return coachId + " (" + coachType + ")";
    }
}

// Train class managing list of coaches
class Train {
    private String trainName;
    private ArrayList<Coach> coaches;

    public Train(String trainName) {
        this.trainName = trainName;
        this.coaches = new ArrayList<>();
    }

    // Add coach to train
    public void addCoach(Coach coach) {
        // Prevent duplicate coach IDs
        for (Coach c : coaches) {
            if (c.getCoachId().equals(coach.getCoachId())) {
                System.out.println("Duplicate Coach ID not allowed: " + coach.getCoachId());
                return;
            }
        }
        coaches.add(coach);
        System.out.println("Coach added: " + coach);
    }

    // Display train consist
    public void displayConsist() {
        System.out.println("\nTrain: " + trainName);
        if (coaches.isEmpty()) {
            System.out.println("No coaches attached.");
            return;
        }

        System.out.println("Train Consist:");
        for (int i = 0; i < coaches.size(); i++) {
            System.out.println((i + 1) + ". " + coaches.get(i));
        }
    }
}

// Main class for UC1
public class tcmUC1 {
    public static void main(String[] args) {

        // Create Train
        Train train = new Train("Express-101");

        // Add Coaches
        train.addCoach(new Coach("C1", "Sleeper"));
        train.addCoach(new Coach("C2", "AC"));
        train.addCoach(new Coach("C3", "General"));

        // Attempt duplicate
        train.addCoach(new Coach("C2", "AC"));

        // Display Train Consist
        train.displayConsist();
    }
}