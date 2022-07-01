package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;

public class CalendarCodec implements ObjectDeserializer, ObjectSerializer {
  public static final CalendarCodec instance = new CalendarCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    Object object = DateCodec.instance.deserialze(paramDefaultJSONParser, paramType, paramObject);
    if (object instanceof Calendar)
      return (T)object; 
    object = object;
    if (object == null)
      return null; 
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    Calendar calendar = Calendar.getInstance(jSONLexer.getTimeZone(), jSONLexer.getLocale());
    calendar.setTime((Date)object);
    return (T)calendar;
  }
  
  public int getFastMatchToken() {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    char[] arrayOfChar;
    paramObject2 = paramJSONSerializer.out;
    if (paramObject1 == null) {
      paramObject2.writeNull();
      return;
    } 
    paramObject1 = paramObject1;
    if (paramObject2.isEnabled(SerializerFeature.UseISO8601DateFormat)) {
      byte b;
      if (paramObject2.isEnabled(SerializerFeature.UseSingleQuotes)) {
        b = 39;
      } else {
        b = 34;
      } 
      paramObject2.append(b);
      paramInt = paramObject1.get(1);
      int i = paramObject1.get(2) + 1;
      int j = paramObject1.get(5);
      int k = paramObject1.get(11);
      int m = paramObject1.get(12);
      int n = paramObject1.get(13);
      int i1 = paramObject1.get(14);
      if (i1 != 0) {
        arrayOfChar = "0000-00-00T00:00:00.000".toCharArray();
        IOUtils.getChars(i1, 23, arrayOfChar);
        IOUtils.getChars(n, 19, arrayOfChar);
        IOUtils.getChars(m, 16, arrayOfChar);
        IOUtils.getChars(k, 13, arrayOfChar);
        IOUtils.getChars(j, 10, arrayOfChar);
        IOUtils.getChars(i, 7, arrayOfChar);
        IOUtils.getChars(paramInt, 4, arrayOfChar);
      } else if (n == 0 && m == 0 && k == 0) {
        arrayOfChar = "0000-00-00".toCharArray();
        IOUtils.getChars(j, 10, arrayOfChar);
        IOUtils.getChars(i, 7, arrayOfChar);
        IOUtils.getChars(paramInt, 4, arrayOfChar);
      } else {
        arrayOfChar = "0000-00-00T00:00:00".toCharArray();
        IOUtils.getChars(n, 19, arrayOfChar);
        IOUtils.getChars(m, 16, arrayOfChar);
        IOUtils.getChars(k, 13, arrayOfChar);
        IOUtils.getChars(j, 10, arrayOfChar);
        IOUtils.getChars(i, 7, arrayOfChar);
        IOUtils.getChars(paramInt, 4, arrayOfChar);
      } 
      paramObject2.write(arrayOfChar);
      paramInt = paramObject1.getTimeZone().getRawOffset() / 3600000;
      if (paramInt == 0) {
        paramObject2.append("Z");
      } else if (paramInt > 0) {
        paramObject2.append("+").append(String.format("%02d", new Object[] { Integer.valueOf(paramInt) })).append(":00");
      } else {
        paramObject2.append("-").append(String.format("%02d", new Object[] { Integer.valueOf(-paramInt) })).append(":00");
      } 
      paramObject2.append(b);
      return;
    } 
    arrayOfChar.write(paramObject1.getTime());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\CalendarCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */