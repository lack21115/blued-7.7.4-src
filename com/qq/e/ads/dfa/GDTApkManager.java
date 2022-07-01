package com.qq.e.ads.dfa;

import android.content.Context;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.DFA;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.concurrent.atomic.AtomicInteger;

public class GDTApkManager {
  private DFA a;
  
  private boolean b;
  
  private boolean c;
  
  private AtomicInteger d;
  
  private Context e;
  
  public GDTApkManager(Context paramContext, IGDTApkListener paramIGDTApkListener) {
    String str;
    this.b = false;
    this.c = false;
    this.d = new AtomicInteger(0);
    if (GDTADManager.getInstance().isInitialized()) {
      String str1 = GDTADManager.getInstance().getAppStatus().getAPPID();
      if (StringUtil.isEmpty(str1) || paramContext == null || paramIGDTApkListener == null) {
        str = String.format("GDTApkManager Constructor params error, appid=%s,context=%s,listener=%s", new Object[] { str1, paramContext, paramIGDTApkListener });
      } else if (!a.a((Context)str)) {
        str = "Required Activity/Service/Permission Not Declared in AndroidManifest.xml";
      } else {
        this.b = true;
        this.e = (Context)str;
        GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, (Context)str, str1, paramIGDTApkListener) {
              public void run() {
                if (GDTADManager.getInstance().initWith(this.c, this.d))
                  try {
                    return;
                  } finally {
                    Exception exception = null;
                    GDTLogger.e("Exception while init UnifiedBannerView plugin", exception);
                  }  
                GDTLogger.e("Fail to init ADManager");
              }
            });
        return;
      } 
    } else {
      str = "SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化";
    } 
    GDTLogger.e(str);
  }
  
  public final void loadGDTApk() {
    String str;
    if (!this.b) {
      str = "GDTApkManager init Context error,See More logs while new GDTApkManager";
    } else {
      if (!this.c) {
        this.d.incrementAndGet();
        return;
      } 
      DFA dFA = this.a;
      if (dFA != null) {
        dFA.loadGDTApk();
        return;
      } 
      str = "InterstitialAD Init error,See More Logs";
    } 
    GDTLogger.e(str);
  }
  
  public final void startInstall(GDTApk paramGDTApk) {
    DFA dFA = this.a;
    if (dFA != null)
      dFA.startInstall(this.e, paramGDTApk); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\dfa\GDTApkManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */