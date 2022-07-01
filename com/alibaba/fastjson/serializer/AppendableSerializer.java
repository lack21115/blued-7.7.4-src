package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class AppendableSerializer implements ObjectSerializer {
  public static final AppendableSerializer instance = new AppendableSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter;
    if (paramObject1 == null) {
      serializeWriter = paramJSONSerializer.out;
      if (serializeWriter.isEnabled(SerializerFeature.WriteNullStringAsEmpty)) {
        serializeWriter.writeString("");
        return;
      } 
      serializeWriter.writeNull();
      return;
    } 
    serializeWriter.write(paramObject1.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\AppendableSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */