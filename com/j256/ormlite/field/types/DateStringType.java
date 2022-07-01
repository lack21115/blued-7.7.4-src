package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

public class DateStringType extends BaseDateType {
  public static int DEFAULT_WIDTH = 50;
  
  private static final DateStringType singleTon = new DateStringType();
  
  private DateStringType() {
    super(SqlType.STRING, new Class[0]);
  }
  
  protected DateStringType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static DateStringType getSingleton() {
    return singleTon;
  }
  
  public int getDefaultWidth() {
    return DEFAULT_WIDTH;
  }
  
  public Class<?> getPrimaryClass() {
    return byte[].class;
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject) {
    return convertDateStringConfig(paramFieldType, defaultDateFormatConfig).getDateFormat().format((Date)paramObject);
  }
  
  public Object makeConfigObject(FieldType paramFieldType) {
    String str = paramFieldType.getFormat();
    return (str == null) ? defaultDateFormatConfig : new BaseDateType.DateStringFormatConfig(str);
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString) throws SQLException {
    BaseDateType.DateStringFormatConfig dateStringFormatConfig = convertDateStringConfig(paramFieldType, defaultDateFormatConfig);
    try {
      return normalizeDateString(dateStringFormatConfig, paramString);
    } catch (ParseException parseException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Problems with field ");
      stringBuilder.append(paramFieldType);
      stringBuilder.append(" parsing default date-string '");
      stringBuilder.append(paramString);
      stringBuilder.append("' using '");
      stringBuilder.append(dateStringFormatConfig);
      stringBuilder.append("'");
      throw SqlExceptionUtil.create(stringBuilder.toString(), parseException);
    } 
  }
  
  public Object resultStringToJava(FieldType paramFieldType, String paramString, int paramInt) throws SQLException {
    return sqlArgToJava(paramFieldType, paramString, paramInt);
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt) throws SQLException {
    return paramDatabaseResults.getString(paramInt);
  }
  
  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt) throws SQLException {
    paramObject = paramObject;
    BaseDateType.DateStringFormatConfig dateStringFormatConfig = convertDateStringConfig(paramFieldType, defaultDateFormatConfig);
    try {
      return parseDateString(dateStringFormatConfig, (String)paramObject);
    } catch (ParseException parseException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Problems with column ");
      stringBuilder.append(paramInt);
      stringBuilder.append(" parsing date-string '");
      stringBuilder.append((String)paramObject);
      stringBuilder.append("' using '");
      stringBuilder.append(dateStringFormatConfig);
      stringBuilder.append("'");
      throw SqlExceptionUtil.create(stringBuilder.toString(), parseException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\DateStringType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */