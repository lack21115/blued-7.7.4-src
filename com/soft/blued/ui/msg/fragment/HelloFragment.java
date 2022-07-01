package com.soft.blued.ui.msg.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.das.guy.GuyProtos;
import com.blued.das.message.MessageProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.FloatFooterView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.model.CallMeStatusData;
import com.soft.blued.ui.find.model.HelloDataExtra;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.find.observer.CallHelloObserver;
import com.soft.blued.ui.msg.adapter.PeopleHelloQuickAdapter;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import java.util.ArrayList;

public class HelloFragment extends BaseFragment implements View.OnClickListener, CallHelloObserver.ICallHelloObserver {
  public NoDataAndLoadFailView d;
  
  public BluedUIHttpResponse e = new BluedUIHttpResponse<BluedEntity<UserFindResult, HelloDataExtra>>(this, (IRequestHost)w_()) {
      boolean a = false;
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        if (HelloFragment.g(this.b) == null)
          HelloFragment.a(this.b, 0); 
        if (this.a) {
          if (HelloFragment.g(this.b).getItemCount() == 0)
            this.b.d.b(); 
        } else {
          if (HelloFragment.h(this.b)) {
            HelloFragment.g(this.b).c(true);
          } else {
            HelloFragment.g(this.b).k();
            HelloFragment.g(this.b).c(false);
          } 
          if (HelloFragment.g(this.b).getItemCount() == 0)
            this.b.d.a(); 
        } 
        HelloFragment.g(this.b).notifyDataSetChanged();
        HelloFragment.e(this.b).j();
        HelloFragment.g(this.b).l();
        this.a = false;
      }
      
      public void onUIStart() {
        super.onUIStart();
      }
      
      public void onUIUpdate(BluedEntity<UserFindResult, HelloDataExtra> param1BluedEntity) {
        if (param1BluedEntity != null) {
          if (param1BluedEntity.extra != null)
            HelloFragment.a(this.b, ((HelloDataExtra)param1BluedEntity.extra).table_type); 
          HelloFragment.b(this.b, param1BluedEntity.hasMore());
          if (param1BluedEntity.hasData()) {
            if (HelloFragment.f(this.b) == 1) {
              HelloFragment.g(this.b).c(param1BluedEntity.data);
            } else {
              HelloFragment.g(this.b).a(param1BluedEntity.data);
            } 
            this.b.d.c();
            HelloFragment.g(this.b).notifyDataSetChanged();
            return;
          } 
          HelloFragment.g(this.b).c(null);
          this.b.d.a();
        } 
      }
      
      public BluedEntity<UserFindResult, HelloDataExtra> parseData(String param1String) {
        BluedEntity<UserFindResult, HelloDataExtra> bluedEntity = super.parseData(param1String);
        if (bluedEntity != null)
          for (int i = 0; i < bluedEntity.data.size(); i++) {
            ((UserFindResult)bluedEntity.data.get(i)).distance = DistanceUtils.a(((UserFindResult)bluedEntity.data.get(i)).distance, BlueAppLocal.c(), false);
            ((UserFindResult)bluedEntity.data.get(i)).last_operate = TimeAndDateUtils.a(HelloFragment.a(this.b), TimeAndDateUtils.b(((UserFindResult)bluedEntity.data.get(i)).last_operate));
          }  
        return bluedEntity;
      }
    };
  
  private Context f;
  
  private View g;
  
  private CommonTopTitleNoTrans h;
  
  private LinearLayout i;
  
  private ShapeTextView j;
  
  private ShapeTextView k;
  
  private LinearLayout l;
  
  private TextView m;
  
  private ImageView n;
  
  private PullToRefreshRecyclerView o;
  
  private RecyclerView p;
  
  private PeopleGridQuickAdapter q;
  
  private FloatFooterView r;
  
  private int s = 1;
  
  private int t = 30;
  
  private boolean u;
  
  private String v;
  
  private String w;
  
  private boolean x;
  
  private RecyclerView.OnScrollListener y = new RecyclerView.OnScrollListener(this) {
      public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
        if (HelloFragment.i(this.a) != null && param1Int == 0) {
          if (!param1RecyclerView.canScrollVertically(-1)) {
            HelloFragment.i(this.a).a();
            return;
          } 
          if (!param1RecyclerView.canScrollVertically(1))
            HelloFragment.i(this.a).b(); 
        } 
      }
      
      public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
        if (param1Int2 < 0) {
          HelloFragment.i(this.a).a();
          return;
        } 
        if (param1Int2 > 0)
          HelloFragment.i(this.a).b(); 
      }
    };
  
  private void a(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("initAdapter:");
    stringBuilder.append(paramInt);
    Log.v("drb", stringBuilder.toString());
    if (this.q == null) {
      MessageProtos.SortType sortType;
      this.q = (PeopleGridQuickAdapter)new PeopleHelloQuickAdapter(new ArrayList(), (Activity)getActivity(), (IRequestHost)w_(), "msg_hello_detail", this.p);
      GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f, 3);
      this.o.getLayoutParams();
      ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)this.o.getLayoutParams();
      layoutParams.leftMargin = DensityUtils.a(this.f, 3.0F);
      layoutParams.rightMargin = 0;
      this.o.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      this.p.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
      this.q.e((View)this.d);
      PeopleGridQuickAdapter peopleGridQuickAdapter = this.q;
      if ("intelligent".equals(this.v)) {
        sortType = MessageProtos.SortType.AI_SORT_TYPE;
      } else {
        sortType = MessageProtos.SortType.DISTANCE_SORT_TYPE;
      } 
      peopleGridQuickAdapter.a(sortType);
      this.q.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
            public void onLoadMoreRequested() {
              HelloFragment.b(this.a);
              HelloFragment.a(this.a, false);
            }
          }this.p);
      this.p.setAdapter((RecyclerView.Adapter)this.q);
    } 
  }
  
  public static void a(Context paramContext, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("hello_title", paramString);
    TerminalActivity.d(paramContext, HelloFragment.class, bundle);
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean)
      this.s = 1; 
    if (this.x) {
      Context context1 = this.f;
      BluedUIHttpResponse bluedUIHttpResponse1 = this.e;
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(this.s);
      stringBuilder3.append("");
      String str1 = stringBuilder3.toString();
      StringBuilder stringBuilder4 = new StringBuilder();
      stringBuilder4.append(this.t);
      stringBuilder4.append("");
      UserHttpUtils.a(context1, bluedUIHttpResponse1, str1, stringBuilder4.toString(), this.v, this.w, (IRequestHost)w_());
      return;
    } 
    Context context = this.f;
    BluedUIHttpResponse bluedUIHttpResponse = this.e;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.s);
    stringBuilder1.append("");
    String str = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.t);
    stringBuilder2.append("");
    UserHttpUtils.a(context, bluedUIHttpResponse, str, stringBuilder2.toString(), "", "", (IRequestHost)w_());
  }
  
  private void b(CallMeStatusData paramCallMeStatusData) {
    if (paramCallMeStatusData == null)
      return; 
    CallHelloManager.a().c();
    int i = paramCallMeStatusData.call_status;
    if (i != 0) {
      if (i != 1)
        if (i != 2) {
          if (i != 4) {
            if (i != 5)
              return; 
            this.r.setBtnText(getResources().getString(2131756508));
            return;
          } 
        } else {
          this.r.setBtnText(2131755719);
          return;
        }  
      CallHelloManager.a().a(this.f, (IRequestHost)w_(), 8);
      return;
    } 
    if (paramCallMeStatusData.free_count != 0) {
      this.r.setBtnText(2131756564);
      return;
    } 
    if (paramCallMeStatusData.pay_count != 0) {
      FloatFooterView floatFooterView = this.r;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.f.getString(2131758318));
      stringBuilder.append(" X ");
      stringBuilder.append(paramCallMeStatusData.pay_count);
      floatFooterView.setBtnText(stringBuilder.toString());
      return;
    } 
    this.r.setBtnText(2131758317);
  }
  
  private void k() {
    this.v = BluedPreferences.dP();
    this.w = BluedPreferences.dQ();
  }
  
  private void l() {
    this.h = (CommonTopTitleNoTrans)this.g.findViewById(2131300300);
    this.h.a();
    this.h.setLeftImg(2131232743);
    this.h.setLeftClickListener(this);
    this.h.setCenterText(2131756894);
  }
  
  private void m() {
    this.i = (LinearLayout)this.g.findViewById(2131298061);
    this.j = (ShapeTextView)this.g.findViewById(2131301349);
    this.j.setOnClickListener(this);
    this.k = (ShapeTextView)this.g.findViewById(2131301350);
    this.k.setOnClickListener(this);
    this.l = (LinearLayout)this.g.findViewById(2131296589);
    this.l.setOnClickListener(this);
    this.m = (TextView)this.g.findViewById(2131300766);
    this.n = (ImageView)this.g.findViewById(2131297768);
    o();
    r();
    this.x = BluedConfig.b().L();
    if (this.x) {
      this.i.setVisibility(0);
      return;
    } 
    this.i.setVisibility(8);
  }
  
  private void n() {
    this.r = (FloatFooterView)this.g.findViewById(2131297052);
    this.r.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener(this) {
          public void onPostFeedClick() {
            CallHelloManager.a().a(HelloFragment.a(this.a), (IRequestHost)this.a.w_(), 8, new CallHelloManager.ToOpenListener(this) {
                  public void a(boolean param2Boolean) {
                    if (param2Boolean)
                      CallHelloManager.a().a(this.a.a.getContext(), (IRequestHost)this.a.a.w_(), false, 8); 
                  }
                });
            CallMeStatusData callMeStatusData = CallHelloManager.a().b();
            if (callMeStatusData != null) {
              int i = callMeStatusData.call_status;
              if (i != 0) {
                if (i != 1)
                  if (i != 2) {
                    if (i != 4) {
                      if (i != 5)
                        return; 
                      EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.COMPLETE_VOCATIVE);
                      return;
                    } 
                  } else {
                    EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.IN_CHECK);
                    return;
                  }  
                EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.IN_VOCATIVE);
                return;
              } 
              if (callMeStatusData.free_count != 0) {
                EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.FREE_VOCATIVE);
                return;
              } 
              if (callMeStatusData.pay_count != 0) {
                EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.OPEN_VOCATIVE_NUM);
                return;
              } 
              EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.OPEN_VOCATIVE);
            } 
          }
        });
  }
  
  private void o() {
    if ("intelligent".equals(this.v)) {
      p();
      return;
    } 
    q();
  }
  
  private void p() {
    ShapeHelper.a((ShapeHelper.ShapeView)this.j, 2131100838);
    ShapeHelper.a((ShapeHelper.ShapeView)this.k, 2131100844);
    this.v = "intelligent";
    BluedPreferences.ap("intelligent");
  }
  
  private void q() {
    ShapeHelper.a((ShapeHelper.ShapeView)this.k, 2131100838);
    ShapeHelper.a((ShapeHelper.ShapeView)this.j, 2131100844);
    this.v = "distance";
    BluedPreferences.ap("distance");
  }
  
  private void r() {
    if (TextUtils.isEmpty(this.w)) {
      s();
      return;
    } 
    t();
  }
  
  private void s() {
    this.m.setTextColor(BluedSkinUtils.a(this.f, 2131100838));
    this.n.setImageDrawable(BluedSkinUtils.b(this.f, 2131232625));
  }
  
  private void t() {
    this.m.setTextColor(BluedSkinUtils.a(this.f, 2131100716));
    this.n.setImageDrawable(BluedSkinUtils.b(this.f, 2131232626));
  }
  
  private void u() {
    this.d = new NoDataAndLoadFailView(this.f);
    this.d.setNoDataStr(2131758356);
    this.d.setNoDataImg(2131232639);
    this.d.c();
    this.o = (PullToRefreshRecyclerView)this.g.findViewById(2131297289);
    this.p = (RecyclerView)this.o.getRefreshableView();
    this.o.setRefreshEnabled(true);
    this.o.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>(this) {
          public void a(PullToRefreshBase<RecyclerView> param1PullToRefreshBase) {
            HelloFragment.a(this.a, true);
          }
        });
    this.p.addOnScrollListener(this.y);
    this.o.k();
    CallHelloManager.a().a(this.f, (IRequestHost)w_(), 8, null);
  }
  
  public String a() {
    return this.w;
  }
  
  public void a(CallMeStatusData paramCallMeStatusData) {
    b(paramCallMeStatusData);
  }
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void b(int paramInt) {
    this.r.setBtnText(TimeAndDateUtils.a(paramInt, false));
  }
  
  public void onClick(View paramView) {
    PeopleGridQuickAdapter peopleGridQuickAdapter;
    switch (paramView.getId()) {
      default:
        return;
      case 2131301350:
        EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_DISTANCE_SORT_CLICK);
        q();
        this.o.k();
        peopleGridQuickAdapter = this.q;
        if (peopleGridQuickAdapter != null) {
          peopleGridQuickAdapter.a(MessageProtos.SortType.DISTANCE_SORT_TYPE);
          return;
        } 
        return;
      case 2131301349:
        EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_AUTO_SORT_CLICK);
        p();
        this.o.k();
        peopleGridQuickAdapter = this.q;
        if (peopleGridQuickAdapter != null) {
          peopleGridQuickAdapter.a(MessageProtos.SortType.AI_SORT_TYPE);
          return;
        } 
        return;
      case 2131296863:
        getActivity().finish();
        return;
      case 2131296589:
        break;
    } 
    HelloFilterDialogFragment helloFilterDialogFragment = new HelloFilterDialogFragment();
    helloFilterDialogFragment.a(new HelloFilterDialogFragment.OnHelloFilterChange(this) {
          public void a(String param1String) {
            HelloFragment.a(this.a, param1String);
            HelloFragment.c(this.a);
            HelloFragment.d(this.a).scrollToPosition(0);
            HelloFragment.e(this.a).k();
          }
        });
    helloFilterDialogFragment.show(getActivity().getSupportFragmentManager(), HelloFilterDialogFragment.class.getSimpleName());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.g;
    if (view == null) {
      this.g = paramLayoutInflater.inflate(2131493152, paramViewGroup, false);
      this.f = (Context)getActivity();
      k();
      l();
      m();
      n();
      u();
      CallHelloObserver.a().a(this, getLifecycle());
    } else if (view.getParent() != null) {
      ((ViewGroup)this.g.getParent()).removeView(this.g);
    } 
    return this.g;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\fragment\HelloFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */