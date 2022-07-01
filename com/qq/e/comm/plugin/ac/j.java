package com.qq.e.comm.plugin.ac;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.ImageView;

public class j extends ImageView {
  private RectF a = new RectF();
  
  private Path b = new Path();
  
  private float[] c = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  
  public j(Context paramContext) {
    super(paramContext);
  }
  
  public void a(float paramFloat) {
    float[] arrayOfFloat = this.c;
    arrayOfFloat[0] = paramFloat;
    arrayOfFloat[1] = paramFloat;
    arrayOfFloat[2] = paramFloat;
    arrayOfFloat[3] = paramFloat;
    arrayOfFloat[4] = paramFloat;
    arrayOfFloat[5] = paramFloat;
    arrayOfFloat[6] = paramFloat;
    arrayOfFloat[7] = paramFloat;
  }
  
  public void a(float[] paramArrayOffloat) {
    if (paramArrayOffloat != null && paramArrayOffloat.length == 8)
      this.c = paramArrayOffloat; 
  }
  
  public void onDraw(Canvas paramCanvas) {
    this.a.set(0.0F, 0.0F, getWidth(), getHeight());
    this.b.addRoundRect(this.a, this.c, Path.Direction.CW);
    paramCanvas.clipPath(this.b);
    super.onDraw(paramCanvas);
    this.b.reset();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ac\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */