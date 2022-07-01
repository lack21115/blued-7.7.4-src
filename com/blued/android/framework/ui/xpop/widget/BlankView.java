package com.blued.android.framework.ui.xpop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class BlankView extends View {
  public int a = 0;
  
  public int b = -1;
  
  public int c = Color.parseColor("#DDDDDD");
  
  private Paint d = new Paint();
  
  private RectF e = null;
  
  public BlankView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public BlankView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    this.d.setAntiAlias(true);
    this.d.setStrokeWidth(1.0F);
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    this.d.setColor(this.b);
    RectF rectF = this.e;
    int i = this.a;
    paramCanvas.drawRoundRect(rectF, i, i, this.d);
    this.d.setStyle(Paint.Style.STROKE);
    this.d.setColor(this.c);
    rectF = this.e;
    i = this.a;
    paramCanvas.drawRoundRect(rectF, i, i, this.d);
    this.d.setStyle(Paint.Style.FILL);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.e = new RectF(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\widget\BlankView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */