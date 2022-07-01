package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.widget.ImageView;

public final class ImageViewCompat {
  private static ImageViewCompat$ImageViewCompatImpl IMPL = new ImageViewCompat$BaseViewCompatImpl();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static ColorStateList getImageTintList(ImageView paramImageView) {
    return IMPL.getImageTintList(paramImageView);
  }
  
  public static PorterDuff.Mode getImageTintMode(ImageView paramImageView) {
    return IMPL.getImageTintMode(paramImageView);
  }
  
  public static void setImageTintList(ImageView paramImageView, ColorStateList paramColorStateList) {
    IMPL.setImageTintList(paramImageView, paramColorStateList);
  }
  
  public static void setImageTintMode(ImageView paramImageView, PorterDuff.Mode paramMode) {
    IMPL.setImageTintMode(paramImageView, paramMode);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 21) {
      IMPL = new ImageViewCompat$LollipopViewCompatImpl();
      throw new VerifyError("bad dex opcode");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\widget\ImageViewCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */