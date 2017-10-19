package com.wktx.app.ztecoordinatorlayout;

import android.graphics.Color;

import com.wktx.app.ztecoordinatorlayout.utils.AppUtils;
import com.wktx.app.ztecoordinatorlayout.utils.FileUtils;

/**
 * Created by wktx on 2017/10/19.
 */

public class Constant {
    public static String PATH_DATA = FileUtils.createRootPath(AppUtils.getAppContext()) + "/cache";

    public static String PATH_TXT = PATH_DATA + "/book/";
    public static String PATH_EPUB = PATH_DATA + "/epub";

    public static final String SUFFIX_TXT = ".txt";
    public static final String SUFFIX_PDF = ".pdf";
    public static final String SUFFIX_EPUB = ".epub";
    public static final String SUFFIX_ZIP = ".zip";
    public static final String SUFFIX_CHM = ".chm";

    public static final String ISNIGHT = "isNight";

    public static final int[] tagColors = new int[]{
            Color.parseColor("#90C5F0"),
            Color.parseColor("#91CED5"),
            Color.parseColor("#F88F55"),
            Color.parseColor("#C0AFD0"),
            Color.parseColor("#E78F8F"),
            Color.parseColor("#67CCB7"),
            Color.parseColor("#F6BC7E")
    };
}
