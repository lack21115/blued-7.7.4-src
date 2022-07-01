package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;

public class c extends IFullScreenVideoAdInteractionListener.Stub {
  private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener a;
  
  private Handler b = new Handler(Looper.getMainLooper());
  
  public c(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener paramFullScreenVideoAdInteractionListener) {
    this.a = paramFullScreenVideoAdInteractionListener;
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
            if (c.a(this.a) != null)
              c.a(this.a).onAdClose(); 
          }
        });
  }
  
  public void onAdShow() throws RemoteException {
    b().post(new Runnable(this) {
          public void run() {
            if (c.a(this.a) != null)
              c.a(this.a).onAdShow(); 
          }
        });
  }
  
  public void onAdVideoBarClick() throws RemoteException {
    b().post(new Runnable(this) {
          public void run() {
            if (c.a(this.a) != null)
              c.a(this.a).onAdVideoBarClick(); 
          }
        });
  }
  
  public void onDestroy() throws RemoteException {
    a();
  }
  
  public void onSkippedVideo() throws RemoteException {
    b().post(new Runnable(this) {
          public void run() {
            if (c.a(this.a) != null)
              c.a(this.a).onSkippedVideo(); 
          }
        });
  }
  
  public void onVideoComplete() throws RemoteException {
    b().post(new Runnable(this) {
          public void run() {
            if (c.a(this.a) != null)
              c.a(this.a).onVideoComplete(); 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\aidl\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */