package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

public class DrawableCrossFadeTransition implements Transition<Drawable> {
  private final int a;
  
  private final boolean b;
  
  public DrawableCrossFadeTransition(int paramInt, boolean paramBoolean) {
    this.a = paramInt;
    this.b = paramBoolean;
  }
  
  public boolean a(Drawable paramDrawable, Transition.ViewAdapter paramViewAdapter) {
    ColorDrawable colorDrawable;
    Drawable drawable2 = paramViewAdapter.e();
    Drawable drawable1 = drawable2;
    if (drawable2 == null)
      colorDrawable = new ColorDrawable(0); 
    TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[] { (Drawable)colorDrawable, paramDrawable });
    transitionDrawable.setCrossFadeEnabled(this.b);
    transitionDrawable.startTransition(this.a);
    paramViewAdapter.e((Drawable)transitionDrawable);
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\transition\DrawableCrossFadeTransition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */