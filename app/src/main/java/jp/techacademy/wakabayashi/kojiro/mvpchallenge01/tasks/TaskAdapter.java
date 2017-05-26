package jp.techacademy.wakabayashi.kojiro.mvpchallenge01.tasks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


import jp.techacademy.wakabayashi.kojiro.mvpchallenge01.data.Task;

/**
 * Created by wkojiro on 2017/05/26.
 */

public class TaskAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater; //他のxmlリソースのViewを取り扱うための仕組みであるLayoutInflaterをメンバ変数として定義しておき、コンストラクタを新規に追加して取得しておきます。
    private ArrayList<Task> mTaskArrayList;

    public TaskAdapter(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //ActivityクラスのgetSystemServiceメソッドとはシステムレベルのサービスを取得するためのメソッドです。本レッスンではレイアウトのためのサービスとアラームのためのサービスを取得するのに使います。
    }
    public void setTaskArrayList(ArrayList<Task> taskArrayList) {
        mTaskArrayList = taskArrayList;
    }
    @Override
    public int getCount() {
        return mTaskArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mTaskArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(android.R.layout.simple_list_item_2, null); //simple_list_item_2はタイトルとサブタイトルがあるセルです。
        }

        TextView textView1 = (TextView) convertView.findViewById(android.R.id.text1);
        TextView textView2 = (TextView) convertView.findViewById(android.R.id.text2);

        // 後でTaskクラスから情報を取得するように変更する
        textView1.setText(mTaskArrayList.get(position).getTitle());



        return convertView;
    }
}
