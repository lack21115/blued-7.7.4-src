package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;

public class LivePKProgressView extends FrameLayout {
  private Context a;
  
  private LayoutInflater b;
  
  private ViewGroup c;
  
  private ProgressBar d;
  
  private TextView e;
  
  private TextView f;
  
  private int g;
  
  private int h;
  
  private boolean i = false;
  
  private ImageView j;
  
  private int k;
  
  public LivePKProgressView(Context paramContext) {
    this(paramContext, null);
  }
  
  public LivePKProgressView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LivePKProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    c();
  }
  
  private void c() {
    this.b = LayoutInflater.from(this.a);
    this.b.inflate(R.layout.live_pk_progress_view, (ViewGroup)this);
    this.c = (ViewGroup)findViewById(R.id.content_layout);
    this.d = (ProgressBar)findViewById(R.id.live_pk_progress_view);
    this.e = (TextView)findViewById(R.id.live_pk_our_progress);
    this.f = (TextView)findViewById(R.id.live_pk_other_progress);
    this.j = (ImageView)findViewById(R.id.live_pk_progress_anim);
    this.k = AppInfo.l - DensityUtils.a(this.a, 38.0F);
  }
  
  private void setAnimMargin(int paramInt) {
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.j.getLayoutParams();
    float f = paramInt / 100.0F;
    int i = DensityUtils.a(this.a, 15.0F);
    layoutParams.leftMargin = (int)(this.k * f) + DensityUtils.a(this.a, 16.0F) - i / 2;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" progress:");
    stringBuilder.append(paramInt);
    stringBuilder.append("  pkIconwidth:");
    stringBuilder.append(i);
    stringBuilder.append("  mProgressWidth: ");
    stringBuilder.append(this.k);
    stringBuilder.append("  margin:");
    stringBuilder.append(layoutParams.leftMargin);
    Log.i("==opop", stringBuilder.toString());
    this.j.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  private void setProgress(int paramInt) {
    this.d.setProgress(paramInt);
    setAnimMargin(paramInt);
  }
  
  public void a() {
    this.i = true;
    ProgressBar progressBar = this.d;
    if (progressBar != null)
      progressBar.clearAnimation(); 
  }
  
  public void b() {
    setProgress(50);
    this.g = 0;
    this.h = 0;
    this.e.setText(String.format(this.a.getString(R.string.live_pk_my_result), new Object[] { "0" }));
    this.f.setText(String.format(this.a.getString(R.string.live_pk_your_result), new Object[] { "0" }));
  }
  
  public void setOtherProgress(int paramInt) {
    if (paramInt > this.h) {
      int i = this.g;
      if (i == 0) {
        setProgress(0);
      } else {
        setProgress((int)(i / (i + paramInt) * 100.0F));
      } 
      this.h = paramInt;
      TextView textView = this.f;
      String str = this.a.getString(R.string.live_pk_your_result);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append("");
      textView.setText(String.format(str, new Object[] { stringBuilder.toString() }));
    } 
  }
  
  public void setOurProgress(int paramInt) {
    if (paramInt > this.g) {
      int i = this.h;
      if (i == 0) {
        setProgress(100);
      } else {
        setProgress((int)(paramInt / (i + paramInt) * 100.0F));
      } 
      this.g = paramInt;
      TextView textView = this.e;
      String str = this.a.getString(R.string.live_pk_my_result);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt);
      stringBuilder.append("");
      textView.setText(String.format(str, new Object[] { stringBuilder.toString() }));
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LivePKProgressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */