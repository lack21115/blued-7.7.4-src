package com.huawei.updatesdk.a.b.d.c;

import android.util.Log;
import com.huawei.updatesdk.a.a.c.f;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b {
  private static final char COMMA = ',';
  
  private static final String END_FLAG = "_";
  
  private static final String TAG = "b";
  
  private String arrayToJson(Object paramObject) throws IllegalAccessException, IllegalArgumentException {
    int j = Array.getLength(paramObject);
    if (j <= 0)
      return "[]"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    for (int i = 0; i < j; i++) {
      String str = valueToJson(Array.get(paramObject, i));
      if (str != null) {
        stringBuilder.append(str);
        stringBuilder.append(',');
      } 
    } 
    formatJsonStr(stringBuilder);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  private void formatJsonStr(StringBuilder paramStringBuilder) {
    int i = paramStringBuilder.length();
    if (i > 0) {
      int j = i - 1;
      if (paramStringBuilder.charAt(j) == ',')
        paramStringBuilder.delete(j, i); 
    } 
  }
  
  private boolean isPrimitiveObj(Object paramObject) {
    return (paramObject instanceof Integer || paramObject instanceof Long || paramObject instanceof Boolean || paramObject instanceof Float || paramObject instanceof Byte || paramObject instanceof Character || paramObject instanceof Double || paramObject instanceof Short);
  }
  
  private Object jsonBeanFromJson(Class<b> paramClass, Object paramObject) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, JSONException {
    b b1 = paramClass.newInstance();
    b1.fromJson((JSONObject)paramObject);
    return b1;
  }
  
  private String mapToJson(Map paramMap) throws IllegalAccessException, IllegalArgumentException {
    if (paramMap.size() <= 0)
      return "{}"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{");
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    while (true) {
      Map.Entry entry = iterator.next();
      String str1 = (String)entry.getKey();
      String str2 = valueToJson(entry.getValue());
      if (str2 != null) {
        stringBuilder.append("\"");
        stringBuilder.append(str1);
        stringBuilder.append("\":");
        stringBuilder.append(str2);
      } 
      if (iterator.hasNext()) {
        if (str2 != null)
          stringBuilder.append(','); 
        continue;
      } 
      stringBuilder.append("}");
      return stringBuilder.toString();
    } 
  }
  
  private void processValueError(Field paramField, Object paramObject) {
    if (paramObject != null) {
      if (!(paramObject instanceof String))
        return; 
      try {
        Class<?> clazz = paramField.getType();
        if (!clazz.isPrimitive())
          return; 
        String str = clazz.getName();
        if ("int".equals(str)) {
          paramObject = Integer.valueOf(Integer.parseInt((String)paramObject));
        } else if ("float".equals(str)) {
          paramObject = Float.valueOf(Float.parseFloat((String)paramObject));
        } else if ("long".equals(str)) {
          paramObject = Long.valueOf(Long.parseLong((String)paramObject));
        } else if ("boolean".equals(str)) {
          paramObject = Boolean.valueOf(Boolean.parseBoolean((String)paramObject));
        } else if ("double".equals(str)) {
          paramObject = Double.valueOf(Double.parseDouble((String)paramObject));
        } else if ("short".equals(str)) {
          paramObject = Short.valueOf(Short.parseShort((String)paramObject));
        } else if ("byte".equals(str)) {
          paramObject = Byte.valueOf(Byte.parseByte((String)paramObject));
        } else if ("char".equals(str)) {
          paramObject = Character.valueOf(((String)paramObject).charAt(0));
        } else {
          return;
        } 
        paramField.set(this, paramObject);
        return;
      } catch (IllegalAccessException illegalAccessException) {
        paramObject = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("processValueError Throwable:");
        stringBuilder.append(illegalAccessException.getMessage());
        com.huawei.updatesdk.a.a.b.a.a.a.b((String)paramObject, stringBuilder.toString());
      } 
    } 
  }
  
  private Object valueFromJson(Class<?> paramClass1, Class paramClass2, Object paramObject) throws IllegalAccessException, IllegalArgumentException, InstantiationException, ClassNotFoundException, JSONException {
    if (paramClass1.isPrimitive() || paramClass1.equals(String.class)) {
      object = paramObject;
      if ("float".equals(paramClass1.getName())) {
        object = paramObject;
        if (paramObject instanceof Double)
          object = Float.valueOf(((Double)paramObject).floatValue()); 
      } 
      return object;
    } 
    if (List.class.isAssignableFrom(paramClass1))
      return listFromJson((Class)object, paramObject); 
    if (b.class.isAssignableFrom(paramClass1)) {
      if (!paramClass1.equals(b.class))
        return jsonBeanFromJson(paramClass1, paramObject); 
      object = new StringBuilder();
      object.append("error type, type:");
      object.append(paramClass1);
      throw new IllegalArgumentException(object.toString());
    } 
    if (Map.class.isAssignableFrom(paramClass1))
      return mapFromJson((Class)object, paramObject); 
    Object object = new StringBuilder();
    object.append("unsupport type, Type:");
    object.append(paramClass1);
    throw new IllegalArgumentException(object.toString());
  }
  
  private String valueToJson(Object paramObject) throws IllegalAccessException, IllegalArgumentException {
    String str = null;
    if (paramObject == null)
      return null; 
    if (paramObject instanceof String)
      return JSONObject.quote(paramObject.toString()); 
    if (isPrimitiveObj(paramObject))
      return String.valueOf(paramObject); 
    if (paramObject instanceof b)
      return ((b)paramObject).toJson(); 
    if (paramObject instanceof List)
      return listToJson((List)paramObject); 
    if (paramObject instanceof Map)
      return mapToJson((Map)paramObject); 
    if (paramObject.getClass().isArray())
      str = arrayToJson(paramObject); 
    return str;
  }
  
  public void fromJson(JSONObject paramJSONObject) throws IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException, JSONException {
    Field[] arrayOfField = f.a(getClass());
    Object object = null;
    for (int i = 0; i < arrayOfField.length; i++) {
      AccessController.doPrivileged(new a(arrayOfField[i]));
      String str = arrayOfField[i].getName();
      if (str.endsWith("_")) {
        String str1 = str.substring(0, str.length() - 1);
        if (paramJSONObject.has(str1)) {
          Object object1 = paramJSONObject.get(str1);
          if (!JSONObject.NULL.equals(object1))
            try {
              object1 = valueFromJson(arrayOfField[i].getType(), f.a(arrayOfField[i]), object1);
              object = object1;
              arrayOfField[i].set(this, object1);
              object = object1;
            } catch (Exception exception) {
              String str2 = TAG;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(getClass().getName());
              stringBuilder.append(".fromJson error, fieldName:");
              stringBuilder.append(str1);
              stringBuilder.append(exception.toString());
              Log.e(str2, stringBuilder.toString());
              processValueError(arrayOfField[i], object);
            }  
        } 
      } 
    } 
  }
  
  protected Object listFromJson(Class paramClass, Object paramObject) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, JSONException {
    if (paramClass != null) {
      if (paramObject instanceof org.json.JSONArray) {
        ArrayList<Object> arrayList = new ArrayList();
        paramObject = paramObject;
        for (int i = 0; i < paramObject.length(); i++) {
          Object object = valueFromJson(paramClass, null, paramObject.get(i));
          if (object != null)
            if (paramClass.equals(object.getClass())) {
              arrayList.add(object);
            } else {
              String str = TAG;
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("listFromJson error, memberClass:");
              stringBuilder1.append(paramClass);
              stringBuilder1.append(", valueClass:");
              stringBuilder1.append(object.getClass());
              com.huawei.updatesdk.a.a.b.a.a.a.b(str, stringBuilder1.toString());
            }  
        } 
        return arrayList;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("jsonobject is not JSONArray, jsonValue:");
      stringBuilder.append(paramObject);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("generic type is null");
  }
  
  protected String listToJson(List paramList) throws IllegalAccessException, IllegalArgumentException {
    if (paramList.size() <= 0)
      return "[]"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    for (int i = 0; i < paramList.size(); i++) {
      String str = valueToJson(paramList.get(i));
      if (str != null) {
        stringBuilder.append(str);
        stringBuilder.append(',');
      } 
    } 
    formatJsonStr(stringBuilder);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  protected Object mapFromJson(Class paramClass, Object paramObject) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, JSONException {
    if (paramClass != null) {
      if (paramObject instanceof JSONObject) {
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        paramObject = paramObject;
        Iterator<String> iterator = paramObject.keys();
        while (iterator.hasNext()) {
          String str = iterator.next();
          Object object = valueFromJson(paramClass, null, paramObject.get(str));
          if (object != null) {
            if (paramClass.equals(object.getClass())) {
              linkedHashMap.put(str, object);
              continue;
            } 
            str = TAG;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("mapFromJson error, memberClass:");
            stringBuilder1.append(paramClass);
            stringBuilder1.append(", valueClass:");
            stringBuilder1.append(object.getClass());
            com.huawei.updatesdk.a.a.b.a.a.a.b(str, stringBuilder1.toString());
          } 
        } 
        return linkedHashMap;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("jsonobject is not JSONObject, jsonValue:");
      stringBuilder.append(paramObject);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("generic type is null");
  }
  
  public String toJson() throws IllegalAccessException, IllegalArgumentException {
    Field[] arrayOfField = f.a(getClass());
    if (arrayOfField.length <= 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{");
    for (int i = 0; i < arrayOfField.length; i++) {
      AccessController.doPrivileged(new a(arrayOfField[i]));
      String str = arrayOfField[i].getName();
      if (str != null && str.endsWith("_")) {
        str = str.substring(0, str.length() - 1);
        String str1 = valueToJson(arrayOfField[i].get(this));
        if (str1 != null) {
          stringBuilder.append("\"");
          stringBuilder.append(str);
          stringBuilder.append("\":");
          stringBuilder.append(str1);
          stringBuilder.append(',');
        } 
      } 
    } 
    formatJsonStr(stringBuilder);
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
  
  static class a implements PrivilegedAction {
    private Field a;
    
    a(Field param1Field) {
      this.a = param1Field;
    }
    
    public Object run() {
      this.a.setAccessible(true);
      return null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\b\d\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */