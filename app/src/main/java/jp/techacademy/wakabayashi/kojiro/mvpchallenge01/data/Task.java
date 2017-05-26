package jp.techacademy.wakabayashi.kojiro.mvpchallenge01.data;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by wkojiro on 2017/05/26.
 */

public class Task extends RealmObject implements Serializable{


    @PrimaryKey
    private int mId;
    private String mTitle;
    private String mDescription;




    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getTitle(){
        return mTitle;
    }

    public void setTitle(String title){
        this.mTitle = title;
    }

    public String getmDescription(){
        return  mDescription;
    }

    public void setDescription(String description){
        this.mDescription = description;
    }

}
