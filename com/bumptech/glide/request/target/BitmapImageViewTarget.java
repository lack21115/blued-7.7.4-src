package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class BitmapImageViewTarget extends ImageViewTarget<Bitmap> {
  public BitmapImageViewTarget(ImageView paramImageView) {
    super(paramImageView);
  }
  
  protected void a(Bitmap paramBitmap) {
    this.a.setImageBitmap(paramBitmap);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\target\BitmapImageViewTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */