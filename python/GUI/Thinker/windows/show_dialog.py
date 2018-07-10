import tkinter as tk
import tkinter.messagebox

def welcome():
    tk.messagebox.showinfo(title="welcome",message="欢迎登陆Snail Mail!")
    # 开启一个新的窗口
    window = tk.Tk()
    window.title('Snail Mail')
    window.geometry('1000x650')

    # 创建frame
    frm_left = tk.Frame(window,height= 650,width=200,bg='white')
    frm_left.pack(side='left')
    # 创建frame
    frm_right = tk.Frame(window,height=650,width=795);
    frm_right.pack(side='right')

    #
    frm_right_top = tk.Frame(frm_right, height=60, width=795,bg='white')
    frm_right_top.pack(side='top')

    frm_right_line = tk.Frame(frm_right, height=5, width=795,)
    frm_right_line.pack(side='top')

    frm_right_bottom = tk.Frame(frm_right, height=585, width=795, bg='white')
    frm_right_bottom.pack(side='bottom')


    window.mainloop()