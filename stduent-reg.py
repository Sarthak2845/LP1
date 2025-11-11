import tkinter as tk

root = tk.Tk()
root.title("Student Registration Form")

# Title
tk.Label(root, text="Student Registration Form", font=("Arial", 16, "bold")).grid(row=0, column=0, columnspan=2, pady=10)

# Name
tk.Label(root, text="Name").grid(row=1, column=0, sticky="w", padx=10, pady=5)
tk.Entry(root).grid(row=1, column=1, padx=10, pady=5)

# Age
tk.Label(root, text="Age").grid(row=2, column=0, sticky="w", padx=10, pady=5)
tk.Entry(root).grid(row=2, column=1, padx=10, pady=5)

# Gender
tk.Label(root, text="Gender").grid(row=3, column=0, sticky="w", padx=10, pady=5)
tk.Radiobutton(root, text="Male", value=1).grid(row=3, column=1, sticky="w")
tk.Radiobutton(root, text="Female", value=2).grid(row=3, column=2, sticky="w")

# Course
tk.Label(root, text="Course").grid(row=4, column=0, sticky="w", padx=10, pady=5)
listbox = tk.Listbox(root, height=4)
listbox.grid(row=4, column=1, padx=10, pady=5)

for course in ["Computer Engineering", "Electronics", "Mechanical", "Civil"]:
    listbox.insert(tk.END, course)

# Submit button
tk.Button(root, text="Submit").grid(row=5, column=1, pady=15)

root.mainloop()
