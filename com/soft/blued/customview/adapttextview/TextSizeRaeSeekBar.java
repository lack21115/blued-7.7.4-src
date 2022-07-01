package com.soft.blued.customview.adapttextview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.blued.android.core.utils.skin.BluedSkinUtils;

public class TextSizeRaeSeekBar extends AppCompatSeekBar {
  private String[] a;
  
  private int[] b;
  
  private final Paint c = (Paint)new TextPaint(1);
  
  private final Paint d = (Paint)new TextPaint(1);
  
  private float e = 18.0F;
  
  private float f = 15.0F;
  
  private int g = 10;
  
  private final Rect h = new Rect();
  
  public TextSizeRaeSeekBar(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public TextSizeRaeSeekBar(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextSizeRaeSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(float paramFloat) {
    return FontAdjustTextHelper.a(getContext(), paramFloat);
  }
  
  private void a() {
    this.a = FontAdjustTextHelper.c();
    this.b = FontAdjustTextHelper.d();
    setMax(this.b.length - 1);
    this.c.setColor(BluedSkinUtils.a(getContext(), 2131100359));
    this.d.setColor(BluedSkinUtils.a(getContext(), 2131100838));
  }
  
  public int a(Paint paramPaint, String paramString) {
    boolean bool;
    int i = 0;
    if (paramString != null && paramString.length() > 0) {
      int k = paramString.length();
      float[] arrayOfFloat = new float[k];
      paramPaint.getTextWidths(paramString, arrayOfFloat);
      int j = 0;
      while (true) {
        bool = j;
        if (i < k) {
          j += (int)Math.ceil(arrayOfFloat[i]);
          i++;
          continue;
        } 
        break;
      } 
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void onDraw(Canvas paramCanvas) {
    int j = getMax();
    int i = getWidth();
    int k = getHeight() / 2;
    this.h.left = getPaddingLeft();
    this.h.right = i - getPaddingRight();
    this.h.top = k - a(1.0F);
    Rect rect = this.h;
    rect.bottom = rect.top + a(1.5F);
    int m = this.h.width();
    paramCanvas.drawRect(this.h, this.c);
    for (i = 0; i <= j; i++) {
      int n = getPaddingLeft() + m * i / j;
      paramCanvas.drawCircle(n, k, FontAdjustTextHelper.a(getContext(), 3.0F), this.c);
      String[] arrayOfString = this.a;
      String str = arrayOfString[i % arrayOfString.length];
      this.d.setTextSize(a(this.b[i]));
      this.d.getTextBounds(str, 0, str.length(), this.h);
      float f = (n - a(this.d, this.a[i]) / 2);
      int[] arrayOfInt = this.b;
      paramCanvas.drawText(str, f, a(arrayOfInt[arrayOfInt.length - 1]), this.d);
    } 
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: iload_2
    //   5: invokespecial onMeasure : (II)V
    //   8: iload_1
    //   9: invokestatic getMode : (I)I
    //   12: istore_1
    //   13: iload_2
    //   14: invokestatic getMode : (I)I
    //   17: istore_2
    //   18: aload_0
    //   19: invokevirtual getMeasuredWidth : ()I
    //   22: istore_3
    //   23: aload_0
    //   24: invokevirtual getMeasuredHeight : ()I
    //   27: istore #4
    //   29: aload_0
    //   30: aload_0
    //   31: getfield b : [I
    //   34: aload_0
    //   35: getfield b : [I
    //   38: arraylength
    //   39: iconst_1
    //   40: isub
    //   41: iaload
    //   42: i2f
    //   43: invokespecial a : (F)I
    //   46: istore #5
    //   48: aload_0
    //   49: aload_0
    //   50: getfield f : F
    //   53: invokespecial a : (F)I
    //   56: istore #6
    //   58: aload_0
    //   59: iload_3
    //   60: iload_1
    //   61: invokestatic makeMeasureSpec : (II)I
    //   64: iload #4
    //   66: iload #5
    //   68: iconst_2
    //   69: imul
    //   70: iadd
    //   71: iload #6
    //   73: iconst_2
    //   74: imul
    //   75: iadd
    //   76: iload_2
    //   77: invokestatic makeMeasureSpec : (II)I
    //   80: invokevirtual setMeasuredDimension : (II)V
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: astore #7
    //   88: aload_0
    //   89: monitorexit
    //   90: aload #7
    //   92: athrow
    // Exception table:
    //   from	to	target	type
    //   2	83	86	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\adapttextview\TextSizeRaeSeekBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */