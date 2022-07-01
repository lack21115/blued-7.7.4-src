package com.soft.blued.tinker.reporter;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.tinker.lib.reporter.DefaultLoadReporter;
import com.tencent.tinker.lib.util.UpgradePatchRetry;
import java.io.File;

public class BluedLoadReporter extends DefaultLoadReporter {
  public BluedLoadReporter(Context paramContext) {
    super(paramContext);
  }
  
  public void onLoadException(Throwable paramThrowable, int paramInt) {
    super.onLoadException(paramThrowable, paramInt);
    BluedTinkerReport.a(paramThrowable, paramInt);
  }
  
  public void onLoadFileMd5Mismatch(File paramFile, int paramInt) {
    super.onLoadFileMd5Mismatch(paramFile, paramInt);
    BluedTinkerReport.d(paramInt);
  }
  
  public void onLoadFileNotFound(File paramFile, int paramInt, boolean paramBoolean) {
    super.onLoadFileNotFound(paramFile, paramInt, paramBoolean);
    BluedTinkerReport.c(paramInt);
  }
  
  public void onLoadInterpret(int paramInt, Throwable paramThrowable) {
    super.onLoadInterpret(paramInt, paramThrowable);
    BluedTinkerReport.a(paramInt, paramThrowable);
  }
  
  public void onLoadPackageCheckFail(File paramFile, int paramInt) {
    super.onLoadPackageCheckFail(paramFile, paramInt);
    BluedTinkerReport.b(paramInt);
  }
  
  public void onLoadPatchInfoCorrupted(String paramString1, String paramString2, File paramFile) {
    super.onLoadPatchInfoCorrupted(paramString1, paramString2, paramFile);
    BluedTinkerReport.a();
  }
  
  public void onLoadPatchListenerReceiveFail(File paramFile, int paramInt) {
    super.onLoadPatchListenerReceiveFail(paramFile, paramInt);
    BluedTinkerReport.a(paramInt);
  }
  
  public void onLoadPatchVersionChanged(String paramString1, String paramString2, File paramFile, String paramString3) {
    super.onLoadPatchVersionChanged(paramString1, paramString2, paramFile, paramString3);
  }
  
  public void onLoadResult(File paramFile, int paramInt, long paramLong) {
    super.onLoadResult(paramFile, paramInt, paramLong);
    if (paramInt == 0)
      BluedTinkerReport.a(paramLong); 
    Looper.getMainLooper();
    Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler(this) {
          public boolean queueIdle() {
            if (UpgradePatchRetry.getInstance(BluedLoadReporter.a(this.a)).onPatchRetryLoad())
              BluedTinkerReport.g(); 
            return false;
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\tinker\reporter\BluedLoadReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */