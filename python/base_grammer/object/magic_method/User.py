class User(object):
	def __new__(cls,*args,**kwargs):
		#打印__new__方法相关信息
		print('调用 def __new__方法')
		print(args)
		# 最后返回父类方法
		return super(User,cls).__new__(cls)

	def __init__(self,name,age):
		print('调用了def __init__方法')
		self.name=name
		self.age=age

if __name__ == '__main__':
	usr = User('哈哈',21)
