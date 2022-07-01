package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

public abstract class RefreshDrawable extends Drawable implements Animatable, Drawable.Callback {
  private PullRefreshLayout a;
  
  public RefreshDrawable(Context paramContext, PullRefreshLayout paramPullRefreshLayout) {
    this.a = paramPullRefreshLayout;
  }
  
  public abstract void a(int[] paramArrayOfint);
  
  public Context c() {
    PullRefreshLayout pullRefreshLayout = this.a;
    return (pullRefreshLayout != null) ? pullRefreshLayout.getContext() : null;
  }
  
  public abstract void c(float paramFloat);
  
  public abstract void c(int paramInt);
  
  public PullRefreshLayout d() {
    return this.a;
  }
  
  public int getOpacity() {
    return -3;
  }
  
  public void invalidateDrawable(Drawable paramDrawable) {
    Drawable.Callback callback = getCallback();
    if (callback != null)
      callback.invalidateDrawable(this); 
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {
    Drawable.Callback callback = getCallback();
    if (callback != null)
      callback.scheduleDrawable(this, paramRunnable, paramLong); 
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {
    Drawable.Callback callback = getCallback();
    if (callback != null)
      callback.unscheduleDrawable(this, paramRunnable); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\RefreshDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */