# 字典操作

# 字典相当于java中的map,字典可以存储任意类型数据
# 键必须唯一，值可以重复；键值之间分号个开，元素之间逗号隔开。
# 值必须写，不然报错dict={1:"v1",2:"v2",3:"v3",4:},这样的话会报错

dict={1:"v1",2:"v2",3:"v3"}
print("dict=",dict)

#声明时key为重复，最后一个值为准
dict1={1:"111",1:"222"}
print(dict1)

# 根据key访问值
print("dict[1]=",dict[1])

#修改字典中元素
#增加一个键值对
dict[4]="v4"
print("增加一个元素后：",dict)

#修改一个元素
dict[1]="value1"
print("修改后为：",dict)

#删除指定元素
del dict[1]
print("删除第一个元素后：",dict)

#清空字典
dict.clear()
print("清空字典后：",dict)

#删除字典
del dict


# 字典长度
#print("dict长度：",len(dict))

#输出字典可打印的子符串
#print("字典可打印的字符串：",str(dict))

#返回输入变量的类型
print("输入变量类型：",type(dict))

#字典浅复制
dict2=dict.copy({30:"val30"})
print("dict2为dict的浅复制：",dict2)

#返回字典中所有值
vals = dict2.values()
for x in vals:
	print("各个值：",x)

#随即返回并删除一个键值对
p=dict2.popitem()
print("返回的值：",p)
print("删除一个元素后的字典：",dict2)

#
print("--",dict2.items())
