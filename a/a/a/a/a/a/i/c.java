package a.a.a.a.a.a.i;

import a.a.a.a.a.e.h;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.qiniu.pili.droid.streaming.StreamStatusCallback;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import com.qiniu.pili.droid.streaming.core.PLDroidStreamingCore;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public abstract class c {
  public d A;
  
  public StreamStatusCallback B;
  
  public boolean C = false;
  
  public boolean D = false;
  
  public ByteBuffer E;
  
  public int F = 0;
  
  public BlockingDeque<g> G = new LinkedBlockingDeque<g>();
  
  public ArrayList<a.a.a.a.a.a.f.a> H;
  
  public a.a.a.a.a.a.f.a I;
  
  public volatile b J = new b(this);
  
  public boolean K = false;
  
  public long L;
  
  public e M;
  
  public Context N;
  
  public boolean O = false;
  
  public Thread P;
  
  public f Q;
  
  public volatile boolean R;
  
  public int b = 4;
  
  public int c = 1;
  
  public int d;
  
  public int e;
  
  public byte[] f;
  
  public PLDroidStreamingCore g;
  
  public final Object h = new Object();
  
  public volatile boolean i;
  
  public boolean j;
  
  public volatile boolean k = false;
  
  public volatile boolean l = false;
  
  public volatile boolean m = false;
  
  public final Object n = new Object();
  
  public boolean o;
  
  public byte[] p;
  
  public byte[] q;
  
  public final int r;
  
  public final Object s = new Object();
  
  public volatile boolean t = false;
  
  public volatile boolean u = false;
  
  public int v = 0;
  
  public long[] w;
  
  public long[] x;
  
  public a.a.a.a.a.a.b y;
  
  public d z;
  
  static {
    h.b(300, 800);
  }
  
  public c() {
    this.g = new PLDroidStreamingCore();
    this.r = 2;
  }
  
  public c(int paramInt) {
    this.r = paramInt;
    this.g = new PLDroidStreamingCore();
  }
  
  public static boolean c() {
    return false;
  }
  
  public int a(g paramg) {
    PLDroidStreamingCore pLDroidStreamingCore = this.g;
    ByteBuffer byteBuffer = paramg.d.mBuffer;
    PLBufferInfo pLBufferInfo = paramg.a;
    int i = pLDroidStreamingCore.sendFrame(byteBuffer, pLBufferInfo.size, pLBufferInfo.presentationTimeUs / 1000L, pLBufferInfo.dtsUs / 1000L, false, false);
    if (i == 0) {
      b b1 = this.J;
      b1.n++;
      b1 = this.J;
      b1.t++;
    } 
    return i;
  }
  
  public long a(long paramLong, int paramInt, boolean paramBoolean) {
    a.a.a.a.a.e.e e1;
    long[] arrayOfLong = this.w;
    if (arrayOfLong[paramInt] == 0L) {
      if (paramLong != 0L) {
        arrayOfLong[paramInt] = paramLong;
        e1 = a.a.a.a.a.e.e.f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Set mFirstPts[");
        stringBuilder.append(paramInt);
        stringBuilder.append("] ");
        stringBuilder.append(this.w);
        e1.b("Muxer", stringBuilder.toString());
      } 
      return 0L;
    } 
    return b(paramLong - e1[paramInt], paramInt, paramBoolean);
  }
  
  public void a() {
    a.a.a.a.a.e.e.f.c("Muxer", "forceStop");
    if (!f()) {
      a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("forceStop return immediately:mReady=");
      stringBuilder.append(this.i);
      e1.c("Muxer", stringBuilder.toString());
      return;
    } 
    if (this.C) {
      a.a.a.a.a.e.e.f.c("Muxer", "streaming paused");
      return;
    } 
    this.m = true;
    e(new g(-1, 0, null, null));
  }
  
  public void a(int paramInt) {
    synchronized (this.s) {
      a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("addTrack trackIndex:");
      stringBuilder.append(paramInt);
      e1.c("Muxer", stringBuilder.toString());
      if (paramInt == 0) {
        this.t = true;
      } else if (paramInt == 1) {
        this.u = true;
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Unsupported Track:");
        stringBuilder1.append(paramInt);
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      f(paramInt);
      return;
    } 
  }
  
  public final void a(int paramInt1, int paramInt2) {
    Intent intent = new Intent("pldroid-qos-filter");
    intent.putExtra("pldroid-qos-msg-type", 164);
    intent.putExtra("beginAt", this.L);
    intent.putExtra("endAt", System.currentTimeMillis());
    intent.putExtra("gopTime", n());
    intent.putExtra("videoSendFrames", (int)this.J.u);
    intent.putExtra("videoDroppedFrames", (int)this.J.w);
    intent.putExtra("audioSendFrames", (int)this.J.t);
    intent.putExtra("audioDroppedFrames", (int)this.J.v);
    intent.putExtra("totalSendBytes", this.J.y + this.J.x);
    intent.putExtra("errorCode", paramInt1);
    intent.putExtra("errorOSCode", paramInt2);
    a.a.a.a.a.j.a.a().a(intent);
  }
  
  public void a(int paramInt1, int paramInt2, PLAVFrame paramPLAVFrame, PLBufferInfo paramPLBufferInfo) {
    if (h.c(paramPLBufferInfo)) {
      a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("SIGNAL END OF TRACK trackIndex:");
      stringBuilder.append(paramInt1);
      stringBuilder.append(",mStreamingPaused:");
      stringBuilder.append(this.C);
      e1.b("Muxer", stringBuilder.toString());
      if (!this.C)
        c(paramInt1); 
    } 
  }
  
  public void a(int paramInt1, PLAVFrame paramPLAVFrame, int paramInt2) {
    if (paramInt1 == 0) {
      d d1 = this.z;
      if (d1 != null) {
        d1.a(paramPLAVFrame, paramInt2);
        return;
      } 
    } else {
      if (paramInt1 == 1) {
        d d1 = this.A;
        if (d1 != null)
          d1.a(paramPLAVFrame, paramInt2); 
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("can't support track:");
      stringBuilder.append(paramInt1);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
  }
  
  public final void a(a.a.a.a.a.a.b.c paramc, Object paramObject) {
    paramc.ordinal();
    q();
    d().a(paramc, paramObject);
  }
  
  public void a(d paramd) {
    this.A = paramd;
  }
  
  public void a(Context paramContext) {
    this.N = paramContext;
  }
  
  public void a(StreamStatusCallback paramStreamStatusCallback) {
    this.B = paramStreamStatusCallback;
  }
  
  public void a(PLBufferInfo paramPLBufferInfo, PLAVFrame paramPLAVFrame, int paramInt1, int paramInt2) {
    synchronized (this.n) {
      if (!this.o) {
        a.a.a.a.a.e.e.f.a("Muxer", "releaseOutputBufer encodedData.clear()!");
        paramPLAVFrame.mBuffer.clear();
        if (h.a(paramPLBufferInfo)) {
          a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.f;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("mMuxerInputKeyFrameQueue.add encodedData:");
          stringBuilder.append(paramPLAVFrame.mBuffer);
          e1.c("Muxer", stringBuilder.toString());
          this.I.a(paramPLAVFrame);
        } else {
          synchronized (this.H) {
            ((a.a.a.a.a.a.f.a)this.H.get(paramInt2)).a(paramPLAVFrame);
          } 
        } 
      } 
      return;
    } 
  }
  
  public final void a(PLDroidStreamingCore.AVOptions paramAVOptions) {
    Context context = this.N;
    if (context != null) {
      if (paramAVOptions == null)
        return; 
      String[] arrayOfString2 = h.g(context);
      if (arrayOfString2 != null && arrayOfString2.length == 2) {
        paramAVOptions.appName = arrayOfString2[0];
        paramAVOptions.appVersion = arrayOfString2[1];
      } 
      String str = a.a.a.a.a.k.c.a.b(this.N);
      paramAVOptions.networkType = str;
      boolean bool = str.equals("WIFI");
      paramAVOptions.isWifiNetwork = bool;
      if (bool) {
        String[] arrayOfString = a.a.a.a.a.k.c.a.f(this.N);
        if (arrayOfString != null && arrayOfString.length >= 2) {
          if (h.d(arrayOfString[1])) {
            paramAVOptions.signalDB = Integer.parseInt(arrayOfString[1]);
            paramAVOptions.enableWifiPermission = true;
            return;
          } 
          paramAVOptions.enableWifiPermission = false;
          return;
        } 
        paramAVOptions.enableWifiPermission = false;
        return;
      } 
      String[] arrayOfString1 = a.a.a.a.a.k.c.a.g(this.N);
      if (arrayOfString1 != null && arrayOfString1.length >= 2) {
        paramAVOptions.ispName = arrayOfString1[0];
        if (h.d(arrayOfString1[1])) {
          paramAVOptions.signalDB = Integer.parseInt(arrayOfString1[1]);
          paramAVOptions.enablePhonePermission = true;
          return;
        } 
        paramAVOptions.enablePhonePermission = false;
        return;
      } 
      paramAVOptions.enablePhonePermission = false;
    } 
  }
  
  public void a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Ljava/lang/Object;
    //   6: astore_3
    //   7: aload_3
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield R : Z
    //   13: ifeq -> 37
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield R : Z
    //   21: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   24: ldc 'Muxer'
    //   26: ldc_w 'start muxing thread marked interrupt, unnecessary to go on'
    //   29: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_3
    //   33: monitorexit
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: aload_0
    //   38: getfield j : Z
    //   41: ifeq -> 60
    //   44: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   47: ldc 'Muxer'
    //   49: ldc_w 'Muxing thread running when start requested'
    //   52: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload_3
    //   56: monitorexit
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield j : Z
    //   65: aload_0
    //   66: iconst_0
    //   67: putfield k : Z
    //   70: new a/a/a/a/a/a/i/c$f
    //   73: dup
    //   74: aload_0
    //   75: invokespecial <init> : (La/a/a/a/a/a/i/c;)V
    //   78: astore #4
    //   80: aload_0
    //   81: aload #4
    //   83: putfield Q : La/a/a/a/a/a/i/c$f;
    //   86: aload #4
    //   88: aload_1
    //   89: invokevirtual setName : (Ljava/lang/String;)V
    //   92: aload_0
    //   93: getfield Q : La/a/a/a/a/a/i/c$f;
    //   96: invokevirtual start : ()V
    //   99: aload_0
    //   100: invokestatic currentThread : ()Ljava/lang/Thread;
    //   103: putfield P : Ljava/lang/Thread;
    //   106: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   109: astore_1
    //   110: new java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial <init> : ()V
    //   117: astore #4
    //   119: aload #4
    //   121: ldc_w 'the thread to launch muxing thread is: '
    //   124: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload #4
    //   130: aload_0
    //   131: getfield P : Ljava/lang/Thread;
    //   134: invokevirtual getId : ()J
    //   137: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_1
    //   142: ldc 'Muxer'
    //   144: aload #4
    //   146: invokevirtual toString : ()Ljava/lang/String;
    //   149: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload_0
    //   153: getfield i : Z
    //   156: ifne -> 234
    //   159: aload_0
    //   160: getfield k : Z
    //   163: istore_2
    //   164: iload_2
    //   165: ifne -> 234
    //   168: aload_0
    //   169: getfield h : Ljava/lang/Object;
    //   172: invokevirtual wait : ()V
    //   175: goto -> 152
    //   178: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   181: astore_1
    //   182: new java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial <init> : ()V
    //   189: astore #4
    //   191: aload #4
    //   193: ldc_w 'interrupt from user, stop waiting muxing thread: '
    //   196: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload #4
    //   202: aload_0
    //   203: getfield Q : La/a/a/a/a/a/i/c$f;
    //   206: invokevirtual getId : ()J
    //   209: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_1
    //   214: ldc 'Muxer'
    //   216: aload #4
    //   218: invokevirtual toString : ()Ljava/lang/String;
    //   221: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload_0
    //   225: iconst_1
    //   226: putfield k : Z
    //   229: aload_0
    //   230: iconst_0
    //   231: putfield j : Z
    //   234: aload_3
    //   235: monitorexit
    //   236: aload_0
    //   237: monitorexit
    //   238: return
    //   239: astore_1
    //   240: aload_3
    //   241: monitorexit
    //   242: aload_1
    //   243: athrow
    //   244: astore_1
    //   245: aload_0
    //   246: monitorexit
    //   247: aload_1
    //   248: athrow
    //   249: astore_1
    //   250: goto -> 178
    // Exception table:
    //   from	to	target	type
    //   2	9	244	finally
    //   9	34	239	finally
    //   37	57	239	finally
    //   60	110	239	finally
    //   110	152	239	finally
    //   152	164	239	finally
    //   168	175	249	java/lang/InterruptedException
    //   168	175	239	finally
    //   178	182	239	finally
    //   182	234	239	finally
    //   234	236	239	finally
    //   240	242	239	finally
    //   242	244	244	finally
  }
  
  public void a(ByteBuffer paramByteBuffer, PLBufferInfo paramPLBufferInfo) {
    a.a.a.a.a.e.e.f.c("Muxer", "AACMetaData");
    int i = paramPLBufferInfo.size;
    byte[] arrayOfByte = new byte[i];
    this.q = arrayOfByte;
    paramByteBuffer.get(arrayOfByte, paramPLBufferInfo.offset, i);
    paramByteBuffer.position(paramPLBufferInfo.offset);
    paramByteBuffer.put(this.q, 0, paramPLBufferInfo.size);
    paramByteBuffer.position(paramPLBufferInfo.offset);
  }
  
  public void a(boolean paramBoolean) {
    this.C = paramBoolean;
    if (paramBoolean)
      this.D = true; 
  }
  
  public void a(byte[] paramArrayOfbyte, int paramInt) {
    paramArrayOfbyte[0] = -1;
    paramArrayOfbyte[1] = -7;
    int i = this.b;
    int j = this.c;
    paramArrayOfbyte[2] = (byte)((i << 2) + 64 + (j >> 2));
    paramArrayOfbyte[3] = (byte)(((j & 0x3) << 6) + (paramInt >> 11));
    paramArrayOfbyte[4] = (byte)((paramInt & 0x7FF) >> 3);
    paramArrayOfbyte[5] = (byte)(((paramInt & 0x7) << 5) + 31);
    paramArrayOfbyte[6] = -4;
  }
  
  public boolean a(a.a.a.a.a.a.b paramb) {
    a.a.a.a.a.e.e.f.c("Muxer", "prepare");
    return b(paramb);
  }
  
  public final long b(long paramLong, int paramInt, boolean paramBoolean) {
    long[] arrayOfLong = this.x;
    if (arrayOfLong[paramInt] >= paramLong) {
      arrayOfLong[paramInt] = arrayOfLong[paramInt] + 9643L;
      return arrayOfLong[paramInt];
    } 
    if (paramBoolean)
      arrayOfLong[paramInt] = paramLong; 
    return paramLong;
  }
  
  public abstract void b();
  
  public void b(int paramInt) {
    a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.f;
    null = new StringBuilder();
    null.append("onEncoderReleased trackIndex=");
    null.append(paramInt);
    e1.c("Muxer", null.toString());
    synchronized (this.n) {
      this.o = true;
      return;
    } 
  }
  
  public void b(d paramd) {
    this.z = paramd;
  }
  
  public void b(ByteBuffer paramByteBuffer, PLBufferInfo paramPLBufferInfo) {
    if (!h.d(paramPLBufferInfo)) {
      a.a.a.a.a.e.e.f.c("Muxer", "no need to add adts header");
      return;
    } 
    int i = paramPLBufferInfo.size;
    this.d = i;
    i += 7;
    this.e = i;
    a(this.f, i);
    paramByteBuffer.get(this.f, 7, this.d);
    paramByteBuffer.position(paramPLBufferInfo.offset);
    paramByteBuffer.limit(paramPLBufferInfo.offset + this.e);
    try {
      paramByteBuffer.put(this.f, 0, this.e);
      paramByteBuffer.position(paramPLBufferInfo.offset);
      paramPLBufferInfo.size = this.e;
      return;
    } catch (BufferOverflowException bufferOverflowException) {
      a.a.a.a.a.e.e.f.d("Muxer", "BufferOverFlow adding ADTS header");
      paramByteBuffer.put(this.f, 0, this.e);
      return;
    } 
  }
  
  public void b(boolean paramBoolean) {
    this.O = paramBoolean;
  }
  
  public boolean b(a.a.a.a.a.a.b paramb) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield y : La/a/a/a/a/a/b;
    //   5: aload_0
    //   6: getfield s : Ljava/lang/Object;
    //   9: astore_1
    //   10: aload_1
    //   11: monitorenter
    //   12: iconst_0
    //   13: istore_3
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield u : Z
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield t : Z
    //   24: aload_1
    //   25: monitorexit
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield v : I
    //   31: aload_0
    //   32: iconst_2
    //   33: newarray long
    //   35: putfield x : [J
    //   38: iconst_0
    //   39: istore_2
    //   40: aload_0
    //   41: getfield x : [J
    //   44: astore_1
    //   45: iload_2
    //   46: aload_1
    //   47: arraylength
    //   48: if_icmpge -> 62
    //   51: aload_1
    //   52: iload_2
    //   53: lconst_0
    //   54: lastore
    //   55: iload_2
    //   56: iconst_1
    //   57: iadd
    //   58: istore_2
    //   59: goto -> 40
    //   62: aload_0
    //   63: iconst_2
    //   64: newarray long
    //   66: putfield w : [J
    //   69: iload_3
    //   70: istore_2
    //   71: aload_0
    //   72: getfield w : [J
    //   75: astore_1
    //   76: iload_2
    //   77: aload_1
    //   78: arraylength
    //   79: if_icmpge -> 93
    //   82: aload_1
    //   83: iload_2
    //   84: lconst_0
    //   85: lastore
    //   86: iload_2
    //   87: iconst_1
    //   88: iadd
    //   89: istore_2
    //   90: goto -> 71
    //   93: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   96: astore_1
    //   97: new java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial <init> : ()V
    //   104: astore #4
    //   106: aload #4
    //   108: ldc_w 'Created muxer for output: '
    //   111: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload #4
    //   117: aload_0
    //   118: getfield y : La/a/a/a/a/a/b;
    //   121: invokevirtual g : ()Ljava/lang/String;
    //   124: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_1
    //   129: ldc 'Muxer'
    //   131: aload #4
    //   133: invokevirtual toString : ()Ljava/lang/String;
    //   136: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   139: iconst_1
    //   140: ireturn
    //   141: astore #4
    //   143: aload_1
    //   144: monitorexit
    //   145: aload #4
    //   147: athrow
    // Exception table:
    //   from	to	target	type
    //   14	26	141	finally
    //   143	145	141	finally
  }
  
  public int c(g paramg) {
    if (paramg.b == 0 && i())
      b(paramg.d.mBuffer, paramg.a); 
    paramg.d.mBuffer.position(paramg.a.offset);
    ByteBuffer byteBuffer = paramg.d.mBuffer;
    PLBufferInfo pLBufferInfo2 = paramg.a;
    byteBuffer.limit(pLBufferInfo2.offset + pLBufferInfo2.size);
    paramg.f = null;
    if (paramg.b == 1) {
      if (a.a.a.a.a.f.b.a().c() || a.a.a.a.a.f.b.a().b(paramg.a.presentationTimeUs)) {
        paramg.f = a.a.a.a.a.f.b.a().b();
        a.a.a.a.a.f.b.a().d();
      } 
      a.a.a.a.a.f.b.a().e();
    } 
    PLBufferInfo pLBufferInfo1 = paramg.a;
    pLBufferInfo1.presentationTimeUs = a(pLBufferInfo1.presentationTimeUs, paramg.b, true ^ h.b(pLBufferInfo1));
    pLBufferInfo1 = paramg.a;
    if (pLBufferInfo1.presentationTimeUs < 0L) {
      a(pLBufferInfo1, paramg.d, paramg.c, paramg.b);
      a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Warming bufferInfo.presentationTimeUs:");
      stringBuilder.append(paramg.a.presentationTimeUs);
      e1.d("Muxer", stringBuilder.toString());
      if (!this.C && g()) {
        a.a.a.a.a.e.e.f.c("Muxer", "Shutting down on last frame");
        return -1;
      } 
    } 
    return 0;
  }
  
  public void c(int paramInt) {
    paramInt = this.v + 1;
    this.v = paramInt;
    if (paramInt > 2)
      this.v = 2; 
  }
  
  public void c(ByteBuffer paramByteBuffer, PLBufferInfo paramPLBufferInfo) {
    a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("H264MetaData mH264MetaSize:");
    stringBuilder.append(paramPLBufferInfo.size);
    e1.c("Muxer", stringBuilder.toString());
    int i = paramPLBufferInfo.size;
    if (i <= 0) {
      a.a.a.a.a.e.e.f.e("Muxer", "error buffer size");
      return;
    } 
    this.F = i;
    byte[] arrayOfByte = new byte[i];
    this.p = arrayOfByte;
    paramByteBuffer.get(arrayOfByte, paramPLBufferInfo.offset, i);
    paramByteBuffer.position(paramPLBufferInfo.offset);
    paramByteBuffer.put(this.p, 0, paramPLBufferInfo.size);
    paramByteBuffer.position(paramPLBufferInfo.offset);
  }
  
  public void c(boolean paramBoolean) {
    if (paramBoolean) {
      b b2 = this.J;
      b2.j++;
      return;
    } 
    b b1 = this.J;
    b1.i++;
  }
  
  public int d(g paramg) {
    int i;
    if (!d().t())
      d().a(a.a.a.a.a.a.b.c.e, null); 
    if (h.a(paramg.a)) {
      if (h.d(paramg.a)) {
        d(paramg.d.mBuffer, paramg.a);
        PLDroidStreamingCore pLDroidStreamingCore = this.g;
        ByteBuffer byteBuffer = this.E;
        PLBufferInfo pLBufferInfo = paramg.a;
        i = pLBufferInfo.size;
        i = pLDroidStreamingCore.sendFrame(byteBuffer, this.F + i, pLBufferInfo.presentationTimeUs / 1000L, pLBufferInfo.dtsUs / 1000L, true, true, paramg.f);
      } else {
        PLDroidStreamingCore pLDroidStreamingCore = this.g;
        ByteBuffer byteBuffer = paramg.d.mBuffer;
        PLBufferInfo pLBufferInfo = paramg.a;
        i = pLDroidStreamingCore.sendFrame(byteBuffer, pLBufferInfo.size, pLBufferInfo.presentationTimeUs / 1000L, pLBufferInfo.dtsUs / 1000L, true, true, paramg.f);
      } 
    } else {
      PLDroidStreamingCore pLDroidStreamingCore = this.g;
      ByteBuffer byteBuffer = paramg.d.mBuffer;
      PLBufferInfo pLBufferInfo = paramg.a;
      i = pLDroidStreamingCore.sendFrame(byteBuffer, pLBufferInfo.size, pLBufferInfo.presentationTimeUs / 1000L, pLBufferInfo.dtsUs / 1000L, true, h.a(pLBufferInfo), paramg.f);
    } 
    if (i == 0) {
      b b1 = this.J;
      b1.o++;
      b1 = this.J;
      b1.u++;
    } 
    return i;
  }
  
  public a.a.a.a.a.a.b d() {
    return this.y;
  }
  
  public void d(ByteBuffer paramByteBuffer, PLBufferInfo paramPLBufferInfo) {
    if (this.E == null && h.d(paramPLBufferInfo)) {
      ByteBuffer byteBuffer1 = ByteBuffer.allocateDirect(paramByteBuffer.capacity());
      this.E = byteBuffer1;
      byteBuffer1.clear();
      byteBuffer1 = this.E;
      byte[] arrayOfByte = this.p;
      byteBuffer1.put(arrayOfByte, 0, arrayOfByte.length);
    } 
    ByteBuffer byteBuffer = this.E;
    if (byteBuffer != null) {
      byteBuffer.position(this.F);
      this.E.put(paramByteBuffer);
    } 
  }
  
  public boolean d(int paramInt) {
    if (h()) {
      if (paramInt == PLDroidStreamingCore.ERROR_CODE_TIME_OUT) {
        d().a(a.a.a.a.a.a.b.c.h, null);
        return false;
      } 
      if (paramInt == PLDroidStreamingCore.ERROR_CODE_DISCONNECTED || c()) {
        a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ERROR_CODE_DISCONNECTED remote ip:");
        stringBuilder.append(this.g.getRemoteIP());
        stringBuilder.append(",path:");
        stringBuilder.append(this.g.getPath());
        e1.d("Muxer", stringBuilder.toString());
        d().a(a.a.a.a.a.a.b.c.i, null);
        return false;
      } 
      if (paramInt == PLDroidStreamingCore.ERROR_CODE_UNAUTHORIZED_URL) {
        d().a(a.a.a.a.a.a.b.c.p, null);
        return false;
      } 
    } 
    return true;
  }
  
  public b e() {
    return this.J;
  }
  
  public void e(int paramInt) {
    b b1 = this.J;
    b1.z += paramInt;
    b1 = this.J;
    b1.A++;
  }
  
  public void e(g paramg) {
    this.G.add(paramg);
    f(paramg);
  }
  
  public final void f(int paramInt) {}
  
  public final void f(g paramg) {
    if (paramg.a != null) {
      b b1 = this.J;
      b1.B += paramg.a.size;
    } 
  }
  
  public boolean f() {
    synchronized (this.h) {
      return this.i;
    } 
  }
  
  public final void g(int paramInt) {
    StreamingProfile.StreamStatus streamStatus = d().f().getStreamStatus();
    paramInt /= 1000;
    long l1 = this.J.e;
    long l2 = paramInt;
    streamStatus.audioFps = (int)(l1 / l2);
    streamStatus.videoFps = (int)(this.J.f / l2);
    streamStatus.totalAVBitrate = (int)((this.J.g + this.J.h) * 8L / l2);
    streamStatus.audioBitrate = (int)(this.J.g * 8L / l2);
    streamStatus.videoBitrate = (int)(this.J.h * 8L / l2);
    streamStatus.totalAVBitrateProduce = (int)(this.J.B * 8L / l2);
    this.J.p = (int)this.J.i / paramInt;
    this.J.q = (int)this.J.j / paramInt;
    this.J.r = (int)this.J.n / paramInt;
    this.J.s = (int)this.J.o / paramInt;
    if (this.J.A > 0)
      streamStatus.meanTcpSendTimeInMilliseconds = this.J.z / this.J.A; 
    this.J.A = 0;
    this.J.z = 0;
  }
  
  public final void g(g paramg) {
    if (paramg.a != null) {
      int i = paramg.b;
      if (i == 0) {
        b b1 = this.J;
        b1.e++;
        b1 = this.J;
        b1.g += paramg.a.size;
        b1 = this.J;
        b1.x += paramg.a.size;
      } else if (i == 1) {
        b b1 = this.J;
        b1.f++;
        b1 = this.J;
        b1.h += paramg.a.size;
        b1 = this.J;
        b1.y += paramg.a.size;
      } 
      if (!this.K) {
        this.K = true;
        e e1 = this.M;
        if (e1 != null)
          e1.sendMessage(e1.obtainMessage(0)); 
      } 
    } 
  }
  
  public boolean g() {
    return (this.v == this.r);
  }
  
  public boolean h() {
    synchronized (this.s) {
      int i = this.r;
      boolean bool2 = false;
      boolean bool1 = false;
      if (i == 1) {
        if (this.t || this.u)
          bool1 = true; 
        return bool1;
      } 
      if (this.r == 2) {
        bool1 = bool2;
        if (this.t) {
          bool1 = bool2;
          if (this.u)
            bool1 = true; 
        } 
        return bool1;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unsupported mExpectedNumTracks:");
      stringBuilder.append(this.r);
      throw new IllegalStateException(stringBuilder.toString());
    } 
  }
  
  public boolean i() {
    int i = a.a[this.y.h().ordinal()];
    return !(i != 1 && i != 2);
  }
  
  public g j() {
    try {
      g g = this.G.take();
      g(g);
      return g;
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
      return null;
    } 
  }
  
  public void k() {
    synchronized (this.h) {
      a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("try interrupt muxing thread mRunning: ");
      stringBuilder.append(this.j);
      stringBuilder.append(" mReady: ");
      stringBuilder.append(this.i);
      stringBuilder.append(" mIsIOError: ");
      stringBuilder.append(this.k);
      e1.d("Muxer", stringBuilder.toString());
      if (this.j) {
        if (!this.i && !this.k && this.Q != null && this.P != null) {
          e1 = a.a.a.a.a.e.e.f;
          stringBuilder = new StringBuilder();
          stringBuilder.append("interrupt muxing thread: ");
          stringBuilder.append(this.P.getId());
          e1.d("Muxer", stringBuilder.toString());
          this.Q.a();
          this.P.interrupt();
        } else {
          a.a.a.a.a.e.e.f.d("Muxer", "unable to interrupt under current situation");
        } 
      } else {
        a.a.a.a.a.e.e.f.d("Muxer", "muxing thread not started yet, then mark it unnecessary to start");
        this.R = true;
      } 
      return;
    } 
  }
  
  public void l() {
    synchronized (this.h) {
      this.R = false;
      return;
    } 
  }
  
  public void m() {
    if (this.g.isInitialized()) {
      a.a.a.a.a.e.e.f.e("Muxer", "Shutting down");
      synchronized (this.n) {
        boolean bool;
        if (this.o && c.c == d().h()) {
          bool = true;
        } else {
          bool = false;
        } 
        a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.f;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("released:");
        stringBuilder.append(bool);
        stringBuilder.append(",mStreamingPaused=");
        stringBuilder.append(this.C);
        e1.e("Muxer", stringBuilder.toString());
        this.g.shutDown(bool);
      } 
    } 
    this.E = null;
  }
  
  public long n() {
    StreamingProfile streamingProfile = d().f();
    return (streamingProfile == null || this.O || streamingProfile.getVideoProfile() == null || (streamingProfile.getVideoProfile()).reqFps == 0) ? 0L : ((streamingProfile.getVideoProfile()).maxKeyFrameInterval * 1000 / (streamingProfile.getVideoProfile()).reqFps);
  }
  
  public final void o() {
    this.J.e = 0L;
    this.J.f = 0L;
    this.J.g = 0L;
    this.J.h = 0L;
    this.J.i = 0L;
    this.J.j = 0L;
    this.J.k = 0L;
    this.J.l = 0L;
    this.J.m = 0L;
    this.J.n = 0L;
    this.J.o = 0L;
    this.J.B = 0L;
  }
  
  public final boolean p() {
    try {
      PLDroidStreamingCore.c c1;
      if (this instanceof a) {
        c1 = PLDroidStreamingCore.c.a;
      } else if (this instanceof b) {
        c1 = PLDroidStreamingCore.c.c;
      } else {
        c1 = PLDroidStreamingCore.c.b;
      } 
      PLDroidStreamingCore.AVOptions aVOptions = d().o();
      aVOptions.type = c1.ordinal();
      aVOptions.gopTimeMS = n();
      a(aVOptions);
      StreamingProfile streamingProfile = d().f();
      streamingProfile.setRtmpOptions("flashVer", a.a.a.a.a.e.d.b);
      aVOptions.rtmpOptions = d().f().getRtmpOptions();
      aVOptions.quicEnable = d().f().f();
      this.g.initCore(aVOptions);
      return false;
    } catch (a.a.a.a.a.f.d d1) {
      a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("PLMuxer.prepare():");
      stringBuilder.append(d1.getMessage());
      e1.e("Muxer", stringBuilder.toString());
      a(a.a.a.a.a.a.b.c.p, Integer.valueOf(PLDroidStreamingCore.ERROR_CODE_UNAUTHORIZED_URL));
      int i = PLDroidStreamingCore.ERROR_CODE_UNAUTHORIZED_URL;
      a(i, i);
    } catch (IOException iOException) {
      a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("PLMuxer.prepare():");
      stringBuilder.append(iOException.getMessage());
      e1.e("Muxer", stringBuilder.toString());
      a(a.a.a.a.a.a.b.c.g, Integer.valueOf(PLDroidStreamingCore.ERROR_CODE_TIME_OUT));
      int i = PLDroidStreamingCore.ERROR_CODE_TIME_OUT;
      a(i, i);
    } 
    return true;
  }
  
  public final void q() {
    synchronized (this.h) {
      this.i = false;
      this.h.notify();
      this.j = false;
      this.m = false;
      this.G.clear();
      this.p = null;
      this.q = null;
      synchronized (this.s) {
        this.t = false;
        this.u = false;
        null = this.M;
        if (null != null) {
          null.removeCallbacksAndMessages(null);
          this.M.a();
          this.M = null;
        } 
        this.K = false;
        o();
        return;
      } 
    } 
  }
  
  public class b {
    public int A;
    
    public long B;
    
    public boolean a;
    
    public boolean b;
    
    public long c;
    
    public long d;
    
    public long e;
    
    public long f;
    
    public long g;
    
    public long h;
    
    public long i;
    
    public long j;
    
    public long k;
    
    public long l;
    
    public long m;
    
    public long n;
    
    public long o;
    
    public int p;
    
    public int q;
    
    public int r;
    
    public int s;
    
    public long t;
    
    public long u;
    
    public long v;
    
    public long w;
    
    public long x;
    
    public long y;
    
    public int z;
    
    public b(c this$0) {}
  }
  
  public enum c {
    a, b, c, d;
    
    static {
      c c1 = new c("INVALID", 3);
      d = c1;
      e = new c[] { a, b, c, c1 };
    }
  }
  
  public static interface d {
    void a(PLAVFrame param1PLAVFrame, int param1Int);
  }
  
  public static class e extends Handler {
    public WeakReference<c> a;
    
    public e(Looper param1Looper, c param1c) {
      super(param1Looper);
      this.a = new WeakReference<c>(param1c);
    }
    
    public void a() {
      getLooper().quit();
      this.a.clear();
    }
    
    public void handleMessage(Message param1Message) {
      c c = this.a.get();
      if (c == null) {
        a.a.a.a.a.e.e.f.d("Muxer", "MuxerHandler.handleMessage: muxer is null");
        return;
      } 
      if (param1Message.what != 0)
        return; 
      int i = c.d().f().getStreamStatusConfig().getIntervalMs();
      c.a(c, i);
      StreamingProfile.StreamStatus streamStatus = c.d().f().getStreamStatus();
      if (c.d(c) != null)
        c.d(c).notifyStreamStatusChanged(streamStatus); 
      c.b b = c.e(c);
      if (b.b && System.currentTimeMillis() - b.c >= a.a.a.a.a.j.a.a().b()) {
        b.d = System.currentTimeMillis();
        Intent intent = new Intent("pldroid-qos-filter");
        intent.putExtra("pldroid-qos-msg-type", 161);
        intent.putExtra("beginAt", b.c);
        intent.putExtra("endAt", b.d);
        intent.putExtra("audioFps", streamStatus.audioFps);
        intent.putExtra("videoFps", streamStatus.videoFps);
        intent.putExtra("audioBitrate", streamStatus.audioBitrate);
        intent.putExtra("videoBitrate", streamStatus.videoBitrate);
        intent.putExtra("audioSourceFps", b.p);
        intent.putExtra("videoSourceFps", b.q);
        intent.putExtra("dropAudioFrameNum", b.k);
        intent.putExtra("dropVideoFrameNum", b.l);
        intent.putExtra("video_buffer_dropped_frames", b.m);
        intent.putExtra("sentAudioFps", b.r);
        intent.putExtra("sentVideoFps", b.s);
        a.a.a.a.a.j.a.a().a(intent);
        b.c = System.currentTimeMillis();
      } 
      c.f(c);
      sendMessageDelayed(obtainMessage(0), i);
    }
  }
  
  public class f extends Thread {
    public volatile boolean a;
    
    public f(c this$0) {}
    
    public void a() {
      this.a = true;
    }
    
    public void run() {
      a.a.a.a.a.e.e e = a.a.a.a.a.e.e.f;
      null = new StringBuilder();
      null.append("starting muxing thread: ");
      null.append(getId());
      e.c("Muxer", null.toString());
      if (!a.a.a.a.a.k.b.a())
        a.a.a.a.a.k.b.a(c.a(this.b)); 
      c c1 = this.b;
      c1.l = false;
      boolean bool = c.b(c1);
      synchronized (this.b.h) {
        if (this.a) {
          a.a.a.a.a.e.e.f.d("Muxer", "muxing thread got interrupted, return anyway.");
          return;
        } 
        this.b.k = bool;
        try {
          if (this.b.k) {
            a.a.a.a.a.e.e.f.e("Muxer", "Init streaming core failed.");
            return;
          } 
          this.b.i = true;
          this.b.h.notify();
          null = new HandlerThread("MuxerHt");
          null.start();
          c.a(this.b, new c.e(null.getLooper(), this.b));
          c.a(this.b, System.currentTimeMillis());
          this.b.d().a(a.a.a.a.a.a.b.c.c, null);
          null = new a(this);
          this.b.g.setOnErrorListener((PLDroidStreamingCore.b)null);
          this.b.b();
          if (!this.b.l)
            c.a(this.b, 0, 0); 
          c.c(this.b);
          this.b.m();
          this.b.d().a(a.a.a.a.a.a.b.c.f, null);
          return;
        } finally {
          this.b.h.notify();
        } 
      } 
    }
    
    public class a implements PLDroidStreamingCore.b {
      public a(c.f this$0) {}
      
      public void a(int param2Int, String param2String) {
        this.a.b.l = true;
        c.a(this.a.b, param2Int, param2Int);
      }
    }
  }
  
  public class a implements PLDroidStreamingCore.b {
    public a(c this$0) {}
    
    public void a(int param1Int, String param1String) {
      this.a.b.l = true;
      c.a(this.a.b, param1Int, param1Int);
    }
  }
  
  public static class g {
    public PLBufferInfo a;
    
    public int b;
    
    public int c;
    
    public PLAVFrame d;
    
    public long e;
    
    public String f;
    
    public g(int param1Int1, int param1Int2, PLAVFrame param1PLAVFrame, PLBufferInfo param1PLBufferInfo) {
      this(param1Int1, param1Int2, param1PLAVFrame, param1PLBufferInfo, null);
    }
    
    public g(int param1Int1, int param1Int2, PLAVFrame param1PLAVFrame, PLBufferInfo param1PLBufferInfo, String param1String) {
      this.b = param1Int1;
      this.c = param1Int2;
      this.d = param1PLAVFrame;
      this.e = System.currentTimeMillis();
      PLBufferInfo pLBufferInfo = new PLBufferInfo();
      this.a = pLBufferInfo;
      this.f = param1String;
      if (param1PLBufferInfo != null) {
        pLBufferInfo.set(param1PLBufferInfo.offset, param1PLBufferInfo.size, param1PLBufferInfo.presentationTimeUs, param1PLBufferInfo.dtsUs, param1PLBufferInfo.flags);
        this.a.isNeedAddHeader = param1PLBufferInfo.isNeedAddHeader;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\i\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */