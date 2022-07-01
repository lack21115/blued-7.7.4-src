package a.a.a.a.a.a.j;

import a.a.a.a.a.e.e;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class g extends f {
  public a.a.a.a.a.a.a a;
  
  public volatile a b;
  
  public final void a() {
    // Byte code:
    //   0: aload_0
    //   1: getfield w : La/a/a/a/a/a/j/f$a;
    //   4: astore_1
    //   5: aload_1
    //   6: getfield g : Z
    //   9: ifeq -> 27
    //   12: aload_0
    //   13: new a/a/a/a/a/a/j/i/a
    //   16: dup
    //   17: aload_1
    //   18: invokespecial <init> : (La/a/a/a/a/a/j/f$a;)V
    //   21: putfield a : La/a/a/a/a/a/a;
    //   24: goto -> 39
    //   27: aload_0
    //   28: new a/a/a/a/a/a/j/e
    //   31: dup
    //   32: aload_1
    //   33: invokespecial <init> : (La/a/a/a/a/a/j/f$a;)V
    //   36: putfield a : La/a/a/a/a/a/a;
    //   39: aload_0
    //   40: getfield v : La/a/a/a/a/a/c;
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull -> 54
    //   48: aload_1
    //   49: invokeinterface d : ()V
    //   54: aload_0
    //   55: lconst_0
    //   56: putfield y : J
    //   59: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   62: ldc 'YUVDataTransfer'
    //   64: ldc 'startEncoding -'
    //   66: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: monitorenter
    //   71: aload_0
    //   72: getstatic a/a/a/a/a/f/c.c : La/a/a/a/a/f/c;
    //   75: putfield t : La/a/a/a/a/f/c;
    //   78: aload_0
    //   79: invokevirtual e : ()V
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Exception table:
    //   from	to	target	type
    //   71	84	85	finally
    //   86	88	85	finally
  }
  
  public void a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : La/a/a/a/a/a/a;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull -> 16
    //   11: aload_2
    //   12: iload_1
    //   13: invokevirtual a : (I)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore_2
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	19	finally
    //   11	16	19	finally
  }
  
  public void a(f.a parama) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 19
    //   6: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   9: ldc 'YUVDataTransfer'
    //   11: ldc 'config is null when startEncoding'
    //   13: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield t : La/a/a/a/a/f/c;
    //   23: getstatic a/a/a/a/a/f/c.c : La/a/a/a/a/f/c;
    //   26: if_acmpne -> 42
    //   29: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   32: ldc 'YUVDataTransfer'
    //   34: ldc 'startEncoding failed as already being running'
    //   36: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_0
    //   43: getfield t : La/a/a/a/a/f/c;
    //   46: getstatic a/a/a/a/a/f/c.d : La/a/a/a/a/f/c;
    //   49: if_acmpne -> 77
    //   52: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   55: ldc 'YUVDataTransfer'
    //   57: ldc 'set pending action as START'
    //   59: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_0
    //   63: getstatic a/a/a/a/a/f/a.b : La/a/a/a/a/f/a;
    //   66: putfield u : La/a/a/a/a/f/a;
    //   69: aload_0
    //   70: aload_1
    //   71: putfield x : La/a/a/a/a/a/j/f$a;
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: aload_0
    //   78: getfield t : La/a/a/a/a/f/c;
    //   81: getstatic a/a/a/a/a/f/c.b : La/a/a/a/a/f/c;
    //   84: if_acmpne -> 122
    //   87: aload_0
    //   88: getfield u : La/a/a/a/a/f/a;
    //   91: getstatic a/a/a/a/a/f/a.c : La/a/a/a/a/f/a;
    //   94: if_acmpne -> 119
    //   97: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   100: ldc 'YUVDataTransfer'
    //   102: ldc 'set pending action as RESTART'
    //   104: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: getstatic a/a/a/a/a/f/a.d : La/a/a/a/a/f/a;
    //   111: putfield u : La/a/a/a/a/f/a;
    //   114: aload_0
    //   115: aload_1
    //   116: putfield x : La/a/a/a/a/a/j/f$a;
    //   119: aload_0
    //   120: monitorexit
    //   121: return
    //   122: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   125: ldc 'YUVDataTransfer'
    //   127: ldc 'startEncoding +'
    //   129: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_0
    //   133: aload_1
    //   134: putfield w : La/a/a/a/a/a/j/f$a;
    //   137: aload_0
    //   138: getstatic a/a/a/a/a/f/c.b : La/a/a/a/a/f/c;
    //   141: putfield t : La/a/a/a/a/f/c;
    //   144: new android/os/HandlerThread
    //   147: dup
    //   148: ldc 'YUVDataTransfer'
    //   150: invokespecial <init> : (Ljava/lang/String;)V
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual start : ()V
    //   158: aload_0
    //   159: new a/a/a/a/a/a/j/g$a
    //   162: dup
    //   163: aload_1
    //   164: invokevirtual getLooper : ()Landroid/os/Looper;
    //   167: aload_0
    //   168: invokespecial <init> : (Landroid/os/Looper;La/a/a/a/a/a/j/g;)V
    //   171: putfield b : La/a/a/a/a/a/j/g$a;
    //   174: aload_0
    //   175: getfield b : La/a/a/a/a/a/j/g$a;
    //   178: iconst_1
    //   179: invokevirtual sendEmptyMessage : (I)Z
    //   182: pop
    //   183: aload_0
    //   184: monitorexit
    //   185: return
    //   186: astore_1
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_1
    //   190: athrow
    // Exception table:
    //   from	to	target	type
    //   6	16	186	finally
    //   19	39	186	finally
    //   42	74	186	finally
    //   77	119	186	finally
    //   122	183	186	finally
  }
  
  public void a(WatermarkSetting paramWatermarkSetting) {
    f.a a2 = this.w;
    if (a2 != null)
      a2.a(paramWatermarkSetting); 
    a.a.a.a.a.a.a a1 = this.a;
    if (a1 != null)
      a1.a(paramWatermarkSetting); 
  }
  
  public final void a(PLAVFrame paramPLAVFrame) {
    a.a.a.a.a.a.a a1 = this.a;
    if (a1 != null)
      a1.a(paramPLAVFrame, this.w, false); 
  }
  
  public void a(ByteBuffer paramByteBuffer, int paramInt, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield t : La/a/a/a/a/f/c;
    //   6: getstatic a/a/a/a/a/f/c.c : La/a/a/a/a/f/c;
    //   9: if_acmpne -> 227
    //   12: aload_0
    //   13: getfield a : La/a/a/a/a/a/a;
    //   16: ifnull -> 227
    //   19: aload_0
    //   20: getfield b : La/a/a/a/a/a/j/g$a;
    //   23: ifnull -> 227
    //   26: invokestatic a : ()La/a/a/a/a/a/j/a;
    //   29: invokevirtual b : ()Z
    //   32: ifeq -> 38
    //   35: goto -> 227
    //   38: aload_0
    //   39: aload_0
    //   40: getfield y : J
    //   43: lconst_1
    //   44: ladd
    //   45: putfield y : J
    //   48: invokestatic d : ()Z
    //   51: ifeq -> 122
    //   54: aload_0
    //   55: getfield y : J
    //   58: ldc2_w 2
    //   61: lrem
    //   62: lconst_0
    //   63: lcmp
    //   64: ifne -> 122
    //   67: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   70: ldc 'YUVDataTransfer'
    //   72: ldc 'Drop the in frame'
    //   74: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload_0
    //   78: getfield w : La/a/a/a/a/a/j/f$a;
    //   81: getfield a : La/a/a/a/a/a/i/c;
    //   84: invokevirtual e : ()La/a/a/a/a/a/i/c$b;
    //   87: astore_1
    //   88: aload_1
    //   89: aload_1
    //   90: getfield l : J
    //   93: lconst_1
    //   94: ladd
    //   95: putfield l : J
    //   98: aload_0
    //   99: getfield w : La/a/a/a/a/a/j/f$a;
    //   102: getfield a : La/a/a/a/a/a/i/c;
    //   105: invokevirtual e : ()La/a/a/a/a/a/i/c$b;
    //   108: astore_1
    //   109: aload_1
    //   110: aload_1
    //   111: getfield w : J
    //   114: lconst_1
    //   115: ladd
    //   116: putfield w : J
    //   119: aload_0
    //   120: monitorexit
    //   121: return
    //   122: aload_0
    //   123: getfield a : La/a/a/a/a/a/a;
    //   126: aload_1
    //   127: invokevirtual capacity : ()I
    //   130: invokevirtual b : (I)Lcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;
    //   133: astore #5
    //   135: aload #5
    //   137: ifnull -> 172
    //   140: aload #5
    //   142: aload_1
    //   143: aload_1
    //   144: invokevirtual capacity : ()I
    //   147: lload_3
    //   148: invokevirtual fillFrame : (Ljava/nio/ByteBuffer;IJ)V
    //   151: aload_0
    //   152: getfield b : La/a/a/a/a/a/j/g$a;
    //   155: aload_0
    //   156: getfield b : La/a/a/a/a/a/j/g$a;
    //   159: iconst_2
    //   160: aload #5
    //   162: invokevirtual obtainMessage : (ILjava/lang/Object;)Landroid/os/Message;
    //   165: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   168: pop
    //   169: goto -> 224
    //   172: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   175: ldc 'YUVDataTransfer'
    //   177: ldc 'inputFrame is null. so drop the frame...'
    //   179: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload_0
    //   183: getfield w : La/a/a/a/a/a/j/f$a;
    //   186: getfield a : La/a/a/a/a/a/i/c;
    //   189: invokevirtual e : ()La/a/a/a/a/a/i/c$b;
    //   192: astore_1
    //   193: aload_1
    //   194: aload_1
    //   195: getfield l : J
    //   198: lconst_1
    //   199: ladd
    //   200: putfield l : J
    //   203: aload_0
    //   204: getfield w : La/a/a/a/a/a/j/f$a;
    //   207: getfield a : La/a/a/a/a/a/i/c;
    //   210: invokevirtual e : ()La/a/a/a/a/a/i/c$b;
    //   213: astore_1
    //   214: aload_1
    //   215: aload_1
    //   216: getfield w : J
    //   219: lconst_1
    //   220: ladd
    //   221: putfield w : J
    //   224: aload_0
    //   225: monitorexit
    //   226: return
    //   227: aload_0
    //   228: monitorexit
    //   229: return
    //   230: astore_1
    //   231: aload_0
    //   232: monitorexit
    //   233: aload_1
    //   234: athrow
    // Exception table:
    //   from	to	target	type
    //   2	35	230	finally
    //   38	119	230	finally
    //   122	135	230	finally
    //   140	169	230	finally
    //   172	224	230	finally
  }
  
  public void a(byte[] paramArrayOfbyte, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   5: astore #4
    //   7: new java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial <init> : ()V
    //   14: astore #5
    //   16: aload #5
    //   18: ldc 'onPreviewFrame + bytes.len:'
    //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload #5
    //   26: aload_1
    //   27: arraylength
    //   28: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload #5
    //   34: ldc ',ts:'
    //   36: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload #5
    //   42: lload_2
    //   43: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload #4
    //   49: ldc 'YUVDataTransfer'
    //   51: aload #5
    //   53: invokevirtual toString : ()Ljava/lang/String;
    //   56: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield t : La/a/a/a/a/f/c;
    //   63: getstatic a/a/a/a/a/f/c.c : La/a/a/a/a/f/c;
    //   66: if_acmpne -> 288
    //   69: aload_0
    //   70: getfield a : La/a/a/a/a/a/a;
    //   73: ifnull -> 288
    //   76: aload_0
    //   77: getfield b : La/a/a/a/a/a/j/g$a;
    //   80: ifnull -> 288
    //   83: invokestatic a : ()La/a/a/a/a/a/j/a;
    //   86: invokevirtual b : ()Z
    //   89: ifeq -> 95
    //   92: goto -> 288
    //   95: aload_0
    //   96: aload_0
    //   97: getfield y : J
    //   100: lconst_1
    //   101: ladd
    //   102: putfield y : J
    //   105: invokestatic d : ()Z
    //   108: ifeq -> 179
    //   111: aload_0
    //   112: getfield y : J
    //   115: ldc2_w 2
    //   118: lrem
    //   119: lconst_0
    //   120: lcmp
    //   121: ifne -> 179
    //   124: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   127: ldc 'YUVDataTransfer'
    //   129: ldc 'Drop the in frame'
    //   131: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_0
    //   135: getfield w : La/a/a/a/a/a/j/f$a;
    //   138: getfield a : La/a/a/a/a/a/i/c;
    //   141: invokevirtual e : ()La/a/a/a/a/a/i/c$b;
    //   144: astore_1
    //   145: aload_1
    //   146: aload_1
    //   147: getfield l : J
    //   150: lconst_1
    //   151: ladd
    //   152: putfield l : J
    //   155: aload_0
    //   156: getfield w : La/a/a/a/a/a/j/f$a;
    //   159: getfield a : La/a/a/a/a/a/i/c;
    //   162: invokevirtual e : ()La/a/a/a/a/a/i/c$b;
    //   165: astore_1
    //   166: aload_1
    //   167: aload_1
    //   168: getfield w : J
    //   171: lconst_1
    //   172: ladd
    //   173: putfield w : J
    //   176: aload_0
    //   177: monitorexit
    //   178: return
    //   179: aload_0
    //   180: getfield a : La/a/a/a/a/a/a;
    //   183: aload_1
    //   184: arraylength
    //   185: invokevirtual b : (I)Lcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;
    //   188: astore #4
    //   190: aload #4
    //   192: ifnull -> 223
    //   195: aload #4
    //   197: aload_1
    //   198: lload_2
    //   199: invokevirtual fillFrame : ([BJ)V
    //   202: aload_0
    //   203: getfield b : La/a/a/a/a/a/j/g$a;
    //   206: aload_0
    //   207: getfield b : La/a/a/a/a/a/j/g$a;
    //   210: iconst_2
    //   211: aload #4
    //   213: invokevirtual obtainMessage : (ILjava/lang/Object;)Landroid/os/Message;
    //   216: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   219: pop
    //   220: goto -> 275
    //   223: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   226: ldc 'YUVDataTransfer'
    //   228: ldc 'inputFrame is null. so drop the frame...'
    //   230: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload_0
    //   234: getfield w : La/a/a/a/a/a/j/f$a;
    //   237: getfield a : La/a/a/a/a/a/i/c;
    //   240: invokevirtual e : ()La/a/a/a/a/a/i/c$b;
    //   243: astore_1
    //   244: aload_1
    //   245: aload_1
    //   246: getfield l : J
    //   249: lconst_1
    //   250: ladd
    //   251: putfield l : J
    //   254: aload_0
    //   255: getfield w : La/a/a/a/a/a/j/f$a;
    //   258: getfield a : La/a/a/a/a/a/i/c;
    //   261: invokevirtual e : ()La/a/a/a/a/a/i/c$b;
    //   264: astore_1
    //   265: aload_1
    //   266: aload_1
    //   267: getfield w : J
    //   270: lconst_1
    //   271: ladd
    //   272: putfield w : J
    //   275: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   278: ldc 'YUVDataTransfer'
    //   280: ldc 'onPreviewFrame -'
    //   282: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload_0
    //   286: monitorexit
    //   287: return
    //   288: aload_0
    //   289: monitorexit
    //   290: return
    //   291: astore_1
    //   292: aload_0
    //   293: monitorexit
    //   294: aload_1
    //   295: athrow
    // Exception table:
    //   from	to	target	type
    //   2	92	291	finally
    //   95	176	291	finally
    //   179	190	291	finally
    //   195	220	291	finally
    //   223	275	291	finally
    //   275	285	291	finally
  }
  
  public boolean a(boolean paramBoolean) {
    f.a a1 = this.w;
    if (a1 != null) {
      a1.a(paramBoolean);
      return true;
    } 
    e.f.c("YUVDataTransfer", "setEncodingMirror failed");
    return false;
  }
  
  public final void b() {
    a.a.a.a.a.a.a a1 = this.a;
    if (a1 != null) {
      a1.b();
      this.a = null;
    } 
  }
  
  public void b(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield t : La/a/a/a/a/f/c;
    //   6: getstatic a/a/a/a/a/f/c.a : La/a/a/a/a/f/c;
    //   9: if_acmpne -> 25
    //   12: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   15: ldc 'YUVDataTransfer'
    //   17: ldc 'stopEncoding failed as not being running'
    //   19: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield t : La/a/a/a/a/f/c;
    //   29: getstatic a/a/a/a/a/f/c.b : La/a/a/a/a/f/c;
    //   32: if_acmpne -> 55
    //   35: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   38: ldc 'YUVDataTransfer'
    //   40: ldc 'set pending action as STOP'
    //   42: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: getstatic a/a/a/a/a/f/a.c : La/a/a/a/a/f/a;
    //   49: putfield u : La/a/a/a/a/f/a;
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: getfield t : La/a/a/a/a/f/c;
    //   59: getstatic a/a/a/a/a/f/c.d : La/a/a/a/a/f/c;
    //   62: if_acmpne -> 95
    //   65: aload_0
    //   66: getfield u : La/a/a/a/a/f/a;
    //   69: getstatic a/a/a/a/a/f/a.b : La/a/a/a/a/f/a;
    //   72: if_acmpne -> 92
    //   75: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   78: ldc 'YUVDataTransfer'
    //   80: ldc 'clear pending start action'
    //   82: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: getstatic a/a/a/a/a/f/a.a : La/a/a/a/a/f/a;
    //   89: putfield u : La/a/a/a/a/f/a;
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   98: ldc 'YUVDataTransfer'
    //   100: ldc 'stopEncoding +'
    //   102: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_0
    //   106: getstatic a/a/a/a/a/f/c.d : La/a/a/a/a/f/c;
    //   109: putfield t : La/a/a/a/a/f/c;
    //   112: aload_0
    //   113: getfield b : La/a/a/a/a/a/j/g$a;
    //   116: aload_0
    //   117: getfield b : La/a/a/a/a/a/j/g$a;
    //   120: iconst_0
    //   121: iload_1
    //   122: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   125: invokevirtual obtainMessage : (ILjava/lang/Object;)Landroid/os/Message;
    //   128: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   131: pop
    //   132: aload_0
    //   133: monitorexit
    //   134: return
    //   135: astore_2
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_2
    //   139: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	135	finally
    //   25	52	135	finally
    //   55	92	135	finally
    //   95	132	135	finally
  }
  
  public final void d(boolean paramBoolean) {
    // Byte code:
    //   0: invokestatic myLooper : ()Landroid/os/Looper;
    //   3: invokevirtual quit : ()V
    //   6: aload_0
    //   7: getfield a : La/a/a/a/a/a/a;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull -> 31
    //   15: iload_1
    //   16: ifeq -> 31
    //   19: aload_2
    //   20: invokevirtual a : ()V
    //   23: aload_0
    //   24: getfield a : La/a/a/a/a/a/a;
    //   27: iconst_1
    //   28: invokevirtual a : (Z)V
    //   31: aload_0
    //   32: invokevirtual b : ()V
    //   35: aload_0
    //   36: getfield v : La/a/a/a/a/a/c;
    //   39: astore_2
    //   40: aload_2
    //   41: ifnull -> 50
    //   44: aload_2
    //   45: invokeinterface a : ()V
    //   50: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   53: ldc 'YUVDataTransfer'
    //   55: ldc_w 'stopEncoding -'
    //   58: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_0
    //   62: monitorenter
    //   63: aload_0
    //   64: getstatic a/a/a/a/a/f/c.a : La/a/a/a/a/f/c;
    //   67: putfield t : La/a/a/a/a/f/c;
    //   70: aload_0
    //   71: invokevirtual e : ()V
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore_2
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_2
    //   81: athrow
    // Exception table:
    //   from	to	target	type
    //   63	76	77	finally
    //   78	80	77	finally
  }
  
  public static class a extends Handler {
    public WeakReference<g> a;
    
    public a(Looper param1Looper, g param1g) {
      super(param1Looper);
      this.a = new WeakReference<g>(param1g);
    }
    
    public void handleMessage(Message param1Message) {
      int i = param1Message.what;
      Object object = param1Message.obj;
      g g = this.a.get();
      if (g == null) {
        e.f.d("YUVDataTransfer", "EncoderHandler.handleMessage: encoder is null");
        return;
      } 
      if (i != 0) {
        if (i != 1) {
          if (i != 2)
            return; 
          g.a(g, (PLAVFrame)object);
          return;
        } 
        g.a(g);
        return;
      } 
      g.a(g, ((Boolean)object).booleanValue());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\j\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */