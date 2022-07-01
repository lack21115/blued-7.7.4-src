package com.soft.blued.ui.notify.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.AppUtils;
import com.blued.das.client.feed.FeedProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.discover.observer.SystemNoticeViewModel;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.notify.fragment.SystemNoticeAdapter;
import com.soft.blued.ui.notify.model.FeedNotice;
import com.soft.blued.ui.notify.model.ViewpointNoticeCount;
import com.soft.blued.view.tip.CommonAlertDialog;

public class SystemNoticePresenter extends MvpPresenter {
  public SystemNoticeViewModel h;
  
  public boolean i = false;
  
  public boolean j = false;
  
  private SystemNoticeAdapter k;
  
  private String l = "comments";
  
  private int m = 1;
  
  private int n = 20;
  
  private boolean o = false;
  
  private ViewpointNoticeCount p;
  
  private void a(long paramLong) {
    EventTrackFeed.b(FeedProtos.Event.MSG_NOTICE_DELETE_CLICK);
    InstantLog.b("delete_all", 1);
    CommonAlertDialog.a((Context)h(), AppUtils.a(2131758303), AppUtils.a(2131756180), AppUtils.a(2131756100), new DialogInterface.OnClickListener(this, paramLong) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            FindHttpUtils.a(new BluedUIHttpResponse(this, this.b.g()) {
                  public void onUIUpdate(BluedEntity param2BluedEntity) {
                    this.a.b.a("VIEW_POINT_CLEAR", false);
                    this.a.b.a("VIEW_POINT_LIST", (Object)null);
                  }
                }this.b.g(), "comments", String.valueOf(this.a));
          }
        }AppUtils.a(2131755726), null, null);
  }
  
  private void c(IFetchDataListener paramIFetchDataListener) {
    FindHttpUtils.a(d(paramIFetchDataListener), this.l, this.m, this.n, g());
  }
  
  private BluedUIHttpResponse d(IFetchDataListener paramIFetchDataListener) {
    String str;
    if (this.m == 1) {
      str = "system_notice";
    } else {
      str = "";
    } 
    return new BluedUIHttpResponse<BluedEntity<FeedNotice, BluedEntityBaseExtra>>(this, str, g(), paramIFetchDataListener) {
        public void onUICache(BluedEntity<FeedNotice, BluedEntityBaseExtra> param1BluedEntity) {
          super.onUICache(param1BluedEntity);
          if (param1BluedEntity != null && param1BluedEntity.hasData())
            this.b.a("VIEW_POINT_LIST", param1BluedEntity.data); 
        }
        
        public void onUIFinish(boolean param1Boolean) {
          super.onUIFinish(param1Boolean);
          if (!param1Boolean)
            SystemNoticePresenter.d(this.b); 
          if (!SystemNoticePresenter.e(this.b)) {
            IFetchDataListener iFetchDataListener1 = this.a;
            if (iFetchDataListener1 != null)
              iFetchDataListener1.b(); 
          } 
          IFetchDataListener iFetchDataListener = this.a;
          if (iFetchDataListener != null)
            iFetchDataListener.a(param1Boolean); 
          FindHttpUtils.a(null, SystemNoticePresenter.f(this.b), String.valueOf(SystemNoticePresenter.a(this.b).a()), this.b.g());
        }
        
        public void onUIUpdate(BluedEntity<FeedNotice, BluedEntityBaseExtra> param1BluedEntity) {
          if (param1BluedEntity != null && param1BluedEntity.hasData()) {
            if (SystemNoticePresenter.c(this.b) == 1) {
              ChatHelperV4.a().a(3L);
              ChatHelperV4.a().a(11L);
              ChatHelperV4.a().a(22L);
            } 
            IFetchDataListener iFetchDataListener = this.a;
            if (iFetchDataListener != null)
              iFetchDataListener.a("VIEW_POINT_LIST", param1BluedEntity.data); 
            SystemNoticePresenter.a(this.b, param1BluedEntity.hasMore());
            return;
          } 
          SystemNoticePresenter.a(this.b, false);
        }
      };
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    this.h = (SystemNoticeViewModel)ViewModelProviders.of(paramFragmentActivity).get(SystemNoticeViewModel.class);
  }
  
  public void a(LifecycleOwner paramLifecycleOwner) {
    super.a(paramLifecycleOwner);
    LiveEventBus.get("click_right_delete", View.class).observe(paramLifecycleOwner, new Observer<View>(this) {
          public void a(View param1View) {
            if (SystemNoticePresenter.a(this.a) != null) {
              SystemNoticePresenter systemNoticePresenter = this.a;
              SystemNoticePresenter.a(systemNoticePresenter, SystemNoticePresenter.a(systemNoticePresenter).a());
            } 
          }
        });
    LiveEventBus.get("clear_message_notify", Void.class).observe(paramLifecycleOwner, new Observer<Void>(this) {
          public void a(Void param1Void) {
            SystemNoticePresenter.a(this.a, new ViewpointNoticeCount());
            SystemNoticePresenter systemNoticePresenter = this.a;
            systemNoticePresenter.a("VIEW_POINT", SystemNoticePresenter.b(systemNoticePresenter));
            this.a.a("CLEAR_NOTIFY", false);
            this.a.n();
            this.a.o();
            this.a.p();
            this.a.q();
            this.a.r();
            this.a.s();
          }
        });
    SystemNoticeViewModel systemNoticeViewModel = (SystemNoticeViewModel)ViewModelProviders.of((FragmentActivity)h()).get(SystemNoticeViewModel.class);
    systemNoticeViewModel.h.observe(paramLifecycleOwner, new Observer<ViewpointNoticeCount>(this) {
          public void a(ViewpointNoticeCount param1ViewpointNoticeCount) {
            if (SystemNoticePresenter.b(this.a) == null)
              SystemNoticePresenter.a(this.a, new ViewpointNoticeCount()); 
            (SystemNoticePresenter.b(this.a)).followers = Math.max((SystemNoticePresenter.b(this.a)).followers, param1ViewpointNoticeCount.followers);
            (SystemNoticePresenter.b(this.a)).liked = Math.max((SystemNoticePresenter.b(this.a)).liked, param1ViewpointNoticeCount.liked);
            (SystemNoticePresenter.b(this.a)).groups = Math.max((SystemNoticePresenter.b(this.a)).groups, param1ViewpointNoticeCount.groups);
            (SystemNoticePresenter.b(this.a)).circle = Math.max((SystemNoticePresenter.b(this.a)).circle, param1ViewpointNoticeCount.circle);
            SystemNoticePresenter systemNoticePresenter = this.a;
            systemNoticePresenter.a("VIEW_POINT", SystemNoticePresenter.b(systemNoticePresenter));
          }
        });
    systemNoticeViewModel.g.observe(paramLifecycleOwner, new Observer<Integer>(this) {
          public void a(Integer param1Integer) {
            if (this.a.i && this.a.j)
              this.a.e(); 
          }
        });
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.m = 1;
    m();
    c(paramIFetchDataListener);
  }
  
  public void a(SystemNoticeAdapter paramSystemNoticeAdapter) {
    this.k = paramSystemNoticeAdapter;
  }
  
  public void a(ViewpointNoticeCount paramViewpointNoticeCount) {
    ChatManager.getInstance().updateSessionNoReadNum((short)1, 5L, paramViewpointNoticeCount.followers);
    ChatManager.getInstance().updateSessionNoReadNum((short)1, 21L, paramViewpointNoticeCount.liked);
    ChatManager.getInstance().updateSessionNoReadNum((short)1, 2L, paramViewpointNoticeCount.groups);
    ChatManager.getInstance().updateSessionNoReadNum((short)1, 24L, paramViewpointNoticeCount.circle);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.m++;
    c(paramIFetchDataListener);
  }
  
  public void b(ViewpointNoticeCount paramViewpointNoticeCount) {
    if (paramViewpointNoticeCount != null)
      this.h.b = paramViewpointNoticeCount; 
    this.h.f.postValue(Integer.valueOf(this.h.b.getSum() + this.h.c));
    this.h.d.postValue(Integer.valueOf(this.h.a + this.h.b.getSum() + this.h.c));
  }
  
  public void k() {
    super.k();
    d((IFetchDataListener)null).refresh();
  }
  
  public void m() {
    FindHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<ViewpointNoticeCount>>(this, g()) {
          public void a(BluedEntityA<ViewpointNoticeCount> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && !param1BluedEntityA.data.isEmpty()) {
              if (param1BluedEntityA.data.get(0) == null)
                return; 
              SystemNoticePresenter.a(this.a, (ViewpointNoticeCount)param1BluedEntityA.getSingleData());
              (SystemNoticePresenter.b(this.a)).isHttp = true;
              SystemNoticePresenter systemNoticePresenter = this.a;
              systemNoticePresenter.a("VIEW_POINT", SystemNoticePresenter.b(systemNoticePresenter));
              systemNoticePresenter = this.a;
              systemNoticePresenter.a(SystemNoticePresenter.b(systemNoticePresenter));
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            return super.onUIFailure(param1Int, param1String);
          }
        }g());
  }
  
  public void n() {
    ChatManager.getInstance().updateSessionNoReadNum((short)1, 5L, 0);
    ChatManager.getInstance().updateSessionNoReadNum((short)1, 21L, 0);
    ChatManager.getInstance().updateSessionNoReadNum((short)1, 2L, 0);
    ChatManager.getInstance().updateSessionNoReadNum((short)1, 24L, 0);
  }
  
  public void o() {
    this.h.b.followers = 0;
    ChatManager.getInstance().ignoredNoReadNum((short)1, 5L);
    FindHttpUtils.a(null, "followers", String.valueOf(System.currentTimeMillis() / 1000L), null);
    b((ViewpointNoticeCount)null);
  }
  
  public void p() {
    this.h.b.liked = 0;
    ChatManager.getInstance().ignoredNoReadNum((short)1, 21L);
    FindHttpUtils.a(null, "liked", null);
    b((ViewpointNoticeCount)null);
  }
  
  public void q() {
    this.h.b.groups = 0;
    ChatManager.getInstance().ignoredNoReadNum((short)1, 2L);
    FindHttpUtils.a(null, "groups", null);
    b((ViewpointNoticeCount)null);
  }
  
  public void r() {
    this.h.b.circle = 0;
    ChatManager.getInstance().ignoredNoReadNum((short)1, 24L);
    FindHttpUtils.a(null, "circle", null);
    b((ViewpointNoticeCount)null);
  }
  
  public void s() {
    ChatHelperV4.a().a(3L);
    ChatHelperV4.a().a(11L);
    ChatHelperV4.a().a(22L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\notify\presenter\SystemNoticePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */