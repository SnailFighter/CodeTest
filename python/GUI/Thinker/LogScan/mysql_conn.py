import pymysql.cursors
import datetime

from Log import Log

# Connect to the database


def get_sql_conn():
    connection = pymysql.connect(host='xx.xx.xx.xx',
                                 port=3308,
                                 user='root',
                                 password='mysql',
                                 db='resources',
                                 charset='utf8',
                                 cursorclass=pymysql.cursors.DictCursor)
    return connection


def execute_sql(pack_code):
    try:
        list=[]
        arr = pack_code.replace('，'  ,  ',').strip().replace(' ' , '').split(',')
        params = ''
        for code in arr:
            code = code.strip()
            params += ",'"+code+"'"
        params.strip(',')
        print(params)

        connection = get_sql_conn()
        with connection.cursor() as cursor:
            # Read a single record
            sql = "select log.start_time as time,check_orgin, did,shield,t.reason,package_log_id as id," \
                  "pack_code,business_type,resource_from,agency from ( " \
                  "select max(dlog.id) as did,dlog.status as shield,dlog.reason, dlog.package_log_id, " \
                  "dlog.pack_code,dlog.business_type,dlog.agency,dlog.resource_from  " \
                  " from resources.check_package_log log ,check_package_detail_log dlog " \
                  " where log.id=dlog.package_log_id and dlog.pack_code in  %s  group by pack_code " \
                  " ) t ,check_package_log log where t.package_log_id = log.id"
            # 参考 https://stackoverflow.com/questions/39334484/pymysql-select-in-with-variable-number-of-parameters
            cursor.execute(sql, [arr])
            #cursor.executemany(sql, arr)  //这个方法只会返回最后一条记录
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

                if x['business_type'] is not None:
                    if x['business_type'] == 10:
                        log_str = log_str + ' 自营  '
                    if x['business_type'] == 20:
                        log_str = log_str + ' 集采分销  '
                    if x['business_type'] == 30:
                        log_str = log_str + ' 寄售  '
                else:
                    log_str = log_str + '业务类型丢失    '

                if x['agency'] is not None:
                    if x['agency'] == 0:
                        log_str = log_str + '非代挂  '
                    if x['agency'] == 1:
                        log_str = log_str + '代挂  '
                else:
                    log_str = log_str + '缺少是否代挂信息    '

                if x['resource_from'] is not None:
                    if x['resource_from'] == 10:
                        log_str = log_str + '公共资源区  '
                    if x['resource_from'] == 20:
                        log_str = log_str + '定向资源区  '
                    if x['resource_from'] == 30:
                        log_str = log_str + '竞价资源区  '
                else:
                    log_str = log_str + '资源区信息丢失 '

                log_str = log_str + ' 时间：'
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








