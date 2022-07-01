package com.soft.blued.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

public class ShareBitmapUtils {
  public static Bitmap a(Drawable paramDrawable) {
    Bitmap bitmap;
    try {
      Bitmap.Config config;
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      if (paramDrawable.getOpacity() != -1) {
        config = Bitmap.Config.ARGB_8888;
      } else {
        config = Bitmap.Config.RGB_565;
      } 
      bitmap = Bitmap.createBitmap(i, j, config);
    } catch (Exception exception) {
      Bitmap.Config config;
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      if (paramDrawable.getOpacity() != -1) {
        config = Bitmap.Config.ARGB_4444;
      } else {
        config = Bitmap.Config.RGB_565;
      } 
      bitmap = Bitmap.createBitmap(i, j, config);
    } 
    Canvas canvas = new Canvas(bitmap);
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    paramDrawable.draw(canvas);
    return bitmap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\ShareBitmapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */