import tkinter as tk

root = tk.Tk()
root.title("Cab / Auto Booking App")
root.geometry("420x480")


# Title
tk.Label(root, text="Cab / Auto Booking", font=("Arial", 16, "bold")).pack(pady=10)

# Customer Name
tk.Label(root, text="Full Name:").pack(anchor='w', padx=20, pady=5)
tk.Entry(root, width=35).pack(padx=20)

# Pickup Location
tk.Label(root, text="Pickup Location:").pack(anchor='w', padx=20, pady=5)
tk.Entry(root, width=35).pack(padx=20)

# Drop Location
tk.Label(root, text="Drop Location:").pack(anchor='w', padx=20, pady=5)
tk.Entry(root, width=35).pack(padx=20)

# Vehicle Type
tk.Label(root, text="Select Vehicle Type:").pack(anchor='w', padx=20, pady=5)
tk.Radiobutton(root, text="Auto", value=1).pack(anchor='w', padx=40)
tk.Radiobutton(root, text="Mini Cab", value=2).pack(anchor='w', padx=40)
tk.Radiobutton(root, text="Sedan", value=3).pack(anchor='w', padx=40)
tk.Radiobutton(root, text="SUV", value=4).pack(anchor='w', padx=40)

# Payment Method
tk.Label(root, text="Payment Method:").pack(anchor='w', padx=20, pady=5)
tk.Checkbutton(root, text="Cash").pack(anchor='w', padx=40)
tk.Checkbutton(root, text="UPI / Wallet").pack(anchor='w', padx=40)
tk.Checkbutton(root, text="Credit / Debit Card").pack(anchor='w', padx=40)

# Contact Number
tk.Label(root, text="Contact Number:").pack(anchor='w', padx=20, pady=5)
tk.Entry(root, width=35).pack(padx=20)

# Terms
tk.Checkbutton(root, text="I confirm the above details are correct").pack(pady=10)

# Buttons
tk.Button(root, text="Book Ride", width=18, bg="green", fg="white").pack(pady=5)
tk.Button(root, text="Cancel", width=18, bg="red", fg="white").pack(pady=5)

root.mainloop()
