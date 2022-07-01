package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveRankGuestListItemAdapter;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.model.BluedLiveRankListData;
import com.blued.android.module.live_china.model.LiveConsumeAllEntity;
import com.blued.android.module.live_china.model.LiveConsumeEntity;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;
import java.util.List;

public class LiveRankGuestFragment extends BaseFragment {
  public static String d = "ISCOMEHOT";
  
  public static String e = "LID";
  
  public static String f = "IF_USER_ANCHOR";
  
  private boolean A;
  
  private boolean B;
  
  private boolean C;
  
  private boolean D;
  
  private ProgressBar E;
  
  public BluedUIHttpResponse g = new BluedUIHttpResponse<LiveConsumeEntity<BluedLiveRankListData>>(this, (IRequestHost)w_()) {
      public void a(LiveConsumeEntity<BluedLiveRankListData> param1LiveConsumeEntity) {
        if (param1LiveConsumeEntity.data != null && param1LiveConsumeEntity.data.size() > 0) {
          LiveRankGuestFragment.a(this.a).setVisibility(0);
          if (param1LiveConsumeEntity.hasMore()) {
            LiveRankGuestFragment.a(this.a, true);
            LiveRankGuestFragment.a(this.a).o();
          } else {
            LiveRankGuestFragment.a(this.a, false);
            LiveRankGuestFragment.a(this.a).p();
          } 
          if (LiveRankGuestFragment.c(this.a) == 1) {
            LiveRankGuestFragment.d(this.a).setVisibility(4);
            LiveRankGuestFragment.e(this.a).clear();
          } 
          LiveRankGuestFragment.e(this.a).addAll(param1LiveConsumeEntity.data);
          LiveRankGuestFragment.f(this.a).notifyDataSetChanged();
        } else {
          if (LiveRankGuestFragment.c(this.a) == 1) {
            LiveRankGuestFragment.a(this.a).setVisibility(4);
            LiveRankGuestFragment.d(this.a).setVisibility(0);
            LiveRankGuestFragment.e(this.a).clear();
            LiveRankGuestFragment.f(this.a).notifyDataSetChanged();
          } 
          if (LiveRankGuestFragment.c(this.a) != 1)
            LiveRankGuestFragment.g(this.a); 
          LiveRankGuestFragment.a(this.a).p();
        } 
        LiveRankGuestFragment.h(this.a).setVisibility(4);
      }
      
      public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
        super.onFailure(param1Throwable, param1Int, param1String);
        if (LiveRankGuestFragment.c(this.a) == 1)
          AppInfo.n().post(new Runnable(this) {
                public void run() {
                  LiveRankGuestFragment.h(this.a.a).setVisibility(0);
                  LiveRankGuestFragment.d(this.a.a).setVisibility(4);
                  LiveRankGuestFragment.a(this.a.a).setVisibility(4);
                }
              }); 
      }
      
      public void onUIFinish() {
        LiveRankGuestFragment.a(this.a).j();
        LiveRankGuestFragment.a(this.a).q();
        LiveRankGuestFragment.i(this.a).setVisibility(8);
      }
      
      public void onUIStart() {}
    };
  
  public BluedUIHttpResponse h = new BluedUIHttpResponse<LiveConsumeAllEntity<BluedLiveRankListData>>(this, (IRequestHost)w_()) {
      public void a(LiveConsumeAllEntity<BluedLiveRankListData> param1LiveConsumeAllEntity) {
        if (param1LiveConsumeAllEntity.data != null && param1LiveConsumeAllEntity.data.size() > 0) {
          LiveRankGuestFragment.a(this.a).setVisibility(0);
          if (param1LiveConsumeAllEntity.hasMore()) {
            LiveRankGuestFragment.a(this.a, true);
            LiveRankGuestFragment.a(this.a).o();
          } else {
            LiveRankGuestFragment.a(this.a, false);
            LiveRankGuestFragment.a(this.a).p();
          } 
          if (LiveRankGuestFragment.c(this.a) == 1) {
            LiveRankGuestFragment.d(this.a).setVisibility(4);
            LiveRankGuestFragment.e(this.a).clear();
          } 
          LiveRankGuestFragment.e(this.a).addAll(param1LiveConsumeAllEntity.data);
          LiveRankGuestFragment.f(this.a).notifyDataSetChanged();
        } else {
          if (LiveRankGuestFragment.c(this.a) == 1) {
            LiveRankGuestFragment.e(this.a).clear();
            LiveRankGuestFragment.f(this.a).notifyDataSetChanged();
            LiveRankGuestFragment.a(this.a).setVisibility(4);
            LiveRankGuestFragment.d(this.a).setVisibility(0);
          } 
          if (LiveRankGuestFragment.c(this.a) != 1)
            LiveRankGuestFragment.g(this.a); 
          LiveRankGuestFragment.a(this.a).p();
        } 
        LiveRankGuestFragment.h(this.a).setVisibility(4);
      }
      
      public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
        super.onFailure(param1Throwable, param1Int, param1String);
        if (LiveRankGuestFragment.c(this.a) == 1)
          AppInfo.n().post(new Runnable(this) {
                public void run() {
                  LiveRankGuestFragment.h(this.a.a).setVisibility(0);
                  LiveRankGuestFragment.d(this.a.a).setVisibility(4);
                  LiveRankGuestFragment.a(this.a.a).setVisibility(4);
                }
              }); 
      }
      
      public void onUIFinish() {
        LiveRankGuestFragment.a(this.a).j();
        LiveRankGuestFragment.a(this.a).q();
        LiveRankGuestFragment.i(this.a).setVisibility(8);
      }
      
      public void onUIStart() {}
    };
  
  private String i = LiveRankGuestFragment.class.getSimpleName();
  
  private View j;
  
  private Context k;
  
  private List<BluedLiveRankListData> l;
  
  private RenrenPullToRefreshListView m;
  
  private LayoutInflater n;
  
  private View o;
  
  private ListView p;
  
  private LiveRankGuestListItemAdapter q;
  
  private View r;
  
  private LinearLayout s;
  
  private TextView t;
  
  private String[] u = new String[2];
  
  private int v = 1;
  
  private boolean w = true;
  
  private long x;
  
  private long y;
  
  private String z;
  
  private void k() {
    if (getArguments() != null) {
      this.B = getArguments().getBoolean(d);
      this.z = getArguments().getString("UID");
      this.y = getArguments().getLong(e);
      this.A = getArguments().getBoolean(f);
    } 
  }
  
  private void l() {
    this.n = (LayoutInflater)this.k.getSystemService("layout_inflater");
    this.o = this.n.inflate(R.layout.fragment_live_list_header, null);
    this.E = (ProgressBar)this.j.findViewById(R.id.loading_view);
    this.l = new ArrayList<BluedLiveRankListData>();
    this.m = (RenrenPullToRefreshListView)this.j.findViewById(R.id.rptrlv_live_list);
    this.m.setRefreshEnabled(false);
    if (this.C) {
      this.D = true;
      this.m.postDelayed(new Runnable(this) {
            public void run() {
              LiveRankGuestFragment.a(this.a).k();
            }
          },  100L);
    } 
    this.m.setOnPullDownListener(new MyPullDownListener());
    this.p = (ListView)this.m.getRefreshableView();
    this.p.setDivider(null);
    this.p.setSelector((Drawable)new ColorDrawable(0));
    this.s = (LinearLayout)this.j.findViewById(R.id.ll_nodata_error);
    this.t = (TextView)this.j.findViewById(R.id.tv_live_reload);
    this.t.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            LiveRankGuestFragment.a(this.a, 1);
            this.a.a();
          }
        });
    this.r = this.j.findViewById(R.id.ll_nodata_rank);
    this.q = new LiveRankGuestListItemAdapter((Fragment)this, this.l, this.A, this.B, (IRequestHost)w_());
    this.p.setAdapter((ListAdapter)this.q);
  }
  
  public void a() {
    if (this.v == 1)
      this.w = true; 
    if (!this.w) {
      int i = this.v;
      if (i != 1) {
        this.v = i - 1;
        AppMethods.a(this.k.getResources().getString(R.string.common_nomore_data));
        this.m.j();
        return;
      } 
    } 
    if (this.B) {
      LiveRoomHttpUtils.a(this.k, this.z, this.y, this.v, this.g, (IRequestHost)w_());
      return;
    } 
    LiveRoomHttpUtils.a(this.k, this.z, this.y, "month", this.v, this.h, (IRequestHost)w_());
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.k = (Context)getActivity();
    View view = this.j;
    if (view == null) {
      int i;
      if (LiveFloatManager.a().B()) {
        i = R.layout.fragment_live_rank_list_guest_land;
      } else {
        i = R.layout.fragment_live_rank_list_guest;
      } 
      this.j = paramLayoutInflater.inflate(i, paramViewGroup, false);
      k();
      l();
      this.x = 0L;
    } else if (view.getParent() != null) {
      ((ViewGroup)this.j.getParent()).removeView(this.j);
    } 
    return this.j;
  }
  
  public void onPause() {
    super.onPause();
    this.x = System.currentTimeMillis();
  }
  
  public void onResume() {
    super.onResume();
    if (this.C && this.x != 0L) {
      if (System.currentTimeMillis() - this.x > 300000L)
        this.m.setRefreshing(true); 
      this.x = 0L;
    } 
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    this.C = paramBoolean;
    if (!this.D && this.C && this.j != null) {
      this.D = true;
      this.m.setRefreshing(true);
    } 
  }
  
  class MyPullDownListener implements RenrenPullToRefreshListView.OnPullDownListener {
    private MyPullDownListener(LiveRankGuestFragment this$0) {}
    
    public void a() {
      LiveRankGuestFragment.a(this.a, 1);
      this.a.a();
    }
    
    public void b() {
      LiveRankGuestFragment.b(this.a);
      this.a.a();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveRankGuestFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */