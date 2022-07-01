package com.soft.blued.tinker.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.soft.blued.tinker.util.Utils;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.lib.service.PatchResult;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.lib.util.TinkerServiceInternals;
import java.io.File;

public class PatchLoadResultService extends DefaultTinkerResultService {
  private void a() {
    TinkerLog.i("Tinker.PatchLoadResultService", "app is background now, i can kill quietly", new Object[0]);
    Process.killProcess(Process.myPid());
  }
  
  public void onPatchResult(PatchResult paramPatchResult) {
    if (paramPatchResult == null) {
      TinkerLog.e("Tinker.PatchLoadResultService", "PatchLoadResultService received null result!!!!", new Object[0]);
      return;
    } 
    TinkerLog.i("Tinker.PatchLoadResultService", "PatchLoadResultService receive result: %s", new Object[] { paramPatchResult.toString() });
    TinkerServiceInternals.killTinkerPatchServiceProcess(getApplicationContext());
    (new Handler(Looper.getMainLooper())).post(new Runnable(this, paramPatchResult) {
          public void run() {}
        });
    if (paramPatchResult.isSuccess) {
      deleteRawPatchFile(new File(paramPatchResult.rawPatchFilePath));
      if (checkIfNeedKill(paramPatchResult)) {
        if (Utils.b()) {
          TinkerLog.i("Tinker.PatchLoadResultService", "it is in background, just restart process", new Object[0]);
          a();
          return;
        } 
        TinkerLog.i("Tinker.PatchLoadResultService", "tinker wait screen to restart process", new Object[0]);
        new Utils.ScreenState(getApplicationContext(), new Utils.ScreenState.IOnScreenOff(this) {
              public void a() {
                PatchLoadResultService.a(this.a);
              }
            });
        return;
      } 
      TinkerLog.i("Tinker.PatchLoadResultService", "I have already install the newly patch version!", new Object[0]);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\tinker\service\PatchLoadResultService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */