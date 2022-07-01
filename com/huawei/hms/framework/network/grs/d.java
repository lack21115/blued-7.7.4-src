package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.a.c;
import com.huawei.hms.framework.network.grs.c.l;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class d {
  private static final String a = "d";
  
  private static ExecutorService b = ExecutorsUtils.newCachedThreadPool("GRS_GrsClient-Init");
  
  private GrsBaseInfo c;
  
  private boolean d = false;
  
  private final Object e = new Object();
  
  private Context f;
  
  private l g;
  
  private a h;
  
  private c i;
  
  private a j;
  
  private Future<Boolean> k;
  
  d(Context paramContext, GrsBaseInfo paramGrsBaseInfo) {
    this.f = paramContext.getApplicationContext();
    a(paramGrsBaseInfo);
    if (!this.d)
      synchronized (this.e) {
        if (!this.d) {
          paramGrsBaseInfo = this.c;
          Context context = this.f;
          this.k = b.submit(new c(this, context, paramGrsBaseInfo));
        } 
        return;
      }  
  }
  
  d(GrsBaseInfo paramGrsBaseInfo) {
    a(paramGrsBaseInfo);
  }
  
  private void a(GrsBaseInfo paramGrsBaseInfo) {
    try {
      this.c = paramGrsBaseInfo.clone();
      return;
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      Logger.w(a, "GrsClient catch CloneNotSupportedException", cloneNotSupportedException);
      this.c = paramGrsBaseInfo.copy();
      return;
    } 
  }
  
  private void a(Map<String, ?> paramMap) {
    if (paramMap == null || paramMap.isEmpty()) {
      Logger.v(a, "sp's content is empty.");
      return;
    } 
    for (String str : paramMap.keySet()) {
      if (str.endsWith("time")) {
        String str1 = this.i.a(str, "");
        boolean bool = TextUtils.isEmpty(str1);
        long l2 = 0L;
        long l1 = l2;
        if (!bool) {
          l1 = l2;
          if (str1.matches("\\d+"))
            try {
              l1 = Long.parseLong(str1);
            } catch (NumberFormatException numberFormatException) {
              Logger.w(a, "convert expire time from String to Long catch NumberFormatException.", numberFormatException);
              l1 = l2;
            }  
        } 
        if (!a(l1)) {
          Logger.i(a, "init interface auto clear some invalid sp's data.");
          str1 = str.substring(0, str.length() - 4);
          this.i.a(str1);
          this.i.a(str);
        } 
      } 
    } 
  }
  
  private boolean a(long paramLong) {
    return (System.currentTimeMillis() - paramLong <= 604800000L);
  }
  
  private boolean c() {
    boolean bool = false;
    try {
      if (this.k != null)
        bool = ((Boolean)this.k.get(10L, TimeUnit.SECONDS)).booleanValue(); 
      return bool;
    } catch (CancellationException cancellationException) {
      Logger.i(a, "init compute task canceled.");
      return false;
    } catch (ExecutionException executionException) {
      Logger.w(a, "init compute task failed.", executionException);
      return false;
    } catch (InterruptedException interruptedException) {
      Logger.w(a, "init compute task interrupted.", interruptedException);
      return false;
    } catch (TimeoutException timeoutException) {
      Logger.w(a, "init compute task timed out");
      return false;
    } catch (Exception exception) {
      Logger.w(a, "init compute task occur unknown Exception", exception);
      return false;
    } 
  }
  
  String a(String paramString1, String paramString2) {
    if (this.c == null || paramString1 == null || paramString2 == null) {
      Logger.w(a, "invalid para!");
      return null;
    } 
    return c() ? this.j.a(paramString1, paramString2, this.f) : null;
  }
  
  Map<String, String> a(String paramString) {
    if (this.c == null || paramString == null) {
      Logger.w(a, "invalid para!");
      return new HashMap<String, String>();
    } 
    return c() ? this.j.a(paramString, this.f) : new HashMap<String, String>();
  }
  
  void a() {
    if (!c())
      return; 
    String str = this.c.getGrsParasKey(false, true, this.f);
    this.i.a(str);
    c c1 = this.i;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("time");
    c1.a(stringBuilder.toString());
    this.g.a(str);
  }
  
  void a(String paramString, IQueryUrlsCallBack paramIQueryUrlsCallBack) {
    if (paramIQueryUrlsCallBack == null) {
      Logger.w(a, "IQueryUrlsCallBack is must not null for process continue.");
      return;
    } 
    if (this.c == null || paramString == null) {
      paramIQueryUrlsCallBack.onCallBackFail(-6);
      return;
    } 
    if (c())
      this.j.a(paramString, paramIQueryUrlsCallBack, this.f); 
  }
  
  void a(String paramString1, String paramString2, IQueryUrlCallBack paramIQueryUrlCallBack) {
    if (paramIQueryUrlCallBack == null) {
      Logger.w(a, "IQueryUrlCallBack is must not null for process continue.");
      return;
    } 
    if (this.c == null || paramString1 == null || paramString2 == null) {
      paramIQueryUrlCallBack.onCallBackFail(-6);
      return;
    } 
    if (c())
      this.j.a(paramString1, paramString2, paramIQueryUrlCallBack, this.f); 
  }
  
  boolean a(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (d.class != paramObject.getClass())
        return false; 
      if (paramObject instanceof d) {
        paramObject = paramObject;
        return this.c.compare(((d)paramObject).c);
      } 
    } 
    return false;
  }
  
  boolean b() {
    if (!c())
      return false; 
    GrsBaseInfo grsBaseInfo = this.c;
    if (grsBaseInfo != null) {
      Context context = this.f;
      if (context == null)
        return false; 
      this.h.a(grsBaseInfo, context);
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */