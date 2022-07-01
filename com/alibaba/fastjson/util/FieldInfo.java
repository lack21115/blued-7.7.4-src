package com.alibaba.fastjson.util;

import com.alibaba.fastjson.annotation.JSONField;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class FieldInfo implements Comparable<FieldInfo> {
  public final Class<?> declaringClass;
  
  public final Field field;
  
  public final boolean fieldAccess;
  
  private final JSONField fieldAnnotation;
  
  public final Class<?> fieldClass;
  
  public final boolean fieldTransient;
  
  public final Type fieldType;
  
  public final boolean getOnly;
  
  public final boolean isEnum;
  
  public final String label;
  
  public final Method method;
  
  private final JSONField methodAnnotation;
  
  public final String name;
  
  public final char[] name_chars;
  
  private int ordinal;
  
  public final int serialzeFeatures;
  
  public FieldInfo(String paramString, Class<?> paramClass1, Class<?> paramClass2, Type paramType, Field paramField, int paramInt1, int paramInt2) {
    this.ordinal = 0;
    this.name = paramString;
    this.declaringClass = paramClass1;
    this.fieldClass = paramClass2;
    this.fieldType = paramType;
    this.method = null;
    this.field = paramField;
    this.ordinal = paramInt1;
    this.serialzeFeatures = paramInt2;
    this.isEnum = paramClass2.isEnum();
    if (paramField != null) {
      boolean bool;
      paramInt1 = paramField.getModifiers();
      if ((paramInt1 & 0x1) != 0 || this.method == null) {
        bool = true;
      } else {
        bool = false;
      } 
      this.fieldAccess = bool;
      this.fieldTransient = Modifier.isTransient(paramInt1);
    } else {
      this.fieldTransient = false;
      this.fieldAccess = false;
    } 
    this.name_chars = genFieldNameChars();
    if (paramField != null)
      TypeUtils.setAccessible(paramField); 
    this.label = "";
    this.fieldAnnotation = null;
    this.methodAnnotation = null;
    this.getOnly = false;
  }
  
  public FieldInfo(String paramString1, Method paramMethod, Field paramField, Class<?> paramClass, Type paramType, int paramInt1, int paramInt2, JSONField paramJSONField1, JSONField paramJSONField2, String paramString2) {
    Class<?> clazz;
    Type type1;
    Type<?> type;
    Type type2;
    boolean bool1;
    boolean bool3 = false;
    boolean bool2 = false;
    this.ordinal = 0;
    String str = paramString1;
    if (paramField != null) {
      String str1 = paramField.getName();
      str = paramString1;
      if (str1.equals(paramString1))
        str = str1; 
    } 
    this.name = str;
    this.method = paramMethod;
    this.field = paramField;
    this.ordinal = paramInt1;
    this.serialzeFeatures = paramInt2;
    this.fieldAnnotation = paramJSONField1;
    this.methodAnnotation = paramJSONField2;
    if (paramField != null) {
      paramInt1 = paramField.getModifiers();
      if ((paramInt1 & 0x1) != 0 || paramMethod == null) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.fieldAccess = bool1;
      this.fieldTransient = Modifier.isTransient(paramInt1);
    } else {
      this.fieldAccess = false;
      this.fieldTransient = false;
    } 
    if (paramString2 != null && paramString2.length() > 0) {
      this.label = paramString2;
    } else {
      this.label = "";
    } 
    this.name_chars = genFieldNameChars();
    if (paramMethod != null)
      TypeUtils.setAccessible(paramMethod); 
    if (paramField != null)
      TypeUtils.setAccessible(paramField); 
    if (paramMethod != null) {
      Class[] arrayOfClass = paramMethod.getParameterTypes();
      if (arrayOfClass.length == 1) {
        clazz = arrayOfClass[0];
        type = paramMethod.getGenericParameterTypes()[0];
        bool1 = bool2;
      } else {
        clazz = paramMethod.getReturnType();
        type = paramMethod.getGenericReturnType();
        bool1 = true;
      } 
      this.declaringClass = paramMethod.getDeclaringClass();
      type1 = type;
    } else {
      clazz = type.getType();
      type1 = type.getGenericType();
      this.declaringClass = type.getDeclaringClass();
      bool1 = bool3;
    } 
    this.getOnly = bool1;
    if (paramClass != null && clazz == Object.class && type1 instanceof TypeVariable) {
      type = getInheritGenericType(paramClass, (TypeVariable)type1);
      if (type != null) {
        this.fieldClass = TypeUtils.getClass(type);
        this.fieldType = type;
        this.isEnum = clazz.isEnum();
        return;
      } 
    } 
    if (!(type1 instanceof Class)) {
      paramType = getFieldType(paramClass, paramType, type1);
      type = clazz;
      type2 = paramType;
      if (paramType != type1)
        if (paramType instanceof ParameterizedType) {
          type = TypeUtils.getClass(paramType);
          type2 = paramType;
        } else {
          type = clazz;
          type2 = paramType;
          if (paramType instanceof Class) {
            type = TypeUtils.getClass(paramType);
            type2 = paramType;
          } 
        }  
    } else {
      type2 = type1;
      type = clazz;
    } 
    this.fieldType = type2;
    this.fieldClass = (Class<?>)type;
    this.isEnum = type.isEnum();
  }
  
  public static Type getFieldType(Class<?> paramClass, Type paramType1, Type paramType2) {
    if (paramClass != null) {
      Type type;
      if (paramType1 == null)
        return paramType2; 
      if (paramType2 instanceof GenericArrayType) {
        Type type1 = ((GenericArrayType)paramType2).getGenericComponentType();
        type = getFieldType(paramClass, paramType1, type1);
        return (type1 != type) ? Array.newInstance(TypeUtils.getClass(type), 0).getClass() : paramType2;
      } 
      if (!TypeUtils.isGenericParamType(paramType1))
        return paramType2; 
      if (paramType2 instanceof TypeVariable) {
        ParameterizedType parameterizedType = (ParameterizedType)TypeUtils.getGenericParamType(paramType1);
        Class<?> clazz = TypeUtils.getClass(parameterizedType);
        TypeVariable typeVariable = (TypeVariable)paramType2;
        TypeVariable[] arrayOfTypeVariable = (TypeVariable[])clazz.getTypeParameters();
        for (int i = 0; i < arrayOfTypeVariable.length; i++) {
          if (arrayOfTypeVariable[i].getName().equals(typeVariable.getName()))
            return parameterizedType.getActualTypeArguments()[i]; 
        } 
      } 
      if (paramType2 instanceof ParameterizedType) {
        ParameterizedType parameterizedType = (ParameterizedType)paramType2;
        Type[] arrayOfType = parameterizedType.getActualTypeArguments();
        TypeVariable[] arrayOfTypeVariable2 = null;
        TypeVariable[] arrayOfTypeVariable1 = arrayOfTypeVariable2;
        int j = 0;
        int i = 0;
        while (j < arrayOfType.length) {
          Type[] arrayOfType2;
          Type type1 = arrayOfType[j];
          int k = i;
          TypeVariable[] arrayOfTypeVariable3 = arrayOfTypeVariable2;
          TypeVariable[] arrayOfTypeVariable4 = arrayOfTypeVariable1;
          if (type1 instanceof TypeVariable) {
            type1 = type1;
            k = i;
            arrayOfTypeVariable3 = arrayOfTypeVariable2;
            arrayOfTypeVariable4 = arrayOfTypeVariable1;
            if (paramType1 instanceof ParameterizedType) {
              Type[] arrayOfType3;
              arrayOfTypeVariable3 = arrayOfTypeVariable2;
              if (arrayOfTypeVariable2 == null)
                arrayOfTypeVariable3 = type.getTypeParameters(); 
              k = 0;
              while (k < arrayOfTypeVariable3.length) {
                Type[] arrayOfType4;
                arrayOfTypeVariable2 = arrayOfTypeVariable1;
                if (arrayOfTypeVariable3[k].getName().equals(type1.getName())) {
                  arrayOfTypeVariable2 = arrayOfTypeVariable1;
                  if (arrayOfTypeVariable1 == null)
                    arrayOfType4 = ((ParameterizedType)paramType1).getActualTypeArguments(); 
                  arrayOfType[j] = arrayOfType4[k];
                  i = 1;
                } 
                k++;
                arrayOfType3 = arrayOfType4;
              } 
              arrayOfType2 = arrayOfType3;
              k = i;
            } 
          } 
          j++;
          i = k;
          arrayOfTypeVariable2 = arrayOfTypeVariable3;
          Type[] arrayOfType1 = arrayOfType2;
        } 
        if (i != 0)
          return new ParameterizedTypeImpl(arrayOfType, parameterizedType.getOwnerType(), parameterizedType.getRawType()); 
      } 
    } 
    return paramType2;
  }
  
  public static Type getInheritGenericType(Class<?> paramClass, TypeVariable<?> paramTypeVariable) {
    Object object = paramTypeVariable.getGenericDeclaration();
    while (true) {
      Type type = paramClass.getGenericSuperclass();
      if (type == null)
        return null; 
      if (type instanceof ParameterizedType) {
        ParameterizedType parameterizedType = (ParameterizedType)type;
        if (parameterizedType.getRawType() == object) {
          object = object.getTypeParameters();
          Type[] arrayOfType = parameterizedType.getActualTypeArguments();
          for (int i = 0; i < object.length; i++) {
            if (object[i] == paramTypeVariable)
              return arrayOfType[i]; 
          } 
          return null;
        } 
      } 
      paramClass = TypeUtils.getClass(type);
      if (type == null)
        return null; 
    } 
  }
  
  public int compareTo(FieldInfo paramFieldInfo) {
    int i = this.ordinal;
    int j = paramFieldInfo.ordinal;
    if (i < j)
      return -1; 
    if (i > j)
      return 1; 
    i = this.name.compareTo(paramFieldInfo.name);
    if (i != 0)
      return i; 
    Class<?> clazz1 = getDeclaredClass();
    Class<?> clazz2 = paramFieldInfo.getDeclaredClass();
    if (clazz1 != null && clazz2 != null && clazz1 != clazz2) {
      if (clazz1.isAssignableFrom(clazz2))
        return -1; 
      if (clazz2.isAssignableFrom(clazz1))
        return 1; 
    } 
    Field field = this.field;
    boolean bool = false;
    if (field != null && field.getType() == this.fieldClass) {
      i = 1;
    } else {
      i = 0;
    } 
    field = paramFieldInfo.field;
    j = bool;
    if (field != null) {
      j = bool;
      if (field.getType() == paramFieldInfo.fieldClass)
        j = 1; 
    } 
    return (i != 0 && j == 0) ? 1 : ((j != 0 && i == 0) ? -1 : ((paramFieldInfo.fieldClass.isPrimitive() && !this.fieldClass.isPrimitive()) ? 1 : ((this.fieldClass.isPrimitive() && !paramFieldInfo.fieldClass.isPrimitive()) ? -1 : ((paramFieldInfo.fieldClass.getName().startsWith("java.") && !this.fieldClass.getName().startsWith("java.")) ? 1 : ((this.fieldClass.getName().startsWith("java.") && !paramFieldInfo.fieldClass.getName().startsWith("java.")) ? -1 : this.fieldClass.getName().compareTo(paramFieldInfo.fieldClass.getName()))))));
  }
  
  protected char[] genFieldNameChars() {
    int i = this.name.length();
    char[] arrayOfChar = new char[i + 3];
    String str = this.name;
    str.getChars(0, str.length(), arrayOfChar, 1);
    arrayOfChar[0] = '"';
    arrayOfChar[i + 1] = '"';
    arrayOfChar[i + 2] = ':';
    return arrayOfChar;
  }
  
  public Object get(Object paramObject) throws IllegalAccessException, InvocationTargetException {
    Method method = this.method;
    return (method != null) ? method.invoke(paramObject, new Object[0]) : this.field.get(paramObject);
  }
  
  public <T extends java.lang.annotation.Annotation> T getAnnation(Class<T> paramClass) {
    if (paramClass == JSONField.class)
      return (T)getAnnotation(); 
    Method method1 = null;
    Method method2 = this.method;
    if (method2 != null)
      method1 = method2.getAnnotation((Class)paramClass); 
    method2 = method1;
    if (method1 == null) {
      Field field = this.field;
      method2 = method1;
      if (field == null)
        method2 = field.getAnnotation((Class)paramClass); 
    } 
    return (T)method2;
  }
  
  public JSONField getAnnotation() {
    JSONField jSONField = this.fieldAnnotation;
    return (jSONField != null) ? jSONField : this.methodAnnotation;
  }
  
  protected Class<?> getDeclaredClass() {
    Method method = this.method;
    if (method != null)
      return method.getDeclaringClass(); 
    Field field = this.field;
    return (field != null) ? field.getDeclaringClass() : null;
  }
  
  public String getFormat() {
    JSONField jSONField = getAnnotation();
    String str = null;
    if (jSONField != null) {
      str = jSONField.format();
      if (str.trim().length() == 0)
        return null; 
    } 
    return str;
  }
  
  public Member getMember() {
    Method method = this.method;
    return (Member)((method != null) ? method : this.field);
  }
  
  public void set(Object paramObject1, Object paramObject2) throws IllegalAccessException, InvocationTargetException {
    Method method = this.method;
    if (method != null) {
      method.invoke(paramObject1, new Object[] { paramObject2 });
      return;
    } 
    this.field.set(paramObject1, paramObject2);
  }
  
  public void setAccessible() throws SecurityException {
    Method method = this.method;
    if (method != null) {
      TypeUtils.setAccessible(method);
      return;
    } 
    TypeUtils.setAccessible(this.field);
  }
  
  public String toString() {
    return this.name;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjso\\util\FieldInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */