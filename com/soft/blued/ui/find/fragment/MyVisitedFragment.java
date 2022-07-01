package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ToggleButton;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.das.guy.GuyProtos;
import com.blued.das.vip.VipProtos;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.log.trackUtils.EventTrackVIP;
import com.soft.blued.ui.find.adapter.VisitorListAdapter;
import com.soft.blued.ui.find.model.BluedMyVisitorList;
import com.soft.blued.ui.find.observer.UserInfoDataObserver;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import java.util.List;
import java.util.Map;

public class MyVisitedFragment extends PreloadFragment {
  private boolean A;
  
  private NoDataAndLoadFailView B;
  
  private BluedUIHttpResponse C = new BluedUIHttpResponse<BluedEntityA<BluedBlackList.privacySettingEntity>>(this, "my_privacy_setting", (IRequestHost)w_()) {
      private void c(BluedEntityA<BluedBlackList.privacySettingEntity> param1BluedEntityA) {
        MyVisitedFragment myVisitedFragment = this.a;
        List list = param1BluedEntityA.data;
        boolean bool = false;
        if (((BluedBlackList.privacySettingEntity)list.get(0)).is_traceless_access == 1)
          bool = true; 
        MyVisitedFragment.c(myVisitedFragment, bool);
        MyVisitedFragment.b(this.a).setChecked(MyVisitedFragment.a(this.a));
      }
      
      protected BluedEntityA<BluedBlackList.privacySettingEntity> a(String param1String) {
        return (BluedEntityA<BluedBlackList.privacySettingEntity>)super.parseData(param1String);
      }
      
      protected void a(BluedEntityA<BluedBlackList.privacySettingEntity> param1BluedEntityA) {
        super.onUICache((BluedEntity)param1BluedEntityA);
        c(param1BluedEntityA);
      }
      
      public void b(BluedEntityA<BluedBlackList.privacySettingEntity> param1BluedEntityA) {
        c(param1BluedEntityA);
      }
      
      public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
        super.onFailure(param1Throwable, param1Int, param1String);
      }
    };
  
  BluedUIHttpResponse o = new BluedUIHttpResponse<BluedEntityA<BluedMyVisitorList>>(this) {
      boolean a;
      
      public void a(BluedEntityA<BluedMyVisitorList> param1BluedEntityA) {
        if (param1BluedEntityA != null)
          try {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              if (param1BluedEntityA.hasMore()) {
                MyVisitedFragment.d(this.b, true);
                MyVisitedFragment.e(this.b).o();
              } else {
                MyVisitedFragment.d(this.b, false);
                MyVisitedFragment.e(this.b).p();
              } 
              if (MyVisitedFragment.f(this.b) == 1) {
                MyVisitedFragment.g(this.b).a(param1BluedEntityA.data, 0);
                return;
              } 
              MyVisitedFragment.g(this.b).b(param1BluedEntityA.data, 0);
              return;
            } 
            if (MyVisitedFragment.f(this.b) == 1)
              MyVisitedFragment.g(this.b).a(param1BluedEntityA.data, 0); 
            if (MyVisitedFragment.f(this.b) != 1) {
              MyVisitedFragment.h(this.b);
              MyVisitedFragment.d(this.b, false);
            } 
            MyVisitedFragment.e(this.b).p();
            AppMethods.a(MyVisitedFragment.c(this.b).getResources().getString(2131756083));
            return;
          } catch (Exception exception) {
            exception.printStackTrace();
            AppMethods.a(MyVisitedFragment.c(this.b).getResources().getString(2131756082));
            if (MyVisitedFragment.f(this.b) != 1)
              MyVisitedFragment.h(this.b); 
            return;
          }  
        if (MyVisitedFragment.f(this.b) == 1)
          MyVisitedFragment.g(this.b).a(((BluedEntityA)exception).data, 0); 
        if (MyVisitedFragment.f(this.b) != 1) {
          MyVisitedFragment.h(this.b);
          MyVisitedFragment.d(this.b, false);
        } 
        MyVisitedFragment.e(this.b).p();
        AppMethods.a(MyVisitedFragment.c(this.b).getResources().getString(2131756083));
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        if (MyVisitedFragment.f(this.b) != 1)
          MyVisitedFragment.h(this.b); 
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        MyVisitedFragment.e(this.b).j();
        MyVisitedFragment.e(this.b).q();
        if (MyVisitedFragment.g(this.b).getCount() == 0) {
          if (this.a) {
            MyVisitedFragment.i(this.b).b();
          } else {
            MyVisitedFragment.i(this.b).a();
          } 
        } else {
          MyVisitedFragment.i(this.b).c();
        } 
        MyVisitedFragment.g(this.b).notifyDataSetChanged();
        this.a = false;
      }
    };
  
  private Context p;
  
  private View q;
  
  private RenrenPullToRefreshListView r;
  
  private ListView s;
  
  private View t;
  
  private ToggleButton u;
  
  private boolean v;
  
  private LayoutInflater w;
  
  private VisitorListAdapter x;
  
  private int y;
  
  private boolean z = true;
  
  private void a(boolean paramBoolean) {
    String str;
    Map<String, String> map = BluedHttpTools.a();
    if (paramBoolean) {
      str = "1";
    } else {
      str = "0";
    } 
    map.put("is_traceless_access", str);
    ProfileHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)w_(), paramBoolean) {
          public void a(BluedEntityA<Object> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              AppMethods.a(AppInfo.d().getResources().getString(2131757808));
              if (this.a) {
                (BluedConfig.b().j()).is_traceless_access = 1;
              } else {
                (BluedConfig.b().j()).is_traceless_access = 0;
              } 
            } else {
              AppMethods.a(AppInfo.d().getResources().getString(2131756082));
            } 
            UserInfoDataObserver.a().b();
          }
        }UserInfo.a().i().getUid(), map);
  }
  
  private void b(boolean paramBoolean) {
    if (paramBoolean)
      this.y = 1; 
    if (this.y == 1)
      this.z = true; 
    if (!this.z) {
      int i = this.y;
      if (i != 1) {
        this.y = i - 1;
        AppMethods.a(this.p.getResources().getString(2131756083));
        this.r.j();
        this.r.q();
        return;
      } 
    } 
    Context context = this.p;
    BluedUIHttpResponse bluedUIHttpResponse = this.o;
    String str = UserInfo.a().i().getUid();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.y);
    stringBuilder.append("");
    MineHttpUtils.c(context, bluedUIHttpResponse, str, stringBuilder.toString(), "20", (IRequestHost)w_());
  }
  
  private void u() {
    this.w = LayoutInflater.from(this.p);
    this.r = (RenrenPullToRefreshListView)this.q.findViewById(2131298144);
    this.r.setRefreshEnabled(true);
    this.s = (ListView)this.r.getRefreshableView();
    this.s.setClipToPadding(false);
    this.s.setScrollBarStyle(33554432);
    this.s.setHeaderDividersEnabled(false);
    this.s.setDividerHeight(0);
    this.t = this.w.inflate(2131493775, null);
    this.u = (ToggleButton)this.t.findViewById(2131300243);
    this.u.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if ((UserInfo.a().i()).vip_grade != 2 && !MyVisitedFragment.a(this.a)) {
              MyVisitedFragment.b(this.a).setChecked(false);
              PayUtils.a(MyVisitedFragment.c(this.a), 11, "visit_page_no_trace_visit");
            } else if (MyVisitedFragment.b(this.a).isChecked()) {
              MyVisitedFragment.a(this.a, true);
            } else {
              MyVisitedFragment.a(this.a, false);
            } 
            EventTrackVIP.b(VipProtos.Event.VISIT_PAGE_NO_TRACE_BTN_CLICK, MyVisitedFragment.b(this.a).isChecked());
          }
        });
    this.s.addHeaderView(this.t);
    this.x = new VisitorListAdapter(this.p, (IRequestHost)w_());
    this.s.setAdapter((ListAdapter)this.x);
    this.B = new NoDataAndLoadFailView(this.p);
    this.B.setNoDataImg(2131232637);
    this.B.setNoDataStr(2131758233);
    this.s.setEmptyView((View)this.B);
    this.r.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener(this) {
          public void a() {
            MyVisitedFragment.a(this.a, 1);
            MyVisitedFragment.b(this.a, false);
            this.a.t();
          }
          
          public void b() {
            MyVisitedFragment.d(this.a);
            MyVisitedFragment.b(this.a, false);
          }
        });
    t();
  }
  
  public void a(View paramView) {
    this.p = (Context)getActivity();
    this.q = paramView;
    this.w = LayoutInflater.from(this.p);
    View view = this.w.inflate(2131493364, null);
    ((ViewGroup)paramView).addView(view);
    u();
    EventTrackGuy.b(GuyProtos.Event.NEARBY_VISIT_LOOK_SHOW);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean && !this.A) {
      RenrenPullToRefreshListView renrenPullToRefreshListView = this.r;
      if (renrenPullToRefreshListView != null) {
        renrenPullToRefreshListView.k();
        this.A = true;
      } 
    } 
  }
  
  public void t() {
    ProfileHttpUtils.a(this.p, this.C, UserInfo.a().i().getUid(), (IRequestHost)w_());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\MyVisitedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */