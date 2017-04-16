package text.bawei.com.zhaokao2.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.List;

import text.bawei.com.zhaokao2.R;
import text.bawei.com.zhaokao2.adapter.MyAdapter;
import text.bawei.com.zhaokao2.bean.Bean;
import text.bawei.com.zhaokao2.bean.Beans;
import text.bawei.com.zhaokao2.utils.GsonUtils;
import text.bawei.com.zhaokao2.utils.NetworkUtils;
import text.bawei.com.zhaokao2.utils.UrlUtils;

public class MainActivity extends AppCompatActivity {
    private SlidingMenu slidingMenu;
    private ImageView main_click;
    private ListView main_list;
    private TextView main_texts;
    private ListView left_list;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    String str = (String) msg.obj;
                    Bean bean1 = GsonUtils.changeChar(str);
                    List<Bean.DataBean> data = bean1.getData();
                    MyAdapter myAdapter = new MyAdapter(data, MainActivity.this);
                    main_list.setAdapter(myAdapter);
                    main_texts.setText("全部药品");
                    break;
                case 2:
                    String str1 = (String) msg.obj;
                    Bean bean2 = GsonUtils.changeChar(str1);
                    List<Bean.DataBean> data1 = bean2.getData();
                    MyAdapter myAdapter1 = new MyAdapter(data1, MainActivity.this);
                    main_list.setAdapter(myAdapter1);
                    main_texts.setText("西药");
                    break;
                case 3:
                    String str2 = (String) msg.obj;
                    Bean bean3 = GsonUtils.changeChar(str2);
                    List<Bean.DataBean> data2 = bean3.getData();
                    MyAdapter myAdapter2 = new MyAdapter(data2, MainActivity.this);
                    main_list.setAdapter(myAdapter2);
                    main_texts.setText("中药");
                    break;
                case 4:
                    String strs = (String) msg.obj;
                    Gson gson = new Gson();
                    Beans beans = gson.fromJson(strs, Beans.class);
                    List<Beans.DataBean> data3 = beans.getData();
                    left_list.setAdapter(new ArrayAdapter<Beans.DataBean>(MainActivity.this,android.R.layout.simple_list_item_1,data3));
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initView() {
        leftView();
        main_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (slidingMenu.isSecondaryMenuShowing()) {
                    slidingMenu.showContent();
                } else {
                    slidingMenu.showSecondaryMenu();
                }
            }
        });
        new NetworkUtils(handler, UrlUtils.URLPATH1, 1).execNet();
        new NetworkUtils(handler, UrlUtils.URLPATH, 4).execNet();

    }

    private void initData() {
        main_click = (ImageView) findViewById(R.id.main_click);
        main_list = (ListView) findViewById(R.id.main_list);
        main_texts = (TextView) findViewById(R.id.main_texts);
    }

    private void leftView() {
        slidingMenu = new SlidingMenu(this);
        //从左边滑出
        slidingMenu.setMode(SlidingMenu.LEFT);
        int widthPixels = this.getResources().getDisplayMetrics().widthPixels;
        slidingMenu.setBehindOffset(widthPixels / 3 * 1);
        slidingMenu.attachToActivity(MainActivity.this, SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setMenu(R.layout.leftmenu);
        left_list = (ListView) slidingMenu.findViewById(R.id.left_list);
        left_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    if (!slidingMenu.isSecondaryMenuShowing()) {
                        slidingMenu.showContent();
                    }
                    new NetworkUtils(handler, UrlUtils.URLPATH1, 1).execNet();
                }else if(position==1){
                    if (!slidingMenu.isSecondaryMenuShowing()) {
                        slidingMenu.showContent();
                    }
                    new NetworkUtils(handler, UrlUtils.URLPATH1, 2).execNet();
                }else if(position==2){
                    if (!slidingMenu.isSecondaryMenuShowing()) {
                        slidingMenu.showContent();
                    }
                    new NetworkUtils(handler, UrlUtils.URLPATH1, 3).execNet();
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (!slidingMenu.isSecondaryMenuShowing()) {
            slidingMenu.showContent();
        }
        return true;
    }
}

