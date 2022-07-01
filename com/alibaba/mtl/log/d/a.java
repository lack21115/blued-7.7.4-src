package com.alibaba.mtl.log.d;

import com.alibaba.mtl.log.e.b;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;

public class a {
  static a a = new a();
  
  private int A;
  
  private boolean E = false;
  
  protected long z = com.alibaba.mtl.log.a.a.a();
  
  public static a a() {
    return a;
  }
  
  private long c() {
    int i;
    long l;
    i.a("UploadEngine", new Object[] { "UTDC.bBackground:", Boolean.valueOf(com.alibaba.mtl.log.a.o), "AppInfoUtil.isForeground(UTDC.getContext()) ", Boolean.valueOf(b.b(com.alibaba.mtl.log.a.getContext())) });
    com.alibaba.mtl.log.a.o = b.b(com.alibaba.mtl.log.a.getContext()) ^ true;
    boolean bool = com.alibaba.mtl.log.a.o;
    com.alibaba.mtl.log.a.a.a();
    if (bool) {
      l = com.alibaba.mtl.log.a.a.b();
      i = this.A;
    } else {
      l = com.alibaba.mtl.log.a.a.a();
      i = this.A;
    } 
    this.z = l + i;
    if (com.alibaba.mtl.log.a.a.g())
      this.z = 3000L; 
    return this.z;
  }
  
  public void J() {
    if (this.A == 0) {
      this.A = 7000;
      return;
    } 
    this.A = 0;
  }
  
  public void start() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield E : Z
    //   7: invokestatic a : ()Lcom/alibaba/mtl/log/e/r;
    //   10: iconst_2
    //   11: invokevirtual b : (I)Z
    //   14: ifeq -> 24
    //   17: invokestatic a : ()Lcom/alibaba/mtl/log/e/r;
    //   20: iconst_2
    //   21: invokevirtual f : (I)V
    //   24: aload_0
    //   25: invokespecial c : ()J
    //   28: pop2
    //   29: new java/util/Random
    //   32: dup
    //   33: invokespecial <init> : ()V
    //   36: astore_1
    //   37: invokestatic isRunning : ()Z
    //   40: ifne -> 68
    //   43: invokestatic a : ()Lcom/alibaba/mtl/log/e/r;
    //   46: iconst_2
    //   47: new com/alibaba/mtl/log/d/a$1
    //   50: dup
    //   51: aload_0
    //   52: invokespecial <init> : (Lcom/alibaba/mtl/log/d/a;)V
    //   55: aload_1
    //   56: aload_0
    //   57: getfield z : J
    //   60: l2i
    //   61: invokevirtual nextInt : (I)I
    //   64: i2l
    //   65: invokevirtual a : (ILjava/lang/Runnable;J)V
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Exception table:
    //   from	to	target	type
    //   2	24	71	finally
    //   24	68	71	finally
  }
  
  public void stop() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield E : Z
    //   7: invokestatic a : ()Lcom/alibaba/mtl/log/e/r;
    //   10: iconst_2
    //   11: invokevirtual f : (I)V
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	17	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */