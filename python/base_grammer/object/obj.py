# java 中有构造器，python的构造器是__init__()这样的方法
# python只能有一个__init__ 这样的方法，不像java可以有多个构造方法，不过在python中在初始化方法中写多个参数，指定默认值的方式实现构造器的多态。
# 类中的方法第一个参数都有个指向自己的变量，默认写self，当然也可以写做其他名字


class Obj(object):
	def __init__(self,name,age,shortName='sn'):
		self.name=name
		self.age=age
		self.__shortName=shortName
	def getName(self):
		return self.name
	def setName(self,name):
		self.name=name


if __name__ == '__main__':
	obj = Obj('xxxx',20)
	print(obj.getName())
	obj.setName('YYYYYY')
	print(obj.getName())
	#访问属性
	print(obj.name)
	print(obj.__shortName)

