import tkinter as tk
# 安装Pillow库
from PIL import Image, ImageTk

from show_dialog import welcome

window = tk.Tk()
window.title('Snail Mail')
window.geometry('600x400')

# welcome image
canvas = tk.Canvas(window, height=200, width=600)
image_file = Image.open('welcome.jpg')
photo = ImageTk.PhotoImage(image_file)
image = canvas.create_image(0,0, anchor='nw', image=photo)
canvas.pack(side='top')

# user information
tk.Label(window, text='User name: ').place(x=150, y= 220)
tk.Label(window, text='Password: ').place(x=150, y= 270)

var_usr_name = tk.StringVar()
var_usr_name.set('example@python.com')
entry_usr_name = tk.Entry(window, textvariable=var_usr_name)
entry_usr_name.place(x=250, y=220)
var_usr_pwd = tk.StringVar()
entry_usr_pwd = tk.Entry(window, textvariable=var_usr_pwd, show='*')
entry_usr_pwd.place(x=250, y=270)

def usr_login():
    # 主界面不关闭（否则整个程序都会关闭），而是隐藏
    window.withdraw()
    welcome()
def usr_sign_up():
    pass

# login and sign up button
btn_login = tk.Button(window, text='Login', command=usr_login)
btn_login.place(x=170, y=300)
btn_sign_up = tk.Button(window, text='Quit', command=usr_sign_up)
btn_sign_up.place(x=270, y=300)

window.mainloop()