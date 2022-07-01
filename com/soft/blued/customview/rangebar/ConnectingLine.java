package com.soft.blued.customview.rangebar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.TypedValue;

class ConnectingLine {
  private final Paint a;
  
  private final float b;
  
  private final float c;
  
  ConnectingLine(Context paramContext, float paramFloat1, float paramFloat2, int paramInt) {
    this.b = TypedValue.applyDimension(1, paramFloat2, paramContext.getResources().getDisplayMetrics());
    this.a = new Paint();
    this.a.setColor(paramInt);
    this.a.setStrokeWidth(this.b);
    this.a.setAntiAlias(true);
    this.c = paramFloat1;
  }
  
  void a(Canvas paramCanvas, Thumb paramThumb1, Thumb paramThumb2) {
    paramCanvas.drawLine(paramThumb1.b(), this.c, paramThumb2.b(), this.c, this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\rangebar\ConnectingLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */