package text.bawei.com.xutileszhoukao;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * 类的用途：
 * 时间:  2017/4/10  18:51
 * 姓名:  李照照
 */
public class MyFragment extends Fragment{
    private List<Bean.ResultBean.DataBean> list;
    private ListView listView;
    private Handler handler = new Handler() {


        private List<Bean.ResultBean.DataBean> list;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                String str = (String) msg.obj;

                Gson gson = new Gson();
                Bean bean = gson.fromJson(str, Bean.class);

                list = bean.getResult().getData();

                 Myadapter myadapter = new Myadapter(getActivity(), list);
                listView.setAdapter(myadapter);
            }
        }
    };
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item, null);
        listView = (ListView) view.findViewById(R.id.listview);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String name = bundle.get("name").toString();
         //   new Https(Url.url01,handler).getadd();
            Log.d("MyFragment", name);
            getData(name);
        }


        return view;
    }

    private void getData(String s) {
        RequestParams params = new RequestParams(s);
       /* params.addQueryStringParameter("username","abc");
        params.addQueryStringParameter("password","123");*/
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Message mess=Message.obtain();
                mess.what=1;
                mess.obj=result;
                handler.sendMessage(mess);
                //解析result
            }
            //请求异常后的回调方法
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }
            //主动调用取消请求的回调方法
            @Override
            public void onCancelled(CancelledException cex) {
            }
            @Override
            public void onFinished() {
            }
        });
    }

    public static MyFragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString("name", name);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
