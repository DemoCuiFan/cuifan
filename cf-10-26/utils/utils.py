# -*- coding:utf-8 -*-
from selenium import webdriver
import time
class Utils(object):


    def startFirefox(self,url):
        self.driver = webdriver.Firefox()
        self.driver.get(url)
        pass

    def findID(self,id):
        return self.driver.find_element_by_id(id)

    def findCLASS(self,classes):
        return self.driver.find_element_by_class_name(classes)

    def cloneDriver(self):
        self.driver.close()

    def timeSleep(self,num):
        time.sleep(num)

    def assertEQ(self,self1,a,b):
        self1.assertEqual(a,b)

    def max_Windows(self):
        self.driver.maximize_window()

    def getTitle(self):
        return self.driver.title

    def findLink(self,link):
        return self.driver.find_element_by_link_text(link)

    def getCurrWindows(self):
        #获取当前Windows
        return self.driver.current_window_handle

    def getAllWindows(self):
        #获取所有Windows
        return self.driver.window_handles

    def windowQieHuan(self,windows):
        #切换Windows
        self.driver.switch_to_window(windows)

    pass