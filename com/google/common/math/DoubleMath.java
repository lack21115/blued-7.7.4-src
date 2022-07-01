package com.google.common.math;

import java.math.RoundingMode;

public final class DoubleMath {
  static final double[] a;
  
  private static final double b = Math.log(2.0D);
  
  static {
    a = new double[] { 
        1.0D, 2.0922789888E13D, 2.631308369336935E35D, 1.2413915592536073E61D, 1.2688693218588417E89D, 7.156945704626381E118D, 9.916779348709496E149D, 1.974506857221074E182D, 3.856204823625804E215D, 5.5502938327393044E249D, 
        4.7147236359920616E284D };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\math\DoubleMath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */