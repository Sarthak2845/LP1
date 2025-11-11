import tkinter as tk

root = tk.Tk()
root.title("Login Form")
tk.Label(root, text="Login Form", font=("Arial", 16, "bold")).grid(row=0, column=0, columnspan=2, pady=10)
# Username
tk.Label(root, text="Username").grid(row=1, column=0, sticky="w", padx=10, pady=5)
tk.Entry(root).grid(row=1, column=1, padx=10, pady=5)
# Password
tk.Label(root, text="Password").grid(row=2, column=0, sticky="w", padx=10, pady=5)
tk.Entry(root, show="*").grid(row=2, column=1, padx=10, pady=5)
# Login button
tk.Button(root, text="Login").grid(row=3, column=1, pady=15)
root.mainloop()