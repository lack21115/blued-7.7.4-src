package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.SQLException;

public class DateTimeType extends BaseDataType {
  private static final String[] associatedClassNames;
  
  private static Class<?> dateTimeClass;
  
  private static Method getMillisMethod;
  
  private static Constructor<?> millisConstructor;
  
  private static final DateTimeType singleTon = new DateTimeType();
  
  static {
    dateTimeClass = null;
    getMillisMethod = null;
    millisConstructor = null;
    associatedClassNames = new String[] { "org.joda.time.DateTime" };
  }
  
  private DateTimeType() {
    super(SqlType.LONG, new Class[0]);
  }
  
  protected DateTimeType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  private Constructor<?> getConstructor() throws Exception {
    if (millisConstructor == null)
      millisConstructor = getDateTimeClass().getConstructor(new Class[] { long.class }); 
    return millisConstructor;
  }
  
  private Class<?> getDateTimeClass() throws ClassNotFoundException {
    if (dateTimeClass == null)
      dateTimeClass = Class.forName("org.joda.time.DateTime"); 
    return dateTimeClass;
  }
  
  private Method getMillisMethod() throws Exception {
    if (getMillisMethod == null)
      getMillisMethod = getDateTimeClass().getMethod("getMillis", new Class[0]); 
    return getMillisMethod;
  }
  
  public static DateTimeType getSingleton() {
    return singleTon;
  }
  
  public String[] getAssociatedClassNames() {
    return associatedClassNames;
  }
  
  public Class<?> getPrimaryClass() {
    try {
      return getDateTimeClass();
    } catch (ClassNotFoundException classNotFoundException) {
      return null;
    } 
  }
  
  public boolean isAppropriateId() {
    return false;
  }
  
  public boolean isEscapedValue() {
    return false;
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject) throws SQLException {
    try {
      Method method = getMillisMethod();
      return (paramObject == null) ? null : method.invoke(paramObject, new Object[0]);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not use reflection to get millis from Joda DateTime: ");
      stringBuilder.append(paramObject);
      throw SqlExceptionUtil.create(stringBuilder.toString(), exception);
    } 
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString) {
    return Long.valueOf(Long.parseLong(paramString));
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt) throws SQLException {
    return Long.valueOf(paramDatabaseResults.getLong(paramInt));
  }
  
  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt) throws SQLException {
    try {
      return getConstructor().newInstance(new Object[] { paramObject });
    } catch (Exception exception) {
      throw SqlExceptionUtil.create("Could not use reflection to construct a Joda DateTime", exception);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\DateTimeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */