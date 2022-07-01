package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.b;
import com.huawei.hms.framework.network.grs.c.b.b;
import com.huawei.hms.framework.network.grs.d.d;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class l {
  private ExecutorService a = ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");
  
  private Map<String, b> b = new ConcurrentHashMap<String, b>(16);
  
  private final Object c = new Object();
  
  private a d;
  
  private void a(e parame, b paramb) {
    if (paramb != null) {
      if (parame == null) {
        Logger.v("RequestController", "GrsResponse is null");
        paramb.a();
        return;
      } 
      Logger.v("RequestController", "GrsResponse is not null");
      paramb.a(parame);
    } 
  }
  
  public e a(GrsBaseInfo paramGrsBaseInfo, Context paramContext, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("request to server with service name is: ");
    stringBuilder.append(paramString);
    Logger.d("RequestController", stringBuilder.toString());
    String str = paramGrsBaseInfo.getGrsParasKey(false, true, paramContext);
    synchronized (this.c) {
      Future<e> future;
      String str1;
      if (!NetworkUtil.isNetworkAvailable(paramContext))
        return null; 
      d.a a1 = d.a(str);
      b b = this.b.get(str);
      if (b == null || !b.b()) {
        if (a1 == null || !a1.a()) {
          Logger.d("RequestController", "hitGrsRequestBean == null or request block is released.");
          future = this.a.submit(new j(this, paramGrsBaseInfo, paramContext, paramString));
          this.b.put(str, new b(future));
        } else {
          return null;
        } 
      } else {
        future = b.a();
      } 
      try {
        return future.get();
      } catch (CancellationException cancellationException) {
        str1 = "when check result, find CancellationException, check others";
      } catch (ExecutionException executionException) {
        str1 = "when check result, find ExecutionException, check others";
      } catch (InterruptedException interruptedException) {
        str1 = "when check result, find InterruptedException, check others";
      } 
      Logger.w("RequestController", str1, interruptedException);
      return null;
    } 
  }
  
  public void a(GrsBaseInfo paramGrsBaseInfo, Context paramContext, b paramb, String paramString) {
    this.a.execute(new k(this, paramGrsBaseInfo, paramContext, paramString, paramb));
  }
  
  public void a(a parama) {
    this.d = parama;
  }
  
  public void a(String paramString) {
    synchronized (this.c) {
      this.b.remove(paramString);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\c\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */