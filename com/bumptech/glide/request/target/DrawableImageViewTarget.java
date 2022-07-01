package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class DrawableImageViewTarget extends ImageViewTarget<Drawable> {
  public DrawableImageViewTarget(ImageView paramImageView) {
    super(paramImageView);
  }
  
  protected void d(Drawable paramDrawable) {
    this.a.setImageDrawable(paramDrawable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\target\DrawableImageViewTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */