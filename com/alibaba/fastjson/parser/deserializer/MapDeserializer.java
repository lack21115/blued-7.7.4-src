package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MapDeserializer implements ObjectDeserializer {
  public static MapDeserializer instance = new MapDeserializer();
  
  public static Object parseMap(DefaultJSONParser paramDefaultJSONParser, Map<Object, Object> paramMap, Type paramType1, Type paramType2, Object paramObject) {
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    if (jSONLexer.token() == 12 || jSONLexer.token() == 16) {
      ObjectDeserializer objectDeserializer1 = paramDefaultJSONParser.getConfig().getDeserializer(paramType1);
      ObjectDeserializer objectDeserializer2 = paramDefaultJSONParser.getConfig().getDeserializer(paramType2);
      jSONLexer.nextToken(objectDeserializer1.getFastMatchToken());
      paramObject = paramDefaultJSONParser.getContext();
      try {
        while (true) {
          if (jSONLexer.token() == 13) {
            jSONLexer.nextToken(16);
            return paramMap;
          } 
          int i = jSONLexer.token();
          Object object = null;
          if (i == 4 && jSONLexer.isRef() && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
            jSONLexer.nextTokenWithColon(4);
            if (jSONLexer.token() == 4) {
              Object object1 = jSONLexer.stringVal();
              if ("..".equals(object1)) {
                object1 = ((ParseContext)paramObject).parent.object;
              } else if ("$".equals(object1)) {
                for (object1 = paramObject; ((ParseContext)object1).parent != null; object1 = ((ParseContext)object1).parent);
                object1 = ((ParseContext)object1).object;
              } else {
                paramDefaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask((ParseContext)paramObject, (String)object1));
                paramDefaultJSONParser.setResolveStatus(1);
                object1 = object;
              } 
              jSONLexer.nextToken(13);
              if (jSONLexer.token() == 13) {
                jSONLexer.nextToken(16);
                return object1;
              } 
              throw new JSONException("illegal ref");
            } 
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("illegal ref, ");
            stringBuilder1.append(JSONToken.name(jSONLexer.token()));
            throw new JSONException(stringBuilder1.toString());
          } 
          if (stringBuilder1.size() == 0 && jSONLexer.token() == 4 && JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal()) && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
            jSONLexer.nextTokenWithColon(4);
            jSONLexer.nextToken(16);
            if (jSONLexer.token() == 13) {
              jSONLexer.nextToken();
              return stringBuilder1;
            } 
            jSONLexer.nextToken(objectDeserializer1.getFastMatchToken());
          } 
          object = objectDeserializer1.deserialze(paramDefaultJSONParser, paramType1, null);
          if (jSONLexer.token() == 17) {
            jSONLexer.nextToken(objectDeserializer2.getFastMatchToken());
            Object object1 = objectDeserializer2.deserialze(paramDefaultJSONParser, paramType2, object);
            paramDefaultJSONParser.checkMapResolve((Map)stringBuilder1, object);
            stringBuilder1.put(object, object1);
            if (jSONLexer.token() == 16)
              jSONLexer.nextToken(objectDeserializer1.getFastMatchToken()); 
            continue;
          } 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("syntax error, expect :, actual ");
          stringBuilder1.append(jSONLexer.token());
          throw new JSONException(stringBuilder1.toString());
        } 
      } finally {
        paramDefaultJSONParser.setContext((ParseContext)paramObject);
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("syntax error, expect {, actual ");
    stringBuilder.append(jSONLexer.tokenName());
    throw new JSONException(stringBuilder.toString());
  }
  
  public static Map parseMap(DefaultJSONParser paramDefaultJSONParser, Map<String, Object> paramMap, Type paramType, Object paramObject) {
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    if (jSONLexer.token() == 12) {
      ParseContext parseContext = paramDefaultJSONParser.getContext();
      int i = 0;
      try {
        while (true) {
          StringBuilder stringBuilder1;
          Map<Class<?>, Object> map;
          String str;
          Class<?> clazz;
          jSONLexer.skipWhitespace();
          char c = jSONLexer.getCurrent();
          char c1 = c;
          if (jSONLexer.isEnabled(Feature.AllowArbitraryCommas))
            while (true) {
              c1 = c;
              if (c == ',') {
                jSONLexer.next();
                jSONLexer.skipWhitespace();
                c = jSONLexer.getCurrent();
                continue;
              } 
              break;
            }  
          if (c1 == '"') {
            str = jSONLexer.scanSymbol(paramDefaultJSONParser.getSymbolTable(), '"');
            jSONLexer.skipWhitespace();
            if (jSONLexer.getCurrent() != ':') {
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append("expect ':' at ");
              stringBuilder1.append(jSONLexer.pos());
              throw new JSONException(stringBuilder1.toString());
            } 
          } else {
            if (c1 == '}') {
              jSONLexer.next();
              jSONLexer.resetStringPosition();
              jSONLexer.nextToken(16);
              return (Map)stringBuilder1;
            } 
            if (c1 == '\'') {
              if (jSONLexer.isEnabled(Feature.AllowSingleQuotes)) {
                str = jSONLexer.scanSymbol(paramDefaultJSONParser.getSymbolTable(), '\'');
                jSONLexer.skipWhitespace();
                if (jSONLexer.getCurrent() != ':') {
                  stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("expect ':' at ");
                  stringBuilder1.append(jSONLexer.pos());
                  throw new JSONException(stringBuilder1.toString());
                } 
              } else {
                throw new JSONException("syntax error");
              } 
            } else if (jSONLexer.isEnabled(Feature.AllowUnQuotedFieldNames)) {
              str = jSONLexer.scanSymbolUnQuoted(paramDefaultJSONParser.getSymbolTable());
              jSONLexer.skipWhitespace();
              char c2 = jSONLexer.getCurrent();
              if (c2 != ':') {
                stringBuilder1 = new StringBuilder();
                stringBuilder1.append("expect ':' at ");
                stringBuilder1.append(jSONLexer.pos());
                stringBuilder1.append(", actual ");
                stringBuilder1.append(c2);
                throw new JSONException(stringBuilder1.toString());
              } 
            } else {
              throw new JSONException("syntax error");
            } 
          } 
          jSONLexer.next();
          jSONLexer.skipWhitespace();
          jSONLexer.getCurrent();
          jSONLexer.resetStringPosition();
          if (str == JSON.DEFAULT_TYPE_KEY && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
            clazz = TypeUtils.loadClass(jSONLexer.scanSymbol(paramDefaultJSONParser.getSymbolTable(), '"'), paramDefaultJSONParser.getConfig().getDefaultClassLoader());
            if (Map.class.isAssignableFrom(clazz)) {
              jSONLexer.nextToken(16);
              if (jSONLexer.token() == 13) {
                jSONLexer.nextToken(16);
                return (Map)stringBuilder1;
              } 
            } else {
              ObjectDeserializer objectDeserializer = paramDefaultJSONParser.getConfig().getDeserializer(clazz);
              jSONLexer.nextToken(16);
              paramDefaultJSONParser.setResolveStatus(2);
              if (parseContext != null && !(paramObject instanceof Integer))
                paramDefaultJSONParser.popContext(); 
              map = objectDeserializer.<Map>deserialze(paramDefaultJSONParser, clazz, paramObject);
              return map;
            } 
          } else {
            Object object;
            jSONLexer.nextToken();
            if (i)
              paramDefaultJSONParser.setContext(parseContext); 
            if (jSONLexer.token() == 8) {
              object = null;
              jSONLexer.nextToken();
            } else {
              object = paramDefaultJSONParser.parseObject(paramType, clazz);
            } 
            map.put(clazz, object);
            paramDefaultJSONParser.checkMapResolve(map, clazz);
            paramDefaultJSONParser.setContext(parseContext, object, clazz);
            paramDefaultJSONParser.setContext(parseContext);
            int j = jSONLexer.token();
            if (j != 20) {
              if (j == 15)
                return map; 
              if (j == 13) {
                jSONLexer.nextToken();
                return map;
              } 
            } else {
              continue;
            } 
          } 
          i++;
        } 
      } finally {
        paramDefaultJSONParser.setContext(parseContext);
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("syntax error, expect {, actual ");
    stringBuilder.append(jSONLexer.token());
    throw new JSONException(stringBuilder.toString());
  }
  
  protected Map<Object, Object> createMap(Type paramType) {
    if (paramType == Properties.class)
      return new Properties(); 
    if (paramType == Hashtable.class)
      return new Hashtable<Object, Object>(); 
    if (paramType == IdentityHashMap.class)
      return new IdentityHashMap<Object, Object>(); 
    if (paramType == SortedMap.class || paramType == TreeMap.class)
      return new TreeMap<Object, Object>(); 
    if (paramType == ConcurrentMap.class || paramType == ConcurrentHashMap.class)
      return new ConcurrentHashMap<Object, Object>(); 
    if (paramType == Map.class || paramType == HashMap.class)
      return new HashMap<Object, Object>(); 
    if (paramType == LinkedHashMap.class)
      return new LinkedHashMap<Object, Object>(); 
    if (paramType instanceof ParameterizedType)
      return createMap(((ParameterizedType)paramType).getRawType()); 
    Class<Map> clazz = (Class)paramType;
    if (!clazz.isInterface())
      try {
        return clazz.newInstance();
      } catch (Exception exception) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("unsupport type ");
        stringBuilder1.append(paramType);
        throw new JSONException(stringBuilder1.toString(), exception);
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("unsupport type ");
    stringBuilder.append(paramType);
    throw new JSONException(stringBuilder.toString());
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    if (paramType == JSONObject.class && paramDefaultJSONParser.getFieldTypeResolver() == null)
      return (T)paramDefaultJSONParser.parseObject(); 
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    if (jSONLexer.token() == 8) {
      jSONLexer.nextToken(16);
      return null;
    } 
    Map<Object, Object> map = createMap(paramType);
    ParseContext parseContext = paramDefaultJSONParser.getContext();
    try {
      paramDefaultJSONParser.setContext(parseContext, map, paramObject);
      return (T)deserialze(paramDefaultJSONParser, paramType, paramObject, map);
    } finally {
      paramDefaultJSONParser.setContext(parseContext);
    } 
  }
  
  protected Object deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject, Map<String, Object> paramMap) {
    if (paramType instanceof ParameterizedType) {
      ParameterizedType parameterizedType = (ParameterizedType)paramType;
      paramType = parameterizedType.getActualTypeArguments()[0];
      Type type = parameterizedType.getActualTypeArguments()[1];
      return (String.class == paramType) ? parseMap(paramDefaultJSONParser, paramMap, type, paramObject) : parseMap(paramDefaultJSONParser, (Map)paramMap, paramType, type, paramObject);
    } 
    return paramDefaultJSONParser.parseObject(paramMap, paramObject);
  }
  
  public int getFastMatchToken() {
    return 12;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\MapDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */