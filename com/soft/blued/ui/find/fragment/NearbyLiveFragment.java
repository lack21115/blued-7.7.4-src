package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.live_china.observer.LiveListPositionObserver;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.discover.observer.LiveListSetSelectedTab;
import com.soft.blued.ui.find.adapter.NearbyLiveAdapter;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.live.model.BluedLiveListData;

public class NearbyLiveFragment extends BaseFragment implements LiveListPositionObserver.ILiveListPositionObserver {
  public boolean d;
  
  public int e;
  
  public int f;
  
  public NoDataAndLoadFailView g;
  
  public boolean h;
  
  BluedUIHttpResponse i = new BluedUIHttpResponse<BluedEntityA<BluedLiveListData>>(this) {
      public void a(BluedEntityA<BluedLiveListData> param1BluedEntityA) {
        try {
          if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
            if (param1BluedEntityA.extra != null && param1BluedEntityA.hasMore()) {
              this.a.d = true;
              NearbyLiveFragment.a(this.a).o();
            } else {
              NearbyLiveFragment.a(this.a).p();
              this.a.d = false;
            } 
            if (this.a.e == 1) {
              NearbyLiveFragment.c(this.a).b(param1BluedEntityA.data);
            } else {
              NearbyLiveFragment.c(this.a).a(param1BluedEntityA.data);
            } 
            if (!this.a.d) {
              NearbyLiveFragment.c(this.a).a();
              return;
            } 
          } else if (this.a.e != 1) {
            NearbyLiveFragment nearbyLiveFragment = this.a;
            nearbyLiveFragment.e--;
            AppMethods.a(NearbyLiveFragment.b(this.a).getResources().getString(2131756083));
            return;
          } 
        } catch (Exception exception) {
          if (this.a.e != 1) {
            NearbyLiveFragment nearbyLiveFragment = this.a;
            nearbyLiveFragment.e--;
          } 
        } 
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a.h = true;
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        NearbyLiveFragment.d(this.a).setEmptyView((View)this.a.g);
        NearbyLiveFragment.a(this.a).j();
        NearbyLiveFragment.a(this.a).q();
        if (this.a.h) {
          this.a.g.b();
        } else if (NearbyLiveFragment.c(this.a).getCount() == 0) {
          this.a.g.a();
        } 
        NearbyLiveFragment.c(this.a).notifyDataSetChanged();
        this.a.h = false;
      }
    };
  
  private Context j;
  
  private View k;
  
  private CommonTopTitleNoTrans l;
  
  private RenrenPullToRefreshListView m;
  
  private NearbyLiveAdapter n;
  
  private ListView o;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, NearbyLiveFragment.class, null);
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.e = 1;
    } else if (this.d) {
      this.e++;
    } else {
      return;
    } 
    LiveHttpUtils.a(this.i, (IRequestHost)w_(), this.e);
  }
  
  public void a() {
    this.g = new NoDataAndLoadFailView(this.j);
    this.g.setNoDataStr(2131758248);
    this.m = (RenrenPullToRefreshListView)this.k.findViewById(2131298144);
    this.o = (ListView)this.m.getRefreshableView();
    this.m.setRefreshEnabled(true);
    this.o.setClipToPadding(false);
    this.o.setScrollBarStyle(33554432);
    this.o.setHeaderDividersEnabled(false);
    this.o.setDividerHeight(0);
    this.n = new NearbyLiveAdapter(this.j, (IRequestHost)w_());
    this.o.setAdapter((ListAdapter)this.n);
    this.m.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener(this) {
          public void a() {
            NearbyLiveFragment.a(this.a, true);
          }
          
          public void b() {
            NearbyLiveFragment.a(this.a, false);
          }
        });
    this.m.postDelayed(new Runnable(this) {
          public void run() {
            NearbyLiveFragment.a(this.a).k();
          }
        },  100L);
  }
  
  public void a(int paramInt, long paramLong) {
    if (paramInt != -1) {
      paramInt = (int)Math.floor((paramInt / 3.0F));
      this.o.setSelectionFromTop(paramInt + 1, 0);
    } 
  }
  
  public void k() {
    this.l = (CommonTopTitleNoTrans)this.k.findViewById(2131300273);
    this.l.setCenterText(this.j.getResources().getString(2131759223));
    this.l.setRightText(this.j.getResources().getString(2131755130));
    this.l.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    this.l.setRightClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            LiveListPositionObserver.a().b(this.a);
            InstantLog.a("live_nearby_hot");
            HomeArgumentHelper.a(NearbyLiveFragment.b(this.a), "live", null);
            this.a.a(new Runnable(this) {
                  public void run() {
                    LiveListSetSelectedTab.a().a(1);
                  }
                },  300L);
          }
        });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.j = (Context)getActivity();
    this.f = 60;
    View view = this.k;
    if (view == null) {
      this.k = paramLayoutInflater.inflate(2131493251, paramViewGroup, false);
      LiveListPositionObserver.a().a(this);
      a();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.k.getParent()).removeView(this.k);
    } 
    return this.k;
  }
  
  public void onDestroy() {
    LiveListPositionObserver.a().b(this);
    super.onDestroy();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\NearbyLiveFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */