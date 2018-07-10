import tkinter as tk
import tkinter.messagebox

def welcome():
    tk.messagebox.showinfo(title="welcome",message="欢迎登陆Snail Mail!")
    # 开启一个新的窗口
    window = tk.Tk()
    window.title('Snail Mail')
    window.geometry('1000x650')

    window.mainloop()