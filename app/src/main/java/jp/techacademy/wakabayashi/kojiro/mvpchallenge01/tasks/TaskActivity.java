package jp.techacademy.wakabayashi.kojiro.mvpchallenge01.tasks;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

import jp.techacademy.wakabayashi.kojiro.mvpchallenge01.R;
import jp.techacademy.wakabayashi.kojiro.mvpchallenge01.addedittask.AddEditTaskActivity;
import jp.techacademy.wakabayashi.kojiro.mvpchallenge01.data.Task;


public class TaskActivity extends AppCompatActivity {

    /* Realm 関連　*/
    private Realm mRealm;
    private RealmResults<Task> mTaskRealmResults;
    private RealmChangeListener mRealmListener = new RealmChangeListener() {
        @Override
        public void onChange(Object element) {
            reloadListView();
        }
    };


    private ListView mListView;
    private TaskAdapter mTaskAdapter;
    private FloatingActionButton fab;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

    fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TaskActivity.this, AddEditTaskActivity.class);
                startActivity(intent);


            }
        });

    mRealm = Realm.getDefaultInstance();
    mTaskRealmResults = mRealm.where(Task.class).findAll();
    mRealm.addChangeListener(mRealmListener);


        // ListViewの設定
    mTaskAdapter = new TaskAdapter(this);
    mListView = (ListView) findViewById(R.id.listView1);


    if (mTaskRealmResults.size() == 0) {
            // アプリ起動時にタスクの数が0であった場合は表示テスト用のタスクを作成する
            addTaskForTest();
    }
    reloadListView();



    }


    private void reloadListView() {


        Log.d("リロード","リロード");
        //ArrayList<Task> taskArrayList = new ArrayList<>();

        // 後でTaskクラスに変更する

        ArrayList<String> taskArrayList = new ArrayList<>();
        taskArrayList.add("aaa");
        taskArrayList.add("bbb");
        taskArrayList.add("ccc");

/*
        for (int i = 0; i < mTaskRealmResults.size(); i++) {
            if (!mTaskRealmResults.get(i).isValid()) continue;

            Task task = new Task();

            task.setId(mTaskRealmResults.get(i).getId());
            task.setTitle(mTaskRealmResults.get(i).getTitle());
            task.setDescription(mTaskRealmResults.get(i).getmDescription());

            taskArrayList.add(task);
        }

        mTaskAdapter.setTaskArrayList(taskArrayList);
        mListView.setAdapter(mTaskAdapter);
        mTaskAdapter.notifyDataSetChanged();

*/

    }

    private void addTaskForTest() {
        Task task = new Task();
        task.setTitle("作業");
        task.setDescription("プログラムを書いてPUSHする");
        task.setId(0);
        mRealm.beginTransaction();
        mRealm.copyToRealmOrUpdate(task);
        mRealm.commitTransaction();
    }

}
