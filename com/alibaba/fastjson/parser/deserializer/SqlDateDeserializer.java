package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONScanner;
import java.lang.reflect.Type;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class SqlDateDeserializer extends AbstractDateDeserializer implements ObjectDeserializer {
  public static final SqlDateDeserializer instance = new SqlDateDeserializer();
  
  public static final SqlDateDeserializer instance_timestamp = new SqlDateDeserializer(true);
  
  private boolean timestamp = false;
  
  public SqlDateDeserializer() {}
  
  public SqlDateDeserializer(boolean paramBoolean) {
    this.timestamp = true;
  }
  
  protected <T> T cast(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2) {
    if (this.timestamp)
      return castTimestamp(paramDefaultJSONParser, paramType, paramObject1, paramObject2); 
    if (paramObject2 == null)
      return null; 
    if (paramObject2 instanceof Date)
      return (T)new Date(((Date)paramObject2).getTime()); 
    if (paramObject2 instanceof Number)
      return (T)new Date(((Number)paramObject2).longValue()); 
    if (paramObject2 instanceof String) {
      paramObject1 = paramObject2;
      if (paramObject1.length() == 0)
        return null; 
      JSONScanner jSONScanner = new JSONScanner((String)paramObject1);
      try {
        long l;
        if (jSONScanner.scanISO8601DateIfMatch()) {
          l = jSONScanner.getCalendar().getTimeInMillis();
        } else {
          DateFormat dateFormat = paramDefaultJSONParser.getDateFormat();
          try {
            return (T)new Date(dateFormat.parse((String)paramObject1).getTime());
          } catch (ParseException parseException) {
            l = Long.parseLong((String)paramObject1);
          } 
        } 
        return (T)new Date(l);
      } finally {
        jSONScanner.close();
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("parse error : ");
    stringBuilder.append(paramObject2);
    throw new JSONException(stringBuilder.toString());
  }
  
  protected <T> T castTimestamp(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2) {
    if (paramObject2 == null)
      return null; 
    if (paramObject2 instanceof Date)
      return (T)new Timestamp(((Date)paramObject2).getTime()); 
    if (paramObject2 instanceof Number)
      return (T)new Timestamp(((Number)paramObject2).longValue()); 
    if (paramObject2 instanceof String) {
      paramObject1 = paramObject2;
      if (paramObject1.length() == 0)
        return null; 
      JSONScanner jSONScanner = new JSONScanner((String)paramObject1);
      try {
        long l;
        if (jSONScanner.scanISO8601DateIfMatch()) {
          l = jSONScanner.getCalendar().getTimeInMillis();
        } else {
          DateFormat dateFormat = paramDefaultJSONParser.getDateFormat();
          try {
            return (T)new Timestamp(dateFormat.parse((String)paramObject1).getTime());
          } catch (ParseException parseException) {
            l = Long.parseLong((String)paramObject1);
          } 
        } 
        return (T)new Timestamp(l);
      } finally {
        jSONScanner.close();
      } 
    } 
    throw new JSONException("parse error");
  }
  
  public int getFastMatchToken() {
    return 2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\SqlDateDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */