package com.google.common.math;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class MathPreconditions {
  static int a(@NullableDecl String paramString, int paramInt) {
    if (paramInt > 0)
      return paramInt; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" (");
    stringBuilder.append(paramInt);
    stringBuilder.append(") must be > 0");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static void a(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
  }
  
  static void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {
    if (paramBoolean)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("overflow: ");
    stringBuilder.append(paramString);
    stringBuilder.append("(");
    stringBuilder.append(paramInt1);
    stringBuilder.append(", ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(")");
    throw new ArithmeticException(stringBuilder.toString());
  }
  
  static void a(boolean paramBoolean, String paramString, long paramLong1, long paramLong2) {
    if (paramBoolean)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("overflow: ");
    stringBuilder.append(paramString);
    stringBuilder.append("(");
    stringBuilder.append(paramLong1);
    stringBuilder.append(", ");
    stringBuilder.append(paramLong2);
    stringBuilder.append(")");
    throw new ArithmeticException(stringBuilder.toString());
  }
  
  static int b(@NullableDecl String paramString, int paramInt) {
    if (paramInt >= 0)
      return paramInt; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(" (");
    stringBuilder.append(paramInt);
    stringBuilder.append(") must be >= 0");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\math\MathPreconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */