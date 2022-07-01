package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public final class BeanContext {
  private final Class<?> beanClass;
  
  private final FieldInfo fieldInfo;
  
  BeanContext(Class<?> paramClass, FieldInfo paramFieldInfo) {
    this.beanClass = paramClass;
    this.fieldInfo = paramFieldInfo;
  }
  
  public <T extends java.lang.annotation.Annotation> T getAnnation(Class<T> paramClass) {
    return (T)this.fieldInfo.getAnnation(paramClass);
  }
  
  public Class<?> getBeanClass() {
    return this.beanClass;
  }
  
  public int getFeatures() {
    return this.fieldInfo.serialzeFeatures;
  }
  
  public Field getField() {
    return this.fieldInfo.field;
  }
  
  public Class<?> getFieldClass() {
    return this.fieldInfo.fieldClass;
  }
  
  public Type getFieldType() {
    return this.fieldInfo.fieldType;
  }
  
  public String getLabel() {
    return this.fieldInfo.label;
  }
  
  public Method getMethod() {
    return this.fieldInfo.method;
  }
  
  public String getName() {
    return this.fieldInfo.name;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\BeanContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */