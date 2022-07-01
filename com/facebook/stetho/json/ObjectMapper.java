package com.facebook.stetho.json;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.facebook.stetho.json.annotation.JsonValue;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ObjectMapper {
  private final Map<Class<?>, Method> mJsonValueMethodCache = new IdentityHashMap<Class<?>, Method>();
  
  private <T> T _convertFromJSONObject(JSONObject paramJSONObject, Class<T> paramClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, JSONException {
    Constructor<T> constructor = paramClass.getDeclaredConstructor((Class[])null);
    constructor.setAccessible(true);
    int i = 0;
    T t = constructor.newInstance(new Object[0]);
    Field[] arrayOfField = paramClass.getFields();
    while (true) {
      if (i < arrayOfField.length) {
        Field field = arrayOfField[i];
        if (!Modifier.isStatic(field.getModifiers())) {
          Object object = getValueForField(field, paramJSONObject.opt(field.getName()));
          try {
            field.set(t, object);
            i++;
          } catch (IllegalArgumentException illegalArgumentException) {
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Class: ");
            stringBuilder.append(paramClass.getSimpleName());
            stringBuilder.append(" Field: ");
            stringBuilder.append(field.getName());
            stringBuilder.append(" type ");
            if (object != null) {
              str = object.getClass().getName();
            } else {
              str = "null";
            } 
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString(), illegalArgumentException);
          } 
          continue;
        } 
      } else {
        break;
      } 
      i++;
    } 
    return (T)illegalArgumentException;
  }
  
  private JSONObject _convertToJSONObject(Object paramObject) throws JSONException, InvocationTargetException, IllegalAccessException {
    JSONObject jSONObject = new JSONObject();
    Field[] arrayOfField = paramObject.getClass().getFields();
    for (int i = 0; i < arrayOfField.length; i++) {
      Field field = arrayOfField[i];
      if (!Modifier.isStatic(field.getModifiers())) {
        JsonProperty jsonProperty = field.<JsonProperty>getAnnotation(JsonProperty.class);
        if (jsonProperty != null) {
          Object object2 = field.get(paramObject);
          Object object1 = field.getType();
          if (object2 != null)
            object1 = object2.getClass(); 
          String str = field.getName();
          if (jsonProperty.required() && object2 == null) {
            Object object = JSONObject.NULL;
          } else if (object2 == JSONObject.NULL) {
            object1 = object2;
          } else {
            object1 = getJsonValue(object2, (Class<?>)object1, field);
          } 
          jSONObject.put(str, object1);
        } 
      } 
    } 
    return jSONObject;
  }
  
  private static boolean canDirectlySerializeClass(Class<?> paramClass) {
    return (isWrapperOrPrimitiveType(paramClass) || paramClass.equals(String.class));
  }
  
  private List<Object> convertArrayToList(Field paramField, JSONArray paramJSONArray) throws IllegalAccessException, JSONException {
    Class<? extends Enum> clazz;
    if (List.class.isAssignableFrom(paramField.getType())) {
      Type[] arrayOfType = ((ParameterizedType)paramField.getGenericType()).getActualTypeArguments();
      if (arrayOfType.length == 1) {
        int i = 0;
        clazz = (Class)arrayOfType[0];
        ArrayList<Enum> arrayList = new ArrayList();
        while (i < paramJSONArray.length()) {
          if (clazz.isEnum()) {
            arrayList.add(getEnumValue(paramJSONArray.getString(i), clazz));
          } else if (canDirectlySerializeClass(clazz)) {
            arrayList.add(paramJSONArray.get(i));
          } else {
            JSONObject jSONObject = paramJSONArray.getJSONObject(i);
            if (jSONObject == null) {
              arrayList.add(null);
            } else {
              arrayList.add(convertValue(jSONObject, (Class)clazz));
            } 
          } 
          i++;
        } 
        return (List)arrayList;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Only able to handle a single type in a list ");
      stringBuilder1.append(clazz.getName());
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("only know how to deserialize List<?> on field ");
    stringBuilder.append(clazz.getName());
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private JSONArray convertListToJsonArray(Object paramObject) throws InvocationTargetException, IllegalAccessException {
    JSONArray jSONArray = new JSONArray();
    for (Object object : paramObject) {
      paramObject = null;
      if (object != null)
        paramObject = getJsonValue(object, object.getClass(), null); 
      jSONArray.put(paramObject);
    } 
    return jSONArray;
  }
  
  private Enum getEnumByMethod(String paramString, Class<? extends Enum> paramClass, Method paramMethod) {
    Enum[] arrayOfEnum = paramClass.getEnumConstants();
    int i = 0;
    while (i < arrayOfEnum.length) {
      Enum enum_ = arrayOfEnum[i];
      try {
        Object object = paramMethod.invoke(enum_, new Object[0]);
        if (object != null) {
          boolean bool = object.toString().equals(paramString);
          if (bool)
            return enum_; 
        } 
        i++;
      } catch (Exception exception) {
        throw new IllegalArgumentException(exception);
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No enum constant ");
    stringBuilder.append(paramClass.getName());
    stringBuilder.append(".");
    stringBuilder.append((String)exception);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private Enum getEnumValue(String paramString, Class<? extends Enum> paramClass) {
    Method method = getJsonValueMethod(paramClass);
    return (method != null) ? getEnumByMethod(paramString, paramClass, method) : Enum.valueOf((Class)paramClass, paramString);
  }
  
  private Object getJsonValue(Object paramObject, Class<?> paramClass, Field paramField) throws InvocationTargetException, IllegalAccessException {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: ldc java/util/List
    //   8: aload_2
    //   9: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   12: ifeq -> 21
    //   15: aload_0
    //   16: aload_1
    //   17: invokespecial convertListToJsonArray : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   20: areturn
    //   21: aload_0
    //   22: aload_2
    //   23: invokespecial getJsonValueMethod : (Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull -> 41
    //   31: aload_3
    //   32: aload_1
    //   33: iconst_0
    //   34: anewarray java/lang/Object
    //   37: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   40: areturn
    //   41: aload_2
    //   42: invokestatic canDirectlySerializeClass : (Ljava/lang/Class;)Z
    //   45: ifne -> 56
    //   48: aload_0
    //   49: aload_1
    //   50: ldc org/json/JSONObject
    //   52: invokevirtual convertValue : (Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;
    //   55: areturn
    //   56: aload_2
    //   57: ldc_w java/lang/Double
    //   60: invokevirtual equals : (Ljava/lang/Object;)Z
    //   63: ifne -> 78
    //   66: aload_1
    //   67: astore_3
    //   68: aload_2
    //   69: ldc_w java/lang/Float
    //   72: invokevirtual equals : (Ljava/lang/Object;)Z
    //   75: ifeq -> 127
    //   78: aload_1
    //   79: checkcast java/lang/Number
    //   82: invokevirtual doubleValue : ()D
    //   85: dstore #4
    //   87: dload #4
    //   89: invokestatic isNaN : (D)Z
    //   92: ifeq -> 99
    //   95: ldc_w 'NaN'
    //   98: areturn
    //   99: dload #4
    //   101: ldc2_w Infinity
    //   104: dcmpl
    //   105: ifne -> 112
    //   108: ldc_w 'Infinity'
    //   111: areturn
    //   112: aload_1
    //   113: astore_3
    //   114: dload #4
    //   116: ldc2_w -Infinity
    //   119: dcmpl
    //   120: ifne -> 127
    //   123: ldc_w '-Infinity'
    //   126: astore_3
    //   127: aload_3
    //   128: areturn
  }
  
  @Nullable
  private Method getJsonValueMethod(Class<?> paramClass) {
    synchronized (this.mJsonValueMethodCache) {
      Method method2 = this.mJsonValueMethodCache.get(paramClass);
      Method method1 = method2;
      if (method2 == null) {
        method1 = method2;
        if (!this.mJsonValueMethodCache.containsKey(paramClass)) {
          method1 = getJsonValueMethodImpl(paramClass);
          this.mJsonValueMethodCache.put(paramClass, method1);
        } 
      } 
      return method1;
    } 
  }
  
  @Nullable
  private static Method getJsonValueMethodImpl(Class<?> paramClass) {
    Method[] arrayOfMethod = paramClass.getMethods();
    for (int i = 0; i < arrayOfMethod.length; i++) {
      if (arrayOfMethod[i].getAnnotation(JsonValue.class) != null)
        return arrayOfMethod[i]; 
    } 
    return null;
  }
  
  private Object getValueForField(Field paramField, Object<?> paramObject) throws JSONException {
    if (paramObject != null)
      try {
        if (paramObject == JSONObject.NULL)
          return null; 
        if (paramObject.getClass() == paramField.getType())
          return paramObject; 
        if (paramObject instanceof JSONObject)
          return convertValue(paramObject, paramField.getType()); 
        if (paramField.getType().isEnum())
          return getEnumValue((String)paramObject, paramField.getType().asSubclass(Enum.class)); 
        if (paramObject instanceof JSONArray)
          return convertArrayToList(paramField, (JSONArray)paramObject); 
        if (paramObject instanceof Number) {
          Number number = (Number)paramObject;
          paramObject = (Object<?>)paramField.getType();
          if (paramObject == Integer.class || paramObject == int.class) {
            int i = number.intValue();
            return Integer.valueOf(i);
          } 
          if (paramObject == Long.class || paramObject == long.class)
            return Long.valueOf(number.longValue()); 
          if (paramObject == Double.class || paramObject == double.class)
            return Double.valueOf(number.doubleValue()); 
          if (paramObject == Float.class || paramObject == float.class)
            return Float.valueOf(number.floatValue()); 
          if (paramObject == Byte.class || paramObject == byte.class)
            return Byte.valueOf(number.byteValue()); 
          if (paramObject == Short.class || paramObject == short.class)
            return Short.valueOf(number.shortValue()); 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Not setup to handle class ");
          stringBuilder.append(paramObject.getName());
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
      } catch (IllegalAccessException illegalAccessException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to set value for field ");
        stringBuilder.append(paramField.getName());
        throw new IllegalArgumentException(stringBuilder.toString(), illegalAccessException);
      }  
    return illegalAccessException;
  }
  
  private static boolean isWrapperOrPrimitiveType(Class<?> paramClass) {
    return (paramClass.isPrimitive() || paramClass.equals(Boolean.class) || paramClass.equals(Integer.class) || paramClass.equals(Character.class) || paramClass.equals(Byte.class) || paramClass.equals(Short.class) || paramClass.equals(Double.class) || paramClass.equals(Long.class) || paramClass.equals(Float.class));
  }
  
  public <T> T convertValue(Object paramObject, Class<T> paramClass) throws IllegalArgumentException {
    if (paramObject == null)
      return null; 
    if (paramClass != Object.class && paramClass.isAssignableFrom(paramObject.getClass()))
      return (T)paramObject; 
    try {
      if (paramObject instanceof JSONObject)
        return _convertFromJSONObject((JSONObject)paramObject, paramClass); 
      if (paramClass == JSONObject.class)
        return (T)_convertToJSONObject(paramObject); 
      throw new IllegalArgumentException("Expecting either fromValue or toValueType to be a JSONObject");
    } catch (NoSuchMethodException noSuchMethodException) {
      throw new IllegalArgumentException(noSuchMethodException);
    } catch (IllegalAccessException illegalAccessException) {
      throw new IllegalArgumentException(illegalAccessException);
    } catch (InstantiationException instantiationException) {
      throw new IllegalArgumentException(instantiationException);
    } catch (JSONException jSONException) {
      throw new IllegalArgumentException(jSONException);
    } catch (InvocationTargetException invocationTargetException) {
      throw ExceptionUtil.propagate(invocationTargetException.getCause());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\json\ObjectMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */