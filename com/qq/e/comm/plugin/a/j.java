package com.qq.e.comm.plugin.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.at;

public class j {
  static Intent a(Context paramContext) {
    return c(paramContext).putExtra("recover", true);
  }
  
  static Intent a(Context paramContext, c paramc) {
    return c(paramContext).putExtra("gdt_apkdownload_task", paramc.u());
  }
  
  static Bundle a(Intent paramIntent) {
    return paramIntent.getBundleExtra("gdt_apkdownload_task");
  }
  
  public static void a(Intent paramIntent, boolean paramBoolean) {
    paramIntent.putExtra("trigger_by_notify_bar", paramBoolean);
  }
  
  static Intent b(Context paramContext) {
    return c(paramContext).putExtra("repair", true);
  }
  
  static boolean b(Intent paramIntent) {
    return paramIntent.getBooleanExtra("repair", false);
  }
  
  static Intent c(Context paramContext) {
    Intent intent = new Intent();
    intent.setClassName(paramContext, at.f());
    intent.putExtra("GDT_APPID", GDTADManager.getInstance().getAppStatus().getAPPID());
    return intent;
  }
  
  static boolean c(Intent paramIntent) {
    return paramIntent.getBooleanExtra("recover", false);
  }
  
  static boolean d(Intent paramIntent) {
    return paramIntent.getBooleanExtra("trigger_by_notify_bar", false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */