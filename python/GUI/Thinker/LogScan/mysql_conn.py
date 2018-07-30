import pymysql.cursors
import json

# Connect to the database
connection = pymysql.connect(host='147.107.123.216',
                             port=3308,
                             user='root',
                             password='mysql',
                             db='resources',
                             charset='utf8',
                             cursorclass=pymysql.cursors.DictCursor)

try:
    with connection.cursor() as cursor:
        # Read a single record
        sql = "select * from check_package_detail_log limit 30"
        cursor.execute(sql)
        # 返回的是list，list里面是dict数据
        result = cursor.fetchmany(10)
        for x in result:
            print(x['id'])
        print(result)


finally:
    connection.close()
