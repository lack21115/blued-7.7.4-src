package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public final class ListSerializer implements ObjectSerializer {
  public static final ListSerializer instance = new ListSerializer();
  
  public final void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    boolean bool = paramJSONSerializer.out.writeClassName;
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (bool && paramType instanceof ParameterizedType) {
      paramType = ((ParameterizedType)paramType).getActualTypeArguments()[0];
    } else {
      paramType = null;
    } 
    if (paramObject1 == null) {
      if (serializeWriter.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
        serializeWriter.write("[]");
        return;
      } 
      serializeWriter.writeNull();
      return;
    } 
    List<Object> list = (List)paramObject1;
    if (list.size() == 0) {
      serializeWriter.append("[]");
      return;
    } 
    SerialContext serialContext = paramJSONSerializer.context;
    paramJSONSerializer.setContext(serialContext, paramObject1, paramObject2, 0);
    try {
      if (serializeWriter.prettyFormat) {
        serializeWriter.append('[');
        paramJSONSerializer.incrementIndent();
        Iterator<List> iterator = list.iterator();
        for (paramInt = 0;; paramInt++) {
          if (iterator.hasNext()) {
            list = iterator.next();
            if (paramInt != 0)
              serializeWriter.append(','); 
            paramJSONSerializer.println();
            if (list != null) {
              if (paramJSONSerializer.containsReference(list)) {
                paramJSONSerializer.writeReference(list);
              } else {
                ObjectSerializer objectSerializer = paramJSONSerializer.getObjectWriter(list.getClass());
                paramJSONSerializer.context = new SerialContext(serialContext, paramObject1, paramObject2, 0, 0);
                objectSerializer.write(paramJSONSerializer, list, Integer.valueOf(paramInt), paramType, 0);
              } 
            } else {
              paramJSONSerializer.out.writeNull();
            } 
          } else {
            paramJSONSerializer.decrementIdent();
            paramJSONSerializer.println();
            serializeWriter.append(']');
            return;
          } 
        } 
      } 
      serializeWriter.append('[');
      int i = list.size();
    } finally {
      paramJSONSerializer.context = serialContext;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\ListSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */