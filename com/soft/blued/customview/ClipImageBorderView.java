package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class ClipImageBorderView extends View {
  private int a;
  
  private int b;
  
  private int c;
  
  private int d = Color.parseColor("#FFFFFF");
  
  private int e = 1;
  
  private Paint f;
  
  public ClipImageBorderView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ClipImageBorderView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ClipImageBorderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.e = (int)TypedValue.applyDimension(1, this.e, getResources().getDisplayMetrics());
    this.f = new Paint();
    this.f.setAntiAlias(true);
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    this.c = getWidth() - this.a * 2;
    if (this.b == 0)
      this.b = (getHeight() - this.c) / 2; 
    this.f.setColor(Color.parseColor("#aa000000"));
    this.f.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(0.0F, 0.0F, this.a, getHeight(), this.f);
    paramCanvas.drawRect((getWidth() - this.a), 0.0F, getWidth(), getHeight(), this.f);
    paramCanvas.drawRect(this.a, 0.0F, (getWidth() - this.a), this.b, this.f);
    paramCanvas.drawRect(this.a, (getHeight() - this.b), (getWidth() - this.a), getHeight(), this.f);
    this.f.setColor(this.d);
    this.f.setStrokeWidth(this.e);
    this.f.setStyle(Paint.Style.STROKE);
    paramCanvas.drawRect(this.a, this.b, (getWidth() - this.a), (getHeight() - this.b), this.f);
  }
  
  public void setHorizontalPadding(int paramInt) {
    this.a = paramInt;
  }
  
  public void setVerticalPadding(int paramInt) {
    this.b = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\ClipImageBorderView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */