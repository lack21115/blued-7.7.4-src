package com.tencent.liteav.audio.impl.earmonitor;

import android.content.Context;

public interface TXSystemAudioKit {
  void initialize(Context paramContext, a parama);
  
  void setSystemEarMonitoringVolume(int paramInt);
  
  void startSystemEarMonitoring();
  
  void stopSystemEarMonitoring();
  
  void uninitialize();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\tencent\liteav\audio\impl\earmonitor\TXSystemAudioKit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */