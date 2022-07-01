package com.soft.blued.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class RippleAnimationView extends View {
  private Bitmap a;
  
  private Paint b;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private boolean f;
  
  private long g;
  
  private float h;
  
  private float i;
  
  private ViewGroup j;
  
  private OnAnimationEndListener k;
  
  private Animator.AnimatorListener l;
  
  private ValueAnimator.AnimatorUpdateListener m;
  
  private RippleAnimationView(Context paramContext, float paramFloat1, float paramFloat2, int paramInt) {
    super(paramContext);
    this.j = (ViewGroup)a(paramContext).getWindow().getDecorView();
    this.h = paramFloat1;
    this.i = paramFloat2;
    this.d = paramInt;
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    c();
    b();
  }
  
  private Activity a(Context paramContext) {
    while (paramContext instanceof ContextWrapper) {
      if (paramContext instanceof Activity)
        return (Activity)paramContext; 
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    } 
    throw new RuntimeException("Activity not found!");
  }
  
  public static RippleAnimationView a(View paramView) {
    Context context = paramView.getContext();
    int i = paramView.getWidth() / 2;
    int j = paramView.getHeight() / 2;
    return new RippleAnimationView(context, c(paramView) + i, d(paramView) + j, Math.max(i, j));
  }
  
  private static Bitmap b(View paramView) {
    paramView.measure(View.MeasureSpec.makeMeasureSpec((paramView.getLayoutParams()).width, 1073741824), View.MeasureSpec.makeMeasureSpec((paramView.getLayoutParams()).height, 1073741824));
    Bitmap bitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(bitmap));
    return bitmap;
  }
  
  private void b() {
    this.l = (Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
        public void onAnimationEnd(Animator param1Animator) {
          if (RippleAnimationView.a(this.a) != null)
            RippleAnimationView.a(this.a).a(); 
          RippleAnimationView.a(this.a, false);
          RippleAnimationView.b(this.a);
        }
      };
    this.m = new ValueAnimator.AnimatorUpdateListener(this) {
        public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
          RippleAnimationView.a(this.a, (int)((Float)param1ValueAnimator.getAnimatedValue()).floatValue() + RippleAnimationView.c(this.a));
          this.a.postInvalidate();
        }
      };
  }
  
  private static float c(View paramView) {
    float f2 = paramView.getX();
    ViewParent viewParent = paramView.getParent();
    float f1 = f2;
    if (viewParent instanceof View)
      f1 = f2 + c((View)viewParent); 
    return f1;
  }
  
  private void c() {
    float f = this.h;
    int i = this.d;
    RectF rectF1 = new RectF(0.0F, 0.0F, f + i, this.i + i);
    RectF rectF2 = new RectF(rectF1.right, 0.0F, this.j.getRight(), rectF1.bottom);
    RectF rectF3 = new RectF(0.0F, rectF1.bottom, rectF1.right, this.j.getBottom());
    RectF rectF4 = new RectF(rectF3.right, rectF1.bottom, this.j.getRight(), rectF3.bottom);
    double d1 = Math.sqrt(Math.pow(rectF1.width(), 2.0D) + Math.pow(rectF1.height(), 2.0D));
    double d2 = Math.sqrt(Math.pow(rectF2.width(), 2.0D) + Math.pow(rectF2.height(), 2.0D));
    double d3 = Math.sqrt(Math.pow(rectF3.width(), 2.0D) + Math.pow(rectF3.height(), 2.0D));
    double d4 = Math.sqrt(Math.pow(rectF4.width(), 2.0D) + Math.pow(rectF4.height(), 2.0D));
    this.c = (int)Math.max(Math.max(d1, d2), Math.max(d3, d4));
  }
  
  private static float d(View paramView) {
    float f2 = paramView.getY();
    ViewParent viewParent = paramView.getParent();
    float f1 = f2;
    if (viewParent instanceof View)
      f1 = f2 + d((View)viewParent); 
    return f1;
  }
  
  private void d() {
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.j.addView(this);
  }
  
  private void e() {
    ViewGroup viewGroup = this.j;
    if (viewGroup != null) {
      viewGroup.removeView(this);
      this.j = null;
    } 
    Bitmap bitmap = this.a;
    if (bitmap != null) {
      if (!bitmap.isRecycled())
        this.a.recycle(); 
      this.a = null;
    } 
    if (this.b != null)
      this.b = null; 
  }
  
  private void f() {
    Bitmap bitmap = this.a;
    if (bitmap != null && !bitmap.isRecycled())
      this.a.recycle(); 
    this.a = b((View)this.j);
  }
  
  private ValueAnimator getAnimator() {
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, this.c }).setDuration(this.g);
    valueAnimator.addUpdateListener(this.m);
    valueAnimator.addListener(this.l);
    return valueAnimator;
  }
  
  public RippleAnimationView a(long paramLong) {
    this.g = paramLong;
    return this;
  }
  
  public void a() {
    if (!this.f) {
      this.f = true;
      f();
      d();
      getAnimator().start();
    } 
  }
  
  protected void onDraw(Canvas paramCanvas) {
    int i;
    if (Build.VERSION.SDK_INT >= 21) {
      i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null);
    } else {
      i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null, 31);
    } 
    paramCanvas.drawBitmap(this.a, 0.0F, 0.0F, null);
    paramCanvas.drawCircle(this.h, this.i, this.e, this.b);
    paramCanvas.restoreToCount(i);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return true;
  }
  
  public static interface OnAnimationEndListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\RippleAnimationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */