package com.blued.android.framework.urlmanager;

import com.blued.android.framework.utils.SharedPreferencesUtils;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

public class HostConfig {
  private static int a;
  
  private static AREA b = AREA.a;
  
  private static final ConcurrentHashMap<AREA, ConcurrentHashMap<Object, String[]>> c = new ConcurrentHashMap<AREA, ConcurrentHashMap<Object, String[]>>();
  
  public static String a() {
    if (c.size() == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry entry : ((ConcurrentHashMap)c.get(d())).entrySet()) {
      stringBuilder.append(entry.getKey().toString());
      stringBuilder.append(": ");
      stringBuilder.append(((String[])entry.getValue())[a]);
      stringBuilder.append("\n");
    } 
    return stringBuilder.toString();
  }
  
  public static String a(Object paramObject) {
    return (paramObject == null) ? "" : ((String[])((ConcurrentHashMap)c.get(d())).get(paramObject))[a];
  }
  
  public static void a(int paramInt) {
    a = paramInt;
    c();
  }
  
  public static void a(AREA paramAREA) {
    b = paramAREA;
  }
  
  private static void a(AREA paramAREA, Object paramObject, String[] paramArrayOfString) {
    if (paramObject != null && paramArrayOfString != null && paramArrayOfString.length == 2) {
      if (c.containsKey(paramAREA)) {
        ((ConcurrentHashMap<Object, String[]>)c.get(paramAREA)).put(paramObject, paramArrayOfString);
        return;
      } 
      ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<Object, Object>();
      concurrentHashMap.put(paramObject, paramArrayOfString);
      c.put(paramAREA, concurrentHashMap);
    } 
  }
  
  public static void a(Object paramObject, String[] paramArrayOfString) {
    a(AREA.b, paramObject, paramArrayOfString);
  }
  
  public static void b() {
    a = SharedPreferencesUtils.a().getInt("http_env", 0);
  }
  
  private static void c() {
    SharedPreferencesUtils.a().edit().putInt("http_env", a).commit();
  }
  
  private static AREA d() {
    AREA aREA1 = AREA.a;
    AREA aREA2 = b;
    if (aREA1 != aREA2)
      return aREA2; 
    aREA1 = e();
    if (aREA1 == AREA.c) {
      if (!c.containsKey(AREA.c))
        return AREA.b; 
    } else if (!c.containsKey(AREA.b)) {
      aREA1 = AREA.c;
    } 
    return aREA1;
  }
  
  private static AREA e() {
    try {
      String str = TimeZone.getDefault().getID();
      if ("Asia/Shanghai".equals(str) || "Asia/Chongqing".equals(str) || "Asia/Harbin".equals(str) || "Asia/Urumqi".equals(str))
        return AREA.b; 
    } catch (Exception exception) {}
    return AREA.c;
  }
  
  public enum AREA {
    a, b, c;
  }
  
  public static interface ENV {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\urlmanager\HostConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */