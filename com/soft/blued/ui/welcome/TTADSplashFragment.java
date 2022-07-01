package com.soft.blued.ui.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.welcome.model.SplashEntity;
import com.soft.blued.utils.third.TTADUtils;

public class TTADSplashFragment extends TimeoutFragment {
  public static boolean d = false;
  
  public Context e;
  
  public View f;
  
  public long g;
  
  public boolean h = false;
  
  private String[] i;
  
  private String[] j;
  
  private String[] k;
  
  private FrameLayout l;
  
  private View m;
  
  private View n;
  
  private String o;
  
  public static void a(Fragment paramFragment, SplashEntity.ShowEntity paramShowEntity, String paramString, int paramInt) {
    if (paramShowEntity != null && !d && paramFragment.isAdded()) {
      d = true;
      Bundle bundle = new Bundle();
      bundle.putStringArray("KEY_SHOW_URL", paramShowEntity.show_url);
      bundle.putStringArray("KEY_CLICK_URL", paramShowEntity.click_url);
      bundle.putStringArray("KEY_HIDDEN_URL", paramShowEntity.hidden_url);
      bundle.putString("SPLASH_ID", paramString);
      bundle.putInt("timeout_ms", 5000);
      TerminalActivity.a(bundle);
      TerminalActivity.a(paramFragment, TTADSplashFragment.class, bundle, paramInt);
    } 
  }
  
  private void l() {
    FragmentActivity fragmentActivity = getActivity();
    if (fragmentActivity != null) {
      d = false;
      Intent intent = new Intent();
      long l2 = this.g;
      long l1 = l2;
      if (l2 == 0L)
        l1 = System.currentTimeMillis(); 
      intent.putExtra("THIRD_UNVALID_DURATION", l1);
      intent.putExtra("THIRD_HAS_CALL_BACK", this.h);
      fragmentActivity.setResult(-1, intent);
      fragmentActivity.finish();
    } 
  }
  
  public void a() {
    l();
  }
  
  public void a(TTSplashAd paramTTSplashAd) {
    if (paramTTSplashAd == null)
      return; 
    View view = paramTTSplashAd.getSplashView();
    FragmentActivity fragmentActivity = getActivity();
    if (view != null && this.l != null && fragmentActivity != null && !fragmentActivity.isFinishing()) {
      this.l.removeAllViews();
      this.l.addView(view);
    } else {
      l();
    } 
    paramTTSplashAd.setSplashInteractionListener(new TTSplashAd.AdInteractionListener(this) {
          public void onAdClicked(View param1View, int param1Int) {
            FindHttpUtils.a(TTADSplashFragment.b(this.a));
          }
          
          public void onAdShow(View param1View, int param1Int) {
            TTADSplashFragment tTADSplashFragment = this.a;
            tTADSplashFragment.h = true;
            tTADSplashFragment.g = System.currentTimeMillis();
            FindHttpUtils.a(TTADSplashFragment.c(this.a));
            TTADSplashFragment.d(this.a).setBackgroundColor(this.a.e.getResources().getColor(2131100980));
          }
          
          public void onAdSkip() {
            FindHttpUtils.a(TTADSplashFragment.e(this.a));
            TTADSplashFragment.a(this.a);
          }
          
          public void onAdTimeOver() {
            TTADSplashFragment.a(this.a);
          }
        });
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent) {
    return (paramInt == 4 || paramInt == 3) ? true : super.a(paramInt, paramKeyEvent);
  }
  
  public boolean j() {
    return false;
  }
  
  public void k() {
    getActivity().getWindow().getDecorView().setBackground(BluedSkinUtils.b(this.e, 2131231042));
    this.l = (FrameLayout)this.f.findViewById(2131297078);
    this.m = this.f.findViewById(2131298750);
    this.m.setVisibility(8);
    this.n = this.f.findViewById(2131301624);
    this.n.setVisibility(0);
    this.n.setBackgroundColor(this.e.getResources().getColor(2131100897));
    TTADUtils.a(this.e, this.o, new TTADUtils.TTGetSplashAdListener(this) {
          public void a() {
            Log.v("drb", "getSplashAD onError");
            TTADSplashFragment.a(this.a);
          }
          
          public void a(TTSplashAd param1TTSplashAd) {
            Log.v("drb", "getSplashAD onSuccess");
            this.a.a(param1TTSplashAd);
          }
          
          public void b() {
            Log.v("drb", "getSplashAD onNoAD");
            TTADSplashFragment tTADSplashFragment = this.a;
            tTADSplashFragment.h = true;
            TTADSplashFragment.a(tTADSplashFragment);
          }
        });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    StringBuilder stringBuilder;
    this.e = (Context)getActivity();
    getActivity().overridePendingTransition(2130771986, 2130771986);
    View view = this.f;
    if (view == null) {
      if (getArguments() != null) {
        this.i = getArguments().getStringArray("KEY_SHOW_URL");
        this.j = getArguments().getStringArray("KEY_CLICK_URL");
        this.k = getArguments().getStringArray("KEY_HIDDEN_URL");
        this.o = getArguments().getString("SPLASH_ID");
        stringBuilder = new StringBuilder();
        stringBuilder.append("splash_id:");
        stringBuilder.append(this.o);
        Log.v("drb", stringBuilder.toString());
      } 
      this.f = paramLayoutInflater.inflate(2131493333, paramViewGroup, false);
      k();
    } else if (stringBuilder.getParent() != null) {
      ((ViewGroup)this.f.getParent()).removeView(this.f);
    } 
    return this.f;
  }
  
  public void onDestroy() {
    super.onDestroy();
    d = false;
  }
  
  public void onResume() {
    super.onResume();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\welcome\TTADSplashFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */