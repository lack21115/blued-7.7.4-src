package c.t.maploc.lite.tsa;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ad extends Handler {
  private byte[] a = new byte[0];
  
  private ad(ab paramab, Looper paramLooper) {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial handleMessage : (Landroid/os/Message;)V
    //   5: aload_0
    //   6: getfield b : Lc/t/maploc/lite/tsa/ab;
    //   9: getfield h : Z
    //   12: ifne -> 16
    //   15: return
    //   16: aload_1
    //   17: getfield what : I
    //   20: istore_2
    //   21: iload_2
    //   22: iconst_1
    //   23: if_icmpeq -> 109
    //   26: iload_2
    //   27: iconst_2
    //   28: if_icmpeq -> 32
    //   31: return
    //   32: aload_0
    //   33: getfield b : Lc/t/maploc/lite/tsa/ab;
    //   36: invokestatic h : (Lc/t/maploc/lite/tsa/ab;)Landroid/telephony/CellLocation;
    //   39: astore_1
    //   40: aload_0
    //   41: getfield b : Lc/t/maploc/lite/tsa/ab;
    //   44: invokestatic c : (Lc/t/maploc/lite/tsa/ab;)Landroid/telephony/SignalStrength;
    //   47: astore_3
    //   48: aload_1
    //   49: ifnull -> 150
    //   52: aload_0
    //   53: getfield b : Lc/t/maploc/lite/tsa/ab;
    //   56: invokestatic i : (Lc/t/maploc/lite/tsa/ab;)Landroid/telephony/TelephonyManager;
    //   59: aload_1
    //   60: aload_3
    //   61: invokestatic a : (Landroid/telephony/TelephonyManager;Landroid/telephony/CellLocation;Landroid/telephony/SignalStrength;)Lc/t/maploc/lite/tsa/m;
    //   64: astore_3
    //   65: aload_0
    //   66: getfield a : [B
    //   69: astore_1
    //   70: aload_1
    //   71: monitorenter
    //   72: aload_3
    //   73: ifnull -> 101
    //   76: aload_3
    //   77: aload_0
    //   78: getfield b : Lc/t/maploc/lite/tsa/ab;
    //   81: getfield g : Lc/t/maploc/lite/tsa/j;
    //   84: getfield a : Landroid/content/Context;
    //   87: invokestatic b : (Landroid/content/Context;)Ljava/util/List;
    //   90: invokevirtual a : (Ljava/util/List;)V
    //   93: aload_0
    //   94: getfield b : Lc/t/maploc/lite/tsa/ab;
    //   97: aload_3
    //   98: invokevirtual a : (Lc/t/maploc/lite/tsa/p;)V
    //   101: aload_1
    //   102: monitorexit
    //   103: return
    //   104: astore_3
    //   105: aload_1
    //   106: monitorexit
    //   107: aload_3
    //   108: athrow
    //   109: aload_0
    //   110: getfield b : Lc/t/maploc/lite/tsa/ab;
    //   113: invokestatic g : (Lc/t/maploc/lite/tsa/ab;)Landroid/os/Handler;
    //   116: ifnull -> 128
    //   119: aload_0
    //   120: iconst_1
    //   121: ldc2_w 30000
    //   124: invokevirtual sendEmptyMessageDelayed : (IJ)Z
    //   127: pop
    //   128: aload_0
    //   129: getfield b : Lc/t/maploc/lite/tsa/ab;
    //   132: getfield g : Lc/t/maploc/lite/tsa/j;
    //   135: getfield a : Landroid/content/Context;
    //   138: invokestatic a : (Landroid/content/Context;)Landroid/telephony/CellLocation;
    //   141: astore_1
    //   142: aload_0
    //   143: getfield b : Lc/t/maploc/lite/tsa/ab;
    //   146: aload_1
    //   147: invokestatic c : (Lc/t/maploc/lite/tsa/ab;Landroid/telephony/CellLocation;)V
    //   150: return
    //   151: astore_1
    //   152: return
    // Exception table:
    //   from	to	target	type
    //   16	21	151	finally
    //   32	48	151	finally
    //   52	72	151	finally
    //   76	101	104	finally
    //   101	103	104	finally
    //   105	107	104	finally
    //   107	109	151	finally
    //   109	128	151	finally
    //   128	150	151	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */