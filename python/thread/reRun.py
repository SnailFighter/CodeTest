import threading

def hello():
    print("hello python!!!!!!")

class MyThread(threading.Thread):
    def __init__(self,sid):
        threading.Thread.__init__(self)
        self.sid=sid
    # 重载run方法, 实现逻辑的两种方法
    def run(self):
        hello() # 方式1
        print('current Thread %d run'%self.sid,threading.current_thread()) # 方式2

for i in range(1,11):
    t = MyThread(i)
    t.start()
