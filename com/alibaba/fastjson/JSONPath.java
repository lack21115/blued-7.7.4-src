package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ASMJavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.ASMJavaBeanSerializer;
import com.alibaba.fastjson.serializer.FieldSerializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

public class JSONPath implements JSONAware {
  private static int CACHE_SIZE = 1024;
  
  private static ConcurrentMap<String, JSONPath> pathCache = new ConcurrentHashMap<String, JSONPath>(128, 0.75F, 1);
  
  private ParserConfig parserConfig;
  
  private final String path;
  
  private Segement[] segments;
  
  private SerializeConfig serializeConfig;
  
  public JSONPath(String paramString) {
    this(paramString, SerializeConfig.getGlobalInstance(), ParserConfig.getGlobalInstance());
  }
  
  public JSONPath(String paramString, SerializeConfig paramSerializeConfig, ParserConfig paramParserConfig) {
    if (paramString != null && !paramString.isEmpty()) {
      this.path = paramString;
      this.serializeConfig = paramSerializeConfig;
      this.parserConfig = paramParserConfig;
      return;
    } 
    throw new IllegalArgumentException();
  }
  
  public static void arrayAdd(Object paramObject, String paramString, Object... paramVarArgs) {
    compile(paramString).arrayAdd(paramObject, paramVarArgs);
  }
  
  public static JSONPath compile(String paramString) {
    JSONPath jSONPath2 = pathCache.get(paramString);
    JSONPath jSONPath1 = jSONPath2;
    if (jSONPath2 == null) {
      jSONPath2 = new JSONPath(paramString);
      jSONPath1 = jSONPath2;
      if (pathCache.size() < CACHE_SIZE) {
        pathCache.putIfAbsent(paramString, jSONPath2);
        jSONPath1 = pathCache.get(paramString);
      } 
    } 
    return jSONPath1;
  }
  
  public static boolean contains(Object paramObject, String paramString) {
    return (paramObject == null) ? false : compile(paramString).contains(paramObject);
  }
  
  public static boolean containsValue(Object paramObject1, String paramString, Object paramObject2) {
    return compile(paramString).containsValue(paramObject1, paramObject2);
  }
  
  static boolean eq(Object paramObject1, Object paramObject2) {
    return (paramObject1 == paramObject2) ? true : ((paramObject1 != null) ? ((paramObject2 == null) ? false : ((paramObject1.getClass() == paramObject2.getClass()) ? paramObject1.equals(paramObject2) : ((paramObject1 instanceof Number) ? ((paramObject2 instanceof Number) ? eqNotNull((Number)paramObject1, (Number)paramObject2) : false) : paramObject1.equals(paramObject2)))) : false);
  }
  
  static boolean eqNotNull(Number paramNumber1, Number paramNumber2) {
    Class<?> clazz1 = paramNumber1.getClass();
    boolean bool1 = isInt(clazz1);
    Class<?> clazz2 = paramNumber1.getClass();
    boolean bool2 = isInt(clazz2);
    if (bool1 && bool2)
      return (paramNumber1.longValue() == paramNumber2.longValue()); 
    bool2 = isDouble(clazz1);
    boolean bool3 = isDouble(clazz2);
    return ((bool2 && bool3) || (bool2 && bool1) || (bool3 && bool1)) ? ((paramNumber1.doubleValue() == paramNumber2.doubleValue())) : false;
  }
  
  public static Object eval(Object paramObject, String paramString) {
    return compile(paramString).eval(paramObject);
  }
  
  protected static boolean isDouble(Class<?> paramClass) {
    return (paramClass == Float.class || paramClass == Double.class);
  }
  
  protected static boolean isInt(Class<?> paramClass) {
    return (paramClass == Byte.class || paramClass == Short.class || paramClass == Integer.class || paramClass == Long.class);
  }
  
  public static Object read(String paramString1, String paramString2) {
    Object object = JSON.parse(paramString1);
    return compile(paramString2).eval(object);
  }
  
  public static boolean set(Object paramObject1, String paramString, Object paramObject2) {
    return compile(paramString).set(paramObject1, paramObject2);
  }
  
  public static int size(Object paramObject, String paramString) {
    JSONPath jSONPath = compile(paramString);
    return jSONPath.evalSize(jSONPath.eval(paramObject));
  }
  
  public void arrayAdd(Object<?> paramObject, Object... paramVarArgs) {
    if (paramVarArgs != null) {
      if (paramVarArgs.length == 0)
        return; 
      if (paramObject == null)
        return; 
      init();
      int k = 0;
      int j = 0;
      Object<?> object1 = paramObject;
      Object<?> object2 = null;
      int i = 0;
      while (true) {
        Segement[] arrayOfSegement = this.segments;
        if (i < arrayOfSegement.length) {
          if (i == arrayOfSegement.length - 1)
            object2 = object1; 
          object1 = (Object<?>)this.segments[i].eval(this, paramObject, object1);
          i++;
          continue;
        } 
        if (object1 != null) {
          if (object1 instanceof Collection) {
            paramObject = object1;
            k = paramVarArgs.length;
            for (i = j; i < k; i++)
              paramObject.add(paramVarArgs[i]); 
            return;
          } 
          paramObject = (Object<?>)object1.getClass();
          if (paramObject.isArray()) {
            j = Array.getLength(object1);
            paramObject = (Object<?>)Array.newInstance(paramObject.getComponentType(), paramVarArgs.length + j);
            System.arraycopy(object1, 0, paramObject, 0, j);
            for (i = k; i < paramVarArgs.length; i++)
              Array.set(paramObject, j + i, paramVarArgs[i]); 
            Segement[] arrayOfSegement1 = this.segments;
            Segement segement = arrayOfSegement1[arrayOfSegement1.length - 1];
            if (segement instanceof PropertySegement) {
              ((PropertySegement)segement).setValue(this, object2, paramObject);
              return;
            } 
            if (segement instanceof ArrayAccessSegement) {
              ((ArrayAccessSegement)segement).setValue(this, object2, paramObject);
              return;
            } 
            throw new UnsupportedOperationException();
          } 
          throw new UnsupportedOperationException();
        } 
        paramObject = (Object<?>)new StringBuilder();
        paramObject.append("value not found in path ");
        paramObject.append(this.path);
        throw new JSONPathException(paramObject.toString());
      } 
    } 
  }
  
  public boolean contains(Object paramObject) {
    if (paramObject == null)
      return false; 
    init();
    Object object = paramObject;
    int i = 0;
    while (true) {
      Segement[] arrayOfSegement = this.segments;
      if (i < arrayOfSegement.length) {
        object = arrayOfSegement[i].eval(this, paramObject, object);
        if (object == null)
          return false; 
        i++;
        continue;
      } 
      return true;
    } 
  }
  
  public boolean containsValue(Object paramObject1, Object paramObject2) {
    paramObject1 = eval(paramObject1);
    if (paramObject1 == paramObject2)
      return true; 
    if (paramObject1 == null)
      return false; 
    if (paramObject1 instanceof Iterable) {
      paramObject1 = ((Iterable)paramObject1).iterator();
      while (paramObject1.hasNext()) {
        if (eq(paramObject1.next(), paramObject2))
          return true; 
      } 
      return false;
    } 
    return eq(paramObject1, paramObject2);
  }
  
  public Object eval(Object paramObject) {
    if (paramObject == null)
      return null; 
    init();
    int i = 0;
    Object object = paramObject;
    while (true) {
      Segement[] arrayOfSegement = this.segments;
      if (i < arrayOfSegement.length) {
        object = arrayOfSegement[i].eval(this, paramObject, object);
        i++;
        continue;
      } 
      return object;
    } 
  }
  
  int evalSize(Object paramObject) {
    if (paramObject == null)
      return -1; 
    if (paramObject instanceof Collection)
      return ((Collection)paramObject).size(); 
    if (paramObject instanceof Object[])
      return ((Object[])paramObject).length; 
    if (paramObject.getClass().isArray())
      return Array.getLength(paramObject); 
    boolean bool = paramObject instanceof Map;
    int i = 0;
    int j = 0;
    if (bool) {
      paramObject = ((Map)paramObject).values().iterator();
      i = j;
      while (paramObject.hasNext()) {
        if (paramObject.next() != null)
          i++; 
      } 
      return i;
    } 
    JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(paramObject.getClass());
    if (javaBeanSerializer == null)
      return -1; 
    try {
      paramObject = javaBeanSerializer.getFieldValues(paramObject);
      for (j = 0; i < paramObject.size(); j = k) {
        javaBeanSerializer = paramObject.get(i);
        int k = j;
        if (javaBeanSerializer != null)
          k = j + 1; 
        i++;
      } 
      return j;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("evalSize error : ");
      stringBuilder.append(this.path);
      throw new JSONException(stringBuilder.toString(), exception);
    } 
  }
  
  protected Object getArrayItem(Object paramObject, int paramInt) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof List) {
      paramObject = paramObject;
      return (paramInt >= 0) ? ((paramInt < paramObject.size()) ? paramObject.get(paramInt) : null) : ((Math.abs(paramInt) <= paramObject.size()) ? paramObject.get(paramObject.size() + paramInt) : null);
    } 
    if (paramObject.getClass().isArray()) {
      int i = Array.getLength(paramObject);
      return (paramInt >= 0) ? ((paramInt < i) ? Array.get(paramObject, paramInt) : null) : ((Math.abs(paramInt) <= i) ? Array.get(paramObject, i + paramInt) : null);
    } 
    throw new UnsupportedOperationException();
  }
  
  protected JavaBeanSerializer getJavaBeanSerializer(Class<?> paramClass) {
    ObjectSerializer objectSerializer = this.serializeConfig.getObjectWriter(paramClass);
    return (objectSerializer instanceof JavaBeanSerializer) ? (JavaBeanSerializer)objectSerializer : ((objectSerializer instanceof ASMJavaBeanSerializer) ? ((ASMJavaBeanSerializer)objectSerializer).getJavaBeanSerializer() : null);
  }
  
  public String getPath() {
    return this.path;
  }
  
  protected Object getPropertyValue(Object paramObject, String paramString, boolean paramBoolean) {
    if (paramObject == null)
      return null; 
    if (paramObject instanceof Map)
      return ((Map)paramObject).get(paramString); 
    JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(paramObject.getClass());
    if (javaBeanSerializer != null)
      try {
        FieldSerializer fieldSerializer = javaBeanSerializer.getFieldSerializer(paramString);
        return (fieldSerializer == null) ? null : fieldSerializer.getPropertyValue(paramObject);
      } catch (Exception exception) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("jsonpath error, path ");
        stringBuilder1.append(this.path);
        stringBuilder1.append(", segement ");
        stringBuilder1.append(paramString);
        throw new JSONPathException(stringBuilder1.toString(), exception);
      }  
    if (exception instanceof List) {
      List list = (List)exception;
      ArrayList<Object> arrayList = new ArrayList(list.size());
      int i;
      for (i = 0; i < list.size(); i++)
        arrayList.add(getPropertyValue(list.get(i), paramString, paramBoolean)); 
      return arrayList;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("jsonpath error, path ");
    stringBuilder.append(this.path);
    stringBuilder.append(", segement ");
    stringBuilder.append(paramString);
    throw new JSONPathException(stringBuilder.toString());
  }
  
  protected Collection<Object> getPropertyValues(Object paramObject) {
    JavaBeanSerializer javaBeanSerializer = getJavaBeanSerializer(paramObject.getClass());
    if (javaBeanSerializer != null)
      try {
        return javaBeanSerializer.getFieldValues(paramObject);
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("jsonpath error, path ");
        stringBuilder.append(this.path);
        throw new JSONPathException(stringBuilder.toString(), exception);
      }  
    if (exception instanceof Map)
      return ((Map)exception).values(); 
    throw new UnsupportedOperationException();
  }
  
  protected void init() {
    if (this.segments != null)
      return; 
    if ("*".equals(this.path)) {
      this.segments = new Segement[] { WildCardSegement.instance };
      return;
    } 
    this.segments = (new JSONPathParser(this.path)).explain();
  }
  
  public boolean set(Object paramObject1, Object paramObject2) {
    Object object2;
    if (paramObject1 == null)
      return false; 
    init();
    Object object = null;
    Object object1 = paramObject1;
    int i = 0;
    while (true) {
      Segement[] arrayOfSegement = this.segments;
      object2 = object;
      if (i < arrayOfSegement.length) {
        if (i == arrayOfSegement.length - 1) {
          object2 = object1;
          break;
        } 
        object1 = arrayOfSegement[i].eval(this, paramObject1, object1);
        if (object1 == null) {
          object2 = object;
          break;
        } 
        i++;
        continue;
      } 
      break;
    } 
    if (object2 == null)
      return false; 
    paramObject1 = this.segments;
    paramObject1 = paramObject1[paramObject1.length - 1];
    if (paramObject1 instanceof PropertySegement) {
      ((PropertySegement)paramObject1).setValue(this, object2, paramObject2);
      return true;
    } 
    if (paramObject1 instanceof ArrayAccessSegement)
      return ((ArrayAccessSegement)paramObject1).setValue(this, object2, paramObject2); 
    throw new UnsupportedOperationException();
  }
  
  public boolean setArrayItem(JSONPath paramJSONPath, Object paramObject1, int paramInt, Object paramObject2) {
    if (paramObject1 instanceof List) {
      List<Object> list = (List)paramObject1;
      if (paramInt >= 0) {
        list.set(paramInt, paramObject2);
        return true;
      } 
      list.set(list.size() + paramInt, paramObject2);
      return true;
    } 
    if (paramObject1.getClass().isArray()) {
      int i = Array.getLength(paramObject1);
      if (paramInt >= 0) {
        if (paramInt < i) {
          Array.set(paramObject1, paramInt, paramObject2);
          return true;
        } 
      } else if (Math.abs(paramInt) <= i) {
        Array.set(paramObject1, i + paramInt, paramObject2);
      } 
      return true;
    } 
    throw new UnsupportedOperationException();
  }
  
  protected boolean setPropertyValue(Object paramObject1, String paramString, Object paramObject2) {
    if (paramObject1 instanceof Map) {
      ((Map<String, Object>)paramObject1).put(paramString, paramObject2);
      return true;
    } 
    if (paramObject1 instanceof List) {
      paramObject1 = ((List)paramObject1).iterator();
      while (paramObject1.hasNext()) {
        Object object = paramObject1.next();
        if (object == null)
          continue; 
        setPropertyValue(object, paramString, paramObject2);
      } 
      return true;
    } 
    ObjectDeserializer objectDeserializer = this.parserConfig.getDeserializer(paramObject1.getClass());
    JavaBeanDeserializer javaBeanDeserializer = null;
    if (objectDeserializer instanceof JavaBeanDeserializer) {
      javaBeanDeserializer = (JavaBeanDeserializer)objectDeserializer;
    } else if (objectDeserializer instanceof ASMJavaBeanDeserializer) {
      javaBeanDeserializer = ((ASMJavaBeanDeserializer)objectDeserializer).getInnterSerializer();
    } 
    if (javaBeanDeserializer != null) {
      FieldDeserializer fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(paramString);
      if (fieldDeserializer == null)
        return false; 
      fieldDeserializer.setValue(paramObject1, paramObject2);
      return true;
    } 
    throw new UnsupportedOperationException();
  }
  
  public int size(Object paramObject) {
    if (paramObject == null)
      return -1; 
    init();
    int i = 0;
    Object object = paramObject;
    while (true) {
      Segement[] arrayOfSegement = this.segments;
      if (i < arrayOfSegement.length) {
        object = arrayOfSegement[i].eval(this, paramObject, object);
        i++;
        continue;
      } 
      return evalSize(object);
    } 
  }
  
  public String toJSONString() {
    return JSON.toJSONString(this.path);
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    paramJSONSerializer.write(this.path);
  }
  
  static class ArrayAccessSegement implements Segement {
    private final int index;
    
    public ArrayAccessSegement(int param1Int) {
      this.index = param1Int;
    }
    
    public Object eval(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      return param1JSONPath.getArrayItem(param1Object2, this.index);
    }
    
    public boolean setValue(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      return param1JSONPath.setArrayItem(param1JSONPath, param1Object1, this.index, param1Object2);
    }
  }
  
  static interface Filter {
    boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3);
  }
  
  public static class FilterSegement implements Segement {
    private final JSONPath.Filter filter;
    
    public FilterSegement(JSONPath.Filter param1Filter) {
      this.filter = param1Filter;
    }
    
    public Object eval(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      if (param1Object2 == null)
        return null; 
      ArrayList arrayList = new ArrayList();
      if (param1Object2 instanceof Iterable) {
        for (Object object : param1Object2) {
          if (this.filter.apply(param1JSONPath, param1Object1, param1Object2, object))
            arrayList.add(object); 
        } 
        return arrayList;
      } 
      return this.filter.apply(param1JSONPath, param1Object1, param1Object2, param1Object2) ? param1Object2 : null;
    }
  }
  
  static class IntBetweenSegement implements Filter {
    private final long endValue;
    
    private final boolean not;
    
    private final String propertyName;
    
    private final long startValue;
    
    public IntBetweenSegement(String param1String, long param1Long1, long param1Long2, boolean param1Boolean) {
      this.propertyName = param1String;
      this.startValue = param1Long1;
      this.endValue = param1Long2;
      this.not = param1Boolean;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      Object object = param1JSONPath.getPropertyValue(param1Object3, this.propertyName, false);
      if (object == null)
        return false; 
      if (object instanceof Number) {
        long l = ((Number)object).longValue();
        if (l >= this.startValue && l <= this.endValue)
          return this.not ^ true; 
      } 
      return this.not;
    }
  }
  
  static class IntInSegement implements Filter {
    private final boolean not;
    
    private final String propertyName;
    
    private final long[] values;
    
    public IntInSegement(String param1String, long[] param1ArrayOflong, boolean param1Boolean) {
      this.propertyName = param1String;
      this.values = param1ArrayOflong;
      this.not = param1Boolean;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      param1Object1 = this.propertyName;
      int i = 0;
      Object object = param1JSONPath.getPropertyValue(param1Object3, (String)param1Object1, false);
      if (object == null)
        return false; 
      if (object instanceof Number) {
        long l = ((Number)object).longValue();
        object = this.values;
        int j = object.length;
        while (i < j) {
          if (object[i] == l)
            return this.not ^ true; 
          i++;
        } 
      } 
      return this.not;
    }
  }
  
  static class IntObjInSegement implements Filter {
    private final boolean not;
    
    private final String propertyName;
    
    private final Long[] values;
    
    public IntObjInSegement(String param1String, Long[] param1ArrayOfLong, boolean param1Boolean) {
      this.propertyName = param1String;
      this.values = param1ArrayOfLong;
      this.not = param1Boolean;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      param1Object1 = this.propertyName;
      int j = 0;
      int i = 0;
      Object object = param1JSONPath.getPropertyValue(param1Object3, (String)param1Object1, false);
      if (object == null) {
        object = this.values;
        j = object.length;
        while (i < j) {
          if (object[i] == null)
            return this.not ^ true; 
          i++;
        } 
        return this.not;
      } 
      if (object instanceof Number) {
        long l = ((Number)object).longValue();
        object = this.values;
        int k = object.length;
        for (i = j; i < k; i++) {
          param1Object1 = object[i];
          if (param1Object1 != null && param1Object1.longValue() == l)
            return this.not ^ true; 
        } 
      } 
      return this.not;
    }
  }
  
  static class IntOpSegement implements Filter {
    private final JSONPath.Operator op;
    
    private final String propertyName;
    
    private final long value;
    
    public IntOpSegement(String param1String, long param1Long, JSONPath.Operator param1Operator) {
      this.propertyName = param1String;
      this.value = param1Long;
      this.op = param1Operator;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      param1Object1 = this.propertyName;
      boolean bool3 = false;
      boolean bool4 = false;
      boolean bool5 = false;
      boolean bool6 = false;
      boolean bool2 = false;
      boolean bool1 = false;
      Object object = param1JSONPath.getPropertyValue(param1Object3, (String)param1Object1, false);
      if (object == null)
        return false; 
      if (!(object instanceof Number))
        return false; 
      long l = ((Number)object).longValue();
      if (this.op == JSONPath.Operator.EQ) {
        if (l == this.value)
          bool1 = true; 
        return bool1;
      } 
      if (this.op == JSONPath.Operator.NE) {
        bool1 = bool3;
        if (l != this.value)
          bool1 = true; 
        return bool1;
      } 
      if (this.op == JSONPath.Operator.GE) {
        bool1 = bool4;
        if (l >= this.value)
          bool1 = true; 
        return bool1;
      } 
      if (this.op == JSONPath.Operator.GT) {
        bool1 = bool5;
        if (l > this.value)
          bool1 = true; 
        return bool1;
      } 
      if (this.op == JSONPath.Operator.LE) {
        bool1 = bool6;
        if (l <= this.value)
          bool1 = true; 
        return bool1;
      } 
      bool1 = bool2;
      if (this.op == JSONPath.Operator.LT) {
        bool1 = bool2;
        if (l < this.value)
          bool1 = true; 
      } 
      return bool1;
    }
  }
  
  static class JSONPathParser {
    private char ch;
    
    private int level;
    
    private final String path;
    
    private int pos;
    
    public JSONPathParser(String param1String) {
      this.path = param1String;
      next();
    }
    
    static boolean isDigitFirst(char param1Char) {
      return (param1Char == '-' || param1Char == '+' || (param1Char >= '0' && param1Char <= '9'));
    }
    
    void accept(char param1Char) {
      if (this.ch == param1Char) {
        if (!isEOF())
          next(); 
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("expect '");
      stringBuilder.append(param1Char);
      stringBuilder.append(", but '");
      stringBuilder.append(this.ch);
      stringBuilder.append("'");
      throw new JSONPathException(stringBuilder.toString());
    }
    
    JSONPath.Segement buildArraySegement(String param1String) {
      String[] arrayOfString;
      int k = param1String.length();
      int i = 0;
      int m = 0;
      char c1 = param1String.charAt(0);
      int j = 1;
      int i1 = k - 1;
      char c2 = param1String.charAt(i1);
      int n = param1String.indexOf(',');
      int i2 = param1String.length();
      k = -1;
      if (i2 > 2 && c1 == '\'' && c2 == '\'') {
        if (n == -1)
          return new JSONPath.PropertySegement(param1String.substring(1, i1)); 
        arrayOfString = param1String.split(",");
        String[] arrayOfString1 = new String[arrayOfString.length];
        for (i = m; i < arrayOfString.length; i++) {
          String str = arrayOfString[i];
          arrayOfString1[i] = str.substring(1, str.length() - 1);
        } 
        return new JSONPath.MultiPropertySegement(arrayOfString1);
      } 
      m = arrayOfString.indexOf(':');
      if (n == -1 && m == -1)
        return new JSONPath.ArrayAccessSegement(Integer.parseInt((String)arrayOfString)); 
      if (n != -1) {
        arrayOfString = arrayOfString.split(",");
        int[] arrayOfInt = new int[arrayOfString.length];
        while (i < arrayOfString.length) {
          arrayOfInt[i] = Integer.parseInt(arrayOfString[i]);
          i++;
        } 
        return new JSONPath.MultiIndexSegement(arrayOfInt);
      } 
      if (m != -1) {
        arrayOfString = arrayOfString.split(":");
        int[] arrayOfInt = new int[arrayOfString.length];
        for (i = 0; i < arrayOfString.length; i++) {
          String str = arrayOfString[i];
          if (str.isEmpty()) {
            if (i == 0) {
              arrayOfInt[i] = 0;
            } else {
              throw new UnsupportedOperationException();
            } 
          } else {
            arrayOfInt[i] = Integer.parseInt(str);
          } 
        } 
        m = arrayOfInt[0];
        i = k;
        if (arrayOfInt.length > 1)
          i = arrayOfInt[1]; 
        if (arrayOfInt.length == 3)
          j = arrayOfInt[2]; 
        if (i < 0 || i >= m) {
          if (j > 0)
            return new JSONPath.RangeSegement(m, i, j); 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("step must greater than zero : ");
          stringBuilder1.append(j);
          throw new UnsupportedOperationException(stringBuilder1.toString());
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("end must greater than or equals start. start ");
        stringBuilder.append(m);
        stringBuilder.append(",  end ");
        stringBuilder.append(i);
        throw new UnsupportedOperationException(stringBuilder.toString());
      } 
      throw new UnsupportedOperationException();
    }
    
    public JSONPath.Segement[] explain() {
      String str = this.path;
      if (str != null && !str.isEmpty()) {
        JSONPath.Segement[] arrayOfSegement = new JSONPath.Segement[8];
        while (true) {
          JSONPath.Segement[] arrayOfSegement1;
          JSONPath.Segement segement = readSegement();
          if (segement == null) {
            int j = this.level;
            if (j == arrayOfSegement.length)
              return arrayOfSegement; 
            arrayOfSegement1 = new JSONPath.Segement[j];
            System.arraycopy(arrayOfSegement, 0, arrayOfSegement1, 0, j);
            return arrayOfSegement1;
          } 
          int i = this.level;
          this.level = i + 1;
          arrayOfSegement[i] = (JSONPath.Segement)arrayOfSegement1;
        } 
      } 
      throw new IllegalArgumentException();
    }
    
    boolean isEOF() {
      return (this.pos >= this.path.length());
    }
    
    void next() {
      String str = this.path;
      int i = this.pos;
      this.pos = i + 1;
      this.ch = str.charAt(i);
    }
    
    JSONPath.Segement parseArrayAccess(boolean param1Boolean) {
      if (param1Boolean)
        accept('['); 
      int i = this.ch;
      boolean bool2 = false;
      boolean bool1 = false;
      if (i == 63) {
        next();
        accept('(');
        if (this.ch == '@') {
          next();
          accept('.');
        } 
        i = 1;
      } else {
        i = 0;
      } 
      if (i != 0 || IOUtils.firstIdentifier(this.ch)) {
        int k;
        String str1;
        String str2 = readName();
        skipWhitespace();
        if (i != 0 && this.ch == ')') {
          next();
          if (param1Boolean)
            accept(']'); 
          return new JSONPath.FilterSegement(new JSONPath.NotNullSegement(str2));
        } 
        if (param1Boolean && this.ch == ']') {
          next();
          return new JSONPath.FilterSegement(new JSONPath.NotNullSegement(str2));
        } 
        JSONPath.Operator operator = readOp();
        skipWhitespace();
        if (operator == JSONPath.Operator.BETWEEN || operator == JSONPath.Operator.NOT_BETWEEN) {
          if (operator == JSONPath.Operator.NOT_BETWEEN) {
            param1Boolean = true;
          } else {
            param1Boolean = false;
          } 
          Object object = readValue();
          if ("and".equalsIgnoreCase(readName())) {
            Object object1 = readValue();
            if (object != null && object1 != null) {
              if (JSONPath.isInt(object.getClass()) && JSONPath.isInt(object1.getClass()))
                return new JSONPath.FilterSegement(new JSONPath.IntBetweenSegement(str2, ((Number)object).longValue(), ((Number)object1).longValue(), param1Boolean)); 
              throw new JSONPathException(this.path);
            } 
            throw new JSONPathException(this.path);
          } 
          throw new JSONPathException(this.path);
        } 
        if (operator == JSONPath.Operator.IN || operator == JSONPath.Operator.NOT_IN) {
          boolean bool;
          if (operator == JSONPath.Operator.NOT_IN) {
            bool = true;
          } else {
            bool = false;
          } 
          accept('(');
          ArrayList<Object> arrayList = new ArrayList();
          arrayList.add(readValue());
          while (true) {
            JSONPath.Operator operator1;
            skipWhitespace();
            if (this.ch != ',') {
              accept(')');
              if (i != 0)
                accept(')'); 
              if (param1Boolean)
                accept(']'); 
              Iterator<Object> iterator = arrayList.iterator();
              i = 1;
              boolean bool3 = true;
              boolean bool4 = true;
              while (iterator.hasNext()) {
                Class<?> clazz = (Class<?>)iterator.next();
                if (clazz == null) {
                  if (i != 0)
                    i = 0; 
                  continue;
                } 
                clazz = clazz.getClass();
                char c1 = i;
                boolean bool5 = bool4;
                if (i != 0) {
                  c1 = i;
                  bool5 = bool4;
                  if (clazz != Byte.class) {
                    c1 = i;
                    bool5 = bool4;
                    if (clazz != Short.class) {
                      c1 = i;
                      bool5 = bool4;
                      if (clazz != Integer.class) {
                        c1 = i;
                        bool5 = bool4;
                        if (clazz != Long.class) {
                          c1 = Character.MIN_VALUE;
                          bool5 = false;
                        } 
                      } 
                    } 
                  } 
                } 
                i = c1;
                bool4 = bool5;
                if (bool3) {
                  i = c1;
                  bool4 = bool5;
                  if (clazz != String.class) {
                    bool3 = false;
                    i = c1;
                    bool4 = bool5;
                  } 
                } 
              } 
              if (arrayList.size() == 1 && arrayList.get(0) == null)
                return bool ? new JSONPath.FilterSegement(new JSONPath.NotNullSegement(str2)) : new JSONPath.FilterSegement(new JSONPath.NullSegement(str2)); 
              if (i != 0) {
                if (arrayList.size() == 1) {
                  long l = ((Number)arrayList.get(0)).longValue();
                  if (bool) {
                    operator1 = JSONPath.Operator.NE;
                  } else {
                    operator1 = JSONPath.Operator.EQ;
                  } 
                  return new JSONPath.FilterSegement(new JSONPath.IntOpSegement(str2, l, operator1));
                } 
                long[] arrayOfLong = new long[operator1.size()];
                i = bool1;
                while (i < arrayOfLong.length) {
                  arrayOfLong[i] = ((Number)operator1.get(i)).longValue();
                  k = i + 1;
                } 
                return new JSONPath.FilterSegement(new JSONPath.IntInSegement(str2, arrayOfLong, bool));
              } 
              if (bool3) {
                if (operator1.size() == 1) {
                  String str = operator1.get(0);
                  if (bool) {
                    operator1 = JSONPath.Operator.NE;
                  } else {
                    operator1 = JSONPath.Operator.EQ;
                  } 
                  return new JSONPath.FilterSegement(new JSONPath.StringOpSegement(str2, str, operator1));
                } 
                String[] arrayOfString = new String[operator1.size()];
                operator1.toArray((Object[])arrayOfString);
                return new JSONPath.FilterSegement(new JSONPath.StringInSegement(str2, arrayOfString, bool));
              } 
              if (bool4) {
                Long[] arrayOfLong = new Long[operator1.size()];
                i = bool2;
                while (i < arrayOfLong.length) {
                  Number number = operator1.get(i);
                  if (number != null)
                    arrayOfLong[i] = Long.valueOf(number.longValue()); 
                  k = i + 1;
                } 
                return new JSONPath.FilterSegement(new JSONPath.IntObjInSegement(str2, arrayOfLong, bool));
              } 
              throw new UnsupportedOperationException();
            } 
            next();
            operator1.add(readValue());
          } 
        } 
        char c = this.ch;
        if (c == '\'' || c == '"') {
          String[] arrayOfString1;
          String str4 = readString();
          if (k != 0)
            accept(')'); 
          if (param1Boolean)
            accept(']'); 
          if (operator == JSONPath.Operator.RLIKE)
            return new JSONPath.FilterSegement(new JSONPath.RlikeSegement(str2, str4, false)); 
          if (operator == JSONPath.Operator.NOT_RLIKE)
            return new JSONPath.FilterSegement(new JSONPath.RlikeSegement(str2, str4, true)); 
          String str3 = str4;
          if (operator != JSONPath.Operator.LIKE) {
            str3 = str4;
            JSONPath.Operator operator1 = operator;
            if (operator == JSONPath.Operator.NOT_LIKE) {
              str3 = str4;
            } else {
              return new JSONPath.FilterSegement(new JSONPath.StringOpSegement(str2, str3, operator1));
            } 
          } 
          while (str3.indexOf("%%") != -1)
            str3 = str3.replaceAll("%%", "%"); 
          if (operator == JSONPath.Operator.NOT_LIKE) {
            param1Boolean = true;
          } else {
            param1Boolean = false;
          } 
          k = str3.indexOf('%');
          if (k == -1) {
            JSONPath.Operator operator1;
            if (operator == JSONPath.Operator.LIKE) {
              operator1 = JSONPath.Operator.EQ;
            } else {
              operator1 = JSONPath.Operator.NE;
            } 
            return new JSONPath.FilterSegement(new JSONPath.StringOpSegement(str2, str3, operator1));
          } 
          String[] arrayOfString2 = str3.split("%");
          str4 = null;
          if (k == 0) {
            if (str3.charAt(str3.length() - 1) == '%') {
              arrayOfString1 = new String[arrayOfString2.length - 1];
              System.arraycopy(arrayOfString2, 1, arrayOfString1, 0, arrayOfString1.length);
            } else {
              str4 = arrayOfString2[arrayOfString2.length - 1];
              if (arrayOfString2.length > 2) {
                arrayOfString1 = new String[arrayOfString2.length - 2];
                System.arraycopy(arrayOfString2, 1, arrayOfString1, 0, arrayOfString1.length);
                arrayOfString2 = null;
              } else {
                arrayOfString2 = null;
                arrayOfString1 = arrayOfString2;
              } 
              return new JSONPath.FilterSegement(new JSONPath.MatchSegement(str2, (String)arrayOfString2, str4, arrayOfString1, param1Boolean));
            } 
          } else if (arrayOfString1.charAt(arrayOfString1.length() - 1) == '%') {
            arrayOfString1 = arrayOfString2;
          } else {
            String str;
            if (arrayOfString2.length == 1) {
              str = arrayOfString2[0];
              arrayOfString1 = null;
            } else if (str.length == 2) {
              String str5 = str[0];
              str4 = str[1];
              str = str5;
              str5 = null;
            } else {
              str1 = str[0];
              str4 = str[str.length - 1];
              arrayOfString1 = new String[str.length - 2];
              System.arraycopy(str, 1, arrayOfString1, 0, arrayOfString1.length);
              str = str1;
            } 
            return new JSONPath.FilterSegement(new JSONPath.MatchSegement(str2, str, str4, arrayOfString1, param1Boolean));
          } 
          arrayOfString2 = null;
          return new JSONPath.FilterSegement(new JSONPath.MatchSegement(str2, (String)arrayOfString2, str4, arrayOfString1, param1Boolean));
        } 
        if (isDigitFirst(c)) {
          long l = readLongValue();
          if (k != 0)
            accept(')'); 
          if (param1Boolean)
            accept(']'); 
          return new JSONPath.FilterSegement(new JSONPath.IntOpSegement(str2, l, (JSONPath.Operator)str1));
        } 
        if (this.ch == 'n' && "null".equals(readName())) {
          if (k != 0)
            accept(')'); 
          accept(']');
          if (str1 == JSONPath.Operator.EQ)
            return new JSONPath.FilterSegement(new JSONPath.NullSegement(str2)); 
          if (str1 == JSONPath.Operator.NE)
            return new JSONPath.FilterSegement(new JSONPath.NotNullSegement(str2)); 
          throw new UnsupportedOperationException();
        } 
        throw new UnsupportedOperationException();
      } 
      int j = this.pos;
      while (true) {
        i = this.ch;
        if (i != 93 && i != 47 && !isEOF()) {
          next();
          continue;
        } 
        break;
      } 
      if (param1Boolean) {
        int k = this.pos;
      } else if (this.ch == '/') {
        int k = this.pos;
      } else {
        i = this.pos;
        JSONPath.Segement segement1 = buildArraySegement(this.path.substring(j - 1, i));
      } 
      JSONPath.Segement segement = buildArraySegement(this.path.substring(j - 1, --i));
    }
    
    protected long readLongValue() {
      int i = this.pos;
      char c = this.ch;
      if (c == '+' || c == '-')
        next(); 
      while (true) {
        c = this.ch;
        if (c >= '0' && c <= '9') {
          next();
          continue;
        } 
        break;
      } 
      int j = this.pos;
      return Long.parseLong(this.path.substring(i - 1, j - 1));
    }
    
    String readName() {
      skipWhitespace();
      char c = this.ch;
      if (c == '\\' || IOUtils.firstIdentifier(c)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        while (!isEOF()) {
          c = this.ch;
          if (c == '\\') {
            next();
            stringBuilder1.append(this.ch);
            if (isEOF())
              break; 
            next();
            continue;
          } 
          if (!IOUtils.isIdent(c))
            break; 
          stringBuilder1.append(this.ch);
          next();
        } 
        if (isEOF() && IOUtils.isIdent(this.ch))
          stringBuilder1.append(this.ch); 
        return stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("illeal jsonpath syntax. ");
      stringBuilder.append(this.path);
      throw new JSONPathException(stringBuilder.toString());
    }
    
    protected JSONPath.Operator readOp() {
      String str;
      char c = this.ch;
      if (c == '=') {
        next();
        str = (String)JSONPath.Operator.EQ;
      } else if (c == '!') {
        next();
        accept('=');
        str = (String)JSONPath.Operator.NE;
      } else if (c == '<') {
        next();
        if (this.ch == '=') {
          next();
          str = (String)JSONPath.Operator.LE;
        } else {
          str = (String)JSONPath.Operator.LT;
        } 
      } else if (c == '>') {
        next();
        if (this.ch == '=') {
          next();
          str = (String)JSONPath.Operator.GE;
        } else {
          str = (String)JSONPath.Operator.GT;
        } 
      } else {
        str = null;
      } 
      if (str == null) {
        str = readName();
        if ("not".equalsIgnoreCase(str)) {
          skipWhitespace();
          str = readName();
          if ("like".equalsIgnoreCase(str))
            return JSONPath.Operator.NOT_LIKE; 
          if ("rlike".equalsIgnoreCase(str))
            return JSONPath.Operator.NOT_RLIKE; 
          if ("in".equalsIgnoreCase(str))
            return JSONPath.Operator.NOT_IN; 
          if ("between".equalsIgnoreCase(str))
            return JSONPath.Operator.NOT_BETWEEN; 
          throw new UnsupportedOperationException();
        } 
        if ("like".equalsIgnoreCase(str))
          return JSONPath.Operator.LIKE; 
        if ("rlike".equalsIgnoreCase(str))
          return JSONPath.Operator.RLIKE; 
        if ("in".equalsIgnoreCase(str))
          return JSONPath.Operator.IN; 
        if ("between".equalsIgnoreCase(str))
          return JSONPath.Operator.BETWEEN; 
        throw new UnsupportedOperationException();
      } 
      return (JSONPath.Operator)str;
    }
    
    JSONPath.Segement readSegement() {
      if (this.level == 0 && this.path.length() == 1) {
        if (isDigitFirst(this.ch))
          return new JSONPath.ArrayAccessSegement(this.ch - 48); 
        char c = this.ch;
        if (c < 'a' || c > 'z') {
          c = this.ch;
          if (c >= 'A' && c <= 'Z')
            return new JSONPath.PropertySegement(Character.toString(this.ch)); 
        } else {
          return new JSONPath.PropertySegement(Character.toString(this.ch));
        } 
      } 
      while (!isEOF()) {
        skipWhitespace();
        char c = this.ch;
        if (c == '@') {
          next();
          return JSONPath.SelfSegement.instance;
        } 
        if (c == '$') {
          next();
          continue;
        } 
        if (c == '.' || c == '/') {
          next();
          char c1 = this.ch;
          if (c1 == '*') {
            if (!isEOF())
              next(); 
            return JSONPath.WildCardSegement.instance;
          } 
          if (isDigitFirst(c1))
            return parseArrayAccess(false); 
          String str = readName();
          if (this.ch == '(') {
            next();
            if (this.ch == ')') {
              if (!isEOF())
                next(); 
              if ("size".equals(str))
                return JSONPath.SizeSegement.instance; 
              throw new UnsupportedOperationException();
            } 
            throw new UnsupportedOperationException();
          } 
          return new JSONPath.PropertySegement(str);
        } 
        if (c == '[')
          return parseArrayAccess(true); 
        if (this.level == 0)
          return new JSONPath.PropertySegement(readName()); 
        throw new UnsupportedOperationException();
      } 
      return null;
    }
    
    String readString() {
      int i;
      char c = this.ch;
      next();
      int j = this.pos;
      while (this.ch != c && !isEOF())
        next(); 
      String str = this.path;
      if (isEOF()) {
        i = this.pos;
      } else {
        i = this.pos - 1;
      } 
      str = str.substring(j - 1, i);
      accept(c);
      return str;
    }
    
    protected Object readValue() {
      skipWhitespace();
      if (isDigitFirst(this.ch))
        return Long.valueOf(readLongValue()); 
      char c = this.ch;
      if (c == '"' || c == '\'')
        return readString(); 
      if (c == 'n') {
        if ("null".equals(readName()))
          return null; 
        throw new JSONPathException(this.path);
      } 
      throw new UnsupportedOperationException();
    }
    
    public final void skipWhitespace() {
      while (true) {
        char c = this.ch;
        if (c <= ' ' && (c == ' ' || c == '\r' || c == '\n' || c == '\t' || c == '\f' || c == '\b')) {
          next();
          continue;
        } 
        break;
      } 
    }
  }
  
  static class MatchSegement implements Filter {
    private final String[] containsValues;
    
    private final String endsWithValue;
    
    private final int minLength;
    
    private final boolean not;
    
    private final String propertyName;
    
    private final String startsWithValue;
    
    public MatchSegement(String param1String1, String param1String2, String param1String3, String[] param1ArrayOfString, boolean param1Boolean) {
      this.propertyName = param1String1;
      this.startsWithValue = param1String2;
      this.endsWithValue = param1String3;
      this.containsValues = param1ArrayOfString;
      this.not = param1Boolean;
      int k = 0;
      if (param1String2 != null) {
        j = param1String2.length() + 0;
      } else {
        j = 0;
      } 
      int i = j;
      if (param1String3 != null)
        i = j + param1String3.length(); 
      int j = i;
      if (param1ArrayOfString != null) {
        int m = param1ArrayOfString.length;
        while (true) {
          j = i;
          if (k < m) {
            i += param1ArrayOfString[k].length();
            k++;
            continue;
          } 
          break;
        } 
      } 
      this.minLength = j;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      int i;
      param1Object1 = this.propertyName;
      int j = 0;
      Object object = param1JSONPath.getPropertyValue(param1Object3, (String)param1Object1, false);
      if (object == null)
        return false; 
      object = object.toString();
      if (object.length() < this.minLength)
        return this.not; 
      param1Object1 = this.startsWithValue;
      if (param1Object1 != null) {
        if (!object.startsWith((String)param1Object1))
          return this.not; 
        i = this.startsWithValue.length() + 0;
      } else {
        i = 0;
      } 
      param1Object1 = this.containsValues;
      if (param1Object1 != null) {
        int k = param1Object1.length;
        while (j < k) {
          param1Object2 = param1Object1[j];
          i = object.indexOf((String)param1Object2, i);
          if (i == -1)
            return this.not; 
          i += param1Object2.length();
          j++;
        } 
      } 
      param1Object1 = this.endsWithValue;
      return (param1Object1 != null && !object.endsWith((String)param1Object1)) ? this.not : (this.not ^ true);
    }
  }
  
  static class MultiIndexSegement implements Segement {
    private final int[] indexes;
    
    public MultiIndexSegement(int[] param1ArrayOfint) {
      this.indexes = param1ArrayOfint;
    }
    
    public Object eval(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      param1Object1 = new ArrayList(this.indexes.length);
      int i = 0;
      while (true) {
        int[] arrayOfInt = this.indexes;
        if (i < arrayOfInt.length) {
          param1Object1.add(param1JSONPath.getArrayItem(param1Object2, arrayOfInt[i]));
          i++;
          continue;
        } 
        return param1Object1;
      } 
    }
  }
  
  static class MultiPropertySegement implements Segement {
    private final String[] propertyNames;
    
    public MultiPropertySegement(String[] param1ArrayOfString) {
      this.propertyNames = param1ArrayOfString;
    }
    
    public Object eval(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      param1Object1 = new ArrayList(this.propertyNames.length);
      String[] arrayOfString = this.propertyNames;
      int j = arrayOfString.length;
      int i;
      for (i = 0; i < j; i++)
        param1Object1.add(param1JSONPath.getPropertyValue(param1Object2, arrayOfString[i], true)); 
      return param1Object1;
    }
  }
  
  static class NotNullSegement implements Filter {
    private final String propertyName;
    
    public NotNullSegement(String param1String) {
      this.propertyName = param1String;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      param1Object1 = this.propertyName;
      boolean bool = false;
      if (param1JSONPath.getPropertyValue(param1Object3, (String)param1Object1, false) != null)
        bool = true; 
      return bool;
    }
  }
  
  static class NullSegement implements Filter {
    private final String propertyName;
    
    public NullSegement(String param1String) {
      this.propertyName = param1String;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      param1Object1 = this.propertyName;
      boolean bool = false;
      if (param1JSONPath.getPropertyValue(param1Object3, (String)param1Object1, false) == null)
        bool = true; 
      return bool;
    }
  }
  
  enum Operator {
    BETWEEN, EQ, GE, GT, IN, LE, LIKE, LT, NE, NOT_BETWEEN, NOT_IN, NOT_LIKE, NOT_RLIKE, RLIKE;
    
    static {
      GE = new Operator("GE", 3);
      LT = new Operator("LT", 4);
      LE = new Operator("LE", 5);
      LIKE = new Operator("LIKE", 6);
      NOT_LIKE = new Operator("NOT_LIKE", 7);
      RLIKE = new Operator("RLIKE", 8);
      NOT_RLIKE = new Operator("NOT_RLIKE", 9);
      IN = new Operator("IN", 10);
      NOT_IN = new Operator("NOT_IN", 11);
      BETWEEN = new Operator("BETWEEN", 12);
      NOT_BETWEEN = new Operator("NOT_BETWEEN", 13);
      $VALUES = new Operator[] { 
          EQ, NE, GT, GE, LT, LE, LIKE, NOT_LIKE, RLIKE, NOT_RLIKE, 
          IN, NOT_IN, BETWEEN, NOT_BETWEEN };
    }
  }
  
  static class PropertySegement implements Segement {
    private final String propertyName;
    
    public PropertySegement(String param1String) {
      this.propertyName = param1String;
    }
    
    public Object eval(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      return param1JSONPath.getPropertyValue(param1Object2, this.propertyName, true);
    }
    
    public void setValue(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      param1JSONPath.setPropertyValue(param1Object1, this.propertyName, param1Object2);
    }
  }
  
  static class RangeSegement implements Segement {
    private final int end;
    
    private final int start;
    
    private final int step;
    
    public RangeSegement(int param1Int1, int param1Int2, int param1Int3) {
      this.start = param1Int1;
      this.end = param1Int2;
      this.step = param1Int3;
    }
    
    public Object eval(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      int k = JSONPath.SizeSegement.instance.eval(param1JSONPath, param1Object1, param1Object2).intValue();
      int i = this.start;
      if (i < 0)
        i += k; 
      int j = this.end;
      if (j < 0)
        j += k; 
      param1Object1 = new ArrayList((j - i) / this.step + 1);
      while (i <= j && i < k) {
        param1Object1.add(param1JSONPath.getArrayItem(param1Object2, i));
        i += this.step;
      } 
      return param1Object1;
    }
  }
  
  static class RlikeSegement implements Filter {
    private final boolean not;
    
    private final Pattern pattern;
    
    private final String propertyName;
    
    public RlikeSegement(String param1String1, String param1String2, boolean param1Boolean) {
      this.propertyName = param1String1;
      this.pattern = Pattern.compile(param1String2);
      this.not = param1Boolean;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      int i;
      Object object = param1JSONPath.getPropertyValue(param1Object3, this.propertyName, false);
      if (object == null)
        return false; 
      object = object.toString();
      boolean bool2 = this.pattern.matcher((CharSequence)object).matches();
      boolean bool1 = bool2;
      if (this.not)
        i = bool2 ^ true; 
      return i;
    }
  }
  
  static interface Segement {
    Object eval(JSONPath param1JSONPath, Object param1Object1, Object param1Object2);
  }
  
  static class SelfSegement implements Segement {
    public static final SelfSegement instance = new SelfSegement();
    
    public Object eval(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      return param1Object2;
    }
  }
  
  static class SizeSegement implements Segement {
    public static final SizeSegement instance = new SizeSegement();
    
    public Integer eval(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      return Integer.valueOf(param1JSONPath.evalSize(param1Object2));
    }
  }
  
  static class StringInSegement implements Filter {
    private final boolean not;
    
    private final String propertyName;
    
    private final String[] values;
    
    public StringInSegement(String param1String, String[] param1ArrayOfString, boolean param1Boolean) {
      this.propertyName = param1String;
      this.values = param1ArrayOfString;
      this.not = param1Boolean;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      param1Object1 = this.propertyName;
      int i = 0;
      Object object = param1JSONPath.getPropertyValue(param1Object3, (String)param1Object1, false);
      param1Object1 = this.values;
      int j = param1Object1.length;
      while (i < j) {
        param1Object2 = param1Object1[i];
        if (param1Object2 == object)
          return this.not ^ true; 
        if (param1Object2 != null && param1Object2.equals(object))
          return this.not ^ true; 
        i++;
      } 
      return this.not;
    }
  }
  
  static class StringOpSegement implements Filter {
    private final JSONPath.Operator op;
    
    private final String propertyName;
    
    private final String value;
    
    public StringOpSegement(String param1String1, String param1String2, JSONPath.Operator param1Operator) {
      this.propertyName = param1String1;
      this.value = param1String2;
      this.op = param1Operator;
    }
    
    public boolean apply(JSONPath param1JSONPath, Object param1Object1, Object param1Object2, Object param1Object3) {
      param1Object1 = this.propertyName;
      boolean bool3 = false;
      boolean bool4 = false;
      boolean bool2 = false;
      boolean bool1 = false;
      Object object = param1JSONPath.getPropertyValue(param1Object3, (String)param1Object1, false);
      if (this.op == JSONPath.Operator.EQ)
        return this.value.equals(object); 
      if (this.op == JSONPath.Operator.NE)
        return this.value.equals(object) ^ true; 
      if (object == null)
        return false; 
      int i = this.value.compareTo(object.toString());
      if (this.op == JSONPath.Operator.GE) {
        if (i <= 0)
          bool1 = true; 
        return bool1;
      } 
      if (this.op == JSONPath.Operator.GT) {
        bool1 = bool3;
        if (i < 0)
          bool1 = true; 
        return bool1;
      } 
      if (this.op == JSONPath.Operator.LE) {
        bool1 = bool4;
        if (i >= 0)
          bool1 = true; 
        return bool1;
      } 
      bool1 = bool2;
      if (this.op == JSONPath.Operator.LT) {
        bool1 = bool2;
        if (i > 0)
          bool1 = true; 
      } 
      return bool1;
    }
  }
  
  static class WildCardSegement implements Segement {
    public static WildCardSegement instance = new WildCardSegement();
    
    public Object eval(JSONPath param1JSONPath, Object param1Object1, Object param1Object2) {
      return param1JSONPath.getPropertyValues(param1Object2);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\JSONPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */