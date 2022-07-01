package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.ss.android.socialbase.appdownloader.c.c;
import com.ss.android.socialbase.appdownloader.c.d;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.d.a;
import com.ss.android.socialbase.appdownloader.k;
import com.ss.android.socialbase.downloader.d.z;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.g.c;

public class DownloadTaskDeleteActivity extends Activity {
  private j a;
  
  private Intent b;
  
  private void a() {
    Window window = getWindow();
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    layoutParams.alpha = 0.0F;
    window.setAttributes(layoutParams);
  }
  
  private void b() {
    if (this.a == null) {
      Intent intent = this.b;
      if (intent == null)
        return; 
      try {
        k k1;
        a a;
        int i = intent.getIntExtra("extra_click_download_ids", 0);
        c c1 = f.a(getApplicationContext()).h(i);
        if (c1 == null)
          return; 
        String str1 = c1.i();
        if (TextUtils.isEmpty(str1)) {
          Log.w("DeleteActivity", "Missing appName; skipping handle");
          return;
        } 
        String str2 = String.format(getString(k.a((Context)this, "appdownloader_notification_download_delete")), new Object[] { str1 });
        c c = d.h().a();
        str1 = null;
        if (c != null)
          k1 = c.a((Context)this); 
        k k2 = k1;
        if (k1 == null)
          a = new a((Context)this); 
        if (a != null) {
          int k = k.a((Context)this, "appdownloader_tip");
          int m = k.a((Context)this, "appdownloader_label_ok");
          int n = k.a((Context)this, "appdownloader_label_cancel");
          a.a(k).a(str2).a(m, new DialogInterface.OnClickListener(this, c1, i) {
                public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                  d d = d.h().b();
                  if (d != null)
                    d.a(this.a); 
                  z z = f.a(b.B()).i(this.b);
                  if (z != null)
                    z.a(10, this.a, "", ""); 
                  if (b.B() != null)
                    f.a(b.B()).b(this.b); 
                  this.c.finish();
                }
              }).b(n, new DialogInterface.OnClickListener(this) {
                public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                  this.a.finish();
                }
              }).a(new DialogInterface.OnCancelListener(this) {
                public void onCancel(DialogInterface param1DialogInterface) {
                  this.a.finish();
                }
              });
          this.a = a.a();
          return;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    a();
  }
  
  protected void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
  }
  
  protected void onResume() {
    super.onResume();
    this.b = getIntent();
    b();
    j j1 = this.a;
    if (j1 != null && !j1.b()) {
      this.a.a();
      return;
    } 
    if (this.a == null)
      finish(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\view\DownloadTaskDeleteActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */