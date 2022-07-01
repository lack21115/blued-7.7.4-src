package com.ss.android.downloadlib.a;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.a.a.b.b;
import com.ss.android.a.a.b.c;
import com.ss.android.downloadlib.d.a;
import com.ss.android.downloadlib.e.f;
import com.ss.android.downloadlib.e.h;
import com.ss.android.socialbase.downloader.g.c;
import java.util.concurrent.ConcurrentHashMap;

public class d implements h.a {
  private static String a = d.class.getSimpleName();
  
  private static volatile d b;
  
  private h c;
  
  private ConcurrentHashMap<Long, Runnable> d = null;
  
  public d() {
    this.d = new ConcurrentHashMap<Long, Runnable>();
    this.c = new h(Looper.getMainLooper(), this);
  }
  
  public static d a() {
    // Byte code:
    //   0: getstatic com/ss/android/downloadlib/a/d.b : Lcom/ss/android/downloadlib/a/d;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/downloadlib/a/d
    //   8: monitorenter
    //   9: getstatic com/ss/android/downloadlib/a/d.b : Lcom/ss/android/downloadlib/a/d;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/downloadlib/a/d
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/downloadlib/a/d.b : Lcom/ss/android/downloadlib/a/d;
    //   25: ldc com/ss/android/downloadlib/a/d
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/downloadlib/a/d
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/downloadlib/a/d.b : Lcom/ss/android/downloadlib/a/d;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static boolean a(c paramc) {
    return (paramc != null && paramc.y() != null && !TextUtils.isEmpty(paramc.y().a()));
  }
  
  public static boolean a(c paramc) {
    return (paramc == null || paramc.q() == 0 || paramc.q() == -4);
  }
  
  public void a(int paramInt, c paramc, b paramb) {
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("sendQuickAppMsg msgWhat:");
    stringBuilder.append(paramInt);
    f.a(str, stringBuilder.toString(), null);
    if (this.c == null)
      return; 
    Message message = Message.obtain();
    message.what = paramInt;
    message.obj = Long.valueOf(paramc.d());
    this.c.sendMessageDelayed(message, b());
  }
  
  public void a(Message paramMessage) {
    boolean bool;
    if (paramMessage == null)
      return; 
    if (j.k() != null) {
      bool = j.k().a();
    } else {
      bool = false;
    } 
    long l = 0L;
    if (paramMessage.obj instanceof Long)
      l = ((Long)paramMessage.obj).longValue(); 
    int i = paramMessage.what;
    if (i != 4) {
      if (i != 5) {
        if (i != 7)
          return; 
        Runnable runnable = this.d.get(Long.valueOf(l));
        this.d.remove(Long.valueOf(l));
        if (bool) {
          a.a().a(l, 1);
          a.a().a(l, true, 1);
          return;
        } 
        if (runnable != null)
          this.c.post(runnable); 
        a.a().a(l, false, 1);
        return;
      } 
      if (!bool)
        return; 
      a.a().a(l, true, 1);
      return;
    } 
    if (!bool)
      return; 
    a.a().a(l, true, 2);
  }
  
  public long b() {
    return j.i().optLong("quick_app_check_internal", 1200L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */