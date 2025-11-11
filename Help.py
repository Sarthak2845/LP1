import tkinter as tk

root = tk.Tk()
root.title("Help - MyApp")
root.geometry("450x400")
root.resizable(False, False)

# Title
tk.Label(root, text="Help & Support", font=("Arial", 16, "bold")).pack(pady=10)

# App Info
tk.Label(root, text="Welcome to MyApp!", font=("Arial", 12)).pack(pady=5)
tk.Label(root, text="If you are facing any issues, please read the instructions below:", font=("Arial", 10)).pack(pady=5)

# Help Text
help_text = tk.Text(root, width=55, height=12, wrap='word')
help_text.pack(padx=20, pady=10)

help_content = """Common Help Topics:
1. How to create an account – Go to the Sign-Up screen and fill all required details.
2. How to reset password – Click on 'Forgot Password' in the Login screen.
3. App not responding – Close and reopen the application.
4. Contact Support – Email us at support@myapp.com or call +91-9999999999.

Note:
Ensure you have an active internet connection before using online features.
"""

help_text.insert(tk.END, help_content)
help_text.config(state='disabled')  # make read-only

# Contact Support Section
tk.Label(root, text="Need more help?", font=("Arial", 11, "bold")).pack(pady=5)
tk.Checkbutton(root, text="Email Support Team").pack(anchor='w', padx=40)
tk.Checkbutton(root, text="Call Support Center").pack(anchor='w', padx=40)

# Button
tk.Button(root, text="Back to Home", width=20).pack(pady=15)

root.mainloop()
