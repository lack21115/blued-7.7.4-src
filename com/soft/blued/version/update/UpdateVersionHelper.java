package com.soft.blued.version.update;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.download.model.DownloadBaseInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.utils.BluedPreferences;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateVersionHelper {
  public static int a(Context paramContext) {
    if (paramContext != null)
      try {
        DownloadManager downloadManager = (DownloadManager)paramContext.getSystemService("download");
        DownloadManager.Query query = new DownloadManager.Query();
        long l = BluedPreferences.bD();
        if (l != -1L) {
          query.setFilterById(new long[] { l });
          Cursor cursor = downloadManager.query(query);
          if (cursor.moveToFirst()) {
            int i = cursor.getInt(cursor.getColumnIndex("status"));
            byte b = 2;
            if (i != 2) {
              b = 8;
              if (i != 8)
                return -1; 
            } 
            return b;
          } 
        } 
        return -1;
      } catch (Exception exception) {
        return -1;
      }  
    return -1;
  }
  
  public static void a(File paramFile) {
    if (paramFile != null && paramFile.exists())
      paramFile.delete(); 
  }
  
  public static void b(Context paramContext) {
    MineHttpUtils.a(paramContext, "0", (HttpResponseHandler)new BluedUIHttpResponse<BluedEntityA<DownloadBaseInfo>>(paramContext) {
          public void a(BluedEntityA<DownloadBaseInfo> param1BluedEntityA) {
            if (param1BluedEntityA != null)
              try {
                if (param1BluedEntityA.hasData()) {
                  DownloadBaseInfo downloadBaseInfo = param1BluedEntityA.data.get(0);
                  String str = downloadBaseInfo.type;
                  if (!TextUtils.isEmpty(downloadBaseInfo.version_code))
                    BluedPreferences.Y(downloadBaseInfo.version_code); 
                  if (!TextUtils.isEmpty(str) && str.equals("1")) {
                    if (!(this.a instanceof android.app.Activity))
                      return; 
                    str = (new SimpleDateFormat(" yyyy-MM-dd")).format(new Date());
                    if (str.equals(BluedPreferences.bO())) {
                      int i = BluedPreferences.bP();
                      if (i >= downloadBaseInfo.times)
                        return; 
                      BluedPreferences.r(i + 1);
                    } else {
                      BluedPreferences.ad(str);
                      if (downloadBaseInfo.times > 0) {
                        BluedPreferences.r(1);
                      } else {
                        BluedPreferences.r(0);
                        return;
                      } 
                    } 
                    Bundle bundle = new Bundle();
                    bundle.putString("i_s_update_tag", "i_s_weak_update");
                    bundle.putString("i_s_update_url", downloadBaseInfo.download_url);
                    bundle.putString("i_s_update_desc", downloadBaseInfo.description);
                    bundle.putString("i_s_update_version", downloadBaseInfo.version);
                    bundle.putString("i_s_update_title", downloadBaseInfo.title);
                    TerminalActivity.a(bundle);
                    TransparentActivity.b(this.a, UpdateVersionFragment.class, bundle);
                    return;
                  } 
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
              }  
          }
        });
  }
  
  public static void c(Context paramContext) {
    Intent intent = new Intent("android.intent.action.VIEW");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("market://details?id=");
    stringBuilder.append(AppInfo.a);
    intent.setData(Uri.parse(stringBuilder.toString()));
    if (intent.resolveActivity(paramContext.getPackageManager()) != null) {
      paramContext.startActivity(intent);
      return;
    } 
    stringBuilder = new StringBuilder();
    stringBuilder.append("https://play.google.com/store/apps/details?id=");
    stringBuilder.append(AppInfo.a);
    intent.setData(Uri.parse(stringBuilder.toString()));
    if (intent.resolveActivity(paramContext.getPackageManager()) != null)
      paramContext.startActivity(intent); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\versio\\update\UpdateVersionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */