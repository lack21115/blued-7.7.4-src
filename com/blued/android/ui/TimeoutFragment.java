package com.blued.android.ui;

import android.os.Bundle;
import com.blued.android.core.ui.BaseFragment;
import in.xiandan.countdowntimer.CountDownTimerSupport;
import in.xiandan.countdowntimer.OnCountDownTimerListener;

public abstract class TimeoutFragment extends BaseFragment {
  private static final String d = TimeoutFragment.class.getName();
  
  private int e = 0;
  
  private CountDownTimerSupport f;
  
  private void k() {
    int i = this.e;
    if (i <= 0)
      return; 
    CountDownTimerSupport countDownTimerSupport = this.f;
    if (countDownTimerSupport == null) {
      this.f = new CountDownTimerSupport(i, i);
      this.f.a(new OnCountDownTimerListener(this) {
            public void a() {
              this.a.a();
            }
            
            public void a(long param1Long) {}
            
            public void b() {}
          });
      this.f.a();
      return;
    } 
    countDownTimerSupport.c();
  }
  
  private void l() {
    CountDownTimerSupport countDownTimerSupport = this.f;
    if (countDownTimerSupport != null)
      try {
        countDownTimerSupport.b();
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  private void m() {
    CountDownTimerSupport countDownTimerSupport = this.f;
    if (countDownTimerSupport != null)
      countDownTimerSupport.d(); 
  }
  
  protected abstract void a();
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
      this.e = paramBundle.getInt("timeout_ms", 0); 
  }
  
  public void onDestroy() {
    super.onDestroy();
    m();
  }
  
  public void onPause() {
    super.onPause();
    l();
  }
  
  public void onResume() {
    super.onResume();
    k();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\androi\\ui\TimeoutFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */