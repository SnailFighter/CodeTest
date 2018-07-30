#!/usr/bin/python
# -*- coding: utf-8 -*-

# 日志详细信息


class Log(object):
    def __init__(self, data_id, pack_code, origin=1, reason=''):
        self.data_id = data_id
        self.pack_code = pack_code
        self.origin = origin
        self.reason = reason

