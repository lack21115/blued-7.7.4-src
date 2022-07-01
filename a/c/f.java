package a.c;

import java.util.LinkedHashMap;

public class f<K, V> {
  public final LinkedHashMap<K, V> a;
  
  public int b;
  
  public int c;
  
  public int d;
  
  public int e;
  
  public int f;
  
  public int g;
  
  public f(int paramInt) {
    if (paramInt > 0)
      throw new VerifyError("bad dex opcode"); 
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  public final V a(K paramK) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 21
    //   4: aload_0
    //   5: monitorenter
    //   6: new java/lang/VerifyError
    //   9: dup
    //   10: ldc 'bad dex opcode'
    //   12: invokespecial <init> : (Ljava/lang/String;)V
    //   15: athrow
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    //   21: new java/lang/NullPointerException
    //   24: dup
    //   25: ldc 'key == null'
    //   27: invokespecial <init> : (Ljava/lang/String;)V
    //   30: athrow
    // Exception table:
    //   from	to	target	type
    //   6	16	16	finally
    //   17	19	16	finally
  }
  
  public final V a(K paramK, V paramV) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 25
    //   4: aload_2
    //   5: ifnull -> 25
    //   8: aload_0
    //   9: monitorenter
    //   10: new java/lang/VerifyError
    //   13: dup
    //   14: ldc 'bad dex opcode'
    //   16: invokespecial <init> : (Ljava/lang/String;)V
    //   19: athrow
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    //   25: new java/lang/NullPointerException
    //   28: dup
    //   29: ldc 'key == null || value == null'
    //   31: invokespecial <init> : (Ljava/lang/String;)V
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   10	20	20	finally
    //   21	23	20	finally
  }
  
  public void a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/VerifyError
    //   5: dup
    //   6: ldc 'bad dex opcode'
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: athrow
    //   12: astore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: goto -> 20
    //   18: aload_2
    //   19: athrow
    //   20: goto -> 18
    // Exception table:
    //   from	to	target	type
    //   2	12	12	finally
    //   13	15	12	finally
  }
  
  public final String toString() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/VerifyError
    //   5: dup
    //   6: ldc 'bad dex opcode'
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: athrow
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	12	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\a\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */