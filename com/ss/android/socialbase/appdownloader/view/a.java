package com.ss.android.socialbase.appdownloader.view;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.j;
import com.ss.android.socialbase.downloader.downloader.b;

public class a extends Fragment {
  public static Intent d() {
    return new Intent("android.settings.APPLICATION_SETTINGS");
  }
  
  private Context e() {
    Context context2 = b.B();
    Context context1 = context2;
    if (context2 == null) {
      context1 = context2;
      if (getActivity() != null) {
        context1 = context2;
        if (!getActivity().isFinishing())
          context1 = getActivity().getApplicationContext(); 
      } 
    } 
    return context1;
  }
  
  private Intent f() {
    Context context = e();
    if (context == null)
      return null; 
    Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
    String str = context.getPackageName();
    intent.putExtra("package", str);
    intent.putExtra("android.provider.extra.APP_PACKAGE", str);
    intent.putExtra("app_package", str);
    int i = (context.getApplicationInfo()).uid;
    intent.putExtra("uid", i);
    intent.putExtra("app_uid", i);
    return intent;
  }
  
  public void a() {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public Intent b() {
    Intent intent;
    Context context = e();
    if (context == null)
      return null; 
    String str = context.getPackageName();
    if (!TextUtils.isEmpty(Build.MANUFACTURER)) {
      String str1 = Build.MANUFACTURER.toLowerCase();
      if (str1.contains("oppo")) {
        intent = new Intent();
        intent.putExtra("packageName", str);
        intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
        return intent;
      } 
      if (str1.contains("vivo")) {
        intent = new Intent();
        intent.putExtra("packagename", str);
        if (Build.VERSION.SDK_INT >= 25) {
          intent.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
          return intent;
        } 
        intent.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
        return intent;
      } 
      if (str1.contains("meizu") && Build.VERSION.SDK_INT < 25) {
        intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", str);
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        return intent;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("package:");
    stringBuilder.append(intent.getPackageName());
    return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(stringBuilder.toString()));
  }
  
  public Intent c() {
    Context context = e();
    if (context == null)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("package:");
    stringBuilder.append(context.getPackageName());
    return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(stringBuilder.toString()));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (j.a()) {
      j.a(true);
      return;
    } 
    j.a(false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\view\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */