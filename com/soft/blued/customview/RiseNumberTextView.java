package com.soft.blued.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.soft.blued.utils.StringUtils;
import java.text.DecimalFormat;

public class RiseNumberTextView extends TextView {
  static final int[] a = new int[] { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };
  
  private int b = 0;
  
  private float c;
  
  private float d;
  
  private float e;
  
  private long f = 1500L;
  
  private int g = 2;
  
  private DecimalFormat h = new DecimalFormat("##0.00");
  
  private EndListener i = null;
  
  public RiseNumberTextView(Context paramContext) {
    super(paramContext);
  }
  
  public RiseNumberTextView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public RiseNumberTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void c() {
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { this.d, this.c });
    valueAnimator.setDuration(this.f);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            RiseNumberTextView.a(this.a, Float.valueOf(param1ValueAnimator.getAnimatedValue().toString()).floatValue());
            RiseNumberTextView riseNumberTextView = this.a;
            riseNumberTextView.setText(RiseNumberTextView.a(riseNumberTextView).format(Float.parseFloat(param1ValueAnimator.getAnimatedValue().toString())));
            if (param1ValueAnimator.getAnimatedFraction() >= 1.0F) {
              RiseNumberTextView.a(this.a, 0);
              if (RiseNumberTextView.b(this.a) != null)
                RiseNumberTextView.b(this.a).a(); 
            } 
          }
        });
    valueAnimator.start();
  }
  
  private void d() {
    ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[] { (int)this.d, (int)this.c });
    valueAnimator.setDuration(this.f);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            RiseNumberTextView.a(this.a, Float.valueOf(param1ValueAnimator.getAnimatedValue().toString()).floatValue());
            this.a.setText(StringUtils.a(param1ValueAnimator.getAnimatedValue().toString()));
            if (param1ValueAnimator.getAnimatedFraction() >= 1.0F) {
              RiseNumberTextView.a(this.a, 0);
              if (RiseNumberTextView.b(this.a) != null)
                RiseNumberTextView.b(this.a).a(); 
            } 
          }
        });
    valueAnimator.start();
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.g = 2;
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.c = paramInt1;
    this.d = paramInt2;
    this.g = 1;
  }
  
  public boolean a() {
    return (this.b == 1);
  }
  
  public void b() {
    if (!a()) {
      this.b = 1;
      if (this.g == 1) {
        d();
        return;
      } 
      c();
    } 
  }
  
  public float getNowNumber() {
    return this.e;
  }
  
  public void setDecimals(String paramString) {
    this.h = new DecimalFormat(paramString);
  }
  
  public void setDuration(long paramLong) {
    this.f = paramLong;
  }
  
  public void setOnEndListener(EndListener paramEndListener) {
    this.i = paramEndListener;
  }
  
  public void setText(float paramFloat) {
    setText(this.h.format(paramFloat));
  }
  
  public static interface EndListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\RiseNumberTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */