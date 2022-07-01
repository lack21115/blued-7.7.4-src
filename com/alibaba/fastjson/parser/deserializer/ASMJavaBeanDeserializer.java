package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import java.lang.reflect.Type;

public abstract class ASMJavaBeanDeserializer implements ObjectDeserializer {
  private JavaBeanDeserializer serializer;
  
  public ASMJavaBeanDeserializer(ParserConfig paramParserConfig, Class<?> paramClass) {
    this.serializer = new JavaBeanDeserializer(paramParserConfig, paramClass, paramClass);
  }
  
  public FieldDeserializer createFieldDeserializer(ParserConfig paramParserConfig, JavaBeanInfo paramJavaBeanInfo, FieldInfo paramFieldInfo) {
    return paramParserConfig.createFieldDeserializer(paramParserConfig, paramJavaBeanInfo, paramFieldInfo);
  }
  
  public Object createInstance(DefaultJSONParser paramDefaultJSONParser) {
    JavaBeanDeserializer javaBeanDeserializer = this.serializer;
    return javaBeanDeserializer.createInstance(paramDefaultJSONParser, javaBeanDeserializer.clazz);
  }
  
  public abstract Object createInstance(DefaultJSONParser paramDefaultJSONParser, Type paramType);
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    return this.serializer.deserialze(paramDefaultJSONParser, paramType, paramObject);
  }
  
  public <T> T deserialzeArrayMapping(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2) {
    return this.serializer.deserialzeArrayMapping(paramDefaultJSONParser, paramType, paramObject1, paramObject2);
  }
  
  public int getFastMatchToken() {
    return this.serializer.getFastMatchToken();
  }
  
  public FieldDeserializer getFieldDeserializer(String paramString) {
    return this.serializer.getFieldDeserializer(paramString);
  }
  
  public Type getFieldType(int paramInt) {
    return (this.serializer.sortedFieldDeserializers[paramInt]).fieldInfo.fieldType;
  }
  
  public JavaBeanDeserializer getInnterSerializer() {
    return this.serializer;
  }
  
  public boolean isSupportArrayToBean(JSONLexer paramJSONLexer) {
    return this.serializer.isSupportArrayToBean(paramJSONLexer);
  }
  
  public Object parseRest(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2) {
    return this.serializer.deserialze(paramDefaultJSONParser, paramType, paramObject1, paramObject2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\ASMJavaBeanDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */