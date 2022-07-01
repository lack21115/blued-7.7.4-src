package com.google.common.reflect;

import java.lang.reflect.InvocationHandler;

public abstract class AbstractInvocationHandler implements InvocationHandler {
  private static final Object[] a = new Object[0];
  
  public boolean equals(Object paramObject) {
    return super.equals(paramObject);
  }
  
  public int hashCode() {
    return super.hashCode();
  }
  
  public String toString() {
    return super.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\reflect\AbstractInvocationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */