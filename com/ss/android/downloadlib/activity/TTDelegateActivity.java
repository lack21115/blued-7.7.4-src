package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.app.ActivityCompat;
import com.ss.android.a.a.a.n;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.e.e;
import com.ss.android.downloadlib.e.g;
import java.lang.ref.WeakReference;

public class TTDelegateActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {
  protected Intent a = null;
  
  public static void a(String paramString) {
    Intent intent = new Intent(j.a(), TTDelegateActivity.class);
    intent.addFlags(268435456);
    intent.putExtra("type", 2);
    intent.putExtra("open_url", paramString);
    if (j.a() != null)
      j.a().startActivity(intent); 
  }
  
  public static void a(String paramString, String[] paramArrayOfString) {
    Intent intent = new Intent(j.a(), TTDelegateActivity.class);
    intent.addFlags(268435456);
    intent.putExtra("type", 1);
    intent.putExtra("permission_id_key", paramString);
    intent.putExtra("permission_content_key", paramArrayOfString);
    if (j.a() != null)
      j.a().startActivity(intent); 
  }
  
  private void b() {
    Window window = getWindow();
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    layoutParams.alpha = 0.0F;
    window.setAttributes(layoutParams);
  }
  
  private void b(String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      g.a(this);
      return;
    } 
    try {
      Uri uri = Uri.parse(paramString);
      Intent intent = new Intent("android.intent.action.VIEW");
      intent.setData(uri);
      intent.putExtra("open_url", paramString);
      intent.addFlags(268435456);
      startActivity(intent);
    } catch (Exception exception) {
      exception.printStackTrace();
    } finally {}
    g.a(this);
  }
  
  private void b(String paramString, String[] paramArrayOfString) {
    if (TextUtils.isEmpty(paramString) || paramArrayOfString == null || paramArrayOfString.length <= 0) {
      g.a(this);
      return;
    } 
    n n = new n(this, paramString) {
        private WeakReference<Activity> c = new WeakReference<Activity>(this.b);
        
        public void a() {
          e.a(this.a);
          g.a(this.c.get());
        }
        
        public void a(String param1String) {
          e.a(this.a, param1String);
          g.a(this.c.get());
        }
      };
    if (Build.VERSION.SDK_INT >= 23)
      try {
        j.f().a(this, paramArrayOfString, n);
        return;
      } catch (Exception exception) {
        n.a();
        return;
      }  
    n.a();
  }
  
  protected void a() {
    Intent intent = this.a;
    if (intent == null)
      return; 
    int i = intent.getIntExtra("type", 0);
    if (i != 1) {
      if (i != 2) {
        g.a(this);
      } else {
        b(this.a.getStringExtra("open_url"));
      } 
    } else {
      b(this.a.getStringExtra("permission_id_key"), this.a.getStringArrayExtra("permission_content_key"));
    } 
    this.a = null;
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    b();
    this.a = getIntent();
    j.b((Context)this);
  }
  
  protected void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    this.a = paramIntent;
    j.b((Context)this);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfint);
    j.f().a(this, paramInt, paramArrayOfString, paramArrayOfint);
  }
  
  protected void onResume() {
    super.onResume();
    a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\activity\TTDelegateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */