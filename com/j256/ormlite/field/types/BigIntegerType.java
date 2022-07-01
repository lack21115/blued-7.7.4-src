package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.math.BigInteger;
import java.sql.SQLException;

public class BigIntegerType extends BaseDataType {
  public static int DEFAULT_WIDTH = 255;
  
  private static final BigIntegerType singleTon = new BigIntegerType();
  
  protected BigIntegerType() {
    super(SqlType.STRING, new Class[] { BigInteger.class });
  }
  
  protected BigIntegerType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static BigIntegerType getSingleton() {
    return singleTon;
  }
  
  public int getDefaultWidth() {
    return DEFAULT_WIDTH;
  }
  
  public boolean isAppropriateId() {
    return false;
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject) {
    return ((BigInteger)paramObject).toString();
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString) throws SQLException {
    try {
      return new BigInteger(paramString);
    } catch (IllegalArgumentException illegalArgumentException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Problems with field ");
      stringBuilder.append(paramFieldType);
      stringBuilder.append(" parsing default BigInteger string '");
      stringBuilder.append(paramString);
      stringBuilder.append("'");
      throw SqlExceptionUtil.create(stringBuilder.toString(), illegalArgumentException);
    } 
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt) throws SQLException {
    return paramDatabaseResults.getString(paramInt);
  }
  
  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt) throws SQLException {
    try {
      return new BigInteger((String)paramObject);
    } catch (IllegalArgumentException illegalArgumentException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Problems with column ");
      stringBuilder.append(paramInt);
      stringBuilder.append(" parsing BigInteger string '");
      stringBuilder.append(paramObject);
      stringBuilder.append("'");
      throw SqlExceptionUtil.create(stringBuilder.toString(), illegalArgumentException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\BigIntegerType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */