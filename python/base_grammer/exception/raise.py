import sys

try:
    x = int(input('输入被除数：'))
    if 0==x:
        raise ValueError('输入错误：0不能做除数')
    print('100/',x,'=',100/x)
except Exception as e:
    print(e)
except ZeroDivisionError:
    print('被除数不能为0')
except:
    print(sys.exc_info())
