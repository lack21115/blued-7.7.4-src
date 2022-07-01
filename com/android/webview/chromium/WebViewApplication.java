package com.android.webview.chromium;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.chromium.base.BuildInfo;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;

public class WebViewApplication extends Application {
  public void onCreate() {
    super.onCreate();
    if (Build.VERSION.SDK_INT >= 26 && !BuildInfo.isAtLeastP()) {
      if (!ContextUtils.isIsolatedProcess())
        return; 
      try {
        ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo(getPackageName(), 128);
        if (applicationInfo.metaData != null) {
          if (!applicationInfo.metaData.containsKey("preloaded_fonts"))
            return; 
          Class<?> clazz1 = Class.forName("android.app.ActivityThread");
          clazz1.getMethod("currentActivityThread", new Class[0]);
          Method method = clazz1.getMethod("getPackageManager", new Class[0]);
          Field field = clazz1.getDeclaredField("sPackageManager");
          field.setAccessible(true);
          Class<?> clazz2 = Class.forName("android.content.pm.IPackageManager");
          ClassLoader classLoader = clazz2.getClassLoader();
          FontPreloadingWorkaround$PackageManagerWrapper fontPreloadingWorkaround$PackageManagerWrapper = new FontPreloadingWorkaround$PackageManagerWrapper(method.invoke(null, new Object[0]));
          field.set((Object)null, Proxy.newProxyInstance(classLoader, new Class[] { clazz2 }, fontPreloadingWorkaround$PackageManagerWrapper));
          return;
        } 
        return;
      } catch (Exception exception) {
        Log.w("FontWorkaround", "Installing workaround failed, continuing without", new Object[] { exception });
        return;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\WebViewApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */