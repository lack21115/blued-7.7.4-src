package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

public class IntType extends IntegerObjectType {
  private static final IntType singleTon = new IntType();
  
  private IntType() {
    super(SqlType.INTEGER, new Class[] { int.class });
  }
  
  protected IntType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static IntType getSingleton() {
    return singleTon;
  }
  
  public boolean isPrimitive() {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\IntType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */