package com.qq.e.comm.plugin.ac;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;

public class h extends View {
  private Paint a;
  
  private int b;
  
  private int c = 100;
  
  private boolean d = false;
  
  private int e = Color.parseColor("#3185FC");
  
  private int f = Color.parseColor("#3185FC");
  
  private int g = Color.parseColor("#d8d8d8");
  
  private Paint h;
  
  private Path i = new Path();
  
  private float[] j = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  
  private RectF k;
  
  public h(Context paramContext) {
    super(paramContext);
    setLayerType(1, null);
    a();
  }
  
  private void a() {
    this.a = new Paint();
    this.h = new Paint();
    this.k = new RectF();
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Paint paramPaint) {
    this.k.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    paramCanvas.drawRect(this.k, paramPaint);
  }
  
  public void a(float paramFloat) {
    float[] arrayOfFloat = this.j;
    if (arrayOfFloat != null && arrayOfFloat.length > 0) {
      int i = 0;
      while (true) {
        arrayOfFloat = this.j;
        if (i < arrayOfFloat.length) {
          arrayOfFloat[i] = paramFloat;
          i++;
          continue;
        } 
        break;
      } 
    } 
  }
  
  public void a(int paramInt) {
    // Byte code:
    //   0: iload_1
    //   1: ifgt -> 14
    //   4: iconst_0
    //   5: istore_2
    //   6: aload_0
    //   7: iload_2
    //   8: putfield b : I
    //   11: goto -> 28
    //   14: iload_1
    //   15: istore_2
    //   16: iload_1
    //   17: bipush #100
    //   19: if_icmplt -> 6
    //   22: aload_0
    //   23: bipush #100
    //   25: putfield b : I
    //   28: aload_0
    //   29: invokevirtual postInvalidate : ()V
    //   32: return
  }
  
  public void a(boolean paramBoolean) {
    this.d = paramBoolean;
  }
  
  public void b(int paramInt) {
    this.c = paramInt;
  }
  
  public void c(int paramInt) {
    this.e = paramInt;
    this.f = paramInt;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    this.k.set(0.0F, 0.0F, getWidth(), getHeight());
    this.i.addRoundRect(this.k, this.j, Path.Direction.CW);
    paramCanvas.clipPath(this.i);
    super.onDraw(paramCanvas);
    if (this.b >= 0) {
      Paint paint;
      int i = getMeasuredWidth();
      float f3 = getMeasuredHeight();
      float f4 = f3 / 2.0F;
      int j = this.b;
      float f1 = j / this.c;
      float f2 = i;
      f1 *= f2;
      if (this.d) {
        if (j > 0 && j < 100) {
          this.h.setColor(this.g);
          a(paramCanvas, 0.0F, 0.0F, f2, f3, this.h);
          paint = this.a;
          i = this.e;
          j = this.f;
          Shader.TileMode tileMode = Shader.TileMode.CLAMP;
          paint.setShader((Shader)new LinearGradient(0.0F, f4, f1, f4, i, j, tileMode));
          this.a.setStyle(Paint.Style.FILL);
          paint = this.a;
        } else {
          this.h.setColor(this.f);
          this.a.setStyle(Paint.Style.FILL);
          paint = this.h;
          f1 = f2;
        } 
      } else {
        this.h.setColor(Color.parseColor("#40000000"));
        a(paramCanvas, 0.0F, 0.0F, f2, f3, this.h);
        this.a.setColor(Color.parseColor("#BFFFFFFF"));
        paint = this.a;
      } 
      a(paramCanvas, 0.0F, 0.0F, f1, f3, paint);
    } 
    this.i.reset();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ac\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */