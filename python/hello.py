import tkinter as tk

class Application(tk.Frame):
    def __init__(self, master=None):
        super().__init__(master)
        self.pack()
        self.create_widgets()

    def create_widgets(self):

        frame_root = tk.Frame(self)

        frame_left = tk.Frame(frame_root)
        frame_left['bg']="#cc4400"
        frame_right = tk.Frame(frame_root)




        self.hi_there = tk.Button(frame_left)
        self.hi_there["text"] = "Hello World\n(click me)"
        self.hi_there["command"] = self.say_hi
        self.hi_there.pack(side="left")

        self.hello_there = tk.Button(frame_right)
        self.hello_there["text"] = "hello!"
        self.hello_there["command"] = self.hello
        self.hello_there.place(x=115,y=15,anchor='nw')




        self.quit = tk.Button(self, text="QUIT", fg="red",
                              command=root.destroy)
        self.quit.pack(side="bottom")

        frame_left.pack(side="left")
        frame_right.pack(side="right")
        frame_root.pack();

    def say_hi(self):
        print("hi there, everyone!")

    def hello(self):
        print("hello")


# 创建一个窗口
root = tk.Tk()
# 背景颜色
root["bg"]="#f6f6f6"
# 窗口大小
root.geometry("900x600")
# 长宽不可变
root.resizable(width=False,height=False)
app = Application(master=root)

# 消息循环
app.mainloop()