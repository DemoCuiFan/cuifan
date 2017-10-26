# -*- coding:utf-8 -*-
import os
import json
class JsonData(object):

    # def readJSON(self):
    def __init__(self):
        # D:\\lxztest1026\\units/jsondata.json'
        fileName = os.path.dirname(os.getcwd())+"/login/model/jsondata.json"
        fo = open(fileName,"rb")
        self.jsons = json.load(fo)

    def getUsername(self):
        return self.jsons[1]["username"]
    def getPassWord(self):
        return self.jsons[1]["password"]