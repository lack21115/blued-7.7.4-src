package org.chromium.base;

import org.chromium.base.annotations.CalledByNative;

public class JavaExceptionReporter implements Thread.UncaughtExceptionHandler {
  private final boolean mCrashAfterReport;
  
  private boolean mHandlingException;
  
  private final Thread.UncaughtExceptionHandler mParent;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private JavaExceptionReporter(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, boolean paramBoolean) {
    this.mParent = paramUncaughtExceptionHandler;
    this.mCrashAfterReport = paramBoolean;
  }
  
  @CalledByNative
  private static void installHandler(boolean paramBoolean) {
    Thread.setDefaultUncaughtExceptionHandler(new JavaExceptionReporter(Thread.getDefaultUncaughtExceptionHandler(), paramBoolean));
  }
  
  private static native void nativeReportJavaException(boolean paramBoolean, Throwable paramThrowable);
  
  private static native void nativeReportJavaStackTrace(String paramString);
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
    if (!this.mHandlingException) {
      this.mHandlingException = true;
      nativeReportJavaException(this.mCrashAfterReport, paramThrowable);
    } 
    if (this.mParent != null)
      this.mParent.uncaughtException(paramThread, paramThrowable); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\JavaExceptionReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */