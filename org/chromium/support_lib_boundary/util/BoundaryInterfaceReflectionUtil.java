package org.chromium.support_lib_boundary.util;

import android.annotation.TargetApi;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BoundaryInterfaceReflectionUtil {
  public static Object castToSuppLibClass(Class paramClass, InvocationHandler paramInvocationHandler) {
    return paramClass.cast(Proxy.newProxyInstance(BoundaryInterfaceReflectionUtil.class.getClassLoader(), new Class[] { paramClass }, paramInvocationHandler));
  }
  
  public static boolean containsFeature(String[] paramArrayOfString, String paramString) {
    int j = paramArrayOfString.length;
    for (int i = 0; i < j; i++) {
      if (paramArrayOfString[i].equals(paramString))
        return true; 
    } 
    return false;
  }
  
  @TargetApi(19)
  public static InvocationHandler createInvocationHandlerFor(Object paramObject) {
    return new BoundaryInterfaceReflectionUtil$InvocationHandlerWithDelegateGetter(paramObject);
  }
  
  public static Method dupeMethod(Method paramMethod, ClassLoader paramClassLoader) {
    Class<?> clazz = Class.forName(paramMethod.getDeclaringClass().getName(), true, paramClassLoader);
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    return clazz.getDeclaredMethod(paramMethod.getName(), arrayOfClass);
  }
  
  public static Object getDelegateFromInvocationHandler(InvocationHandler paramInvocationHandler) {
    return ((BoundaryInterfaceReflectionUtil$InvocationHandlerWithDelegateGetter)paramInvocationHandler).mDelegate;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_boundar\\util\BoundaryInterfaceReflectionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */