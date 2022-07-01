package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.ImageViewCompat;

public class AppCompatImageHelper {
  private final ImageView a;
  
  private TintInfo b;
  
  private TintInfo c;
  
  private TintInfo d;
  
  public AppCompatImageHelper(ImageView paramImageView) {
    this.a = paramImageView;
  }
  
  private boolean a(Drawable paramDrawable) {
    if (this.d == null)
      this.d = new TintInfo(); 
    TintInfo tintInfo = this.d;
    tintInfo.a();
    ColorStateList colorStateList = ImageViewCompat.getImageTintList(this.a);
    if (colorStateList != null) {
      tintInfo.mHasTintList = true;
      tintInfo.mTintList = colorStateList;
    } 
    PorterDuff.Mode mode = ImageViewCompat.getImageTintMode(this.a);
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
  
  private boolean e() {
    int i = Build.VERSION.SDK_INT;
    return (i > 21) ? ((this.b != null)) : ((i == 21));
  }
  
  void a(ColorStateList paramColorStateList) {
    if (this.c == null)
      this.c = new TintInfo(); 
    TintInfo tintInfo = this.c;
    tintInfo.mTintList = paramColorStateList;
    tintInfo.mHasTintList = true;
    d();
  }
  
  void a(PorterDuff.Mode paramMode) {
    if (this.c == null)
      this.c = new TintInfo(); 
    TintInfo tintInfo = this.c;
    tintInfo.mTintMode = paramMode;
    tintInfo.mHasTintMode = true;
    d();
  }
  
  boolean a() {
    Drawable drawable = this.a.getBackground();
    return !(Build.VERSION.SDK_INT >= 21 && drawable instanceof android.graphics.drawable.RippleDrawable);
  }
  
  ColorStateList b() {
    TintInfo tintInfo = this.c;
    return (tintInfo != null) ? tintInfo.mTintList : null;
  }
  
  PorterDuff.Mode c() {
    TintInfo tintInfo = this.c;
    return (tintInfo != null) ? tintInfo.mTintMode : null;
  }
  
  void d() {
    Drawable drawable = this.a.getDrawable();
    if (drawable != null)
      DrawableUtils.a(drawable); 
    if (drawable != null) {
      if (e() && a(drawable))
        return; 
      TintInfo tintInfo = this.c;
      if (tintInfo != null) {
        AppCompatDrawableManager.a(drawable, tintInfo, this.a.getDrawableState());
        return;
      } 
      tintInfo = this.b;
      if (tintInfo != null)
        AppCompatDrawableManager.a(drawable, tintInfo, this.a.getDrawableState()); 
    } 
  }
  
  public void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt) {
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(this.a.getContext(), paramAttributeSet, R.styleable.AppCompatImageView, paramInt, 0);
    try {
      Drawable drawable2 = this.a.getDrawable();
      Drawable drawable1 = drawable2;
      if (drawable2 == null) {
        paramInt = tintTypedArray.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1);
        drawable1 = drawable2;
        if (paramInt != -1) {
          drawable2 = AppCompatResources.getDrawable(this.a.getContext(), paramInt);
          drawable1 = drawable2;
          if (drawable2 != null) {
            this.a.setImageDrawable(drawable2);
            drawable1 = drawable2;
          } 
        } 
      } 
      if (drawable1 != null)
        DrawableUtils.a(drawable1); 
      if (tintTypedArray.hasValue(R.styleable.AppCompatImageView_tint))
        ImageViewCompat.setImageTintList(this.a, tintTypedArray.getColorStateList(R.styleable.AppCompatImageView_tint)); 
      if (tintTypedArray.hasValue(R.styleable.AppCompatImageView_tintMode))
        ImageViewCompat.setImageTintMode(this.a, DrawableUtils.parseTintMode(tintTypedArray.getInt(R.styleable.AppCompatImageView_tintMode, -1), null)); 
      return;
    } finally {
      tintTypedArray.recycle();
    } 
  }
  
  public void setImageResource(int paramInt) {
    if (paramInt != 0) {
      Drawable drawable = AppCompatResources.getDrawable(this.a.getContext(), paramInt);
      if (drawable != null)
        DrawableUtils.a(drawable); 
      this.a.setImageDrawable(drawable);
    } else {
      this.a.setImageDrawable(null);
    } 
    d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\AppCompatImageHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */