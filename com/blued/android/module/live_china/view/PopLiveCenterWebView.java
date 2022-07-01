package com.blued.android.module.live_china.view;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.web.LiveWebCallBack;

public class PopLiveCenterWebView extends FrameLayout {
  public View a;
  
  public View b;
  
  public View c;
  
  public Context d;
  
  public LayoutInflater e;
  
  private boolean f = false;
  
  private Dialog g;
  
  private BluedWebView h;
  
  private ImageView i;
  
  private WebView j;
  
  private LiveConnectionView k;
  
  public PopLiveCenterWebView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public PopLiveCenterWebView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PopLiveCenterWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = paramContext;
    e();
  }
  
  private void e() {
    this.e = LayoutInflater.from(this.d);
    a();
    this.b = this.a.findViewById(R.id.tv_bg);
    this.b.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.b();
          }
        });
    this.c = this.a.findViewById(R.id.ll_content);
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.i = (ImageView)this.a.findViewById(R.id.live_pk_center_explain_close);
    this.i.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.b();
          }
        });
    this.g = DialogUtils.a(this.d);
  }
  
  private void f() {
    this.j = (WebView)this.a.findViewById(R.id.live_pk_center_explain_webview);
    this.h = new BluedWebView((Fragment)this.k.a, this.j, null, (BluedWebView.WebCallback)new LiveWebCallBack(this) {
          public void b(BluedWebView param1BluedWebView, String param1String, boolean param1Boolean) {
            PopLiveCenterWebView.a(this.a, true);
            DialogUtils.b(PopLiveCenterWebView.a(this.a));
          }
        });
  }
  
  private void g() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_out));
  }
  
  public void a() {
    this.a = this.e.inflate(R.layout.pop_live_pk_center, (ViewGroup)this);
  }
  
  public void a(LiveConnectionView paramLiveConnectionView) {
    this.k = paramLiveConnectionView;
    f();
  }
  
  public void a(String paramString) {
    setVisibility(0);
    this.c.setVisibility(0);
    this.c.clearAnimation();
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_in));
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this, paramString) {
          public void onAnimationEnd(Animation param1Animation) {
            PopLiveCenterWebView.b(this.b).a(this.a);
            DialogUtils.a(PopLiveCenterWebView.a(this.b));
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
  }
  
  public void b() {
    if (this.c.getVisibility() == 8)
      return; 
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            this.a.setVisibility(8);
          }
        },  320L);
    g();
    this.c.setVisibility(8);
  }
  
  public boolean c() {
    return (getVisibility() == 0);
  }
  
  public void d() {
    b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopLiveCenterWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */