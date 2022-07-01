package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONAware;
import java.io.IOException;
import java.lang.reflect.Type;

public class JSONAwareSerializer implements ObjectSerializer {
  public static JSONAwareSerializer instance = new JSONAwareSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    paramJSONSerializer.out.write(((JSONAware)paramObject1).toJSONString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\JSONAwareSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */