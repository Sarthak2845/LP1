### 🧠 **1. Process Synchronization**

* **Definition:**
  Synchronization is the technique of **controlling the access of multiple processes or threads** to shared resources.
  It ensures that **only one process** modifies shared data at a time, avoiding **race conditions** and **data inconsistency**.

* **Need for Synchronization:**

  * To maintain **data consistency**.
  * To avoid **race conditions**.
  * To ensure **orderly execution** of concurrent threads.

---

### 🔐 **2. Critical Section Problem**

* The part of the program where shared resources are accessed is called the **critical section**.
* Only one thread should execute in the critical section at any given time.

**Solution requirements:**

1. **Mutual Exclusion** – Only one thread can enter the critical section.
2. **Progress** – The decision of who enters next cannot be postponed indefinitely.
3. **Bounded Waiting** – No thread should wait forever to enter.

---

### ⚙️ **3. Semaphores**

* **Definition:**
  A **semaphore** is a synchronization primitive used to control access to shared resources.
  It uses two atomic operations:

  * `wait()` or `acquire()` – Decrements the semaphore. If it becomes < 0, process waits.
  * `signal()` or `release()` – Increments the semaphore. If it becomes ≥ 0, a waiting process is resumed.

* **Types:**

  1. **Binary Semaphore (Mutex):** Takes values 0 or 1 → used for mutual exclusion.
  2. **Counting Semaphore:** Can take any integer value → used to manage a limited number of resources.

---

### 🧱 **4. Mutex (Mutual Exclusion Lock)**

* A **mutex** is a binary semaphore.
* Used to protect a shared resource so that only one thread can access it at a time.
* When a thread locks the mutex, others must wait until it’s released.

---

### 🧩 **5. Reader–Writer Problem**

* A classic synchronization problem in Operating Systems.
* Multiple readers and writers share a common resource (like a database or file).

**Rules:**

1. Multiple readers can read simultaneously.
2. Only one writer can write at a time.
3. No reader should read while a writer is writing.

**Goal:**
Maintain data consistency and concurrency.

---

### ⚖️ **6. Reader–Writer Problem Types**

1. **Reader Priority (First Reader–Writer Problem):**

   * Once a reader enters, new readers are allowed even if a writer is waiting.
   * Writers may suffer from **starvation**.
2. **Writer Priority (Second Reader–Writer Problem):**

   * Once a writer is waiting, no new reader is allowed to enter.
   * Ensures writers get a fair chance.

Your program implements **Reader Priority**.

---

### 🔁 **7. Algorithm Used**

**Shared Variables:**

```java
Semaphore mutex = 1;
Semaphore wrt = 1;
int readCount = 0;
```

**Reader Process:**

```
wait(mutex);
readCount++;
if (readCount == 1)
   wait(wrt);   // first reader locks writers
signal(mutex);

--- Critical Section (read the data) ---

wait(mutex);
readCount--;
if (readCount == 0)
   signal(wrt);  // last reader unlocks writers
signal(mutex);
```

**Writer Process:**

```
wait(wrt);

--- Critical Section (write the data) ---

signal(wrt);
```

---

### 🔄 **8. Working Explanation**

* **`mutex`** → Protects `readCount` (so it’s updated safely).
* **`wrt`** → Controls access to the shared resource (`message`).
* **`readCount`** → Tracks how many readers are currently reading.

Flow:

1. The **first reader** acquires `wrt` (locks writers).
2. Multiple readers read simultaneously.
3. The **last reader** releases `wrt` (unlocks writers).
4. Writers write one at a time.

---

### 🧮 **9. Output Example**

```
Thread Writer1 is WRITING: Good Morning
Thread Writer1 has FINISHED WRITING
Thread Writer2 is WRITING: Good Morning
Thread Writer2 has FINISHED WRITING
Thread Reader1 is READING: Good Morning
Thread Reader2 is READING: Good Morning
Thread Reader3 is READING: Good Morning
Thread Reader3 has FINISHED READING
Thread Reader2 has FINISHED READING
Thread Reader1 has FINISHED READING
Thread Writer3 is WRITING: Good Morning
Thread Writer3 has FINISHED WRITING
```

✅ Multiple readers read together
✅ Writers write one by one
✅ No data corruption — synchronization successful

---

### 🚨 **10. Problems in Synchronization**

| Term               | Explanation                                                                                                                          |
| ------------------ | ------------------------------------------------------------------------------------------------------------------------------------ |
| **Race Condition** | When two or more threads access shared data simultaneously and the final result depends on the timing of access.                     |
| **Deadlock**       | A state where two or more processes are waiting indefinitely for each other to release resources.                                    |
| **Starvation**     | When a process waits indefinitely because resources are continuously given to others (e.g., writer starves in reader-priority case). |
| **Busy Waiting**   | Continuously checking for a condition in a loop without releasing CPU (inefficient). Semaphores avoid this.                          |

---

### 🧭 **11. Advantages**

* Ensures **data consistency**.
* Allows **maximum concurrency** (multiple readers).
* Prevents **race conditions**.
* Demonstrates real OS synchronization concepts.

---

### ⚠️ **12. Disadvantages**

* Writers can suffer **starvation** in reader-priority version.
* Implementation can get complex for fairness.

---

### 💡 **13. Priority in This Program**

* **Reader Priority**
* Writers wait if readers are active.
* New readers can join even while a writer is waiting.

---

### 🧩 **14. Real-Life Example**

A shared **database system**:

* Multiple users can **read** account details simultaneously.
* Only one user (admin) can **update** the database at a time.

---

### 📘 **15. Conclusion**

The program successfully implements **process synchronization** for the **Reader–Writer problem** using **semaphores**.
It ensures that multiple readers can read concurrently, but writers get exclusive access to the shared resource — maintaining data integrity and synchronization.


