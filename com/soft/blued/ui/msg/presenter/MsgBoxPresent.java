package com.soft.blued.ui.msg.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.StableSessionListListener;
import com.blued.android.chat.listener.FetchDataListener;
import com.blued.android.chat.listener.SessionListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.utils.AppUtils;
import com.blued.das.message.MessageProtos;
import com.soft.blued.BluedConstant;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.ui.group.GroupNotifyFragment;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.manager.MsgBoxManager;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.msg.pop.BottomMenuPop;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MsgBoxPresent extends MvpPresenter {
  private MsgSessionListener h = new MsgSessionListener(this);
  
  private BottomMenuPop i;
  
  private List<SessionModel> j;
  
  private SessionModel a(int paramInt) {
    return (paramInt >= 0 && paramInt < this.j.size()) ? this.j.get(paramInt) : null;
  }
  
  private void a(SessionModel paramSessionModel, boolean paramBoolean) {
    if (paramSessionModel == null)
      return; 
    short s = paramSessionModel.sessionType;
    LogData logData = new LogData();
    logData.g = "none";
    if (s != 1) {
      if (s != 2) {
        if (s != 3)
          return; 
        ChatHelperV4.a().a((Context)h(), paramSessionModel.sessionId, paramSessionModel.nickName, paramSessionModel.avatar, paramSessionModel.vBadge, paramSessionModel.vipGrade, paramSessionModel.vipAnnual, paramSessionModel.vipExpLvl, "", false, 1, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""), true);
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
      chatHelperV4.a((Context)activity, l, str1, str2, i, j, k, m, stringBuilder.toString(), paramBoolean, 0, 0, logData, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, ""), true);
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
  
  public void a(SessionModel paramSessionModel) {
    if (paramSessionModel == null)
      return; 
    long l = paramSessionModel.sessionId;
    ChatManager.getInstance().deleteSession(paramSessionModel.sessionType, l);
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void b(SessionModel paramSessionModel) {
    if ((UserInfo.a().i()).vip_grade != 2 && (BluedConfig.b().j()).is_view_secretly == 0) {
      InstantLog.a("msg_view_secretly_click", 0);
      PayUtils.a((Context)h(), 6, "chat_msg_quiet_singe");
      return;
    } 
    InstantLog.a("msg_view_secretly_click", 1);
    a(paramSessionModel, true);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public void m() {
    ChatManager.getInstance().registerSessionListener((SessionListener)this.h);
  }
  
  public void n() {
    ChatManager.getInstance().unregisterSessionListener((SessionListener)this.h);
  }
  
  public AdapterView.OnItemLongClickListener o() {
    return new AdapterView.OnItemLongClickListener(this) {
        public boolean onItemLongClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
          SessionModel sessionModel = MsgBoxPresent.a(this.a, param1Int - 2);
          if (sessionModel == null)
            return true; 
          ArrayList<String> arrayList1 = new ArrayList();
          if (sessionModel.sessionType == 2) {
            arrayList1.add(AppUtils.a(2131758011));
            arrayList1.add(AppUtils.a(2131758009));
          } else {
            arrayList1.add(AppUtils.a(2131758009));
          } 
          ArrayList<BottomMenuPop.MenuItemInfo> arrayList = new ArrayList();
          for (String str : arrayList1) {
            BottomMenuPop.MenuItemInfo menuItemInfo = new BottomMenuPop.MenuItemInfo();
            menuItemInfo.a = str;
            menuItemInfo.c = new View.OnClickListener(this, str, sessionModel) {
                public void onClick(View param2View) {
                  if (MsgBoxPresent.b(this.c.a) != null)
                    MsgBoxPresent.b(this.c.a).p(); 
                  if (TextUtils.equals(this.a, AppUtils.a(2131758011))) {
                    this.c.a.b(this.b);
                    return;
                  } 
                  if (TextUtils.equals(this.a, AppUtils.a(2131758009)))
                    this.c.a.a(this.b); 
                }
              };
            arrayList.add(menuItemInfo);
          } 
          MsgBoxPresent msgBoxPresent = this.a;
          MsgBoxPresent.a(msgBoxPresent, new BottomMenuPop((Context)msgBoxPresent.h()));
          (MsgBoxPresent.b(this.a)).b = arrayList;
          (new XPopup.Builder((Context)this.a.h())).a((BasePopupView)MsgBoxPresent.b(this.a)).h();
          return true;
        }
      };
  }
  
  public AdapterView.OnItemClickListener p() {
    return new AdapterView.OnItemClickListener(this) {
        public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
          SessionModel sessionModel = MsgBoxPresent.a(this.a, param1Int - 2);
          if (sessionModel != null) {
            if (BluedPreferences.ar()) {
              this.a.b(sessionModel);
              return;
            } 
            MsgBoxPresent.a(this.a, sessionModel, false);
          } 
        }
      };
  }
  
  public void q() {
    ChatManager.getInstance().getSessionModelList(new FetchDataListener<List<SessionModel>>(this) {
          public void a(List<SessionModel> param1List) {
            AppInfo.n().post(new Runnable(this, param1List) {
                  public void run() {
                    MsgBoxPresent.c(this.b.a).onUISessionDataChanged(this.a);
                  }
                });
          }
        });
  }
  
  public class MsgSessionListener extends StableSessionListListener {
    public MsgSessionListener(MsgBoxPresent this$0) {}
    
    public void onUISessionDataChanged(List<SessionModel> param1List) {
      ChatHelperV4.a(param1List, true);
      MsgBoxPresent.a(this.a, new ArrayList());
      if (param1List != null)
        MsgBoxPresent.a(this.a).addAll(MsgBoxManager.a().a(param1List, true)); 
      if (BluedConstant.a) {
        Iterator<SessionModel> iterator = MsgBoxPresent.a(this.a).iterator();
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
      MsgBoxPresent msgBoxPresent = this.a;
      msgBoxPresent.a("session_list", MsgBoxPresent.a(msgBoxPresent));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\presenter\MsgBoxPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */