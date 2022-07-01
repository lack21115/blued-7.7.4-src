package com.google.android.material.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;

public class ViewUtils {
  public static float a(Context paramContext, int paramInt) {
    Resources resources = paramContext.getResources();
    return TypedValue.applyDimension(1, paramInt, resources.getDisplayMetrics());
  }
  
  public static PorterDuff.Mode a(int paramInt, PorterDuff.Mode paramMode) {
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
  
  public static void a(View paramView, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener) {
    TypedArray typedArray = paramView.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.Insets, paramInt1, paramInt2);
    boolean bool1 = typedArray.getBoolean(R.styleable.Insets_paddingBottomSystemWindowInsets, false);
    boolean bool2 = typedArray.getBoolean(R.styleable.Insets_paddingLeftSystemWindowInsets, false);
    boolean bool3 = typedArray.getBoolean(R.styleable.Insets_paddingRightSystemWindowInsets, false);
    typedArray.recycle();
    a(paramView, new OnApplyWindowInsetsListener(bool1, bool2, bool3, paramOnApplyWindowInsetsListener) {
          public WindowInsetsCompat a(View param1View, WindowInsetsCompat param1WindowInsetsCompat, ViewUtils.RelativePadding param1RelativePadding) {
            if (this.a)
              param1RelativePadding.d += param1WindowInsetsCompat.getSystemWindowInsetBottom(); 
            boolean bool = ViewUtils.a(param1View);
            if (this.b)
              if (bool) {
                param1RelativePadding.c += param1WindowInsetsCompat.getSystemWindowInsetLeft();
              } else {
                param1RelativePadding.a += param1WindowInsetsCompat.getSystemWindowInsetLeft();
              }  
            if (this.c)
              if (bool) {
                param1RelativePadding.a += param1WindowInsetsCompat.getSystemWindowInsetRight();
              } else {
                param1RelativePadding.c += param1WindowInsetsCompat.getSystemWindowInsetRight();
              }  
            param1RelativePadding.a(param1View);
            ViewUtils.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.d;
            WindowInsetsCompat windowInsetsCompat = param1WindowInsetsCompat;
            if (onApplyWindowInsetsListener != null)
              windowInsetsCompat = onApplyWindowInsetsListener.a(param1View, param1WindowInsetsCompat, param1RelativePadding); 
            return windowInsetsCompat;
          }
        });
  }
  
  public static void a(View paramView, OnApplyWindowInsetsListener paramOnApplyWindowInsetsListener) {
    ViewCompat.setOnApplyWindowInsetsListener(paramView, new androidx.core.view.OnApplyWindowInsetsListener(paramOnApplyWindowInsetsListener, new RelativePadding(ViewCompat.getPaddingStart(paramView), paramView.getPaddingTop(), ViewCompat.getPaddingEnd(paramView), paramView.getPaddingBottom())) {
          public WindowInsetsCompat onApplyWindowInsets(View param1View, WindowInsetsCompat param1WindowInsetsCompat) {
            return this.a.a(param1View, param1WindowInsetsCompat, new ViewUtils.RelativePadding(this.b));
          }
        });
    c(paramView);
  }
  
  public static boolean a(View paramView) {
    return (ViewCompat.getLayoutDirection(paramView) == 1);
  }
  
  public static void b(View paramView) {
    paramView.requestFocus();
    paramView.post(new Runnable(paramView) {
          public void run() {
            ((InputMethodManager)this.a.getContext().getSystemService("input_method")).showSoftInput(this.a, 1);
          }
        });
  }
  
  public static void c(View paramView) {
    if (ViewCompat.isAttachedToWindow(paramView)) {
      ViewCompat.requestApplyInsets(paramView);
      return;
    } 
    paramView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
          public void onViewAttachedToWindow(View param1View) {
            param1View.removeOnAttachStateChangeListener(this);
            ViewCompat.requestApplyInsets(param1View);
          }
          
          public void onViewDetachedFromWindow(View param1View) {}
        });
  }
  
  public static float d(View paramView) {
    ViewParent viewParent = paramView.getParent();
    float f = 0.0F;
    while (viewParent instanceof View) {
      f += ViewCompat.getElevation((View)viewParent);
      viewParent = viewParent.getParent();
    } 
    return f;
  }
  
  public static ViewOverlayImpl e(View paramView) {
    return (ViewOverlayImpl)((paramView == null) ? null : ((Build.VERSION.SDK_INT >= 18) ? new ViewOverlayApi18(paramView) : ViewOverlayApi14.a(paramView)));
  }
  
  public static ViewGroup f(View paramView) {
    if (paramView == null)
      return null; 
    View view = paramView.getRootView();
    ViewGroup viewGroup = (ViewGroup)view.findViewById(16908290);
    return (viewGroup != null) ? viewGroup : ((view != paramView && view instanceof ViewGroup) ? (ViewGroup)view : null);
  }
  
  public static ViewOverlayImpl g(View paramView) {
    return e((View)f(paramView));
  }
  
  public static interface OnApplyWindowInsetsListener {
    WindowInsetsCompat a(View param1View, WindowInsetsCompat param1WindowInsetsCompat, ViewUtils.RelativePadding param1RelativePadding);
  }
  
  public static class RelativePadding {
    public int a;
    
    public int b;
    
    public int c;
    
    public int d;
    
    public RelativePadding(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      this.a = param1Int1;
      this.b = param1Int2;
      this.c = param1Int3;
      this.d = param1Int4;
    }
    
    public RelativePadding(RelativePadding param1RelativePadding) {
      this.a = param1RelativePadding.a;
      this.b = param1RelativePadding.b;
      this.c = param1RelativePadding.c;
      this.d = param1RelativePadding.d;
    }
    
    public void a(View param1View) {
      ViewCompat.setPaddingRelative(param1View, this.a, this.b, this.c, this.d);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\internal\ViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */