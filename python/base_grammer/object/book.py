# python 多态，多态是建立在继承的基础上
class Book(object):
	def __init__(self,name):
		self.name=name

	def getName(self):
		return "本书名字："+self.name

