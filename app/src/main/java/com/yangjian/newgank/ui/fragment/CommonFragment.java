package com.yangjian.newgank.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.yangjian.newgank.R;
import com.yangjian.newgank.bean.Gank;
import com.yangjian.newgank.widget.recyclerview.base.ViewHolder;

/**
 * Created by Yang on 2018/6/22.
 * Function：
 */

public class CommonFragment extends BaseListFragment<Gank> {

    public static final String ARG_TYPE = "type";

    private String type;

    public static CommonFragment newInstance(String type) {

        Bundle args = new Bundle();

        CommonFragment fragment = new CommonFragment();
        args.putString(ARG_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            type = getArguments().getString(ARG_TYPE);
        }
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_common;
    }

    @Override
    public void fillValue(ViewHolder holder, Gank gank, int position) {
        TextView text = holder.getView(R.id.text);
        text.setText(Html.fromHtml("<a href=\""
                + gank.getUrl() + "\">"
                + gank.getDesc() + "</a>"
                + "[" + gank.getWho() + "]"));
        text.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    protected String getUrl() {
        return "http://gank.io/api/data/" + type + "/"
                + String.valueOf(pageSize) + "/"
                + String.valueOf(page);
    }
}
