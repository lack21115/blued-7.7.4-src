package com.ss.android.socialbase.appdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.c.c;
import com.ss.android.socialbase.appdownloader.c.d;
import com.ss.android.socialbase.downloader.d.z;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.f.a;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.k.a;
import com.ss.android.socialbase.downloader.m.f;
import java.util.Iterator;
import java.util.List;

public class DownloadReceiver extends BroadcastReceiver {
  private static final String a = DownloadReceiver.class.getSimpleName();
  
  private Handler b = new Handler(Looper.getMainLooper());
  
  private void a(Context paramContext, String paramString) {
    try {
      Intent intent = new Intent(paramContext, DownloadHandlerService.class);
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
      c c = d.h().a();
      if (str.equals("android.intent.action.BOOT_COMPLETED") && (c == null || c.a())) {
        if (a.a())
          a.a(a, "Received broadcast intent for android.intent.action.BOOT_COMPLETED"); 
        a(paramContext, str);
        return;
      } 
      if (str.equals("android.intent.action.MEDIA_MOUNTED")) {
        if (a.a())
          a.a(a, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED"); 
        a(paramContext, str);
        return;
      } 
      if (str.equals("android.intent.action.PACKAGE_ADDED") || str.equals("android.intent.action.PACKAGE_REPLACED"))
        b.k().execute(new Runnable(this, paramIntent, paramContext) {
              public void run() {
                Uri uri = this.a.getData();
                if (uri == null)
                  return; 
                String str = uri.getSchemeSpecificPart();
                d d = d.h().b();
                if (d != null)
                  d.a(this.b, str); 
                List list = f.a(this.b).b("application/vnd.android.package-archive");
                if (list != null) {
                  Iterator<c> iterator = list.iterator();
                  while (iterator.hasNext()) {
                    c c = iterator.next();
                    if (c != null && c.a(c, str)) {
                      z z = f.a(this.b).i(c.g());
                      if (z != null && f.e(z.a()))
                        z.a(9, c, str, ""); 
                      a a = a.a(c.g());
                      boolean bool = false;
                      if (a.a("install_queue_enable", 0) == 1)
                        bool = true; 
                      if (bool)
                        i.a().a(c, str); 
                      DownloadReceiver.a(this.c).postDelayed(new Runnable(this, c) {
                            public void run() {
                              b.k().execute(new Runnable(this) {
                                    public void run() {
                                      try {
                                        if (this.a.a.be())
                                          return; 
                                      } finally {
                                        Exception exception = null;
                                      } 
                                    }
                                  });
                            }
                          }1000L);
                      break;
                    } 
                  } 
                } 
              }
            }); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\DownloadReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */