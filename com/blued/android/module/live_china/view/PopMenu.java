package com.blued.android.module.live_china.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import com.blued.android.core.AppInfo;
import com.blued.android.module.res_china.R;

public class PopMenu {
  public View a;
  
  public View b;
  
  public Context c;
  
  public MyPopupWindow d;
  
  public ViewGroup e;
  
  public onShowListener f;
  
  public void a() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setDuration(200L);
    alphaAnimation.setFillAfter(true);
    this.a.startAnimation((Animation)alphaAnimation);
    this.e.setVisibility(8);
    this.e.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_top_out2));
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            this.a.d.a();
          }
        },  320L);
  }
  
  class MyPopupWindow extends PopupWindow {
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
  
  public static interface onShowListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */