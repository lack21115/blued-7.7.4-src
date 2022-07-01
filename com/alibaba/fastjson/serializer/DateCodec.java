package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCodec extends AbstractDateDeserializer implements ObjectDeserializer, ObjectSerializer {
  public static final DateCodec instance = new DateCodec();
  
  public <T> T cast(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2) {
    if (paramObject2 == null)
      return null; 
    if (paramObject2 instanceof Date)
      return (T)paramObject2; 
    if (paramObject2 instanceof Number)
      return (T)new Date(((Number)paramObject2).longValue()); 
    if (paramObject2 instanceof String) {
      paramObject1 = paramObject2;
      if (paramObject1.length() == 0)
        return null; 
      paramObject2 = new JSONScanner((String)paramObject1);
      try {
        Date date;
        if (paramObject2.scanISO8601DateIfMatch(false)) {
          Calendar calendar = paramObject2.getCalendar();
          if (paramType == Calendar.class)
            return (T)calendar; 
          date = calendar.getTime();
          return (T)date;
        } 
        paramObject2.close();
        return (T)new Date(Long.parseLong((String)paramObject1));
      } finally {
        paramObject2.close();
      } 
    } 
    throw new JSONException("parse error");
  }
  
  public int getFastMatchToken() {
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    DateFormat dateFormat;
    SerializeWriter serializeWriter = paramJSONSerializer.out;
    if (paramObject1 == null) {
      serializeWriter.writeNull();
      return;
    } 
    if (paramObject1 instanceof Date) {
      paramObject2 = paramObject1;
    } else {
      paramObject2 = TypeUtils.castToDate(paramObject1);
    } 
    if (serializeWriter.isEnabled(SerializerFeature.WriteDateUseDateFormat)) {
      dateFormat = paramJSONSerializer.getDateFormat();
      paramObject1 = dateFormat;
      if (dateFormat == null) {
        paramObject1 = new SimpleDateFormat(JSON.DEFFAULT_DATE_FORMAT, paramJSONSerializer.locale);
        paramObject1.setTimeZone(paramJSONSerializer.timeZone);
      } 
      serializeWriter.writeString(paramObject1.format((Date)paramObject2));
      return;
    } 
    if (serializeWriter.isEnabled(SerializerFeature.WriteClassName) && paramObject1.getClass() != dateFormat) {
      if (paramObject1.getClass() == Date.class) {
        serializeWriter.write("new Date(");
        serializeWriter.writeLongAndChar(((Date)paramObject1).getTime(), ')');
        return;
      } 
      serializeWriter.write(123);
      serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY);
      paramJSONSerializer.write(paramObject1.getClass().getName());
      serializeWriter.writeFieldValue(',', "val", ((Date)paramObject1).getTime());
      serializeWriter.write(125);
      return;
    } 
    long l = paramObject2.getTime();
    if (serializeWriter.isEnabled(SerializerFeature.UseISO8601DateFormat)) {
      char[] arrayOfChar;
      if (serializeWriter.isEnabled(SerializerFeature.UseSingleQuotes)) {
        paramInt = 39;
      } else {
        paramInt = 34;
      } 
      serializeWriter.write(paramInt);
      paramObject1 = Calendar.getInstance(paramJSONSerializer.timeZone, paramJSONSerializer.locale);
      paramObject1.setTimeInMillis(l);
      int i = paramObject1.get(1);
      int j = paramObject1.get(2) + 1;
      int k = paramObject1.get(5);
      int m = paramObject1.get(11);
      int n = paramObject1.get(12);
      int i1 = paramObject1.get(13);
      int i2 = paramObject1.get(14);
      if (i2 != 0) {
        arrayOfChar = "0000-00-00T00:00:00.000".toCharArray();
        IOUtils.getChars(i2, 23, arrayOfChar);
        IOUtils.getChars(i1, 19, arrayOfChar);
        IOUtils.getChars(n, 16, arrayOfChar);
        IOUtils.getChars(m, 13, arrayOfChar);
        IOUtils.getChars(k, 10, arrayOfChar);
        IOUtils.getChars(j, 7, arrayOfChar);
        IOUtils.getChars(i, 4, arrayOfChar);
      } else if (i1 == 0 && n == 0 && m == 0) {
        arrayOfChar = "0000-00-00".toCharArray();
        IOUtils.getChars(k, 10, arrayOfChar);
        IOUtils.getChars(j, 7, arrayOfChar);
        IOUtils.getChars(i, 4, arrayOfChar);
      } else {
        arrayOfChar = "0000-00-00T00:00:00".toCharArray();
        IOUtils.getChars(i1, 19, arrayOfChar);
        IOUtils.getChars(n, 16, arrayOfChar);
        IOUtils.getChars(m, 13, arrayOfChar);
        IOUtils.getChars(k, 10, arrayOfChar);
        IOUtils.getChars(j, 7, arrayOfChar);
        IOUtils.getChars(i, 4, arrayOfChar);
      } 
      serializeWriter.write(arrayOfChar);
      i = paramObject1.getTimeZone().getRawOffset() / 3600000;
      if (i == 0) {
        serializeWriter.write(90);
      } else {
        if (i > 0) {
          serializeWriter.append('+').append(String.format("%02d", new Object[] { Integer.valueOf(i) }));
        } else {
          serializeWriter.append('-').append(String.format("%02d", new Object[] { Integer.valueOf(-i) }));
        } 
        serializeWriter.append(":00");
      } 
      serializeWriter.write(paramInt);
      return;
    } 
    serializeWriter.writeLong(l);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\DateCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */