package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

public final class ViewCompat {
  private static ViewCompat$ViewCompatBaseImpl IMPL = new ViewCompat$ViewCompatBaseImpl();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static ColorStateList getBackgroundTintList(View paramView) {
    return IMPL.getBackgroundTintList(paramView);
  }
  
  public static PorterDuff.Mode getBackgroundTintMode(View paramView) {
    return IMPL.getBackgroundTintMode(paramView);
  }
  
  public static int getLayoutDirection(View paramView) {
    return IMPL.getLayoutDirection(paramView);
  }
  
  public static int getMinimumHeight(View paramView) {
    return IMPL.getMinimumHeight(paramView);
  }
  
  public static int getPaddingEnd(View paramView) {
    return IMPL.getPaddingEnd(paramView);
  }
  
  public static int getPaddingStart(View paramView) {
    return IMPL.getPaddingStart(paramView);
  }
  
  public static String getTransitionName(View paramView) {
    return IMPL.getTransitionName(paramView);
  }
  
  public static int getWindowSystemUiVisibility(View paramView) {
    return IMPL.getWindowSystemUiVisibility(paramView);
  }
  
  public static boolean hasOverlappingRendering(View paramView) {
    return IMPL.hasOverlappingRendering(paramView);
  }
  
  public static boolean isAttachedToWindow(View paramView) {
    return IMPL.isAttachedToWindow(paramView);
  }
  
  public static void postInvalidateOnAnimation(View paramView) {
    IMPL.postInvalidateOnAnimation(paramView);
  }
  
  public static void postOnAnimation(View paramView, Runnable paramRunnable) {
    IMPL.postOnAnimation(paramView, paramRunnable);
  }
  
  public static void postOnAnimationDelayed(View paramView, Runnable paramRunnable, long paramLong) {
    IMPL.postOnAnimationDelayed(paramView, paramRunnable, paramLong);
  }
  
  public static void requestApplyInsets(View paramView) {
    IMPL.requestApplyInsets(paramView);
  }
  
  public static void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat) {
    View.AccessibilityDelegate accessibilityDelegate;
    if (paramAccessibilityDelegateCompat == null) {
      paramAccessibilityDelegateCompat = null;
    } else {
      accessibilityDelegate = paramAccessibilityDelegateCompat.mBridge;
    } 
    paramView.setAccessibilityDelegate(accessibilityDelegate);
  }
  
  public static void setBackground(View paramView, Drawable paramDrawable) {
    IMPL.setBackground(paramView, paramDrawable);
  }
  
  public static void setBackgroundTintList(View paramView, ColorStateList paramColorStateList) {
    IMPL.setBackgroundTintList(paramView, paramColorStateList);
  }
  
  public static void setBackgroundTintMode(View paramView, PorterDuff.Mode paramMode) {
    IMPL.setBackgroundTintMode(paramView, paramMode);
  }
  
  public static void setPaddingRelative(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    IMPL.setPaddingRelative(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public static void setTransitionName(View paramView, String paramString) {
    IMPL.setTransitionName(paramView, paramString);
  }
  
  public static void stopNestedScroll(View paramView) {
    IMPL.stopNestedScroll(paramView);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 26) {
      IMPL = new ViewCompat$ViewCompatApi26Impl();
      throw new VerifyError("bad dex opcode");
    } 
    if (Build.VERSION.SDK_INT >= 24) {
      IMPL = new ViewCompat$ViewCompatApi24Impl();
      throw new VerifyError("bad dex opcode");
    } 
    if (Build.VERSION.SDK_INT >= 23) {
      IMPL = new ViewCompat$ViewCompatApi23Impl();
      throw new VerifyError("bad dex opcode");
    } 
    if (Build.VERSION.SDK_INT >= 21) {
      IMPL = new ViewCompat$ViewCompatApi21Impl();
      throw new VerifyError("bad dex opcode");
    } 
    if (Build.VERSION.SDK_INT >= 19) {
      IMPL = new ViewCompat$ViewCompatApi19Impl();
      throw new VerifyError("bad dex opcode");
    } 
    if (Build.VERSION.SDK_INT >= 18) {
      IMPL = new ViewCompat$ViewCompatApi18Impl();
      throw new VerifyError("bad dex opcode");
    } 
    if (Build.VERSION.SDK_INT >= 17) {
      IMPL = new ViewCompat$ViewCompatApi17Impl();
      throw new VerifyError("bad dex opcode");
    } 
    if (Build.VERSION.SDK_INT >= 16) {
      IMPL = new ViewCompat$ViewCompatApi16Impl();
      throw new VerifyError("bad dex opcode");
    } 
    if (Build.VERSION.SDK_INT >= 15) {
      IMPL = new ViewCompat$ViewCompatApi15Impl();
      throw new VerifyError("bad dex opcode");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\ViewCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */