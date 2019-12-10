# isinstance(param,types)

def paramCheck(age):
    if not isinstance(age,(int,str)):
        # if error, raise show error
        raise TypeError('bad type')
    print('hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh')

paramCheck(2222)
paramCheck('323df')
paramCheck([1,2,3])
