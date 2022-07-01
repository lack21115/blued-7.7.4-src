package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;

public class StringCodec implements ObjectDeserializer, ObjectSerializer {
  public static StringCodec instance = new StringCodec();
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser) {
    String str;
    JSONLexer jSONLexer = paramDefaultJSONParser.getLexer();
    if (jSONLexer.token() == 4) {
      str = jSONLexer.stringVal();
      jSONLexer.nextToken(16);
      return (T)str;
    } 
    if (jSONLexer.token() == 2) {
      str = jSONLexer.numberString();
      jSONLexer.nextToken(16);
      return (T)str;
    } 
    Object object = str.parse();
    return (T)((object == null) ? null : object.toString());
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    Object object;
    JSONLexer jSONLexer;
    if (paramType == StringBuffer.class) {
      String str;
      jSONLexer = paramDefaultJSONParser.lexer;
      if (jSONLexer.token() == 4) {
        str = jSONLexer.stringVal();
        jSONLexer.nextToken(16);
        return (T)new StringBuffer(str);
      } 
      object = str.parse();
      return (T)((object == null) ? null : new StringBuffer(object.toString()));
    } 
    if (jSONLexer == StringBuilder.class) {
      jSONLexer = ((DefaultJSONParser)object).lexer;
      if (jSONLexer.token() == 4) {
        object = jSONLexer.stringVal();
        jSONLexer.nextToken(16);
        return (T)new StringBuilder((String)object);
      } 
      object = object.parse();
      return (T)((object == null) ? null : new StringBuilder(object.toString()));
    } 
    return deserialze((DefaultJSONParser)object);
  }
  
  public int getFastMatchToken() {
    return 4;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    write(paramJSONSerializer, (String)paramObject1);
  }
  
  public void write(JSONSerializer paramJSONSerializer, String paramString) {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramString == null) {
      if (serializeWriter.isEnabled(SerializerFeature.WriteNullStringAsEmpty)) {
        serializeWriter.writeString("");
        return;
      } 
      serializeWriter.writeNull();
      return;
    } 
    serializeWriter.writeString(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\StringCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */