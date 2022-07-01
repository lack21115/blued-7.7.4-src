package com.alipay.a.a;

import com.alipay.a.b.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.alipay.a;
import org.json.alipay.b;

public final class f {
  private static List<j> a;
  
  static {
    ArrayList<j> arrayList = new ArrayList();
    a = arrayList;
    arrayList.add(new l());
    a.add(new d());
    a.add(new c());
    a.add(new h());
    a.add(new b());
    a.add(new a());
    a.add(new g());
  }
  
  public static String a(Object paramObject) {
    if (paramObject == null)
      return null; 
    paramObject = b(paramObject);
    if (a.a(paramObject.getClass()))
      return b.c(paramObject.toString()); 
    if (Collection.class.isAssignableFrom(paramObject.getClass()))
      return (new a((List)paramObject)).toString(); 
    if (Map.class.isAssignableFrom(paramObject.getClass()))
      return (new b((Map)paramObject)).toString(); 
    StringBuilder stringBuilder = new StringBuilder("Unsupported Class : ");
    stringBuilder.append(paramObject.getClass());
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static Object b(Object paramObject) {
    if (paramObject == null)
      return null; 
    for (j j : a) {
      if (j.a(paramObject.getClass())) {
        Object object = j.a(paramObject);
        if (object != null)
          return object; 
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder("Unsupported Class : ");
    stringBuilder.append(paramObject.getClass());
    throw new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\a\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */