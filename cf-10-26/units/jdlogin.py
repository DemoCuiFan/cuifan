# -*- coding:utf-8 -*-
import unittest
from login import logins

class Login(unittest.TestCase):
    @classmethod
    def setUpClass(self):
        self.login = logins.LoginControl()

        pass

    def setUp(self):

        pass


    def test_1_us_null_pa_null(self):
        u'''直接点击登录'''
        self.login.nullLogin()

    def test_2_us_pa_ture(self):
        u'''输入正确的用户名，密码，点击登录'''
        self.login.startLogin()
        self.login.assertEQ(self,u"京东(JD.COM)-正品低价、品质保障、配送及时、轻松购物！",self.login.getTitle())
        pass

    def test_4_gywm(self):
         u'''点击关于我们'''
         self.login.click_gywm(self,u"企业简介-京东商城")

    def tearDown(self):
        self.login.cloneDirver()


        pass

