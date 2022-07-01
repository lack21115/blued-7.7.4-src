package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;

public class CharacterCodec implements ObjectDeserializer, ObjectSerializer {
  public static final CharacterCodec instance = new CharacterCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    Object object = paramDefaultJSONParser.parse();
    return (T)((object == null) ? null : TypeUtils.castToChar(object));
  }
  
  public int getFastMatchToken() {
    return 4;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    paramObject1 = paramObject1;
    if (paramObject1 == null) {
      serializeWriter.writeString("");
      return;
    } 
    if (paramObject1.charValue() == '\000') {
      serializeWriter.writeString("\000");
      return;
    } 
    serializeWriter.writeString(paramObject1.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\CharacterCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */