package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

public class DateType extends BaseDateType {
  private static final DateType singleTon = new DateType();
  
  private DateType() {
    super(SqlType.DATE, new Class[] { Date.class });
  }
  
  protected DateType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static DateType getSingleton() {
    return singleTon;
  }
  
  protected BaseDateType.DateStringFormatConfig getDefaultDateFormatConfig() {
    return defaultDateFormatConfig;
  }
  
  public boolean isArgumentHolderRequired() {
    return true;
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject) {
    return new Timestamp(((Date)paramObject).getTime());
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString) throws SQLException {
    BaseDateType.DateStringFormatConfig dateStringFormatConfig = convertDateStringConfig(paramFieldType, getDefaultDateFormatConfig());
    try {
      return new Timestamp(parseDateString(dateStringFormatConfig, paramString).getTime());
    } catch (ParseException parseException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Problems parsing default date string '");
      stringBuilder.append(paramString);
      stringBuilder.append("' using '");
      stringBuilder.append(dateStringFormatConfig);
      stringBuilder.append('\'');
      throw SqlExceptionUtil.create(stringBuilder.toString(), parseException);
    } 
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt) throws SQLException {
    return paramDatabaseResults.getTimestamp(paramInt);
  }
  
  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt) {
    return new Date(((Timestamp)paramObject).getTime());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\DateType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */