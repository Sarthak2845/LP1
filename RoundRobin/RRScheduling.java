import java.util.*;

public class SimpleRoundRobin {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of processes: ");
    int n = sc.nextInt();

    int[] pid = new int[n];
    int[] at = new int[n];
    int[] bt = new int[n];
    int[] rt = new int[n]; // remaining time
    int[] ct = new int[n];
    int[] tat = new int[n];
    int[] wt = new int[n];

    for (int i = 0; i < n; i++) {
      pid[i] = i + 1;
      System.out.print("Arrival time of P" + pid[i] + ": ");
      at[i] = sc.nextInt();
      System.out.print("Burst time of P" + pid[i] + ": ");
      bt[i] = sc.nextInt();
      rt[i] = bt[i];
    }

    System.out.print("Enter time quantum: ");
    int quantum = sc.nextInt();

    // Sort processes by arrival time
    for (int i = 0; i < n - 1; i++)
      for (int j = i + 1; j < n; j++)
        if (at[i] > at[j]) {
          int t;
          t = at[i]; at[i] = at[j]; at[j] = t;
          t = bt[i]; bt[i] = bt[j]; bt[j] = t;
          t = rt[i]; rt[i] = rt[j]; rt[j] = t;
          t = pid[i]; pid[i] = pid[j]; pid[j] = t;
        }

    Queue<Integer> q = new LinkedList<>();
    boolean[] done = new boolean[n];
    int time = at[0]; // start at arrival of first process
    q.add(0);

    while (!q.isEmpty()) {
      int i = q.poll(); // current process

      // execute for min(remaining time, quantum)
      if (rt[i] <= quantum) {
        time += rt[i];
        rt[i] = 0;
        ct[i] = time;
        tat[i] = ct[i] - at[i];
        wt[i] = tat[i] - bt[i];
        done[i] = true;
      } else {
        time += quantum;
        rt[i] -= quantum;
      }

      // add all processes that have arrived by current time and not done
      for (int j = 0; j < n; j++) {
        if (at[j] <= time && !done[j] && !q.contains(j)) {
          q.add(j);
        }
      }

      // if the current process still has time left, put it back in queue
      if (!done[i] && !q.contains(i)) {
        q.add(i);
      }

      // if queue empty but unfinished processes exist, jump time to next arrival
      if (q.isEmpty()) {
        for (int j = 0; j < n; j++) {
          if (!done[j]) {
            time = at[j];
            q.add(j);
            break;
          }
        }
      }
    }

    // ---- Output ----
    float avgTAT = 0, avgWT = 0;

    System.out.printf("\nAverage Turnaround Time: %.2f\n", avgTAT / n);
    System.out.printf("Average Waiting Time: %.2f\n", avgWT / n);

    sc.close();
  }
}
