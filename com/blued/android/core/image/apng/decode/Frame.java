package com.blued.android.core.image.apng.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.blued.android.core.image.apng.io.Reader;
import com.blued.android.core.image.apng.io.Writer;

public abstract class Frame<R extends Reader, W extends Writer> {
  protected final R g;
  
  public int h;
  
  public int i;
  
  public int j;
  
  public int k;
  
  public int l;
  
  public Frame(R paramR) {
    this.g = paramR;
  }
  
  public abstract Bitmap a(Canvas paramCanvas, Paint paramPaint, int paramInt, Bitmap paramBitmap, W paramW);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\decode\Frame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */