package com.qq.e.comm.plugin.ac;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import com.qq.e.comm.plugin.aa.b.f;
import com.qq.e.comm.plugin.util.y;

public class b extends View {
  private Paint a;
  
  private Paint b;
  
  private RectF c;
  
  private float d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  private f i;
  
  private int j;
  
  private int k;
  
  private a l;
  
  private Runnable m = new Runnable(this) {
      public void run() {
        if (b.a(this.a) != null && b.b(this.a) > 0 && b.a(this.a).f() < b.b(this.a)) {
          this.a.invalidate();
          b.c(this.a);
          y.a(b.d(this.a), b.e(this.a));
        } 
      }
    };
  
  public b(Context paramContext) {
    super(paramContext);
    setLayerType(1, null);
    b();
  }
  
  private void b() {
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.b = new Paint();
    this.b.setColor(-1);
    this.b.setTextAlign(Paint.Align.CENTER);
    this.c = new RectF();
  }
  
  private void c() {
    a a1 = this.l;
    if (a1 != null)
      a1.i(); 
  }
  
  public void a() {
    y.c(this.m);
  }
  
  public void a(float paramFloat) {
    this.d = paramFloat;
  }
  
  public void a(int paramInt) {
    this.e = paramInt;
  }
  
  public void a(f paramf, int paramInt, a parama) {
    if (paramf != null && paramInt > 0 && paramf.e() > 0) {
      this.i = paramf;
      this.j = paramf.e();
      this.k = paramInt;
      this.l = parama;
      invalidate();
      c();
      y.a(this.m, paramInt);
    } 
  }
  
  public void b(float paramFloat) {
    this.b.setTextSize(paramFloat);
    Paint.FontMetricsInt fontMetricsInt = this.b.getFontMetricsInt();
    int i = fontMetricsInt.top;
    this.h = (fontMetricsInt.bottom + i) / 2;
  }
  
  public void b(int paramInt) {
    this.f = paramInt;
  }
  
  public void c(int paramInt) {
    this.g = paramInt;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    f f1 = this.i;
    if (f1 != null && this.j > 0) {
      int k = f1.f();
      if (k <= this.j) {
        this.a.setStyle(Paint.Style.FILL);
        this.a.setColor(this.g);
        float f2 = (i / 2);
        j /= 2;
        float f3 = j;
        paramCanvas.drawCircle(f2, f3, f2 - this.d, this.a);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.d);
        this.a.setColor(this.e);
        paramCanvas.drawCircle(f2, f3, f2 - this.d, this.a);
        RectF rectF = this.c;
        f3 = this.d;
        rectF.left = f3;
        rectF.top = f3;
        float f4 = i;
        rectF.right = f4 - f3;
        rectF.bottom = f4 - f3;
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.d);
        this.a.setColor(this.f);
        paramCanvas.drawArc(this.c, -90.0F, k / this.j * 360.0F, false, this.a);
        long l = ((this.j - k) / 1000);
        String str = String.valueOf(1);
        if (l > 0L)
          str = String.valueOf(l); 
        if (!TextUtils.isEmpty(str))
          paramCanvas.drawText(str, f2, (j - this.h), this.b); 
      } 
    } 
  }
  
  public static interface a {
    void i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ac\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */