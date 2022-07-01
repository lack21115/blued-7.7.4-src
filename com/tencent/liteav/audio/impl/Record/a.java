package com.tencent.liteav.audio.impl.Record;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class a implements Runnable {
  private WeakReference<c> a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private boolean e;
  
  private Thread f;
  
  private byte[] g;
  
  private void a(byte[] paramArrayOfbyte, int paramInt, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/lang/ref/WeakReference;
    //   6: ifnull -> 55
    //   9: aload_0
    //   10: getfield a : Ljava/lang/ref/WeakReference;
    //   13: invokevirtual get : ()Ljava/lang/Object;
    //   16: checkcast com/tencent/liteav/audio/impl/Record/c
    //   19: astore #5
    //   21: goto -> 24
    //   24: aload_0
    //   25: monitorexit
    //   26: aload #5
    //   28: ifnull -> 42
    //   31: aload #5
    //   33: aload_1
    //   34: iload_2
    //   35: lload_3
    //   36: invokeinterface onAudioRecordPCM : ([BIJ)V
    //   41: return
    //   42: ldc 'AudioCenter:TXCAudioBGMRecord'
    //   44: ldc 'onRecordPcmData:no callback'
    //   46: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   49: return
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    //   55: aconst_null
    //   56: astore #5
    //   58: goto -> 24
    // Exception table:
    //   from	to	target	type
    //   2	21	50	finally
    //   24	26	50	finally
    //   51	53	50	finally
  }
  
  private void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/lang/ref/WeakReference;
    //   6: ifnull -> 49
    //   9: aload_0
    //   10: getfield a : Ljava/lang/ref/WeakReference;
    //   13: invokevirtual get : ()Ljava/lang/Object;
    //   16: checkcast com/tencent/liteav/audio/impl/Record/c
    //   19: astore_1
    //   20: goto -> 23
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: ifnull -> 36
    //   29: aload_1
    //   30: invokeinterface onAudioRecordStart : ()V
    //   35: return
    //   36: ldc 'AudioCenter:TXCAudioBGMRecord'
    //   38: ldc 'onRecordStart:no callback'
    //   40: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   43: return
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    //   49: aconst_null
    //   50: astore_1
    //   51: goto -> 23
    // Exception table:
    //   from	to	target	type
    //   2	20	44	finally
    //   23	25	44	finally
    //   45	47	44	finally
  }
  
  private void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/lang/ref/WeakReference;
    //   6: ifnull -> 49
    //   9: aload_0
    //   10: getfield a : Ljava/lang/ref/WeakReference;
    //   13: invokevirtual get : ()Ljava/lang/Object;
    //   16: checkcast com/tencent/liteav/audio/impl/Record/c
    //   19: astore_1
    //   20: goto -> 23
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: ifnull -> 36
    //   29: aload_1
    //   30: invokeinterface onAudioRecordStop : ()V
    //   35: return
    //   36: ldc 'AudioCenter:TXCAudioBGMRecord'
    //   38: ldc 'onRecordStop:no callback'
    //   40: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   43: return
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    //   49: aconst_null
    //   50: astore_1
    //   51: goto -> 23
    // Exception table:
    //   from	to	target	type
    //   2	20	44	finally
    //   23	25	44	finally
    //   45	47	44	finally
  }
  
  public void a() {
    this.e = false;
    long l = System.currentTimeMillis();
    Thread thread = this.f;
    if (thread != null && thread.isAlive() && Thread.currentThread().getId() != this.f.getId())
      try {
        this.f.join();
      } catch (Exception exception) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("record stop Exception: ");
        stringBuilder1.append(exception.getMessage());
        TXCLog.e("AudioCenter:TXCAudioBGMRecord", stringBuilder1.toString());
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("stop record cost time(MS): ");
    stringBuilder.append(System.currentTimeMillis() - l);
    TXCLog.i("AudioCenter:TXCAudioBGMRecord", stringBuilder.toString());
    this.f = null;
  }
  
  public void run() {
    if (!this.e) {
      TXCLog.w("AudioCenter:TXCAudioBGMRecord", "audio record: abandom start audio sys record thread!");
      return;
    } 
    b();
    int i = this.b;
    int j = this.c;
    int k = this.d;
    int m = j * 1024 * k / 8;
    this.g = new byte[m];
    Arrays.fill(this.g, (byte)0);
    long l1 = 0L;
    long l2 = System.currentTimeMillis();
    while (true) {
      if (this.e && !Thread.interrupted()) {
        if ((System.currentTimeMillis() - l2) * i * j * k / 8L / 1000L - l1 < m) {
          try {
            Thread.sleep(10L);
          } catch (InterruptedException interruptedException) {}
          continue;
        } 
        byte[] arrayOfByte = this.g;
        l1 += arrayOfByte.length;
        a(arrayOfByte, arrayOfByte.length, TXCTimeUtil.getTimeTick());
        continue;
      } 
      c();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\tencent\liteav\audio\impl\Record\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */