package com.baidu.mobads.interfaces.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public interface IXAdPackageUtils {
  int getAppVersion(Context paramContext);
  
  Intent getInstallIntent(String paramString);
  
  ApkInfo getLocalApkFileInfo(Context paramContext, String paramString);
  
  boolean isForeground(Context paramContext, String paramString);
  
  boolean isInstalled(Context paramContext, String paramString);
  
  boolean isSystemPackage(PackageInfo paramPackageInfo);
  
  void openApp(Context paramContext, String paramString);
  
  boolean sendAPOInfo(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3);
  
  void sendAPOIsSuccess(Context paramContext, boolean paramBoolean, int paramInt, String paramString1, String paramString2);
  
  void sendDialerIsSuccess(Context paramContext, boolean paramBoolean, int paramInt, String paramString);
  
  public static class ApkInfo {
    private PackageInfo a;
    
    public final String appName = "";
    
    public final String packageName;
    
    public final int versionCode;
    
    public final String versionName;
    
    public ApkInfo(Context param1Context, PackageInfo param1PackageInfo) {
      this.a = param1PackageInfo;
      this.packageName = param1PackageInfo.packageName;
      this.versionName = param1PackageInfo.versionName;
      this.versionCode = param1PackageInfo.versionCode;
    }
    
    public JSONObject toJSONObject() {
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.put("p", this.packageName);
        jSONObject.put("v", this.versionName);
        jSONObject.put("c", this.versionCode);
        jSONObject.put("s", (new File(this.a.applicationInfo.sourceDir)).lastModified());
        return jSONObject;
      } catch (JSONException jSONException) {
        return jSONObject;
      } 
    }
    
    public JSONObject toRecentJSONObject() {
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.put("p", this.packageName);
        jSONObject.put("v", this.versionName);
        jSONObject.put("c", this.versionCode);
        return jSONObject;
      } catch (JSONException jSONException) {
        return jSONObject;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interface\\utils\IXAdPackageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */