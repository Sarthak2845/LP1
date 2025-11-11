import java.util.Scanner;

public class SimplePriorityScheduling {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of processes: ");
    int n = sc.nextInt();

    int[] pid = new int[n];
    int[] at = new int[n];
    int[] bt = new int[n];
    int[] pr = new int[n];
    int[] ct = new int[n];
    int[] tat = new int[n];
    int[] wt = new int[n];
    boolean[] done = new boolean[n];

    // ----- Input -----
    for (int i = 0; i < n; i++) {
      pid[i] = i + 1;
      System.out.print("Arrival time of P" + pid[i] + ": ");
      at[i] = sc.nextInt();
      System.out.print("Burst time of P" + pid[i] + ": ");
      bt[i] = sc.nextInt();
      System.out.print("Priority of P" + pid[i]);
      pr[i] = sc.nextInt();
    }

    // ----- Sort by arrival time -----
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (at[i] > at[j]) {
          int t;
          t = at[i]; at[i] = at[j]; at[j] = t;
          t = bt[i]; bt[i] = bt[j]; bt[j] = t;
          t = pr[i]; pr[i] = pr[j]; pr[j] = t;
          t = pid[i]; pid[i] = pid[j]; pid[j] = t;
        }
      }
    }

    // ----- Scheduling -----
    int time = 0, completed = 0;
    float avgTAT = 0, avgWT = 0;

    while (completed < n) {
      int idx = -1;
      int highestPriority = Integer.MAX_VALUE;

      // find process with highest priority (lowest number) among arrived ones
      for (int i = 0; i < n; i++) {
        if (!done[i] && at[i] <= time && pr[i] < highestPriority) {
          highestPriority = pr[i];
          idx = i;
        }
      }

      // if no process has arrived, increment time
      if (idx == -1) {
        time++;
        continue;
      }

      // execute that process fully (non-preemptive)
      time += bt[idx];
      ct[idx] = time;
      tat[idx] = ct[idx] - at[idx];
      wt[idx] = tat[idx] - bt[idx];
      done[idx] = true;
      completed++;

      avgTAT += tat[idx];
      avgWT += wt[idx];
    }

    // ----- Output -----
    System.out.printf("\nAverage Turnaround Time: %.2f\n", avgTAT / n);
    System.out.printf("Average Waiting Time: %.2f\n", avgWT / n);

    sc.close();
  }
}
