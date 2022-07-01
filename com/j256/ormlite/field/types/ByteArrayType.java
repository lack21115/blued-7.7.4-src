package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.Arrays;

public class ByteArrayType extends BaseDataType {
  private static final ByteArrayType singleTon = new ByteArrayType();
  
  private ByteArrayType() {
    super(SqlType.BYTE_ARRAY, new Class[0]);
  }
  
  protected ByteArrayType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static ByteArrayType getSingleton() {
    return singleTon;
  }
  
  public boolean dataIsEqual(Object paramObject1, Object paramObject2) {
    boolean bool = false;
    if (paramObject1 == null) {
      if (paramObject2 == null)
        bool = true; 
      return bool;
    } 
    return (paramObject2 == null) ? false : Arrays.equals((byte[])paramObject1, (byte[])paramObject2);
  }
  
  public Class<?> getPrimaryClass() {
    return byte[].class;
  }
  
  public boolean isAppropriateId() {
    return false;
  }
  
  public boolean isArgumentHolderRequired() {
    return true;
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString) throws SQLException {
    throw new SQLException("byte[] type cannot have default values");
  }
  
  public Object resultStringToJava(FieldType paramFieldType, String paramString, int paramInt) throws SQLException {
    throw new SQLException("byte[] type cannot be converted from string to Java");
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt) throws SQLException {
    return paramDatabaseResults.getBytes(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\ByteArrayType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */