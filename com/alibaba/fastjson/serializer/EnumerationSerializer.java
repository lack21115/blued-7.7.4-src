package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;

public class EnumerationSerializer implements ObjectSerializer {
  public static EnumerationSerializer instance = new EnumerationSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      if (serializeWriter.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
        serializeWriter.write("[]");
        return;
      } 
      serializeWriter.writeNull();
      return;
    } 
    Type type2 = null;
    boolean bool = serializeWriter.isEnabled(SerializerFeature.WriteClassName);
    paramInt = 0;
    Type type1 = type2;
    if (bool) {
      type1 = type2;
      if (paramType instanceof ParameterizedType)
        type1 = ((ParameterizedType)paramType).getActualTypeArguments()[0]; 
    } 
    Enumeration enumeration = (Enumeration)paramObject1;
    SerialContext serialContext = paramJSONSerializer.context;
    paramJSONSerializer.setContext(serialContext, paramObject1, paramObject2, 0);
    try {
      serializeWriter.append('[');
      while (true) {
        int i;
        if (enumeration.hasMoreElements()) {
          paramObject1 = enumeration.nextElement();
          i = paramInt + 1;
          if (paramInt != 0)
            serializeWriter.append(','); 
          if (paramObject1 == null) {
            serializeWriter.writeNull();
          } else {
            paramJSONSerializer.getObjectWriter(paramObject1.getClass()).write(paramJSONSerializer, paramObject1, Integer.valueOf(i - 1), type1, 0);
          } 
        } else {
          serializeWriter.append(']');
          return;
        } 
        paramInt = i;
      } 
    } finally {
      paramJSONSerializer.context = serialContext;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\EnumerationSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */