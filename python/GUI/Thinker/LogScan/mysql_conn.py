import pymysql.cursors

# Connect to the database
# 全局变量
list = []


def get_sql_conn():
    connection = pymysql.connect(host='xx.xx.xx.xx',
                                 port=3306,
                                 user='root',
                                 password='mysql',
                                 db='resources',
                                 charset='utf8',
                                 cursorclass=pymysql.cursors.DictCursor)
    return connection


def execute_sql(pack_code, type):
    try:
        print('------------'+str(type))

        list=[]
        arr = pack_code.replace('，'  ,  ',').strip().replace(' ' , '').split(',')
        params = ''
        for code in arr:
            code = code.strip()
            params += ",'"+code+"'"
        params.strip(',')
        print(params)

        request_type = []
        if type == 0:
            request_type = [1, 2, 6]
        if type == 1:
            request_type = [4, 7]
        if type == 2:
            request_type = [5]





        connection = get_sql_conn()
        with connection.cursor() as cursor:
            # Read a single record

            sql = "select olog.id ,package_log_id,package_code, shield,r.reason,package_type, provider_name," \
                  "olog.end_time as time," \
                  " agency,business_type,resource_from ,olog.status, olog.reason as lreason ,buyer_name from " \
                  "(select package_log_id,package_code,status as shield,reason,package_type, provider_name, agency," \
                  "business_type,resource_from from	check_package_detail_log clog where id in " \
                  "( select max(dlog.id) as id from check_package_detail_log dlog join check_package_log log " \
                  "on dlog.package_log_id=log.id where 	log.check_orgin in %s  and dlog.package_code" \
                  " in   %s  group by dlog.package_code )) r " \
                  "join check_package_log olog on r.package_log_id=olog.id "

            # 参考 https://stackoverflow.com/questions/39334484/pymysql-select-in-with-variable-number-of-parameters
            cursor.execute(sql, [request_type, arr])
            #cursor.executemany(sql, arr)  //这个方法只会返回最后一条记录
            # 返回的是list，list里面是dict数据
            if cursor.rowcount==0:
                list.append("找不到对应数据！")
                return list
            result = cursor.fetchmany(cursor.rowcount)
            return log_marge(result, type)
    finally:
        connection.close()


def log_marge(log_dict, type):
    list = []
    if log_dict is None or type is None:
        return
    # 验盾
    if type == 0:
        for x in log_dict:
            log_str = 'ID：' + str(x['id']) + '  捆包号:'

            if x['package_code'] is not None:
                log_str = log_str + x['package_code']
            else:
                log_str = log_str + "  无记录  "

            if x['business_type'] is not None:
                if x['business_type'] == 10:
                    log_str = log_str + ' 自营  '
                if x['business_type'] == 20:
                    log_str = log_str + ' 集采分销  '
                if x['business_type'] == 30:
                    log_str = log_str + ' 寄售  '
            else:
                log_str = log_str + ' 业务类型丢失    '

            if x['agency'] is not None:
                if x['agency'] == 0:
                    log_str = log_str + '非代挂  '
                if x['agency'] == 1:
                    log_str = log_str + '代挂  '
            else:
                log_str = log_str + ' 缺少是否代挂信息  '

            if x['resource_from'] is not None:
                if x['resource_from'] == 10:
                    log_str = log_str + '公共资源区  '
                if x['resource_from'] == 20:
                    log_str = log_str + '定向资源区  '
                if x['resource_from'] == 30:
                    log_str = log_str + '竞价资源区  '
            else:
                log_str = log_str + ' 资源区信息丢失 '

            log_str = log_str + ' 时间：'
            if x['time'] is not None:
                log_str = log_str + x['time'].strftime('%Y-%m-%d %X')
            else:
                log_str = log_str + " 无记录   "

            if x['shield'] is not None:
                if x['shield'] == 10:
                    log_str = log_str + '  结果：极速购 '
                if x['shield'] == 20:
                    log_str = log_str + '  结果：放心购 '
                if x['shield'] == 30:
                    log_str = log_str + '  结果：耐心购 '
                if x['shield'] == 50:
                    log_str = log_str + '  结果：线下购 '
            else:
                log_str = log_str + '  结果：无记录    '

            if x['reason'] is not None:
                log_str = log_str + ' 备注：' + x['reason']
            else:
                log_str = log_str + " 备注： 无记录 "
            list.append(log_str)
        return list
    # 解锁，锁货
    if type == 1:
        for x in log_dict:
            log_str = 'ID：' + str(x['id']) + '  捆包号:'
            if x['package_code'] is not None:
                log_str = log_str + x['package_code']
            else:
                log_str = log_str + "  无记录  "

            log_str = log_str + ' 时间：'
            if x['time'] is not None:
                log_str = log_str + x['time'].strftime('%Y-%m-%d %X')
            else:
                log_str = log_str + " 无记录    "

            log_str = log_str + ' 结果：'
            if x['status'] is None:
                log_str = log_str + ' 未知 '
            elif x['status'] == 0:
                log_str = log_str + ' 失败 '
            elif x['status'] == 1:
                log_str = log_str + ' 成功 '
            else:
                log_str = log_str + ' 未知 '

            log_str = log_str + ' 备注：'
            if x['lreason'] is None:
                log_str = log_str + ' 未知 '
            else:
                log_str = log_str + x['lreason']
            list.append(log_str)
        return list
    # 过户
    if type == 2:
        for x in log_dict:
            log_str = 'ID：' + str(x['id']) + '  捆包号:'
            if x['package_code'] is not None:
                log_str = log_str + x['package_code']
            else:
                log_str = log_str + "  无记录  "

            log_str = log_str + ' 时间：'
            if x['time'] is not None:
                log_str = log_str + x['time'].strftime('%Y-%m-%d %X')
            else:
                log_str = log_str + " 无记录    "

            log_str = log_str + ' 卖家：'
            if x['provider_name'] is None:
                log_str = log_str + " 无记录 "
            else:
                log_str = log_str + x['provider_name']

            log_str = log_str + ' 买家：'
            if x['buyer_name'] is None:
                log_str = log_str + " 无记录 "
            else:
                log_str = log_str + x['buyer_name']

            log_str = log_str + '  结果(欧冶除外)：'
            if x['status'] is None:
                log_str = log_str + ' 未知 '
            elif x['status'] == 0:
                log_str = log_str + ' 失败 '
            elif x['status'] == 1:
                log_str = log_str + ' 成功 '
            else:
                log_str = log_str + ' 未知 '

            log_str = log_str + ' 备注：'
            if x['lreason'] is None:
                log_str = log_str + ' 未知 '
            else:
                log_str = log_str + x['lreason']
            list.append(log_str)
        return list












