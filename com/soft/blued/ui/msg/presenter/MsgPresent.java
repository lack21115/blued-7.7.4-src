package com.soft.blued.ui.msg.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.StableSessionListListener;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.chat.contract.FilterSessionListListener;
import com.blued.android.module.chat.contract.IChatRelationDataListener;
import com.blued.android.module.chat.manager.ChatRelationDataManager;
import com.blued.das.message.MessageProtos;
import com.soft.blued.BluedConstant;
import com.soft.blued.base.mvp.MVPBasePresent;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.model.HelloDataExtra;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.group.GroupNotifyFragment;
import com.soft.blued.ui.msg.MsgBoxFragment;
import com.soft.blued.ui.msg.contract.IMsgContract;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.manager.MsgBoxManager;
import com.soft.blued.ui.msg.manager.MsgDataManager;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg.observer.RecvMsgListenerObserver;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MsgPresent extends MVPBasePresent<IMsgContract.IView> implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, FilterSessionListListener, IChatRelationDataListener, RecvMsgListenerObserver.IRecvMsgListener {
  private boolean b;
  
  private String[] c;
  
  private Context d;
  
  private IRequestHost e;
  
  private MsgDataManager f;
  
  private boolean g;
  
  private boolean h;
  
  private boolean i;
  
  private void a(SessionModel paramSessionModel, boolean paramBoolean) {
    Context context;
    IMsgContract.IView iView = (IMsgContract.IView)aV_();
    if (iView == null)
      return; 
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
          TerminalActivity.d(((IMsgContract.IView)aV_()).b(), MsgBoxFragment.class, null);
          return;
        } 
        ChatHelperV4.a().a(iView.b(), paramSessionModel.sessionId, paramSessionModel.nickName, paramSessionModel.avatar, paramSessionModel.vBadge, paramSessionModel.vipGrade, paramSessionModel.vipAnnual, paramSessionModel.vipExpLvl, "", false, 1, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
        return;
      } 
      ChatHelperV4 chatHelperV4 = ChatHelperV4.a();
      context = iView.b();
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
      chatHelperV4.a(context, l, str1, str2, i, j, k, m, stringBuilder.toString(), paramBoolean, 0, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""));
      return;
    } 
    if (paramSessionModel.sessionId == 2L) {
      Bundle bundle = new Bundle();
      bundle.putLong("passby_session_id", paramSessionModel.sessionId);
      bundle.putShort("passby_session_type", (short)1);
      TerminalActivity.d(context.b(), GroupNotifyFragment.class, bundle);
      return;
    } 
    if (paramSessionModel.sessionId == 5L)
      ChatHelperV4.a().a(context.b(), paramSessionModel.sessionId, paramSessionModel.maxHasReadMsgID); 
  }
  
  private void a(String paramString, boolean paramBoolean) {
    IMsgContract.IView iView = (IMsgContract.IView)aV_();
    if (iView == null)
      return; 
    List<SessionModel> list = d();
    this.f.c();
    if (list != null && list.size() > 0)
      for (SessionModel sessionModel : list) {
        SessionSettingModel sessionSettingModel = (SessionSettingModel)sessionModel.sessionSettingModel;
        if ((!TextUtils.isEmpty(sessionModel.nickName) && sessionModel.nickName.contains(paramString)) || (!TextUtils.isEmpty(sessionModel.lastMsgFromNickname) && sessionModel.lastMsgFromNickname.contains(paramString)) || (!TextUtils.isEmpty(sessionModel.lastMsgContent) && sessionModel.lastMsgContent.contains(paramString)) || (sessionSettingModel != null && !TextUtils.isEmpty(sessionSettingModel.getSessinoNote()) && sessionSettingModel.getSessinoNote().contains(paramString)))
          this.f.a(sessionModel); 
      }  
    iView.a(f(), e().size());
    if (paramBoolean)
      iView.b(this.i); 
  }
  
  private void a(boolean paramBoolean) {
    IMsgContract.IView iView = (IMsgContract.IView)aV_();
    if (iView == null)
      return; 
    if (!TextUtils.isEmpty(iView.e())) {
      a(iView.e(), paramBoolean);
      return;
    } 
    boolean bool = f();
    if (!bool) {
      iView.a(e().size());
      return;
    } 
    iView.a(bool, e().size());
    if (paramBoolean)
      iView.b(this.i); 
  }
  
  private void g() {
    a(false);
  }
  
  public SessionModel a(int paramInt) {
    return (paramInt >= 0 && paramInt < e().size()) ? e().get(paramInt) : null;
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Bundle paramBundle) {
    IMsgContract.IView iView = (IMsgContract.IView)aV_();
    if (iView == null)
      return; 
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add(iView.b().getString(2131758011));
    arrayList.add(iView.b().getString(2131758009));
    this.c = arrayList.<String>toArray(new String[arrayList.size()]);
  }
  
  public void a(SessionModel paramSessionModel) {
    IMsgContract.IView iView = (IMsgContract.IView)aV_();
    if (iView == null)
      return; 
    if ((UserInfo.a().i()).vip_grade != 2 && (BluedConfig.b().j()).is_view_secretly == 0) {
      InstantLog.a("msg_view_secretly_click", 0);
      PayUtils.a((Context)iView.a(), 6, "chat_msg_quiet_singe");
      return;
    } 
    InstantLog.a("msg_view_secretly_click", 1);
    a(paramSessionModel, true);
  }
  
  public void a(SessionModel paramSessionModel, ChattingModel paramChattingModel) {
    if (f() && ChatHelperV4.a(paramSessionModel) && !this.f.e().contains(paramSessionModel)) {
      IMsgContract.IView iView = (IMsgContract.IView)aV_();
      if (iView == null)
        return; 
      iView.b(this.i);
    } 
  }
  
  public void b(Bundle paramBundle) {}
  
  public void b(SessionModel paramSessionModel) {
    if (paramSessionModel == null)
      return; 
    if (paramSessionModel.sessionType == 6668) {
      if (aV_() == null)
        return; 
      CommonAlertDialog.a(((IMsgContract.IView)aV_()).b(), "", ((IMsgContract.IView)aV_()).b().getResources().getString(2131758027), null, new DialogInterface.OnClickListener(this) {
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
  
  public void c() {}
  
  public List<SessionModel> d() {
    return f() ? this.f.e() : this.f.a();
  }
  
  public List<SessionModel> e() {
    IMsgContract.IView iView = (IMsgContract.IView)aV_();
    return (iView == null) ? new ArrayList<SessionModel>() : (TextUtils.isEmpty(iView.e()) ? this.f.a() : this.f.b());
  }
  
  public boolean f() {
    return false;
  }
  
  public void onDeleteSessions(List<Pair<Short, Long>> paramList) {
    ((IMsgContract.IView)aV_()).f();
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
    IMsgContract.IView iView = (IMsgContract.IView)aV_();
    if (iView == null)
      return true; 
    if (sessionModel.sessionType == 2) {
      ArrayList<String> arrayList = new ArrayList();
      arrayList.add(iView.b().getString(2131758011));
      arrayList.add(iView.b().getString(2131758009));
      this.c = arrayList.<String>toArray(new String[arrayList.size()]);
    } else {
      ArrayList<String> arrayList = new ArrayList();
      if (sessionModel.lastMsgFromId != 0L)
        arrayList.add(iView.b().getString(2131757941)); 
      arrayList.add(iView.b().getString(2131757942));
      this.c = arrayList.<String>toArray(new String[arrayList.size()]);
    } 
    iView.a(sessionModel, this.c);
    return true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 + paramInt2 == paramInt3)
      this.b = true; 
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void onUISessionDataChanged(List<SessionModel> paramList1, List<SessionModel> paramList2) {
    if (f()) {
      ChatHelperV4.c(paramList1);
      this.f.a(paramList1);
      boolean bool = true;
      this.g = true;
      if (this.h) {
        this.h = false;
        ChatHelperV4.a(paramList2, false);
        if (this.f.d(paramList2) <= 0)
          bool = false; 
        a(bool);
        return;
      } 
      g();
    } 
  }
  
  public class MsgSessionListener extends StableSessionListListener {
    public void onUISessionDataChanged(List<SessionModel> param1List) {
      MsgPresent.a(this.a).c(param1List);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("dataManager====");
      stringBuilder.append(param1List.size());
      Logger.e("MsgPresent test", new Object[] { stringBuilder.toString() });
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
      MsgPresent.a(this.a).b(arrayList);
      MsgPresent.b(this.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\presenter\MsgPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */