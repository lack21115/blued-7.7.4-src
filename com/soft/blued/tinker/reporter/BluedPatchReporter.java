package com.soft.blued.tinker.reporter;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.reporter.DefaultPatchReporter;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.List;

public class BluedPatchReporter extends DefaultPatchReporter {
  public BluedPatchReporter(Context paramContext) {
    super(paramContext);
  }
  
  public void onPatchDexOptFail(File paramFile, List<File> paramList, Throwable paramThrowable) {
    super.onPatchDexOptFail(paramFile, paramList, paramThrowable);
    BluedTinkerReport.a(paramThrowable);
  }
  
  public void onPatchException(File paramFile, Throwable paramThrowable) {
    super.onPatchException(paramFile, paramThrowable);
    BluedTinkerReport.b(paramThrowable);
  }
  
  public void onPatchInfoCorrupted(File paramFile, String paramString1, String paramString2) {
    super.onPatchInfoCorrupted(paramFile, paramString1, paramString2);
    BluedTinkerReport.c();
  }
  
  public void onPatchPackageCheckFail(File paramFile, int paramInt) {
    super.onPatchPackageCheckFail(paramFile, paramInt);
    BluedTinkerReport.f(paramInt);
  }
  
  public void onPatchResult(File paramFile, boolean paramBoolean, long paramLong) {
    super.onPatchResult(paramFile, paramBoolean, paramLong);
    BluedTinkerReport.a(paramLong, paramBoolean);
  }
  
  public void onPatchServiceStart(Intent paramIntent) {
    super.onPatchServiceStart(paramIntent);
    BluedTinkerReport.b();
  }
  
  public void onPatchTypeExtractFail(File paramFile1, File paramFile2, String paramString, int paramInt) {
    super.onPatchTypeExtractFail(paramFile1, paramFile2, paramString, paramInt);
    BluedTinkerReport.e(paramInt);
  }
  
  public void onPatchVersionCheckFail(File paramFile, SharePatchInfo paramSharePatchInfo, String paramString) {
    super.onPatchVersionCheckFail(paramFile, paramSharePatchInfo, paramString);
    BluedTinkerReport.d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\tinker\reporter\BluedPatchReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */