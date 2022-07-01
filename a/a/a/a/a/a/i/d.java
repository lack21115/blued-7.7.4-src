package a.a.a.a.a.a.i;

import a.a.a.a.a.a.b;
import a.a.a.a.a.a.f.a;
import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import a.a.a.a.a.m.a;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import com.qiniu.pili.droid.streaming.av.common.PLAVFrame;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import com.qiniu.pili.droid.streaming.core.PLDroidStreamingCore;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class d extends c {
  public long S;
  
  public long T;
  
  public long U;
  
  public long V;
  
  public long W;
  
  public long X;
  
  public long Y;
  
  public boolean Z = false;
  
  public long a;
  
  public d() {
    super(1);
  }
  
  public d(int paramInt) {
    super(paramInt);
  }
  
  public final void a(int paramInt1, int paramInt2, PLAVFrame paramPLAVFrame) {
    c.b b = e();
    b.m++;
    a(paramInt1, paramPLAVFrame, paramInt2);
    e.f.d("PLVideoMuxer", "GOP dropping, non I frame dropped.");
  }
  
  public void a(int paramInt1, int paramInt2, PLAVFrame paramPLAVFrame, PLBufferInfo paramPLBufferInfo) {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: aload_3
    //   4: aload #4
    //   6: invokespecial a : (IILcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;)V
    //   9: aload_0
    //   10: getfield h : Ljava/lang/Object;
    //   13: astore #6
    //   15: aload #6
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield i : Z
    //   22: ifeq -> 373
    //   25: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   28: astore #5
    //   30: new java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial <init> : ()V
    //   37: astore #7
    //   39: aload #7
    //   41: ldc 'writeSampleData ===='
    //   43: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload #7
    //   49: iload_1
    //   50: invokestatic valueOf : (I)Ljava/lang/String;
    //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload #7
    //   59: ldc ',frame.mBuffer:'
    //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload #7
    //   67: aload_3
    //   68: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   71: invokevirtual toString : ()Ljava/lang/String;
    //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload #5
    //   80: ldc 'PLVideoMuxer'
    //   82: aload #7
    //   84: invokevirtual toString : ()Ljava/lang/String;
    //   87: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: iload_1
    //   92: iload_2
    //   93: aload_3
    //   94: aload #4
    //   96: invokevirtual b : (IILcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;)Z
    //   99: ifeq -> 106
    //   102: aload #6
    //   104: monitorexit
    //   105: return
    //   106: aload_0
    //   107: invokevirtual t : ()V
    //   110: aload_0
    //   111: invokevirtual w : ()V
    //   114: aload_0
    //   115: iload_1
    //   116: iload_2
    //   117: aload_3
    //   118: aload #4
    //   120: invokevirtual b : (IILcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;)Z
    //   123: ifeq -> 130
    //   126: aload #6
    //   128: monitorexit
    //   129: return
    //   130: invokestatic c : ()Z
    //   133: ifeq -> 164
    //   136: iload_1
    //   137: iconst_1
    //   138: if_icmpne -> 164
    //   141: aload #4
    //   143: invokestatic b : (Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;)Z
    //   146: ifne -> 164
    //   149: aload_0
    //   150: iload_1
    //   151: iload_2
    //   152: aload_3
    //   153: invokevirtual a : (IILcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;)V
    //   156: aload_0
    //   157: invokevirtual v : ()V
    //   160: aload #6
    //   162: monitorexit
    //   163: return
    //   164: aload #4
    //   166: invokestatic a : (Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;)Z
    //   169: ifeq -> 221
    //   172: aload_0
    //   173: getfield I : La/a/a/a/a/a/f/a;
    //   176: astore #7
    //   178: aload #7
    //   180: monitorenter
    //   181: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   184: ldc 'PLVideoMuxer'
    //   186: ldc 'key frame.....'
    //   188: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload_0
    //   192: getfield I : La/a/a/a/a/a/f/a;
    //   195: aload_3
    //   196: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   199: invokevirtual capacity : ()I
    //   202: invokevirtual a : (I)Lcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;
    //   205: astore #5
    //   207: aload #7
    //   209: monitorexit
    //   210: goto -> 256
    //   213: astore #4
    //   215: aload #7
    //   217: monitorexit
    //   218: aload #4
    //   220: athrow
    //   221: aload_0
    //   222: getfield H : Ljava/util/ArrayList;
    //   225: astore #7
    //   227: aload #7
    //   229: monitorenter
    //   230: aload_0
    //   231: getfield H : Ljava/util/ArrayList;
    //   234: iload_1
    //   235: invokevirtual get : (I)Ljava/lang/Object;
    //   238: checkcast a/a/a/a/a/a/f/a
    //   241: aload_3
    //   242: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   245: invokevirtual capacity : ()I
    //   248: invokevirtual a : (I)Lcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;
    //   251: astore #5
    //   253: aload #7
    //   255: monitorexit
    //   256: aload #5
    //   258: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   261: invokevirtual clear : ()Ljava/nio/Buffer;
    //   264: pop
    //   265: aload #5
    //   267: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   270: aload_3
    //   271: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   274: invokevirtual put : (Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   277: pop
    //   278: aload #5
    //   280: getfield mBuffer : Ljava/nio/ByteBuffer;
    //   283: iconst_0
    //   284: invokevirtual position : (I)Ljava/nio/Buffer;
    //   287: pop
    //   288: aload_0
    //   289: iload_1
    //   290: aload_3
    //   291: iload_2
    //   292: invokevirtual a : (ILcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;I)V
    //   295: aload_0
    //   296: getfield C : Z
    //   299: ifeq -> 324
    //   302: aload #4
    //   304: invokestatic c : (Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;)Z
    //   307: ifeq -> 324
    //   310: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   313: ldc 'PLVideoMuxer'
    //   315: ldc 'ignore the eos frame when streaming paused'
    //   317: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   320: aload #6
    //   322: monitorexit
    //   323: return
    //   324: aload_0
    //   325: new a/a/a/a/a/a/i/c$g
    //   328: dup
    //   329: iload_1
    //   330: iload_2
    //   331: aload #5
    //   333: aload #4
    //   335: invokespecial <init> : (IILcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;Lcom/qiniu/pili/droid/streaming/av/common/PLBufferInfo;)V
    //   338: invokevirtual e : (La/a/a/a/a/a/i/c$g;)V
    //   341: goto -> 390
    //   344: astore #4
    //   346: aload #7
    //   348: monitorexit
    //   349: aload #4
    //   351: athrow
    //   352: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   355: ldc 'PLVideoMuxer'
    //   357: ldc 'OOM exception!'
    //   359: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   362: aload_0
    //   363: iload_1
    //   364: aload_3
    //   365: iload_2
    //   366: invokevirtual a : (ILcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;I)V
    //   369: aload #6
    //   371: monitorexit
    //   372: return
    //   373: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   376: ldc 'PLVideoMuxer'
    //   378: ldc 'Dropping frame because Muxer not ready!'
    //   380: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload_0
    //   384: iload_1
    //   385: aload_3
    //   386: iload_2
    //   387: invokevirtual a : (ILcom/qiniu/pili/droid/streaming/av/common/PLAVFrame;I)V
    //   390: aload #6
    //   392: monitorexit
    //   393: return
    //   394: astore_3
    //   395: aload #6
    //   397: monitorexit
    //   398: aload_3
    //   399: athrow
    //   400: astore #4
    //   402: goto -> 352
    // Exception table:
    //   from	to	target	type
    //   18	30	394	finally
    //   30	105	394	finally
    //   106	129	394	finally
    //   130	136	394	finally
    //   141	163	394	finally
    //   164	181	400	java/lang/OutOfMemoryError
    //   164	181	394	finally
    //   181	210	213	finally
    //   215	218	213	finally
    //   218	221	400	java/lang/OutOfMemoryError
    //   218	221	394	finally
    //   221	230	400	java/lang/OutOfMemoryError
    //   221	230	394	finally
    //   230	256	344	finally
    //   256	323	394	finally
    //   324	341	394	finally
    //   346	349	344	finally
    //   349	352	400	java/lang/OutOfMemoryError
    //   349	352	394	finally
    //   352	372	394	finally
    //   373	390	394	finally
    //   390	393	394	finally
    //   395	398	394	finally
  }
  
  public void a(PLBufferInfo paramPLBufferInfo, PLAVFrame paramPLAVFrame, int paramInt1, int paramInt2) {
    synchronized (this.n) {
      if (!this.o) {
        e.f.a("PLVideoMuxer", "releaseOutputBufer encodedData.clear()!");
        paramPLAVFrame.mBuffer.clear();
        if (h.a(paramPLBufferInfo)) {
          e e = e.f;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("mMuxerInputKeyFrameQueue.add encodedData:");
          stringBuilder.append(paramPLAVFrame.mBuffer);
          e.a("PLVideoMuxer", stringBuilder.toString());
          this.I.a(paramPLAVFrame);
        } else {
          synchronized (this.H) {
            ((a)this.H.get(paramInt2)).a(paramPLAVFrame);
          } 
        } 
      } 
      return;
    } 
  }
  
  public boolean a(b paramb) {
    e.f.c("PLVideoMuxer", "prepare");
    if (this.C) {
      e.f.c("PLVideoMuxer", "mStreamingPaused");
      return false;
    } 
    super.a(paramb);
    d().a(b.c.b, null);
    r();
    this.X = 0L;
    u();
    s();
    a("PLVideoMuxer");
    return this.k ^ true;
  }
  
  public int a_(c.g paramg) {
    return 0;
  }
  
  public void b() {
    while (true) {
      e e = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("working mStop:");
      stringBuilder.append(this.m);
      stringBuilder.append(",mStreamingPaused:");
      stringBuilder.append(this.C);
      e.a("PLVideoMuxer", stringBuilder.toString());
      c.g g = j();
      if (!this.m) {
        if (g.d == null)
          return; 
        e e1 = e.f;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("consume packet:");
        stringBuilder1.append(g);
        e1.a("PLVideoMuxer", stringBuilder1.toString());
        if (c(g) < 0)
          return; 
        if (h.b(g.a)) {
          e1 = e.f;
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("handling BUFFER_FLAG_CODEC_CONFIG for track ");
          stringBuilder1.append(g.b);
          e1.c("PLVideoMuxer", stringBuilder1.toString());
          if (g.a.size > 0) {
            b(g);
            continue;
          } 
          e.f.e("PLVideoMuxer", "error config buffer");
          return;
        } 
        if (!g()) {
          int i = -1;
          long l = System.currentTimeMillis();
          int j = g.b;
          if (j == 0) {
            i = a_(g);
          } else if (j == 1) {
            i = d(g);
          } 
          e((int)(System.currentTimeMillis() - l));
          a(g.a, g.d, g.c, g.b);
          if (!d(i))
            return; 
        } else {
          a(g.a, g.d, g.c, g.b);
        } 
        if (!this.C && g()) {
          e.f.c("PLVideoMuxer", "Shutting down on last frame");
          break;
        } 
        continue;
      } 
      break;
    } 
  }
  
  public void b(c.g paramg) {
    if (paramg.b == 1) {
      e.f.b("PLVideoMuxer", "Capture SPS + PPS");
      c(paramg.d.mBuffer, paramg.a);
      PLDroidStreamingCore pLDroidStreamingCore = this.g;
      byte[] arrayOfByte = this.p;
      pLDroidStreamingCore.writeVideoSeqHeader(arrayOfByte, arrayOfByte.length, paramg.a.presentationTimeUs / 1000L);
    } 
    if (this.p != null) {
      d().a(b.c.d, null);
      e e = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("writeHeader :mIsNeedUpdateAVOption=");
      stringBuilder.append(this.D);
      e.c("PLVideoMuxer", stringBuilder.toString());
    } 
    a(paramg.a, paramg.d, paramg.c, paramg.b);
  }
  
  public final boolean b(int paramInt1, int paramInt2, PLAVFrame paramPLAVFrame, PLBufferInfo paramPLBufferInfo) {
    if (this.Z) {
      if (h.a(paramPLBufferInfo)) {
        this.Z = false;
        e.f.d("PLVideoMuxer", "GOP dropping done, met next I frame.");
        return false;
      } 
      a(paramInt1, paramInt2, paramPLAVFrame);
      return true;
    } 
    return false;
  }
  
  public void r() {
    this.i = false;
    this.p = null;
    this.q = null;
    this.F = -1;
    this.o = false;
    this.Z = false;
    a.a().b();
    a.a().a(d().f().a());
  }
  
  public void s() {
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mMuxerAVFrameInputPool:");
    stringBuilder.append(this.H);
    stringBuilder.append(",mMuxerInputKeyFramePool:");
    stringBuilder.append(this.I);
    e.c("PLVideoMuxer", stringBuilder.toString());
    try {
      this.H.clear();
    } catch (NullPointerException nullPointerException) {
      e.f.d("PLVideoMuxer", "mPacketDataQueue or mMuxerInputQueue is null");
    } 
    ArrayList<a> arrayList = this.H;
    if (arrayList == null) {
      this.H = new ArrayList<a>();
    } else {
      arrayList.clear();
    } 
    if (this.I == null)
      this.I = new a(3); 
    for (int i = 0; i < 2; i++)
      this.H.add(new a(10)); 
  }
  
  public void t() {
    if (System.currentTimeMillis() - this.S < 1000L)
      return; 
    this.S = System.currentTimeMillis();
    try {
      c.g g1 = this.G.peekFirst();
      c.g g2 = this.G.peekLast();
      if (g1 != null && g2 != null) {
        this.Y = g2.a.presentationTimeUs - g1.a.presentationTimeUs;
        if (h.b()) {
          e.f.d("PLVideoMuxer", "Drop frame due to low memory.");
          d().a(b.c.k, null);
          this.G.removeLast();
          v();
          this.X = 0L;
          return;
        } 
        if (this.Y > 0L && this.Y <= this.T) {
          if (this.X == 0L)
            this.X = g2.e; 
          if (g2.e - this.X >= this.W) {
            e.f.c("PLVideoMuxer", "11 Gooooooooooooooooooooooood");
            this.X = 0L;
            d().a(b.c.l, null);
            return;
          } 
        } else {
          if (this.Y >= this.T && this.Y < this.U) {
            this.X = 0L;
            e e = e.f;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Baaaaaaaaaaaaaaaaaaaaaaaaaaad:");
            stringBuilder.append(this.G.size());
            e.c("PLVideoMuxer", stringBuilder.toString());
            d().a(b.c.m, null);
            return;
          } 
          if (this.Y >= this.V) {
            e.f.d("PLVideoMuxer", "Drop frame due to buffer time level full.");
            d().a(b.c.k, null);
            this.G.removeLast();
            v();
            this.X = 0L;
            return;
          } 
          this.X = 0L;
          return;
        } 
      } 
    } catch (NoSuchElementException noSuchElementException) {
      e e = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("No Such Element.");
      stringBuilder.append(noSuchElementException.getMessage());
      e.d("PLVideoMuxer", stringBuilder.toString());
    } 
  }
  
  public void u() {
    this.a = 0L;
    this.S = 0L;
    try {
      StreamingProfile.SendingBufferProfile sendingBufferProfile = d().f().getSendingBufferInfo();
      this.T = (long)(sendingBufferProfile.getLowThreshold() * 1000.0F);
      this.U = (long)(sendingBufferProfile.getHighThreshold() * 1000.0F);
      this.V = (long)(sendingBufferProfile.getDurationLimit() * 1000.0F);
      this.W = sendingBufferProfile.getLowThresholdTimeout();
    } catch (NullPointerException nullPointerException) {
      e.f.d("PLVideoMuxer", "NPE. Use the default sendingBufferInfo values!");
      this.T = 200L;
      this.U = 800L;
      this.V = 3000L;
      this.W = 60000L;
    } 
    e e = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mBufferTimeLevelLow:");
    stringBuilder.append(this.T);
    stringBuilder.append(",mBufferTimeLevelHigh:");
    stringBuilder.append(this.U);
    stringBuilder.append(",mBufferTimeLevelFull:");
    stringBuilder.append(this.V);
    stringBuilder.append(",mBufferTimeLevelLowTimeout:");
    stringBuilder.append(this.W);
    e.c("PLVideoMuxer", stringBuilder.toString());
  }
  
  public final void v() {
    this.Z = true;
    e.f.d("PLVideoMuxer", "GOP dropping start.");
  }
  
  public final void w() {
    if (System.currentTimeMillis() - this.a < 1000L)
      return; 
    a.a().a(d());
    this.a = System.currentTimeMillis();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\i\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */