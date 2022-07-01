package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Currency;

public class CurrencyCodec implements ObjectDeserializer, ObjectSerializer {
  public static final CurrencyCodec instance = new CurrencyCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    String str = (String)paramDefaultJSONParser.parse();
    return (T)((str == null || str.length() == 0) ? null : Currency.getInstance(str));
  }
  
  public int getFastMatchToken() {
    return 4;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      serializeWriter.writeNull();
      return;
    } 
    serializeWriter.writeString(((Currency)paramObject1).getCurrencyCode());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\CurrencyCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */