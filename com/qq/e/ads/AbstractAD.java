package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;

public abstract class AbstractAD<T extends ADI> {
  private volatile boolean a = false;
  
  private volatile boolean b = false;
  
  private T c;
  
  private BrowserType d;
  
  private DownAPPConfirmPolicy e;
  
  protected final T a() {
    return this.c;
  }
  
  protected abstract T a(Context paramContext, POFactory paramPOFactory, String paramString1, String paramString2);
  
  protected final void a(Context paramContext, String paramString1, String paramString2, BasicADListener paramBasicADListener) {
    if (!a.a(paramContext)) {
      GDTLogger.e("Required Activity/Service/Permission not declared in AndroidManifest.xml");
      a(paramBasicADListener, 4002);
      return;
    } 
    this.b = true;
    GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, paramContext, paramString1, paramString2, paramBasicADListener) {
          public void run() {
            int i;
            AbstractAD abstractAD;
            AbstractAD.BasicADListener basicADListener;
            if (GDTADManager.getInstance().initWith(this.a, this.b)) {
              try {
                return;
              } finally {
                Exception exception = null;
                GDTLogger.e("Exception while init plugin", exception);
                abstractAD = this.e;
                basicADListener = this.d;
              } 
            } else {
              GDTLogger.e("Fail to init ADManager");
              abstractAD = this.e;
              basicADListener = this.d;
              i = 200101;
            } 
            abstractAD.a(basicADListener, i);
          }
        });
  }
  
  public void a(BasicADListener paramBasicADListener, int paramInt) {
    if (paramBasicADListener != null) {
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        paramBasicADListener.onNoAD(a.a(paramInt));
        return;
      } 
      (new Handler(Looper.getMainLooper())).post(new Runnable(this, paramBasicADListener, paramInt) {
            public void run() {
              AbstractAD.BasicADListener basicADListener = this.a;
              if (basicADListener != null)
                basicADListener.onNoAD(a.a(this.b)); 
            }
          });
    } 
  }
  
  protected abstract void a(T paramT);
  
  protected final boolean b() {
    return this.a;
  }
  
  protected final boolean c() {
    return this.b;
  }
  
  public void setBrowserType(BrowserType paramBrowserType) {
    this.d = paramBrowserType;
    T t = this.c;
    if (t != null && paramBrowserType != null)
      t.setBrowserType(paramBrowserType.value()); 
  }
  
  public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy) {
    this.e = paramDownAPPConfirmPolicy;
    T t = this.c;
    if (t != null && paramDownAPPConfirmPolicy != null)
      t.setDownAPPConfirmPolicy(paramDownAPPConfirmPolicy); 
  }
  
  public static interface BasicADListener {
    void onNoAD(AdError param1AdError);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\AbstractAD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */