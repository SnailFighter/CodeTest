import pymysql.cursors

# Connect to the database
connection = pymysql.connect(host='47.107.23.206',
                             port=3308,
                             user='root',
                             password='opmysql',
                             db='resources',
                             charset='utf8',
                             cursorclass=pymysql.cursors.DictCursor)

try:
    with connection.cursor() as cursor:
        # Read a single record
        sql = "select * from check_package_detail_log limit 30"
        cursor.execute(sql)
        result = cursor.fetchmany(10)
        print(result)
finally:
    connection.close()