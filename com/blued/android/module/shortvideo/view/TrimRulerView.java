package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class TrimRulerView extends View {
  private final String[] a = new String[] { "00:00", "00:15", "00:30", "00:45", "01:00" };
  
  private Paint b;
  
  private float c;
  
  private float d;
  
  private int e = 0;
  
  public TrimRulerView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet, 0);
  }
  
  public TrimRulerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet, paramInt);
  }
  
  private void a(AttributeSet paramAttributeSet, int paramInt) {
    this.b = new Paint();
    this.b.setColor(Color.parseColor("#ffffff"));
    this.b.setStrokeWidth(3.0F);
    this.b.setTextSize(TypedValue.applyDimension(2, 11.0F, getResources().getDisplayMetrics()));
    this.b.setAntiAlias(true);
    Rect rect = new Rect();
    Paint paint = this.b;
    String[] arrayOfString = this.a;
    paint.getTextBounds(arrayOfString[0], 0, arrayOfString[0].length(), rect);
    this.c = rect.width();
    this.d = rect.height();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    float f2 = (getMeasuredWidth() - getPaddingLeft() - getPaddingRight() - this.e * 2) / 60.0F;
    float f1 = (getPaddingLeft() + this.e);
    int i = 0;
    int j = 0;
    while (i < 61) {
      if (i % 15 == 0) {
        paramCanvas.drawLine(f1, 0.0F, f1, 12.0F, this.b);
        paramCanvas.drawText(this.a[j], f1 - this.c * 0.5F, this.d + 14.0F, this.b);
        j++;
      } else {
        paramCanvas.drawLine(f1, 0.0F, f1, 6.0F, this.b);
      } 
      f1 += f2;
      i++;
    } 
  }
  
  public void setOffset(int paramInt) {
    this.e = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\TrimRulerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */