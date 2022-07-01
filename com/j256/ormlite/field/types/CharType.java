package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;

public class CharType extends CharacterObjectType {
  private static final CharType singleTon = new CharType();
  
  private CharType() {
    super(SqlType.CHAR, new Class[] { char.class });
  }
  
  protected CharType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static CharType getSingleton() {
    return singleTon;
  }
  
  public boolean isPrimitive() {
    return true;
  }
  
  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject) {
    Character character = (Character)paramObject;
    return (character == null || character.charValue() == '\000') ? null : character;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\CharType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */