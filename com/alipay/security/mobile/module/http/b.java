package com.alipay.security.mobile.module.http;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.security.mobile.module.a.a;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import org.json.JSONObject;

public class b implements a {
  private static b d;
  
  private static DataReportResult e;
  
  private w a = null;
  
  private BugTrackMessageService b = null;
  
  private DataReportService c = null;
  
  private b(Context paramContext, String paramString) {
    aa aa = new aa();
    aa.a(paramString);
    this.a = (w)new h(paramContext);
    this.b = (BugTrackMessageService)this.a.a(BugTrackMessageService.class, aa);
    this.c = (DataReportService)this.a.a(DataReportService.class, aa);
  }
  
  public static b a(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/alipay/security/mobile/module/http/b
    //   2: monitorenter
    //   3: getstatic com/alipay/security/mobile/module/http/b.d : Lcom/alipay/security/mobile/module/http/b;
    //   6: ifnonnull -> 21
    //   9: new com/alipay/security/mobile/module/http/b
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;)V
    //   18: putstatic com/alipay/security/mobile/module/http/b.d : Lcom/alipay/security/mobile/module/http/b;
    //   21: getstatic com/alipay/security/mobile/module/http/b.d : Lcom/alipay/security/mobile/module/http/b;
    //   24: astore_0
    //   25: ldc com/alipay/security/mobile/module/http/b
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc com/alipay/security/mobile/module/http/b
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
  }
  
  public DataReportResult a(DataReportRequest paramDataReportRequest) {
    if (paramDataReportRequest == null)
      return null; 
    if (this.c != null) {
      e = null;
      (new Thread(new c(this, paramDataReportRequest))).start();
      for (int i = 300000; e == null && i >= 0; i -= 50)
        Thread.sleep(50L); 
    } 
    return e;
  }
  
  public boolean a(String paramString) {
    boolean bool = a.a(paramString);
    boolean bool1 = false;
    if (bool)
      return false; 
    BugTrackMessageService bugTrackMessageService = this.b;
    bool = bool1;
    if (bugTrackMessageService != null) {
      String str = null;
      try {
        paramString = bugTrackMessageService.logCollect(a.f(paramString));
      } finally {
        paramString = null;
      } 
      if (!a.a(paramString))
        bool = ((Boolean)(new JSONObject(paramString)).get("success")).booleanValue(); 
    } 
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\security\mobile\module\http\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */