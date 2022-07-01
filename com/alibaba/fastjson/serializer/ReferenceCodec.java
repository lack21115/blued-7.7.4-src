package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

public class ReferenceCodec implements ObjectDeserializer, ObjectSerializer {
  public static final ReferenceCodec instance = new ReferenceCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    paramType = paramType;
    Object object = paramDefaultJSONParser.parseObject(paramType.getActualTypeArguments()[0]);
    paramType = paramType.getRawType();
    if (paramType == AtomicReference.class)
      return (T)new AtomicReference(object); 
    if (paramType == WeakReference.class)
      return (T)new WeakReference(object); 
    if (paramType == SoftReference.class)
      return (T)new SoftReference(object); 
    throw new UnsupportedOperationException(paramType.toString());
  }
  
  public int getFastMatchToken() {
    return 12;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    if (paramObject1 instanceof AtomicReference) {
      paramObject1 = ((AtomicReference)paramObject1).get();
    } else {
      paramObject1 = ((Reference)paramObject1).get();
    } 
    paramJSONSerializer.write(paramObject1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\ReferenceCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */