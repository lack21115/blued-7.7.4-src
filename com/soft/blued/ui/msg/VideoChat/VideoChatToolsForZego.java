package com.soft.blued.ui.msg.VideoChat;

import android.app.Activity;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.soft.blued.user.UserInfo;
import com.zego.zegoliveroom.ZegoLiveRoom;
import com.zego.zegoliveroom.callback.IZegoLivePlayerCallback;
import com.zego.zegoliveroom.callback.IZegoLivePublisherCallback;
import com.zego.zegoliveroom.callback.IZegoLoginCompletionCallback;
import com.zego.zegoliveroom.callback.IZegoRoomCallback;
import com.zego.zegoliveroom.constants.ZegoAvConfig;
import com.zego.zegoliveroom.entity.ZegoPlayStreamQuality;
import com.zego.zegoliveroom.entity.ZegoPublishStreamQuality;
import com.zego.zegoliveroom.entity.ZegoRoomInfo;
import com.zego.zegoliveroom.entity.ZegoStreamInfo;
import java.util.HashMap;

public class VideoChatToolsForZego implements IVideoChatTools {
  private static VideoChatToolsForZego a;
  
  private Activity b;
  
  private ZegoLiveRoom c;
  
  private boolean d = true;
  
  private ViewGroup e;
  
  private ViewGroup f;
  
  private IVideoChatListener g;
  
  private String h;
  
  private void a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield h : Ljava/lang/String;
    //   7: aload_0
    //   8: getfield e : Landroid/view/ViewGroup;
    //   11: ifnull -> 47
    //   14: aload_0
    //   15: getfield e : Landroid/view/ViewGroup;
    //   18: invokevirtual getChildCount : ()I
    //   21: ifne -> 47
    //   24: new android/view/SurfaceView
    //   27: dup
    //   28: aload_0
    //   29: getfield e : Landroid/view/ViewGroup;
    //   32: invokevirtual getContext : ()Landroid/content/Context;
    //   35: invokespecial <init> : (Landroid/content/Context;)V
    //   38: astore_2
    //   39: aload_0
    //   40: getfield e : Landroid/view/ViewGroup;
    //   43: aload_2
    //   44: invokevirtual addView : (Landroid/view/View;)V
    //   47: aload_0
    //   48: getfield c : Lcom/zego/zegoliveroom/ZegoLiveRoom;
    //   51: aload_1
    //   52: aload_0
    //   53: getfield e : Landroid/view/ViewGroup;
    //   56: iconst_0
    //   57: invokevirtual getChildAt : (I)Landroid/view/View;
    //   60: invokevirtual startPlayingStream : (Ljava/lang/String;Ljava/lang/Object;)Z
    //   63: pop
    //   64: aload_0
    //   65: getfield c : Lcom/zego/zegoliveroom/ZegoLiveRoom;
    //   68: iconst_1
    //   69: aload_1
    //   70: invokevirtual setViewMode : (ILjava/lang/String;)Z
    //   73: pop
    //   74: aload_0
    //   75: getfield g : Lcom/soft/blued/ui/msg/VideoChat/IVideoChatListener;
    //   78: ifnull -> 99
    //   81: aload_0
    //   82: getfield g : Lcom/soft/blued/ui/msg/VideoChat/IVideoChatListener;
    //   85: invokeinterface b : ()V
    //   90: aload_0
    //   91: getfield g : Lcom/soft/blued/ui/msg/VideoChat/IVideoChatListener;
    //   94: invokeinterface a : ()V
    //   99: aload_0
    //   100: monitorexit
    //   101: return
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Exception table:
    //   from	to	target	type
    //   2	47	102	finally
    //   47	99	102	finally
  }
  
  public static VideoChatToolsForZego i() {
    if (a == null)
      a = new VideoChatToolsForZego(); 
    return a;
  }
  
  public void a() {
    this.c.logoutRoom();
  }
  
  public void a(Activity paramActivity, BD1V1Config paramBD1V1Config, IVideoChatListener paramIVideoChatListener) {
    this.b = paramActivity;
    this.g = paramIVideoChatListener;
    ZegoLiveRoom.setUser(UserInfo.a().i().getUid(), UserInfo.a().i().getName());
    ZegoLiveRoom.setTestEnv(false);
    ZegoLiveRoom.setBusinessType(2);
    this.c = new ZegoLiveRoom();
    if (!this.c.initSDK(paramBD1V1Config.c, paramBD1V1Config.b, AppInfo.d()))
      AppMethods.a("Zego SDK初始化失败!"); 
    ZegoAvConfig zegoAvConfig = new ZegoAvConfig(2);
    zegoAvConfig.setVideoFPS(15);
    zegoAvConfig.setVideoBitrate(800000);
    this.c.setAVConfig(zegoAvConfig);
    this.c.enableTrafficControl(0, false);
    ZegoLiveRoom.requireHardwareEncoder(false);
    ZegoLiveRoom.requireHardwareDecoder(false);
    this.c.enableBeautifying(3);
    this.c.setPolishStep(7.0F);
    this.c.setZegoLivePublisherCallback(new IZegoLivePublisherCallback(this, paramIVideoChatListener) {
          public void onCaptureAudioFirstFrame() {}
          
          public void onCaptureVideoFirstFrame() {}
          
          public void onCaptureVideoSizeChangedTo(int param1Int1, int param1Int2) {}
          
          public void onJoinLiveRequest(int param1Int, String param1String1, String param1String2, String param1String3) {}
          
          public void onPublishQualityUpdate(String param1String, ZegoPublishStreamQuality param1ZegoPublishStreamQuality) {}
          
          public void onPublishStateUpdate(int param1Int, String param1String, HashMap<String, Object> param1HashMap) {
            if (param1Int == 0)
              return; 
            this.a.d();
          }
        });
    this.c.setZegoLivePlayerCallback(new IZegoLivePlayerCallback(this, paramIVideoChatListener) {
          public void onInviteJoinLiveRequest(int param1Int, String param1String1, String param1String2, String param1String3) {}
          
          public void onPlayQualityUpdate(String param1String, ZegoPlayStreamQuality param1ZegoPlayStreamQuality) {}
          
          public void onPlayStateUpdate(int param1Int, String param1String) {
            if (param1Int == 0)
              return; 
            this.a.d();
          }
          
          public void onRecvEndJoinLiveCommand(String param1String1, String param1String2, String param1String3) {}
          
          public void onVideoSizeChangedTo(String param1String, int param1Int1, int param1Int2) {}
        });
    this.c.setZegoRoomCallback(new IZegoRoomCallback(this, paramIVideoChatListener) {
          public void onDisconnect(int param1Int, String param1String) {
            this.a.c();
          }
          
          public void onKickOut(int param1Int, String param1String1, String param1String2) {}
          
          public void onReconnect(int param1Int, String param1String) {}
          
          public void onRecvCustomCommand(String param1String1, String param1String2, String param1String3, String param1String4) {}
          
          public void onRoomInfoUpdated(ZegoRoomInfo param1ZegoRoomInfo, String param1String) {}
          
          public void onStreamExtraInfoUpdated(ZegoStreamInfo[] param1ArrayOfZegoStreamInfo, String param1String) {}
          
          public void onStreamUpdated(int param1Int, ZegoStreamInfo[] param1ArrayOfZegoStreamInfo, String param1String) {
            if (param1Int == 2001) {
              VideoChatToolsForZego.a(this.b, (param1ArrayOfZegoStreamInfo[0]).streamID);
              return;
            } 
            if (param1Int == 2002)
              this.a.c(); 
          }
          
          public void onTempBroken(int param1Int, String param1String) {}
        });
    a(paramBD1V1Config.e);
    b(paramBD1V1Config.f);
  }
  
  public void a(ViewGroup paramViewGroup) {
    paramViewGroup.removeAllViews();
    SurfaceView surfaceView = new SurfaceView(paramViewGroup.getContext());
    paramViewGroup.addView((View)surfaceView);
    this.f = paramViewGroup;
    this.c.setPreviewView(surfaceView);
    this.c.setPreviewViewMode(1);
    this.c.startPreview();
  }
  
  public void a(String paramString, int paramInt) {
    this.c.loginRoom(paramString, 2, new IZegoLoginCompletionCallback(this, paramString) {
          public void onLoginCompletion(int param1Int, ZegoStreamInfo[] param1ArrayOfZegoStreamInfo) {
            if (param1Int == 0) {
              ZegoLiveRoom zegoLiveRoom = VideoChatToolsForZego.a(this.b);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(this.a);
              stringBuilder.append(System.currentTimeMillis());
              String str = stringBuilder.toString();
              param1Int = 0;
              zegoLiveRoom.startPublishing(str, "", 0);
              if (param1ArrayOfZegoStreamInfo != null && param1ArrayOfZegoStreamInfo.length > 0) {
                int i = param1ArrayOfZegoStreamInfo.length;
                while (param1Int < i) {
                  ZegoStreamInfo zegoStreamInfo = param1ArrayOfZegoStreamInfo[param1Int];
                  VideoChatToolsForZego.a(this.b, zegoStreamInfo.streamID);
                  param1Int++;
                } 
              } 
            } else {
              VideoChatToolsForZego.b(this.b).d();
            } 
          }
        });
  }
  
  public void a(boolean paramBoolean) {
    this.c.enableSpeaker(paramBoolean ^ true);
  }
  
  public void b() {
    this.d ^= 0x1;
    this.c.setFrontCam(this.d);
  }
  
  public void b(ViewGroup paramViewGroup) {
    paramViewGroup.removeAllViews();
    this.e = paramViewGroup;
  }
  
  public void b(boolean paramBoolean) {
    this.c.setBuiltInSpeakerOn(paramBoolean);
  }
  
  public void c() {
    this.c.enableCamera(true);
  }
  
  public void d() {
    this.c.enableCamera(false);
  }
  
  public void e() {}
  
  public void f() {}
  
  public void g() {
    if (this.c != null) {
      if (!TextUtils.isEmpty(this.h))
        this.c.stopPlayingStream(this.h); 
      this.c.setPreviewView(null);
      this.c.stopPreview();
      this.c.stopPublishing();
      this.c.unInitSDK();
      this.c.setZegoLivePublisherCallback(null);
      this.c.setZegoLivePlayerCallback(null);
      this.c.setZegoRoomCallback(null);
    } 
    ViewGroup viewGroup = this.f;
    if (viewGroup != null) {
      viewGroup.removeAllViews();
      this.e.removeAllViews();
    } 
    if (ZegoBeautyWrapper.a() != null)
      ZegoBeautyWrapper.a().b(); 
  }
  
  public void h() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\VideoChat\VideoChatToolsForZego.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */