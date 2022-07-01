package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

public abstract class DrawableResource<T extends Drawable> implements Initializable, Resource<T> {
  protected final T d;
  
  public DrawableResource(T paramT) {
    this.d = (T)Preconditions.a(paramT);
  }
  
  public void d() {
    T t = this.d;
    if (t instanceof BitmapDrawable) {
      ((BitmapDrawable)t).getBitmap().prepareToDraw();
      return;
    } 
    if (t instanceof GifDrawable)
      ((GifDrawable)t).b().prepareToDraw(); 
  }
  
  public final T e() {
    Drawable.ConstantState constantState = this.d.getConstantState();
    return (T)((constantState == null) ? (Object)this.d : constantState.newDrawable());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\drawable\DrawableResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */