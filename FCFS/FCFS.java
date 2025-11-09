import java.util.Scanner;

public class FCFS_Simple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("*** First Come First Serve Scheduling ***");
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] arrival = new int[n];
        int[] burst = new int[n];
        int[] completion = new int[n];
        int[] tat = new int[n];
        int[] wt = new int[n];
        float totalTAT = 0, totalWT = 0;

        // Input process details
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter arrival time for process " + (i + 1) + ": ");
            arrival[i] = sc.nextInt();
            System.out.print("Enter burst time for process " + (i + 1) + ": ");
            burst[i] = sc.nextInt();
        }

        // Sort by arrival time (simple bubble sort)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arrival[i] > arrival[j]) {
                    int temp = arrival[i]; arrival[i] = arrival[j]; arrival[j] = temp;
                    temp = burst[i]; burst[i] = burst[j]; burst[j] = temp;
                }
            }
        }

        // Calculate completion time
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                completion[i] = arrival[i] + burst[i];
            } else {
                if (arrival[i] > completion[i - 1])
                    completion[i] = arrival[i] + burst[i];
                else
                    completion[i] = completion[i - 1] + burst[i];
            }
        }

        // Calculate TAT and WT
        for (int i = 0; i < n; i++) {
            tat[i] = completion[i] - arrival[i];
            wt[i] = tat[i] - burst[i];
            totalTAT += tat[i];
            totalWT += wt[i];
        }

        // Output results
        System.out.println("\n--- Results ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Process " + (i + 1));
            System.out.println("Arrival Time: " + arrival[i]);
            System.out.println("Burst Time: " + burst[i]);
            System.out.println("Completion Time: " + completion[i]);
            System.out.println("Turnaround Time: " + tat[i]);
            System.out.println("Waiting Time: " + wt[i]);
            System.out.println();
        }

        System.out.println("Average Turnaround Time: " + (totalTAT / n));
        System.out.println("Average Waiting Time: " + (totalWT / n));

        sc.close();
    }
}
