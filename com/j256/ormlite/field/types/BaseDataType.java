package com.j256.ormlite.field.types;

import com.j256.ormlite.field.BaseFieldConverter;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.lang.reflect.Field;
import java.sql.SQLException;

public abstract class BaseDataType extends BaseFieldConverter implements DataPersister {
  private final Class<?>[] classes;
  
  private final SqlType sqlType;
  
  public BaseDataType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    this.sqlType = paramSqlType;
    this.classes = paramArrayOfClass;
  }
  
  public Object convertIdNumber(Number paramNumber) {
    return null;
  }
  
  public boolean dataIsEqual(Object paramObject1, Object paramObject2) {
    boolean bool = false;
    if (paramObject1 == null) {
      if (paramObject2 == null)
        bool = true; 
      return bool;
    } 
    return (paramObject2 == null) ? false : paramObject1.equals(paramObject2);
  }
  
  public Object generateId() {
    throw new IllegalStateException("Should not have tried to generate this type");
  }
  
  public String[] getAssociatedClassNames() {
    return null;
  }
  
  public Class<?>[] getAssociatedClasses() {
    return this.classes;
  }
  
  public int getDefaultWidth() {
    return 0;
  }
  
  public Class<?> getPrimaryClass() {
    Class<?>[] arrayOfClass = this.classes;
    return (arrayOfClass.length == 0) ? null : arrayOfClass[0];
  }
  
  public SqlType getSqlType() {
    return this.sqlType;
  }
  
  public boolean isAppropriateId() {
    return true;
  }
  
  public boolean isArgumentHolderRequired() {
    return false;
  }
  
  public boolean isComparable() {
    return true;
  }
  
  public boolean isEscapedDefaultValue() {
    return isEscapedValue();
  }
  
  public boolean isEscapedValue() {
    return true;
  }
  
  public boolean isPrimitive() {
    return false;
  }
  
  public boolean isSelfGeneratedId() {
    return false;
  }
  
  public boolean isValidForField(Field paramField) {
    Class<?>[] arrayOfClass = this.classes;
    if (arrayOfClass.length == 0)
      return true; 
    int j = arrayOfClass.length;
    for (int i = 0; i < j; i++) {
      if (arrayOfClass[i].isAssignableFrom(paramField.getType()))
        return true; 
    } 
    return false;
  }
  
  public boolean isValidForVersion() {
    return false;
  }
  
  public boolean isValidGeneratedType() {
    return false;
  }
  
  public Object makeConfigObject(FieldType paramFieldType) throws SQLException {
    return null;
  }
  
  public Object moveToNextValue(Object paramObject) {
    return null;
  }
  
  public abstract Object parseDefaultString(FieldType paramFieldType, String paramString) throws SQLException;
  
  public Object resultStringToJava(FieldType paramFieldType, String paramString, int paramInt) throws SQLException {
    return parseDefaultString(paramFieldType, paramString);
  }
  
  public abstract Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt) throws SQLException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\BaseDataType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */