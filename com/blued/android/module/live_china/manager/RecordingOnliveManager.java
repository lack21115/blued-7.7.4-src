package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.module.external_sense_library.config.BluedBeautifyKey;
import com.blued.android.module.external_sense_library.config.BluedFilterType;
import com.blued.android.module.external_sense_library.contract.IHandActionListener;
import com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor;
import com.blued.android.module.external_sense_library.contract.ISetStickerListener;
import com.blued.android.module.external_sense_library.manager.FilterDataManager;
import com.blued.android.module.external_sense_library.manager.SenseTimeFactory;
import com.blued.android.module.external_sense_library.manager.SenseTimeZegoFlashManger;
import com.blued.android.module.external_sense_library.model.ErrorCode;
import com.blued.android.module.external_sense_library.utils.FileUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.common.GetAppIDConfig;
import com.blued.android.module.live_china.common.ZegoCommonHelper;
import com.blued.android.module.live_china.common.ZegoMixStreamHelper;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.liveForMsg.LiveMsgManager;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.model.InstantLogBody;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.PopBeautyNewView;
import com.blued.android.module.live_china.zegoVideoCapture.VideoFilterFactory;
import com.blued.das.live.LiveProtos;
import com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback;
import com.zego.zegoavkit2.ZegoExternalVideoCapture;
import com.zego.zegoavkit2.mixstream.ZegoMixStreamInfo;
import com.zego.zegoavkit2.mixstream.ZegoSoundLevelInMixStreamInfo;
import com.zego.zegoavkit2.videofilter.ZegoExternalVideoFilter;
import com.zego.zegoavkit2.videofilter.ZegoVideoFilterFactory;
import com.zego.zegoliveroom.callback.IZegoInitSDKCompletionCallback;
import com.zego.zegoliveroom.callback.IZegoLiveEventCallback;
import com.zego.zegoliveroom.callback.IZegoLivePlayerCallback;
import com.zego.zegoliveroom.callback.IZegoLivePublisherCallback;
import com.zego.zegoliveroom.callback.IZegoLoginCompletionCallback;
import com.zego.zegoliveroom.callback.IZegoRoomCallback;
import com.zego.zegoliveroom.callback.IZegoUpdatePublishTargetCallback;
import com.zego.zegoliveroom.entity.ZegoPlayStreamQuality;
import com.zego.zegoliveroom.entity.ZegoPublishStreamQuality;
import com.zego.zegoliveroom.entity.ZegoRoomInfo;
import com.zego.zegoliveroom.entity.ZegoStreamInfo;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RecordingOnliveManager implements IHandActionListener {
  public Context a;
  
  public SenseTimeZegoFlashManger b;
  
  public String c = "";
  
  public boolean d;
  
  private ExecutorService e = Executors.newSingleThreadExecutor();
  
  private RecordingOnliveFragment f;
  
  private int g = 1;
  
  private StopConnecting h = new StopConnecting();
  
  private StartMixStream i = new StartMixStream();
  
  private volatile boolean j = true;
  
  private int k = 0;
  
  private List<String> l = new ArrayList<String>();
  
  private boolean m = false;
  
  private boolean n = false;
  
  private boolean o = false;
  
  private String p = "";
  
  private boolean q = false;
  
  private int r = 0;
  
  private ZegoMixStreamHelper.MixStreamCallback s = new ZegoMixStreamHelper.MixStreamCallback(this) {
      public void a(int param1Int) {
        if (param1Int != 0)
          RecordingOnliveManager.b(this.a); 
        LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("混流回调errorcode：");
        stringBuilder.append(param1Int);
        liveMsgSendManager.b(stringBuilder.toString());
      }
      
      public void a(ArrayList<ZegoSoundLevelInMixStreamInfo> param1ArrayList) {}
    };
  
  private Handler t = new Handler(this) {
      public void handleMessage(Message param1Message) {
        super.handleMessage(param1Message);
        if (param1Message.what != 150)
          return; 
        ByteBuffer byteBuffer = (ByteBuffer)param1Message.obj;
        Bundle bundle = param1Message.getData();
        int i = bundle.getInt("imageWidth");
        int j = bundle.getInt("imageHeight");
        RecordingOnliveManager.a(this.a, byteBuffer, FileUtils.a(param1Message.arg1), i, j);
      }
    };
  
  public RecordingOnliveManager(RecordingOnliveFragment paramRecordingOnliveFragment, boolean paramBoolean) {
    this.a = paramRecordingOnliveFragment.getContext();
    this.f = paramRecordingOnliveFragment;
    FilterDataManager.getInstance().getFilters();
    B();
    A();
    C();
    D();
    LiveGiftManager.a().a(true);
  }
  
  private void A() {
    ZegoCommonHelper.b().d();
    ZegoCommonHelper.b().a(846434966L, GetAppIDConfig.a, LiveRoomInfo.a().j() ^ true, 0, new IZegoInitSDKCompletionCallback(this) {
          public void onInitSDK(int param1Int) {
            if (param1Int != 0) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("zego SDK 初始化失败");
              stringBuilder.append(param1Int);
              AppMethods.a(stringBuilder.toString());
              return;
            } 
            Log.i("==record", "initZegoSDK ok");
            RecordingOnliveManager recordingOnliveManager = this.a;
            recordingOnliveManager.b((RecordingOnliveManager.a(recordingOnliveManager)).I);
            ZegoCommonHelper.b().c().setPreviewView((RecordingOnliveManager.a(this.a)).E);
            ZegoCommonHelper.b().c().setPreviewViewMode(1);
            ZegoCommonHelper.b().c().startPreview();
          }
        });
    y();
  }
  
  private void B() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("美颜：");
    stringBuilder.append(LiveRoomPreferences.v());
    Log.v("drb", stringBuilder.toString());
    if (LiveRoomPreferences.v() == 1)
      return; 
    try {
      if (this.b != null) {
        this.b.onSurfaceDestroyed();
        this.b.onDestroy();
      } 
      this.b = (SenseTimeZegoFlashManger)SenseTimeFactory.createInstance((Context)this.f.getActivity(), 3);
      this.b.setHandActionListener(this);
      this.b.setHandler(this.t);
      this.b.enableBeautify(true);
      this.b.setCameraFacing(this.j);
      a(this.a, (ISenseTimeProcessor)this.b);
      return;
    } catch (Exception exception) {
      Logger.a("rrrb", new Object[] { "initKiwi ", exception.toString() });
      l();
      return;
    } 
  }
  
  private void C() {
    RecordingOnliveFragment recordingOnliveFragment = this.f;
    recordingOnliveFragment.aj = new PopBeautyNewView(recordingOnliveFragment, this);
  }
  
  private void D() {
    this.f.a(new Runnable(this) {
          public void run() {
            if ((RecordingOnliveManager.a(this.a)).aj != null) {
              Log.v("==record", "mBeautyView initData");
              (RecordingOnliveManager.a(this.a)).aj.c();
            } 
            if ((RecordingOnliveManager.a(this.a)).cF != null) {
              Log.v("==record", "mPopGestureView initData");
              (RecordingOnliveManager.a(this.a)).cF.d();
            } 
          }
        });
  }
  
  private void a(File paramFile, Bitmap paramBitmap) {
    Bitmap bitmap2 = null;
    FileNotFoundException fileNotFoundException1 = null;
    try {
      BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramFile));
      try {
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bufferedOutputStream);
      } catch (FileNotFoundException fileNotFoundException) {
        BufferedOutputStream bufferedOutputStream1 = bufferedOutputStream;
      } finally {
        paramFile = null;
      } 
    } catch (FileNotFoundException fileNotFoundException2) {
      paramBitmap = bitmap2;
    } finally {}
    Bitmap bitmap1 = paramBitmap;
    fileNotFoundException2.printStackTrace();
    if (paramBitmap != null)
      paramBitmap.close(); 
    if (this.t != null) {
      String str = paramFile.getAbsolutePath();
      AppUtils.a(AppInfo.d(), str, false);
    } 
  }
  
  private void a(ByteBuffer paramByteBuffer, File paramFile, int paramInt1, int paramInt2) {
    if (paramInt1 > 0) {
      if (paramInt2 <= 0)
        return; 
      Bitmap bitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      paramByteBuffer.position(0);
      bitmap.copyPixelsFromBuffer(paramByteBuffer);
      a(paramFile, bitmap);
      bitmap.recycle();
    } 
  }
  
  private void y() {
    ZegoCommonHelper.b().c().setZegoRoomCallback(new IZegoRoomCallback(this) {
          public void onDisconnect(int param1Int, String param1String) {
            Log.v("==record", "onDisconnect");
            if (RecordingOnliveManager.a(this.a).aR()) {
              RecordingOnliveManager.a(this.a).ap();
              return;
            } 
            if (RecordingOnliveManager.a(this.a).B()) {
              RecordingOnliveManager.a(this.a).aT();
              return;
            } 
            if (RecordingOnliveManager.a(this.a).aN() || RecordingOnliveManager.a(this.a).aO()) {
              RecordingOnliveManager.a(this.a).O();
              return;
            } 
            if (RecordingOnliveManager.a(this.a).aP()) {
              RecordingOnliveManager.a(this.a).y();
              (RecordingOnliveManager.a(this.a)).q.d();
              return;
            } 
            if (RecordingOnliveManager.a(this.a).aQ()) {
              RecordingOnliveManager.a(this.a).aX();
              RecordingOnliveManager.a(this.a).ai();
              return;
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
              if (zegoStreamInfo != null && TextUtils.equals(this.a.a(zegoStreamInfo.streamID), LiveRoomInfo.a().f())) {
                if (RecordingOnliveManager.a(this.a).B()) {
                  RecordingOnliveManager.a(this.a).aT();
                  return;
                } 
                if (RecordingOnliveManager.a(this.a).aN() || RecordingOnliveManager.a(this.a).aO()) {
                  RecordingOnliveManager.a(this.a).O();
                  return;
                } 
                if (RecordingOnliveManager.a(this.a).aP()) {
                  RecordingOnliveManager.a(this.a).y();
                  (RecordingOnliveManager.a(this.a)).q.d();
                  return;
                } 
                if (RecordingOnliveManager.a(this.a).aQ()) {
                  RecordingOnliveManager.a(this.a).aX();
                  RecordingOnliveManager.a(this.a).ai();
                  return;
                } 
              } 
            } 
          }
          
          public void onTempBroken(int param1Int, String param1String) {
            Log.v("==record", "onTempBroken");
          }
        });
    ZegoMixStreamHelper.a().a(this.s);
    ZegoCommonHelper.b().c().setZegoLiveEventCallback(new IZegoLiveEventCallback(this) {
          public void onLiveEvent(int param1Int, HashMap<String, String> param1HashMap) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onLiveEvent:");
            stringBuilder.append(param1Int);
            Log.v("==record", stringBuilder.toString());
            if (param1Int != 3) {
              if (param1Int != 4) {
                if (param1Int != 6)
                  return; 
                RecordingOnliveManager.a(this.a).j(0);
                return;
              } 
              RecordingOnliveManager.a(this.a).j(8);
              return;
            } 
            RecordingOnliveManager.a(this.a).j(0);
          }
        });
    ZegoCommonHelper.b().c().setZegoLivePublisherCallback(new IZegoLivePublisherCallback(this) {
          public void onCaptureAudioFirstFrame() {
            Log.v("==record", "onCaptureAudioFirstFrame");
          }
          
          public void onCaptureVideoFirstFrame() {
            Log.v("==record", "onCaptureVideoFirstFrame");
          }
          
          public void onCaptureVideoSizeChangedTo(int param1Int1, int param1Int2) {}
          
          public void onJoinLiveRequest(int param1Int, String param1String1, String param1String2, String param1String3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onJoinLiveRequest i:");
            stringBuilder.append(param1Int);
            stringBuilder.append(" -- s:");
            stringBuilder.append(param1String1);
            stringBuilder.append(" -- s1:");
            stringBuilder.append(param1String2);
            stringBuilder.append(" -- s2:");
            stringBuilder.append(param1String3);
            Log.v("==record", stringBuilder.toString());
          }
          
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
              Log.i("record", stringBuilder.toString());
            } 
          }
          
          public void onPublishStateUpdate(int param1Int, String param1String, HashMap<String, Object> param1HashMap) {
            if (param1Int != 0) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("推流失败，err:");
              stringBuilder.append(param1Int);
              AppMethods.a(stringBuilder.toString());
            } 
          }
        });
    ZegoCommonHelper.b().c().setZegoLivePlayerCallback(new IZegoLivePlayerCallback(this) {
          public void onInviteJoinLiveRequest(int param1Int, String param1String1, String param1String2, String param1String3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onInviteJoinLiveRequest i:");
            stringBuilder.append(param1Int);
            stringBuilder.append(" -- s:");
            stringBuilder.append(param1String1);
            stringBuilder.append(" -- s1:");
            stringBuilder.append(param1String2);
            stringBuilder.append(" -- s2:");
            stringBuilder.append(param1String3);
            Log.v("==record", stringBuilder.toString());
          }
          
          public void onPlayQualityUpdate(String param1String, ZegoPlayStreamQuality param1ZegoPlayStreamQuality) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onPlayQualityUpdate s:");
            stringBuilder.append(param1String);
            Log.v("==record", stringBuilder.toString());
          }
          
          public void onPlayStateUpdate(int param1Int, String param1String) {
            StringBuilder stringBuilder1;
            String str;
            if (param1Int != 0) {
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append("拉流失败，err:");
              stringBuilder1.append(param1Int);
              AppMethods.a(stringBuilder1.toString());
              return;
            } 
            RecordingOnliveManager.b(this.a, true);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("拉流成功：");
            stringBuilder2.append((String)stringBuilder1);
            Log.v("==record", stringBuilder2.toString());
            if (RecordingOnliveManager.a(this.a).aP() || RecordingOnliveManager.a(this.a).aQ()) {
              Log.v("==record", "make friend or lover 拉流成功");
              return;
            } 
            RecordingOnliveManager.a(this.a).aD();
            if (!TextUtils.isEmpty(stringBuilder1)) {
              String[] arrayOfString = stringBuilder1.split("-");
              stringBuilder2 = stringBuilder1;
              if (arrayOfString != null) {
                stringBuilder2 = stringBuilder1;
                if (arrayOfString.length == 3)
                  str = arrayOfString[1]; 
              } 
            } else {
              str = "";
            } 
            if (RecordingOnliveManager.a(this.a).aM() || RecordingOnliveManager.a(this.a).B()) {
              LiveMsgSendManager.a().b("对方窗口已准备好");
            } else {
              (RecordingOnliveManager.a(this.a)).aL.setVisibility(0);
              PlayingRTCManager.a(RecordingOnliveManager.a(this.a).getContext(), (RecordingOnliveManager.a(this.a)).aN, str, (RecordingOnliveManager.a(this.a)).t, (RecordingOnliveManager.a(this.a)).u, (IRequestHost)RecordingOnliveManager.a(this.a).w_());
            } 
            (RecordingOnliveManager.a(this.a)).aF.setOnClickListener(new View.OnClickListener(this, str) {
                  public void onClick(View param2View) {
                    byte b;
                    if (RecordingOnliveManager.a(this.b.a).aM() || RecordingOnliveManager.a(this.b.a).B()) {
                      b = 1;
                    } else {
                      b = 0;
                    } 
                    LiveMsgManager liveMsgManager = (RecordingOnliveManager.a(this.b.a)).cG;
                    String str = this.a;
                    if (b) {
                      b = 3;
                    } else {
                      b = 2;
                    } 
                    liveMsgManager.a(str, b);
                    InstantLog.a("live_connect_area_click");
                  }
                });
          }
          
          public void onRecvEndJoinLiveCommand(String param1String1, String param1String2, String param1String3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onRecvEndJoinLiveCommand s:");
            stringBuilder.append(param1String1);
            stringBuilder.append(" -- s1:");
            stringBuilder.append(param1String2);
            stringBuilder.append(" -- s2:");
            stringBuilder.append(param1String3);
            Log.v("==record", stringBuilder.toString());
          }
          
          public void onVideoSizeChangedTo(String param1String, int param1Int1, int param1Int2) {}
        });
    ZegoCommonHelper.b().e().setEventWithIndexCallback(new IZegoMediaPlayerWithIndexCallback(this) {
          public void onAudioBegin(int param1Int) {
            Log.i("==record", "onAudioBegin");
          }
          
          public void onBufferBegin(int param1Int) {
            Log.i("==record", "onBufferBegin");
            ZegoCommonHelper.b().d(1);
          }
          
          public void onBufferEnd(int param1Int) {
            Log.i("==record", "onBufferEnd");
            ZegoCommonHelper.b().d(2);
          }
          
          public void onLoadComplete(int param1Int) {
            Log.i("==record", "onLoadComplete");
          }
          
          public void onPlayEnd(int param1Int) {
            Log.i("==record", "onPlayEnd");
            RecordingOnliveManager.a(this.a).bg();
            ZegoCommonHelper.b().d(3);
          }
          
          public void onPlayError(int param1Int1, int param1Int2) {
            Log.i("==record", "onPlayError");
          }
          
          public void onPlayPause(int param1Int) {
            Log.i("==record", "onPlayPause");
          }
          
          public void onPlayResume(int param1Int) {
            Log.i("==record", "onPlayResume");
          }
          
          public void onPlayStart(int param1Int) {
            Log.i("==record", "onPlayStart");
            ZegoCommonHelper.b().d(2);
          }
          
          public void onPlayStop(int param1Int) {
            Log.i("==record", "onPlayStop");
          }
          
          public void onProcessInterval(long param1Long, int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onProcessInterval:");
            stringBuilder.append(param1Long);
            Log.i("==record", stringBuilder.toString());
            ZegoCommonHelper.b().a(param1Long);
            RecordingOnliveManager.a(this.a).d(param1Long);
          }
          
          public void onReadEOF(int param1Int) {
            Log.i("==record", "onReadEOF");
          }
          
          public void onSeekComplete(int param1Int1, long param1Long, int param1Int2) {
            Log.i("==record", "onSeekComplete");
          }
          
          public void onSnapshot(Bitmap param1Bitmap, int param1Int) {
            Log.i("==record", "onSnapshot");
          }
          
          public void onVideoBegin(int param1Int) {
            Log.i("==record", "onVideoBegin");
          }
        });
  }
  
  private void z() {
    AppInfo.n().removeCallbacks(this.i);
    AppInfo.n().postDelayed(this.i, 2000L);
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
    if (TextUtils.isEmpty(this.c)) {
      Log.i("==record", "mStreamID is empty");
      return;
    } 
    if (!this.n) {
      this.n = true;
      Log.i("==record", "startPublish");
      ZegoCommonHelper.b().c().startPublishing(this.c, "", 0);
    } 
  }
  
  public void a(float paramFloat) {
    if (this.b == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("strength:");
    stringBuilder.append(paramFloat);
    Log.i("==record", stringBuilder.toString());
    this.b.setFilterStrength(paramFloat);
  }
  
  public void a(float paramFloat1, float paramFloat2, String paramString) {
    BluedUIHttpResponse<BluedEntityA<LiveRoomData>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<LiveRoomData>>(this, (IRequestHost)this.f.w_()) {
        protected void a(BluedEntityA<LiveRoomData> param1BluedEntityA) {}
      };
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.f.u);
    stringBuilder.append("");
    LiveRoomHttpUtils.a(bluedUIHttpResponse, stringBuilder.toString(), paramFloat1, paramFloat2, paramString);
  }
  
  public void a(int paramInt) {
    if (this.r == paramInt)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("switchScreen:");
    stringBuilder.append(paramInt);
    Log.i("==record", stringBuilder.toString());
    this.r = paramInt;
    if (this.r == 0) {
      ZegoCommonHelper.b().c().stopPreview();
      ZegoCommonHelper.b().c().setAppOrientation(0);
      ZegoCommonHelper.b().b(0);
      ZegoCommonHelper.b().c().startPreview();
      return;
    } 
    ZegoCommonHelper.b().c().stopPreview();
    ZegoCommonHelper.b().c().setAppOrientation(1);
    ZegoCommonHelper.b().c(0);
    ZegoCommonHelper.b().c().startPreview();
  }
  
  public void a(int paramInt, String paramString) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("startConferenceInternal mode:");
    stringBuilder1.append(paramInt);
    Log.i("==record", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("startConferenceInternal playId:");
    stringBuilder1.append(paramString);
    Log.i("==record", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("startConferenceInternal loginRoomSuccess:");
    stringBuilder1.append(this.o);
    Log.i("==record", stringBuilder1.toString());
    LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("我的拉流id:");
    stringBuilder2.append(paramString);
    liveMsgSendManager.b(stringBuilder2.toString());
    if (paramInt == 0)
      j(); 
    if (f() > 0)
      e(); 
    if (paramInt == 3 || paramInt == 4) {
      Log.v("==record", "startConferenceInternal playId ignore");
      return;
    } 
    a(this.c, paramString, 1);
  }
  
  public void a(long paramLong) {
    AppInfo.n().removeCallbacks(this.h);
    AppInfo.n().postDelayed(this.h, paramLong);
  }
  
  public void a(Context paramContext, ISenseTimeProcessor paramISenseTimeProcessor) {
    try {
      VideoFilterFactory videoFilterFactory = new VideoFilterFactory(VideoFilterFactory.FilterType.e, (ISenseTimeProcessor)this.b);
      videoFilterFactory.a(this.a);
      ZegoExternalVideoFilter.setVideoFilterFactory((ZegoVideoFilterFactory)videoFilterFactory, 0);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void a(BluedBeautifyKey.KEY paramKEY, float paramFloat) {
    SenseTimeZegoFlashManger senseTimeZegoFlashManger = this.b;
    if (senseTimeZegoFlashManger == null)
      return; 
    senseTimeZegoFlashManger.setBeautyParam(paramKEY, paramFloat);
  }
  
  public void a(BluedFilterType.FILER paramFILER) {
    SenseTimeZegoFlashManger senseTimeZegoFlashManger = this.b;
    if (senseTimeZegoFlashManger == null)
      return; 
    if (paramFILER == null) {
      senseTimeZegoFlashManger.setFilterStyle(null);
      return;
    } 
    Log.i("==record", "setFilter");
    this.b.setFilterStyle(paramFILER);
  }
  
  public void a(LiveGiftModel paramLiveGiftModel, ISetStickerListener paramISetStickerListener) {
    if (this.b == null) {
      if (paramISetStickerListener != null)
        paramISetStickerListener.onFailed(ErrorCode.PlayStickerCode.a, "STManager is null"); 
      return;
    } 
    Log.i("==record", "setSticker");
    if (paramLiveGiftModel != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setSticker:");
      stringBuilder.append(paramLiveGiftModel.anim_code);
      Log.i("==record", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("setSticker:");
      stringBuilder.append(paramLiveGiftModel.resource_url);
      Log.i("==record", stringBuilder.toString());
      this.b.changeSticker(paramLiveGiftModel.anim_code, paramLiveGiftModel.resource_url, paramISetStickerListener);
      this.b.enableSticker(true);
      Log.v("pk", "setSticker--");
      return;
    } 
    this.b.enableSticker(false);
  }
  
  public void a(String paramString1, String paramString2, int paramInt) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("startZegoPlay:");
    stringBuilder1.append(paramString1);
    stringBuilder1.append("  :");
    stringBuilder1.append(paramString2);
    stringBuilder1.append("  :");
    stringBuilder1.append(paramInt);
    Log.i("==record", stringBuilder1.toString());
    LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("拉流index：");
    stringBuilder2.append(paramInt);
    stringBuilder2.append(" -- playId：");
    stringBuilder2.append(paramString2);
    liveMsgSendManager.b(stringBuilder2.toString());
    this.l.add(paramString2);
    if (TextUtils.isEmpty(paramString2))
      return; 
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt == 3) {
          if (this.f.aH.getTag(R.id.zego_texture_id) instanceof String && !TextUtils.equals((String)this.f.aH.getTag(R.id.zego_texture_id), paramString2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("playId not equal D:");
            stringBuilder.append(paramString2);
            Log.v("==record", stringBuilder.toString());
            this.f.aH();
          } 
          this.f.av.setVisibility(0);
          this.f.aH.setVisibility(0);
          this.f.aH.setTag(R.id.zego_texture_id, paramString2);
          ZegoCommonHelper.b().c().startPlayingStream(paramString2, this.f.aH);
          ZegoCommonHelper.b().c().setViewMode(1, paramString2);
        } 
      } else {
        if (this.f.aG.getTag(R.id.zego_texture_id) instanceof String && !TextUtils.equals((String)this.f.aG.getTag(R.id.zego_texture_id), paramString2)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("playId not equal C:");
          stringBuilder.append(paramString2);
          Log.v("==record", stringBuilder.toString());
          this.f.aG();
        } 
        this.f.au.setVisibility(0);
        this.f.aG.setVisibility(0);
        this.f.aG.setTag(R.id.zego_texture_id, paramString2);
        ZegoCommonHelper.b().c().startPlayingStream(paramString2, this.f.aG);
        ZegoCommonHelper.b().c().setViewMode(1, paramString2);
      } 
    } else {
      if (this.f.aF.getTag(R.id.zego_texture_id) instanceof String && !TextUtils.equals((String)this.f.aF.getTag(R.id.zego_texture_id), paramString2)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("playId not equal B:");
        stringBuilder.append(paramString2);
        Log.v("==record", stringBuilder.toString());
        this.f.aF();
      } 
      this.f.at.setVisibility(0);
      this.f.aF.setVisibility(0);
      this.f.aF.setTag(R.id.zego_texture_id, paramString2);
      ZegoCommonHelper.b().c().startPlayingStream(paramString2, this.f.aF);
      ZegoCommonHelper.b().c().setViewMode(1, paramString2);
    } 
    c(paramString1, paramString2, paramInt);
  }
  
  public void a(String paramString, boolean paramBoolean) {
    Logger.a("==record", new Object[] { "startLiveConnecting:" });
    if (LiveRoomManager.a().h() == null)
      return; 
    if (this.o)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("conference_id:");
    stringBuilder.append((LiveRoomManager.a().h()).conference_id);
    Log.v("==record", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("streamId:");
    stringBuilder.append(paramString);
    Log.v("==record", stringBuilder.toString());
    this.c = paramString;
    if (this.f.be) {
      this.f.getActivity().setRequestedOrientation(0);
      a(1);
    } else {
      a(0);
      if (ZegoCommonHelper.b().f() || paramBoolean) {
        ZegoCommonHelper.b().c().stopPreview();
        ZegoCommonHelper.b().b(this.f.x);
        ZegoCommonHelper.b().c().setPreviewView(this.f.aE());
        ZegoCommonHelper.b().c().setPreviewViewMode(1);
        ZegoCommonHelper.b().c().startPreview();
      } 
    } 
    ZegoCommonHelper.b().c().loginRoom((LiveRoomManager.a().h()).conference_id, 1, new IZegoLoginCompletionCallback(this, paramBoolean) {
          public void onLoginCompletion(int param1Int, ZegoStreamInfo[] param1ArrayOfZegoStreamInfo) {
            boolean bool = false;
            if (param1Int == 0) {
              RecordingOnliveManager.a(this.b, true);
              if (TextUtils.isEmpty(this.b.c))
                return; 
              ZegoCommonHelper.b().c().enableMicDevice(true);
              this.b.a();
              if (this.a) {
                this.b.f();
                if ((LiveRoomManager.a().h()).matchmaking != null && (LiveRoomManager.a().h()).matchmaking.fans != null) {
                  (RecordingOnliveManager.a(this.b)).bb.b((LiveRoomManager.a().h()).matchmaking.fans);
                  Iterator<LiveMakeLoverFansModel> iterator = (LiveRoomManager.a().h()).matchmaking.fans.iterator();
                  param1Int = bool;
                  while (iterator.hasNext()) {
                    LiveMakeLoverFansModel liveMakeLoverFansModel = iterator.next();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("sync info:");
                    stringBuilder.append(param1Int);
                    stringBuilder.append("   :");
                    stringBuilder.append(liveMakeLoverFansModel.stream);
                    Log.i("==record", stringBuilder.toString());
                    RecordingOnliveManager recordingOnliveManager = (RecordingOnliveManager.a(this.b)).S;
                    String str2 = (LiveRoomManager.a().h()).stream;
                    String str1 = liveMakeLoverFansModel.stream;
                    recordingOnliveManager.b(str2, str1, ++param1Int);
                  } 
                } 
              } else {
                this.b.a(false);
                return;
              } 
            } else {
              RecordingOnliveManager.a(this.b, false);
              AppMethods.a("登录zego房间失败");
            } 
          }
        });
  }
  
  public void a(boolean paramBoolean) {
    this.q = false;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append((LiveRoomManager.a().h()).publish_url);
    stringBuilder2.append("&serialnum=");
    String str = stringBuilder2.toString();
    this.k++;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(str);
    stringBuilder3.append(String.valueOf(this.k));
    this.p = stringBuilder3.toString();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("startSingleStream:");
    stringBuilder1.append(this.p);
    Log.v("==record", stringBuilder1.toString());
    ZegoMixStreamHelper.a().b();
    ZegoCommonHelper.b().c().addPublishTarget(this.p, this.c, new IZegoUpdatePublishTargetCallback(this, paramBoolean) {
          public void onUpdatePublishTargetState(int param1Int, String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("addPublishTarget:");
            stringBuilder.append(param1Int);
            Log.v("==record", stringBuilder.toString());
            if (this.a)
              ZegoMixStreamHelper.a().c(this.b.c); 
          }
        });
  }
  
  public int b(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setLocalWindowPosition:");
    stringBuilder.append(paramString);
    stringBuilder.append(" getLiveState:");
    stringBuilder.append(this.f.A());
    Log.i("==record", stringBuilder.toString());
    ZegoMixStreamInfo zegoMixStreamInfo = new ZegoMixStreamInfo();
    zegoMixStreamInfo.streamID = paramString;
    if (this.f.aN() || this.f.aO()) {
      Log.i("==record", "normal");
      if (this.f.be) {
        zegoMixStreamInfo.left = 0;
        zegoMixStreamInfo.top = 0;
        zegoMixStreamInfo.right = (ZegoCommonHelper.b()).i;
        zegoMixStreamInfo.bottom = (ZegoCommonHelper.b()).h;
      } else {
        zegoMixStreamInfo.left = 0;
        zegoMixStreamInfo.top = 0;
        zegoMixStreamInfo.right = (ZegoCommonHelper.b()).h;
        zegoMixStreamInfo.bottom = (ZegoCommonHelper.b()).i;
      } 
      return ZegoMixStreamHelper.a().a(zegoMixStreamInfo, paramString);
    } 
    if (this.f.aM()) {
      if (!this.f.be) {
        Log.i("==record", "pk");
        int i = (ZegoCommonHelper.b()).h / 2;
        int j = (ZegoCommonHelper.b()).h / 4 * 3;
        zegoMixStreamInfo.left = 0;
        zegoMixStreamInfo.top = ((ZegoCommonHelper.b()).i - j) / 2;
        zegoMixStreamInfo.right = i;
        zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + j;
      } 
    } else if (this.f.aP()) {
      if (!this.f.be) {
        Log.i("==record", "makefriends");
        int i = (ZegoCommonHelper.b()).h / 2;
        int j = (int)(i * RecordingMakeFriendManager.c);
        zegoMixStreamInfo.left = 0;
        zegoMixStreamInfo.top = ((ZegoCommonHelper.b()).i - j * 2) / 2;
        zegoMixStreamInfo.right = i;
        zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + j;
      } 
    } else if (this.f.aQ()) {
      if (this.f.be)
        return 0; 
      Log.i("==record", "makelover");
      int i = (ZegoCommonHelper.b()).h / 3;
      int j = (int)(i * RecordingMakeLoverManager.d);
      zegoMixStreamInfo.left = 0;
      zegoMixStreamInfo.top = ((ZegoCommonHelper.b()).i - j * 2) / 2;
      zegoMixStreamInfo.right = i;
      zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + j;
    } 
    return ZegoMixStreamHelper.a().a(zegoMixStreamInfo, paramString);
  }
  
  public void b() {
    if (this.n) {
      this.n = false;
      Log.i("==record", "stopPublishing");
      ZegoCommonHelper.b().c().stopPublishing();
    } 
  }
  
  public void b(int paramInt) {}
  
  public void b(long paramLong) {
    if (LiveRoomManager.a().h() != null)
      EventTrackLive.a(LiveProtos.Event.LIVE_LOADING, LiveRoomManager.a().c(), LiveRoomManager.a().e()); 
    Map<String, String> map = BluedHttpTools.a();
    map.put("loading_time", String.valueOf(paramLong));
    map.put("session_id", String.valueOf(this.f.u));
    InstantLogBody instantLogBody = new InstantLogBody();
    instantLogBody.service = "live_loading";
    instantLogBody.event = 20001;
    InstantLog.a(instantLogBody, map);
  }
  
  public void b(String paramString1, String paramString2, int paramInt) {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("startZegoPlayForMakeLover:");
    stringBuilder1.append(paramString1);
    stringBuilder1.append("  :");
    stringBuilder1.append(paramString2);
    stringBuilder1.append("  :");
    stringBuilder1.append(paramInt);
    Log.i("==record", stringBuilder1.toString());
    LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("拉流index：");
    stringBuilder2.append(paramInt);
    stringBuilder2.append(" -- playId：");
    stringBuilder2.append(paramString2);
    liveMsgSendManager.b(stringBuilder2.toString());
    this.l.add(paramString2);
    if (TextUtils.isEmpty(paramString2))
      return; 
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3) {
          if (paramInt != 4) {
            if (paramInt == 5) {
              if (this.f.aJ.getTag(R.id.zego_texture_id) instanceof String && !TextUtils.equals((String)this.f.aJ.getTag(R.id.zego_texture_id), paramString2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("playId not equal F:");
                stringBuilder.append(paramString2);
                Log.v("==record", stringBuilder.toString());
                this.f.aJ();
              } 
              this.f.ax.setVisibility(0);
              this.f.aJ.setVisibility(0);
              this.f.aJ.setTag(R.id.zego_texture_id, paramString2);
              ZegoCommonHelper.b().c().startPlayingStream(paramString2, this.f.aJ);
              ZegoCommonHelper.b().c().setViewMode(1, paramString2);
            } 
          } else {
            if (this.f.aI.getTag(R.id.zego_texture_id) instanceof String && !TextUtils.equals((String)this.f.aI.getTag(R.id.zego_texture_id), paramString2)) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("playId not equal E:");
              stringBuilder.append(paramString2);
              Log.v("==record", stringBuilder.toString());
              this.f.aI();
            } 
            this.f.aw.setVisibility(0);
            this.f.aI.setVisibility(0);
            this.f.aI.setTag(R.id.zego_texture_id, paramString2);
            ZegoCommonHelper.b().c().startPlayingStream(paramString2, this.f.aI);
            ZegoCommonHelper.b().c().setViewMode(1, paramString2);
          } 
        } else {
          if (this.f.aH.getTag(R.id.zego_texture_id) instanceof String && !TextUtils.equals((String)this.f.aH.getTag(R.id.zego_texture_id), paramString2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("playId not equal D:");
            stringBuilder.append(paramString2);
            Log.v("==record", stringBuilder.toString());
            this.f.aH();
          } 
          this.f.av.setVisibility(0);
          this.f.aH.setVisibility(0);
          this.f.aH.setTag(R.id.zego_texture_id, paramString2);
          ZegoCommonHelper.b().c().startPlayingStream(paramString2, this.f.aH);
          ZegoCommonHelper.b().c().setViewMode(1, paramString2);
        } 
      } else {
        if (this.f.aG.getTag(R.id.zego_texture_id) instanceof String && !TextUtils.equals((String)this.f.aG.getTag(R.id.zego_texture_id), paramString2)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("playId not equal C:");
          stringBuilder.append(paramString2);
          Log.v("==record", stringBuilder.toString());
          this.f.aG();
        } 
        this.f.au.setVisibility(0);
        this.f.aG.setVisibility(0);
        this.f.aG.setTag(R.id.zego_texture_id, paramString2);
        ZegoCommonHelper.b().c().startPlayingStream(paramString2, this.f.aG);
        ZegoCommonHelper.b().c().setViewMode(1, paramString2);
      } 
    } else {
      if (this.f.aF.getTag(R.id.zego_texture_id) instanceof String && !TextUtils.equals((String)this.f.aF.getTag(R.id.zego_texture_id), paramString2)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("playId not equal B:");
        stringBuilder.append(paramString2);
        Log.v("==record", stringBuilder.toString());
        this.f.aF();
      } 
      this.f.at.setVisibility(0);
      this.f.aF.setVisibility(0);
      this.f.aF.setTag(R.id.zego_texture_id, paramString2);
      ZegoCommonHelper.b().c().startPlayingStream(paramString2, this.f.aF);
      ZegoCommonHelper.b().c().setViewMode(1, paramString2);
    } 
    c(paramString1, paramString2, paramInt);
  }
  
  public void b(boolean paramBoolean) {
    if (paramBoolean) {
      ZegoCommonHelper.b().c().setVideoMirrorMode(1, 0);
      return;
    } 
    ZegoCommonHelper.b().c().setVideoMirrorMode(0, 0);
  }
  
  public void c() {
    if (this.m) {
      for (String str : this.l) {
        ZegoCommonHelper.b().c().stopPlayingStream(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("停止拉流id:");
        stringBuilder.append(str);
        Log.v("==record", stringBuilder.toString());
      } 
      this.l.clear();
      this.m = false;
    } 
  }
  
  public void c(String paramString1, String paramString2, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setRemoteWindowPosition:");
    stringBuilder.append(paramString1);
    stringBuilder.append(" getLiveState:");
    stringBuilder.append(this.f.A());
    stringBuilder.append(" index：");
    stringBuilder.append(paramInt);
    Log.i("==record", stringBuilder.toString());
    ZegoMixStreamInfo zegoMixStreamInfo = new ZegoMixStreamInfo();
    zegoMixStreamInfo.streamID = paramString2;
    if (this.f.aN() || this.f.aO()) {
      paramInt = (int)((ZegoCommonHelper.b()).h * 1.0F / 544.0F * 145.0F);
      int i = (int)((ZegoCommonHelper.b()).i * 1.0F / 960.0F * 255.0F);
      if (this.f.be) {
        zegoMixStreamInfo.left = (ZegoCommonHelper.b()).i - paramInt - 60;
        zegoMixStreamInfo.top = (ZegoCommonHelper.b()).h - i - 50;
        zegoMixStreamInfo.right = (ZegoCommonHelper.b()).i - 60;
        zegoMixStreamInfo.bottom = (ZegoCommonHelper.b()).h - 50;
      } else {
        zegoMixStreamInfo.left = (ZegoCommonHelper.b()).h - paramInt;
        zegoMixStreamInfo.top = (ZegoCommonHelper.b()).i - i - 80;
        zegoMixStreamInfo.right = (ZegoCommonHelper.b()).h;
        zegoMixStreamInfo.bottom = (ZegoCommonHelper.b()).i - 80;
      } 
    } else if (this.f.aM()) {
      if (!this.f.be) {
        paramInt = (ZegoCommonHelper.b()).h / 2;
        int i = (ZegoCommonHelper.b()).h / 4 * 3;
        zegoMixStreamInfo.left = paramInt;
        zegoMixStreamInfo.top = ((ZegoCommonHelper.b()).i - i) / 2;
        zegoMixStreamInfo.right = (ZegoCommonHelper.b()).h;
        zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + i;
      } 
    } else if (this.f.aP()) {
      if (!this.f.be) {
        int i = (ZegoCommonHelper.b()).h / 2;
        int j = (int)(i * RecordingMakeFriendManager.c);
        if (paramInt == 1) {
          zegoMixStreamInfo.left = i;
          paramInt = (ZegoCommonHelper.b()).i;
          int k = j * 2;
          zegoMixStreamInfo.top = (paramInt - k) / 2;
          zegoMixStreamInfo.right = (ZegoCommonHelper.b()).h;
          zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + j;
          zegoMixStreamInfo.left = i;
          zegoMixStreamInfo.top = ((ZegoCommonHelper.b()).i - k) / 2;
          zegoMixStreamInfo.right = (ZegoCommonHelper.b()).h;
          zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + j;
        } else if (paramInt == 2) {
          zegoMixStreamInfo.left = 0;
          zegoMixStreamInfo.top = ((ZegoCommonHelper.b()).i - j * 2) / 2 + j;
          zegoMixStreamInfo.right = i;
          zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + j;
        } else if (paramInt == 3) {
          zegoMixStreamInfo.left = i;
          zegoMixStreamInfo.top = ((ZegoCommonHelper.b()).i - j * 2) / 2 + j;
          zegoMixStreamInfo.right = (ZegoCommonHelper.b()).h;
          zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + j;
        } 
      } 
    } else if (this.f.aQ()) {
      if (this.f.be)
        return; 
      int i = (ZegoCommonHelper.b()).h / 3;
      int j = (int)(i * RecordingMakeLoverManager.d);
      if (paramInt == 1) {
        zegoMixStreamInfo.left = i;
        zegoMixStreamInfo.top = ((ZegoCommonHelper.b()).i - j * 2) / 2;
        zegoMixStreamInfo.right = i * 2;
        zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + j;
      } else if (paramInt == 2) {
        zegoMixStreamInfo.left = i * 2;
        zegoMixStreamInfo.top = ((ZegoCommonHelper.b()).i - j * 2) / 2;
        zegoMixStreamInfo.right = (ZegoCommonHelper.b()).h;
        zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + j;
      } else if (paramInt == 3) {
        zegoMixStreamInfo.left = 0;
        zegoMixStreamInfo.top = ((ZegoCommonHelper.b()).i - j * 2) / 2 + j;
        zegoMixStreamInfo.right = i;
        zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + j;
      } else if (paramInt == 4) {
        zegoMixStreamInfo.left = i;
        zegoMixStreamInfo.top = ((ZegoCommonHelper.b()).i - j * 2) / 2 + j;
        zegoMixStreamInfo.right = i * 2;
        zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + j;
      } else if (paramInt == 5) {
        zegoMixStreamInfo.left = i * 2;
        zegoMixStreamInfo.top = ((ZegoCommonHelper.b()).i - j * 2) / 2 + j;
        zegoMixStreamInfo.right = (ZegoCommonHelper.b()).h;
        zegoMixStreamInfo.bottom = zegoMixStreamInfo.top + j;
      } 
    } 
    ZegoMixStreamHelper.a().a(zegoMixStreamInfo, paramString1);
  }
  
  public void d() {
    if (this.f.getContext() == null)
      return; 
    ZegoCommonHelper.b().c().setPreviewView(null);
    RecordingOnliveFragment recordingOnliveFragment = this.f;
    recordingOnliveFragment.E = new TextureView(recordingOnliveFragment.getContext());
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.gravity = 17;
    this.f.D.removeAllViews();
    this.f.D.addView((View)this.f.E, (ViewGroup.LayoutParams)layoutParams);
    ZegoCommonHelper.b().c().setPreviewView(this.f.E);
  }
  
  public void e() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("stopSingleStream:");
    stringBuilder.append(this.p);
    Log.v("==record", stringBuilder.toString());
    if (TextUtils.isEmpty(this.p))
      return; 
    ZegoCommonHelper.b().c().deletePublishTarget(this.p, this.c, new IZegoUpdatePublishTargetCallback(this) {
          public void onUpdatePublishTargetState(int param1Int, String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("stopSingleStream:");
            stringBuilder.append(param1Int);
            Log.v("==record", stringBuilder.toString());
          }
        });
  }
  
  public int f() {
    Log.v("==record", "startMixStream");
    this.q = true;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append((LiveRoomManager.a().h()).publish_url);
    stringBuilder1.append("&serialnum=");
    String str = stringBuilder1.toString();
    this.k++;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str);
    stringBuilder2.append(String.valueOf(this.k));
    str = stringBuilder2.toString();
    ZegoMixStreamHelper.a().b(str);
    return b(this.c);
  }
  
  public void g() {
    this.d ^= 0x1;
    ZegoCommonHelper.b().a(this.d);
  }
  
  public void h() {
    Log.v("==record", "stopConference");
    this.f.a(new Runnable(this) {
          public void run() {
            this.a.c();
            (RecordingOnliveManager.a(this.a)).aF.setVisibility(8);
            if (RecordingOnliveManager.d(this.a))
              this.a.a(true); 
          }
        });
  }
  
  public void i() {
    LiveRoomHttpUtils.m(new BluedUIHttpResponse(this, (IRequestHost)this.f.w_()) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        });
  }
  
  public void j() {
    ZegoCommonHelper.b().c().enableMicDevice(false);
  }
  
  public void k() {
    ZegoCommonHelper.b().c().enableMicDevice(true);
  }
  
  public void l() {
    this.f.ab();
  }
  
  public void m() {
    this.j ^= 0x1;
    if (this.j) {
      b(this.f.I);
    } else {
      b(false);
    } 
    if (this.j) {
      this.f.k(8);
    } else {
      this.f.k(0);
    } 
    boolean bool = ZegoCommonHelper.b().c().setFrontCam(this.j);
    if (bool) {
      SenseTimeZegoFlashManger senseTimeZegoFlashManger = this.b;
      if (senseTimeZegoFlashManger != null) {
        senseTimeZegoFlashManger.switchCamera();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("switchCamera:");
        stringBuilder.append(bool);
        Log.v("==record", stringBuilder.toString());
      } 
    } 
  }
  
  public void n() {
    if (this.b != null) {
      Log.v("==record", "onStart");
      this.b.onStart();
    } 
  }
  
  public void o() {
    if (this.b != null) {
      Log.v("==record", "onStop");
      this.b.onStop();
    } 
  }
  
  public void onHandAction(long paramLong) {
    if (AppInfo.m()) {
      if (paramLong == 131072L) {
        AppMethods.a("检测到抱拳手势");
        return;
      } 
      if (paramLong == 262144L) {
        AppMethods.a("检测到单手比爱心手势");
        return;
      } 
      if (paramLong == 8192L) {
        AppMethods.a("检测到单枪手势");
        return;
      } 
      if (paramLong == 2048L) {
        AppMethods.a("检测到大拇哥手势");
        return;
      } 
      if (paramLong == 16384L)
        AppMethods.a("检测到爱心手势"); 
    } 
  }
  
  public void p() {
    a();
    ZegoCommonHelper.b().j();
    if (this.b != null) {
      Log.v("==record", "onResume");
      this.b.onResume();
    } 
    ChatManager.getInstance().resumeLive(this.f.t, this.f.u);
  }
  
  public void q() {
    b();
    ZegoCommonHelper.b().k();
    if (this.b != null) {
      Log.v("==record", "onPause");
      this.b.onPause();
    } 
    if (!this.f.bh)
      ChatManager.getInstance().pauseLive(this.f.t, this.f.u); 
  }
  
  public void r() {
    Log.v("==record", "------------onDestroy------------");
    SenseTimeZegoFlashManger senseTimeZegoFlashManger = this.b;
    if (senseTimeZegoFlashManger != null)
      senseTimeZegoFlashManger.onDestroy(); 
    ZegoCommonHelper.b().c().logoutRoom();
    c();
    ZegoCommonHelper.b().c().stopPreview();
    b();
    ZegoCommonHelper.b().h();
    if (this.q)
      ZegoMixStreamHelper.a().c(this.c); 
    ZegoMixStreamHelper.a().c();
    ZegoExternalVideoCapture.setVideoCaptureFactory(null, 0);
    ZegoCommonHelper.b().g();
    this.o = false;
  }
  
  public void s() {
    b();
    ZegoCommonHelper.b().h();
    this.f.K_();
    this.f.j(8);
  }
  
  public void t() {
    AppInfo.n().removeCallbacks(this.h);
  }
  
  public void u() {
    BluedUIHttpResponse<BluedEntityA<LiveRoomData>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<LiveRoomData>>(this, (IRequestHost)this.f.w_()) {
        protected void a(BluedEntityA<LiveRoomData> param1BluedEntityA) {}
      };
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.f.u);
    stringBuilder.append("");
    LiveRoomHttpUtils.o(bluedUIHttpResponse, stringBuilder.toString());
  }
  
  public void v() {
    m();
  }
  
  public void w() {
    ZegoCommonHelper.b().c().enableTorch(true);
  }
  
  public void x() {
    ZegoCommonHelper.b().c().enableTorch(false);
  }
  
  class StartMixStream implements Runnable {
    private StartMixStream(RecordingOnliveManager this$0) {}
    
    public void run() {
      if (RecordingOnliveManager.a(this.a).aS()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isLiveConnecting:");
        stringBuilder.append(this.a.c);
        Log.i("==makelover==", stringBuilder.toString());
        ZegoMixStreamHelper.a().a(this.a.c);
        RecordingOnliveManager.b(this.a);
      } 
    }
  }
  
  class StopConnecting implements Runnable {
    private StopConnecting(RecordingOnliveManager this$0) {}
    
    public void run() {
      this.a.b();
      if (RecordingOnliveManager.a(this.a) != null) {
        RecordingOnliveManager.a(this.a).K_();
        RecordingOnliveManager.a(this.a).j(8);
        RecordingOnliveManager.a(this.a).h(true);
      } 
      if (RecordingOnliveManager.c(this.a) != null) {
        RecordingOnliveManager.c(this.a).shutdownNow();
        RecordingOnliveManager.a(this.a, (ExecutorService)null);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\RecordingOnliveManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */