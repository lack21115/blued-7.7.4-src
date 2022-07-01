package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.UUID;

public class UuidType extends BaseDataType {
  public static int DEFAULT_WIDTH = 48;
  
  private static final UuidType singleTon = new UuidType();
  
  private UuidType() {
    super(SqlType.STRING, new Class[] { UUID.class });
  }
  
  protected UuidType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static UuidType getSingleton() {
    return singleTon;
  }
  
  public Object generateId() {
    return UUID.randomUUID();
  }
  
  public int getDefaultWidth() {
    return DEFAULT_WIDTH;
  }
  
  public boolean isSelfGeneratedId() {
    return true;
  }
  
  public boolean isValidGeneratedType() {
    return true;
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject) {
    return ((UUID)paramObject).toString();
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString) throws SQLException {
    try {
      return UUID.fromString(paramString);
    } catch (IllegalArgumentException illegalArgumentException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Problems with field ");
      stringBuilder.append(paramFieldType);
      stringBuilder.append(" parsing default UUID-string '");
      stringBuilder.append(paramString);
      stringBuilder.append("'");
      throw SqlExceptionUtil.create(stringBuilder.toString(), illegalArgumentException);
    } 
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt) throws SQLException {
    return paramDatabaseResults.getString(paramInt);
  }
  
  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt) throws SQLException {
    String str = (String)paramObject;
    try {
      return UUID.fromString(str);
    } catch (IllegalArgumentException illegalArgumentException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Problems with column ");
      stringBuilder.append(paramInt);
      stringBuilder.append(" parsing UUID-string '");
      stringBuilder.append(str);
      stringBuilder.append("'");
      throw SqlExceptionUtil.create(stringBuilder.toString(), illegalArgumentException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\UuidType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */