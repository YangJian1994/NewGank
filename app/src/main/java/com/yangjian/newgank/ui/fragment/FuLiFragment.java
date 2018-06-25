package com.yangjian.newgank.ui.fragment;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.yangjian.newgank.R;
import com.yangjian.newgank.bean.Gank;
import com.yangjian.newgank.widget.recyclerview.base.ViewHolder;

/**
 * Created by Yang on 2018/6/22.
 * Function：
 */

public class FuLiFragment extends BaseListFragment<Gank> {

    @Override
    public int getItemLayout() {
        return R.layout.item_fuli;
    }

    @Override
    public void fillValue(ViewHolder holder, Gank gank, int position) {
        ImageView mImage = holder.getView(R.id.image);
        Picasso.with(getContext()).load(gank.getUrl()).placeholder(R.mipmap.avatar).into(mImage);
    }

    @Override
    protected String getUrl() {
        return "http://gank.io/api/data/福利/" + String.valueOf(pageSize) + "/" + String.valueOf(page);
    }
}
