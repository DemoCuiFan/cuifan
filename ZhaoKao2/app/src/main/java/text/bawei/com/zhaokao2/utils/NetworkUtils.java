package text.bawei.com.zhaokao2.utils;

import android.os.Handler;
import android.os.Message;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 1.类的用途:
 * 2.@author:崔帆
 * 3.@date:2017/4/15.
 */

public class NetworkUtils {
    private Handler handler;
    private String mUrl;
    private int type;

    public NetworkUtils(Handler handler, String mUrl, int type) {
        this.handler = handler;
        this.mUrl = mUrl;
        this.type = type;
    }

    public void execNet(){
        new Thread(){
            @Override
            public void run() {
                String s = DoGet(mUrl);
                Message message = new Message();
                message.obj = s;
                message.what = type;
                handler.sendMessage(message);
            }
        }.start();
    }
    public String DoGet(String url) {
        HttpURLConnection conn = null;
        StringBuffer result = null;
        try {
            URL mUrl = new URL(url);
            conn = (HttpURLConnection) mUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("encoding","UTF-8"); //可以指定编码
            conn.setConnectTimeout(5000);
            if (conn.getResponseCode() == 200) {
                result = new StringBuffer();
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = "";
                while( (line =br.readLine()) != null ){
                    result.append(line);
                }
            } else {
                System.out.println("请求失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return result.toString();
    }
}
