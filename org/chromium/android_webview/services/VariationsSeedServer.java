package org.chromium.android_webview.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.IBinder;
import org.chromium.build.BuildHooksAndroid;

public class VariationsSeedServer extends Service {
  private final IVariationsSeedServer$Stub mBinder = new VariationsSeedServer$1(this);
  
  private VariationsSeedHolder mSeedHolder;
  
  public Context createConfigurationContext(Configuration paramConfiguration) {
    if (Build.VERSION.SDK_INT < 17)
      return null; 
    if (!BuildHooksAndroid.isEnabled())
      return super.createConfigurationContext(paramConfiguration); 
    super.createConfigurationContext(paramConfiguration);
    return BuildHooksAndroid.createConfigurationContext$6263c3eb();
  }
  
  public AssetManager getAssets() {
    return !BuildHooksAndroid.isEnabled() ? super.getAssets() : BuildHooksAndroid.getAssets$49f66a90();
  }
  
  public Resources getResources() {
    return !BuildHooksAndroid.isEnabled() ? super.getResources() : BuildHooksAndroid.getResources$177d0c3c();
  }
  
  public Resources.Theme getTheme() {
    return !BuildHooksAndroid.isEnabled() ? super.getTheme() : BuildHooksAndroid.getTheme$21e91261();
  }
  
  public IBinder onBind(Intent paramIntent) {
    return (IBinder)this.mBinder;
  }
  
  public void onCreate() {
    super.onCreate();
    ServiceInit.init(getApplicationContext());
    this.mSeedHolder = VariationsSeedHolder.getInstance();
  }
  
  public void setTheme(int paramInt) {
    if (!BuildHooksAndroid.isEnabled()) {
      super.setTheme(paramInt);
      return;
    } 
    BuildHooksAndroid.get();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\services\VariationsSeedServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */