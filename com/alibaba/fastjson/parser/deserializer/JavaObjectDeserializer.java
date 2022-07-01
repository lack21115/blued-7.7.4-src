package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;

public class JavaObjectDeserializer implements ObjectDeserializer {
  public static final JavaObjectDeserializer instance = new JavaObjectDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    Object[] arrayOfObject;
    if (paramType instanceof GenericArrayType) {
      paramObject = ((GenericArrayType)paramType).getGenericComponentType();
      Object object = paramObject;
      if (paramObject instanceof TypeVariable)
        object = ((TypeVariable)paramObject).getBounds()[0]; 
      paramObject = new ArrayList();
      paramDefaultJSONParser.parseArray((Type)object, (Collection)paramObject);
      if (object instanceof Class) {
        object = object;
        if (object == boolean.class)
          return (T)TypeUtils.cast(paramObject, boolean[].class, paramDefaultJSONParser.getConfig()); 
        if (object == short.class)
          return (T)TypeUtils.cast(paramObject, short[].class, paramDefaultJSONParser.getConfig()); 
        if (object == int.class)
          return (T)TypeUtils.cast(paramObject, int[].class, paramDefaultJSONParser.getConfig()); 
        if (object == long.class)
          return (T)TypeUtils.cast(paramObject, long[].class, paramDefaultJSONParser.getConfig()); 
        if (object == float.class)
          return (T)TypeUtils.cast(paramObject, float[].class, paramDefaultJSONParser.getConfig()); 
        if (object == double.class)
          return (T)TypeUtils.cast(paramObject, double[].class, paramDefaultJSONParser.getConfig()); 
        arrayOfObject = (Object[])Array.newInstance((Class<?>)object, paramObject.size());
        paramObject.toArray(arrayOfObject);
        return (T)arrayOfObject;
      } 
      return (T)paramObject.toArray();
    } 
    return (T)arrayOfObject.parse(paramObject);
  }
  
  public int getFastMatchToken() {
    return 12;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\JavaObjectDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */