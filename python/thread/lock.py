import threading
import time

numWithLock=1
numWithoutLock=1

lock = threading.RLock()
def addWithLock():
    lock.acquire()
    global numWithLock
    numWithLock +=1
    time.sleep(1)
    lock.release()

def addWithoutLock():
    global numWithoutLock
    numWithoutLock+=1
    time.sleep(1)

threads = []

for i in range(1,20):
    x = threading.Thread(target=addWithLock)
    x.start()
    threads.append(x)

for i in range(1,20):
    t = threading.Thread(target=addWithoutLock)
    t.start()
    threads.append(t)

for i in threads:
    i.join()

print('numWithLock=',numWithLock)
print('numWithoutLock=',numWithoutLock)
