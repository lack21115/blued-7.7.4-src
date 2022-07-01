package com.alipay.a.a;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.TreeMap;
import org.json.alipay.b;

public final class g implements i, j {
  public final Object a(Object paramObject) {
    TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
    Class<?> clazz = paramObject.getClass();
    while (true) {
      Field[] arrayOfField = clazz.getDeclaredFields();
      if (!clazz.equals(Object.class)) {
        if (arrayOfField != null && arrayOfField.length > 0) {
          int m = arrayOfField.length;
          for (int k = 0; k < m; k++) {
            Field field = arrayOfField[k];
            Object object1 = null;
            Object object = object1;
            if (field != null)
              if (paramObject == null) {
                object = object1;
              } else if ("this$0".equals(field.getName())) {
                object = object1;
              } else {
                boolean bool = field.isAccessible();
                field.setAccessible(true);
                object = field.get(paramObject);
                if (object == null) {
                  object = object1;
                } else {
                  field.setAccessible(bool);
                  object = f.b(object);
                } 
              }  
            if (object != null)
              treeMap.put(field.getName(), object); 
          } 
        } 
        clazz = clazz.getSuperclass();
        continue;
      } 
      return treeMap;
    } 
  }
  
  public final Object a(Object paramObject, Type paramType) {
    if (!paramObject.getClass().equals(b.class))
      return null; 
    b b = (b)paramObject;
    paramObject = paramType;
    paramType = paramObject.newInstance();
    while (!paramObject.equals(Object.class)) {
      Field[] arrayOfField = paramObject.getDeclaredFields();
      if (arrayOfField != null && arrayOfField.length > 0) {
        int m = arrayOfField.length;
        for (int k = 0; k < m; k++) {
          Field field = arrayOfField[k];
          String str = field.getName();
          Type type = field.getGenericType();
          if (b.b(str)) {
            field.setAccessible(true);
            field.set(paramType, e.a(b.a(str), type));
          } 
        } 
      } 
      paramObject = paramObject.getSuperclass();
    } 
    return paramType;
  }
  
  public final boolean a(Class<?> paramClass) {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\a\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */