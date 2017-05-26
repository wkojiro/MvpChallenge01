package jp.techacademy.wakabayashi.kojiro.mvpchallenge01;

import android.app.Application;

import io.realm.Realm;
/**
 * Created by wkojiro on 2017/05/26.
 */

public class MvpTask extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        Realm.init(this);
    }

}
