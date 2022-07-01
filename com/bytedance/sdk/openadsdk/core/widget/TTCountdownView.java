package com.bytedance.sdk.openadsdk.core.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class TTCountdownView extends View {
  private boolean A = false;
  
  private int a = Color.parseColor("#fce8b6");
  
  private int b = Color.parseColor("#f0f0f0");
  
  private int c = Color.parseColor("#ffffff");
  
  private int d = Color.parseColor("#7c7c7c");
  
  private float e = 2.0F;
  
  private float f = 12.0F;
  
  private float g = 18.0F;
  
  private int h = 270;
  
  private boolean i = false;
  
  private float j = 5.0F;
  
  private float k = 5.0F;
  
  private float l = 0.8F;
  
  private String m = "跳过";
  
  private boolean n = false;
  
  private Paint o;
  
  private Paint p;
  
  private Paint q;
  
  private Paint r;
  
  private float s = 1.0F;
  
  private float t = 1.0F;
  
  private RectF u;
  
  private a v;
  
  private AnimatorSet w;
  
  private ValueAnimator x;
  
  private ValueAnimator y;
  
  private ValueAnimator z;
  
  public TTCountdownView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public TTCountdownView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TTCountdownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.e = a(2.0F);
    this.g = a(18.0F);
    this.f = b(12.0F);
    this.h %= 360;
    c();
    d();
  }
  
  private float a(float paramFloat) {
    return TypedValue.applyDimension(1, paramFloat, getResources().getDisplayMetrics());
  }
  
  private void a(Canvas paramCanvas) {
    String str1;
    paramCanvas.save();
    Paint.FontMetrics fontMetrics = this.r.getFontMetrics();
    if (this.n) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append((int)Math.ceil(a(this.t, this.k)));
      str1 = stringBuilder.toString();
    } else {
      str1 = this.m;
    } 
    String str2 = str1;
    if (TextUtils.isEmpty(str1))
      str2 = "跳过"; 
    paramCanvas.drawText(str2, 0.0F, 0.0F - (fontMetrics.ascent + fontMetrics.descent) / 2.0F, this.r);
    paramCanvas.restore();
  }
  
  private float b(float paramFloat) {
    return TypedValue.applyDimension(2, paramFloat, getResources().getDisplayMetrics());
  }
  
  private void b(Canvas paramCanvas) {
    float f1;
    paramCanvas.save();
    float f2 = a(this.s, 360);
    if (this.i) {
      f1 = this.h - f2;
    } else {
      f1 = this.h;
    } 
    paramCanvas.drawCircle(0.0F, 0.0F, this.g, this.p);
    paramCanvas.drawCircle(0.0F, 0.0F, this.g, this.q);
    paramCanvas.drawArc(this.u, f1, f2, false, this.o);
    paramCanvas.restore();
  }
  
  private void c() {
    this.o = new Paint(1);
    this.o.setColor(this.a);
    this.o.setStrokeWidth(this.e);
    this.o.setAntiAlias(true);
    this.o.setStyle(Paint.Style.STROKE);
    this.p = new Paint(1);
    this.p.setColor(this.c);
    this.p.setAntiAlias(true);
    this.p.setStrokeWidth(this.e);
    this.p.setStyle(Paint.Style.FILL);
    this.q = new Paint(1);
    this.q.setColor(this.b);
    this.q.setAntiAlias(true);
    this.q.setStrokeWidth(this.e / 2.0F);
    this.q.setStyle(Paint.Style.STROKE);
    this.r = new Paint(1);
    this.r.setColor(this.d);
    this.q.setAntiAlias(true);
    this.r.setTextSize(this.f);
    this.r.setTextAlign(Paint.Align.CENTER);
  }
  
  private void d() {
    float f = this.g;
    this.u = new RectF(-f, -f, f, f);
  }
  
  private int e() {
    return (int)((this.e / 2.0F + this.g) * 2.0F + a(4.0F));
  }
  
  private ValueAnimator getArcAnim() {
    ValueAnimator valueAnimator = this.y;
    if (valueAnimator != null) {
      valueAnimator.cancel();
      this.y = null;
    } 
    this.y = ValueAnimator.ofFloat(new float[] { this.s, 0.0F });
    this.y.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.y.setDuration((long)(a(this.s, this.j) * 1000.0F));
    this.y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            TTCountdownView.b(this.a, ((Float)param1ValueAnimator.getAnimatedValue()).floatValue());
            this.a.postInvalidate();
          }
        });
    return this.y;
  }
  
  private ValueAnimator getNumAnim() {
    ValueAnimator valueAnimator = this.x;
    if (valueAnimator != null) {
      valueAnimator.cancel();
      this.x = null;
    } 
    this.x = ValueAnimator.ofFloat(new float[] { this.t, 0.0F });
    this.x.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.x.setDuration((long)(a(this.t, this.k) * 1000.0F));
    this.x.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            TTCountdownView.a(this.a, ((Float)param1ValueAnimator.getAnimatedValue()).floatValue());
            this.a.postInvalidate();
          }
        });
    return this.x;
  }
  
  public float a(float paramFloat1, float paramFloat2) {
    return paramFloat1 * paramFloat2;
  }
  
  public float a(float paramFloat, int paramInt) {
    return paramInt * paramFloat;
  }
  
  public void a() {
    AnimatorSet animatorSet = this.w;
    if (animatorSet != null && animatorSet.isRunning()) {
      this.w.cancel();
      this.w = null;
    } 
    this.w = new AnimatorSet();
    this.w.playTogether(new Animator[] { (Animator)getNumAnim(), (Animator)getArcAnim() });
    this.w.setInterpolator((TimeInterpolator)new LinearInterpolator());
    this.w.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationCancel(Animator param1Animator) {
            TTCountdownView.a(this.a, true);
          }
          
          public void onAnimationEnd(Animator param1Animator) {
            if (TTCountdownView.a(this.a)) {
              TTCountdownView.a(this.a, false);
              return;
            } 
            if (TTCountdownView.b(this.a) != null)
              TTCountdownView.b(this.a).b(); 
          }
          
          public void onAnimationStart(Animator param1Animator) {
            if (TTCountdownView.b(this.a) != null)
              TTCountdownView.b(this.a).a(); 
          }
        });
    this.w.start();
  }
  
  public void b() {
    AnimatorSet animatorSet = this.w;
    if (animatorSet != null) {
      animatorSet.cancel();
      this.w = null;
    } 
    ValueAnimator valueAnimator = this.z;
    if (valueAnimator != null) {
      valueAnimator.cancel();
      this.z = null;
    } 
    valueAnimator = this.x;
    if (valueAnimator != null) {
      valueAnimator.cancel();
      this.x = null;
    } 
    valueAnimator = this.y;
    if (valueAnimator != null) {
      valueAnimator.cancel();
      this.y = null;
    } 
    this.s = 1.0F;
    this.t = 1.0F;
    invalidate();
  }
  
  public a getCountdownListener() {
    return this.v;
  }
  
  protected void onDetachedFromWindow() {
    b();
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    paramCanvas.translate(getMeasuredWidth() / 2.0F, getMeasuredHeight() / 2.0F);
    b(paramCanvas);
    a(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    int k = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = j;
    if (m != 1073741824)
      paramInt1 = e(); 
    paramInt2 = i;
    if (k != 1073741824)
      paramInt2 = e(); 
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setCountDownTime(int paramInt) {
    float f = paramInt;
    this.k = f;
    this.j = f;
    b();
  }
  
  public void setCountdownListener(a parama) {
    this.v = parama;
  }
  
  public static interface a {
    void a();
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\TTCountdownView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */