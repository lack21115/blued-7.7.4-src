package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class EnumSerializer implements ObjectSerializer {
  public static final EnumSerializer instance = new EnumSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    paramObject2 = paramJSONSerializer.out;
    if (paramObject1 == null) {
      paramObject2.writeNull();
      return;
    } 
    paramObject1 = paramObject1;
    if (((SerializeWriter)paramObject2).writeEnumUsingName && !((SerializeWriter)paramObject2).writeEnumUsingToString) {
      paramJSONSerializer.write(paramObject1.name());
      return;
    } 
    if (((SerializeWriter)paramObject2).writeEnumUsingToString) {
      paramJSONSerializer.write(paramObject1.toString());
      return;
    } 
    paramObject2.writeInt(paramObject1.ordinal());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\EnumSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */