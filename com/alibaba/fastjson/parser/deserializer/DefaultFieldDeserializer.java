package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Type;
import java.util.Map;

public class DefaultFieldDeserializer extends FieldDeserializer {
  private ObjectDeserializer fieldValueDeserilizer;
  
  public DefaultFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo) {
    super(paramClass, paramFieldInfo);
  }
  
  public int getFastMatchToken() {
    ObjectDeserializer objectDeserializer = this.fieldValueDeserilizer;
    return (objectDeserializer != null) ? objectDeserializer.getFastMatchToken() : 2;
  }
  
  public void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap) {
    if (this.fieldValueDeserilizer == null)
      this.fieldValueDeserilizer = paramDefaultJSONParser.getConfig().getDeserializer(this.fieldInfo); 
    if (paramType instanceof java.lang.reflect.ParameterizedType)
      (paramDefaultJSONParser.getContext()).type = paramType; 
    paramType = this.fieldValueDeserilizer.deserialze(paramDefaultJSONParser, this.fieldInfo.fieldType, this.fieldInfo.name);
    if (paramDefaultJSONParser.getResolveStatus() == 1) {
      paramObject = paramDefaultJSONParser.getLastResolveTask();
      ((DefaultJSONParser.ResolveTask)paramObject).fieldDeserializer = this;
      ((DefaultJSONParser.ResolveTask)paramObject).ownerContext = paramDefaultJSONParser.getContext();
      paramDefaultJSONParser.setResolveStatus(0);
      return;
    } 
    if (paramObject == null) {
      paramMap.put(this.fieldInfo.name, paramType);
      return;
    } 
    setValue(paramObject, paramType);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\DefaultFieldDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */