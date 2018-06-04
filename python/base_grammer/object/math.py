# 继承book
from book import Book

class Math(Book):
	def getName(self):
		return self.name
