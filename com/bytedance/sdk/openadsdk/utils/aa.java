package com.bytedance.sdk.openadsdk.utils;

import java.lang.reflect.Method;

public class aa {
  private static Object a;
  
  private static Method b;
  
  static {
    try {
      Method method2 = Class.class.getDeclaredMethod("forName", new Class[] { String.class });
      Method method1 = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, Class[].class });
      Class clazz = (Class)method2.invoke(null, new Object[] { "dalvik.system.VMRuntime" });
      Method method3 = (Method)method1.invoke(clazz, new Object[] { "getRuntime", null });
      return;
    } finally {
      Exception exception = null;
      t.b("Reflection", "reflect bootstrap failed:", exception);
    } 
  }
  
  public static boolean a() {
    return a(new String[] { "L" });
  }
  
  public static boolean a(String... paramVarArgs) {
    Object object = a;
    if (object != null) {
      Method method = b;
      if (method == null)
        return false; 
      try {
        return true;
      } finally {
        paramVarArgs = null;
      } 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */