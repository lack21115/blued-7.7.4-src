package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.Date;

public class DateLongType extends BaseDateType {
  private static final DateLongType singleTon = new DateLongType();
  
  private DateLongType() {
    super(SqlType.LONG, new Class[0]);
  }
  
  protected DateLongType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static DateLongType getSingleton() {
    return singleTon;
  }
  
  public Class<?> getPrimaryClass() {
    return Date.class;
  }
  
  public boolean isEscapedValue() {
    return false;
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject) {
    return Long.valueOf(((Date)paramObject).getTime());
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString) throws SQLException {
    try {
      long l = Long.parseLong(paramString);
      return Long.valueOf(l);
    } catch (NumberFormatException numberFormatException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Problems with field ");
      stringBuilder.append(paramFieldType);
      stringBuilder.append(" parsing default date-long value: ");
      stringBuilder.append(paramString);
      throw SqlExceptionUtil.create(stringBuilder.toString(), numberFormatException);
    } 
  }
  
  public Object resultStringToJava(FieldType paramFieldType, String paramString, int paramInt) {
    return sqlArgToJava(paramFieldType, Long.valueOf(Long.parseLong(paramString)), paramInt);
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt) throws SQLException {
    return Long.valueOf(paramDatabaseResults.getLong(paramInt));
  }
  
  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt) {
    return new Date(((Long)paramObject).longValue());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\DateLongType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */