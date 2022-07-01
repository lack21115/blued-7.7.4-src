package com.j256.ormlite.field;

import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public abstract class BaseFieldConverter implements FieldConverter {
  public boolean isStreamType() {
    return false;
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject) throws SQLException {
    return paramObject;
  }
  
  public Object resultToJava(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt) throws SQLException {
    Object object = resultToSqlArg(paramFieldType, paramDatabaseResults, paramInt);
    return (object == null) ? null : sqlArgToJava(paramFieldType, object, paramInt);
  }
  
  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt) throws SQLException {
    return paramObject;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\BaseFieldConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */