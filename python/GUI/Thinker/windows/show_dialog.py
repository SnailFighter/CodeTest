import tkinter as tk
from tkinter import *
import tkinter.messagebox

from PIL import Image, ImageTk
from read_file import mk_mail_dir
from read_file import read_file_only_read



# 获取选择的文件名称
def listbox_click(event):
    print('fdfdf')
    file_name_index = listbox.curselection()
    if len(file_name_index) > 0:
        content = read_file_only_read(mk_mail_dir()[file_name_index[0]])
        print(content)
        mail_text.delete(1.0, tk.END)
        mail_text.insert(tk.INSERT, content)

# 保存模板方法
def save_temple():
    # 获取text空间内容
    mail_str = mail_text.get(0, tk.END)
    # 保存内容到文件中

# 保存模板弹框
def save_temple_dialog():
    pass


def welcome():
    tk.messagebox.showinfo(title="welcome", message="欢迎登陆Snail Mail!")
    # 开启一个新的窗口
    window = tk.Toplevel()
    window.title('Snail Mail')
    window.geometry('1000x650')
    mk_mail_dir()

    # 创建frame
    frm_left = tk.Frame(window,height=650, width=200, bg='white')
    frm_left.pack(side='left')
    # 创建frame
    frm_right = tk.Frame(window, height=650, width=795);
    frm_right.pack(side='right')

    # *********************右半部分********************************
    frm_right_top = tk.Frame(frm_right, height=60, width=795, bg='white')
    frm_right_top.pack(side='top')

    frm_right_line = tk.Frame(frm_right, height=5, width=795,)
    frm_right_line.pack(side='top')

    frm_right_bottom = tk.Frame(frm_right, height=585, width=795, bg='white')
    frm_right_bottom.pack(side='bottom')

    # frm_right_top label,text 等内容
    frm_right_top_left = tk.Frame(frm_right_top, height=60, width=350, bg='white')
    frm_right_top_left.place(x=1, y=1)

    label1 = tk.Label(frm_right_top_left, text="收件人：", bg='white', font=("Helvetical", 16))
    label1.place(x=10, y=15)

    mail_entry = tk.Entry(frm_right_top_left, bg='LightYellow')
    mail_entry.place(x=110, y=17)

    send = tk.Button(frm_right_top, text='发送邮件', bg='LightYellow', border=3, command='')
    send.place(x=470, y=15)

    delbtn = tk.Button(frm_right_top, text='删除模板', bg='LightYellow', border=3, command='')
    delbtn.place(x=630, y=15)

    savebtn = tk.Button(frm_right_top, text='保存模板', bg='LightYellow', border=3, command='save_temple')
    savebtn.place(x=550, y=15)

    label3 = tk.Label(frm_right_top_left, text="@qq.com", bg='white', font=("Helvetical", 16))
    label3.place(x=210, y=15)

    # bg image
    canvas1 = tk.Canvas(frm_right_bottom, height=650, width=795)
    image_file1 = Image.open('mail_bg.jpg')
    # 如果不写expand=True 图片将被裁切
    image_file1.rotate(90, expand=True).save('mail_bg1.jpg')
    image_file2 = Image.open('mail_bg1.jpg')
    bender = Image.new('RGB', image_file2.size, (0, 0, 0, 0))
    image_file2 = Image.blend(bender, image_file2, 0.1)
    out = image_file2.resize((800, 550), Image.ANTIALIAS)
    photo1 = ImageTk.PhotoImage(out)
    canvas1.create_image(0, 0, anchor='nw', image=photo1)
    canvas1.place(x=1, y=1)

    # *********************左半部分*******************************
    global listbox
    listbox = tk.Listbox(window, selectmode='EXTENDED', height=33, width=20, font=("Times New Roman", 15))
    # listbox 绑定事件
    listbox = tk.Listbox(window, selectmode='EXTENDED', height=650, width=21, font=("Times New Roman", 15))
    listbox.bind('<Button-1>', listbox_click)
    for item in mk_mail_dir():
        listbox.insert('end', item)
    listbox.place(x=1, y=1)

    # 文本内容Text
    global mail_text
    mail_text = tk.Text(frm_right_bottom, height=585, width=795, font=("Times New Roman", 15))
    mail_text.place(x=1, y=1)


    window.mainloop()





# def alpha(self,img,factor):
#     img = img.convert('RGB')
#     bender = Image.new('RGBA',img.size,(0,0,0,0))
#     img = Image.blend(bender,img,factor)
#     return img


