package com.google.common.math;

public abstract class LinearTransformation {
  public static final class LinearTransformationBuilder {}
  
  static final class NaNLinearTransformation extends LinearTransformation {
    static final NaNLinearTransformation a = new NaNLinearTransformation();
    
    public String toString() {
      return "NaN";
    }
  }
  
  static final class RegularLinearTransformation extends LinearTransformation {
    final double a;
    
    final double b;
    
    public String toString() {
      return String.format("y = %g * x + %g", new Object[] { Double.valueOf(this.a), Double.valueOf(this.b) });
    }
  }
  
  static final class VerticalLinearTransformation extends LinearTransformation {
    final double a;
    
    public String toString() {
      return String.format("x = %g", new Object[] { Double.valueOf(this.a) });
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\math\LinearTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */