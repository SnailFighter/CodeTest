import threading

def handle(sid):
    print('Thread %d run'%sid, threading.current_thread())

for i in range(1,11):
    t = threading.Thread(target=handle, args=(i,))
    t.start()




