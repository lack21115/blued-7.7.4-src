package com.huawei.updatesdk.b.d;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.updatesdk.a.b.c.b;
import com.huawei.updatesdk.b.c.c;
import com.huawei.updatesdk.support.pm.PackageInstallerActivity;
import java.io.File;

public class a {
  public static void a(int paramInt1, int paramInt2) {
    Intent intent = new Intent();
    Bundle bundle = new Bundle();
    bundle.putInt("INSTALL_STATE", paramInt1);
    bundle.putInt("INSTALL_TYPE", paramInt2);
    intent.putExtras(bundle);
    b b = b.a(intent);
    c.b().c(b);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    StringBuilder stringBuilder;
    a(3, 1);
    File file = new File(paramString1);
    if (!file.exists() || !file.isFile() || file.length() <= 0L) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("system install failed,file not existed filePath:");
      stringBuilder.append(paramString1);
      com.huawei.updatesdk.a.a.b.a.a.a.b("InstallProcess", stringBuilder.toString());
      a(4, -10003);
      return;
    } 
    Intent intent = new Intent((Context)stringBuilder, PackageInstallerActivity.class);
    intent.putExtra("install_path", paramString1);
    intent.putExtra("install_packagename", paramString2);
    if (!(stringBuilder instanceof android.app.Activity))
      intent.setFlags(402653184); 
    try {
      stringBuilder.startActivity(intent);
      return;
    } catch (ActivityNotFoundException activityNotFoundException) {
      a(4, -10002);
      com.huawei.updatesdk.a.a.b.a.a.a.a("InstallProcess", " can not start install !", (Throwable)activityNotFoundException);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\b\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */