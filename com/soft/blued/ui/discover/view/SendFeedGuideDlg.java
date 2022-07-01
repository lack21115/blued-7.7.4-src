package com.soft.blued.ui.discover.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.common.view.CubicInterpolator;
import com.soft.blued.manager.SendNotificationManager;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;

public class SendFeedGuideDlg extends Dialog {
  private View a;
  
  private View b;
  
  private View c;
  
  private View d;
  
  private BluedIngSelfFeed e;
  
  private Runnable f = new Runnable(this) {
      public void run() {
        SendFeedGuideDlg.c(this.a);
      }
    };
  
  public SendFeedGuideDlg(Context paramContext, int paramInt) {
    super(paramContext, paramInt);
    a();
  }
  
  private void a() {
    this.a = LayoutInflater.from(getContext()).inflate(2131493042, null);
    this.c = this.a.findViewById(2131296952);
    this.d = this.a.findViewById(2131296951);
    this.d.setOnClickListener(new -$$Lambda$SendFeedGuideDlg$CuG1EpzweHep_jfW7y8R4HFP-5s(this));
    this.b = this.a.findViewById(2131296953);
    setContentView(this.a);
    StatusBarHelper.a(getWindow());
    setCancelable(false);
    setOnDismissListener(new DialogInterface.OnDismissListener(this) {
          public void onDismiss(DialogInterface param1DialogInterface) {
            SendNotificationManager.a().a(SendFeedGuideDlg.a(this.a));
          }
        });
  }
  
  private void b() {
    AppInfo.n().removeCallbacks(this.f);
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setDuration(370L);
    alphaAnimation.setInterpolator((Interpolator)new CubicInterpolator(0.66F, 0.01F, 0.34F, 1.0F));
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.dismiss();
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.c.startAnimation((Animation)alphaAnimation);
    this.c.postDelayed(new Runnable(this) {
          public void run() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
            alphaAnimation.setDuration(165L);
            alphaAnimation.setInterpolator((Interpolator)new CubicInterpolator(0.17F, 0.17F, 0.83F, 1.0F));
            SendFeedGuideDlg.b(this.a).startAnimation((Animation)alphaAnimation);
          }
        }200L);
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed) {
    this.e = paramBluedIngSelfFeed;
  }
  
  protected void onCreate(Bundle paramBundle) {
    if (Build.VERSION.SDK_INT >= 28) {
      WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
      layoutParams.layoutInDisplayCutoutMode = 1;
      getWindow().setAttributes(layoutParams);
    } 
    super.onCreate(paramBundle);
  }
  
  public void show() {
    super.show();
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
    alphaAnimation.setInterpolator((Interpolator)new CubicInterpolator(0.48F, 0.05F, 0.83F, 0.83F));
    alphaAnimation.setDuration(330L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    alphaAnimation.setDuration(410L);
    alphaAnimation.setInterpolator((Interpolator)new CubicInterpolator(0.66F, 0.01F, 0.34F, 1.0F));
    this.c.startAnimation((Animation)alphaAnimation);
    AppInfo.n().postDelayed(this.f, 2000L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\view\SendFeedGuideDlg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */