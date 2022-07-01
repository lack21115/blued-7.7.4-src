package com.soft.blued.tinker.crash;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.soft.blued.tinker.reporter.BluedTinkerReport;
import com.soft.blued.tinker.util.TinkerManager;
import com.soft.blued.tinker.util.Utils;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.tinker.TinkerApplicationHelper;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

public class BluedUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
  private final Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();
  
  private void a(Throwable paramThrowable) {
    ApplicationLike applicationLike = TinkerManager.a();
    if (applicationLike == null || applicationLike.getApplication() == null) {
      TinkerLog.w("Tinker.BluedUncaughtExceptionHandler", "applicationlike is null", new Object[0]);
      return;
    } 
    if (!TinkerApplicationHelper.isTinkerLoadSuccess(applicationLike)) {
      TinkerLog.w("Tinker.BluedUncaughtExceptionHandler", "tinker is not loaded", new Object[0]);
      return;
    } 
    for (boolean bool = false; paramThrowable != null; bool = bool1) {
      boolean bool1 = bool;
      if (!bool)
        bool1 = Utils.a(paramThrowable); 
      if (bool1) {
        boolean bool2;
        if (paramThrowable instanceof IllegalAccessError && paramThrowable.getMessage().contains("Class ref in pre-verified class resolved to unexpected implementation")) {
          bool2 = true;
        } else {
          bool2 = false;
        } 
        if (bool2) {
          BluedTinkerReport.f();
          TinkerLog.e("Tinker.BluedUncaughtExceptionHandler", "have xposed: just clean tinker", new Object[0]);
          ShareTinkerInternals.killAllOtherProcess((Context)applicationLike.getApplication());
          TinkerApplicationHelper.cleanPatch(applicationLike);
          ShareTinkerInternals.setTinkerDisableWithSharedPreferences((Context)applicationLike.getApplication());
          return;
        } 
      } 
      paramThrowable = paramThrowable.getCause();
    } 
  }
  
  private boolean a() {
    ApplicationLike applicationLike = TinkerManager.a();
    if (applicationLike != null) {
      if (applicationLike.getApplication() == null)
        return false; 
      if (!TinkerApplicationHelper.isTinkerLoadSuccess(applicationLike))
        return false; 
      if (SystemClock.elapsedRealtime() - applicationLike.getApplicationStartElapsedTime() < 10000L) {
        String str = TinkerApplicationHelper.getCurrentVersion(applicationLike);
        if (ShareTinkerInternals.isNullOrNil(str))
          return false; 
        SharedPreferences sharedPreferences = applicationLike.getApplication().getSharedPreferences("tinker_share_config", 4);
        int i = sharedPreferences.getInt(str, 0) + 1;
        if (i >= 3) {
          BluedTinkerReport.e();
          TinkerApplicationHelper.cleanPatch(applicationLike);
          TinkerLog.e("Tinker.BluedUncaughtExceptionHandler", "tinker has fast crash more than %d, we just clean patch!", new Object[] { Integer.valueOf(i) });
          return true;
        } 
        sharedPreferences.edit().putInt(str, i).commit();
        TinkerLog.e("Tinker.BluedUncaughtExceptionHandler", "tinker has fast crash %d times", new Object[] { Integer.valueOf(i) });
      } 
    } 
    return false;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    TinkerLog.e("Tinker.BluedUncaughtExceptionHandler", "uncaughtException:", new Object[0]);
    if (paramThrowable != null)
      TinkerLog.e("Tinker.BluedUncaughtExceptionHandler", paramThrowable.getMessage(), new Object[0]); 
    a();
    a(paramThrowable);
    if (this.a != null && paramThread != null && paramThrowable != null) {
      TinkerLog.e("Tinker.BluedUncaughtExceptionHandler", "uncaughtException report", new Object[0]);
      this.a.uncaughtException(paramThread, paramThrowable);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\tinker\crash\BluedUncaughtExceptionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */