package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import java.lang.reflect.Type;

public class EnumDeserializer implements ObjectDeserializer {
  private final Class<?> enumClass;
  
  private final Enum[] values;
  
  public EnumDeserializer(Class<?> paramClass) {
    this.enumClass = paramClass;
    this.values = (Enum[])paramClass.getEnumConstants();
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    try {
      String str;
      JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
      int i = jSONLexer.token();
      if (i == 2) {
        i = jSONLexer.intValue();
        jSONLexer.nextToken(16);
        if (i >= 0 && i <= this.values.length)
          return (T)this.values[i]; 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("parse enum ");
        stringBuilder1.append(this.enumClass.getName());
        stringBuilder1.append(" error, value : ");
        stringBuilder1.append(i);
        throw new JSONException(stringBuilder1.toString());
      } 
      if (i == 4) {
        str = jSONLexer.stringVal();
        jSONLexer.nextToken(16);
        return (T)((str.length() == 0) ? null : Enum.valueOf(this.enumClass, str));
      } 
      if (i == 8) {
        jSONLexer.nextToken(16);
        return null;
      } 
      Object object = str.parse();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("parse enum ");
      stringBuilder.append(this.enumClass.getName());
      stringBuilder.append(" error, value : ");
      stringBuilder.append(object);
      throw new JSONException(stringBuilder.toString());
    } catch (JSONException jSONException) {
      throw jSONException;
    } catch (Exception exception) {
      throw new JSONException(exception.getMessage(), exception);
    } 
  }
  
  public int getFastMatchToken() {
    return 2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\EnumDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */