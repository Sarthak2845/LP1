import java.util.Scanner;

public class NonSJF {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter number of processes: ");
    int n = sc.nextInt();

    int[] pid = new int[n], at = new int[n], bt = new int[n], ct = new int[n], tat = new int[n], wt = new int[n];
    float avgTAT = 0, avgWT = 0;

    for (int i = 0; i < n; i++) {
      pid[i] = i + 1;
      System.out.print("Arrival time of P" + pid[i] + ": ");
      at[i] = sc.nextInt();
      System.out.print("Burst time of P" + pid[i] + ": ");
      bt[i] = sc.nextInt();
    }

    for (int i = 0; i < n - 1; i++)
      for (int j = i + 1; j < n; j++)
        if (at[i] > at[j]) {
          int t = at[i]; at[i] = at[j]; at[j] = t;
          t = bt[i]; bt[i] = bt[j]; bt[j] = t;
          t = pid[i]; pid[i] = pid[j]; pid[j] = t;
        }

    int time = 0;
    boolean[] done = new boolean[n];
    for (int c = 0; c < n; c++) {
      int idx = -1, min = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++)
        if (!done[i] && at[i] <= time && bt[i] < min) {
          min = bt[i];
          idx = i;
        }
      if (idx == -1) { time++; c--; continue; }
      time += bt[idx];
      ct[idx] = time;
      tat[idx] = ct[idx] - at[idx];
      wt[idx] = tat[idx] - bt[idx];
      avgTAT += tat[idx];
      avgWT += wt[idx];
      done[idx] = true;
    }

    for (int i = 0; i < n; i++)
      System.out.println("P" + pid[i] + " -> CT: " + ct[i] + "ms, TAT: " + tat[i] + "ms, WT: " + wt[i] + "ms");

    System.out.printf("\nAverage Turnaround Time: %.2f\n", avgTAT / n);
    System.out.printf("Average Waiting Time: %.2f\n", avgWT / n);
    sc.close();
  }
}
