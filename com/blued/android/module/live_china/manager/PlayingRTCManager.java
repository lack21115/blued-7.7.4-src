package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.common.GetAppIDConfig;
import com.blued.android.module.live_china.common.ZegoCommonHelper;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.LiveBitmapUtils;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.zego.zegoavkit2.soundlevel.IZegoSoundLevelCallback;
import com.zego.zegoavkit2.soundlevel.ZegoSoundLevelInfo;
import com.zego.zegoavkit2.soundlevel.ZegoSoundLevelMonitor;
import com.zego.zegoliveroom.ZegoLiveRoom;
import com.zego.zegoliveroom.callback.IZegoInitSDKCompletionCallback;
import com.zego.zegoliveroom.callback.IZegoLiveEventCallback;
import com.zego.zegoliveroom.callback.IZegoLivePlayerCallback;
import com.zego.zegoliveroom.callback.IZegoLivePublisherCallback;
import com.zego.zegoliveroom.callback.IZegoLoginCompletionCallback;
import com.zego.zegoliveroom.callback.IZegoRoomCallback;
import com.zego.zegoliveroom.entity.ZegoPlayStreamQuality;
import com.zego.zegoliveroom.entity.ZegoPublishStreamQuality;
import com.zego.zegoliveroom.entity.ZegoRoomInfo;
import com.zego.zegoliveroom.entity.ZegoStreamInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayingRTCManager {
  public boolean a = true;
  
  int b = -1;
  
  private TextureView c;
  
  private View d;
  
  private View e;
  
  private PlayingOnliveFragment f;
  
  private boolean g = false;
  
  private boolean h;
  
  private List<String> i = new ArrayList<String>();
  
  private boolean j = false;
  
  private boolean k = false;
  
  private boolean l = true;
  
  public PlayingRTCManager(PlayingOnliveFragment paramPlayingOnliveFragment, TextureView paramTextureView) {
    this.f = paramPlayingOnliveFragment;
    this.c = paramTextureView;
    r();
    this.d = LayoutInflater.from(AppInfo.d()).inflate(R.layout.live_mark_make_lover, null);
    this.e = LayoutInflater.from(AppInfo.d()).inflate(R.layout.live_mark_make_friend, null);
    if (this.f.R == 1) {
      ViewGroup.LayoutParams layoutParams = this.f.ac.getLayoutParams();
      layoutParams.width = DensityUtils.a(this.f.getContext(), 280.0F);
      layoutParams.height = DensityUtils.a(this.f.getContext(), 157.0F);
      this.f.ac.setLayoutParams(layoutParams);
    } 
  }
  
  public static void a(Context paramContext, TextView paramTextView, String paramString, short paramShort, long paramLong, IRequestHost paramIRequestHost) {
    LiveRoomHttpUtils.a(paramContext, new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(paramIRequestHost, paramTextView) {
          protected void a(BluedEntityA<LiveRoomUserModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              LiveRoomUserModel liveRoomUserModel = param1BluedEntityA.data.get(0);
              if (liveRoomUserModel != null && !TextUtils.isEmpty(liveRoomUserModel.name)) {
                this.a.setVisibility(0);
                this.a.setText(liveRoomUserModel.name);
              } 
            } 
          }
        }paramString, "", Long.valueOf(paramLong), Short.valueOf(paramShort), paramIRequestHost);
  }
  
  private void a(String paramString, FileHttpResponseHandler paramFileHttpResponseHandler) {
    StringBuilder stringBuilder1;
    if (TextUtils.isEmpty(paramString))
      return; 
    File file = new File(AppInfo.d().getExternalCacheDir(), "pushPhoto");
    if (!file.exists())
      file.mkdirs(); 
    file = new File(file, Md5.a(paramString));
    String str = file.getPath();
    if (!file.exists()) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("downloadPhotoResource:");
      stringBuilder1.append(paramString);
      Log.i("==record", stringBuilder1.toString());
      FileDownloader.a(paramString, str, new FileHttpResponseHandler(this, str, paramFileHttpResponseHandler) {
            public void a(File param1File) {
              if (param1File != null && param1File.exists()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("downloadPhotoResource complete:");
                stringBuilder.append(this.a);
                Log.i("==record", stringBuilder.toString());
                AppInfo.n().post(new Runnable(this, param1File) {
                      public void run() {
                        if (this.b.b != null)
                          this.b.b.onSuccess(this.a); 
                      }
                    });
                return;
              } 
              Log.i("==record", "downloadPhotoResource fail");
            }
            
            public void onFinish() {}
          }null);
      return;
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("has downloadPhotoResource:");
    stringBuilder2.append(paramString);
    Log.i("==record", stringBuilder2.toString());
    if (paramFileHttpResponseHandler != null)
      paramFileHttpResponseHandler.onSuccess(stringBuilder1); 
  }
  
  private void g(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    d();
    j();
    if (this.f.aF()) {
      Log.i("==record", "make lover startZegoPublish");
      ZegoCommonHelper.b().c().enableCamera(false);
      this.h = false;
    } 
    if (this.f.aD()) {
      Log.i("==record", "make friend startZegoPublish");
      c();
    } 
    Log.v("==record", "startZegoPublish");
    LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("开始推流：");
    stringBuilder.append(paramString);
    liveMsgSendManager.b(stringBuilder.toString());
    this.c.setVisibility(0);
    ZegoCommonHelper.b().c().setPreviewView(this.c);
    ZegoCommonHelper.b().c().setPreviewViewMode(1);
    ZegoCommonHelper.b().c().startPreview();
    ZegoCommonHelper.b().c().startPublishing(paramString, "", 0);
    Log.v("==record", "startZegoPublish end --- ");
    if (this.f.aF())
      c(this.f.bM.i); 
  }
  
  private void n() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("initZego:");
    stringBuilder.append(this.g);
    Log.i("==record", stringBuilder.toString());
    if (this.g) {
      ZegoCommonHelper.b().b(this.f.A());
      return;
    } 
    r();
    ZegoCommonHelper.b().d();
    ZegoCommonHelper.b().a(846434966L, GetAppIDConfig.a, LiveRoomInfo.a().j() ^ true, this.f.A(), new IZegoInitSDKCompletionCallback(this) {
          public void onInitSDK(int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onInitSDK:");
            stringBuilder.append(param1Int);
            Log.i("==record", stringBuilder.toString());
            if (param1Int != 0) {
              stringBuilder = new StringBuilder();
              stringBuilder.append("zego SDK 初始化失败");
              stringBuilder.append(param1Int);
              AppMethods.a(stringBuilder.toString());
            } 
          }
        });
    Log.i("==record", "initZego enableBeautifying");
    ZegoCommonHelper.b().c().enableBeautifying(3);
    Log.i("==record", "initZego set callback");
    o();
    this.g = true;
  }
  
  private void o() {
    ZegoCommonHelper.b().c().setZegoRoomCallback(new IZegoRoomCallback(this) {
          public void onDisconnect(int param1Int, String param1String) {
            Log.v("==record", "onDisconnect");
            if (PlayingRTCManager.a(this.a).aC()) {
              PlayingRTCManager.a(this.a).f(false);
              return;
            } 
            if (PlayingRTCManager.a(this.a).aE()) {
              PlayingRTCManager.a(this.a).y();
              (PlayingRTCManager.a(this.a)).q.d();
              (PlayingRTCManager.a(this.a)).bP.setState(0);
              (PlayingRTCManager.a(this.a)).q.a(1);
              return;
            } 
            if (PlayingRTCManager.a(this.a).aG()) {
              PlayingRTCManager.a(this.a).ah();
              PlayingRTCManager.a(this.a).X();
            } 
          }
          
          public void onKickOut(int param1Int, String param1String1, String param1String2) {
            Log.v("==record", "onKickOut");
          }
          
          public void onReconnect(int param1Int, String param1String) {
            Log.v("==record", "onReconnect");
          }
          
          public void onRecvCustomCommand(String param1String1, String param1String2, String param1String3, String param1String4) {}
          
          public void onRoomInfoUpdated(ZegoRoomInfo param1ZegoRoomInfo, String param1String) {}
          
          public void onStreamExtraInfoUpdated(ZegoStreamInfo[] param1ArrayOfZegoStreamInfo, String param1String) {}
          
          public void onStreamUpdated(int param1Int, ZegoStreamInfo[] param1ArrayOfZegoStreamInfo, String param1String) {
            int j = param1ArrayOfZegoStreamInfo.length;
            int i;
            for (i = 0; i < j; i++) {
              ZegoStreamInfo zegoStreamInfo = param1ArrayOfZegoStreamInfo[i];
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("onStreamUpdated i:");
              stringBuilder.append(param1Int);
              stringBuilder.append(" -- s:");
              stringBuilder.append(param1String);
              stringBuilder.append(" -- streamid:");
              stringBuilder.append(zegoStreamInfo.streamID);
              Log.v("==record", stringBuilder.toString());
            } 
            if (param1Int == 2002 && param1ArrayOfZegoStreamInfo != null && param1ArrayOfZegoStreamInfo.length > 0) {
              ZegoStreamInfo zegoStreamInfo = param1ArrayOfZegoStreamInfo[0];
              if (zegoStreamInfo != null && CommonStringUtils.c(this.a.a(zegoStreamInfo.streamID)) == LiveRoomManager.a().d()) {
                Log.i("==record", "onStreamUpdated 2002 exit");
                if (PlayingRTCManager.a(this.a).aC()) {
                  PlayingRTCManager.a(this.a).a(0, false);
                  PlayingRTCManager.a(this.a).f(false);
                  return;
                } 
                if (PlayingRTCManager.a(this.a).aE()) {
                  PlayingRTCManager.a(this.a).a(0, false);
                  PlayingRTCManager.a(this.a).y();
                  (PlayingRTCManager.a(this.a)).q.d();
                  (PlayingRTCManager.a(this.a)).bP.setState(0);
                  (PlayingRTCManager.a(this.a)).q.a(1);
                  return;
                } 
                PlayingRTCManager.a(this.a).aG();
              } 
            } 
          }
          
          public void onTempBroken(int param1Int, String param1String) {
            Log.v("==record", "onTempBroken");
          }
        });
    ZegoCommonHelper.b().c().setZegoLiveEventCallback(new IZegoLiveEventCallback(this) {
          public void onLiveEvent(int param1Int, HashMap<String, String> param1HashMap) {
            if (param1Int != 2) {
              if (param1Int != 3)
                return; 
              PlayingRTCManager.a(this.a).a(0, false);
              return;
            } 
            PlayingRTCManager.a(this.a).a(8, false);
          }
        });
    ZegoCommonHelper.b().c().setZegoLivePublisherCallback(new IZegoLivePublisherCallback(this) {
          public void onCaptureAudioFirstFrame() {}
          
          public void onCaptureVideoFirstFrame() {}
          
          public void onCaptureVideoSizeChangedTo(int param1Int1, int param1Int2) {}
          
          public void onJoinLiveRequest(int param1Int, String param1String1, String param1String2, String param1String3) {}
          
          public void onPublishQualityUpdate(String param1String, ZegoPublishStreamQuality param1ZegoPublishStreamQuality) {
            if (param1ZegoPublishStreamQuality != null) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("onPublishQualityUpdate:");
              stringBuilder.append(param1ZegoPublishStreamQuality.width);
              stringBuilder.append(" : ");
              stringBuilder.append(param1ZegoPublishStreamQuality.height);
              stringBuilder.append(" : ");
              stringBuilder.append(param1ZegoPublishStreamQuality.vkbps);
              stringBuilder.append("  : ");
              stringBuilder.append(param1ZegoPublishStreamQuality.vcapFps);
              Log.i("==record", stringBuilder.toString());
            } 
          }
          
          public void onPublishStateUpdate(int param1Int, String param1String, HashMap<String, Object> param1HashMap) {
            if (param1Int != 0) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("推流失败，err:");
              stringBuilder.append(param1Int);
              AppMethods.a(stringBuilder.toString());
              return;
            } 
            PlayingRTCManager.a(this.a, true);
            if (PlayingRTCManager.a(this.a).aE() && !(PlayingRTCManager.a(this.a)).bO.a())
              PlayingRTCManager.a(this.a).aS(); 
          }
        });
    ZegoCommonHelper.b().c().setZegoLivePlayerCallback(new IZegoLivePlayerCallback(this) {
          public void onInviteJoinLiveRequest(int param1Int, String param1String1, String param1String2, String param1String3) {}
          
          public void onPlayQualityUpdate(String param1String, ZegoPlayStreamQuality param1ZegoPlayStreamQuality) {}
          
          public void onPlayStateUpdate(int param1Int, String param1String) {
            LiveMsgSendManager liveMsgSendManager;
            if (param1Int != 0) {
              liveMsgSendManager = LiveMsgSendManager.a();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("拉流失败，err:");
              stringBuilder.append(param1Int);
              liveMsgSendManager.b(stringBuilder.toString());
              return;
            } 
            PlayingRTCManager.b(this.a, true);
            if (PlayingRTCManager.a(this.a).aD() || PlayingRTCManager.a(this.a).aF()) {
              LiveMsgSendManager liveMsgSendManager1 = LiveMsgSendManager.a();
              StringBuilder stringBuilder2 = new StringBuilder();
              stringBuilder2.append("拉流成功 playId：");
              stringBuilder2.append((String)liveMsgSendManager);
              liveMsgSendManager1.b(stringBuilder2.toString());
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("拉流回调监听 playId:");
              stringBuilder1.append((String)liveMsgSendManager);
              Log.v("==record", stringBuilder1.toString());
            } else {
              String str;
              PlayingRTCManager.a(this.a).av();
              if (!TextUtils.isEmpty((CharSequence)liveMsgSendManager)) {
                String[] arrayOfString = liveMsgSendManager.split("-");
                if (arrayOfString != null && arrayOfString.length == 3) {
                  str = arrayOfString[1];
                } else {
                  LiveMsgSendManager liveMsgSendManager1 = liveMsgSendManager;
                } 
              } else {
                str = "";
              } 
              if (!(PlayingRTCManager.a(this.a)).aJ)
                PlayingRTCManager.a(this.a).f(false); 
              PlayingRTCManager.a(PlayingRTCManager.a(this.a).getContext(), (PlayingRTCManager.a(this.a)).aw, str, (PlayingRTCManager.a(this.a)).t, (PlayingRTCManager.a(this.a)).u, (IRequestHost)PlayingRTCManager.a(this.a).w_());
              if (CommonStringUtils.c(str) == LiveRoomManager.a().d()) {
                (PlayingRTCManager.a(this.a)).au.setVisibility(0);
                Logger.a("==record", new Object[] { "onRemoteWindowAttached -- mOutUserB VISIBLE" });
              } else {
                (PlayingRTCManager.a(this.a)).au.setVisibility(8);
                Logger.a("==record", new Object[] { "onRemoteWindowAttached -- mOutUserB GONE" });
              } 
            } 
            (PlayingRTCManager.a(this.a)).ao.setOnClickListener(new View.OnClickListener(this, (String)liveMsgSendManager) {
                  public void onClick(View param2View) {
                    InstantLog.a("live_connect_area_click");
                    LiveSetDataObserver.a().e(this.a);
                  }
                });
          }
          
          public void onRecvEndJoinLiveCommand(String param1String1, String param1String2, String param1String3) {}
          
          public void onVideoSizeChangedTo(String param1String, int param1Int1, int param1Int2) {}
        });
    ZegoSoundLevelMonitor.getInstance().setCycle(300);
    ZegoSoundLevelMonitor.getInstance().setCallback(new IZegoSoundLevelCallback(this) {
          public void onCaptureSoundLevelUpdate(ZegoSoundLevelInfo param1ZegoSoundLevelInfo) {
            if (PlayingRTCManager.a(this.a) != null && param1ZegoSoundLevelInfo != null) {
              if (PlayingRTCManager.a(this.a).aG()) {
                if (param1ZegoSoundLevelInfo.soundLevel > 1.0F && PlayingRTCManager.b(this.a)) {
                  PlayingRTCManager.a(this.a).ai();
                  return;
                } 
                PlayingRTCManager.a(this.a).aj();
                return;
              } 
              if (PlayingRTCManager.a(this.a).aE()) {
                if (param1ZegoSoundLevelInfo.soundLevel > 1.0F && PlayingRTCManager.b(this.a)) {
                  PlayingRTCManager.a(this.a).ak();
                  return;
                } 
                PlayingRTCManager.a(this.a).al();
              } 
            } 
          }
          
          public void onSoundLevelUpdate(ZegoSoundLevelInfo[] param1ArrayOfZegoSoundLevelInfo) {}
        });
    ZegoSoundLevelMonitor.getInstance().start();
  }
  
  private void p() {
    Bitmap bitmap;
    try {
      this.d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      this.d.layout(0, 0, this.d.getMeasuredWidth(), this.d.getMeasuredHeight());
      bitmap = Bitmap.createBitmap(this.d.getWidth(), this.d.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas canvas = new Canvas(bitmap);
      this.d.draw(canvas);
    } catch (Exception exception) {
      bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
      exception.printStackTrace();
    } 
    String str = m();
    LiveBitmapUtils.a(bitmap, str, 100);
    if (bitmap != null)
      bitmap.recycle(); 
    Rect rect = new Rect(0, 0, (ZegoCommonHelper.b()).j, (ZegoCommonHelper.b()).k);
    ZegoLiveRoom.setWaterMarkImagePath(RecyclingUtils.Scheme.c.b(str));
    ZegoLiveRoom.setPreviewWaterMarkRect(rect);
    ZegoLiveRoom.setPublishWaterMarkRect(rect);
  }
  
  private void q() {
    Bitmap bitmap;
    try {
      this.e.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      this.e.layout(0, 0, this.e.getMeasuredWidth(), this.e.getMeasuredHeight());
      bitmap = Bitmap.createBitmap(this.e.getWidth(), this.e.getHeight(), Bitmap.Config.ARGB_8888);
      Canvas canvas = new Canvas(bitmap);
      this.e.draw(canvas);
    } catch (Exception exception) {
      bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
      exception.printStackTrace();
    } 
    String str = m();
    LiveBitmapUtils.a(bitmap, str, 100);
    if (bitmap != null)
      bitmap.recycle(); 
    Rect rect = new Rect(0, 0, (ZegoCommonHelper.b()).j, (ZegoCommonHelper.b()).k);
    ZegoLiveRoom.setWaterMarkImagePath(RecyclingUtils.Scheme.c.b(str));
    ZegoLiveRoom.setPreviewWaterMarkRect(rect);
    ZegoLiveRoom.setPublishWaterMarkRect(rect);
  }
  
  private void r() {
    ImageFileLoader.a(null).a(AvatarUtils.a(0, LiveRoomInfo.a().e())).a();
  }
  
  public String a(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      String[] arrayOfString = paramString.split("-");
      if (arrayOfString != null && arrayOfString.length == 3)
        return arrayOfString[1]; 
    } 
    return "";
  }
  
  public void a() {
    b(true, 2);
  }
  
  public void a(JoinLiveResult paramJoinLiveResult, String paramString1, String paramString2, String paramString3, int paramInt) {
    Logger.a("==record", new Object[] { "onJoinLive result = ", paramJoinLiveResult.toString(), "--", "joinLiveId = ", paramString1 });
    int i = null.a[paramJoinLiveResult.ordinal()];
    if (i != 1) {
      if (i != 2 && i != 3) {
        if (i != 4) {
          if (i != 5)
            return; 
          AppMethods.d(R.string.audio_request_expired);
          return;
        } 
        AppMethods.d(R.string.no_extra_quota);
        return;
      } 
    } else {
      if (TextUtils.isEmpty(paramString1))
        return; 
      if (this.f.ci) {
        this.f.ci = false;
        return;
      } 
      if (this.f.aD() || this.f.aF()) {
        a(paramString1, paramString2, paramString3, paramInt);
        if (this.f.aE() && !this.f.bO.a())
          this.f.bS.i(); 
        return;
      } 
      this.f.ab();
      this.f.a(new Runnable(this, paramString1, paramString2, paramString3, paramInt) {
            public void run() {
              PlayingRTCManager.a(this.e).ao();
              this.e.a(this.a, this.b, this.c, this.d);
            }
          });
      return;
    } 
  }
  
  public void a(String paramString, int paramInt) {
    if (TextUtils.isEmpty(paramString))
      return; 
    this.i.add(paramString);
    LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("开始拉流 playId：");
    stringBuilder2.append(paramString);
    stringBuilder2.append(" -- index:");
    stringBuilder2.append(paramInt);
    liveMsgSendManager.b(stringBuilder2.toString());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("使用zego拉流 playId:");
    stringBuilder1.append(paramString);
    stringBuilder1.append(" -- index:");
    stringBuilder1.append(paramInt);
    Log.v("==record", stringBuilder1.toString());
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          if (paramInt != 4)
            return; 
          if (this.f.as.getTag(R.id.zego_texture_id) instanceof String && !TextUtils.equals((String)this.f.as.getTag(R.id.zego_texture_id), paramString)) {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("playId not equal F:");
            stringBuilder1.append(paramString);
            Log.v("==record", stringBuilder1.toString());
            this.f.au();
          } 
          this.f.ag.setVisibility(0);
          this.f.as.setVisibility(0);
          this.f.as.setTag(R.id.zego_texture_id, paramString);
          ZegoCommonHelper.b().c().startPlayingStream(paramString, this.f.as);
          ZegoCommonHelper.b().c().setViewMode(1, paramString);
          return;
        } 
        if (this.f.ar.getTag(R.id.zego_texture_id) instanceof String && !TextUtils.equals((String)this.f.ar.getTag(R.id.zego_texture_id), paramString)) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("playId not equal E:");
          stringBuilder1.append(paramString);
          Log.v("==record", stringBuilder1.toString());
          this.f.at();
        } 
        this.f.af.setVisibility(0);
        this.f.ar.setVisibility(0);
        this.f.ar.setTag(R.id.zego_texture_id, paramString);
        ZegoCommonHelper.b().c().startPlayingStream(paramString, this.f.ar);
        ZegoCommonHelper.b().c().setViewMode(1, paramString);
        return;
      } 
      if (this.f.aq.getTag(R.id.zego_texture_id) instanceof String && !TextUtils.equals((String)this.f.aq.getTag(R.id.zego_texture_id), paramString)) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("playId not equal D:");
        stringBuilder1.append(paramString);
        Log.v("==record", stringBuilder1.toString());
        this.f.as();
      } 
      this.f.ae.setVisibility(0);
      this.f.aq.setVisibility(0);
      this.f.aq.setTag(R.id.zego_texture_id, paramString);
      ZegoCommonHelper.b().c().startPlayingStream(paramString, this.f.aq);
      ZegoCommonHelper.b().c().setViewMode(1, paramString);
      return;
    } 
    if (this.f.ap.getTag(R.id.zego_texture_id) instanceof String && !TextUtils.equals((String)this.f.ap.getTag(R.id.zego_texture_id), paramString)) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("playId not equal C:");
      stringBuilder1.append(paramString);
      Log.v("==record", stringBuilder1.toString());
      this.f.ar();
    } 
    this.f.ad.setVisibility(0);
    this.f.ap.setVisibility(0);
    this.f.ap.setTag(R.id.zego_texture_id, paramString);
    ZegoCommonHelper.b().c().startPlayingStream(paramString, this.f.ap);
    ZegoCommonHelper.b().c().setViewMode(1, paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt) {
    Log.v("==record", "startJoinLiveAnchor");
    n();
    ZegoCommonHelper.b().c().setVideoMirrorMode(0, 0);
    ZegoCommonHelper.b().c().loginRoom(paramString1, 1, new IZegoLoginCompletionCallback(this, paramString2, paramString3) {
          public void onLoginCompletion(int param1Int, ZegoStreamInfo[] param1ArrayOfZegoStreamInfo) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onLoginCompletion err:");
            stringBuilder.append(param1Int);
            Log.v("==record", stringBuilder.toString());
            if (param1Int == 0) {
              PlayingRTCManager.a(this.c, this.a);
              if (PlayingRTCManager.a(this.c).aD() || PlayingRTCManager.a(this.c).aF()) {
                Log.v("==record", "make friend or make lover");
                return;
              } 
              this.c.b(this.b);
              return;
            } 
            AppMethods.a("登录zego房间失败");
          }
        });
  }
  
  public void a(short paramShort, long paramLong, int paramInt) {
    ChatManager.getInstance().applyJoinLive(paramShort, paramLong, paramInt);
  }
  
  public void a(boolean paramBoolean, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("markMakeLoverMic:");
    stringBuilder.append(paramBoolean);
    stringBuilder.append("mMicOpen:");
    stringBuilder.append(this.l);
    Log.i("record", stringBuilder.toString());
    ImageView imageView = (ImageView)this.d.findViewById(R.id.iv_mic);
    if (this.l) {
      imageView.setVisibility(0);
      if (paramBoolean) {
        paramInt %= 3;
        if (paramInt == 0) {
          imageView.setImageResource(R.drawable.live_mic_voice_1);
        } else if (paramInt == 1) {
          imageView.setImageResource(R.drawable.live_mic_voice_2);
        } else if (paramInt == 2) {
          imageView.setImageResource(R.drawable.live_mic_voice_3);
        } 
      } else {
        imageView.setImageResource(R.drawable.live_mic_voice_3);
      } 
    } else {
      imageView.setVisibility(8);
    } 
    p();
  }
  
  public void b() {
    b(false, 2);
  }
  
  public void b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    this.i.add(paramString);
    LiveMsgSendManager.a().b("开始拉主播流");
    this.f.ac.setVisibility(0);
    this.f.ao.setVisibility(0);
    ZegoCommonHelper.b().c().startPlayingStream(paramString, this.f.ao);
    ZegoCommonHelper.b().c().setViewMode(1, paramString);
  }
  
  public void b(boolean paramBoolean, int paramInt) {
    ImageView imageView = (ImageView)this.e.findViewById(R.id.iv_mic);
    if (this.l) {
      imageView.setVisibility(0);
      if (paramBoolean) {
        paramInt %= 3;
        if (paramInt == 0) {
          imageView.setImageResource(R.drawable.live_mic_voice_1);
        } else if (paramInt == 1) {
          imageView.setImageResource(R.drawable.live_mic_voice_2);
        } else if (paramInt == 2) {
          imageView.setImageResource(R.drawable.live_mic_voice_3);
        } 
      } else {
        imageView.setImageResource(R.drawable.live_mic_voice_3);
      } 
    } else {
      imageView.setVisibility(8);
    } 
    q();
  }
  
  public void c() {
    this.l = false;
    ZegoCommonHelper.b().c().enableMic(false);
    if (this.f.aG()) {
      a(false, 0);
      return;
    } 
    if (this.f.aE())
      b(false, 0); 
  }
  
  public void c(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("markMakeLoverAvatarIfNetUrl");
    stringBuilder.append(paramString);
    Log.i("==record", stringBuilder.toString());
    if (!TextUtils.isEmpty(paramString) && paramString.startsWith("http")) {
      Log.i("==record", "markMakeLoverAvatar from http");
      a(paramString, new FileHttpResponseHandler(this) {
            public void a(File param1File) {
              this.a.d(param1File.getAbsolutePath());
            }
          });
      return;
    } 
    d(paramString);
  }
  
  public void d() {
    this.l = true;
    ZegoCommonHelper.b().c().enableMic(true);
    if (this.f.aG()) {
      a(false, 0);
      return;
    } 
    if (this.f.aE())
      b(false, 0); 
  }
  
  public void d(String paramString) {
    Bitmap bitmap;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("markMakeLoverAvatar:");
    stringBuilder.append(paramString);
    Log.i("==record", stringBuilder.toString());
    ImageView imageView2 = (ImageView)this.d.findViewById(R.id.iv_avatar);
    if (TextUtils.isEmpty(paramString)) {
      bitmap = BitmapFactory.decodeResource(AppInfo.d().getResources(), R.drawable.user_bg_round);
    } else {
      bitmap = LiveBitmapUtils.a((String)bitmap, 360);
    } 
    if (bitmap == null) {
      Log.i("==record==", "bitmap is null");
      imageView2.setVisibility(8);
    } else {
      imageView2.setVisibility(0);
      imageView2.setImageBitmap(bitmap);
    } 
    ImageView imageView1 = (ImageView)this.d.findViewById(R.id.iv_mic);
    if (this.l) {
      imageView1.setVisibility(0);
      imageView1.setImageResource(R.drawable.live_mic_voice_3);
    } else {
      imageView1.setVisibility(8);
    } 
    p();
    if (!this.h) {
      Log.i("==record", "enableCamera true");
      ZegoCommonHelper.b().c().enableCamera(true);
      this.h = true;
    } 
  }
  
  public void e() {
    LiveRoomHttpUtils.m(new BluedUIHttpResponse(this, (IRequestHost)this.f.w_()) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        });
  }
  
  public void e(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("markMakeFriendAvatarIfNetUrl");
    stringBuilder.append(paramString);
    Log.i("==record", stringBuilder.toString());
    if (!TextUtils.isEmpty(paramString) && paramString.startsWith("http")) {
      a(paramString, new FileHttpResponseHandler(this) {
            public void a(File param1File) {
              this.a.f(param1File.getAbsolutePath());
            }
          });
      return;
    } 
    f(paramString);
  }
  
  public void f() {
    if (this.j) {
      for (String str : this.i) {
        ZegoCommonHelper.b().c().stopPlayingStream(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("停止拉流id:");
        stringBuilder.append(str);
        Log.v("==record", stringBuilder.toString());
      } 
      this.i.clear();
      this.j = false;
    } 
  }
  
  public void f(String paramString) {
    Bitmap bitmap;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("markMakeFriendAvatar:");
    stringBuilder.append(paramString);
    Log.i("==record", stringBuilder.toString());
    ImageView imageView2 = (ImageView)this.e.findViewById(R.id.iv_avatar);
    imageView2.setVisibility(0);
    if (TextUtils.isEmpty(paramString)) {
      bitmap = BitmapFactory.decodeResource(AppInfo.d().getResources(), R.drawable.user_bg_round);
    } else {
      bitmap = LiveBitmapUtils.a((String)bitmap, 360);
    } 
    if (bitmap != null)
      imageView2.setImageBitmap(bitmap); 
    ImageView imageView1 = (ImageView)this.e.findViewById(R.id.iv_mic);
    if (this.l) {
      imageView1.setVisibility(0);
      imageView1.setImageResource(R.drawable.live_mic_voice_3);
    } else {
      imageView1.setVisibility(8);
    } 
    q();
    if (!this.h) {
      Log.i("==record", "enableCamera true");
      ZegoCommonHelper.b().c().enableCamera(true);
      this.h = true;
    } 
  }
  
  public void g() {
    ZegoCommonHelper.b().c().logoutRoom();
    ZegoSoundLevelMonitor.getInstance().stop();
    f();
    if (this.k) {
      ZegoCommonHelper.b().c().stopPreview();
      ZegoCommonHelper.b().c().stopPublishing();
    } 
    ZegoCommonHelper.b().g();
  }
  
  public void h() {
    j();
    ZegoCommonHelper.b().c().stopPreview();
    ZegoCommonHelper.b().c().stopPublishing();
    this.k = false;
    f();
    ZegoCommonHelper.b().c().logoutRoom();
  }
  
  public void i() {
    Log.i("==record", "markMakeFriendVideo");
    ((ImageView)this.e.findViewById(R.id.iv_avatar)).setVisibility(8);
    ImageView imageView = (ImageView)this.e.findViewById(R.id.iv_mic);
    if (this.l) {
      imageView.setVisibility(0);
      imageView.setImageResource(R.drawable.live_mic_voice_3);
    } else {
      imageView.setVisibility(8);
    } 
    q();
    if (!this.h) {
      Log.i("==makelover", "enableCamera true");
      ZegoCommonHelper.b().c().enableCamera(true);
      this.h = true;
    } 
  }
  
  public void j() {
    Log.i("==record", "clearMark");
    Rect rect = new Rect(0, 0, 0, 0);
    ZegoLiveRoom.setWaterMarkImagePath("");
    ZegoLiveRoom.setPreviewWaterMarkRect(rect);
    ZegoLiveRoom.setPublishWaterMarkRect(rect);
  }
  
  public void k() {
    Log.i("==record", "switchVideoStreaming");
    i();
  }
  
  public void l() {
    Log.i("==record", "switchPictureStreaming");
    e(this.f.bM.i);
  }
  
  public String m() {
    this.b++;
    if (this.b >= 10000)
      this.b = 0; 
    File file = AppInfo.d().getExternalFilesDir((String)null);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("push_image_");
    stringBuilder.append(this.b % 4);
    String str = stringBuilder.toString();
    if (file != null) {
      file = new File(file, "img");
      if (file.exists() || file.mkdirs())
        return (new File(file, str)).getAbsolutePath(); 
    } 
    file = AppInfo.d().getFilesDir();
    if (file != null) {
      file = new File(file, "img");
      if (file.exists() || file.mkdirs())
        return (new File(file, str)).getAbsolutePath(); 
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\PlayingRTCManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */