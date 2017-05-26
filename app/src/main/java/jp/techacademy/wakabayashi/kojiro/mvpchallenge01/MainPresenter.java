package jp.techacademy.wakabayashi.kojiro.mvpchallenge01;

import android.widget.ImageView;

/**
 * Created by wkojiro on 2017/05/26.
 */

public class MainPresenter {

    private IMainActivity mView;
    private IDivinationManager mDivinationManager;

    public MainPresenter(){
        mDivinationManager = new DivinationManager();

    }
    public void setView(IMainActivity view){
        mView = view;
    }

    public void startDivination(){
        mView.showProgress();
        mDivinationManager.get(new DivinationDelegate(){
            @Override
            public void completeDivination(String result){
                mView.setResultText(result);
                mView.dismissProgress();
            }

        });
    }

}
