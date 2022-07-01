package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

interface LruPoolStrategy {
  Bitmap a();
  
  Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
  
  void a(Bitmap paramBitmap);
  
  String b(int paramInt1, int paramInt2, Bitmap.Config paramConfig);
  
  String b(Bitmap paramBitmap);
  
  int c(Bitmap paramBitmap);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\bitmap_recycle\LruPoolStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */