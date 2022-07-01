package com.qq.e.comm.plugin.n;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ac.f;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.util.GDTLogger;

public class k extends RelativeLayout {
  public k(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public k(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  private void b() {
    GDTLogger.d("LoadingView init");
    setLayerType(1, null);
    setBackgroundColor(-16777216);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    layoutParams1.addRule(13);
    setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    String str2 = GDTADManager.getInstance().getSM().getString("endcardLoadingUrl");
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = "http://qzs.qq.com/union/res/union_cdn/page/images/loading_2x.gif"; 
    f f = new f(getContext(), str1);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(128, 128);
    layoutParams2.addRule(13);
    f.setId(2131755010);
    addView((View)f, (ViewGroup.LayoutParams)layoutParams2);
    TextView textView = new TextView(getContext());
    textView.setId(2131755011);
    layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(3, 2131755010);
    layoutParams2.addRule(14);
    layoutParams2.topMargin = am.a(getContext(), 16);
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    textView.setText("正在加载游戏");
    textView.setTextColor(-1);
    textView.setTextSize(20.0F);
    addView((View)textView);
    textView = new TextView(getContext());
    textView.setId(2131755012);
    layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(3, 2131755011);
    layoutParams2.addRule(14);
    layoutParams2.topMargin = am.a(getContext(), 8);
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    textView.setText("即将开启试玩");
    textView.setTextColor(-1);
    textView.setTextSize(16.0F);
    addView((View)textView);
    setVisibility(8);
  }
  
  public void a() {
    GDTLogger.d("LoadingView dismiss");
    clearAnimation();
    setVisibility(8);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\n\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */