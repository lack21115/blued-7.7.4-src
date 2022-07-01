package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

public class BitmapPoolAdapter implements BitmapPool {
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
    return Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(Bitmap paramBitmap) {
    paramBitmap.recycle();
  }
  
  public Bitmap b(int paramInt1, int paramInt2, Bitmap.Config paramConfig) {
    return a(paramInt1, paramInt2, paramConfig);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\bitmap_recycle\BitmapPoolAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */