package com.tencent.tbs.patch.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JSONObject {
  public static final Object NULL;
  
  private static final Double a = Double.valueOf(0.0D);
  
  private final Map<String, Object> b;
  
  static {
    NULL = new Object() {
        public boolean equals(Object param1Object) {
          return (param1Object == this || param1Object == null);
        }
        
        public String toString() {
          return "null";
        }
      };
    throw new VerifyError("bad dex opcode");
  }
  
  public JSONObject() {
    this.b = new HashMap<String, Object>();
  }
  
  public JSONObject(JSONObject paramJSONObject, String[] paramArrayOfString) {
    this();
    int j = paramArrayOfString.length;
    for (int i = 0; i < j; i++) {
      String str = paramArrayOfString[i];
      Object object = paramJSONObject.opt(str);
      if (object != null)
        this.b.put(str, object); 
    } 
  }
  
  public JSONObject(JSONTokener paramJSONTokener) {
    Object object = paramJSONTokener.nextValue();
    if (object instanceof JSONObject) {
      this.b = ((JSONObject)object).b;
      return;
    } 
    throw a.a(object, "JSONObject");
  }
  
  public JSONObject(String paramString) {
    this(new JSONTokener(paramString));
  }
  
  public JSONObject(Map paramMap) {
    this();
    for (Map.Entry entry : paramMap.entrySet()) {
      String str = (String)entry.getKey();
      if (str != null) {
        this.b.put(str, entry.getValue());
        continue;
      } 
      throw new NullPointerException();
    } 
  }
  
  public static String numberToString(Number paramNumber) {
    if (paramNumber != null) {
      double d = paramNumber.doubleValue();
      a.a(d);
      if (paramNumber.equals(a))
        return "-0"; 
      long l = paramNumber.longValue();
      return (d == l) ? Long.toString(l) : paramNumber.toString();
    } 
    throw new JSONException("Number must be non-null");
  }
  
  public static String quote(String paramString) {
    if (paramString == null)
      return "\"\""; 
    try {
      JSONStringer jSONStringer = new JSONStringer();
      jSONStringer.a(JSONStringer.a.f, "");
      jSONStringer.value(paramString);
      jSONStringer.a(JSONStringer.a.f, JSONStringer.a.f, "");
      return jSONStringer.toString();
    } catch (JSONException jSONException) {
      throw new AssertionError();
    } 
  }
  
  String a(String paramString) {
    if (paramString != null)
      return paramString; 
    throw new JSONException("Names must be non-null");
  }
  
  void a(JSONStringer paramJSONStringer) {
    paramJSONStringer.object();
    for (Map.Entry<String, Object> entry : this.b.entrySet())
      paramJSONStringer.key((String)entry.getKey()).value(entry.getValue()); 
    paramJSONStringer.endObject();
  }
  
  public JSONObject accumulate(String paramString, Object paramObject) {
    Object object = this.b.get(a(paramString));
    if (object == null)
      return put(paramString, paramObject); 
    if (paramObject instanceof Number)
      a.a(((Number)paramObject).doubleValue()); 
    if (object instanceof JSONArray) {
      ((JSONArray)object).put(paramObject);
      return this;
    } 
    JSONArray jSONArray = new JSONArray();
    jSONArray.put(object);
    jSONArray.put(paramObject);
    this.b.put(paramString, jSONArray);
    return this;
  }
  
  public Object get(String paramString) {
    Object object = this.b.get(paramString);
    if (object != null)
      return object; 
    object = new StringBuilder();
    object.append("No value for ");
    object.append(paramString);
    throw new JSONException(object.toString());
  }
  
  public boolean getBoolean(String paramString) {
    Object object = get(paramString);
    Boolean bool = a.a(object);
    if (bool != null)
      return bool.booleanValue(); 
    throw a.a(paramString, object, "boolean");
  }
  
  public double getDouble(String paramString) {
    Object object = get(paramString);
    Double double_ = a.b(object);
    if (double_ != null)
      return double_.doubleValue(); 
    throw a.a(paramString, object, "double");
  }
  
  public int getInt(String paramString) {
    Object object = get(paramString);
    Integer integer = a.c(object);
    if (integer != null)
      return integer.intValue(); 
    throw a.a(paramString, object, "int");
  }
  
  public JSONArray getJSONArray(String paramString) {
    Object object = get(paramString);
    if (object instanceof JSONArray)
      return (JSONArray)object; 
    throw a.a(paramString, object, "JSONArray");
  }
  
  public JSONObject getJSONObject(String paramString) {
    Object object = get(paramString);
    if (object instanceof JSONObject)
      return (JSONObject)object; 
    throw a.a(paramString, object, "JSONObject");
  }
  
  public long getLong(String paramString) {
    Object object = get(paramString);
    Long long_ = a.d(object);
    if (long_ != null)
      return long_.longValue(); 
    throw a.a(paramString, object, "long");
  }
  
  public String getString(String paramString) {
    Object object = get(paramString);
    String str = a.e(object);
    if (str != null)
      return str; 
    throw a.a(paramString, object, "String");
  }
  
  public boolean has(String paramString) {
    return this.b.containsKey(paramString);
  }
  
  public boolean isNull(String paramString) {
    paramString = (String)this.b.get(paramString);
    return (paramString == null || paramString == NULL);
  }
  
  public Iterator keys() {
    return this.b.keySet().iterator();
  }
  
  public int length() {
    return this.b.size();
  }
  
  public JSONArray names() {
    return this.b.isEmpty() ? null : new JSONArray(new ArrayList(this.b.keySet()));
  }
  
  public Object opt(String paramString) {
    return this.b.get(paramString);
  }
  
  public boolean optBoolean(String paramString) {
    return optBoolean(paramString, false);
  }
  
  public boolean optBoolean(String paramString, boolean paramBoolean) {
    Boolean bool = a.a(opt(paramString));
    if (bool != null)
      paramBoolean = bool.booleanValue(); 
    return paramBoolean;
  }
  
  public double optDouble(String paramString) {
    return optDouble(paramString, Double.NaN);
  }
  
  public double optDouble(String paramString, double paramDouble) {
    Double double_ = a.b(opt(paramString));
    if (double_ != null)
      paramDouble = double_.doubleValue(); 
    return paramDouble;
  }
  
  public int optInt(String paramString) {
    return optInt(paramString, 0);
  }
  
  public int optInt(String paramString, int paramInt) {
    Integer integer = a.c(opt(paramString));
    if (integer != null)
      paramInt = integer.intValue(); 
    return paramInt;
  }
  
  public JSONArray optJSONArray(String paramString) {
    Object object = opt(paramString);
    return (object instanceof JSONArray) ? (JSONArray)object : null;
  }
  
  public JSONObject optJSONObject(String paramString) {
    Object object = opt(paramString);
    return (object instanceof JSONObject) ? (JSONObject)object : null;
  }
  
  public long optLong(String paramString) {
    return optLong(paramString, 0L);
  }
  
  public long optLong(String paramString, long paramLong) {
    Long long_ = a.d(opt(paramString));
    if (long_ != null)
      paramLong = long_.longValue(); 
    return paramLong;
  }
  
  public String optString(String paramString) {
    return optString(paramString, "");
  }
  
  public String optString(String paramString1, String paramString2) {
    paramString1 = a.e(opt(paramString1));
    return (paramString1 != null) ? paramString1 : paramString2;
  }
  
  public JSONObject put(String paramString, double paramDouble) {
    this.b.put(a(paramString), Double.valueOf(a.a(paramDouble)));
    return this;
  }
  
  public JSONObject put(String paramString, int paramInt) {
    this.b.put(a(paramString), Integer.valueOf(paramInt));
    return this;
  }
  
  public JSONObject put(String paramString, long paramLong) {
    this.b.put(a(paramString), Long.valueOf(paramLong));
    return this;
  }
  
  public JSONObject put(String paramString, Object paramObject) {
    if (paramObject == null) {
      this.b.remove(paramString);
      return this;
    } 
    if (paramObject instanceof Number)
      a.a(((Number)paramObject).doubleValue()); 
    this.b.put(a(paramString), paramObject);
    return this;
  }
  
  public JSONObject put(String paramString, boolean paramBoolean) {
    this.b.put(a(paramString), Boolean.valueOf(paramBoolean));
    return this;
  }
  
  public JSONObject putOpt(String paramString, Object paramObject) {
    return (paramString != null) ? ((paramObject == null) ? this : put(paramString, paramObject)) : this;
  }
  
  public Object remove(String paramString) {
    return this.b.remove(paramString);
  }
  
  public JSONArray toJSONArray(JSONArray paramJSONArray) {
    JSONArray jSONArray = new JSONArray();
    if (paramJSONArray == null)
      return null; 
    int j = paramJSONArray.length();
    if (j == 0)
      return null; 
    for (int i = 0; i < j; i++)
      jSONArray.put(opt(a.e(paramJSONArray.opt(i)))); 
    return jSONArray;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\json\JSONObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */