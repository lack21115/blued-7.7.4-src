package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class OptionalCodec implements ObjectDeserializer, ObjectSerializer {
  public static OptionalCodec instance = new OptionalCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    Integer integer;
    Long long_;
    Double double_;
    if (paramType == OptionalInt.class) {
      integer = TypeUtils.castToInt(paramDefaultJSONParser.parseObject(Integer.class));
      return (T)((integer == null) ? OptionalInt.empty() : OptionalInt.of(integer.intValue()));
    } 
    if (paramType == OptionalLong.class) {
      long_ = TypeUtils.castToLong(integer.parseObject(Long.class));
      return (T)((long_ == null) ? OptionalLong.empty() : OptionalLong.of(long_.longValue()));
    } 
    if (paramType == OptionalDouble.class) {
      double_ = TypeUtils.castToDouble(long_.parseObject(Double.class));
      return (T)((double_ == null) ? OptionalDouble.empty() : OptionalDouble.of(double_.doubleValue()));
    } 
    Object object = double_.parseObject(TypeUtils.unwrapOptional(paramType));
    return (T)((object == null) ? Optional.empty() : Optional.of(object));
  }
  
  public int getFastMatchToken() {
    return 12;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    if (paramObject1 == null) {
      paramJSONSerializer.writeNull();
      return;
    } 
    if (paramObject1 instanceof Optional) {
      paramJSONSerializer.write(((Optional)paramObject1).get());
      return;
    } 
    if (paramObject1 instanceof OptionalDouble) {
      paramObject1 = paramObject1;
      if (paramObject1.isPresent()) {
        paramJSONSerializer.write(Double.valueOf(paramObject1.getAsDouble()));
        return;
      } 
      paramJSONSerializer.writeNull();
      return;
    } 
    if (paramObject1 instanceof OptionalInt) {
      paramObject1 = paramObject1;
      if (paramObject1.isPresent()) {
        paramInt = paramObject1.getAsInt();
        paramJSONSerializer.out.writeInt(paramInt);
        return;
      } 
      paramJSONSerializer.writeNull();
      return;
    } 
    if (paramObject1 instanceof OptionalLong) {
      paramObject1 = paramObject1;
      if (paramObject1.isPresent()) {
        long l = paramObject1.getAsLong();
        paramJSONSerializer.out.writeLong(l);
        return;
      } 
      paramJSONSerializer.writeNull();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("not support optional : ");
    stringBuilder.append(paramObject1.getClass());
    throw new JSONException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\OptionalCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */