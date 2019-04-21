package com.example.admin.day03_zuoye_one.base;

import android.os.Environment;

import java.io.File;

/**
 * Created by admin on 2019/4/2.
 */

public interface Constants {
    boolean isDebug = true;

    public static final String IT_ZHIHU_DETAIL_ID = "zhihu_detail_id";
    public static final String IT_ZHIHU_DETAIL_TRANSITION = "zhihu_detail_transition";

    String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() +
            File.separator + "codeest" + File.separator + "GeekNews";

    String FILE_PROVIDER_AUTHORITY="com.baidu.geek.fileprovider";

    //网络缓存的地址
    String PATH_DATA = BaseApp.getInstance().getCacheDir().getAbsolutePath() +
            File.separator + "data";

    String PATH_CACHE = PATH_DATA + "/NetCache";
    String DATA = "data";
    //夜间模式
    String MODE = "mode";
    String NIGHT_CURRENT_FRAG_POS = "fragment_pos";
}
