package com.google.android.gms.dynamite;

import dalvik.system.PathClassLoader;

final class zzi extends PathClassLoader {
  zzi(String paramString, ClassLoader paramClassLoader) {
    super(paramString, paramClassLoader);
  }
  
  protected final Class<?> loadClass(String paramString, boolean paramBoolean) throws ClassNotFoundException {
    if (!paramString.startsWith("java.") && !paramString.startsWith("android."))
      try {
        return findClass(paramString);
      } catch (ClassNotFoundException classNotFoundException) {} 
    return super.loadClass(paramString, paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\dynamite\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */