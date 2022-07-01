package com.blued.android.module.yy_china.trtc_audio.manager;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.framework.utils.AudioManagerUtils;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.trtc_audio.IAudioContract;
import com.blued.android.module.yy_china.trtc_audio.float_window.AudioFloatWindow;
import com.blued.android.module.yy_china.trtc_audio.model.TrtcMusicModel;
import com.blued.android.module.yy_china.trtc_audio.model.YYAudioConfig;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.tencent.trtc.TRTCCloudDef;

public class AudioChannelManager implements IAudioContract.IAudioControl {
  private static volatile AudioChannelManager b;
  
  public boolean a = false;
  
  private IAudioContract.IAudioControl c;
  
  private IAudioContract.AppHandoverListener d;
  
  private AudioFloatWindow e;
  
  private void b(Context paramContext) {
    AudioFloatWindow audioFloatWindow = this.e;
    if (audioFloatWindow != null)
      audioFloatWindow.b(); 
    AudioManagerUtils.a().b();
    this.e = new AudioFloatWindow(paramContext);
    this.e.a();
  }
  
  public static AudioChannelManager e() {
    // Byte code:
    //   0: ldc com/blued/android/module/yy_china/trtc_audio/manager/AudioChannelManager
    //   2: monitorenter
    //   3: getstatic com/blued/android/module/yy_china/trtc_audio/manager/AudioChannelManager.b : Lcom/blued/android/module/yy_china/trtc_audio/manager/AudioChannelManager;
    //   6: ifnonnull -> 40
    //   9: ldc com/blued/android/module/yy_china/trtc_audio/manager/AudioChannelManager
    //   11: monitorenter
    //   12: getstatic com/blued/android/module/yy_china/trtc_audio/manager/AudioChannelManager.b : Lcom/blued/android/module/yy_china/trtc_audio/manager/AudioChannelManager;
    //   15: ifnonnull -> 28
    //   18: new com/blued/android/module/yy_china/trtc_audio/manager/AudioChannelManager
    //   21: dup
    //   22: invokespecial <init> : ()V
    //   25: putstatic com/blued/android/module/yy_china/trtc_audio/manager/AudioChannelManager.b : Lcom/blued/android/module/yy_china/trtc_audio/manager/AudioChannelManager;
    //   28: ldc com/blued/android/module/yy_china/trtc_audio/manager/AudioChannelManager
    //   30: monitorexit
    //   31: goto -> 40
    //   34: astore_0
    //   35: ldc com/blued/android/module/yy_china/trtc_audio/manager/AudioChannelManager
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    //   40: getstatic com/blued/android/module/yy_china/trtc_audio/manager/AudioChannelManager.b : Lcom/blued/android/module/yy_china/trtc_audio/manager/AudioChannelManager;
    //   43: astore_0
    //   44: ldc com/blued/android/module/yy_china/trtc_audio/manager/AudioChannelManager
    //   46: monitorexit
    //   47: aload_0
    //   48: areturn
    //   49: astore_0
    //   50: ldc com/blued/android/module/yy_china/trtc_audio/manager/AudioChannelManager
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    // Exception table:
    //   from	to	target	type
    //   3	12	49	finally
    //   12	28	34	finally
    //   28	31	34	finally
    //   35	38	34	finally
    //   38	40	49	finally
    //   40	44	49	finally
  }
  
  public void a() {
    IAudioContract.IAudioControl iAudioControl = this.c;
    if (iAudioControl == null)
      return; 
    iAudioControl.a();
    IAudioContract.AppHandoverListener appHandoverListener = this.d;
    if (appHandoverListener != null)
      appHandoverListener.b(); 
  }
  
  public void a(int paramInt) {
    IAudioContract.IAudioControl iAudioControl = this.c;
    if (iAudioControl == null)
      return; 
    iAudioControl.a(paramInt);
  }
  
  public void a(int paramInt, IAudioContract.IMusicCallback paramIMusicCallback) {
    IAudioContract.IAudioControl iAudioControl = this.c;
    if (iAudioControl == null)
      return; 
    iAudioControl.a(paramInt, paramIMusicCallback);
  }
  
  public void a(int paramInt, String paramString) {
    IAudioContract.IAudioControl iAudioControl = this.c;
    if (iAudioControl == null)
      return; 
    iAudioControl.a(paramInt, new IAudioContract.IMusicCallback(this, paramInt) {
          public void a(int param1Int1, int param1Int2) {
            if (param1Int1 != 1)
              return; 
            LiveEventBus.get("live_music_changed").post("");
          }
          
          public void a(TrtcMusicModel param1TrtcMusicModel) {
            if (this.a != 1)
              return; 
            LiveEventBus.get("live_music_play_progress").post(param1TrtcMusicModel);
          }
          
          public void b(int param1Int1, int param1Int2) {
            if (param1Int1 != 1)
              return; 
            LiveMusicModel liveMusicModel = YYRoomInfoManager.d().n();
            if (liveMusicModel != null) {
              YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
              if (yYRoomModel != null)
                EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_MUSIC_DONE_CLICK, yYRoomModel.room_id, liveMusicModel.sheet_id, liveMusicModel.music_id, (int)liveMusicModel.duration); 
              liveMusicModel.playStatus = 3;
            } 
            LiveEventBus.get("live_music_changed").post("");
          }
        });
    this.c.a(paramInt, paramString);
  }
  
  public void a(Context paramContext) {
    if (!(e()).a) {
      c();
      return;
    } 
    b(paramContext);
  }
  
  public void a(IAudioContract.AppHandoverListener paramAppHandoverListener) {
    this.d = paramAppHandoverListener;
  }
  
  public void a(IAudioContract.IAudioCallback paramIAudioCallback) {
    IAudioContract.IAudioControl iAudioControl = this.c;
    if (iAudioControl != null) {
      iAudioControl.b(paramIAudioCallback);
      return;
    } 
    this.c = new AudioChannelManagerForTencent();
    this.c.a(paramIAudioCallback);
  }
  
  public void a(YYAudioConfig paramYYAudioConfig) {
    if (this.c != null && paramYYAudioConfig != null) {
      if (TextUtils.isEmpty(paramYYAudioConfig.c))
        return; 
      this.c.a(paramYYAudioConfig);
    } 
  }
  
  public void a(TRTCCloudDef.TRTCPublishCDNParam paramTRTCPublishCDNParam) {
    IAudioContract.IAudioControl iAudioControl = this.c;
    if (iAudioControl == null)
      return; 
    iAudioControl.a(paramTRTCPublishCDNParam);
  }
  
  public void a(String paramString) {
    AudioFloatWindow audioFloatWindow = this.e;
    if (audioFloatWindow != null) {
      audioFloatWindow.b(paramString);
      this.e = null;
      return;
    } 
    YYRoomInfoManager.d().o();
  }
  
  public void a(boolean paramBoolean) {
    IAudioContract.IAudioControl iAudioControl = this.c;
    if (iAudioControl == null)
      return; 
    iAudioControl.a(paramBoolean);
  }
  
  public void b() {
    IAudioContract.IAudioControl iAudioControl = this.c;
    if (iAudioControl == null)
      return; 
    iAudioControl.b();
    IAudioContract.AppHandoverListener appHandoverListener = this.d;
    if (appHandoverListener != null)
      appHandoverListener.a(); 
  }
  
  public void b(int paramInt) {
    IAudioContract.IAudioControl iAudioControl = this.c;
    if (iAudioControl == null)
      return; 
    iAudioControl.b(paramInt);
  }
  
  public void b(IAudioContract.IAudioCallback paramIAudioCallback) {
    IAudioContract.IAudioControl iAudioControl = this.c;
    if (iAudioControl == null)
      return; 
    iAudioControl.b(paramIAudioCallback);
  }
  
  public void c() {
    if (this.c == null)
      return; 
    f();
    this.c.c();
    this.c = null;
    this.a = false;
    this.d = null;
  }
  
  public void c(int paramInt) {
    IAudioContract.IAudioControl iAudioControl = this.c;
    if (iAudioControl == null)
      return; 
    iAudioControl.c(paramInt);
  }
  
  public void d() {
    IAudioContract.IAudioControl iAudioControl = this.c;
    if (iAudioControl == null)
      return; 
    iAudioControl.d();
  }
  
  public void d(int paramInt) {
    IAudioContract.IAudioControl iAudioControl = this.c;
    if (iAudioControl == null)
      return; 
    iAudioControl.d(paramInt);
  }
  
  public void f() {
    AudioFloatWindow audioFloatWindow = this.e;
    if (audioFloatWindow != null) {
      audioFloatWindow.b();
      this.e = null;
    } 
  }
  
  public void g() {
    if (this.e != null)
      this.e = null; 
  }
  
  public boolean h() {
    return (this.e != null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\trtc_audio\manager\AudioChannelManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */