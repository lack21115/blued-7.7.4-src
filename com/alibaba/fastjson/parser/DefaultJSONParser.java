package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ASMJavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DefaultJSONParser implements Closeable {
  public static final int NONE = 0;
  
  public static final int NeedToResolve = 1;
  
  public static final int TypeNameRedirect = 2;
  
  private static final Set<Class<?>> primitiveClasses = new HashSet<Class<?>>();
  
  protected ParserConfig config;
  
  protected ParseContext context;
  
  private ParseContext[] contextArray;
  
  private int contextArrayIndex = 0;
  
  private DateFormat dateFormat;
  
  private String dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
  
  private List<ExtraProcessor> extraProcessors = null;
  
  private List<ExtraTypeProvider> extraTypeProviders = null;
  
  protected FieldTypeResolver fieldTypeResolver = null;
  
  public final Object input;
  
  public final JSONLexer lexer;
  
  public int resolveStatus = 0;
  
  private List<ResolveTask> resolveTaskList;
  
  public final SymbolTable symbolTable;
  
  static {
    primitiveClasses.add(boolean.class);
    primitiveClasses.add(byte.class);
    primitiveClasses.add(short.class);
    primitiveClasses.add(int.class);
    primitiveClasses.add(long.class);
    primitiveClasses.add(float.class);
    primitiveClasses.add(double.class);
    primitiveClasses.add(Boolean.class);
    primitiveClasses.add(Byte.class);
    primitiveClasses.add(Short.class);
    primitiveClasses.add(Integer.class);
    primitiveClasses.add(Long.class);
    primitiveClasses.add(Float.class);
    primitiveClasses.add(Double.class);
    primitiveClasses.add(BigInteger.class);
    primitiveClasses.add(BigDecimal.class);
    primitiveClasses.add(String.class);
  }
  
  public DefaultJSONParser(JSONLexer paramJSONLexer) {
    this(paramJSONLexer, ParserConfig.getGlobalInstance());
  }
  
  public DefaultJSONParser(JSONLexer paramJSONLexer, ParserConfig paramParserConfig) {
    this((Object)null, paramJSONLexer, paramParserConfig);
  }
  
  public DefaultJSONParser(Object paramObject, JSONLexer paramJSONLexer, ParserConfig paramParserConfig) {
    this.lexer = paramJSONLexer;
    this.input = paramObject;
    this.config = paramParserConfig;
    this.symbolTable = paramParserConfig.symbolTable;
    paramJSONLexer.nextToken(12);
  }
  
  public DefaultJSONParser(String paramString) {
    this(paramString, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public DefaultJSONParser(String paramString, ParserConfig paramParserConfig) {
    this(paramString, new JSONScanner(paramString, JSON.DEFAULT_PARSER_FEATURE), paramParserConfig);
  }
  
  public DefaultJSONParser(String paramString, ParserConfig paramParserConfig, int paramInt) {
    this(paramString, new JSONScanner(paramString, paramInt), paramParserConfig);
  }
  
  public DefaultJSONParser(char[] paramArrayOfchar, int paramInt1, ParserConfig paramParserConfig, int paramInt2) {
    this(paramArrayOfchar, new JSONScanner(paramArrayOfchar, paramInt1, paramInt2), paramParserConfig);
  }
  
  private void addContext(ParseContext paramParseContext) {
    int i = this.contextArrayIndex;
    this.contextArrayIndex = i + 1;
    ParseContext[] arrayOfParseContext = this.contextArray;
    if (arrayOfParseContext == null) {
      this.contextArray = new ParseContext[8];
    } else if (i >= arrayOfParseContext.length) {
      ParseContext[] arrayOfParseContext1 = new ParseContext[arrayOfParseContext.length * 3 / 2];
      System.arraycopy(arrayOfParseContext, 0, arrayOfParseContext1, 0, arrayOfParseContext.length);
      this.contextArray = arrayOfParseContext1;
    } 
    this.contextArray[i] = paramParseContext;
  }
  
  public final void accept(int paramInt) {
    JSONLexer jSONLexer = this.lexer;
    if (jSONLexer.token() == paramInt) {
      jSONLexer.nextToken();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("syntax error, expect ");
    stringBuilder.append(JSONToken.name(paramInt));
    stringBuilder.append(", actual ");
    stringBuilder.append(JSONToken.name(jSONLexer.token()));
    throw new JSONException(stringBuilder.toString());
  }
  
  public final void accept(int paramInt1, int paramInt2) {
    JSONLexer jSONLexer = this.lexer;
    if (jSONLexer.token() == paramInt1) {
      jSONLexer.nextToken(paramInt2);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("syntax error, expect ");
    stringBuilder.append(JSONToken.name(paramInt1));
    stringBuilder.append(", actual ");
    stringBuilder.append(JSONToken.name(jSONLexer.token()));
    throw new JSONException(stringBuilder.toString());
  }
  
  public void acceptType(String paramString) {
    JSONLexer jSONLexer = this.lexer;
    jSONLexer.nextTokenWithColon();
    if (jSONLexer.token() == 4) {
      if (paramString.equals(jSONLexer.stringVal())) {
        jSONLexer.nextToken();
        if (jSONLexer.token() == 16)
          jSONLexer.nextToken(); 
        return;
      } 
      throw new JSONException("type not match error");
    } 
    throw new JSONException("type not match error");
  }
  
  public void addResolveTask(ResolveTask paramResolveTask) {
    if (this.resolveTaskList == null)
      this.resolveTaskList = new ArrayList<ResolveTask>(2); 
    this.resolveTaskList.add(paramResolveTask);
  }
  
  public void checkListResolve(Collection paramCollection) {
    if (this.resolveStatus == 1) {
      if (paramCollection instanceof List) {
        int i = paramCollection.size();
        paramCollection = paramCollection;
        ResolveTask resolveTask1 = getLastResolveTask();
        resolveTask1.fieldDeserializer = (FieldDeserializer)new ResolveFieldDeserializer(this, (List)paramCollection, i - 1);
        resolveTask1.ownerContext = this.context;
        setResolveStatus(0);
        return;
      } 
      ResolveTask resolveTask = getLastResolveTask();
      resolveTask.fieldDeserializer = (FieldDeserializer)new ResolveFieldDeserializer(paramCollection);
      resolveTask.ownerContext = this.context;
      setResolveStatus(0);
    } 
  }
  
  public void checkMapResolve(Map paramMap, Object paramObject) {
    if (this.resolveStatus == 1) {
      ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(paramMap, paramObject);
      paramObject = getLastResolveTask();
      ((ResolveTask)paramObject).fieldDeserializer = (FieldDeserializer)resolveFieldDeserializer;
      ((ResolveTask)paramObject).ownerContext = this.context;
      setResolveStatus(0);
    } 
  }
  
  public void close() {
    JSONLexer jSONLexer = this.lexer;
    try {
      if (!jSONLexer.isEnabled(Feature.AutoCloseSource) || jSONLexer.token() == 20)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("not close json text, token : ");
      stringBuilder.append(JSONToken.name(jSONLexer.token()));
      throw new JSONException(stringBuilder.toString());
    } finally {
      jSONLexer.close();
    } 
  }
  
  public void config(Feature paramFeature, boolean paramBoolean) {
    this.lexer.config(paramFeature, paramBoolean);
  }
  
  public ParserConfig getConfig() {
    return this.config;
  }
  
  public ParseContext getContext() {
    return this.context;
  }
  
  public String getDateFomartPattern() {
    return this.dateFormatPattern;
  }
  
  public DateFormat getDateFormat() {
    if (this.dateFormat == null) {
      this.dateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
      this.dateFormat.setTimeZone(this.lexer.getTimeZone());
    } 
    return this.dateFormat;
  }
  
  public List<ExtraProcessor> getExtraProcessors() {
    if (this.extraProcessors == null)
      this.extraProcessors = new ArrayList<ExtraProcessor>(2); 
    return this.extraProcessors;
  }
  
  public List<ExtraTypeProvider> getExtraTypeProviders() {
    if (this.extraTypeProviders == null)
      this.extraTypeProviders = new ArrayList<ExtraTypeProvider>(2); 
    return this.extraTypeProviders;
  }
  
  public FieldTypeResolver getFieldTypeResolver() {
    return this.fieldTypeResolver;
  }
  
  public String getInput() {
    Object object = this.input;
    return (object instanceof char[]) ? new String((char[])object) : object.toString();
  }
  
  public ResolveTask getLastResolveTask() {
    List<ResolveTask> list = this.resolveTaskList;
    return list.get(list.size() - 1);
  }
  
  public JSONLexer getLexer() {
    return this.lexer;
  }
  
  public Object getObject(String paramString) {
    for (int i = 0; i < this.contextArrayIndex; i++) {
      if (paramString.equals(this.contextArray[i].toString()))
        return (this.contextArray[i]).object; 
    } 
    return null;
  }
  
  public int getResolveStatus() {
    return this.resolveStatus;
  }
  
  public List<ResolveTask> getResolveTaskList() {
    if (this.resolveTaskList == null)
      this.resolveTaskList = new ArrayList<ResolveTask>(2); 
    return this.resolveTaskList;
  }
  
  public SymbolTable getSymbolTable() {
    return this.symbolTable;
  }
  
  public void handleResovleTask(Object<ResolveTask> paramObject) {
    paramObject = (Object<ResolveTask>)this.resolveTaskList;
    if (paramObject == null)
      return; 
    int j = paramObject.size();
    for (int i = 0; i < j; i++) {
      ResolveTask resolveTask = this.resolveTaskList.get(i);
      Object object = resolveTask.referenceValue;
      paramObject = null;
      if (resolveTask.ownerContext != null)
        paramObject = (Object<ResolveTask>)resolveTask.ownerContext.object; 
      if (object.startsWith("$")) {
        Object object1 = getObject((String)object);
      } else {
        object = resolveTask.context.object;
      } 
      FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
      if (fieldDeserializer != null)
        fieldDeserializer.setValue(paramObject, object); 
    } 
  }
  
  public boolean isEnabled(Feature paramFeature) {
    return this.lexer.isEnabled(paramFeature);
  }
  
  public Object parse() {
    return parse(null);
  }
  
  public Object parse(Object paramObject) {
    JSONLexer jSONLexer = this.lexer;
    int i = jSONLexer.token();
    if (i != 2) {
      if (i != 3) {
        HashSet hashSet;
        if (i != 4) {
          if (i != 12) {
            if (i != 14) {
              TreeSet treeSet;
              switch (i) {
                default:
                  switch (i) {
                    default:
                      paramObject = new StringBuilder();
                      paramObject.append("syntax error, pos ");
                      paramObject.append(jSONLexer.getBufferPosition());
                      throw new JSONException(paramObject.toString());
                    case 23:
                      jSONLexer.nextToken();
                      return null;
                    case 22:
                      jSONLexer.nextToken();
                      treeSet = new TreeSet();
                      parseArray(treeSet, paramObject);
                      return treeSet;
                    case 21:
                      treeSet.nextToken();
                      hashSet = new HashSet();
                      parseArray(hashSet, paramObject);
                      return hashSet;
                    case 20:
                      break;
                  } 
                  if (hashSet.isBlankInput())
                    return null; 
                  paramObject = new StringBuilder();
                  paramObject.append("unterminated json string, pos ");
                  paramObject.append(hashSet.getBufferPosition());
                  throw new JSONException(paramObject.toString());
                case 9:
                  hashSet.nextToken(18);
                  if (hashSet.token() == 18) {
                    hashSet.nextToken(10);
                    accept(10);
                    long l = hashSet.integerValue().longValue();
                    accept(2);
                    accept(11);
                    return new Date(l);
                  } 
                  throw new JSONException("syntax error");
                case 8:
                  hashSet.nextToken();
                  return null;
                case 7:
                  hashSet.nextToken();
                  return Boolean.FALSE;
                case 6:
                  break;
              } 
              hashSet.nextToken();
              return Boolean.TRUE;
            } 
            JSONArray jSONArray = new JSONArray();
            parseArray((Collection)jSONArray, paramObject);
            return hashSet.isEnabled(Feature.UseObjectArray) ? jSONArray.toArray() : jSONArray;
          } 
          return parseObject((Map)new JSONObject(hashSet.isEnabled(Feature.OrderedField)), paramObject);
        } 
        String str = hashSet.stringVal();
        hashSet.nextToken(16);
        if (hashSet.isEnabled(Feature.AllowISO8601DateFormat)) {
          paramObject = new JSONScanner(str);
          try {
            if (paramObject.scanISO8601DateIfMatch())
              return paramObject.getCalendar().getTime(); 
            return str;
          } finally {
            paramObject.close();
          } 
        } 
        return str;
      } 
      paramObject = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
      jSONLexer.nextToken();
      return paramObject;
    } 
    paramObject = jSONLexer.integerValue();
    jSONLexer.nextToken();
    return paramObject;
  }
  
  public <T> List<T> parseArray(Class<T> paramClass) {
    ArrayList<T> arrayList = new ArrayList();
    parseArray(paramClass, arrayList);
    return arrayList;
  }
  
  public void parseArray(Class<?> paramClass, Collection paramCollection) {
    parseArray(paramClass, paramCollection);
  }
  
  public void parseArray(Type paramType, Collection paramCollection) {
    parseArray(paramType, paramCollection, null);
  }
  
  public void parseArray(Type paramType, Collection<Object> paramCollection, Object paramObject) {
    if (this.lexer.token() == 21 || this.lexer.token() == 22)
      this.lexer.nextToken(); 
    if (this.lexer.token() == 14) {
      ObjectDeserializer objectDeserializer;
      if (int.class == paramType) {
        IntegerCodec integerCodec = IntegerCodec.instance;
        this.lexer.nextToken(2);
      } else if (String.class == paramType) {
        StringCodec stringCodec = StringCodec.instance;
        this.lexer.nextToken(4);
      } else {
        objectDeserializer = this.config.getDeserializer(paramType);
        this.lexer.nextToken(objectDeserializer.getFastMatchToken());
      } 
      ParseContext parseContext = this.context;
      setContext(paramCollection, paramObject);
      int i = 0;
      try {
        while (true) {
          if (this.lexer.isEnabled(Feature.AllowArbitraryCommas))
            while (this.lexer.token() == 16)
              this.lexer.nextToken();  
          int j = this.lexer.token();
          if (j == 15) {
            setContext(parseContext);
            return;
          } 
          Class<int> clazz = int.class;
          Object object = null;
          paramObject = null;
          if (clazz == paramType) {
            paramCollection.add(IntegerCodec.instance.deserialze(this, null, null));
          } else if (String.class == paramType) {
            if (this.lexer.token() == 4) {
              paramObject = this.lexer.stringVal();
              this.lexer.nextToken(16);
            } else {
              object = parse();
              if (object != null)
                paramObject = object.toString(); 
            } 
            paramCollection.add(paramObject);
          } else {
            if (this.lexer.token() == 8) {
              this.lexer.nextToken();
              paramObject = object;
            } else {
              paramObject = objectDeserializer.deserialze(this, paramType, Integer.valueOf(i));
            } 
            paramCollection.add(paramObject);
            checkListResolve(paramCollection);
          } 
          if (this.lexer.token() == 16)
            this.lexer.nextToken(objectDeserializer.getFastMatchToken()); 
          i++;
        } 
      } finally {
        setContext(parseContext);
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("exepct '[', but ");
    stringBuilder.append(JSONToken.name(this.lexer.token()));
    stringBuilder.append(", ");
    stringBuilder.append(this.lexer.info());
    throw new JSONException(stringBuilder.toString());
  }
  
  public final void parseArray(Collection paramCollection) {
    parseArray(paramCollection, (Object)null);
  }
  
  public final void parseArray(Collection<Object> paramCollection, Object paramObject) {
    JSONLexer jSONLexer = this.lexer;
    if (jSONLexer.token() == 21 || jSONLexer.token() == 22)
      jSONLexer.nextToken(); 
    if (jSONLexer.token() == 14) {
      jSONLexer.nextToken(4);
      ParseContext parseContext = this.context;
      setContext(paramCollection, paramObject);
      int i = 0;
      try {
        while (true) {
          if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas))
            while (jSONLexer.token() == 16)
              jSONLexer.nextToken();  
          int j = jSONLexer.token();
          paramObject = null;
          if (j != 2) {
            if (j != 3) {
              if (j != 4) {
                if (j != 6) {
                  if (j != 7) {
                    if (j != 8) {
                      if (j != 12) {
                        if (j != 20) {
                          if (j != 23) {
                            if (j != 14) {
                              if (j != 15) {
                                paramObject = parse();
                              } else {
                                jSONLexer.nextToken(16);
                                return;
                              } 
                            } else {
                              JSONArray jSONArray = new JSONArray();
                              parseArray((Collection)jSONArray, Integer.valueOf(i));
                              paramObject = jSONArray;
                              if (jSONLexer.isEnabled(Feature.UseObjectArray))
                                paramObject = jSONArray.toArray(); 
                            } 
                          } else {
                            jSONLexer.nextToken(4);
                          } 
                        } else {
                          throw new JSONException("unclosed jsonArray");
                        } 
                      } else {
                        paramObject = parseObject((Map)new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), Integer.valueOf(i));
                      } 
                    } else {
                      jSONLexer.nextToken(4);
                    } 
                  } else {
                    paramObject = Boolean.FALSE;
                    jSONLexer.nextToken(16);
                  } 
                } else {
                  paramObject = Boolean.TRUE;
                  jSONLexer.nextToken(16);
                } 
              } else {
                String str = jSONLexer.stringVal();
                jSONLexer.nextToken(16);
                paramObject = str;
                if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                  JSONScanner jSONScanner = new JSONScanner(str);
                  paramObject = str;
                  if (jSONScanner.scanISO8601DateIfMatch())
                    paramObject = jSONScanner.getCalendar().getTime(); 
                  jSONScanner.close();
                } 
              } 
            } else {
              if (jSONLexer.isEnabled(Feature.UseBigDecimal)) {
                paramObject = jSONLexer.decimalValue(true);
              } else {
                paramObject = jSONLexer.decimalValue(false);
              } 
              jSONLexer.nextToken(16);
            } 
          } else {
            paramObject = jSONLexer.integerValue();
            jSONLexer.nextToken(16);
          } 
          paramCollection.add(paramObject);
          checkListResolve(paramCollection);
          if (jSONLexer.token() == 16)
            jSONLexer.nextToken(4); 
          i++;
        } 
      } finally {
        setContext(parseContext);
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("syntax error, expect [, actual ");
    stringBuilder.append(JSONToken.name(jSONLexer.token()));
    stringBuilder.append(", pos ");
    stringBuilder.append(jSONLexer.pos());
    throw new JSONException(stringBuilder.toString());
  }
  
  public Object[] parseArray(Type[] paramArrayOfType) {
    if (this.lexer.token() == 8) {
      this.lexer.nextToken(16);
      return null;
    } 
    if (this.lexer.token() == 14) {
      Object[] arrayOfObject = new Object[paramArrayOfType.length];
      if (paramArrayOfType.length == 0) {
        this.lexer.nextToken(15);
        if (this.lexer.token() == 15) {
          this.lexer.nextToken(16);
          return new Object[0];
        } 
        throw new JSONException("syntax error");
      } 
      this.lexer.nextToken(2);
      int i = 0;
      while (i < paramArrayOfType.length) {
        Object object;
        if (this.lexer.token() == 8) {
          this.lexer.nextToken(16);
          object = null;
        } else {
          Type type = paramArrayOfType[i];
          if (type == int.class || type == Integer.class) {
            if (this.lexer.token() == 2) {
              object = Integer.valueOf(this.lexer.intValue());
              this.lexer.nextToken(16);
            } else {
              object = TypeUtils.cast(parse(), type, this.config);
            } 
          } else if (type == String.class) {
            if (this.lexer.token() == 4) {
              object = this.lexer.stringVal();
              this.lexer.nextToken(16);
            } else {
              object = TypeUtils.cast(parse(), type, this.config);
            } 
          } else {
            boolean bool;
            if (i == paramArrayOfType.length - 1 && type instanceof Class) {
              object = type;
              bool = object.isArray();
              object = object.getComponentType();
            } else {
              object = null;
              bool = false;
            } 
            if (bool && this.lexer.token() != 14) {
              ArrayList<Object> arrayList = new ArrayList();
              object = this.config.getDeserializer((Type)object);
              int j = object.getFastMatchToken();
              if (this.lexer.token() != 15)
                while (true) {
                  arrayList.add(object.deserialze(this, type, null));
                  if (this.lexer.token() == 16) {
                    this.lexer.nextToken(j);
                    continue;
                  } 
                  if (this.lexer.token() == 15)
                    break; 
                  stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("syntax error :");
                  stringBuilder1.append(JSONToken.name(this.lexer.token()));
                  throw new JSONException(stringBuilder1.toString());
                }  
              Object object1 = TypeUtils.cast(arrayList, type, this.config);
            } else {
              object = this.config.getDeserializer(type).deserialze(this, type, null);
            } 
          } 
        } 
        arrayOfObject[i] = object;
        if (this.lexer.token() == 15)
          break; 
        if (this.lexer.token() == 16) {
          if (i == stringBuilder1.length - 1) {
            this.lexer.nextToken(15);
          } else {
            this.lexer.nextToken(2);
          } 
          i++;
          continue;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("syntax error :");
        stringBuilder1.append(JSONToken.name(this.lexer.token()));
        throw new JSONException(stringBuilder1.toString());
      } 
      if (this.lexer.token() == 15) {
        this.lexer.nextToken(16);
        return arrayOfObject;
      } 
      throw new JSONException("syntax error");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("syntax error : ");
    stringBuilder.append(this.lexer.tokenName());
    throw new JSONException(stringBuilder.toString());
  }
  
  public Object parseArrayWithType(Type paramType) {
    ParameterizedType parameterizedType;
    if (this.lexer.token() == 8) {
      this.lexer.nextToken();
      return null;
    } 
    Type[] arrayOfType = ((ParameterizedType)paramType).getActualTypeArguments();
    if (arrayOfType.length == 1) {
      ArrayList arrayList;
      Type type = arrayOfType[0];
      if (type instanceof Class) {
        arrayList = new ArrayList();
        parseArray((Class)type, arrayList);
        return arrayList;
      } 
      if (type instanceof WildcardType) {
        WildcardType wildcardType = (WildcardType)type;
        type = wildcardType.getUpperBounds()[0];
        if (Object.class.equals(type)) {
          if ((wildcardType.getLowerBounds()).length == 0)
            return parse(); 
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("not support type : ");
          stringBuilder1.append(arrayList);
          throw new JSONException(stringBuilder1.toString());
        } 
        arrayList = new ArrayList();
        parseArray((Class)stringBuilder1, arrayList);
        return arrayList;
      } 
      if (stringBuilder1 instanceof TypeVariable) {
        Type type1 = (TypeVariable)stringBuilder1;
        Type[] arrayOfType1 = type1.getBounds();
        if (arrayOfType1.length == 1) {
          type1 = arrayOfType1[0];
          if (type1 instanceof Class) {
            arrayList = new ArrayList();
            parseArray((Class)type1, arrayList);
            return arrayList;
          } 
        } else {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("not support : ");
          stringBuilder2.append(type1);
          throw new JSONException(stringBuilder2.toString());
        } 
      } 
      if (stringBuilder1 instanceof ParameterizedType) {
        parameterizedType = (ParameterizedType)stringBuilder1;
        ArrayList arrayList1 = new ArrayList();
        parseArray(parameterizedType, arrayList1);
        return arrayList1;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("TODO : ");
      stringBuilder1.append(parameterizedType);
      throw new JSONException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("not support type ");
    stringBuilder.append(parameterizedType);
    throw new JSONException(stringBuilder.toString());
  }
  
  public void parseExtra(Object paramObject, String paramString) {
    this.lexer.nextTokenWithColon();
    List<ExtraTypeProvider> list1 = this.extraTypeProviders;
    Object object = null;
    Type type = null;
    if (list1 != null) {
      Iterator<ExtraTypeProvider> iterator = list1.iterator();
      for (object = type; iterator.hasNext(); object = ((ExtraTypeProvider)iterator.next()).getExtraType(paramObject, paramString));
    } 
    if (object == null) {
      object = parse();
    } else {
      object = parseObject((Type)object);
    } 
    if (paramObject instanceof ExtraProcessable) {
      ((ExtraProcessable)paramObject).processExtra(paramString, object);
      return;
    } 
    List<ExtraProcessor> list = this.extraProcessors;
    if (list != null) {
      Iterator<ExtraProcessor> iterator = list.iterator();
      while (iterator.hasNext())
        ((ExtraProcessor)iterator.next()).processExtra(paramObject, paramString, object); 
    } 
  }
  
  public Object parseKey() {
    if (this.lexer.token() == 18) {
      String str = this.lexer.stringVal();
      this.lexer.nextToken(16);
      return str;
    } 
    return parse(null);
  }
  
  public JSONObject parseObject() {
    return (JSONObject)parseObject((Map)new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
  }
  
  public <T> T parseObject(Class<T> paramClass) {
    return parseObject(paramClass, (Object)null);
  }
  
  public <T> T parseObject(Type paramType) {
    return parseObject(paramType, (Object)null);
  }
  
  public <T> T parseObject(Type paramType, Object paramObject) {
    byte[] arrayOfByte;
    if (this.lexer.token() == 8) {
      this.lexer.nextToken();
      return null;
    } 
    Type type = paramType;
    if (this.lexer.token() == 4) {
      byte[] arrayOfByte1;
      paramType = TypeUtils.unwrap(paramType);
      if (paramType == byte[].class) {
        arrayOfByte1 = this.lexer.bytesValue();
        this.lexer.nextToken();
        return (T)arrayOfByte1;
      } 
      arrayOfByte = arrayOfByte1;
      if (arrayOfByte1 == char[].class) {
        String str = this.lexer.stringVal();
        this.lexer.nextToken();
        return (T)str.toCharArray();
      } 
    } 
    ObjectDeserializer objectDeserializer = this.config.getDeserializer((Type)arrayOfByte);
    try {
      return (T)objectDeserializer.deserialze(this, (Type)arrayOfByte, paramObject);
    } catch (JSONException jSONException) {
      throw jSONException;
    } finally {
      objectDeserializer = null;
    } 
  }
  
  public Object parseObject(Map paramMap) {
    return parseObject(paramMap, (Object)null);
  }
  
  public final Object parseObject(Map paramMap, Object paramObject) {
    JSONLexer jSONLexer = this.lexer;
    if (jSONLexer.token() == 8) {
      jSONLexer.nextToken();
      return null;
    } 
    if (jSONLexer.token() == 13) {
      jSONLexer.nextToken();
      return paramMap;
    } 
    if (jSONLexer.token() == 12 || jSONLexer.token() == 16) {
      Object object = this.context;
      boolean bool = false;
      while (true) {
        String str1;
        Object object1 = object;
        try {
          jSONLexer.skipWhitespace();
          object1 = object;
          char c = jSONLexer.getCurrent();
          char c1 = c;
          object1 = object;
          if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas))
            while (true) {
              c1 = c;
              if (c == ',') {
                object1 = object;
                jSONLexer.next();
                object1 = object;
                jSONLexer.skipWhitespace();
                object1 = object;
                c = jSONLexer.getCurrent();
                continue;
              } 
              break;
            }  
          boolean bool2 = true;
        } finally {
          setContext((ParseContext)object1);
        } 
        boolean bool1 = false;
        String str2 = str1;
        object = SYNTHETIC_LOCAL_VARIABLE_9;
        object1 = SYNTHETIC_LOCAL_VARIABLE_5;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("syntax error, expect {, actual ");
    stringBuilder.append(jSONLexer.tokenName());
    stringBuilder.append(", ");
    stringBuilder.append(jSONLexer.info());
    throw new JSONException(stringBuilder.toString());
  }
  
  public void parseObject(Object paramObject) {
    JavaBeanDeserializer javaBeanDeserializer;
    Class<?> clazz = paramObject.getClass();
    ObjectDeserializer objectDeserializer = this.config.getDeserializer(clazz);
    if (objectDeserializer instanceof JavaBeanDeserializer) {
      javaBeanDeserializer = (JavaBeanDeserializer)objectDeserializer;
    } else if (objectDeserializer instanceof ASMJavaBeanDeserializer) {
      javaBeanDeserializer = ((ASMJavaBeanDeserializer)objectDeserializer).getInnterSerializer();
    } else {
      javaBeanDeserializer = null;
    } 
    if (this.lexer.token() == 12 || this.lexer.token() == 16)
      while (true) {
        FieldDeserializer fieldDeserializer;
        String str = this.lexer.scanSymbol(this.symbolTable);
        if (str == null) {
          if (this.lexer.token() == 13) {
            this.lexer.nextToken(16);
            return;
          } 
          if (this.lexer.token() == 16 && this.lexer.isEnabled(Feature.AllowArbitraryCommas))
            continue; 
        } 
        if (javaBeanDeserializer != null) {
          fieldDeserializer = javaBeanDeserializer.getFieldDeserializer(str);
        } else {
          fieldDeserializer = null;
        } 
        if (fieldDeserializer == null) {
          if (this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
            this.lexer.nextTokenWithColon();
            parse();
            if (this.lexer.token() == 13) {
              this.lexer.nextToken();
              return;
            } 
            continue;
          } 
          paramObject = new StringBuilder();
          paramObject.append("setter not found, class ");
          paramObject.append(clazz.getName());
          paramObject.append(", property ");
          paramObject.append(str);
          throw new JSONException(paramObject.toString());
        } 
        Class<int> clazz1 = fieldDeserializer.fieldInfo.fieldClass;
        Object object = fieldDeserializer.fieldInfo.fieldType;
        if (clazz1 == int.class) {
          this.lexer.nextTokenWithColon(2);
          Object object1 = IntegerCodec.instance.deserialze(this, (Type)object, null);
        } else if (clazz1 == String.class) {
          this.lexer.nextTokenWithColon(4);
          object = StringCodec.deserialze(this);
        } else if (clazz1 == long.class) {
          this.lexer.nextTokenWithColon(2);
          object = LongCodec.instance.deserialze(this, (Type)object, null);
        } else {
          ObjectDeserializer objectDeserializer1 = this.config.getDeserializer(clazz1, (Type)object);
          this.lexer.nextTokenWithColon(objectDeserializer1.getFastMatchToken());
          object = objectDeserializer1.deserialze(this, (Type)object, null);
        } 
        fieldDeserializer.setValue(paramObject, object);
        if (this.lexer.token() != 16 && this.lexer.token() == 13) {
          this.lexer.nextToken(16);
          return;
        } 
      }  
    paramObject = new StringBuilder();
    paramObject.append("syntax error, expect {, actual ");
    paramObject.append(this.lexer.tokenName());
    throw new JSONException(paramObject.toString());
  }
  
  public void popContext() {
    if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect))
      return; 
    this.context = this.context.parent;
    ParseContext[] arrayOfParseContext = this.contextArray;
    int i = this.contextArrayIndex;
    arrayOfParseContext[i - 1] = null;
    this.contextArrayIndex = i - 1;
  }
  
  public void setConfig(ParserConfig paramParserConfig) {
    this.config = paramParserConfig;
  }
  
  public ParseContext setContext(ParseContext paramParseContext, Object paramObject1, Object paramObject2) {
    if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect))
      return null; 
    this.context = new ParseContext(paramParseContext, paramObject1, paramObject2);
    addContext(this.context);
    return this.context;
  }
  
  public ParseContext setContext(Object paramObject1, Object paramObject2) {
    return this.lexer.isEnabled(Feature.DisableCircularReferenceDetect) ? null : setContext(this.context, paramObject1, paramObject2);
  }
  
  public void setContext(ParseContext paramParseContext) {
    if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect))
      return; 
    this.context = paramParseContext;
  }
  
  public void setDateFomrat(DateFormat paramDateFormat) {
    this.dateFormat = paramDateFormat;
  }
  
  public void setDateFormat(String paramString) {
    this.dateFormatPattern = paramString;
    this.dateFormat = null;
  }
  
  public void setFieldTypeResolver(FieldTypeResolver paramFieldTypeResolver) {
    this.fieldTypeResolver = paramFieldTypeResolver;
  }
  
  public void setResolveStatus(int paramInt) {
    this.resolveStatus = paramInt;
  }
  
  public static class ResolveTask {
    private final ParseContext context;
    
    public FieldDeserializer fieldDeserializer;
    
    public ParseContext ownerContext;
    
    private final String referenceValue;
    
    public ResolveTask(ParseContext param1ParseContext, String param1String) {
      this.context = param1ParseContext;
      this.referenceValue = param1String;
    }
    
    public ParseContext getContext() {
      return this.context;
    }
    
    public FieldDeserializer getFieldDeserializer() {
      return this.fieldDeserializer;
    }
    
    public ParseContext getOwnerContext() {
      return this.ownerContext;
    }
    
    public String getReferenceValue() {
      return this.referenceValue;
    }
    
    public void setFieldDeserializer(FieldDeserializer param1FieldDeserializer) {
      this.fieldDeserializer = param1FieldDeserializer;
    }
    
    public void setOwnerContext(ParseContext param1ParseContext) {
      this.ownerContext = param1ParseContext;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\DefaultJSONParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */