package com.blued.android.module.media.selector.widget;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.blued.android.core.AppInfo;
import com.blued.android.module.media.selector.R;
import java.util.TimerTask;

public class PopMenu {
  private static boolean f = false;
  
  private ViewGroup a;
  
  private View b;
  
  private View c;
  
  private Context d;
  
  private MyPopupWindow e;
  
  public PopMenu(Context paramContext, View paramView) {
    this.d = paramContext;
    this.a = (ViewGroup)new FrameLayout(paramContext);
    this.b = new View(paramContext);
    this.b.setBackgroundColor(-16777216);
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.a();
          }
        });
    this.c = paramView;
    this.c.setBackgroundColor(this.d.getResources().getColor(R.color.window_bg_color));
    this.c.setVisibility(8);
    this.a.addView(this.b, -1, -1);
    this.a.addView(this.c, -1, -2);
    this.e = new MyPopupWindow(this, (View)this.a, -1, -1, true);
    this.e.setBackgroundDrawable(this.d.getResources().getDrawable(17170445));
    this.e.setTouchable(true);
    this.e.setOutsideTouchable(true);
    this.e.setFocusable(true);
    this.e.setAnimationStyle(R.style.PopupAnimation);
    this.e.update();
  }
  
  public void a() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(200L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.c.setVisibility(8);
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_top_out2));
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            PopMenu.d(this.a).a();
          }
        },  320L);
  }
  
  public void a(View paramView) {
    this.b.clearAnimation();
    this.c.clearAnimation();
    if (this.e.isShowing())
      this.e.a(); 
    if (Build.VERSION.SDK_INT < 24) {
      this.e.showAsDropDown(paramView);
    } else {
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[1] + paramView.getHeight();
      if (Build.VERSION.SDK_INT >= 25) {
        int j = ((WindowManager)this.d.getSystemService("window")).getDefaultDisplay().getHeight();
        this.e.setHeight(j - i);
      } 
      this.e.showAtLocation(paramView, 0, 0, i);
    } 
    this.c.setVisibility(8);
    this.b.setVisibility(8);
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
            alphaAnimation.setDuration(200L);
            alphaAnimation.setFillAfter(true);
            PopMenu.a(this.a).startAnimation((Animation)alphaAnimation);
            PopMenu.a(this.a).setVisibility(0);
            PopMenu.c(this.a).startAnimation(AnimationUtils.loadAnimation(PopMenu.b(this.a), R.anim.push_top_in2));
            PopMenu.c(this.a).setVisibility(0);
          }
        }50L);
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener) {
    this.e.setOnDismissListener(paramOnDismissListener);
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
        this.a.a();
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selector\widget\PopMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */