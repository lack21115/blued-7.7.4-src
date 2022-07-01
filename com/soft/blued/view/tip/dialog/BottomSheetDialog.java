package com.soft.blued.view.tip.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

public class BottomSheetDialog extends AppCompatDialog {
  boolean a;
  
  boolean b = true;
  
  private BottomSheetBehavior<FrameLayout> c;
  
  private FrameLayout d;
  
  private boolean e = true;
  
  private boolean f;
  
  private BottomSheetBehavior.BottomSheetCallback g = new BottomSheetBehavior.BottomSheetCallback(this) {
      public void a(View param1View, float param1Float) {}
      
      public void a(View param1View, int param1Int) {
        if (param1Int == 5)
          this.a.cancel(); 
      }
    };
  
  public BottomSheetDialog(Context paramContext, int paramInt) {
    super(paramContext, a(paramContext, paramInt));
    supportRequestWindowFeature(1);
  }
  
  private static int a(Context paramContext, int paramInt) {
    int i = paramInt;
    if (paramInt == 0) {
      TypedValue typedValue = new TypedValue();
      if (paramContext.getTheme().resolveAttribute(2130968705, typedValue, true))
        return typedValue.resourceId; 
      i = 2131821003;
    } 
    return i;
  }
  
  private View a(int paramInt, View paramView, ViewGroup.LayoutParams paramLayoutParams) {
    e();
    CoordinatorLayout coordinatorLayout = (CoordinatorLayout)this.d.findViewById(2131296843);
    View view = paramView;
    if (paramInt != 0) {
      view = paramView;
      if (paramView == null)
        view = getLayoutInflater().inflate(paramInt, (ViewGroup)coordinatorLayout, false); 
    } 
    FrameLayout frameLayout = (FrameLayout)this.d.findViewById(2131296916);
    frameLayout.removeAllViews();
    if (paramLayoutParams == null) {
      frameLayout.addView(view);
    } else {
      frameLayout.addView(view, paramLayoutParams);
    } 
    coordinatorLayout.findViewById(2131300309).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (this.a.b && this.a.isShowing() && this.a.c())
              this.a.cancel(); 
          }
        });
    ViewCompat.setAccessibilityDelegate((View)frameLayout, new AccessibilityDelegateCompat(this) {
          public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
            if (this.a.b) {
              param1AccessibilityNodeInfoCompat.addAction(1048576);
              param1AccessibilityNodeInfoCompat.setDismissable(true);
              return;
            } 
            param1AccessibilityNodeInfoCompat.setDismissable(false);
          }
          
          public boolean performAccessibilityAction(View param1View, int param1Int, Bundle param1Bundle) {
            if (param1Int == 1048576 && this.a.b) {
              this.a.cancel();
              return true;
            } 
            return super.performAccessibilityAction(param1View, param1Int, param1Bundle);
          }
        });
    frameLayout.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return true;
          }
        });
    return (View)this.d;
  }
  
  private FrameLayout e() {
    if (this.d == null) {
      this.d = (FrameLayout)View.inflate(getContext(), 2131492960, null);
      this.c = BottomSheetBehavior.b((FrameLayout)this.d.findViewById(2131296916));
      this.c.a(this.g);
      this.c.b(this.b);
    } 
    return this.d;
  }
  
  public BottomSheetBehavior<FrameLayout> a() {
    if (this.c == null)
      e(); 
    return this.c;
  }
  
  public boolean b() {
    return this.a;
  }
  
  boolean c() {
    if (!this.f) {
      TypedArray typedArray = getContext().obtainStyledAttributes(new int[] { 16843611 });
      this.e = typedArray.getBoolean(0, true);
      typedArray.recycle();
      this.f = true;
    } 
    return this.e;
  }
  
  public void cancel() {
    BottomSheetBehavior<FrameLayout> bottomSheetBehavior = a();
    if (!this.a || bottomSheetBehavior.d() == 5) {
      super.cancel();
      return;
    } 
    bottomSheetBehavior.d(5);
  }
  
  void d() {
    this.c.b(this.g);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    Window window = getWindow();
    if (window != null) {
      if (Build.VERSION.SDK_INT >= 21) {
        window.clearFlags(67108864);
        window.addFlags(-2147483648);
      } 
      window.setLayout(-1, -1);
    } 
  }
  
  protected void onStart() {
    super.onStart();
    BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.c;
    if (bottomSheetBehavior != null && bottomSheetBehavior.d() == 5)
      this.c.d(4); 
  }
  
  public void setCancelable(boolean paramBoolean) {
    super.setCancelable(paramBoolean);
    if (this.b != paramBoolean) {
      this.b = paramBoolean;
      BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.c;
      if (bottomSheetBehavior != null)
        bottomSheetBehavior.b(paramBoolean); 
    } 
  }
  
  public void setCanceledOnTouchOutside(boolean paramBoolean) {
    super.setCanceledOnTouchOutside(paramBoolean);
    if (paramBoolean && !this.b)
      this.b = true; 
    this.e = paramBoolean;
    this.f = true;
  }
  
  public void setContentView(int paramInt) {
    super.setContentView(a(paramInt, (View)null, (ViewGroup.LayoutParams)null));
  }
  
  public void setContentView(View paramView) {
    super.setContentView(a(0, paramView, (ViewGroup.LayoutParams)null));
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
    super.setContentView(a(0, paramView, paramLayoutParams));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\view\tip\dialog\BottomSheetDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */