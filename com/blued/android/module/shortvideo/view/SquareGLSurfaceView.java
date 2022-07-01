package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class SquareGLSurfaceView extends GLSurfaceView {
  private static String a = SquareGLSurfaceView.class.getSimpleName();
  
  public SquareGLSurfaceView(Context paramContext) {
    super(paramContext);
  }
  
  public SquareGLSurfaceView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("specify width mode:");
    stringBuilder.append(View.MeasureSpec.toString(paramInt1));
    stringBuilder.append(" size:");
    stringBuilder.append(i);
    Log.i(str, stringBuilder.toString());
    str = a;
    stringBuilder = new StringBuilder();
    stringBuilder.append("specify height mode:");
    stringBuilder.append(View.MeasureSpec.toString(paramInt2));
    stringBuilder.append(" size:");
    stringBuilder.append(j);
    Log.i(str, stringBuilder.toString());
    setMeasuredDimension(i, j);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\SquareGLSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */