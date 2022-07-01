package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.core.f.d;
import com.bytedance.sdk.openadsdk.core.f.e;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.widget.b;
import com.bytedance.sdk.openadsdk.downloadnew.a.d;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.h;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.ArrayList;

public class TTDelegateActivity extends Activity {
  private Intent a;
  
  private AlertDialog b;
  
  private void a() {
    if (h.c().l())
      getWindow().addFlags(2621440); 
    Window window = getWindow();
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    layoutParams.alpha = 0.0F;
    window.setAttributes(layoutParams);
  }
  
  private void a(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener) {
    try {
      if (this.b == null) {
        String str;
        if (Build.VERSION.SDK_INT >= 21) {
          str = "Theme.Dialog.TTDownload";
        } else {
          str = "Theme.Dialog.TTDownloadOld";
        } 
        int i = ab.g((Context)this, str);
        this.b = (new AlertDialog.Builder((Context)this, i)).create();
      } 
      this.b.setTitle(String.valueOf(paramString1));
      this.b.setMessage(String.valueOf(paramString2));
      this.b.setButton(-1, ab.a((Context)this, "tt_label_ok"), paramOnClickListener1);
      this.b.setButton(-2, ab.a((Context)this, "tt_label_cancel"), paramOnClickListener2);
      this.b.setOnCancelListener(paramOnCancelListener);
      if (!this.b.isShowing()) {
        this.b.show();
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void a(String paramString1, String paramString2, String paramString3) {
    Intent intent = new Intent(o.a(), TTDelegateActivity.class);
    intent.addFlags(268435456);
    intent.putExtra("type", 3);
    intent.putExtra("app_download_url", paramString1);
    intent.putExtra("dialog_title_key", paramString2);
    intent.putExtra("dialog_content_key", paramString3);
    if (o.a() != null)
      b.a(o.a(), intent, null); 
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    Intent intent = new Intent(o.a(), TTDelegateActivity.class);
    intent.addFlags(268435456);
    intent.putExtra("type", 5);
    intent.putExtra("app_download_url", paramString1);
    intent.putExtra("dialog_title_key", paramString2);
    intent.putExtra("dialog_content_key", paramString3);
    intent.putExtra("dialog_btn_yes_key", paramString4);
    intent.putExtra("dialog_btn_no_key", paramString5);
    if (o.a() != null)
      b.a(o.a(), intent, null); 
  }
  
  public static void a(String paramString, String[] paramArrayOfString) {
    Intent intent = new Intent(o.a(), TTDelegateActivity.class);
    intent.addFlags(268435456);
    intent.putExtra("type", 4);
    intent.putExtra("permission_id_key", paramString);
    intent.putExtra("permission_content_key", paramArrayOfString);
    if (o.a() != null)
      b.a(o.a(), intent, new b.a() {
            public void a() {}
            
            public void a(Throwable param1Throwable) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("requestPermission->startActivity error :");
              stringBuilder.append(param1Throwable.toString());
              t.b(stringBuilder.toString());
            }
          }); 
  }
  
  private void b() {
    try {
      int i = this.a.getIntExtra("type", 0);
      String str = this.a.getStringExtra("app_download_url");
      this.a.getStringExtra("app_name");
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 4) {
              if (i != 5) {
                finish();
                return;
              } 
              b(str, this.a.getStringExtra("dialog_title_key"), this.a.getStringExtra("dialog_content_key"), this.a.getStringExtra("dialog_btn_yes_key"), this.a.getStringExtra("dialog_btn_no_key"));
              return;
            } 
            b(this.a.getStringExtra("permission_id_key"), this.a.getStringArrayExtra("permission_content_key"));
            return;
          } 
          b(str, this.a.getStringExtra("dialog_title_key"), this.a.getStringExtra("dialog_content_key"));
          return;
        } 
        c();
        return;
      } 
    } catch (Exception exception) {
      finish();
    } 
  }
  
  private void b(String paramString1, String paramString2, String paramString3) {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
      str = ab.a((Context)this, "tt_tip"); 
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3))
      paramString2 = ""; 
    a(str, paramString2, new DialogInterface.OnClickListener(this, paramString1) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            g.a(this.a);
            this.b.finish();
          }
        }new DialogInterface.OnClickListener(this, paramString1) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            g.b(this.a);
            this.b.finish();
          }
        }new DialogInterface.OnCancelListener(this, paramString1) {
          public void onCancel(DialogInterface param1DialogInterface) {
            g.c(this.a);
            this.b.finish();
          }
        });
  }
  
  private void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    AlertDialog alertDialog = this.b;
    if (alertDialog != null)
      alertDialog.dismiss(); 
    b b = (new b((Context)this)).a(paramString2).b(paramString3).c(paramString4).d(paramString5).a(new b.a(this, paramString1) {
          public void a(Dialog param1Dialog) {
            g.a(this.a);
            this.b.finish();
          }
          
          public void b(Dialog param1Dialog) {
            g.b(this.a);
            this.b.finish();
          }
        }).a(new DialogInterface.OnCancelListener(this, paramString1) {
          public void onCancel(DialogInterface param1DialogInterface) {
            g.c(this.a);
            this.b.finish();
          }
        });
    b.show();
    this.b = (AlertDialog)b;
  }
  
  private void b(String paramString, String[] paramArrayOfString) {
    if (TextUtils.isEmpty(paramString) || paramArrayOfString == null || paramArrayOfString.length <= 0) {
      finish();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 23)
      try {
        d.a().a(this, paramArrayOfString, new e(this, paramString) {
              public void a() {
                h.a(this.a);
                this.b.finish();
              }
              
              public void a(String param1String) {
                h.a(this.a, param1String);
                this.b.finish();
              }
            });
        return;
      } catch (Exception exception) {
        finish();
        return;
      }  
    t.b("TT_AD_SDK", "已经有权限");
    finish();
  }
  
  private void c() {
    if (Build.VERSION.SDK_INT >= 23)
      try {
        TTCustomController tTCustomController = h.c().d();
        boolean bool1 = tTCustomController.isCanUseLocation();
        boolean bool2 = tTCustomController.isCanUsePhoneState();
        boolean bool3 = tTCustomController.isCanUseWriteExternal();
        ArrayList<String> arrayList = new ArrayList();
        if (bool1) {
          arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
          arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        } 
        if (bool2)
          arrayList.add("android.permission.READ_PHONE_STATE"); 
        if (bool3)
          arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE"); 
        String[] arrayOfString = new String[arrayList.size()];
        arrayList.toArray(arrayOfString);
        d.a().a(this, arrayOfString, new e(this) {
              public void a() {
                com.bytedance.sdk.openadsdk.i.a.a().c(new TTDelegateActivity.a(), 1);
                this.a.finish();
              }
              
              public void a(String param1String) {
                "android.permission.READ_PHONE_STATE".equals(param1String);
                com.bytedance.sdk.openadsdk.i.a.a().c(new TTDelegateActivity.a(), 1);
                this.a.finish();
              }
            });
        return;
      } catch (Exception exception) {
        finish();
        return;
      }  
    t.b("TT_AD_SDK", "已经有Read phone state权限");
    finish();
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    a();
    this.a = getIntent();
    if (o.a() == null)
      o.a((Context)this); 
  }
  
  protected void onDestroy() {
    try {
      if (this.b != null && this.b.isShowing())
        this.b.dismiss(); 
    } finally {
      Exception exception;
    } 
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    if (o.a() == null)
      o.a((Context)this); 
    try {
      setIntent(paramIntent);
      return;
    } finally {
      paramIntent = null;
    } 
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfint) {
    d.a().a(this, paramArrayOfString, paramArrayOfint);
    com.bytedance.sdk.openadsdk.i.a.a().c(new a(), 1);
    finish();
  }
  
  protected void onResume() {
    super.onResume();
    if (getIntent() != null)
      b(); 
  }
  
  public static class a implements Runnable {
    public void run() {
      d.a();
      j.j(o.a());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\activity\TTDelegateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */