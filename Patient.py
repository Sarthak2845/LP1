import tkinter as tk

root = tk.Tk()
root.title("Patient Registration Form")
root.geometry("400x500")
root.resizable(False, False)

# Title
tk.Label(root, text="Hospital Patient Registration", font=("Arial", 16, "bold")).pack(pady=10)

# Full Name
tk.Label(root, text="Full Name:").pack(anchor='w', padx=20, pady=5)
tk.Entry(root, width=35).pack(padx=20)

# Age
tk.Label(root, text="Age:").pack(anchor='w', padx=20, pady=5)
tk.Entry(root, width=35).pack(padx=20)

# Gender
tk.Label(root, text="Gender:").pack(anchor='w', padx=20, pady=5)
tk.Radiobutton(root, text="Male", value=1).pack(anchor='w', padx=40)
tk.Radiobutton(root, text="Female", value=2).pack(anchor='w', padx=40)

# Department / Ward selection
tk.Label(root, text="Select Department:").pack(anchor='w', padx=20, pady=5)
dept_listbox = tk.Listbox(root, height=5)
dept_listbox.pack(padx=20, pady=5)
for dept in ["General Medicine", "Pediatrics", "Orthopedics", "Cardiology", "Gynecology"]:
    dept_listbox.insert(tk.END, dept)

# Symptoms / Conditions
tk.Label(root, text="Symptoms:").pack(anchor='w', padx=20, pady=5)
tk.Checkbutton(root, text="Fever").pack(anchor='w', padx=40)
tk.Checkbutton(root, text="Cough").pack(anchor='w', padx=40)
tk.Checkbutton(root, text="Headache").pack(anchor='w', padx=40)
tk.Checkbutton(root, text="Body Pain").pack(anchor='w', padx=40)

# Contact Number
tk.Label(root, text="Contact Number:").pack(anchor='w', padx=20, pady=5)
tk.Entry(root, width=35).pack(padx=20)

# Terms & Conditions
tk.Checkbutton(root, text="I confirm that the above details are correct").pack(pady=10)

# Submit Button
tk.Button(root, text="Submit", width=20, bg="green", fg="white").pack(pady=10)

root.mainloop()
