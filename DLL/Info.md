## 🔹 **What is Linking?**

Linking is the process of **combining different pieces of code and data** into a single executable program.
When we write a program, it often uses functions or variables defined in other files or libraries.
The linker connects all these references together, so the program can run properly.

Linking happens after compilation and can be done in two ways:

* **Static Linking**
* **Dynamic Linking**

---

## 🔹 **Static Linking**

In **static linking**, all the required functions and libraries are **copied directly into the final executable** at compile time.

### **Features:**

* The entire code (including libraries) becomes part of the `.exe` or `.class` file.
* The program does **not need external files** to run.
* Execution is faster because everything is already linked.
* However, the executable becomes **large in size**, and if a library changes, the program must be **recompiled**.

### **Example:**

When we compile a C program with:

```bash
gcc main.c lib.c -o main
```

All the functions from `lib.c` are linked **statically** into the `main` executable.

---

## 🔹 **Dynamic Linking**

In **dynamic linking**, the program does **not copy** the library code into the executable.
Instead, it keeps only a **reference** to the shared library.
The actual linking happens **at runtime** (when the program runs).

### **Features:**

* The executable is **smaller** in size.
* Multiple programs can **share a single library file** in memory.
* If the library is updated, all programs automatically use the new version — **no recompilation needed**.
* Slightly slower execution because linking occurs at runtime.

### **Example (C language):**

In Windows → uses **`.dll` (Dynamic Link Library)`**  
In Linux → uses **`.so` (Shared Object)**

---

## 🔹 **Dynamic Link Library (DLL)**

A **DLL (Dynamic Link Library)** is a file that contains code and data that can be used by multiple programs simultaneously.
It allows programs to use functions written in other languages like C, C++, etc., **without recompiling** the main program.

### **Advantages:**

1. Saves memory and disk space.
2. Easy to update and maintain.
3. Enables **language interoperability** (e.g., Java using C functions).
4. Reduces executable size.

---

## 🔹 **Dynamic Linking in Java using JNI**

Java can use native libraries (like DLLs or `.so` files) using **Java Native Interface (JNI)**.

### **Steps in Java:**

1. Declare native methods in Java:

   ```java
   private native int add(int a, int b);
   ```
2. Load the native library:

   ```java
   static {
       System.loadLibrary("Demo");
   }
   ```
3. Implement these functions in C/C++ and compile them into a DLL:

   ```bash
   gcc -shared -fPIC -I"%JAVA_HOME%/include" -I"%JAVA_HOME%/include/win32" Demo.c -o Demo.dll
   ```
4. Run the Java program, which dynamically links to the DLL during runtime.

---

## 🔹 **Difference Between Static and Dynamic Linking**

| Feature         | Static Linking     | Dynamic Linking  |
| --------------- | ------------------ | ---------------- |
| Linking Time    | Compile time       | Run time         |
| Executable Size | Large              | Small            |
| Memory Usage    | More               | Less (shared)    |
| Update Library  | Need recompilation | No recompilation |
| Speed           | Faster             | Slightly slower  |
| Example File    | `.lib`, `.a`       | `.dll`, `.so`    |

---

## 🔹 **Conclusion**

Dynamic Linking and DLLs make programs **modular, reusable, and efficient**.
In Java, **JNI** acts as a bridge between Java and native languages like C/C++, enabling performance optimization and hardware-level access while keeping Java code portable and platform-independent.

---

## ⚙️ Step-by-Step Implementation

### 🧩 Step 1: Save the File

Save your Java file as:

```
Demo.java
```

and keep it inside:

```
D:\CG-PRACTICLES\LP1\DLL
```

---

### ⚙️ Step 2: Compile and Generate Header File

In PowerShell (after JDK is installed and `javac` works), run:

```bash
cd D:\CG-PRACTICLES\LP1\DLL
javac -h . Demo.java
```

✅ This does two things:

* Compiles `Demo.java` → creates `Demo.class`
* Generates JNI header file → `Demo.h`

You’ll now see:

```
Demo.java
Demo.class
Demo.h
```

---

### 🧠 Step 3: Implement the Native Methods in C

Create a new file named **Demo.c** (in the same folder):

```c
#include <jni.h>
#include <stdio.h>
#include "Demo.h"

JNIEXPORT jint JNICALL Java_Demo_add(JNIEnv *env, jobject obj, jint a, jint b) {
    return a + b;
}

JNIEXPORT jint JNICALL Java_Demo_sub(JNIEnv *env, jobject obj, jint a, jint b) {
    return a - b;
}

JNIEXPORT jint JNICALL Java_Demo_mul(JNIEnv *env, jobject obj, jint a, jint b) {
    return a * b;
}

JNIEXPORT jint JNICALL Java_Demo_div(JNIEnv *env, jobject obj, jint a, jint b) {
    if (b == 0) return 0;  // safeguard
    return a / b;
}
```

💡 Each function name **must match** the pattern `Java_<ClassName>_<MethodName>` exactly, or JNI won’t link it correctly.

---

### ⚙️ Step 4: Compile the DLL

Now compile your C file into a DLL (using **MinGW** or any GCC):

```bash
gcc -shared -o Demo.dll -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" Demo.c
```

✅ Output: `Demo.dll`

Now your folder contains:

```
Demo.java
Demo.class
Demo.h
Demo.c
Demo.dll
```

---

### ⚙️ Step 5: Run the Java Program

Finally, run your Java class while telling it where to find the DLL:

```bash
java -classpath . -Djava.library.path=. Demo
```

---

### 🧮 Example Run

```
Enter value of a :
10

Enter value of b :
5

1. Addition
2. Subtraction
3. Multiplication
4. Division
5. Exit

ENTER YOUR CHOICE :
1
Addition is : 15

ENTER YOUR CHOICE :
3
Multiplication is : 50
```

✅ Works perfectly — functions are handled inside `Demo.dll`.

---

## 🧱 Summary of Commands

```bash
cd D:\CG-PRACTICLES\LP1\DLL
javac -h . Demo.java
gcc -shared -o Demo.dll -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" Demo.c
java -classpath . -Djava.library.path=. Demo
```

---

