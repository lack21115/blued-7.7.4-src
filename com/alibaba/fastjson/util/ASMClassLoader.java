package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;

public class ASMClassLoader extends ClassLoader {
  private static ProtectionDomain DOMAIN = AccessController.<ProtectionDomain>doPrivileged(new PrivilegedAction() {
        public Object run() {
          return ASMClassLoader.class.getProtectionDomain();
        }
      });
  
  public ASMClassLoader() {
    super(getParentClassLoader());
  }
  
  public ASMClassLoader(ClassLoader paramClassLoader) {
    super(paramClassLoader);
  }
  
  static ClassLoader getParentClassLoader() {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    if (classLoader != null)
      try {
        classLoader.loadClass(JSON.class.getName());
        return classLoader;
      } catch (ClassNotFoundException classNotFoundException) {} 
    return JSON.class.getClassLoader();
  }
  
  public Class<?> defineClassPublic(String paramString, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws ClassFormatError {
    return defineClass(paramString, paramArrayOfbyte, paramInt1, paramInt2, DOMAIN);
  }
  
  public boolean isExternalClass(Class<?> paramClass) {
    ClassLoader classLoader = paramClass.getClassLoader();
    if (classLoader == null)
      return false; 
    ASMClassLoader aSMClassLoader = this;
    while (aSMClassLoader != null) {
      if (aSMClassLoader == classLoader)
        return false; 
      ClassLoader classLoader1 = aSMClassLoader.getParent();
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjso\\util\ASMClassLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */