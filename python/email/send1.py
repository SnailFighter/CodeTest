import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
from email.header import Header

sender = 'xxxxxxx@163.com'
receivers = 'yyyyyyy@qq.com'  # 接收邮件，可设置为你的QQ邮箱或者其他邮箱

# 创建一个带附件的实例
message = MIMEMultipart()
message['From'] = Header("py email", 'utf-8')
message['To'] = receivers
subject = 'How do you do '
message['Subject'] = Header(subject, 'utf-8')

# 邮件正文内容
message.attach(MIMEText('python程序发送的邮件，明天是周五！', 'plain', 'utf-8'))

# 构造附件1，传送当前目录下的 test.txt 文件
att1 = MIMEText(open('test.txt', 'rb').read(), 'base64', 'utf-8')
att1["Content-Type"] = 'application/octet-stream'
# 这里的filename可以任意写，写什么名字，邮件中显示什么名字
att1["Content-Disposition"] = 'attachment; filename="test.txt"'
# message.attach(att1)

# 构造附件2，传送当前目录下的 runoob.txt 文件
att2 = MIMEText(open('runoob.txt', 'rb').read(), 'base64', 'utf-8')
att2["Content-Type"] = 'application/octet-stream'
att2["Content-Disposition"] = 'attachment; filename="runoob.txt"'
# message.attach(att2)



smtpObj = smtplib.SMTP()
smtpObj.connect('smtp.163.com')
smtpObj.login('xxxxxxxx@163.com', 'wwwwwww')
smtpObj.sendmail(sender, receivers, message.as_string())
print("邮件发送成功")
smtpObj.quit()
