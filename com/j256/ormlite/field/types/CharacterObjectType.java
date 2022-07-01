package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class CharacterObjectType extends BaseDataType {
  private static final CharacterObjectType singleTon = new CharacterObjectType();
  
  private CharacterObjectType() {
    super(SqlType.CHAR, new Class[] { Character.class });
  }
  
  protected CharacterObjectType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static CharacterObjectType getSingleton() {
    return singleTon;
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString) throws SQLException {
    if (paramString.length() == 1)
      return Character.valueOf(paramString.charAt(0)); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Problems with field ");
    stringBuilder.append(paramFieldType);
    stringBuilder.append(", default string to long for Character: '");
    stringBuilder.append(paramString);
    stringBuilder.append("'");
    throw new SQLException(stringBuilder.toString());
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt) throws SQLException {
    return Character.valueOf(paramDatabaseResults.getChar(paramInt));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\CharacterObjectType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */