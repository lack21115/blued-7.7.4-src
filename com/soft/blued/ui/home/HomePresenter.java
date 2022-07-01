package com.soft.blued.ui.home;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.blued.android.chat.BluedChat;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.StableSessionListListener;
import com.blued.android.chat.listener.SessionListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.VideoChatMsgContentModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.urlroute.BluedURIRouter;
import com.blued.android.module.chat.ModuleChatConfig;
import com.blued.android.module.chat.http.IModuleChatHttp;
import com.blued.android.module.chat.manager.MsgFilterManager;
import com.blued.android.module.common.utils.ToastUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.BluedConstant;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.H5Url;
import com.soft.blued.push.PushManager;
import com.soft.blued.sdk.SDKActionManager;
import com.soft.blued.ui.discover.observer.SystemNoticeViewModel;
import com.soft.blued.ui.feed.manager.FeedSendManager;
import com.soft.blued.ui.find.observer.FeedRefreshObserver;
import com.soft.blued.ui.home.model.HomeViewModel;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.SignInActivity;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.manager.MsgBoxManager;
import com.soft.blued.ui.msg.model.RefreshSessionEvent;
import com.soft.blued.ui.user.utils.CommandManager;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HomePresenter implements FeedRefreshObserver.IFeedRefreshObserver, HomeContract.Presenter {
  public static final String a = HomePresenter.class.getSimpleName();
  
  private static ExecutorService j = Executors.newSingleThreadExecutor();
  
  private Context b;
  
  private String c;
  
  private HomeContract.View d;
  
  private boolean e = false;
  
  private long f = 0L;
  
  private HomePageSessionListener g;
  
  private IRequestHost h;
  
  private int i = 0;
  
  private List<SessionModel> k;
  
  private boolean l = false;
  
  public HomePresenter(Context paramContext, String paramString, HomeContract.View paramView, IRequestHost paramIRequestHost) {
    this.b = paramContext;
    this.c = paramString;
    this.d = paramView;
    this.h = paramIRequestHost;
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
    String str;
    if (!StringUtils.e(BluedApplicationLike.previousLanguage)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("?lan=");
      stringBuilder.append(BluedApplicationLike.previousLanguage);
      str = H5Url.a(29, new Object[] { stringBuilder.toString() });
    } else {
      str = H5Url.a(29);
    } 
    CommonAlertDialog.a(paramContext, null, "", paramString1, paramString2, paramString3, new DialogInterface.OnClickListener(this, paramContext, str) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            WebViewShowInfoFragment.show(this.a, this.b, 7);
            BluedPreferences.aF();
          }
        }new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            BluedPreferences.aF();
          }
        },  new DialogInterface.OnCancelListener(this) {
          public void onCancel(DialogInterface param1DialogInterface) {
            BluedPreferences.aF();
          }
        },  true);
  }
  
  private void a(List<SessionModel> paramList) {
    boolean bool1;
    boolean bool2;
    boolean bool3;
    SystemNoticeViewModel systemNoticeViewModel = (SystemNoticeViewModel)ViewModelProviders.of((FragmentActivity)this.b).get(SystemNoticeViewModel.class);
    boolean bool4 = false;
    if (paramList != null && paramList.size() > 0) {
      Iterator<SessionModel> iterator = paramList.iterator();
      bool4 = false;
      bool3 = false;
      bool2 = false;
      for (bool1 = false; iterator.hasNext(); bool1 = true) {
        SessionModel sessionModel = iterator.next();
        if (sessionModel.sessionType == 1 && (sessionModel.sessionId == 3L || sessionModel.sessionId == 11L || sessionModel.sessionId == 22L)) {
          String str1 = a;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("找到动态session===");
          stringBuilder1.append(sessionModel.noReadMsgCount);
          stringBuilder1.append("===");
          stringBuilder1.append(sessionModel.sessionId);
          Logger.e(str1, new Object[] { stringBuilder1.toString() });
          if (sessionModel.noReadMsgCount > 0) {
            this.i += sessionModel.noReadMsgCount;
            if (systemNoticeViewModel.c != sessionModel.noReadMsgCount) {
              systemNoticeViewModel.c = sessionModel.noReadMsgCount;
              systemNoticeViewModel.g.postValue(Integer.valueOf(systemNoticeViewModel.c));
            } 
            this.d.e("feed");
            bool4 = true;
          } 
          continue;
        } 
        if (sessionModel.sessionType == 1 && (sessionModel.sessionId == 6L || sessionModel.sessionId == 7L)) {
          if (sessionModel.noReadMsgCount > 0) {
            this.d.d("live");
            bool3 = true;
          } 
          continue;
        } 
        if (sessionModel.sessionType == 1 && sessionModel.sessionId == 12L) {
          if (sessionModel.noReadMsgCount > 0)
            this.d.d("mine"); 
          continue;
        } 
        if (sessionModel.sessionType == 1 && sessionModel.sessionId == 13L) {
          if (sessionModel.noReadMsgCount > 0) {
            if (!this.d.b("feed"))
              this.d.d("feed"); 
            bool2 = true;
          } 
          continue;
        } 
        if (sessionModel.sessionType == 1 && sessionModel.sessionId == 14L) {
          if (sessionModel.noReadMsgCount > 0) {
            if (!this.d.b("feed"))
              this.d.d("feed"); 
          } else {
            continue;
          } 
        } else if (sessionModel.sessionType == 1 && sessionModel.sessionId == 5L) {
          if (sessionModel.noReadMsgCount > 0) {
            this.i += sessionModel.noReadMsgCount;
            systemNoticeViewModel.b.followers = sessionModel.noReadMsgCount;
          } else {
            continue;
          } 
        } else if (sessionModel.sessionType == 1 && sessionModel.sessionId == 21L) {
          if (sessionModel.noReadMsgCount > 0) {
            this.i += sessionModel.noReadMsgCount;
            systemNoticeViewModel.b.liked = sessionModel.noReadMsgCount;
          } else {
            continue;
          } 
        } else if (sessionModel.sessionType == 1 && sessionModel.sessionId == 2L) {
          if (sessionModel.noReadMsgCount > 0) {
            this.i += sessionModel.noReadMsgCount;
            systemNoticeViewModel.b.groups = sessionModel.noReadMsgCount;
          } else {
            continue;
          } 
        } else if (sessionModel.sessionType == 1 && sessionModel.sessionId == 24L && sessionModel.noReadMsgCount > 0) {
          this.i += sessionModel.noReadMsgCount;
          systemNoticeViewModel.b.circle = sessionModel.noReadMsgCount;
        } else {
          continue;
        } 
      } 
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("attention_like_vote_count = ");
      stringBuilder.append(this.i);
      Logger.c(str, new Object[] { stringBuilder.toString() });
      AppInfo.n().post(new Runnable(this, systemNoticeViewModel) {
            public void run() {
              if (HomePresenter.a(this.b) != null) {
                this.a.h.postValue(this.a.b);
                this.a.f.postValue(Integer.valueOf(this.a.b.getSum() + this.a.c));
                this.a.d.postValue(Integer.valueOf(this.a.a + this.a.b.getSum() + this.a.c));
              } 
            }
          });
    } else {
      bool3 = false;
      bool2 = false;
      bool1 = false;
    } 
    if (!bool4)
      this.d.c("feed"); 
    if (!bool3) {
      this.d.e("live");
      if (BluedPreferences.aP()) {
        this.d.d("live");
      } else {
        this.d.e("live");
      } 
    } 
    if (!bool2 && !bool1)
      this.d.e("feed"); 
  }
  
  private void f() {
    g();
    ModuleChatConfig.getInstance().setHttpImpl((IModuleChatHttp)new ChatHttpUtils());
    FeedRefreshObserver.a().a(this);
    FeedSendManager.a().b();
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            if (TextUtils.isEmpty(LoginRegisterTools.d()) && TextUtils.isEmpty(LoginRegisterTools.b())) {
              LoginRegisterTools.a(HomePresenter.a(this.a), 2, 0);
              return;
            } 
            if (TextUtils.isEmpty(LoginRegisterTools.d())) {
              LoginRegisterTools.a(HomePresenter.a(this.a), 1, 1);
              return;
            } 
            if (TextUtils.isEmpty(LoginRegisterTools.b()))
              LoginRegisterTools.a(HomePresenter.a(this.a), 1, 0); 
          }
        }2000L);
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            HomePresenter.b(this.a);
          }
        },  2100L);
    this.g = new HomePageSessionListener();
    LiveEventBus.get("refresh_unread_msg_cnt", RefreshSessionEvent.class).observe((LifecycleOwner)this.d, new Observer<RefreshSessionEvent>(this) {
          public void a(RefreshSessionEvent param1RefreshSessionEvent) {
            if (param1RefreshSessionEvent.list.size() == 0)
              return; 
            String str = HomePresenter.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("KEY_EVENT_REFRESH_UNREAD_MSG_CNT==");
            stringBuilder.append(param1RefreshSessionEvent.list.size());
            Logger.e(str, new Object[] { stringBuilder.toString() });
            HomePresenter.a(this.a, param1RefreshSessionEvent.list);
            HomePresenter.c(this.a);
          }
        });
  }
  
  private void g() {
    boolean bool;
    if (!TextUtils.isEmpty(this.c) && (this.c.equals("from_tag_register") || this.c.equals("from_tag_login"))) {
      CommandManager.a().a(this.b);
      bool = true;
    } else {
      bool = false;
    } 
    if (!UserInfo.a().j()) {
      SignInActivity.a(this.b, new android.os.Bundle[0]);
      return;
    } 
    PushManager.a().e();
    BluedChat.getInstance().startIMService(this.b, bool ^ true);
  }
  
  private void h() {
    String[] arrayOfString1 = this.b.getResources().getStringArray(2130903056);
    String[] arrayOfString2 = this.b.getResources().getStringArray(2130903062);
    String[] arrayOfString3 = this.b.getResources().getStringArray(2130903051);
    if (BluedPreferences.aE()) {
      if (BluedApplicationLike.previousLanguage == null)
        return; 
      String str = BluedApplicationLike.previousLanguage;
      byte b = -1;
      int i = str.hashCode();
      if (i != 3383) {
        if (i != 3428) {
          if (i == 3700 && str.equals("th"))
            b = 2; 
        } else if (str.equals("ko")) {
          b = 1;
        } 
      } else if (str.equals("ja")) {
        b = 0;
      } 
      if (b != 0) {
        if (b != 1) {
          if (b != 2) {
            if (!"zh".equals(BluedApplicationLike.previousLanguage) && !"en".equals(BluedApplicationLike.previousLanguage)) {
              a(this.b, arrayOfString1[0], arrayOfString3[0], arrayOfString2[0]);
              return;
            } 
          } else {
            a(this.b, arrayOfString1[3], arrayOfString3[3], arrayOfString2[3]);
            return;
          } 
        } else {
          a(this.b, arrayOfString1[2], arrayOfString3[2], arrayOfString2[2]);
          return;
        } 
      } else {
        a(this.b, arrayOfString1[1], arrayOfString3[1], arrayOfString2[1]);
      } 
    } 
  }
  
  private void i() {
    if (this.k != null && !this.l) {
      this.l = true;
      ArrayList<SessionModel> arrayList = new ArrayList();
      arrayList.addAll(this.k);
      a(arrayList);
      j.execute(new CountNewSessionThread(this, arrayList));
      this.k.clear();
      this.k = null;
    } 
  }
  
  public void a(Object paramObject, int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 3) {
        if (paramInt != 4) {
          if (paramInt != 5)
            return; 
          this.d.f("feed");
          return;
        } 
        FeedSendManager.a().g();
        return;
      } 
      FeedSendManager.a().g();
    } 
  }
  
  public void b() {
    ChatManager.getInstance().unregisterSessionListener((SessionListener)this.g);
    MsgFilterManager.getInstance().unRegisterSessionListener();
  }
  
  public void bb_() {
    if (!this.e) {
      f();
      this.e = true;
    } 
    ChatManager.getInstance().registerSessionListener((SessionListener)this.g);
  }
  
  public void c() {
    FeedRefreshObserver.a().b(this);
  }
  
  public void d() {
    if (BluedApplicationLike.outUri != null) {
      BluedURIRouter.a().a(this.b, BluedApplicationLike.outUri);
      BluedApplicationLike.outUri = null;
    } 
    SDKActionManager.a(this.b);
  }
  
  public void e() {
    long l = System.currentTimeMillis();
    if (l - this.f > 2000L) {
      ToastUtils.b(2131755508);
      this.f = l;
      return;
    } 
    System.currentTimeMillis();
    AppUtils.a(AppInfo.d());
    BluedPreferences.b(0L);
  }
  
  class CountNewSessionThread implements Runnable {
    int a = 0;
    
    int b = 0;
    
    List<SessionModel> c;
    
    public CountNewSessionThread(HomePresenter this$0, List<SessionModel> param1List) {
      this.c = param1List;
    }
    
    public void run() {
      String str = HomePresenter.a;
      int i = 0;
      Logger.c(str, new Object[] { "计算未读数" });
      ChatHelperV4.a(this.c, false);
      if (this.c != null) {
        while (i < this.c.size()) {
          SessionModel sessionModel = this.c.get(i);
          if (!MsgBoxManager.a().c() || !MsgBoxManager.a().a(sessionModel)) {
            SessionSettingModel sessionSettingModel = (SessionSettingModel)sessionModel.sessionSettingModel;
            if (sessionSettingModel == null || sessionSettingModel.getRemindAudio() == 0)
              if (BluedConstant.a) {
                if (sessionModel.sessionType != 3)
                  if (sessionModel.sessionType == 1) {
                    if (sessionModel.sessionId != 2L)
                      this.a += sessionModel.noReadMsgCount; 
                  } else {
                    this.a += sessionModel.noReadMsgCount;
                  }  
              } else {
                this.a += sessionModel.noReadMsgCount;
              }  
            if (sessionModel.lastMsgType == 52 && sessionModel.noReadMsgCount > 0 && sessionModel.lastMsgContent != null) {
              VideoChatMsgContentModel videoChatMsgContentModel = (VideoChatMsgContentModel)AppInfo.f().fromJson(sessionModel.lastMsgContent, VideoChatMsgContentModel.class);
              if (videoChatMsgContentModel != null && videoChatMsgContentModel.room_type == 2) {
                this.b = 2;
              } else if (videoChatMsgContentModel != null && videoChatMsgContentModel.room_type == 1) {
                this.b = 1;
              } 
            } 
          } 
          i++;
        } 
        this.c.clear();
      } 
      this.c = null;
      AppInfo.n().post(new Runnable(this) {
            public void run() {
              if (this.a.b == 2) {
                HomePresenter.d(this.a.d).b("msg", 2131231193);
              } else if (this.a.b == 1) {
                HomePresenter.d(this.a.d).b("msg", 2131231192);
              } else {
                HomePresenter.d(this.a.d).f("msg");
              } 
              if ((this.a.a > 0 || HomePresenter.e(this.a.d) > 0) && this.a.b == 0) {
                HomePresenter.d(this.a.d).a("msg", this.a.a + HomePresenter.e(this.a.d));
                if (HomePresenter.a(this.a.d) != null)
                  ((HomeViewModel)ViewModelProviders.of((FragmentActivity)HomePresenter.a(this.a.d)).get(HomeViewModel.class)).a.postValue(Integer.valueOf(this.a.a)); 
              } else {
                HomePresenter.d(this.a.d).c("msg");
              } 
              if (HomePresenter.a(this.a.d) != null) {
                SystemNoticeViewModel systemNoticeViewModel = (SystemNoticeViewModel)ViewModelProviders.of((FragmentActivity)HomePresenter.a(this.a.d)).get(SystemNoticeViewModel.class);
                systemNoticeViewModel.a = this.a.a;
                systemNoticeViewModel.e.postValue(Integer.valueOf(this.a.a));
                systemNoticeViewModel.d.postValue(Integer.valueOf(systemNoticeViewModel.a + systemNoticeViewModel.b.getSum() + systemNoticeViewModel.c));
              } 
              HomePresenter.a(this.a.d, 0);
              HomePresenter.a(this.a.d, false);
              HomePresenter.c(this.a.d);
            }
          });
    }
  }
  
  class null implements Runnable {
    null(HomePresenter this$0) {}
    
    public void run() {
      if (this.a.b == 2) {
        HomePresenter.d(this.a.d).b("msg", 2131231193);
      } else if (this.a.b == 1) {
        HomePresenter.d(this.a.d).b("msg", 2131231192);
      } else {
        HomePresenter.d(this.a.d).f("msg");
      } 
      if ((this.a.a > 0 || HomePresenter.e(this.a.d) > 0) && this.a.b == 0) {
        HomePresenter.d(this.a.d).a("msg", this.a.a + HomePresenter.e(this.a.d));
        if (HomePresenter.a(this.a.d) != null)
          ((HomeViewModel)ViewModelProviders.of((FragmentActivity)HomePresenter.a(this.a.d)).get(HomeViewModel.class)).a.postValue(Integer.valueOf(this.a.a)); 
      } else {
        HomePresenter.d(this.a.d).c("msg");
      } 
      if (HomePresenter.a(this.a.d) != null) {
        SystemNoticeViewModel systemNoticeViewModel = (SystemNoticeViewModel)ViewModelProviders.of((FragmentActivity)HomePresenter.a(this.a.d)).get(SystemNoticeViewModel.class);
        systemNoticeViewModel.a = this.a.a;
        systemNoticeViewModel.e.postValue(Integer.valueOf(this.a.a));
        systemNoticeViewModel.d.postValue(Integer.valueOf(systemNoticeViewModel.a + systemNoticeViewModel.b.getSum() + systemNoticeViewModel.c));
      } 
      HomePresenter.a(this.a.d, 0);
      HomePresenter.a(this.a.d, false);
      HomePresenter.c(this.a.d);
    }
  }
  
  class HomePageSessionListener extends StableSessionListListener {
    private HomePageSessionListener(HomePresenter this$0) {}
    
    public void onUISessionDataChanged(List<SessionModel> param1List) {
      String str = HomePresenter.a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onUISessionDataChanged=====");
      stringBuilder.append(param1List.size());
      Logger.c(str, new Object[] { stringBuilder.toString() });
      HomePresenter.a(this.a, param1List);
      HomePresenter.c(this.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\home\HomePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */