package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ASMJavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TypeUtils {
  public static boolean compatibleWithJavaBean = false;
  
  private static ConcurrentMap<String, Class<?>> mappings = new ConcurrentHashMap<String, Class<?>>();
  
  private static Class<?> optionalClass;
  
  private static boolean optionalClassInited = false;
  
  private static Method oracleDateMethod;
  
  private static boolean oracleDateMethodInited = false;
  
  private static Method oracleTimestampMethod;
  
  private static boolean oracleTimestampMethodInited = false;
  
  private static boolean setAccessibleEnable = true;
  
  static {
    addBaseClassMappings();
  }
  
  private static void addBaseClassMappings() {
    mappings.put("byte", byte.class);
    mappings.put("short", short.class);
    mappings.put("int", int.class);
    mappings.put("long", long.class);
    mappings.put("float", float.class);
    mappings.put("double", double.class);
    mappings.put("boolean", boolean.class);
    mappings.put("char", char.class);
    mappings.put("[byte", byte[].class);
    mappings.put("[short", short[].class);
    mappings.put("[int", int[].class);
    mappings.put("[long", long[].class);
    mappings.put("[float", float[].class);
    mappings.put("[double", double[].class);
    mappings.put("[boolean", boolean[].class);
    mappings.put("[char", char[].class);
    mappings.put(HashMap.class.getName(), HashMap.class);
  }
  
  public static <T> T cast(Object paramObject, Class<T> paramClass, ParserConfig paramParserConfig) {
    if (paramObject == null)
      return null; 
    if (paramClass != null) {
      if (paramClass == paramObject.getClass())
        return (T)paramObject; 
      if (paramObject instanceof Map) {
        if (paramClass == Map.class)
          return (T)paramObject; 
        Map<String, Object> map = (Map)paramObject;
        return (T)((paramClass == Object.class && !map.containsKey(JSON.DEFAULT_TYPE_KEY)) ? paramObject : (Object)castToJavaBean(map, paramClass, paramParserConfig));
      } 
      if (paramClass.isArray()) {
        if (paramObject instanceof Collection) {
          Collection collection = (Collection)paramObject;
          int i = 0;
          paramObject = Array.newInstance(paramClass.getComponentType(), collection.size());
          Iterator iterator = collection.iterator();
          while (iterator.hasNext()) {
            Array.set(paramObject, i, cast(iterator.next(), paramClass.getComponentType(), paramParserConfig));
            i++;
          } 
          return (T)paramObject;
        } 
        if (paramClass == byte[].class)
          return (T)castToBytes(paramObject); 
      } 
      if (paramClass.isAssignableFrom(paramObject.getClass()))
        return (T)paramObject; 
      if (paramClass == boolean.class || paramClass == Boolean.class)
        return (T)castToBoolean(paramObject); 
      if (paramClass == byte.class || paramClass == Byte.class)
        return (T)castToByte(paramObject); 
      if (paramClass == short.class || paramClass == Short.class)
        return (T)castToShort(paramObject); 
      if (paramClass == int.class || paramClass == Integer.class)
        return (T)castToInt(paramObject); 
      if (paramClass == long.class || paramClass == Long.class)
        return (T)castToLong(paramObject); 
      if (paramClass == float.class || paramClass == Float.class)
        return (T)castToFloat(paramObject); 
      if (paramClass == double.class || paramClass == Double.class)
        return (T)castToDouble(paramObject); 
      if (paramClass == String.class)
        return (T)castToString(paramObject); 
      if (paramClass == BigDecimal.class)
        return (T)castToBigDecimal(paramObject); 
      if (paramClass == BigInteger.class)
        return (T)castToBigInteger(paramObject); 
      if (paramClass == Date.class)
        return (T)castToDate(paramObject); 
      if (paramClass == Date.class)
        return (T)castToSqlDate(paramObject); 
      if (paramClass == Timestamp.class)
        return (T)castToTimestamp(paramObject); 
      if (paramClass.isEnum())
        return castToEnum(paramObject, paramClass, paramParserConfig); 
      if (Calendar.class.isAssignableFrom(paramClass)) {
        StringBuilder stringBuilder1;
        Date date = castToDate(paramObject);
        if (paramClass == Calendar.class) {
          paramObject = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
        } else {
          try {
            paramObject = (Calendar)paramClass.newInstance();
            paramObject.setTime(date);
            return (T)paramObject;
          } catch (Exception exception) {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("can not cast to : ");
            stringBuilder1.append(paramClass.getName());
            throw new JSONException(stringBuilder1.toString(), exception);
          } 
        } 
        exception.setTime((Date)stringBuilder1);
        return (T)exception;
      } 
      if (exception instanceof String) {
        String str = (String)exception;
        if (str.length() != 0 && !"null".equals(str)) {
          if ("NULL".equals(str))
            return null; 
          if (paramClass == Currency.class)
            return (T)Currency.getInstance(str); 
        } else {
          return null;
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("can not cast to : ");
      stringBuilder.append(paramClass.getName());
      throw new JSONException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("clazz is null");
  }
  
  public static <T> T cast(Object paramObject, ParameterizedType paramParameterizedType, ParserConfig paramParserConfig) {
    ArrayList arrayList;
    HashMap<Object, Object> hashMap;
    Map.Entry entry;
    Type type = paramParameterizedType.getRawType();
    if (type == Set.class || type == HashSet.class || type == TreeSet.class || type == List.class || type == ArrayList.class) {
      Type type1 = paramParameterizedType.getActualTypeArguments()[0];
      if (paramObject instanceof Iterable) {
        if (type == Set.class || type == HashSet.class) {
          HashSet hashSet = new HashSet();
        } else if (type == TreeSet.class) {
          TreeSet treeSet = new TreeSet();
        } else {
          arrayList = new ArrayList();
        } 
        paramObject = ((Iterable)paramObject).iterator();
        while (paramObject.hasNext())
          arrayList.add(cast(paramObject.next(), type1, paramParserConfig)); 
        return (T)arrayList;
      } 
    } 
    if (type == Map.class || type == HashMap.class) {
      Type type1 = arrayList.getActualTypeArguments()[0];
      Type type2 = arrayList.getActualTypeArguments()[1];
      if (paramObject instanceof Map) {
        hashMap = new HashMap<Object, Object>();
        paramObject = ((Map)paramObject).entrySet().iterator();
        while (paramObject.hasNext()) {
          entry = paramObject.next();
          hashMap.put(cast(entry.getKey(), type1, paramParserConfig), cast(entry.getValue(), type2, paramParserConfig));
        } 
        return (T)hashMap;
      } 
    } 
    if (paramObject instanceof String && ((String)paramObject).length() == 0)
      return null; 
    if ((hashMap.getActualTypeArguments()).length == 1 && hashMap.getActualTypeArguments()[0] instanceof java.lang.reflect.WildcardType)
      return cast(paramObject, (Type)entry, paramParserConfig); 
    paramObject = new StringBuilder();
    paramObject.append("can not cast to : ");
    paramObject.append(hashMap);
    throw new JSONException(paramObject.toString());
  }
  
  public static <T> T cast(Object paramObject, Type paramType, ParserConfig paramParserConfig) {
    if (paramObject == null)
      return null; 
    if (paramType instanceof Class)
      return cast(paramObject, (Class<T>)paramType, paramParserConfig); 
    if (paramType instanceof ParameterizedType)
      return cast(paramObject, (ParameterizedType)paramType, paramParserConfig); 
    if (paramObject instanceof String) {
      String str = (String)paramObject;
      if (str.length() == 0 || "null".equals(str) || "NULL".equals(str))
        return null; 
    } 
    if (paramType instanceof TypeVariable)
      return (T)paramObject; 
    paramObject = new StringBuilder();
    paramObject.append("can not cast to : ");
    paramObject.append(paramType);
    throw new JSONException(paramObject.toString());
  }
  
  public static BigDecimal castToBigDecimal(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof BigDecimal)
      return (BigDecimal)paramObject; 
    if (paramObject instanceof BigInteger)
      return new BigDecimal((BigInteger)paramObject); 
    paramObject = paramObject.toString();
    return (paramObject.length() == 0) ? null : new BigDecimal((String)paramObject);
  }
  
  public static BigInteger castToBigInteger(Object paramObject) {
    Object object = null;
    if (paramObject == null)
      return null; 
    if (paramObject instanceof BigInteger)
      return (BigInteger)paramObject; 
    if (paramObject instanceof Float || paramObject instanceof Double)
      return BigInteger.valueOf(((Number)paramObject).longValue()); 
    String str = paramObject.toString();
    paramObject = object;
    if (str.length() != 0) {
      paramObject = object;
      if (!"null".equals(str)) {
        if ("NULL".equals(str))
          return null; 
        paramObject = new BigInteger(str);
      } 
    } 
    return (BigInteger)paramObject;
  }
  
  public static Boolean castToBoolean(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Boolean)
      return (Boolean)paramObject; 
    if (paramObject instanceof Number) {
      int i = ((Number)paramObject).intValue();
      boolean bool = true;
      if (i != 1)
        bool = false; 
      return Boolean.valueOf(bool);
    } 
    if (paramObject instanceof String) {
      String str = (String)paramObject;
      if (str.length() != 0 && !"null".equals(str)) {
        if ("NULL".equals(str))
          return null; 
        if ("true".equalsIgnoreCase(str) || "1".equals(str))
          return Boolean.TRUE; 
        if ("false".equalsIgnoreCase(str) || "0".equals(str))
          return Boolean.FALSE; 
      } else {
        return null;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to boolean, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static Byte castToByte(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Number)
      return Byte.valueOf(((Number)paramObject).byteValue()); 
    if (paramObject instanceof String) {
      paramObject = paramObject;
      return (paramObject.length() != 0 && !"null".equals(paramObject)) ? ("NULL".equals(paramObject) ? null : Byte.valueOf(Byte.parseByte((String)paramObject))) : null;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to byte, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static byte[] castToBytes(Object paramObject) {
    if (paramObject instanceof byte[])
      return (byte[])paramObject; 
    if (paramObject instanceof String)
      return IOUtils.decodeFast((String)paramObject); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to int, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static Character castToChar(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Character)
      return (Character)paramObject; 
    if (paramObject instanceof String) {
      String str = (String)paramObject;
      if (str.length() == 0)
        return null; 
      if (str.length() == 1)
        return Character.valueOf(str.charAt(0)); 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("can not cast to char, value : ");
      stringBuilder1.append(paramObject);
      throw new JSONException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to char, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static Date castToDate(Object paramObject) {
    StringBuilder stringBuilder;
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Date)
      return (Date)paramObject; 
    if (paramObject instanceof Calendar)
      return ((Calendar)paramObject).getTime(); 
    long l = -1L;
    if (paramObject instanceof Number)
      return new Date(((Number)paramObject).longValue()); 
    if (paramObject instanceof String) {
      String str = (String)paramObject;
      if (str.indexOf('-') != -1) {
        if (str.length() == JSON.DEFFAULT_DATE_FORMAT.length()) {
          paramObject = JSON.DEFFAULT_DATE_FORMAT;
        } else if (str.length() == 10) {
          paramObject = "yyyy-MM-dd";
        } else if (str.length() == 19) {
          paramObject = "yyyy-MM-dd HH:mm:ss";
        } else {
          paramObject = "yyyy-MM-dd HH:mm:ss.SSS";
        } 
        paramObject = new SimpleDateFormat((String)paramObject, JSON.defaultLocale);
        paramObject.setTimeZone(JSON.defaultTimeZone);
        try {
          return paramObject.parse(str);
        } catch (ParseException parseException) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("can not cast to Date, value : ");
          stringBuilder.append(str);
          throw new JSONException(stringBuilder.toString());
        } 
      } 
      if (str.length() == 0)
        return null; 
      l = Long.parseLong(str);
    } 
    if (l < 0L) {
      Class<?> clazz = stringBuilder.getClass();
      if ("oracle.sql.TIMESTAMP".equals(clazz.getName())) {
        if (oracleTimestampMethod == null && !oracleTimestampMethodInited)
          try {
            oracleTimestampMethod = clazz.getMethod("toJdbc", new Class[0]);
          } catch (NoSuchMethodException noSuchMethodException) {
          
          } finally {
            oracleTimestampMethodInited = true;
          }  
        try {
          object = oracleTimestampMethod.invoke(stringBuilder, new Object[0]);
          return (Date)object;
        } catch (Exception null) {
          throw new JSONException("can not cast oracle.sql.TIMESTAMP to Date", object);
        } 
      } 
      if ("oracle.sql.DATE".equals(noSuchMethodException.getName())) {
        if (oracleDateMethod == null && !oracleDateMethodInited)
          try {
            oracleDateMethod = noSuchMethodException.getMethod("toJdbc", new Class[0]);
          } catch (NoSuchMethodException noSuchMethodException1) {
          
          } finally {
            oracleDateMethodInited = true;
          }  
        try {
          object = oracleDateMethod.invoke(stringBuilder, new Object[0]);
          return (Date)object;
        } catch (Exception object) {
          throw new JSONException("can not cast oracle.sql.DATE to Date", object);
        } 
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("can not cast to Date, value : ");
      stringBuilder1.append(object);
      throw new JSONException(stringBuilder1.toString());
    } 
    return new Date(l);
  }
  
  public static Double castToDouble(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Number)
      return Double.valueOf(((Number)paramObject).doubleValue()); 
    if (paramObject instanceof String) {
      String str = paramObject.toString();
      if (str.length() != 0 && !"null".equals(str)) {
        if ("NULL".equals(str))
          return null; 
        paramObject = str;
        if (str.indexOf(',') != 0)
          paramObject = str.replaceAll(",", ""); 
        return Double.valueOf(Double.parseDouble((String)paramObject));
      } 
      return null;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to double, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static <T> T castToEnum(Object paramObject, Class<T> paramClass, ParserConfig paramParserConfig) {
    try {
      if (paramObject instanceof String) {
        paramObject = paramObject;
        return (T)((paramObject.length() == 0) ? null : Enum.valueOf((Class)paramClass, (String)paramObject));
      } 
      if (paramObject instanceof Number) {
        int i = ((Number)paramObject).intValue();
        paramObject = paramClass.getEnumConstants();
        if (i < paramObject.length)
          return (T)paramObject[i]; 
      } 
      paramObject = new StringBuilder();
      paramObject.append("can not cast to : ");
      paramObject.append(paramClass.getName());
      throw new JSONException(paramObject.toString());
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("can not cast to : ");
      stringBuilder.append(paramClass.getName());
      throw new JSONException(stringBuilder.toString(), exception);
    } 
  }
  
  public static Float castToFloat(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Number)
      return Float.valueOf(((Number)paramObject).floatValue()); 
    if (paramObject instanceof String) {
      String str = paramObject.toString();
      if (str.length() != 0 && !"null".equals(str)) {
        if ("NULL".equals(str))
          return null; 
        paramObject = str;
        if (str.indexOf(',') != 0)
          paramObject = str.replaceAll(",", ""); 
        return Float.valueOf(Float.parseFloat((String)paramObject));
      } 
      return null;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to float, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static Integer castToInt(Object paramObject) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static <T> T castToJavaBean(Object paramObject, Class<T> paramClass) {
    return cast(paramObject, paramClass, ParserConfig.getGlobalInstance());
  }
  
  public static <T> T castToJavaBean(Map<String, Object> paramMap, Class<T> paramClass, ParserConfig paramParserConfig) {
    StringBuilder stringBuilder;
    JSONObject jSONObject;
    String str1;
    JavaBeanDeserializer javaBeanDeserializer;
    int i = 0;
    if (paramClass == StackTraceElement.class)
      try {
        str1 = (String)paramMap.get("className");
        str2 = (String)paramMap.get("methodName");
        String str = (String)paramMap.get("fileName");
        Number number = (Number)paramMap.get("lineNumber");
        if (number != null)
          i = number.intValue(); 
        return (T)new StackTraceElement(str1, str2, str, i);
      } catch (Exception exception) {
        throw new JSONException(exception.getMessage(), exception);
      }  
    Object object = exception.get(JSON.DEFAULT_TYPE_KEY);
    if (object instanceof String) {
      object = object;
      Class<?> clazz = loadClass((String)object);
      if (clazz != null) {
        if (!clazz.equals(str1))
          return castToJavaBean((Map<String, Object>)exception, (Class)clazz, (ParserConfig)str2); 
      } else {
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        stringBuilder.append(" not found");
        throw new ClassNotFoundException(stringBuilder.toString());
      } 
    } 
    if (str1.isInterface()) {
      if (stringBuilder instanceof JSONObject) {
        jSONObject = (JSONObject)stringBuilder;
      } else {
        jSONObject = new JSONObject((Map)jSONObject);
      } 
      return (T)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[] { (Class)str1 }, (InvocationHandler)jSONObject);
    } 
    object = str2;
    if (str2 == null)
      object = ParserConfig.getGlobalInstance(); 
    String str2 = null;
    ObjectDeserializer objectDeserializer = object.getDeserializer((Type)str1);
    if (objectDeserializer instanceof JavaBeanDeserializer) {
      javaBeanDeserializer = (JavaBeanDeserializer)objectDeserializer;
    } else {
      str1 = str2;
      if (objectDeserializer instanceof ASMJavaBeanDeserializer)
        javaBeanDeserializer = ((ASMJavaBeanDeserializer)objectDeserializer).getInnterSerializer(); 
    } 
    if (javaBeanDeserializer != null)
      return (T)javaBeanDeserializer.createInstance((Map)jSONObject, (ParserConfig)object); 
    throw new JSONException("can not get javaBeanDeserializer");
  }
  
  public static Long castToLong(Object paramObject) {
    String str = null;
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Number)
      return Long.valueOf(((Number)paramObject).longValue()); 
    if (paramObject instanceof String) {
      String str1 = (String)paramObject;
      if (str1.length() != 0 && !"null".equals(str1)) {
        if ("NULL".equals(str1))
          return null; 
        String str2 = str1;
        if (str1.indexOf(',') != 0)
          str2 = str1.replaceAll(",", ""); 
        try {
          long l = Long.parseLong(str2);
          return Long.valueOf(l);
        } catch (NumberFormatException numberFormatException) {
          Calendar calendar;
          JSONScanner jSONScanner = new JSONScanner(str2);
          str2 = str;
          if (jSONScanner.scanISO8601DateIfMatch(false))
            calendar = jSONScanner.getCalendar(); 
          jSONScanner.close();
          if (calendar != null)
            return Long.valueOf(calendar.getTimeInMillis()); 
        } 
      } else {
        return null;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to long, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static Short castToShort(Object paramObject) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Number)
      return Short.valueOf(((Number)paramObject).shortValue()); 
    if (paramObject instanceof String) {
      paramObject = paramObject;
      return (paramObject.length() != 0 && !"null".equals(paramObject)) ? ("NULL".equals(paramObject) ? null : Short.valueOf(Short.parseShort((String)paramObject))) : null;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to short, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static Date castToSqlDate(Object paramObject) {
    long l;
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Date)
      return (Date)paramObject; 
    if (paramObject instanceof Date)
      return new Date(((Date)paramObject).getTime()); 
    if (paramObject instanceof Calendar)
      return new Date(((Calendar)paramObject).getTimeInMillis()); 
    if (paramObject instanceof Number) {
      l = ((Number)paramObject).longValue();
    } else {
      l = 0L;
    } 
    if (paramObject instanceof String) {
      String str = (String)paramObject;
      if (str.length() != 0 && !"null".equals(str)) {
        if ("NULL".equals(str))
          return null; 
        l = Long.parseLong(str);
      } else {
        return null;
      } 
    } 
    if (l > 0L)
      return new Date(l); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to Date, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static String castToString(Object paramObject) {
    return (paramObject == null) ? null : paramObject.toString();
  }
  
  public static Timestamp castToTimestamp(Object paramObject) {
    long l;
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Calendar)
      return new Timestamp(((Calendar)paramObject).getTimeInMillis()); 
    if (paramObject instanceof Timestamp)
      return (Timestamp)paramObject; 
    if (paramObject instanceof Date)
      return new Timestamp(((Date)paramObject).getTime()); 
    if (paramObject instanceof Number) {
      l = ((Number)paramObject).longValue();
    } else {
      l = 0L;
    } 
    if (paramObject instanceof String) {
      String str = (String)paramObject;
      if (str.length() != 0 && !"null".equals(str)) {
        if ("NULL".equals(str))
          return null; 
        l = Long.parseLong(str);
      } else {
        return null;
      } 
    } 
    if (l > 0L)
      return new Timestamp(l); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("can not cast to Date, value : ");
    stringBuilder.append(paramObject);
    throw new JSONException(stringBuilder.toString());
  }
  
  public static void clearClassMapping() {
    mappings.clear();
    addBaseClassMappings();
  }
  
  public static List<FieldInfo> computeGetters(Class<?> paramClass, JSONType paramJSONType, Map<String, String> paramMap, boolean paramBoolean) {
    // Byte code:
    //   0: new java/util/LinkedHashMap
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #17
    //   9: aload_0
    //   10: invokevirtual getMethods : ()[Ljava/lang/reflect/Method;
    //   13: astore #13
    //   15: aload #13
    //   17: arraylength
    //   18: istore #8
    //   20: iconst_0
    //   21: istore #9
    //   23: iload #9
    //   25: iload #8
    //   27: if_icmpge -> 1207
    //   30: aload #13
    //   32: iload #9
    //   34: aaload
    //   35: astore #18
    //   37: aload #18
    //   39: invokevirtual getName : ()Ljava/lang/String;
    //   42: astore #16
    //   44: aconst_null
    //   45: astore #11
    //   47: aload #18
    //   49: invokevirtual getModifiers : ()I
    //   52: invokestatic isStatic : (I)Z
    //   55: ifeq -> 61
    //   58: goto -> 1198
    //   61: aload #18
    //   63: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   66: getstatic java/lang/Void.TYPE : Ljava/lang/Class;
    //   69: invokevirtual equals : (Ljava/lang/Object;)Z
    //   72: ifeq -> 78
    //   75: goto -> 58
    //   78: aload #18
    //   80: invokevirtual getParameterTypes : ()[Ljava/lang/Class;
    //   83: arraylength
    //   84: ifeq -> 90
    //   87: goto -> 58
    //   90: aload #18
    //   92: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   95: ldc_w java/lang/ClassLoader
    //   98: if_acmpne -> 104
    //   101: goto -> 58
    //   104: aload #18
    //   106: invokevirtual getName : ()Ljava/lang/String;
    //   109: ldc_w 'getMetaClass'
    //   112: invokevirtual equals : (Ljava/lang/Object;)Z
    //   115: ifeq -> 138
    //   118: aload #18
    //   120: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   123: invokevirtual getName : ()Ljava/lang/String;
    //   126: ldc_w 'groovy.lang.MetaClass'
    //   129: invokevirtual equals : (Ljava/lang/Object;)Z
    //   132: ifeq -> 138
    //   135: goto -> 58
    //   138: aload #18
    //   140: ldc_w com/alibaba/fastjson/annotation/JSONField
    //   143: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   146: checkcast com/alibaba/fastjson/annotation/JSONField
    //   149: astore_1
    //   150: aload_1
    //   151: astore #14
    //   153: aload_1
    //   154: ifnonnull -> 165
    //   157: aload_0
    //   158: aload #18
    //   160: invokestatic getSupperMethodAnnotation : (Ljava/lang/Class;Ljava/lang/reflect/Method;)Lcom/alibaba/fastjson/annotation/JSONField;
    //   163: astore #14
    //   165: aload #14
    //   167: ifnull -> 331
    //   170: aload #14
    //   172: invokeinterface serialize : ()Z
    //   177: ifne -> 183
    //   180: goto -> 58
    //   183: aload #14
    //   185: invokeinterface ordinal : ()I
    //   190: istore #7
    //   192: aload #14
    //   194: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   199: invokestatic of : ([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   202: istore #10
    //   204: aload #14
    //   206: invokeinterface name : ()Ljava/lang/String;
    //   211: invokevirtual length : ()I
    //   214: ifeq -> 290
    //   217: aload #14
    //   219: invokeinterface name : ()Ljava/lang/String;
    //   224: astore #11
    //   226: aload #11
    //   228: astore_1
    //   229: aload_2
    //   230: ifnull -> 257
    //   233: aload_2
    //   234: aload #11
    //   236: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   241: checkcast java/lang/String
    //   244: astore #11
    //   246: aload #11
    //   248: astore_1
    //   249: aload #11
    //   251: ifnonnull -> 257
    //   254: goto -> 58
    //   257: aload #17
    //   259: aload_1
    //   260: new com/alibaba/fastjson/util/FieldInfo
    //   263: dup
    //   264: aload_1
    //   265: aload #18
    //   267: aconst_null
    //   268: aload_0
    //   269: aconst_null
    //   270: iload #7
    //   272: iload #10
    //   274: aload #14
    //   276: aconst_null
    //   277: aconst_null
    //   278: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   281: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   286: pop
    //   287: goto -> 58
    //   290: iload #7
    //   292: istore #6
    //   294: iload #10
    //   296: istore #5
    //   298: aload #14
    //   300: invokeinterface label : ()Ljava/lang/String;
    //   305: invokevirtual length : ()I
    //   308: ifeq -> 337
    //   311: aload #14
    //   313: invokeinterface label : ()Ljava/lang/String;
    //   318: astore #11
    //   320: iload #7
    //   322: istore #6
    //   324: iload #10
    //   326: istore #5
    //   328: goto -> 337
    //   331: iconst_0
    //   332: istore #6
    //   334: iconst_0
    //   335: istore #5
    //   337: aload #16
    //   339: ldc_w 'get'
    //   342: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   345: ifeq -> 810
    //   348: aload #16
    //   350: invokevirtual length : ()I
    //   353: iconst_4
    //   354: if_icmpge -> 360
    //   357: goto -> 58
    //   360: aload #16
    //   362: ldc_w 'getClass'
    //   365: invokevirtual equals : (Ljava/lang/Object;)Z
    //   368: ifeq -> 374
    //   371: goto -> 357
    //   374: aload #16
    //   376: iconst_3
    //   377: invokevirtual charAt : (I)C
    //   380: istore #4
    //   382: iload #4
    //   384: invokestatic isUpperCase : (C)Z
    //   387: ifne -> 469
    //   390: iload #4
    //   392: sipush #512
    //   395: if_icmple -> 401
    //   398: goto -> 469
    //   401: iload #4
    //   403: bipush #95
    //   405: if_icmpne -> 418
    //   408: aload #16
    //   410: iconst_4
    //   411: invokevirtual substring : (I)Ljava/lang/String;
    //   414: astore_1
    //   415: goto -> 526
    //   418: iload #4
    //   420: bipush #102
    //   422: if_icmpne -> 435
    //   425: aload #16
    //   427: iconst_3
    //   428: invokevirtual substring : (I)Ljava/lang/String;
    //   431: astore_1
    //   432: goto -> 526
    //   435: aload #16
    //   437: invokevirtual length : ()I
    //   440: iconst_5
    //   441: if_icmplt -> 58
    //   444: aload #16
    //   446: iconst_4
    //   447: invokevirtual charAt : (I)C
    //   450: invokestatic isUpperCase : (C)Z
    //   453: ifeq -> 58
    //   456: aload #16
    //   458: iconst_3
    //   459: invokevirtual substring : (I)Ljava/lang/String;
    //   462: invokestatic decapitalize : (Ljava/lang/String;)Ljava/lang/String;
    //   465: astore_1
    //   466: goto -> 526
    //   469: getstatic com/alibaba/fastjson/util/TypeUtils.compatibleWithJavaBean : Z
    //   472: ifeq -> 488
    //   475: aload #16
    //   477: iconst_3
    //   478: invokevirtual substring : (I)Ljava/lang/String;
    //   481: invokestatic decapitalize : (Ljava/lang/String;)Ljava/lang/String;
    //   484: astore_1
    //   485: goto -> 526
    //   488: new java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial <init> : ()V
    //   495: astore_1
    //   496: aload_1
    //   497: aload #16
    //   499: iconst_3
    //   500: invokevirtual charAt : (I)C
    //   503: invokestatic toLowerCase : (C)C
    //   506: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload_1
    //   511: aload #16
    //   513: iconst_4
    //   514: invokevirtual substring : (I)Ljava/lang/String;
    //   517: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: aload_1
    //   522: invokevirtual toString : ()Ljava/lang/String;
    //   525: astore_1
    //   526: aload_0
    //   527: aload_1
    //   528: invokestatic isJSONTypeIgnore : (Ljava/lang/Class;Ljava/lang/String;)Z
    //   531: ifeq -> 537
    //   534: goto -> 357
    //   537: aload_0
    //   538: aload_1
    //   539: invokestatic getField : (Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   542: astore #19
    //   544: aload #19
    //   546: ifnull -> 721
    //   549: aload #19
    //   551: ldc_w com/alibaba/fastjson/annotation/JSONField
    //   554: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   557: checkcast com/alibaba/fastjson/annotation/JSONField
    //   560: astore #12
    //   562: aload #12
    //   564: ifnull -> 706
    //   567: aload #12
    //   569: invokeinterface serialize : ()Z
    //   574: ifne -> 580
    //   577: goto -> 357
    //   580: aload #12
    //   582: invokeinterface ordinal : ()I
    //   587: istore #6
    //   589: aload #12
    //   591: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   596: invokestatic of : ([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   599: istore #5
    //   601: aload #12
    //   603: invokeinterface name : ()Ljava/lang/String;
    //   608: invokevirtual length : ()I
    //   611: ifeq -> 654
    //   614: aload #12
    //   616: invokeinterface name : ()Ljava/lang/String;
    //   621: astore #15
    //   623: aload #15
    //   625: astore_1
    //   626: aload_2
    //   627: ifnull -> 654
    //   630: aload_2
    //   631: aload #15
    //   633: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   638: checkcast java/lang/String
    //   641: astore #15
    //   643: aload #15
    //   645: astore_1
    //   646: aload #15
    //   648: ifnonnull -> 654
    //   651: goto -> 371
    //   654: aload #12
    //   656: invokeinterface label : ()Ljava/lang/String;
    //   661: invokevirtual length : ()I
    //   664: ifeq -> 691
    //   667: aload #12
    //   669: invokeinterface label : ()Ljava/lang/String;
    //   674: astore #11
    //   676: iload #5
    //   678: istore #7
    //   680: iload #6
    //   682: istore #5
    //   684: iload #7
    //   686: istore #6
    //   688: goto -> 736
    //   691: iload #5
    //   693: istore #7
    //   695: iload #6
    //   697: istore #5
    //   699: iload #7
    //   701: istore #6
    //   703: goto -> 718
    //   706: iload #6
    //   708: istore #7
    //   710: iload #5
    //   712: istore #6
    //   714: iload #7
    //   716: istore #5
    //   718: goto -> 736
    //   721: iload #6
    //   723: istore #7
    //   725: aconst_null
    //   726: astore #12
    //   728: iload #5
    //   730: istore #6
    //   732: iload #7
    //   734: istore #5
    //   736: aload_1
    //   737: astore #15
    //   739: aload_2
    //   740: ifnull -> 764
    //   743: aload_2
    //   744: aload_1
    //   745: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   750: checkcast java/lang/String
    //   753: astore_1
    //   754: aload_1
    //   755: astore #15
    //   757: aload_1
    //   758: ifnonnull -> 764
    //   761: goto -> 371
    //   764: aload #17
    //   766: aload #15
    //   768: new com/alibaba/fastjson/util/FieldInfo
    //   771: dup
    //   772: aload #15
    //   774: aload #18
    //   776: aload #19
    //   778: aload_0
    //   779: aconst_null
    //   780: iload #5
    //   782: iload #6
    //   784: aload #14
    //   786: aload #12
    //   788: aload #11
    //   790: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   793: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   798: pop
    //   799: iload #6
    //   801: istore #7
    //   803: aload #11
    //   805: astore #12
    //   807: goto -> 822
    //   810: aload #11
    //   812: astore #12
    //   814: iload #5
    //   816: istore #7
    //   818: iload #6
    //   820: istore #5
    //   822: aload #16
    //   824: ldc_w 'is'
    //   827: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   830: ifeq -> 1198
    //   833: aload #16
    //   835: invokevirtual length : ()I
    //   838: iconst_3
    //   839: if_icmpge -> 845
    //   842: goto -> 1198
    //   845: aload #16
    //   847: iconst_2
    //   848: invokevirtual charAt : (I)C
    //   851: istore #4
    //   853: iload #4
    //   855: invokestatic isUpperCase : (C)Z
    //   858: ifeq -> 921
    //   861: getstatic com/alibaba/fastjson/util/TypeUtils.compatibleWithJavaBean : Z
    //   864: ifeq -> 880
    //   867: aload #16
    //   869: iconst_2
    //   870: invokevirtual substring : (I)Ljava/lang/String;
    //   873: invokestatic decapitalize : (Ljava/lang/String;)Ljava/lang/String;
    //   876: astore_1
    //   877: goto -> 952
    //   880: new java/lang/StringBuilder
    //   883: dup
    //   884: invokespecial <init> : ()V
    //   887: astore_1
    //   888: aload_1
    //   889: aload #16
    //   891: iconst_2
    //   892: invokevirtual charAt : (I)C
    //   895: invokestatic toLowerCase : (C)C
    //   898: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   901: pop
    //   902: aload_1
    //   903: aload #16
    //   905: iconst_3
    //   906: invokevirtual substring : (I)Ljava/lang/String;
    //   909: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: pop
    //   913: aload_1
    //   914: invokevirtual toString : ()Ljava/lang/String;
    //   917: astore_1
    //   918: goto -> 952
    //   921: iload #4
    //   923: bipush #95
    //   925: if_icmpne -> 938
    //   928: aload #16
    //   930: iconst_3
    //   931: invokevirtual substring : (I)Ljava/lang/String;
    //   934: astore_1
    //   935: goto -> 952
    //   938: iload #4
    //   940: bipush #102
    //   942: if_icmpne -> 1198
    //   945: aload #16
    //   947: iconst_2
    //   948: invokevirtual substring : (I)Ljava/lang/String;
    //   951: astore_1
    //   952: aload_0
    //   953: aload_1
    //   954: invokestatic getField : (Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   957: astore #15
    //   959: aload #15
    //   961: ifnonnull -> 975
    //   964: aload_0
    //   965: aload #16
    //   967: invokestatic getField : (Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   970: astore #15
    //   972: goto -> 975
    //   975: aload #15
    //   977: ifnull -> 1128
    //   980: aload #15
    //   982: ldc_w com/alibaba/fastjson/annotation/JSONField
    //   985: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   988: checkcast com/alibaba/fastjson/annotation/JSONField
    //   991: astore #11
    //   993: aload #11
    //   995: ifnull -> 1125
    //   998: aload #11
    //   1000: invokeinterface serialize : ()Z
    //   1005: ifne -> 1011
    //   1008: goto -> 1198
    //   1011: aload #11
    //   1013: invokeinterface ordinal : ()I
    //   1018: istore #6
    //   1020: aload #11
    //   1022: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1027: invokestatic of : ([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   1030: istore #5
    //   1032: aload #11
    //   1034: invokeinterface name : ()Ljava/lang/String;
    //   1039: invokevirtual length : ()I
    //   1042: ifeq -> 1085
    //   1045: aload #11
    //   1047: invokeinterface name : ()Ljava/lang/String;
    //   1052: astore #16
    //   1054: aload #16
    //   1056: astore_1
    //   1057: aload_2
    //   1058: ifnull -> 1085
    //   1061: aload_2
    //   1062: aload #16
    //   1064: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1069: checkcast java/lang/String
    //   1072: astore #16
    //   1074: aload #16
    //   1076: astore_1
    //   1077: aload #16
    //   1079: ifnonnull -> 1085
    //   1082: goto -> 1198
    //   1085: aload #11
    //   1087: invokeinterface label : ()Ljava/lang/String;
    //   1092: invokevirtual length : ()I
    //   1095: ifeq -> 1114
    //   1098: aload #11
    //   1100: invokeinterface label : ()Ljava/lang/String;
    //   1105: astore #12
    //   1107: iload #5
    //   1109: istore #7
    //   1111: goto -> 1135
    //   1114: iload #5
    //   1116: istore #7
    //   1118: iload #6
    //   1120: istore #5
    //   1122: goto -> 1131
    //   1125: goto -> 1131
    //   1128: aconst_null
    //   1129: astore #11
    //   1131: iload #5
    //   1133: istore #6
    //   1135: aload_1
    //   1136: astore #16
    //   1138: aload_2
    //   1139: ifnull -> 1163
    //   1142: aload_2
    //   1143: aload_1
    //   1144: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1149: checkcast java/lang/String
    //   1152: astore_1
    //   1153: aload_1
    //   1154: astore #16
    //   1156: aload_1
    //   1157: ifnonnull -> 1163
    //   1160: goto -> 1198
    //   1163: aload #17
    //   1165: aload #16
    //   1167: new com/alibaba/fastjson/util/FieldInfo
    //   1170: dup
    //   1171: aload #16
    //   1173: aload #18
    //   1175: aload #15
    //   1177: aload_0
    //   1178: aconst_null
    //   1179: iload #6
    //   1181: iload #7
    //   1183: aload #14
    //   1185: aload #11
    //   1187: aload #12
    //   1189: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   1192: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1197: pop
    //   1198: iload #9
    //   1200: iconst_1
    //   1201: iadd
    //   1202: istore #9
    //   1204: goto -> 23
    //   1207: aload_0
    //   1208: invokevirtual getFields : ()[Ljava/lang/reflect/Field;
    //   1211: astore #13
    //   1213: aload #13
    //   1215: arraylength
    //   1216: istore #9
    //   1218: iconst_0
    //   1219: istore #7
    //   1221: iload #7
    //   1223: iload #9
    //   1225: if_icmpge -> 1474
    //   1228: aload #13
    //   1230: iload #7
    //   1232: aaload
    //   1233: astore #14
    //   1235: aload #14
    //   1237: invokevirtual getModifiers : ()I
    //   1240: invokestatic isStatic : (I)Z
    //   1243: ifeq -> 1249
    //   1246: goto -> 1465
    //   1249: aload #14
    //   1251: ldc_w com/alibaba/fastjson/annotation/JSONField
    //   1254: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   1257: checkcast com/alibaba/fastjson/annotation/JSONField
    //   1260: astore #15
    //   1262: aload #14
    //   1264: invokevirtual getName : ()Ljava/lang/String;
    //   1267: astore_1
    //   1268: aload #15
    //   1270: ifnull -> 1383
    //   1273: aload #15
    //   1275: invokeinterface serialize : ()Z
    //   1280: ifne -> 1286
    //   1283: goto -> 1246
    //   1286: aload #15
    //   1288: invokeinterface ordinal : ()I
    //   1293: istore #6
    //   1295: aload #15
    //   1297: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1302: invokestatic of : ([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   1305: istore #5
    //   1307: aload #15
    //   1309: invokeinterface name : ()Ljava/lang/String;
    //   1314: invokevirtual length : ()I
    //   1317: ifeq -> 1328
    //   1320: aload #15
    //   1322: invokeinterface name : ()Ljava/lang/String;
    //   1327: astore_1
    //   1328: aload #15
    //   1330: invokeinterface label : ()Ljava/lang/String;
    //   1335: invokevirtual length : ()I
    //   1338: ifeq -> 1365
    //   1341: aload #15
    //   1343: invokeinterface label : ()Ljava/lang/String;
    //   1348: astore #11
    //   1350: iload #5
    //   1352: istore #8
    //   1354: iload #6
    //   1356: istore #5
    //   1358: iload #8
    //   1360: istore #6
    //   1362: goto -> 1392
    //   1365: iload #5
    //   1367: istore #8
    //   1369: aconst_null
    //   1370: astore #11
    //   1372: iload #6
    //   1374: istore #5
    //   1376: iload #8
    //   1378: istore #6
    //   1380: goto -> 1392
    //   1383: aconst_null
    //   1384: astore #11
    //   1386: iconst_0
    //   1387: istore #5
    //   1389: iconst_0
    //   1390: istore #6
    //   1392: aload_1
    //   1393: astore #12
    //   1395: aload_2
    //   1396: ifnull -> 1420
    //   1399: aload_2
    //   1400: aload_1
    //   1401: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1406: checkcast java/lang/String
    //   1409: astore_1
    //   1410: aload_1
    //   1411: astore #12
    //   1413: aload_1
    //   1414: ifnonnull -> 1420
    //   1417: goto -> 1246
    //   1420: aload #17
    //   1422: aload #12
    //   1424: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   1429: ifne -> 1246
    //   1432: aload #17
    //   1434: aload #12
    //   1436: new com/alibaba/fastjson/util/FieldInfo
    //   1439: dup
    //   1440: aload #12
    //   1442: aconst_null
    //   1443: aload #14
    //   1445: aload_0
    //   1446: aconst_null
    //   1447: iload #5
    //   1449: iload #6
    //   1451: aconst_null
    //   1452: aload #15
    //   1454: aload #11
    //   1456: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   1459: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1464: pop
    //   1465: iload #7
    //   1467: iconst_1
    //   1468: iadd
    //   1469: istore #7
    //   1471: goto -> 1221
    //   1474: new java/util/ArrayList
    //   1477: dup
    //   1478: invokespecial <init> : ()V
    //   1481: astore_2
    //   1482: aload_0
    //   1483: ldc_w com/alibaba/fastjson/annotation/JSONType
    //   1486: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   1489: checkcast com/alibaba/fastjson/annotation/JSONType
    //   1492: astore_0
    //   1493: aload_0
    //   1494: ifnull -> 1574
    //   1497: aload_0
    //   1498: invokeinterface orders : ()[Ljava/lang/String;
    //   1503: astore_1
    //   1504: aload_1
    //   1505: astore_0
    //   1506: aload_1
    //   1507: ifnull -> 1576
    //   1510: aload_1
    //   1511: astore_0
    //   1512: aload_1
    //   1513: arraylength
    //   1514: aload #17
    //   1516: invokeinterface size : ()I
    //   1521: if_icmpne -> 1576
    //   1524: aload_1
    //   1525: arraylength
    //   1526: istore #6
    //   1528: iconst_0
    //   1529: istore #5
    //   1531: iload #5
    //   1533: iload #6
    //   1535: if_icmpge -> 1566
    //   1538: aload #17
    //   1540: aload_1
    //   1541: iload #5
    //   1543: aaload
    //   1544: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   1549: ifne -> 1557
    //   1552: aload_1
    //   1553: astore_0
    //   1554: goto -> 1576
    //   1557: iload #5
    //   1559: iconst_1
    //   1560: iadd
    //   1561: istore #5
    //   1563: goto -> 1531
    //   1566: iconst_1
    //   1567: istore #5
    //   1569: aload_1
    //   1570: astore_0
    //   1571: goto -> 1579
    //   1574: aconst_null
    //   1575: astore_0
    //   1576: iconst_0
    //   1577: istore #5
    //   1579: iload #5
    //   1581: ifeq -> 1628
    //   1584: aload_0
    //   1585: arraylength
    //   1586: istore #6
    //   1588: iconst_0
    //   1589: istore #5
    //   1591: iload #5
    //   1593: iload #6
    //   1595: if_icmpge -> 1677
    //   1598: aload_2
    //   1599: aload #17
    //   1601: aload_0
    //   1602: iload #5
    //   1604: aaload
    //   1605: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   1610: checkcast com/alibaba/fastjson/util/FieldInfo
    //   1613: invokeinterface add : (Ljava/lang/Object;)Z
    //   1618: pop
    //   1619: iload #5
    //   1621: iconst_1
    //   1622: iadd
    //   1623: istore #5
    //   1625: goto -> 1591
    //   1628: aload #17
    //   1630: invokeinterface values : ()Ljava/util/Collection;
    //   1635: invokeinterface iterator : ()Ljava/util/Iterator;
    //   1640: astore_0
    //   1641: aload_0
    //   1642: invokeinterface hasNext : ()Z
    //   1647: ifeq -> 1669
    //   1650: aload_2
    //   1651: aload_0
    //   1652: invokeinterface next : ()Ljava/lang/Object;
    //   1657: checkcast com/alibaba/fastjson/util/FieldInfo
    //   1660: invokeinterface add : (Ljava/lang/Object;)Z
    //   1665: pop
    //   1666: goto -> 1641
    //   1669: iload_3
    //   1670: ifeq -> 1677
    //   1673: aload_2
    //   1674: invokestatic sort : (Ljava/util/List;)V
    //   1677: aload_2
    //   1678: areturn
  }
  
  public static Collection createCollection(Type<Object> paramType) {
    Class<?> clazz = getRawClass(paramType);
    if (clazz == AbstractCollection.class || clazz == Collection.class)
      return new ArrayList(); 
    if (clazz.isAssignableFrom(HashSet.class))
      return new HashSet(); 
    if (clazz.isAssignableFrom(LinkedHashSet.class))
      return new LinkedHashSet(); 
    if (clazz.isAssignableFrom(TreeSet.class))
      return new TreeSet(); 
    if (clazz.isAssignableFrom(ArrayList.class))
      return new ArrayList(); 
    if (clazz.isAssignableFrom(EnumSet.class)) {
      if (paramType instanceof ParameterizedType) {
        paramType = ((ParameterizedType)paramType).getActualTypeArguments()[0];
      } else {
        paramType = Object.class;
      } 
      return EnumSet.noneOf((Class)paramType);
    } 
    try {
      return (Collection)clazz.newInstance();
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("create instane error, class ");
      stringBuilder.append(clazz.getName());
      throw new JSONException(stringBuilder.toString());
    } 
  }
  
  public static String decapitalize(String paramString) {
    char[] arrayOfChar;
    if (paramString != null) {
      if (paramString.length() == 0)
        return paramString; 
      if (paramString.length() > 1 && Character.isUpperCase(paramString.charAt(1)) && Character.isUpperCase(paramString.charAt(0)))
        return paramString; 
      arrayOfChar = paramString.toCharArray();
      arrayOfChar[0] = Character.toLowerCase(arrayOfChar[0]);
      return new String(arrayOfChar);
    } 
    return (String)arrayOfChar;
  }
  
  public static Class<?> getClass(Type paramType) {
    return (paramType.getClass() == Class.class) ? (Class)paramType : ((paramType instanceof ParameterizedType) ? getClass(((ParameterizedType)paramType).getRawType()) : ((paramType instanceof TypeVariable) ? (Class)((TypeVariable)paramType).getBounds()[0] : Object.class));
  }
  
  public static Class<?> getCollectionItemClass(Type paramType) {
    if (paramType instanceof ParameterizedType) {
      paramType = ((ParameterizedType)paramType).getActualTypeArguments()[0];
      if (paramType instanceof Class) {
        paramType = paramType;
        if (Modifier.isPublic(paramType.getModifiers()))
          return (Class<?>)paramType; 
        throw new JSONException("can not create ASMParser");
      } 
      throw new JSONException("can not create ASMParser");
    } 
    return Object.class;
  }
  
  public static Field getField(Class<?> paramClass, String paramString, Field[] paramArrayOfField) {
    int j = paramArrayOfField.length;
    for (int i = 0; i < j; i++) {
      Field field = paramArrayOfField[i];
      if (paramString.equals(field.getName()))
        return field; 
    } 
    paramClass = paramClass.getSuperclass();
    return (paramClass != null && paramClass != Object.class) ? getField(paramClass, paramString, paramClass.getDeclaredFields()) : null;
  }
  
  public static Type getGenericParamType(Type paramType) {
    if (paramType instanceof ParameterizedType)
      return paramType; 
    Type type = paramType;
    if (paramType instanceof Class)
      type = getGenericParamType(((Class)paramType).getGenericSuperclass()); 
    return type;
  }
  
  public static JSONType getJSONType(Class<?> paramClass) {
    return paramClass.<JSONType>getAnnotation(JSONType.class);
  }
  
  public static int getParserFeatures(Class<?> paramClass) {
    JSONType jSONType = paramClass.<JSONType>getAnnotation(JSONType.class);
    return (jSONType == null) ? 0 : Feature.of(jSONType.parseFeatures());
  }
  
  public static Class<?> getRawClass(Type paramType) {
    if (paramType instanceof Class)
      return (Class)paramType; 
    if (paramType instanceof ParameterizedType)
      return getRawClass(((ParameterizedType)paramType).getRawType()); 
    throw new JSONException("TODO");
  }
  
  public static int getSerializeFeatures(Class<?> paramClass) {
    JSONType jSONType = paramClass.<JSONType>getAnnotation(JSONType.class);
    return (jSONType == null) ? 0 : SerializerFeature.of(jSONType.serialzeFeatures());
  }
  
  public static JSONField getSupperMethodAnnotation(Class<?> paramClass, Method paramMethod) {
    Class[] arrayOfClass = paramClass.getInterfaces();
    if (arrayOfClass.length > 0) {
      Class[] arrayOfClass1 = paramMethod.getParameterTypes();
      int j = arrayOfClass.length;
      for (int i = 0; i < j; i++) {
        for (Method method : arrayOfClass[i].getMethods()) {
          Class[] arrayOfClass2 = method.getParameterTypes();
          if (arrayOfClass2.length == arrayOfClass1.length && method.getName().equals(paramMethod.getName())) {
            int k = 0;
            while (true) {
              if (k < arrayOfClass1.length) {
                if (!arrayOfClass2[k].equals(arrayOfClass1[k])) {
                  k = 0;
                  break;
                } 
                k++;
                continue;
              } 
              k = 1;
              break;
            } 
            if (k != 0) {
              JSONField jSONField = method.<JSONField>getAnnotation(JSONField.class);
              if (jSONField != null)
                return jSONField; 
            } 
          } 
        } 
      } 
    } 
    return null;
  }
  
  public static boolean isGenericParamType(Type paramType) {
    if (paramType instanceof ParameterizedType)
      return true; 
    if (paramType instanceof Class) {
      paramType = ((Class)paramType).getGenericSuperclass();
      return (paramType == Object.class) ? false : isGenericParamType(paramType);
    } 
    return false;
  }
  
  private static boolean isJSONTypeIgnore(Class<?> paramClass, String paramString) {
    JSONType jSONType = paramClass.<JSONType>getAnnotation(JSONType.class);
    if (jSONType != null) {
      String[] arrayOfString2 = jSONType.includes();
      if (arrayOfString2.length > 0) {
        for (int j = 0; j < arrayOfString2.length; j++) {
          if (paramString.equals(arrayOfString2[j]))
            return false; 
        } 
        return true;
      } 
      String[] arrayOfString1 = jSONType.ignores();
      for (int i = 0; i < arrayOfString1.length; i++) {
        if (paramString.equals(arrayOfString1[i]))
          return true; 
      } 
    } 
    return (paramClass.getSuperclass() != Object.class && paramClass.getSuperclass() != null && isJSONTypeIgnore(paramClass.getSuperclass(), paramString));
  }
  
  public static Class<?> loadClass(String paramString) {
    return loadClass(paramString, null);
  }
  
  public static Class<?> loadClass(String paramString, ClassLoader paramClassLoader) {
    Class<?> clazz1;
    if (paramString == null || paramString.length() == 0)
      return null; 
    Class<?> clazz3 = mappings.get(paramString);
    if (clazz3 != null)
      return clazz3; 
    if (paramString.charAt(0) == '[')
      return Array.newInstance(loadClass(paramString.substring(1), paramClassLoader), 0).getClass(); 
    if (paramString.startsWith("L") && paramString.endsWith(";"))
      return loadClass(paramString.substring(1, paramString.length() - 1), paramClassLoader); 
    Class<?> clazz2 = clazz3;
    if (paramClassLoader != null) {
      clazz2 = clazz3;
      try {
        clazz1 = paramClassLoader.loadClass(paramString);
        clazz2 = clazz1;
        return clazz1;
      } finally {
        paramClassLoader = null;
      } 
    } 
    try {
      ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
      clazz1 = clazz2;
    } finally {
      paramClassLoader = null;
    } 
    try {
      clazz2 = Class.forName(paramString);
      clazz1 = clazz2;
      return clazz2;
    } finally {
      paramString = null;
    } 
  }
  
  static void setAccessible(AccessibleObject paramAccessibleObject) {
    if (!setAccessibleEnable)
      return; 
    if (paramAccessibleObject.isAccessible())
      return; 
    try {
      paramAccessibleObject.setAccessible(true);
      return;
    } catch (AccessControlException accessControlException) {
      setAccessibleEnable = false;
      return;
    } 
  }
  
  public static Type unwrap(Type<char[]> paramType) {
    Type<char[]> type = paramType;
    if (paramType instanceof GenericArrayType) {
      Type type1 = ((GenericArrayType)paramType).getGenericComponentType();
      if (type1 == byte.class)
        return byte[].class; 
      type = paramType;
      if (type1 == char.class)
        type = char[].class; 
    } 
    return type;
  }
  
  public static Type unwrapOptional(Type paramType) {
    if (!optionalClassInited)
      try {
        optionalClass = Class.forName("java.util.Optional");
      } catch (Exception exception) {
      
      } finally {
        optionalClassInited = true;
      }  
    Type type = paramType;
    if (paramType instanceof ParameterizedType) {
      ParameterizedType parameterizedType = (ParameterizedType)paramType;
      type = paramType;
      if (parameterizedType.getRawType() == optionalClass)
        type = parameterizedType.getActualTypeArguments()[0]; 
    } 
    return type;
  }
  
  static {
    try {
      String str = System.getProperty("fastjson.compatibleWithJavaBean");
      if ("true".equals(str)) {
        compatibleWithJavaBean = true;
      } else if ("false".equals(str)) {
        compatibleWithJavaBean = false;
      } 
    } finally {
      Exception exception;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjso\\util\TypeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */