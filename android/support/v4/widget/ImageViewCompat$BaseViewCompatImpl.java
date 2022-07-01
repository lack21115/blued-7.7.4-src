package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.ImageView;

class ImageViewCompat$BaseViewCompatImpl implements ImageViewCompat$ImageViewCompatImpl {
  public ColorStateList getImageTintList(ImageView paramImageView) {
    return (paramImageView instanceof TintableImageSourceView) ? ((TintableImageSourceView)paramImageView).getSupportImageTintList() : null;
  }
  
  public PorterDuff.Mode getImageTintMode(ImageView paramImageView) {
    return (paramImageView instanceof TintableImageSourceView) ? ((TintableImageSourceView)paramImageView).getSupportImageTintMode() : null;
  }
  
  public void setImageTintList(ImageView paramImageView, ColorStateList paramColorStateList) {
    if (paramImageView instanceof TintableImageSourceView)
      ((TintableImageSourceView)paramImageView).setSupportImageTintList(paramColorStateList); 
  }
  
  public void setImageTintMode(ImageView paramImageView, PorterDuff.Mode paramMode) {
    if (paramImageView instanceof TintableImageSourceView)
      ((TintableImageSourceView)paramImageView).setSupportImageTintMode(paramMode); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\widget\ImageViewCompat$BaseViewCompatImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */