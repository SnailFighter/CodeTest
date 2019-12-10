def returnValun():
    name='天王'
    age=33
    return name,age

hisname,hisage=returnValun()
print(hisname,hisage)

persion=returnValun()
print(persion)

# 如果不需要接受某个字段，使用_
hername,_=returnValun();
print(hername)
