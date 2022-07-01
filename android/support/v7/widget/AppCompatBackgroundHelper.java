package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;

final class AppCompatBackgroundHelper {
  private int mBackgroundResId = -1;
  
  private TintInfo mBackgroundTint;
  
  private final AppCompatDrawableManager mDrawableManager;
  
  private TintInfo mInternalBackgroundTint;
  
  private TintInfo mTmpInfo;
  
  private final View mView;
  
  AppCompatBackgroundHelper(View paramView) {
    this.mView = paramView;
    this.mDrawableManager = AppCompatDrawableManager.get();
  }
  
  private void setInternalBackgroundTint(ColorStateList paramColorStateList) {
    if (paramColorStateList != null) {
      if (this.mInternalBackgroundTint == null)
        this.mInternalBackgroundTint = new TintInfo(); 
      this.mInternalBackgroundTint.mTintList = paramColorStateList;
      this.mInternalBackgroundTint.mHasTintList = true;
    } else {
      this.mInternalBackgroundTint = null;
    } 
    applySupportBackgroundTint();
  }
  
  final void applySupportBackgroundTint() {
    Drawable drawable = this.mView.getBackground();
    if (drawable != null) {
      int i = Build.VERSION.SDK_INT;
      boolean bool = false;
      if ((i > 21) ? (this.mInternalBackgroundTint != null) : (i == 21)) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i != 0) {
        if (this.mTmpInfo == null)
          this.mTmpInfo = new TintInfo(); 
        TintInfo tintInfo = this.mTmpInfo;
        tintInfo.clear();
        ColorStateList colorStateList = ViewCompat.getBackgroundTintList(this.mView);
        if (colorStateList != null) {
          tintInfo.mHasTintList = true;
          tintInfo.mTintList = colorStateList;
        } 
        PorterDuff.Mode mode = ViewCompat.getBackgroundTintMode(this.mView);
        if (mode != null) {
          tintInfo.mHasTintMode = true;
          tintInfo.mTintMode = mode;
        } 
        if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
          AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
          i = 1;
        } else {
          i = bool;
        } 
        if (i != 0)
          return; 
      } 
      if (this.mBackgroundTint != null) {
        AppCompatDrawableManager.tintDrawable(drawable, this.mBackgroundTint, this.mView.getDrawableState());
        return;
      } 
      if (this.mInternalBackgroundTint != null)
        AppCompatDrawableManager.tintDrawable(drawable, this.mInternalBackgroundTint, this.mView.getDrawableState()); 
    } 
  }
  
  final ColorStateList getSupportBackgroundTintList() {
    return (this.mBackgroundTint != null) ? this.mBackgroundTint.mTintList : null;
  }
  
  final PorterDuff.Mode getSupportBackgroundTintMode() {
    return (this.mBackgroundTint != null) ? this.mBackgroundTint.mTintMode : null;
  }
  
  final void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt) {
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), paramAttributeSet, R.styleable.ViewBackgroundHelper, paramInt, 0);
    try {
      if (tintTypedArray.hasValue(R.styleable.ViewBackgroundHelper_android_background)) {
        this.mBackgroundResId = tintTypedArray.getResourceId(R.styleable.ViewBackgroundHelper_android_background, -1);
        ColorStateList colorStateList = this.mDrawableManager.getTintList(this.mView.getContext(), this.mBackgroundResId);
        if (colorStateList != null)
          setInternalBackgroundTint(colorStateList); 
      } 
      if (tintTypedArray.hasValue(R.styleable.ViewBackgroundHelper_backgroundTint))
        ViewCompat.setBackgroundTintList(this.mView, tintTypedArray.getColorStateList(R.styleable.ViewBackgroundHelper_backgroundTint)); 
      if (tintTypedArray.hasValue(R.styleable.ViewBackgroundHelper_backgroundTintMode))
        ViewCompat.setBackgroundTintMode(this.mView, DrawableUtils.parseTintMode(tintTypedArray.getInt(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null)); 
      return;
    } finally {
      tintTypedArray.mWrapped.recycle();
    } 
  }
  
  final void onSetBackgroundDrawable$130e17e7() {
    this.mBackgroundResId = -1;
    setInternalBackgroundTint(null);
    applySupportBackgroundTint();
  }
  
  final void onSetBackgroundResource(int paramInt) {
    ColorStateList colorStateList;
    this.mBackgroundResId = paramInt;
    if (this.mDrawableManager != null) {
      colorStateList = this.mDrawableManager.getTintList(this.mView.getContext(), paramInt);
    } else {
      colorStateList = null;
    } 
    setInternalBackgroundTint(colorStateList);
    applySupportBackgroundTint();
  }
  
  final void setSupportBackgroundTintList(ColorStateList paramColorStateList) {
    if (this.mBackgroundTint == null)
      this.mBackgroundTint = new TintInfo(); 
    this.mBackgroundTint.mTintList = paramColorStateList;
    this.mBackgroundTint.mHasTintList = true;
    applySupportBackgroundTint();
  }
  
  final void setSupportBackgroundTintMode(PorterDuff.Mode paramMode) {
    if (this.mBackgroundTint == null)
      this.mBackgroundTint = new TintInfo(); 
    this.mBackgroundTint.mTintMode = paramMode;
    this.mBackgroundTint.mHasTintMode = true;
    applySupportBackgroundTint();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\AppCompatBackgroundHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */