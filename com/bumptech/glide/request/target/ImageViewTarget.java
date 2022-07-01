package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.transition.Transition;

public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements Transition.ViewAdapter {
  private Animatable b;
  
  public ImageViewTarget(ImageView paramImageView) {
    super(paramImageView);
  }
  
  private void b(Z paramZ) {
    a(paramZ);
    c(paramZ);
  }
  
  private void c(Z paramZ) {
    if (paramZ instanceof Animatable) {
      this.b = (Animatable)paramZ;
      this.b.start();
      return;
    } 
    this.b = null;
  }
  
  public void a(Drawable paramDrawable) {
    super.a(paramDrawable);
    b((Z)null);
    e(paramDrawable);
  }
  
  protected abstract void a(Z paramZ);
  
  public void a(Z paramZ, Transition<? super Z> paramTransition) {
    if (paramTransition == null || !paramTransition.a(paramZ, this)) {
      b(paramZ);
      return;
    } 
    c(paramZ);
  }
  
  public void b(Drawable paramDrawable) {
    super.b(paramDrawable);
    b((Z)null);
    e(paramDrawable);
  }
  
  public void c(Drawable paramDrawable) {
    super.c(paramDrawable);
    Animatable animatable = this.b;
    if (animatable != null)
      animatable.stop(); 
    b((Z)null);
    e(paramDrawable);
  }
  
  public Drawable e() {
    return this.a.getDrawable();
  }
  
  public void e(Drawable paramDrawable) {
    this.a.setImageDrawable(paramDrawable);
  }
  
  public void o_() {
    Animatable animatable = this.b;
    if (animatable != null)
      animatable.start(); 
  }
  
  public void p_() {
    Animatable animatable = this.b;
    if (animatable != null)
      animatable.stop(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\target\ImageViewTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */