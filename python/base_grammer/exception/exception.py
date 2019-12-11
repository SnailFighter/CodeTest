try:
    x = int(input('输入被除数：'))
    print('100/',x,'=',100/x)
except Exception as e:
    print('其他异常......')
    print(e)   # 打印异常信息


# Exception 为最大异常
