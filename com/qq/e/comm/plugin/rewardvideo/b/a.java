package com.qq.e.comm.plugin.rewardvideo.b;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.ar;

public class a extends AlertDialog {
  private TextView a;
  
  private TextView b;
  
  public a(Context paramContext) {
    super(paramContext);
  }
  
  public LinearLayout a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    LinearLayout linearLayout2 = new LinearLayout(paramContext);
    linearLayout2.setOrientation(1);
    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, am.a(paramContext, 137));
    linearLayout2.setBackgroundDrawable((Drawable)ar.a(am.a(paramContext, 10), -1, 255));
    linearLayout2.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    TextView textView2 = new TextView(paramContext);
    textView2.setText(paramString1);
    textView2.setTextColor(-16777216);
    textView2.setTextSize(16.0F);
    textView2.setGravity(17);
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
    layoutParams2.bottomMargin = am.a(paramContext, 40);
    layoutParams2.topMargin = am.a(paramContext, 40);
    layoutParams2.rightMargin = am.a(paramContext, 20);
    layoutParams2.leftMargin = am.a(paramContext, 20);
    linearLayout2.addView((View)textView2, (ViewGroup.LayoutParams)layoutParams2);
    TextView textView1 = new TextView(paramContext);
    textView1.setBackgroundColor(Color.parseColor("#ececec"));
    linearLayout2.addView((View)textView1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, am.a(paramContext, 1)));
    LinearLayout linearLayout1 = new LinearLayout(paramContext);
    linearLayout1.setOrientation(0);
    linearLayout2.addView((View)linearLayout1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, am.a(paramContext, 44)));
    if (!TextUtils.isEmpty(paramString3)) {
      this.b = new TextView(paramContext);
      this.b.setText(paramString3);
      this.b.setTextSize(16.0F);
      this.b.setTextColor(-16777216);
      this.b.setGravity(17);
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, am.a(paramContext, 44));
      layoutParams.weight = 1.0F;
      linearLayout1.addView((View)this.b, (ViewGroup.LayoutParams)layoutParams);
      TextView textView = new TextView(paramContext);
      textView.setBackgroundColor(Color.parseColor("#ececec"));
      linearLayout1.addView((View)textView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(am.a(paramContext, 1), -1));
    } 
    this.a = new TextView(paramContext);
    this.a.setText(paramString2);
    this.a.setTextSize(16.0F);
    this.a.setTextColor(Color.parseColor("#3185FC"));
    this.a.setGravity(17);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(0, am.a(paramContext, 44));
    layoutParams1.weight = 1.0F;
    linearLayout1.addView((View)this.a, (ViewGroup.LayoutParams)layoutParams1);
    return linearLayout2;
  }
  
  public TextView a() {
    return this.b;
  }
  
  public TextView b() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\rewardvideo\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */