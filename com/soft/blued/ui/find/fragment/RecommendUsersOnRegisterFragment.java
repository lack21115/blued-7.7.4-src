package com.soft.blued.ui.find.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.login.LoginAndRegisterProtos;
import com.soft.blued.customview.swipecard.SwipeFlingAdapterView;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackLoginAndRegister;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.adapter.RecommendGridAdapter;
import com.soft.blued.ui.find.adapter.SwipeCardAdapter;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.user.UserInfo;

public class RecommendUsersOnRegisterFragment extends KeyBoardFragment implements View.OnClickListener, SwipeFlingAdapterView.onFlingListener {
  public BluedUIHttpResponse e = new BluedUIHttpResponse<BluedEntityA<BluedRecommendUsers>>(this) {
      public void a(BluedEntityA<BluedRecommendUsers> param1BluedEntityA) {
        RecommendUsersOnRegisterFragment.a(this.a).a(false);
        if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
          if (param1BluedEntityA.data.size() == RecommendUsersOnRegisterFragment.b(this.a)) {
            RecommendUsersOnRegisterFragment.a(this.a, true);
            RecommendUsersOnRegisterFragment.c(this.a).o();
          } else {
            RecommendUsersOnRegisterFragment.c(this.a).p();
            if (RecommendUsersOnRegisterFragment.d(this.a) != 1)
              AppMethods.a(RecommendUsersOnRegisterFragment.e(this.a).getResources().getString(2131756083)); 
            RecommendUsersOnRegisterFragment.a(this.a, false);
          } 
          if (RecommendUsersOnRegisterFragment.d(this.a) == 1) {
            RecommendUsersOnRegisterFragment.f(this.a).a(param1BluedEntityA.data);
            RecommendUsersOnRegisterFragment.a(this.a).a(param1BluedEntityA.data);
            return;
          } 
          RecommendUsersOnRegisterFragment.f(this.a).b(param1BluedEntityA.data);
          RecommendUsersOnRegisterFragment.a(this.a).b(param1BluedEntityA.data);
          return;
        } 
        RecommendUsersOnRegisterFragment.a(this.a, false);
        RecommendUsersOnRegisterFragment.c(this.a).p();
        AppMethods.a(RecommendUsersOnRegisterFragment.e(this.a).getResources().getString(2131756083));
        RecommendUsersOnRegisterFragment.g(this.a);
      }
      
      public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
        RecommendUsersOnRegisterFragment.a(this.a).a(false);
        super.onFailure(param1Throwable, param1Int, param1String);
      }
      
      public void onUIFinish() {
        RecommendUsersOnRegisterFragment.c(this.a).j();
        RecommendUsersOnRegisterFragment.c(this.a).q();
        RecommendUsersOnRegisterFragment.a(this.a).a(false);
      }
      
      public void onUIStart() {}
    };
  
  private Context f;
  
  private View o;
  
  private RenrenPullToRefreshListView p;
  
  private SwipeFlingAdapterView q;
  
  private ListView r;
  
  private LayoutInflater s;
  
  private int t;
  
  private int u = 30;
  
  private boolean v = true;
  
  private RecommendGridAdapter w;
  
  private SwipeCardAdapter x;
  
  private Dialog y;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, RecommendUsersOnRegisterFragment.class, new Bundle());
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean)
      this.t = 1; 
    if (this.t == 1)
      this.v = true; 
    if (!this.v) {
      int i = this.t;
      if (i != 1) {
        this.t = i - 1;
        AppMethods.a(this.f.getResources().getString(2131756083));
        this.p.j();
        this.p.q();
        return;
      } 
    } 
    this.x.a(true);
    Context context = this.f;
    BluedUIHttpResponse bluedUIHttpResponse = this.e;
    String str1 = UserInfo.a().i().getUid();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.t);
    stringBuilder1.append("");
    String str2 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.u);
    stringBuilder2.append("");
    LoginRegisterHttpUtils.a(0, context, bluedUIHttpResponse, str1, str2, stringBuilder2.toString(), (IRequestHost)w_());
  }
  
  private void t() {
    this.s = LayoutInflater.from(this.f);
    this.y = DialogUtils.a((Context)getActivity());
    this.o.findViewById(2131297268).setOnClickListener(this);
    Context context = this.f;
    this.w = new RecommendGridAdapter(context, PeopleGridQuickAdapter.a(context), this, w_(), this.y);
    this.p = (RenrenPullToRefreshListView)this.o.findViewById(2131298144);
    this.p.setRefreshEnabled(true);
    this.p.p();
    this.r = (ListView)this.p.getRefreshableView();
    this.r.setClipToPadding(false);
    this.r.setScrollBarStyle(33554432);
    this.r.setHeaderDividersEnabled(false);
    this.r.setDividerHeight(0);
    this.r.setAdapter((ListAdapter)this.w);
    this.p.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener(this) {
          public void a() {
            RecommendUsersOnRegisterFragment.a(this.a, 1);
            RecommendUsersOnRegisterFragment.b(this.a, false);
          }
          
          public void b() {
            RecommendUsersOnRegisterFragment.h(this.a);
            RecommendUsersOnRegisterFragment.b(this.a, false);
          }
        });
    this.p.postDelayed(new Runnable(this) {
          public void run() {
            RecommendUsersOnRegisterFragment.c(this.a).k();
          }
        },  100L);
    this.q = (SwipeFlingAdapterView)this.o.findViewById(2131300148);
    this.q.setFlingListener(this);
    this.x = new SwipeCardAdapter(this.f, this.q, this, w_(), this.y);
    this.q.setAdapter((Adapter)this.x);
    this.q.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            if ((param1MotionEvent.getRawY() < (RecommendUsersOnRegisterFragment.i(this.a)).b || param1MotionEvent.getRawY() > (RecommendUsersOnRegisterFragment.i(this.a)).e) && (RecommendUsersOnRegisterFragment.i(this.a)).a != null && (RecommendUsersOnRegisterFragment.i(this.a)).a.getX() == (RecommendUsersOnRegisterFragment.i(this.a)).c) {
              RecommendUsersOnRegisterFragment.f(this.a).notifyDataSetChanged();
              RecommendUsersOnRegisterFragment.i(this.a).setVisibility(8);
            } 
            return true;
          }
        });
    this.x.a(new SwipeCardAdapter.SwipeCardListener(this) {
          public void a() {
            RecommendUsersOnRegisterFragment.h(this.a);
            RecommendUsersOnRegisterFragment.b(this.a, false);
          }
        });
  }
  
  public boolean V_() {
    getActivity().setResult(-1);
    Bundle bundle = new Bundle();
    bundle.putString("from_tag_page", "from_tag_register");
    HomeArgumentHelper.a((Context)getActivity(), null, bundle);
    return false;
  }
  
  public void a() {
    this.x.a(0);
  }
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(int paramInt) {}
  
  public void a(Object paramObject) {
    this.x.c();
  }
  
  public void b(Object paramObject) {
    this.x.b();
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296788) {
      if (i != 2131297268) {
        switch (i) {
          default:
            return;
          case 2131297363:
          case 2131297364:
          case 2131297365:
          case 2131297366:
            break;
        } 
        this.x.b(((Integer)paramView.getTag()).intValue());
        this.q.a = null;
        this.x.c(((Integer)paramView.getTag()).intValue());
        this.q.setVisibility(0);
        return;
      } 
      EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.REC_PAGE_ENTER_BTN_CLICK);
      V_();
      return;
    } 
    this.w.notifyDataSetChanged();
    this.q.setVisibility(8);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.f = (Context)getActivity();
    View view = this.o;
    if (view == null) {
      this.o = paramLayoutInflater.inflate(2131493285, paramViewGroup, false);
      t();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.o.getParent()).removeView(this.o);
    } 
    return this.o;
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\RecommendUsersOnRegisterFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */