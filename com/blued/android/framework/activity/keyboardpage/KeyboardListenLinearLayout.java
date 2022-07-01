package com.blued.android.framework.activity.keyboardpage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.KeyboardUtils;

public class KeyboardListenLinearLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
  private SwitchPanelRelativeLayout a;
  
  private boolean b = false;
  
  private boolean c = false;
  
  private int d;
  
  private IOnKeyboardStateChangedListener e;
  
  public KeyboardListenLinearLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public KeyboardListenLinearLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public KeyboardListenLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  private void a() {
    Rect rect = new Rect();
    ((Activity)getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
    int j = this.d;
    int i = j;
    if (j == 0)
      i = AppInfo.m; 
    j = Math.abs(rect.bottom - rect.top - i);
    if (Math.abs(j) > i / 5) {
      i = 1;
    } else {
      i = 0;
    } 
    if (j != 0 && i != 0)
      KeyboardUtils.a(j); 
  }
  
  private boolean a(View paramView) {
    Rect rect = new Rect();
    paramView.getWindowVisibleDisplayFrame(rect);
    int i = rect.bottom;
    int j = AppInfo.l;
    boolean bool = false;
    if (i == j)
      return false; 
    DisplayMetrics displayMetrics = paramView.getResources().getDisplayMetrics();
    if ((paramView.getBottom() - rect.bottom) > displayMetrics.density * 100.0F)
      bool = true; 
    return bool;
  }
  
  private SwitchPanelRelativeLayout b(View paramView) {
    SwitchPanelRelativeLayout switchPanelRelativeLayout = this.a;
    if (switchPanelRelativeLayout != null)
      return switchPanelRelativeLayout; 
    if (paramView instanceof SwitchPanelRelativeLayout) {
      this.a = (SwitchPanelRelativeLayout)paramView;
      return this.a;
    } 
    if (paramView instanceof ViewGroup) {
      int i = 0;
      while (true) {
        ViewGroup viewGroup = (ViewGroup)paramView;
        if (i < viewGroup.getChildCount()) {
          SwitchPanelRelativeLayout switchPanelRelativeLayout1 = b(viewGroup.getChildAt(i));
          if (switchPanelRelativeLayout1 != null) {
            this.a = switchPanelRelativeLayout1;
            return this.a;
          } 
          i++;
          continue;
        } 
        break;
      } 
    } 
    return null;
  }
  
  private void b() {
    Rect rect = new Rect();
    ((Activity)getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
    this.d = rect.bottom - rect.top;
  }
  
  public void onGlobalLayout() {
    getViewTreeObserver().removeOnGlobalLayoutListener(this);
    b();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (this.e != null) {
      if (this.a == null)
        b((View)this); 
      if (!this.b) {
        this.b = true;
        IOnKeyboardStateChangedListener iOnKeyboardStateChangedListener = this.e;
        if (iOnKeyboardStateChangedListener != null)
          iOnKeyboardStateChangedListener.a(-1); 
      } else if (a(getRootView())) {
        if (!this.c) {
          SwitchPanelRelativeLayout switchPanelRelativeLayout = this.a;
          if (switchPanelRelativeLayout != null) {
            switchPanelRelativeLayout.c();
            this.a.a(true);
          } 
          this.c = true;
          this.e.a(-3);
          a();
        } 
      } else if (this.c) {
        SwitchPanelRelativeLayout switchPanelRelativeLayout = this.a;
        if (switchPanelRelativeLayout != null && switchPanelRelativeLayout.a()) {
          this.a.a(false);
          this.a.b();
        } 
        this.c = false;
        this.e.a(-2);
      } 
    } 
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setOnKeyboardStateChangedListener(IOnKeyboardStateChangedListener paramIOnKeyboardStateChangedListener) {
    this.e = paramIOnKeyboardStateChangedListener;
  }
  
  public static interface IOnKeyboardStateChangedListener {
    void a(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\activity\keyboardpage\KeyboardListenLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */