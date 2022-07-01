package android.support.v7.widget;

import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.support.v7.graphics.drawable.DrawableWrapper;

public final class DrawableUtils {
  static {
    new Rect();
    if (Build.VERSION.SDK_INT >= 18)
      try {
        Class.forName("android.graphics.Insets");
        throw new VerifyError("bad dex opcode");
      } catch (ClassNotFoundException classNotFoundException) {} 
    throw new VerifyError("bad dex opcode");
  }
  
  public static boolean canSafelyMutateDrawable(Drawable paramDrawable) {
    while (true) {
      Drawable[] arrayOfDrawable;
      Drawable drawable;
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
        break;
      } 
      if (arrayOfDrawable instanceof DrawableWrapper) {
        drawable = ((DrawableWrapper)arrayOfDrawable).getWrappedDrawable();
        continue;
      } 
      if (drawable instanceof DrawableWrapper) {
        drawable = ((DrawableWrapper)drawable).mDrawable;
        continue;
      } 
      if (drawable instanceof ScaleDrawable) {
        drawable = ((ScaleDrawable)drawable).getDrawable();
        continue;
      } 
      break;
    } 
    return true;
  }
  
  static void fixDrawable(Drawable paramDrawable) {
    if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName())) {
      int[] arrayOfInt = paramDrawable.getState();
      if (arrayOfInt == null || arrayOfInt.length == 0) {
        paramDrawable.setState(ThemeUtils.CHECKED_STATE_SET);
      } else {
        paramDrawable.setState(ThemeUtils.EMPTY_STATE_SET);
      } 
      paramDrawable.setState(arrayOfInt);
    } 
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\DrawableUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */