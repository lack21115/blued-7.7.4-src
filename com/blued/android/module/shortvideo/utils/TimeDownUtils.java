package com.blued.android.module.shortvideo.utils;

import android.os.Handler;
import android.widget.TextView;

public class TimeDownUtils {
  Handler a = new Handler();
  
  Runnable b = new Runnable(this) {
      public void run() {
        TimeDownUtils.a(this.a);
        TextView textView = TimeDownUtils.c(this.a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TimeDownUtils.b(this.a));
        stringBuilder.append("");
        textView.setText(stringBuilder.toString());
        if (TimeDownUtils.b(this.a) == 0) {
          TimeDownUtils.a(this.a, 3);
          this.a.a.removeCallbacks(this.a.b);
          if (TimeDownUtils.d(this.a) != null) {
            TimeDownUtils.d(this.a).v();
            return;
          } 
        } else {
          this.a.a.postDelayed(this, 1000L);
        } 
      }
    };
  
  private int c = 3;
  
  private TextView d;
  
  private ITimeDownCallBack e;
  
  public TimeDownUtils(TextView paramTextView, int paramInt, ITimeDownCallBack paramITimeDownCallBack) {
    this.d = paramTextView;
    this.c = paramInt;
    this.e = paramITimeDownCallBack;
  }
  
  public void a() {
    TextView textView = this.d;
    if (textView != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.c);
      stringBuilder.append("");
      textView.setText(stringBuilder.toString());
    } 
    Handler handler = this.a;
    if (handler != null)
      handler.postDelayed(this.b, 1000L); 
  }
  
  public void b() {
    Handler handler = this.a;
    if (handler != null)
      handler.removeCallbacks(this.b); 
    this.c = 3;
  }
  
  public static interface ITimeDownCallBack {
    void v();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvide\\utils\TimeDownUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */