import tkinter as tk

root = tk.Tk()
root.title("Fund Transfer")
root.geometry("400x420")


# Title
tk.Label(root, text="Fund Transfer Window", font=("Arial", 16, "bold")).pack(pady=10)

# From Account
tk.Label(root, text="From Account:").pack(anchor='w', padx=20, pady=5)
tk.Entry(root, width=35).pack(padx=20)

# To Account
tk.Label(root, text="To Account:").pack(anchor='w', padx=20, pady=5)
tk.Entry(root, width=35).pack(padx=20)

# Amount
tk.Label(root, text="Amount (₹):").pack(anchor='w', padx=20, pady=5)
tk.Entry(root, width=35).pack(padx=20)

# Transfer Mode
tk.Label(root, text="Transfer Mode:", font=("Arial", 12)).pack(anchor='w', padx=20, pady=5)
tk.Radiobutton(root, text="NEFT", value=1).pack(anchor='w', padx=40)
tk.Radiobutton(root, text="RTGS", value=2).pack(anchor='w', padx=40)
tk.Radiobutton(root, text="IMPS", value=3).pack(anchor='w', padx=40)

# Remarks
tk.Label(root, text="Remarks:").pack(anchor='w', padx=20, pady=5)
tk.Entry(root, width=35).pack(padx=20)

# Terms and Conditions
tk.Checkbutton(root, text="I confirm the above details are correct").pack(pady=10)

# Buttons
tk.Button(root, text="Transfer", width=15, bg="green", fg="white").pack(pady=5)
tk.Button(root, text="Cancel", width=15, bg="red", fg="white").pack(pady=5)

root.mainloop()
