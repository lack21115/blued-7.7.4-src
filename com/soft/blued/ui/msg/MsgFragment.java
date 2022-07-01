package com.soft.blued.ui.msg;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.StableIMConnectListener;
import com.blued.android.chat.listener.IMStatusListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.das.message.MessageProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.HorizontalScrollView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.PopMenu;
import com.soft.blued.customview.RiseNumberTextView;
import com.soft.blued.customview.TouchEnableKeyboardLinearLayout;
import com.soft.blued.customview.VerticalTextView;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.push.PushChecker;
import com.soft.blued.ui.find.fragment.HelloStateDialogFragment;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.model.CallMeStatusData;
import com.soft.blued.ui.find.model.HelloDataExtra;
import com.soft.blued.ui.find.observer.CallHelloObserver;
import com.soft.blued.ui.home.HomeTabClick;
import com.soft.blued.ui.home.model.HomeViewModel;
import com.soft.blued.ui.msg.adapter.ChatFriendListAdapter;
import com.soft.blued.ui.msg.adapter.MsgHelloAdapter;
import com.soft.blued.ui.msg.contract.IMsgFilterCallback;
import com.soft.blued.ui.msg.contract.IMsgView;
import com.soft.blued.ui.msg.customview.MsgFilterView;
import com.soft.blued.ui.msg.customview.TranslationAnimHintView;
import com.soft.blued.ui.msg.fragment.HelloFragment;
import com.soft.blued.ui.msg.pop.MsgBoxGuidePop;
import com.soft.blued.ui.msg.presenter.MsgPresenter;
import com.soft.blued.ui.search.SearchAllFragment;
import com.soft.blued.ui.setting.Contract.IPrivacySettingContract;
import com.soft.blued.ui.setting.Presenter.PrivacySettingPresenter;
import com.soft.blued.ui.setting.fragment.RemindSettingFragment;
import com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.click.SingleClickProxy;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.CommonNotification;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

public class MsgFragment extends MvpFragment<MsgPresenter> implements View.OnClickListener, AbsListView.OnScrollListener, CallHelloObserver.ICallHelloObserver, HomeTabClick.TabClickListener, IMsgFilterCallback, IMsgView, IPrivacySettingContract.IView {
  public static boolean e;
  
  @BindView(2131296552)
  public TranslationAnimHintView bottom_hint_view;
  
  @BindView(2131296849)
  public View cover_view;
  
  public MsgHelloAdapter d;
  
  private LayoutInflater f;
  
  private ListView g;
  
  private ViewGroup h;
  
  private MenuViewHolder i;
  
  private PopMenu j;
  
  @BindView(2131297981)
  public TouchEnableKeyboardLinearLayout keyboardLayout;
  
  @BindView(2131299259)
  public MsgFilterView msgFilterView;
  
  @BindView(2131299250)
  public View msg_filter_guide_iv;
  
  private View n;
  
  private HeaderViewHolder o;
  
  private View p;
  
  @BindView(2131299268)
  public RenrenPullToRefreshListView pullRefresh;
  
  private HelloHeaderHolder q;
  
  private ChatFriendListAdapter r;
  
  @BindView(2131299558)
  public RelativeLayout rLayout;
  
  private IPrivacySettingContract.IPresenter s;
  
  private Dialog t;
  
  private final MsgConnectListener u = new MsgConnectListener();
  
  private ImageView v;
  
  private int w;
  
  private int x;
  
  private boolean y;
  
  private ArrayList<Unbinder> z = new ArrayList<Unbinder>();
  
  private void O() {
    this.s = (IPrivacySettingContract.IPresenter)new PrivacySettingPresenter((Context)getActivity(), (IRequestHost)w_(), this);
    if (BluedPreferences.at())
      this.s.c(); 
    LiveEventBus.get("sync_secret_look_state", Boolean.class).observe((LifecycleOwner)this, new Observer<Boolean>(this) {
          public void a(Boolean param1Boolean) {
            MsgFragment.a(this.a);
          }
        });
  }
  
  private void P() {
    if (this.o != null) {
      if (this.i == null)
        return; 
      if (BluedPreferences.ar()) {
        this.i.tv_item4.setText(2131755612);
        if (BluedPreferences.dX()) {
          this.o.anim_hint_view.a(3, new View.OnClickListener(this) {
                public void onClick(View param1View) {
                  BluedPreferences.S(false);
                  (MsgFragment.b(this.a)).anim_hint_view.a(3);
                }
              },  new boolean[0]);
          return;
        } 
      } else {
        this.i.tv_item4.setText(2131755613);
        this.o.anim_hint_view.a(3);
      } 
    } 
  }
  
  private void Q() {
    this.r = new ChatFriendListAdapter((IRequestHost)w_(), this);
    this.g.setAdapter((ListAdapter)this.r);
    this.r.a = (MsgPresenter)s();
    this.g.setOnItemClickListener((AdapterView.OnItemClickListener)s());
    this.g.setOnItemLongClickListener((AdapterView.OnItemLongClickListener)s());
    this.g.setOnScrollListener(this);
  }
  
  private void R() {
    this.pullRefresh.setRefreshEnabled(true);
    this.pullRefresh.p();
    this.g = (ListView)this.pullRefresh.getRefreshableView();
    this.pullRefresh.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener(this) {
          public void a() {
            this.a.k();
            ((MsgPresenter)this.a.s()).x();
          }
          
          public void b() {}
        });
    this.n = this.f.inflate(2131493773, null);
    this.g.addHeaderView(this.n);
    this.o = new HeaderViewHolder(this);
    this.z.add(ButterKnife.a(this.o, this.n));
    this.o.ll_nodata_chats.setNoDataImg(2131232632);
    this.o.searchLayout.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackMessage.a(MessageProtos.Event.MSG_SCREEN_SEARCH_BOX_CLICK);
            SearchAllFragment.a(this.a.getContext(), true);
          }
        });
    View view = this.p;
    if (view == null) {
      this.p = View.inflate(getContext(), 2131493788, null);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.p.getParent()).removeView(this.p);
    } 
    this.q = new HelloHeaderHolder(this);
    this.z.add(ButterKnife.a(this.q, this.p));
    this.p.setVisibility(8);
    this.q.tv_call_me_btn.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              EventTrackMessage.a(MessageProtos.Event.MSG_VOCATIV_BTN_CLICK);
              MsgFragment.c(this.a);
            }
          }));
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(0);
    this.o.rvHello.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.d = new MsgHelloAdapter((IRequestHost)w_(), getContext());
    this.d.d(true);
    this.d.a(this.p, -1, 0);
    this.o.rvHello.setAdapter((RecyclerView.Adapter)this.d);
    this.o.llHello.setVisibility(8);
    this.o.rvHello.setVisibility(8);
    this.o.layoutNewHello.setVisibility(8);
  }
  
  private boolean S() {
    Fragment fragment = getParentFragment();
    return (fragment != null && fragment instanceof MessagePageFragment && ((MessagePageFragment)fragment).k() == 1);
  }
  
  private void T() {
    CallMeStatusData callMeStatusData = CallHelloManager.a().b();
    if (callMeStatusData != null && callMeStatusData.call_status == 5) {
      HelloStateDialogFragment.a(getContext(), callMeStatusData);
      CallHelloManager.a().a(getContext(), (IRequestHost)w_(), 2, null);
      return;
    } 
    CallHelloManager.a().a(getContext(), (IRequestHost)w_(), 2, new CallHelloManager.ToOpenListener(this) {
          public void a(boolean param1Boolean) {
            if (param1Boolean)
              CallHelloManager.a().a(this.a.getContext(), (IRequestHost)this.a.w_(), false, 2); 
          }
        });
  }
  
  private void U() {
    if (this.o == null)
      return; 
    if (this.p.getVisibility() == 0 || this.d.n().size() > 0) {
      this.o.llHello.setVisibility(0);
      this.o.rvHello.setVisibility(0);
      if (this.d.n().size() > 0) {
        this.o.rlHelloEmpty.setVisibility(8);
        return;
      } 
      this.o.rlHelloEmpty.setVisibility(0);
      return;
    } 
    this.o.llHello.setVisibility(8);
    this.o.rvHello.setVisibility(8);
    this.o.rlHelloEmpty.setVisibility(8);
  }
  
  private void V() {
    View view = this.msg_filter_guide_iv;
    if (view != null && view.getVisibility() == 8) {
      this.msg_filter_guide_iv.setVisibility(0);
      this.msg_filter_guide_iv.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              this.a.msg_filter_guide_iv.setVisibility(8);
              ((MsgPresenter)this.a.s()).m();
            }
          });
      a(new Runnable(this) {
            public void run() {
              if (this.a.msg_filter_guide_iv != null)
                this.a.msg_filter_guide_iv.setVisibility(8); 
              ((MsgPresenter)this.a.s()).m();
            }
          },  5000L);
    } 
  }
  
  private void W() {
    View view = this.cover_view;
    if (view != null)
      view.setVisibility(8); 
  }
  
  private void X() {
    if (this.p.getVisibility() != 0)
      return; 
    CallHelloManager.a().d();
  }
  
  private void Y() {
    this.q.tv_call_me_btn.setBackgroundResource(2131232398);
    this.q.iv_call_default.setVisibility(0);
    this.q.tv_call_me_btn.setText("");
    CallHelloManager.a().c();
    CallHelloManager.a().e();
  }
  
  private void a(boolean paramBoolean, int paramInt) {
    ChatFriendListAdapter chatFriendListAdapter = this.r;
    if (chatFriendListAdapter != null) {
      chatFriendListAdapter.a(((MsgPresenter)s()).s(), paramBoolean);
      this.r.notifyDataSetChanged();
    } 
    b(paramBoolean, paramInt);
  }
  
  private void b(boolean paramBoolean, int paramInt) {
    HeaderViewHolder headerViewHolder = this.o;
    if (headerViewHolder == null)
      return; 
    if (headerViewHolder.ll_nodata_chats != null) {
      if (paramInt > 0) {
        this.o.ll_nodata_chats.c();
      } else {
        if (paramBoolean) {
          this.o.ll_nodata_chats.setNoDataStr(2131758240);
        } else {
          this.o.ll_nodata_chats.setNoDataStr(2131758227);
        } 
        this.o.ll_nodata_chats.a();
      } 
      this.rLayout.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131100733));
    } 
  }
  
  protected void E() {
    HeaderViewHolder headerViewHolder = this.o;
    if (headerViewHolder == null)
      return; 
    headerViewHolder.tvMore.setVisibility(4);
    this.o.ivMore.setVisibility(8);
    this.o.llHello.setVisibility(8);
    this.o.rvHello.setVisibility(8);
    this.o.layoutNewHello.setVisibility(8);
    U();
  }
  
  public void F() {
    this.x = this.g.getFirstVisiblePosition();
    this.w = 0;
    for (int i = this.x; i < ((MsgPresenter)s()).h.a().size() + 1; i = j + 1) {
      int j = i;
      if (i != 0)
        if (this.w == i) {
          j = i;
        } else {
          SessionModel sessionModel = ((MsgPresenter)s()).h.a().get(i - 1);
          j = i;
          if (sessionModel != null) {
            j = i;
            if (sessionModel.noReadMsgCount > 0)
              if (this.y) {
                this.y = false;
                j = 0;
              } else {
                this.w = i;
                return;
              }  
          } 
        }  
    } 
  }
  
  public void G() {
    this.cover_view.setVisibility(0);
    this.cover_view.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            if (param1MotionEvent.getAction() == 0) {
              MsgFragment.g(this.a);
              if (this.a.msgFilterView != null)
                this.a.msgFilterView.a(); 
              if (this.a.msg_filter_guide_iv.getVisibility() == 0) {
                this.a.msg_filter_guide_iv.setVisibility(8);
                ((MsgPresenter)this.a.s()).m();
              } 
            } 
            return true;
          }
        });
  }
  
  public void H() {
    W();
  }
  
  public boolean I() {
    return ((MsgPresenter)s()).n();
  }
  
  public boolean J() {
    return ((MsgPresenter)s()).o();
  }
  
  public boolean K() {
    return ((MsgPresenter)s()).p();
  }
  
  public boolean L() {
    return ((MsgPresenter)s()).t();
  }
  
  public boolean M() {
    return false;
  }
  
  public boolean N() {
    return false;
  }
  
  public void a(Bundle paramBundle) {
    int i;
    super.a(paramBundle);
    this.t = DialogUtils.a(getContext());
    this.f = LayoutInflater.from(getContext());
    this.h = (ViewGroup)this.f.inflate(2131493217, null);
    this.i = new MenuViewHolder(this);
    this.z.add(ButterKnife.a(this.i, (View)this.h));
    TextView textView = this.i.tv_item4;
    if (BluedPreferences.ar()) {
      i = 2131755612;
    } else {
      i = 2131755613;
    } 
    textView.setText(i);
    this.i.tv_item1.setOnClickListener(this);
    this.i.tv_item2.setOnClickListener(this);
    this.i.tv_item3.setOnClickListener(this);
    this.i.lay_item4.setOnClickListener(this);
    this.i.tv_item0.setOnClickListener(this);
    if (BluedConfig.b().B()) {
      if (!BluedPreferences.ca())
        this.i.iv_msg_box_red_point.setVisibility(0); 
      this.i.tv_item0.setVisibility(0);
    } 
    this.j = new PopMenu(getContext(), (View)this.h);
    R();
    Q();
    O();
    CallHelloObserver.a().a(this, getLifecycle());
  }
  
  public void a(AbsListView paramAbsListView) {
    int i = this.w;
    if (i == 0) {
      paramAbsListView.smoothScrollToPosition(0);
      return;
    } 
    a(paramAbsListView, i);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {
    int i;
    int k = DensityUtils.a(getContext(), 90.0F);
    View view = this.n;
    if (view != null) {
      i = view.getHeight();
    } else {
      i = 0;
    } 
    view = paramAbsListView.getChildAt(0);
    int j = this.x;
    if (j == 0) {
      paramInt--;
    } else {
      if (j == 1) {
        i += view.getTop();
        j = this.x;
      } else {
        i = view.getTop() + k;
        j = this.x;
      } 
      paramInt -= j;
    } 
    paramAbsListView.smoothScrollBy(i + paramInt * k, 200);
  }
  
  protected void a(BluedEntity paramBluedEntity) {
    HeaderViewHolder headerViewHolder = this.o;
    if (headerViewHolder == null)
      return; 
    headerViewHolder.layoutNewHello.setVisibility(8);
    this.d.c(paramBluedEntity.data);
    this.o.llHello.setVisibility(0);
    this.o.rvHello.setVisibility(0);
    if (paramBluedEntity.hasMore()) {
      this.o.tvMore.setVisibility(0);
      this.o.ivMore.setVisibility(0);
      this.o.llHello.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              HelloFragment.a(this.a.getContext(), (MsgFragment.b(this.a)).gtvHelloTitle.getText().toString());
            }
          });
      this.o.mScrollView.setOnReleaseListener(new HorizontalScrollView.OnReleaseListener(this) {
            public void a() {
              String str;
              if (MsgFragment.b(this.a) != null && (MsgFragment.b(this.a)).gtvHelloTitle != null) {
                str = (MsgFragment.b(this.a)).gtvHelloTitle.getText().toString();
              } else {
                str = "";
              } 
              HelloFragment.a(this.a.getContext(), str);
            }
          });
      this.o.tvHelloMore.setVisibility(0);
    } else {
      this.o.tvMore.setVisibility(4);
      this.o.ivMore.setVisibility(8);
      this.o.llHello.setOnClickListener(null);
      this.o.mScrollView.setOnReleaseListener(null);
      this.o.tvHelloMore.setVisibility(8);
    } 
    U();
  }
  
  public void a(CallMeStatusData paramCallMeStatusData) {
    if (this.p.getVisibility() == 0) {
      TextView textView;
      if (this.q == null)
        return; 
      CallHelloManager.a().a(paramCallMeStatusData);
      Y();
      int i = paramCallMeStatusData.call_status;
      if (i != 0) {
        if (i != 1)
          if (i != 2) {
            if (i != 4) {
              if (i != 5)
                return; 
              this.q.iv_call_default.setVisibility(8);
              this.q.tv_call_me_btn.setText("");
              this.q.tv_call_me_btn.setBackgroundResource(2131232397);
              this.q.tv_hint.setText(getResources().getString(2131756508));
              return;
            } 
          } else {
            this.q.iv_call_default.setVisibility(8);
            this.q.tv_call_me_btn.setText("");
            this.q.tv_call_me_btn.setBackgroundResource(2131232404);
            this.q.tv_hint.setText(getResources().getString(2131755719));
            return;
          }  
        this.q.iv_call_default.setVisibility(8);
        if (paramCallMeStatusData.multiples >= 10.0F) {
          this.q.tv_call_me_btn.setText("10x");
        } else {
          float f = (new BigDecimal(paramCallMeStatusData.multiples)).setScale(1, 1).floatValue();
          textView = this.q.tv_call_me_btn;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(f);
          stringBuilder.append("x");
          textView.setText(stringBuilder.toString());
        } 
        this.q.tv_call_me_btn.setBackgroundResource(2131232398);
        CallHelloManager.a().a(getContext(), (IRequestHost)w_(), 2);
        return;
      } 
      if (((CallMeStatusData)textView).free_count != 0) {
        this.q.iv_call_default.setVisibility(0);
        this.q.tv_call_me_btn.setText("");
        this.q.tv_hint.setText(getResources().getString(2131756564));
        return;
      } 
      if (((CallMeStatusData)textView).pay_count != 0) {
        this.q.iv_call_default.setVisibility(8);
        TextView textView1 = this.q.tv_call_me_btn;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((CallMeStatusData)textView).pay_count);
        stringBuilder.append("");
        textView1.setText(stringBuilder.toString());
        this.q.tv_hint.setText(getResources().getString(2131758317));
        X();
        return;
      } 
      this.q.tv_hint.setText(getResources().getString(2131758317));
    } 
  }
  
  protected void a(HelloDataExtra paramHelloDataExtra) {
    HeaderViewHolder headerViewHolder = this.o;
    if (headerViewHolder == null)
      return; 
    headerViewHolder.gtvHelloTitle.setText(paramHelloDataExtra.main_title);
    this.o.tvMore.setText(paramHelloDataExtra.subheading);
  }
  
  protected void a(Boolean paramBoolean) {
    if (this.d == null)
      return; 
    if (paramBoolean.booleanValue()) {
      EventTrackMessage.a(MessageProtos.Event.MSG_VOCATIV_BTN_SHOW);
      this.p.setVisibility(0);
    } else {
      this.p.setVisibility(8);
    } 
    U();
  }
  
  protected void a(Integer paramInteger) {
    a(((MsgPresenter)s()).t(), paramInteger.intValue());
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(boolean paramBoolean, String paramString) {
    if (this.q != null) {
      if (this.p.getVisibility() != 0)
        return; 
      if (this.q.iv_call_default != null && this.q.tv_call_me_btn != null) {
        if (paramBoolean) {
          this.q.iv_call_default.setVisibility(8);
          this.q.tv_call_me_btn.setText(paramString);
          return;
        } 
        this.q.iv_call_default.setVisibility(0);
        this.q.tv_call_me_btn.setText("");
      } 
    } 
  }
  
  public void aL_() {
    super.aL_();
    View view2 = this.n;
    if (view2 != null)
      this.g.removeHeaderView(view2); 
    Iterator<Unbinder> iterator = this.z.iterator();
    while (iterator.hasNext())
      ((Unbinder)iterator.next()).unbind(); 
    this.z.clear();
    this.o = null;
    this.i = null;
    this.q = null;
    View view1 = this.p;
    if (view1 != null && view1.getParent() != null)
      ((ViewGroup)this.p.getParent()).removeView(this.p); 
  }
  
  public void b(int paramInt) {
    if (this.q != null) {
      if (this.p.getVisibility() != 0)
        return; 
      this.q.tv_hint.setText(TimeAndDateUtils.a(paramInt, false));
    } 
  }
  
  protected void b(HelloDataExtra paramHelloDataExtra) {
    if (this.o == null)
      return; 
    float f = paramHelloDataExtra.multiples;
    int i = paramHelloDataExtra.promote_person_num;
    this.o.llHello.setVisibility(8);
    this.o.rvHello.setVisibility(8);
    this.o.layoutNewHello.setVisibility(0);
    this.o.layoutNewHello.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            PrivilegeBuyDialogFragment.a(this.a.getContext(), 2);
          }
        });
    if (this.o.rtvMultiple != null) {
      float f1 = Float.valueOf(this.o.rtvMultiple.getText().toString()).floatValue();
      if (f1 == 0.0F && f > 1.0F) {
        this.o.rtvMultiple.a(f, 1.0F);
        this.o.rtvMultiple.setDecimals("0.0");
        this.o.rtvMultiple.setDuration(3000L);
        this.o.rtvMultiple.b();
      } else {
        this.o.rtvMultiple.setText(f1);
      } 
    } 
    if (this.o.rtvNum != null && i > 0) {
      int j = (int)this.o.rtvNum.getNowNumber();
      this.o.rtvNum.a(i, j);
      this.o.rtvNum.setDuration(3000L);
      this.o.rtvNum.b();
    } 
  }
  
  protected void b(Boolean paramBoolean) {
    MsgFilterView msgFilterView = this.msgFilterView;
    if (msgFilterView != null)
      msgFilterView.setNewMessageStatus(true); 
    if (paramBoolean.booleanValue())
      V(); 
  }
  
  public void b(boolean paramBoolean) {
    ((MsgPresenter)s()).a(paramBoolean);
  }
  
  public void b(boolean paramBoolean, String paramString) {}
  
  public void c(String paramString) {
    if ("msg".equals(paramString)) {
      this.w = 0;
      ListView listView = this.g;
      if (listView != null)
        listView.smoothScrollToPosition(0); 
      ((MsgPresenter)s()).x();
    } 
  }
  
  public void c(boolean paramBoolean) {
    ((MsgPresenter)s()).b(paramBoolean);
  }
  
  public void d(String paramString) {
    if ("msg".equals(paramString)) {
      F();
      a((AbsListView)this.g);
    } 
  }
  
  public void d(boolean paramBoolean) {
    ((MsgPresenter)s()).c(paramBoolean);
  }
  
  public void e(boolean paramBoolean) {
    ((MsgPresenter)s()).B();
    View view = this.msg_filter_guide_iv;
    if (view != null && view.getVisibility() == 0)
      this.msg_filter_guide_iv.setVisibility(8); 
    if (paramBoolean)
      ((MsgPresenter)s()).m(); 
  }
  
  public void f(boolean paramBoolean) {}
  
  public void g(boolean paramBoolean) {}
  
  public void h(boolean paramBoolean) {
    BluedPreferences.v(paramBoolean);
    P();
  }
  
  public void i(boolean paramBoolean) {}
  
  public void j(boolean paramBoolean) {}
  
  public void k() {
    ((MsgPresenter)s()).w();
  }
  
  public void k(boolean paramBoolean) {}
  
  protected void l() {
    a(new Runnable(this) {
          public void run() {
            MsgBoxGuidePop msgBoxGuidePop = new MsgBoxGuidePop(this.a.getContext());
            (new XPopup.Builder(this.a.getContext())).a((BasePopupView)msgBoxGuidePop).h();
            TextView textView = msgBoxGuidePop.c;
            if (textView != null && MsgFragment.d(this.a) != null)
              textView.setOnClickListener(new View.OnClickListener(this, msgBoxGuidePop) {
                    public void onClick(View param2View) {
                      this.a.p();
                      (MsgFragment.e(this.b.a)).tv_item0.performClick();
                    }
                  }); 
          }
        });
  }
  
  public void l(boolean paramBoolean) {}
  
  protected void m() {
    this.bottom_hint_view.a(5, null, new boolean[] { true });
  }
  
  public void m(boolean paramBoolean) {}
  
  protected void n() {
    RenrenPullToRefreshListView renrenPullToRefreshListView = this.pullRefresh;
    if (renrenPullToRefreshListView != null)
      renrenPullToRefreshListView.j(); 
  }
  
  public void n(boolean paramBoolean) {}
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    if (e) {
      m();
      e = false;
    } 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131298009) {
      switch (i) {
        default:
          return;
        case 2131300930:
          EventTrackMessage.a(MessageProtos.Event.MSG_MORE_ATTENTION_SETTING);
          this.j.d();
          TerminalActivity.d((Context)getActivity(), RemindSettingFragment.class, null);
          return;
        case 2131300929:
          EventTrackMessage.a(MessageProtos.Event.MSG_MORE_CLEAR);
          this.j.d();
          CommonAlertDialog.a(getContext(), getContext().getResources().getString(2131755498), getContext().getResources().getString(2131755596), getContext().getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
                public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                  MsgFragment.f(this.a).show();
                  ThreadManager.a().a(new ThreadExecutor(this, "ClearChatList") {
                        public void execute() {
                          ChatManager.getInstance().deleteAllSessions();
                          this.a.a.a(new Runnable(this) {
                                public void run() {
                                  if (MsgFragment.f(this.a.a.a) != null)
                                    MsgFragment.f(this.a.a.a).dismiss(); 
                                }
                              });
                        }
                      });
                }
              }getContext().getResources().getString(2131756057), null, null);
          return;
        case 2131300928:
          EventTrackMessage.a(MessageProtos.Event.MSG_MORE_IGNORE_UNREAD);
          this.j.d();
          CommonAlertDialog.a(getContext(), getString(2131756094), getString(2131758050), getString(2131756086), new DialogInterface.OnClickListener(this) {
                public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                  ChatManager.getInstance().ignoredNoReadNumAll();
                }
              },  getString(2131756057), null, null);
          return;
        case 2131300927:
          break;
      } 
      this.j.d();
      BluedURIRouterAdapter.goChatAndOpenMsgBox(getChildFragmentManager(), 0);
      EventTrackMessage.a(MessageProtos.Event.MSG_MORE_NO_DISTURB_CLICK);
      if (!BluedPreferences.ca()) {
        BluedPreferences.bZ();
        this.i.iv_msg_box_red_point.setVisibility(4);
        ImageView imageView = this.v;
        if (imageView != null && imageView instanceof ImageView) {
          imageView.setImageDrawable(BluedSkinUtils.b(getContext(), 2131232748));
          return;
        } 
      } 
    } else {
      EventTrackMessage.a(MessageProtos.Event.MSG_MORE_OPEN_LOOK_QUIET);
      this.j.d();
      if (!BluedPreferences.ar() && (UserInfo.a().i()).vip_grade != 2 && (BluedConfig.b().j()).is_view_secretly == 0) {
        PayUtils.a((Context)getActivity(), 13, "chat_msg_quiet_all");
        InstantLog.a("msg_view_secretly_all_click", 0);
        return;
      } 
      InstantLog.a("msg_view_secretly_all_click", 1);
      IPrivacySettingContract.IPresenter iPresenter = this.s;
      if (iPresenter != null)
        iPresenter.a(true ^ BluedPreferences.ar(), false); 
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    LiveEventBus.get("click_right_pop_menu", View.class).observe((LifecycleOwner)this, new MenuObserver());
    LiveEventBus.get("clear_message_chat", Void.class).observe((LifecycleOwner)this, new IgnoredNoReadMsgObserver());
    ((HomeViewModel)ViewModelProviders.of(getActivity()).get(HomeViewModel.class)).a.observe((LifecycleOwner)this, new Observer<Integer>(this) {
          public void a(Integer param1Integer) {
            PushChecker.a().a(this.a.getContext(), 0, MessageProtos.WarnTime.UNREAD_FIRST);
          }
        });
    LiveEventBus.get("refresh_session_list", Void.class).observe((LifecycleOwner)this, new Observer<Void>(this) {
          public void a(Void param1Void) {
            ((MsgPresenter)this.a.s()).w();
          }
        });
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public void onPause() {
    super.onPause();
  }
  
  public void onResume() {
    super.onResume();
    CommonNotification.a();
    InstantLog.a("session_list_show");
    ((MsgPresenter)s()).A();
    this.pullRefresh.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131100728));
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt1 + paramInt2 == paramInt3)
      this.y = true; 
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void onStart() {
    super.onStart();
    ChatManager.getInstance().registerIMStatusListener((IMStatusListener)this.u);
    ((MsgPresenter)s()).y();
  }
  
  public void onStop() {
    super.onStop();
    ((MsgPresenter)s()).z();
    ChatManager.getInstance().unregisterIMStatusListener((IMStatusListener)this.u);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    paramView.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131100728));
    PushChecker.a().a(this.o.anim_hint_view, 0, MessageProtos.WarnTime.TOAST_MSG);
    PushChecker.a().a(this.o.anim_hint_view, 2, MessageProtos.WarnTime.TOAST_MSG);
    P();
    if (S())
      ((MsgPresenter)s()).x(); 
  }
  
  public int p() {
    return 2131493231;
  }
  
  public boolean z() {
    return true;
  }
  
  public class HeaderViewHolder {
    @BindView(2131296444)
    public TranslationAnimHintView anim_hint_view;
    
    @BindView(2131297330)
    public TextView gtvHelloTitle;
    
    @BindView(2131297863)
    public ImageView ivMore;
    
    @BindView(2131298079)
    public ConstraintLayout layoutNewHello;
    
    @BindView(2131298877)
    public LinearLayout llHello;
    
    @BindView(2131298988)
    public NoDataAndLoadFailView ll_nodata_chats;
    
    @BindView(2131299842)
    public HorizontalScrollView mScrollView;
    
    @BindView(2131299710)
    public RelativeLayout rlHelloEmpty;
    
    @BindView(2131299764)
    public RiseNumberTextView rtvMultiple;
    
    @BindView(2131299765)
    public RiseNumberTextView rtvNum;
    
    @BindView(2131297370)
    public RecyclerView rvHello;
    
    @BindView(2131299868)
    public ShapeLinearLayout searchLayout;
    
    @BindView(2131300042)
    public ViewStub stub_push_remind;
    
    @BindView(2131300043)
    public ViewStub stub_push_remind_permanent;
    
    @BindView(2131300889)
    public VerticalTextView tvHelloMore;
    
    @BindView(2131301050)
    public TextView tvMore;
    
    public HeaderViewHolder(MsgFragment this$0) {}
  }
  
  public class HelloHeaderHolder {
    @BindView(2131297713)
    public ImageView iv_call_default;
    
    @BindView(2131300606)
    public TextView tv_call_me_btn;
    
    @BindView(2131300890)
    public TextView tv_hint;
    
    public HelloHeaderHolder(MsgFragment this$0) {}
  }
  
  class IgnoredNoReadMsgObserver implements Observer<Void> {
    private IgnoredNoReadMsgObserver(MsgFragment this$0) {}
    
    public void a(Void param1Void) {
      if (MsgFragment.h(this.a) != null)
        MsgFragment.h(this.a).a(); 
      this.a.a(new Runnable(this) {
            public void run() {
              ((MsgPresenter)this.a.a.s()).v();
            }
          },  600L);
    }
  }
  
  class null implements Runnable {
    null(MsgFragment this$0) {}
    
    public void run() {
      ((MsgPresenter)this.a.a.s()).v();
    }
  }
  
  class MenuObserver implements Observer<View> {
    private MenuObserver(MsgFragment this$0) {}
    
    public void a(View param1View) {
      MsgFragment.a(this.a, (ImageView)param1View);
      EventTrackMessage.a(MessageProtos.Event.MSG_MORE_BTN_CLICK);
      if (MsgFragment.i(this.a).a()) {
        MsgFragment.i(this.a).d();
        return;
      } 
      MsgFragment.i(this.a).a(param1View);
    }
  }
  
  public class MenuViewHolder {
    @BindView(2131297864)
    public ImageView iv_msg_box_red_point;
    
    @BindView(2131298009)
    public RelativeLayout lay_item4;
    
    @BindView(2131300927)
    public RelativeLayout tv_item0;
    
    @BindView(2131300928)
    public TextView tv_item1;
    
    @BindView(2131300929)
    public TextView tv_item2;
    
    @BindView(2131300930)
    public TextView tv_item3;
    
    @BindView(2131300931)
    public TextView tv_item4;
    
    public MenuViewHolder(MsgFragment this$0) {}
  }
  
  class MsgConnectListener extends StableIMConnectListener {
    private MsgConnectListener(MsgFragment this$0) {}
    
    public void onUIConnected() {
      Logger.c("MsgFragment", new Object[] { "onUIConnected-----" });
      if (MsgFragment.b(this.a) != null && (MsgFragment.b(this.a)).anim_hint_view != null && this.a.getContext() != null)
        (MsgFragment.b(this.a)).anim_hint_view.a(4); 
    }
    
    public void onUIConnecting() {
      Logger.c("MsgFragment", new Object[] { "onUIConnecting-----" });
      if (MsgFragment.b(this.a) != null && (MsgFragment.b(this.a)).anim_hint_view != null && this.a.getContext() != null)
        (MsgFragment.b(this.a)).anim_hint_view.a(4, this.a.getContext().getResources().getString(2131755803)); 
    }
    
    public void onUIDisconnected() {
      Logger.c("MsgFragment", new Object[] { "onUIDisconnected-----" });
      if (MsgFragment.b(this.a) != null && (MsgFragment.b(this.a)).anim_hint_view != null && this.a.getContext() != null)
        (MsgFragment.b(this.a)).anim_hint_view.a(4, this.a.getContext().getResources().getString(2131755806)); 
    }
    
    public void onUIReceiving() {
      Logger.c("MsgFragment", new Object[] { "onUIReceiving-----" });
      if (MsgFragment.b(this.a) != null && (MsgFragment.b(this.a)).anim_hint_view != null && this.a.getContext() != null)
        (MsgFragment.b(this.a)).anim_hint_view.a(4, this.a.getContext().getResources().getString(2131755809)); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\MsgFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */