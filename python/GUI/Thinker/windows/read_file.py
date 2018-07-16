#coding=utf-8
import os

path='mails'

def mk_mail_dir():
    # 文件夹是否已经存在
    is_exist = os.path.exists(path)
    if not is_exist:
        #创建
        os.mkdir(path,777)
        return
    else:
        #获取文件夹下面的文件名称
        files = os.listdir(path)
        print(files)
        return files

def save_file(content,file_name):
    # 权限是读写
    with open(path + '/' + file_name, 'w') as f:
        # 判断是否可写
        print(f.writable())
        # 写入内容
        f.write(content)
        f.close()

def read_file_only_read(file_name):
    with open(path+'/'+file_name, 'r') as f:
        return f.read()