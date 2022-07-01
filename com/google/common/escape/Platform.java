package com.google.common.escape;

final class Platform {
  private static final ThreadLocal<char[]> a = new ThreadLocal<char[]>() {
      protected char[] a() {
        return new char[1024];
      }
    };
  
  static char[] a() {
    return a.get();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\escape\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */