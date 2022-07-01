package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class BitmapThumbnailImageViewTarget extends ThumbnailImageViewTarget<Bitmap> {
  protected Drawable a(Bitmap paramBitmap) {
    return (Drawable)new BitmapDrawable(this.a.getResources(), paramBitmap);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\target\BitmapThumbnailImageViewTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */