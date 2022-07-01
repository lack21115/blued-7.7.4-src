package com.soft.blued.tinker.util;

import android.content.Context;
import com.soft.blued.tinker.crash.BluedUncaughtExceptionHandler;
import com.soft.blued.tinker.reporter.BluedLoadReporter;
import com.soft.blued.tinker.reporter.BluedPatchListener;
import com.soft.blued.tinker.reporter.BluedPatchReporter;
import com.soft.blued.tinker.service.PatchLoadResultService;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.listener.PatchListener;
import com.tencent.tinker.lib.patch.AbstractPatch;
import com.tencent.tinker.lib.patch.UpgradePatch;
import com.tencent.tinker.lib.reporter.LoadReporter;
import com.tencent.tinker.lib.reporter.PatchReporter;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.lib.util.UpgradePatchRetry;

public class TinkerManager {
  private static ApplicationLike a;
  
  private static BluedUncaughtExceptionHandler b;
  
  private static boolean c = false;
  
  public static ApplicationLike a() {
    return a;
  }
  
  public static void a(ApplicationLike paramApplicationLike) {
    a = paramApplicationLike;
  }
  
  public static void a(boolean paramBoolean) {
    UpgradePatchRetry.getInstance((Context)a.getApplication()).setRetryEnable(paramBoolean);
  }
  
  public static void b() {
    if (b == null) {
      b = new BluedUncaughtExceptionHandler();
      Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)b);
    } 
  }
  
  public static void b(ApplicationLike paramApplicationLike) {
    if (c) {
      TinkerLog.w("Tinker.TinkerManager", "install tinker, but has installed, ignore", new Object[0]);
      return;
    } 
    TinkerInstaller.install(paramApplicationLike, (LoadReporter)new BluedLoadReporter((Context)paramApplicationLike.getApplication()), (PatchReporter)new BluedPatchReporter((Context)paramApplicationLike.getApplication()), (PatchListener)new BluedPatchListener((Context)paramApplicationLike.getApplication()), PatchLoadResultService.class, (AbstractPatch)new UpgradePatch());
    c = true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\tinke\\util\TinkerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */