package jp.techacademy.wakabayashi.kojiro.mvpchallenge01.addedittask;

import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import jp.techacademy.wakabayashi.kojiro.mvpchallenge01.data.local.TaskLocalDataSouce;


/**
 * Created by wkojiro on 2017/05/26.
 */

public class AddEditTaskPresenter {

    private AddEditTaskContract mView;
    private TaskLocalDataSouce mTasksRepository;
    public AddEditTaskPresenter(){
        mTasksRepository = new TaskLocalDataSouce();
    }


    public void setView(AddEditTaskContract view){
        mView = view;
    }


    public void saveTask(String title , String description) {

        Toast.makeText((Context) mView,"ddd"+title+description,Toast.LENGTH_SHORT).show();

        mView.showProgress();
        mTasksRepository.addTask(title,description);

        mView.dismissProgress();

    }
}
