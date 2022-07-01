package com.bytedance.embedapplog.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.h;
import org.json.JSONObject;

class p extends c {
  private final Context e;
  
  private final h f;
  
  p(Context paramContext, h paramh) {
    super(false, false);
    this.e = paramContext;
    this.f = paramh;
  }
  
  protected boolean a(JSONObject paramJSONObject) {
    String str = this.e.getPackageName();
    if (TextUtils.isEmpty(this.f.T())) {
      paramJSONObject.put("package", str);
    } else {
      if (h.b)
        h.a("has zijie pkg", null); 
      paramJSONObject.put("package", this.f.T());
      paramJSONObject.put("real_package_name", str);
    } 
    try {
      PackageInfo packageInfo = this.e.getPackageManager().getPackageInfo(str, 0);
      int i = packageInfo.versionCode;
      boolean bool = TextUtils.isEmpty(this.f.K());
      if (!bool) {
        paramJSONObject.put("app_version", this.f.K());
      } else {
        paramJSONObject.put("app_version", packageInfo.versionName);
      } 
      bool = TextUtils.isEmpty(this.f.P());
      if (!bool) {
        paramJSONObject.put("app_version_minor", this.f.P());
      } else {
        paramJSONObject.put("app_version_minor", "");
      } 
      int j = this.f.H();
      if (j != 0) {
        paramJSONObject.put("version_code", this.f.H());
      } else {
        paramJSONObject.put("version_code", i);
      } 
      j = this.f.I();
      if (j != 0) {
        paramJSONObject.put("update_version_code", this.f.I());
      } else {
        paramJSONObject.put("update_version_code", i);
      } 
      j = this.f.J();
      if (j != 0) {
        paramJSONObject.put("manifest_version_code", this.f.J());
      } else {
        paramJSONObject.put("manifest_version_code", i);
      } 
      if (!TextUtils.isEmpty(this.f.G()))
        paramJSONObject.put("app_name", this.f.G()); 
      if (!TextUtils.isEmpty(this.f.L()))
        paramJSONObject.put("tweaked_channel", this.f.L()); 
      if (packageInfo.applicationInfo != null) {
        i = packageInfo.applicationInfo.labelRes;
        if (i > 0)
          paramJSONObject.put("display_name", this.e.getString(i)); 
      } 
      return true;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      h.a((Throwable)nameNotFoundException);
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */