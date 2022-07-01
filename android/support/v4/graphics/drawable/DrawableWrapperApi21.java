package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

final class DrawableWrapperApi21 extends DrawableWrapperApi19 {
  private static Method sIsProjectedDrawableMethod;
  
  DrawableWrapperApi21(Drawable paramDrawable) {
    super(paramDrawable);
    findAndCacheIsProjectedDrawableMethod();
  }
  
  DrawableWrapperApi21(DrawableWrapperApi14$DrawableWrapperState paramDrawableWrapperApi14$DrawableWrapperState, Resources paramResources) {
    super(paramDrawableWrapperApi14$DrawableWrapperState, paramResources);
    findAndCacheIsProjectedDrawableMethod();
  }
  
  private static void findAndCacheIsProjectedDrawableMethod() {
    if (sIsProjectedDrawableMethod == null)
      try {
        sIsProjectedDrawableMethod = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
        return;
      } catch (Exception exception) {
        Log.w("DrawableWrapperApi21", "Failed to retrieve Drawable#isProjected() method", exception);
      }  
  }
  
  public final Rect getDirtyBounds() {
    return this.mDrawable.getDirtyBounds();
  }
  
  public final void getOutline(Outline paramOutline) {
    this.mDrawable.getOutline(paramOutline);
  }
  
  protected final boolean isCompatTintEnabled() {
    if (Build.VERSION.SDK_INT == 21) {
      Drawable drawable = this.mDrawable;
      return (drawable instanceof android.graphics.drawable.GradientDrawable || drawable instanceof android.graphics.drawable.DrawableContainer || drawable instanceof android.graphics.drawable.InsetDrawable || drawable instanceof android.graphics.drawable.RippleDrawable);
    } 
    return false;
  }
  
  final DrawableWrapperApi14$DrawableWrapperState mutateConstantState() {
    return new DrawableWrapperApi21$DrawableWrapperStateLollipop(this.mState);
  }
  
  public final void setHotspot(float paramFloat1, float paramFloat2) {
    this.mDrawable.setHotspot(paramFloat1, paramFloat2);
  }
  
  public final void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final boolean setState(int[] paramArrayOfint) {
    if (super.setState(paramArrayOfint)) {
      invalidateSelf();
      return true;
    } 
    return false;
  }
  
  public final void setTint(int paramInt) {
    if (isCompatTintEnabled()) {
      super.setTint(paramInt);
      return;
    } 
    this.mDrawable.setTint(paramInt);
  }
  
  public final void setTintList(ColorStateList paramColorStateList) {
    if (isCompatTintEnabled()) {
      super.setTintList(paramColorStateList);
      return;
    } 
    this.mDrawable.setTintList(paramColorStateList);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode) {
    if (isCompatTintEnabled()) {
      super.setTintMode(paramMode);
      return;
    } 
    this.mDrawable.setTintMode(paramMode);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\graphics\drawable\DrawableWrapperApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */