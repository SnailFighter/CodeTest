def docstring():
    '''我是文档字符串'''
    name='aaaaaaaaaaa'
    age=1111
    return name,age

print(docstring.__doc__)

# 可以修改文档字符串
docstring.__doc__ = "I am docStr"
print(docstring.__doc__)
