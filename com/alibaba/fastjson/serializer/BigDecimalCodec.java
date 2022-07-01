package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public class BigDecimalCodec implements ObjectDeserializer, ObjectSerializer {
  public static final BigDecimalCodec instance = new BigDecimalCodec();
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser) {
    BigDecimal bigDecimal;
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    if (jSONLexer.token() == 2) {
      bigDecimal = jSONLexer.decimalValue();
      jSONLexer.nextToken(16);
      return (T)bigDecimal;
    } 
    if (jSONLexer.token() == 3) {
      bigDecimal = jSONLexer.decimalValue();
      jSONLexer.nextToken(16);
      return (T)bigDecimal;
    } 
    Object object = bigDecimal.parse();
    return (T)((object == null) ? null : TypeUtils.castToBigDecimal(object));
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    return deserialze(paramDefaultJSONParser);
  }
  
  public int getFastMatchToken() {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      if (serializeWriter.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
        serializeWriter.write(48);
        return;
      } 
      serializeWriter.writeNull();
      return;
    } 
    paramObject1 = paramObject1;
    serializeWriter.write(paramObject1.toString());
    if (serializeWriter.isEnabled(SerializerFeature.WriteClassName) && paramType != BigDecimal.class && paramObject1.scale() == 0)
      serializeWriter.write(46); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\BigDecimalCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */