#!/usr/bin/python
# -*- coding: utf-8 -*-
from obj import Obj


# python中类的继承

#继承父类Obj，python的最终父类都是object，
class extendObj(Obj):
	pass

if __name__ == '__main__':
	extendobj = extendObj('name1',21)
	print(extendobj.getName())
