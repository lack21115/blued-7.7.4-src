package com.qiniu.android.bigdata.pipeline;

import com.qiniu.android.utils.FastDatePrinter;
import com.qiniu.android.utils.Json;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class Points {
  private static String buildString(Object paramObject) {
    return (paramObject == null) ? null : ((paramObject instanceof Integer || paramObject instanceof Long || paramObject instanceof Float || paramObject instanceof Double || paramObject instanceof Boolean) ? paramObject.toString() : ((paramObject instanceof String) ? ((String)paramObject).replace("\n", "\\n").replace("\t", "\\t") : ((paramObject instanceof Collection) ? Json.encodeList((Collection)paramObject) : ((paramObject instanceof Map) ? Json.encodeMap((Map)paramObject) : ((paramObject instanceof Date) ? LazyHolder.INSTANCE.format((Date)paramObject) : paramObject.toString())))));
  }
  
  public static StringBuilder formatPoint(Object paramObject, StringBuilder paramStringBuilder) {
    Field[] arrayOfField = paramObject.getClass().getDeclaredFields();
    new Points();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int j = arrayOfField.length;
    int i = 0;
    while (true) {
      if (i < j) {
        Field field = arrayOfField[i];
        try {
          Object object = field.get(paramObject);
          hashMap.put(field.getName(), object);
        } catch (IllegalAccessException illegalAccessException) {}
        i++;
        continue;
      } 
      return formatPoint((Map)hashMap, paramStringBuilder);
    } 
  }
  
  public static <V> StringBuilder formatPoint(Map<String, V> paramMap, StringBuilder paramStringBuilder) {
    for (Map.Entry<String, V> entry : paramMap.entrySet()) {
      paramStringBuilder.append((String)entry.getKey());
      paramStringBuilder.append("=");
      paramStringBuilder.append(buildString(entry.getValue()));
      paramStringBuilder.append("\t");
    } 
    paramStringBuilder.replace(paramStringBuilder.length() - 1, paramStringBuilder.length(), "\n");
    return paramStringBuilder;
  }
  
  public static <V> StringBuilder formatPoints(List<Map<String, V>> paramList) {
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<Map<String, V>> iterator = paramList.iterator();
    while (iterator.hasNext())
      formatPoint(iterator.next(), stringBuilder); 
    return stringBuilder;
  }
  
  public static StringBuilder formatPoints(Object[] paramArrayOfObject) {
    StringBuilder stringBuilder = new StringBuilder();
    int j = paramArrayOfObject.length;
    for (int i = 0; i < j; i++)
      formatPoint(paramArrayOfObject[i], stringBuilder); 
    return stringBuilder;
  }
  
  public static <V> StringBuilder formatPoints(Map<String, V>[] paramArrayOfMap) {
    StringBuilder stringBuilder = new StringBuilder();
    int j = paramArrayOfMap.length;
    for (int i = 0; i < j; i++)
      formatPoint(paramArrayOfMap[i], stringBuilder); 
    return stringBuilder;
  }
  
  public static <V> StringBuilder formatPointsObjects(List<V> paramList) {
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<V> iterator = paramList.iterator();
    while (iterator.hasNext())
      formatPoint(iterator.next(), stringBuilder); 
    return stringBuilder;
  }
  
  static class LazyHolder {
    private static final FastDatePrinter INSTANCE = new FastDatePrinter("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Calendar.getInstance().getTimeZone(), Locale.getDefault());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\bigdata\pipeline\Points.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */