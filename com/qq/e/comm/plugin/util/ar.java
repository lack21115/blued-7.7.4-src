package com.qq.e.comm.plugin.util;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;

public class ar {
  public static ShapeDrawable a(float paramFloat, int paramInt1, int paramInt2) {
    float[] arrayOfFloat = new float[8];
    for (int i = 0; i < 8; i++)
      arrayOfFloat[i] = paramFloat; 
    ShapeDrawable shapeDrawable = new ShapeDrawable((Shape)new RoundRectShape(arrayOfFloat, null, null));
    shapeDrawable.getPaint().setColor(paramInt1);
    shapeDrawable.getPaint().setAlpha(paramInt2);
    return shapeDrawable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */