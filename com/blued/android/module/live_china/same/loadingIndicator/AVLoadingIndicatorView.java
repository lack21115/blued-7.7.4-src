package com.blued.android.module.live_china.same.loadingIndicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.live_china.R;

public class AVLoadingIndicatorView extends View {
  int a;
  
  int b;
  
  Paint c;
  
  BaseIndicatorController d;
  
  private boolean e;
  
  public AVLoadingIndicatorView(Context paramContext) {
    super(paramContext);
    a((AttributeSet)null, 0);
  }
  
  public AVLoadingIndicatorView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet, 0);
  }
  
  public AVLoadingIndicatorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet, paramInt);
  }
  
  public AVLoadingIndicatorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramAttributeSet, paramInt1);
  }
  
  private int a(int paramInt) {
    return (int)(getContext().getResources().getDisplayMetrics()).density * paramInt;
  }
  
  private int a(int paramInt1, int paramInt2) {
    int i = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    if (i == 1073741824)
      return j; 
    paramInt2 = paramInt1;
    if (i == Integer.MIN_VALUE)
      paramInt2 = Math.min(paramInt1, j); 
    return paramInt2;
  }
  
  private void a(AttributeSet paramAttributeSet, int paramInt) {
    TypedArray typedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.AVLoadingIndicatorView);
    this.a = typedArray.getInt(R.styleable.AVLoadingIndicatorView_indicator, 0);
    this.b = typedArray.getColor(R.styleable.AVLoadingIndicatorView_indicator_color, -1);
    typedArray.recycle();
    this.c = new Paint();
    this.c.setColor(this.b);
    this.c.setStyle(Paint.Style.FILL);
    this.c.setAntiAlias(true);
    b();
  }
  
  private void b() {
    switch (this.a) {
      default:
        this.d = new BallSpinFadeLoaderIndicator();
        break;
      case 22:
        this.d = new BallSpinFadeLoaderIndicator();
        break;
      case 18:
        this.d = new LineScalePulseOutIndicator();
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 17:
      case 19:
      case 20:
      case 21:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
        break;
    } 
    BaseIndicatorController baseIndicatorController = this.d;
    if (baseIndicatorController != null)
      baseIndicatorController.a(this); 
  }
  
  void a() {
    this.d.f();
  }
  
  void a(Canvas paramCanvas) {
    this.d.a(paramCanvas, this.c);
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    if (this.e)
      this.d.a(BaseIndicatorController.AnimStatus.a); 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.d.a(BaseIndicatorController.AnimStatus.c);
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    a(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.e) {
      this.e = true;
      a();
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    setMeasuredDimension(a(a(45), paramInt1), a(a(45), paramInt2));
  }
  
  public void setVisibility(int paramInt) {
    if (getVisibility() != paramInt) {
      super.setVisibility(paramInt);
      if (paramInt == 8 || paramInt == 4) {
        this.d.a(BaseIndicatorController.AnimStatus.b);
        return;
      } 
      this.d.a(BaseIndicatorController.AnimStatus.a);
      return;
    } 
  }
  
  public static @interface Indicator {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\same\loadingIndicator\AVLoadingIndicatorView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */