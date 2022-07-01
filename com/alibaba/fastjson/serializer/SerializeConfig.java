package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.OptionalCodec;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.ServiceLoader;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
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
import java.sql.Clob;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class SerializeConfig extends IdentityHashMap<Type, ObjectSerializer> {
  private static boolean awtError;
  
  public static final SerializeConfig globalInstance = new SerializeConfig();
  
  private static boolean jdk8Error;
  
  private static boolean oracleJdbcError;
  
  private boolean asm = ASMUtils.IS_ANDROID ^ true;
  
  private ASMSerializerFactory asmFactory;
  
  private String typeKey = JSON.DEFAULT_TYPE_KEY;
  
  static {
    awtError = false;
    jdk8Error = false;
    oracleJdbcError = false;
  }
  
  public SerializeConfig() {
    this(1024);
  }
  
  public SerializeConfig(int paramInt) {
    super(paramInt);
    try {
      if (this.asm)
        this.asmFactory = new ASMSerializerFactory(); 
    } catch (NoClassDefFoundError noClassDefFoundError) {
      this.asm = false;
    } catch (ExceptionInInitializerError exceptionInInitializerError) {
      this.asm = false;
    } 
    put(Boolean.class, BooleanCodec.instance);
    put(Character.class, CharacterCodec.instance);
    put(Byte.class, IntegerCodec.instance);
    put(Short.class, IntegerCodec.instance);
    put(Integer.class, IntegerCodec.instance);
    put(Long.class, LongCodec.instance);
    put(Float.class, FloatCodec.instance);
    put(Double.class, DoubleSerializer.instance);
    put(BigDecimal.class, BigDecimalCodec.instance);
    put(BigInteger.class, BigIntegerCodec.instance);
    put(String.class, StringCodec.instance);
    put(byte[].class, PrimitiveArraySerializer.instance);
    put(short[].class, PrimitiveArraySerializer.instance);
    put(int[].class, PrimitiveArraySerializer.instance);
    put(long[].class, PrimitiveArraySerializer.instance);
    put(float[].class, PrimitiveArraySerializer.instance);
    put(double[].class, PrimitiveArraySerializer.instance);
    put(boolean[].class, PrimitiveArraySerializer.instance);
    put(char[].class, PrimitiveArraySerializer.instance);
    put(Object[].class, ObjectArrayCodec.instance);
    put(Class.class, MiscCodec.instance);
    put(SimpleDateFormat.class, MiscCodec.instance);
    put(Locale.class, MiscCodec.instance);
    put(Currency.class, CurrencyCodec.instance);
    put(TimeZone.class, MiscCodec.instance);
    put(UUID.class, MiscCodec.instance);
    put(InetAddress.class, MiscCodec.instance);
    put(Inet4Address.class, MiscCodec.instance);
    put(Inet6Address.class, MiscCodec.instance);
    put(InetSocketAddress.class, MiscCodec.instance);
    put(File.class, MiscCodec.instance);
    put(URI.class, MiscCodec.instance);
    put(URL.class, MiscCodec.instance);
    put(Appendable.class, AppendableSerializer.instance);
    put(StringBuffer.class, AppendableSerializer.instance);
    put(StringBuilder.class, AppendableSerializer.instance);
    put(Pattern.class, MiscCodec.instance);
    put(Charset.class, CharsetCodec.instance);
    put(AtomicBoolean.class, AtomicCodec.instance);
    put(AtomicInteger.class, AtomicCodec.instance);
    put(AtomicLong.class, AtomicCodec.instance);
    put(AtomicReference.class, ReferenceCodec.instance);
    put(AtomicIntegerArray.class, AtomicCodec.instance);
    put(AtomicLongArray.class, AtomicCodec.instance);
    put(WeakReference.class, ReferenceCodec.instance);
    put(SoftReference.class, ReferenceCodec.instance);
    if (!awtError)
      try {
        put(Class.forName("java.awt.Color"), AwtCodec.instance);
        put(Class.forName("java.awt.Font"), AwtCodec.instance);
        put(Class.forName("java.awt.Point"), AwtCodec.instance);
        put(Class.forName("java.awt.Rectangle"), AwtCodec.instance);
      } finally {
        Exception exception = null;
      }  
    if (!jdk8Error)
      try {
        put(Class.forName("java.time.LocalDateTime"), Jdk8DateCodec.instance);
        put(Class.forName("java.time.LocalDate"), Jdk8DateCodec.instance);
        put(Class.forName("java.time.LocalTime"), Jdk8DateCodec.instance);
        put(Class.forName("java.time.ZonedDateTime"), Jdk8DateCodec.instance);
        put(Class.forName("java.time.OffsetDateTime"), Jdk8DateCodec.instance);
        put(Class.forName("java.time.OffsetTime"), Jdk8DateCodec.instance);
        put(Class.forName("java.time.ZoneOffset"), Jdk8DateCodec.instance);
        put(Class.forName("java.time.ZoneRegion"), Jdk8DateCodec.instance);
        put(Class.forName("java.time.Period"), Jdk8DateCodec.instance);
        put(Class.forName("java.time.Duration"), Jdk8DateCodec.instance);
        put(Class.forName("java.time.Instant"), Jdk8DateCodec.instance);
        put(Class.forName("java.util.Optional"), OptionalCodec.instance);
        put(Class.forName("java.util.OptionalDouble"), OptionalCodec.instance);
        put(Class.forName("java.util.OptionalInt"), OptionalCodec.instance);
        put(Class.forName("java.util.OptionalLong"), OptionalCodec.instance);
      } finally {
        Exception exception = null;
      }  
    if (!oracleJdbcError)
      try {
        put(Class.forName("oracle.sql.DATE"), DateCodec.instance);
        return;
      } finally {
        Exception exception = null;
      }  
  }
  
  public static SerializeConfig getGlobalInstance() {
    return globalInstance;
  }
  
  public final ObjectSerializer createASMSerializer(Class<?> paramClass) throws Exception {
    return this.asmFactory.createJavaBeanSerializer(paramClass, null);
  }
  
  public ObjectSerializer createJavaBeanSerializer(Class<?> paramClass) {
    if (!Modifier.isPublic(paramClass.getModifiers()))
      return new JavaBeanSerializer(paramClass); 
    boolean bool2 = this.asm;
    if ((bool2 && this.asmFactory.classLoader.isExternalClass(paramClass)) || paramClass == Serializable.class || paramClass == Object.class)
      bool2 = false; 
    JSONType jSONType = paramClass.<JSONType>getAnnotation(JSONType.class);
    boolean bool1 = bool2;
    if (jSONType != null) {
      bool1 = bool2;
      if (!jSONType.asm())
        bool1 = false; 
    } 
    bool2 = bool1;
    if (bool1) {
      bool2 = bool1;
      if (!ASMUtils.checkName(paramClass.getName()))
        bool2 = false; 
    } 
    bool1 = bool2;
    if (bool2) {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      while (true) {
        bool1 = bool2;
        if (i < j) {
          JSONField jSONField = arrayOfField[i].<JSONField>getAnnotation(JSONField.class);
          if (jSONField != null && !ASMUtils.checkName(jSONField.name())) {
            bool1 = false;
            break;
          } 
          i++;
          continue;
        } 
        break;
      } 
    } 
    if (bool1)
      try {
      
      } catch (ClassCastException classCastException) {
      
      } finally {
        jSONType = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create asm serializer error, class ");
        stringBuilder.append(paramClass);
      }  
    return new JavaBeanSerializer(paramClass);
  }
  
  public ObjectSerializer getObjectWriter(Class<?> paramClass) {
    objectSerializer2 = (ObjectSerializer)get(paramClass);
    ObjectSerializer objectSerializer1 = objectSerializer2;
    if (objectSerializer2 == null) {
      try {
        for (ObjectSerializer objectSerializer2 : ServiceLoader.load(AutowiredObjectSerializer.class, Thread.currentThread().getContextClassLoader())) {
          if (!(objectSerializer2 instanceof AutowiredObjectSerializer))
            continue; 
          objectSerializer2 = objectSerializer2;
          Iterator<Type> iterator = objectSerializer2.getAutowiredFor().iterator();
          while (iterator.hasNext())
            put(iterator.next(), objectSerializer2); 
        } 
      } catch (ClassCastException classCastException) {}
      objectSerializer1 = (ObjectSerializer)get(paramClass);
    } 
    objectSerializer2 = objectSerializer1;
    if (objectSerializer1 == null) {
      ClassLoader classLoader = JSON.class.getClassLoader();
      objectSerializer2 = objectSerializer1;
      if (classLoader != Thread.currentThread().getContextClassLoader()) {
        try {
          for (ObjectSerializer objectSerializer2 : ServiceLoader.load(AutowiredObjectSerializer.class, classLoader)) {
            if (!(objectSerializer2 instanceof AutowiredObjectSerializer))
              continue; 
            objectSerializer2 = objectSerializer2;
            Iterator<Type> iterator = objectSerializer2.getAutowiredFor().iterator();
            while (iterator.hasNext())
              put(iterator.next(), objectSerializer2); 
          } 
        } catch (ClassCastException classCastException) {}
        objectSerializer2 = (ObjectSerializer)get(paramClass);
      } 
    } 
    objectSerializer1 = objectSerializer2;
    if (objectSerializer2 == null) {
      if (Map.class.isAssignableFrom(paramClass)) {
        put(paramClass, MapSerializer.instance);
      } else if (List.class.isAssignableFrom(paramClass)) {
        put(paramClass, ListSerializer.instance);
      } else if (Collection.class.isAssignableFrom(paramClass)) {
        put(paramClass, CollectionCodec.instance);
      } else if (Date.class.isAssignableFrom(paramClass)) {
        put(paramClass, DateCodec.instance);
      } else if (JSONAware.class.isAssignableFrom(paramClass)) {
        put(paramClass, JSONAwareSerializer.instance);
      } else if (JSONSerializable.class.isAssignableFrom(paramClass)) {
        put(paramClass, JSONSerializableSerializer.instance);
      } else if (JSONStreamAware.class.isAssignableFrom(paramClass)) {
        put(paramClass, MiscCodec.instance);
      } else if (paramClass.isEnum() || (paramClass.getSuperclass() != null && paramClass.getSuperclass().isEnum())) {
        put(paramClass, EnumSerializer.instance);
      } else if (paramClass.isArray()) {
        Class<?> clazz = paramClass.getComponentType();
        put(paramClass, new ArraySerializer(clazz, getObjectWriter(clazz)));
      } else if (Throwable.class.isAssignableFrom(paramClass)) {
        put(paramClass, new JavaBeanSerializer(paramClass, null, TypeUtils.getSerializeFeatures(paramClass) | SerializerFeature.WriteClassName.mask));
      } else if (TimeZone.class.isAssignableFrom(paramClass)) {
        put(paramClass, MiscCodec.instance);
      } else if (Appendable.class.isAssignableFrom(paramClass)) {
        put(paramClass, AppendableSerializer.instance);
      } else if (Charset.class.isAssignableFrom(paramClass)) {
        put(paramClass, CharsetCodec.instance);
      } else if (Enumeration.class.isAssignableFrom(paramClass)) {
        put(paramClass, EnumerationSerializer.instance);
      } else if (Calendar.class.isAssignableFrom(paramClass)) {
        put(paramClass, CalendarCodec.instance);
      } else if (Clob.class.isAssignableFrom(paramClass)) {
        put(paramClass, ClobSeriliazer.instance);
      } else if (Iterable.class.isAssignableFrom(paramClass) || Iterator.class.isAssignableFrom(paramClass)) {
        put(paramClass, MiscCodec.instance);
      } else {
        boolean bool1;
        boolean bool2;
        Class[] arrayOfClass = paramClass.getInterfaces();
        int j = arrayOfClass.length;
        boolean bool4 = false;
        boolean bool3 = false;
        int i = 0;
        while (true) {
          boolean bool = true;
          bool1 = bool3;
          if (i < j) {
            String str = arrayOfClass[i].getName();
            if (str.equals("net.sf.cglib.proxy.Factory") || str.equals("org.springframework.cglib.proxy.Factory")) {
              bool1 = true;
            } else {
              bool1 = bool4;
              boolean bool5 = bool;
              if (!str.equals("javassist.util.proxy.ProxyObject")) {
                if (str.equals("org.apache.ibatis.javassist.util.proxy.ProxyObject")) {
                  bool1 = bool4;
                  bool5 = bool;
                  break;
                } 
                i++;
                continue;
              } 
              break;
            } 
          } 
          bool2 = false;
          break;
        } 
        if (bool1 || bool2) {
          ObjectSerializer objectSerializer = getObjectWriter(paramClass.getSuperclass());
          put(paramClass, objectSerializer);
          return objectSerializer;
        } 
        put(paramClass, createJavaBeanSerializer(paramClass));
      } 
      objectSerializer1 = (ObjectSerializer)get(paramClass);
    } 
    return objectSerializer1;
  }
  
  public String getTypeKey() {
    return this.typeKey;
  }
  
  public boolean isAsmEnable() {
    return this.asm;
  }
  
  public void setAsmEnable(boolean paramBoolean) {
    if (ASMUtils.IS_ANDROID)
      return; 
    this.asm = paramBoolean;
  }
  
  public void setTypeKey(String paramString) {
    this.typeKey = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\SerializeConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */