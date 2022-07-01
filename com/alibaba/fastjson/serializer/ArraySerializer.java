package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class ArraySerializer implements ObjectSerializer {
  private final ObjectSerializer compObjectSerializer;
  
  private final Class<?> componentType;
  
  public ArraySerializer(Class<?> paramClass, ObjectSerializer paramObjectSerializer) {
    this.componentType = paramClass;
    this.compObjectSerializer = paramObjectSerializer;
  }
  
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      if (serializeWriter.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
        serializeWriter.write("[]");
        return;
      } 
      serializeWriter.writeNull();
      return;
    } 
    Object[] arrayOfObject = (Object[])paramObject1;
    int i = arrayOfObject.length;
    SerialContext serialContext = paramJSONSerializer.context;
    paramInt = 0;
    paramJSONSerializer.setContext(serialContext, paramObject1, paramObject2, 0);
    try {
      serializeWriter.append('[');
      while (true) {
        if (paramInt < i) {
          if (paramInt != 0)
            serializeWriter.append(','); 
          paramObject1 = arrayOfObject[paramInt];
          if (paramObject1 == null) {
            serializeWriter.append("null");
          } else if (paramObject1.getClass() == this.componentType) {
            this.compObjectSerializer.write(paramJSONSerializer, paramObject1, Integer.valueOf(paramInt), null, 0);
          } else {
            paramJSONSerializer.getObjectWriter(paramObject1.getClass()).write(paramJSONSerializer, paramObject1, Integer.valueOf(paramInt), null, 0);
          } 
        } else {
          serializeWriter.append(']');
          return;
        } 
        paramInt++;
      } 
    } finally {
      paramJSONSerializer.context = serialContext;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\ArraySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */