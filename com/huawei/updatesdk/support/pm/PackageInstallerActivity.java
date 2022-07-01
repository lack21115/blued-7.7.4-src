package com.huawei.updatesdk.support.pm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.updatesdk.a.a.b.a.a.a;
import com.huawei.updatesdk.a.a.c.h.b;
import com.huawei.updatesdk.a.b.c.b;
import com.huawei.updatesdk.b.d.a;
import com.huawei.updatesdk.fileprovider.UpdateSdkFileProvider;
import java.io.File;

public class PackageInstallerActivity extends Activity {
  private Intent a(Context paramContext, String paramString) {
    if (!TextUtils.isEmpty(paramString) && !paramString.contains("../") && !paramString.contains("..") && !paramString.contains("%00") && !paramString.contains(".\\.\\") && !paramString.contains("./")) {
      Uri uri;
      Intent intent = new Intent();
      intent.setAction("android.intent.action.INSTALL_PACKAGE");
      if (Build.VERSION.SDK_INT >= 24) {
        intent.addFlags(1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramContext.getApplicationContext().getPackageName());
        stringBuilder.append(".updateSdk.fileProvider");
        uri = UpdateSdkFileProvider.getUriForFile(paramContext, stringBuilder.toString(), new File(paramString));
      } else {
        uri = Uri.fromFile(new File((String)uri));
      } 
      intent.setData(uri);
      if (!(paramContext instanceof Activity))
        intent.addFlags(268435456); 
      return intent;
    } 
    throw new IllegalArgumentException("getNomalInstallIntent: Not a standard path");
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (1000 == paramInt1)
      if (paramInt2 == 0) {
        a.a(7, 0);
      } else {
        paramInt1 = -10004;
        if (paramIntent != null)
          paramInt1 = b.a(paramIntent).a("android.intent.extra.INSTALL_RESULT", -10004); 
        if (paramInt1 != 0 && paramInt1 != 1)
          a.a(4, paramInt1); 
      }  
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    String str;
    requestWindowFeature(1);
    b.d().a(getWindow());
    super.onCreate(paramBundle);
    Intent intent = getIntent();
    if (intent == null) {
      finish();
      str = "PackageInstallerActivity error intent";
    } else {
      b b = b.a((Intent)str);
      str = b.a("install_path");
      String str1 = b.a("install_packagename");
      if (TextUtils.isEmpty(str)) {
        a.a(4, -3);
        finish();
        str = "PackageInstallerActivity can not find filePath.";
      } else {
        try {
          Intent intent1 = a((Context)this, str);
          intent1.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
          intent1.putExtra("android.intent.extra.RETURN_RESULT", true);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(" onCreate filePath:");
          stringBuilder.append(str);
          stringBuilder.append(",packageName:");
          stringBuilder.append(str1);
          stringBuilder.append(",taskId:");
          stringBuilder.append(getTaskId());
          a.c("PackageInstallerActivity", stringBuilder.toString());
          startActivityForResult(intent1, 1000);
          return;
        } catch (Exception exception) {
          a.b("PackageInstallerActivity", "can not start install action");
          a.a(4, -2);
          finish();
          return;
        } 
      } 
    } 
    a.b("PackageInstallerActivity", (String)exception);
  }
  
  protected void onDestroy() {
    finishActivity(1000);
    super.onDestroy();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\support\pm\PackageInstallerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */