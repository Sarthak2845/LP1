import tkinter as tk

root = tk.Tk()
root.title("Sports Academy Registration Form")
root.geometry("420x520")
root.resizable(False, False)

# Title
tk.Label(root, text="Sports Academy Registration", font=("Arial", 16, "bold")).pack(pady=10)

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

# Choose Sport
tk.Label(root, text="Select Sport:").pack(anchor='w', padx=20, pady=5)
sport_listbox = tk.Listbox(root, height=5)
sport_listbox.pack(padx=20, pady=5)
for sport in ["Cricket", "Football", "Basketball", "Tennis", "Swimming"]:
    sport_listbox.insert(tk.END, sport)

# Skill Level
tk.Label(root, text="Skill Level:").pack(anchor='w', padx=20, pady=5)
tk.Checkbutton(root, text="Beginner").pack(anchor='w', padx=40)
tk.Checkbutton(root, text="Intermediate").pack(anchor='w', padx=40)
tk.Checkbutton(root, text="Advanced").pack(anchor='w', padx=40)

# Contact Number
tk.Label(root, text="Contact Number:").pack(anchor='w', padx=20, pady=5)
tk.Entry(root, width=35).pack(padx=20)

# Terms and Conditions
tk.Checkbutton(root, text="I agree to the rules & regulations of the academy").pack(pady=10)

# Submit Button
tk.Button(root, text="Register", width=20, bg="green", fg="white").pack(pady=10)

root.mainloop()
