package com.qq.e.comm.plugin.q;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.ab.b;
import com.qq.e.comm.plugin.ab.d.a;
import com.qq.e.comm.plugin.ab.d.e;
import com.qq.e.comm.plugin.ab.d.f;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

public class c implements ACTD, f {
  private Activity a;
  
  private a b;
  
  private String c;
  
  private long d;
  
  private long e;
  
  private long f;
  
  private String g;
  
  private boolean h;
  
  private b i;
  
  private b j;
  
  private String k;
  
  private boolean l;
  
  private ValueCallback<Uri[]> m;
  
  private ValueCallback<Uri> n;
  
  private com.qq.e.comm.plugin.y.c o;
  
  private boolean p = false;
  
  private boolean q = false;
  
  private boolean r = false;
  
  private boolean s = false;
  
  public c(Activity paramActivity) {
    this.a = paramActivity;
    this.c = paramActivity.getIntent().getStringExtra("url");
    this.d = paramActivity.getIntent().getLongExtra("clickStartTime", System.currentTimeMillis());
    String str = paramActivity.getIntent().getStringExtra("reportUrl");
    if (!TextUtils.isEmpty(str))
      this.j = new b(str, this.d); 
    this.g = this.c;
  }
  
  private void a(int paramInt, String paramString) {
    b(paramInt, paramString, null);
  }
  
  private void b(int paramInt, String paramString1, String paramString2) {
    if (GDTADManager.getInstance().getSM().getInteger("lpnaspl", 1) == 1)
      b.a(paramInt, this.d, this.o, paramString1, paramString2); 
  }
  
  public void a(int paramInt) {
    if (paramInt == 100) {
      this.i.a();
      return;
    } 
    this.i.a(paramInt);
  }
  
  public void a(int paramInt, String paramString1, String paramString2) {
    b b1 = this.j;
    if (b1 != null)
      b1.a(paramString2, b.d); 
    if (!this.s) {
      this.s = true;
      b(2040004, paramString2, paramString1);
    } 
  }
  
  public void a(ValueCallback<Uri> paramValueCallback, Intent paramIntent) {
    if (paramValueCallback != null && paramIntent != null) {
      this.n = paramValueCallback;
      this.a.startActivityForResult(paramIntent, 2);
    } 
  }
  
  public void a(String paramString) {
    b b1 = this.j;
    if (b1 != null)
      b1.a(paramString, b.c); 
    if (!this.p) {
      this.p = true;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("PageFinished url=");
      stringBuilder.append(paramString);
      GDTLogger.d(stringBuilder.toString());
      this.e = System.currentTimeMillis();
      stringBuilder = new StringBuilder();
      stringBuilder.append("页面加载完成，耗时：");
      stringBuilder.append(this.e - this.f);
      GDTLogger.d(stringBuilder.toString());
      a(2040003, paramString);
    } 
  }
  
  public void a(String paramString, Bitmap paramBitmap) {
    b b1 = this.j;
    if (b1 != null)
      b1.a(paramString, b.b); 
    if (!this.r) {
      this.r = true;
      a(2040002, paramString);
    } 
  }
  
  public void b(String paramString) {
    this.g = paramString;
    if (!this.q) {
      this.q = true;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("302 to url:");
      stringBuilder.append(paramString);
      GDTLogger.d(stringBuilder.toString());
      this.f = System.currentTimeMillis();
      stringBuilder = new StringBuilder();
      stringBuilder.append("点击到302耗时：");
      stringBuilder.append(this.f - this.d);
      GDTLogger.d(stringBuilder.toString());
      a(2040001, paramString);
    } 
  }
  
  public boolean b(ValueCallback<Uri[]> paramValueCallback, Intent paramIntent) {
    if (paramValueCallback != null && paramIntent != null) {
      this.m = paramValueCallback;
      this.a.startActivityForResult(paramIntent, 1);
      return true;
    } 
    return false;
  }
  
  public void c(String paramString) {
    if (this.l)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("title:");
    stringBuilder.append(paramString);
    GDTLogger.d(stringBuilder.toString());
    if (TextUtils.isEmpty(paramString)) {
      this.i.a(this.k);
      return;
    } 
    this.i.a(paramString);
  }
  
  public void d_() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    // Byte code:
    //   0: iconst_1
    //   1: iload_1
    //   2: if_icmpne -> 63
    //   5: aload_0
    //   6: getfield m : Landroid/webkit/ValueCallback;
    //   9: ifnull -> 63
    //   12: iload_2
    //   13: iconst_m1
    //   14: if_icmpne -> 45
    //   17: aload_3
    //   18: ifnull -> 45
    //   21: aload_3
    //   22: invokevirtual getData : ()Landroid/net/Uri;
    //   25: astore #4
    //   27: aload #4
    //   29: ifnull -> 45
    //   32: iconst_1
    //   33: anewarray android/net/Uri
    //   36: astore_3
    //   37: aload_3
    //   38: iconst_0
    //   39: aload #4
    //   41: aastore
    //   42: goto -> 47
    //   45: aconst_null
    //   46: astore_3
    //   47: aload_0
    //   48: getfield m : Landroid/webkit/ValueCallback;
    //   51: aload_3
    //   52: invokeinterface onReceiveValue : (Ljava/lang/Object;)V
    //   57: aload_0
    //   58: aconst_null
    //   59: putfield m : Landroid/webkit/ValueCallback;
    //   62: return
    //   63: iconst_2
    //   64: iload_1
    //   65: if_icmpne -> 109
    //   68: aload_0
    //   69: getfield n : Landroid/webkit/ValueCallback;
    //   72: ifnull -> 109
    //   75: iload_2
    //   76: iconst_m1
    //   77: if_icmpne -> 92
    //   80: aload_3
    //   81: ifnull -> 92
    //   84: aload_3
    //   85: invokevirtual getData : ()Landroid/net/Uri;
    //   88: astore_3
    //   89: goto -> 94
    //   92: aconst_null
    //   93: astore_3
    //   94: aload_0
    //   95: getfield n : Landroid/webkit/ValueCallback;
    //   98: aload_3
    //   99: invokeinterface onReceiveValue : (Ljava/lang/Object;)V
    //   104: aload_0
    //   105: aconst_null
    //   106: putfield n : Landroid/webkit/ValueCallback;
    //   109: return
  }
  
  public void onAfterCreate(Bundle paramBundle) {
    String str1;
    Window window = this.a.getWindow();
    FrameLayout.LayoutParams layoutParams2 = null;
    window.setBackgroundDrawable(null);
    FrameLayout frameLayout = new FrameLayout((Context)this.a);
    this.a.setContentView((View)frameLayout, new ViewGroup.LayoutParams(-1, -1));
    this.i = new b((Context)this.a);
    DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
    boolean bool = true;
    int i = (int)TypedValue.applyDimension(1, 45.0F, displayMetrics);
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-1, i);
    layoutParams1.gravity = 48;
    this.i.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.i.setBackgroundColor(-1);
    String str2 = this.a.getIntent().getStringExtra("adinfo");
    layoutParams1 = layoutParams2;
    if (str2 != null)
      try {
        JSONObject jSONObject = new JSONObject(str2);
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Parse adinfo failed:");
        stringBuilder.append(exception.getMessage());
        GDTLogger.i(stringBuilder.toString());
        layoutParams1 = layoutParams2;
      }  
    if (layoutParams1 != null) {
      str1 = "txt";
      if (!layoutParams1.has("txt"))
        str1 = "title"; 
      str1 = layoutParams1.optString(str1);
    } else {
      str1 = "";
    } 
    this.k = str1;
    if (layoutParams1 != null) {
      if (!layoutParams1.has("type") || !"information".equals(layoutParams1.optString("type")))
        bool = false; 
      this.l = bool;
    } else {
      this.l = false;
    } 
    this.o = new com.qq.e.comm.plugin.y.c();
    this.o.a(this.a.getIntent().getStringExtra("posId"));
    if (layoutParams1 != null)
      this.o.b(layoutParams1.optString("cl")).c(layoutParams1.optString("traceid")); 
    this.i.a(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (c.a(this.a).d()) {
              c.a(this.a).e();
              return;
            } 
            c.b(this.a).finish();
            c c1 = this.a;
            c.a(c1, 2040005, c.c(c1));
          }
        });
    frameLayout.addView((View)this.i);
    this.b = (new e((Context)this.a, (JSONObject)layoutParams1)).a();
    this.b.a(this);
    this.b.a(this.c);
    layoutParams1 = new FrameLayout.LayoutParams(-1, -1);
    layoutParams1.topMargin = i;
    this.b.b().setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    frameLayout.addView(this.b.b());
  }
  
  public void onBackPressed() {
    b b1 = this.j;
    if (b1 != null)
      b1.a(this.g, b.e); 
    if (SDKStatus.getSDKVersionCode() >= 9) {
      this.a.finish();
      a(2040005, this.g);
    } 
  }
  
  public void onBeforeCreate(Bundle paramBundle) {
    this.a.requestWindowFeature(1);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onDestroy() {
    b b1 = this.j;
    if (b1 != null)
      b1.a(this.g, b.g); 
    a a1 = this.b;
    if (a1 != null)
      a1.a(); 
  }
  
  public void onPause() {
    b b1 = this.j;
    if (b1 != null)
      b1.a(this.g, b.f); 
    try {
      if (this.b.b() != null) {
        this.b.b().getClass().getMethod("onPause", new Class[0]).invoke(this.b.b(), (Object[])null);
        this.h = true;
        return;
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("InnerBrowser onPause err");
      stringBuilder.append(exception);
      GDTLogger.e(stringBuilder.toString());
    } 
  }
  
  public void onResume() {
    try {
      if (this.h) {
        if (this.b.b() != null)
          this.b.b().getClass().getMethod("onResume", new Class[0]).invoke(this.b.b(), (Object[])null); 
        this.h = false;
        return;
      } 
    } catch (Exception exception) {
      GDTLogger.e("InnerBrowser onResume err");
    } 
  }
  
  public void onStop() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\q\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */