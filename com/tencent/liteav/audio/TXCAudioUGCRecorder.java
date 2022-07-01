package com.tencent.liteav.audio;

import android.content.Context;
import com.tencent.liteav.audio.impl.Record.TXCAudioSysRecord;
import com.tencent.liteav.audio.impl.Record.a;
import com.tencent.liteav.audio.impl.Record.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TXCAudioUGCRecorder implements c {
  private static final TXCAudioUGCRecorder INSTANCE = new TXCAudioUGCRecorder();
  
  private static final String TAG = "AudioCenter:TXCAudioUGCRecorder";
  
  private final int AAC_SAMPLE_NUM = 1024;
  
  protected int mAACFrameLength = this.mChannels * 1024 * this.mBits / 8;
  
  protected int mAECType = 0;
  
  private a mBGMRecorder = null;
  
  protected int mBits = 16;
  
  protected int mChannels = 1;
  
  protected Context mContext;
  
  private boolean mCurBGMRecordFlag = false;
  
  private boolean mEnableBGMRecord = false;
  
  private final List<byte[]> mEncodedAudioList = (List)new ArrayList<byte>();
  
  protected boolean mIsEarphoneOn = false;
  
  private boolean mIsMute = false;
  
  private boolean mIsPause = false;
  
  private boolean mIsRunning = false;
  
  private long mLastPTS = 0L;
  
  protected int mReverbType = 0;
  
  protected AtomicInteger mSampleRate = new AtomicInteger(48000);
  
  private int mShouldClearAACDataCnt = 0;
  
  private AtomicReference<Float> mSpeedRate = new AtomicReference<Float>(Float.valueOf(1.0F));
  
  protected int mVoiceChangerType = 0;
  
  private float mVolume = 1.0F;
  
  private WeakReference<g> mWeakRecordListener;
  
  private TXCAudioUGCRecorder() {
    TXCAudioSysRecord.getInstance();
    nativeClassInit();
  }
  
  public static TXCAudioUGCRecorder getInstance() {
    return INSTANCE;
  }
  
  private native void nativeClassInit();
  
  private native void nativeEnableMixMode(boolean paramBoolean);
  
  private native void nativeSetChangerType(int paramInt);
  
  private native void nativeSetReverbType(int paramInt);
  
  private native void nativeSetSpeedRate(float paramFloat);
  
  private native void nativeSetVolume(float paramFloat);
  
  private native void nativeStartAudioRecord(int paramInt1, int paramInt2, int paramInt3);
  
  private native void nativeStopAudioRecord();
  
  private void updateAudioEffector() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_1
    //   4: aload_0
    //   5: getfield mEnableBGMRecord : Z
    //   8: ifne -> 104
    //   11: aload_0
    //   12: getfield mAECType : I
    //   15: iconst_1
    //   16: if_icmpne -> 22
    //   19: goto -> 104
    //   22: iload_1
    //   23: ifne -> 65
    //   26: aload_0
    //   27: aload_0
    //   28: getfield mReverbType : I
    //   31: invokespecial nativeSetReverbType : (I)V
    //   34: aload_0
    //   35: aload_0
    //   36: getfield mVoiceChangerType : I
    //   39: invokespecial nativeSetChangerType : (I)V
    //   42: aload_0
    //   43: getfield mIsMute : Z
    //   46: ifeq -> 57
    //   49: aload_0
    //   50: fconst_0
    //   51: invokespecial nativeSetVolume : (F)V
    //   54: goto -> 65
    //   57: aload_0
    //   58: aload_0
    //   59: getfield mVolume : F
    //   62: invokespecial nativeSetVolume : (F)V
    //   65: iload_1
    //   66: ifeq -> 74
    //   69: aload_0
    //   70: fconst_0
    //   71: invokespecial nativeSetVolume : (F)V
    //   74: aload_0
    //   75: iload_1
    //   76: invokespecial nativeEnableMixMode : (Z)V
    //   79: aload_0
    //   80: aload_0
    //   81: getfield mSpeedRate : Ljava/util/concurrent/atomic/AtomicReference;
    //   84: invokevirtual get : ()Ljava/lang/Object;
    //   87: checkcast java/lang/Float
    //   90: invokevirtual floatValue : ()F
    //   93: invokespecial nativeSetSpeedRate : (F)V
    //   96: aload_0
    //   97: monitorexit
    //   98: return
    //   99: astore_2
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_2
    //   103: athrow
    //   104: iconst_1
    //   105: istore_1
    //   106: goto -> 22
    // Exception table:
    //   from	to	target	type
    //   4	11	99	finally
    //   11	19	99	finally
    //   26	54	99	finally
    //   57	65	99	finally
    //   69	74	99	finally
    //   74	96	99	finally
  }
  
  public void clearCache() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'AudioCenter:TXCAudioUGCRecorder'
    //   4: ldc 'clearCache'
    //   6: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield mEncodedAudioList : Ljava/util/List;
    //   13: astore_1
    //   14: aload_1
    //   15: monitorenter
    //   16: aload_0
    //   17: getfield mEncodedAudioList : Ljava/util/List;
    //   20: invokeinterface clear : ()V
    //   25: aload_1
    //   26: monitorexit
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: astore_2
    //   31: aload_1
    //   32: monitorexit
    //   33: aload_2
    //   34: athrow
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	35	finally
    //   16	27	30	finally
    //   31	33	30	finally
    //   33	35	35	finally
  }
  
  public void enableBGMRecord(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("enableBGMRecord: ");
    stringBuilder.append(paramBoolean);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", stringBuilder.toString());
    if (this.mEnableBGMRecord != paramBoolean && !paramBoolean)
      this.mShouldClearAACDataCnt = 2; 
    this.mEnableBGMRecord = paramBoolean;
    updateAudioEffector();
  }
  
  public int getChannels() {
    return this.mChannels;
  }
  
  public g getListener() {
    WeakReference<g> weakReference = this.mWeakRecordListener;
    return (weakReference != null) ? weakReference.get() : null;
  }
  
  public int getSampleRate() {
    return this.mSampleRate.get();
  }
  
  public boolean isPaused() {
    return this.mIsPause;
  }
  
  public boolean isRecording() {
    return this.mIsRunning;
  }
  
  public void onAudioRecordError(int paramInt, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("sys audio record error: ");
    stringBuilder.append(paramInt);
    stringBuilder.append(", ");
    stringBuilder.append(paramString);
    TXCLog.e("AudioCenter:TXCAudioUGCRecorder", stringBuilder.toString());
    g g = getListener();
    if (g != null)
      g.onRecordError(paramInt, paramString); 
  }
  
  public void onAudioRecordPCM(byte[] paramArrayOfbyte, int paramInt, long paramLong) {
    long l2 = this.mLastPTS;
    long l1 = paramLong;
    if (l2 >= paramLong)
      l1 = 2L + l2; 
    while (true) {
      while (true) {
        List<byte[]> list = this.mEncodedAudioList;
        /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/util/List<ObjectType{B, dimension=1}>}, name=null} */
        break;
      } 
      if (paramArrayOfbyte == null)
        return; 
    } 
  }
  
  public void onAudioRecordStart() {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "sys audio record start");
  }
  
  public void onAudioRecordStop() {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "sys audio record stop");
  }
  
  public void onEncodedData(byte[] paramArrayOfbyte) {
    synchronized (this.mEncodedAudioList) {
      this.mEncodedAudioList.add(paramArrayOfbyte);
      return;
    } 
  }
  
  public void pause() {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "pause");
    TXCAudioEngine.getInstance().pauseLocalAudio();
    synchronized (this.mEncodedAudioList) {
      this.mIsPause = true;
      return;
    } 
  }
  
  public void resume() {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "resume");
    TXCAudioEngine.getInstance().resumeLocalAudio();
    synchronized (this.mEncodedAudioList) {
      this.mIsPause = false;
      nativeEnableMixMode(this.mEnableBGMRecord);
      if (this.mIsMute || this.mEnableBGMRecord) {
        nativeSetVolume(0.0F);
        return;
      } 
      nativeSetVolume(this.mVolume);
      return;
    } 
  }
  
  public void setAECType(int paramInt, Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setAECType: ");
    stringBuilder.append(paramInt);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", stringBuilder.toString());
    this.mAECType = paramInt;
    if (paramContext != null)
      this.mContext = paramContext.getApplicationContext(); 
  }
  
  public void setChangerType(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_2
    //   11: ldc_w 'setChangerType: '
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload_2
    //   19: iload_1
    //   20: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: ldc 'AudioCenter:TXCAudioUGCRecorder'
    //   26: aload_2
    //   27: invokevirtual toString : ()Ljava/lang/String;
    //   30: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: iload_1
    //   35: putfield mVoiceChangerType : I
    //   38: aload_0
    //   39: iload_1
    //   40: invokespecial nativeSetChangerType : (I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: athrow
    // Exception table:
    //   from	to	target	type
    //   2	43	46	finally
  }
  
  public void setChannels(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setChannels: ");
    stringBuilder.append(paramInt);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", stringBuilder.toString());
    this.mChannels = paramInt;
  }
  
  public void setListener(g paramg) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 14
    //   6: aload_0
    //   7: aconst_null
    //   8: putfield mWeakRecordListener : Ljava/lang/ref/WeakReference;
    //   11: goto -> 26
    //   14: aload_0
    //   15: new java/lang/ref/WeakReference
    //   18: dup
    //   19: aload_1
    //   20: invokespecial <init> : (Ljava/lang/Object;)V
    //   23: putfield mWeakRecordListener : Ljava/lang/ref/WeakReference;
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
  
  public void setMute(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setMute: ");
    stringBuilder.append(paramBoolean);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", stringBuilder.toString());
    this.mIsMute = paramBoolean;
    if (paramBoolean) {
      nativeSetVolume(0.0F);
      return;
    } 
    nativeSetVolume(this.mVolume);
  }
  
  public void setReverbType(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_2
    //   11: ldc_w 'setReverbType: '
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload_2
    //   19: iload_1
    //   20: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: ldc 'AudioCenter:TXCAudioUGCRecorder'
    //   26: aload_2
    //   27: invokevirtual toString : ()Ljava/lang/String;
    //   30: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: iload_1
    //   35: putfield mReverbType : I
    //   38: aload_0
    //   39: iload_1
    //   40: invokespecial nativeSetReverbType : (I)V
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: athrow
    // Exception table:
    //   from	to	target	type
    //   2	43	46	finally
  }
  
  public void setSampleRate(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setSampleRate: ");
    stringBuilder.append(paramInt);
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", stringBuilder.toString());
    this.mSampleRate.set(paramInt);
  }
  
  public void setSpeedRate(float paramFloat) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_2
    //   11: ldc_w 'setSpeedRate: '
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload_2
    //   19: fload_1
    //   20: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: ldc 'AudioCenter:TXCAudioUGCRecorder'
    //   26: aload_2
    //   27: invokevirtual toString : ()Ljava/lang/String;
    //   30: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: getfield mSpeedRate : Ljava/util/concurrent/atomic/AtomicReference;
    //   37: fload_1
    //   38: invokestatic valueOf : (F)Ljava/lang/Float;
    //   41: invokevirtual set : (Ljava/lang/Object;)V
    //   44: aload_0
    //   45: aload_0
    //   46: getfield mSpeedRate : Ljava/util/concurrent/atomic/AtomicReference;
    //   49: invokevirtual get : ()Ljava/lang/Object;
    //   52: checkcast java/lang/Float
    //   55: invokevirtual floatValue : ()F
    //   58: invokespecial nativeSetSpeedRate : (F)V
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: astore_2
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_2
    //   68: athrow
    // Exception table:
    //   from	to	target	type
    //   2	61	64	finally
  }
  
  public void setVolume(float paramFloat) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_2
    //   10: aload_2
    //   11: ldc_w 'setVolume: '
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload_2
    //   19: fload_1
    //   20: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: ldc 'AudioCenter:TXCAudioUGCRecorder'
    //   26: aload_2
    //   27: invokevirtual toString : ()Ljava/lang/String;
    //   30: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: fload_1
    //   35: putfield mVolume : F
    //   38: aload_0
    //   39: getfield mIsMute : Z
    //   42: ifeq -> 53
    //   45: aload_0
    //   46: fconst_0
    //   47: invokespecial nativeSetVolume : (F)V
    //   50: goto -> 58
    //   53: aload_0
    //   54: fload_1
    //   55: invokespecial nativeSetVolume : (F)V
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    // Exception table:
    //   from	to	target	type
    //   2	50	61	finally
    //   53	58	61	finally
  }
  
  public int startRecord(Context paramContext) {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "startRecord");
    if (paramContext != null)
      this.mContext = paramContext.getApplicationContext(); 
    updateAudioEffector();
    TXCAudioSysRecord.getInstance().setAudioRecordListener(this);
    nativeStartAudioRecord(this.mSampleRate.get(), this.mChannels, this.mBits);
    this.mIsRunning = true;
    this.mLastPTS = 0L;
    return 0;
  }
  
  public int stopRecord() {
    TXCLog.i("AudioCenter:TXCAudioUGCRecorder", "stopRecord");
    TXCAudioSysRecord.getInstance().setAudioRecordListener(null);
    a a1 = this.mBGMRecorder;
    if (a1 != null) {
      a1.a();
      this.mBGMRecorder = null;
    } 
    nativeStopAudioRecord();
    nativeEnableMixMode(false);
    nativeSetVolume(1.0F);
    synchronized (this.mEncodedAudioList) {
      this.mEncodedAudioList.clear();
      this.mIsRunning = false;
      this.mLastPTS = 0L;
      this.mIsPause = false;
      this.mIsMute = false;
      this.mShouldClearAACDataCnt = 0;
      return 0;
    } 
  }
  
  static {
    g.f();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\audio\TXCAudioUGCRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */