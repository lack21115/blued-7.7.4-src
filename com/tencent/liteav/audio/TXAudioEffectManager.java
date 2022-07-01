package com.tencent.liteav.audio;

public interface TXAudioEffectManager {
  void enableVoiceEarMonitor(boolean paramBoolean);
  
  long getMusicCurrentPosInMS(int paramInt);
  
  long getMusicDurationInMS(String paramString);
  
  void pausePlayMusic(int paramInt);
  
  void resumePlayMusic(int paramInt);
  
  void seekMusicToPosInMS(int paramInt1, int paramInt2);
  
  void setAllMusicVolume(int paramInt);
  
  void setMusicObserver(int paramInt, TXMusicPlayObserver paramTXMusicPlayObserver);
  
  void setMusicPitch(int paramInt, float paramFloat);
  
  void setMusicPlayoutVolume(int paramInt1, int paramInt2);
  
  void setMusicPublishVolume(int paramInt1, int paramInt2);
  
  void setMusicSpeedRate(int paramInt, float paramFloat);
  
  void setVoiceCaptureVolume(int paramInt);
  
  void setVoiceChangerType(TXVoiceChangerType paramTXVoiceChangerType);
  
  void setVoiceEarMonitorVolume(int paramInt);
  
  void setVoiceReverbType(TXVoiceReverbType paramTXVoiceReverbType);
  
  boolean startPlayMusic(AudioMusicParam paramAudioMusicParam);
  
  void stopPlayMusic(int paramInt);
  
  public static class AudioMusicParam {
    public long endTimeMS;
    
    public int id;
    
    public boolean isShortFile;
    
    public int loopCount;
    
    public String path;
    
    public boolean publish;
    
    public long startTimeMS;
    
    public AudioMusicParam(int param1Int, String param1String) {
      this.path = param1String;
      this.id = param1Int;
      this.loopCount = 0;
      this.publish = false;
      this.isShortFile = false;
      this.startTimeMS = 0L;
      this.endTimeMS = -1L;
    }
  }
  
  public static interface TXMusicPlayObserver {
    void onComplete(int param1Int1, int param1Int2);
    
    void onPlayProgress(int param1Int, long param1Long1, long param1Long2);
    
    void onStart(int param1Int1, int param1Int2);
  }
  
  public enum TXVoiceChangerType {
    TXLiveVoiceChangerType_0(0),
    TXLiveVoiceChangerType_1(1),
    TXLiveVoiceChangerType_10(1),
    TXLiveVoiceChangerType_11(1),
    TXLiveVoiceChangerType_2(2),
    TXLiveVoiceChangerType_3(3),
    TXLiveVoiceChangerType_4(4),
    TXLiveVoiceChangerType_5(5),
    TXLiveVoiceChangerType_6(6),
    TXLiveVoiceChangerType_7(7),
    TXLiveVoiceChangerType_8(8),
    TXLiveVoiceChangerType_9(9);
    
    private int nativeValue;
    
    static {
      $VALUES = new TXVoiceChangerType[] { 
          TXLiveVoiceChangerType_0, TXLiveVoiceChangerType_1, TXLiveVoiceChangerType_2, TXLiveVoiceChangerType_3, TXLiveVoiceChangerType_4, TXLiveVoiceChangerType_5, TXLiveVoiceChangerType_6, TXLiveVoiceChangerType_7, TXLiveVoiceChangerType_8, TXLiveVoiceChangerType_9, 
          TXLiveVoiceChangerType_10, TXLiveVoiceChangerType_11 };
    }
    
    TXVoiceChangerType(int param1Int1) {
      this.nativeValue = param1Int1;
    }
    
    public int getNativeValue() {
      return this.nativeValue;
    }
  }
  
  public enum TXVoiceReverbType {
    TXLiveVoiceReverbType_0(0),
    TXLiveVoiceReverbType_1(1),
    TXLiveVoiceReverbType_2(2),
    TXLiveVoiceReverbType_3(3),
    TXLiveVoiceReverbType_4(4),
    TXLiveVoiceReverbType_5(5),
    TXLiveVoiceReverbType_6(6),
    TXLiveVoiceReverbType_7(7);
    
    private int nativeValue;
    
    static {
    
    }
    
    TXVoiceReverbType(int param1Int1) {
      this.nativeValue = param1Int1;
    }
    
    public int getNativeValue() {
      return this.nativeValue;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\audio\TXAudioEffectManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */