package com.soft.blued.ui.msg.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.das.vip.VipProtos;
import com.soft.blued.base.mvp.MVPBasePresent;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.msg.ChatBgSelectFragment;
import com.soft.blued.ui.msg.contract.IChatBgSettingIView;
import com.soft.blued.ui.msg.manager.ChatBgManager;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import java.util.HashMap;

public class ChatBgSettingPresent extends MVPBasePresent<IChatBgSettingIView> {
  private long b = -1L;
  
  private short c;
  
  private int d;
  
  private SessionSettingModel e;
  
  private String f;
  
  private void a(SessionSettingModel paramSessionSettingModel, String paramString) {
    SessionSettingModel sessionSettingModel = paramSessionSettingModel;
    if (paramSessionSettingModel == null) {
      sessionSettingModel = new SessionSettingModel();
      sessionSettingModel.setSessionId(this.b);
      sessionSettingModel.setSessionType(this.c);
      sessionSettingModel.setLoadName(Long.valueOf(UserInfo.a().i().getUid()).longValue());
    } 
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString;
      if (!ChatBgManager.b(paramString)) {
        str = paramString;
        if (!paramString.toLowerCase().contains("file://"))
          str = RecyclingUtils.Scheme.c.b(paramString); 
      } 
    } 
    sessionSettingModel.setChatBgUri(str);
    ChatManager.getInstance().setSessionSetting(this.c, Long.valueOf(this.b).longValue(), (SessionSettingBaseModel)sessionSettingModel);
    InstantLog.a("chat_bg_done");
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1) {
      switch (paramInt1) {
        default:
          return;
        case 1002:
          EventTrackVIP.a(VipProtos.Event.VIP_BACKFROUND_PHOTOGRAPH_BTN_CLICK);
          break;
        case 1000:
        case 1001:
          break;
      } 
      if (paramIntent != null) {
        this.f = paramIntent.getStringExtra("photo_path");
        if (this.d != 2) {
          SessionModel sessionModel = ChatManager.getInstance().getSnapSessionModel(this.c, Long.valueOf(this.b).longValue());
          if (sessionModel != null)
            this.e = (SessionSettingModel)sessionModel.sessionSettingModel; 
          SessionSettingModel sessionSettingModel = this.e;
          if (sessionSettingModel == null) {
            ChatManager.getInstance().getSessionSettingModel(this.c, Long.valueOf(this.b).longValue(), new FetchDataListener<SessionSettingBaseModel>(this) {
                  public void a(SessionSettingBaseModel param1SessionSettingBaseModel) {
                    if (param1SessionSettingBaseModel != null)
                      ChatBgSettingPresent.a(this.a, (SessionSettingModel)param1SessionSettingBaseModel); 
                    ChatBgSettingPresent chatBgSettingPresent = this.a;
                    ChatBgSettingPresent.a(chatBgSettingPresent, ChatBgSettingPresent.a(chatBgSettingPresent), ChatBgSettingPresent.b(this.a));
                  }
                });
          } else {
            a(sessionSettingModel, this.f);
          } 
          IChatBgSettingIView iChatBgSettingIView = (IChatBgSettingIView)aV_();
          if (iChatBgSettingIView != null) {
            Activity activity = iChatBgSettingIView.q();
            iChatBgSettingIView.q();
            activity.setResult(-1, new Intent());
            iChatBgSettingIView.q().finish();
            return;
          } 
        } else {
          if (paramInt1 == 1000)
            EventTrackVIP.a(VipProtos.Event.VIP_BACKFROUND_CHOOSE_PHOTO_BTN_CLICK); 
          if (ChatBgManager.b(this.f)) {
            BluedPreferences.a(UserInfo.a().i().getUid(), "");
          } else {
            if (!this.f.toLowerCase().contains("file://"))
              this.f = RecyclingUtils.Scheme.c.b(this.f); 
            BluedPreferences.a(UserInfo.a().i().getUid(), this.f);
          } 
          InstantLog.a("chat_bg_done");
          IChatBgSettingIView iChatBgSettingIView = (IChatBgSettingIView)aV_();
          if (iChatBgSettingIView != null)
            iChatBgSettingIView.t(); 
        } 
      } 
    } 
  }
  
  public void a(Bundle paramBundle) {
    IChatBgSettingIView iChatBgSettingIView = (IChatBgSettingIView)aV_();
    if (iChatBgSettingIView != null) {
      Bundle bundle = iChatBgSettingIView.getArguments();
      if (bundle != null) {
        this.b = bundle.getLong("passby_session_id", -1L);
        this.c = bundle.getShort("passby_session_type");
        this.d = bundle.getInt("from");
        return;
      } 
      iChatBgSettingIView.q().finish();
    } 
  }
  
  public void b(Bundle paramBundle) {}
  
  public void c() {}
  
  public void d() {
    IChatBgSettingIView iChatBgSettingIView = (IChatBgSettingIView)aV_();
    if (iChatBgSettingIView != null)
      ChatBgSelectFragment.a(iChatBgSettingIView.s(), this.d, this.b, this.c, 1001); 
  }
  
  public void e() {
    IChatBgSettingIView iChatBgSettingIView = (IChatBgSettingIView)aV_();
    if (iChatBgSettingIView != null)
      PhotoSelectFragment.a(iChatBgSettingIView.s(), 12, 1000); 
  }
  
  public void f() {
    IChatBgSettingIView iChatBgSettingIView = (IChatBgSettingIView)aV_();
    if (iChatBgSettingIView != null)
      PhotoSelectFragment.a(iChatBgSettingIView.s(), 12, 1002, true); 
  }
  
  public void g() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("chatBgUri", "");
    ChatManager.getInstance().updateAllSessionSetting(hashMap);
    InstantLog.a("chat_bg_done");
    AppMethods.d(2131758706);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\presenter\ChatBgSettingPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */