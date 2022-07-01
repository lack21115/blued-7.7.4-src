package com.amap.api.mapcore2d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.net.Proxy;

public class ev extends er {
  private static ev c;
  
  private fw d;
  
  private Handler e;
  
  private ev(boolean paramBoolean, int paramInt) {
    if (paramBoolean)
      try {
        return;
      } finally {
        Exception exception = null;
        do.c(exception, "NetManger", "NetManger1");
        exception.printStackTrace();
      }  
    if (Looper.myLooper() == null) {
      this.e = new a(Looper.getMainLooper());
      return;
    } 
    this.e = new a();
  }
  
  public static ev a(boolean paramBoolean) {
    return a(paramBoolean, 5);
  }
  
  private static ev a(boolean paramBoolean, int paramInt) {
    // Byte code:
    //   0: ldc com/amap/api/mapcore2d/ev
    //   2: monitorenter
    //   3: getstatic com/amap/api/mapcore2d/ev.c : Lcom/amap/api/mapcore2d/ev;
    //   6: ifnonnull -> 24
    //   9: new com/amap/api/mapcore2d/ev
    //   12: dup
    //   13: iload_0
    //   14: iload_1
    //   15: invokespecial <init> : (ZI)V
    //   18: putstatic com/amap/api/mapcore2d/ev.c : Lcom/amap/api/mapcore2d/ev;
    //   21: goto -> 55
    //   24: iload_0
    //   25: ifeq -> 55
    //   28: getstatic com/amap/api/mapcore2d/ev.c : Lcom/amap/api/mapcore2d/ev;
    //   31: getfield d : Lcom/amap/api/mapcore2d/fw;
    //   34: ifnonnull -> 55
    //   37: getstatic com/amap/api/mapcore2d/ev.c : Lcom/amap/api/mapcore2d/ev;
    //   40: iload_1
    //   41: invokestatic a : (I)Lcom/amap/api/mapcore2d/fw;
    //   44: putfield d : Lcom/amap/api/mapcore2d/fw;
    //   47: goto -> 55
    //   50: astore_2
    //   51: aload_2
    //   52: invokevirtual printStackTrace : ()V
    //   55: getstatic com/amap/api/mapcore2d/ev.c : Lcom/amap/api/mapcore2d/ev;
    //   58: astore_2
    //   59: ldc com/amap/api/mapcore2d/ev
    //   61: monitorexit
    //   62: aload_2
    //   63: areturn
    //   64: astore_2
    //   65: ldc com/amap/api/mapcore2d/ev
    //   67: monitorexit
    //   68: aload_2
    //   69: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	50	finally
    //   28	47	50	finally
    //   51	55	64	finally
    //   55	59	64	finally
  }
  
  private void a(cp paramcp, ex paramex) {
    ez ez = new ez();
    ez.a = paramcp;
    ez.b = paramex;
    Message message = Message.obtain();
    message.obj = ez;
    message.what = 1;
    this.e.sendMessage(message);
  }
  
  private void a(ey paramey, ex paramex) {
    paramex.a(paramey.b, paramey.a);
    ez ez = new ez();
    ez.b = paramex;
    Message message = Message.obtain();
    message.obj = ez;
    message.what = 0;
    this.e.sendMessage(message);
  }
  
  public ey b(ew paramew, boolean paramBoolean) throws cp {
    try {
      return (new eu(paramew.c, paramew.d, proxy, paramBoolean)).a(paramew.h(), paramew.n(), paramew.m(), paramew.f(), paramew.g(), paramew.o());
    } catch (cp cp) {
      throw cp;
    } finally {
      paramew = null;
      paramew.printStackTrace();
    } 
  }
  
  public byte[] b(ew paramew) throws cp {
    try {
      return (ey != null) ? ey.a : null;
    } catch (cp cp) {
      throw cp;
    } finally {
      paramew = null;
      paramew.printStackTrace();
      do.e().b((Throwable)paramew, "NetManager", "makeSyncPostRequest");
    } 
  }
  
  public byte[] d(ew paramew) throws cp {
    try {
      return (ey != null) ? ey.a : null;
    } catch (cp cp) {
      throw cp;
    } finally {
      paramew = null;
    } 
  }
  
  public byte[] e(ew paramew) throws cp {
    try {
      return (ey != null) ? ey.a : null;
    } catch (cp cp) {
      throw cp;
    } finally {
      paramew = null;
    } 
  }
  
  static class a extends Handler {
    public a() {}
    
    private a(Looper param1Looper) {
      super(param1Looper);
    }
    
    public void handleMessage(Message param1Message) {
      try {
        int i = param1Message.what;
        return;
      } finally {
        param1Message = null;
        param1Message.printStackTrace();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */