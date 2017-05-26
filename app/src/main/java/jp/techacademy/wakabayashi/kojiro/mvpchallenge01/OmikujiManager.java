package jp.techacademy.wakabayashi.kojiro.mvpchallenge01;

/**
 * Created by wkojiro on 2017/05/26.
 */

public class OmikujiManager {


    public static interface OmikujiDelegate{
        void completeDivination(String result);

    }

    public void getOmikuji(OmikujiDelegate s){

        s.completeDivination("Uma");
      //  String result = "uma";
       // return result;
    }

}
