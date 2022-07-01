package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

public abstract class DrawableWrapperApi14$DrawableWrapperState extends Drawable.ConstantState {
  int mChangingConfigurations;
  
  Drawable.ConstantState mDrawableState;
  
  ColorStateList mTint = null;
  
  PorterDuff.Mode mTintMode = DrawableWrapperApi14.DEFAULT_TINT_MODE;
  
  DrawableWrapperApi14$DrawableWrapperState(DrawableWrapperApi14$DrawableWrapperState paramDrawableWrapperApi14$DrawableWrapperState) {
    if (paramDrawableWrapperApi14$DrawableWrapperState != null) {
      this.mChangingConfigurations = paramDrawableWrapperApi14$DrawableWrapperState.mChangingConfigurations;
      this.mDrawableState = paramDrawableWrapperApi14$DrawableWrapperState.mDrawableState;
      this.mTint = paramDrawableWrapperApi14$DrawableWrapperState.mTint;
      this.mTintMode = paramDrawableWrapperApi14$DrawableWrapperState.mTintMode;
    } 
  }
  
  public int getChangingConfigurations() {
    byte b;
    int i = this.mChangingConfigurations;
    if (this.mDrawableState != null) {
      b = this.mDrawableState.getChangingConfigurations();
    } else {
      b = 0;
    } 
    return i | b;
  }
  
  public Drawable newDrawable() {
    return newDrawable(null);
  }
  
  public abstract Drawable newDrawable(Resources paramResources);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\graphics\drawable\DrawableWrapperApi14$DrawableWrapperState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */