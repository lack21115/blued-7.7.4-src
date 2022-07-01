package com.google.common.math;

import com.google.common.base.Preconditions;

final class DoubleUtils {
  static double a(double paramDouble) {
    Preconditions.a(Double.isNaN(paramDouble) ^ true);
    return Math.max(paramDouble, 0.0D);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\math\DoubleUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */