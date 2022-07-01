package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.FieldInfo;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class JSONSerializer {
  protected List<AfterFilter> afterFilters = null;
  
  protected List<BeforeFilter> beforeFilters = null;
  
  private final SerializeConfig config;
  
  protected SerialContext context;
  
  protected List<ContextValueFilter> contextValueFilters = null;
  
  private DateFormat dateFormat;
  
  private String dateFormatPattern;
  
  private String indent = "\t";
  
  private int indentCount = 0;
  
  protected List<LabelFilter> labelFilters = null;
  
  protected Locale locale = JSON.defaultLocale;
  
  protected List<NameFilter> nameFilters = null;
  
  public final SerializeWriter out;
  
  protected List<PropertyFilter> propertyFilters = null;
  
  protected List<PropertyPreFilter> propertyPreFilters = null;
  
  protected IdentityHashMap<Object, SerialContext> references = null;
  
  protected TimeZone timeZone = JSON.defaultTimeZone;
  
  protected List<ValueFilter> valueFilters = null;
  
  public JSONSerializer() {
    this(new SerializeWriter(), SerializeConfig.getGlobalInstance());
  }
  
  public JSONSerializer(SerializeConfig paramSerializeConfig) {
    this(new SerializeWriter(), paramSerializeConfig);
  }
  
  public JSONSerializer(SerializeWriter paramSerializeWriter) {
    this(paramSerializeWriter, SerializeConfig.getGlobalInstance());
  }
  
  public JSONSerializer(SerializeWriter paramSerializeWriter, SerializeConfig paramSerializeConfig) {
    this.out = paramSerializeWriter;
    this.config = paramSerializeConfig;
  }
  
  public static void write(SerializeWriter paramSerializeWriter, Object paramObject) {
    (new JSONSerializer(paramSerializeWriter)).write(paramObject);
  }
  
  public static void write(Writer paramWriter, Object paramObject) {
    SerializeWriter serializeWriter = new SerializeWriter();
    try {
      (new JSONSerializer(serializeWriter)).write(paramObject);
      serializeWriter.writeTo(paramWriter);
      serializeWriter.close();
      return;
    } catch (IOException iOException) {
      throw new JSONException(iOException.getMessage(), iOException);
    } finally {}
    serializeWriter.close();
    throw paramWriter;
  }
  
  public void addFilter(SerializeFilter paramSerializeFilter) {
    if (paramSerializeFilter == null)
      return; 
    if (paramSerializeFilter instanceof PropertyPreFilter)
      getPropertyPreFilters().add((PropertyPreFilter)paramSerializeFilter); 
    if (paramSerializeFilter instanceof NameFilter)
      getNameFilters().add((NameFilter)paramSerializeFilter); 
    if (paramSerializeFilter instanceof ValueFilter)
      getValueFilters().add((ValueFilter)paramSerializeFilter); 
    if (paramSerializeFilter instanceof ContextValueFilter)
      getContextValueFilters().add((ContextValueFilter)paramSerializeFilter); 
    if (paramSerializeFilter instanceof PropertyFilter)
      getPropertyFilters().add((PropertyFilter)paramSerializeFilter); 
    if (paramSerializeFilter instanceof BeforeFilter)
      getBeforeFilters().add((BeforeFilter)paramSerializeFilter); 
    if (paramSerializeFilter instanceof AfterFilter)
      getAfterFilters().add((AfterFilter)paramSerializeFilter); 
    if (paramSerializeFilter instanceof LabelFilter)
      getLabelFilters().add((LabelFilter)paramSerializeFilter); 
  }
  
  public boolean apply(Object paramObject1, String paramString, Object paramObject2) {
    List<PropertyFilter> list = this.propertyFilters;
    if (list == null)
      return true; 
    Iterator<PropertyFilter> iterator = list.iterator();
    while (iterator.hasNext()) {
      if (!((PropertyFilter)iterator.next()).apply(paramObject1, paramString, paramObject2))
        return false; 
    } 
    return true;
  }
  
  public boolean applyLabel(String paramString) {
    List<LabelFilter> list = this.labelFilters;
    if (list != null) {
      Iterator<LabelFilter> iterator = list.iterator();
      while (iterator.hasNext()) {
        if (!((LabelFilter)iterator.next()).apply(paramString))
          return false; 
      } 
    } 
    return true;
  }
  
  public boolean applyName(Object paramObject, String paramString) {
    List<PropertyPreFilter> list = this.propertyPreFilters;
    if (list == null)
      return true; 
    Iterator<PropertyPreFilter> iterator = list.iterator();
    while (iterator.hasNext()) {
      if (!((PropertyPreFilter)iterator.next()).apply(this, paramObject, paramString))
        return false; 
    } 
    return true;
  }
  
  public boolean checkValue() {
    List<ValueFilter> list = this.valueFilters;
    if (list == null || list.size() <= 0) {
      List<ContextValueFilter> list1 = this.contextValueFilters;
      if ((list1 == null || list1.size() <= 0) && !this.out.writeNonStringValueAsString)
        return false; 
    } 
    return true;
  }
  
  public void close() {
    this.out.close();
  }
  
  public void config(SerializerFeature paramSerializerFeature, boolean paramBoolean) {
    this.out.config(paramSerializerFeature, paramBoolean);
  }
  
  public boolean containsReference(Object paramObject) {
    IdentityHashMap<Object, SerialContext> identityHashMap = this.references;
    return (identityHashMap != null && identityHashMap.containsKey(paramObject));
  }
  
  public void decrementIdent() {
    this.indentCount--;
  }
  
  public List<AfterFilter> getAfterFilters() {
    if (this.afterFilters == null)
      this.afterFilters = new ArrayList<AfterFilter>(); 
    return this.afterFilters;
  }
  
  public List<BeforeFilter> getBeforeFilters() {
    if (this.beforeFilters == null)
      this.beforeFilters = new ArrayList<BeforeFilter>(); 
    return this.beforeFilters;
  }
  
  public SerialContext getContext() {
    return this.context;
  }
  
  public List<ContextValueFilter> getContextValueFilters() {
    if (this.contextValueFilters == null)
      this.contextValueFilters = new ArrayList<ContextValueFilter>(); 
    return this.contextValueFilters;
  }
  
  public DateFormat getDateFormat() {
    if (this.dateFormat == null) {
      String str = this.dateFormatPattern;
      if (str != null) {
        this.dateFormat = new SimpleDateFormat(str, this.locale);
        this.dateFormat.setTimeZone(this.timeZone);
      } 
    } 
    return this.dateFormat;
  }
  
  public String getDateFormatPattern() {
    DateFormat dateFormat = this.dateFormat;
    return (dateFormat instanceof SimpleDateFormat) ? ((SimpleDateFormat)dateFormat).toPattern() : this.dateFormatPattern;
  }
  
  public FieldInfo getFieldInfo() {
    return null;
  }
  
  public int getIndentCount() {
    return this.indentCount;
  }
  
  public List<LabelFilter> getLabelFilters() {
    if (this.labelFilters == null)
      this.labelFilters = new ArrayList<LabelFilter>(); 
    return this.labelFilters;
  }
  
  public SerializeConfig getMapping() {
    return this.config;
  }
  
  public List<NameFilter> getNameFilters() {
    if (this.nameFilters == null)
      this.nameFilters = new ArrayList<NameFilter>(); 
    return this.nameFilters;
  }
  
  public ObjectSerializer getObjectWriter(Class<?> paramClass) {
    return this.config.getObjectWriter(paramClass);
  }
  
  public List<PropertyFilter> getPropertyFilters() {
    if (this.propertyFilters == null)
      this.propertyFilters = new ArrayList<PropertyFilter>(); 
    return this.propertyFilters;
  }
  
  public List<PropertyPreFilter> getPropertyPreFilters() {
    if (this.propertyPreFilters == null)
      this.propertyPreFilters = new ArrayList<PropertyPreFilter>(); 
    return this.propertyPreFilters;
  }
  
  public List<ValueFilter> getValueFilters() {
    if (this.valueFilters == null)
      this.valueFilters = new ArrayList<ValueFilter>(); 
    return this.valueFilters;
  }
  
  public SerializeWriter getWriter() {
    return this.out;
  }
  
  public boolean hasNameFilters() {
    List<NameFilter> list = this.nameFilters;
    return (list != null && list.size() > 0);
  }
  
  public void incrementIndent() {
    this.indentCount++;
  }
  
  public boolean isEnabled(SerializerFeature paramSerializerFeature) {
    return this.out.isEnabled(paramSerializerFeature);
  }
  
  public final boolean isWriteClassName(Type paramType, Object paramObject) {
    return (this.out.isEnabled(SerializerFeature.WriteClassName) && (paramType != null || !this.out.isEnabled(SerializerFeature.NotWriteRootClassName) || this.context.parent != null));
  }
  
  public void popContext() {
    SerialContext serialContext = this.context;
    if (serialContext != null)
      this.context = serialContext.parent; 
  }
  
  public void println() {
    this.out.write(10);
    for (int i = 0; i < this.indentCount; i++)
      this.out.write(this.indent); 
  }
  
  public String processKey(Object paramObject1, String paramString, Object paramObject2) {
    List<NameFilter> list = this.nameFilters;
    String str = paramString;
    if (list != null) {
      Iterator<NameFilter> iterator = list.iterator();
      while (true) {
        str = paramString;
        if (iterator.hasNext()) {
          paramString = ((NameFilter)iterator.next()).process(paramObject1, paramString, paramObject2);
          continue;
        } 
        break;
      } 
    } 
    return str;
  }
  
  public Object processValue(JavaBeanSerializer paramJavaBeanSerializer, Object paramObject1, String paramString, Object paramObject2) {
    // Byte code:
    //   0: aload #4
    //   2: astore #5
    //   4: aload #4
    //   6: ifnull -> 50
    //   9: aload #4
    //   11: astore #5
    //   13: aload_0
    //   14: getfield out : Lcom/alibaba/fastjson/serializer/SerializeWriter;
    //   17: getfield writeNonStringValueAsString : Z
    //   20: ifeq -> 50
    //   23: aload #4
    //   25: instanceof java/lang/Number
    //   28: ifne -> 43
    //   31: aload #4
    //   33: astore #5
    //   35: aload #4
    //   37: instanceof java/lang/Boolean
    //   40: ifeq -> 50
    //   43: aload #4
    //   45: invokevirtual toString : ()Ljava/lang/String;
    //   48: astore #5
    //   50: aload_0
    //   51: getfield valueFilters : Ljava/util/List;
    //   54: astore #6
    //   56: aload #5
    //   58: astore #4
    //   60: aload #6
    //   62: ifnull -> 112
    //   65: aload #6
    //   67: invokeinterface iterator : ()Ljava/util/Iterator;
    //   72: astore #6
    //   74: aload #5
    //   76: astore #4
    //   78: aload #6
    //   80: invokeinterface hasNext : ()Z
    //   85: ifeq -> 112
    //   88: aload #6
    //   90: invokeinterface next : ()Ljava/lang/Object;
    //   95: checkcast com/alibaba/fastjson/serializer/ValueFilter
    //   98: aload_2
    //   99: aload_3
    //   100: aload #5
    //   102: invokeinterface process : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: astore #5
    //   109: goto -> 74
    //   112: aload_0
    //   113: getfield contextValueFilters : Ljava/util/List;
    //   116: astore #6
    //   118: aload #4
    //   120: astore #5
    //   122: aload #6
    //   124: ifnull -> 184
    //   127: aload_1
    //   128: aload_3
    //   129: invokevirtual getFieldSerializer : (Ljava/lang/String;)Lcom/alibaba/fastjson/serializer/FieldSerializer;
    //   132: getfield fieldContext : Lcom/alibaba/fastjson/serializer/BeanContext;
    //   135: astore_1
    //   136: aload #6
    //   138: invokeinterface iterator : ()Ljava/util/Iterator;
    //   143: astore #6
    //   145: aload #4
    //   147: astore #5
    //   149: aload #6
    //   151: invokeinterface hasNext : ()Z
    //   156: ifeq -> 184
    //   159: aload #6
    //   161: invokeinterface next : ()Ljava/lang/Object;
    //   166: checkcast com/alibaba/fastjson/serializer/ContextValueFilter
    //   169: aload_1
    //   170: aload_2
    //   171: aload_3
    //   172: aload #4
    //   174: invokeinterface process : (Lcom/alibaba/fastjson/serializer/BeanContext;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   179: astore #4
    //   181: goto -> 145
    //   184: aload #5
    //   186: areturn
  }
  
  public void setContext(SerialContext paramSerialContext) {
    this.context = paramSerialContext;
  }
  
  public void setContext(SerialContext paramSerialContext, Object paramObject1, Object paramObject2, int paramInt) {
    setContext(paramSerialContext, paramObject1, paramObject2, paramInt, 0);
  }
  
  public void setContext(SerialContext paramSerialContext, Object paramObject1, Object paramObject2, int paramInt1, int paramInt2) {
    if (this.out.disableCircularReferenceDetect)
      return; 
    this.context = new SerialContext(paramSerialContext, paramObject1, paramObject2, paramInt1, paramInt2);
    if (this.references == null)
      this.references = new IdentityHashMap<Object, SerialContext>(); 
    this.references.put(paramObject1, this.context);
  }
  
  public void setContext(Object paramObject1, Object paramObject2) {
    setContext(this.context, paramObject1, paramObject2, 0);
  }
  
  public void setDateFormat(String paramString) {
    this.dateFormatPattern = paramString;
    if (this.dateFormat != null)
      this.dateFormat = null; 
  }
  
  public void setDateFormat(DateFormat paramDateFormat) {
    this.dateFormat = paramDateFormat;
    if (this.dateFormatPattern != null)
      this.dateFormatPattern = null; 
  }
  
  public String toString() {
    return this.out.toString();
  }
  
  public final void write(Object paramObject) {
    if (paramObject == null) {
      this.out.writeNull();
      return;
    } 
    ObjectSerializer objectSerializer = getObjectWriter(paramObject.getClass());
    try {
      objectSerializer.write(this, paramObject, null, null, 0);
      return;
    } catch (IOException iOException) {
      throw new JSONException(iOException.getMessage(), iOException);
    } 
  }
  
  public final void write(String paramString) {
    StringCodec.instance.write(this, paramString);
  }
  
  public char writeAfter(Object paramObject, char paramChar) {
    List<AfterFilter> list = this.afterFilters;
    char c = paramChar;
    if (list != null) {
      Iterator<AfterFilter> iterator = list.iterator();
      while (true) {
        c = paramChar;
        if (iterator.hasNext()) {
          paramChar = ((AfterFilter)iterator.next()).writeAfter(this, paramObject, paramChar);
          continue;
        } 
        break;
      } 
    } 
    return c;
  }
  
  public char writeBefore(Object paramObject, char paramChar) {
    List<BeforeFilter> list = this.beforeFilters;
    char c = paramChar;
    if (list != null) {
      Iterator<BeforeFilter> iterator = list.iterator();
      while (true) {
        c = paramChar;
        if (iterator.hasNext()) {
          paramChar = ((BeforeFilter)iterator.next()).writeBefore(this, paramObject, paramChar);
          continue;
        } 
        break;
      } 
    } 
    return c;
  }
  
  public boolean writeDirect() {
    return (this.out.writeDirect && this.beforeFilters == null && this.afterFilters == null && this.valueFilters == null && this.contextValueFilters == null && this.propertyFilters == null && this.nameFilters == null && this.propertyPreFilters == null && this.labelFilters == null);
  }
  
  protected final void writeKeyValue(char paramChar, String paramString, Object paramObject) {
    if (paramChar != '\000')
      this.out.write(paramChar); 
    this.out.writeFieldName(paramString);
    write(paramObject);
  }
  
  public void writeNull() {
    this.out.writeNull();
  }
  
  public void writeReference(Object paramObject) {
    SerialContext serialContext2 = this.context;
    if (paramObject == serialContext2.object) {
      this.out.write("{\"$ref\":\"@\"}");
      return;
    } 
    SerialContext serialContext3 = serialContext2.parent;
    SerialContext serialContext1 = serialContext2;
    if (serialContext3 != null) {
      serialContext1 = serialContext2;
      if (paramObject == serialContext3.object) {
        this.out.write("{\"$ref\":\"..\"}");
        return;
      } 
    } 
    while (true) {
      if (serialContext1.parent == null) {
        if (paramObject == serialContext1.object) {
          this.out.write("{\"$ref\":\"$\"}");
          return;
        } 
        this.out.write("{\"$ref\":\"");
        this.out.write(((SerialContext)this.references.get(paramObject)).toString());
        this.out.write("\"}");
        return;
      } 
      serialContext1 = serialContext1.parent;
    } 
  }
  
  public final void writeWithFieldName(Object paramObject1, Object paramObject2) {
    writeWithFieldName(paramObject1, paramObject2, null, 0);
  }
  
  public final void writeWithFieldName(Object paramObject1, Object paramObject2, Type paramType, int paramInt) {
    if (paramObject1 == null)
      try {
        this.out.writeNull();
        return;
      } catch (IOException iOException) {
        throw new JSONException(iOException.getMessage(), iOException);
      }  
    getObjectWriter(iOException.getClass()).write(this, iOException, paramObject2, paramType, paramInt);
  }
  
  public final void writeWithFormat(Object paramObject, String paramString) {
    if (paramObject instanceof Date) {
      DateFormat dateFormat2 = getDateFormat();
      DateFormat dateFormat1 = dateFormat2;
      if (dateFormat2 == null) {
        dateFormat1 = new SimpleDateFormat(paramString, this.locale);
        dateFormat1.setTimeZone(this.timeZone);
      } 
      paramObject = dateFormat1.format((Date)paramObject);
      this.out.writeString((String)paramObject);
      return;
    } 
    write(paramObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\JSONSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */