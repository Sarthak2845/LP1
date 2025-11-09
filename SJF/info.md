### **Concept**

Preemptive SJF (SRTF) is a **CPU scheduling algorithm** where the process with the **shortest remaining burst time** is always selected for execution.
If a new process arrives with a shorter burst time than the remaining time of the currently running process, the CPU **preempts** (interrupts) the current process and assigns control to the new one.

---

### **Key Terms**

* **Preemptive:** The CPU can switch from one process to another if a shorter job arrives.
* **Burst Time (BT):** Total time required for execution.
* **Remaining Time (RT):** Burst time left for completion.
* **Arrival Time (AT):** Time when the process enters the ready queue.
* **Completion Time (CT):** Time when the process finishes execution.
* **Turnaround Time (TAT):**
  `TAT = CT – AT`
* **Waiting Time (WT):**
  `WT = TAT – BT`

---

### **Algorithm Steps**

1. Sort processes by arrival time.
2. At every unit of time, check for all arrived processes.
3. Select the process with the **least remaining burst time**.
4. Execute it for one unit of time, then re-evaluate.
5. Repeat until all processes finish execution.

---

### **Advantages**

* More responsive than non-preemptive SJF.
* Reduces average waiting and turnaround time.

---

### **Disadvantages**

* High overhead due to frequent context switching.
* Requires accurate estimation of burst times.
* Long processes may suffer from **starvation**.

---

### **Use Case**

Best suited for **time-sharing** or **interactive systems**, where responsiveness and fairness are important.
