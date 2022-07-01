package com.bytedance.embedapplog.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.bytedance.embedapplog.util.b;
import com.bytedance.embedapplog.util.h;
import org.json.JSONObject;

class s extends c {
  private final Context e;
  
  s(Context paramContext) {
    super(true, false);
    this.e = paramContext;
  }
  
  protected boolean a(JSONObject paramJSONObject) {
    String str;
    Signature signature;
    PackageManager packageManager1 = this.e.getPackageManager();
    PackageManager packageManager2 = null;
    try {
      signature = (Signature)packageManager1.getPackageInfo(this.e.getPackageName(), 64);
    } catch (Exception exception) {
      h.a(exception);
      signature = null;
    } 
    packageManager1 = packageManager2;
    if (signature != null) {
      packageManager1 = packageManager2;
      if (((PackageInfo)signature).signatures != null) {
        packageManager1 = packageManager2;
        if (((PackageInfo)signature).signatures.length > 0) {
          signature = ((PackageInfo)signature).signatures[0];
          packageManager1 = packageManager2;
          if (signature != null)
            str = b.b(signature.toByteArray()); 
        } 
      } 
    } 
    if (str != null)
      paramJSONObject.put("sig_hash", str); 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */