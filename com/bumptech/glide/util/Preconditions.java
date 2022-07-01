package com.bumptech.glide.util;

import android.text.TextUtils;

public final class Preconditions {
  public static <T> T a(T paramT) {
    return a(paramT, "Argument must not be null");
  }
  
  public static <T> T a(T paramT, String paramString) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(paramString);
  }
  
  public static String a(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      return paramString; 
    throw new IllegalArgumentException("Must not be null or empty");
  }
  
  public static <T extends java.util.Collection<Y>, Y> T a(T paramT) {
    if (!paramT.isEmpty())
      return paramT; 
    throw new IllegalArgumentException("Must not be empty.");
  }
  
  public static void a(boolean paramBoolean, String paramString) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glid\\util\Preconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */