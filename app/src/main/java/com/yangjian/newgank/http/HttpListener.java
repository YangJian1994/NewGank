package com.yangjian.newgank.http;

/**
 * Created by Yang on 2018/6/22.
 * Function：
 */

public interface HttpListener {
    void onSuccess(Object result);

    void onFailure(int errorType, String message);
}
