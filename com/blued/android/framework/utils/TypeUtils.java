package com.blued.android.framework.utils;

import java.util.List;

public class TypeUtils {
  public static <T> T a(Object paramObject) {
    return (T)paramObject;
  }
  
  public static boolean a(List<?> paramList) {
    return (paramList == null || paramList.isEmpty());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\TypeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */