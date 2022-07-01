package com.alipay.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.sys.a;

class h extends IRemoteServiceCallback.Stub {
  h(e parame) {}
  
  public boolean isHideLoadingScreen() throws RemoteException {
    return false;
  }
  
  public void payEnd(boolean paramBoolean, String paramString) throws RemoteException {}
  
  public void startActivity(String paramString1, String paramString2, int paramInt, Bundle paramBundle) throws RemoteException {
    Intent intent = new Intent("android.intent.action.MAIN", null);
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = new Bundle(); 
    try {
      bundle.putInt("CallingPid", paramInt);
      intent.putExtras(bundle);
    } catch (Exception exception) {
      a.a(e.a(this.a), "biz", "ErrIntentEx", exception);
    } 
    intent.setClassName(paramString1, paramString2);
    try {
      Activity activity = e.c(this.a);
      if (activity != null) {
        long l = SystemClock.elapsedRealtime();
        e.c(this.a).startActivity(intent);
        a a = e.a(this.a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(SystemClock.elapsedRealtime() - l);
        a.b(a, "biz", "stAct2", stringBuilder.toString());
      } else {
        a.a(e.a(this.a), "biz", "ErrActNull", "");
        Context context = e.a(this.a).b();
        if (context != null)
          context.startActivity(intent); 
      } 
      return;
    } finally {
      a.a(e.a(this.a), "biz", "ErrActNull", (Throwable)paramString1);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sd\\util\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */