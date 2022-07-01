package com.huawei.hms.framework.network.grs;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e {
  private static Map<String, d> a = new ConcurrentHashMap<String, d>(16);
  
  private static final Object b = new Object();
  
  public static d a(GrsBaseInfo paramGrsBaseInfo, Context paramContext) {
    synchronized (b) {
      int i = paramGrsBaseInfo.uniqueCode();
      Map<String, d> map2 = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramContext.getPackageName());
      stringBuilder.append(i);
      d d2 = map2.get(stringBuilder.toString());
      if (d2 != null) {
        if (d2.a(new d(paramGrsBaseInfo)))
          return d2; 
        d1 = new d(paramContext, paramGrsBaseInfo);
        Map<String, d> map = a;
        stringBuilder = new StringBuilder();
        stringBuilder.append(paramContext.getPackageName());
        stringBuilder.append(i);
        map.put(stringBuilder.toString(), d1);
        return d1;
      } 
      d d1 = new d(paramContext, (GrsBaseInfo)d1);
      Map<String, d> map1 = a;
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramContext.getPackageName());
      stringBuilder.append(i);
      map1.put(stringBuilder.toString(), d1);
      return d1;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */