
for x in range(1,10):
	for y in range(1,x+1):
		print("{}x{}={} ".format(y,x,x*y),end='')
	print()




for i in range(1,10):
	for j in range(1,i+1):
		print("%sx%s =%s " % (j,i,i*j),end='')
	print()
