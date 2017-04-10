package text.bawei.com.xutileszhoukao;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tablayout;
    private ViewPager vp;
    private MainAdapter mainAdapter;
    private List<Fragment> fragments = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getData();
    }

    private void getData() {
        mainAdapter = new MainAdapter(getSupportFragmentManager());
        fragments.add(MyFragment.newInstance(Url.url01));
        fragments.add(MyFragment.newInstance(Url.url02));
        fragments.add(MyFragment.newInstance(Url.url03));
        fragments.add(MyFragment.newInstance(Url.url04));
        fragments.add(MyFragment.newInstance(Url.url05));
        fragments.add(MyFragment.newInstance(Url.url06));
        fragments.add(MyFragment.newInstance(Url.url07));
        fragments.add(MyFragment.newInstance(Url.url08));
        fragments.add(MyFragment.newInstance(Url.url09));
        fragments.add(MyFragment.newInstance(Url.url010));
        mainAdapter.setFragments(fragments);
        vp.setAdapter(mainAdapter);
        //设置tabLayout
        tablayout.setupWithViewPager(vp);
        tablayout.setTabsFromPagerAdapter(mainAdapter);
        //设置文字的颜色
        tablayout.setTabTextColors(Color.GRAY, Color.RED);

    }

    private void initView() {
        tablayout = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);


    }
}
