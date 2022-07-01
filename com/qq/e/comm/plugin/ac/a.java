package com.qq.e.comm.plugin.ac;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.qq.e.comm.plugin.util.am;

public class a extends View {
  private Paint a;
  
  private Paint b;
  
  private int c;
  
  private int d = am.a(getContext().getApplicationContext(), 4);
  
  private int e = 100;
  
  private RectF f;
  
  public a(Context paramContext) {
    super(paramContext);
    setLayerType(1, null);
    a();
  }
  
  private void a() {
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.a.setColor(Color.parseColor("#C3C4C5"));
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeWidth(this.d);
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setColor(-1);
    this.b.setStrokeWidth(this.d);
    this.f = new RectF();
  }
  
  public void a(int paramInt) {
    // Byte code:
    //   0: iload_1
    //   1: ifgt -> 14
    //   4: iconst_0
    //   5: istore_2
    //   6: aload_0
    //   7: iload_2
    //   8: putfield c : I
    //   11: goto -> 28
    //   14: iload_1
    //   15: istore_2
    //   16: iload_1
    //   17: bipush #100
    //   19: if_icmplt -> 6
    //   22: aload_0
    //   23: bipush #100
    //   25: putfield c : I
    //   28: aload_0
    //   29: invokevirtual postInvalidate : ()V
    //   32: return
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    int k = i / 2;
    paramCanvas.drawCircle(k, (j / 2), (k - this.d), this.a);
    j = this.c;
    if (j > 0) {
      RectF rectF = this.f;
      k = this.d;
      rectF.left = k;
      rectF.top = k;
      rectF.right = (i - k);
      rectF.bottom = (i - k);
      paramCanvas.drawArc(rectF, -90.0F, j / this.e * 360.0F, false, this.b);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ac\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */