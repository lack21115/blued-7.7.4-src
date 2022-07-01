package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

public class AuthProgressBar extends View {
  Paint a;
  
  Paint b;
  
  long c = 100L;
  
  long d = 0L;
  
  Handler e = new Handler();
  
  Runnable f = new Runnable(this) {
      public void run() {
        long l = System.currentTimeMillis() - AuthProgressBar.a(this.a);
        if (l <= 5000L) {
          AuthProgressBar.a(this.a, l / 50L);
          this.a.e.postDelayed(this, 10L);
          return;
        } 
        this.a.e.removeCallbacks(this.a.f);
      }
    };
  
  private long g = 0L;
  
  public AuthProgressBar(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public AuthProgressBar(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AuthProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void c() {
    this.a = new Paint(1);
    this.a.setColor(-7829368);
    this.b = new Paint(1);
    this.b.setColor(-16776961);
  }
  
  private void setProgress(long paramLong) {
    this.d = paramLong;
    invalidate();
  }
  
  public void a() {
    Handler handler = this.e;
    if (handler != null) {
      handler.removeCallbacks(this.f);
      this.g = System.currentTimeMillis();
      this.e.postDelayed(this.f, 10L);
    } 
  }
  
  public void b() {
    Handler handler = this.e;
    if (handler != null)
      handler.removeCallbacks(this.f); 
  }
  
  protected void onDraw(Canvas paramCanvas) {
    int i = getWidth();
    int j = getHeight();
    float f2 = (float)this.d;
    float f1 = i;
    int k = (int)(f2 * f1 / (float)this.c / 2.0F);
    f2 = k;
    float f3 = j;
    paramCanvas.drawRect(0.0F, 0.0F, f2, f3, this.a);
    float f4 = (i - k);
    paramCanvas.drawRect(f4, 0.0F, f1, f3, this.a);
    paramCanvas.drawRect(f2, 0.0F, f4, f3, this.b);
  }
  
  public void setMaxProgress(long paramLong) {
    this.c = paramLong;
    invalidate();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\AuthProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */