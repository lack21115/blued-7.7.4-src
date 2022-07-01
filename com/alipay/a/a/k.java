package com.alipay.a.a;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import org.json.alipay.a;

public final class k implements i {
  public final Object a(Object<Object> paramObject, Type paramType) {
    if (!paramObject.getClass().equals(a.class))
      return null; 
    a a = (a)paramObject;
    HashSet hashSet = new HashSet();
    boolean bool = paramType instanceof ParameterizedType;
    int j = 0;
    if (bool) {
      paramObject = (Object<Object>)((ParameterizedType)paramType).getActualTypeArguments()[0];
    } else {
      paramObject = (Object<Object>)Object.class;
    } 
    while (j < a.a()) {
      hashSet.add(e.a(a.a(j), (Type)paramObject));
      j++;
    } 
    return hashSet;
  }
  
  public final boolean a(Class<?> paramClass) {
    return Set.class.isAssignableFrom(paramClass);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\a\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */