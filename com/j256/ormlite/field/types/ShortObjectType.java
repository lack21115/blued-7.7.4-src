package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class ShortObjectType extends BaseDataType {
  private static final ShortObjectType singleTon = new ShortObjectType();
  
  private ShortObjectType() {
    super(SqlType.SHORT, new Class[] { Short.class });
  }
  
  protected ShortObjectType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static ShortObjectType getSingleton() {
    return singleTon;
  }
  
  public boolean isEscapedValue() {
    return false;
  }
  
  public boolean isValidForVersion() {
    return true;
  }
  
  public Object moveToNextValue(Object paramObject) {
    return (paramObject == null) ? Short.valueOf((short)1) : Short.valueOf((short)(((Short)paramObject).shortValue() + 1));
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString) {
    return Short.valueOf(Short.parseShort(paramString));
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt) throws SQLException {
    return Short.valueOf(paramDatabaseResults.getShort(paramInt));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\ShortObjectType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */