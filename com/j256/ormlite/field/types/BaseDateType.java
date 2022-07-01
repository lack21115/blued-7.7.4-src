package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseDateType extends BaseDataType {
  protected static final DateStringFormatConfig defaultDateFormatConfig = new DateStringFormatConfig("yyyy-MM-dd HH:mm:ss.SSSSSS");
  
  protected BaseDateType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  protected static DateStringFormatConfig convertDateStringConfig(FieldType paramFieldType, DateStringFormatConfig paramDateStringFormatConfig) {
    if (paramFieldType == null)
      return paramDateStringFormatConfig; 
    DateStringFormatConfig dateStringFormatConfig = (DateStringFormatConfig)paramFieldType.getDataTypeConfigObj();
    return (dateStringFormatConfig == null) ? paramDateStringFormatConfig : dateStringFormatConfig;
  }
  
  protected static String normalizeDateString(DateStringFormatConfig paramDateStringFormatConfig, String paramString) throws ParseException {
    DateFormat dateFormat = paramDateStringFormatConfig.getDateFormat();
    return dateFormat.format(dateFormat.parse(paramString));
  }
  
  protected static Date parseDateString(DateStringFormatConfig paramDateStringFormatConfig, String paramString) throws ParseException {
    return paramDateStringFormatConfig.getDateFormat().parse(paramString);
  }
  
  public boolean isValidForField(Field paramField) {
    return (paramField.getType() == Date.class);
  }
  
  public boolean isValidForVersion() {
    return true;
  }
  
  public Object moveToNextValue(Object paramObject) {
    long l = System.currentTimeMillis();
    return (paramObject == null) ? new Date(l) : ((l == ((Date)paramObject).getTime()) ? new Date(l + 1L) : new Date(l));
  }
  
  public static class DateStringFormatConfig {
    final String dateFormatStr;
    
    private final ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        protected DateFormat initialValue() {
          return new SimpleDateFormat(BaseDateType.DateStringFormatConfig.this.dateFormatStr);
        }
      };
    
    public DateStringFormatConfig(String param1String) {
      this.dateFormatStr = param1String;
    }
    
    public DateFormat getDateFormat() {
      return this.threadLocal.get();
    }
    
    public String toString() {
      return this.dateFormatStr;
    }
  }
  
  class null extends ThreadLocal<DateFormat> {
    protected DateFormat initialValue() {
      return new SimpleDateFormat(this.this$0.dateFormatStr);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\BaseDateType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */