package com.google.protobuf;

final class Android {
  static {
    if (getClassForName("org.robolectric.Robolectric") != null) {
      bool = true;
    } else {
      bool = false;
    } 
    IS_ROBOLECTRIC = bool;
  }
  
  private static <T> Class<T> getClassForName(String paramString) {
    try {
      return (Class)Class.forName(paramString);
    } finally {
      paramString = null;
    } 
  }
  
  static Class<?> getMemoryClass() {
    return MEMORY_CLASS;
  }
  
  static boolean isOnAndroidDevice() {
    return (MEMORY_CLASS != null && !IS_ROBOLECTRIC);
  }
  
  static {
    boolean bool;
  }
  
  private static final boolean IS_ROBOLECTRIC;
  
  private static final Class<?> MEMORY_CLASS = getClassForName("libcore.io.Memory");
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\Android.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */