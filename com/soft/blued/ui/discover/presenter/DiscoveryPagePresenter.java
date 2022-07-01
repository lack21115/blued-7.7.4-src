package com.soft.blued.ui.discover.presenter;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProviders;
import com.blued.android.chat.listener.SingleSessionListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.ui.discover.model.DiscoveryPageTabModel;
import com.soft.blued.ui.discover.observer.DiscoverSquareViewModel;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import java.util.List;

public class DiscoveryPagePresenter extends MvpPresenter implements SingleSessionListener {
  public List<DiscoveryPageTabModel> h;
  
  public int a(int paramInt) {
    int j = -1;
    for (int i = 0; i < m().size(); i++) {
      if (((DiscoveryPageTabModel)m().get(i)).tabid == paramInt)
        j = i; 
    } 
    return j;
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    this.h = DiscoveryPageTabModel.getDiscoveryTabs((Context)h());
  }
  
  public void a(LifecycleOwner paramLifecycleOwner) {
    super.a(paramLifecycleOwner);
    ChatHelperV4.a().a(this);
    paramLifecycleOwner.getLifecycle().addObserver(new LifecycleObserver(this, paramLifecycleOwner) {
          @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
          public void onDestroy() {
            ChatHelperV4.a().b(this.b);
            this.a.getLifecycle().removeObserver(this);
          }
        });
    if (HomeActivity.c != null) {
      DiscoverSquareViewModel discoverSquareViewModel = (DiscoverSquareViewModel)ViewModelProviders.of((FragmentActivity)HomeActivity.c).get(DiscoverSquareViewModel.class);
      discoverSquareViewModel.a.observe(paramLifecycleOwner, new Observer<Integer>(this) {
            public void a(Integer param1Integer) {
              this.a.a("view_page_to_item", param1Integer);
            }
          });
      discoverSquareViewModel.b.observe(paramLifecycleOwner, new Observer<Void>(this) {
            public void a(Void param1Void) {
              int i = this.a.a(3);
              this.a.a("show_red_dot", Integer.valueOf(i));
            }
          });
    } 
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public List<DiscoveryPageTabModel> m() {
    List<DiscoveryPageTabModel> list = this.h;
    if (list == null || list.size() <= 0)
      this.h = DiscoveryPageTabModel.getDiscoveryTabs((Context)h()); 
    return this.h;
  }
  
  public void onSessionDataChanged(SessionModel paramSessionModel) {
    if (paramSessionModel != null && paramSessionModel.sessionType == 1 && paramSessionModel.sessionId == 13L && paramSessionModel.noReadMsgCount != 0)
      a("show_red_dot", Integer.valueOf(a(3))); 
  }
  
  public void onSessionRemoved(short paramShort, long paramLong) {
    if (paramShort == 1 && paramLong == 13L)
      a("hide_red_dot", Integer.valueOf(a(3))); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\presenter\DiscoveryPagePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */