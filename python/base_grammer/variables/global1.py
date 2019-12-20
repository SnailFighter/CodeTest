a = 6 # 全局变量
def fun():
    global a  # 获取全局变量
    a=5  # 
    print('=========== %n',a)
fun()  #
print(a)  # 因为使用了global，所以外面生效。
