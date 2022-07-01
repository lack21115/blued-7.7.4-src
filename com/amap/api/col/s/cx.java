package com.amap.api.col.s;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public final class cx extends cs {
  private static cx c;
  
  private Handler d;
  
  private cx() {
    try {
      return;
    } finally {
      Exception exception = null;
      cg.c(exception, "NetManger", "NetManger1");
      exception.printStackTrace();
    } 
  }
  
  private static cz a(cy paramcy, boolean paramBoolean, int paramInt) throws bh {
    try {
      return (new cv(paramcy, paramBoolean)).a(paramcy.g(), paramcy.n(), paramcy.o(), paramcy.j(), paramcy.f(), paramcy.e(), paramInt);
    } catch (bh bh) {
      throw bh;
    } finally {
      paramcy = null;
      paramcy.printStackTrace();
    } 
  }
  
  public static cx b() {
    return c();
  }
  
  private static cz b(cy paramcy, boolean paramBoolean) throws bh {
    int i = cv.a(paramcy);
    try {
      cz cz = a(paramcy, paramBoolean, i);
    } catch (bh bh) {
      if (cv.a(i)) {
        bh = null;
      } else {
        throw bh;
      } 
    } 
    if ((bh == null || ((cz)bh).a == null || ((cz)bh).a.length <= 0) && cv.a(i))
      try {
        return a(paramcy, paramBoolean, 3);
      } catch (bh bh1) {
        throw bh1;
      }  
    return (cz)bh;
  }
  
  private static cx c() {
    // Byte code:
    //   0: ldc com/amap/api/col/s/cx
    //   2: monitorenter
    //   3: getstatic com/amap/api/col/s/cx.c : Lcom/amap/api/col/s/cx;
    //   6: ifnonnull -> 27
    //   9: new com/amap/api/col/s/cx
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/amap/api/col/s/cx.c : Lcom/amap/api/col/s/cx;
    //   19: goto -> 27
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual printStackTrace : ()V
    //   27: invokestatic c : ()Lcom/amap/api/col/s/bm$a;
    //   30: ifnonnull -> 39
    //   33: invokestatic a : ()Lcom/amap/api/col/s/bm$a;
    //   36: invokestatic a : (Lcom/amap/api/col/s/bm$a;)V
    //   39: getstatic com/amap/api/col/s/cx.c : Lcom/amap/api/col/s/cx;
    //   42: astore_0
    //   43: ldc com/amap/api/col/s/cx
    //   45: monitorexit
    //   46: aload_0
    //   47: areturn
    //   48: astore_0
    //   49: ldc com/amap/api/col/s/cx
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    //   54: astore_0
    //   55: goto -> 39
    // Exception table:
    //   from	to	target	type
    //   3	19	22	finally
    //   23	27	48	finally
    //   27	39	54	finally
    //   39	43	48	finally
  }
  
  public static byte[] d(cy paramcy) throws bh {
    try {
      return (cz != null) ? cz.a : null;
    } catch (bh bh) {
      throw bh;
    } finally {
      paramcy = null;
    } 
  }
  
  public static byte[] e(cy paramcy) throws bh {
    try {
      return (cz != null) ? cz.a : null;
    } catch (bh bh) {
      throw bh;
    } finally {
      paramcy = null;
    } 
  }
  
  public final byte[] b(cy paramcy) throws bh {
    try {
      return (cz != null) ? cz.a : null;
    } catch (bh bh) {
      throw bh;
    } finally {
      paramcy = null;
      paramcy.printStackTrace();
      cg.d().b((Throwable)paramcy, "NetManager", "makeSyncPostRequest");
    } 
  }
  
  static final class a extends Handler {
    public a() {}
    
    private a(Looper param1Looper) {
      super(param1Looper);
    }
    
    public final void handleMessage(Message param1Message) {
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */