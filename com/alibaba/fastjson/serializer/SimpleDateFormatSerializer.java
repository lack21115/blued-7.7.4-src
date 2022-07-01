package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatSerializer implements ObjectSerializer {
  private final String pattern;
  
  public SimpleDateFormatSerializer(String paramString) {
    this.pattern = paramString;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    if (paramObject1 == null) {
      paramJSONSerializer.out.writeNull();
      return;
    } 
    paramObject1 = paramObject1;
    paramObject2 = new SimpleDateFormat(this.pattern, paramJSONSerializer.locale);
    paramObject2.setTimeZone(paramJSONSerializer.timeZone);
    paramJSONSerializer.write(paramObject2.format((Date)paramObject1));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\SimpleDateFormatSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */