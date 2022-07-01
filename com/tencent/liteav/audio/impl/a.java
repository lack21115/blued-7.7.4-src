package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public class a {
  private static final a a = new a();
  
  private ConcurrentHashMap<Integer, WeakReference<b>> b = new ConcurrentHashMap<Integer, WeakReference<b>>();
  
  private PhoneStateListener c = null;
  
  private Context d;
  
  public static a a() {
    return a;
  }
  
  private void a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/concurrent/ConcurrentHashMap;
    //   6: invokevirtual entrySet : ()Ljava/util/Set;
    //   9: invokeinterface iterator : ()Ljava/util/Iterator;
    //   14: astore_2
    //   15: aload_2
    //   16: invokeinterface hasNext : ()Z
    //   21: ifeq -> 71
    //   24: aload_2
    //   25: invokeinterface next : ()Ljava/lang/Object;
    //   30: checkcast java/util/Map$Entry
    //   33: invokeinterface getValue : ()Ljava/lang/Object;
    //   38: checkcast java/lang/ref/WeakReference
    //   41: invokevirtual get : ()Ljava/lang/Object;
    //   44: checkcast com/tencent/liteav/audio/impl/b
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull -> 62
    //   52: aload_3
    //   53: iload_1
    //   54: invokeinterface onCallStateChanged : (I)V
    //   59: goto -> 15
    //   62: aload_2
    //   63: invokeinterface remove : ()V
    //   68: goto -> 15
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: astore_2
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_2
    //   78: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	74	finally
    //   15	48	74	finally
    //   52	59	74	finally
    //   62	68	74	finally
  }
  
  public void a(Context paramContext) {
    if (this.c != null)
      return; 
    this.d = paramContext.getApplicationContext();
    (new Handler(Looper.getMainLooper())).post(new Runnable(this) {
          public void run() {
            if (a.a(this.a) != null)
              return; 
            a.a(this.a, new PhoneStateListener(this) {
                  public void onCallStateChanged(int param2Int, String param2String) {
                    super.onCallStateChanged(param2Int, param2String);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onCallStateChanged:");
                    stringBuilder.append(param2Int);
                    TXCLog.i("AudioCenter:TXCTelephonyMgr", stringBuilder.toString());
                    a.a(this.a.a, param2Int);
                  }
                });
            try {
              ((TelephonyManager)a.b(this.a).getSystemService("phone")).listen(a.a(this.a), 32);
              return;
            } catch (Exception exception) {
              TXCLog.e("AudioCenter:TXCTelephonyMgr", "TelephonyManager listen error ", exception);
              return;
            } 
          }
        });
  }
  
  public void a(b paramb) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield b : Ljava/util/concurrent/ConcurrentHashMap;
    //   13: aload_1
    //   14: invokevirtual hashCode : ()I
    //   17: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   20: new java/lang/ref/WeakReference
    //   23: dup
    //   24: aload_1
    //   25: invokespecial <init> : (Ljava/lang/Object;)V
    //   28: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   31: pop
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	32	35	finally
  }
  
  protected void finalize() throws Throwable {
    super.finalize();
    if (this.c != null && this.d != null)
      (new Handler(Looper.getMainLooper())).post(new Runnable(this) {
            public void run() {
              if (a.a(this.a) != null && a.b(this.a) != null)
                try {
                  ((TelephonyManager)a.b(this.a).getApplicationContext().getSystemService("phone")).listen(a.a(this.a), 0);
                } catch (Exception exception) {
                  TXCLog.e("AudioCenter:TXCTelephonyMgr", "TelephonyManager listen error ", exception);
                }  
              a.a(this.a, (PhoneStateListener)null);
            }
          }); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\tencent\liteav\audio\impl\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */