package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class BooleanObjectType extends BaseDataType {
  private static final BooleanObjectType singleTon = new BooleanObjectType();
  
  private BooleanObjectType() {
    super(SqlType.BOOLEAN, new Class[] { Boolean.class });
  }
  
  protected BooleanObjectType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static BooleanObjectType getSingleton() {
    return singleTon;
  }
  
  public boolean isAppropriateId() {
    return false;
  }
  
  public boolean isEscapedValue() {
    return false;
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString) {
    return Boolean.valueOf(Boolean.parseBoolean(paramString));
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt) throws SQLException {
    return Boolean.valueOf(paramDatabaseResults.getBoolean(paramInt));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\BooleanObjectType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */