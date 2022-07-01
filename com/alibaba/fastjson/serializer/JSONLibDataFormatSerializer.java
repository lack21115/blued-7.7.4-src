package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.lang.reflect.Type;

public class JSONLibDataFormatSerializer implements ObjectSerializer {
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    if (paramObject1 == null) {
      paramJSONSerializer.out.writeNull();
      return;
    } 
    paramObject1 = paramObject1;
    paramObject2 = new JSONObject();
    paramObject2.put("date", Integer.valueOf(paramObject1.getDate()));
    paramObject2.put("day", Integer.valueOf(paramObject1.getDay()));
    paramObject2.put("hours", Integer.valueOf(paramObject1.getHours()));
    paramObject2.put("minutes", Integer.valueOf(paramObject1.getMinutes()));
    paramObject2.put("month", Integer.valueOf(paramObject1.getMonth()));
    paramObject2.put("seconds", Integer.valueOf(paramObject1.getSeconds()));
    paramObject2.put("time", Long.valueOf(paramObject1.getTime()));
    paramObject2.put("timezoneOffset", Integer.valueOf(paramObject1.getTimezoneOffset()));
    paramObject2.put("year", Integer.valueOf(paramObject1.getYear()));
    paramJSONSerializer.write(paramObject2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\JSONLibDataFormatSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */