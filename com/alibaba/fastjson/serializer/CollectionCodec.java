package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public class CollectionCodec implements ObjectDeserializer, ObjectSerializer {
  public static final CollectionCodec instance = new CollectionCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    JSONArray jSONArray;
    Type<Object> type1;
    int i = paramDefaultJSONParser.lexer.token();
    Type<Object> type2 = null;
    if (i == 8) {
      paramDefaultJSONParser.lexer.nextToken(16);
      return null;
    } 
    if (paramType == JSONArray.class) {
      jSONArray = new JSONArray();
      paramDefaultJSONParser.parseArray((Collection)jSONArray);
      return (T)jSONArray;
    } 
    Collection collection = TypeUtils.createCollection((Type)jSONArray);
    if (jSONArray instanceof ParameterizedType) {
      type1 = ((ParameterizedType)jSONArray).getActualTypeArguments()[0];
    } else {
      Type<Object> type = type2;
      if (type1 instanceof Class) {
        type1 = type1;
        type = type2;
        if (!type1.getName().startsWith("java.")) {
          type1 = type1.getGenericSuperclass();
          type = type2;
          if (type1 instanceof ParameterizedType)
            type = ((ParameterizedType)type1).getActualTypeArguments()[0]; 
        } 
      } 
      type1 = type;
      if (type == null)
        type1 = Object.class; 
    } 
    paramDefaultJSONParser.parseArray(type1, collection, paramObject);
    return (T)collection;
  }
  
  public int getFastMatchToken() {
    return 14;
  }
  
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
    Collection collection = (Collection)paramObject1;
    SerialContext serialContext = paramJSONSerializer.context;
    paramJSONSerializer.setContext(serialContext, paramObject1, paramObject2, 0);
    if (serializeWriter.isEnabled(SerializerFeature.WriteClassName))
      if (HashSet.class == collection.getClass()) {
        serializeWriter.append("Set");
      } else if (TreeSet.class == collection.getClass()) {
        serializeWriter.append("TreeSet");
      }  
    try {
      serializeWriter.append('[');
      paramObject1 = collection.iterator();
      while (true) {
        int i;
        if (paramObject1.hasNext()) {
          paramObject2 = paramObject1.next();
          i = paramInt + 1;
          if (paramInt != 0)
            serializeWriter.append(','); 
          if (paramObject2 == null) {
            serializeWriter.writeNull();
          } else {
            Class<?> clazz = paramObject2.getClass();
            if (clazz == Integer.class) {
              serializeWriter.writeInt(((Integer)paramObject2).intValue());
            } else if (clazz == Long.class) {
              serializeWriter.writeLong(((Long)paramObject2).longValue());
              if (serializeWriter.isEnabled(SerializerFeature.WriteClassName))
                serializeWriter.write(76); 
            } else {
              paramJSONSerializer.getObjectWriter(clazz).write(paramJSONSerializer, paramObject2, Integer.valueOf(i - 1), type1, 0);
            } 
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\CollectionCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */