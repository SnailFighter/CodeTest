try:
    x = int(input('输入被除数：'))
    print('100/',x,'=',100/x)
except ValueError:
    print('无效除数，重新输入......')
except ZeroDivisionError:
    print('除数不能为0，重新输入......')
except:
    print('其他异常......')
else:
    print('没有异常')
