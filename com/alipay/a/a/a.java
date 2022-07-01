package com.alipay.a.a;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class a implements i, j {
  public final Object a(Object paramObject) {
    paramObject = paramObject;
    ArrayList<Object> arrayList = new ArrayList();
    int m = paramObject.length;
    for (int k = 0; k < m; k++)
      arrayList.add(f.b(paramObject[k])); 
    return arrayList;
  }
  
  public final Object a(Object paramObject, Type<?> paramType) {
    if (!paramObject.getClass().equals(org.json.alipay.a.class))
      return null; 
    paramObject = paramObject;
    if (!(paramType instanceof java.lang.reflect.GenericArrayType)) {
      paramType = ((Class)paramType).getComponentType();
      int m = paramObject.a();
      Object object = Array.newInstance((Class<?>)paramType, m);
      for (int k = 0; k < m; k++)
        Array.set(object, k, e.a(paramObject.a(k), paramType)); 
      return object;
    } 
    throw new IllegalArgumentException("Does not support generic array!");
  }
  
  public final boolean a(Class<?> paramClass) {
    return paramClass.isArray();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */