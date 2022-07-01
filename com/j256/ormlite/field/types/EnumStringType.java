package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EnumStringType extends BaseEnumType {
  public static int DEFAULT_WIDTH = 100;
  
  private static final EnumStringType singleTon = new EnumStringType();
  
  private EnumStringType() {
    super(SqlType.STRING, new Class[] { Enum.class });
  }
  
  protected EnumStringType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static EnumStringType getSingleton() {
    return singleTon;
  }
  
  public int getDefaultWidth() {
    return DEFAULT_WIDTH;
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject) {
    return ((Enum)paramObject).name();
  }
  
  public Object makeConfigObject(FieldType paramFieldType) throws SQLException {
    Enum enum_;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Enum[] arrayOfEnum = paramFieldType.getType().getEnumConstants();
    if (arrayOfEnum != null) {
      int j = arrayOfEnum.length;
      for (int i = 0; i < j; i++) {
        enum_ = arrayOfEnum[i];
        hashMap.put(enum_.name(), enum_);
      } 
      return hashMap;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Field ");
    stringBuilder.append(enum_);
    stringBuilder.append(" improperly configured as type ");
    stringBuilder.append(this);
    throw new SQLException(stringBuilder.toString());
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString) {
    return paramString;
  }
  
  public Object resultStringToJava(FieldType paramFieldType, String paramString, int paramInt) throws SQLException {
    return sqlArgToJava(paramFieldType, paramString, paramInt);
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt) throws SQLException {
    return paramDatabaseResults.getString(paramInt);
  }
  
  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt) throws SQLException {
    if (paramFieldType == null)
      return paramObject; 
    paramObject = paramObject;
    Map map = (Map)paramFieldType.getDataTypeConfigObj();
    return (map == null) ? enumVal(paramFieldType, paramObject, null, paramFieldType.getUnknownEnumVal()) : enumVal(paramFieldType, paramObject, (Enum)map.get(paramObject), paramFieldType.getUnknownEnumVal());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\EnumStringType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */