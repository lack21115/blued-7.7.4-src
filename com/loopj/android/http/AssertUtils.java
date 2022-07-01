package com.loopj.android.http;

class AssertUtils {
  public static void asserts(boolean paramBoolean, String paramString) {
    if (paramBoolean)
      return; 
    throw new AssertionError(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\AssertUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */