package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;

public final class DrawableTransitionOptions extends TransitionOptions<DrawableTransitionOptions, Drawable> {
  public static DrawableTransitionOptions a(int paramInt) {
    return (new DrawableTransitionOptions()).b(paramInt);
  }
  
  public static DrawableTransitionOptions a(DrawableCrossFadeFactory paramDrawableCrossFadeFactory) {
    return (new DrawableTransitionOptions()).b(paramDrawableCrossFadeFactory);
  }
  
  public DrawableTransitionOptions a(DrawableCrossFadeFactory.Builder paramBuilder) {
    return b(paramBuilder.a());
  }
  
  public DrawableTransitionOptions b(int paramInt) {
    return a(new DrawableCrossFadeFactory.Builder(paramInt));
  }
  
  public DrawableTransitionOptions b(DrawableCrossFadeFactory paramDrawableCrossFadeFactory) {
    return (DrawableTransitionOptions)a((TransitionFactory)paramDrawableCrossFadeFactory);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\drawable\DrawableTransitionOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */