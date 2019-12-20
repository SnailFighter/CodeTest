var =1  #全局变量
def fun1():
    def fun2():
        print(var)
    fun2()  #fun1 调用fun2:：
fun1()

