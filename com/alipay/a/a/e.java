package com.alipay.a.a;

import com.alipay.a.b.a;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.alipay.a;
import org.json.alipay.b;

public final class e {
  static List<i> a;
  
  static {
    ArrayList<i> arrayList = new ArrayList();
    a = arrayList;
    arrayList.add(new l());
    a.add(new d());
    a.add(new c());
    a.add(new h());
    a.add(new k());
    a.add(new b());
    a.add(new a());
    a.add(new g());
  }
  
  public static final <T> T a(Object paramObject, Type paramType) {
    for (i i : a) {
      if (i.a(a.a(paramType))) {
        Object object = i.a(paramObject, paramType);
        if (object != null)
          return (T)object; 
      } 
    } 
    return null;
  }
  
  public static final Object a(String paramString, Type paramType) {
    a a;
    b b;
    if (paramString == null || paramString.length() == 0)
      return null; 
    paramString = paramString.trim();
    if (paramString.startsWith("[") && paramString.endsWith("]")) {
      a = new a(paramString);
      return a(a, paramType);
    } 
    if (a.startsWith("{") && a.endsWith("}")) {
      b = new b((String)a);
      return a(b, paramType);
    } 
    return a(b, paramType);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */