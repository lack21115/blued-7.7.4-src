package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

final class ImageViewCompat$LollipopViewCompatImpl extends ImageViewCompat$BaseViewCompatImpl {
  public final ColorStateList getImageTintList(ImageView paramImageView) {
    return paramImageView.getImageTintList();
  }
  
  public final PorterDuff.Mode getImageTintMode(ImageView paramImageView) {
    return paramImageView.getImageTintMode();
  }
  
  public final void setImageTintList(ImageView paramImageView, ColorStateList paramColorStateList) {
    paramImageView.setImageTintList(paramColorStateList);
    if (Build.VERSION.SDK_INT == 21) {
      boolean bool;
      Drawable drawable = paramImageView.getDrawable();
      if (paramImageView.getImageTintList() != null && paramImageView.getImageTintMode() != null) {
        bool = true;
      } else {
        bool = false;
      } 
      if (drawable != null && bool) {
        if (drawable.isStateful())
          drawable.setState(paramImageView.getDrawableState()); 
        paramImageView.setImageDrawable(drawable);
      } 
    } 
  }
  
  public final void setImageTintMode(ImageView paramImageView, PorterDuff.Mode paramMode) {
    paramImageView.setImageTintMode(paramMode);
    if (Build.VERSION.SDK_INT == 21) {
      boolean bool;
      Drawable drawable = paramImageView.getDrawable();
      if (paramImageView.getImageTintList() != null && paramImageView.getImageTintMode() != null) {
        bool = true;
      } else {
        bool = false;
      } 
      if (drawable != null && bool) {
        if (drawable.isStateful())
          drawable.setState(paramImageView.getDrawableState()); 
        paramImageView.setImageDrawable(drawable);
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\widget\ImageViewCompat$LollipopViewCompatImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */