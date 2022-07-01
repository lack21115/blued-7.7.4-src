package com.soft.blued.ui.discover.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.model.BluedMyExtra;
import com.soft.blued.ui.feed.manager.FeedMethods;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.adapter.PeopleListQuickAdapter;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.find.observer.SetModelObserver;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import java.util.ArrayList;

public class NearbyModuleUsersFragment extends BaseFragment implements SetModelObserver.ISetModelObserver {
  public static String e = "module_cid";
  
  public static String f = "module_tips";
  
  private String A;
  
  private CommonTopTitleNoTrans B;
  
  public int d = 0;
  
  public int g;
  
  public String h;
  
  public NoDataAndLoadFailView i;
  
  public NoDataAndLoadFailView j;
  
  public boolean k;
  
  BluedUIHttpResponse l = new BluedUIHttpResponse<BluedEntity<UserFindResult, BluedMyExtra>>(this, (IRequestHost)w_()) {
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a.k = true;
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        NearbyModuleUsersFragment.f(this.a).e((View)this.a.j);
        NearbyModuleUsersFragment.c(this.a).e((View)this.a.i);
        NearbyModuleUsersFragment.a(this.a).j();
        NearbyModuleUsersFragment.f(this.a).l();
        NearbyModuleUsersFragment.c(this.a).l();
        NearbyModuleUsersFragment.d(this.a).j();
        if (this.a.k) {
          this.a.j.b();
          this.a.i.b();
        } else if (NearbyModuleUsersFragment.c(this.a).getItemCount() == 0 || NearbyModuleUsersFragment.f(this.a).getItemCount() == 0) {
          this.a.j.a();
          this.a.i.a();
        } 
        NearbyModuleUsersFragment.c(this.a).notifyDataSetChanged();
        NearbyModuleUsersFragment.f(this.a).notifyDataSetChanged();
        this.a.k = false;
      }
      
      public void onUIUpdate(BluedEntity<UserFindResult, BluedMyExtra> param1BluedEntity) {
        if (param1BluedEntity.hasMore()) {
          NearbyModuleUsersFragment.b(this.a, true);
          NearbyModuleUsersFragment.c(this.a).c(true);
          NearbyModuleUsersFragment.f(this.a).c(true);
        } else {
          NearbyModuleUsersFragment.c(this.a).c(false);
          NearbyModuleUsersFragment.f(this.a).c(false);
          NearbyModuleUsersFragment.b(this.a, false);
        } 
        if (param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
          if (NearbyModuleUsersFragment.g(this.a) == 1) {
            NearbyModuleUsersFragment.c(this.a).c(param1BluedEntity.data);
            NearbyModuleUsersFragment.f(this.a).c(param1BluedEntity.data);
          } else {
            NearbyModuleUsersFragment.c(this.a).a(param1BluedEntity.data);
            NearbyModuleUsersFragment.f(this.a).a(param1BluedEntity.data);
          } 
          if (param1BluedEntity.extra != null) {
            NearbyModuleUsersFragment.a(this.a, ((BluedMyExtra)param1BluedEntity.extra).getNext_min_dist());
            NearbyModuleUsersFragment.b(this.a, ((BluedMyExtra)param1BluedEntity.extra).getNext_skip_uid());
            return;
          } 
        } else if (NearbyModuleUsersFragment.g(this.a) != 1) {
          NearbyModuleUsersFragment.h(this.a);
          AppMethods.a(NearbyModuleUsersFragment.i(this.a).getResources().getString(2131756083));
        } 
      }
      
      public BluedEntity<UserFindResult, BluedMyExtra> parseData(String param1String) {
        BluedEntity<UserFindResult, BluedMyExtra> bluedEntity = super.parseData(param1String);
        if (bluedEntity != null)
          for (int i = 0; i < bluedEntity.data.size(); i++) {
            UserBasicModel userBasicModel = bluedEntity.data.get(i);
            userBasicModel.last_operate = TimeAndDateUtils.a(NearbyModuleUsersFragment.i(this.a), TimeAndDateUtils.b(userBasicModel.last_operate));
            userBasicModel.distance = DistanceUtils.a(userBasicModel.distance, BlueAppLocal.c(), false);
          }  
        return bluedEntity;
      }
    };
  
  private Context m;
  
  private View n;
  
  private ViewFlipper o;
  
  private PullToRefreshRecyclerView p;
  
  private RecyclerView q;
  
  private PeopleGridQuickAdapter r;
  
  private int s;
  
  private PullToRefreshRecyclerView t;
  
  private RecyclerView u;
  
  private PeopleListQuickAdapter v;
  
  private int w = 60;
  
  private int x = 1;
  
  private boolean y = false;
  
  private String z;
  
  private void a() {
    this.s = PeopleGridQuickAdapter.a(this.m);
    this.i = new NoDataAndLoadFailView(this.m);
    this.j = new NoDataAndLoadFailView(this.m);
    this.o = (ViewFlipper)this.n.findViewById(2131301615);
    this.o.setInAnimation(AnimationUtils.loadAnimation(this.m, 2130772059));
    this.o.setOutAnimation(AnimationUtils.loadAnimation(this.m, 2130772060));
    if (BluedPreferences.I() == 0) {
      this.o.setDisplayedChild(0);
      this.d = 0;
      this.B.setRightImg(2131232589);
      return;
    } 
    this.o.setDisplayedChild(1);
    this.d = 1;
    this.B.setRightImg(2131232588);
  }
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, NearbyModuleUsersFragment.class, null);
  }
  
  public static void a(Context paramContext, int paramInt, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putInt(e, paramInt);
    bundle.putString(f, paramString);
    TerminalActivity.d(paramContext, NearbyModuleUsersFragment.class, bundle);
  }
  
  private void a(boolean paramBoolean) {
    FilterEntity filterEntity = new FilterEntity();
    filterEntity.longitude = BluedPreferences.s();
    filterEntity.sort_by = "detail";
    filterEntity.latitude = BluedPreferences.t();
    filterEntity.nickName = "";
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.w);
    stringBuilder1.append("");
    filterEntity.limit = stringBuilder1.toString();
    filterEntity.source = "nearby";
    filterEntity.cid = this.g;
    filterEntity.column = PeopleGridQuickAdapter.a(this.m);
    String str = FeedMethods.a(this.m, 1);
    if (paramBoolean) {
      this.x = 1;
    } else if (this.y) {
      this.x++;
      filterEntity.next_min_dist = this.z;
      filterEntity.next_skip_uid = this.A;
    } else {
      return;
    } 
    int i = this.w;
    int j = this.x;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(i * (j - 1));
    stringBuilder2.append("");
    filterEntity.start = stringBuilder2.toString();
    NearbyHttpUtils.b((Context)getActivity(), this.l, filterEntity, str, (IRequestHost)w_());
  }
  
  private void k() {
    this.p = (PullToRefreshRecyclerView)this.n.findViewById(2131297262);
    this.q = (RecyclerView)this.p.getRefreshableView();
    this.p.setRefreshEnabled(true);
    this.q.setClipToPadding(false);
    this.q.setScrollBarStyle(33554432);
    if (this.d == 0)
      this.p.postDelayed(new Runnable(this) {
            public void run() {
              NearbyModuleUsersFragment.a(this.a).k();
            }
          },  100L); 
    this.p.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>(this) {
          public void a(PullToRefreshBase<RecyclerView> param1PullToRefreshBase) {
            NearbyModuleUsersFragment.a(this.a, true);
          }
        });
    ArrayList arrayList = new ArrayList();
    FragmentActivity fragmentActivity = getActivity();
    ActivityFragmentActive activityFragmentActive = w_();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("module_detail");
    stringBuilder.append(this.g);
    this.r = new PeopleGridQuickAdapter(arrayList, (Activity)fragmentActivity, (IRequestHost)activityFragmentActive, stringBuilder.toString(), this.q);
    this.q.setAdapter((RecyclerView.Adapter)this.r);
    this.r.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            NearbyModuleUsersFragment.a(this.a, false);
          }
        }this.q);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.m, this.s);
    this.q.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(this) {
          public int getSpanSize(int param1Int) {
            int i = NearbyModuleUsersFragment.b(this.c);
            if (NearbyModuleUsersFragment.c(this.c).e(param1Int) != null) {
              param1Int = NearbyModuleUsersFragment.c(this.c).getItemViewType(param1Int);
              if (param1Int != 10)
                return (param1Int != 11) ? NearbyModuleUsersFragment.b(this.c) : NearbyModuleUsersFragment.b(this.c); 
              i = 1;
            } 
            return i;
          }
        });
  }
  
  private void l() {
    this.t = (PullToRefreshRecyclerView)this.n.findViewById(2131298144);
    this.u = (RecyclerView)this.t.getRefreshableView();
    this.t.setRefreshEnabled(true);
    this.u.setClipToPadding(false);
    this.u.setScrollBarStyle(33554432);
    if (this.d == 1)
      this.t.postDelayed(new Runnable(this) {
            public void run() {
              NearbyModuleUsersFragment.d(this.a).k();
            }
          },  100L); 
    this.t.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>(this) {
          public void a(PullToRefreshBase<RecyclerView> param1PullToRefreshBase) {
            NearbyModuleUsersFragment.a(this.a, true);
          }
        });
    ArrayList arrayList = new ArrayList();
    FragmentActivity fragmentActivity = getActivity();
    ActivityFragmentActive activityFragmentActive = w_();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("module_detail");
    stringBuilder.append(this.g);
    this.v = new PeopleListQuickAdapter(arrayList, (Activity)fragmentActivity, (IRequestHost)activityFragmentActive, stringBuilder.toString(), this.u);
    this.v.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            NearbyModuleUsersFragment.a(this.a, false);
          }
        }this.u);
    this.u.setAdapter((RecyclerView.Adapter)this.v);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.m, 1);
    this.u.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
  }
  
  private void m() {
    this.B = (CommonTopTitleNoTrans)this.n.findViewById(2131300273);
    this.B.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    this.B.setCenterText(this.h);
    this.B.setRightClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            int i = this.a.d;
            boolean bool = true;
            if (i == 0) {
              BluedPreferences.a(1);
              NearbyModuleUsersFragment.e(this.a).setRightImg(2131232588);
            } else {
              BluedPreferences.a(0);
              NearbyModuleUsersFragment.e(this.a).setRightImg(2131232589);
              bool = false;
            } 
            SetModelObserver.a().a(bool);
          }
        });
  }
  
  public void a(int paramInt) {
    if (paramInt != this.d) {
      ViewFlipper viewFlipper = this.o;
      if (viewFlipper != null)
        viewFlipper.showNext(); 
    } 
    this.d = paramInt;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.m = (Context)getActivity();
    View view = this.n;
    if (view == null) {
      this.g = 3;
      this.h = this.m.getResources().getString(2131757837);
      this.n = paramLayoutInflater.inflate(2131493155, paramViewGroup, false);
      Bundle bundle = getArguments();
      if (bundle != null) {
        this.g = bundle.getInt(e);
        this.h = bundle.getString(f);
      } 
      m();
      a();
      k();
      l();
      SetModelObserver.a().a(this);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.n.getParent()).removeView(this.n);
    } 
    return this.n;
  }
  
  public void onDestroy() {
    super.onDestroy();
    SetModelObserver.a().b(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\fragment\NearbyModuleUsersFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */