#java 中有构造器，python的构造器是__init__()这样的方法
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



	#@classmethod 修饰的方法相当于java中static修饰的方法，是类的方法。
	@classmethod
	def getAgeAndName(self):
		#这么写是要包错误的：type object 'Obj' has no attribute 'name' 
		# 因为name是实例化后才有的 
		#return self.name
		print("yttyty")
	#@property 相当与直接返回了方法的返回值
	@property
	def getPro(self):
		return self.name


if __name__ == '__main__':
	obj = Obj('xxxx',20)
	print(obj.getName())
	obj.setName('YYYYYY')
	print(obj.getName())
	#访问属性
	print(obj.name)
	# obj.__shortName报错
	#print(obj.__shortName)
	#注意，这里直接使用的类名.方法名,另外print打印为：None，因为getAgeAndName()方法返回值为空
	print(Obj.getAgeAndName())
	#注意，这里方法名后名没有使用括号
	print(obj.getPro)
