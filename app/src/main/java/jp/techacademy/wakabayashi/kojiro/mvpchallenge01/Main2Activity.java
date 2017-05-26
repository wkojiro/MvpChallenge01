package jp.techacademy.wakabayashi.kojiro.mvpchallenge01;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import jp.techacademy.wakabayashi.kojiro.mvpchallenge01.tasks.TaskActivity;

public class Main2Activity extends AppCompatActivity implements IMainActivity, View.OnClickListener{

    private MainPresenter mMainpresenter;
    private Button mButton,mTaskButton;
    private TextView mTextView;
    private ProgressDialog mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mMainpresenter = new MainPresenter();
        mMainpresenter.setView(this);

        mTextView = (TextView) findViewById(R.id.textView);
        mButton = (Button) findViewById(R.id.button3);
        mTaskButton = (Button) findViewById(R.id.button4);

        mButton.setOnClickListener(this);
        mTaskButton.setOnClickListener(this);

        mProgress = new ProgressDialog(this);


    }

    @Override
    public void onClick(View v){

        switch (v.getId()) {
            case R.id.button3:
                mMainpresenter.startDivination();
                break;
            case R.id.button4:

                Intent intent = new Intent(this, TaskActivity.class);
                startActivity(intent);
                break;
        }
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

    @Override
    public void settoast(){

        Toast.makeText(getApplicationContext(),"test",Toast.LENGTH_SHORT).show();

    }

}
