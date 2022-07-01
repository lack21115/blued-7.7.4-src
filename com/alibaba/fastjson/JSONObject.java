package com.alibaba.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class JSONObject extends JSON implements Serializable, Cloneable, InvocationHandler, Map<String, Object> {
  private static final int DEFAULT_INITIAL_CAPACITY = 16;
  
  private static final long serialVersionUID = 1L;
  
  private final Map<String, Object> map;
  
  public JSONObject() {
    this(16, false);
  }
  
  public JSONObject(int paramInt) {
    this(paramInt, false);
  }
  
  public JSONObject(int paramInt, boolean paramBoolean) {
    if (paramBoolean) {
      this.map = new LinkedHashMap<String, Object>(paramInt);
      return;
    } 
    this.map = new HashMap<String, Object>(paramInt);
  }
  
  public JSONObject(Map<String, Object> paramMap) {
    this.map = paramMap;
  }
  
  public JSONObject(boolean paramBoolean) {
    this(16, paramBoolean);
  }
  
  public void clear() {
    this.map.clear();
  }
  
  public Object clone() {
    Map<String, Object> map = this.map;
    if (map instanceof LinkedHashMap) {
      map = new LinkedHashMap<String, Object>(map);
    } else {
      map = new HashMap<String, Object>(map);
    } 
    return new JSONObject(map);
  }
  
  public boolean containsKey(Object paramObject) {
    return this.map.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject) {
    return this.map.containsValue(paramObject);
  }
  
  public Set<Map.Entry<String, Object>> entrySet() {
    return this.map.entrySet();
  }
  
  public boolean equals(Object paramObject) {
    return this.map.equals(paramObject);
  }
  
  public JSONObject fluentClear() {
    this.map.clear();
    return this;
  }
  
  public JSONObject fluentPut(String paramString, Object paramObject) {
    this.map.put(paramString, paramObject);
    return this;
  }
  
  public JSONObject fluentPutAll(Map<? extends String, ? extends Object> paramMap) {
    this.map.putAll(paramMap);
    return this;
  }
  
  public JSONObject fluentRemove(Object paramObject) {
    this.map.remove(paramObject);
    return this;
  }
  
  public Object get(Object paramObject) {
    return this.map.get(paramObject);
  }
  
  public BigDecimal getBigDecimal(String paramString) {
    return TypeUtils.castToBigDecimal(get(paramString));
  }
  
  public BigInteger getBigInteger(String paramString) {
    return TypeUtils.castToBigInteger(get(paramString));
  }
  
  public Boolean getBoolean(String paramString) {
    Object object = get(paramString);
    return (object == null) ? null : TypeUtils.castToBoolean(object);
  }
  
  public boolean getBooleanValue(String paramString) {
    Object object = get(paramString);
    return (object == null) ? false : TypeUtils.castToBoolean(object).booleanValue();
  }
  
  public Byte getByte(String paramString) {
    return TypeUtils.castToByte(get(paramString));
  }
  
  public byte getByteValue(String paramString) {
    Object object = get(paramString);
    return (object == null) ? 0 : TypeUtils.castToByte(object).byteValue();
  }
  
  public byte[] getBytes(String paramString) {
    Object object = get(paramString);
    return (object == null) ? null : TypeUtils.castToBytes(object);
  }
  
  public Date getDate(String paramString) {
    return TypeUtils.castToDate(get(paramString));
  }
  
  public Double getDouble(String paramString) {
    return TypeUtils.castToDouble(get(paramString));
  }
  
  public double getDoubleValue(String paramString) {
    Object object = get(paramString);
    return (object == null) ? 0.0D : TypeUtils.castToDouble(object).doubleValue();
  }
  
  public Float getFloat(String paramString) {
    return TypeUtils.castToFloat(get(paramString));
  }
  
  public float getFloatValue(String paramString) {
    Object object = get(paramString);
    return (object == null) ? 0.0F : TypeUtils.castToFloat(object).floatValue();
  }
  
  public int getIntValue(String paramString) {
    Object object = get(paramString);
    return (object == null) ? 0 : TypeUtils.castToInt(object).intValue();
  }
  
  public Integer getInteger(String paramString) {
    return TypeUtils.castToInt(get(paramString));
  }
  
  public JSONArray getJSONArray(String paramString) {
    paramString = (String)this.map.get(paramString);
    return (paramString instanceof JSONArray) ? (JSONArray)paramString : (JSONArray)toJSON(paramString);
  }
  
  public JSONObject getJSONObject(String paramString) {
    paramString = (String)this.map.get(paramString);
    return (paramString instanceof JSONObject) ? (JSONObject)paramString : (JSONObject)toJSON(paramString);
  }
  
  public Long getLong(String paramString) {
    return TypeUtils.castToLong(get(paramString));
  }
  
  public long getLongValue(String paramString) {
    Object object = get(paramString);
    return (object == null) ? 0L : TypeUtils.castToLong(object).longValue();
  }
  
  public <T> T getObject(String paramString, Class<T> paramClass) {
    return (T)TypeUtils.castToJavaBean(this.map.get(paramString), paramClass);
  }
  
  public Short getShort(String paramString) {
    return TypeUtils.castToShort(get(paramString));
  }
  
  public short getShortValue(String paramString) {
    Object object = get(paramString);
    return (object == null) ? 0 : TypeUtils.castToShort(object).shortValue();
  }
  
  public Date getSqlDate(String paramString) {
    return TypeUtils.castToSqlDate(get(paramString));
  }
  
  public String getString(String paramString) {
    Object object = get(paramString);
    return (object == null) ? null : object.toString();
  }
  
  public Timestamp getTimestamp(String paramString) {
    return TypeUtils.castToTimestamp(get(paramString));
  }
  
  public int hashCode() {
    return this.map.hashCode();
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) throws Throwable {
    StringBuilder stringBuilder;
    paramObject = paramMethod.getParameterTypes();
    int i = paramObject.length;
    Object object = null;
    if (i == 1) {
      if (paramMethod.getName().equals("equals"))
        return Boolean.valueOf(equals(paramArrayOfObject[0])); 
      if (paramMethod.getReturnType() == void.class) {
        paramObject = paramMethod.<JSONField>getAnnotation(JSONField.class);
        if (paramObject != null && paramObject.name().length() != 0) {
          paramObject = paramObject.name();
        } else {
          paramObject = null;
        } 
        object = paramObject;
        if (paramObject == null) {
          paramObject = paramMethod.getName();
          if (paramObject.startsWith("set")) {
            paramObject = paramObject.substring(3);
            if (paramObject.length() != 0) {
              stringBuilder = new StringBuilder();
              stringBuilder.append(Character.toLowerCase(paramObject.charAt(0)));
              stringBuilder.append(paramObject.substring(1));
              object = stringBuilder.toString();
            } else {
              throw new JSONException("illegal setter");
            } 
          } else {
            throw new JSONException("illegal setter");
          } 
        } 
        this.map.put(object, paramArrayOfObject[0]);
        return null;
      } 
      throw new JSONException("illegal setter");
    } 
    if (paramObject.length == 0) {
      if (stringBuilder.getReturnType() != void.class) {
        JSONField jSONField = stringBuilder.<JSONField>getAnnotation(JSONField.class);
        paramObject = object;
        if (jSONField != null) {
          paramObject = object;
          if (jSONField.name().length() != 0)
            paramObject = jSONField.name(); 
        } 
        Object object1 = paramObject;
        if (paramObject == null) {
          paramObject = stringBuilder.getName();
          if (paramObject.startsWith("get")) {
            paramObject = paramObject.substring(3);
            if (paramObject.length() != 0) {
              object1 = new StringBuilder();
              object1.append(Character.toLowerCase(paramObject.charAt(0)));
              object1.append(paramObject.substring(1));
              object1 = object1.toString();
            } else {
              throw new JSONException("illegal getter");
            } 
          } else if (paramObject.startsWith("is")) {
            paramObject = paramObject.substring(2);
            if (paramObject.length() != 0) {
              object1 = new StringBuilder();
              object1.append(Character.toLowerCase(paramObject.charAt(0)));
              object1.append(paramObject.substring(1));
              object1 = object1.toString();
            } else {
              throw new JSONException("illegal getter");
            } 
          } else {
            if (paramObject.startsWith("hashCode"))
              return Integer.valueOf(hashCode()); 
            if (paramObject.startsWith("toString"))
              return toString(); 
            throw new JSONException("illegal getter");
          } 
        } 
        return TypeUtils.cast(this.map.get(object1), stringBuilder.getGenericReturnType(), ParserConfig.getGlobalInstance());
      } 
      throw new JSONException("illegal getter");
    } 
    throw new UnsupportedOperationException(stringBuilder.toGenericString());
  }
  
  public boolean isEmpty() {
    return this.map.isEmpty();
  }
  
  public Set<String> keySet() {
    return this.map.keySet();
  }
  
  public Object put(String paramString, Object paramObject) {
    return this.map.put(paramString, paramObject);
  }
  
  public void putAll(Map<? extends String, ? extends Object> paramMap) {
    this.map.putAll(paramMap);
  }
  
  public Object remove(Object paramObject) {
    return this.map.remove(paramObject);
  }
  
  public int size() {
    return this.map.size();
  }
  
  public Collection<Object> values() {
    return this.map.values();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\JSONObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */