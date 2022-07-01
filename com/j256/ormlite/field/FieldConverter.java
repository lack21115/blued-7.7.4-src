package com.j256.ormlite.field;

import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public interface FieldConverter {
  SqlType getSqlType();
  
  boolean isStreamType();
  
  Object javaToSqlArg(FieldType paramFieldType, Object paramObject) throws SQLException;
  
  Object parseDefaultString(FieldType paramFieldType, String paramString) throws SQLException;
  
  Object resultStringToJava(FieldType paramFieldType, String paramString, int paramInt) throws SQLException;
  
  Object resultToJava(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt) throws SQLException;
  
  Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt) throws SQLException;
  
  Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt) throws SQLException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\FieldConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */