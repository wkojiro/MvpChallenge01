package jp.techacademy.wakabayashi.kojiro.mvpchallenge01.addedittask;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import jp.techacademy.wakabayashi.kojiro.mvpchallenge01.R;



public class AddEditTaskActivity extends AppCompatActivity implements AddEditTaskContract , View.OnClickListener{

    private Button mSubmitButton;
    private EditText mTitleEdit, mDescriptionEdit;
    private ProgressDialog mProgress;
    private AddEditTaskPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_task);

        mPresenter = new AddEditTaskPresenter();
        mPresenter.setView(this);

        mProgress = new ProgressDialog(this);
        mSubmitButton = (Button) findViewById(R.id.done_button);

        mTitleEdit = (EditText) findViewById(R.id.title_edit_text);
        mDescriptionEdit = (EditText) findViewById(R.id.content_edit_text);

        mSubmitButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v){
        String title = mTitleEdit.getText().toString();
        String description = mDescriptionEdit.getText().toString();
        mPresenter.saveTask(title, description);
        finish();
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
    public void setTitle(String title) {

    }

    @Override
    public void setDescription(String description) {

    }

}
