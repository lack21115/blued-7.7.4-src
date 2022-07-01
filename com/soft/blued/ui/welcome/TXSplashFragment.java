package com.soft.blued.ui.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.ui.TimeoutFragment;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
import com.soft.blued.BluedConstant;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.welcome.model.SplashEntity;
import com.soft.blued.utils.Logger;

public class TXSplashFragment extends TimeoutFragment implements SplashADListener {
  public static boolean g = false;
  
  public Context d;
  
  public View e;
  
  public boolean f = false;
  
  public long h;
  
  public boolean i = false;
  
  private FrameLayout j;
  
  private View k;
  
  private SplashAD l;
  
  private int m = 500;
  
  private String[] n;
  
  private String[] o;
  
  private View p;
  
  private long q = 0L;
  
  private Handler r = new Handler(Looper.getMainLooper());
  
  public static void a(Fragment paramFragment, SplashEntity.ShowEntity paramShowEntity, int paramInt) {
    if (paramShowEntity != null && !g && paramFragment.isAdded()) {
      g = true;
      Bundle bundle = new Bundle();
      bundle.putStringArray("KEY_SHOW_URL", paramShowEntity.show_url);
      bundle.putStringArray("KEY_CLICK_URL", paramShowEntity.click_url);
      bundle.putStringArray("KEY_HIDDEN_URL", paramShowEntity.hidden_url);
      bundle.putInt("timeout_ms", 5000);
      TerminalActivity.a(bundle);
      TerminalActivity.a(paramFragment, TXSplashFragment.class, bundle, paramInt);
    } 
  }
  
  private void m() {
    this.q = System.currentTimeMillis();
    this.l = new SplashAD((Context)getActivity(), this.k, l(), this, 3000);
    this.l.fetchAndShowIn((ViewGroup)this.j);
  }
  
  private void n() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("next:");
    stringBuilder.append(this.f);
    Log.v("drb", stringBuilder.toString());
    if (this.f) {
      o();
      return;
    } 
    this.f = true;
  }
  
  private void o() {
    FragmentActivity fragmentActivity = getActivity();
    if (fragmentActivity != null) {
      g = false;
      Intent intent = new Intent();
      long l2 = this.h;
      long l1 = l2;
      if (l2 == 0L)
        l1 = System.currentTimeMillis(); 
      intent.putExtra("THIRD_UNVALID_DURATION", l1);
      intent.putExtra("THIRD_HAS_CALL_BACK", this.i);
      fragmentActivity.setResult(-1, intent);
      fragmentActivity.finish();
    } 
  }
  
  public void a() {
    o();
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent) {
    return (paramInt == 4 || paramInt == 3) ? true : super.a(paramInt, paramKeyEvent);
  }
  
  public boolean j() {
    return false;
  }
  
  public void k() {
    getActivity().getWindow().getDecorView().setBackground(BluedSkinUtils.b(this.d, 2131231042));
    this.j = (FrameLayout)this.e.findViewById(2131297078);
    this.k = this.e.findViewById(2131298750);
    this.p = this.e.findViewById(2131301624);
    this.p.setVisibility(0);
    this.p.setBackgroundColor(this.d.getResources().getColor(2131100897));
  }
  
  public String l() {
    return BluedConstant.d();
  }
  
  public void onADClicked() {
    Object object;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SplashADClicked clickUrl: ");
    if (this.l.getExt() != null) {
      object = this.l.getExt().get("clickUrl");
    } else {
      object = "";
    } 
    stringBuilder.append(object);
    Logger.b("AD_DEMO", new Object[] { stringBuilder.toString() });
    FindHttpUtils.a(this.o);
  }
  
  public void onADDismissed() {
    Logger.b("AD_DEMO", new Object[] { "SplashADDismissed" });
    Log.v("drb", "onADDismissed next");
    n();
  }
  
  public void onADExposure() {
    Logger.b("AD_DEMO", new Object[] { "SplashADExposure" });
  }
  
  public void onADLoaded(long paramLong) {}
  
  public void onADPresent() {
    this.h = System.currentTimeMillis();
    this.i = true;
    Logger.b("AD_DEMO", new Object[] { "SplashADPresent" });
    this.k.setVisibility(0);
    FindHttpUtils.a(this.n);
    this.p.setBackgroundColor(this.d.getResources().getColor(2131100980));
  }
  
  public void onADTick(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SplashADTick ");
    stringBuilder.append(paramLong);
    stringBuilder.append("ms");
    Logger.b("AD_DEMO", new Object[] { stringBuilder.toString() });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    Logger.c("welcomeadljx", new Object[] { "txsplashfragment createview" });
    this.d = (Context)getActivity();
    getActivity().overridePendingTransition(2130771986, 2130771986);
    View view = this.e;
    if (view == null) {
      if (getArguments() != null) {
        this.n = getArguments().getStringArray("KEY_SHOW_URL");
        this.o = getArguments().getStringArray("KEY_CLICK_URL");
        getArguments().getStringArray("KEY_HIDDEN_URL");
      } 
      this.e = paramLayoutInflater.inflate(2131493333, paramViewGroup, false);
      k();
      m();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    Logger.c("welcomeadljx", new Object[] { "txsplashfragment created" });
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.r.removeCallbacksAndMessages(null);
  }
  
  public void onNoAD(AdError paramAdError) {
    this.i = true;
    Logger.b("AD_DEMO", new Object[] { String.format("LoadSplashADFail, eCode=%d, errorMsg=%s", new Object[] { Integer.valueOf(paramAdError.getErrorCode()), paramAdError.getErrorMsg() }) });
    long l = System.currentTimeMillis() - this.q;
    int i = this.m;
    if (l > i) {
      l = 0L;
    } else {
      l = i - l;
    } 
    this.r.postDelayed(new Runnable(this) {
          public void run() {
            Log.v("drb", "onNoAD finish");
            TXSplashFragment.a(this.a);
          }
        }l);
  }
  
  public void onPause() {
    super.onPause();
    this.f = false;
  }
  
  public void onResume() {
    super.onResume();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onResume canJump:");
    stringBuilder.append(this.f);
    Log.v("drb", stringBuilder.toString());
    if (this.f)
      n(); 
    this.f = true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\welcome\TXSplashFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */