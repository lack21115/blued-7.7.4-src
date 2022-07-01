package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
  ViewDragHelper a;
  
  OnDismissListener b;
  
  int c = 2;
  
  float d = 0.5F;
  
  float e = 0.0F;
  
  float f = 0.5F;
  
  private boolean g;
  
  private float h = 0.0F;
  
  private boolean i;
  
  private final ViewDragHelper.Callback j = new ViewDragHelper.Callback(this) {
      private int b;
      
      private int c = -1;
      
      private boolean a(View param1View, float param1Float) {
        boolean bool2 = false;
        boolean bool3 = false;
        boolean bool1 = false;
        int j = param1Float cmp 0.0F;
        if (j != 0) {
          boolean bool;
          if (ViewCompat.getLayoutDirection(param1View) == 1) {
            bool = true;
          } else {
            bool = false;
          } 
          if (this.a.c == 2)
            return true; 
          if (this.a.c == 0) {
            if (bool ? (param1Float < 0.0F) : (j > 0))
              bool1 = true; 
            return bool1;
          } 
          bool1 = bool2;
          if (this.a.c == 1)
            if (bool) {
              bool1 = bool2;
              if (j > 0)
                return true; 
            } else {
              bool1 = bool2;
              if (param1Float < 0.0F)
                return true; 
            }  
          return bool1;
        } 
        int i = param1View.getLeft();
        j = this.b;
        int k = Math.round(param1View.getWidth() * this.a.d);
        bool1 = bool3;
        if (Math.abs(i - j) >= k)
          bool1 = true; 
        return bool1;
      }
      
      public int clampViewPositionHorizontal(View param1View, int param1Int1, int param1Int2) {
        int i;
        if (ViewCompat.getLayoutDirection(param1View) == 1) {
          param1Int2 = 1;
        } else {
          param1Int2 = 0;
        } 
        if (this.a.c == 0) {
          if (param1Int2 != 0) {
            i = this.b - param1View.getWidth();
            param1Int2 = this.b;
          } else {
            i = this.b;
            param1Int2 = param1View.getWidth();
            param1Int2 += i;
          } 
        } else {
          if (this.a.c == 1) {
            if (param1Int2 != 0) {
              i = this.b;
              param1Int2 = param1View.getWidth();
            } else {
              i = this.b - param1View.getWidth();
              param1Int2 = this.b;
              return SwipeDismissBehavior.a(i, param1Int1, param1Int2);
            } 
          } else {
            i = this.b - param1View.getWidth();
            param1Int2 = this.b;
            param1Int2 = param1View.getWidth() + param1Int2;
            return SwipeDismissBehavior.a(i, param1Int1, param1Int2);
          } 
          param1Int2 += i;
        } 
        return SwipeDismissBehavior.a(i, param1Int1, param1Int2);
      }
      
      public int clampViewPositionVertical(View param1View, int param1Int1, int param1Int2) {
        return param1View.getTop();
      }
      
      public int getViewHorizontalDragRange(View param1View) {
        return param1View.getWidth();
      }
      
      public void onViewCaptured(View param1View, int param1Int) {
        this.c = param1Int;
        this.b = param1View.getLeft();
        ViewParent viewParent = param1View.getParent();
        if (viewParent != null)
          viewParent.requestDisallowInterceptTouchEvent(true); 
      }
      
      public void onViewDragStateChanged(int param1Int) {
        if (this.a.b != null)
          this.a.b.a(param1Int); 
      }
      
      public void onViewPositionChanged(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
        float f1 = this.b + param1View.getWidth() * this.a.e;
        float f2 = this.b + param1View.getWidth() * this.a.f;
        float f3 = param1Int1;
        if (f3 <= f1) {
          param1View.setAlpha(1.0F);
          return;
        } 
        if (f3 >= f2) {
          param1View.setAlpha(0.0F);
          return;
        } 
        param1View.setAlpha(SwipeDismissBehavior.a(0.0F, 1.0F - SwipeDismissBehavior.b(f1, f2, f3), 1.0F));
      }
      
      public void onViewReleased(View param1View, float param1Float1, float param1Float2) {
        boolean bool;
        this.c = -1;
        int i = param1View.getWidth();
        if (a(param1View, param1Float1)) {
          int j = param1View.getLeft();
          int k = this.b;
          if (j < k) {
            i = k - i;
          } else {
            i = k + i;
          } 
          bool = true;
        } else {
          i = this.b;
          bool = false;
        } 
        if (this.a.a.settleCapturedViewAt(i, param1View.getTop())) {
          ViewCompat.postOnAnimation(param1View, new SwipeDismissBehavior.SettleRunnable(this.a, param1View, bool));
          return;
        } 
        if (bool && this.a.b != null)
          this.a.b.a(param1View); 
      }
      
      public boolean tryCaptureView(View param1View, int param1Int) {
        int i = this.c;
        return ((i == -1 || i == param1Int) && this.a.a(param1View));
      }
    };
  
  static float a(float paramFloat1, float paramFloat2, float paramFloat3) {
    return Math.min(Math.max(paramFloat1, paramFloat2), paramFloat3);
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3) {
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }
  
  private void a(ViewGroup paramViewGroup) {
    if (this.a == null) {
      ViewDragHelper viewDragHelper;
      if (this.i) {
        viewDragHelper = ViewDragHelper.create(paramViewGroup, this.h, this.j);
      } else {
        viewDragHelper = ViewDragHelper.create((ViewGroup)viewDragHelper, this.j);
      } 
      this.a = viewDragHelper;
    } 
  }
  
  static float b(float paramFloat1, float paramFloat2, float paramFloat3) {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }
  
  private void b(View paramView) {
    ViewCompat.removeAccessibilityAction(paramView, 1048576);
    if (a(paramView))
      ViewCompat.replaceAccessibilityAction(paramView, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new AccessibilityViewCommand(this) {
            public boolean perform(View param1View, AccessibilityViewCommand.CommandArguments param1CommandArguments) {
              // Byte code:
              //   0: aload_0
              //   1: getfield a : Lcom/google/android/material/behavior/SwipeDismissBehavior;
              //   4: aload_1
              //   5: invokevirtual a : (Landroid/view/View;)Z
              //   8: istore #6
              //   10: iconst_0
              //   11: istore #5
              //   13: iload #6
              //   15: ifeq -> 129
              //   18: aload_1
              //   19: invokestatic getLayoutDirection : (Landroid/view/View;)I
              //   22: iconst_1
              //   23: if_icmpne -> 32
              //   26: iconst_1
              //   27: istore #4
              //   29: goto -> 35
              //   32: iconst_0
              //   33: istore #4
              //   35: aload_0
              //   36: getfield a : Lcom/google/android/material/behavior/SwipeDismissBehavior;
              //   39: getfield c : I
              //   42: ifne -> 50
              //   45: iload #4
              //   47: ifne -> 72
              //   50: iload #5
              //   52: istore_3
              //   53: aload_0
              //   54: getfield a : Lcom/google/android/material/behavior/SwipeDismissBehavior;
              //   57: getfield c : I
              //   60: iconst_1
              //   61: if_icmpne -> 74
              //   64: iload #5
              //   66: istore_3
              //   67: iload #4
              //   69: ifne -> 74
              //   72: iconst_1
              //   73: istore_3
              //   74: aload_1
              //   75: invokevirtual getWidth : ()I
              //   78: istore #5
              //   80: iload #5
              //   82: istore #4
              //   84: iload_3
              //   85: ifeq -> 93
              //   88: iload #5
              //   90: ineg
              //   91: istore #4
              //   93: aload_1
              //   94: iload #4
              //   96: invokestatic offsetLeftAndRight : (Landroid/view/View;I)V
              //   99: aload_1
              //   100: fconst_0
              //   101: invokevirtual setAlpha : (F)V
              //   104: aload_0
              //   105: getfield a : Lcom/google/android/material/behavior/SwipeDismissBehavior;
              //   108: getfield b : Lcom/google/android/material/behavior/SwipeDismissBehavior$OnDismissListener;
              //   111: ifnull -> 127
              //   114: aload_0
              //   115: getfield a : Lcom/google/android/material/behavior/SwipeDismissBehavior;
              //   118: getfield b : Lcom/google/android/material/behavior/SwipeDismissBehavior$OnDismissListener;
              //   121: aload_1
              //   122: invokeinterface a : (Landroid/view/View;)V
              //   127: iconst_1
              //   128: ireturn
              //   129: iconst_0
              //   130: ireturn
            }
          }); 
  }
  
  public void a(float paramFloat) {
    this.e = a(0.0F, paramFloat, 1.0F);
  }
  
  public void a(int paramInt) {
    this.c = paramInt;
  }
  
  public void a(OnDismissListener paramOnDismissListener) {
    this.b = paramOnDismissListener;
  }
  
  public boolean a(View paramView) {
    return true;
  }
  
  public void b(float paramFloat) {
    this.f = a(0.0F, paramFloat, 1.0F);
  }
  
  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent) {
    boolean bool = this.g;
    int i = paramMotionEvent.getActionMasked();
    if (i != 0) {
      if (i == 1 || i == 3)
        this.g = false; 
    } else {
      this.g = paramCoordinatorLayout.isPointInChildBounds((View)paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      bool = this.g;
    } 
    if (bool) {
      a((ViewGroup)paramCoordinatorLayout);
      return this.a.shouldInterceptTouchEvent(paramMotionEvent);
    } 
    return false;
  }
  
  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt) {
    boolean bool = super.onLayoutChild(paramCoordinatorLayout, (View)paramV, paramInt);
    if (ViewCompat.getImportantForAccessibility((View)paramV) == 0) {
      ViewCompat.setImportantForAccessibility((View)paramV, 1);
      b((View)paramV);
    } 
    return bool;
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent) {
    ViewDragHelper viewDragHelper = this.a;
    if (viewDragHelper != null) {
      viewDragHelper.processTouchEvent(paramMotionEvent);
      return true;
    } 
    return false;
  }
  
  public static interface OnDismissListener {
    void a(int param1Int);
    
    void a(View param1View);
  }
  
  class SettleRunnable implements Runnable {
    private final View b;
    
    private final boolean c;
    
    SettleRunnable(SwipeDismissBehavior this$0, View param1View, boolean param1Boolean) {
      this.b = param1View;
      this.c = param1Boolean;
    }
    
    public void run() {
      if (this.a.a != null && this.a.a.continueSettling(true)) {
        ViewCompat.postOnAnimation(this.b, this);
        return;
      } 
      if (this.c && this.a.b != null)
        this.a.b.a(this.b); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\behavior\SwipeDismissBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */