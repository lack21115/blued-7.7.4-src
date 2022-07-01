package com.huawei.hms.framework.network.grs.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.c.e;
import com.huawei.hms.framework.network.grs.c.l;
import com.huawei.hms.framework.network.grs.d.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {
  private static final String a = "a";
  
  private Map<String, Map<String, Map<String, String>>> b = new ConcurrentHashMap<String, Map<String, Map<String, String>>>(16);
  
  private Map<String, Long> c = new ConcurrentHashMap<String, Long>(16);
  
  private c d;
  
  private l e;
  
  public a(c paramc, l paraml) {
    this.d = paramc;
    this.e = paraml;
    this.e.a(this);
  }
  
  private void a(GrsBaseInfo paramGrsBaseInfo, b paramb, Context paramContext, String paramString) {
    String str = paramGrsBaseInfo.getGrsParasKey(false, true, paramContext);
    Long long_ = this.c.get(str);
    if (e.a(long_)) {
      paramb.a(2);
      return;
    } 
    if (e.a(long_, 300000L))
      this.e.a(paramGrsBaseInfo, paramContext, null, paramString); 
    paramb.a(1);
  }
  
  private void a(GrsBaseInfo paramGrsBaseInfo, String paramString, Context paramContext) {
    if (e.a(this.c.get(paramString), 300000L))
      this.e.a(paramGrsBaseInfo, paramContext, null, null); 
  }
  
  public String a(GrsBaseInfo paramGrsBaseInfo, String paramString1, String paramString2, b paramb, Context paramContext) {
    Map<String, String> map = a(paramGrsBaseInfo, paramString1, paramb, paramContext);
    return (map == null) ? null : map.get(paramString2);
  }
  
  public Map<String, String> a(GrsBaseInfo paramGrsBaseInfo, String paramString, b paramb, Context paramContext) {
    String str = paramGrsBaseInfo.getGrsParasKey(false, true, paramContext);
    Map map = this.b.get(str);
    if (map == null || map.isEmpty())
      return new HashMap<String, String>(); 
    a(paramGrsBaseInfo, paramb, paramContext, paramString);
    return (Map<String, String>)map.get(paramString);
  }
  
  public void a(GrsBaseInfo paramGrsBaseInfo, Context paramContext) {
    String str = paramGrsBaseInfo.getGrsParasKey(false, true, paramContext);
    c c1 = this.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("time");
    c1.b(stringBuilder.toString(), "0");
    Map<String, Long> map = this.c;
    stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("time");
    map.remove(stringBuilder.toString());
    this.b.remove(str);
    this.e.a(str);
  }
  
  public void a(GrsBaseInfo paramGrsBaseInfo, e parame, Context paramContext) {
    if (parame.e() == 2) {
      Logger.w(a, "update cache from server failed");
      return;
    } 
    String str = paramGrsBaseInfo.getGrsParasKey(false, true, paramContext);
    this.d.b(str, parame.i());
    c c1 = this.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("time");
    c1.b(stringBuilder.toString(), parame.a());
    this.b.put(str, com.huawei.hms.framework.network.grs.a.a(parame.i()));
    this.c.put(str, Long.valueOf(Long.parseLong(parame.a())));
  }
  
  public void b(GrsBaseInfo paramGrsBaseInfo, Context paramContext) {
    String str1 = paramGrsBaseInfo.getGrsParasKey(false, true, paramContext);
    String str2 = this.d.a(str1, "");
    c c1 = this.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str1);
    stringBuilder.append("time");
    String str3 = c1.a(stringBuilder.toString(), "0");
    boolean bool = TextUtils.isEmpty(str3);
    long l2 = 0L;
    long l1 = l2;
    if (!bool) {
      l1 = l2;
      if (str3.matches("\\d+"))
        try {
          l1 = Long.parseLong(str3);
        } catch (NumberFormatException numberFormatException) {
          Logger.w(a, "convert urlParamKey from String to Long catch NumberFormatException.", numberFormatException);
          l1 = l2;
        }  
    } 
    this.b.put(str1, com.huawei.hms.framework.network.grs.a.a(str2));
    this.c.put(str1, Long.valueOf(l1));
    a(paramGrsBaseInfo, str1, paramContext);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */