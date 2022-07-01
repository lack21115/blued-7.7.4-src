package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

public class ShortType extends ShortObjectType {
  private static final ShortType singleTon = new ShortType();
  
  private ShortType() {
    super(SqlType.SHORT, new Class[] { short.class });
  }
  
  protected ShortType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static ShortType getSingleton() {
    return singleTon;
  }
  
  public boolean isPrimitive() {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\ShortType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */