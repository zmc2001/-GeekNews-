package com.example.admin.day03_zuoye_one.util;

import android.util.Log;

import com.example.admin.day03_zuoye_one.base.Constants;

/**
 * Created by admin on 2019/4/2.
 */

public class Logger {
    public static void logD(String tag,String msg){
        if (Constants.isDebug){
            Log.i("tag", "logD: "+msg);
        }
    }
}
