import pymysql.cursors
import datetime

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
            sql = "select log.id,log.start_time as time,check_orgin,log.status,dlog.status as shield,dlog.reason, " \
                  "dlog.pack_code from resources.check_package_log log ," \
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
                log_str = log_str+"  业务操作: " + '验盾' + ' 时间：'

                if x['time'] is not None:
                    log_str = log_str + x['time'].strftime('%Y-%m-%d %X')
                else:
                    log_str = log_str+" /    "

                if x['shield'] is not None:
                    if x['shield'] == 10:
                        log_str = log_str + '  结果：极速购'
                    if x['shield'] == 20:
                        log_str = log_str + '  结果：放心购'
                    if x['shield'] == 30:
                        log_str = log_str + '  结果：耐心购'
                    if x['shield'] == 50:
                        log_str = log_str + '  结果：线下购'
                else:
                    log_str = log_str + '  结果：/   '
                if x['reason'] is not None:
                    log_str = log_str + ' 备注：' + x['reason']
                else:
                    log_str = log_str+" / "
                list.append(log_str)
            return list


    finally:
        connection.close()








