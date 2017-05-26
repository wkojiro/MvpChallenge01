package jp.techacademy.wakabayashi.kojiro.mvpchallenge01.addedittask;



/**
 * Created by wkojiro on 2017/05/26.
 */

public interface AddEditTaskContract {

    void showProgress();
    void dismissProgress();
    void setTitle(String title);
    void setDescription(String description);


    interface Presenter {
        void saveTask(String title, String description);
    }



}
