package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.WrappedDrawable;
import java.lang.reflect.Field;

public class DrawableUtils {
  public static final Rect INSETS_NONE;
  
  private static final int[] a = new int[] { 16842912 };
  
  private static final int[] b = new int[0];
  
  private static Class<?> c;
  
  static {
    INSETS_NONE = new Rect();
    if (Build.VERSION.SDK_INT >= 18)
      try {
        c = Class.forName("android.graphics.Insets");
        return;
      } catch (ClassNotFoundException classNotFoundException) {
        return;
      }  
  }
  
  static void a(Drawable paramDrawable) {
    if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()))
      b(paramDrawable); 
  }
  
  private static void b(Drawable paramDrawable) {
    int[] arrayOfInt = paramDrawable.getState();
    if (arrayOfInt == null || arrayOfInt.length == 0) {
      paramDrawable.setState(a);
    } else {
      paramDrawable.setState(b);
    } 
    paramDrawable.setState(arrayOfInt);
  }
  
  public static boolean canSafelyMutateDrawable(Drawable paramDrawable) {
    Drawable[] arrayOfDrawable;
    if (Build.VERSION.SDK_INT < 15 && paramDrawable instanceof android.graphics.drawable.InsetDrawable)
      return false; 
    if (Build.VERSION.SDK_INT < 15 && paramDrawable instanceof android.graphics.drawable.GradientDrawable)
      return false; 
    if (Build.VERSION.SDK_INT < 17 && paramDrawable instanceof android.graphics.drawable.LayerDrawable)
      return false; 
    if (paramDrawable instanceof DrawableContainer) {
      Drawable.ConstantState constantState = paramDrawable.getConstantState();
      if (constantState instanceof DrawableContainer.DrawableContainerState) {
        arrayOfDrawable = ((DrawableContainer.DrawableContainerState)constantState).getChildren();
        int j = arrayOfDrawable.length;
        for (int i = 0; i < j; i++) {
          if (!canSafelyMutateDrawable(arrayOfDrawable[i]))
            return false; 
        } 
      } 
    } else {
      if (arrayOfDrawable instanceof WrappedDrawable)
        return canSafelyMutateDrawable(((WrappedDrawable)arrayOfDrawable).getWrappedDrawable()); 
      if (arrayOfDrawable instanceof DrawableWrapper)
        return canSafelyMutateDrawable(((DrawableWrapper)arrayOfDrawable).getWrappedDrawable()); 
      if (arrayOfDrawable instanceof ScaleDrawable)
        return canSafelyMutateDrawable(((ScaleDrawable)arrayOfDrawable).getDrawable()); 
    } 
    return true;
  }
  
  public static Rect getOpticalBounds(Drawable paramDrawable) {
    Insets insets;
    if (Build.VERSION.SDK_INT >= 29) {
      insets = paramDrawable.getOpticalInsets();
      Rect rect = new Rect();
      rect.left = insets.left;
      rect.right = insets.right;
      rect.top = insets.top;
      rect.bottom = insets.bottom;
      return rect;
    } 
    if (c != null)
      try {
        Drawable drawable = DrawableCompat.unwrap((Drawable)insets);
        Object object = drawable.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(drawable, new Object[0]);
        if (object != null) {
          Rect rect = new Rect();
          Field[] arrayOfField = c.getFields();
          int j = arrayOfField.length;
          for (int i = 0;; i++) {
            byte b;
            Field field;
            if (i < j) {
              field = arrayOfField[i];
              String str = field.getName();
              b = -1;
              switch (str.hashCode()) {
                case 108511772:
                  if (str.equals("right"))
                    b = 2; 
                  break;
                case 3317767:
                  if (str.equals("left"))
                    b = 0; 
                  break;
                case 115029:
                  if (str.equals("top"))
                    b = 1; 
                  break;
                case -1383228885:
                  if (str.equals("bottom"))
                    b = 3; 
                  break;
              } 
            } else {
              return rect;
            } 
            if (b != 0) {
              if (b != 1) {
                if (b != 2) {
                  if (b == 3)
                    rect.bottom = field.getInt(object); 
                } else {
                  rect.right = field.getInt(object);
                } 
              } else {
                rect.top = field.getInt(object);
              } 
            } else {
              rect.left = field.getInt(object);
            } 
          } 
        } 
      } catch (Exception exception) {
        Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
      }  
    return INSETS_NONE;
  }
  
  public static PorterDuff.Mode parseTintMode(int paramInt, PorterDuff.Mode paramMode) {
    if (paramInt != 3) {
      if (paramInt != 5) {
        if (paramInt != 9) {
          switch (paramInt) {
            default:
              return paramMode;
            case 16:
              return PorterDuff.Mode.ADD;
            case 15:
              return PorterDuff.Mode.SCREEN;
            case 14:
              break;
          } 
          return PorterDuff.Mode.MULTIPLY;
        } 
        return PorterDuff.Mode.SRC_ATOP;
      } 
      return PorterDuff.Mode.SRC_IN;
    } 
    return PorterDuff.Mode.SRC_OVER;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\DrawableUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */