package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.Timestamp;

public class TimeStampType extends DateType {
  private static final TimeStampType singleTon = new TimeStampType();
  
  private TimeStampType() {
    super(SqlType.DATE, new Class[] { Timestamp.class });
  }
  
  protected TimeStampType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static TimeStampType getSingleton() {
    return singleTon;
  }
  
  public boolean isValidForField(Field paramField) {
    return (paramField.getType() == Timestamp.class);
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject) {
    return paramObject;
  }
  
  public Object moveToNextValue(Object paramObject) {
    long l = System.currentTimeMillis();
    return (paramObject == null) ? new Timestamp(l) : ((l == ((Timestamp)paramObject).getTime()) ? new Timestamp(l + 1L) : new Timestamp(l));
  }
  
  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt) {
    return paramObject;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\TimeStampType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */