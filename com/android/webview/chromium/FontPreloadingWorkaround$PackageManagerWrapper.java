package com.android.webview.chromium;

import android.content.pm.ApplicationInfo;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class FontPreloadingWorkaround$PackageManagerWrapper implements InvocationHandler {
  private Object mRealPackageManager;
  
  public FontPreloadingWorkaround$PackageManagerWrapper(Object paramObject) {
    this.mRealPackageManager = paramObject;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject) {
    try {
      paramObject = paramMethod.invoke(this.mRealPackageManager, paramArrayOfObject);
      if (paramMethod.getReturnType() == ApplicationInfo.class) {
        ApplicationInfo applicationInfo = (ApplicationInfo)paramObject;
        if (applicationInfo.metaData != null)
          applicationInfo.metaData.remove("preloaded_fonts"); 
      } 
      return paramObject;
    } catch (InvocationTargetException invocationTargetException) {
      throw invocationTargetException.getTargetException();
    } catch (ReflectiveOperationException reflectiveOperationException) {
      throw new RuntimeException("Reflection failed when proxying IPackageManager", reflectiveOperationException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\FontPreloadingWorkaround$PackageManagerWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */