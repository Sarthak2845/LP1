**Shortest Job First (Non-Preemptive) Scheduling – Theory**

Shortest Job First (SJF) is a **CPU scheduling algorithm** that selects the process with the **smallest burst time** for execution next. It minimizes average waiting and turnaround time, making it one of the most efficient non-preemptive algorithms.

### **Key Concepts**

* **Non-Preemptive:** Once a process starts execution, it runs until completion.
* **Burst Time (BT):** Time required by a process for execution.
* **Arrival Time (AT):** Time when a process enters the ready queue.
* **Completion Time (CT):** Time when a process finishes execution.
* **Turnaround Time (TAT):**
  `TAT = CT – AT`
* **Waiting Time (WT):**
  `WT = TAT – BT`

### **Algorithm Steps**

1. Sort processes by arrival time.
2. From the available processes, pick the one with the shortest burst time.
3. Execute it fully (no interruption).
4. Update current time, completion, turnaround, and waiting times.
5. Repeat until all processes are done.

### **Advantages**

* Produces minimum average waiting time.
* Efficient for smaller jobs.

### **Disadvantages**

* Difficult to predict burst time in advance.
* May cause **starvation** for longer processes.
* Not suitable for real-time systems.

### **Use Case**

SJF is ideal when process execution times are known in advance (like batch systems).
