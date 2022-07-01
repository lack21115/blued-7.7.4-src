package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.live_china.R;

public class HalfCircle extends View {
  public Paint a;
  
  public int b = -1;
  
  public Context c;
  
  public HalfCircle(Context paramContext) {
    super(paramContext);
    this.c = paramContext;
    a();
  }
  
  public HalfCircle(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
    a();
  }
  
  public HalfCircle(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
    a();
  }
  
  public void a() {
    this.a = new Paint(1);
    this.a.setStyle(Paint.Style.FILL);
  }
  
  protected void onDraw(Canvas paramCanvas) {
    int i = this.b;
    if (i != -1) {
      this.a.setColor(i);
    } else {
      this.a.setColor(this.c.getResources().getColor(R.color.black));
    } 
    paramCanvas.drawArc(new RectF(0.0F, 0.0F, (getWidth() * 2), getHeight()), 90.0F, 180.0F, false, this.a);
  }
  
  public void setColor(int paramInt) {
    this.b = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\HalfCircle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */