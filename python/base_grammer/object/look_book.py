from book import Book
from math import Math

class Look(object):
	@classmethod
	def get_book_name(self,book):
		print(book.getName())
	
if __name__ == '__main__':
	book = Book('书')
	math = Math('高数')
	Look.get_book_name(book)
	Look.get_book_name(math)
	
