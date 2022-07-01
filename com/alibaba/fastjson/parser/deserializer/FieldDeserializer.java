package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class FieldDeserializer {
  protected final Class<?> clazz;
  
  public final FieldInfo fieldInfo;
  
  public FieldDeserializer(Class<?> paramClass, FieldInfo paramFieldInfo) {
    this.clazz = paramClass;
    this.fieldInfo = paramFieldInfo;
  }
  
  public int getFastMatchToken() {
    return 0;
  }
  
  public abstract void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap);
  
  public void setValue(Object paramObject, int paramInt) {
    setValue(paramObject, Integer.valueOf(paramInt));
  }
  
  public void setValue(Object paramObject, long paramLong) {
    setValue(paramObject, Long.valueOf(paramLong));
  }
  
  public void setValue(Object paramObject1, Object paramObject2) {
    if (paramObject2 == null) {
      Class<byte> clazz = this.fieldInfo.fieldClass;
      if (clazz == byte.class || clazz == short.class || clazz == int.class || clazz == long.class || clazz == float.class || clazz == double.class || clazz == boolean.class || clazz == char.class)
        return; 
    } 
    Method method = this.fieldInfo.method;
    if (method != null)
      try {
        if (this.fieldInfo.getOnly) {
          if (this.fieldInfo.fieldClass == AtomicInteger.class) {
            paramObject1 = method.invoke(paramObject1, new Object[0]);
            if (paramObject1 != null) {
              paramObject1.set(((AtomicInteger)paramObject2).get());
              return;
            } 
          } else if (this.fieldInfo.fieldClass == AtomicLong.class) {
            paramObject1 = method.invoke(paramObject1, new Object[0]);
            if (paramObject1 != null) {
              paramObject1.set(((AtomicLong)paramObject2).get());
              return;
            } 
          } else if (this.fieldInfo.fieldClass == AtomicBoolean.class) {
            paramObject1 = method.invoke(paramObject1, new Object[0]);
            if (paramObject1 != null) {
              paramObject1.set(((AtomicBoolean)paramObject2).get());
              return;
            } 
          } else if (Map.class.isAssignableFrom(method.getReturnType())) {
            paramObject1 = method.invoke(paramObject1, new Object[0]);
            if (paramObject1 != null) {
              paramObject1.putAll((Map)paramObject2);
              return;
            } 
          } else {
            paramObject1 = method.invoke(paramObject1, new Object[0]);
            if (paramObject1 != null) {
              paramObject1.addAll((Collection)paramObject2);
              return;
            } 
          } 
        } else {
          if (paramObject2 == null && this.fieldInfo.fieldClass.isPrimitive())
            return; 
          method.invoke(paramObject1, new Object[] { paramObject2 });
        } 
        return;
      } catch (Exception exception) {
        paramObject2 = new StringBuilder();
        paramObject2.append("set property error, ");
        paramObject2.append(this.fieldInfo.name);
        throw new JSONException(paramObject2.toString(), exception);
      }  
    Field field = this.fieldInfo.field;
    if (field != null)
      try {
        field.set(exception, paramObject2);
        return;
      } catch (Exception exception1) {
        paramObject2 = new StringBuilder();
        paramObject2.append("set property error, ");
        paramObject2.append(this.fieldInfo.name);
        throw new JSONException(paramObject2.toString(), exception1);
      }  
  }
  
  public void setValue(Object paramObject, String paramString) {
    setValue(paramObject, paramString);
  }
  
  public void setValue(Object paramObject, boolean paramBoolean) {
    setValue(paramObject, Boolean.valueOf(paramBoolean));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\FieldDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */