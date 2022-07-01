package c.t.maploc.lite.tsa;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ah extends Handler {
  private byte[] a = new byte[0];
  
  private ah(af paramaf, Looper paramLooper) {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial handleMessage : (Landroid/os/Message;)V
    //   5: aload_0
    //   6: getfield b : Lc/t/maploc/lite/tsa/af;
    //   9: getfield h : Z
    //   12: ifne -> 16
    //   15: return
    //   16: aload_1
    //   17: getfield what : I
    //   20: istore_2
    //   21: iload_2
    //   22: iconst_1
    //   23: if_icmpeq -> 67
    //   26: iload_2
    //   27: iconst_2
    //   28: if_icmpeq -> 32
    //   31: return
    //   32: aload_0
    //   33: getfield b : Lc/t/maploc/lite/tsa/af;
    //   36: getfield b : Lc/t/maploc/lite/tsa/m;
    //   39: astore_3
    //   40: aload_0
    //   41: getfield a : [B
    //   44: astore_1
    //   45: aload_1
    //   46: monitorenter
    //   47: aload_3
    //   48: ifnull -> 59
    //   51: aload_0
    //   52: getfield b : Lc/t/maploc/lite/tsa/af;
    //   55: aload_3
    //   56: invokevirtual a : (Lc/t/maploc/lite/tsa/p;)V
    //   59: aload_1
    //   60: monitorexit
    //   61: return
    //   62: astore_3
    //   63: aload_1
    //   64: monitorexit
    //   65: aload_3
    //   66: athrow
    //   67: aload_0
    //   68: getfield b : Lc/t/maploc/lite/tsa/af;
    //   71: getfield e : Landroid/os/Handler;
    //   74: ifnull -> 86
    //   77: aload_0
    //   78: iconst_1
    //   79: ldc2_w 30000
    //   82: invokevirtual sendEmptyMessageDelayed : (IJ)Z
    //   85: pop
    //   86: aload_0
    //   87: getfield b : Lc/t/maploc/lite/tsa/af;
    //   90: getfield a : Landroid/telephony/TelephonyManager;
    //   93: astore_1
    //   94: aload_1
    //   95: ifnull -> 124
    //   98: aconst_null
    //   99: astore_1
    //   100: aload_0
    //   101: getfield b : Lc/t/maploc/lite/tsa/af;
    //   104: getfield a : Landroid/telephony/TelephonyManager;
    //   107: invokevirtual getAllCellInfo : ()Ljava/util/List;
    //   110: astore_3
    //   111: aload_3
    //   112: astore_1
    //   113: aload_0
    //   114: getfield b : Lc/t/maploc/lite/tsa/af;
    //   117: getfield f : Landroid/telephony/PhoneStateListener;
    //   120: aload_1
    //   121: invokevirtual onCellInfoChanged : (Ljava/util/List;)V
    //   124: return
    //   125: astore_1
    //   126: return
    //   127: astore_3
    //   128: goto -> 113
    // Exception table:
    //   from	to	target	type
    //   16	21	125	finally
    //   32	47	125	finally
    //   51	59	62	finally
    //   59	61	62	finally
    //   63	65	62	finally
    //   65	67	125	finally
    //   67	86	125	finally
    //   86	94	125	finally
    //   100	111	127	finally
    //   113	124	125	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */