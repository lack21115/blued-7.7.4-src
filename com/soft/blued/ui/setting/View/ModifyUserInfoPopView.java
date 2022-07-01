package com.soft.blued.ui.setting.View;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;

public class ModifyUserInfoPopView {
  public View a;
  
  public View b;
  
  public View c;
  
  public Context d;
  
  public LayoutInflater e;
  
  private TextView f;
  
  private TextView g;
  
  private MyPopupWindow h;
  
  private String i = "";
  
  private String j = "";
  
  private View.OnClickListener k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  public ModifyUserInfoPopView(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener) {
    this.i = paramString1;
    this.j = paramString2;
    this.d = paramContext;
    this.k = paramOnClickListener;
    this.l = paramInt1;
    this.m = paramInt2;
    this.n = paramInt3;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("top:");
    stringBuilder.append(paramInt3);
    stringBuilder.append("--right:");
    stringBuilder.append(paramInt2);
    Log.v("drb", stringBuilder.toString());
    f();
  }
  
  private void f() {
    this.e = LayoutInflater.from(this.d);
    a();
    this.b = this.a.findViewById(2131300559);
    this.b.setBackgroundColor(this.d.getResources().getColor(2131100897));
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.c = this.a.findViewById(2131298758);
    this.c.setVisibility(8);
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.h = new MyPopupWindow(this, this.a, -1, -1, true);
    this.h.setBackgroundDrawable(this.d.getResources().getDrawable(17170445));
    this.h.setTouchable(true);
    this.h.setOutsideTouchable(true);
    this.h.setFocusable(true);
    this.h.update();
    this.f = (TextView)this.a.findViewById(2131301377);
    this.g = (TextView)this.a.findViewById(2131300590);
    this.f.setText(this.i);
    this.g.setText(this.j);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
    layoutParams.rightMargin = this.m;
    layoutParams.topMargin = this.n;
    layoutParams.gravity = this.l;
    this.c.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (ModifyUserInfoPopView.a(this.a) != null)
              ModifyUserInfoPopView.a(this.a).onClick(param1View); 
          }
        });
  }
  
  private void g() {
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, 2130772055));
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {}
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
  }
  
  public void a() {
    this.a = this.e.inflate(2131493947, null);
  }
  
  public boolean b() {
    return (this.c.getVisibility() == 0);
  }
  
  public void c() {
    this.b.clearAnimation();
    this.c.clearAnimation();
    if (this.h.isShowing())
      this.h.a(); 
    this.h.showAtLocation(this.a, 49, 0, 0);
    this.c.setVisibility(0);
    g();
  }
  
  public void d() {
    if (this.c.getVisibility() == 8)
      return; 
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            ModifyUserInfoPopView.b(this.a).a();
          }
        },  320L);
    e();
    this.c.setVisibility(8);
  }
  
  public void e() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, 2130772056));
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(ModifyUserInfoPopView this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1View, param1Int1, param1Int2, param1Boolean);
    }
    
    public void a() {
      if (this.a.d instanceof Activity && Build.VERSION.SDK_INT >= 17 && !((Activity)this.a.d).isFinishing() && !((Activity)this.a.d).isDestroyed())
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
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\View\ModifyUserInfoPopView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */