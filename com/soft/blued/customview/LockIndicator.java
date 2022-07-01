package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

public class LockIndicator extends View {
  private int a = 3;
  
  private int b = 3;
  
  private int c = 60;
  
  private int d = 60;
  
  private int e = 5;
  
  private int f = 5;
  
  private int g = 3;
  
  private Paint h = null;
  
  private Drawable i = null;
  
  private Drawable j = null;
  
  private String k;
  
  public LockIndicator(Context paramContext) {
    super(paramContext);
  }
  
  public LockIndicator(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet, 0);
    this.h = new Paint();
    this.h.setAntiAlias(true);
    this.h.setStrokeWidth(this.g);
    this.h.setStyle(Paint.Style.STROKE);
    this.i = getResources().getDrawable(2131231311);
    this.j = getResources().getDrawable(2131231312);
    Drawable drawable = this.j;
    if (drawable != null) {
      this.c = drawable.getIntrinsicWidth();
      this.d = this.j.getIntrinsicHeight();
      int i = this.c;
      this.e = i / 4;
      int j = this.d;
      this.f = j / 4;
      this.j.setBounds(0, 0, i, j);
      this.i.setBounds(0, 0, this.c, this.d);
    } 
  }
  
  protected void onDraw(Canvas paramCanvas) {
    if (this.j != null) {
      if (this.i == null)
        return; 
      for (int i = 0; i < this.a; i++) {
        int j = 0;
        while (j < this.b) {
          this.h.setColor(-16777216);
          int k = this.d;
          int m = this.f;
          int n = this.c;
          int i1 = this.e;
          paramCanvas.save();
          paramCanvas.translate((k * j + m * j), (n * i + i1 * i));
          k = this.b;
          j++;
          if (!TextUtils.isEmpty(this.k)) {
            if (this.k.indexOf(String.valueOf(k * i + j)) == -1) {
              this.i.draw(paramCanvas);
            } else {
              this.j.draw(paramCanvas);
            } 
          } else {
            this.i.draw(paramCanvas);
          } 
          paramCanvas.restore();
        } 
      } 
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (this.j != null) {
      paramInt1 = this.b;
      paramInt2 = this.d;
      int i = this.f;
      int j = this.a;
      setMeasuredDimension(paramInt2 * paramInt1 + i * (paramInt1 - 1), this.c * j + this.e * (j - 1));
    } 
  }
  
  public void setPath(String paramString) {
    this.k = paramString;
    invalidate();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\LockIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */