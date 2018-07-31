package com.chokus.konye.mvptutorial;

import android.content.Context;
import android.widget.Toast;

public class util {
    static Toast mToast;
    public static String baseURL = "put in base url of API here";

    public static void showToast(Context context, String statusMsg){
        if(mToast != null) mToast.cancel();
        mToast = Toast.makeText(context,statusMsg, Toast.LENGTH_SHORT);
        mToast.show();
    }
}
