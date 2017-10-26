# -*- coding:utf-8 -*-
from utils import utils,urlutils
from login.model import jsondatas
class LoginControl(object):


    def __init__(self):
        self.driver = utils.Utils()
        self.urlUtils = urlutils.UrlUtils()
        self.json = jsondatas.JsonData()

    def max_windows(self):
        self.driver.max_Windows()



    def startDriver(self):
        self.driver.startFirefox(self.urlUtils.loginUrl)  # 打开浏览器

    def zhlogin(self):
        self.driver.findCLASS("login-tab-r").click()
        #点击‘账户登陆’

    def startLogin(self):

        self.startDriver()
        #打开浏览器
        self.max_windows()
        self.zhlogin()
        #点击‘账户登陆’

        self.driver.findID("loginname").send_keys(self.json.getUsername())
        #通过ID查找 用户名输入框    输入数据
        self.driver.findID("nloginpwd").send_keys(self.json.getPassWord())
        #通过ID查找 密码输入框    输入数据
        self.tiemSleep()
        self.tiemSleep()
        self.loginClick()

        pass

    #点击‘关于我们’
    def click_gywm(self,self1,a):
        self.startDriver()
        self.max_windows()
        # 获取当前Windows
        curr = self.driver.getCurrWindows()
        self.driver.findLink(u"关于我们").click()
        # 休眠5秒
        self.tiemSleep()
        # 获取所有Windows
        alls = self.driver.getAllWindows()

        for index in alls:
            if curr!=index:
                # 切换到最新的窗口
                self.driver.windowQieHuan(index)


        self.assertEQ(self1,a,self.getTitle())


    def nullLogin(self):
        # 打开浏览器
        self.startDriver()
        self.max_windows()
        # 点击账户登陆
        self.zhlogin()
        # 点击登录
        self.loginClick()


    def loginClick(self):
        # 点击登陆按钮
        self.driver.findID("loginsubmit").click()


    def tiemSleep(self):
        # 休眠5 秒
        self.driver.timeSleep(5)

    def cloneDirver(self):
        # 关闭浏览器
        self.driver.cloneDriver()

    def assertEQ(self,self1,a,b):
        self1.assertEqual(a,b)

    def getTitle(self):
        self.tiemSleep()
        aa = self.driver.getTitle()
        print aa

        return aa
    pass