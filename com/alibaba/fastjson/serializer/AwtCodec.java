package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.lang.reflect.Type;

public class AwtCodec implements ObjectDeserializer, ObjectSerializer {
  public static final AwtCodec instance = new AwtCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    paramObject = paramDefaultJSONParser.lexer;
    if (paramObject.token() == 8) {
      paramObject.nextToken(16);
      return null;
    } 
    if (paramObject.token() == 12 || paramObject.token() == 16) {
      paramObject.nextToken();
      if (paramType == Point.class)
        return (T)parsePoint(paramDefaultJSONParser); 
      if (paramType == Rectangle.class)
        return (T)parseRectangle(paramDefaultJSONParser); 
      if (paramType == Color.class)
        return (T)parseColor(paramDefaultJSONParser); 
      if (paramType == Font.class)
        return (T)parseFont(paramDefaultJSONParser); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("not support awt class : ");
      stringBuilder.append(paramType);
      throw new JSONException(stringBuilder.toString());
    } 
    throw new JSONException("syntax error");
  }
  
  public int getFastMatchToken() {
    return 12;
  }
  
  protected Color parseColor(DefaultJSONParser paramDefaultJSONParser) {
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    int j = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    int i = 0;
    while (true) {
      if (jSONLexer.token() == 13) {
        jSONLexer.nextToken();
        return new Color(j, bool2, bool1, i);
      } 
      if (jSONLexer.token() == 4) {
        String str = jSONLexer.stringVal();
        jSONLexer.nextTokenWithColon(2);
        if (jSONLexer.token() == 2) {
          boolean bool3;
          boolean bool4;
          int m;
          StringBuilder stringBuilder;
          int k = jSONLexer.intValue();
          jSONLexer.nextToken();
          if (str.equalsIgnoreCase("r")) {
            bool3 = bool2;
            bool4 = bool1;
            m = i;
          } else if (str.equalsIgnoreCase("g")) {
            bool3 = k;
            k = j;
            bool4 = bool1;
            m = i;
          } else if (str.equalsIgnoreCase("b")) {
            bool4 = k;
            k = j;
            bool3 = bool2;
            m = i;
          } else if (str.equalsIgnoreCase("alpha")) {
            m = k;
            bool4 = bool1;
            bool3 = bool2;
            k = j;
          } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("syntax error, ");
            stringBuilder.append(str);
            throw new JSONException(stringBuilder.toString());
          } 
          j = k;
          bool2 = bool3;
          bool1 = bool4;
          i = m;
          if (stringBuilder.token() == 16) {
            stringBuilder.nextToken(4);
            j = k;
            bool2 = bool3;
            bool1 = bool4;
            i = m;
          } 
          continue;
        } 
        throw new JSONException("syntax error");
      } 
      throw new JSONException("syntax error");
    } 
  }
  
  protected Font parseFont(DefaultJSONParser paramDefaultJSONParser) {
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    boolean bool = false;
    paramDefaultJSONParser = null;
    int i = 0;
    while (true) {
      if (jSONLexer.token() == 13) {
        jSONLexer.nextToken();
        return new Font((String)paramDefaultJSONParser, bool, i);
      } 
      if (jSONLexer.token() == 4) {
        boolean bool1;
        int j;
        DefaultJSONParser defaultJSONParser;
        String str = jSONLexer.stringVal();
        jSONLexer.nextTokenWithColon(2);
        if (str.equalsIgnoreCase("name")) {
          if (jSONLexer.token() == 4) {
            str = jSONLexer.stringVal();
            jSONLexer.nextToken();
            bool1 = bool;
            j = i;
          } else {
            throw new JSONException("syntax error");
          } 
        } else if (str.equalsIgnoreCase("style")) {
          if (jSONLexer.token() == 2) {
            bool1 = jSONLexer.intValue();
            jSONLexer.nextToken();
            defaultJSONParser = paramDefaultJSONParser;
            j = i;
          } else {
            throw new JSONException("syntax error");
          } 
        } else if (defaultJSONParser.equalsIgnoreCase("size")) {
          if (jSONLexer.token() == 2) {
            j = jSONLexer.intValue();
            jSONLexer.nextToken();
            defaultJSONParser = paramDefaultJSONParser;
            bool1 = bool;
          } else {
            throw new JSONException("syntax error");
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("syntax error, ");
          stringBuilder.append((String)defaultJSONParser);
          throw new JSONException(stringBuilder.toString());
        } 
        bool = bool1;
        paramDefaultJSONParser = defaultJSONParser;
        i = j;
        if (jSONLexer.token() == 16) {
          jSONLexer.nextToken(4);
          bool = bool1;
          paramDefaultJSONParser = defaultJSONParser;
          i = j;
        } 
        continue;
      } 
      throw new JSONException("syntax error");
    } 
  }
  
  protected Point parsePoint(DefaultJSONParser paramDefaultJSONParser) {
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    int j = 0;
    int i = 0;
    while (true) {
      if (jSONLexer.token() == 13) {
        jSONLexer.nextToken();
        return new Point(j, i);
      } 
      if (jSONLexer.token() == 4) {
        String str = jSONLexer.stringVal();
        if (JSON.DEFAULT_TYPE_KEY.equals(str)) {
          paramDefaultJSONParser.acceptType("java.awt.Point");
          continue;
        } 
        jSONLexer.nextTokenWithColon(2);
        if (jSONLexer.token() == 2) {
          int m;
          int k = jSONLexer.intValue();
          jSONLexer.nextToken();
          if (str.equalsIgnoreCase("x")) {
            m = i;
          } else if (str.equalsIgnoreCase("y")) {
            m = k;
            k = j;
          } else {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("syntax error, ");
            stringBuilder1.append(str);
            throw new JSONException(stringBuilder1.toString());
          } 
          j = k;
          i = m;
          if (jSONLexer.token() == 16) {
            jSONLexer.nextToken(4);
            j = k;
            i = m;
          } 
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("syntax error : ");
        stringBuilder.append(jSONLexer.tokenName());
        throw new JSONException(stringBuilder.toString());
      } 
      throw new JSONException("syntax error");
    } 
  }
  
  protected Rectangle parseRectangle(DefaultJSONParser paramDefaultJSONParser) {
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    int j = 0;
    boolean bool2 = false;
    boolean bool1 = false;
    int i = 0;
    while (true) {
      if (jSONLexer.token() == 13) {
        jSONLexer.nextToken();
        return new Rectangle(j, bool2, bool1, i);
      } 
      if (jSONLexer.token() == 4) {
        String str = jSONLexer.stringVal();
        jSONLexer.nextTokenWithColon(2);
        if (jSONLexer.token() == 2) {
          boolean bool3;
          boolean bool4;
          int m;
          StringBuilder stringBuilder;
          int k = jSONLexer.intValue();
          jSONLexer.nextToken();
          if (str.equalsIgnoreCase("x")) {
            bool3 = bool2;
            bool4 = bool1;
            m = i;
          } else if (str.equalsIgnoreCase("y")) {
            bool3 = k;
            k = j;
            bool4 = bool1;
            m = i;
          } else if (str.equalsIgnoreCase("width")) {
            bool4 = k;
            k = j;
            bool3 = bool2;
            m = i;
          } else if (str.equalsIgnoreCase("height")) {
            m = k;
            bool4 = bool1;
            bool3 = bool2;
            k = j;
          } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("syntax error, ");
            stringBuilder.append(str);
            throw new JSONException(stringBuilder.toString());
          } 
          j = k;
          bool2 = bool3;
          bool1 = bool4;
          i = m;
          if (stringBuilder.token() == 16) {
            stringBuilder.nextToken(4);
            j = k;
            bool2 = bool3;
            bool1 = bool4;
            i = m;
          } 
          continue;
        } 
        throw new JSONException("syntax error");
      } 
      throw new JSONException("syntax error");
    } 
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    StringBuilder stringBuilder;
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      serializeWriter.writeNull();
      return;
    } 
    if (paramObject1 instanceof Point) {
      paramObject1 = paramObject1;
      serializeWriter.writeFieldValue(writeClassName(serializeWriter, Point.class, '{'), "x", paramObject1.getX());
      serializeWriter.writeFieldValue(',', "y", paramObject1.getY());
    } else if (paramObject1 instanceof Font) {
      paramObject1 = paramObject1;
      serializeWriter.writeFieldValue(writeClassName(serializeWriter, Font.class, '{'), "name", paramObject1.getName());
      serializeWriter.writeFieldValue(',', "style", paramObject1.getStyle());
      serializeWriter.writeFieldValue(',', "size", paramObject1.getSize());
    } else if (paramObject1 instanceof Rectangle) {
      paramObject1 = paramObject1;
      serializeWriter.writeFieldValue(writeClassName(serializeWriter, Rectangle.class, '{'), "x", paramObject1.getX());
      serializeWriter.writeFieldValue(',', "y", paramObject1.getY());
      serializeWriter.writeFieldValue(',', "width", paramObject1.getWidth());
      serializeWriter.writeFieldValue(',', "height", paramObject1.getHeight());
    } else if (paramObject1 instanceof Color) {
      paramObject1 = paramObject1;
      serializeWriter.writeFieldValue(writeClassName(serializeWriter, Color.class, '{'), "r", paramObject1.getRed());
      serializeWriter.writeFieldValue(',', "g", paramObject1.getGreen());
      serializeWriter.writeFieldValue(',', "b", paramObject1.getBlue());
      if (paramObject1.getAlpha() > 0)
        serializeWriter.writeFieldValue(',', "alpha", paramObject1.getAlpha()); 
    } else {
      stringBuilder = new StringBuilder();
      stringBuilder.append("not support awt class : ");
      stringBuilder.append(paramObject1.getClass().getName());
      throw new JSONException(stringBuilder.toString());
    } 
    stringBuilder.write(125);
  }
  
  protected char writeClassName(SerializeWriter paramSerializeWriter, Class<?> paramClass, char paramChar) {
    if (paramSerializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
      paramSerializeWriter.write(123);
      paramSerializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
      paramSerializeWriter.writeString(paramClass.getName());
      paramChar = ',';
    } 
    return paramChar;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\AwtCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */