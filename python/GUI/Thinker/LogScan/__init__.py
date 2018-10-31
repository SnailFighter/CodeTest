import tkinter as tk
from tkinter import *

from mysql_conn import execute_sql



def search():
    listbox.delete(0, 'end')
    if mail_entry.get() is None:
        return
    # 查询数据库方法
    lists = execute_sql(mail_entry.get(), v.get())

    if lists is not None and len(lists) > 0:
        for i in lists:
            listbox.insert('end', i)
    else:
        listbox.insert('end', "无相关信息！")
    listbox.place(x=1, y=1)
    print

window = tk.Tk()
window.title('LogScanner')
window.resizable(width=False, height=False)
window.geometry('1200x800')



# 创建frame
frm_right = tk.Frame(window, height=880, width=1200)
frm_right.pack(side='left')

# *********************右半部分********************************
frm_right_top = tk.Frame(frm_right, height=60, width=1200, bg='white')
frm_right_top.pack(side='top')

frm_right_line = tk.Frame(frm_right, height=5, width=1200,)
frm_right_line.pack(side='top')

frm_right_bottom = tk.Frame(frm_right, height=724, width=1200, bg='white')
frm_right_bottom.pack(side='bottom')

# frm_right_top label,text 等内容
frm_right_top_left = tk.Frame(frm_right_top, height=60, width=800, bg='white')
frm_right_top_left.place(x=1, y=1)

label1 = tk.Label(frm_right_top_left, text="捆包号：", bg='white', font=("Helvetical", 10))
label1.place(x=10, y=15)


# 添加提示信息
e = StringVar()
e.set("请输入捆包号,逗号分隔")
global mail_entry
mail_entry = tk.Entry(frm_right_top_left, width=1200, textvariable=e, bg='LightYellow')
mail_entry.place(x=110, y=17)

savebtn = tk.Button(frm_right_top, text='查   询', bg='LightYellow', border=2, command=search)
savebtn.place(x=850, y=15)

# 通过变量v来表明三个单选按钮是在同一个单选组中
global v
v = IntVar()
v.set(0)

Radiobutton(frm_right_top, variable=v, value=0, text='验盾', bg='white').place(x=930, y=15)

Radiobutton(frm_right_top, variable=v, value=1, text='(解)锁货', bg='white').place(x=1000, y=15)

Radiobutton(frm_right_top, variable=v, value=2, text='过户', bg='white').place(x=1090, y=15)



# item 标题


global listbox
# listbox 绑定事件
listbox = tk.Listbox(frm_right_bottom, selectmode='EXTENDED', height=666, width=800, font=("Times New Roman", 10),
                     bg='white')
#data_list = execute_sql()
#if len(data_list) > 0:
#    for x in data_list:
#        listbox.insert('end', x)
listbox.place(x=1, y=1)



window.mainloop()










