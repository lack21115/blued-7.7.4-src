package com.blued.android.module.yy_china.trtc_audio.float_window;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AudioManagerUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.utils.AssetsUtils;
import com.blued.android.module.yy_china.NotificationService;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.BlindPublishModel;
import com.blued.android.module.yy_china.model.YYHeartModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYMsgKickInfoExtra;
import com.blued.android.module.yy_china.model.YYRetryRoomModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.observer.RoleStatusObserver;
import com.blued.android.module.yy_china.trtc_audio.IAudioContract;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.trtc_audio.model.FloatPermissionEvent;
import com.blued.android.module.yy_china.trtc_audio.model.GenerateTestUserSig;
import com.blued.android.module.yy_china.trtc_audio.permission.FloatPermissionDialogActivity;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.tencent.trtc.TRTCCloudDef;
import java.util.List;
import java.util.Set;

public class AudioFloatWindow implements Observer<FloatPermissionEvent>, RoleStatusObserver {
  private Context a;
  
  private FloatWindow b;
  
  private FrameLayout c;
  
  private ImageView d;
  
  private ImageView e;
  
  private ImageView f;
  
  private Observer<YYMsgKickInfoExtra> g = new Observer<YYMsgKickInfoExtra>(this) {
      public void a(YYMsgKickInfoExtra param1YYMsgKickInfoExtra) {
        if (param1YYMsgKickInfoExtra == null) {
          ToastUtils.a("你被房主移出了房间", 0);
        } else {
          ToastUtils.a("房间已关闭", 0);
        } 
        Logger.e("AudioFloatWindow", new Object[] { "关闭直播间" });
        this.a.b("");
      }
    };
  
  private Observer<YYImModel> h = new Observer<YYImModel>(this) {
      public void a(YYImModel param1YYImModel) {
        if (param1YYImModel == null)
          return; 
        YYImMsgManager.a().w(param1YYImModel);
      }
    };
  
  private long i = 0L;
  
  public AudioFloatWindow(Context paramContext) {
    this.a = paramContext;
    c();
    d();
  }
  
  private void a(String paramString, YYUserInfo paramYYUserInfo) {
    long l1 = System.currentTimeMillis();
    long l2 = this.i;
    if (l2 > 0L && l1 - l2 >= 120000L)
      YYRoomHttpUtils.h(paramString, new BluedUIHttpResponse<BluedEntityA<YYHeartModel>>(this, null, paramYYUserInfo) {
            protected void a(BluedEntityA<YYHeartModel> param1BluedEntityA) {
              if (param1BluedEntityA != null) {
                if (!param1BluedEntityA.hasData())
                  return; 
                YYHeartModel yYHeartModel = (YYHeartModel)param1BluedEntityA.getSingleData();
                if (yYHeartModel == null)
                  return; 
                if (yYHeartModel.in_room != 1)
                  this.b.b(""); 
                if (yYHeartModel.is_mics != 1) {
                  YYUserInfo yYUserInfo = this.a;
                  yYUserInfo.is_mic = "0";
                  yYUserInfo.is_open_mic = 0;
                  this.b.a("0");
                } 
              } 
            }
            
            public void onUIStart() {
              super.onUIStart();
              AudioFloatWindow.a(this.b, System.currentTimeMillis());
            }
          }null); 
  }
  
  private void a(String paramString1, String paramString2) {
    k();
    YYRoomHttpUtils.d(paramString1, d(paramString2), null);
  }
  
  private boolean a(Intent paramIntent) {
    List list = AppInfo.d().getPackageManager().queryIntentActivities(paramIntent, 65536);
    return (list != null && list.size() > 0);
  }
  
  private void c() {
    this.c = (FrameLayout)LayoutInflater.from(this.a).inflate(R.layout.view_audio_float_layout, null);
    this.d = (ImageView)this.c.findViewById(R.id.iv_talking_view);
    this.e = (ImageView)this.c.findViewById(R.id.iv_header);
    this.f = (ImageView)this.c.findViewById(R.id.float_colse);
    this.f.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel != null)
              EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_MINIMIZED_WINDOW_CLICK, yYRoomModel.room_id, yYRoomModel.uid); 
            this.a.b("");
          }
        });
  }
  
  private void c(String paramString) {
    k();
    YYRoomHttpUtils.c(paramString, d(""), null);
  }
  
  private BluedUIHttpResponse d(String paramString) {
    return new BluedUIHttpResponse<BluedEntityA<Object>>(this, paramString) {
        protected void a(BluedEntityA<Object> param1BluedEntityA) {
          if (!TextUtils.isEmpty(this.a))
            LiveEventBus.get("into_new_yy_room").post(this.a); 
        }
      };
  }
  
  private void d() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null) {
      ImageLoader.a(null, yYRoomModel.avatar).a(R.drawable.user_bg_round).a(this.e);
      String str = AssetsUtils.a("live_talking_window.png", false);
      ImageLoader.a(null, RecyclingUtils.Scheme.c.b(str)).e(-1).f().a(this.d);
      if (TextUtils.equals(yYRoomModel.uid, YYRoomInfoManager.d().e())) {
        this.f.setVisibility(8);
        return;
      } 
      this.f.setVisibility(0);
    } 
  }
  
  private void e() {
    Logger.e("AudioFloatWindow", new Object[] { "showFloatView() ... " });
    YYObserverManager.a().a(this);
    AudioChannelManager.e().b(i());
    AudioChannelManager.e().a(j());
    LiveEventBus.get("close_living_room", YYMsgKickInfoExtra.class).observeForever(this.g);
    LiveEventBus.get("display_emoji_image", YYImModel.class).observeForever(this.h);
    this.b = new FloatWindow(this.a, 0, 800, 60, 60, false, new IFloatWindow.IFloatWindowCallback(this) {
          public View a() {
            return (View)AudioFloatWindow.a(this.a);
          }
          
          public void b() {
            AudioFloatWindow.b(this.a);
            YYRoomInfoManager.d().c(AudioFloatWindow.c(this.a));
          }
        });
    this.b.a(true);
    this.b.a();
    this.b.a(0);
  }
  
  private void f() {
    h();
    FloatWindow floatWindow = this.b;
    if (floatWindow != null) {
      floatWindow.b();
      this.b = null;
    } 
    YYObserverManager.a().b(this);
    AudioChannelManager.e().a(null);
    AudioChannelManager.e().g();
    (AudioChannelManager.e()).a = false;
  }
  
  private void g() {
    LiveEventBus.get("event_request_float_permission", FloatPermissionEvent.class).observeForever(this);
  }
  
  private void h() {
    Logger.e("window", new Object[] { "unRegisterBus ... " });
    LiveEventBus.get("event_request_float_permission", FloatPermissionEvent.class).removeObserver(this);
    LiveEventBus.get("close_living_room", YYMsgKickInfoExtra.class).removeObserver(this.g);
    LiveEventBus.get("display_emoji_image", YYImModel.class).removeObserver(this.h);
  }
  
  private IAudioContract.IAudioCallback i() {
    return new IAudioContract.IAudioCallback(this) {
        public void a() {}
        
        public void a(int param1Int) {}
        
        public void a(int param1Int, String param1String) {
          Logger.e("sdk", new Object[] { "float window onStartPublishCDNStream ... " });
          AudioFloatWindow.d(this.a);
          YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
          if (yYRoomModel == null)
            return; 
          YYRoomHttpUtils.a(yYRoomModel.room_id);
        }
        
        public void a(long param1Long) {}
        
        public void a(String param1String) {}
        
        public void a(String param1String, boolean param1Boolean) {
          YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
          YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
          if (yYRoomModel != null && yYUserInfo != null && TextUtils.equals(yYUserInfo.is_mic, "1")) {
            if (TextUtils.equals(yYRoomModel.uid, yYUserInfo.getUid()))
              return; 
            AudioFloatWindow.a(this.a, yYRoomModel.room_id, yYUserInfo);
          } 
        }
        
        public void a(Set<String> param1Set) {}
        
        public void b() {
          Logger.e("sdk", new Object[] { "float window onConnectionRecovery ... " });
          AudioFloatWindow.d(this.a);
        }
        
        public void b(int param1Int, String param1String) {}
        
        public void b(String param1String) {}
        
        public void c(String param1String) {}
      };
  }
  
  private IAudioContract.AppHandoverListener j() {
    return new IAudioContract.AppHandoverListener(this) {
        public void a() {
          if (AudioFloatWindow.e(this.a) != null) {
            Logger.e("window", new Object[] { "onAppBack ... " });
            AudioManagerUtils.a().a(false);
            AudioFloatWindow.e(this.a).b();
          } 
          YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
          if (yYUserInfo != null && TextUtils.equals(yYUserInfo.is_mic, "1")) {
            Intent intent = new Intent(AudioFloatWindow.c(this.a), NotificationService.class);
            AudioFloatWindow.c(this.a).startService(intent);
          } 
        }
        
        public void b() {
          if (AudioFloatWindow.e(this.a) != null) {
            Logger.e("window", new Object[] { "onAppFore ... " });
            AudioManagerUtils.a().b();
            AudioFloatWindow.e(this.a).a();
          } 
          AudioFloatWindow.d(this.a);
          Intent intent = new Intent(AudioFloatWindow.c(this.a), NotificationService.class);
          AudioFloatWindow.c(this.a).stopService(intent);
        }
      };
  }
  
  private void k() {
    YYRoomInfoManager.d().l();
    AudioChannelManager.e().c();
    Intent intent = new Intent(this.a, NotificationService.class);
    this.a.stopService(intent);
  }
  
  private void l() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYRoomHttpUtils.f(yYRoomModel.room_id, new BluedUIHttpResponse<BluedEntityA<YYRetryRoomModel>>(this, yYRoomModel) {
          protected void a(BluedEntityA<YYRetryRoomModel> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              if (!param1BluedEntityA.hasData())
                return; 
              YYRetryRoomModel yYRetryRoomModel = (YYRetryRoomModel)param1BluedEntityA.getSingleData();
              if (!TextUtils.equals(this.a.room_name, yYRetryRoomModel.room_name))
                this.a.room_name = yYRetryRoomModel.room_name; 
              if (!TextUtils.equals(this.a.relationship, yYRetryRoomModel.relationship))
                this.a.relationship = yYRetryRoomModel.relationship; 
              List list = yYRetryRoomModel.mics;
              if (yYRetryRoomModel.isCPChannel()) {
                ((YYSeatMemberModel)list.get(0)).itemType = 1;
                if (yYRetryRoomModel.getCPPresentStep() != this.a.getCPPresentStep()) {
                  this.a.setCPPresentStep(yYRetryRoomModel.getCPPresentStep());
                  this.a.setCPNextStep(yYRetryRoomModel.getCPNextStep());
                } 
              } 
              this.a.setSeatList(list);
              if (yYRetryRoomModel.isCPChannel() && yYRetryRoomModel.blind_publish != null && !yYRetryRoomModel.blind_publish.isEmpty())
                for (BlindPublishModel blindPublishModel : yYRetryRoomModel.blind_publish) {
                  YYSeatMemberModel yYSeatMemberModel = this.a.getSeatMember(blindPublishModel.uid);
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(blindPublishModel.choose_seat_num);
                  stringBuilder.append("");
                  yYSeatMemberModel.likeNum = stringBuilder.toString();
                }  
              YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
              if (yYUserInfo == null)
                return; 
              yYUserInfo.push_url = yYRetryRoomModel.publish_url;
              if (!TextUtils.equals(yYUserInfo.chat_anchor, yYRetryRoomModel.chat_anchor))
                yYUserInfo.chat_anchor = yYRetryRoomModel.chat_anchor; 
              if (yYUserInfo.is_open_mic != yYRetryRoomModel.is_open_mic) {
                yYUserInfo.is_open_mic = yYRetryRoomModel.is_open_mic;
                this.b.a(yYRetryRoomModel.is_open_mic);
              } 
              if (!TextUtils.equals(yYUserInfo.is_mic, yYRetryRoomModel.is_mic)) {
                yYUserInfo.is_mic = yYRetryRoomModel.is_mic;
                if (TextUtils.equals(yYRetryRoomModel.is_mic, "1")) {
                  this.b.a("1");
                } else {
                  this.b.a(yYUserInfo.chat_anchor);
                } 
              } 
              yYUserInfo.mute = yYRetryRoomModel.mute;
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (param1Int == 40380002) {
              ToastUtils.a("房间已关闭", 0);
              AudioFloatWindow.f(this.b);
            } else if (param1Int == 40380030) {
              ToastUtils.a("你已被房主移出了房间", 0);
              AudioFloatWindow.f(this.b);
            } else if (param1Int == 40380022) {
              AudioFloatWindow.f(this.b);
            } 
            return super.onUIFailure(param1Int, param1String);
          }
        }null);
  }
  
  public void a() {
    Logger.e("AudioFloatWindow", new Object[] { "show() ... " });
    if (Build.VERSION.SDK_INT >= 23) {
      if (Settings.canDrawOverlays(AppInfo.d())) {
        e();
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("package:");
      stringBuilder.append(AppInfo.d().getPackageManager());
      if (a(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(stringBuilder.toString())))) {
        g();
        Intent intent = new Intent(AppInfo.d(), FloatPermissionDialogActivity.class);
        intent.putExtra("flag", 2);
        intent.addFlags(268435456);
        AppInfo.d().startActivity(intent);
        return;
      } 
      AppMethods.d(R.string.live_float_toast);
      return;
    } 
    e();
  }
  
  public void a(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("float window notifyMicStatus status ---> ");
    stringBuilder.append(paramInt);
    Logger.e("sdk", new Object[] { stringBuilder.toString() });
    AppInfo.n().post(new Runnable(this, paramInt) {
          public void run() {
            if (this.a == 0) {
              AudioChannelManager.e().a(true);
            } else {
              AudioChannelManager.e().a(false);
            } 
            YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
            if (yYUserInfo != null)
              yYUserInfo.is_open_mic = this.a; 
          }
        });
  }
  
  public void a(FloatPermissionEvent paramFloatPermissionEvent) {
    int i = paramFloatPermissionEvent.status;
    if (i != 0) {
      if (i != 1)
        return; 
      b("");
      h();
      AppMethods.d(R.string.live_float_toast);
      return;
    } 
    e();
  }
  
  public void a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("float window notifyStatus roleCode ---> ");
    stringBuilder.append(paramString);
    Logger.e("sdk", new Object[] { stringBuilder.toString() });
    AppInfo.n().post(new Runnable(this, paramString) {
          public void run() {
            if (TextUtils.equals("2", this.a) || TextUtils.equals("0", this.a)) {
              AudioChannelManager.e().d();
              AudioChannelManager.e().a(21);
              if ((YYRoomInfoManager.d()).a != null)
                (YYRoomInfoManager.d()).a.push_url = ""; 
              return;
            } 
            if (TextUtils.equals("1", this.a)) {
              TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam = new TRTCCloudDef.TRTCPublishCDNParam();
              tRTCPublishCDNParam.appId = GenerateTestUserSig.b();
              tRTCPublishCDNParam.bizId = GenerateTestUserSig.d();
              tRTCPublishCDNParam.url = (YYRoomInfoManager.d()).a.push_url;
              AudioChannelManager.e().a(tRTCPublishCDNParam);
              AudioChannelManager.e().a(20);
              if (AudioFloatWindow.e(this.b) != null && AudioFloatWindow.e(this.b).c()) {
                ToastUtils.a("你已上麦，麦克风已开启，可以开始聊天了", 0);
                return;
              } 
            } 
          }
        });
  }
  
  public void b() {
    f();
  }
  
  public void b(String paramString) {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null) {
      YYRoomInfoManager.d().l();
      AudioChannelManager.e().c();
      return;
    } 
    YYUserInfo yYUserInfo = (YYRoomInfoManager.d()).a;
    if (yYUserInfo != null) {
      if (TextUtils.equals(yYUserInfo.chat_anchor, "1")) {
        c(yYRoomModel.room_id);
        return;
      } 
      a(yYRoomModel.room_id, paramString);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\trtc_audio\float_window\AudioFloatWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */