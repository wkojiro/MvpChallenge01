package jp.techacademy.wakabayashi.kojiro.mvpchallenge01;

import android.widget.Toast;

/**
 * Created by wkojiro on 2017/05/26.
 */

public class DivinationManager implements IDivinationManager {


    public static interface DivinationDelegate{
        void completeDivination(String result);
        
    }


    public void get(DivinationDelegate delegate){
        delegate.completeDivination("result");
    }


}
