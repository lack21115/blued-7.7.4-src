package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

public class CharsetCodec implements ObjectDeserializer, ObjectSerializer {
  public static final CharsetCodec instance = new CharsetCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    Object object = paramDefaultJSONParser.parse();
    return (T)((object == null) ? null : Charset.forName((String)object));
  }
  
  public int getFastMatchToken() {
    return 4;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    if (paramObject1 == null) {
      paramJSONSerializer.writeNull();
      return;
    } 
    paramJSONSerializer.write(((Charset)paramObject1).toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\CharsetCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */