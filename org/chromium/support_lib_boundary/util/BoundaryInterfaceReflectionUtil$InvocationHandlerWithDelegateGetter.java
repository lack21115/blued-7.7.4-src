package org.chromium.support_lib_boundary.util;

import android.annotation.TargetApi;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TargetApi(19)
final class BoundaryInterfaceReflectionUtil$InvocationHandlerWithDelegateGetter implements InvocationHandler {
  final Object mDelegate;
  
  public BoundaryInterfaceReflectionUtil$InvocationHandlerWithDelegateGetter(Object paramObject) {
    this.mDelegate = paramObject;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) {
    paramObject = this.mDelegate.getClass().getClassLoader();
    try {
      return BoundaryInterfaceReflectionUtil.dupeMethod(paramMethod, (ClassLoader)paramObject).invoke(this.mDelegate, paramArrayOfObject);
    } catch (InvocationTargetException invocationTargetException) {
      throw invocationTargetException.getTargetException();
    } catch (ReflectiveOperationException reflectiveOperationException) {
      StringBuilder stringBuilder = new StringBuilder("Reflection failed for method ");
      stringBuilder.append(paramMethod);
      throw new RuntimeException(stringBuilder.toString(), reflectiveOperationException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_boundar\\util\BoundaryInterfaceReflectionUtil$InvocationHandlerWithDelegateGetter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */