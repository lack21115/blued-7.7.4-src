package com.ss.android.downloadlib.a;

import android.os.Looper;
import android.os.Message;
import com.ss.android.downloadad.a.b.a;
import com.ss.android.downloadlib.a.a.a;
import com.ss.android.downloadlib.a.b.a;
import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.d.a;
import com.ss.android.downloadlib.e.g;
import com.ss.android.downloadlib.e.h;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.k.a;
import com.ss.android.socialbase.downloader.m.i;
import com.ss.android.socialbase.downloader.m.k;
import org.json.JSONObject;

public class b implements h.a {
  private static final String a = b.class.getSimpleName();
  
  private static b b;
  
  private h c = new h(Looper.getMainLooper(), this);
  
  private long d;
  
  public static b a() {
    // Byte code:
    //   0: getstatic com/ss/android/downloadlib/a/b.b : Lcom/ss/android/downloadlib/a/b;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/downloadlib/a/b
    //   8: monitorenter
    //   9: getstatic com/ss/android/downloadlib/a/b.b : Lcom/ss/android/downloadlib/a/b;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/downloadlib/a/b
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/downloadlib/a/b.b : Lcom/ss/android/downloadlib/a/b;
    //   25: ldc com/ss/android/downloadlib/a/b
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/downloadlib/a/b
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/downloadlib/a/b.b : Lcom/ss/android/downloadlib/a/b;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(a parama, int paramInt) {
    if (j.k() == null)
      return; 
    if (j.k().a() && !j.r())
      return; 
    if (parama == null)
      return; 
    if (2 == paramInt) {
      a a1 = c.a().d(parama.b);
      JSONObject jSONObject = new JSONObject();
      paramInt = -1;
      try {
        jSONObject.put("type", "miui_silent_install");
        boolean bool = g.c(j.a(), parama.d);
        if (bool) {
          jSONObject.put("message", "miui_silent_install_succeed");
          paramInt = 4;
        } else {
          jSONObject.put("message", "miui_silent_install_failed: has started service");
          paramInt = 5;
        } 
      } catch (Exception exception) {}
      a a2 = new a(paramInt, jSONObject.toString());
      j.g().a(null, a2, paramInt);
      a.a().a("embeded_ad", "anti_hijack_result", jSONObject, a1);
    } 
    if (g.c(j.a(), parama.d)) {
      a.a().a("delayinstall_installed", parama.b);
      return;
    } 
    if (!g.a(parama.g)) {
      a.a().a("delayinstall_file_lost", parama.b);
      return;
    } 
    if (a.a().a(parama.d)) {
      a.a().a("delayinstall_conflict_with_back_dialog", parama.b);
      return;
    } 
    a.a().a("delayinstall_install_start", parama.b);
    d.a(j.a(), (int)parama.a);
  }
  
  public void a(Message paramMessage) {
    if (paramMessage.what != 200)
      return; 
    a((a)paramMessage.obj, paramMessage.arg1);
  }
  
  public void a(c paramc, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4) {
    a a1 = new a(paramc.g(), paramLong1, paramLong2, paramString1, paramString2, paramString3, paramString4);
    a a2 = a.a(paramc.g());
    if (a2.a("back_miui_silent_install", 1) == 0 && (i.j() || i.k()) && k.a(j.a(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
      if (paramc.bg().getBoolean("extra_silent_install_succeed", false)) {
        Message message = this.c.obtainMessage(200, a1);
        message.arg1 = 2;
        int i = a2.a("check_silent_install_interval", 60000);
        this.c.sendMessageDelayed(message, i);
        return;
      } 
      a a3 = c.a().d(a1.b);
      JSONObject jSONObject = new JSONObject();
      byte b1 = -1;
      try {
        jSONObject.put("type", "miui_silent_install");
        jSONObject.put("message", "miui_silent_install_failed: has not started service");
        b1 = 5;
      } catch (Exception exception) {}
      a a4 = new a(b1, jSONObject.toString());
      j.g().a(null, a4, b1);
      a.a().a("embeded_ad", "anti_hijack_result", jSONObject, a3);
    } 
    if (!j.q())
      return; 
    paramLong2 = System.currentTimeMillis() - this.d;
    paramLong1 = j.t();
    if (paramLong2 < j.u()) {
      paramLong2 = j.u() - paramLong2;
      paramLong1 += paramLong2;
      this.d = System.currentTimeMillis() + paramLong2;
    } else {
      this.d = System.currentTimeMillis();
    } 
    h h1 = this.c;
    h1.sendMessageDelayed(h1.obtainMessage(200, a1), paramLong1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */