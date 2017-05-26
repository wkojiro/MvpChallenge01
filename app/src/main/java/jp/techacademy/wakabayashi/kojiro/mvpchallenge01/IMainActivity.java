package jp.techacademy.wakabayashi.kojiro.mvpchallenge01;

/**
 * Created by wkojiro on 2017/05/26.
 */

public interface IMainActivity {

    void showProgress();
    void dismissProgress();
    void setResultText(String result);
    void settoast();
}
