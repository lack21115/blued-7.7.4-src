package com.google.android.gms.common.internal;

public abstract class zzi {
  private Object zzgat;
  
  private boolean zzgfl;
  
  public zzi(zzd paramzzd, Object paramObject) {
    this.zzgat = paramObject;
    this.zzgfl = false;
  }
  
  public final void removeListener() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aconst_null
    //   4: putfield zzgat : Ljava/lang/Object;
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	10	finally
    //   11	13	10	finally
  }
  
  public final void unregister() {
    removeListener();
    synchronized (zzd.zzf(this.zzgfk)) {
      zzd.zzf(this.zzgfk).remove(this);
      return;
    } 
  }
  
  public final void zzamc() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zzgat : Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_0
    //   8: getfield zzgfl : Z
    //   11: ifeq -> 67
    //   14: aload_0
    //   15: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   18: astore_2
    //   19: new java/lang/StringBuilder
    //   22: dup
    //   23: aload_2
    //   24: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   27: invokevirtual length : ()I
    //   30: bipush #47
    //   32: iadd
    //   33: invokespecial <init> : (I)V
    //   36: astore_3
    //   37: aload_3
    //   38: ldc 'Callback proxy '
    //   40: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_3
    //   45: aload_2
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_3
    //   51: ldc ' being reused. This is not safe.'
    //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: ldc 'GmsClient'
    //   59: aload_3
    //   60: invokevirtual toString : ()Ljava/lang/String;
    //   63: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   66: pop
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: ifnull -> 84
    //   73: aload_0
    //   74: aload_1
    //   75: invokevirtual zzw : (Ljava/lang/Object;)V
    //   78: goto -> 84
    //   81: astore_1
    //   82: aload_1
    //   83: athrow
    //   84: aload_0
    //   85: monitorenter
    //   86: aload_0
    //   87: iconst_1
    //   88: putfield zzgfl : Z
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_0
    //   94: invokevirtual unregister : ()V
    //   97: return
    //   98: astore_1
    //   99: aload_0
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Exception table:
    //   from	to	target	type
    //   2	67	103	finally
    //   67	69	103	finally
    //   73	78	81	java/lang/RuntimeException
    //   86	93	98	finally
    //   99	101	98	finally
    //   104	106	103	finally
  }
  
  protected abstract void zzw(Object paramObject);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */