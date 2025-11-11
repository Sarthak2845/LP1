import tkinter as tk

root = tk.Tk()
root.title("Customer Feedback Form")
root.geometry("400x450")
root.resizable(False, False)

# Title
tk.Label(root, text="Hotel Food Feedback Form", font=("Arial", 16, "bold")).pack(pady=10)

# Name
tk.Label(root, text="Full Name:").pack(anchor='w', padx=20, pady=5)
tk.Entry(root, width=35).pack(padx=20)

# Room Number
tk.Label(root, text="Room Number:").pack(anchor='w', padx=20, pady=5)
tk.Entry(root, width=35).pack(padx=20)

# Food Quality
tk.Label(root, text="Food Quality:", font=("Arial", 12)).pack(anchor='w', padx=20, pady=5)
tk.Checkbutton(root, text="Excellent").pack(anchor='w', padx=40)
tk.Checkbutton(root, text="Good").pack(anchor='w', padx=40)
tk.Checkbutton(root, text="Average").pack(anchor='w', padx=40)
tk.Checkbutton(root, text="Poor").pack(anchor='w', padx=40)

# Service Quality
tk.Label(root, text="Service Quality:", font=("Arial", 12)).pack(anchor='w', padx=20, pady=5)
tk.Checkbutton(root, text="Excellent").pack(anchor='w', padx=40)
tk.Checkbutton(root, text="Good").pack(anchor='w', padx=40)
tk.Checkbutton(root, text="Average").pack(anchor='w', padx=40)
tk.Checkbutton(root, text="Poor").pack(anchor='w', padx=40)

# Suggestions
tk.Label(root, text="Additional Comments:").pack(anchor='w', padx=20, pady=5)
tk.Text(root, width=35, height=5).pack(padx=20, pady=5)

# Submit Button
tk.Button(root, text="Submit Feedback", width=20).pack(pady=15)

root.mainloop()
