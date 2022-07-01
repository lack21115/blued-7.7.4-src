package com.alipay.a.a;

import com.alipay.a.b.a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.alipay.b;

public final class h implements i, j {
  private static Map<Object, Object> a(Type paramType) {
    while (true) {
      if (paramType == Properties.class)
        return new Properties(); 
      if (paramType == Hashtable.class)
        return new Hashtable<Object, Object>(); 
      if (paramType == IdentityHashMap.class)
        return new IdentityHashMap<Object, Object>(); 
      if (paramType == SortedMap.class || paramType == TreeMap.class)
        break; 
      if (paramType == ConcurrentMap.class || paramType == ConcurrentHashMap.class)
        return new ConcurrentHashMap<Object, Object>(); 
      if (paramType == Map.class || paramType == HashMap.class)
        return new HashMap<Object, Object>(); 
      if (paramType == LinkedHashMap.class)
        return new LinkedHashMap<Object, Object>(); 
      if (paramType instanceof ParameterizedType) {
        paramType = ((ParameterizedType)paramType).getRawType();
        continue;
      } 
      Class<Map> clazz = (Class)paramType;
      if (!clazz.isInterface())
        try {
          return clazz.newInstance();
        } catch (Exception exception) {
          StringBuilder stringBuilder1 = new StringBuilder("unsupport type ");
          stringBuilder1.append(paramType);
          throw new IllegalArgumentException(stringBuilder1.toString(), exception);
        }  
      StringBuilder stringBuilder = new StringBuilder("unsupport type ");
      stringBuilder.append(paramType);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    return new TreeMap<Object, Object>();
  }
  
  public final Object a(Object paramObject) {
    TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
    paramObject = ((Map)paramObject).entrySet().iterator();
    while (paramObject.hasNext()) {
      Map.Entry entry = paramObject.next();
      if (entry.getKey() instanceof String) {
        treeMap.put(entry.getKey(), f.b(entry.getValue()));
        continue;
      } 
      throw new IllegalArgumentException("Map key must be String!");
    } 
    return treeMap;
  }
  
  public final Object a(Object paramObject, Type paramType) {
    if (!paramObject.getClass().equals(b.class))
      return null; 
    b b = (b)paramObject;
    Map<Object, Object> map = a(paramType);
    if (paramType instanceof ParameterizedType) {
      paramType = paramType;
      paramObject = paramType.getActualTypeArguments()[0];
      paramType = paramType.getActualTypeArguments()[1];
      if (String.class == paramObject) {
        Iterator<String> iterator = b.a();
        while (iterator.hasNext()) {
          String str = iterator.next();
          if (a.a((Class)paramType)) {
            paramObject = b.a(str);
          } else {
            paramObject = e.a(b.a(str), paramType);
          } 
          map.put(str, paramObject);
        } 
        return map;
      } 
      throw new IllegalArgumentException("Deserialize Map Key must be String.class");
    } 
    throw new IllegalArgumentException("Deserialize Map must be Generics!");
  }
  
  public final boolean a(Class<?> paramClass) {
    return Map.class.isAssignableFrom(paramClass);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\a\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */