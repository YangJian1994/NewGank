package com.yangjian.newgank.theme;

import android.content.res.Resources;
import android.view.View;

/**
 * Created by Yang on 2018/6/22.
 * Function：换肤接口
 */

public interface ColorUiInterface {

    View getView();

    void setTheme(Resources.Theme themeId);
}
