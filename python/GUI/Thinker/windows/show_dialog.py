import tkinter as tk
import tkinter.messagebox

def welcome():
    tk.messagebox.showinfo(title="welcome",message="热烈欢迎")

# 开启一个新的窗口

window = tk.Tk()
window.title('Welcome to Python GUI')
window.geometry('600x400')

window.mainloop()