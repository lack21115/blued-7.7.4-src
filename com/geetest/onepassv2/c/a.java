package com.geetest.onepassv2.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.geetest.onelogin.e.a.f;
import com.geetest.onelogin.e.a.g;
import com.geetest.onelogin.j.c;
import com.geetest.onelogin.j.h;
import com.geetest.onelogin.j.i;
import com.geetest.onelogin.j.j;
import com.geetest.onelogin.j.p;
import com.geetest.onepassv2.f.c;
import com.geetest.onepassv2.listener.OnePassListener;
import java.util.UUID;
import java.util.concurrent.Executors;

public class a {
  private static volatile a a;
  
  private Context b;
  
  private com.geetest.onepassv2.a.a c = null;
  
  private c d;
  
  private String e = "https://onepass.geetest.com";
  
  private String f = null;
  
  private int g = 8000;
  
  private OnePassListener h;
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/geetest/onepassv2/c/a.a : Lcom/geetest/onepassv2/c/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/geetest/onepassv2/c/a
    //   8: monitorenter
    //   9: getstatic com/geetest/onepassv2/c/a.a : Lcom/geetest/onepassv2/c/a;
    //   12: ifnonnull -> 25
    //   15: new com/geetest/onepassv2/c/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/geetest/onepassv2/c/a.a : Lcom/geetest/onepassv2/c/a;
    //   25: ldc com/geetest/onepassv2/c/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/geetest/onepassv2/c/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/geetest/onepassv2/c/a.a : Lcom/geetest/onepassv2/c/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(int paramInt) {
    this.g = paramInt;
  }
  
  public void a(Context paramContext) {
    try {
      SharedPreferences sharedPreferences = paramContext.getSharedPreferences("Geetest_OneLogin", 0);
      if ("unknown".equals(sharedPreferences.getString("uuid", "unknown")))
        sharedPreferences.edit().putString("uuid", UUID.randomUUID().toString()).apply(); 
    } catch (Exception exception) {
      h.c(exception.toString());
      exception.printStackTrace();
    } 
    c.a(1);
    p.a().a(false);
    this.b = paramContext.getApplicationContext();
    com.geetest.onelogin.c.a.a(this.b, false);
  }
  
  public void a(String paramString) {
    this.f = paramString;
  }
  
  public void a(String paramString1, String paramString2, OnePassListener paramOnePassListener) {
    h.b("OnePassV2 开始");
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("当前 OnePassV2 的版本号为: ");
    stringBuilder3.append(b());
    h.b(stringBuilder3.toString());
    this.c = new com.geetest.onepassv2.a.a();
    this.c.a(this.g);
    this.c.b(this.f);
    this.c.c(this.e);
    if (paramOnePassListener == null) {
      h.c("当前传入的 OnePassListener 为 null");
      return;
    } 
    this.h = paramOnePassListener;
    if (this.b == null) {
      h.c("当前传入的上下文为 null");
      return;
    } 
    if (this.h.onAlgorithmSelf() && this.h.onAlgorithm()) {
      h.c("当前使用的接口 onAlgorithmSelf 与 onAlgorithm 都为 true");
      return;
    } 
    String str = this.c.c();
    if (TextUtils.isEmpty(str)) {
      this.c.B(j.b(this.b));
    } else {
      this.c.B(str);
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("当前手机获取的运营商为: ");
    stringBuilder2.append(this.c.C());
    h.b(stringBuilder2.toString());
    this.c.x(g.a(16));
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("当前传入的手机号为: ");
    stringBuilder2.append(paramString1);
    h.b(stringBuilder2.toString());
    if (!TextUtils.isEmpty(paramString1) && !j.a(paramString1)) {
      com.geetest.onepassv2.listener.a.a(this.h, com.geetest.onelogin.b.a.s, "phone number cannot be empty", this.c);
      return;
    } 
    this.c.C(paramString1);
    if (this.h.onAlgorithm()) {
      if (TextUtils.isEmpty(paramString1)) {
        this.c.y("");
        h.b("当前选择对手机号加密，但手机号为空");
      } else {
        this.c.y(f.a(paramString1));
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("当前选择对手机号加密，加密后的手机号为: ");
        stringBuilder1.append(this.c.z());
        h.b(stringBuilder1.toString());
      } 
    } else {
      this.c.y((String)stringBuilder1);
    } 
    if (TextUtils.isEmpty(paramString2)) {
      h.c("当前传入的 APP_ID 为 null ");
      com.geetest.onepassv2.listener.a.a(this.h, com.geetest.onelogin.b.a.t, "APP_ID cannot be empty", this.c);
      return;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("当前传入的 APP_ID 为: ");
    stringBuilder1.append(paramString2);
    h.b(stringBuilder1.toString());
    this.c.z(paramString2);
    if (!i.a(this.b)) {
      h.c("当前网络不可用");
      com.geetest.onepassv2.listener.a.a(this.h, com.geetest.onelogin.b.a.u, "network is unavailable", this.c);
      return;
    } 
    this.d = new c(this.c, this.b, this.h);
    this.d.executeOnExecutor(Executors.newCachedThreadPool(), (Object[])new String[0]);
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      h.a(1, "Geetest_OneLogin");
      return;
    } 
    h.a(6, "Geetest_OneLogin");
  }
  
  public void a(boolean paramBoolean, String paramString) {
    byte b;
    if (paramBoolean) {
      b = 1;
    } else {
      b = 6;
    } 
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = "Geetest_OneLogin"; 
    h.a(b, str);
  }
  
  public String b() {
    return "2.1.4.1";
  }
  
  public String b(Context paramContext) {
    return j.b(paramContext);
  }
  
  public void b(String paramString) {
    this.e = paramString;
  }
  
  public String c() {
    com.geetest.onepassv2.a.a a1 = this.c;
    return (a1 == null) ? null : a1.z();
  }
  
  public String d() {
    com.geetest.onepassv2.a.a a1 = this.c;
    return (a1 == null) ? null : a1.B();
  }
  
  public void e() {
    c c1 = this.d;
    if (c1 != null)
      c1.a(); 
    if (a != null)
      a = null; 
    if (this.h != null)
      this.h = null; 
    c1 = this.d;
    if (c1 != null && !c1.isCancelled() && this.d.getStatus() == AsyncTask.Status.RUNNING)
      this.d.cancel(true); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onepassv2\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */