package com.tencent.liteav.audio;

import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TXAudioEffectManagerImpl implements TXAudioEffectManager {
  private static final int EFFECT_PLAYER_ID_TYPE = 2;
  
  private static final int NEW_BGM_PLAYER_ID_TYPE = 1;
  
  private static final int OLD_BGM_PLAYER_ID_TYPE = 0;
  
  private static final String TAG = "AudioCenter:TXAudioEffectManager";
  
  private static final Handler mMainHandler;
  
  private static final HashMap<Long, TXAudioEffectManager.TXMusicPlayObserver> mMusicObserverMap = new HashMap<Long, TXAudioEffectManager.TXMusicPlayObserver>();
  
  private final int mIdType;
  
  private final List<Long> mPlayingMusicIDList = new ArrayList<Long>();
  
  static {
    mMainHandler = new Handler(Looper.getMainLooper());
    g.f();
    nativeClassInit();
  }
  
  private TXAudioEffectManagerImpl(int paramInt) {
    this.mIdType = paramInt;
  }
  
  private static long convertIdToInt64(int paramInt1, int paramInt2) {
    long l = paramInt1;
    return paramInt2 | l << 32L;
  }
  
  public static TXAudioEffectManagerImpl getAutoCacheHolder() {
    return AudioEffectManagerAutoCacheHolder.INSTANCE;
  }
  
  public static TXAudioEffectManagerImpl getCacheInstance() {
    return AudioEffectManagerCacheHolder.INSTANCE;
  }
  
  public static TXAudioEffectManagerImpl getInstance() {
    return AudioEffectManagerHolder.INSTANCE;
  }
  
  private static native void nativeClassInit();
  
  private native long nativeGetAvailableBGMBytes(long paramLong);
  
  private native long nativeGetCurrentPositionInMs(long paramLong);
  
  private static native long nativeGetDurationMSByPath(String paramString);
  
  private native void nativePause(long paramLong);
  
  private native void nativeResume(long paramLong);
  
  private native void nativeSeekToPosition(long paramLong1, long paramLong2);
  
  private native void nativeSeekToTime(long paramLong, int paramInt);
  
  private native void nativeSetAllVolume(int paramInt);
  
  private native void nativeSetChangerType(long paramLong, int paramInt);
  
  private native void nativeSetMuteDataDurationToPublish(long paramLong, int paramInt);
  
  private native void nativeSetPitch(long paramLong, float paramFloat);
  
  private native void nativeSetPlayoutSpeedRate(long paramLong, float paramFloat);
  
  private native void nativeSetPlayoutVolume(long paramLong, int paramInt);
  
  private native void nativeSetPublishVolume(long paramLong, int paramInt);
  
  private native void nativeSetReverbType(long paramLong, int paramInt);
  
  private native void nativeSetSpeedRate(long paramLong, float paramFloat);
  
  private native void nativeSetVolume(long paramLong, int paramInt);
  
  private native boolean nativeStartPlay(long paramLong, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  private native void nativeStartPlayRange(long paramLong1, long paramLong2, long paramLong3);
  
  private native void nativeStopPlay(long paramLong);
  
  public static void onEffectFinish(final long id, final int errCode) {
    mMainHandler.post(new Runnable() {
          public void run() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onEffectFinish -> effect id = ");
            stringBuilder.append(id);
            stringBuilder.append(", errCode = ");
            stringBuilder.append(errCode);
            TXCLog.i("AudioCenter:TXAudioEffectManager", stringBuilder.toString());
            if (TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(id)) != null)
              ((TXAudioEffectManager.TXMusicPlayObserver)TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(id))).onComplete((int)id, errCode); 
          }
        });
  }
  
  public static void onEffectProgress(final long id, final long curPtsMS, final long durationMS) {
    mMainHandler.post(new Runnable() {
          public void run() {
            if (TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(id)) != null)
              ((TXAudioEffectManager.TXMusicPlayObserver)TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(id))).onPlayProgress((int)id, curPtsMS, durationMS); 
          }
        });
  }
  
  public static void onEffectStart(final long id, final int errCode) {
    mMainHandler.post(new Runnable() {
          public void run() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onEffectStart -> effect id = ");
            stringBuilder.append(id);
            stringBuilder.append(", errCode = ");
            stringBuilder.append(errCode);
            TXCLog.i("AudioCenter:TXAudioEffectManager", stringBuilder.toString());
            if (TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(id)) != null)
              ((TXAudioEffectManager.TXMusicPlayObserver)TXAudioEffectManagerImpl.mMusicObserverMap.get(Long.valueOf(id))).onStart((int)id, errCode); 
          }
        });
  }
  
  public void enableVoiceEarMonitor(boolean paramBoolean) {
    TXCAudioEngine.enableAudioEarMonitoring(paramBoolean);
  }
  
  public long getAvailableBGMBytes(int paramInt) {
    return nativeGetAvailableBGMBytes(convertIdToInt64(this.mIdType, paramInt));
  }
  
  public long getMusicCurrentPosInMS(int paramInt) {
    return nativeGetCurrentPositionInMs(convertIdToInt64(this.mIdType, paramInt));
  }
  
  public long getMusicDurationInMS(String paramString) {
    return nativeGetDurationMSByPath(paramString);
  }
  
  public void interruptAllMusics() {
    TXCLog.i("AudioCenter:TXAudioEffectManager", "interruptAllMusics");
    Iterator<Long> iterator = this.mPlayingMusicIDList.iterator();
    while (iterator.hasNext())
      nativePause(((Long)iterator.next()).longValue()); 
  }
  
  public void pausePlayMusic(int paramInt) {
    long l = convertIdToInt64(this.mIdType, paramInt);
    this.mPlayingMusicIDList.remove(Long.valueOf(l));
    nativePause(l);
  }
  
  public void recoverAllMusics() {
    TXCLog.i("AudioCenter:TXAudioEffectManager", "recoverAllMusics");
    Iterator<Long> iterator = this.mPlayingMusicIDList.iterator();
    while (iterator.hasNext())
      nativeResume(((Long)iterator.next()).longValue()); 
  }
  
  public void resumePlayMusic(int paramInt) {
    long l = convertIdToInt64(this.mIdType, paramInt);
    if (!this.mPlayingMusicIDList.contains(Long.valueOf(l)))
      this.mPlayingMusicIDList.add(Long.valueOf(l)); 
    nativeResume(l);
  }
  
  public void seekMusicToPosInBytes(int paramInt, long paramLong) {
    nativeSeekToPosition(convertIdToInt64(this.mIdType, paramInt), paramLong);
  }
  
  public void seekMusicToPosInMS(int paramInt1, int paramInt2) {
    nativeSeekToTime(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
  }
  
  public void setAllMusicVolume(int paramInt) {
    nativeSetAllVolume(paramInt);
  }
  
  public void setAudioPlayoutVolume(int paramInt) {
    float f = paramInt / 100.0F;
    TXCAudioEngine.getInstance().setMixingPlayoutVolume(f);
  }
  
  public void setMusicChangerType(int paramInt1, int paramInt2) {
    nativeSetChangerType(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
  }
  
  public void setMusicObserver(final int id, final TXAudioEffectManager.TXMusicPlayObserver observer) {
    Runnable runnable = new Runnable() {
        public void run() {
          if (observer == null) {
            TXAudioEffectManagerImpl.mMusicObserverMap.remove(Long.valueOf(TXAudioEffectManagerImpl.convertIdToInt64(TXAudioEffectManagerImpl.this.mIdType, id)));
          } else {
            TXAudioEffectManagerImpl.mMusicObserverMap.put(Long.valueOf(TXAudioEffectManagerImpl.convertIdToInt64(TXAudioEffectManagerImpl.this.mIdType, id)), observer);
          } 
          TXCLog.i("AudioCenter:TXAudioEffectManager", "setMusicObserver map count: %d", new Object[] { Integer.valueOf(TXAudioEffectManagerImpl.access$600().size()) });
        }
      };
    if (Looper.myLooper() == mMainHandler.getLooper()) {
      runnable.run();
      return;
    } 
    mMainHandler.post(runnable);
  }
  
  public void setMusicPitch(int paramInt, float paramFloat) {
    nativeSetPitch(convertIdToInt64(this.mIdType, paramInt), paramFloat);
  }
  
  public void setMusicPlayoutSpeedRate(int paramInt, float paramFloat) {
    nativeSetPlayoutSpeedRate(convertIdToInt64(this.mIdType, paramInt), paramFloat);
  }
  
  public void setMusicPlayoutVolume(int paramInt1, int paramInt2) {
    nativeSetPlayoutVolume(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
  }
  
  public void setMusicPublishVolume(int paramInt1, int paramInt2) {
    nativeSetPublishVolume(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
  }
  
  public void setMusicReverbType(int paramInt1, int paramInt2) {
    nativeSetReverbType(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
  }
  
  public void setMusicSpeedRate(int paramInt, float paramFloat) {
    nativeSetSpeedRate(convertIdToInt64(this.mIdType, paramInt), paramFloat);
  }
  
  public void setMusicVolume(int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setMusicVolume ");
    stringBuilder.append(paramInt2);
    TXCLog.i("AudioCenter:TXAudioEffectManager", stringBuilder.toString());
    nativeSetVolume(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
  }
  
  public void setMuteDataDurationToPublish(int paramInt1, int paramInt2) {
    nativeSetMuteDataDurationToPublish(convertIdToInt64(this.mIdType, paramInt1), paramInt2);
  }
  
  public void setVoiceCaptureVolume(int paramInt) {
    float f = paramInt / 100.0F;
    TXCAudioEngine.getInstance().setSoftwareCaptureVolume(f);
  }
  
  public void setVoiceChangerType(TXAudioEffectManager.TXVoiceChangerType paramTXVoiceChangerType) {
    TXCAudioEngine.getInstance().setVoiceChangerType(paramTXVoiceChangerType);
  }
  
  public void setVoiceEarMonitorVolume(int paramInt) {
    TXCAudioEngine.setAudioEarMonitoringVolume(paramInt);
  }
  
  public void setVoiceReverbType(TXAudioEffectManager.TXVoiceReverbType paramTXVoiceReverbType) {
    TXCAudioEngine.getInstance().setReverbType(paramTXVoiceReverbType);
  }
  
  public boolean startPlayMusic(TXAudioEffectManager.AudioMusicParam paramAudioMusicParam) {
    TXCLog.i("AudioCenter:TXAudioEffectManager", "startPlay");
    long l1 = paramAudioMusicParam.startTimeMS;
    long l2 = paramAudioMusicParam.endTimeMS;
    if (l1 < 0L)
      l1 = 0L; 
    if (l2 < 0L)
      l2 = 0L; 
    long l3 = convertIdToInt64(this.mIdType, paramAudioMusicParam.id);
    if (!this.mPlayingMusicIDList.contains(Long.valueOf(l3)))
      this.mPlayingMusicIDList.add(Long.valueOf(l3)); 
    nativeStartPlayRange(l3, l1, l2);
    return nativeStartPlay(l3, paramAudioMusicParam.path, paramAudioMusicParam.loopCount, paramAudioMusicParam.publish, paramAudioMusicParam.isShortFile);
  }
  
  public void stopAllMusics() {
    TXCLog.i("AudioCenter:TXAudioEffectManager", "stopAllMusics");
    Iterator<Long> iterator = this.mPlayingMusicIDList.iterator();
    while (iterator.hasNext()) {
      final long finalId = ((Long)iterator.next()).longValue();
      nativeStopPlay(l);
      mMainHandler.post(new Runnable() {
            public void run() {
              TXAudioEffectManagerImpl.mMusicObserverMap.remove(Long.valueOf(finalId));
            }
          });
    } 
    this.mPlayingMusicIDList.clear();
  }
  
  public void stopPlayMusic(int paramInt) {
    long l = convertIdToInt64(this.mIdType, paramInt);
    this.mPlayingMusicIDList.remove(Long.valueOf(l));
    nativeStopPlay(l);
  }
  
  static class AudioEffectManagerAutoCacheHolder {
    private static final TXAudioEffectManagerImpl INSTANCE = new TXAudioEffectManagerImpl(1);
  }
  
  static class AudioEffectManagerCacheHolder {
    private static final TXAudioEffectManagerImpl INSTANCE = new TXAudioEffectManagerImpl(2);
  }
  
  static class AudioEffectManagerHolder {
    private static final TXAudioEffectManagerImpl INSTANCE = new TXAudioEffectManagerImpl(0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\audio\TXAudioEffectManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */