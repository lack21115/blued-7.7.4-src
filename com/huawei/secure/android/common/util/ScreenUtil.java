package com.huawei.secure.android.common.util;

import java.lang.reflect.Method;
import java.security.PrivilegedAction;

public class ScreenUtil {
  static class a implements PrivilegedAction {
    Method a;
    
    public Object run() {
      Method method = this.a;
      if (method == null)
        return null; 
      method.setAccessible(true);
      return null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\commo\\util\ScreenUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */