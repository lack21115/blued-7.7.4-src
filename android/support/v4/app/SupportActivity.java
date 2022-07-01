package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ReportFragment;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.util.SimpleArrayMap;
import org.chromium.build.BuildHooksAndroid;

public class SupportActivity extends Activity implements LifecycleOwner {
  private LifecycleRegistry mLifecycleRegistry;
  
  public SupportActivity() {
    new SimpleArrayMap();
    this.mLifecycleRegistry = new LifecycleRegistry(this);
  }
  
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
  
  public Lifecycle getLifecycle() {
    return (Lifecycle)this.mLifecycleRegistry;
  }
  
  public Resources getResources() {
    return !BuildHooksAndroid.isEnabled() ? super.getResources() : BuildHooksAndroid.getResources$177d0c3c();
  }
  
  public Resources.Theme getTheme() {
    return !BuildHooksAndroid.isEnabled() ? super.getTheme() : BuildHooksAndroid.getTheme$21e91261();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    ReportFragment.injectIfNeededIn(this);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {
    this.mLifecycleRegistry.mState = Lifecycle.State.CREATED;
    super.onSaveInstanceState(paramBundle);
  }
  
  public void setTheme(int paramInt) {
    if (!BuildHooksAndroid.isEnabled()) {
      super.setTheme(paramInt);
      return;
    } 
    BuildHooksAndroid.get();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\SupportActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */