import operator

# 列表的基本操作

list = [1,3,4,5,5,6,1,900]
list1 = [1]
print(list)

#将list1追加到list中
list.extend(list1)
print(list)

#指定位置插入一个元素
list.insert(1,111)
print(list)

#p排序
list.sort()
print("排序： ",list)

#访问指定位置的值
print("访问指定位置的值：list[3]=",list[3])

#访问指定位置的值
print("访问指定位置的值：list[0:3]=",list[0:3])

# 修改指定位置的值
list[1] = 9876
print("修改后的值：list=",list)

# 删除指定位置的值
del list[0]
print("删除后的list=",list)

# 查询列表长度
print("查询列表长度list.len=",len(list))

#合并两个列表
print("合并后的列表list=",list+list1)

#复制列表
list2 = list*2
print("复制后列表list2=",list2)

# 判断元素是否在列表中
print("元素3000是否在列表list中：",3000 in list)

#迭代输出
for x in list:
	print(x)

#########列表函数##########

# 比较两个列表 3.4.1后没有这个函数
#print("list,list1比较：cmp(list,list1)",cmp(list,list1))
print("list,list1比较：operator.eq(list,list1)",operator.eq(list,list1))

# 返回列表最大元素和最小元素
print("list最大元素：",max(list))
print("list最小元素：",min(list))

#统计元素出现的次数
print("1出现的次数：",list.count(1))

#从列表中查找第一个匹配指定元素的位置
print("1第一次出现的位置：",list.index(1))

#在指定位置插入元素
list.insert(2,4567)
print("第三个位置插入4567",list)

#反转列表
list.reverse()
print("反转列表：",list)
