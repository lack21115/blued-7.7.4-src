package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.utils.ResourceManager;

public class SelectCountryTitleView extends RelativeLayout {
  private TextView mTitleTv;
  
  public SelectCountryTitleView(Context paramContext) {
    super(paramContext);
    initView();
  }
  
  private void initView() {
    setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-1, ResourceManager.dp2px(getContext(), 24)));
    setBackgroundDrawable(ResourceManager.getDrawable(getContext(), "tableview_sectionheader_background.png"));
    this.mTitleTv = new TextView(getContext());
    this.mTitleTv.setTextSize(14.0F);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.addRule(15);
    layoutParams.leftMargin = ResourceManager.dp2px(getContext(), 10);
    this.mTitleTv.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.mTitleTv.setGravity(3);
    this.mTitleTv.setTextColor(-7171438);
    this.mTitleTv.setGravity(16);
    addView((View)this.mTitleTv);
  }
  
  public void setTitle(String paramString) {
    this.mTitleTv.setText(paramString);
  }
  
  public void update(String paramString) {
    setTitle(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\register\mobile\SelectCountryTitleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */