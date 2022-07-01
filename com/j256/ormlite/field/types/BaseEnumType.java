package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.SQLException;

public abstract class BaseEnumType extends BaseDataType {
  protected BaseEnumType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  protected static Enum<?> enumVal(FieldType paramFieldType, Object paramObject, Enum<?> paramEnum1, Enum<?> paramEnum2) throws SQLException {
    if (paramEnum1 != null)
      return paramEnum1; 
    if (paramEnum2 != null)
      return paramEnum2; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Cannot get enum value of '");
    stringBuilder.append(paramObject);
    stringBuilder.append("' for field ");
    stringBuilder.append(paramFieldType);
    throw new SQLException(stringBuilder.toString());
  }
  
  public boolean isValidForField(Field paramField) {
    return paramField.getType().isEnum();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\BaseEnumType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */