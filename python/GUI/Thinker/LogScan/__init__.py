import tkinter as tk
from tkinter import *

window = tk.Tk()
window.title('Snail Mail')
window.geometry('1200x800')

# 创建frame
frm_left = tk.Frame(window, height=800, width=200, bg='white')
frm_left.pack(side='left')
# 创建frame
frm_right = tk.Frame(window, height=880, width=1200)
frm_right.pack(side='left')

# *********************右半部分********************************
frm_right_top = tk.Frame(frm_right, height=60, width=1000, bg='white')
frm_right_top.pack(side='top')

frm_right_line = tk.Frame(frm_right, height=5, width=795,)
frm_right_line.pack(side='top')

frm_right_bottom = tk.Frame(frm_right, height=724, width=995, bg='blue')
frm_right_bottom.pack(side='bottom')

# frm_right_top label,text 等内容
frm_right_top_left = tk.Frame(frm_right_top, height=60, width=800, bg='white')
frm_right_top_left.place(x=1, y=1)

label1 = tk.Label(frm_right_top_left, text="捆包号：", bg='white', font=("Helvetical", 10))
label1.place(x=10, y=15)

# 添加提示信息
e = StringVar()
e.set("多个捆包号可用逗号隔开")
global mail_entry
mail_entry = tk.Entry(frm_right_top_left, width=600, textvariable=e, bg='LightYellow')
mail_entry.place(x=110, y=17)

savebtn = tk.Button(frm_right_top, text='查   询', bg='LightYellow', border=2, command='')
savebtn.place(x=850, y=15)

# *********************左半部分*******************************
global listbox
listbox = tk.Listbox(window, selectmode='EXTENDED', height=33, width=20, font=("Times New Roman", 15))
# listbox 绑定事件
listbox = tk.Listbox(window, selectmode='EXTENDED', height=650, width=21, font=("Times New Roman", 15))


# 文本内容Text
global mail_text
mail_text = tk.Text(frm_right_bottom, height=110, width=800, font=("Times New Roman", 12))
mail_text.place(x=1, y=1)

window.mainloop()







