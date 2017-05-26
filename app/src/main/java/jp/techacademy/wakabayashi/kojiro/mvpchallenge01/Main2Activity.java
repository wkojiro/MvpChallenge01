package jp.techacademy.wakabayashi.kojiro.mvpchallenge01;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements IMainActivity, View.OnClickListener{

    private MainPresenter mMainpresenter;
    private Button mButton;
    private TextView mTextView;
    private ProgressDialog mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mMainpresenter = new MainPresenter();
        mMainpresenter.setView(this);

        mTextView = (TextView) findViewById(R.id.textview);
        mButton = (Button) findViewById(R.id.button3);
        mButton.setOnClickListener(this);

        mProgress = new ProgressDialog(this);


    }

    @Override
    public void onClick(View v){
        mMainpresenter.startDivination();
    }

    @Override
    public void showProgress() {


        mProgress.show();

    }

    @Override
    public void dismissProgress() {

        mProgress.dismiss();

    }

    @Override
    public void setResultText(String result){

        mTextView.setText(result);
    }

}
