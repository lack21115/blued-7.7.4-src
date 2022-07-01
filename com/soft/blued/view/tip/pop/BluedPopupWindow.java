package com.soft.blued.view.tip.pop;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.core.widget.PopupWindowCompat;

public class BluedPopupWindow extends PopupWindow {
  private int a = -2;
  
  private int b = -2;
  
  private float c = 1.0F;
  
  private Context d;
  
  private View e;
  
  private boolean f = true;
  
  private int g = -1;
  
  private boolean h = true;
  
  private View i;
  
  private int j = 2;
  
  private int k = 1;
  
  private int l;
  
  private int m;
  
  private final ViewTreeObserver.OnGlobalLayoutListener n = new ViewTreeObserver.OnGlobalLayoutListener(this) {
      public void onGlobalLayout() {
        BluedPopupWindow bluedPopupWindow = this.a;
        BluedPopupWindow.a(bluedPopupWindow, bluedPopupWindow.getContentView().getWidth());
        bluedPopupWindow = this.a;
        BluedPopupWindow.b(bluedPopupWindow, bluedPopupWindow.getContentView().getHeight());
        if (BluedPopupWindow.c(this.a)) {
          BluedPopupWindow.d(this.a);
          return;
        } 
        bluedPopupWindow = this.a;
        BluedPopupWindow.a(bluedPopupWindow, BluedPopupWindow.a(bluedPopupWindow), BluedPopupWindow.b(this.a), BluedPopupWindow.e(this.a), BluedPopupWindow.f(this.a), BluedPopupWindow.g(this.a), BluedPopupWindow.h(this.a), BluedPopupWindow.i(this.a));
        BluedPopupWindow.d(this.a);
      }
    };
  
  public BluedPopupWindow(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public BluedPopupWindow(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BluedPopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = paramContext;
  }
  
  private static int a(int paramInt) {
    return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt), b(paramInt));
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 != 0) {
      if (paramInt1 != 1) {
        if (paramInt1 != 3) {
          if (paramInt1 != 4)
            return paramInt3; 
        } else {
          paramInt1 = paramView.getHeight();
          return paramInt3 - paramInt1;
        } 
      } else {
        paramInt2 += paramView.getHeight();
      } 
      return paramInt3 - paramInt2;
    } 
    paramInt1 = paramView.getHeight() / 2 + paramInt2 / 2;
    return paramInt3 - paramInt1;
  }
  
  private void a(float paramFloat) {
    Context context = this.d;
    if (context == null)
      return; 
    if (context instanceof Activity) {
      Window window = ((Activity)context).getWindow();
      WindowManager.LayoutParams layoutParams = window.getAttributes();
      layoutParams.alpha = paramFloat;
      window.setAttributes(layoutParams);
    } 
  }
  
  private void a(int paramInt1, int paramInt2, View paramView, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    update(paramView, b(paramView, paramInt4, paramInt1, paramInt5), a(paramView, paramInt3, paramInt2, paramInt6), paramInt1, paramInt2);
  }
  
  private void a(View paramView) {
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(this.n);
  }
  
  private void a(boolean paramBoolean) {
    if (!paramBoolean) {
      setFocusable(true);
      setOutsideTouchable(false);
      setBackgroundDrawable(null);
      getContentView().setFocusable(true);
      getContentView().setFocusableInTouchMode(true);
      getContentView().setOnKeyListener(new View.OnKeyListener(this) {
            public boolean onKey(View param1View, int param1Int, KeyEvent param1KeyEvent) {
              if (param1Int == 4) {
                this.a.dismiss();
                return true;
              } 
              return false;
            }
          });
      setTouchInterceptor(new View.OnTouchListener(this) {
            public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
              int i = (int)param1MotionEvent.getX();
              int j = (int)param1MotionEvent.getY();
              return (param1MotionEvent.getAction() == 0 && (i < 0 || i >= BluedPopupWindow.a(this.a) || j < 0 || j >= BluedPopupWindow.b(this.a))) ? true : ((param1MotionEvent.getAction() == 4));
            }
          });
      return;
    } 
    setOutsideTouchable(true);
    setBackgroundDrawable(null);
  }
  
  private static int b(int paramInt) {
    return (paramInt != -2) ? 1073741824 : 0;
  }
  
  private int b(View paramView, int paramInt1, int paramInt2, int paramInt3) {
    int i;
    if (paramInt1 != 0) {
      i = paramInt2;
      if (paramInt1 != 1) {
        if (paramInt1 != 2) {
          i = paramInt3;
          if (paramInt1 != 3) {
            if (paramInt1 != 4)
              return paramInt3; 
            i = paramInt2 - paramView.getWidth();
            return paramInt3 - i;
          } 
        } else {
          paramInt1 = paramView.getWidth();
          i = paramInt3 + paramInt1;
        } 
      } else {
        return paramInt3 - i;
      } 
    } else {
      paramInt1 = paramView.getWidth() / 2 - paramInt2 / 2;
      i = paramInt3 + paramInt1;
    } 
    return i;
  }
  
  private void b() {
    if (getContentView() != null) {
      if (Build.VERSION.SDK_INT >= 16) {
        getContentView().getViewTreeObserver().removeOnGlobalLayoutListener(this.n);
        return;
      } 
      getContentView().getViewTreeObserver().removeGlobalOnLayoutListener(this.n);
    } 
  }
  
  private void c() {
    float f = this.c;
    if (f >= 1.0F)
      return; 
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, f });
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            BluedPopupWindow.a(this.a, f);
          }
        });
    valueAnimator.setDuration(360L);
    valueAnimator.start();
  }
  
  private void d() {
    float f = this.c;
    if (f >= 1.0F)
      return; 
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { f, 1.0F });
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            BluedPopupWindow.a(this.a, f);
          }
        });
    valueAnimator.setDuration(360L);
    valueAnimator.start();
  }
  
  public void a() {
    setContentView(this.e);
    setHeight(this.b);
    setWidth(this.a);
    a(this.f);
    int i = this.g;
    if (i != -1)
      setAnimationStyle(i); 
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, true);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
    this.h = false;
    this.i = paramView;
    this.l = paramInt3;
    this.m = paramInt4;
    this.j = paramInt1;
    this.k = paramInt2;
    View view = getContentView();
    if (view == null)
      return; 
    c();
    a(view);
    setClippingEnabled(paramBoolean);
    try {
      view.measure(a(getWidth()), a(getHeight()));
      int k = view.getMeasuredWidth();
      int m = view.getMeasuredHeight();
      int i = paramInt3;
      int j = paramInt4;
      if (!paramBoolean) {
        int[] arrayOfInt = new int[2];
        paramView.getLocationInWindow(arrayOfInt);
        i = paramInt3 + arrayOfInt[0];
        j = paramInt4 + arrayOfInt[1] + paramView.getHeight();
      } 
      paramInt1 = a(paramView, paramInt1, m, j);
      paramInt2 = b(paramView, paramInt2, k, i);
      if (paramBoolean) {
        PopupWindowCompat.showAsDropDown(this, paramView, paramInt2, paramInt1, 0);
        return;
      } 
      showAtLocation(paramView, 0, paramInt2, paramInt1);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void dismiss() {
    super.dismiss();
    d();
    b();
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3) {
    this.h = true;
    this.i = paramView;
    this.l = paramInt2;
    this.m = paramInt3;
    a(getContentView());
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public static class Builder {
    private BluedPopupWindow a;
    
    private Builder(Activity param1Activity, View param1View) {
      this.a = new BluedPopupWindow((Context)param1Activity);
      BluedPopupWindow.a(this.a, (Context)param1Activity);
      BluedPopupWindow.a(this.a, param1View);
    }
    
    public static Builder a(Activity param1Activity, View param1View) {
      return new Builder(param1Activity, param1View);
    }
    
    public Builder a(boolean param1Boolean) {
      BluedPopupWindow.a(this.a, param1Boolean);
      return this;
    }
    
    public BluedPopupWindow a() {
      this.a.a();
      return this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\view\tip\pop\BluedPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */