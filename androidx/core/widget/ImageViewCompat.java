package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

public class ImageViewCompat {
  public static ColorStateList getImageTintList(ImageView paramImageView) {
    return (Build.VERSION.SDK_INT >= 21) ? paramImageView.getImageTintList() : ((paramImageView instanceof TintableImageSourceView) ? ((TintableImageSourceView)paramImageView).getSupportImageTintList() : null);
  }
  
  public static PorterDuff.Mode getImageTintMode(ImageView paramImageView) {
    return (Build.VERSION.SDK_INT >= 21) ? paramImageView.getImageTintMode() : ((paramImageView instanceof TintableImageSourceView) ? ((TintableImageSourceView)paramImageView).getSupportImageTintMode() : null);
  }
  
  public static void setImageTintList(ImageView paramImageView, ColorStateList paramColorStateList) {
    Drawable drawable;
    if (Build.VERSION.SDK_INT >= 21) {
      paramImageView.setImageTintList(paramColorStateList);
      if (Build.VERSION.SDK_INT == 21) {
        drawable = paramImageView.getDrawable();
        if (drawable != null && paramImageView.getImageTintList() != null) {
          if (drawable.isStateful())
            drawable.setState(paramImageView.getDrawableState()); 
          paramImageView.setImageDrawable(drawable);
          return;
        } 
      } 
    } else if (paramImageView instanceof TintableImageSourceView) {
      ((TintableImageSourceView)paramImageView).setSupportImageTintList((ColorStateList)drawable);
    } 
  }
  
  public static void setImageTintMode(ImageView paramImageView, PorterDuff.Mode paramMode) {
    Drawable drawable;
    if (Build.VERSION.SDK_INT >= 21) {
      paramImageView.setImageTintMode(paramMode);
      if (Build.VERSION.SDK_INT == 21) {
        drawable = paramImageView.getDrawable();
        if (drawable != null && paramImageView.getImageTintList() != null) {
          if (drawable.isStateful())
            drawable.setState(paramImageView.getDrawableState()); 
          paramImageView.setImageDrawable(drawable);
          return;
        } 
      } 
    } else if (paramImageView instanceof TintableImageSourceView) {
      ((TintableImageSourceView)paramImageView).setSupportImageTintMode((PorterDuff.Mode)drawable);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\widget\ImageViewCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */