package jp.techacademy.wakabayashi.kojiro.mvpchallenge01.tasks;

import jp.techacademy.wakabayashi.kojiro.mvpchallenge01.addedittask.AddEditTaskContract;

/**
 * Created by wkojiro on 2017/05/26.
 */

public class TaskPresenter implements TaskListConstact {

    public TaskListConstact mView;
    public void setView(TaskListConstact view){
        mView = view;
    }




    @Override
    public void showProgress() {

    }

    @Override
    public void dismissProgress() {

    }

    @Override
    public void showAddEditTask() {

    }

    @Override
    public void reloadTask() {

    }
}
