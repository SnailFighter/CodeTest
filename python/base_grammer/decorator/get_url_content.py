import requests
from retry import retry 

@retry(attemp=3)
def get_response(url):
    r = requests.get(url)
    return r
