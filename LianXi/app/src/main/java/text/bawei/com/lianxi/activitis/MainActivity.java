package text.bawei.com.lianxi.activitis;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import text.bawei.com.lianxi.R;
import text.bawei.com.lianxi.asyncTask.MyAsyncTask;


public class MainActivity extends AppCompatActivity {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        MyAsyncTask myAsyncTask = new MyAsyncTask(MainActivity.this, listView);
        myAsyncTask.execute("http://result.eolinker.com/hs8Lfqd8722a248fff2322d8013fac7521a90448d88fb4e?uri=hunhyt");
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.main_listview);
    }

}
