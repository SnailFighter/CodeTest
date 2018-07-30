import pymysql.cursors
from Log import Log

# Connect to the database


def get_sql_conn():
    connection = pymysql.connect(host='47.107.23.206',
                                 port=3308,
                                 user='root',
                                 password='opmysql',
                                 db='resources',
                                 charset='utf8',
                                 cursorclass=pymysql.cursors.DictCursor)
    return connection


def execute_sql(pack_code):
    try:
        list=[]
        connection = get_sql_conn()
        with connection.cursor() as cursor:
            # Read a single record
            sql = "select log.id,check_orgin,log.status,dlog.* from resources.check_package_log log ," \
                  "check_package_detail_log dlog where log.id=dlog.package_log_id " \
                  " and dlog.pack_code=%s order by log.id desc limit 35"

            cursor.execute(sql, pack_code)
            # 返回的是list，list里面是dict数据
            if cursor.rowcount==0:
                list.append("找不到对应数据！")
                return list
            result = cursor.fetchmany(cursor.rowcount)
            for x in result:
                log = Log(x['id'], 1, x['reason'])
                log_str = 'ID：'+str(x['id'])+'  捆包号:'
                if x['pack_code'] is not None:
                    log_str = log_str + x['pack_code']
                else:
                    log_str = log_str+" /  "
                log_str =  log_str+"  业务操作: " + '验盾' + '  结果：' + '急速购' + ' 备注：'
                if x['reason'] is not None:
                    log_str = log_str + x['reason']
                else:
                    log_str = log_str+" / "
                list.append(log_str)
            return list


    finally:
        connection.close()








