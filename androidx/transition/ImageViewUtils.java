package androidx.transition;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import java.lang.reflect.Field;

class ImageViewUtils {
  private static boolean a = true;
  
  private static Field b;
  
  private static boolean c;
  
  private static void a() {
    if (!c) {
      try {
        b = ImageView.class.getDeclaredField("mDrawMatrix");
        b.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {}
      c = true;
    } 
  }
  
  static void a(ImageView paramImageView, Matrix paramMatrix) {
    Drawable drawable;
    if (Build.VERSION.SDK_INT >= 29) {
      paramImageView.animateTransform(paramMatrix);
      return;
    } 
    if (paramMatrix == null) {
      drawable = paramImageView.getDrawable();
      if (drawable != null) {
        drawable.setBounds(0, 0, paramImageView.getWidth() - paramImageView.getPaddingLeft() - paramImageView.getPaddingRight(), paramImageView.getHeight() - paramImageView.getPaddingTop() - paramImageView.getPaddingBottom());
        paramImageView.invalidate();
        return;
      } 
    } else {
      Matrix matrix;
      if (Build.VERSION.SDK_INT >= 21) {
        b(paramImageView, (Matrix)drawable);
        return;
      } 
      Drawable drawable1 = paramImageView.getDrawable();
      if (drawable1 != null) {
        drawable1.setBounds(0, 0, drawable1.getIntrinsicWidth(), drawable1.getIntrinsicHeight());
        Drawable drawable2 = null;
        drawable1 = null;
        a();
        Field field = b;
        if (field != null) {
          drawable1 = drawable2;
          try {
            Matrix matrix1 = (Matrix)field.get(paramImageView);
            if (matrix1 == null)
              try {
                Matrix matrix3 = new Matrix();
                Matrix matrix2 = matrix3;
                b.set(paramImageView, matrix3);
                matrix2 = matrix3;
                if (matrix2 != null)
                  matrix2.set((Matrix)drawable); 
              } catch (IllegalAccessException illegalAccessException) {} 
            matrix = matrix1;
          } catch (IllegalAccessException illegalAccessException) {}
        } 
      } else {
        return;
      } 
      if (matrix != null)
        matrix.set((Matrix)drawable); 
    } 
  }
  
  private static void b(ImageView paramImageView, Matrix paramMatrix) {
    if (a)
      try {
        paramImageView.animateTransform(paramMatrix);
        return;
      } catch (NoSuchMethodError noSuchMethodError) {
        a = false;
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\ImageViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */