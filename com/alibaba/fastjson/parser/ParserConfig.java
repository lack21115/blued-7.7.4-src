package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory;
import com.alibaba.fastjson.parser.deserializer.ArrayListTypeFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.MapDeserializer;
import com.alibaba.fastjson.parser.deserializer.NumberDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.OptionalCodec;
import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.StackTraceElementDeserializer;
import com.alibaba.fastjson.parser.deserializer.TimeDeserializer;
import com.alibaba.fastjson.serializer.AtomicCodec;
import com.alibaba.fastjson.serializer.AwtCodec;
import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.BigIntegerCodec;
import com.alibaba.fastjson.serializer.BooleanCodec;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.CharArrayCodec;
import com.alibaba.fastjson.serializer.CharacterCodec;
import com.alibaba.fastjson.serializer.CharsetCodec;
import com.alibaba.fastjson.serializer.CollectionCodec;
import com.alibaba.fastjson.serializer.CurrencyCodec;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.FloatCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.MiscCodec;
import com.alibaba.fastjson.serializer.ReferenceCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.JavaBeanInfo;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class ParserConfig {
  public static final String DENY_PROPERTY = "fastjson.parser.deny";
  
  private static boolean awtError;
  
  public static ParserConfig global = new ParserConfig();
  
  private static boolean jdk8Error;
  
  private boolean asmEnable = ASMUtils.IS_ANDROID ^ true;
  
  protected ASMDeserializerFactory asmFactory;
  
  protected ClassLoader defaultClassLoader;
  
  private String[] denyList = new String[] { "java.lang.Thread" };
  
  private final IdentityHashMap<Type, ObjectDeserializer> derializers = new IdentityHashMap();
  
  public final SymbolTable symbolTable = new SymbolTable(4096);
  
  static {
    awtError = false;
    jdk8Error = false;
  }
  
  public ParserConfig() {
    this(null, null);
  }
  
  public ParserConfig(ASMDeserializerFactory paramASMDeserializerFactory) {
    this(paramASMDeserializerFactory, null);
  }
  
  private ParserConfig(ASMDeserializerFactory paramASMDeserializerFactory, ClassLoader paramClassLoader) {
    ASMDeserializerFactory aSMDeserializerFactory = paramASMDeserializerFactory;
    if (paramASMDeserializerFactory == null) {
      aSMDeserializerFactory = paramASMDeserializerFactory;
      if (!ASMUtils.IS_ANDROID)
        if (paramClassLoader == null) {
          try {
            aSMDeserializerFactory = new ASMDeserializerFactory((ClassLoader)new ASMClassLoader());
          } catch (ExceptionInInitializerError|java.security.AccessControlException|NoClassDefFoundError exceptionInInitializerError) {
            aSMDeserializerFactory = paramASMDeserializerFactory;
          } 
        } else {
          aSMDeserializerFactory = new ASMDeserializerFactory((ClassLoader)exceptionInInitializerError);
        }  
    } 
    this.asmFactory = aSMDeserializerFactory;
    if (aSMDeserializerFactory == null)
      this.asmEnable = false; 
    this.derializers.put(SimpleDateFormat.class, MiscCodec.instance);
    this.derializers.put(Timestamp.class, SqlDateDeserializer.instance_timestamp);
    this.derializers.put(Date.class, SqlDateDeserializer.instance);
    this.derializers.put(Time.class, TimeDeserializer.instance);
    this.derializers.put(Date.class, DateCodec.instance);
    this.derializers.put(Calendar.class, CalendarCodec.instance);
    this.derializers.put(JSONObject.class, MapDeserializer.instance);
    this.derializers.put(JSONArray.class, CollectionCodec.instance);
    this.derializers.put(Map.class, MapDeserializer.instance);
    this.derializers.put(HashMap.class, MapDeserializer.instance);
    this.derializers.put(LinkedHashMap.class, MapDeserializer.instance);
    this.derializers.put(TreeMap.class, MapDeserializer.instance);
    this.derializers.put(ConcurrentMap.class, MapDeserializer.instance);
    this.derializers.put(ConcurrentHashMap.class, MapDeserializer.instance);
    this.derializers.put(Collection.class, CollectionCodec.instance);
    this.derializers.put(List.class, CollectionCodec.instance);
    this.derializers.put(ArrayList.class, CollectionCodec.instance);
    this.derializers.put(Object.class, JavaObjectDeserializer.instance);
    this.derializers.put(String.class, StringCodec.instance);
    this.derializers.put(StringBuffer.class, StringCodec.instance);
    this.derializers.put(StringBuilder.class, StringCodec.instance);
    this.derializers.put(char.class, CharacterCodec.instance);
    this.derializers.put(Character.class, CharacterCodec.instance);
    this.derializers.put(byte.class, NumberDeserializer.instance);
    this.derializers.put(Byte.class, NumberDeserializer.instance);
    this.derializers.put(short.class, NumberDeserializer.instance);
    this.derializers.put(Short.class, NumberDeserializer.instance);
    this.derializers.put(int.class, IntegerCodec.instance);
    this.derializers.put(Integer.class, IntegerCodec.instance);
    this.derializers.put(long.class, LongCodec.instance);
    this.derializers.put(Long.class, LongCodec.instance);
    this.derializers.put(BigInteger.class, BigIntegerCodec.instance);
    this.derializers.put(BigDecimal.class, BigDecimalCodec.instance);
    this.derializers.put(float.class, FloatCodec.instance);
    this.derializers.put(Float.class, FloatCodec.instance);
    this.derializers.put(double.class, NumberDeserializer.instance);
    this.derializers.put(Double.class, NumberDeserializer.instance);
    this.derializers.put(boolean.class, BooleanCodec.instance);
    this.derializers.put(Boolean.class, BooleanCodec.instance);
    this.derializers.put(Class.class, MiscCodec.instance);
    this.derializers.put(char[].class, CharArrayCodec.instance);
    this.derializers.put(AtomicBoolean.class, BooleanCodec.instance);
    this.derializers.put(AtomicInteger.class, IntegerCodec.instance);
    this.derializers.put(AtomicLong.class, LongCodec.instance);
    this.derializers.put(AtomicReference.class, ReferenceCodec.instance);
    this.derializers.put(WeakReference.class, ReferenceCodec.instance);
    this.derializers.put(SoftReference.class, ReferenceCodec.instance);
    this.derializers.put(UUID.class, MiscCodec.instance);
    this.derializers.put(TimeZone.class, MiscCodec.instance);
    this.derializers.put(Locale.class, MiscCodec.instance);
    this.derializers.put(Currency.class, CurrencyCodec.instance);
    this.derializers.put(InetAddress.class, MiscCodec.instance);
    this.derializers.put(Inet4Address.class, MiscCodec.instance);
    this.derializers.put(Inet6Address.class, MiscCodec.instance);
    this.derializers.put(InetSocketAddress.class, MiscCodec.instance);
    this.derializers.put(File.class, MiscCodec.instance);
    this.derializers.put(URI.class, MiscCodec.instance);
    this.derializers.put(URL.class, MiscCodec.instance);
    this.derializers.put(Pattern.class, MiscCodec.instance);
    this.derializers.put(Charset.class, CharsetCodec.instance);
    this.derializers.put(Number.class, NumberDeserializer.instance);
    this.derializers.put(AtomicIntegerArray.class, AtomicCodec.instance);
    this.derializers.put(AtomicLongArray.class, AtomicCodec.instance);
    this.derializers.put(StackTraceElement.class, StackTraceElementDeserializer.instance);
    this.derializers.put(Serializable.class, JavaObjectDeserializer.instance);
    this.derializers.put(Cloneable.class, JavaObjectDeserializer.instance);
    this.derializers.put(Comparable.class, JavaObjectDeserializer.instance);
    this.derializers.put(Closeable.class, JavaObjectDeserializer.instance);
    if (!awtError)
      try {
        this.derializers.put(Class.forName("java.awt.Point"), AwtCodec.instance);
        this.derializers.put(Class.forName("java.awt.Font"), AwtCodec.instance);
        this.derializers.put(Class.forName("java.awt.Rectangle"), AwtCodec.instance);
        this.derializers.put(Class.forName("java.awt.Color"), AwtCodec.instance);
      } finally {
        paramASMDeserializerFactory = null;
      }  
    if (!jdk8Error)
      try {
        this.derializers.put(Class.forName("java.time.LocalDateTime"), Jdk8DateCodec.instance);
        this.derializers.put(Class.forName("java.time.LocalDate"), Jdk8DateCodec.instance);
        this.derializers.put(Class.forName("java.time.LocalTime"), Jdk8DateCodec.instance);
        this.derializers.put(Class.forName("java.time.ZonedDateTime"), Jdk8DateCodec.instance);
        this.derializers.put(Class.forName("java.time.OffsetDateTime"), Jdk8DateCodec.instance);
        this.derializers.put(Class.forName("java.time.OffsetTime"), Jdk8DateCodec.instance);
        this.derializers.put(Class.forName("java.time.ZoneOffset"), Jdk8DateCodec.instance);
        this.derializers.put(Class.forName("java.time.ZoneRegion"), Jdk8DateCodec.instance);
        this.derializers.put(Class.forName("java.time.ZoneId"), Jdk8DateCodec.instance);
        this.derializers.put(Class.forName("java.time.Period"), Jdk8DateCodec.instance);
        this.derializers.put(Class.forName("java.time.Duration"), Jdk8DateCodec.instance);
        this.derializers.put(Class.forName("java.time.Instant"), Jdk8DateCodec.instance);
        this.derializers.put(Class.forName("java.util.Optional"), OptionalCodec.instance);
        this.derializers.put(Class.forName("java.util.OptionalDouble"), OptionalCodec.instance);
        this.derializers.put(Class.forName("java.util.OptionalInt"), OptionalCodec.instance);
        this.derializers.put(Class.forName("java.util.OptionalLong"), OptionalCodec.instance);
      } finally {
        paramASMDeserializerFactory = null;
      }  
    addDeny("java.lang.Thread");
    configFromPropety(System.getProperties());
  }
  
  public ParserConfig(ClassLoader paramClassLoader) {
    this(null, paramClassLoader);
  }
  
  public static Field getField(Class<?> paramClass, String paramString) {
    Field field2 = getField0(paramClass, paramString);
    Field field1 = field2;
    if (field2 == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("_");
      stringBuilder.append(paramString);
      field1 = getField0(paramClass, stringBuilder.toString());
    } 
    field2 = field1;
    if (field1 == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("m_");
      stringBuilder.append(paramString);
      field2 = getField0(paramClass, stringBuilder.toString());
    } 
    return field2;
  }
  
  private static Field getField0(Class<?> paramClass, String paramString) {
    for (Field field : paramClass.getDeclaredFields()) {
      if (paramString.equals(field.getName()))
        return field; 
    } 
    return (paramClass.getSuperclass() != null && paramClass.getSuperclass() != Object.class) ? getField(paramClass.getSuperclass(), paramString) : null;
  }
  
  public static ParserConfig getGlobalInstance() {
    return global;
  }
  
  public void addDeny(String paramString) {
    if (paramString != null) {
      if (paramString.length() == 0)
        return; 
      String[] arrayOfString1 = this.denyList;
      String[] arrayOfString2 = new String[arrayOfString1.length + 1];
      System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, arrayOfString1.length);
      arrayOfString2[arrayOfString2.length - 1] = paramString;
      this.denyList = arrayOfString2;
    } 
  }
  
  public void configFromPropety(Properties paramProperties) {
    String str = paramProperties.getProperty("fastjson.parser.deny");
    if (str != null && str.length() > 0) {
      String[] arrayOfString = str.split(",");
      for (int i = 0; i < arrayOfString.length; i++)
        addDeny(arrayOfString[i]); 
    } 
  }
  
  public FieldDeserializer createFieldDeserializer(ParserConfig paramParserConfig, JavaBeanInfo paramJavaBeanInfo, FieldInfo paramFieldInfo) {
    Class clazz = paramJavaBeanInfo.clazz;
    Class<List> clazz1 = paramFieldInfo.fieldClass;
    return (FieldDeserializer)((clazz1 == List.class || clazz1 == ArrayList.class) ? new ArrayListTypeFieldDeserializer(paramParserConfig, clazz, paramFieldInfo) : new DefaultFieldDeserializer(paramParserConfig, clazz, paramFieldInfo));
  }
  
  public ObjectDeserializer createJavaBeanDeserializer(Class<?> paramClass, Type paramType) {
    boolean bool3 = this.asmEnable;
    boolean bool1 = bool3;
    if (bool3) {
      JSONType jSONType = paramClass.<JSONType>getAnnotation(JSONType.class);
      boolean bool = bool3;
      if (jSONType != null) {
        bool = bool3;
        if (!jSONType.asm())
          bool = false; 
      } 
      bool1 = bool;
      if (bool) {
        Class<?> clazz2 = JavaBeanInfo.getBuilderClass(jSONType);
        Class<?> clazz1 = clazz2;
        if (clazz2 == null)
          clazz1 = paramClass; 
        while (true) {
          if (!Modifier.isPublic(clazz1.getModifiers())) {
            bool1 = false;
            break;
          } 
          clazz2 = clazz1.getSuperclass();
          bool1 = bool;
          if (clazz2 != Object.class) {
            clazz1 = clazz2;
            if (clazz2 == null) {
              bool1 = bool;
              break;
            } 
            continue;
          } 
          break;
        } 
      } 
    } 
    boolean bool2 = bool1;
    if ((paramClass.getTypeParameters()).length != 0)
      bool2 = false; 
    bool1 = bool2;
    if (bool2) {
      ASMDeserializerFactory aSMDeserializerFactory = this.asmFactory;
      bool1 = bool2;
      if (aSMDeserializerFactory != null) {
        bool1 = bool2;
        if (aSMDeserializerFactory.classLoader.isExternalClass(paramClass))
          bool1 = false; 
      } 
    } 
    bool2 = bool1;
    if (bool1)
      bool2 = ASMUtils.checkName(paramClass.getName()); 
    bool1 = bool2;
    if (bool2) {
      if (paramClass.isInterface())
        bool2 = false; 
      JavaBeanInfo javaBeanInfo = JavaBeanInfo.build(paramClass, paramType);
      bool1 = bool2;
      if (bool2) {
        bool1 = bool2;
        if (javaBeanInfo.fields.length > 200)
          bool1 = false; 
      } 
      Constructor constructor = javaBeanInfo.defaultConstructor;
      bool2 = bool1;
      if (bool1) {
        bool2 = bool1;
        if (constructor == null) {
          bool2 = bool1;
          if (!paramClass.isInterface())
            bool2 = false; 
        } 
      } 
      FieldInfo[] arrayOfFieldInfo = javaBeanInfo.fields;
      int j = arrayOfFieldInfo.length;
      int i = 0;
      while (true) {
        bool1 = bool2;
        if (i < j) {
          FieldInfo fieldInfo = arrayOfFieldInfo[i];
          if (!fieldInfo.getOnly) {
            Class clazz = fieldInfo.fieldClass;
            if (Modifier.isPublic(clazz.getModifiers()) && (!clazz.isMemberClass() || Modifier.isStatic(clazz.getModifiers())) && (fieldInfo.getMember() == null || ASMUtils.checkName(fieldInfo.getMember().getName()))) {
              JSONField jSONField = fieldInfo.getAnnotation();
              if ((jSONField == null || ASMUtils.checkName(jSONField.name())) && (!clazz.isEnum() || getDeserializer(clazz) instanceof com.alibaba.fastjson.parser.deserializer.EnumDeserializer)) {
                i++;
                continue;
              } 
            } 
          } 
          bool1 = false;
        } 
        break;
      } 
    } 
    bool2 = bool1;
    if (bool1) {
      bool2 = bool1;
      if (paramClass.isMemberClass()) {
        bool2 = bool1;
        if (!Modifier.isStatic(paramClass.getModifiers()))
          bool2 = false; 
      } 
    } 
    if (!bool2)
      return (ObjectDeserializer)new JavaBeanDeserializer(this, paramClass, paramType); 
    try {
      return this.asmFactory.createJavaBeanDeserializer(this, paramClass, paramType);
    } catch (NoSuchMethodException noSuchMethodException) {
      return (ObjectDeserializer)new JavaBeanDeserializer(this, paramClass, paramType);
    } catch (JSONException jSONException) {
      return (ObjectDeserializer)new JavaBeanDeserializer(this, paramClass, paramType);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("create asm deserializer error, ");
      stringBuilder.append(paramClass.getName());
      throw new JSONException(stringBuilder.toString(), exception);
    } 
  }
  
  public ClassLoader getDefaultClassLoader() {
    return this.defaultClassLoader;
  }
  
  public IdentityHashMap<Type, ObjectDeserializer> getDerializers() {
    return this.derializers;
  }
  
  public ObjectDeserializer getDeserializer(FieldInfo paramFieldInfo) {
    return getDeserializer(paramFieldInfo.fieldClass, paramFieldInfo.fieldType);
  }
  
  public ObjectDeserializer getDeserializer(Class<?> paramClass, Type paramType) {
    // Byte code:
    //   0: aload_0
    //   1: getfield derializers : Lcom/alibaba/fastjson/util/IdentityHashMap;
    //   4: aload_2
    //   5: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   8: checkcast com/alibaba/fastjson/parser/deserializer/ObjectDeserializer
    //   11: astore #4
    //   13: aload #4
    //   15: ifnull -> 21
    //   18: aload #4
    //   20: areturn
    //   21: aload_2
    //   22: astore #4
    //   24: aload_2
    //   25: ifnonnull -> 31
    //   28: aload_1
    //   29: astore #4
    //   31: aload_0
    //   32: getfield derializers : Lcom/alibaba/fastjson/util/IdentityHashMap;
    //   35: aload #4
    //   37: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast com/alibaba/fastjson/parser/deserializer/ObjectDeserializer
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull -> 50
    //   48: aload_2
    //   49: areturn
    //   50: aload_1
    //   51: ldc_w com/alibaba/fastjson/annotation/JSONType
    //   54: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   57: checkcast com/alibaba/fastjson/annotation/JSONType
    //   60: astore #5
    //   62: aload #5
    //   64: ifnull -> 93
    //   67: aload #5
    //   69: invokeinterface mappingTo : ()Ljava/lang/Class;
    //   74: astore #5
    //   76: aload #5
    //   78: ldc_w java/lang/Void
    //   81: if_acmpeq -> 93
    //   84: aload_0
    //   85: aload #5
    //   87: aload #5
    //   89: invokevirtual getDeserializer : (Ljava/lang/Class;Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   92: areturn
    //   93: aload #4
    //   95: instanceof java/lang/reflect/WildcardType
    //   98: ifne -> 117
    //   101: aload #4
    //   103: instanceof java/lang/reflect/TypeVariable
    //   106: ifne -> 117
    //   109: aload #4
    //   111: instanceof java/lang/reflect/ParameterizedType
    //   114: ifeq -> 129
    //   117: aload_0
    //   118: getfield derializers : Lcom/alibaba/fastjson/util/IdentityHashMap;
    //   121: aload_1
    //   122: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   125: checkcast com/alibaba/fastjson/parser/deserializer/ObjectDeserializer
    //   128: astore_2
    //   129: aload_2
    //   130: ifnull -> 135
    //   133: aload_2
    //   134: areturn
    //   135: iconst_0
    //   136: istore_3
    //   137: aload_0
    //   138: getfield denyList : [Ljava/lang/String;
    //   141: astore_2
    //   142: iload_3
    //   143: aload_2
    //   144: arraylength
    //   145: if_icmpge -> 215
    //   148: aload_2
    //   149: iload_3
    //   150: aaload
    //   151: astore #5
    //   153: aload_1
    //   154: invokevirtual getName : ()Ljava/lang/String;
    //   157: bipush #36
    //   159: bipush #46
    //   161: invokevirtual replace : (CC)Ljava/lang/String;
    //   164: astore_2
    //   165: aload_2
    //   166: aload #5
    //   168: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   171: ifne -> 181
    //   174: iload_3
    //   175: iconst_1
    //   176: iadd
    //   177: istore_3
    //   178: goto -> 137
    //   181: new java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial <init> : ()V
    //   188: astore_1
    //   189: aload_1
    //   190: ldc_w 'parser deny : '
    //   193: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_1
    //   198: aload_2
    //   199: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: new com/alibaba/fastjson/JSONException
    //   206: dup
    //   207: aload_1
    //   208: invokevirtual toString : ()Ljava/lang/String;
    //   211: invokespecial <init> : (Ljava/lang/String;)V
    //   214: athrow
    //   215: invokestatic currentThread : ()Ljava/lang/Thread;
    //   218: invokevirtual getContextClassLoader : ()Ljava/lang/ClassLoader;
    //   221: astore_2
    //   222: ldc_w com/alibaba/fastjson/parser/deserializer/AutowiredObjectDeserializer
    //   225: aload_2
    //   226: invokestatic load : (Ljava/lang/Class;Ljava/lang/ClassLoader;)Ljava/util/Set;
    //   229: invokeinterface iterator : ()Ljava/util/Iterator;
    //   234: astore_2
    //   235: aload_2
    //   236: invokeinterface hasNext : ()Z
    //   241: ifeq -> 306
    //   244: aload_2
    //   245: invokeinterface next : ()Ljava/lang/Object;
    //   250: checkcast com/alibaba/fastjson/parser/deserializer/AutowiredObjectDeserializer
    //   253: astore #5
    //   255: aload #5
    //   257: invokeinterface getAutowiredFor : ()Ljava/util/Set;
    //   262: invokeinterface iterator : ()Ljava/util/Iterator;
    //   267: astore #6
    //   269: aload #6
    //   271: invokeinterface hasNext : ()Z
    //   276: ifeq -> 235
    //   279: aload #6
    //   281: invokeinterface next : ()Ljava/lang/Object;
    //   286: checkcast java/lang/reflect/Type
    //   289: astore #7
    //   291: aload_0
    //   292: getfield derializers : Lcom/alibaba/fastjson/util/IdentityHashMap;
    //   295: aload #7
    //   297: aload #5
    //   299: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   302: pop
    //   303: goto -> 269
    //   306: aload_0
    //   307: getfield derializers : Lcom/alibaba/fastjson/util/IdentityHashMap;
    //   310: aload #4
    //   312: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   315: checkcast com/alibaba/fastjson/parser/deserializer/ObjectDeserializer
    //   318: astore_2
    //   319: aload_2
    //   320: ifnull -> 325
    //   323: aload_2
    //   324: areturn
    //   325: aload_1
    //   326: invokevirtual isEnum : ()Z
    //   329: ifeq -> 344
    //   332: new com/alibaba/fastjson/parser/deserializer/EnumDeserializer
    //   335: dup
    //   336: aload_1
    //   337: invokespecial <init> : (Ljava/lang/Class;)V
    //   340: astore_1
    //   341: goto -> 463
    //   344: aload_1
    //   345: invokevirtual isArray : ()Z
    //   348: ifeq -> 358
    //   351: getstatic com/alibaba/fastjson/serializer/ObjectArrayCodec.instance : Lcom/alibaba/fastjson/serializer/ObjectArrayCodec;
    //   354: astore_1
    //   355: goto -> 463
    //   358: aload_1
    //   359: ldc_w java/util/Set
    //   362: if_acmpeq -> 459
    //   365: aload_1
    //   366: ldc_w java/util/HashSet
    //   369: if_acmpeq -> 459
    //   372: aload_1
    //   373: ldc java/util/Collection
    //   375: if_acmpeq -> 459
    //   378: aload_1
    //   379: ldc java/util/List
    //   381: if_acmpeq -> 459
    //   384: aload_1
    //   385: ldc java/util/ArrayList
    //   387: if_acmpne -> 393
    //   390: goto -> 459
    //   393: ldc java/util/Collection
    //   395: aload_1
    //   396: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   399: ifeq -> 409
    //   402: getstatic com/alibaba/fastjson/serializer/CollectionCodec.instance : Lcom/alibaba/fastjson/serializer/CollectionCodec;
    //   405: astore_1
    //   406: goto -> 463
    //   409: ldc java/util/Map
    //   411: aload_1
    //   412: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   415: ifeq -> 425
    //   418: getstatic com/alibaba/fastjson/parser/deserializer/MapDeserializer.instance : Lcom/alibaba/fastjson/parser/deserializer/MapDeserializer;
    //   421: astore_1
    //   422: goto -> 463
    //   425: ldc_w java/lang/Throwable
    //   428: aload_1
    //   429: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   432: ifeq -> 448
    //   435: new com/alibaba/fastjson/parser/deserializer/ThrowableDeserializer
    //   438: dup
    //   439: aload_0
    //   440: aload_1
    //   441: invokespecial <init> : (Lcom/alibaba/fastjson/parser/ParserConfig;Ljava/lang/Class;)V
    //   444: astore_1
    //   445: goto -> 463
    //   448: aload_0
    //   449: aload_1
    //   450: aload #4
    //   452: invokevirtual createJavaBeanDeserializer : (Ljava/lang/Class;Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   455: astore_1
    //   456: goto -> 463
    //   459: getstatic com/alibaba/fastjson/serializer/CollectionCodec.instance : Lcom/alibaba/fastjson/serializer/CollectionCodec;
    //   462: astore_1
    //   463: aload_0
    //   464: aload #4
    //   466: aload_1
    //   467: invokevirtual putDeserializer : (Ljava/lang/reflect/Type;Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;)V
    //   470: aload_1
    //   471: areturn
    //   472: astore_2
    //   473: goto -> 306
    // Exception table:
    //   from	to	target	type
    //   222	235	472	java/lang/Exception
    //   235	269	472	java/lang/Exception
    //   269	303	472	java/lang/Exception
  }
  
  public ObjectDeserializer getDeserializer(Type paramType) {
    ObjectDeserializer objectDeserializer = (ObjectDeserializer)this.derializers.get(paramType);
    if (objectDeserializer != null)
      return objectDeserializer; 
    if (paramType instanceof Class)
      return getDeserializer((Class)paramType, paramType); 
    if (paramType instanceof ParameterizedType) {
      Type type = ((ParameterizedType)paramType).getRawType();
      return (type instanceof Class) ? getDeserializer((Class)type, paramType) : getDeserializer(type);
    } 
    return (ObjectDeserializer)JavaObjectDeserializer.instance;
  }
  
  public boolean isAsmEnable() {
    return this.asmEnable;
  }
  
  public boolean isPrimitive(Class<?> paramClass) {
    return (paramClass.isPrimitive() || paramClass == Boolean.class || paramClass == Character.class || paramClass == Byte.class || paramClass == Short.class || paramClass == Integer.class || paramClass == Long.class || paramClass == Float.class || paramClass == Double.class || paramClass == BigInteger.class || paramClass == BigDecimal.class || paramClass == String.class || paramClass == Date.class || paramClass == Date.class || paramClass == Time.class || paramClass == Timestamp.class);
  }
  
  public void putDeserializer(Type paramType, ObjectDeserializer paramObjectDeserializer) {
    this.derializers.put(paramType, paramObjectDeserializer);
  }
  
  public void setAsmEnable(boolean paramBoolean) {
    this.asmEnable = paramBoolean;
  }
  
  public void setDefaultClassLoader(ClassLoader paramClassLoader) {
    this.defaultClassLoader = paramClassLoader;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\ParserConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */