package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public class NumberDeserializer implements ObjectDeserializer {
  public static final NumberDeserializer instance = new NumberDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    BigDecimal bigDecimal;
    paramObject = paramDefaultJSONParser.lexer;
    if (paramObject.token() == 2) {
      if (paramType == double.class || paramType == Double.class) {
        String str = paramObject.numberString();
        paramObject.nextToken(16);
        return (T)Double.valueOf(Double.parseDouble(str));
      } 
      long l = paramObject.longValue();
      paramObject.nextToken(16);
      return (T)((paramType == short.class || paramType == Short.class) ? Short.valueOf((short)(int)l) : ((paramType == byte.class || paramType == Byte.class) ? Byte.valueOf((byte)(int)l) : ((l >= -2147483648L && l <= 2147483647L) ? Integer.valueOf((int)l) : Long.valueOf(l))));
    } 
    if (paramObject.token() == 3) {
      if (paramType == double.class || paramType == Double.class) {
        String str = paramObject.numberString();
        paramObject.nextToken(16);
        return (T)Double.valueOf(Double.parseDouble(str));
      } 
      bigDecimal = paramObject.decimalValue();
      paramObject.nextToken(16);
      return (T)((paramType == short.class || paramType == Short.class) ? Short.valueOf(bigDecimal.shortValue()) : ((paramType == byte.class || paramType == Byte.class) ? Byte.valueOf(bigDecimal.byteValue()) : bigDecimal));
    } 
    Object object = bigDecimal.parse();
    return (T)((object == null) ? null : ((paramType == double.class || paramType == Double.class) ? TypeUtils.castToDouble(object) : ((paramType == short.class || paramType == Short.class) ? TypeUtils.castToShort(object) : ((paramType == byte.class || paramType == Byte.class) ? TypeUtils.castToByte(object) : TypeUtils.castToBigDecimal(object)))));
  }
  
  public int getFastMatchToken() {
    return 2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\NumberDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */