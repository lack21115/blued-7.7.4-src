package com.alibaba.fastjson;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public abstract class JSON implements JSONAware, JSONStreamAware {
  public static int DEFAULT_GENERATE_FEATURE = 0;
  
  public static int DEFAULT_PARSER_FEATURE = 0;
  
  public static String DEFAULT_TYPE_KEY;
  
  public static String DEFFAULT_DATE_FORMAT;
  
  public static final String VERSION = "1.2.9";
  
  public static Locale defaultLocale;
  
  public static TimeZone defaultTimeZone = TimeZone.getDefault();
  
  static final SerializeFilter[] emptyFilters;
  
  static {
    defaultLocale = Locale.getDefault();
    DEFAULT_TYPE_KEY = "@type";
    emptyFilters = new SerializeFilter[0];
    DEFAULT_PARSER_FEATURE = Feature.AutoCloseSource.getMask() | 0x0 | Feature.InternFieldNames.getMask() | Feature.UseBigDecimal.getMask() | Feature.AllowUnQuotedFieldNames.getMask() | Feature.AllowSingleQuotes.getMask() | Feature.AllowArbitraryCommas.getMask() | Feature.SortFeidFastMatch.getMask() | Feature.IgnoreNotMatch.getMask();
    DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    DEFAULT_GENERATE_FEATURE = 0x0 | SerializerFeature.QuoteFieldNames.getMask() | SerializerFeature.SkipTransientField.getMask() | SerializerFeature.WriteEnumUsingName.getMask() | SerializerFeature.SortField.getMask();
  }
  
  public static Object parse(String paramString) {
    return parse(paramString, DEFAULT_PARSER_FEATURE);
  }
  
  public static Object parse(String paramString, int paramInt) {
    if (paramString == null)
      return null; 
    DefaultJSONParser defaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance(), paramInt);
    Object object = defaultJSONParser.parse();
    defaultJSONParser.handleResovleTask(object);
    defaultJSONParser.close();
    return object;
  }
  
  public static Object parse(String paramString, Feature... paramVarArgs) {
    int j = DEFAULT_PARSER_FEATURE;
    int k = paramVarArgs.length;
    for (int i = 0; i < k; i++)
      j = Feature.config(j, paramVarArgs[i], true); 
    return parse(paramString, j);
  }
  
  public static Object parse(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, int paramInt3) {
    paramCharsetDecoder.reset();
    char[] arrayOfChar = IOUtils.getChars((int)(paramInt2 * paramCharsetDecoder.maxCharsPerByte()));
    ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte, paramInt1, paramInt2);
    CharBuffer charBuffer = CharBuffer.wrap(arrayOfChar);
    IOUtils.decode(paramCharsetDecoder, byteBuffer, charBuffer);
    DefaultJSONParser defaultJSONParser = new DefaultJSONParser(arrayOfChar, charBuffer.position(), ParserConfig.getGlobalInstance(), paramInt3);
    Object object = defaultJSONParser.parse();
    defaultJSONParser.handleResovleTask(object);
    defaultJSONParser.close();
    return object;
  }
  
  public static Object parse(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, Feature... paramVarArgs) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return null; 
    int j = DEFAULT_PARSER_FEATURE;
    int k = paramVarArgs.length;
    int i;
    for (i = 0; i < k; i++)
      j = Feature.config(j, paramVarArgs[i], true); 
    return parse(paramArrayOfbyte, paramInt1, paramInt2, paramCharsetDecoder, j);
  }
  
  public static Object parse(byte[] paramArrayOfbyte, Feature... paramVarArgs) {
    return parse(paramArrayOfbyte, 0, paramArrayOfbyte.length, IOUtils.getUTF8Decoder(), paramVarArgs);
  }
  
  public static JSONArray parseArray(String paramString) {
    JSONArray jSONArray;
    JSONLexer jSONLexer2 = null;
    if (paramString == null)
      return null; 
    DefaultJSONParser defaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance());
    JSONLexer jSONLexer1 = defaultJSONParser.lexer;
    if (jSONLexer1.token() == 8) {
      jSONLexer1.nextToken();
      jSONLexer1 = jSONLexer2;
    } else if (jSONLexer1.token() == 20) {
      jSONLexer1 = jSONLexer2;
    } else {
      jSONArray = new JSONArray();
      defaultJSONParser.parseArray(jSONArray);
      defaultJSONParser.handleResovleTask(jSONArray);
    } 
    defaultJSONParser.close();
    return jSONArray;
  }
  
  public static <T> List<T> parseArray(String paramString, Class<T> paramClass) {
    ArrayList<T> arrayList;
    JSONLexer jSONLexer2 = null;
    if (paramString == null)
      return null; 
    DefaultJSONParser defaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance());
    JSONLexer jSONLexer1 = defaultJSONParser.lexer;
    int i = jSONLexer1.token();
    if (i == 8) {
      jSONLexer1.nextToken();
      jSONLexer1 = jSONLexer2;
    } else if (i == 20 && jSONLexer1.isBlankInput()) {
      jSONLexer1 = jSONLexer2;
    } else {
      arrayList = new ArrayList();
      defaultJSONParser.parseArray(paramClass, arrayList);
      defaultJSONParser.handleResovleTask(arrayList);
    } 
    defaultJSONParser.close();
    return arrayList;
  }
  
  public static List<Object> parseArray(String paramString, Type[] paramArrayOfType) {
    List<Object> list;
    Object[] arrayOfObject2 = null;
    if (paramString == null)
      return null; 
    DefaultJSONParser defaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance());
    Object[] arrayOfObject1 = defaultJSONParser.parseArray(paramArrayOfType);
    if (arrayOfObject1 == null) {
      arrayOfObject1 = arrayOfObject2;
    } else {
      list = Arrays.asList(arrayOfObject1);
    } 
    defaultJSONParser.handleResovleTask(list);
    defaultJSONParser.close();
    return list;
  }
  
  public static JSONObject parseObject(String paramString) {
    Object object = parse(paramString);
    return (object instanceof JSONObject) ? (JSONObject)object : (JSONObject)toJSON(object);
  }
  
  public static JSONObject parseObject(String paramString, Feature... paramVarArgs) {
    return (JSONObject)parse(paramString, paramVarArgs);
  }
  
  public static <T> T parseObject(String paramString, TypeReference<T> paramTypeReference, Feature... paramVarArgs) {
    return parseObject(paramString, paramTypeReference.type, ParserConfig.global, DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static <T> T parseObject(String paramString, Class<T> paramClass) {
    return parseObject(paramString, paramClass, new Feature[0]);
  }
  
  public static <T> T parseObject(String paramString, Class<T> paramClass, ParseProcess paramParseProcess, Feature... paramVarArgs) {
    return parseObject(paramString, paramClass, ParserConfig.global, paramParseProcess, DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static <T> T parseObject(String paramString, Class<T> paramClass, Feature... paramVarArgs) {
    return parseObject(paramString, paramClass, ParserConfig.global, DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static <T> T parseObject(String paramString, Type paramType, int paramInt, Feature... paramVarArgs) {
    if (paramString == null)
      return null; 
    int j = paramVarArgs.length;
    boolean bool = false;
    int i = paramInt;
    for (paramInt = bool; paramInt < j; paramInt++)
      i = Feature.config(i, paramVarArgs[paramInt], true); 
    DefaultJSONParser defaultJSONParser = new DefaultJSONParser(paramString, ParserConfig.getGlobalInstance(), i);
    Object object = defaultJSONParser.parseObject(paramType);
    defaultJSONParser.handleResovleTask(object);
    defaultJSONParser.close();
    return (T)object;
  }
  
  public static <T> T parseObject(String paramString, Type paramType, ParserConfig paramParserConfig, int paramInt, Feature... paramVarArgs) {
    return parseObject(paramString, paramType, paramParserConfig, (ParseProcess)null, paramInt, paramVarArgs);
  }
  
  public static <T> T parseObject(String paramString, Type paramType, ParserConfig paramParserConfig, ParseProcess paramParseProcess, int paramInt, Feature... paramVarArgs) {
    if (paramString == null)
      return null; 
    int i = paramInt;
    if (paramVarArgs != null) {
      int k = paramVarArgs.length;
      int j = 0;
      while (true) {
        i = paramInt;
        if (j < k) {
          paramInt = Feature.config(paramInt, paramVarArgs[j], true);
          j++;
          continue;
        } 
        break;
      } 
    } 
    DefaultJSONParser defaultJSONParser = new DefaultJSONParser(paramString, paramParserConfig, i);
    if (paramParseProcess instanceof ExtraTypeProvider)
      defaultJSONParser.getExtraTypeProviders().add((ExtraTypeProvider)paramParseProcess); 
    if (paramParseProcess instanceof ExtraProcessor)
      defaultJSONParser.getExtraProcessors().add((ExtraProcessor)paramParseProcess); 
    if (paramParseProcess instanceof FieldTypeResolver)
      defaultJSONParser.setFieldTypeResolver((FieldTypeResolver)paramParseProcess); 
    Object object = defaultJSONParser.parseObject(paramType);
    defaultJSONParser.handleResovleTask(object);
    defaultJSONParser.close();
    return (T)object;
  }
  
  public static <T> T parseObject(String paramString, Type paramType, ParseProcess paramParseProcess, Feature... paramVarArgs) {
    return parseObject(paramString, paramType, ParserConfig.global, DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static <T> T parseObject(String paramString, Type paramType, Feature... paramVarArgs) {
    return parseObject(paramString, paramType, ParserConfig.global, DEFAULT_PARSER_FEATURE, paramVarArgs);
  }
  
  public static <T> T parseObject(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, CharsetDecoder paramCharsetDecoder, Type paramType, Feature... paramVarArgs) {
    paramCharsetDecoder.reset();
    char[] arrayOfChar = IOUtils.getChars((int)(paramInt2 * paramCharsetDecoder.maxCharsPerByte()));
    ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte, paramInt1, paramInt2);
    CharBuffer charBuffer = CharBuffer.wrap(arrayOfChar);
    IOUtils.decode(paramCharsetDecoder, byteBuffer, charBuffer);
    return parseObject(arrayOfChar, charBuffer.position(), paramType, paramVarArgs);
  }
  
  public static <T> T parseObject(byte[] paramArrayOfbyte, Type paramType, Feature... paramVarArgs) {
    return parseObject(paramArrayOfbyte, 0, paramArrayOfbyte.length, IOUtils.getUTF8Decoder(), paramType, paramVarArgs);
  }
  
  public static <T> T parseObject(char[] paramArrayOfchar, int paramInt, Type paramType, Feature... paramVarArgs) {
    if (paramArrayOfchar == null || paramArrayOfchar.length == 0)
      return null; 
    int j = DEFAULT_PARSER_FEATURE;
    int k = paramVarArgs.length;
    int i;
    for (i = 0; i < k; i++)
      j = Feature.config(j, paramVarArgs[i], true); 
    DefaultJSONParser defaultJSONParser = new DefaultJSONParser(paramArrayOfchar, paramInt, ParserConfig.getGlobalInstance(), j);
    Object object = defaultJSONParser.parseObject(paramType);
    defaultJSONParser.handleResovleTask(object);
    defaultJSONParser.close();
    return (T)object;
  }
  
  public static Object toJSON(Object paramObject) {
    return toJSON(paramObject, ParserConfig.getGlobalInstance());
  }
  
  public static Object toJSON(Object paramObject, ParserConfig paramParserConfig) {
    JSONArray jSONArray;
    if (paramObject == null)
      return null; 
    if (paramObject instanceof JSON)
      return paramObject; 
    if (paramObject instanceof Map) {
      Map map = (Map)paramObject;
      paramObject = new JSONObject(map.size());
      for (Map.Entry entry : map.entrySet())
        paramObject.put(TypeUtils.castToString(entry.getKey()), toJSON(entry.getValue())); 
      return paramObject;
    } 
    if (paramObject instanceof Collection) {
      Collection collection = (Collection)paramObject;
      paramObject = new JSONArray(collection.size());
      Iterator iterator = collection.iterator();
      while (iterator.hasNext())
        paramObject.add(toJSON(iterator.next())); 
      return paramObject;
    } 
    Class<?> clazz = paramObject.getClass();
    if (clazz.isEnum())
      return ((Enum)paramObject).name(); 
    boolean bool = clazz.isArray();
    int i = 0;
    if (bool) {
      int j = Array.getLength(paramObject);
      jSONArray = new JSONArray(j);
      while (i < j) {
        jSONArray.add(toJSON(Array.get(paramObject, i)));
        i++;
      } 
      return jSONArray;
    } 
    if (jSONArray.isPrimitive(clazz))
      return paramObject; 
    try {
      List list = TypeUtils.computeGetters(clazz, clazz.<JSONType>getAnnotation(JSONType.class), null, false);
      JSONObject jSONObject = new JSONObject(list.size());
      for (FieldInfo fieldInfo : list) {
        Object object = toJSON(fieldInfo.get(paramObject));
        jSONObject.put(fieldInfo.name, object);
      } 
      return jSONObject;
    } catch (IllegalAccessException illegalAccessException) {
      throw new JSONException("toJSON error", illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      throw new JSONException("toJSON error", invocationTargetException);
    } 
  }
  
  public static byte[] toJSONBytes(Object paramObject, SerializeConfig paramSerializeConfig, SerializerFeature... paramVarArgs) {
    SerializeWriter serializeWriter = new SerializeWriter();
    try {
      JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter, paramSerializeConfig);
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++)
        jSONSerializer.config(paramVarArgs[i], true); 
      jSONSerializer.write(paramObject);
      paramObject = serializeWriter.toBytes("UTF-8");
      return (byte[])paramObject;
    } finally {
      serializeWriter.close();
    } 
  }
  
  public static byte[] toJSONBytes(Object paramObject, SerializerFeature... paramVarArgs) {
    SerializeWriter serializeWriter = new SerializeWriter();
    try {
      JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter);
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++)
        jSONSerializer.config(paramVarArgs[i], true); 
      jSONSerializer.write(paramObject);
      paramObject = serializeWriter.toBytes("UTF-8");
      return (byte[])paramObject;
    } finally {
      serializeWriter.close();
    } 
  }
  
  public static String toJSONString(Object paramObject) {
    return toJSONString(paramObject, emptyFilters, new SerializerFeature[0]);
  }
  
  public static String toJSONString(Object paramObject, SerializeConfig paramSerializeConfig, SerializeFilter paramSerializeFilter, SerializerFeature... paramVarArgs) {
    int i = DEFAULT_GENERATE_FEATURE;
    return toJSONString(paramObject, paramSerializeConfig, new SerializeFilter[] { paramSerializeFilter }, null, i, paramVarArgs);
  }
  
  public static String toJSONString(Object paramObject, SerializeConfig paramSerializeConfig, SerializeFilter[] paramArrayOfSerializeFilter, String paramString, int paramInt, SerializerFeature... paramVarArgs) {
    SerializeWriter serializeWriter = new SerializeWriter(null, paramInt, paramVarArgs);
    try {
      JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter, paramSerializeConfig);
      int i = paramVarArgs.length;
      boolean bool = false;
      for (paramInt = 0; paramInt < i; paramInt++)
        jSONSerializer.config(paramVarArgs[paramInt], true); 
      if (paramString != null && paramString.length() != 0) {
        jSONSerializer.setDateFormat(paramString);
        jSONSerializer.config(SerializerFeature.WriteDateUseDateFormat, true);
      } 
      if (paramArrayOfSerializeFilter != null) {
        i = paramArrayOfSerializeFilter.length;
        for (paramInt = bool; paramInt < i; paramInt++)
          jSONSerializer.addFilter(paramArrayOfSerializeFilter[paramInt]); 
      } 
      jSONSerializer.write(paramObject);
      paramObject = serializeWriter.toString();
      return (String)paramObject;
    } finally {
      serializeWriter.close();
    } 
  }
  
  public static String toJSONString(Object paramObject, SerializeConfig paramSerializeConfig, SerializeFilter[] paramArrayOfSerializeFilter, SerializerFeature... paramVarArgs) {
    return toJSONString(paramObject, paramSerializeConfig, paramArrayOfSerializeFilter, null, DEFAULT_GENERATE_FEATURE, paramVarArgs);
  }
  
  public static String toJSONString(Object paramObject, SerializeConfig paramSerializeConfig, SerializerFeature... paramVarArgs) {
    return toJSONString(paramObject, paramSerializeConfig, (SerializeFilter)null, paramVarArgs);
  }
  
  public static String toJSONString(Object paramObject, SerializeFilter paramSerializeFilter, SerializerFeature... paramVarArgs) {
    SerializeConfig serializeConfig = SerializeConfig.globalInstance;
    int i = DEFAULT_GENERATE_FEATURE;
    return toJSONString(paramObject, serializeConfig, new SerializeFilter[] { paramSerializeFilter }, null, i, paramVarArgs);
  }
  
  public static String toJSONString(Object paramObject, boolean paramBoolean) {
    return !paramBoolean ? toJSONString(paramObject) : toJSONString(paramObject, new SerializerFeature[] { SerializerFeature.PrettyFormat });
  }
  
  public static String toJSONString(Object paramObject, SerializeFilter[] paramArrayOfSerializeFilter, SerializerFeature... paramVarArgs) {
    return toJSONString(paramObject, SerializeConfig.globalInstance, paramArrayOfSerializeFilter, null, DEFAULT_GENERATE_FEATURE, paramVarArgs);
  }
  
  public static String toJSONString(Object paramObject, SerializerFeature... paramVarArgs) {
    SerializeWriter serializeWriter = new SerializeWriter((Writer)null, DEFAULT_GENERATE_FEATURE, paramVarArgs);
    try {
      (new JSONSerializer(serializeWriter)).write(paramObject);
      paramObject = serializeWriter.toString();
      return (String)paramObject;
    } finally {
      serializeWriter.close();
    } 
  }
  
  public static String toJSONStringWithDateFormat(Object paramObject, String paramString, SerializerFeature... paramVarArgs) {
    return toJSONString(paramObject, SerializeConfig.globalInstance, null, paramString, DEFAULT_GENERATE_FEATURE, paramVarArgs);
  }
  
  public static String toJSONStringZ(Object paramObject, SerializeConfig paramSerializeConfig, SerializerFeature... paramVarArgs) {
    return toJSONString(paramObject, paramSerializeConfig, emptyFilters, null, 0, paramVarArgs);
  }
  
  public static <T> T toJavaObject(JSON paramJSON, Class<T> paramClass) {
    return (T)TypeUtils.cast(paramJSON, paramClass, ParserConfig.getGlobalInstance());
  }
  
  public static void writeJSONStringTo(Object paramObject, Writer paramWriter, SerializerFeature... paramVarArgs) {
    SerializeWriter serializeWriter = new SerializeWriter(paramWriter);
    try {
      JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter);
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++)
        jSONSerializer.config(paramVarArgs[i], true); 
      jSONSerializer.write(paramObject);
      return;
    } finally {
      serializeWriter.close();
    } 
  }
  
  public String toJSONString() {
    SerializeWriter serializeWriter = new SerializeWriter();
    try {
      (new JSONSerializer(serializeWriter)).write(this);
      return serializeWriter.toString();
    } finally {
      serializeWriter.close();
    } 
  }
  
  public <T> T toJavaObject(Class<T> paramClass) {
    return (T)TypeUtils.cast(this, paramClass, ParserConfig.getGlobalInstance());
  }
  
  public String toString() {
    return toJSONString();
  }
  
  public void writeJSONString(Appendable paramAppendable) {
    SerializeWriter serializeWriter = new SerializeWriter();
    try {
      (new JSONSerializer(serializeWriter)).write(this);
      paramAppendable.append(serializeWriter.toString());
      serializeWriter.close();
      return;
    } catch (IOException iOException) {
      throw new JSONException(iOException.getMessage(), iOException);
    } finally {}
    serializeWriter.close();
    throw paramAppendable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\JSON.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */