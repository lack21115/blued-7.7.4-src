package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

public class PrimitiveArraySerializer implements ObjectSerializer {
  public static PrimitiveArraySerializer instance = new PrimitiveArraySerializer();
  
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
    boolean bool = paramObject1 instanceof int[];
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    paramInt = 0;
    if (bool) {
      paramObject1 = paramObject1;
      serializeWriter.write(91);
      while (paramInt < paramObject1.length) {
        if (paramInt != 0)
          serializeWriter.write(44); 
        serializeWriter.writeInt(paramObject1[paramInt]);
        paramInt++;
      } 
      serializeWriter.write(93);
      return;
    } 
    if (paramObject1 instanceof short[]) {
      paramObject1 = paramObject1;
      serializeWriter.write(91);
      for (paramInt = bool1; paramInt < paramObject1.length; paramInt++) {
        if (paramInt != 0)
          serializeWriter.write(44); 
        serializeWriter.writeInt(paramObject1[paramInt]);
      } 
      serializeWriter.write(93);
      return;
    } 
    if (paramObject1 instanceof long[]) {
      paramObject1 = paramObject1;
      serializeWriter.write(91);
      for (paramInt = bool2; paramInt < paramObject1.length; paramInt++) {
        if (paramInt != 0)
          serializeWriter.write(44); 
        serializeWriter.writeLong(paramObject1[paramInt]);
      } 
      serializeWriter.write(93);
      return;
    } 
    if (paramObject1 instanceof boolean[]) {
      paramObject1 = paramObject1;
      serializeWriter.write(91);
      for (paramInt = bool3; paramInt < paramObject1.length; paramInt++) {
        if (paramInt != 0)
          serializeWriter.write(44); 
        serializeWriter.write(paramObject1[paramInt]);
      } 
      serializeWriter.write(93);
      return;
    } 
    if (paramObject1 instanceof float[]) {
      paramObject1 = paramObject1;
      serializeWriter.write(91);
      for (paramInt = bool4; paramInt < paramObject1.length; paramInt++) {
        if (paramInt != 0)
          serializeWriter.write(44); 
        Object object = paramObject1[paramInt];
        if (Float.isNaN(object)) {
          serializeWriter.writeNull();
        } else {
          serializeWriter.append(Float.toString(object));
        } 
      } 
      serializeWriter.write(93);
      return;
    } 
    if (paramObject1 instanceof double[]) {
      paramObject1 = paramObject1;
      serializeWriter.write(91);
      for (paramInt = bool5; paramInt < paramObject1.length; paramInt++) {
        if (paramInt != 0)
          serializeWriter.write(44); 
        Object object = paramObject1[paramInt];
        if (Double.isNaN(object)) {
          serializeWriter.writeNull();
        } else {
          serializeWriter.append(Double.toString(object));
        } 
      } 
      serializeWriter.write(93);
      return;
    } 
    if (paramObject1 instanceof byte[]) {
      serializeWriter.writeByteArray((byte[])paramObject1);
      return;
    } 
    serializeWriter.writeString(new String((char[])paramObject1));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\PrimitiveArraySerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */