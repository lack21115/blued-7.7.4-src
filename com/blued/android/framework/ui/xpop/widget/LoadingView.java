package com.blued.android.framework.ui.xpop.widget;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;

public class LoadingView extends View {
  int a = 12;
  
  float b = 360.0F / this.a;
  
  int c = 0;
  
  float d;
  
  float e;
  
  float f;
  
  float g;
  
  private Paint h = new Paint(1);
  
  private float i;
  
  private float j;
  
  private float k = 2.0F;
  
  private ArgbEvaluator l = new ArgbEvaluator();
  
  private int m = Color.parseColor("#DDDDDD");
  
  private int n = Color.parseColor("#333333");
  
  private Runnable o = new Runnable(this) {
      public void run() {
        LoadingView loadingView = this.a;
        loadingView.c++;
        loadingView = this.a;
        loadingView.postInvalidate(0, 0, loadingView.getMeasuredWidth(), this.a.getMeasuredHeight());
      }
    };
  
  public LoadingView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.k = XPopupUtils.a(paramContext, this.k);
    this.h.setStrokeWidth(this.k);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    removeCallbacks(this.o);
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    int i;
    for (i = this.a - 1; i >= 0; i--) {
      int j = Math.abs(this.c + i);
      int k = this.a;
      float f1 = (j % k + 1) * 1.0F / k;
      j = ((Integer)this.l.evaluate(f1, Integer.valueOf(this.m), Integer.valueOf(this.n))).intValue();
      this.h.setColor(j);
      f1 = this.f;
      float f2 = this.e;
      paramCanvas.drawLine(f1, f2, this.g, f2, this.h);
      paramCanvas.drawCircle(this.f, this.e, this.k / 2.0F, this.h);
      paramCanvas.drawCircle(this.g, this.e, this.k / 2.0F, this.h);
      paramCanvas.rotate(this.b, this.d, this.e);
    } 
    postDelayed(this.o, 60L);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.i = (getMeasuredWidth() / 2);
    this.j = this.i / 2.5F;
    this.d = (getMeasuredWidth() / 2);
    this.e = (getMeasuredHeight() / 2);
    this.k *= getMeasuredWidth() * 1.0F / XPopupUtils.a(getContext(), 30.0F);
    this.h.setStrokeWidth(this.k);
    this.f = this.d + this.j;
    this.g = this.f + this.i / 3.0F;
    removeCallbacks(this.o);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\widget\LoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */