package com.soft.blued.ui.find.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.PauseOnScrollListener;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.adapter.PeopleListQuickAdapter;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.find.model.FindDataExtra;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.find.observer.FloatRedBagViewScrollObserver;
import com.soft.blued.ui.find.observer.HomeADDataObserver;
import com.soft.blued.ui.find.observer.PeopleDataObserver;
import com.soft.blued.ui.find.observer.SetModelObserver;
import com.soft.blued.ui.find.observer.SwipeRefreshObserver;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import java.util.ArrayList;

public class NearbyPeopleTabPageFragment extends BaseFragment implements PeopleDataObserver.IFriendsDataRefreshObserver, SetModelObserver.ISetModelObserver {
  public Context d;
  
  public View e;
  
  public String f = "nearby";
  
  protected PullToRefreshRecyclerView g;
  
  protected PullToRefreshRecyclerView h;
  
  protected RecyclerView i;
  
  protected RecyclerView j;
  
  public PeopleGridQuickAdapter k;
  
  public int l;
  
  public ViewFlipper m;
  
  public boolean n;
  
  public NoDataAndLoadFailView o;
  
  public PauseOnScrollListener p;
  
  public ShapeTextView q;
  
  public NestedScrollView r;
  
  public float s;
  
  public float t;
  
  private PeopleListQuickAdapter u;
  
  private int v;
  
  private FilterEntity w = new FilterEntity();
  
  private int x = 1;
  
  private int y = 60;
  
  private boolean z;
  
  public String X_() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial X_ : ()Ljava/lang/String;
    //   4: astore_2
    //   5: aload_0
    //   6: getfield f : Ljava/lang/String;
    //   9: astore_3
    //   10: aload_3
    //   11: invokevirtual hashCode : ()I
    //   14: istore_1
    //   15: iload_1
    //   16: ldc -1049482625
    //   18: if_icmpeq -> 64
    //   21: iload_1
    //   22: ldc -1048842402
    //   24: if_icmpeq -> 50
    //   27: iload_1
    //   28: ldc -1012222381
    //   30: if_icmpeq -> 36
    //   33: goto -> 78
    //   36: aload_3
    //   37: ldc 'online'
    //   39: invokevirtual equals : (Ljava/lang/Object;)Z
    //   42: ifeq -> 78
    //   45: iconst_1
    //   46: istore_1
    //   47: goto -> 80
    //   50: aload_3
    //   51: ldc 'newbie'
    //   53: invokevirtual equals : (Ljava/lang/Object;)Z
    //   56: ifeq -> 78
    //   59: iconst_2
    //   60: istore_1
    //   61: goto -> 80
    //   64: aload_3
    //   65: ldc 'nearby'
    //   67: invokevirtual equals : (Ljava/lang/Object;)Z
    //   70: ifeq -> 78
    //   73: iconst_0
    //   74: istore_1
    //   75: goto -> 80
    //   78: iconst_m1
    //   79: istore_1
    //   80: iload_1
    //   81: ifeq -> 102
    //   84: iload_1
    //   85: iconst_1
    //   86: if_icmpeq -> 99
    //   89: iload_1
    //   90: iconst_2
    //   91: if_icmpeq -> 96
    //   94: aload_2
    //   95: areturn
    //   96: ldc 'A33'
    //   98: areturn
    //   99: ldc 'A32'
    //   101: areturn
    //   102: ldc 'A31'
    //   104: areturn
  }
  
  public void a() {
    if (getArguments() != null)
      this.f = getArguments().getString("KEY_SORT_BY"); 
    if (StringUtils.e(this.f))
      this.f = "nearby"; 
    k();
    this.r = (NestedScrollView)this.e.findViewById(2131299366);
    this.m = (ViewFlipper)this.e.findViewById(2131301615);
    this.o = (NoDataAndLoadFailView)this.e.findViewById(2131299395);
    this.o.setBackgroundColorRes(2131100528);
    this.q = (ShapeTextView)this.e.findViewById(2131301245);
    this.q.setVisibility(8);
    l();
    n();
    this.v = BluedPreferences.I();
    a(this.v);
    o().refresh();
  }
  
  public void a(int paramInt) {
    this.v = paramInt;
    if (this.v == 0) {
      this.m.setDisplayedChild(0);
      this.w.if_grid = true;
      return;
    } 
    this.m.setDisplayedChild(1);
    this.w.if_grid = false;
  }
  
  public void a(RecyclerView paramRecyclerView) {
    if (c(paramRecyclerView) && !this.z)
      AppMethods.a(this.d.getResources().getString(2131758247)); 
  }
  
  public void a(BluedEntity<UserFindResult, FindDataExtra> paramBluedEntity, boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(String paramString) {}
  
  public void a(boolean paramBoolean) {
    String str;
    if (paramBoolean)
      this.x = 1; 
    int i = this.y;
    int j = this.x;
    FilterEntity filterEntity2 = this.w;
    filterEntity2.sort_by = this.f;
    filterEntity2.longitude = BluedPreferences.s();
    this.w.latitude = BluedPreferences.t();
    filterEntity2 = this.w;
    filterEntity2.nickName = "";
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.y);
    stringBuilder2.append("");
    filterEntity2.limit = stringBuilder2.toString();
    filterEntity2 = this.w;
    filterEntity2.column = this.l;
    filterEntity2.scroll_type = BluedPreferences.C();
    FilterEntity filterEntity3 = this.w;
    if (UserInfo.a().i() == null) {
      str = "";
    } else {
      str = UserInfo.a().i().getCustom();
    } 
    filterEntity3.custom = str;
    FilterEntity filterEntity1 = this.w;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(i * (j - 1));
    stringBuilder1.append("");
    filterEntity1.start = stringBuilder1.toString();
    BluedUIHttpResponse bluedUIHttpResponse = o();
    NearbyHttpUtils.a(this.d, bluedUIHttpResponse, this.w, "", (IRequestHost)w_());
  }
  
  public View.OnTouchListener b(RecyclerView paramRecyclerView) {
    return new View.OnTouchListener(this, paramRecyclerView) {
        public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
          int i = param1MotionEvent.getAction();
          if (i != 0) {
            if (i == 1) {
              this.b.t = param1MotionEvent.getY();
              if (this.a != null && this.b.t >= this.b.s && !this.a.canScrollVertically(-1))
                this.a.stopScroll(); 
            } 
          } else {
            this.b.s = param1MotionEvent.getY();
          } 
          return false;
        }
      };
  }
  
  protected boolean c(RecyclerView paramRecyclerView) {
    boolean bool = false;
    if (paramRecyclerView == null)
      return false; 
    if (paramRecyclerView.computeVerticalScrollExtent() + paramRecyclerView.computeVerticalScrollOffset() >= paramRecyclerView.computeVerticalScrollRange())
      bool = true; 
    return bool;
  }
  
  public void k() {
    this.l = PeopleGridQuickAdapter.a(this.d);
  }
  
  public void l() {
    this.g = (PullToRefreshRecyclerView)this.e.findViewById(2131297289);
    this.g.setRefreshEnabled(false);
    this.i = (RecyclerView)this.g.getRefreshableView();
    this.i.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
          public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
            this.a.p.onScrollStateChanged(null, param1Int);
            super.onScrollStateChanged(param1RecyclerView, param1Int);
          }
          
          public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
            super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
            FloatRedBagViewScrollObserver.a().a(param1RecyclerView, param1Int1, param1Int2);
            this.a.a(param1RecyclerView);
          }
        });
    RecyclerView recyclerView = this.i;
    recyclerView.setOnTouchListener(b(recyclerView));
    m();
    this.k.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            NearbyPeopleTabPageFragment.a(this.a);
            this.a.a(false);
          }
        },  this.i);
    this.i.setAdapter((RecyclerView.Adapter)this.k);
  }
  
  public void m() {
    this.k = new PeopleGridQuickAdapter(new ArrayList(), (Activity)getActivity(), (IRequestHost)w_(), this.f, this.i);
  }
  
  public void n() {
    this.h = (PullToRefreshRecyclerView)this.e.findViewById(2131298144);
    this.h.setRefreshEnabled(false);
    this.j = (RecyclerView)this.h.getRefreshableView();
    this.j.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
          public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
            this.a.p.onScrollStateChanged(null, param1Int);
            super.onScrollStateChanged(param1RecyclerView, param1Int);
          }
          
          public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
            super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
            FloatRedBagViewScrollObserver.a().a(param1RecyclerView, param1Int1, param1Int2);
            if (this.a.c(param1RecyclerView) && !NearbyPeopleTabPageFragment.b(this.a))
              AppMethods.a(this.a.d.getResources().getString(2131758247)); 
          }
        });
    RecyclerView recyclerView = this.j;
    recyclerView.setOnTouchListener(b(recyclerView));
    this.u = new PeopleListQuickAdapter(new ArrayList(), (Activity)getActivity(), (IRequestHost)w_(), this.f, this.j);
    this.u.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            NearbyPeopleTabPageFragment.a(this.a);
            this.a.a(false);
          }
        },  this.j);
    this.j.setAdapter((RecyclerView.Adapter)this.u);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.d, 1);
    this.j.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
  }
  
  public BluedUIHttpResponse o() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("nearby_user_");
    stringBuilder.append(this.f);
    return new BluedUIHttpResponse<BluedEntity<UserFindResult, FindDataExtra>>(this, stringBuilder.toString(), (IRequestHost)w_()) {
        boolean a = false;
        
        public void onUICache(BluedEntity<UserFindResult, FindDataExtra> param1BluedEntity) {
          super.onUICache(param1BluedEntity);
          this.b.a(param1BluedEntity, true);
        }
        
        public boolean onUIFailure(int param1Int, String param1String) {
          this.a = true;
          return super.onUIFailure(param1Int, param1String);
        }
        
        public void onUIFinish() {
          this.b.i.stopScroll();
          this.b.j.stopScroll();
          if (this.a) {
            if (this.b.k.getItemCount() == 0) {
              this.b.m.setVisibility(8);
              this.b.o.b();
            } else {
              this.b.m.setVisibility(0);
            } 
          } else {
            if (NearbyPeopleTabPageFragment.b(this.b)) {
              this.b.k.c(true);
              NearbyPeopleTabPageFragment.c(this.b).c(true);
            } else {
              this.b.k.k();
              this.b.k.c(false);
              NearbyPeopleTabPageFragment.c(this.b).k();
              NearbyPeopleTabPageFragment.c(this.b).c(false);
            } 
            if (this.b.k.getItemCount() == 0) {
              this.b.m.setVisibility(8);
              this.b.o.a();
            } else {
              this.b.m.setVisibility(0);
            } 
          } 
          SwipeRefreshObserver.a().b();
          this.b.k.notifyDataSetChanged();
          this.b.g.j();
          this.b.k.l();
          NearbyPeopleTabPageFragment.c(this.b).notifyDataSetChanged();
          this.b.h.j();
          NearbyPeopleTabPageFragment.c(this.b).l();
          this.a = false;
        }
        
        public void onUIStart() {
          super.onUIStart();
        }
        
        public void onUIUpdate(BluedEntity<UserFindResult, FindDataExtra> param1BluedEntity) {
          this.b.a(param1BluedEntity, false);
        }
        
        public BluedEntity<UserFindResult, FindDataExtra> parseData(String param1String) {
          BluedEntity<UserFindResult, FindDataExtra> bluedEntity = super.parseData(param1String);
          if (bluedEntity != null && bluedEntity.hasData())
            for (int i = 0; i < bluedEntity.data.size(); i++) {
              ((UserFindResult)bluedEntity.data.get(i)).distance = DistanceUtils.a(((UserFindResult)bluedEntity.data.get(i)).distance, BlueAppLocal.c(), false);
              ((UserFindResult)bluedEntity.data.get(i)).last_operate_time_stamp = ((UserFindResult)bluedEntity.data.get(i)).last_operate;
              ((UserFindResult)bluedEntity.data.get(i)).last_operate = TimeAndDateUtils.a(this.b.d, TimeAndDateUtils.b(((UserFindResult)bluedEntity.data.get(i)).last_operate));
            }  
          return bluedEntity;
        }
      };
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.p = new PauseOnScrollListener(false, true);
      this.d = (Context)getActivity();
      this.e = LayoutInflater.from(this.d).inflate(2131493253, paramViewGroup, false);
      a();
      SetModelObserver.a().a(this);
      PeopleDataObserver.a().a(this);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
    SetModelObserver.a().b(this);
    PeopleDataObserver.a().b(this);
  }
  
  public void p() {
    if (this.n) {
      a(true);
      HomeADDataObserver.a().b();
    } 
  }
  
  public void q() {}
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    this.n = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\NearbyPeopleTabPageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */