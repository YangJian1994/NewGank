package com.yangjian.newgank.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;
import com.squareup.picasso.Picasso;
import com.yangjian.newgank.R;
import com.yangjian.newgank.bean.Gank;
import com.yangjian.newgank.event.SkinChangeEvent;
import com.yangjian.newgank.utils.DimenUtils;
import com.yangjian.newgank.utils.ThemeUtils;
import com.yangjian.newgank.widget.recyclerview.base.ViewHolder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by Yang on 2018/6/22.
 * Function：
 */

public class AllFragment extends BaseListFragment<Gank> {

    private String type = "all";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_common;
    }

    @Override
    public void fillValue(ViewHolder holder, Gank gank, int position) {
        ImageView mImage = holder.getView(R.id.image);
        TextView mText = holder.getView(R.id.text);
        if (gank.getType().equals("福利")) {
            mImage.setVisibility(View.VISIBLE);
            mText.setVisibility(View.GONE);
            Picasso.with(getContext()).load(gank.getUrl()).placeholder(R.mipmap.avatar).into(mImage);
        } else {
            mImage.setVisibility(View.GONE);
            mText.setVisibility(View.VISIBLE);
            mText.setLinkTextColor(ThemeUtils.getThemeColor(getActivity(),R.attr.colorPrimary));
            mText.setText(Html.fromHtml("<a href=\""
                    + gank.getUrl() + "\">"
                    + gank.getDesc() + "</a>"
                    + "[" + gank.getWho() + "]"));
            mText.setMovementMethod(LinkMovementMethod.getInstance());
            switch (gank.getType()) {
                case "Android":
                    setIconDrawable(mText, MaterialDesignIconic.Icon.gmi_android);
                    break;
                case "iOS":
                    setIconDrawable(mText, MaterialDesignIconic.Icon.gmi_apple);
                    break;
                case "休息视频":
                    setIconDrawable(mText, MaterialDesignIconic.Icon.gmi_collection_video);
                    break;
                case "前端":
                    setIconDrawable(mText, MaterialDesignIconic.Icon.gmi_language_javascript);
                    break;
                case "拓展资源":
                    setIconDrawable(mText, FontAwesome.Icon.faw_location_arrow);
                    break;
                case "App":
                    setIconDrawable(mText, MaterialDesignIconic.Icon.gmi_apps);
                    break;
                case "瞎推荐":
                    setIconDrawable(mText, MaterialDesignIconic.Icon.gmi_more);
                    break;

            }
        }
    }

    private void setIconDrawable(TextView view, IIcon icon) {
        view.setCompoundDrawablesWithIntrinsicBounds(new IconicsDrawable(getActivity())
                        .icon(icon)
                        .color(ThemeUtils.getThemeColor(getActivity(), R.attr.colorPrimary))
                        .sizeDp(14),
                null, null, null);
        view.setCompoundDrawablePadding(DimenUtils.dp2px(getActivity(), 5));
    }

    @Override
    protected String getUrl() {
        return "http://gank.io/api/data/" + type + "/"
                + String.valueOf(pageSize) + "/"
                + String.valueOf(page);
    }

    @Subscribe
    public void onEvent(SkinChangeEvent event){
        headerAndFooterWrapper.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
