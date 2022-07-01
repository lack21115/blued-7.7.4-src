package com.blued.android.core.image.transform;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;

public class NinePatchTransformation extends BitmapTransformation {
  private static float b = (Resources.getSystem().getDisplayMetrics()).density;
  
  public Bitmap a(BitmapPool paramBitmapPool, Bitmap paramBitmap, int paramInt1, int paramInt2) {
    int k = Math.min(paramInt1, paramInt2);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f = k;
    f = Math.max(f / i, f / j);
    if (i == paramInt1 || j == paramInt2) {
      f = 1.0F;
    } else {
      float f1 = b / 2.0F;
      if (f1 <= f)
        f = f1; 
    } 
    Point point = new Point(i - 2 >> 1, j - 2 >> 1);
    k = (int)(point.x * f);
    int m = (int)(point.y * f);
    Rect rect = new Rect(k, m, paramInt1 - k, paramInt2 - m);
    Bitmap bitmap1 = TransformUtils.a(paramBitmapPool, paramBitmap);
    Bitmap bitmap2 = paramBitmapPool.a(paramInt1, paramInt2, TransformUtils.a(paramBitmap));
    bitmap2.setHasAlpha(true);
    TransformationUtils.a().lock();
    try {
      Canvas canvas = new Canvas(bitmap2);
      canvas.drawBitmap(bitmap1, new Rect(point.x, 0, point.x + 1, point.y), new Rect(rect.left, 0, rect.right, rect.top), null);
      canvas.drawBitmap(bitmap1, new Rect(0, point.y, point.x, point.y + 1), new Rect(0, rect.top, rect.left, rect.bottom), null);
      canvas.drawBitmap(bitmap1, new Rect(point.x + 1, point.y, i, point.y + 1), new Rect(rect.right, rect.top, paramInt1, rect.bottom), null);
      canvas.drawBitmap(bitmap1, new Rect(point.x, point.y + 1, point.x + 1, j), new Rect(rect.left, rect.bottom, rect.right, paramInt2), null);
      canvas.drawBitmap(bitmap1, new Rect(0, 0, point.x, point.y), new Rect(0, 0, rect.left, rect.top), null);
      canvas.drawBitmap(bitmap1, new Rect(point.x + 1, 0, i, point.y), new Rect(rect.right, 0, paramInt1, rect.top), null);
      canvas.drawBitmap(bitmap1, new Rect(0, point.y + 1, point.x, j), new Rect(0, rect.bottom, rect.left, paramInt2), null);
      canvas.drawBitmap(bitmap1, new Rect(point.x + 1, point.y + 1, i, j), new Rect(rect.right, rect.bottom, paramInt1, paramInt2), null);
      canvas.drawBitmap(bitmap1, new Rect(point.x, point.y, point.x + 1, point.y + 1), new Rect(rect.left, rect.top, rect.right, rect.bottom), null);
      canvas.setBitmap(null);
      TransformationUtils.a().unlock();
      return bitmap2;
    } finally {
      TransformationUtils.a().unlock();
    } 
  }
  
  public void a(MessageDigest paramMessageDigest) {
    paramMessageDigest.update("com.blued.android.core.transform.NinePatchTransformation.1".getBytes(a));
  }
  
  public boolean equals(Object paramObject) {
    return paramObject instanceof NinePatchTransformation;
  }
  
  public int hashCode() {
    return "com.blued.android.core.transform.NinePatchTransformation.1".hashCode();
  }
  
  public String toString() {
    return "NinePatchTransformation()";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\transform\NinePatchTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */