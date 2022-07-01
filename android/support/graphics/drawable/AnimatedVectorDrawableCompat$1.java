package android.support.graphics.drawable;

import android.graphics.drawable.Drawable;

final class AnimatedVectorDrawableCompat$1 implements Drawable.Callback {
  public final void invalidateDrawable(Drawable paramDrawable) {
    AnimatedVectorDrawableCompat.this.invalidateSelf();
  }
  
  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {
    AnimatedVectorDrawableCompat.this.scheduleSelf(paramRunnable, paramLong);
  }
  
  public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {
    AnimatedVectorDrawableCompat.this.unscheduleSelf(paramRunnable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\graphics\drawable\AnimatedVectorDrawableCompat$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */