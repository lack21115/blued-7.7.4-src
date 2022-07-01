package com.qiniu.pili.droid.crash;

import android.content.Context;

public class h implements Thread.UncaughtExceptionHandler {
  private static final h a = new h();
  
  private Thread.UncaughtExceptionHandler b;
  
  private Context c;
  
  static h a() {
    return a;
  }
  
  private void b() {
    a a = new a(this.c);
    a.a();
    a.b();
  }
  
  void a(Context paramContext) {
    this.c = paramContext;
    this.b = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
    b();
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    NativeCrashHandler.a().b();
    try {
      (new i(this.c)).a(paramThread).a(paramThrowable).d();
    } finally {
      Exception exception = null;
    } 
    if (uncaughtExceptionHandler != null)
      uncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\crash\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */