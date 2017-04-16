package text.bawei.com.zhaokao2.utils;

import com.google.gson.Gson;

import text.bawei.com.zhaokao2.bean.Bean;


/**
 * 1.类的用途:
 * 2.@author:崔帆
 * 3.@date:2017/4/15.
 */

public class GsonUtils {
    public static Bean changeChar(String str){
        Gson gson = new Gson();
        Bean bean1 = gson.fromJson(str, Bean.class);
        return bean1;
    }
}
