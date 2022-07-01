package com.sina.weibo.sdk.component.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sina.weibo.sdk.utils.ResourceManager;

public class AppProgressDialog extends Dialog {
  private TextView info;
  
  private ProgressBar myBar;
  
  public AppProgressDialog(Context paramContext) {
    super(paramContext);
    setCanceledOnTouchOutside(false);
    LinearLayout linearLayout = new LinearLayout(paramContext);
    linearLayout.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(ResourceManager.dp2px(paramContext, 100), ResourceManager.dp2px(paramContext, 100)));
    linearLayout.setOrientation(0);
    linearLayout.setGravity(17);
    linearLayout.setBackgroundColor(-1);
    this.myBar = new ProgressBar(paramContext);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
    int i = ResourceManager.dp2px(paramContext, 20);
    layoutParams.bottomMargin = i;
    layoutParams.topMargin = i;
    layoutParams.leftMargin = i;
    this.myBar.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    linearLayout.addView((View)this.myBar);
    this.info = new TextView(paramContext);
    setTitle("提示");
    this.info.setTextSize(2, 17.0F);
    this.info.setText("正在处理...");
    this.info.setTextColor(-11382190);
    this.info.setGravity(16);
    layoutParams = new LinearLayout.LayoutParams(-2, -2);
    layoutParams.leftMargin = ResourceManager.dp2px(paramContext, 20);
    layoutParams.rightMargin = ResourceManager.dp2px(paramContext, 20);
    this.info.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    linearLayout.addView((View)this.info);
    setContentView((View)linearLayout);
  }
  
  public void setMessage(String paramString) {
    this.info.setText(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\component\view\AppProgressDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */