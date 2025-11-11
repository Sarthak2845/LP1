import tkinter as tk

root = tk.Tk()
root.title("Sign-Up Window")
root.geometry("350x350")
root.resizable(False, False)

# Title
tk.Label(root, text="Sign-Up Form", font=("Arial", 16, "bold")).pack(pady=10)

# Full Name
tk.Label(root, text="Full Name:").pack(anchor='w', padx=20, pady=5)
tk.Entry(root, width=30).pack(padx=20)

# Email
tk.Label(root, text="Email:").pack(anchor='w', padx=20, pady=5)
tk.Entry(root, width=30).pack(padx=20)

# Password
tk.Label(root, text="Password:").pack(anchor='w', padx=20, pady=5)
tk.Entry(root, width=30, show="*").pack(padx=20)

# Confirm Password
tk.Label(root, text="Confirm Password:").pack(anchor='w', padx=20, pady=5)
tk.Entry(root, width=30, show="*").pack(padx=20)

# Gender
tk.Label(root, text="Gender:").pack(anchor='w', padx=20, pady=5)
tk.Radiobutton(root, text="Male", value=1).pack(anchor='w', padx=40)
tk.Radiobutton(root, text="Female", value=2).pack(anchor='w', padx=40)

# Terms and Conditions
tk.Checkbutton(root, text="I agree to the Terms & Conditions").pack(pady=10)

# Sign Up Button
tk.Button(root, text="Sign Up", width=15).pack(pady=10)

root.mainloop()
