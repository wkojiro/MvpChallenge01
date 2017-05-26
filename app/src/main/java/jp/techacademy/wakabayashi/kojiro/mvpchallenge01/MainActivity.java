package jp.techacademy.wakabayashi.kojiro.mvpchallenge01;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private OmikujiManager mOmikujiManager;
    private Button mButton,mButton2;
    private TextView mTextView;
    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textview);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);

        mButton2 = (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(this);

        mProgress = new ProgressDialog(this);
        mOmikujiManager = new OmikujiManager();

    }

    @Override
    public void onClick(View v){

        switch (v.getId()) {
            case R.id.button:
                mProgress.show();

                mOmikujiManager.getOmikuji(new OmikujiManager.OmikujiDelegate() {
                    @Override
                    public void completeDivination(String result) {
                        mTextView.setText(result);
                        mProgress.dismiss();
                    }
                });
                break;
            case R.id.button2:

                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                break;

        }
    }
}
