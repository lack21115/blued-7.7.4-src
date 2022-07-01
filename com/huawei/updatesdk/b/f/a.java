package com.huawei.updatesdk.b.f;

import android.text.TextUtils;
import com.huawei.updatesdk.a.a.c.h.b;
import java.util.HashMap;
import java.util.Map;

public final class a {
  private static final Map<Integer, String> b = new HashMap<Integer, String>();
  
  private static a c = new a();
  
  private int a = 0;
  
  static {
    b.put(Integer.valueOf(1), "1.0");
    b.put(Integer.valueOf(2), "1.5");
    b.put(Integer.valueOf(3), "1.6");
    b.put(Integer.valueOf(4), "2.0");
    b.put(Integer.valueOf(5), "2.0");
    b.put(Integer.valueOf(6), "2.3");
    b.put(Integer.valueOf(7), "3.0");
    Map<Integer, String> map = b;
    Integer integer = Integer.valueOf(8);
    map.put(integer, "3.0.5");
    b.put(integer, "3.1");
    b.put(Integer.valueOf(9), "4.0");
    b.put(Integer.valueOf(10), "4.1");
    b.put(Integer.valueOf(11), "5.0");
    b.put(Integer.valueOf(12), "5.1");
  }
  
  private a() {
    this.a = c();
    if (this.a == 0)
      this.a = b(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("emuiVersion:");
    stringBuilder.append(this.a);
    com.huawei.updatesdk.a.a.b.a.a.a.a("EMUISupportUtil", stringBuilder.toString());
  }
  
  private String a(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      String[] arrayOfString = paramString.split("_");
      if (arrayOfString.length == 2)
        return arrayOfString[1]; 
    } 
    return "";
  }
  
  private int b() {
    String str = a(b.a("ro.build.version.emui", ""));
    if (!TextUtils.isEmpty(str))
      for (Map.Entry<Integer, String> entry : b.entrySet()) {
        if (str.equals(entry.getValue()))
          return ((Integer)entry.getKey()).intValue(); 
      }  
    return 0;
  }
  
  private int c() {
    return b.a("ro.build.hw_emui_api_level", 0);
  }
  
  public static a d() {
    return c;
  }
  
  public int a() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\b\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */