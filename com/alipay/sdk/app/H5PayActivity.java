package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.data.a;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.n;
import com.alipay.sdk.widget.g;
import com.alipay.sdk.widget.h;
import com.alipay.sdk.widget.j;

public class H5PayActivity extends Activity {
  private g a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private boolean f;
  
  private String g;
  
  private void b() {
    try {
      return;
    } finally {
      Exception exception = null;
      c.a(exception);
    } 
  }
  
  public void a() {
    synchronized (PayTask.a) {
      null.notify();
    } 
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_1} */
  }
  
  public void finish() {
    a();
    super.finish();
  }
  
  public void onBackPressed() {
    g g1 = this.a;
    if (g1 instanceof h) {
      g1.b();
      return;
    } 
    if (!g1.b())
      super.onBackPressed(); 
    j.a(j.c());
    finish();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle) {
    b();
    super.onCreate(paramBundle);
    try {
      a a = a.a.a(getIntent());
      if (a == null) {
        finish();
        return;
      } 
      if (!a.j().b()) {
        setRequestedOrientation(1);
      } else {
        setRequestedOrientation(3);
      } 
      try {
        Bundle bundle = getIntent().getExtras();
        this.b = bundle.getString("url", null);
        if (!n.d(this.b)) {
          finish();
          return;
        } 
        this.d = bundle.getString("cookie", null);
        this.c = bundle.getString("method", null);
        this.e = bundle.getString("title", null);
        this.g = bundle.getString("version", "v1");
        this.f = bundle.getBoolean("backisexit", false);
        try {
          if ("v2".equals(this.g)) {
            j j = new j(this, a);
            setContentView((View)j);
            return;
          } 
          this.a = (g)new h(this, a);
          return;
        } finally {
          bundle = null;
          a.a(a, "biz", "GetInstalledAppEx", (Throwable)bundle);
          finish();
        } 
      } catch (Exception exception) {
        finish();
      } 
      return;
    } catch (Exception exception) {
      finish();
      return;
    } 
  }
  
  protected void onDestroy() {
    super.onDestroy();
    g g1 = this.a;
    if (g1 != null)
      g1.a(); 
  }
  
  public void setRequestedOrientation(int paramInt) {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\app\H5PayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */