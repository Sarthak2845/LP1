import java.util.*;

public class SJF {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*** Shortest Job First Scheduling (Preemptive) ***");

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int pid[] = new int[n];
        int at[] = new int[n]; // Arrival Time
        int bt[] = new int[n]; // Burst Time
        int rt[] = new int[n]; // Remaining Time
        int ct[] = new int[n]; // Completion Time
        int tat[] = new int[n]; // Turnaround Time
        int wt[] = new int[n]; // Waiting Time

        for (int i = 0; i < n; i++) {
            pid[i] = i + 1;
            System.out.print("Enter Arrival Time for P" + pid[i] + ": ");
            at[i] = sc.nextInt();
            System.out.print("Enter Burst Time for P" + pid[i] + ": ");
            bt[i] = sc.nextInt();
            rt[i] = bt[i]; // Initially remaining = burst
        }

        int complete = 0, time = 0, minIndex = -1;
        boolean found;

        while (complete != n) {
            found = false;
            int shortest = Integer.MAX_VALUE;

            // find process with smallest remaining time among arrived processes
            for (int i = 0; i < n; i++) {
                if (at[i] <= time && rt[i] > 0 && rt[i] < shortest) {
                    shortest = rt[i];
                    minIndex = i;
                    found = true;
                }
            }

            if (!found) { // no process has arrived yet
                time++;
                continue;
            }

            // execute that process for 1 unit
            rt[minIndex]--;
            time++;

            // if process completed
            if (rt[minIndex] == 0) {
                complete++;
                ct[minIndex] = time;
            }
        }

        // calculate TAT and WT
        float totalTAT = 0, totalWT = 0;
        for (int i = 0; i < n; i++) {
            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
            totalTAT += tat[i];
            totalWT += wt[i];
        }

        // display results
        System.out.println("\nPID\tAT\tBT\tCT\tTAT\tWT");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" +
                    ct[i] + "\t" + tat[i] + "\t" + wt[i]);
        }

        System.out.printf("\nAverage Turnaround Time: %.2f", totalTAT / n);
        System.out.printf("\nAverage Waiting Time: %.2f\n", totalWT / n);

        sc.close();
    }
}