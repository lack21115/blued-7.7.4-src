package com.blued.android.module.live_china.common;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveMusicModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.zego.zegoavkit2.ZegoMediaPlayer;
import com.zego.zegoliveroom.ZegoLiveRoom;
import com.zego.zegoliveroom.callback.IZegoInitSDKCompletionCallback;
import com.zego.zegoliveroom.callback.IZegoLogHookCallback;
import com.zego.zegoliveroom.constants.ZegoAvConfig;

public class ZegoCommonHelper {
  public static String a = "BluedSolutionRoom_1";
  
  public static String b = "zego-joinlive-stream-anchor-1";
  
  public static String c = "zego-joinlive-stream-anchor-2";
  
  public static String d = "zego-joinlive-stream-anchor";
  
  public static String e = "zego-joinlive-stream-audience1";
  
  private static ZegoCommonHelper o;
  
  private static boolean s = false;
  
  public String f = "";
  
  public String g = "";
  
  public int h = 544;
  
  public int i = 960;
  
  public int j;
  
  public int k;
  
  public int l = 15;
  
  public int m = 368640;
  
  private ZegoLiveRoom n = null;
  
  private ZegoMediaPlayer p = null;
  
  private int q = 0;
  
  private LiveMusicModel r;
  
  private InitProccessState t = InitProccessState.a;
  
  private boolean u = false;
  
  private int v = 0;
  
  public static void a() {
    try {
      b().a((String)null, (String)null, 10485760L, (Application)AppInfo.d());
      s = true;
      return;
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      unsatisfiedLinkError.printStackTrace();
      return;
    } 
  }
  
  public static ZegoCommonHelper b() {
    // Byte code:
    //   0: ldc com/blued/android/module/live_china/common/ZegoCommonHelper
    //   2: monitorenter
    //   3: getstatic com/blued/android/module/live_china/common/ZegoCommonHelper.o : Lcom/blued/android/module/live_china/common/ZegoCommonHelper;
    //   6: ifnonnull -> 19
    //   9: new com/blued/android/module/live_china/common/ZegoCommonHelper
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/blued/android/module/live_china/common/ZegoCommonHelper.o : Lcom/blued/android/module/live_china/common/ZegoCommonHelper;
    //   19: ldc com/blued/android/module/live_china/common/ZegoCommonHelper
    //   21: monitorexit
    //   22: getstatic com/blued/android/module/live_china/common/ZegoCommonHelper.o : Lcom/blued/android/module/live_china/common/ZegoCommonHelper;
    //   25: areturn
    //   26: astore_0
    //   27: ldc com/blued/android/module/live_china/common/ZegoCommonHelper
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	26	finally
    //   19	22	26	finally
    //   27	30	26	finally
  }
  
  public void a(int paramInt) {
    if (LiveRoomManager.a().h() != null) {
      this.q = (LiveRoomManager.a().h()).stream_level;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("set level:");
      stringBuilder1.append(this.q);
      Log.i("==record", stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("state:");
    stringBuilder.append(paramInt);
    Log.i("==record", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("level:");
    stringBuilder.append(this.q);
    Log.i("==record", stringBuilder.toString());
    if (paramInt == 0) {
      paramInt = this.q;
      if (paramInt == 0) {
        this.j = 544;
        this.k = 960;
        this.l = 15;
        this.m = 1024000;
      } else if (paramInt == 1) {
        this.j = 544;
        this.k = 960;
        this.l = 15;
        this.m = 1228800;
      } else if (paramInt == 2) {
        this.j = 544;
        this.k = 960;
        this.l = 18;
        this.m = 1228800;
      } else if (paramInt == 3) {
        this.j = 544;
        this.k = 960;
        this.l = 20;
        this.m = 1228800;
      } else if (paramInt == 4) {
        this.j = 720;
        this.k = 1280;
        this.l = 20;
        this.m = 1843200;
      } 
      this.h = this.j;
      this.i = this.k;
      return;
    } 
    if (1 == paramInt) {
      paramInt = this.q;
      if (paramInt == 0) {
        this.j = 480;
        this.k = 848;
        this.l = 15;
        this.m = 819200;
        return;
      } 
      if (paramInt == 1) {
        this.j = 480;
        this.k = 848;
        this.l = 15;
        this.m = 1024000;
        return;
      } 
      if (paramInt == 2) {
        this.j = 480;
        this.k = 848;
        this.l = 15;
        this.m = 1024000;
        return;
      } 
      if (paramInt == 3) {
        this.j = 480;
        this.k = 848;
        this.l = 20;
        this.m = 1024000;
        return;
      } 
      if (paramInt == 4) {
        this.j = 480;
        this.k = 848;
        this.l = 20;
        this.m = 1024000;
        return;
      } 
    } else {
      if (2 == paramInt || 3 == paramInt || 4 == paramInt) {
        paramInt = this.q;
        if (paramInt == 0) {
          this.j = 240;
          this.k = 424;
          this.l = 15;
          this.m = 368640;
          return;
        } 
        if (paramInt == 1) {
          this.j = 240;
          this.k = 424;
          this.l = 15;
          this.m = 409600;
          return;
        } 
        if (paramInt == 2) {
          this.j = 240;
          this.k = 424;
          this.l = 18;
          this.m = 409600;
          return;
        } 
        if (paramInt == 3) {
          this.j = 240;
          this.k = 424;
          this.l = 20;
          this.m = 409600;
          return;
        } 
        if (paramInt == 4) {
          this.j = 240;
          this.k = 424;
          this.l = 20;
          this.m = 409600;
        } 
        return;
      } 
      if (5 == paramInt || 6 == paramInt) {
        paramInt = this.q;
        if (paramInt == 0) {
          this.j = 272;
          this.k = 240;
          this.l = 15;
          this.m = 368640;
          return;
        } 
        if (paramInt == 1) {
          this.j = 272;
          this.k = 240;
          this.l = 15;
          this.m = 409600;
          return;
        } 
        if (paramInt == 2) {
          this.j = 272;
          this.k = 240;
          this.l = 18;
          this.m = 460800;
          return;
        } 
        if (paramInt == 3) {
          this.j = 272;
          this.k = 240;
          this.l = 20;
          this.m = 460800;
          return;
        } 
        if (paramInt == 4) {
          this.j = 272;
          this.k = 240;
          this.l = 20;
          this.m = 460800;
          return;
        } 
        return;
      } 
      if (8 == paramInt || 9 == paramInt) {
        paramInt = this.q;
        if (paramInt == 0) {
          this.j = 240;
          this.k = 240;
          this.l = 15;
          this.m = 368640;
          return;
        } 
        if (paramInt == 1) {
          this.j = 240;
          this.k = 240;
          this.l = 15;
          this.m = 409600;
          return;
        } 
        if (paramInt == 2) {
          this.j = 240;
          this.k = 240;
          this.l = 18;
          this.m = 460800;
          return;
        } 
        if (paramInt == 3) {
          this.j = 240;
          this.k = 240;
          this.l = 20;
          this.m = 460800;
          return;
        } 
        if (paramInt == 4) {
          this.j = 240;
          this.k = 240;
          this.l = 20;
          this.m = 460800;
          return;
        } 
      } 
    } 
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setZegoAvConfig:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" height:");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" outputFps: ");
    stringBuilder.append(paramInt3);
    stringBuilder.append(" outputBitrate: ");
    stringBuilder.append(paramInt4 / 1024);
    Log.i("==record", stringBuilder.toString());
    ZegoAvConfig zegoAvConfig = new ZegoAvConfig(2);
    zegoAvConfig.setVideoCaptureResolution(paramInt1, paramInt2);
    zegoAvConfig.setVideoEncodeResolution(paramInt1, paramInt2);
    zegoAvConfig.setVideoBitrate(paramInt4);
    zegoAvConfig.setVideoFPS(paramInt3);
    ZegoLiveRoom zegoLiveRoom = this.n;
    if (zegoLiveRoom != null)
      zegoLiveRoom.setAVConfig(zegoAvConfig); 
  }
  
  public void a(long paramLong) {
    LiveMusicModel liveMusicModel = this.r;
    if (liveMusicModel != null)
      liveMusicModel.curDuration = paramLong; 
  }
  
  public void a(LiveMusicModel paramLiveMusicModel) {
    l();
    this.r = paramLiveMusicModel;
    d(1);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, Application paramApplication) {
    ZegoLiveRoom.setSDKContext((ZegoLiveRoom.SDKContext)new ZegoLiveRoom.SDKContextEx(this, paramLong, paramString2, paramString1, paramApplication) {
          public Application getAppContext() {
            return this.d;
          }
          
          public long getLogFileSize() {
            return this.a;
          }
          
          public IZegoLogHookCallback getLogHookCallback() {
            return null;
          }
          
          public String getLogPath() {
            return this.c;
          }
          
          public String getSoFullPath() {
            return this.b;
          }
          
          public String getSubLogFolder() {
            return null;
          }
        });
  }
  
  public void a(boolean paramBoolean) {
    this.u = paramBoolean;
  }
  
  public boolean a(long paramLong, byte[] paramArrayOfbyte, boolean paramBoolean, int paramInt, IZegoInitSDKCompletionCallback paramIZegoInitSDKCompletionCallback) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("initZegoSDK:");
    stringBuilder.append(s);
    stringBuilder.append("  testEnv:");
    stringBuilder.append(paramBoolean);
    stringBuilder.append("  isDebuging:");
    stringBuilder.append(AppInfo.m());
    Log.d("==record", stringBuilder.toString());
    if (!s)
      a(); 
    c();
    b(paramInt);
    if (this.t == InitProccessState.b) {
      Log.d("==record", "SDK已初始化, 无需重复初始化");
      return false;
    } 
    ZegoLiveRoom.setTestEnv(paramBoolean);
    Log.d("==record", "onInitSDK");
    return this.n.initSDK(paramLong, paramArrayOfbyte, new IZegoInitSDKCompletionCallback(this, paramIZegoInitSDKCompletionCallback) {
          public void onInitSDK(int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onInitSDK:");
            stringBuilder.append(param1Int);
            Log.d("==record", stringBuilder.toString());
            if (param1Int == 0) {
              if (ZegoCommonHelper.a(this.b) != null) {
                ZegoCommonHelper.a(this.b).enableAEC(true);
                ZegoCommonHelper.a(this.b).setAECMode(2);
                ZegoCommonHelper.a(this.b).setLatencyMode(2);
              } 
              ZegoCommonHelper.a(this.b, ZegoCommonHelper.InitProccessState.b);
            } else {
              ZegoCommonHelper.a(this.b, ZegoCommonHelper.InitProccessState.c);
              this.b.g();
            } 
            IZegoInitSDKCompletionCallback iZegoInitSDKCompletionCallback = this.a;
            if (iZegoInitSDKCompletionCallback != null)
              iZegoInitSDKCompletionCallback.onInitSDK(param1Int); 
          }
        });
  }
  
  public boolean a(String paramString) {
    LiveMusicModel liveMusicModel = this.r;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (liveMusicModel != null) {
      bool1 = bool2;
      if (TextUtils.equals(liveMusicModel.music_id, paramString)) {
        bool1 = bool2;
        if (n() == 2)
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public void b(int paramInt) {
    a(paramInt);
    a(this.j, this.k, this.l, this.m);
  }
  
  public void b(LiveMusicModel paramLiveMusicModel) {
    this.r = paramLiveMusicModel;
    paramLiveMusicModel = this.r;
    if (paramLiveMusicModel != null && !TextUtils.isEmpty(paramLiveMusicModel.file_url)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("start:");
      stringBuilder.append(this.r.file_url);
      Log.i("==record", stringBuilder.toString());
      e().start(this.r.file_url, false);
    } 
  }
  
  public boolean b(String paramString) {
    LiveMusicModel liveMusicModel = this.r;
    return (liveMusicModel != null && TextUtils.equals(liveMusicModel.music_id, paramString)) ? ((n() == 1)) : false;
  }
  
  public ZegoLiveRoom c() {
    if (this.n == null)
      this.n = new ZegoLiveRoom(); 
    return this.n;
  }
  
  public void c(int paramInt) {
    a(paramInt);
    paramInt = this.j;
    this.j = this.k;
    this.k = paramInt;
    a(this.j, this.k, this.l, this.m);
  }
  
  public boolean c(String paramString) {
    LiveMusicModel liveMusicModel = this.r;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (liveMusicModel != null) {
      bool1 = bool2;
      if (TextUtils.equals(liveMusicModel.music_id, paramString)) {
        bool1 = bool2;
        if (n() == 3)
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public void d() {
    ZegoLiveRoom.setUser(LiveRoomInfo.a().f(), LiveRoomInfo.a().c());
    ZegoLiveRoom.setConfig("play_clear_last_frame=true");
    ZegoLiveRoom.setConfig("room_retry_time=90");
    ZegoLiveRoom.setConfig("av_retry_time=90");
    ZegoLiveRoom.setAudioDeviceMode(6);
  }
  
  public void d(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("set musicPlayState:");
    stringBuilder.append(paramInt);
    Log.i("==record", stringBuilder.toString());
    this.v = paramInt;
    LiveEventBus.get("live_music_changed").post("");
  }
  
  public boolean d(String paramString) {
    return (this.r != null && !TextUtils.isEmpty(paramString) && TextUtils.equals(paramString, this.r.music_id) && !TextUtils.isEmpty(this.r.file_url));
  }
  
  public ZegoMediaPlayer e() {
    if (this.p == null) {
      this.p = new ZegoMediaPlayer();
      this.p.init(1, 0);
      this.p.setProcessInterval(1000L);
    } 
    return this.p;
  }
  
  public boolean f() {
    LiveRoomData liveRoomData = LiveRoomManager.a().h();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (liveRoomData != null) {
      int i = (LiveRoomManager.a().h()).stream_level;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("level:");
      stringBuilder.append(this.q);
      stringBuilder.append("  remoteLevel:");
      stringBuilder.append(i);
      Log.i("==record", stringBuilder.toString());
      bool1 = bool2;
      if (this.q != i)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public boolean g() {
    Log.i("==record", "unInitZegoSDK");
    boolean bool = false;
    this.q = 0;
    if (this.n != null) {
      e().uninit();
      this.t = InitProccessState.a;
      bool = this.n.unInitSDK();
      this.n = null;
      this.p = null;
    } 
    return bool;
  }
  
  public void h() {
    l();
    this.r = null;
    d(0);
  }
  
  public void i() {
    LiveMusicModel liveMusicModel = this.r;
    if (liveMusicModel != null && !TextUtils.isEmpty(liveMusicModel.file_url)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("reStarMusic:");
      stringBuilder.append(this.r.file_url);
      Log.i("==record", stringBuilder.toString());
      l();
      e().start(this.r.file_url, false);
    } 
  }
  
  public void j() {
    LiveMusicModel liveMusicModel = this.r;
    if (liveMusicModel != null && !TextUtils.isEmpty(liveMusicModel.file_url))
      e().resume(); 
  }
  
  public void k() {
    LiveMusicModel liveMusicModel = this.r;
    if (liveMusicModel != null && !TextUtils.isEmpty(liveMusicModel.file_url))
      e().pause(); 
  }
  
  public void l() {
    e().stop();
  }
  
  public LiveMusicModel m() {
    return this.r;
  }
  
  public int n() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("get musicPlayState:");
    stringBuilder.append(this.v);
    Log.i("==record", stringBuilder.toString());
    return this.v;
  }
  
  enum InitProccessState {
    a, b, c;
  }
  
  public static interface MusicPlayState {}
  
  public static interface OnZegoSdkInitEvent {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\common\ZegoCommonHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */