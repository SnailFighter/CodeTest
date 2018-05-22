# tuple 是一个特殊的list，它一旦被创建就不可以被修改

# 创建一个空元素的tuple
noneTuple=()
print("noneTuple",noneTuple)

#创建只包含一个元素的元组
# notice:必须添加一个逗号，不然就认为是20这个数子了
oneTuple=(20,)
print("oneTuple: ",oneTuple)
oneTuple1=(20)
print("不加逗号：",oneTuple1)
mutiTuple=(10,20,30,)
mutiTuple1=(10,20,30)

print("多个元素末尾加逗号：",mutiTuple)
print("多个元素末尾不加逗号：",mutiTuple1)

# 访问指定位置元素
testTuple=(20,50,60,)
print("第一个元素：",testTuple[0])
print("0-2位置的元素",testTuple[0:2])

# 虽然tuple一旦声明就不可修改，但也有办法修改其中的值，
# 类似其他语言的引用，tuple中的元素是内存地址，但是内存地址对应的值，可以修改
list=[1,2,5]
tuple2=("val1","val2",list)
print("修改前值：",tuple2)
list[0]=90
print("修改后的值：",tuple2)


#删除元组
del tuple2


#元素和list和相似，很多方法和list相同


