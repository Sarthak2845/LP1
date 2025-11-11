public class BankerAlgorithm{
    public static void main(String[] args) {
        int n = 5;  // number of processes
        int r = 3;  // number of resource types

        // Allocation matrix
        int[][] alloc = {
            {0, 0, 1},  // P0
            {3, 0, 0},  // P1
            {1, 0, 1},  // P2
            {2, 3, 2},  // P3
            {0, 0, 3}   // P4
        };

        // Maximum need matrix
        int[][] max = {
            {7, 6, 3},
            {3, 2, 2},
            {8, 0, 2},
            {2, 4, 2},
            {5, 2, 3}
        };

        // Available resources
        int[] avail = {2, 3, 2};

        // Step 1: Calculate the "need" matrix
        int[][] need = new int[n][r];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < r; j++) {
                need[i][j] = max[i][j] - alloc[i][j];
            }
        }

        // Step 2: Initialize tracking arrays
        boolean[] finished = new boolean[n];
        int[] safeSeq = new int[n];
        int count = 0;

        // Step 3: Find a safe sequence
        while (count < n) {
            boolean found = false;

            for (int i = 0; i < n; i++) {
                if (!finished[i]) {
                    boolean canRun = true;

                    // Check if process i can be satisfied
                    for (int j = 0; j < r; j++) {
                        if (need[i][j] > avail[j]) {
                            canRun = false;
                            break;
                        }
                    }

                    if (canRun) {
                        // Process i can run → release its resources
                        for (int j = 0; j < r; j++) {
                            avail[j] += alloc[i][j];
                        }

                        safeSeq[count++] = i;   // add to safe sequence
                        finished[i] = true;     // mark as done
                        found = true;
                    }
                }
            }

            // If no process could run in this loop → system is unsafe
            if (!found) {
                System.out.println("System is NOT in a safe state!");
                return;
            }
        }

        // Step 4: Print the safe sequence
        System.out.print("Safe sequence: ");
        for (int i = 0; i < n; i++) {
            System.out.print("P" + safeSeq[i]);
            if (i != n - 1) System.out.print(" -> ");
        }
        System.out.println();
    }
}