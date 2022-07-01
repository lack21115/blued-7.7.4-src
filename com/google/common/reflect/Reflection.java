package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public final class Reflection {
  public static <T> T a(Class<T> paramClass, InvocationHandler paramInvocationHandler) {
    Preconditions.a(paramInvocationHandler);
    Preconditions.a(paramClass.isInterface(), "%s is not an interface", paramClass);
    return paramClass.cast(Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, paramInvocationHandler));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\reflect\Reflection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */