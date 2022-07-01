package com.ss.android.socialbase.downloader.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.f.a;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationService;

public class DownloadReceiver extends BroadcastReceiver {
  private static final String a = DownloadReceiver.class.getSimpleName();
  
  private void a(Context paramContext, String paramString) {
    try {
      Intent intent = new Intent(paramContext, DownloadNotificationService.class);
      return;
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  private void b(Context paramContext, String paramString) {
    try {
      Intent intent = new Intent(paramContext, DownloadNotificationService.class);
      return;
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if (paramContext != null) {
      if (paramIntent == null)
        return; 
      String str = paramIntent.getAction();
      if (TextUtils.isEmpty(str))
        return; 
      if (str.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
        if (a.a())
          a.a(a, "Received broadcast intent for android.net.conn.CONNECTIVITY_CHANGE"); 
        a(paramContext, str);
        return;
      } 
      if (str.equals("android.intent.action.MEDIA_UNMOUNTED") || str.equals("android.intent.action.MEDIA_REMOVED") || str.equals("android.intent.action.MEDIA_BAD_REMOVAL") || str.equals("android.intent.action.MEDIA_EJECT"))
        b(paramContext, str); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\downloader\DownloadReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */