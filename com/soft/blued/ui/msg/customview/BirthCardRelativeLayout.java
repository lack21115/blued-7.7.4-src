package com.soft.blued.ui.msg.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.soft.blued.utils.Logger;

public class BirthCardRelativeLayout extends RelativeLayout {
  private Rect a = new Rect();
  
  private Paint b;
  
  private int c = 0;
  
  public BirthCardRelativeLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public BirthCardRelativeLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BirthCardRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b() {
    this.b = new Paint();
    this.b.setColor(this.c);
    this.b.setStyle(Paint.Style.FILL);
  }
  
  public void a() {
    Logger.c(getClass().getSimpleName(), new Object[] { "startAnim" });
    ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[] { 0, getMeasuredHeight() });
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            (BirthCardRelativeLayout.a(this.a)).top = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            this.a.invalidate();
          }
        });
    valueAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) {
            super.onAnimationEnd(param1Animator);
            BirthCardRelativeLayout.b(this.a).setColor(0);
          }
        });
    valueAnimator.setDuration(2000L);
    valueAnimator.start();
  }
  
  protected void dispatchDraw(Canvas paramCanvas) {
    super.dispatchDraw(paramCanvas);
    String str = getClass().getSimpleName();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("dispatchDraw====");
    stringBuilder.append(this.b.getColor());
    Logger.c(str, new Object[] { stringBuilder.toString() });
    paramCanvas.drawRect(this.a, this.b);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    Rect rect = this.a;
    rect.left = 0;
    rect.right = getMeasuredWidth();
    rect = this.a;
    rect.top = 0;
    rect.bottom = getMeasuredHeight();
  }
  
  public void setShadeColor(int paramInt) {
    this.c = paramInt;
    this.b.setColor(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\customview\BirthCardRelativeLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */