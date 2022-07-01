package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

public class LongType extends LongObjectType {
  private static final LongType singleTon = new LongType();
  
  private LongType() {
    super(SqlType.LONG, new Class[] { long.class });
  }
  
  protected LongType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static LongType getSingleton() {
    return singleTon;
  }
  
  public boolean isPrimitive() {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\LongType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */