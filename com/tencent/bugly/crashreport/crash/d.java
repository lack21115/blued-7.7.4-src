package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.common.info.b;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.util.LinkedHashMap;
import java.util.Map;

public final class d {
  private static d a;
  
  private a b;
  
  private a c;
  
  private b d;
  
  private Context e;
  
  private d(Context paramContext) {
    c c = c.a();
    if (c == null)
      return; 
    this.b = a.a();
    this.c = a.a(paramContext);
    this.d = c.p;
    this.e = paramContext;
    w.a().a(new Runnable(this) {
          public final void run() {
            d.a(this.a);
          }
        });
  }
  
  public static d a(Context paramContext) {
    if (a == null)
      a = new d(paramContext); 
    return a;
  }
  
  public static void a(Thread paramThread, int paramInt, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap) {
    w.a().a(new Runnable(paramThread, paramInt, paramString1, paramString2, paramString3, paramMap) {
          public final void run() {
            try {
              return;
            } finally {
              Exception exception = null;
              if (!x.b(exception))
                exception.printStackTrace(); 
              x.e("[ExtraCrashManager] Crash error %s %s %s", new Object[] { this.c, this.d, this.e });
            } 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\crashreport\crash\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */