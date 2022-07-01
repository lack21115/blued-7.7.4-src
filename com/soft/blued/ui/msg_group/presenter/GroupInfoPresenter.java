package com.soft.blued.ui.msg_group.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.blued.das.message.MessageProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackGroup;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg_group.model.GroupInfoModel;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.HashMap;
import java.util.Map;

public class GroupInfoPresenter extends MvpPresenter implements FetchDataListener<SessionModel> {
  private String h = "";
  
  private boolean i;
  
  private GroupInfoModel j;
  
  private SessionModel k;
  
  private SocialNetWorkProtos.SourceType l = SocialNetWorkProtos.SourceType.UNKNOWN_SOURCE_TYPE;
  
  private void s() {
    SessionModel sessionModel = this.k;
    if (sessionModel != null)
      a("switch_top", Integer.valueOf(sessionModel.lieTop)); 
  }
  
  private void t() {
    MsgGroupHttpUtils.b(g(), this.h, new BluedUIHttpResponse<BluedEntityA>(this, g()) {
          protected void a(BluedEntityA param1BluedEntityA) {}
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (param1Boolean) {
              if (GroupInfoPresenter.b(this.a) != null) {
                BluedPreferences.t((GroupInfoPresenter.b(this.a)).group_id);
                LiveEventBus.get("exit_group", Integer.class).post(Integer.valueOf((GroupInfoPresenter.b(this.a)).group_id));
                ChatManager.getInstance().deleteSessionAndChatting(Short.valueOf((short)3), (GroupInfoPresenter.b(this.a)).group_id);
                (GroupInfoPresenter.b(this.a)).group_role = 0;
                GroupInfoModel groupInfoModel = GroupInfoPresenter.b(this.a);
                groupInfoModel.group_now_population--;
              } 
              this.a.q();
              this.a.i();
            } 
          }
        });
  }
  
  private void u() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("group_status", "3");
    IRequestHost iRequestHost = g();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.j.group_id);
    stringBuilder.append("");
    MsgGroupHttpUtils.a(iRequestHost, stringBuilder.toString(), hashMap, new BluedUIHttpResponse<BluedEntityA>(this, g()) {
          protected void a(BluedEntityA param1BluedEntityA) {}
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            this.a.b("group_info", param1Boolean);
            if (param1Boolean)
              try {
                if (GroupInfoPresenter.b(this.a) != null) {
                  BluedPreferences.t((GroupInfoPresenter.b(this.a)).group_id);
                  LiveEventBus.get("exit_group", Integer.class).post(Integer.valueOf((GroupInfoPresenter.b(this.a)).group_id));
                  ChatManager.getInstance().deleteSessionAndChatting(Short.valueOf((short)3), (GroupInfoPresenter.b(this.a)).group_id);
                  (GroupInfoPresenter.b(this.a)).group_status = 3;
                } 
                LiveEventBus.get("group_dismiss", GroupInfoModel.class).post(GroupInfoPresenter.b(this.a));
                this.a.i();
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
              }  
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.e_("group_info");
          }
        });
  }
  
  private void v() {
    if (this.j != null) {
      SessionSettingModel sessionSettingModel = null;
      SessionModel sessionModel = this.k;
      if (sessionModel != null)
        sessionSettingModel = (SessionSettingModel)sessionModel.sessionSettingModel; 
      int i = GroupUtil.a(this.j.message_is_mute, this.j.at_message_is_mute, this.j.notice_is_mute);
      if (sessionSettingModel != null) {
        sessionSettingModel.setRemindAudio(i);
        ChatManager.getInstance().setSessionSetting(sessionSettingModel.getSessionType(), sessionSettingModel.getSessionId(), (SessionSettingBaseModel)sessionSettingModel);
        return;
      } 
      sessionSettingModel = new SessionSettingModel();
      sessionSettingModel.setLoadName(Long.valueOf(UserInfo.a().i().getUid()).longValue());
      sessionSettingModel.setSessionId(Long.valueOf(this.j.group_id).longValue());
      sessionSettingModel.setSessionType((short)3);
      sessionSettingModel.setRemindAudio(i);
      ChatManager.getInstance().setSessionSetting(sessionSettingModel.getSessionType(), sessionSettingModel.getSessionId(), (SessionSettingBaseModel)sessionSettingModel);
    } 
  }
  
  public void a(ImageView paramImageView) {
    SessionModel sessionModel = this.k;
    if (sessionModel != null)
      GroupUtil.a(sessionModel, paramImageView, g()); 
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    if (paramBundle1 != null) {
      this.h = paramBundle1.getString("group_id");
      if (paramBundle1.containsKey("page_from"))
        this.l = (SocialNetWorkProtos.SourceType)paramBundle1.getSerializable("page_from"); 
      EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_PROFILE_SHOW, this.h, this.l);
      this.j = (GroupInfoModel)paramBundle1.getSerializable("group_info");
      GroupInfoModel groupInfoModel = this.j;
      if (groupInfoModel != null) {
        if (groupInfoModel.group_id != 0) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.j.group_id);
          stringBuilder.append("");
          this.h = stringBuilder.toString();
        } 
        a("group_info", this.j);
      } 
      this.k = ChatManager.getInstance().getSnapSessionModel((short)3, Long.valueOf(this.h).longValue());
      if (this.k == null) {
        ChatManager.getInstance().getSessionModel((short)3, Long.valueOf(this.h).longValue(), this);
        return;
      } 
      s();
    } 
  }
  
  public void a(SessionModel paramSessionModel) {
    this.k = paramSessionModel;
    s();
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    MsgGroupHttpUtils.a(g(), this.h, new BluedUIHttpResponse<BluedEntityA<GroupInfoModel>>(this, g()) {
          protected void a(BluedEntityA<GroupInfoModel> param1BluedEntityA) {
            if (param1BluedEntityA.hasData()) {
              GroupInfoPresenter.a(this.a, param1BluedEntityA.data.get(0));
              GroupInfoPresenter.a(this.a);
              GroupInfoPresenter groupInfoPresenter = this.a;
              groupInfoPresenter.a("group_info", GroupInfoPresenter.b(groupInfoPresenter));
              if (GroupInfoPresenter.c(this.a))
                this.a.q(); 
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (param1Int == 40319010)
              this.a.i(); 
            return super.onUIFailure(param1Int, param1String);
          }
        });
  }
  
  public void a(String paramString, int paramInt) {
    if (this.j == null)
      return; 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    hashMap.put(paramString, stringBuilder.toString());
    if ("message_is_mute".equals(paramString) && paramInt == 2)
      hashMap.put("at_message_is_mute", "2"); 
    IRequestHost iRequestHost = g();
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.j.group_id);
    stringBuilder.append("");
    MsgGroupHttpUtils.a(iRequestHost, stringBuilder.toString(), hashMap, new BluedUIHttpResponse<BluedEntityA>(this, g(), hashMap) {
          protected void a(BluedEntityA param1BluedEntityA) {}
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            this.b.b("group_info", param1Boolean);
            if (param1Boolean)
              try {
                if (GroupInfoPresenter.b(this.b) == null)
                  return; 
                for (Map.Entry entry : this.a.entrySet())
                  GroupUtil.a(GroupInfoPresenter.b(this.b), (String)entry.getKey(), Integer.valueOf((String)entry.getValue())); 
                GroupInfoPresenter.a(this.b);
                this.b.a("switch", GroupInfoPresenter.b(this.b));
                this.b.q();
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
              }  
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.b.e_("group_info");
          }
        });
  }
  
  public void a(boolean paramBoolean) {
    this.i = paramBoolean;
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public void d(String paramString) {
    if (this.j == null)
      return; 
    MsgGroupHttpUtils.b(g(), this.h, paramString, this.j.allow_join, new BluedUIHttpResponse<BluedEntityA>(this, g()) {
          protected void a(BluedEntityA param1BluedEntityA) {}
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (param1Int == 40319016)
              this.a.e(); 
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            this.a.b("addGroup", param1Boolean);
            if (param1Boolean && GroupInfoPresenter.b(this.a) != null) {
              if ((GroupInfoPresenter.b(this.a)).allow_join == 2) {
                (GroupInfoPresenter.b(this.a)).apply_status = 1;
                this.a.b("apply_succeed");
              } else {
                GroupInfoModel groupInfoModel = GroupInfoPresenter.b(this.a);
                groupInfoModel.group_now_population++;
                (GroupInfoPresenter.b(this.a)).group_role = 3;
                AppInfo.n().postDelayed(new Runnable(this) {
                      public void run() {
                        this.a.a.r();
                      }
                    },  200L);
              } 
              this.a.q();
            } 
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.e_("addGroup");
          }
        });
  }
  
  public GroupInfoModel m() {
    return this.j;
  }
  
  public SessionModel n() {
    return this.k;
  }
  
  public SocialNetWorkProtos.SourceType o() {
    return this.l;
  }
  
  public void p() {
    int i;
    Activity activity;
    GroupInfoModel groupInfoModel = this.j;
    if (groupInfoModel == null)
      return; 
    if (groupInfoModel.group_role == 1) {
      activity = h();
      i = 2131755673;
    } else {
      activity = h();
      i = 2131756771;
    } 
    String str2 = activity.getString(i);
    if (this.j.group_role == 1) {
      activity = h();
      i = 2131756658;
    } else {
      activity = h();
      i = 2131756666;
    } 
    String str3 = activity.getString(i);
    if (this.j.group_role == 1) {
      activity = h();
      i = 2131756100;
    } else {
      activity = h();
      i = 2131756086;
    } 
    String str1 = activity.getString(i);
    CommonAlertDialog.a((Context)h(), str2, str3, str1, new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if ((GroupInfoPresenter.b(this.a)).group_role == 1) {
              GroupInfoPresenter.d(this.a);
              return;
            } 
            if ((GroupInfoPresenter.b(this.a)).group_role == 2 || (GroupInfoPresenter.b(this.a)).group_role == 3)
              GroupInfoPresenter.e(this.a); 
          }
        },  h().getResources().getString(2131756057), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
        },  null);
  }
  
  public void q() {
    LiveEventBus.get("refresh_circle_group", GroupInfoModel.class).post(this.j);
  }
  
  public void r() {
    if (this.j == null)
      return; 
    LogData logData = new LogData();
    logData.g = "group_info";
    ChatHelperV4.a().a((Context)h(), Long.valueOf(this.j.group_id).longValue(), this.j.group_title, this.j.group_cover, 0, 0, 0, 0, "", false, 1, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\presenter\GroupInfoPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */