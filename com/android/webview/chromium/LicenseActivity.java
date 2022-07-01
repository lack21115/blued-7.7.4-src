package com.android.webview.chromium;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import org.chromium.build.BuildHooksAndroid;

public class LicenseActivity extends Activity {
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
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    String str = getPackageName();
    Intent intent = new Intent("android.intent.action.VIEW");
    intent.setDataAndType(Uri.parse(String.format("content://%s.%s", new Object[] { str, "LicenseContentProvider/webview_licenses" })), "text/html");
    intent.addCategory("android.intent.category.DEFAULT");
    int i = BuildHooksAndroid.getIdentifier(getResources(), "license_activity_title", "string", str);
    if (i != 0)
      intent.putExtra("android.intent.extra.TITLE", getString(i)); 
    intent.setPackage("com.android.htmlviewer");
    try {
      startActivity(intent);
    } catch (ActivityNotFoundException activityNotFoundException) {
      Log.e("WebView", "Failed to find viewer", (Throwable)activityNotFoundException);
    } 
    finish();
  }
  
  public void setTheme(int paramInt) {
    if (!BuildHooksAndroid.isEnabled()) {
      super.setTheme(paramInt);
      return;
    } 
    BuildHooksAndroid.get();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\LicenseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */