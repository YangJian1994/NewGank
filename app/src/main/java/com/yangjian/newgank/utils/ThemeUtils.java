package com.yangjian.newgank.utils;

import android.content.Context;
import android.content.res.TypedArray;

/**
 * Created by Yang on 2018/6/22.
 * Function：
 */

public class ThemeUtils {

    public static int getThemeColor(Context context, int attrRes) {
        TypedArray typedArray = context.obtainStyledAttributes(new int[]{attrRes});
        int color = typedArray.getColor(0, 0xffffff);
        typedArray.recycle();
        return color;
    }

}
