package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

public class MiscCodec implements ObjectDeserializer, ObjectSerializer {
  public static final MiscCodec instance = new MiscCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    Object object;
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    paramObject = null;
    int i = 0;
    if (paramType == InetSocketAddress.class) {
      if (jSONLexer.token() == 8) {
        jSONLexer.nextToken();
        return null;
      } 
      paramDefaultJSONParser.accept(12);
      object = paramObject;
      while (true) {
        paramObject = jSONLexer.stringVal();
        jSONLexer.nextToken(17);
        if (paramObject.equals("address")) {
          paramDefaultJSONParser.accept(17);
          object = paramDefaultJSONParser.parseObject(InetAddress.class);
        } else if (paramObject.equals("port")) {
          paramDefaultJSONParser.accept(17);
          if (jSONLexer.token() == 2) {
            i = jSONLexer.intValue();
            jSONLexer.nextToken();
          } else {
            throw new JSONException("port is not int");
          } 
        } else {
          paramDefaultJSONParser.accept(17);
          paramDefaultJSONParser.parse();
        } 
        if (jSONLexer.token() == 16) {
          jSONLexer.nextToken();
          continue;
        } 
        paramDefaultJSONParser.accept(13);
        return (T)new InetSocketAddress((InetAddress)object, i);
      } 
    } 
    if (paramDefaultJSONParser.resolveStatus == 2) {
      paramDefaultJSONParser.resolveStatus = 0;
      paramDefaultJSONParser.accept(16);
      if (jSONLexer.token() == 4) {
        if ("val".equals(jSONLexer.stringVal())) {
          jSONLexer.nextToken();
          paramDefaultJSONParser.accept(17);
          paramObject = paramDefaultJSONParser.parse();
          paramDefaultJSONParser.accept(13);
        } else {
          throw new JSONException("syntax error");
        } 
      } else {
        throw new JSONException("syntax error");
      } 
    } else {
      paramObject = paramDefaultJSONParser.parse();
    } 
    if (paramObject == null) {
      paramObject = null;
    } else if (paramObject instanceof String) {
      paramObject = paramObject;
    } else {
      throw new JSONException("expect string");
    } 
    if (paramObject != null) {
      if (paramObject.length() == 0)
        return null; 
      if (object == UUID.class)
        return (T)UUID.fromString((String)paramObject); 
      if (object == URI.class)
        return (T)URI.create((String)paramObject); 
      if (object == URL.class)
        try {
          return (T)new URL((String)paramObject);
        } catch (MalformedURLException malformedURLException) {
          throw new JSONException("create url error", malformedURLException);
        }  
      if (object == Pattern.class)
        return (T)Pattern.compile((String)paramObject); 
      if (object == Locale.class) {
        String[] arrayOfString = paramObject.split("_");
        return (T)((arrayOfString.length == 1) ? new Locale(arrayOfString[0]) : ((arrayOfString.length == 2) ? new Locale(arrayOfString[0], arrayOfString[1]) : new Locale(arrayOfString[0], arrayOfString[1], arrayOfString[2])));
      } 
      if (object == SimpleDateFormat.class) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat((String)paramObject, jSONLexer.getLocale());
        simpleDateFormat.setTimeZone(jSONLexer.getTimeZone());
        return (T)simpleDateFormat;
      } 
      if (object == InetAddress.class || object == Inet4Address.class || object == Inet6Address.class)
        try {
          return (T)InetAddress.getByName((String)paramObject);
        } catch (UnknownHostException unknownHostException) {
          throw new JSONException("deserialize inet adress error", unknownHostException);
        }  
      if (object == File.class)
        return (T)new File((String)paramObject); 
      if (object == TimeZone.class)
        return (T)TimeZone.getTimeZone((String)paramObject); 
      Object object1 = object;
      if (object instanceof ParameterizedType)
        object1 = ((ParameterizedType)object).getRawType(); 
      if (object1 == Class.class)
        return (T)TypeUtils.loadClass((String)paramObject, unknownHostException.getConfig().getDefaultClassLoader()); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("MiscCodec not support ");
      stringBuilder.append(object1);
      throw new JSONException(stringBuilder.toString());
    } 
    return null;
  }
  
  public int getFastMatchToken() {
    return 4;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object<?> paramObject2, Type paramType, int paramInt) throws IOException {
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      serializeWriter.writeNull();
      return;
    } 
    paramObject2 = (Object<?>)paramObject1.getClass();
    if (paramObject2 == SimpleDateFormat.class) {
      String str = ((SimpleDateFormat)paramObject1).toPattern();
      paramObject2 = (Object<?>)str;
      if (serializeWriter.isEnabled(SerializerFeature.WriteClassName)) {
        paramObject2 = (Object<?>)str;
        if (paramObject1.getClass() != paramType) {
          serializeWriter.write(123);
          serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
          paramJSONSerializer.write(paramObject1.getClass().getName());
          serializeWriter.writeFieldValue(',', "val", str);
          serializeWriter.write(125);
          return;
        } 
      } 
    } else if (paramObject2 == Class.class) {
      paramObject2 = (Object<?>)((Class)paramObject1).getName();
    } else {
      if (paramObject2 == InetSocketAddress.class) {
        paramObject1 = paramObject1;
        paramObject2 = (Object<?>)paramObject1.getAddress();
        serializeWriter.write(123);
        if (paramObject2 != null) {
          serializeWriter.writeFieldName("address");
          paramJSONSerializer.write(paramObject2);
          serializeWriter.write(44);
        } 
        serializeWriter.writeFieldName("port");
        serializeWriter.writeInt(paramObject1.getPort());
        serializeWriter.write(125);
        return;
      } 
      if (paramObject1 instanceof File) {
        paramObject2 = (Object<?>)((File)paramObject1).getPath();
      } else if (paramObject1 instanceof InetAddress) {
        paramObject2 = (Object<?>)((InetAddress)paramObject1).getHostAddress();
      } else if (paramObject1 instanceof TimeZone) {
        paramObject2 = (Object<?>)((TimeZone)paramObject1).getID();
      } else {
        if (paramObject1 instanceof JSONStreamAware) {
          ((JSONStreamAware)paramObject1).writeJSONString(serializeWriter);
          return;
        } 
        if (paramObject1 instanceof Iterator) {
          writeIterator(paramJSONSerializer, serializeWriter, (Iterator)paramObject1);
          return;
        } 
        if (paramObject1 instanceof Iterable) {
          writeIterator(paramJSONSerializer, serializeWriter, ((Iterable)paramObject1).iterator());
          return;
        } 
        paramObject2 = (Object<?>)paramObject1.toString();
      } 
    } 
    serializeWriter.writeString((String)paramObject2);
  }
  
  protected void writeIterator(JSONSerializer paramJSONSerializer, SerializeWriter paramSerializeWriter, Iterator<?> paramIterator) {
    paramSerializeWriter.write(91);
    int i;
    for (i = 0; paramIterator.hasNext(); i++) {
      if (i)
        paramSerializeWriter.write(44); 
      paramJSONSerializer.write(paramIterator.next());
    } 
    paramSerializeWriter.write(93);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\MiscCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */