package com.blued.android.module.yy_china.manager;

import android.app.Dialog;
import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live.base.view.LiveCircleProgressView;
import com.blued.android.module.yy_china.IYYRoomInfoCallback;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.fragment.YYStudioErrorFragment;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class YYRoomInfoManager {
  public YYUserInfo a;
  
  private String b;
  
  private YYRoomModel c;
  
  private IYYRoomInfoCallback d;
  
  private LiveCircleProgressView e;
  
  private CountDownTimer f;
  
  private CountDownTimer g;
  
  private boolean h;
  
  private LiveMusicModel i;
  
  private YYRoomInfoManager() {}
  
  private void b(BaseFragmentActivity paramBaseFragmentActivity, String paramString1, String paramString2) {
    YYRoomHttpUtils.b(paramString1, new BluedUIHttpResponse<BluedEntityA<YYRoomModel>>(this, (IRequestHost)paramBaseFragmentActivity.a(), paramBaseFragmentActivity) {
          Dialog a = null;
          
          protected void a(BluedEntityA<YYRoomModel> param1BluedEntityA) {
            YYRoomModel yYRoomModel = (YYRoomModel)param1BluedEntityA.getSingleData();
            if (yYRoomModel != null) {
              if (yYRoomModel.mics != null && yYRoomModel.mics.size() > 0 && yYRoomModel.isCPChannel())
                ((YYSeatMemberModel)yYRoomModel.mics.get(0)).itemType = 1; 
              YYRoomInfoManager.d().a(yYRoomModel);
              YYRoomInfoManager.d().a((Context)this.b);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            DialogUtils.b(this.a);
            YYStudioErrorFragment.a((Context)this.b, param1String);
            return true;
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            DialogUtils.b(this.a);
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a = DialogUtils.a((Context)this.b);
            DialogUtils.a(this.a);
          }
        }(IRequestHost)paramBaseFragmentActivity.a());
  }
  
  private LiveUserRelationshipUtils.IAddOrRemoveAttentionDone c(String paramString) {
    return new LiveUserRelationshipUtils.IAddOrRemoveAttentionDone(this, paramString) {
        public void R_() {}
        
        public void a(String param1String) {
          YYObserverManager.a().a(this.a, param1String);
          LiveEventBus.get("notify_follow_user").post(this.a);
        }
        
        public void b(String param1String) {
          YYObserverManager.a().a(this.a, param1String);
        }
        
        public void d() {}
        
        public void e() {}
      };
  }
  
  public static YYRoomInfoManager d() {
    return Manager.a;
  }
  
  private BluedUIHttpResponse p() {
    return new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
        protected void a(BluedEntityA<Object> param1BluedEntityA) {
          this.a.l();
        }
      };
  }
  
  public String a(int paramInt) {
    IYYRoomInfoCallback iYYRoomInfoCallback = this.d;
    return (iYYRoomInfoCallback == null) ? "" : iYYRoomInfoCallback.a(paramInt);
  }
  
  public void a(long paramLong) {
    if (paramLong <= 0L)
      return; 
    if (this.h)
      return; 
    this.h = true;
    StringBuilder stringBuilder = new StringBuilder();
    long l = paramLong;
    if (paramLong < 1000L)
      l = paramLong * 1000L; 
    this.g = (new CountDownTimer(this, l, 1000L, stringBuilder) {
        public void onFinish() {
          YYRoomInfoManager.a(this.b, false);
          LiveEventBus.get("show_vote_time").post("");
        }
        
        public void onTick(long param1Long) {
          Integer integer;
          param1Long /= 1000L;
          int i = (int)(param1Long / 60L);
          int j = (int)(param1Long % 60L);
          StringBuilder stringBuilder1 = this.a;
          stringBuilder1.delete(0, stringBuilder1.length());
          StringBuilder stringBuilder2 = this.a;
          if (i < 10) {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("0");
            stringBuilder1.append(i);
            String str = stringBuilder1.toString();
          } else {
            integer = Integer.valueOf(i);
          } 
          stringBuilder2.append(integer);
          this.a.append(":");
          stringBuilder2 = this.a;
          if (j < 10) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("0");
            stringBuilder.append(j);
            String str = stringBuilder.toString();
          } else {
            integer = Integer.valueOf(j);
          } 
          stringBuilder2.append(integer);
          LiveEventBus.get("show_vote_time").post(this.a.toString());
        }
      }).start();
  }
  
  public void a(Context paramContext) {
    BaseYYStudioFragment.b(paramContext, false);
    this.a = new YYUserInfo();
    this.a.setUid(e());
    this.a.setName(f());
    this.a.setAvatar(g());
    YYUserInfo yYUserInfo = this.a;
    yYUserInfo.is_open_mic = 0;
    yYUserInfo.is_mic = "0";
    yYUserInfo.chat_anchor = "0";
    yYUserInfo.mute = this.c.mute;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    IYYRoomInfoCallback iYYRoomInfoCallback = this.d;
    if (iYYRoomInfoCallback == null)
      return; 
    iYYRoomInfoCallback.b(paramContext, paramString1, paramString2, c(paramString1), paramIRequestHost);
  }
  
  public void a(BaseFragmentActivity paramBaseFragmentActivity, String paramString1, String paramString2) {
    YYRoomModel yYRoomModel = d().b();
    if (yYRoomModel == null) {
      d().b(paramBaseFragmentActivity, paramString1, paramString2);
      return;
    } 
    if (TextUtils.equals(yYRoomModel.room_id, paramString1)) {
      if (AudioChannelManager.e().h()) {
        AudioChannelManager.e().f();
        d().c((Context)paramBaseFragmentActivity);
        return;
      } 
      paramBaseFragmentActivity.finish();
      return;
    } 
    if (TextUtils.equals(yYRoomModel.uid, d().e())) {
      ToastUtils.a("你正在聊天室房间内，需要退出后操作", 0);
      return;
    } 
    AudioChannelManager.e().a(paramString1);
    AudioChannelManager.e().f();
  }
  
  public void a(LiveMusicModel paramLiveMusicModel) {
    this.i = paramLiveMusicModel;
  }
  
  public void a(LiveCircleProgressView paramLiveCircleProgressView) {
    this.e = paramLiveCircleProgressView;
  }
  
  public void a(IYYRoomInfoCallback paramIYYRoomInfoCallback) {
    this.d = paramIYYRoomInfoCallback;
  }
  
  public void a(YYRoomModel paramYYRoomModel) {
    this.c = paramYYRoomModel;
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
  
  public boolean a() {
    return ((d()).d != null);
  }
  
  public YYRoomModel b() {
    return this.c;
  }
  
  public void b(Context paramContext) {
    BaseYYStudioFragment.a(paramContext, false);
    this.a = new YYUserInfo();
    this.a.setUid(e());
    this.a.setName(f());
    this.a.setAvatar(g());
    YYUserInfo yYUserInfo = this.a;
    yYUserInfo.is_open_mic = 1;
    yYUserInfo.is_mic = "1";
    yYUserInfo.chat_anchor = "1";
  }
  
  public void b(Context paramContext, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    IYYRoomInfoCallback iYYRoomInfoCallback = this.d;
    if (iYYRoomInfoCallback == null)
      return; 
    iYYRoomInfoCallback.a(paramContext, paramString1, paramString2, c(paramString1), paramIRequestHost);
  }
  
  public boolean b(String paramString) {
    YYRoomModel yYRoomModel = this.c;
    return (yYRoomModel == null) ? false : yYRoomModel.isExistById(paramString);
  }
  
  public IYYRoomInfoCallback c() {
    return this.d;
  }
  
  public void c(Context paramContext) {
    BaseYYStudioFragment.a(paramContext);
  }
  
  public String e() {
    IYYRoomInfoCallback iYYRoomInfoCallback = this.d;
    return (iYYRoomInfoCallback == null) ? "" : iYYRoomInfoCallback.c();
  }
  
  public String f() {
    IYYRoomInfoCallback iYYRoomInfoCallback = this.d;
    return (iYYRoomInfoCallback == null) ? "" : iYYRoomInfoCallback.a();
  }
  
  public String g() {
    IYYRoomInfoCallback iYYRoomInfoCallback = this.d;
    return (iYYRoomInfoCallback == null) ? "" : iYYRoomInfoCallback.b();
  }
  
  public String h() {
    return this.b;
  }
  
  public LiveCircleProgressView i() {
    return this.e;
  }
  
  public void j() {
    if (this.e == null)
      return; 
    this.f = (new CountDownTimer(this, 60000L, 1000L) {
        YYRoomModel a = this.b.b();
        
        public void onFinish() {
          Logger.e("timer", new Object[] { "onFinish ... " });
          YYRoomModel yYRoomModel = this.a;
          if (yYRoomModel != null)
            yYRoomModel.setTimerFinished(true); 
          YYRoomInfoManager.d().a("0豆");
          LiveEventBus.get("gift_free_time").post(Integer.valueOf(100));
        }
        
        public void onTick(long param1Long) {
          int i = (int)(param1Long / 1000L);
          YYRoomModel yYRoomModel = this.a;
          if (yYRoomModel != null)
            yYRoomModel.setTimerFinished(false); 
          YYRoomInfoManager yYRoomInfoManager = YYRoomInfoManager.d();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(i);
          stringBuilder.append("s");
          yYRoomInfoManager.a(stringBuilder.toString());
          LiveEventBus.get("gift_free_time").post(Integer.valueOf(i));
        }
      }).start();
    this.e.a(0.0F, 100.0F, 60000L);
  }
  
  public void k() {
    CountDownTimer countDownTimer = this.g;
    if (countDownTimer == null)
      return; 
    countDownTimer.cancel();
    this.h = false;
    LiveEventBus.get("show_vote_time").post("");
  }
  
  public void l() {
    this.c = null;
    this.a = null;
    if (this.i != null) {
      AudioChannelManager.e().d(StringUtils.a(this.i.music_id, 0));
      this.i = null;
    } 
    CountDownTimer countDownTimer = this.f;
    if (countDownTimer != null) {
      countDownTimer.cancel();
      this.f = null;
    } 
    countDownTimer = this.g;
    if (countDownTimer != null) {
      countDownTimer.cancel();
      this.g = null;
      this.h = false;
    } 
    this.e = null;
  }
  
  public boolean m() {
    YYRoomModel yYRoomModel = this.c;
    return (yYRoomModel == null) ? false : (TextUtils.equals(yYRoomModel.uid, e()));
  }
  
  public LiveMusicModel n() {
    return this.i;
  }
  
  public void o() {
    YYRoomModel yYRoomModel = b();
    if (yYRoomModel == null)
      return; 
    if (m()) {
      YYRoomHttpUtils.c(yYRoomModel.room_id, p(), null);
      return;
    } 
    YYRoomHttpUtils.d(yYRoomModel.room_id, p(), null);
  }
  
  public static class Manager {
    public static YYRoomInfoManager a = new YYRoomInfoManager();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\manager\YYRoomInfoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */