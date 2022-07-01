package com.tencent.tbs.patch.json;

class a {
  static double a(double paramDouble) {
    if (!Double.isInfinite(paramDouble) && !Double.isNaN(paramDouble))
      return paramDouble; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Forbidden numeric value: ");
    stringBuilder.append(paramDouble);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static JSONException a(Object paramObject1, Object paramObject2, String paramString) {
    if (paramObject2 == null) {
      paramObject2 = new StringBuilder();
      paramObject2.append("Value at ");
      paramObject2.append(paramObject1);
      paramObject2.append(" is null.");
      throw new JSONException(paramObject2.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Value ");
    stringBuilder.append(paramObject2);
    stringBuilder.append(" at ");
    stringBuilder.append(paramObject1);
    stringBuilder.append(" of type ");
    stringBuilder.append(paramObject2.getClass().getName());
    stringBuilder.append(" cannot be converted to ");
    stringBuilder.append(paramString);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static JSONException a(Object paramObject, String paramString) {
    if (paramObject == null)
      throw new JSONException("Value is null."); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Value ");
    stringBuilder.append(paramObject);
    stringBuilder.append(" of type ");
    stringBuilder.append(paramObject.getClass().getName());
    stringBuilder.append(" cannot be converted to ");
    stringBuilder.append(paramString);
    throw new JSONException(stringBuilder.toString());
  }
  
  static Boolean a(Object paramObject) {
    return (paramObject instanceof Boolean) ? (Boolean)paramObject : ((paramObject instanceof String) ? Boolean.valueOf((String)paramObject) : null);
  }
  
  static Double b(Object paramObject) {
    if (paramObject instanceof Double)
      return (Double)paramObject; 
    if (paramObject instanceof Number)
      return Double.valueOf(((Number)paramObject).doubleValue()); 
    if (paramObject instanceof String)
      try {
        return Double.valueOf((String)paramObject);
      } catch (NumberFormatException numberFormatException) {} 
    return null;
  }
  
  static Integer c(Object paramObject) {
    if (paramObject instanceof Integer)
      return (Integer)paramObject; 
    if (paramObject instanceof Number)
      return Integer.valueOf(((Number)paramObject).intValue()); 
    if (paramObject instanceof String)
      try {
        int i = (int)Double.parseDouble((String)paramObject);
        return Integer.valueOf(i);
      } catch (NumberFormatException numberFormatException) {} 
    return null;
  }
  
  static Long d(Object paramObject) {
    if (paramObject instanceof Long)
      return (Long)paramObject; 
    if (paramObject instanceof Number)
      return Long.valueOf(((Number)paramObject).longValue()); 
    if (paramObject instanceof String)
      try {
        long l = (long)Double.parseDouble((String)paramObject);
        return Long.valueOf(l);
      } catch (NumberFormatException numberFormatException) {} 
    return null;
  }
  
  static String e(Object paramObject) {
    return (paramObject instanceof String) ? (String)paramObject : ((paramObject != null) ? String.valueOf(paramObject) : null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\json\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */