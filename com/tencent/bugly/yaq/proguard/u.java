package com.tencent.bugly.yaq.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.yaq.b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public final class u {
  private static u b = null;
  
  public boolean a;
  
  private final p c;
  
  private final Context d;
  
  private Map<Integer, Long> e;
  
  private long f;
  
  private long g;
  
  private LinkedBlockingQueue<Runnable> h;
  
  private LinkedBlockingQueue<Runnable> i;
  
  private final Object j;
  
  private String k;
  
  private byte[] l;
  
  private long m;
  
  private byte[] n;
  
  private long o;
  
  private String p;
  
  private long q;
  
  private final Object r;
  
  private boolean s;
  
  private final Object t;
  
  private int u;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private u(Context paramContext) {
    new HashMap<Object, Object>();
    throw new VerifyError("bad dex opcode");
  }
  
  public static u a() {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/proguard/u
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/proguard/u.b : Lcom/tencent/bugly/yaq/proguard/u;
    //   6: astore_0
    //   7: ldc com/tencent/bugly/yaq/proguard/u
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/tencent/bugly/yaq/proguard/u
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static u a(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/bugly/yaq/proguard/u
    //   2: monitorenter
    //   3: getstatic com/tencent/bugly/yaq/proguard/u.b : Lcom/tencent/bugly/yaq/proguard/u;
    //   6: ifnonnull -> 20
    //   9: new com/tencent/bugly/yaq/proguard/u
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Landroid/content/Context;)V
    //   17: putstatic com/tencent/bugly/yaq/proguard/u.b : Lcom/tencent/bugly/yaq/proguard/u;
    //   20: getstatic com/tencent/bugly/yaq/proguard/u.b : Lcom/tencent/bugly/yaq/proguard/u;
    //   23: astore_0
    //   24: ldc com/tencent/bugly/yaq/proguard/u
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: astore_0
    //   30: ldc com/tencent/bugly/yaq/proguard/u
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	29	finally
    //   20	24	29	finally
  }
  
  private void a(Runnable paramRunnable, long paramLong) {
    if (paramRunnable == null) {
      x.d("[UploadManager] Upload task should not be null", new Object[0]);
      throw new VerifyError("bad dex opcode");
    } 
    x.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    if (z.a(paramRunnable, "BUGLY_SYNC_UPLOAD") == null) {
      x.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
      a(paramRunnable, true);
      throw new VerifyError("bad dex opcode");
    } 
    try {
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      Object[] arrayOfObject = new Object[1];
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  private void a(Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2, long paramLong) {
    if (paramRunnable == null)
      x.d("[UploadManager] Upload task should not be null", new Object[0]); 
    x.c("[UploadManager] Add upload task (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    throw new VerifyError("bad dex opcode");
  }
  
  private boolean a(Runnable paramRunnable, boolean paramBoolean) {
    if (paramRunnable == null) {
      x.a("[UploadManager] Upload task should not be null", new Object[0]);
      return false;
    } 
    try {
      x.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      Object[] arrayOfObject = new Object[1];
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  private void c(int paramInt) {
    if (paramInt < 0) {
      x.a("[UploadManager] Number of task to execute should >= 0", new Object[0]);
      throw new VerifyError("bad dex opcode");
    } 
    w.a();
    new LinkedBlockingQueue();
    new LinkedBlockingQueue();
    throw new VerifyError("bad dex opcode");
  }
  
  private static boolean c() {
    x.c("[UploadManager] Drop security info of database (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try {
      if (p.a() == null) {
        x.d("[UploadManager] Failed to get Database", new Object[0]);
        return false;
      } 
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      x.a(throwable);
      return false;
    } 
  }
  
  private boolean d() {
    x.c("[UploadManager] Record security info to database (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try {
      if (p.a() == null) {
        x.d("[UploadManager] Failed to get database", new Object[0]);
        return false;
      } 
      new StringBuilder();
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      x.a(throwable);
      c();
      return false;
    } 
  }
  
  private boolean e() {
    x.c("[UploadManager] Load security info from database (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try {
      if (p.a() == null) {
        x.d("[UploadManager] Failed to get database", new Object[0]);
        return false;
      } 
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      x.a(throwable);
      return false;
    } 
  }
  
  public final long a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iflt -> 25
    //   6: new java/lang/VerifyError
    //   9: dup
    //   10: ldc 'bad dex opcode'
    //   12: invokespecial <init> : (Ljava/lang/String;)V
    //   15: athrow
    //   16: aload_0
    //   17: monitorexit
    //   18: lconst_0
    //   19: lreturn
    //   20: astore_2
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_2
    //   24: athrow
    //   25: ldc '[UploadManager] Unknown upload ID: %d'
    //   27: iconst_1
    //   28: anewarray java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: iload_1
    //   34: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   37: aastore
    //   38: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   41: pop
    //   42: goto -> 16
    // Exception table:
    //   from	to	target	type
    //   6	16	20	finally
    //   25	42	20	finally
  }
  
  public final long a(boolean paramBoolean) {
    z.b();
    if (paramBoolean);
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(int paramInt1, int paramInt2, byte[] paramArrayOfbyte, String paramString1, String paramString2, t paramt, int paramInt3, int paramInt4, boolean paramBoolean, Map<String, String> paramMap) {
    try {
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  public final void a(int paramInt, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iflt -> 28
    //   6: new java/lang/VerifyError
    //   9: dup
    //   10: ldc 'bad dex opcode'
    //   12: invokespecial <init> : (Ljava/lang/String;)V
    //   15: athrow
    //   16: aload_0
    //   17: monitorexit
    //   18: new java/lang/VerifyError
    //   21: dup
    //   22: ldc 'bad dex opcode'
    //   24: invokespecial <init> : (Ljava/lang/String;)V
    //   27: athrow
    //   28: ldc '[UploadManager] Unknown uploading ID: %d'
    //   30: iconst_1
    //   31: anewarray java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: iload_1
    //   37: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   40: aastore
    //   41: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   44: pop
    //   45: goto -> 16
    //   48: astore #4
    //   50: aload_0
    //   51: monitorexit
    //   52: aload #4
    //   54: athrow
    // Exception table:
    //   from	to	target	type
    //   6	16	48	finally
    //   28	45	48	finally
  }
  
  public final void a(int paramInt, am paramam, String paramString1, String paramString2, t paramt, long paramLong, boolean paramBoolean) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(int paramInt, am paramam, String paramString1, String paramString2, t paramt, boolean paramBoolean) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(int paramInt, an paraman) {
    throw new VerifyError("bad dex opcode");
  }
  
  protected final void a(long paramLong, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_3
    //   3: ifeq -> 24
    //   6: new com/tencent/bugly/yaq/proguard/r
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: pop
    //   14: new java/lang/VerifyError
    //   17: dup
    //   18: ldc 'bad dex opcode'
    //   20: invokespecial <init> : (Ljava/lang/String;)V
    //   23: athrow
    //   24: goto -> 6
    //   27: astore #4
    //   29: aload_0
    //   30: monitorexit
    //   31: aload #4
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   6	24	27	finally
  }
  
  public final boolean a(Map<String, String> paramMap) {
    if (paramMap == null)
      return false; 
    x.c("[UploadManager] Integrate security to HTTP headers (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    throw new VerifyError("bad dex opcode");
  }
  
  public final byte[] a(byte[] paramArrayOfbyte) {
    throw new VerifyError("bad dex opcode");
  }
  
  protected final void b(boolean paramBoolean) {
    throw new VerifyError("bad dex opcode");
  }
  
  protected final boolean b() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final boolean b(int paramInt) {
    if (b.c) {
      x.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
      return true;
    } 
    System.currentTimeMillis();
    throw new VerifyError("bad dex opcode");
  }
  
  public final byte[] b(byte[] paramArrayOfbyte) {
    throw new VerifyError("bad dex opcode");
  }
  
  final class a implements Runnable {
    private final Context a;
    
    private final Runnable b;
    
    private final long c;
    
    public a(u this$0, Context param1Context) {}
    
    public a(u this$0, Context param1Context, Runnable param1Runnable, long param1Long) {}
    
    public final void run() {
      throw new VerifyError("bad dex opcode");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguar\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */