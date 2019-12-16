import requests

def retry(attemp):
    def decorator(func):
        def wrapper(*args, **kw):
            att=0
            while att<attemp:
                print(att)
                try:
                    return func(*args, **kw)
                except Exception as e:
                    att +=1
        return wrapper
    return decorator

@retry(attemp=3)
def get_response(url):
    r = requests.get(url)
    return r

r = get_response(input('please input url:'))
print(r)

# input http://www.baidu.com
