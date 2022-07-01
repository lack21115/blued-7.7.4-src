package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

class AppCompatBackgroundHelper {
  private final View a;
  
  private final AppCompatDrawableManager b;
  
  private int c = -1;
  
  private TintInfo d;
  
  private TintInfo e;
  
  private TintInfo f;
  
  AppCompatBackgroundHelper(View paramView) {
    this.a = paramView;
    this.b = AppCompatDrawableManager.get();
  }
  
  private boolean b(Drawable paramDrawable) {
    if (this.f == null)
      this.f = new TintInfo(); 
    TintInfo tintInfo = this.f;
    tintInfo.a();
    ColorStateList colorStateList = ViewCompat.getBackgroundTintList(this.a);
    if (colorStateList != null) {
      tintInfo.mHasTintList = true;
      tintInfo.mTintList = colorStateList;
    } 
    PorterDuff.Mode mode = ViewCompat.getBackgroundTintMode(this.a);
    if (mode != null) {
      tintInfo.mHasTintMode = true;
      tintInfo.mTintMode = mode;
    } 
    if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
      AppCompatDrawableManager.a(paramDrawable, tintInfo, this.a.getDrawableState());
      return true;
    } 
    return false;
  }
  
  private boolean d() {
    int i = Build.VERSION.SDK_INT;
    return (i > 21) ? ((this.d != null)) : ((i == 21));
  }
  
  ColorStateList a() {
    TintInfo tintInfo = this.e;
    return (tintInfo != null) ? tintInfo.mTintList : null;
  }
  
  void a(int paramInt) {
    this.c = paramInt;
    AppCompatDrawableManager appCompatDrawableManager = this.b;
    if (appCompatDrawableManager != null) {
      ColorStateList colorStateList = appCompatDrawableManager.a(this.a.getContext(), paramInt);
    } else {
      appCompatDrawableManager = null;
    } 
    b((ColorStateList)appCompatDrawableManager);
    c();
  }
  
  void a(ColorStateList paramColorStateList) {
    if (this.e == null)
      this.e = new TintInfo(); 
    TintInfo tintInfo = this.e;
    tintInfo.mTintList = paramColorStateList;
    tintInfo.mHasTintList = true;
    c();
  }
  
  void a(PorterDuff.Mode paramMode) {
    if (this.e == null)
      this.e = new TintInfo(); 
    TintInfo tintInfo = this.e;
    tintInfo.mTintMode = paramMode;
    tintInfo.mHasTintMode = true;
    c();
  }
  
  void a(Drawable paramDrawable) {
    this.c = -1;
    b((ColorStateList)null);
    c();
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt) {
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(this.a.getContext(), paramAttributeSet, R.styleable.ViewBackgroundHelper, paramInt, 0);
    try {
      if (tintTypedArray.hasValue(R.styleable.ViewBackgroundHelper_android_background)) {
        this.c = tintTypedArray.getResourceId(R.styleable.ViewBackgroundHelper_android_background, -1);
        ColorStateList colorStateList = this.b.a(this.a.getContext(), this.c);
        if (colorStateList != null)
          b(colorStateList); 
      } 
      if (tintTypedArray.hasValue(R.styleable.ViewBackgroundHelper_backgroundTint))
        ViewCompat.setBackgroundTintList(this.a, tintTypedArray.getColorStateList(R.styleable.ViewBackgroundHelper_backgroundTint)); 
      if (tintTypedArray.hasValue(R.styleable.ViewBackgroundHelper_backgroundTintMode))
        ViewCompat.setBackgroundTintMode(this.a, DrawableUtils.parseTintMode(tintTypedArray.getInt(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null)); 
      return;
    } finally {
      tintTypedArray.recycle();
    } 
  }
  
  PorterDuff.Mode b() {
    TintInfo tintInfo = this.e;
    return (tintInfo != null) ? tintInfo.mTintMode : null;
  }
  
  void b(ColorStateList paramColorStateList) {
    if (paramColorStateList != null) {
      if (this.d == null)
        this.d = new TintInfo(); 
      TintInfo tintInfo = this.d;
      tintInfo.mTintList = paramColorStateList;
      tintInfo.mHasTintList = true;
    } else {
      this.d = null;
    } 
    c();
  }
  
  void c() {
    Drawable drawable = this.a.getBackground();
    if (drawable != null) {
      if (d() && b(drawable))
        return; 
      TintInfo tintInfo = this.e;
      if (tintInfo != null) {
        AppCompatDrawableManager.a(drawable, tintInfo, this.a.getDrawableState());
        return;
      } 
      tintInfo = this.d;
      if (tintInfo != null)
        AppCompatDrawableManager.a(drawable, tintInfo, this.a.getDrawableState()); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\AppCompatBackgroundHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */