# -*- coding:utf-8 -*-
import os
import unittest
import HTMLTestRunner
from units import jdlogin

suit = unittest.TestSuite()

suit.addTest(unittest.makeSuite(jdlogin.Login))

fileName = os.getcwd()+"/jingDong.html"
fo = open(fileName,"wb")

runner = HTMLTestRunner.HTMLTestRunner(stream=fo,title=u"京东登陆",description=u"登陆测试用例")
runner.run(suit)
