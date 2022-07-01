package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import java.util.concurrent.locks.Lock;

final class DrawableToBitmapConverter {
  private static final BitmapPool a = (BitmapPool)new BitmapPoolAdapter() {
      public void a(Bitmap param1Bitmap) {}
    };
  
  static Resource<Bitmap> a(BitmapPool paramBitmapPool, Drawable paramDrawable, int paramInt1, int paramInt2) {
    Bitmap bitmap;
    paramDrawable = paramDrawable.getCurrent();
    boolean bool1 = paramDrawable instanceof BitmapDrawable;
    boolean bool = false;
    if (bool1) {
      bitmap = ((BitmapDrawable)paramDrawable).getBitmap();
      paramInt1 = bool;
    } else if (!(bitmap instanceof android.graphics.drawable.Animatable)) {
      bitmap = b(paramBitmapPool, (Drawable)bitmap, paramInt1, paramInt2);
      paramInt1 = 1;
    } else {
      bitmap = null;
      paramInt1 = bool;
    } 
    if (paramInt1 == 0)
      paramBitmapPool = a; 
    return BitmapResource.a(bitmap, paramBitmapPool);
  }
  
  private static Bitmap b(BitmapPool paramBitmapPool, Drawable paramDrawable, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder;
    if (paramInt1 == Integer.MIN_VALUE && paramDrawable.getIntrinsicWidth() <= 0) {
      if (Log.isLoggable("DrawableToBitmap", 5)) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to draw ");
        stringBuilder.append(paramDrawable);
        stringBuilder.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
        Log.w("DrawableToBitmap", stringBuilder.toString());
      } 
      return null;
    } 
    if (paramInt2 == Integer.MIN_VALUE && paramDrawable.getIntrinsicHeight() <= 0) {
      if (Log.isLoggable("DrawableToBitmap", 5)) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to draw ");
        stringBuilder.append(paramDrawable);
        stringBuilder.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
        Log.w("DrawableToBitmap", stringBuilder.toString());
      } 
      return null;
    } 
    if (paramDrawable.getIntrinsicWidth() > 0)
      paramInt1 = paramDrawable.getIntrinsicWidth(); 
    if (paramDrawable.getIntrinsicHeight() > 0)
      paramInt2 = paramDrawable.getIntrinsicHeight(); 
    Lock lock = TransformationUtils.a();
    lock.lock();
    null = stringBuilder.a(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    try {
      Canvas canvas = new Canvas(null);
      paramDrawable.setBounds(0, 0, paramInt1, paramInt2);
      paramDrawable.draw(canvas);
      canvas.setBitmap(null);
      return null;
    } finally {
      lock.unlock();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\bitmap\DrawableToBitmapConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */