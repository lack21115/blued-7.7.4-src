package org.chromium.build;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;

public abstract class BuildHooksAndroid {
  private static BuildHooksAndroid sInstance;
  
  private static BuildHooksAndroid constructBuildHooksAndroidImpl() {
    try {
      return (BuildHooksAndroid)Class.forName("org.chromium.build.BuildHooksAndroidImpl").newInstance();
    } catch (Exception exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  public static Context createConfigurationContext$6263c3eb() {
    return get().createConfigurationContextImpl$6263c3eb();
  }
  
  public static BuildHooksAndroid get() {
    if (sInstance == null)
      sInstance = constructBuildHooksAndroidImpl(); 
    return sInstance;
  }
  
  public static AssetManager getAssets$49f66a90() {
    return get().getAssetsImpl$49f66a90();
  }
  
  public static int getIdentifier(Resources paramResources, String paramString1, String paramString2, String paramString3) {
    return get().getIdentifierImpl(paramResources, paramString1, paramString2, paramString3);
  }
  
  public static Resources getResources$177d0c3c() {
    return get().getResourcesImpl$177d0c3c();
  }
  
  public static Resources.Theme getTheme$21e91261() {
    return get().getThemeImpl$21e91261();
  }
  
  public static boolean isEnabled() {
    return get().isEnabledImpl();
  }
  
  protected abstract Context createConfigurationContextImpl$6263c3eb();
  
  protected abstract AssetManager getAssetsImpl$49f66a90();
  
  protected abstract int getIdentifierImpl(Resources paramResources, String paramString1, String paramString2, String paramString3);
  
  protected abstract Resources getResourcesImpl$177d0c3c();
  
  protected abstract Resources.Theme getThemeImpl$21e91261();
  
  protected abstract boolean isEnabledImpl();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\build\BuildHooksAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */