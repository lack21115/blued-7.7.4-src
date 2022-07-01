package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;

public abstract class ThumbnailImageViewTarget<T> extends ImageViewTarget<T> {
  protected void a(T paramT) {
    ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
    Drawable drawable2 = b(paramT);
    Drawable drawable1 = drawable2;
    if (layoutParams != null) {
      drawable1 = drawable2;
      if (layoutParams.width > 0) {
        drawable1 = drawable2;
        if (layoutParams.height > 0)
          drawable1 = new FixedSizeDrawable(drawable2, layoutParams.width, layoutParams.height); 
      } 
    } 
    this.a.setImageDrawable(drawable1);
  }
  
  protected abstract Drawable b(T paramT);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\target\ThumbnailImageViewTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */