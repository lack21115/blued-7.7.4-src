package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import java.lang.reflect.Type;

public class StackTraceElementDeserializer implements ObjectDeserializer {
  public static final StackTraceElementDeserializer instance = new StackTraceElementDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    if (jSONLexer.token() == 8) {
      jSONLexer.nextToken();
      return null;
    } 
    if (jSONLexer.token() == 12 || jSONLexer.token() == 16) {
      String str3 = null;
      String str2 = str3;
      String str1 = str2;
      boolean bool = false;
      while (true) {
        boolean bool1;
        String str5;
        String str4 = jSONLexer.scanSymbol(paramDefaultJSONParser.getSymbolTable());
        if (str4 == null) {
          if (jSONLexer.token() == 13) {
            jSONLexer.nextToken(16);
            bool1 = bool;
            str4 = str3;
            paramObject = str2;
            str5 = str1;
            continue;
          } 
          if (jSONLexer.token() == 16 && jSONLexer.isEnabled(Feature.AllowArbitraryCommas))
            continue; 
        } 
        jSONLexer.nextTokenWithColon(4);
        if ("className".equals(str4)) {
          if (jSONLexer.token() == 8) {
            str4 = null;
            bool1 = bool;
            paramObject = str2;
            str5 = str1;
          } else if (jSONLexer.token() == 4) {
            str4 = jSONLexer.stringVal();
            bool1 = bool;
            paramObject = str2;
            str5 = str1;
          } else {
            throw new JSONException("syntax error");
          } 
        } else if ("methodName".equals(str4)) {
          if (jSONLexer.token() == 8) {
            paramObject = null;
            bool1 = bool;
            str4 = str3;
            str5 = str1;
          } else if (jSONLexer.token() == 4) {
            paramObject = jSONLexer.stringVal();
            bool1 = bool;
            str4 = str3;
            str5 = str1;
          } else {
            throw new JSONException("syntax error");
          } 
        } else if ("fileName".equals(str4)) {
          if (jSONLexer.token() == 8) {
            str5 = null;
            bool1 = bool;
            str4 = str3;
            paramObject = str2;
          } else if (jSONLexer.token() == 4) {
            str5 = jSONLexer.stringVal();
            bool1 = bool;
            str4 = str3;
            paramObject = str2;
          } else {
            throw new JSONException("syntax error");
          } 
        } else if ("lineNumber".equals(str4)) {
          if (jSONLexer.token() == 8) {
            bool1 = false;
            str4 = str3;
            paramObject = str2;
            str5 = str1;
          } else if (jSONLexer.token() == 2) {
            bool1 = jSONLexer.intValue();
            str4 = str3;
            paramObject = str2;
            str5 = str1;
          } else {
            throw new JSONException("syntax error");
          } 
        } else if ("nativeMethod".equals(str4)) {
          if (jSONLexer.token() == 8) {
            jSONLexer.nextToken(16);
            bool1 = bool;
            str4 = str3;
            paramObject = str2;
            str5 = str1;
          } else if (jSONLexer.token() == 6) {
            jSONLexer.nextToken(16);
            bool1 = bool;
            str4 = str3;
            paramObject = str2;
            str5 = str1;
          } else if (jSONLexer.token() == 7) {
            jSONLexer.nextToken(16);
            bool1 = bool;
            str4 = str3;
            paramObject = str2;
            str5 = str1;
          } else {
            throw new JSONException("syntax error");
          } 
        } else if (str4 == JSON.DEFAULT_TYPE_KEY) {
          if (jSONLexer.token() == 4) {
            str4 = jSONLexer.stringVal();
            if (str4.equals("java.lang.StackTraceElement")) {
              bool1 = bool;
              str4 = str3;
              paramObject = str2;
              str5 = str1;
            } else {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("syntax error : ");
              stringBuilder1.append(str4);
              throw new JSONException(stringBuilder1.toString());
            } 
          } else if (jSONLexer.token() == 8) {
            str5 = str1;
            paramObject = str2;
            str4 = str3;
            bool1 = bool;
          } else {
            throw new JSONException("syntax error");
          } 
        } else {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("syntax error : ");
          stringBuilder1.append(str4);
          throw new JSONException(stringBuilder1.toString());
        } 
        bool = bool1;
        str3 = str4;
        Object object = paramObject;
        str1 = str5;
        if (jSONLexer.token() == 13) {
          jSONLexer.nextToken(16);
          return (T)new StackTraceElement(str4, (String)paramObject, str5, bool1);
        } 
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("syntax error: ");
    stringBuilder.append(JSONToken.name(jSONLexer.token()));
    throw new JSONException(stringBuilder.toString());
  }
  
  public int getFastMatchToken() {
    return 12;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\StackTraceElementDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */