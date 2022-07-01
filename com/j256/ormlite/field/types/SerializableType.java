package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Arrays;

public class SerializableType extends BaseDataType {
  private static final SerializableType singleTon = new SerializableType();
  
  private SerializableType() {
    super(SqlType.SERIALIZABLE, new Class[0]);
  }
  
  protected SerializableType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static SerializableType getSingleton() {
    return singleTon;
  }
  
  public Class<?> getPrimaryClass() {
    return Serializable.class;
  }
  
  public boolean isAppropriateId() {
    return false;
  }
  
  public boolean isArgumentHolderRequired() {
    return true;
  }
  
  public boolean isComparable() {
    return false;
  }
  
  public boolean isStreamType() {
    return true;
  }
  
  public boolean isValidForField(Field paramField) {
    return Serializable.class.isAssignableFrom(paramField.getType());
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject) throws SQLException {
    Exception exception2;
    exception3 = null;
    FieldType fieldType = null;
    paramFieldType = fieldType;
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      paramFieldType = fieldType;
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
      try {
        objectOutputStream.writeObject(paramObject);
        objectOutputStream.close();
        return byteArrayOutputStream.toByteArray();
      } catch (Exception exception3) {
      
      } finally {
        ObjectOutputStream objectOutputStream1;
        paramObject = null;
      } 
    } catch (Exception exception) {
      exception2 = exception3;
      exception3 = exception;
    } finally {}
    Exception exception1 = exception2;
    StringBuilder stringBuilder = new StringBuilder();
    exception1 = exception2;
    stringBuilder.append("Could not write serialized object to byte array: ");
    exception1 = exception2;
    stringBuilder.append(paramObject);
    exception1 = exception2;
    throw SqlExceptionUtil.create(stringBuilder.toString(), exception3);
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString) throws SQLException {
    throw new SQLException("Default values for serializable types are not supported");
  }
  
  public Object resultStringToJava(FieldType paramFieldType, String paramString, int paramInt) throws SQLException {
    throw new SQLException("Serializable type cannot be converted from string to Java");
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt) throws SQLException {
    return paramDatabaseResults.getBytes(paramInt);
  }
  
  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt) throws SQLException {
    Exception exception;
    byte[] arrayOfByte = (byte[])paramObject;
    StringBuilder stringBuilder = null;
    paramFieldType = null;
    try {
    
    } catch (Exception null) {
    
    } finally {
      Exception exception1;
      exception = null;
      paramObject = paramFieldType;
    } 
    Object object = paramObject;
    stringBuilder = new StringBuilder();
    object = paramObject;
    stringBuilder.append("Could not read serialized object from byte array: ");
    object = paramObject;
    stringBuilder.append(Arrays.toString(arrayOfByte));
    object = paramObject;
    stringBuilder.append("(len ");
    object = paramObject;
    stringBuilder.append(arrayOfByte.length);
    object = paramObject;
    stringBuilder.append(")");
    object = paramObject;
    throw SqlExceptionUtil.create(stringBuilder.toString(), exception);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\SerializableType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */