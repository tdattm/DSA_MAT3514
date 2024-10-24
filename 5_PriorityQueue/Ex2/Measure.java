package Hw5_22000081_NguyenTienDat.Ex2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Hw5_22000081_NguyenTienDat.Ex1.PriorityQueueInterface;
import Hw5_22000081_NguyenTienDat.Ex1.SortedArrayPriorityQueue;
import Hw5_22000081_NguyenTienDat.Ex1.SortedLinkedPriorityQueue;
import Hw5_22000081_NguyenTienDat.Ex1.UnsortedArrayPriorityQueue;
import Hw5_22000081_NguyenTienDat.Ex1.UnsortedLinkedPriorityQueue;

public class Measure {

    // Factory pattern to create different types of PriorityQueue based on sign value
    public static PriorityQueueInterface<Integer, Integer> createPriorityQueue(int type, int size) {
        switch (type) {
            case 0: // Unsorted Array
                return (size > 1000)
                        ? new UnsortedArrayPriorityQueue<>(size + 1)
                        : new UnsortedArrayPriorityQueue<>();
            case 1: // Sorted Array
                return (size > 1000)
                        ? new SortedArrayPriorityQueue<>(size + 1)
                        : new SortedArrayPriorityQueue<>();
            case 2: // Unsorted Linked List
                return new UnsortedLinkedPriorityQueue<>();
            case 3: // Sorted Linked List
                return new SortedLinkedPriorityQueue<>();
            default:
                throw new IllegalArgumentException("Invalid type for PriorityQueue.");
        }
    }

    // Function to perform insertion for a given priority queue and record the time
    public static long timeInsert(PriorityQueueInterface<Integer, Integer> pq, int length) {
        long startTime = System.nanoTime(); // More precise than currentTimeMillis
        for (int i = 0; i < length; i++) {
            pq.insert(i, i);
        }
        return System.nanoTime() - startTime;
    }

    // Function to perform removeMin and record the time
    public static long timeRemoveMin(PriorityQueueInterface<Integer, Integer> pq, int length) {
        long startTime = System.nanoTime();
        for (int i = 0; i < length; i++) {
            pq.removeMin();
        }
        return System.nanoTime() - startTime;
    }

    // Helper function to run the test for all priority queue types
    public static void runTest(int size, ArrayList<Long>[] insertTimes, ArrayList<Long>[] removeTimes) {
        for (int i = 0; i < 4; i++) { // We have 4 types of PriorityQueue
            PriorityQueueInterface<Integer, Integer> pq = createPriorityQueue(i, size);

            long insertTime = timeInsert(pq, size);
            insertTimes[i].add(insertTime / 1_000_000); // Convert to milliseconds

            long removeTime = timeRemoveMin(pq, size);
            removeTimes[i].add(removeTime / 1_000_000); // Convert to milliseconds
        }
    }

    public static void main(String[] args) throws IOException {
        int[] sizes = {(int) 1e3}; // Different sizes of the input

        ArrayList<Long>[] insertTimes = new ArrayList[4];
        ArrayList<Long>[] removeTimes = new ArrayList[4];

        // Initialize lists for each type of PriorityQueue
        for (int i = 0; i < 4; i++) {
            insertTimes[i] = new ArrayList<>();
            removeTimes[i] = new ArrayList<>();
        }

        // Run the test for each input size
        for (int size : sizes) {
            runTest(size, insertTimes, removeTimes);
        }

        // Write results to a file
        String fileName = "results_new.txt";
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write("Insert times (in milliseconds):\n");
        for (int i = 0; i < 4; i++) {
            fileWriter.write("PriorityQueue type " + i + ": " + insertTimes[i].toString() + "\n");
        }

        fileWriter.write("\nRemoveMin times (in milliseconds):\n");
        for (int i = 0; i < 4; i++) {
            fileWriter.write("PriorityQueue type " + i + ": " + removeTimes[i].toString() + "\n");
        }

        fileWriter.close();
    }
}
