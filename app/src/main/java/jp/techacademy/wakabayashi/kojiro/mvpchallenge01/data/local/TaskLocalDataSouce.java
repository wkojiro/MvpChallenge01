package jp.techacademy.wakabayashi.kojiro.mvpchallenge01.data.local;

/**
 * Created by wkojiro on 2017/05/26.
 */

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmResults;
import jp.techacademy.wakabayashi.kojiro.mvpchallenge01.addedittask.AddEditTaskActivity;
import jp.techacademy.wakabayashi.kojiro.mvpchallenge01.data.Task;

public class TaskLocalDataSouce {

    private Task mTask;
    private String title;
    private String description;

    public void addTask(String title,String description){

        Log.d("debug","addtask");

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        mTask = new Task();

        RealmResults<Task> taskRealmResults = realm.where(Task.class).findAll();

        int identifier;
        if (taskRealmResults.max("id") != null) {
            identifier = taskRealmResults.max("id").intValue() + 1;
        } else {
            identifier = 0;
        }
        mTask.setId(identifier);
        mTask.setTitle(title);
        mTask.setDescription(description);

        realm.copyToRealmOrUpdate(mTask);
        realm.commitTransaction();

        realm.close();

    }


    static void setTask(Context context,String title, String description){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putString(TaskContract.TITLEKEY,title)
                .putString(TaskContract.DESCRIPTIONKEY,description)
                .apply();
    }

    static void removeTask(Context context){



    }


}
