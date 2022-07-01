package com.soft.blued.ui.msg.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.soft.blued.base.mvp.MVPBasePresent;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.ui.msg.adapter.ChatBgSelectAdapter;
import com.soft.blued.ui.msg.contract.IChatBgSelectIView;
import com.soft.blued.ui.msg.contract.IChatBgSelectOptionCallback;
import com.soft.blued.ui.msg.manager.ChatBgManager;
import com.soft.blued.ui.msg.model.MsgChattingBgModel;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.List;

public class ChatBgSelectPresent extends MVPBasePresent<IChatBgSelectIView> implements IChatBgSelectOptionCallback {
  private List<MsgChattingBgModel> b;
  
  private ChatBgSelectAdapter c;
  
  private SessionSettingModel d = null;
  
  private long e = -1L;
  
  private short f;
  
  private int g;
  
  private String h;
  
  private boolean i;
  
  private void h() {
    if (this.g != 2) {
      SessionSettingModel sessionSettingModel = this.d;
      if (sessionSettingModel != null && !TextUtils.isEmpty(sessionSettingModel.getChatBgUri())) {
        this.h = this.d.getChatBgUri();
      } else {
        this.h = BluedPreferences.w(UserInfo.a().i().getUid());
      } 
    } else {
      this.h = BluedPreferences.w(UserInfo.a().i().getUid());
    } 
    if (!TextUtils.isEmpty(this.h) && !ChatBgManager.b(this.h))
      this.i = true; 
  }
  
  public Context a() {
    IChatBgSelectIView iChatBgSelectIView = (IChatBgSelectIView)aV_();
    return (iChatBgSelectIView != null) ? iChatBgSelectIView.getContext() : null;
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Bundle paramBundle) {
    IChatBgSelectIView iChatBgSelectIView = (IChatBgSelectIView)aV_();
    if (iChatBgSelectIView != null) {
      SessionModel sessionModel;
      Bundle bundle = iChatBgSelectIView.getArguments();
      if (bundle != null) {
        this.g = bundle.getInt("from");
        this.e = bundle.getLong("passby_session_id", -1L);
        this.f = bundle.getShort("passby_session_type");
        this.c = new ChatBgSelectAdapter(aU_(), this);
        iChatBgSelectIView.a((RecyclerView.Adapter)this.c);
        this.b = new ArrayList<MsgChattingBgModel>();
        sessionModel = ChatManager.getInstance().getSnapSessionModel(g(), f());
        if (sessionModel != null)
          this.d = (SessionSettingModel)sessionModel.sessionSettingModel; 
        if (this.d == null)
          ChatManager.getInstance().getSessionSettingModel(this.f, Long.valueOf(this.e).longValue(), new FetchDataListener<SessionSettingBaseModel>(this) {
                public void a(SessionSettingBaseModel param1SessionSettingBaseModel) {
                  ChatBgSelectPresent.a(this.a, (SessionSettingModel)param1SessionSettingBaseModel);
                }
              }); 
        h();
        e();
        return;
      } 
      sessionModel.q().finish();
    } 
  }
  
  public boolean a(String paramString) {
    return paramString.equals(this.h);
  }
  
  public IRequestHost aU_() {
    IChatBgSelectIView iChatBgSelectIView = (IChatBgSelectIView)aV_();
    return (iChatBgSelectIView != null) ? iChatBgSelectIView.p() : null;
  }
  
  public void b(Bundle paramBundle) {}
  
  public void b(String paramString) {
    IChatBgSelectIView iChatBgSelectIView = (IChatBgSelectIView)aV_();
    if (iChatBgSelectIView != null) {
      Intent intent = new Intent();
      intent.putExtra("photo_path", paramString);
      iChatBgSelectIView.q().setResult(-1, intent);
      iChatBgSelectIView.q().finish();
    } 
  }
  
  public void c() {}
  
  public boolean d() {
    return this.i;
  }
  
  public void e() {
    IChatBgSelectIView iChatBgSelectIView = (IChatBgSelectIView)aV_();
    if (iChatBgSelectIView != null)
      ChatHttpUtils.a(new BluedUIHttpResponse<BluedEntity<MsgChattingBgModel, BluedEntityBaseExtra>>(this, aU_()) {
            boolean a = false;
            
            public boolean onUIFailure(int param1Int, String param1String) {
              this.a = true;
              return super.onUIFailure(param1Int, param1String);
            }
            
            public void onUIFinish() {
              IChatBgSelectIView iChatBgSelectIView = (IChatBgSelectIView)this.b.aV_();
              if (iChatBgSelectIView != null) {
                iChatBgSelectIView.a(false);
                iChatBgSelectIView.s();
                if (ChatBgSelectPresent.a(this.b) != null && ChatBgSelectPresent.a(this.b).size() > 0) {
                  if (ChatBgSelectPresent.b(this.b) != null) {
                    ChatBgSelectPresent.b(this.b).a(ChatBgSelectPresent.a(this.b));
                    return;
                  } 
                } else {
                  if (this.a) {
                    iChatBgSelectIView.m();
                    return;
                  } 
                  iChatBgSelectIView.l();
                } 
              } 
            }
            
            public void onUIStart() {
              IChatBgSelectIView iChatBgSelectIView = (IChatBgSelectIView)this.b.aV_();
              if (iChatBgSelectIView != null)
                iChatBgSelectIView.a(true); 
            }
            
            public void onUIUpdate(BluedEntity<MsgChattingBgModel, BluedEntityBaseExtra> param1BluedEntity) {
              IChatBgSelectIView iChatBgSelectIView = (IChatBgSelectIView)this.b.aV_();
              if (iChatBgSelectIView != null) {
                ChatBgSelectPresent.a(this.b).clear();
                MsgChattingBgModel msgChattingBgModel = new MsgChattingBgModel();
                msgChattingBgModel.type = 1;
                ChatBgSelectPresent.a(this.b).add(0, msgChattingBgModel);
                ChatBgSelectPresent.a(this.b).addAll(1, param1BluedEntity.data);
                if (ChatBgSelectPresent.a(this.b) != null && ChatBgSelectPresent.a(this.b).size() > 0) {
                  iChatBgSelectIView.k();
                  return;
                } 
                iChatBgSelectIView.l();
              } 
            }
          }iChatBgSelectIView.p()); 
  }
  
  public long f() {
    return this.e;
  }
  
  public short g() {
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\presenter\ChatBgSelectPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */