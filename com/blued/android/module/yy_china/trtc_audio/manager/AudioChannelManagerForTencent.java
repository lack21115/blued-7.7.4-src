package com.blued.android.module.yy_china.trtc_audio.manager;

import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.yy_china.trtc_audio.IAudioContract;
import com.blued.android.module.yy_china.trtc_audio.model.GenerateTestUserSig;
import com.blued.android.module.yy_china.trtc_audio.model.TrtcMusicModel;
import com.blued.android.module.yy_china.trtc_audio.model.YYAudioConfig;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class AudioChannelManagerForTencent implements IAudioContract.IAudioControl {
  private TRTCCloud a;
  
  private IAudioContract.IAudioCallback b;
  
  private HashMap<Integer, TrtcMusicModel> c;
  
  private TRTCCloudListener f() {
    return new TRTCCloudListener(this) {
        public void onConnectionLost() {
          Logger.d("ulog", new Object[] { " -- onConnectionLost " });
          if (AudioChannelManagerForTencent.b(this.a) != null)
            AudioChannelManagerForTencent.b(this.a).a(); 
        }
        
        public void onConnectionRecovery() {
          super.onConnectionRecovery();
          Logger.d("ulog", new Object[] { " -- onConnectionRecovery " });
          if (AudioChannelManagerForTencent.b(this.a) != null)
            AudioChannelManagerForTencent.b(this.a).b(); 
        }
        
        public void onEnterRoom(long param1Long) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(" -- 自己进入房间 返回码 ");
          stringBuilder.append(param1Long);
          Logger.d("ulog", new Object[] { stringBuilder.toString() });
          if (AudioChannelManagerForTencent.b(this.a) != null)
            AudioChannelManagerForTencent.b(this.a).a(param1Long); 
        }
        
        public void onError(int param1Int, String param1String, Bundle param1Bundle) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(" -- onError ");
          stringBuilder.append(param1String);
          Logger.d("ulog", new Object[] { stringBuilder.toString() });
          if (AudioChannelManagerForTencent.b(this.a) != null)
            AudioChannelManagerForTencent.b(this.a).c(param1String); 
        }
        
        public void onRemoteUserEnterRoom(String param1String) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(" -- 远端进入房间 返回码 ");
          stringBuilder.append(param1String);
          Logger.d("ulog", new Object[] { stringBuilder.toString() });
          if (AudioChannelManagerForTencent.b(this.a) != null)
            AudioChannelManagerForTencent.b(this.a).a(param1String); 
        }
        
        public void onRemoteUserLeaveRoom(String param1String, int param1Int) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(" -- onRemoteUserLeaveRoom ");
          stringBuilder.append(param1String);
          stringBuilder.append("; code： ");
          stringBuilder.append(param1Int);
          Logger.d("ulog", new Object[] { stringBuilder.toString() });
          if (AudioChannelManagerForTencent.b(this.a) != null)
            AudioChannelManagerForTencent.b(this.a).b(param1String); 
        }
        
        public void onStartPublishCDNStream(int param1Int, String param1String) {
          if (AudioChannelManagerForTencent.b(this.a) != null)
            AudioChannelManagerForTencent.b(this.a).a(param1Int, param1String); 
        }
        
        public void onStopPublishCDNStream(int param1Int, String param1String) {
          if (AudioChannelManagerForTencent.b(this.a) != null)
            AudioChannelManagerForTencent.b(this.a).b(param1Int, param1String); 
        }
        
        public void onSwitchRole(int param1Int, String param1String) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(" -- 切换角色 i: ");
          stringBuilder.append(param1Int);
          stringBuilder.append(" ; s: ");
          stringBuilder.append(param1String);
          Logger.d("ulog", new Object[] { stringBuilder.toString() });
          if (AudioChannelManagerForTencent.b(this.a) != null)
            AudioChannelManagerForTencent.b(this.a).a(param1Int); 
        }
        
        public void onTryToReconnect() {
          super.onTryToReconnect();
          Logger.d("ulog", new Object[] { " -- onTryToReconnect " });
        }
        
        public void onUserAudioAvailable(String param1String, boolean param1Boolean) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(" -- ");
          stringBuilder.append(param1Boolean);
          stringBuilder.append(" onUserAudioAvailable  ");
          stringBuilder.append(param1String);
          Logger.d("ulog", new Object[] { stringBuilder.toString() });
          if (AudioChannelManagerForTencent.b(this.a) != null)
            AudioChannelManagerForTencent.b(this.a).a(param1String, param1Boolean); 
        }
        
        public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> param1ArrayList, int param1Int) {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("onUserVoiceVolume  -------------------------------------  ");
          stringBuilder2.append(param1ArrayList.size());
          Logger.d("ulog", new Object[] { stringBuilder2.toString() });
          if (param1ArrayList.isEmpty())
            return; 
          TreeSet<String> treeSet = new TreeSet();
          for (TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo : param1ArrayList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" -- talking user: ");
            stringBuilder.append(tRTCVolumeInfo.userId);
            stringBuilder.append(" <---> volume: ");
            stringBuilder.append(tRTCVolumeInfo.volume);
            Logger.d("ulog", new Object[] { stringBuilder.toString() });
            if (tRTCVolumeInfo.volume < 60)
              continue; 
            treeSet.add(tRTCVolumeInfo.userId);
          } 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(" -- talking user: ");
          stringBuilder1.append(Arrays.toString(treeSet.toArray((Object[])new String[0])));
          Logger.d("ulog", new Object[] { stringBuilder1.toString() });
          if (AudioChannelManagerForTencent.b(this.a) != null)
            AudioChannelManagerForTencent.b(this.a).a(treeSet); 
        }
      };
  }
  
  public void a() {
    if (this.a == null);
  }
  
  public void a(int paramInt) {
    TRTCCloud tRTCCloud = this.a;
    if (tRTCCloud == null)
      return; 
    tRTCCloud.switchRole(paramInt);
    if (paramInt == 20) {
      this.a.startLocalAudio();
      return;
    } 
    this.a.stopLocalAudio();
  }
  
  public void a(int paramInt, IAudioContract.IMusicCallback paramIMusicCallback) {
    this.a.getAudioEffectManager().setMusicObserver(paramInt, new TXAudioEffectManager.TXMusicPlayObserver(this, paramInt, paramIMusicCallback) {
          public void onComplete(int param1Int1, int param1Int2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" -- onComplete id:");
            stringBuilder.append(param1Int1);
            stringBuilder.append(", errCode:");
            stringBuilder.append(param1Int2);
            Logger.d("ulog", new Object[] { stringBuilder.toString() });
            if (AudioChannelManagerForTencent.a(this.c) != null)
              AudioChannelManagerForTencent.a(this.c).remove(Integer.valueOf(param1Int1)); 
            IAudioContract.IMusicCallback iMusicCallback = this.b;
            if (iMusicCallback != null)
              iMusicCallback.b(param1Int1, param1Int2); 
          }
          
          public void onPlayProgress(int param1Int, long param1Long1, long param1Long2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" -- onPlayProgress id:");
            stringBuilder.append(param1Int);
            stringBuilder.append(", curPtsMS:");
            stringBuilder.append(param1Long1);
            stringBuilder.append(", durationMS:");
            stringBuilder.append(param1Long2);
            Logger.d("ulog", new Object[] { stringBuilder.toString() });
            if (AudioChannelManagerForTencent.a(this.c) == null)
              return; 
            TrtcMusicModel trtcMusicModel = (TrtcMusicModel)AudioChannelManagerForTencent.a(this.c).get(Integer.valueOf(param1Int));
            if (trtcMusicModel == null)
              return; 
            trtcMusicModel.c = param1Long1;
            trtcMusicModel.d = param1Long2;
            IAudioContract.IMusicCallback iMusicCallback = this.b;
            if (iMusicCallback != null)
              iMusicCallback.a(trtcMusicModel); 
          }
          
          public void onStart(int param1Int1, int param1Int2) {
            if (AudioChannelManagerForTencent.a(this.c) == null)
              AudioChannelManagerForTencent.a(this.c, new HashMap<Object, Object>()); 
            TrtcMusicModel trtcMusicModel2 = (TrtcMusicModel)AudioChannelManagerForTencent.a(this.c).get(Integer.valueOf(param1Int1));
            TrtcMusicModel trtcMusicModel1 = trtcMusicModel2;
            if (trtcMusicModel2 == null)
              trtcMusicModel1 = new TrtcMusicModel(); 
            trtcMusicModel1.a = param1Int1;
            trtcMusicModel1.b = param1Int2;
            AudioChannelManagerForTencent.a(this.c).put(Integer.valueOf(this.a), trtcMusicModel1);
            IAudioContract.IMusicCallback iMusicCallback = this.b;
            if (iMusicCallback != null)
              iMusicCallback.a(param1Int1, param1Int2); 
          }
        });
  }
  
  public void a(int paramInt, String paramString) {
    if (this.a == null)
      return; 
    TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(paramInt, paramString);
    audioMusicParam.loopCount = 0;
    audioMusicParam.publish = true;
    this.a.getAudioEffectManager().setMusicPublishVolume(1, 5);
    this.a.getAudioEffectManager().setMusicPlayoutVolume(1, 5);
    this.a.getAudioEffectManager().setMusicPublishVolume(2, 70);
    this.a.getAudioEffectManager().setMusicPlayoutVolume(2, 70);
    this.a.getAudioEffectManager().startPlayMusic(audioMusicParam);
  }
  
  public void a(IAudioContract.IAudioCallback paramIAudioCallback) {
    this.b = paramIAudioCallback;
    this.a = TRTCCloud.sharedInstance(AppInfo.d());
    this.a.setListener(f());
    this.a.enableAudioVolumeEvaluation(2000);
  }
  
  public void a(YYAudioConfig paramYYAudioConfig) {
    if (this.a == null)
      return; 
    Logger.d("ulog", new Object[] { " setupChannel--  腾讯云 开房" });
    TRTCCloudDef.TRTCParams tRTCParams = new TRTCCloudDef.TRTCParams();
    tRTCParams.sdkAppId = GenerateTestUserSig.a();
    tRTCParams.userId = paramYYAudioConfig.c;
    tRTCParams.roomId = 0;
    tRTCParams.strRoomId = paramYYAudioConfig.b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(GenerateTestUserSig.b());
    stringBuilder.append("_");
    stringBuilder.append(paramYYAudioConfig.b);
    stringBuilder.append("_");
    stringBuilder.append(paramYYAudioConfig.c);
    stringBuilder.append("_");
    stringBuilder.append(System.currentTimeMillis());
    tRTCParams.streamId = stringBuilder.toString();
    if (TextUtils.isEmpty(paramYYAudioConfig.a)) {
      tRTCParams.userSig = GenerateTestUserSig.a(tRTCParams.userId);
    } else {
      tRTCParams.userSig = paramYYAudioConfig.a;
    } 
    tRTCParams.role = paramYYAudioConfig.d;
    stringBuilder = new StringBuilder();
    stringBuilder.append("加入角色  20主播 21普通：   ");
    stringBuilder.append(paramYYAudioConfig.d);
    Logger.d("ulog", new Object[] { stringBuilder.toString() });
    this.a.enterRoom(tRTCParams, 3);
    a(paramYYAudioConfig.d);
  }
  
  public void a(TRTCCloudDef.TRTCPublishCDNParam paramTRTCPublishCDNParam) {
    TRTCCloud tRTCCloud = this.a;
    if (tRTCCloud == null)
      return; 
    tRTCCloud.startPublishCDNStream(paramTRTCPublishCDNParam);
  }
  
  public void a(boolean paramBoolean) {
    TRTCCloud tRTCCloud = this.a;
    if (tRTCCloud == null)
      return; 
    if (paramBoolean) {
      tRTCCloud.setAudioCaptureVolume(0);
      return;
    } 
    tRTCCloud.setAudioCaptureVolume(100);
  }
  
  public void b() {
    if (this.a == null);
  }
  
  public void b(int paramInt) {
    TRTCCloud tRTCCloud = this.a;
    if (tRTCCloud == null)
      return; 
    tRTCCloud.getAudioEffectManager().resumePlayMusic(paramInt);
  }
  
  public void b(IAudioContract.IAudioCallback paramIAudioCallback) {
    if (this.a != null) {
      if (paramIAudioCallback == null)
        return; 
      this.b = paramIAudioCallback;
    } 
  }
  
  public void c() {
    HashMap<Integer, TrtcMusicModel> hashMap = this.c;
    if (hashMap != null) {
      Iterator<Integer> iterator = hashMap.keySet().iterator();
      while (iterator.hasNext())
        d(((Integer)iterator.next()).intValue()); 
      this.c.clear();
    } 
    e();
    TRTCCloud.destroySharedInstance();
  }
  
  public void c(int paramInt) {
    TRTCCloud tRTCCloud = this.a;
    if (tRTCCloud == null)
      return; 
    tRTCCloud.getAudioEffectManager().pausePlayMusic(paramInt);
  }
  
  public void d() {
    TRTCCloud tRTCCloud = this.a;
    if (tRTCCloud == null)
      return; 
    tRTCCloud.stopPublishCDNStream();
  }
  
  public void d(int paramInt) {
    this.a.getAudioEffectManager().stopPlayMusic(paramInt);
  }
  
  public void e() {
    if (this.a == null)
      return; 
    d();
    this.a.stopLocalAudio();
    this.a.exitRoom();
    Logger.d("ulog", new Object[] { "腾讯云 leaveChannel  " });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\trtc_audio\manager\AudioChannelManagerForTencent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */