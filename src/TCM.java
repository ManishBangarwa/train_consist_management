import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TCM {

    static class Bogie {
        String id;
        int capacity;

        Bogie(String id, int capacity) {
            this.id = id;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        // Display banner
        System.out.println("==============================================");
        System.out.println(" UC13 - Performance: Loop vs Stream ");
        System.out.println("==============================================\n");

        // 1. Prepare a large dataset (10,000 bogies)
        List<Bogie> largeDataset = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            // Alternating capacities between 30 and 80
            largeDataset.add(new Bogie("B" + i, (i % 2 == 0) ? 80 : 30));
        }

        System.out.println("Dataset Size: " + largeDataset.size() + " bogies\n");

        // ---- APPROACH 1: TRADITIONAL LOOP ----
        long startLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : largeDataset) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }
        long endLoop = System.nanoTime();
        long loopDuration = endLoop - startLoop;

        // ---- APPROACH 2: JAVA STREAMS ----
        long startStream = System.nanoTime();
        List<Bogie> streamFiltered = largeDataset.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        long streamDuration = endStream - startStream;

        // Display Results
        System.out.println("--- Filtering Results ---");
        System.out.println("Loop Filtered Count   : " + loopFiltered.size());
        System.out.println("Stream Filtered Count : " + streamFiltered.size());
        System.out.println("Results Match?        : " + (loopFiltered.size() == streamFiltered.size()));

        System.out.println("\n--- Execution Time (Nanoseconds) ---");
        System.out.println("Loop Execution Time   : " + loopDuration + " ns");
        System.out.println("Stream Execution Time : " + streamDuration + " ns");

        // Performance Insight
        String faster = (loopDuration < streamDuration) ? "Loop" : "Stream";
        System.out.println("\nPerformance Note: In this run, " + faster + " was faster.");
        System.out.println("UC13 benchmarking completed...");
    }
}