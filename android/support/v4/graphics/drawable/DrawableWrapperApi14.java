package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

class DrawableWrapperApi14 extends Drawable implements Drawable.Callback, DrawableWrapper, TintAwareDrawable {
  static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
  
  private boolean mColorFilterSet;
  
  private int mCurrentColor;
  
  private PorterDuff.Mode mCurrentMode;
  
  Drawable mDrawable;
  
  private boolean mMutated;
  
  DrawableWrapperApi14$DrawableWrapperState mState = mutateConstantState();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  DrawableWrapperApi14(Drawable paramDrawable) {
    setWrappedDrawable(paramDrawable);
  }
  
  DrawableWrapperApi14(DrawableWrapperApi14$DrawableWrapperState paramDrawableWrapperApi14$DrawableWrapperState, Resources paramResources) {
    if (this.mState != null && this.mState.mDrawableState != null)
      setWrappedDrawable(this.mState.mDrawableState.newDrawable(paramResources)); 
  }
  
  private void setWrappedDrawable(Drawable paramDrawable) {
    if (this.mDrawable != null)
      this.mDrawable.setCallback(null); 
    this.mDrawable = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
      setVisible(paramDrawable.isVisible(), true);
      setState(paramDrawable.getState());
      setLevel(paramDrawable.getLevel());
      setBounds(paramDrawable.getBounds());
      if (this.mState != null)
        this.mState.mDrawableState = paramDrawable.getConstantState(); 
    } 
    invalidateSelf();
  }
  
  private boolean updateTint(int[] paramArrayOfint) {
    if (!isCompatTintEnabled())
      return false; 
    ColorStateList colorStateList = this.mState.mTint;
    PorterDuff.Mode mode = this.mState.mTintMode;
    if (colorStateList != null && mode != null) {
      int i = colorStateList.getColorForState(paramArrayOfint, colorStateList.getDefaultColor());
      if (!this.mColorFilterSet || i != this.mCurrentColor || mode != this.mCurrentMode) {
        setColorFilter(i, mode);
        this.mCurrentColor = i;
        this.mCurrentMode = mode;
        this.mColorFilterSet = true;
        return true;
      } 
      return false;
    } 
    this.mColorFilterSet = false;
    clearColorFilter();
    return false;
  }
  
  public void draw(Canvas paramCanvas) {
    this.mDrawable.draw(paramCanvas);
  }
  
  public int getChangingConfigurations() {
    byte b;
    int i = super.getChangingConfigurations();
    if (this.mState != null) {
      b = this.mState.getChangingConfigurations();
    } else {
      b = 0;
    } 
    return i | b | this.mDrawable.getChangingConfigurations();
  }
  
  public Drawable.ConstantState getConstantState() {
    if (this.mState != null) {
      boolean bool;
      if (this.mState.mDrawableState != null) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        this.mState.mChangingConfigurations = getChangingConfigurations();
        return this.mState;
      } 
    } 
    return null;
  }
  
  public Drawable getCurrent() {
    return this.mDrawable.getCurrent();
  }
  
  public int getIntrinsicHeight() {
    return this.mDrawable.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth() {
    return this.mDrawable.getIntrinsicWidth();
  }
  
  public int getMinimumHeight() {
    return this.mDrawable.getMinimumHeight();
  }
  
  public int getMinimumWidth() {
    return this.mDrawable.getMinimumWidth();
  }
  
  public int getOpacity() {
    return this.mDrawable.getOpacity();
  }
  
  public boolean getPadding(Rect paramRect) {
    return this.mDrawable.getPadding(paramRect);
  }
  
  public int[] getState() {
    return this.mDrawable.getState();
  }
  
  public Region getTransparentRegion() {
    return this.mDrawable.getTransparentRegion();
  }
  
  public final Drawable getWrappedDrawable() {
    return this.mDrawable;
  }
  
  public void invalidateDrawable(Drawable paramDrawable) {
    invalidateSelf();
  }
  
  protected boolean isCompatTintEnabled() {
    return true;
  }
  
  public boolean isStateful() {
    ColorStateList colorStateList;
    if (isCompatTintEnabled() && this.mState != null) {
      colorStateList = this.mState.mTint;
    } else {
      colorStateList = null;
    } 
    return ((colorStateList != null && colorStateList.isStateful()) || this.mDrawable.isStateful());
  }
  
  public void jumpToCurrentState() {
    this.mDrawable.jumpToCurrentState();
  }
  
  public Drawable mutate() {
    if (!this.mMutated && super.mutate() == this) {
      this.mState = mutateConstantState();
      if (this.mDrawable != null)
        this.mDrawable.mutate(); 
      if (this.mState != null) {
        Drawable.ConstantState constantState;
        DrawableWrapperApi14$DrawableWrapperState drawableWrapperApi14$DrawableWrapperState = this.mState;
        if (this.mDrawable != null) {
          constantState = this.mDrawable.getConstantState();
        } else {
          constantState = null;
        } 
        drawableWrapperApi14$DrawableWrapperState.mDrawableState = constantState;
      } 
      this.mMutated = true;
    } 
    return this;
  }
  
  DrawableWrapperApi14$DrawableWrapperState mutateConstantState() {
    return new DrawableWrapperApi14$DrawableWrapperStateBase(this.mState);
  }
  
  protected void onBoundsChange(Rect paramRect) {
    if (this.mDrawable != null)
      this.mDrawable.setBounds(paramRect); 
  }
  
  protected boolean onLevelChange(int paramInt) {
    return this.mDrawable.setLevel(paramInt);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt) {
    this.mDrawable.setAlpha(paramInt);
  }
  
  public void setChangingConfigurations(int paramInt) {
    this.mDrawable.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {
    this.mDrawable.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean) {
    this.mDrawable.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean) {
    this.mDrawable.setFilterBitmap(paramBoolean);
  }
  
  public boolean setState(int[] paramArrayOfint) {
    boolean bool = this.mDrawable.setState(paramArrayOfint);
    return (updateTint(paramArrayOfint) || bool);
  }
  
  public void setTint(int paramInt) {
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList) {
    this.mState.mTint = paramColorStateList;
    updateTint(getState());
  }
  
  public void setTintMode(PorterDuff.Mode paramMode) {
    this.mState.mTintMode = paramMode;
    updateTint(getState());
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2) {
    return (super.setVisible(paramBoolean1, paramBoolean2) || this.mDrawable.setVisible(paramBoolean1, paramBoolean2));
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {
    unscheduleSelf(paramRunnable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\graphics\drawable\DrawableWrapperApi14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */