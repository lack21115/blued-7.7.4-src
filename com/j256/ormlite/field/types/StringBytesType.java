package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class StringBytesType extends BaseDataType {
  private static final String DEFAULT_STRING_BYTES_CHARSET_NAME = "Unicode";
  
  private static final StringBytesType singleTon = new StringBytesType();
  
  private StringBytesType() {
    super(SqlType.BYTE_ARRAY, new Class[0]);
  }
  
  protected StringBytesType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  private String getCharsetName(FieldType paramFieldType) {
    return (paramFieldType == null || paramFieldType.getFormat() == null) ? "Unicode" : paramFieldType.getFormat();
  }
  
  public static StringBytesType getSingleton() {
    return singleTon;
  }
  
  public Class<?> getPrimaryClass() {
    return String.class;
  }
  
  public boolean isAppropriateId() {
    return false;
  }
  
  public boolean isArgumentHolderRequired() {
    return true;
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject) throws SQLException {
    paramObject = paramObject;
    String str = getCharsetName(paramFieldType);
    try {
      return paramObject.getBytes(str);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not convert string with charset name: ");
      stringBuilder.append(str);
      throw SqlExceptionUtil.create(stringBuilder.toString(), unsupportedEncodingException);
    } 
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString) throws SQLException {
    throw new SQLException("String-bytes type cannot have default values");
  }
  
  public Object resultStringToJava(FieldType paramFieldType, String paramString, int paramInt) throws SQLException {
    throw new SQLException("String-bytes type cannot be converted from string to Java");
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt) throws SQLException {
    return paramDatabaseResults.getBytes(paramInt);
  }
  
  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt) throws SQLException {
    paramObject = paramObject;
    String str = getCharsetName(paramFieldType);
    try {
      return new String((byte[])paramObject, str);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not convert string with charset name: ");
      stringBuilder.append(str);
      throw SqlExceptionUtil.create(stringBuilder.toString(), unsupportedEncodingException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\StringBytesType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */