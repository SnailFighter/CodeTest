country = ['China','USA','Fr','English']

# 从0 算起
for index,value in enumerate(country,0):
    print(index,value)
for index,value in enumerate(country,10):
    print(index,value)

country_list =list(enumerate(country,10))
print(country_list)  