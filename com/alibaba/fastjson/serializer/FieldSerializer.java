package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.util.FieldInfo;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Collection;

public class FieldSerializer implements Comparable<FieldSerializer> {
  private final String double_quoted_fieldPrefix;
  
  protected int features;
  
  protected BeanContext fieldContext;
  
  public final FieldInfo fieldInfo;
  
  private String format;
  
  private RuntimeSerializerInfo runtimeInfo;
  
  private String single_quoted_fieldPrefix;
  
  private String un_quoted_fieldPrefix;
  
  protected boolean writeEnumUsingName;
  
  protected boolean writeEnumUsingToString;
  
  protected final boolean writeNull;
  
  protected boolean writeNullBooleanAsFalse;
  
  protected boolean writeNullListAsEmpty;
  
  protected boolean writeNullStringAsEmpty;
  
  protected boolean writeNumberAsZero;
  
  public FieldSerializer(Class<?> paramClass, FieldInfo paramFieldInfo) {
    boolean bool2;
    boolean bool1 = false;
    this.writeNumberAsZero = false;
    this.writeNullStringAsEmpty = false;
    this.writeNullBooleanAsFalse = false;
    this.writeNullListAsEmpty = false;
    this.writeEnumUsingToString = false;
    this.writeEnumUsingName = false;
    this.fieldInfo = paramFieldInfo;
    this.fieldContext = new BeanContext(paramClass, paramFieldInfo);
    paramFieldInfo.setAccessible();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('"');
    stringBuilder.append(paramFieldInfo.name);
    stringBuilder.append("\":");
    this.double_quoted_fieldPrefix = stringBuilder.toString();
    JSONField jSONField = paramFieldInfo.getAnnotation();
    if (jSONField != null) {
      SerializerFeature[] arrayOfSerializerFeature = jSONField.serialzeFeatures();
      int j = arrayOfSerializerFeature.length;
      int i = 0;
      while (true) {
        if (i < j) {
          if (arrayOfSerializerFeature[i] == SerializerFeature.WriteMapNullValue) {
            boolean bool = true;
            break;
          } 
          i++;
          continue;
        } 
        bool2 = false;
        break;
      } 
      this.format = jSONField.format();
      if (this.format.trim().length() == 0)
        this.format = null; 
      arrayOfSerializerFeature = jSONField.serialzeFeatures();
      j = arrayOfSerializerFeature.length;
      for (i = bool1; i < j; i++) {
        SerializerFeature serializerFeature = arrayOfSerializerFeature[i];
        if (serializerFeature == SerializerFeature.WriteNullNumberAsZero) {
          this.writeNumberAsZero = true;
        } else if (serializerFeature == SerializerFeature.WriteNullStringAsEmpty) {
          this.writeNullStringAsEmpty = true;
        } else if (serializerFeature == SerializerFeature.WriteNullBooleanAsFalse) {
          this.writeNullBooleanAsFalse = true;
        } else if (serializerFeature == SerializerFeature.WriteNullListAsEmpty) {
          this.writeNullListAsEmpty = true;
        } else if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
          this.writeEnumUsingToString = true;
        } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
          this.writeEnumUsingName = true;
        } 
      } 
      this.features = SerializerFeature.of(jSONField.serialzeFeatures());
    } else {
      bool2 = false;
    } 
    this.writeNull = bool2;
  }
  
  public int compareTo(FieldSerializer paramFieldSerializer) {
    return this.fieldInfo.compareTo(paramFieldSerializer.fieldInfo);
  }
  
  public Object getPropertyValue(Object paramObject) throws Exception {
    try {
      return this.fieldInfo.get(paramObject);
    } catch (Exception exception) {
      Member member = this.fieldInfo.getMember();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(member.getDeclaringClass().getName());
      stringBuilder.append(".");
      stringBuilder.append(member.getName());
      String str = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append("get property error。 ");
      stringBuilder.append(str);
      throw new JSONException(stringBuilder.toString(), exception);
    } 
  }
  
  public void writePrefix(JSONSerializer paramJSONSerializer) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (serializeWriter.quoteFieldNames) {
      if (serializeWriter.useSingleQuotes) {
        if (this.single_quoted_fieldPrefix == null) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append('\'');
          stringBuilder.append(this.fieldInfo.name);
          stringBuilder.append("':");
          this.single_quoted_fieldPrefix = stringBuilder.toString();
        } 
        serializeWriter.write(this.single_quoted_fieldPrefix);
        return;
      } 
      serializeWriter.write(this.double_quoted_fieldPrefix);
      return;
    } 
    if (this.un_quoted_fieldPrefix == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.fieldInfo.name);
      stringBuilder.append(":");
      this.un_quoted_fieldPrefix = stringBuilder.toString();
    } 
    serializeWriter.write(this.un_quoted_fieldPrefix);
  }
  
  public void writeValue(JSONSerializer paramJSONSerializer, Object paramObject) throws Exception {
    ObjectSerializer objectSerializer;
    String str = this.format;
    if (str != null) {
      paramJSONSerializer.writeWithFormat(paramObject, str);
      return;
    } 
    if (this.runtimeInfo == null) {
      Class<?> clazz1;
      if (paramObject == null) {
        clazz1 = this.fieldInfo.fieldClass;
      } else {
        clazz1 = paramObject.getClass();
      } 
      this.runtimeInfo = new RuntimeSerializerInfo(paramJSONSerializer.getObjectWriter(clazz1), clazz1);
    } 
    RuntimeSerializerInfo runtimeSerializerInfo = this.runtimeInfo;
    int i = this.fieldInfo.serialzeFeatures;
    if (paramObject == null) {
      boolean bool;
      Class<?> clazz1 = runtimeSerializerInfo.runtimeFieldClass;
      paramObject = paramJSONSerializer.out;
      if (this.writeNumberAsZero || (((SerializeWriter)paramObject).features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool && Number.class.isAssignableFrom(clazz1)) {
        paramObject.write(48);
        return;
      } 
      if (this.writeNullStringAsEmpty && String.class == clazz1) {
        paramObject.write("\"\"");
        return;
      } 
      if (this.writeNullBooleanAsFalse && Boolean.class == clazz1) {
        paramObject.write("false");
        return;
      } 
      if (this.writeNullListAsEmpty && Collection.class.isAssignableFrom(clazz1)) {
        paramObject.write("[]");
        return;
      } 
      objectSerializer = runtimeSerializerInfo.fieldSerializer;
      if (((SerializeWriter)paramObject).writeMapNullValue && objectSerializer instanceof ASMJavaBeanSerializer) {
        paramObject.writeNull();
        return;
      } 
      objectSerializer.write(paramJSONSerializer, null, this.fieldInfo.name, this.fieldInfo.fieldType, i);
      return;
    } 
    if (this.fieldInfo.isEnum) {
      if (this.writeEnumUsingName) {
        paramJSONSerializer.out.writeString(((Enum)paramObject).name());
        return;
      } 
      if (this.writeEnumUsingToString) {
        paramJSONSerializer.out.writeString(((Enum)paramObject).toString());
        return;
      } 
    } 
    Class<?> clazz = paramObject.getClass();
    if (clazz == ((RuntimeSerializerInfo)objectSerializer).runtimeFieldClass) {
      ((RuntimeSerializerInfo)objectSerializer).fieldSerializer.write(paramJSONSerializer, paramObject, this.fieldInfo.name, this.fieldInfo.fieldType, i);
      return;
    } 
    paramJSONSerializer.getObjectWriter(clazz).write(paramJSONSerializer, paramObject, this.fieldInfo.name, this.fieldInfo.fieldType, i);
  }
  
  static class RuntimeSerializerInfo {
    ObjectSerializer fieldSerializer;
    
    Class<?> runtimeFieldClass;
    
    public RuntimeSerializerInfo(ObjectSerializer param1ObjectSerializer, Class<?> param1Class) {
      this.fieldSerializer = param1ObjectSerializer;
      this.runtimeFieldClass = param1Class;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\FieldSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */