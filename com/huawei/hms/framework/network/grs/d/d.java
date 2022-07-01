package com.huawei.hms.framework.network.grs.d;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d {
  private static Map<String, a> a = new ConcurrentHashMap<String, a>(16);
  
  public static a a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("map size of get is before:");
    stringBuilder.append(a.size());
    Logger.v("RequestUtil", stringBuilder.toString());
    a a = a.get(paramString);
    stringBuilder = new StringBuilder();
    stringBuilder.append("map size of get is after:");
    stringBuilder.append(a.size());
    Logger.v("RequestUtil", stringBuilder.toString());
    return a;
  }
  
  public static void a(String paramString, a parama) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("map size of put is before:");
    stringBuilder2.append(a.size());
    Logger.v("RequestUtil", stringBuilder2.toString());
    a.put(paramString, parama);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("map size of put is after:");
    stringBuilder1.append(a.size());
    Logger.v("RequestUtil", stringBuilder1.toString());
  }
  
  public static class a {
    private long a;
    
    private long b;
    
    public a(long param1Long1, long param1Long2) {
      this.a = param1Long1;
      this.b = param1Long2;
    }
    
    public boolean a() {
      return (SystemClock.elapsedRealtime() - this.b <= this.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */