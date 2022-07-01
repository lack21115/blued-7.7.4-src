package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;

class ViewUtils {
  static final Property<View, Float> a = new Property<View, Float>(Float.class, "translationAlpha") {
      public Float get(View param1View) {
        return Float.valueOf(ViewUtils.c(param1View));
      }
      
      public void set(View param1View, Float param1Float) {
        ViewUtils.a(param1View, param1Float.floatValue());
      }
    };
  
  static final Property<View, Rect> b = new Property<View, Rect>(Rect.class, "clipBounds") {
      public Rect get(View param1View) {
        return ViewCompat.getClipBounds(param1View);
      }
      
      public void set(View param1View, Rect param1Rect) {
        ViewCompat.setClipBounds(param1View, param1Rect);
      }
    };
  
  private static final ViewUtilsBase c;
  
  static ViewOverlayImpl a(View paramView) {
    return (ViewOverlayImpl)((Build.VERSION.SDK_INT >= 18) ? new ViewOverlayApi18(paramView) : ViewOverlayApi14.b(paramView));
  }
  
  static void a(View paramView, float paramFloat) {
    c.setTransitionAlpha(paramView, paramFloat);
  }
  
  static void a(View paramView, int paramInt) {
    c.setTransitionVisibility(paramView, paramInt);
  }
  
  static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    c.setLeftTopRightBottom(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  static void a(View paramView, Matrix paramMatrix) {
    c.transformMatrixToGlobal(paramView, paramMatrix);
  }
  
  static WindowIdImpl b(View paramView) {
    return (WindowIdImpl)((Build.VERSION.SDK_INT >= 18) ? new WindowIdApi18(paramView) : new WindowIdApi14(paramView.getWindowToken()));
  }
  
  static void b(View paramView, Matrix paramMatrix) {
    c.transformMatrixToLocal(paramView, paramMatrix);
  }
  
  static float c(View paramView) {
    return c.getTransitionAlpha(paramView);
  }
  
  static void c(View paramView, Matrix paramMatrix) {
    c.setAnimationMatrix(paramView, paramMatrix);
  }
  
  static void d(View paramView) {
    c.saveNonTransitionAlpha(paramView);
  }
  
  static void e(View paramView) {
    c.clearNonTransitionAlpha(paramView);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 29) {
      c = new ViewUtilsApi29();
    } else if (Build.VERSION.SDK_INT >= 23) {
      c = new ViewUtilsApi23();
    } else if (Build.VERSION.SDK_INT >= 22) {
      c = new ViewUtilsApi22();
    } else if (Build.VERSION.SDK_INT >= 21) {
      c = new ViewUtilsApi21();
    } else if (Build.VERSION.SDK_INT >= 19) {
      c = new ViewUtilsApi19();
    } else {
      c = new ViewUtilsBase();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\ViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */