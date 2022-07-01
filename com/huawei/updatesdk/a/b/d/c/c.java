package com.huawei.updatesdk.a.b.d.c;

import com.huawei.updatesdk.a.a.c.f;
import com.huawei.updatesdk.a.a.c.g;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class c {
  public static final String CLIENT_API = "clientApi";
  
  private static final String END_FLAG = "_";
  
  private static String url;
  
  private String method_;
  
  private String ver_ = "1.1";
  
  private String a(Field paramField) throws IllegalAccessException, IllegalArgumentException {
    Object object = paramField.get(this);
    return (object != null && object instanceof b) ? ((b)object).toJson() : ((object != null) ? String.valueOf(object) : null);
  }
  
  public static void c(String paramString) {
    url = paramString;
  }
  
  public String a() throws IllegalAccessException, IllegalArgumentException, ArrayIndexOutOfBoundsException {
    e();
    Map<String, Field> map = c();
    String[] arrayOfString = new String[map.size()];
    map.keySet().toArray((Object[])arrayOfString);
    Arrays.sort((Object[])arrayOfString);
    StringBuilder stringBuilder = new StringBuilder();
    int i = 0;
    while (true) {
      String str = a(map.get(arrayOfString[i]));
      if (str != null) {
        str = g.a(str);
        stringBuilder.append(arrayOfString[i]);
        stringBuilder.append("=");
        stringBuilder.append(str);
        stringBuilder.append("&");
      } 
      int j = i + 1;
      i = j;
      if (j >= arrayOfString.length) {
        i = stringBuilder.length();
        if (i > 0)
          if (stringBuilder.charAt(--i) == '&')
            stringBuilder.deleteCharAt(i);  
        return stringBuilder.toString();
      } 
    } 
  }
  
  public void a(String paramString) {
    this.method_ = paramString;
  }
  
  public String b() {
    return this.method_;
  }
  
  public void b(String paramString) {
    this.ver_ = paramString;
  }
  
  protected Map<String, Field> c() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (Field field : f.a(getClass())) {
      field.setAccessible(true);
      String str = field.getName();
      if (str.endsWith("_"))
        hashMap.put(str.substring(0, str.length() - 1), field); 
    } 
    return (Map)hashMap;
  }
  
  public String d() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(url);
    stringBuilder.append("clientApi");
    return stringBuilder.toString();
  }
  
  protected void e() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\b\d\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */