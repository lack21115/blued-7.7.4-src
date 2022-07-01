package com.alipay.a.a;

import java.lang.reflect.Type;
import java.util.Date;

public final class c implements i, j {
  public final Object a(Object paramObject) {
    return Long.valueOf(((Date)paramObject).getTime());
  }
  
  public final Object a(Object paramObject, Type paramType) {
    return new Date(((Long)paramObject).longValue());
  }
  
  public final boolean a(Class<?> paramClass) {
    return Date.class.isAssignableFrom(paramClass);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */