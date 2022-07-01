package com.blued.android.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
  private Context a;
  
  private CrashInfoInterface b;
  
  private Thread.UncaughtExceptionHandler c;
  
  private boolean a() {
    Context context = this.a;
    boolean bool = false;
    SharedPreferences sharedPreferences = context.getSharedPreferences("bd_crash", 0);
    long l1 = sharedPreferences.getLong("crash_time", 0L);
    int i = sharedPreferences.getInt("crash_count", 0);
    long l2 = System.currentTimeMillis();
    if (l2 - l1 <= 10000L) {
      int j = i + 1;
      i = j;
      if (j >= 3) {
        bool = true;
        i = j;
      } 
    } else {
      i = 1;
    } 
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putLong("crash_time", l2);
    editor.putInt("crash_count", i);
    editor.commit();
    return bool;
  }
  
  private boolean a(Throwable paramThrowable) {
    if (a())
      return false; 
    if (paramThrowable == null)
      return true; 
    paramThrowable.printStackTrace();
    CrashInfoInterface crashInfoInterface = this.b;
    if (crashInfoInterface != null)
      crashInfoInterface.a(paramThrowable); 
    AppMethods.a(AppInfo.d(), paramThrowable, AppMethods.a("crash"), this.b);
    try {
      Thread.sleep(1000L);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    Process.killProcess(Process.myPid());
    return true;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    if (!a(paramThrowable)) {
      Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.c;
      if (uncaughtExceptionHandler != null) {
        uncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable);
        return;
      } 
    } 
    System.exit(16);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\CrashHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */