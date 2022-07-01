package com.j256.ormlite.field;

import java.lang.reflect.Field;
import java.sql.SQLException;

public interface DataPersister extends FieldConverter {
  Object convertIdNumber(Number paramNumber);
  
  boolean dataIsEqual(Object paramObject1, Object paramObject2);
  
  Object generateId();
  
  String[] getAssociatedClassNames();
  
  Class<?>[] getAssociatedClasses();
  
  int getDefaultWidth();
  
  Class<?> getPrimaryClass();
  
  boolean isAppropriateId();
  
  boolean isArgumentHolderRequired();
  
  boolean isComparable();
  
  boolean isEscapedDefaultValue();
  
  boolean isEscapedValue();
  
  boolean isPrimitive();
  
  boolean isSelfGeneratedId();
  
  boolean isValidForField(Field paramField);
  
  boolean isValidForVersion();
  
  boolean isValidGeneratedType();
  
  Object makeConfigObject(FieldType paramFieldType) throws SQLException;
  
  Object moveToNextValue(Object paramObject);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\DataPersister.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */