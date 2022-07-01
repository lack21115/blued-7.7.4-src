package com.blued.android.core.image.transform;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public class TransformUtils {
  public static Bitmap.Config a(Bitmap paramBitmap) {
    return (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(paramBitmap.getConfig())) ? Bitmap.Config.RGBA_F16 : Bitmap.Config.ARGB_8888;
  }
  
  public static Bitmap a(BitmapPool paramBitmapPool, Bitmap paramBitmap) {
    Bitmap.Config config = a(paramBitmap);
    if (config.equals(paramBitmap.getConfig()))
      return paramBitmap; 
    Bitmap bitmap = paramBitmapPool.a(paramBitmap.getWidth(), paramBitmap.getHeight(), config);
    (new Canvas(bitmap)).drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    return bitmap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\transform\TransformUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */