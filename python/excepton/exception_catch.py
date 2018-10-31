# 异常处理
try:
    file = open('./not_exist_file','rb')
except IOError as e:
        print('发生了错误！！！！{}'.format(e.args[-1]))




# 处理所有异常
try:
    file = open('test.txt', 'rb')
except Exception as e:
    print('An IOError occurred. {}'.format(e.args[-1]))     




# finally
try:
    file = open('./not_exist_file','rb')
except IOError as e:
        print('发生了错误！！！！{}'.format(e.args[-1]))
finally:
    print("finally we handle all operation")     


# 如果没有异常发生，else 块可以继续执行
try:
    print('发生异常，不可能的！')
except IOError as e:
        print('发生了错误！！！！{}'.format(e.args[-1]))
else:
    print("没有发生任何异常，欧耶！")
finally:
    print("finally we handle all operation")    