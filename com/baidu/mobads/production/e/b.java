package com.baidu.mobads.production.e;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.production.b;
import com.baidu.mobads.production.u;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.vo.d;
import java.util.HashMap;

public class b extends b implements a {
  private RelativeLayout A;
  
  private TextView B;
  
  private CountDownTimer C;
  
  private f D;
  
  private boolean E = false;
  
  private boolean F = false;
  
  private Activity G;
  
  private Boolean H;
  
  public final String y = "html5_intersitial";
  
  protected final IXAdLogger z = XAdSDKFoundationFacade.getInstance().getAdLogger();
  
  public b(Context paramContext, RelativeLayout paramRelativeLayout, Boolean paramBoolean, AdSize paramAdSize, String paramString) {
    super(paramContext);
    setId(paramString);
    setActivity(paramContext);
    setAdSlotBase(paramRelativeLayout);
    this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_INTERSTITIAL;
    this.H = paramBoolean;
    this.D = new f(getApplicationContext(), getActivity(), this.o, Boolean.valueOf(true));
    this.D.c(IXAdConstants4PDK.SlotType.SLOT_TYPE_INTERSTITIAL.getValue());
    this.D.f(paramAdSize.getValue());
    this.D.d(paramString);
    f(paramString);
  }
  
  private RelativeLayout.LayoutParams A() {
    int i = (int)(XAdSDKFoundationFacade.getInstance().getCommonUtils().getScreenDensity(this.f) * 20.0F);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
    layoutParams.addRule(11);
    layoutParams.addRule(10);
    return layoutParams;
  }
  
  private boolean x() {
    return t();
  }
  
  private View y() {
    if (this.A == null) {
      this.A = new RelativeLayout(this.f);
      this.A.setBackgroundColor(Color.argb(42, 0, 0, 0));
      this.B = new TextView(this.f);
      this.B.setTextColor(-65536);
      RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams.addRule(13);
      this.A.addView((View)this.B, (ViewGroup.LayoutParams)layoutParams);
    } 
    this.C = (new e(this, 6000L, 1000L)).start();
    return (View)this.A;
  }
  
  private void z() {
    RelativeLayout relativeLayout = this.A;
    if (relativeLayout != null && relativeLayout.getParent() != null)
      ((ViewGroup)this.A.getParent()).removeView((View)this.A); 
    if (this.C != null) {
      this.z.d("cancel countDownTimer before it finished");
      try {
        this.C.cancel();
        return;
      } catch (Exception exception) {
        this.z.d(exception);
      } 
    } 
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2) {
    if (!this.E && !this.F) {
      this.D.d(paramInt1);
      this.D.e(paramInt2);
      load();
    } 
  }
  
  public void a(Activity paramActivity) {}
  
  public void a(Activity paramActivity, RelativeLayout paramRelativeLayout) {
    try {
      this.z.d("showInterstitialAdInit");
      if (this.E && !this.F) {
        this.F = true;
        this.E = false;
        this.G = paramActivity;
        start();
        v();
        this.e.setBackgroundColor(0);
        RelativeLayout relativeLayout = new RelativeLayout((Context)paramActivity);
        relativeLayout.setBackgroundColor(0);
        paramRelativeLayout.addView((View)relativeLayout, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
        this.e.addView(this.h.getAdView(), (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView((View)this.e, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
        this.h.getAdView().setVisibility(4);
        return;
      } 
      if (this.F) {
        this.z.w("interstitial ad is showing now");
        return;
      } 
      if (!this.E)
        this.z.w("interstitial ad is not ready"); 
      return;
    } catch (Exception exception) {
      this.z.d(exception);
      return;
    } 
  }
  
  public void a(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    this.E = true;
  }
  
  public void a(com.baidu.mobads.openad.d.b paramb, u paramu, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{'ad':[{'id':99999999,'url':'");
    stringBuilder.append(this.D.b());
    stringBuilder.append("', type='");
    stringBuilder.append(IXAdInstanceInfo.CreativeType.HTML.getValue());
    stringBuilder.append("'}],'n':1}");
    paramu.a(paramb, stringBuilder.toString());
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent) {
    return true;
  }
  
  public void b() {
    (new Handler(Looper.getMainLooper())).post(new c(this));
  }
  
  public void b(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    b();
  }
  
  public void b(IXAdResponseInfo paramIXAdResponseInfo) {}
  
  public void c() {}
  
  public void d() {
    this.m = 8000;
  }
  
  public void e(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    v();
    this.F = false;
  }
  
  public void request() {
    a(this.D);
  }
  
  public void start() {
    super.start();
  }
  
  protected boolean t() {
    return (AdSize.InterstitialForVideoBeforePlay.getValue() == this.D.getApt());
  }
  
  public d u() {
    return this.D;
  }
  
  protected void v() {
    Activity activity = this.G;
    if (activity == null)
      return; 
    activity.runOnUiThread(new d(this));
  }
  
  public boolean w() {
    return this.E;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */