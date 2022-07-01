package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.appdownloader.c.c;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.k;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.d.a;
import com.ss.android.socialbase.appdownloader.k;
import org.json.JSONException;
import org.json.JSONObject;

public class JumpUnknownSourceActivity extends Activity {
  private j a;
  
  private Intent b;
  
  private Intent c;
  
  private JSONObject d;
  
  private void a() {
    Window window = getWindow();
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    layoutParams.alpha = 0.0F;
    window.setAttributes(layoutParams);
  }
  
  private void b() {
    if (this.a == null) {
      if (this.b == null)
        return; 
      try {
        a a;
        c c = d.h().a();
        k k1 = null;
        if (c != null)
          k1 = c.a((Context)this); 
        k k2 = k1;
        if (k1 == null)
          a = new a((Context)this); 
        int i = k.a((Context)this, "appdownloader_tip");
        int k = k.a((Context)this, "appdownloader_label_ok");
        int m = k.a((Context)this, "appdownloader_label_cancel");
        String str2 = this.d.optString("jump_unknown_source_tips");
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
          str1 = getString(k.a((Context)this, "appdownloader_jump_unknown_source_tips")); 
        a.a(i).a(str1).a(k, new DialogInterface.OnClickListener(this) {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                JumpUnknownSourceActivity jumpUnknownSourceActivity = this.a;
                if (!b.a((Context)jumpUnknownSourceActivity, JumpUnknownSourceActivity.a(jumpUnknownSourceActivity), JumpUnknownSourceActivity.b(this.a))) {
                  jumpUnknownSourceActivity = this.a;
                  b.a((Context)jumpUnknownSourceActivity, JumpUnknownSourceActivity.a(jumpUnknownSourceActivity), true);
                } 
                this.a.finish();
              }
            }).b(m, new DialogInterface.OnClickListener(this) {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                if (JumpUnknownSourceActivity.a(this.a) != null) {
                  JumpUnknownSourceActivity jumpUnknownSourceActivity = this.a;
                  b.a((Context)jumpUnknownSourceActivity, JumpUnknownSourceActivity.a(jumpUnknownSourceActivity), true);
                } 
                this.a.finish();
              }
            }).a(new DialogInterface.OnCancelListener(this) {
              public void onCancel(DialogInterface param1DialogInterface) {
                if (JumpUnknownSourceActivity.a(this.a) != null) {
                  JumpUnknownSourceActivity jumpUnknownSourceActivity = this.a;
                  b.a((Context)jumpUnknownSourceActivity, JumpUnknownSourceActivity.a(jumpUnknownSourceActivity), true);
                } 
                this.a.finish();
              }
            }).a(false);
        this.a = a.a();
        return;
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
    Intent intent = getIntent();
    this.b = intent;
    if (intent != null) {
      this.c = (Intent)intent.getParcelableExtra("intent");
      try {
        this.d = new JSONObject(intent.getStringExtra("config"));
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
    } 
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\view\JumpUnknownSourceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */