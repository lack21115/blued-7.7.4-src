package com.sina.weibo.sdk.register.mobile;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sina.weibo.sdk.utils.ResourceManager;

public class SelectCountryItemView extends RelativeLayout {
  private TextView mCountryCode;
  
  private TextView mCountryName;
  
  public SelectCountryItemView(Context paramContext, String paramString1, String paramString2) {
    super(paramContext);
    initView(paramString1, paramString2);
  }
  
  private void initView(String paramString1, String paramString2) {
    setLayoutParams((ViewGroup.LayoutParams)new AbsListView.LayoutParams(-1, ResourceManager.dp2px(getContext(), 40)));
    this.mCountryName = new TextView(getContext());
    this.mCountryName.setTextSize(16.0F);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.leftMargin = ResourceManager.dp2px(getContext(), 15);
    layoutParams.addRule(9);
    layoutParams.addRule(15);
    this.mCountryName.setGravity(16);
    this.mCountryName.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.mCountryName.setText(paramString1);
    this.mCountryName.setTextColor(-13421773);
    addView((View)this.mCountryName);
    this.mCountryCode = new TextView(getContext());
    this.mCountryCode.setTextSize(16.0F);
    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.addRule(15);
    layoutParams.addRule(11);
    layoutParams.rightMargin = ResourceManager.dp2px(getContext(), 40);
    this.mCountryCode.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.mCountryCode.setText(paramString2);
    this.mCountryCode.setTextColor(-11502161);
    this.mCountryCode.setGravity(16);
    addView((View)this.mCountryCode);
    setContent(paramString1, paramString2);
  }
  
  private void setContent(String paramString1, String paramString2) {
    this.mCountryName.setText(paramString1);
    this.mCountryCode.setText(paramString2);
  }
  
  public void updateContent(String paramString1, String paramString2) {
    setContent(paramString1, paramString2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\register\mobile\SelectCountryItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */