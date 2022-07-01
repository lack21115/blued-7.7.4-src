package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import android.media.AudioRecord;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class TXCAudioSysRecord implements Runnable {
  private static final String TAG;
  
  private static TXCAudioSysRecord instance = null;
  
  private int mAECType = 0;
  
  private int mBits = 16;
  
  private int mChannels = 1;
  
  private Context mContext;
  
  private boolean mIsCapFirstFrame = false;
  
  private boolean mIsRunning = false;
  
  private AudioRecord mMic;
  
  private AtomicBoolean mPause = new AtomicBoolean(false);
  
  private byte[] mRecordBuffer = null;
  
  private Thread mRecordThread = null;
  
  private int mSampleRate = 48000;
  
  private boolean mSendMuteData = false;
  
  private WeakReference<c> mWeakRefListener;
  
  private Object threadMutex = new Object();
  
  private TXCAudioSysRecord() {
    nativeClassInit();
  }
  
  public static TXCAudioSysRecord getInstance() {
    // Byte code:
    //   0: getstatic com/tencent/liteav/audio/impl/Record/TXCAudioSysRecord.instance : Lcom/tencent/liteav/audio/impl/Record/TXCAudioSysRecord;
    //   3: ifnonnull -> 37
    //   6: ldc com/tencent/liteav/audio/impl/Record/TXCAudioSysRecord
    //   8: monitorenter
    //   9: getstatic com/tencent/liteav/audio/impl/Record/TXCAudioSysRecord.instance : Lcom/tencent/liteav/audio/impl/Record/TXCAudioSysRecord;
    //   12: ifnonnull -> 25
    //   15: new com/tencent/liteav/audio/impl/Record/TXCAudioSysRecord
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/tencent/liteav/audio/impl/Record/TXCAudioSysRecord.instance : Lcom/tencent/liteav/audio/impl/Record/TXCAudioSysRecord;
    //   25: ldc com/tencent/liteav/audio/impl/Record/TXCAudioSysRecord
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/tencent/liteav/audio/impl/Record/TXCAudioSysRecord
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/tencent/liteav/audio/impl/Record/TXCAudioSysRecord.instance : Lcom/tencent/liteav/audio/impl/Record/TXCAudioSysRecord;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void init() {
    byte b;
    int k = this.mSampleRate;
    int m = this.mChannels;
    int n = this.mBits;
    int i = this.mAECType;
    TXCLog.i(TAG, String.format("audio record sampleRate = %d, channels = %d, bits = %d, aectype = %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i) }));
    if (m == 1) {
      i = 16;
    } else {
      i = 12;
    } 
    if (n == 8) {
      b = 3;
    } else {
      b = 2;
    } 
    int j = AudioRecord.getMinBufferSize(k, i, b);
    try {
      TXCLog.i(TAG, "audio record type: system normal");
      try {
        this.mMic = new AudioRecord(1, k, i, b, j * 2);
      } catch (IllegalArgumentException null) {}
    } catch (IllegalArgumentException illegalArgumentException) {}
    TXCLog.e(TAG, "create AudioRecord failed.", illegalArgumentException);
  }
  
  private native void nativeClassInit();
  
  private native void nativeSendSysRecordAudioData(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private void onRecordError(int paramInt, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mWeakRefListener : Ljava/lang/ref/WeakReference;
    //   6: ifnull -> 52
    //   9: aload_0
    //   10: getfield mWeakRefListener : Ljava/lang/ref/WeakReference;
    //   13: invokevirtual get : ()Ljava/lang/Object;
    //   16: checkcast com/tencent/liteav/audio/impl/Record/c
    //   19: astore_3
    //   20: goto -> 23
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_3
    //   26: ifnull -> 38
    //   29: aload_3
    //   30: iload_1
    //   31: aload_2
    //   32: invokeinterface onAudioRecordError : (ILjava/lang/String;)V
    //   37: return
    //   38: getstatic com/tencent/liteav/audio/impl/Record/TXCAudioSysRecord.TAG : Ljava/lang/String;
    //   41: ldc 'onRecordError:no callback'
    //   43: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   46: return
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    //   52: aconst_null
    //   53: astore_3
    //   54: goto -> 23
    // Exception table:
    //   from	to	target	type
    //   2	20	47	finally
    //   23	25	47	finally
    //   48	50	47	finally
  }
  
  private void onRecordPcmData(byte[] paramArrayOfbyte, int paramInt, long paramLong) {
    WeakReference<c> weakReference = this.mWeakRefListener;
    if (weakReference != null) {
      c c = weakReference.get();
    } else {
      weakReference = null;
    } 
    if (weakReference != null) {
      weakReference.onAudioRecordPCM(paramArrayOfbyte, paramInt, paramLong);
      return;
    } 
    TXCLog.e(TAG, "onRecordPcmData:no callback");
  }
  
  private void onRecordStart() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mWeakRefListener : Ljava/lang/ref/WeakReference;
    //   6: ifnull -> 50
    //   9: aload_0
    //   10: getfield mWeakRefListener : Ljava/lang/ref/WeakReference;
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
    //   36: getstatic com/tencent/liteav/audio/impl/Record/TXCAudioSysRecord.TAG : Ljava/lang/String;
    //   39: ldc 'onRecordStart:no callback'
    //   41: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    //   50: aconst_null
    //   51: astore_1
    //   52: goto -> 23
    // Exception table:
    //   from	to	target	type
    //   2	20	45	finally
    //   23	25	45	finally
    //   46	48	45	finally
  }
  
  private void onRecordStop() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mWeakRefListener : Ljava/lang/ref/WeakReference;
    //   6: ifnull -> 50
    //   9: aload_0
    //   10: getfield mWeakRefListener : Ljava/lang/ref/WeakReference;
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
    //   36: getstatic com/tencent/liteav/audio/impl/Record/TXCAudioSysRecord.TAG : Ljava/lang/String;
    //   39: ldc 'onRecordStop:no callback'
    //   41: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    //   50: aconst_null
    //   51: astore_1
    //   52: goto -> 23
    // Exception table:
    //   from	to	target	type
    //   2	20	45	finally
    //   23	25	45	finally
    //   46	48	45	finally
  }
  
  private void uninit() {
    if (this.mMic != null) {
      TXCLog.i(TAG, "stop mic");
      try {
        this.mMic.setRecordPositionUpdateListener(null);
        this.mMic.stop();
        this.mMic.release();
      } catch (Exception exception) {
        TXCLog.e(TAG, "stop AudioRecord failed.", exception);
      } 
    } 
    this.mMic = null;
    this.mRecordBuffer = null;
    this.mIsCapFirstFrame = false;
  }
  
  public boolean isRecording() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mIsRunning : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public void pause(boolean paramBoolean) {
    TXCLog.i(TAG, "system audio record pause");
    this.mPause.set(true);
    this.mSendMuteData = paramBoolean;
  }
  
  public void resume() {
    TXCLog.i(TAG, "system audio record resume");
    this.mPause.set(false);
  }
  
  public void run() {
    int i;
    if (!this.mIsRunning) {
      TXCLog.w(TAG, "audio record: abandom start audio sys record thread!");
      return;
    } 
    onRecordStart();
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("start capture audio data ...,mIsRunning:");
    stringBuilder.append(this.mIsRunning);
    stringBuilder.append(" Thread.interrupted:");
    stringBuilder.append(Thread.interrupted());
    stringBuilder.append(" mMic:");
    stringBuilder.append(this.mMic);
    TXCLog.i(str, stringBuilder.toString());
    init();
    label40: while (true) {
      i = 0;
      int j = 0;
      while (this.mIsRunning && !Thread.interrupted() && this.mMic != null && i <= 5) {
        System.currentTimeMillis();
        AudioRecord audioRecord = this.mMic;
        byte[] arrayOfByte = this.mRecordBuffer;
        int k = audioRecord.read(arrayOfByte, j, arrayOfByte.length - j);
        if (k != this.mRecordBuffer.length - j) {
          if (k <= 0) {
            String str1 = TAG;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("read pcm error, len =");
            stringBuilder1.append(k);
            TXCLog.e(str1, stringBuilder1.toString());
            i++;
            continue;
          } 
          j += k;
          continue;
        } 
        boolean bool = this.mIsCapFirstFrame;
        i = 1;
        if (!bool) {
          onRecordError(-6, "First frame captured#");
          this.mIsCapFirstFrame = true;
        } 
        if (this.mSendMuteData)
          Arrays.fill(this.mRecordBuffer, (byte)0); 
        j = i;
        if (this.mPause.get()) {
          if (this.mSendMuteData) {
            j = i;
            continue label40;
          } 
          j = 0;
          if (j != 0) {
            byte[] arrayOfByte1 = this.mRecordBuffer;
            onRecordPcmData(arrayOfByte1, arrayOfByte1.length, TXCTimeUtil.getTimeTick());
            arrayOfByte1 = this.mRecordBuffer;
            nativeSendSysRecordAudioData(arrayOfByte1, arrayOfByte1.length, this.mSampleRate, this.mChannels, this.mBits);
          } 
          continue;
        } 
        continue label40;
      } 
      break;
    } 
    str = TAG;
    stringBuilder = new StringBuilder();
    stringBuilder.append("stop capture audio data ...,mIsRunning:");
    stringBuilder.append(this.mIsRunning);
    stringBuilder.append(" mMic:");
    stringBuilder.append(this.mMic);
    stringBuilder.append(" nFailedCount:");
    stringBuilder.append(i);
    TXCLog.d(str, stringBuilder.toString());
    uninit();
    if (i > 5) {
      onRecordError(-1, "read data failed!");
      return;
    } 
    onRecordStop();
  }
  
  public void setAudioRecordListener(c paramc) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 14
    //   6: aload_0
    //   7: aconst_null
    //   8: putfield mWeakRefListener : Ljava/lang/ref/WeakReference;
    //   11: goto -> 26
    //   14: aload_0
    //   15: new java/lang/ref/WeakReference
    //   18: dup
    //   19: aload_1
    //   20: invokespecial <init> : (Ljava/lang/Object;)V
    //   23: putfield mWeakRefListener : Ljava/lang/ref/WeakReference;
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   6	11	29	finally
    //   14	26	29	finally
  }
  
  public void start(int paramInt1, int paramInt2, int paramInt3) {
    TXCLog.i(TAG, "start");
    synchronized (this.threadMutex) {
      stop();
      this.mSampleRate = paramInt1;
      this.mChannels = paramInt2;
      this.mBits = paramInt3;
      this.mIsRunning = true;
      this.mRecordThread = new Thread(this, "AudioSysRecord Thread");
      this.mRecordThread.start();
      TXCLog.i(TAG, "start ok");
      return;
    } 
  }
  
  public void stop() {
    TXCLog.i(TAG, "stop");
    synchronized (this.threadMutex) {
      this.mIsRunning = false;
      long l = System.currentTimeMillis();
      if (this.mRecordThread != null && this.mRecordThread.isAlive()) {
        long l1 = Thread.currentThread().getId();
        long l2 = this.mRecordThread.getId();
        if (l1 != l2)
          try {
            this.mRecordThread.join();
          } catch (Exception exception) {
            String str1 = TAG;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("record stop Exception: ");
            stringBuilder1.append(exception.getMessage());
            TXCLog.e(str1, stringBuilder1.toString());
          }  
      } 
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("stop ok,stop record cost time(MS): ");
      stringBuilder.append(System.currentTimeMillis() - l);
      TXCLog.i(str, stringBuilder.toString());
      this.mRecordThread = null;
      TXCLog.i(TAG, "stop ok");
      return;
    } 
  }
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AudioCenter:");
    stringBuilder.append(TXCAudioSysRecord.class.getSimpleName());
    TAG = stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\tencent\liteav\audio\impl\Record\TXCAudioSysRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */