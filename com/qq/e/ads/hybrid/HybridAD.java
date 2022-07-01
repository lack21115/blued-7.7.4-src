package com.qq.e.ads.hybrid;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class HybridAD implements HADI {
  private volatile boolean a;
  
  private volatile boolean b;
  
  private volatile boolean c;
  
  private HADI d;
  
  private HybridADListener e;
  
  private CountDownLatch f = new CountDownLatch(1);
  
  public HybridAD(Context paramContext, HybridADSetting paramHybridADSetting, HybridADListener paramHybridADListener) {
    if (GDTADManager.getInstance().isInitialized()) {
      a(paramContext, GDTADManager.getInstance().getAppStatus().getAPPID(), paramHybridADSetting, paramHybridADListener);
      return;
    } 
    GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
    paramHybridADListener.onError(a.a(2003));
  }
  
  @Deprecated
  public HybridAD(Context paramContext, String paramString, HybridADSetting paramHybridADSetting, HybridADListener paramHybridADListener) {
    GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
    a(paramContext, paramString, paramHybridADSetting, paramHybridADListener);
  }
  
  private void a(Context paramContext, String paramString, HybridADSetting paramHybridADSetting, HybridADListener paramHybridADListener) {
    String str;
    if (paramContext == null || TextUtils.isEmpty(paramString) || paramHybridADListener == null) {
      str = String.format("HybridAD Constructor params error, context=%s, appID=%s,HybridADListener=%s", new Object[] { paramContext, paramString, paramHybridADListener });
    } else {
      this.e = paramHybridADListener;
      this.b = true;
      if (!a.a((Context)str)) {
        str = "Required Activity/Service/Permission Not Declared in AndroidManifest.xml";
      } else {
        this.c = true;
        GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, (Context)str, paramString, paramHybridADSetting, paramHybridADListener) {
              public void run() {
                if (GDTADManager.getInstance().initWith(this.d, this.e)) {
                  try {
                    POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                    return;
                  } finally {
                    Exception exception = null;
                  } 
                } else {
                  GDTLogger.e("Fail to init ADManager");
                } 
                HybridAD.a(this.c, 2001);
                HybridAD.a(this.c).countDown();
              }
            });
        return;
      } 
    } 
    GDTLogger.e(str);
  }
  
  public void loadUrl(String paramString) {
    boolean bool;
    if (!this.b || !this.c) {
      GDTLogger.e("AD init Params OR Context error, details in logs produced while init HybridAD");
      bool = false;
    } else {
      bool = true;
    } 
    if (bool) {
      if (this.a) {
        this.d.loadUrl(paramString);
        return;
      } 
      (new Thread(new Runnable(this, paramString) {
            public void run() {
              try {
                HybridAD.a(this.b).await(30L, TimeUnit.SECONDS);
                if (HybridAD.b(this.b)) {
                  HybridAD.c(this.b).loadUrl(this.a);
                  return;
                } 
                GDTLogger.e("delegate init failed ");
                HybridAD.a(this.b, 2001);
                return;
              } catch (InterruptedException interruptedException) {
                GDTLogger.e("buffered loadUrl action timeout");
                HybridAD.a(this.b, 2001);
                return;
              } 
            }
          })).start();
      return;
    } 
    GDTLogger.e("HybridAD loadUrl error");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\hybrid\HybridAD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */