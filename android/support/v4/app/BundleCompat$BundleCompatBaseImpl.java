package android.support.v4.app;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class BundleCompat$BundleCompatBaseImpl {
  private static Method sGetIBinderMethod;
  
  private static boolean sGetIBinderMethodFetched;
  
  public static IBinder getBinder(Bundle paramBundle, String paramString) {
    if (!sGetIBinderMethodFetched) {
      try {
        Method method = Bundle.class.getMethod("getIBinder", new Class[] { String.class });
        sGetIBinderMethod = method;
        method.setAccessible(true);
      } catch (NoSuchMethodException noSuchMethodException) {
        Log.i("BundleCompatBaseImpl", "Failed to retrieve getIBinder method", noSuchMethodException);
      } 
      sGetIBinderMethodFetched = true;
    } 
    if (sGetIBinderMethod != null)
      try {
        return (IBinder)sGetIBinderMethod.invoke(paramBundle, new Object[] { paramString });
      } catch (InvocationTargetException|IllegalAccessException|IllegalArgumentException invocationTargetException) {
        Log.i("BundleCompatBaseImpl", "Failed to invoke getIBinder via reflection", invocationTargetException);
        sGetIBinderMethod = null;
      }  
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\BundleCompat$BundleCompatBaseImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */