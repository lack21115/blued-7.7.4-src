package com.tencent.tbs.patch.json;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class JSONArray {
  private final List<Object> a;
  
  public JSONArray() {
    this.a = new ArrayList();
  }
  
  public JSONArray(JSONTokener paramJSONTokener) {
    Object object = paramJSONTokener.nextValue();
    if (object instanceof JSONArray) {
      this.a = ((JSONArray)object).a;
      return;
    } 
    throw a.a(object, "JSONArray");
  }
  
  public JSONArray(String paramString) {
    this(new JSONTokener(paramString));
  }
  
  public JSONArray(Collection<?> paramCollection) {
    this();
    this.a.addAll(paramCollection);
  }
  
  void a(JSONStringer paramJSONStringer) {
    paramJSONStringer.array();
    Iterator iterator = this.a.iterator();
    while (iterator.hasNext())
      paramJSONStringer.value(iterator.next()); 
    paramJSONStringer.endArray();
  }
  
  public boolean equals(Object paramObject) {
    return (paramObject instanceof JSONArray && ((JSONArray)paramObject).a.equals(this.a));
  }
  
  public Object get(int paramInt) {
    try {
      Object object = this.a.get(paramInt);
      if (object != null)
        return object; 
      object = new StringBuilder();
      object.append("Value at ");
      object.append(paramInt);
      object.append(" is null.");
      throw new JSONException(object.toString());
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Index ");
      stringBuilder.append(paramInt);
      stringBuilder.append(" out of range [0..");
      stringBuilder.append(this.a.size());
      stringBuilder.append(")");
      throw new JSONException(stringBuilder.toString());
    } 
  }
  
  public boolean getBoolean(int paramInt) {
    Object object = get(paramInt);
    Boolean bool = a.a(object);
    if (bool != null)
      return bool.booleanValue(); 
    throw a.a(Integer.valueOf(paramInt), object, "boolean");
  }
  
  public double getDouble(int paramInt) {
    Object object = get(paramInt);
    Double double_ = a.b(object);
    if (double_ != null)
      return double_.doubleValue(); 
    throw a.a(Integer.valueOf(paramInt), object, "double");
  }
  
  public int getInt(int paramInt) {
    Object object = get(paramInt);
    Integer integer = a.c(object);
    if (integer != null)
      return integer.intValue(); 
    throw a.a(Integer.valueOf(paramInt), object, "int");
  }
  
  public JSONArray getJSONArray(int paramInt) {
    Object object = get(paramInt);
    if (object instanceof JSONArray)
      return (JSONArray)object; 
    throw a.a(Integer.valueOf(paramInt), object, "JSONArray");
  }
  
  public JSONObject getJSONObject(int paramInt) {
    Object object = get(paramInt);
    if (object instanceof JSONObject)
      return (JSONObject)object; 
    throw a.a(Integer.valueOf(paramInt), object, "JSONObject");
  }
  
  public long getLong(int paramInt) {
    Object object = get(paramInt);
    Long long_ = a.d(object);
    if (long_ != null)
      return long_.longValue(); 
    throw a.a(Integer.valueOf(paramInt), object, "long");
  }
  
  public String getString(int paramInt) {
    Object object = get(paramInt);
    String str = a.e(object);
    if (str != null)
      return str; 
    throw a.a(Integer.valueOf(paramInt), object, "String");
  }
  
  public int hashCode() {
    return this.a.hashCode();
  }
  
  public boolean isNull(int paramInt) {
    Object object = opt(paramInt);
    return (object == null || object == JSONObject.NULL);
  }
  
  public String join(String paramString) {
    JSONStringer jSONStringer = new JSONStringer();
    jSONStringer.a(JSONStringer.a.f, "");
    int j = this.a.size();
    for (int i = 0; i < j; i++) {
      if (i > 0)
        jSONStringer.a.append(paramString); 
      jSONStringer.value(this.a.get(i));
    } 
    jSONStringer.a(JSONStringer.a.f, JSONStringer.a.f, "");
    return jSONStringer.a.toString();
  }
  
  public int length() {
    return this.a.size();
  }
  
  public Object opt(int paramInt) {
    return (paramInt < 0 || paramInt >= this.a.size()) ? null : this.a.get(paramInt);
  }
  
  public boolean optBoolean(int paramInt) {
    return optBoolean(paramInt, false);
  }
  
  public boolean optBoolean(int paramInt, boolean paramBoolean) {
    Boolean bool = a.a(opt(paramInt));
    if (bool != null)
      paramBoolean = bool.booleanValue(); 
    return paramBoolean;
  }
  
  public double optDouble(int paramInt) {
    return optDouble(paramInt, Double.NaN);
  }
  
  public double optDouble(int paramInt, double paramDouble) {
    Double double_ = a.b(opt(paramInt));
    if (double_ != null)
      paramDouble = double_.doubleValue(); 
    return paramDouble;
  }
  
  public int optInt(int paramInt) {
    return optInt(paramInt, 0);
  }
  
  public int optInt(int paramInt1, int paramInt2) {
    Integer integer = a.c(opt(paramInt1));
    if (integer != null)
      paramInt2 = integer.intValue(); 
    return paramInt2;
  }
  
  public JSONArray optJSONArray(int paramInt) {
    Object object = opt(paramInt);
    return (object instanceof JSONArray) ? (JSONArray)object : null;
  }
  
  public JSONObject optJSONObject(int paramInt) {
    Object object = opt(paramInt);
    return (object instanceof JSONObject) ? (JSONObject)object : null;
  }
  
  public long optLong(int paramInt) {
    return optLong(paramInt, 0L);
  }
  
  public long optLong(int paramInt, long paramLong) {
    Long long_ = a.d(opt(paramInt));
    if (long_ != null)
      paramLong = long_.longValue(); 
    return paramLong;
  }
  
  public String optString(int paramInt) {
    return optString(paramInt, "");
  }
  
  public String optString(int paramInt, String paramString) {
    String str = a.e(opt(paramInt));
    return (str != null) ? str : paramString;
  }
  
  public JSONArray put(double paramDouble) {
    this.a.add(Double.valueOf(a.a(paramDouble)));
    return this;
  }
  
  public JSONArray put(int paramInt) {
    this.a.add(Integer.valueOf(paramInt));
    return this;
  }
  
  public JSONArray put(int paramInt, double paramDouble) {
    return put(paramInt, Double.valueOf(paramDouble));
  }
  
  public JSONArray put(int paramInt1, int paramInt2) {
    return put(paramInt1, Integer.valueOf(paramInt2));
  }
  
  public JSONArray put(int paramInt, long paramLong) {
    return put(paramInt, Long.valueOf(paramLong));
  }
  
  public JSONArray put(int paramInt, Object paramObject) {
    if (paramObject instanceof Number)
      a.a(((Number)paramObject).doubleValue()); 
    while (this.a.size() <= paramInt)
      this.a.add(null); 
    this.a.set(paramInt, paramObject);
    return this;
  }
  
  public JSONArray put(int paramInt, boolean paramBoolean) {
    return put(paramInt, Boolean.valueOf(paramBoolean));
  }
  
  public JSONArray put(long paramLong) {
    this.a.add(Long.valueOf(paramLong));
    return this;
  }
  
  public JSONArray put(Object paramObject) {
    this.a.add(paramObject);
    return this;
  }
  
  public JSONArray put(boolean paramBoolean) {
    this.a.add(Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public JSONObject toJSONObject(JSONArray paramJSONArray) {
    JSONObject jSONObject = new JSONObject();
    int j = Math.min(paramJSONArray.length(), this.a.size());
    if (j == 0)
      return null; 
    for (int i = 0; i < j; i++)
      jSONObject.put(a.e(paramJSONArray.opt(i)), opt(i)); 
    return jSONObject;
  }
  
  public String toString() {
    try {
      JSONStringer jSONStringer = new JSONStringer();
      a(jSONStringer);
      return jSONStringer.toString();
    } catch (JSONException jSONException) {
      return null;
    } 
  }
  
  public String toString(int paramInt) {
    JSONStringer jSONStringer = new JSONStringer(paramInt);
    a(jSONStringer);
    return jSONStringer.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\json\JSONArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */