package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.Date;

public abstract class AbstractDateDeserializer implements ObjectDeserializer {
  protected abstract <T> T cast(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2);
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    StringBuilder stringBuilder;
    Object object;
    Type type;
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    if (jSONLexer.token() == 2) {
      object = Long.valueOf(jSONLexer.longValue());
      jSONLexer.nextToken(16);
      type = paramType;
    } else if (jSONLexer.token() == 4) {
      String str = jSONLexer.stringVal();
      jSONLexer.nextToken(16);
      object = str;
      type = paramType;
      if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
        JSONScanner jSONScanner = new JSONScanner(str);
        object = str;
        if (jSONScanner.scanISO8601DateIfMatch())
          Date date = jSONScanner.getCalendar().getTime(); 
        jSONScanner.close();
        Type type1 = paramType;
      } 
    } else if (jSONLexer.token() == 8) {
      jSONLexer.nextToken();
      object = null;
      type = paramType;
    } else if (jSONLexer.token() == 12) {
      jSONLexer.nextToken();
      if (jSONLexer.token() == 4) {
        object = jSONLexer.stringVal();
        Type type1 = paramType;
        if (JSON.DEFAULT_TYPE_KEY.equals(object)) {
          jSONLexer.nextToken();
          paramDefaultJSONParser.accept(17);
          Class clazz = TypeUtils.loadClass(jSONLexer.stringVal(), paramDefaultJSONParser.getConfig().getDefaultClassLoader());
          if (clazz != null)
            paramType = clazz; 
          paramDefaultJSONParser.accept(4);
          paramDefaultJSONParser.accept(16);
          type1 = paramType;
        } 
        jSONLexer.nextTokenWithColon(2);
        if (jSONLexer.token() == 2) {
          long l = jSONLexer.longValue();
          jSONLexer.nextToken();
          Long long_ = Long.valueOf(l);
          paramDefaultJSONParser.accept(13);
          type = type1;
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append("syntax error : ");
          stringBuilder.append(jSONLexer.tokenName());
          throw new JSONException(stringBuilder.toString());
        } 
      } else {
        throw new JSONException("syntax error");
      } 
    } else if (stringBuilder.getResolveStatus() == 2) {
      stringBuilder.setResolveStatus(0);
      stringBuilder.accept(16);
      if (jSONLexer.token() == 4) {
        if ("val".equals(jSONLexer.stringVal())) {
          jSONLexer.nextToken();
          stringBuilder.accept(17);
          object = stringBuilder.parse();
          stringBuilder.accept(13);
          type = paramType;
        } else {
          throw new JSONException("syntax error");
        } 
      } else {
        throw new JSONException("syntax error");
      } 
    } else {
      object = stringBuilder.parse();
      type = paramType;
    } 
    return cast((DefaultJSONParser)stringBuilder, type, paramObject, object);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\AbstractDateDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */