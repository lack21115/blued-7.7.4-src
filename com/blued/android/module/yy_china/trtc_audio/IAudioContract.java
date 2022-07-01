package com.blued.android.module.yy_china.trtc_audio;

import com.blued.android.module.yy_china.trtc_audio.model.TrtcMusicModel;
import com.blued.android.module.yy_china.trtc_audio.model.YYAudioConfig;
import com.tencent.trtc.TRTCCloudDef;
import java.util.Set;

public interface IAudioContract {
  public static interface AppHandoverListener {
    void a();
    
    void b();
  }
  
  public static interface IAudioCallback {
    void a();
    
    void a(int param1Int);
    
    void a(int param1Int, String param1String);
    
    void a(long param1Long);
    
    void a(String param1String);
    
    void a(String param1String, boolean param1Boolean);
    
    void a(Set<String> param1Set);
    
    void b();
    
    void b(int param1Int, String param1String);
    
    void b(String param1String);
    
    void c(String param1String);
  }
  
  public static interface IAudioControl {
    void a();
    
    void a(int param1Int);
    
    void a(int param1Int, IAudioContract.IMusicCallback param1IMusicCallback);
    
    void a(int param1Int, String param1String);
    
    void a(IAudioContract.IAudioCallback param1IAudioCallback);
    
    void a(YYAudioConfig param1YYAudioConfig);
    
    void a(TRTCCloudDef.TRTCPublishCDNParam param1TRTCPublishCDNParam);
    
    void a(boolean param1Boolean);
    
    void b();
    
    void b(int param1Int);
    
    void b(IAudioContract.IAudioCallback param1IAudioCallback);
    
    void c();
    
    void c(int param1Int);
    
    void d();
    
    void d(int param1Int);
  }
  
  public static interface IMusicCallback {
    void a(int param1Int1, int param1Int2);
    
    void a(TrtcMusicModel param1TrtcMusicModel);
    
    void b(int param1Int1, int param1Int2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\trtc_audio\IAudioContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */