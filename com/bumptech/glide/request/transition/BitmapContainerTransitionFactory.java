package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

public abstract class BitmapContainerTransitionFactory<R> implements TransitionFactory<R> {
  private final TransitionFactory<Drawable> a;
  
  protected abstract Bitmap a(R paramR);
  
  public Transition<R> a(DataSource paramDataSource, boolean paramBoolean) {
    return new BitmapGlideAnimation(this, this.a.a(paramDataSource, paramBoolean));
  }
  
  final class BitmapGlideAnimation implements Transition<R> {
    private final Transition<Drawable> b;
    
    BitmapGlideAnimation(BitmapContainerTransitionFactory this$0, Transition<Drawable> param1Transition) {
      this.b = param1Transition;
    }
    
    public boolean a(R param1R, Transition.ViewAdapter param1ViewAdapter) {
      BitmapDrawable bitmapDrawable = new BitmapDrawable(param1ViewAdapter.h().getResources(), this.a.a(param1R));
      return this.b.a(bitmapDrawable, param1ViewAdapter);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\transition\BitmapContainerTransitionFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */