package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public class ag {
  public static Class<?> a(String paramString) {
    try {
      return Class.forName(paramString, true, a());
    } catch (ClassNotFoundException classNotFoundException) {
      try {
        return Class.forName(paramString, true, ag.class.getClassLoader());
      } catch (ClassNotFoundException classNotFoundException1) {
        try {
          return Class.forName(paramString);
        } catch (ClassNotFoundException classNotFoundException2) {
          return null;
        } 
      } 
    } 
  }
  
  private static ClassLoader a() {
    ClassLoader classLoader2 = Thread.currentThread().getContextClassLoader();
    ClassLoader classLoader1 = classLoader2;
    if (classLoader2 == null)
      classLoader1 = ag.class.getClassLoader(); 
    return classLoader1;
  }
  
  public static Method a(String paramString1, String paramString2, Class<?>... paramVarArgs) {
    if (!TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2))
        return null; 
      try {
      
      } finally {
        paramVarArgs = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("get method: ");
        stringBuilder.append(paramString1);
        stringBuilder.append(", ");
        stringBuilder.append(paramString2);
      } 
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */