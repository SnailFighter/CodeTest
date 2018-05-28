# 类中的方法

class Obj(object):
	def __init__(self,age,name):
		self.age=age;
		self.name=name;
	

	#自定义的方法
	def getAge(self):
		return self.age;
	#自定义的方法
	def getName(self):
		return self.name;

	#除了__init__这个方法，还有其他的类的专有方法。
	
	# __del__ 析构函数，
	def __del__(self):
		print("对像销毁了")

if __name__=='__main__':
	obj=Obj(20,'aaaa')
