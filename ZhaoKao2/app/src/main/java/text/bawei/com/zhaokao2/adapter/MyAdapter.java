package text.bawei.com.zhaokao2.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import text.bawei.com.zhaokao2.R;
import text.bawei.com.zhaokao2.bean.Bean;

/**
 * 1.类的用途:
 * 2.@author:崔帆
 * 3.@date:2017/4/15.
 */

public class MyAdapter extends BaseAdapter {
    private List<Bean.DataBean> list;
    private Context context;

    public MyAdapter(List<Bean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.list_item,null);
            vh = new ViewHolder();
            vh.text1  = (TextView) convertView.findViewById(R.id.item_text1);
            vh.text2  = (TextView) convertView.findViewById(R.id.item_text2);
            vh.text3  = (TextView) convertView.findViewById(R.id.item_text3);

            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }

        vh.text1.setText(list.get(position).getTitle());
        vh.text2.setText(list.get(position).getApply());
        vh.text3.setText(list.get(position).getOld_price()+"元");
        return convertView;
    }

    class ViewHolder {
        TextView text1;
        TextView text2;
        TextView text3;

    }
}
