package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

public class DoubleType extends DoubleObjectType {
  private static final DoubleType singleTon = new DoubleType();
  
  private DoubleType() {
    super(SqlType.DOUBLE, new Class[] { double.class });
  }
  
  protected DoubleType(SqlType paramSqlType, Class<?>[] paramArrayOfClass) {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static DoubleType getSingleton() {
    return singleTon;
  }
  
  public boolean isPrimitive() {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\field\types\DoubleType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */