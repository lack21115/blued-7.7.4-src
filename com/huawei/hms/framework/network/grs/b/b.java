package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.local.model.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b {
  private static Map<String, b> a = new ConcurrentHashMap<String, b>(16);
  
  private a b;
  
  public b(Context paramContext, GrsBaseInfo paramGrsBaseInfo) {
    a(paramContext);
    Map<String, b> map = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramContext.getPackageName());
    stringBuilder.append(paramGrsBaseInfo.uniqueCode());
    map.put(stringBuilder.toString(), this);
  }
  
  public static b a(String paramString, GrsBaseInfo paramGrsBaseInfo) {
    Map<String, b> map = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(paramGrsBaseInfo.uniqueCode());
    return map.get(stringBuilder.toString());
  }
  
  public a a() {
    return this.b.a();
  }
  
  public String a(GrsBaseInfo paramGrsBaseInfo, String paramString1, String paramString2) {
    return this.b.a(paramGrsBaseInfo, paramString1, paramString2);
  }
  
  public Map<String, String> a(GrsBaseInfo paramGrsBaseInfo, String paramString) {
    return this.b.a(paramGrsBaseInfo, paramString);
  }
  
  public void a(Context paramContext) {
    this.b = new d(paramContext);
    if (!this.b.b())
      this.b = new c(paramContext); 
  }
  
  public void a(GrsBaseInfo paramGrsBaseInfo) {
    this.b.a(paramGrsBaseInfo);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */