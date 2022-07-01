package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;

public class CharArrayCodec implements ObjectDeserializer, ObjectSerializer {
  public static CharArrayCodec instance = new CharArrayCodec();
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser) {
    Number number;
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    if (jSONLexer.token() == 4) {
      String str = jSONLexer.stringVal();
      jSONLexer.nextToken(16);
      return (T)str.toCharArray();
    } 
    if (jSONLexer.token() == 2) {
      number = jSONLexer.integerValue();
      jSONLexer.nextToken(16);
      return (T)number.toString().toCharArray();
    } 
    Object object = number.parse();
    return (T)((object == null) ? null : JSON.toJSONString(object).toCharArray());
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    return deserialze(paramDefaultJSONParser);
  }
  
  public int getFastMatchToken() {
    return 4;
  }
  
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      if (serializeWriter.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
        serializeWriter.write("[]");
        return;
      } 
      serializeWriter.writeNull();
      return;
    } 
    serializeWriter.writeString(new String((char[])paramObject1));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\CharArrayCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */