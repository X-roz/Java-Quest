
# 🧵 Threads - Why Do We Need Them?

There are two main reasons why threads are essential in application development:

1. **Responsiveness** – Threads help applications remain responsive by allowing each task (like handling a user request) to run independently.
2. **Performance** – Multiple threads can perform operations simultaneously, leading to improved efficiency through concurrency.

---

## 💡 What Are Processes and How Are They Connected to Threads?

When a computer is booted, applications stored on the disk are loaded into memory as *processes*.  
Each process has:
- A **Process ID (PID)**
- A **heap** (data storage area)
- A **code section**
- A **main thread** (the starting point of execution)

A **thread** is a lightweight sub-unit of a process. Each thread has:
- A **stack** – stores method calls and local variables.
- An **instruction pointer** – points to the next instruction to execute.

---

## 🤝 How Does Multithreading Work?

Each process starts with a main thread. Multithreading involves creating additional threads within the same process that share:
- The same code
- The same data
- The same file descriptors

This allows multiple operations to happen **in parallel** under the same process (i.e., same PID).

---

## 🤔 Why Use Multiple Threads?

Switching between **threads** is significantly cheaper than switching between **processes**, because threads share the same memory and resources.

### 📱 Real-life Example: Music Player
A music player app can run:
- One thread for **UI rendering**
- Another for **audio playback**

Since both threads share the same resources (files, data), they can operate concurrently without the overhead of switching between processes.  
If only a single thread was used, the UI would freeze when the audio is being processed, leading to a poor user experience.

---

## ⚙️ How Are Threads Scheduled and Managed?

The **Operating System (OS)** handles thread scheduling using **dynamic priority allocation**.  
Here’s how it works:
- All threads are placed in a queue.
- The OS runs them in time slices called **epochs**.
- If a thread doesn’t finish its work in one epoch, it continues in the next.

This approach keeps the UI responsive while ensuring all threads get CPU time.

---

## 🔄 Thread Context Switching

When switching from one thread to another:

1. Pause execution of `Worker1`
2. Save its state
3. Load the state of `Worker2`
4. Resume execution of `Worker2`

Switching between threads is lightweight compared to switching between processes, which involves more context (e.g., memory mappings, file handles).

---

## ⚠️ Disadvantages of Using Too Many Threads

Spawning too many threads can lead to **thrashing**:
- Excessive context switching eats up CPU resources.
- The system spends more time **managing threads** than doing actual work.
- Memory consumption increases, leading to inefficiency.

---

## Summary

- Threads allow parallelism and responsiveness.
- Multithreading is efficient within a process since threads share memory.
- OS handles thread scheduling using epochs.
- Too many threads can lead to resource overhead.
