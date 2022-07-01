package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

public class d extends IRewardAdInteractionListener.Stub {
  private TTRewardVideoAd.RewardAdInteractionListener a;
  
  private Handler b = new Handler(Looper.getMainLooper());
  
  public d(TTRewardVideoAd.RewardAdInteractionListener paramRewardAdInteractionListener) {
    this.a = paramRewardAdInteractionListener;
  }
  
  private void a() {
    this.a = null;
    this.b = null;
  }
  
  private Handler b() {
    Handler handler2 = this.b;
    Handler handler1 = handler2;
    if (handler2 == null) {
      handler1 = new Handler(Looper.getMainLooper());
      this.b = handler1;
    } 
    return handler1;
  }
  
  public void onAdClose() throws RemoteException {
    b().post(new Runnable(this) {
          public void run() {
            if (d.a(this.a) != null)
              d.a(this.a).onAdClose(); 
          }
        });
  }
  
  public void onAdShow() throws RemoteException {
    b().post(new Runnable(this) {
          public void run() {
            if (d.a(this.a) != null)
              d.a(this.a).onAdShow(); 
          }
        });
  }
  
  public void onAdVideoBarClick() throws RemoteException {
    b().post(new Runnable(this) {
          public void run() {
            if (d.a(this.a) != null)
              d.a(this.a).onAdVideoBarClick(); 
          }
        });
  }
  
  public void onDestroy() throws RemoteException {
    a();
  }
  
  public void onRewardVerify(boolean paramBoolean, int paramInt, String paramString) throws RemoteException {
    b().post(new Runnable(this, paramBoolean, paramInt, paramString) {
          public void run() {
            if (d.a(this.d) != null)
              d.a(this.d).onRewardVerify(this.a, this.b, this.c); 
          }
        });
  }
  
  public void onSkippedVideo() throws RemoteException {
    b().post(new Runnable(this) {
          public void run() {
            if (d.a(this.a) != null)
              d.a(this.a).onSkippedVideo(); 
          }
        });
  }
  
  public void onVideoComplete() throws RemoteException {
    b().post(new Runnable(this) {
          public void run() {
            if (d.a(this.a) != null)
              d.a(this.a).onVideoComplete(); 
          }
        });
  }
  
  public void onVideoError() throws RemoteException {
    b().post(new Runnable(this) {
          public void run() {
            if (d.a(this.a) != null)
              d.a(this.a).onVideoError(); 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\aidl\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */