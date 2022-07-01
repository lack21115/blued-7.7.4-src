package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;

public class FloatCodec implements ObjectDeserializer, ObjectSerializer {
  public static FloatCodec instance = new FloatCodec();
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser) {
    String str;
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    if (jSONLexer.token() == 2) {
      str = jSONLexer.numberString();
      jSONLexer.nextToken(16);
      return (T)Float.valueOf(Float.parseFloat(str));
    } 
    if (jSONLexer.token() == 3) {
      float f = jSONLexer.floatValue();
      jSONLexer.nextToken(16);
      return (T)Float.valueOf(f);
    } 
    Object object = str.parse();
    return (T)((object == null) ? null : TypeUtils.castToFloat(object));
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    return deserialze(paramDefaultJSONParser);
  }
  
  public int getFastMatchToken() {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    paramObject2 = paramJSONSerializer.out;
    if (paramObject1 == null) {
      if (paramObject2.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
        paramObject2.write(48);
        return;
      } 
      paramObject2.writeNull();
      return;
    } 
    float f = ((Float)paramObject1).floatValue();
    if (Float.isNaN(f) || Float.isInfinite(f)) {
      paramObject2.writeNull();
      return;
    } 
    paramObject1 = Float.toString(f);
    Object object = paramObject1;
    if (paramObject1.endsWith(".0"))
      object = paramObject1.substring(0, paramObject1.length() - 2); 
    paramObject2.write((String)object);
    if (paramObject2.isEnabled(SerializerFeature.WriteClassName)) {
      paramObject2.write(70);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\FloatCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */