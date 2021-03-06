package com.blued.android.core.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ByteArrayPool {
  public static ByteArrayPool a = new ByteArrayPool(8192);
  
  protected static final Comparator<byte[]> b = new Comparator<byte[]>() {
      public int a(byte[] param1ArrayOfbyte1, byte[] param1ArrayOfbyte2) {
        return param1ArrayOfbyte1.length - param1ArrayOfbyte2.length;
      }
    };
  
  private final List<byte[]> c = (List)new ArrayList<byte>();
  
  private final List<byte[]> d = (List)new ArrayList<byte>(64);
  
  private int e = 0;
  
  private final int f;
  
  public ByteArrayPool(int paramInt) {
    this.f = paramInt;
  }
  
  private void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : I
    //   6: aload_0
    //   7: getfield f : I
    //   10: if_icmple -> 52
    //   13: aload_0
    //   14: getfield c : Ljava/util/List;
    //   17: iconst_0
    //   18: invokeinterface remove : (I)Ljava/lang/Object;
    //   23: checkcast [B
    //   26: astore_1
    //   27: aload_0
    //   28: getfield d : Ljava/util/List;
    //   31: aload_1
    //   32: invokeinterface remove : (Ljava/lang/Object;)Z
    //   37: pop
    //   38: aload_0
    //   39: aload_0
    //   40: getfield e : I
    //   43: aload_1
    //   44: arraylength
    //   45: isub
    //   46: putfield e : I
    //   49: goto -> 2
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   2	49	55	finally
  }
  
  public void a(byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 86
    //   6: aload_1
    //   7: arraylength
    //   8: aload_0
    //   9: getfield f : I
    //   12: if_icmple -> 18
    //   15: goto -> 86
    //   18: aload_0
    //   19: getfield c : Ljava/util/List;
    //   22: aload_1
    //   23: invokeinterface add : (Ljava/lang/Object;)Z
    //   28: pop
    //   29: aload_0
    //   30: getfield d : Ljava/util/List;
    //   33: aload_1
    //   34: getstatic com/blued/android/core/utils/ByteArrayPool.b : Ljava/util/Comparator;
    //   37: invokestatic binarySearch : (Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;)I
    //   40: istore_3
    //   41: iload_3
    //   42: istore_2
    //   43: iload_3
    //   44: ifge -> 52
    //   47: iload_3
    //   48: ineg
    //   49: iconst_1
    //   50: isub
    //   51: istore_2
    //   52: aload_0
    //   53: getfield d : Ljava/util/List;
    //   56: iload_2
    //   57: aload_1
    //   58: invokeinterface add : (ILjava/lang/Object;)V
    //   63: aload_0
    //   64: aload_0
    //   65: getfield e : I
    //   68: aload_1
    //   69: arraylength
    //   70: iadd
    //   71: putfield e : I
    //   74: aload_0
    //   75: invokespecial a : ()V
    //   78: aload_0
    //   79: monitorexit
    //   80: return
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    //   86: aload_0
    //   87: monitorexit
    //   88: return
    // Exception table:
    //   from	to	target	type
    //   6	15	81	finally
    //   18	41	81	finally
    //   52	78	81	finally
  }
  
  public byte[] a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: iload_2
    //   5: aload_0
    //   6: getfield d : Ljava/util/List;
    //   9: invokeinterface size : ()I
    //   14: if_icmpge -> 81
    //   17: aload_0
    //   18: getfield d : Ljava/util/List;
    //   21: iload_2
    //   22: invokeinterface get : (I)Ljava/lang/Object;
    //   27: checkcast [B
    //   30: astore_3
    //   31: aload_3
    //   32: arraylength
    //   33: iload_1
    //   34: if_icmplt -> 74
    //   37: aload_0
    //   38: aload_0
    //   39: getfield e : I
    //   42: aload_3
    //   43: arraylength
    //   44: isub
    //   45: putfield e : I
    //   48: aload_0
    //   49: getfield d : Ljava/util/List;
    //   52: iload_2
    //   53: invokeinterface remove : (I)Ljava/lang/Object;
    //   58: pop
    //   59: aload_0
    //   60: getfield c : Ljava/util/List;
    //   63: aload_3
    //   64: invokeinterface remove : (Ljava/lang/Object;)Z
    //   69: pop
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_3
    //   73: areturn
    //   74: iload_2
    //   75: iconst_1
    //   76: iadd
    //   77: istore_2
    //   78: goto -> 4
    //   81: iload_1
    //   82: newarray byte
    //   84: astore_3
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_3
    //   88: areturn
    //   89: astore_3
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_3
    //   93: athrow
    // Exception table:
    //   from	to	target	type
    //   4	70	89	finally
    //   81	85	89	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\ByteArrayPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */