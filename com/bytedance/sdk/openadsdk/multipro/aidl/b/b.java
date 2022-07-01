package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonPermissionListener;
import com.bytedance.sdk.openadsdk.utils.h;

public class b extends ICommonPermissionListener.Stub {
  private Handler a = new Handler(Looper.getMainLooper());
  
  private h.a b;
  
  public b(h.a parama) {
    this.b = parama;
  }
  
  private void a(Runnable paramRunnable) {
    if (this.a == null)
      this.a = new Handler(Looper.getMainLooper()); 
    this.a.post(paramRunnable);
  }
  
  public void onDenied(String paramString) throws RemoteException {
    a(new Runnable(this, paramString) {
          public void run() {
            if (b.a(this.b) != null)
              b.a(this.b).a(this.a); 
          }
        });
  }
  
  public void onGranted() throws RemoteException {
    a(new Runnable(this) {
          public void run() {
            if (b.a(this.a) != null)
              b.a(this.a).a(); 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\aidl\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */