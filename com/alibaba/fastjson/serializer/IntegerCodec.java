package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

public class IntegerCodec implements ObjectDeserializer, ObjectSerializer {
  public static IntegerCodec instance = new IntegerCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    Integer integer;
    StringBuilder stringBuilder;
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    if (jSONLexer.token() == 8) {
      jSONLexer.nextToken(16);
      return null;
    } 
    if (jSONLexer.token() == 2) {
      try {
        int i = jSONLexer.intValue();
        jSONLexer.nextToken(16);
        integer = Integer.valueOf(i);
      } catch (NumberFormatException numberFormatException) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("int value overflow, field : ");
        stringBuilder.append(paramObject);
        throw new JSONException(stringBuilder.toString(), numberFormatException);
      } 
    } else if (jSONLexer.token() == 3) {
      BigDecimal bigDecimal = jSONLexer.decimalValue();
      jSONLexer.nextToken(16);
      integer = Integer.valueOf(bigDecimal.intValue());
    } else {
      integer = TypeUtils.castToInt(integer.parse());
    } 
    return (T)((stringBuilder == AtomicInteger.class) ? new AtomicInteger(integer.intValue()) : integer);
  }
  
  public int getFastMatchToken() {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object<?> paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    paramObject2 = paramObject1;
    if (paramObject2 == null) {
      if (serializeWriter.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
        serializeWriter.write(48);
        return;
      } 
      serializeWriter.writeNull();
      return;
    } 
    if (paramObject1 instanceof Long) {
      serializeWriter.writeLong(paramObject2.longValue());
    } else {
      serializeWriter.writeInt(paramObject2.intValue());
    } 
    if (serializeWriter.writeClassName) {
      paramObject1 = (Object<?>)paramObject2.getClass();
      if (paramObject1 == Byte.class) {
        serializeWriter.write(66);
        return;
      } 
      if (paramObject1 == Short.class)
        serializeWriter.write(83); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\IntegerCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */