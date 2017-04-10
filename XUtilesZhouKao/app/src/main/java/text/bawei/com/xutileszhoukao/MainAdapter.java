package text.bawei.com.xutileszhoukao;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 类的用途：
 * 时间:  2017/4/10  19:12
 * 姓名:  李照照
 */
public class MainAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragments;
    private String[] titles = {"头条", "社会", "国内","国际","娱乐","体育","军事","科技","音乐","热点"};

    public MainAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }


    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments != null ? fragments.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
