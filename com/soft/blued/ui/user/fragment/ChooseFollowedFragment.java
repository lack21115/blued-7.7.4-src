package com.soft.blued.ui.user.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AudioManagerUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.BluedConstant;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.SearchView;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.ui.user.adapter.ChooseFollowedListAdapter;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.ActivityChangeAnimationUtils;
import com.soft.blued.utils.StringUtils;

public class ChooseFollowedFragment extends KeyBoardFragment {
  private boolean A;
  
  private SearchView B;
  
  private boolean C = false;
  
  private int D = 0;
  
  private boolean E = false;
  
  BluedUIHttpResponse e = new BluedUIHttpResponse<BluedEntityA<BluedRecommendUsers>>(this) {
      public void a(BluedEntityA<BluedRecommendUsers> param1BluedEntityA) {
        if (param1BluedEntityA.data != null && param1BluedEntityA.hasData()) {
          if (ChooseFollowedFragment.d(this.a) == 1) {
            ChooseFollowedFragment.b(this.a).a(param1BluedEntityA.data);
          } else {
            ChooseFollowedFragment.b(this.a).b(param1BluedEntityA.data);
          } 
        } else if (ChooseFollowedFragment.d(this.a) == 1) {
          ChooseFollowedFragment.b(this.a).a();
        } else {
          AppMethods.a(ChooseFollowedFragment.c(this.a).getResources().getString(2131756083));
        } 
        if (param1BluedEntityA.extra != null && param1BluedEntityA.extra.hasmore == 1) {
          ChooseFollowedFragment.b(this.a, true);
          ChooseFollowedFragment.g(this.a).b(true);
          return;
        } 
        ChooseFollowedFragment.b(this.a, false);
        ChooseFollowedFragment.g(this.a).b(false);
      }
      
      public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
        super.onFailure(param1Throwable, param1Int, param1String);
        ChooseFollowedFragment.c(this.a, true);
      }
      
      public void onUIFinish() {
        if (ChooseFollowedFragment.h(this.a)) {
          ChooseFollowedFragment.c(this.a, false);
          if (ChooseFollowedFragment.d(this.a) != 1)
            ChooseFollowedFragment.i(this.a); 
          if (ChooseFollowedFragment.b(this.a).getCount() == 0) {
            ChooseFollowedFragment.j(this.a).b();
            ChooseFollowedFragment.g(this.a).b(false);
          } else {
            ChooseFollowedFragment.j(this.a).c();
          } 
        } else if (ChooseFollowedFragment.b(this.a).getCount() == 0) {
          ChooseFollowedFragment.j(this.a).setNoDataStr(2131758241);
          ChooseFollowedFragment.j(this.a).setNoDataImg(2131232643);
          ChooseFollowedFragment.j(this.a).a();
          ChooseFollowedFragment.g(this.a).b(false);
        } else {
          ChooseFollowedFragment.j(this.a).c();
        } 
        ChooseFollowedFragment.b(this.a).notifyDataSetChanged();
        ChooseFollowedFragment.g(this.a).g();
        ChooseFollowedFragment.g(this.a).h();
      }
    };
  
  BluedUIHttpResponse f = new BluedUIHttpResponse<BluedEntityA<BluedRecommendUsers>>(this) {
      public void a(BluedEntityA<BluedRecommendUsers> param1BluedEntityA) {
        if (param1BluedEntityA.data != null && param1BluedEntityA.hasData()) {
          if (ChooseFollowedFragment.d(this.a) == 1) {
            ChooseFollowedFragment.b(this.a).a(param1BluedEntityA.data);
          } else {
            ChooseFollowedFragment.b(this.a).b(param1BluedEntityA.data);
          } 
        } else if (ChooseFollowedFragment.d(this.a) == 1) {
          ChooseFollowedFragment.b(this.a).a();
        } else {
          AppMethods.a(ChooseFollowedFragment.c(this.a).getResources().getString(2131756083));
        } 
        if (param1BluedEntityA.extra != null && param1BluedEntityA.extra.hasmore == 1) {
          ChooseFollowedFragment.b(this.a, true);
          ChooseFollowedFragment.g(this.a).b(true);
          return;
        } 
        ChooseFollowedFragment.b(this.a, false);
        ChooseFollowedFragment.g(this.a).b(false);
      }
      
      public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
        super.onFailure(param1Throwable, param1Int, param1String);
        ChooseFollowedFragment.c(this.a, true);
      }
      
      public void onUIFinish() {
        if (ChooseFollowedFragment.h(this.a)) {
          ChooseFollowedFragment.c(this.a, false);
          if (ChooseFollowedFragment.d(this.a) != 1)
            ChooseFollowedFragment.i(this.a); 
          if (ChooseFollowedFragment.b(this.a).getCount() == 0) {
            ChooseFollowedFragment.j(this.a).b();
            ChooseFollowedFragment.g(this.a).b(false);
          } else {
            ChooseFollowedFragment.j(this.a).c();
          } 
        } else if (ChooseFollowedFragment.b(this.a).getCount() == 0) {
          ChooseFollowedFragment.j(this.a).setNoDataStr(2131758231);
          ChooseFollowedFragment.j(this.a).setNoDataImg(2131232640);
          ChooseFollowedFragment.j(this.a).a();
          ChooseFollowedFragment.g(this.a).b(false);
        } else {
          ChooseFollowedFragment.j(this.a).c();
        } 
        ChooseFollowedFragment.b(this.a).notifyDataSetChanged();
        ChooseFollowedFragment.g(this.a).g();
        ChooseFollowedFragment.g(this.a).h();
      }
    };
  
  private Context o;
  
  private View p;
  
  private View q;
  
  private KeyboardListenLinearLayout r;
  
  private View s;
  
  private SmartRefreshLayout t;
  
  private ListView u;
  
  private NoDataAndLoadFailView v;
  
  private ChooseFollowedListAdapter w;
  
  private int x;
  
  private int y = 10;
  
  private boolean z = true;
  
  private void a(int paramInt, String paramString1, String paramString2) {
    Intent intent = new Intent();
    intent.putExtra("UID", paramString1);
    intent.putExtra("USER_NAME", paramString2);
    getActivity().setResult(paramInt, intent);
    getActivity().finish();
    ActivityChangeAnimationUtils.c((Activity)getActivity());
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean)
      this.x = 1; 
    if (this.x == 1)
      this.z = true; 
    if (!this.z) {
      int i = this.x;
      if (i != 1) {
        this.x = i - 1;
        AppMethods.a(this.o.getResources().getString(2131756083));
        this.t.g();
        this.t.h();
        return;
      } 
    } 
    Context context = this.o;
    BluedUIHttpResponse bluedUIHttpResponse = this.e;
    String str1 = UserInfo.a().i().getUid();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.x);
    stringBuilder1.append("");
    String str2 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.y);
    stringBuilder2.append("");
    MineHttpUtils.e(context, bluedUIHttpResponse, str1, str2, stringBuilder2.toString(), (IRequestHost)w_());
  }
  
  private void t() {
    Bundle bundle = getArguments();
    if (bundle != null)
      this.D = bundle.getInt("from"); 
  }
  
  private void u() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.p.findViewById(2131300273);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setLeftText(2131755726);
    commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            ChooseFollowedFragment.a(this.a, 0, "", "");
          }
        });
    commonTopTitleNoTrans.setCenterText(2131755357);
    this.B = (SearchView)this.q.findViewById(2131299874);
    this.B.getEditView().setHint(2131755358);
    this.B.setOnSearchInfoListener(new SearchView.OnSearchInfoListener(this) {
          public void a() {
            KeyboardUtils.a((Activity)this.a.getActivity());
          }
          
          public void a(String param1String) {
            if (ChooseFollowedFragment.b(this.a) != null)
              ChooseFollowedFragment.b(this.a).a(param1String); 
            if (StringUtils.e(param1String)) {
              ChooseFollowedFragment.a(this.a, true);
              return;
            } 
            MineHttpUtils.a(ChooseFollowedFragment.c(this.a), this.a.f, param1String, ChooseFollowedFragment.d(this.a), ChooseFollowedFragment.e(this.a), (IRequestHost)this.a.w_());
          }
          
          public void b() {}
        });
    this.r = (KeyboardListenLinearLayout)this.p.findViewById(2131297981);
    this.s = this.p.findViewById(2131297985);
    this.v = (NoDataAndLoadFailView)this.q.findViewById(2131299389);
    this.v.c();
    this.t = (SmartRefreshLayout)this.p.findViewById(2131299616);
    this.t.setBackgroundColor(BluedSkinUtils.a(this.o, 2131100728));
    this.u = (ListView)this.p.findViewById(2131298144);
    this.u.setBackgroundColor(BluedSkinUtils.a(this.o, 2131100728));
    this.u.setClipToPadding(false);
    this.u.setScrollBarStyle(33554432);
    this.u.setHeaderDividersEnabled(false);
    this.u.setDividerHeight(0);
    this.A = true;
    this.w = new ChooseFollowedListAdapter((IRequestHost)w_(), this.o);
    this.u.setAdapter((ListAdapter)this.w);
    this.u.addHeaderView(this.q);
    this.u.setOnItemClickListener(new AdapterView.OnItemClickListener(this) {
          public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
            if (--param1Int >= 0 && param1Int < ChooseFollowedFragment.b(this.a).getCount()) {
              BluedRecommendUsers bluedRecommendUsers = ChooseFollowedFragment.b(this.a).a(param1Int);
              String str1 = bluedRecommendUsers.uid;
              String str2 = bluedRecommendUsers.name;
              ChooseFollowedFragment.a(this.a, -1, str1, str2);
            } 
          }
        });
    this.t.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            ChooseFollowedFragment.f(this.a);
            ChooseFollowedFragment.a(this.a, false);
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ChooseFollowedFragment.a(this.a, 1);
            ChooseFollowedFragment.a(this.a, false);
          }
        });
    this.t.i();
  }
  
  public boolean V_() {
    if (this.D == 1)
      this.E = true; 
    a(0, "", "");
    return true;
  }
  
  public void b(KeyboardListenLinearLayout paramKeyboardListenLinearLayout) {
    a(paramKeyboardListenLinearLayout);
  }
  
  public void e_(int paramInt) {
    if (BluedConstant.f != BluedConstant.h) {
      if (BluedConstant.f == BluedConstant.g)
        return; 
      if (paramInt != -3) {
        if (paramInt != -2)
          return; 
        this.s.setVisibility(8);
        this.s.setOnTouchListener(null);
        SearchView searchView = this.B;
        if (searchView != null) {
          searchView.a(false);
          return;
        } 
      } else {
        this.s.setVisibility(0);
        this.s.setOnTouchListener(new View.OnTouchListener(this) {
              public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
                if (param1MotionEvent.getAction() == 0) {
                  Rect rect = new Rect();
                  ChooseFollowedFragment.a(this.a).getFocusedRect(rect);
                  if (!rect.contains((int)param1MotionEvent.getX(), (int)param1MotionEvent.getY()))
                    KeyboardUtils.a((Activity)this.a.getActivity()); 
                } 
                return false;
              }
            });
        SearchView searchView = this.B;
        if (searchView != null)
          searchView.a(true); 
      } 
    } 
  }
  
  public boolean j() {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.o = (Context)getActivity();
    View view = this.p;
    if (view == null) {
      this.p = paramLayoutInflater.inflate(2131493088, paramViewGroup, false);
      this.q = paramLayoutInflater.inflate(2131493396, null, false);
      t();
      u();
      b(this.r);
      ShortVideoProxy.e().a(getClass().getSimpleName());
    } else if (view.getParent() != null) {
      ((ViewGroup)this.p.getParent()).removeView(this.p);
    } 
    return this.p;
  }
  
  public void onDestroyView() {
    ShortVideoProxy.e().b(getClass().getSimpleName());
    super.onDestroyView();
  }
  
  public void onPause() {
    super.onPause();
    if (this.D == 1)
      AudioManagerUtils.a().a(this.E); 
  }
  
  public void onResume() {
    super.onResume();
    if (this.D == 1) {
      this.E = false;
      AudioManagerUtils.a().b();
    } 
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean && !this.A) {
      SmartRefreshLayout smartRefreshLayout = this.t;
      if (smartRefreshLayout != null) {
        smartRefreshLayout.i();
        this.A = true;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\ChooseFollowedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */