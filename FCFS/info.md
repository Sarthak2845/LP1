## 🧠 **1. Introduction**

**CPU Scheduling** is the process of deciding which process will use the CPU next when there are multiple processes in the ready queue.

The **First Come First Serve (FCFS)** algorithm is the **simplest** scheduling technique.
It executes processes in the **order they arrive** — just like people waiting in a queue (first come, first served).

---

## ⚙️ **2. Definition of FCFS**

> **FCFS Scheduling** is a **non-preemptive** scheduling algorithm where the process that arrives first is executed first until it completes.

* Non-preemptive → once a process starts, it cannot be interrupted until it finishes.
* Based on **arrival time** of processes.

---

## 🧩 **3. Characteristics**

| Feature            | Description                                              |
| ------------------ | -------------------------------------------------------- |
| Scheduling Type    | Non-preemptive                                           |
| Basis of Selection | Arrival time (first come first serve)                    |
| Implementation     | FIFO (First-In-First-Out) queue                          |
| Preemption         | Not allowed                                              |
| Used In            | Batch systems or simple systems without time constraints |

---

## 📘 **4. Important Terms**

| Term                      | Formula         | Meaning                                   |
| ------------------------- | --------------- | ----------------------------------------- |
| **Arrival Time (AT)**     | —               | Time when process enters ready queue      |
| **Burst Time (BT)**       | —               | Total CPU time required by process        |
| **Completion Time (CT)**  | —               | Time when process finishes execution      |
| **Turnaround Time (TAT)** | `TAT = CT - AT` | Total time spent by process in system     |
| **Waiting Time (WT)**     | `WT = TAT - BT` | Time spent waiting in ready queue         |
| **Average TAT**           | `Σ(TAT) / n`    | Average turnaround time for all processes |
| **Average WT**            | `Σ(WT) / n`     | Average waiting time for all processes    |

---

## 📊 **5. Steps of FCFS Algorithm**

1. **Input** number of processes, their **arrival** and **burst times**.
2. **Sort** all processes according to **arrival time**.
3. For each process:

   * Calculate **Completion Time (CT)**:

     * If first process → `CT = AT + BT`
     * Else:

       * If next process arrives after CPU is idle → `CT = AT + BT`
       * Else → `CT = Previous CT + BT`
4. Compute:

   * `TAT = CT - AT`
   * `WT = TAT - BT`
5. Compute averages:

   * `Avg TAT = Total TAT / n`
   * `Avg WT = Total WT / n`
6. Display results.

---

## 🧮 **6. Example**

| Process | Arrival | Burst |
| ------- | ------- | ----- |
| P1      | 0       | 4     |
| P2      | 1       | 3     |
| P3      | 2       | 1     |

**Execution order:** P1 → P2 → P3

**Calculations:**

| Process | AT | BT | CT | TAT = CT-AT | WT = TAT-BT |
| ------- | -- | -- | -- | ----------- | ----------- |
| P1      | 0  | 4  | 4  | 4           | 0           |
| P2      | 1  | 3  | 7  | 6           | 3           |
| P3      | 2  | 1  | 8  | 6           | 5           |

**Average TAT =** (4 + 6 + 6) / 3 = **5.33**
**Average WT =** (0 + 3 + 5) / 3 = **2.67**

---

## ⏱️ **7. Gantt Chart**

```
|  P1  |  P2  | P3  |
0      4      7     8
```

* Shows how CPU time is divided among processes in sequence.

---

## ✅ **8. Advantages**

1. **Simple and easy to implement.**
2. **Fair** — every process gets CPU in order of arrival.
3. Good for **batch processing** (no strict timing).

---

## ❌ **9. Disadvantages**

1. **Poor performance for short jobs** when long jobs come first (known as **Convoy Effect**).
2. **Average waiting time** can be **very high**.
3. **Not suitable for time-sharing or interactive systems**.
4. **Non-preemptive**, so processes cannot be interrupted.

---

## 💡 **10. Applications**

* Suitable for **batch systems**.
* Used when **all jobs are roughly equal in length**.
* Used for **simple job scheduling** where fairness is more important than speed.

