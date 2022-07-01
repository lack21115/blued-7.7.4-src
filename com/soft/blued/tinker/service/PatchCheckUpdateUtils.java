package com.soft.blued.tinker.service;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.framework.download.DownloadManager;
import com.blued.android.framework.download.OnFileDownloadListener;
import com.blued.android.framework.download.model.DownloadBaseInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.CommonTools;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.tinker.model.TinkerExtra;
import com.soft.blued.tinker.model.TinkerModel;
import com.soft.blued.tinker.util.TinkerTools;
import com.soft.blued.utils.Logger;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import java.io.File;

public class PatchCheckUpdateUtils {
  public static void a() {
    AppHttpUtils.a(TinkerTools.a(), AppInfo.c, (StringHttpResponseHandler)new BluedUIHttpResponse<BluedEntity<TinkerModel, TinkerExtra>>() {
          public boolean onUIFailure(int param1Int, String param1String) {
            return true;
          }
          
          public void onUIUpdate(BluedEntity<TinkerModel, TinkerExtra> param1BluedEntity) {
            Logger.b("PTH", new Object[] { "patch check update request success" });
            if (param1BluedEntity == null || !param1BluedEntity.hasData()) {
              Logger.b("PTH", new Object[] { "patch has no data" });
              return;
            } 
            ThreadManager.a().a(new ThreadExecutor(this, "checkPatchResult", param1BluedEntity) {
                  public void execute() {
                    PatchCheckUpdateUtils.a(this.a);
                  }
                });
          }
        });
  }
  
  private static void b(BluedEntity<TinkerModel, TinkerExtra> paramBluedEntity) {
    if (paramBluedEntity.extra != null && ((TinkerExtra)paramBluedEntity.extra).a == 1) {
      Logger.b("PTH", new Object[] { "patch check update need roll back" });
      Tinker.with(AppInfo.d()).cleanPatch();
      return;
    } 
    for (TinkerModel tinkerModel : paramBluedEntity.data) {
      DownloadBaseInfo downloadBaseInfo = new DownloadBaseInfo();
      downloadBaseInfo.download_url = tinkerModel.tinker_url;
      downloadBaseInfo.description = "patch";
      if (TextUtils.isEmpty(downloadBaseInfo.download_url)) {
        Logger.b("PTH", new Object[] { "download_url is empty" });
        return;
      } 
      String str1 = CommonTools.d(downloadBaseInfo.download_url);
      String str2 = CommonTools.a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("downloadDirs sub:");
      stringBuilder.append(str2);
      Logger.b("PTH", new Object[] { stringBuilder.toString() });
      if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str1)) {
        File file = new File(str2, str1);
        DownloadManager.a().a(downloadBaseInfo, file.getAbsolutePath(), new OnFileDownloadListener() {
              public void a(DownloadBaseInfo param1DownloadBaseInfo) {
                Logger.b("PTH", new Object[] { "patch download start" });
              }
              
              public void a(DownloadBaseInfo param1DownloadBaseInfo, int param1Int1, int param1Int2) {}
              
              public void a(DownloadBaseInfo param1DownloadBaseInfo, String param1String) {
                Logger.b("PTH", new Object[] { "patch file download success" });
                if (param1DownloadBaseInfo == null)
                  return; 
                if (TextUtils.isEmpty(param1String))
                  return; 
                if ((new File(param1String)).exists()) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("patch file path: ");
                  stringBuilder.append(param1String);
                  Logger.b("PTH", new Object[] { stringBuilder.toString() });
                  TinkerInstaller.onReceiveUpgradePatch(AppInfo.d(), param1String);
                } 
              }
              
              public void b(DownloadBaseInfo param1DownloadBaseInfo) {
                Logger.b("PTH", new Object[] { "patch download failure" });
              }
            }false);
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\tinker\service\PatchCheckUpdateUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */