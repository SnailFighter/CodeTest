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
