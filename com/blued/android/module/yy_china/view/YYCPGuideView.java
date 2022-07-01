package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;

public class YYCPGuideView extends LinearLayout {
  private TextView a;
  
  private TextView b;
  
  private TextView c;
  
  private TextView d;
  
  private TextView e;
  
  public YYCPGuideView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYCPGuideView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYCPGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private String a(int paramInt) {
    return getResources().getString(paramInt);
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_cp_guide, (ViewGroup)this, true);
    this.a = (TextView)findViewById(R.id.tv_blind_introduction);
    this.b = (TextView)findViewById(R.id.tv_blind_heart);
    this.c = (TextView)findViewById(R.id.tv_blind_publish);
    this.d = (TextView)findViewById(R.id.tv_blind_result);
    this.e = (TextView)findViewById(R.id.tv_blind_bulletin);
  }
  
  private void b() {
    int i;
    TextView textView = this.a;
    if (YYRoomInfoManager.d().m()) {
      i = R.string.blind_introduction_host;
    } else {
      i = R.string.blind_introduction_other;
    } 
    textView.setText(a(i));
    textView = this.b;
    if (YYRoomInfoManager.d().m()) {
      i = R.string.blind_heart_host;
    } else {
      i = R.string.blind_heart_other;
    } 
    textView.setText(a(i));
    textView = this.c;
    if (YYRoomInfoManager.d().m()) {
      i = R.string.blind_publish_host;
    } else {
      i = R.string.blind_publish_other;
    } 
    textView.setText(a(i));
    textView = this.d;
    if (YYRoomInfoManager.d().m()) {
      i = R.string.blind_result_host;
    } else {
      i = R.string.blind_result_other;
    } 
    textView.setText(a(i));
    textView = this.e;
    if (YYRoomInfoManager.d().m()) {
      i = R.string.blind_bulletin_host;
    } else {
      i = R.string.blind_bulletin_other;
    } 
    textView.setText(i);
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYCPGuideView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */