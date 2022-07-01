package com.qq.e.comm.plugin.q;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;

class a extends View {
  private Paint a;
  
  private float b;
  
  private RectF c;
  
  private float d;
  
  private Path e;
  
  public a(Context paramContext) {
    super(paramContext);
    setLayerType(1, null);
    this.c = new RectF();
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.e = new Path();
  }
  
  private float a() {
    return (float)((this.d * 2.0F) * Math.sqrt(Math.pow((b() / 2), 2.0D) + Math.pow((c() - this.b), 2.0D)) / b());
  }
  
  private int b() {
    return getHeight() - getPaddingBottom() - getPaddingTop();
  }
  
  private int c() {
    return getWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  public void a(float paramFloat) {
    this.b = (float)(paramFloat / Math.sqrt(2.0D));
    this.d = paramFloat;
    this.a.setStrokeWidth(paramFloat);
  }
  
  public void a(int paramInt) {
    this.a.setColor(paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    this.e.moveTo(getPaddingLeft(), (getHeight() / 2));
    this.e.lineTo(c() - this.b + getPaddingLeft(), getPaddingTop());
    this.e.lineTo((c() + getPaddingLeft()), this.b + getPaddingTop());
    this.e.lineTo(a() + getPaddingLeft(), (getHeight() / 2));
    this.e.lineTo((c() + getPaddingLeft()), b() - this.b + getPaddingTop());
    this.e.lineTo(c() - this.b + getPaddingLeft(), (b() + getPaddingTop()));
    this.e.close();
    paramCanvas.drawPath(this.e, this.a);
    this.c.set(c() - this.b * 2.0F + getPaddingLeft(), getPaddingTop(), (c() + getPaddingLeft()), this.b * 2.0F + getPaddingTop());
    paramCanvas.drawArc(this.c, 0.0F, -90.0F, true, this.a);
    this.c.set(c() - this.b * 2.0F + getPaddingLeft(), b() - this.b * 2.0F + getPaddingTop(), (c() + getPaddingLeft()), (b() + getPaddingTop()));
    paramCanvas.drawArc(this.c, 0.0F, 90.0F, true, this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\q\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */