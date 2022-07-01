package org.chromium.base.metrics;

import org.chromium.base.ThreadUtils;

public class RecordUserAction {
  private static Throwable sDisabledBy;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private static native long nativeAddActionCallbackForTesting(RecordUserAction$UserActionCallback paramRecordUserAction$UserActionCallback);
  
  private static native void nativeRecordUserAction(String paramString);
  
  private static native void nativeRemoveActionCallbackForTesting(long paramLong);
  
  public static void record(String paramString) {
    if (sDisabledBy != null)
      return; 
    if (ThreadUtils.runningOnUiThread()) {
      nativeRecordUserAction(paramString);
      return;
    } 
    ThreadUtils.runOnUiThread(new RecordUserAction$1(paramString));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\metrics\RecordUserAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */