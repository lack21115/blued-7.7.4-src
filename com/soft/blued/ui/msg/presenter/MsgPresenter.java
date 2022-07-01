package com.soft.blued.ui.msg.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.StableSessionListListener;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.listener.SessionListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.chat.contract.FilterSessionListListener;
import com.blued.android.module.chat.contract.IChatRelationDataListener;
import com.blued.android.module.chat.manager.ChatRelationDataManager;
import com.blued.android.module.chat.manager.MsgFilterManager;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.das.message.MessageProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.BluedConstant;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.model.HelloDataExtra;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.group.GroupNotifyFragment;
import com.soft.blued.ui.msg.MsgBoxFragment;
import com.soft.blued.ui.msg.MsgPreferences;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.manager.ChatBgManager;
import com.soft.blued.ui.msg.manager.MsgBoxManager;
import com.soft.blued.ui.msg.manager.MsgDataManager;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg.model.RefreshSessionEvent;
import com.soft.blued.ui.msg.observer.RecvMsgListenerObserver;
import com.soft.blued.ui.msg.pop.BottomMenuPop;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MsgPresenter extends MvpPresenter implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, FilterSessionListListener, IChatRelationDataListener, RecvMsgListenerObserver.IRecvMsgListener {
  public MsgDataManager h;
  
  private boolean i = false;
  
  private boolean j = false;
  
  private boolean k = false;
  
  private boolean l = false;
  
  private boolean m = true;
  
  private boolean n = false;
  
  private boolean o = true;
  
  private boolean p = true;
  
  private String q = "";
  
  private MsgSessionListener r;
  
  private String[] s;
  
  private BottomMenuPop t;
  
  private void C() {
    if (t()) {
      this.i = false;
      MsgFilterManager.getInstance().filterData();
      return;
    } 
    if (TextUtils.isEmpty(this.q)) {
      a("dataUpdateFinish", Integer.valueOf(s().size()));
      return;
    } 
    d(this.q);
  }
  
  private void D() {
    d(false);
  }
  
  private void c(String paramString, boolean paramBoolean) {
    List<SessionModel> list = r();
    this.h.c();
    if (list != null && list.size() > 0)
      for (SessionModel sessionModel : list) {
        SessionSettingModel sessionSettingModel = (SessionSettingModel)sessionModel.sessionSettingModel;
        if ((!TextUtils.isEmpty(sessionModel.nickName) && sessionModel.nickName.contains(paramString)) || (!TextUtils.isEmpty(sessionModel.lastMsgFromNickname) && sessionModel.lastMsgFromNickname.contains(paramString)) || (!TextUtils.isEmpty(sessionModel.lastMsgContent) && sessionModel.lastMsgContent.contains(paramString)) || (sessionSettingModel != null && !TextUtils.isEmpty(sessionSettingModel.getSessinoNote()) && sessionSettingModel.getSessinoNote().contains(paramString)))
          this.h.a(sessionModel); 
      }  
    a("dataUpdateFinish", Integer.valueOf(s().size()));
    if (paramBoolean)
      a("filterOpenHasNewMessage", this.m); 
  }
  
  private void d(boolean paramBoolean) {
    if (!TextUtils.isEmpty(this.q)) {
      c(this.q, paramBoolean);
      return;
    } 
    a("dataUpdateFinish", Integer.valueOf(s().size()));
    if (t() && paramBoolean)
      a("filterOpenHasNewMessage", this.m); 
  }
  
  public void A() {
    ChatRelationDataManager.getInstance().updateRelationData(new ChatRelationDataManager.UpdateRelationCallback(this) {
          public void finish(int param1Int, String param1String) {}
        });
  }
  
  public void B() {
    MsgFilterManager.getInstance().setFilterSwitch(false, false, false);
    this.n = false;
    this.k = false;
    this.l = false;
    this.j = false;
    if (TextUtils.isEmpty(this.q)) {
      a("dataUpdateFinish", Integer.valueOf(s().size()));
      return;
    } 
    d(this.q);
  }
  
  public SessionModel a(int paramInt) {
    return (paramInt >= 0 && paramInt < s().size()) ? s().get(paramInt) : null;
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    this.r = new MsgSessionListener(this);
    this.h = new MsgDataManager();
    ChatBgManager.a(UserInfo.a().i().getUid());
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add(h().getString(2131758011));
    arrayList.add(h().getString(2131758009));
    this.s = arrayList.<String>toArray(new String[arrayList.size()]);
  }
  
  public void a(SessionModel paramSessionModel) {
    if ((UserInfo.a().i()).vip_grade != 2 && (BluedConfig.b().j()).is_view_secretly == 0) {
      InstantLog.a("msg_view_secretly_click", 0);
      PayUtils.a((Context)h(), 6, "chat_msg_quiet_singe");
      return;
    } 
    InstantLog.a("msg_view_secretly_click", 1);
    a(paramSessionModel, true);
  }
  
  public void a(SessionModel paramSessionModel, ChattingModel paramChattingModel) {
    if (t() && ChatHelperV4.a(paramSessionModel) && !this.h.e().contains(paramSessionModel))
      a("filterOpenHasNewMessage", this.m); 
  }
  
  public void a(SessionModel paramSessionModel, boolean paramBoolean) {
    if (paramSessionModel == null)
      return; 
    short s = paramSessionModel.sessionType;
    LogData logData = new LogData();
    logData.g = "none";
    if (s != 1) {
      if (s != 2) {
        if (s != 3) {
          if (s != 6668)
            return; 
          TerminalActivity.d((Context)h(), MsgBoxFragment.class, null);
          return;
        } 
        logData.g = "msg_list";
        ChatHelperV4.a().a((Context)h(), paramSessionModel.sessionId, paramSessionModel.nickName, paramSessionModel.avatar, paramSessionModel.vBadge, paramSessionModel.vipGrade, paramSessionModel.vipAnnual, paramSessionModel.vipExpLvl, "", false, 1, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
        return;
      } 
      ChatHelperV4 chatHelperV4 = ChatHelperV4.a();
      Activity activity = h();
      long l = paramSessionModel.sessionId;
      String str1 = paramSessionModel.nickName;
      String str2 = paramSessionModel.avatar;
      int i = paramSessionModel.vBadge;
      int j = paramSessionModel.vipGrade;
      int k = paramSessionModel.vipAnnual;
      int m = paramSessionModel.vipExpLvl;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramSessionModel.lastMsgFromDistance);
      stringBuilder.append("");
      chatHelperV4.a((Context)activity, l, str1, str2, i, j, k, m, stringBuilder.toString(), paramBoolean, 0, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
      return;
    } 
    if (paramSessionModel.sessionId == 2L) {
      Bundle bundle = new Bundle();
      bundle.putLong("passby_session_id", paramSessionModel.sessionId);
      bundle.putShort("passby_session_type", (short)1);
      TerminalActivity.d((Context)h(), GroupNotifyFragment.class, bundle);
      return;
    } 
    if (paramSessionModel.sessionId == 5L)
      ChatHelperV4.a().a((Context)h(), paramSessionModel.sessionId, paramSessionModel.maxHasReadMsgID); 
  }
  
  public void a(SessionModel paramSessionModel, String[] paramArrayOfString) {
    ArrayList<BottomMenuPop.MenuItemInfo> arrayList = new ArrayList();
    int j = paramArrayOfString.length;
    for (int i = 0; i < j; i++) {
      String str = paramArrayOfString[i];
      BottomMenuPop.MenuItemInfo menuItemInfo = new BottomMenuPop.MenuItemInfo();
      menuItemInfo.a = str;
      if (TextUtils.equals(str, h().getResources().getString(2131757942))) {
        menuItemInfo.b = 2131100576;
      } else if (TextUtils.equals(str, h().getResources().getString(2131757941))) {
        menuItemInfo.b = 2131100716;
      } 
      menuItemInfo.c = new View.OnClickListener(this, str, paramSessionModel) {
          public void onClick(View param1View) {
            if (MsgPresenter.a(this.c) != null)
              MsgPresenter.a(this.c).p(); 
            if (TextUtils.equals(this.a, this.c.h().getResources().getString(2131758011))) {
              this.c.a(this.b);
              MessageProtos.Event event = MessageProtos.Event.MSG_LIST_OPERATE_VIEW_PRIVATE_CLICK;
              MessageProtos.StrangerSource strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(this.b.sessionId);
              stringBuilder.append("");
              EventTrackMessage.a(event, strangerSource, stringBuilder.toString());
              return;
            } 
            if (TextUtils.equals(this.a, this.c.h().getResources().getString(2131758009)) || TextUtils.equals(this.a, this.c.h().getResources().getString(2131757941))) {
              this.c.b(this.b);
              return;
            } 
            if (TextUtils.equals(this.a, this.c.h().getResources().getString(2131757942))) {
              this.c.u();
              return;
            } 
          }
        };
      arrayList.add(menuItemInfo);
    } 
    this.t = new BottomMenuPop((Context)h());
    this.t.b = arrayList;
    (new XPopup.Builder((Context)h())).a((BasePopupView)this.t).h();
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void a(boolean paramBoolean) {
    MsgFilterManager.getInstance().setInitiatorSwitch(paramBoolean);
    this.n = paramBoolean;
    q();
    C();
  }
  
  public void b(SessionModel paramSessionModel) {
    if (paramSessionModel == null)
      return; 
    if (paramSessionModel.sessionType == 6668) {
      CommonAlertDialog.a((Context)h(), "", h().getResources().getString(2131758027), null, new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              ChatManager.getInstance().getSessionModelList(new FetchDataListener<List<SessionModel>>(this) {
                    public void a(List<SessionModel> param2List) {
                      for (SessionModel sessionModel : MsgBoxManager.a().a(param2List, true)) {
                        if (sessionModel.sessionType == 6668 && sessionModel.lastMsgFromId != 0L) {
                          sessionModel.lastMsgFromId = 0L;
                          continue;
                        } 
                        this.a.a.b(sessionModel);
                      } 
                    }
                  });
            }
          }null, null, null);
      return;
    } 
    ChatManager.getInstance().deleteSession(paramSessionModel.sessionType, paramSessionModel.sessionId);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public void b(boolean paramBoolean) {
    MsgFilterManager.getInstance().setFollowerSwitch(paramBoolean);
    this.k = paramBoolean;
    q();
    C();
  }
  
  public void c(boolean paramBoolean) {
    MsgFilterManager.getInstance().setNearBySwitch(paramBoolean);
    this.l = paramBoolean;
    q();
    C();
  }
  
  public void d(String paramString) {
    c(paramString, false);
  }
  
  public void m() {
    this.m = false;
    MsgPreferences.a();
  }
  
  public boolean n() {
    return this.n;
  }
  
  public boolean o() {
    return this.k;
  }
  
  public void onDeleteSessions(List<Pair<Short, Long>> paramList) {
    a("showDeletedMsgHint", false);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    SessionModel sessionModel = a(paramInt - 2);
    if (sessionModel != null) {
      if (BluedPreferences.ar()) {
        a(sessionModel);
        return;
      } 
      a(sessionModel, false);
    } 
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {
    SessionModel sessionModel = a(paramInt - 2);
    if (sessionModel == null)
      return true; 
    MessageProtos.Event event = MessageProtos.Event.MSG_LIST_OPERATE_SHOW;
    MessageProtos.StrangerSource strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(sessionModel.sessionId);
    stringBuilder.append("");
    EventTrackMessage.a(event, strangerSource, stringBuilder.toString());
    if (sessionModel.sessionType == 2) {
      ArrayList<String> arrayList = new ArrayList();
      arrayList.add(h().getString(2131758011));
      arrayList.add(h().getString(2131758009));
      this.s = arrayList.<String>toArray(new String[arrayList.size()]);
    } else if (sessionModel.sessionType == 3) {
      ArrayList<String> arrayList = new ArrayList();
      arrayList.add(h().getString(2131758009));
      this.s = arrayList.<String>toArray(new String[arrayList.size()]);
    } else {
      ArrayList<String> arrayList = new ArrayList();
      if (sessionModel.lastMsgFromId != 0L)
        arrayList.add(h().getString(2131757941)); 
      arrayList.add(h().getString(2131757942));
      this.s = arrayList.<String>toArray(new String[arrayList.size()]);
    } 
    a(sessionModel, this.s);
    return true;
  }
  
  public void onUISessionDataChanged(List<SessionModel> paramList1, List<SessionModel> paramList2) {
    if (t()) {
      ChatHelperV4.c(paramList1);
      this.h.a(paramList1);
      boolean bool = true;
      this.i = true;
      if (this.p) {
        this.p = false;
        ChatHelperV4.a(paramList2, false);
        if (this.h.d(paramList2) <= 0)
          bool = false; 
        d(bool);
        return;
      } 
      D();
    } 
  }
  
  public boolean p() {
    return this.l;
  }
  
  public void q() {
    if (this.n || this.k || this.l) {
      this.j = true;
      return;
    } 
    this.j = false;
  }
  
  public List<SessionModel> r() {
    return t() ? this.h.e() : this.h.a();
  }
  
  public List<SessionModel> s() {
    return TextUtils.isEmpty(this.q) ? this.h.a() : this.h.b();
  }
  
  public boolean t() {
    return false;
  }
  
  public void u() {
    ToastUtils.a(h().getString(2131758028));
    BluedPreferences.P(false);
    w();
  }
  
  public void v() {
    ArrayList<Pair> arrayList = new ArrayList();
    for (SessionModel sessionModel : this.h.a())
      arrayList.add(new Pair(Short.valueOf(sessionModel.sessionType), Long.valueOf(sessionModel.sessionId))); 
    ChatManager.getInstance().ignoredNoReadNum(arrayList);
  }
  
  public void w() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("refreshSessionList====");
    stringBuilder.append(this.h.d().size());
    Logger.e("MsgPresent test", new Object[] { stringBuilder.toString() });
    ArrayList<SessionModel> arrayList = new ArrayList();
    arrayList.addAll(this.h.d());
    RefreshSessionEvent refreshSessionEvent = new RefreshSessionEvent();
    refreshSessionEvent.list = new ArrayList();
    refreshSessionEvent.list.addAll(this.h.d());
    LiveEventBus.get("refresh_unread_msg_cnt").post(refreshSessionEvent);
    this.r.onUISessionDataChanged(arrayList);
  }
  
  public void x() {
    UserHttpUtils.a((Context)h(), new BluedUIHttpResponse<BluedEntity<UserFindResult, HelloDataExtra>>(this, g()) {
          private boolean b = false;
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.b = true;
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            if (this.b) {
              this.a.b("hideHelloView");
              this.a.a("helloViewShowBtn", new Boolean(false));
            } 
            this.a.b("refreshComplete");
          }
          
          public void onUIStart() {
            super.onUIStart();
          }
          
          public void onUIUpdate(BluedEntity<UserFindResult, HelloDataExtra> param1BluedEntity) {
            MsgPresenter msgPresenter;
            if (param1BluedEntity == null)
              return; 
            HelloDataExtra helloDataExtra = (HelloDataExtra)param1BluedEntity.extra;
            boolean bool = false;
            if (helloDataExtra != null) {
              if (helloDataExtra.view_type != 2) {
                if (param1BluedEntity.hasData()) {
                  this.a.a("setNewHelloText", helloDataExtra);
                  this.a.a("addHelloListData", param1BluedEntity);
                } else {
                  this.a.b("hideHelloView");
                } 
              } else {
                this.a.a("setNewHelloView", helloDataExtra);
              } 
              msgPresenter = this.a;
              if (helloDataExtra.show_call_btn == 1)
                bool = true; 
              msgPresenter.a("helloViewShowBtn", new Boolean(bool));
              if (helloDataExtra.show_call_btn == 1) {
                CallHelloManager.a().a((Context)this.a.h(), this.a.g(), 2, null);
                return;
              } 
            } else {
              if (msgPresenter.hasData()) {
                this.a.a("addHelloListData", msgPresenter);
              } else {
                this.a.b("hideHelloView");
              } 
              this.a.a("helloViewShowBtn", new Boolean(false));
            } 
          }
        }"1", "15", "", "", g());
  }
  
  public void y() {
    ChatManager.getInstance().registerSessionListener((SessionListener)this.r);
    ChatRelationDataManager.getInstance().registerChatRelationDataListener(this);
  }
  
  public void z() {
    ChatManager.getInstance().unregisterSessionListener((SessionListener)this.r);
    ChatRelationDataManager.getInstance().unRegisterChatRelationDataListener(this);
  }
  
  public class MsgSessionListener extends StableSessionListListener {
    public MsgSessionListener(MsgPresenter this$0) {}
    
    public void onUISessionDataChanged(List<SessionModel> param1List) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("copyList====");
      stringBuilder.append(param1List.size());
      Logger.c("MsgPresent test", new Object[] { stringBuilder.toString() });
      this.a.h.c(param1List);
      ChatHelperV4.a(param1List, true);
      ArrayList arrayList = new ArrayList();
      if (param1List != null)
        arrayList.addAll(MsgBoxManager.a().a(param1List, false)); 
      if (BluedConstant.a) {
        Iterator<SessionModel> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
          SessionModel sessionModel = iterator.next();
          if (sessionModel.sessionType == 3) {
            iterator.remove();
            continue;
          } 
          if (sessionModel.sessionType == 1 && sessionModel.sessionId == 2L)
            iterator.remove(); 
        } 
      } 
      this.a.h.b(arrayList);
      MsgPresenter.b(this.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\presenter\MsgPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */