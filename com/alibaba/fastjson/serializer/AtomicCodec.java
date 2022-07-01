package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public class AtomicCodec implements ObjectDeserializer, ObjectSerializer {
  public static final AtomicCodec instance = new AtomicCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    if (paramDefaultJSONParser.lexer.token() == 8) {
      paramDefaultJSONParser.lexer.nextToken(16);
      return null;
    } 
    paramObject = new JSONArray();
    paramDefaultJSONParser.parseArray((Collection)paramObject);
    boolean bool = false;
    int i = 0;
    if (paramType == AtomicIntegerArray.class) {
      AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(paramObject.size());
      while (i < paramObject.size()) {
        atomicIntegerArray.set(i, paramObject.getInteger(i).intValue());
        i++;
      } 
      return (T)atomicIntegerArray;
    } 
    AtomicLongArray atomicLongArray = new AtomicLongArray(paramObject.size());
    for (i = bool; i < paramObject.size(); i++)
      atomicLongArray.set(i, paramObject.getLong(i).longValue()); 
    return (T)atomicLongArray;
  }
  
  public int getFastMatchToken() {
    return 14;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    paramObject2 = paramJSONSerializer.out;
    if (paramObject1 instanceof AtomicInteger) {
      paramObject2.writeInt(((AtomicInteger)paramObject1).get());
      return;
    } 
    if (paramObject1 instanceof AtomicLong) {
      paramObject2.writeLong(((AtomicLong)paramObject1).get());
      return;
    } 
    if (paramObject1 instanceof AtomicBoolean) {
      String str;
      if (((AtomicBoolean)paramObject1).get()) {
        str = "true";
      } else {
        str = "false";
      } 
      paramObject2.append(str);
      return;
    } 
    if (paramObject1 == null) {
      if (paramObject2.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
        paramObject2.write("[]");
        return;
      } 
      paramObject2.writeNull();
      return;
    } 
    boolean bool = paramObject1 instanceof AtomicIntegerArray;
    int i = 0;
    paramInt = 0;
    if (bool) {
      AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray)paramObject1;
      i = atomicIntegerArray.length();
      paramObject2.write(91);
      while (paramInt < i) {
        int k = atomicIntegerArray.get(paramInt);
        if (paramInt != 0)
          paramObject2.write(44); 
        paramObject2.writeInt(k);
        paramInt++;
      } 
      paramObject2.write(93);
      return;
    } 
    AtomicLongArray atomicLongArray = (AtomicLongArray)paramObject1;
    int j = atomicLongArray.length();
    paramObject2.write(91);
    for (paramInt = i; paramInt < j; paramInt++) {
      long l = atomicLongArray.get(paramInt);
      if (paramInt != 0)
        paramObject2.write(44); 
      paramObject2.writeLong(l);
    } 
    paramObject2.write(93);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\AtomicCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */