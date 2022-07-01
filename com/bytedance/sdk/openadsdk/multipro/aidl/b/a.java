package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.ICommonDialogListener;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.t;

public class a extends ICommonDialogListener.Stub {
  private Handler a = new Handler(Looper.getMainLooper());
  
  private g.a b;
  
  public a(g.a parama) {
    this.b = parama;
  }
  
  private void a(Runnable paramRunnable) {
    this.a.post(paramRunnable);
  }
  
  public void onDialogBtnNo() throws RemoteException {
    t.b("CommonDialogListenerImpl", "CommonDialogListenerImpl: onDialogBtnNo");
    a(new Runnable(this) {
          public void run() {
            if (a.a(this.a) != null)
              a.a(this.a).b(); 
          }
        });
  }
  
  public void onDialogBtnYes() throws RemoteException {
    t.b("CommonDialogListenerImpl", "CommonDialogListenerImpl: onDialogBtnYes");
    a(new Runnable(this) {
          public void run() {
            if (a.a(this.a) != null)
              a.a(this.a).a(); 
          }
        });
  }
  
  public void onDialogCancel() throws RemoteException {
    t.b("CommonDialogListenerImpl", "CommonDialogListenerImpl: onDialogCancel");
    a(new Runnable(this) {
          public void run() {
            if (a.a(this.a) != null)
              a.a(this.a).c(); 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\aidl\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */