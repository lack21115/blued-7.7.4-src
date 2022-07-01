package com.blued.android.module.live_china.view;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveFloatManager;

public class LiveCueView {
  public View a;
  
  public View b;
  
  public View c;
  
  public Context d;
  
  public LayoutInflater e;
  
  private TextView f;
  
  private MyPopupWindow g;
  
  private String h = "";
  
  private boolean i = true;
  
  private int j = 5000;
  
  public LiveCueView(Context paramContext, String paramString) {
    this.h = paramString;
    this.d = paramContext;
    f();
  }
  
  public LiveCueView(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, int paramInt6, int paramInt7) {
    this.h = paramString;
    this.d = paramContext;
    this.i = paramBoolean;
    this.j = paramInt7;
    f();
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
    layoutParams.leftMargin = DensityUtils.a(this.d, paramInt2);
    layoutParams.topMargin = DensityUtils.a(this.d, paramInt3);
    layoutParams.rightMargin = DensityUtils.a(this.d, paramInt4);
    layoutParams.bottomMargin = DensityUtils.a(this.d, paramInt5);
    layoutParams.gravity = paramInt1;
    this.c.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    if (paramInt6 != 0)
      this.c.setBackgroundResource(paramInt6); 
  }
  
  public static void a(Context paramContext, String paramString) {
    (new LiveCueView(paramContext, paramString)).b();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, int paramInt6, int paramInt7) {
    (new LiveCueView(paramContext, paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean, paramInt6, paramInt7)).b();
  }
  
  private void f() {
    this.e = LayoutInflater.from(this.d);
    a();
    this.b = this.a.findViewById(R.id.tv_bg);
    this.b.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.d();
          }
        });
    this.c = this.a.findViewById(R.id.ll_content);
    this.c.setVisibility(8);
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.g = new MyPopupWindow(this, this.a, -1, -1, true);
    this.g.setBackgroundDrawable(this.d.getResources().getDrawable(17170445));
    this.g.setTouchable(true);
    this.g.setOutsideTouchable(true);
    this.g.setFocusable(true);
    this.g.update();
    this.f = (TextView)this.a.findViewById(R.id.cue_text);
    this.f.setText(this.h);
  }
  
  private void g() {
    int i = DensityUtils.a(this.d, 3.6F);
    int j = DensityUtils.a(this.d, 3.6F);
    int k = DensityUtils.a(this.d, 3.6F);
    View view = this.c;
    float f1 = i;
    float f2 = -i;
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, "translationY", new float[] { 0.0F, f1, f2, f1, f2, j, -j, k, -k, 0.0F }).setDuration(5000L);
    objectAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
    objectAnimator.start();
  }
  
  public void a() {
    if (LiveFloatManager.a().B()) {
      this.a = this.e.inflate(R.layout.pop_cue_view_center, null);
      return;
    } 
    this.a = this.e.inflate(R.layout.pop_cue_view, null);
  }
  
  public void b() {
    this.b.clearAnimation();
    this.c.clearAnimation();
    if (this.g.isShowing())
      this.g.a(); 
    this.g.showAtLocation(this.a, 49, 0, 0);
    this.c.setVisibility(0);
    c();
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            this.a.d();
          }
        },  this.j);
  }
  
  public void c() {
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_in));
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            if (LiveCueView.a(this.a))
              LiveCueView.b(this.a); 
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
  }
  
  public void d() {
    if (this.c.getVisibility() == 8)
      return; 
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            LiveCueView.c(this.a).a();
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
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_out));
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(LiveCueView this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveCueView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */