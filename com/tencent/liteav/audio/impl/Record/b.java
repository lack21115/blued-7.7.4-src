package com.tencent.liteav.audio.impl.Record;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.liteav.audio.g;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Vector;

public class b extends Thread {
  private MediaCodec.BufferInfo a;
  
  private MediaCodecInfo b;
  
  private MediaFormat c;
  
  private MediaCodec d;
  
  private Vector<byte[]> e;
  
  private WeakReference<g> f;
  
  private volatile boolean g = false;
  
  private volatile boolean h = false;
  
  private final Object i = new Object();
  
  private long j = 0L;
  
  private int k = 48000;
  
  private int l = 1;
  
  private int m = 16;
  
  private byte[] n;
  
  static {
    g.f();
  }
  
  public b() {
    super("TXAudioRecordThread");
  }
  
  private static final MediaCodecInfo a(String paramString) {
    TXCLog.v("AudioCenter:TXCAudioHWEncoder", "selectAudioCodec:");
    int j = MediaCodecList.getCodecCount();
    for (int i = 0; i < j; i++) {
      MediaCodecInfo mediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (mediaCodecInfo.isEncoder()) {
        String[] arrayOfString = mediaCodecInfo.getSupportedTypes();
        for (int k = 0; k < arrayOfString.length; k++) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("supportedType:");
          stringBuilder.append(mediaCodecInfo.getName());
          stringBuilder.append(",MIME=");
          stringBuilder.append(arrayOfString[k]);
          TXCLog.i("AudioCenter:TXCAudioHWEncoder", stringBuilder.toString());
          if (arrayOfString[k].equalsIgnoreCase(paramString))
            return mediaCodecInfo; 
        } 
      } 
    } 
    return null;
  }
  
  private void a(ByteBuffer paramByteBuffer, int paramInt, long paramLong) {
    if (this.h)
      return; 
    ByteBuffer[] arrayOfByteBuffer2 = this.d.getInputBuffers();
    int i = this.d.dequeueInputBuffer(10000L);
    if (i >= 0) {
      ByteBuffer byteBuffer = arrayOfByteBuffer2[i];
      byteBuffer.clear();
      if (paramByteBuffer != null)
        byteBuffer.put(paramByteBuffer); 
      if (paramInt <= 0) {
        TXCLog.i("AudioCenter:TXCAudioHWEncoder", "send BUFFER_FLAG_END_OF_STREAM");
        this.d.queueInputBuffer(i, 0, 0, paramLong, 4);
      } else {
        this.d.queueInputBuffer(i, 0, paramInt, paramLong, 0);
      } 
    } 
    ByteBuffer[] arrayOfByteBuffer1 = this.d.getOutputBuffers();
    do {
      paramInt = this.d.dequeueOutputBuffer(this.a, 10000L);
      if (paramInt == -1)
        continue; 
      if (paramInt == -3) {
        arrayOfByteBuffer1 = this.d.getOutputBuffers();
      } else if (paramInt == -2) {
        this.d.getOutputFormat();
      } else if (paramInt >= 0) {
        ByteBuffer byteBuffer = arrayOfByteBuffer1[paramInt];
        if ((this.a.flags & 0x2) != 0) {
          TXCLog.d("AudioCenter:TXCAudioHWEncoder", "drain:BUFFER_FLAG_CODEC_CONFIG");
          this.a.size = 0;
        } 
        if (this.a.size != 0) {
          this.a.presentationTimeUs = f();
          this.n = new byte[byteBuffer.limit()];
          byteBuffer.get(this.n);
          b(this.n, this.a.presentationTimeUs);
          this.j = this.a.presentationTimeUs;
        } 
        this.d.releaseOutputBuffer(paramInt, false);
      } 
    } while (paramInt >= 0);
  }
  
  private void b() {
    this.b = a("audio/mp4a-latm");
    if (this.b == null) {
      TXCLog.e("AudioCenter:TXCAudioHWEncoder", "Unable to find an appropriate codec for audio/mp4a-latm");
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("selected codec: ");
    stringBuilder.append(this.b.getName());
    TXCLog.i("AudioCenter:TXCAudioHWEncoder", stringBuilder.toString());
    int i = this.k;
    char c = '紀';
    if (i >= 32000)
      c = '切'; 
    this.c = MediaFormat.createAudioFormat("audio/mp4a-latm", this.k, this.l);
    this.c.setInteger("bitrate", c);
    this.c.setInteger("channel-count", this.l);
    this.c.setInteger("sample-rate", this.k);
    this.c.setInteger("aac-profile", 2);
    stringBuilder = new StringBuilder();
    stringBuilder.append("format: ");
    stringBuilder.append(this.c);
    TXCLog.i("AudioCenter:TXCAudioHWEncoder", stringBuilder.toString());
    try {
      d();
    } catch (Exception exception) {
      TXCLog.e("AudioCenter:TXCAudioHWEncoder", "start media codec failed.", exception);
    } 
    start();
  }
  
  private void b(byte[] paramArrayOfbyte, long paramLong) {
    WeakReference<g> weakReference = this.f;
    if (weakReference != null) {
      g g = weakReference.get();
      if (g != null)
        g.onRecordEncData(paramArrayOfbyte, paramLong, this.k, this.l, this.m); 
    } 
  }
  
  private void c() {
    this.h = true;
  }
  
  private void d() throws IOException {
    if (this.d != null)
      return; 
    this.d = MediaCodec.createEncoderByType("audio/mp4a-latm");
    this.d.configure(this.c, null, null, 1);
    this.d.start();
    TXCLog.i("AudioCenter:TXCAudioHWEncoder", "prepare finishing");
    this.g = true;
  }
  
  private void e() {
    MediaCodec mediaCodec = this.d;
    if (mediaCodec != null) {
      mediaCodec.stop();
      this.d.release();
      this.d = null;
    } 
    this.g = false;
  }
  
  private long f() {
    long l2 = TXCTimeUtil.getTimeTick();
    long l3 = this.j;
    long l1 = l2;
    if (l2 < l3)
      l1 = l2 + l3 - l2; 
    return l1;
  }
  
  public void a() {
    c();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, WeakReference<g> paramWeakReference) {
    this.f = paramWeakReference;
    this.a = new MediaCodec.BufferInfo();
    this.e = (Vector)new Vector<byte>();
    this.k = paramInt2;
    this.l = paramInt3;
    this.m = paramInt4;
    b();
  }
  
  public void a(byte[] paramArrayOfbyte, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: getfield e : Ljava/util/Vector;
    //   4: astore #4
    //   6: aload #4
    //   8: ifnull -> 50
    //   11: aload_1
    //   12: ifnull -> 50
    //   15: aload #4
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield e : Ljava/util/Vector;
    //   22: ifnonnull -> 29
    //   25: aload #4
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield e : Ljava/util/Vector;
    //   33: aload_1
    //   34: invokevirtual add : (Ljava/lang/Object;)Z
    //   37: pop
    //   38: aload #4
    //   40: monitorexit
    //   41: goto -> 50
    //   44: astore_1
    //   45: aload #4
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    //   50: aload_0
    //   51: getfield i : Ljava/lang/Object;
    //   54: astore_1
    //   55: aload_1
    //   56: monitorenter
    //   57: aload_0
    //   58: getfield i : Ljava/lang/Object;
    //   61: invokevirtual notify : ()V
    //   64: aload_1
    //   65: monitorexit
    //   66: return
    //   67: astore #4
    //   69: aload_1
    //   70: monitorexit
    //   71: aload #4
    //   73: athrow
    // Exception table:
    //   from	to	target	type
    //   18	28	44	finally
    //   29	41	44	finally
    //   45	48	44	finally
    //   57	66	67	finally
    //   69	71	67	finally
  }
  
  public void run() {
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
    while (true) {
      if (!this.h) {
        if (this.g) {
          synchronized (this.e) {
            ByteBuffer byteBuffer1;
            boolean bool = this.e.isEmpty();
            if (bool) {
              try {
                Thread.sleep(10L);
              } catch (InterruptedException interruptedException) {}
              continue;
            } 
            synchronized (this.e) {
              byte[] arrayOfByte = this.e.remove(0);
              if (arrayOfByte != null) {
                ByteBuffer byteBuffer2 = byteBuffer;
                try {
                  byteBuffer.clear();
                  byteBuffer1 = byteBuffer;
                  byteBuffer2 = byteBuffer;
                  if (arrayOfByte.length > byteBuffer.capacity()) {
                    byteBuffer2 = byteBuffer;
                    byteBuffer1 = ByteBuffer.allocateDirect(arrayOfByte.length);
                  } 
                  byteBuffer2 = byteBuffer1;
                  byteBuffer1.clear();
                  byteBuffer2 = byteBuffer1;
                  byteBuffer1.put(arrayOfByte);
                  byteBuffer2 = byteBuffer1;
                  byteBuffer1.flip();
                  byteBuffer2 = byteBuffer1;
                  a(byteBuffer1, arrayOfByte.length, f());
                  byteBuffer = byteBuffer1;
                } catch (Exception exception) {
                  TXCLog.e("AudioCenter:TXCAudioHWEncoder", "encode frame failed.", exception);
                  ByteBuffer byteBuffer3 = byteBuffer2;
                } 
              } 
            } 
          } 
          continue;
        } 
        synchronized (this.i) {
          this.i.wait();
        } 
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_3} */
        continue;
      } 
      e();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\tencent\liteav\audio\impl\Record\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */