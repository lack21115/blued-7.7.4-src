package com.alipay.a.a;

import java.lang.reflect.Type;

public final class d implements i, j {
  public final Object a(Object paramObject) {
    return ((Enum)paramObject).name();
  }
  
  public final Object a(Object paramObject, Type paramType) {
    return Enum.valueOf((Class<Enum>)paramType, paramObject.toString());
  }
  
  public final boolean a(Class<?> paramClass) {
    return Enum.class.isAssignableFrom(paramClass);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */