var =1  #全局变量
def fun1():
    def fun2():
        var = 20  #本地变量
        print(var)
    var =2 # E 
    fun2()  #fun1 调用fun2:：
fun1()

