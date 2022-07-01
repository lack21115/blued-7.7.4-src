package com.soft.blued.customview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module_share_china.R;

public class PopMenu {
  public ViewGroup a;
  
  public View b;
  
  public View c;
  
  public Context d;
  
  public MyPopupWindow e;
  
  public ViewGroup f;
  
  public onShowListener g;
  
  public PopMenu(Context paramContext, View paramView) {
    this.d = paramContext;
    this.a = (ViewGroup)new RelativeLayout(paramContext);
    this.f = (ViewGroup)new RelativeLayout(paramContext);
    this.b = new View(paramContext);
    this.b.setBackgroundColor(Color.parseColor("#B3000000"));
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.d();
          }
        });
    this.c = paramView;
    if (c() > 0)
      this.c.setBackgroundColor(c()); 
    this.a.addView(this.b, -1, -1);
    this.f.addView(this.c, (ViewGroup.LayoutParams)b());
    this.a.addView((View)this.f, (ViewGroup.LayoutParams)b());
    this.e = new MyPopupWindow(this, (View)this.a, -1, -1, true);
    this.e.setBackgroundDrawable(this.d.getResources().getDrawable(17170445));
    this.e.setTouchable(true);
    this.e.setFocusable(true);
    this.e.setOutsideTouchable(true);
    this.e.update();
  }
  
  private boolean a(Context paramContext) {
    boolean bool = false;
    if (paramContext == null)
      return false; 
    Rect rect = new Rect();
    try {
      ((Activity)paramContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
      int i = rect.height();
      int j = StatusBarHelper.a(paramContext);
      if (i != AppInfo.m - j)
        bool = true; 
      return bool;
    } catch (ClassCastException classCastException) {
      classCastException.printStackTrace();
      return false;
    } 
  }
  
  public void a(View paramView) {
    this.b.clearAnimation();
    this.f.clearAnimation();
    if (this.e.isShowing())
      this.e.a(); 
    if (Build.VERSION.SDK_INT < 24) {
      this.e.showAsDropDown(paramView);
    } else {
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      int k = arrayOfInt[1] + paramView.getHeight();
      this.e.getHeight();
      int j = ((WindowManager)this.d.getSystemService("window")).getDefaultDisplay().getHeight() - k;
      int i = j;
      if (a(this.d))
        i = j + StatusBarHelper.a(this.d); 
      this.e.setHeight(i);
      this.e.showAtLocation(((Activity)this.d).getWindow().getDecorView(), 0, 0, k);
    } 
    this.f.setVisibility(8);
    this.b.setVisibility(8);
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
            alphaAnimation.setDuration(200L);
            alphaAnimation.setFillAfter(true);
            this.a.b.startAnimation((Animation)alphaAnimation);
            this.a.b.setVisibility(0);
            this.a.f.startAnimation(AnimationUtils.loadAnimation(this.a.d, R.anim.push_top_in2));
            this.a.f.setVisibility(0);
            if (this.a.g != null)
              this.a.g.a(); 
          }
        }10L);
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener) {
    this.e.setOnDismissListener(paramOnDismissListener);
  }
  
  public void a(onShowListener paramonShowListener) {
    this.g = paramonShowListener;
  }
  
  public boolean a() {
    return this.e.isShowing();
  }
  
  public RelativeLayout.LayoutParams b() {
    return new RelativeLayout.LayoutParams(-1, -2);
  }
  
  public int c() {
    return this.d.getResources().getColor(R.color.window_bg_color);
  }
  
  public void d() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setDuration(200L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.f.setVisibility(8);
    this.f.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_top_out2));
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            this.a.e.a();
          }
        },  320L);
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(PopMenu this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1View, param1Int1, param1Int2, param1Boolean);
    }
    
    public void a() {
      super.dismiss();
    }
    
    public void dismiss() {
      try {
        this.a.d();
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
  
  public static interface onShowListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\PopMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */