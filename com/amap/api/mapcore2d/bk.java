package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.RemoteException;
import android.view.View;

class bk extends View {
  private String a = "";
  
  private int b = 0;
  
  private b c;
  
  private Paint d;
  
  private Paint e;
  
  private Rect f;
  
  public bk(Context paramContext, b paramb) {
    super(paramContext);
    this.c = paramb;
    this.d = new Paint();
    this.f = new Rect();
    this.d.setAntiAlias(true);
    this.d.setColor(-16777216);
    this.d.setStrokeWidth(q.a * 2.0F);
    this.d.setStyle(Paint.Style.STROKE);
    this.e = new Paint();
    this.e.setAntiAlias(true);
    this.e.setColor(-16777216);
    this.e.setTextSize(q.a * 20.0F);
  }
  
  public void a() {
    this.d = null;
    this.e = null;
    this.f = null;
    this.a = null;
  }
  
  public void a(int paramInt) {
    this.b = paramInt;
  }
  
  public void a(String paramString) {
    this.a = paramString;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    try {
      boolean bool = this.c.c().isScaleControlsEnabled();
      if (!bool)
        return; 
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
    } 
    if (!this.a.equals("")) {
      int j = this.b;
      if (j == 0)
        return; 
      int i = j;
      try {
        if (j > this.c.getWidth() / 5)
          i = this.c.getWidth() / 5; 
      } catch (Exception exception) {
        cm.a(exception, "ScaleView", "onDraw");
        i = j;
      } 
      Point point = this.c.f();
      Paint paint = this.e;
      String str = this.a;
      paint.getTextBounds(str, 0, str.length(), this.f);
      if (point.x + i > this.c.getWidth() - 10) {
        j = this.c.getWidth() - 10 - (this.f.width() + i) / 2;
      } else {
        j = point.x + (i - this.f.width()) / 2;
      } 
      int k = point.y - this.f.height() + 5;
      paramCanvas.drawText(this.a, j, k, this.e);
      j -= (i - this.f.width()) / 2;
      k += this.f.height() - 5;
      float f1 = j;
      float f2 = (k - 2);
      float f3 = (k + 2);
      paramCanvas.drawLine(f1, f2, f1, f3, this.d);
      float f4 = k;
      float f5 = (j + i);
      paramCanvas.drawLine(f1, f4, f5, f4, this.d);
      paramCanvas.drawLine(f5, f2, f5, f3, this.d);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */