package com.tencent.liteav.audio;

import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.g;
import java.lang.ref.WeakReference;

public class TXCLiveBGMPlayer implements TXAudioEffectManager.TXMusicPlayObserver {
  private static final int PLAY_ERR_OPEN = -1;
  
  private static final int PLAY_SUCCESS = 0;
  
  private static final String TAG = "AudioCenter:TXCLiveBGMPlayer";
  
  private int mBGMId = Integer.MAX_VALUE;
  
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  
  private boolean mIsPause = false;
  
  private boolean mIsRunning = false;
  
  private WeakReference<h> mWeakListener = null;
  
  static {
    g.f();
  }
  
  private TXCLiveBGMPlayer() {}
  
  public static TXCLiveBGMPlayer getInstance() {
    return a.a();
  }
  
  private void onPlayEnd(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mWeakListener : Ljava/lang/ref/WeakReference;
    //   6: ifnull -> 49
    //   9: aload_0
    //   10: getfield mWeakListener : Ljava/lang/ref/WeakReference;
    //   13: invokevirtual get : ()Ljava/lang/Object;
    //   16: checkcast com/tencent/liteav/audio/h
    //   19: astore_2
    //   20: goto -> 23
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_0
    //   26: getfield mHandler : Landroid/os/Handler;
    //   29: new com/tencent/liteav/audio/TXCLiveBGMPlayer$2
    //   32: dup
    //   33: aload_0
    //   34: aload_2
    //   35: iload_1
    //   36: invokespecial <init> : (Lcom/tencent/liteav/audio/TXCLiveBGMPlayer;Lcom/tencent/liteav/audio/h;I)V
    //   39: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   42: pop
    //   43: return
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    //   49: aconst_null
    //   50: astore_2
    //   51: goto -> 23
    // Exception table:
    //   from	to	target	type
    //   2	20	44	finally
    //   23	25	44	finally
    //   45	47	44	finally
  }
  
  private void onPlayProgress(long paramLong1, long paramLong2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mWeakListener : Ljava/lang/ref/WeakReference;
    //   6: ifnull -> 54
    //   9: aload_0
    //   10: getfield mWeakListener : Ljava/lang/ref/WeakReference;
    //   13: invokevirtual get : ()Ljava/lang/Object;
    //   16: checkcast com/tencent/liteav/audio/h
    //   19: astore #5
    //   21: goto -> 24
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_0
    //   27: getfield mHandler : Landroid/os/Handler;
    //   30: new com/tencent/liteav/audio/TXCLiveBGMPlayer$3
    //   33: dup
    //   34: aload_0
    //   35: aload #5
    //   37: lload_1
    //   38: lload_3
    //   39: invokespecial <init> : (Lcom/tencent/liteav/audio/TXCLiveBGMPlayer;Lcom/tencent/liteav/audio/h;JJ)V
    //   42: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   45: pop
    //   46: return
    //   47: astore #5
    //   49: aload_0
    //   50: monitorexit
    //   51: aload #5
    //   53: athrow
    //   54: aconst_null
    //   55: astore #5
    //   57: goto -> 24
    // Exception table:
    //   from	to	target	type
    //   2	21	47	finally
    //   24	26	47	finally
    //   49	51	47	finally
  }
  
  private void onPlayStart(int paramInt) {
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
    //   19: astore_2
    //   20: goto -> 23
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_0
    //   26: getfield mHandler : Landroid/os/Handler;
    //   29: new com/tencent/liteav/audio/TXCLiveBGMPlayer$1
    //   32: dup
    //   33: aload_0
    //   34: aload_2
    //   35: invokespecial <init> : (Lcom/tencent/liteav/audio/TXCLiveBGMPlayer;Lcom/tencent/liteav/audio/h;)V
    //   38: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   41: pop
    //   42: return
    //   43: astore_2
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: athrow
    //   48: aconst_null
    //   49: astore_2
    //   50: goto -> 23
    // Exception table:
    //   from	to	target	type
    //   2	20	43	finally
    //   23	25	43	finally
    //   44	46	43	finally
  }
  
  public int getBGMDuration(String paramString) {
    return (int)TXAudioEffectManagerImpl.getInstance().getMusicDurationInMS(paramString);
  }
  
  public long getBGMGetCurrentProgressInMs(String paramString) {
    return (paramString == null) ? TXAudioEffectManagerImpl.getInstance().getMusicCurrentPosInMS(this.mBGMId) : 0L;
  }
  
  public boolean isPlaying() {
    return this.mIsRunning;
  }
  
  public boolean isRunning() {
    return (this.mIsRunning && !this.mIsPause);
  }
  
  public void onComplete(int paramInt1, int paramInt2) {
    onPlayEnd(paramInt2);
  }
  
  public void onPlayProgress(int paramInt, long paramLong1, long paramLong2) {
    onPlayProgress(paramLong1, paramLong2);
  }
  
  public void onStart(int paramInt1, int paramInt2) {
    onPlayStart(paramInt2);
  }
  
  public boolean pause() {
    TXCLog.i("AudioCenter:TXCLiveBGMPlayer", "pause");
    this.mIsPause = true;
    TXAudioEffectManagerImpl.getInstance().pausePlayMusic(this.mBGMId);
    return true;
  }
  
  public boolean resume() {
    TXCLog.i("AudioCenter:TXCLiveBGMPlayer", "resume");
    this.mIsPause = false;
    TXAudioEffectManagerImpl.getInstance().resumePlayMusic(this.mBGMId);
    return true;
  }
  
  public void setBGMPosition(int paramInt) {
    TXAudioEffectManagerImpl.getInstance().seekMusicToPosInMS(this.mBGMId, paramInt);
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
  
  public void setPitch(float paramFloat) {
    TXAudioEffectManagerImpl.getInstance().setMusicPitch(this.mBGMId, paramFloat);
  }
  
  public boolean setPlayoutVolume(float paramFloat) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setPlayoutVolume:");
    stringBuilder.append(paramFloat);
    TXCLog.i("AudioCenter:TXCLiveBGMPlayer", stringBuilder.toString());
    TXAudioEffectManagerImpl.getInstance().setMusicPlayoutVolume(this.mBGMId, (int)(paramFloat * 100.0F));
    return true;
  }
  
  public boolean setPublishVolume(float paramFloat) {
    TXAudioEffectManagerImpl.getInstance().setMusicPublishVolume(this.mBGMId, (int)(paramFloat * 100.0F));
    return true;
  }
  
  public boolean setVolume(float paramFloat) {
    TXCLog.i("AudioCenter:TXCLiveBGMPlayer", "setVolume");
    TXAudioEffectManagerImpl.getInstance().setMusicVolume(this.mBGMId, (int)(paramFloat * 100.0F));
    return true;
  }
  
  public boolean startPlay(String paramString) {
    if (paramString == null || paramString.isEmpty()) {
      TXCLog.e("AudioCenter:TXCLiveBGMPlayer", "start live bgm failed! invalid params!");
      return false;
    } 
    this.mIsRunning = true;
    TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(this.mBGMId, paramString);
    audioMusicParam.publish = true;
    audioMusicParam.loopCount = 0;
    boolean bool = TXAudioEffectManagerImpl.getInstance().startPlayMusic(audioMusicParam);
    TXAudioEffectManagerImpl.getInstance().setMusicObserver(this.mBGMId, this);
    if (!bool) {
      onPlayEnd(-1);
      return false;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("start bgm play : filePath = ");
    stringBuilder.append(paramString);
    TXCLog.i("AudioCenter:TXCLiveBGMPlayer", stringBuilder.toString());
    return true;
  }
  
  public void stopAll() {
    TXAudioEffectManagerImpl.getInstance().stopAllMusics();
    TXAudioEffectManagerImpl.getAutoCacheHolder().stopAllMusics();
    TXAudioEffectManagerImpl.getCacheInstance().stopAllMusics();
  }
  
  public boolean stopPlay() {
    this.mIsRunning = false;
    long l = System.currentTimeMillis();
    TXAudioEffectManagerImpl.getInstance().setMusicObserver(this.mBGMId, null);
    TXAudioEffectManagerImpl.getInstance().stopPlayMusic(this.mBGMId);
    this.mIsPause = false;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("stopBGMPlay cost(MS): ");
    stringBuilder.append(System.currentTimeMillis() - l);
    TXCLog.i("AudioCenter:TXCLiveBGMPlayer", stringBuilder.toString());
    return true;
  }
  
  static class a {
    private static TXCLiveBGMPlayer a = new TXCLiveBGMPlayer();
    
    public static TXCLiveBGMPlayer a() {
      return a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\audio\TXCLiveBGMPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */