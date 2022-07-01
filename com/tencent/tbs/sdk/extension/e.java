package com.tencent.tbs.sdk.extension;

import android.os.Handler;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;

public class e implements Runnable {
  public static String a = "TBSFileLock";
  
  private static Object f = new Object();
  
  private static Object g = new Object();
  
  private static HashMap<e, Object> h = null;
  
  private static Handler i = null;
  
  File b = null;
  
  RandomAccessFile c = null;
  
  FileLock d = null;
  
  long e = 0L;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public e(File paramFile, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(".");
    stringBuilder.append(paramString);
    stringBuilder.append(".lock");
    this.b = new File(paramFile, stringBuilder.toString());
  }
  
  Handler a() {
    // Byte code:
    //   0: getstatic com/tencent/tbs/sdk/extension/e.i : Landroid/os/Handler;
    //   3: ifnonnull -> 55
    //   6: ldc com/tencent/tbs/sdk/extension/e
    //   8: monitorenter
    //   9: getstatic com/tencent/tbs/sdk/extension/e.i : Landroid/os/Handler;
    //   12: ifnonnull -> 43
    //   15: new android/os/HandlerThread
    //   18: dup
    //   19: ldc 'QBFileLock.Thread'
    //   21: invokespecial <init> : (Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual start : ()V
    //   29: new android/os/Handler
    //   32: dup
    //   33: aload_1
    //   34: invokevirtual getLooper : ()Landroid/os/Looper;
    //   37: invokespecial <init> : (Landroid/os/Looper;)V
    //   40: putstatic com/tencent/tbs/sdk/extension/e.i : Landroid/os/Handler;
    //   43: ldc com/tencent/tbs/sdk/extension/e
    //   45: monitorexit
    //   46: goto -> 55
    //   49: astore_1
    //   50: ldc com/tencent/tbs/sdk/extension/e
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    //   55: getstatic com/tencent/tbs/sdk/extension/e.i : Landroid/os/Handler;
    //   58: areturn
    // Exception table:
    //   from	to	target	type
    //   9	43	49	finally
    //   43	46	49	finally
    //   50	53	49	finally
  }
  
  public void a(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/tencent/tbs/sdk/extension/e.a : Ljava/lang/String;
    //   5: astore_2
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc '>>> release lock: '
    //   17: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_2
    //   22: aload_0
    //   23: getfield b : Ljava/io/File;
    //   26: invokevirtual getName : ()Ljava/lang/String;
    //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_2
    //   34: invokevirtual toString : ()Ljava/lang/String;
    //   37: pop
    //   38: aload_0
    //   39: getfield d : Ljava/nio/channels/FileLock;
    //   42: astore_2
    //   43: aload_2
    //   44: ifnull -> 67
    //   47: aload_0
    //   48: getfield d : Ljava/nio/channels/FileLock;
    //   51: invokevirtual release : ()V
    //   54: goto -> 62
    //   57: astore_2
    //   58: aload_2
    //   59: invokevirtual printStackTrace : ()V
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield d : Ljava/nio/channels/FileLock;
    //   67: aload_0
    //   68: getfield c : Ljava/io/RandomAccessFile;
    //   71: astore_2
    //   72: aload_2
    //   73: ifnull -> 96
    //   76: aload_0
    //   77: getfield c : Ljava/io/RandomAccessFile;
    //   80: invokevirtual close : ()V
    //   83: goto -> 91
    //   86: astore_2
    //   87: aload_2
    //   88: invokevirtual printStackTrace : ()V
    //   91: aload_0
    //   92: aconst_null
    //   93: putfield c : Ljava/io/RandomAccessFile;
    //   96: getstatic com/tencent/tbs/sdk/extension/e.i : Landroid/os/Handler;
    //   99: ifnull -> 118
    //   102: aload_0
    //   103: getfield e : J
    //   106: lconst_0
    //   107: lcmp
    //   108: ifle -> 118
    //   111: getstatic com/tencent/tbs/sdk/extension/e.i : Landroid/os/Handler;
    //   114: aload_0
    //   115: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   118: iload_1
    //   119: ifeq -> 126
    //   122: aload_0
    //   123: invokevirtual d : ()V
    //   126: aload_0
    //   127: monitorexit
    //   128: return
    //   129: astore_2
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_2
    //   133: athrow
    // Exception table:
    //   from	to	target	type
    //   2	43	129	finally
    //   47	54	57	java/lang/Exception
    //   47	54	129	finally
    //   58	62	129	finally
    //   62	67	129	finally
    //   67	72	129	finally
    //   76	83	86	java/lang/Exception
    //   76	83	129	finally
    //   87	91	129	finally
    //   91	96	129	finally
    //   96	118	129	finally
    //   122	126	129	finally
  }
  
  public void b() {
    /* monitor enter ThisExpression{ObjectType{com/tencent/tbs/sdk/extension/e}} */
    try {
      this.c = new RandomAccessFile(this.b, "rw");
    } catch (Exception exception) {
      exception.printStackTrace();
    } finally {
      Exception exception;
    } 
    if (this.c != null) {
      FileChannel fileChannel = this.c.getChannel();
      if (fileChannel != null) {
        if (this.e > 0L)
          a().postDelayed(this, this.e); 
        String str2 = null;
        long l = System.currentTimeMillis();
        while (true) {
          try {
            FileLock fileLock2 = fileChannel.lock();
            FileLock fileLock1 = fileLock2;
            if (fileLock2 != null) {
              fileLock1 = fileLock2;
              break;
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
            str1 = a;
            str1 = str2;
          } 
          try {
            Thread.sleep(50L);
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
          } 
          str2 = str1;
          if (Math.abs(System.currentTimeMillis() - l) >= 1000L) {
            str2 = a;
            break;
          } 
        } 
        this.d = (FileLock)str1;
        String str1 = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(">>> lock [");
        stringBuilder.append(this.b.getName());
        stringBuilder.append("] cost: ");
        stringBuilder.append(System.currentTimeMillis() - l);
        stringBuilder.toString();
      } 
    } 
    if (this.d != null)
      c(); 
    /* monitor exit ThisExpression{ObjectType{com/tencent/tbs/sdk/extension/e}} */
  }
  
  void c() {
    synchronized (g) {
      if (h == null)
        h = new HashMap<e, Object>(); 
      h.put(this, f);
      return;
    } 
  }
  
  void d() {
    synchronized (g) {
      if (h == null)
        return; 
      h.remove(this);
      return;
    } 
  }
  
  public void e() {
    a(true);
  }
  
  public void run() {
    String str = a;
    e();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */