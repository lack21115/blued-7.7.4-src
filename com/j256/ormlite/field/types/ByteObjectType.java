package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class ByteObjectType extends BaseDataType {
  private static final ByteObjectType singleTon = new ByteObjectType();
  
  private ByteObjectType() {
    super(SqlType.BYTE, new Class[] { Byte.class });
  }
  
  protected ByteObjectType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static ByteObjectType getSingleton() {
    return singleTon;
  }
  
  public boolean isEscapedValue() {
    return false;
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString) {
    return Byte.valueOf(Byte.parseByte(paramString));
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt) throws SQLException {
    return Byte.valueOf(paramDatabaseResults.getByte(paramInt));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\ByteObjectType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */