import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
from email.header import Header

sender = 'cht_feng@163.com'
receivers = 'xxxx@qq.com'  # 接收邮件，可设置为你的QQ邮箱或者其他邮箱

# 创建一个带附件的实例
message = MIMEMultipart()
message['From'] = Header("cht email", 'utf-8')
message['To'] = receivers
subject = 'How do you do'
message['Subject'] = Header(subject, 'utf-8')

# 邮件正文内容
# message.attach(MIMEText('python程序发送的邮件，明天是周五！', 'plain', 'utf-8'))





def send_mail(username,mail_context):
    try:
        receivers = username +"@qq.com"
        # 邮件正文内容
        message.attach(MIMEText(mail_context, 'plain', 'utf-8'))
        smtpObj = smtplib.SMTP()
        smtpObj.connect('smtp.163.com')
        smtpObj.login('cht_feng@163.com', 'cht@2018')
        smtpObj.sendmail(sender, receivers, message.as_string())
        print("邮件发送成功")
        smtpObj.quit()
    except Exception as e:
        print(e)

