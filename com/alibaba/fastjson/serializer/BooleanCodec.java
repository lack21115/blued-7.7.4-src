package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

public class BooleanCodec implements ObjectDeserializer, ObjectSerializer {
  public static final BooleanCodec instance = new BooleanCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    Object object;
    paramObject = paramDefaultJSONParser.lexer;
    if (paramObject.token() == 6) {
      paramObject.nextToken(16);
      object = Boolean.TRUE;
    } else if (paramObject.token() == 7) {
      paramObject.nextToken(16);
      object = Boolean.FALSE;
    } else if (paramObject.token() == 2) {
      int i = paramObject.intValue();
      paramObject.nextToken(16);
      if (i == 1) {
        object = Boolean.TRUE;
      } else {
        object = Boolean.FALSE;
      } 
    } else {
      object = object.parse();
      if (object == null)
        return null; 
      object = TypeUtils.castToBoolean(object);
    } 
    return (T)((paramType == AtomicBoolean.class) ? new AtomicBoolean(object.booleanValue()) : object);
  }
  
  public int getFastMatchToken() {
    return 6;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    paramObject1 = paramObject1;
    if (paramObject1 == null) {
      if (serializeWriter.isEnabled(SerializerFeature.WriteNullBooleanAsFalse)) {
        serializeWriter.write("false");
        return;
      } 
      serializeWriter.writeNull();
      return;
    } 
    if (paramObject1.booleanValue()) {
      serializeWriter.write("true");
      return;
    } 
    serializeWriter.write("false");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\BooleanCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */