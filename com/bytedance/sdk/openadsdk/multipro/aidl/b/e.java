package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ITTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;

public class e extends ITTAppDownloadListener.Stub {
  private volatile TTAppDownloadListener a;
  
  private Handler b = new Handler(Looper.getMainLooper());
  
  public e(TTAppDownloadListener paramTTAppDownloadListener) {
    this.a = paramTTAppDownloadListener;
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
  
  private boolean c() {
    return (this.a != null);
  }
  
  public void a() {
    this.a = null;
    this.b = null;
  }
  
  public void onDownloadActive(long paramLong1, long paramLong2, String paramString1, String paramString2) throws RemoteException {
    if (this.a != null)
      b().post(new Runnable(this, paramLong1, paramLong2, paramString1, paramString2) {
            public void run() {
              if (!e.a(this.e))
                return; 
              e.b(this.e).onDownloadActive(this.a, this.b, this.c, this.d);
            }
          }); 
  }
  
  public void onDownloadFailed(long paramLong1, long paramLong2, String paramString1, String paramString2) throws RemoteException {
    if (this.a != null)
      b().post(new Runnable(this, paramLong1, paramLong2, paramString1, paramString2) {
            public void run() {
              if (!e.a(this.e))
                return; 
              e.b(this.e).onDownloadFailed(this.a, this.b, this.c, this.d);
            }
          }); 
  }
  
  public void onDownloadFinished(long paramLong, String paramString1, String paramString2) throws RemoteException {
    if (this.a != null)
      b().post(new Runnable(this, paramLong, paramString1, paramString2) {
            public void run() {
              if (!e.a(this.d))
                return; 
              e.b(this.d).onDownloadFinished(this.a, this.b, this.c);
            }
          }); 
  }
  
  public void onDownloadPaused(long paramLong1, long paramLong2, String paramString1, String paramString2) throws RemoteException {
    if (this.a != null)
      b().post(new Runnable(this, paramLong1, paramLong2, paramString1, paramString2) {
            public void run() {
              if (!e.a(this.e))
                return; 
              e.b(this.e).onDownloadPaused(this.a, this.b, this.c, this.d);
            }
          }); 
  }
  
  public void onIdle() throws RemoteException {
    if (this.a != null)
      b().post(new Runnable(this) {
            public void run() {
              if (!e.a(this.a))
                return; 
              e.b(this.a).onIdle();
            }
          }); 
  }
  
  public void onInstalled(String paramString1, String paramString2) throws RemoteException {
    if (this.a != null)
      b().post(new Runnable(this, paramString1, paramString2) {
            public void run() {
              if (!e.a(this.c))
                return; 
              e.b(this.c).onInstalled(this.a, this.b);
            }
          }); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\aidl\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */