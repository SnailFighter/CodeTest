a = 6 # 全局变量
def fun():
    a=5  # 
    print('=========== %n',a)
fun()  #
print(a)  # 因为fun（）中作用于只局限于函数内，所以外面不生效。
