package com.tencent.liteav.audio;

import com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.g;
import java.lang.ref.WeakReference;

public class TXCUGCBGMPlayer implements TXAudioEffectManager.TXMusicPlayObserver {
  private static final int PLAY_ERR_OPEN = -1;
  
  private static final int PLAY_SUCCESS = 0;
  
  private static final String TAG = "AudioCenter:TXCUGCBGMPlayer";
  
  private int mBGMId = Integer.MIN_VALUE;
  
  private long mEndTimeMS = 0L;
  
  private boolean mIsRunning = false;
  
  private long mSeekBytes = 0L;
  
  private float mSpeedRate = 1.0F;
  
  private long mStartTimeMS = 0L;
  
  private float mVolume = 1.0F;
  
  private WeakReference<h> mWeakListener = null;
  
  static {
    g.f();
  }
  
  private TXCUGCBGMPlayer() {
    TXCMultAudioTrackPlayer.getInstance();
  }
  
  public static TXCUGCBGMPlayer getInstance() {
    return a.a();
  }
  
  private void onPlayEnd(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mWeakListener : Ljava/lang/ref/WeakReference;
    //   6: ifnull -> 42
    //   9: aload_0
    //   10: getfield mWeakListener : Ljava/lang/ref/WeakReference;
    //   13: invokevirtual get : ()Ljava/lang/Object;
    //   16: checkcast com/tencent/liteav/audio/h
    //   19: astore_2
    //   20: goto -> 23
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: ifnull -> 36
    //   29: aload_2
    //   30: iload_1
    //   31: invokeinterface onPlayEnd : (I)V
    //   36: return
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    //   42: aconst_null
    //   43: astore_2
    //   44: goto -> 23
    // Exception table:
    //   from	to	target	type
    //   2	20	37	finally
    //   23	25	37	finally
    //   38	40	37	finally
  }
  
  private void onPlayProgress(long paramLong1, long paramLong2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mWeakListener : Ljava/lang/ref/WeakReference;
    //   6: ifnull -> 48
    //   9: aload_0
    //   10: getfield mWeakListener : Ljava/lang/ref/WeakReference;
    //   13: invokevirtual get : ()Ljava/lang/Object;
    //   16: checkcast com/tencent/liteav/audio/h
    //   19: astore #5
    //   21: goto -> 24
    //   24: aload_0
    //   25: monitorexit
    //   26: aload #5
    //   28: ifnull -> 40
    //   31: aload #5
    //   33: lload_1
    //   34: lload_3
    //   35: invokeinterface onPlayProgress : (JJ)V
    //   40: return
    //   41: astore #5
    //   43: aload_0
    //   44: monitorexit
    //   45: aload #5
    //   47: athrow
    //   48: aconst_null
    //   49: astore #5
    //   51: goto -> 24
    // Exception table:
    //   from	to	target	type
    //   2	21	41	finally
    //   24	26	41	finally
    //   43	45	41	finally
  }
  
  private void onPlayStart() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mWeakListener : Ljava/lang/ref/WeakReference;
    //   6: ifnull -> 41
    //   9: aload_0
    //   10: getfield mWeakListener : Ljava/lang/ref/WeakReference;
    //   13: invokevirtual get : ()Ljava/lang/Object;
    //   16: checkcast com/tencent/liteav/audio/h
    //   19: astore_1
    //   20: goto -> 23
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: ifnull -> 35
    //   29: aload_1
    //   30: invokeinterface onPlayStart : ()V
    //   35: return
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    //   41: aconst_null
    //   42: astore_1
    //   43: goto -> 23
    // Exception table:
    //   from	to	target	type
    //   2	20	36	finally
    //   23	25	36	finally
    //   37	39	36	finally
  }
  
  public long getDurationMS(String paramString) {
    return TXAudioEffectManagerImpl.getCacheInstance().getMusicDurationInMS(paramString);
  }
  
  public void onComplete(int paramInt1, int paramInt2) {
    onPlayEnd(paramInt2);
  }
  
  public void onPlayProgress(int paramInt, long paramLong1, long paramLong2) {
    onPlayProgress(paramLong1, paramLong2);
  }
  
  public void onStart(int paramInt1, int paramInt2) {
    onPlayStart();
  }
  
  public void pause() {
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "pause");
    TXAudioEffectManagerImpl.getCacheInstance().pausePlayMusic(this.mBGMId);
  }
  
  public void playFromTime(long paramLong1, long paramLong2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("startPlayRange:");
    stringBuilder.append(paramLong1);
    stringBuilder.append(", ");
    stringBuilder.append(paramLong2);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", stringBuilder.toString());
    this.mStartTimeMS = paramLong1;
    this.mEndTimeMS = paramLong2;
  }
  
  public void resume() {
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "resume");
    TXAudioEffectManagerImpl.getCacheInstance().resumePlayMusic(this.mBGMId);
  }
  
  public void seekBytes(long paramLong) {
    long l1 = paramLong;
    if (paramLong < 0L) {
      TXCLog.e("AudioCenter:TXCUGCBGMPlayer", "seek bytes can not be negative. change to 0");
      l1 = 0L;
    } 
    long l2 = TXAudioEffectManagerImpl.getCacheInstance().getAvailableBGMBytes(this.mBGMId);
    paramLong = l1;
    if (l2 > 0L)
      paramLong = l1 % l2; 
    this.mSeekBytes = paramLong;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mSeekBytes:");
    stringBuilder.append(this.mSeekBytes);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", stringBuilder.toString());
    TXAudioEffectManagerImpl.getCacheInstance().seekMusicToPosInBytes(this.mBGMId, paramLong);
  }
  
  public void setChangerType(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("changerType:");
    stringBuilder.append(paramInt);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", stringBuilder.toString());
    TXAudioEffectManagerImpl.getCacheInstance().setMusicChangerType(this.mBGMId, paramInt);
  }
  
  public void setOnPlayListener(h paramh) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 11
    //   6: aload_0
    //   7: aconst_null
    //   8: putfield mWeakListener : Ljava/lang/ref/WeakReference;
    //   11: aload_0
    //   12: new java/lang/ref/WeakReference
    //   15: dup
    //   16: aload_1
    //   17: invokespecial <init> : (Ljava/lang/Object;)V
    //   20: putfield mWeakListener : Ljava/lang/ref/WeakReference;
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Exception table:
    //   from	to	target	type
    //   6	11	26	finally
    //   11	23	26	finally
  }
  
  public void setReverbType(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("int reverbType:");
    stringBuilder.append(paramInt);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", stringBuilder.toString());
    TXAudioEffectManagerImpl.getCacheInstance().setMusicReverbType(this.mBGMId, paramInt);
  }
  
  public void setSpeedRate(float paramFloat) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setSpeedRate:");
    stringBuilder.append(paramFloat);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", stringBuilder.toString());
    this.mSpeedRate = paramFloat;
    TXAudioEffectManagerImpl.getCacheInstance().setMusicPlayoutSpeedRate(this.mBGMId, paramFloat);
  }
  
  public void setVolume(float paramFloat) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setVolume:");
    stringBuilder.append(paramFloat);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", stringBuilder.toString());
    this.mVolume = paramFloat;
    TXAudioEffectManagerImpl.getCacheInstance().setMusicVolume(this.mBGMId, (int)(paramFloat * 100.0F));
  }
  
  public void startPlay(String paramString, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("startPlay:");
    stringBuilder.append(paramString);
    stringBuilder.append("record:");
    stringBuilder.append(paramBoolean);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", stringBuilder.toString());
    if (paramString != null) {
      if (paramString.isEmpty())
        return; 
      if (this.mIsRunning) {
        TXCLog.w("AudioCenter:TXCUGCBGMPlayer", "BGM is playing, restarting...");
        stopPlay();
      } 
      this.mSeekBytes = 0L;
      this.mIsRunning = true;
      TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(this.mBGMId, paramString);
      audioMusicParam.publish = paramBoolean;
      audioMusicParam.loopCount = 0;
      audioMusicParam.startTimeMS = this.mStartTimeMS;
      audioMusicParam.endTimeMS = this.mEndTimeMS;
      audioMusicParam.isShortFile = true;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("start bgm play : filePath = ");
      stringBuilder1.append(paramString);
      stringBuilder1.append(" publish:");
      stringBuilder1.append(paramBoolean);
      stringBuilder1.append(" startTimeMS:");
      stringBuilder1.append(this.mStartTimeMS);
      stringBuilder1.append(" endTimeMS:");
      stringBuilder1.append(this.mEndTimeMS);
      stringBuilder1.append(" isShortFile:");
      stringBuilder1.append(audioMusicParam.isShortFile);
      stringBuilder1.append("mVolume:");
      stringBuilder1.append(this.mVolume);
      TXCLog.i("AudioCenter:TXCUGCBGMPlayer", stringBuilder1.toString());
      TXAudioEffectManagerImpl.getCacheInstance().setMusicVolume(this.mBGMId, (int)(this.mVolume * 100.0F));
      TXAudioEffectManagerImpl.getCacheInstance().setMusicPlayoutSpeedRate(this.mBGMId, this.mSpeedRate);
      if (paramBoolean)
        TXAudioEffectManagerImpl.getCacheInstance().setMuteDataDurationToPublish(this.mBGMId, 200); 
      paramBoolean = TXAudioEffectManagerImpl.getCacheInstance().startPlayMusic(audioMusicParam);
      TXAudioEffectManagerImpl.getCacheInstance().setMusicObserver(this.mBGMId, this);
      if (!paramBoolean) {
        onPlayEnd(-1);
        return;
      } 
      onPlayStart();
    } 
  }
  
  public void stopPlay() {
    // Byte code:
    //   0: ldc 'AudioCenter:TXCUGCBGMPlayer'
    //   2: ldc_w 'stopPlay'
    //   5: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_0
    //   9: iconst_0
    //   10: putfield mIsRunning : Z
    //   13: invokestatic currentTimeMillis : ()J
    //   16: lstore_1
    //   17: aload_0
    //   18: monitorenter
    //   19: invokestatic getCacheInstance : ()Lcom/tencent/liteav/audio/TXAudioEffectManagerImpl;
    //   22: aload_0
    //   23: getfield mBGMId : I
    //   26: aconst_null
    //   27: invokevirtual setMusicObserver : (ILcom/tencent/liteav/audio/TXAudioEffectManager$TXMusicPlayObserver;)V
    //   30: invokestatic getCacheInstance : ()Lcom/tencent/liteav/audio/TXAudioEffectManagerImpl;
    //   33: aload_0
    //   34: getfield mBGMId : I
    //   37: invokevirtual stopPlayMusic : (I)V
    //   40: aload_0
    //   41: monitorexit
    //   42: new java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial <init> : ()V
    //   49: astore_3
    //   50: aload_3
    //   51: ldc_w 'stopBGMPlay cost(MS): '
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_3
    //   59: invokestatic currentTimeMillis : ()J
    //   62: lload_1
    //   63: lsub
    //   64: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: ldc 'AudioCenter:TXCUGCBGMPlayer'
    //   70: aload_3
    //   71: invokevirtual toString : ()Ljava/lang/String;
    //   74: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   77: return
    //   78: astore_3
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_3
    //   82: athrow
    // Exception table:
    //   from	to	target	type
    //   19	42	78	finally
    //   79	81	78	finally
  }
  
  static class a {
    private static TXCUGCBGMPlayer a = new TXCUGCBGMPlayer();
    
    public static TXCUGCBGMPlayer a() {
      return a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\audio\TXCUGCBGMPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */