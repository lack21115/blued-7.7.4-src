package com.geetest.onelogin.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Movie;
import android.graphics.PaintFlagsDrawFilter;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;

public class GTGifView extends View {
  private int a;
  
  private Movie b;
  
  private long c;
  
  private int d;
  
  private float e;
  
  private float f;
  
  private float g;
  
  private int h;
  
  private int i;
  
  private volatile boolean j;
  
  private boolean k = true;
  
  public GTGifView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public GTGifView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GTGifView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    if (Build.VERSION.SDK_INT >= 11)
      setLayerType(1, null); 
  }
  
  private void a(Canvas paramCanvas) {
    this.b.setTime(this.d);
    paramCanvas.save();
    paramCanvas.setDrawFilter((DrawFilter)new PaintFlagsDrawFilter(0, 3));
    float f1 = this.g;
    paramCanvas.scale(f1, f1);
    Movie movie = this.b;
    f1 = this.e;
    float f2 = this.g;
    movie.draw(paramCanvas, f1 / f2, this.f / f2);
    paramCanvas.restore();
  }
  
  private void c() {
    if (this.k) {
      if (Build.VERSION.SDK_INT >= 16) {
        postInvalidateOnAnimation();
        return;
      } 
      invalidate();
    } 
  }
  
  private void d() {
    long l = SystemClock.uptimeMillis();
    if (this.c == 0L)
      this.c = l; 
    int j = this.b.duration();
    int i = j;
    if (j == 0)
      i = 1000; 
    this.d = (int)((l - this.c) % i);
  }
  
  public void a() {
    if (this.j) {
      this.j = false;
      setVisibility(0);
      this.c = SystemClock.uptimeMillis() - this.d;
      invalidate();
    } 
  }
  
  public void b() {
    if (!this.j) {
      this.j = true;
      setVisibility(8);
      invalidate();
    } 
  }
  
  public int getGifResource() {
    return this.a;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    if (this.b != null) {
      if (!this.j) {
        d();
        a(paramCanvas);
        c();
        return;
      } 
      a(paramCanvas);
    } 
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.e = (getWidth() - this.h) / 2.0F;
    this.f = (getHeight() - this.i) / 2.0F;
    if (getVisibility() == 0) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    this.k = paramBoolean;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Landroid/graphics/Movie;
    //   4: astore #7
    //   6: aload #7
    //   8: ifnull -> 144
    //   11: aload #7
    //   13: invokevirtual width : ()I
    //   16: istore #5
    //   18: aload_0
    //   19: getfield b : Landroid/graphics/Movie;
    //   22: invokevirtual height : ()I
    //   25: istore #6
    //   27: iload_1
    //   28: invokestatic getMode : (I)I
    //   31: ifeq -> 55
    //   34: iload_1
    //   35: invokestatic getSize : (I)I
    //   38: istore_1
    //   39: iload #5
    //   41: iload_1
    //   42: if_icmple -> 55
    //   45: iload #5
    //   47: i2f
    //   48: iload_1
    //   49: i2f
    //   50: fdiv
    //   51: fstore_3
    //   52: goto -> 57
    //   55: fconst_1
    //   56: fstore_3
    //   57: iload_2
    //   58: invokestatic getMode : (I)I
    //   61: ifeq -> 86
    //   64: iload_2
    //   65: invokestatic getSize : (I)I
    //   68: istore_1
    //   69: iload #6
    //   71: iload_1
    //   72: if_icmple -> 86
    //   75: iload #6
    //   77: i2f
    //   78: iload_1
    //   79: i2f
    //   80: fdiv
    //   81: fstore #4
    //   83: goto -> 89
    //   86: fconst_1
    //   87: fstore #4
    //   89: aload_0
    //   90: fconst_1
    //   91: fload_3
    //   92: fload #4
    //   94: invokestatic max : (FF)F
    //   97: fdiv
    //   98: putfield g : F
    //   101: iload #5
    //   103: i2f
    //   104: fstore_3
    //   105: aload_0
    //   106: getfield g : F
    //   109: fstore #4
    //   111: aload_0
    //   112: fload_3
    //   113: fload #4
    //   115: fmul
    //   116: f2i
    //   117: putfield h : I
    //   120: aload_0
    //   121: iload #6
    //   123: i2f
    //   124: fload #4
    //   126: fmul
    //   127: f2i
    //   128: putfield i : I
    //   131: aload_0
    //   132: aload_0
    //   133: getfield h : I
    //   136: aload_0
    //   137: getfield i : I
    //   140: invokevirtual setMeasuredDimension : (II)V
    //   143: return
    //   144: aload_0
    //   145: aload_0
    //   146: invokevirtual getSuggestedMinimumWidth : ()I
    //   149: aload_0
    //   150: invokevirtual getSuggestedMinimumHeight : ()I
    //   153: invokevirtual setMeasuredDimension : (II)V
    //   156: return
  }
  
  public void onScreenStateChanged(int paramInt) {
    super.onScreenStateChanged(paramInt);
    boolean bool = true;
    if (paramInt != 1)
      bool = false; 
    this.k = bool;
    c();
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt) {
    boolean bool;
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.k = bool;
    c();
  }
  
  protected void onWindowVisibilityChanged(int paramInt) {
    boolean bool;
    super.onWindowVisibilityChanged(paramInt);
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.k = bool;
    c();
  }
  
  public void setGifResource(int paramInt) {
    this.a = paramInt;
    this.b = Movie.decodeStream(getResources().openRawResource(this.a));
    requestLayout();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\view\GTGifView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */