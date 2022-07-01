package com.google.common.base;

public abstract class Ticker {
  private static final Ticker a = new Ticker() {
      public long a() {
        return Platform.a();
      }
    };
  
  public static Ticker b() {
    return a;
  }
  
  public abstract long a();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\Ticker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */