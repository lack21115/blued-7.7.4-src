package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.RewardListAdapter;
import com.blued.android.module.live_china.contrast.LiveRewardDetailsContract;
import com.blued.android.module.live_china.fragment.PlayingOnliveBaseModeFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.live_interface.IFollowView;
import com.blued.android.module.live_china.live_interface.IGrabRewardView;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveRewardExtraModel;
import com.blued.android.module.live_china.model.LiveRewardListModel;
import com.blued.android.module.live_china.model.LiveRewardModel;
import com.blued.android.module.live_china.model.RewardDetailsCommonModel;
import com.blued.android.module.live_china.model.RewardErrorModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveKeyboardObserver;
import com.blued.android.module.live_china.observer.LiveRelationshipObserver;
import com.blued.android.module.live_china.observer.LiveRewardStatusObserver;
import com.blued.android.module.live_china.presenter.LiveFollowPresenter;
import com.blued.android.module.live_china.presenter.LiveGrabRewardPresenter;
import com.blued.android.module.live_china.presenter.LiveRewardDetailsPresenter;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.ishumei.sdk.captcha.SmCaptchaWebView;
import java.util.HashMap;
import java.util.List;

public class PopRewardListView implements View.OnClickListener, RenrenPullToRefreshListView.OnPullDownListener, LiveRewardDetailsContract.IView, IFollowView, IGrabRewardView, LiveKeyboardObserver.ILiveKeyboardObserver {
  private LinearLayout A;
  
  private LinearLayout B;
  
  private LinearLayout C;
  
  private TextView D;
  
  private FrameLayout E;
  
  private ImageView F;
  
  private ImageView G;
  
  private ImageView H;
  
  private TextView I;
  
  private TextView J;
  
  private LinearLayout K;
  
  private TextView L;
  
  private TextView M;
  
  private TextView N;
  
  private TextView O;
  
  private View P;
  
  private View Q;
  
  private ImageView R;
  
  private ImageView S;
  
  private SmCaptchaWebView T;
  
  private SmCaptchaWebView.ResultListener U;
  
  private SmCaptchaWebView.SmOption V;
  
  private String W;
  
  private View X;
  
  private View Y;
  
  private TextView Z;
  
  public View a;
  
  private View aa;
  
  private RewardListAdapter ab;
  
  private LiveRewardModel ac;
  
  private RewardDetailsCommonModel ad;
  
  private LiveRewardDetailsPresenter ae;
  
  private String af;
  
  private LiveRewardExtraModel ag;
  
  private OnPopEventCallBack ah;
  
  public LayoutInflater b;
  
  private View c;
  
  private View d;
  
  private Context e;
  
  private BaseFragment f;
  
  private RecordingOnliveFragment g;
  
  private PlayingOnliveBaseModeFragment h;
  
  private ActivityFragmentActive i;
  
  private boolean j;
  
  private long k;
  
  private MyPopupWindow l;
  
  private ImageView m;
  
  private RenrenPullToRefreshListView n;
  
  private ListView o;
  
  private LayoutInflater p;
  
  private View q;
  
  private View r;
  
  private ViewGroup s;
  
  private View t;
  
  private FrameLayout u;
  
  private ImageView v;
  
  private ImageView w;
  
  private ImageView x;
  
  private TextView y;
  
  private TextView z;
  
  public PopRewardListView(BaseFragment paramBaseFragment, LiveRewardModel paramLiveRewardModel) {
    this.f = paramBaseFragment;
    this.e = paramBaseFragment.getContext();
    this.ac = paramLiveRewardModel;
    p();
    j();
    if (paramLiveRewardModel.status == 2) {
      this.d.setVisibility(0);
      this.u.setVisibility(0);
      r();
      return;
    } 
    if (this.j || paramLiveRewardModel.status == 1) {
      Logger.a("drb", new Object[] { "PopRewardListView 红包详情" });
      this.d.setVisibility(0);
      this.s.setVisibility(0);
      this.u.setVisibility(8);
      this.t.setVisibility(0);
      this.E.setVisibility(0);
      ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
      if (LiveFloatManager.a().B()) {
        DensityUtils.a(this.e, 305.0F);
      } else {
        layoutParams.height = DensityUtils.a(this.e, 433.0F);
      } 
      this.d.setLayoutParams(layoutParams);
      this.ae.b();
      if (!this.j) {
        if (paramLiveRewardModel.is_prize == 1) {
          this.L.setText("1");
          this.H.setImageResource(R.drawable.live_reward_list_header_gift_icon);
          return;
        } 
        if (paramLiveRewardModel.beans > 0.0D) {
          this.L.setText(CommonStringUtils.d(Double.toString(paramLiveRewardModel.beans)));
          this.H.setImageResource(R.drawable.live_reward_list_header_bean_icon);
        } 
      } 
      return;
    } 
    if (!TextUtils.isEmpty(this.ac.pwd) && !this.ac.hasPwdTip) {
      this.d.setVisibility(8);
      this.X.setVisibility(0);
      if (LiveRoomManager.a().h() != null && (LiveRoomManager.a().h()).profile != null) {
        EventTrackLive.e(LiveProtos.Event.RED_BAG_GET_POP_SHOW, LiveRoomManager.a().c(), LiveRoomManager.a().e(), this.ac.pwd);
        return;
      } 
    } else {
      n();
      return;
    } 
  }
  
  public PopRewardListView(BaseFragment paramBaseFragment, LiveRewardModel paramLiveRewardModel, LiveRewardListModel paramLiveRewardListModel, RewardErrorModel paramRewardErrorModel) {
    this.f = paramBaseFragment;
    this.e = paramBaseFragment.getContext();
    this.ac = paramLiveRewardModel;
    p();
    j();
    if (paramRewardErrorModel != null) {
      a(paramRewardErrorModel.throwable, paramRewardErrorModel.statusCode, paramRewardErrorModel.content);
      return;
    } 
    if (paramLiveRewardListModel != null) {
      a(paramLiveRewardListModel);
      return;
    } 
    n();
  }
  
  public static PopRewardListView a(BaseFragment paramBaseFragment, LiveRewardModel paramLiveRewardModel) {
    PopRewardListView popRewardListView = new PopRewardListView(paramBaseFragment, paramLiveRewardModel);
    popRewardListView.k();
    return popRewardListView;
  }
  
  public static PopRewardListView a(BaseFragment paramBaseFragment, LiveRewardModel paramLiveRewardModel, LiveRewardListModel paramLiveRewardListModel, RewardErrorModel paramRewardErrorModel) {
    PopRewardListView popRewardListView = new PopRewardListView(paramBaseFragment, paramLiveRewardModel, paramLiveRewardListModel, paramRewardErrorModel);
    popRewardListView.k();
    return popRewardListView;
  }
  
  private void p() {
    Context context = this.e;
    if (context == null)
      return; 
    this.b = LayoutInflater.from(context);
    i();
    this.c = this.a.findViewById(R.id.tv_bg);
    this.c.setBackgroundColor(this.e.getResources().getColor(R.color.transparent));
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.d = this.a.findViewById(R.id.ll_content);
    this.d.setVisibility(8);
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.Q = this.a.findViewById(R.id.ll_identify);
    this.Q.setVisibility(8);
    this.R = (ImageView)this.a.findViewById(R.id.iv_close);
    this.S = (ImageView)this.a.findViewById(R.id.sm_refresh);
    this.T = (SmCaptchaWebView)this.a.findViewById(R.id.sm_captch);
    this.Q.post(new Runnable(this) {
          public void run() {
            PopRewardListView.a(this.a);
          }
        });
    this.X = this.a.findViewById(R.id.ll_word_tip);
    this.Y = this.a.findViewById(R.id.iv_word_tip_close);
    this.Z = (TextView)this.a.findViewById(R.id.tv_word_tip_content);
    this.Z.setText(String.format(this.e.getString(R.string.live_reward_receive_content), new Object[] { this.ac.pwd }));
    this.aa = this.a.findViewById(R.id.tv_word_tip_ok);
    this.l = new MyPopupWindow(this, this.a, -1, -1, true);
    this.l.setBackgroundDrawable(this.e.getResources().getDrawable(17170445));
    this.l.setTouchable(true);
    this.l.setOutsideTouchable(true);
    this.l.setFocusable(true);
    this.l.update();
    this.ab = new RewardListAdapter(this.f, this);
    this.p = (LayoutInflater)this.e.getSystemService("layout_inflater");
    this.m = (ImageView)this.a.findViewById(R.id.live_reward_close);
    this.n = (RenrenPullToRefreshListView)this.a.findViewById(R.id.live_reward_list);
    this.t = this.a.findViewById(R.id.live_reward_list_seat);
    this.s = (ViewGroup)this.a.findViewById(R.id.live_reward_title);
    this.n.setRefreshEnabled(false);
    this.n.setOnPullDownListener(this);
    this.o = (ListView)this.n.getRefreshableView();
    this.o.setDivider(null);
    this.o.setAdapter((ListAdapter)this.ab);
    this.q = this.p.inflate(R.layout.pop_reward_list_header, (ViewGroup)this.o, false);
    this.r = this.a.findViewById(R.id.pop_reward_list_footer);
    this.u = (FrameLayout)this.q.findViewById(R.id.reward_get_layout);
    this.v = (ImageView)this.q.findViewById(R.id.reward_get_bg);
    this.w = (ImageView)this.q.findViewById(R.id.reward_get_header);
    this.x = (ImageView)this.q.findViewById(R.id.reward_get_verify);
    this.y = (TextView)this.q.findViewById(R.id.reward_get_name);
    this.z = (TextView)this.q.findViewById(R.id.reward_get_follow_text);
    this.A = (LinearLayout)this.q.findViewById(R.id.reward_get_btn);
    this.B = (LinearLayout)this.q.findViewById(R.id.live_reward_get_loading);
    this.C = (LinearLayout)this.q.findViewById(R.id.live_reward_get_details_layout);
    this.D = (TextView)this.q.findViewById(R.id.reward_get_miss_text);
    this.E = (FrameLayout)this.q.findViewById(R.id.reward_detail_layout);
    this.F = (ImageView)this.q.findViewById(R.id.reward_detail_header);
    this.G = (ImageView)this.q.findViewById(R.id.reward_detail_verify);
    this.I = (TextView)this.q.findViewById(R.id.reward_detail_name);
    this.J = (TextView)this.q.findViewById(R.id.reward_detail_miss);
    this.K = (LinearLayout)this.q.findViewById(R.id.reward_detail_got);
    this.L = (TextView)this.q.findViewById(R.id.reward_detail_beans);
    this.H = (ImageView)this.q.findViewById(R.id.iv_gift_bens_icon);
    this.M = (TextView)this.q.findViewById(R.id.reward_detail_num);
    this.N = (TextView)this.q.findViewById(R.id.reward_detail_sum);
    this.O = (TextView)this.q.findViewById(R.id.reward_detail_time);
    this.P = this.q.findViewById(R.id.reward_detail__line);
    this.o.addHeaderView(this.q);
    this.m.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.R.setOnClickListener(this);
    this.S.setOnClickListener(this);
    this.aa.setOnClickListener(this);
    this.Y.setOnClickListener(this);
  }
  
  private void q() {
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this.u, "alpha", new float[] { 1.0F, 0.0F });
    objectAnimator.setDuration(100L);
    objectAnimator.start();
    objectAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) {
            super.onAnimationEnd(param1Animator);
            PopRewardListView.c(this.a).setVisibility(8);
          }
        });
    new ObjectAnimator();
    ValueAnimator valueAnimator = ObjectAnimator.ofInt(new int[] { DensityUtils.a(this.e, 340.0F), DensityUtils.a(this.e, 433.0F) });
    valueAnimator.setDuration(100L);
    valueAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = PopRewardListView.d(this.a).getLayoutParams();
            layoutParams.height = i;
            PopRewardListView.d(this.a).setLayoutParams(layoutParams);
          }
        });
    valueAnimator.start();
    this.s.setVisibility(0);
    this.t.setVisibility(0);
    this.E.setVisibility(0);
  }
  
  private void r() {
    this.D.setVisibility(0);
    this.C.setVisibility(0);
    this.J.setVisibility(0);
    this.K.setVisibility(8);
    this.A.setVisibility(8);
    this.z.setVisibility(8);
  }
  
  private void s() {
    String str = this.e.getString(R.string.biao_v1_lr_ver_sm_captcha);
    int i = DensityUtils.a(this.e, 300.0F);
    int j = (int)(i / 300.0D * 234.0D);
    ViewGroup.LayoutParams layoutParams = this.T.getLayoutParams();
    layoutParams.width = i;
    layoutParams.height = j;
    this.T.setLayoutParams(layoutParams);
    this.V = new SmCaptchaWebView.SmOption();
    this.V.setOrganization("qRLrIEyYwqE1vOhOACQy");
    this.V.setMode("slide");
    this.V.setAppId("1");
    this.V.setChannel(AppInfo.c);
    if (!BlueAppLocal.d()) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put("lang", "en");
      this.V.setExtOption(hashMap);
    } 
    if (!TextUtils.isEmpty(str))
      this.V.setTipMessage(str); 
    this.T.setBackgroundColor(0);
    this.U = new SmCaptchaWebView.ResultListener(this) {
        public void onError(int param1Int) {}
        
        public void onReady() {}
        
        public void onSuccess(CharSequence param1CharSequence, boolean param1Boolean) {
          EventTrackLive.a(LiveProtos.Event.LIVE_REDVERIFY_CONFIRM, String.valueOf(PopRewardListView.j(this.a)), PopRewardListView.k(this.a), param1Boolean);
          PopRewardListView.a(this.a, param1CharSequence.toString());
          param1CharSequence = new StringBuilder();
          param1CharSequence.append("onSuccess:");
          param1CharSequence.append(PopRewardListView.l(this.a));
          param1CharSequence.append("pass:");
          param1CharSequence.append(param1Boolean);
          Log.i("xpm", param1CharSequence.toString());
          if (param1Boolean) {
            PopRewardListView popRewardListView = this.a;
            (new LiveGrabRewardPresenter(popRewardListView, (IRequestHost)PopRewardListView.m(popRewardListView))).a((PopRewardListView.i(this.a)).hongbao_id, PopRewardListView.j(this.a), PopRewardListView.l(this.a), (PopRewardListView.i(this.a)).pwd);
            return;
          } 
          AppMethods.a(PopRewardListView.n(this.a).getString(R.string.live_reward_identify_fail), true);
        }
      };
  }
  
  private void t() {
    this.T.initWithOption(this.V, this.U);
    int i = SmCaptchaWebView.SMCAPTCHA_SUCCESS;
  }
  
  public void a() {}
  
  public void a(LiveRewardExtraModel paramLiveRewardExtraModel) {
    this.ag = paramLiveRewardExtraModel;
    if (this.j) {
      this.L.setText(CommonStringUtils.d(Double.toString(paramLiveRewardExtraModel.total_beans)));
      this.N.setText(String.format(this.e.getString(R.string.live_reward_got_num), new Object[] { CommonStringUtils.d(Double.toString(paramLiveRewardExtraModel.grab_beans)), CommonStringUtils.d(Double.toString(paramLiveRewardExtraModel.total_beans)) }));
      TextView textView = this.M;
      String str1 = this.e.getString(R.string.live_reward_got_num);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramLiveRewardExtraModel.grab_count);
      stringBuilder1.append("");
      String str2 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramLiveRewardExtraModel.total_count);
      stringBuilder2.append("");
      textView.setText(String.format(str1, new Object[] { str2, stringBuilder2.toString() }));
    } else {
      TextView textView = this.M;
      String str1 = this.e.getString(R.string.live_reward_get_num);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramLiveRewardExtraModel.grab_count);
      stringBuilder1.append("");
      String str2 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramLiveRewardExtraModel.total_count);
      stringBuilder2.append("");
      textView.setText(String.format(str1, new Object[] { str2, stringBuilder2.toString() }));
    } 
    if (paramLiveRewardExtraModel.has_grabbed == 1) {
      TextView textView = this.O;
      String str = this.e.getString(R.string.live_reward_got_secound);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramLiveRewardExtraModel.total_time);
      stringBuilder.append("");
      textView.setText(String.format(str, new Object[] { stringBuilder.toString() }));
    } 
    this.ab.a(paramLiveRewardExtraModel.lucky_uid);
  }
  
  public void a(LiveRewardListModel paramLiveRewardListModel) {
    Logger.a("rrrb", new Object[] { "抢红包完成 onGrabRewardComplete model = ", paramLiveRewardListModel });
    this.B.setVisibility(8);
    if (paramLiveRewardListModel != null)
      if (paramLiveRewardListModel.beans > 0.0D || paramLiveRewardListModel.is_prize == 1) {
        if (paramLiveRewardListModel.is_prize == 1) {
          this.L.setText("1");
          this.H.setImageResource(R.drawable.live_reward_list_header_gift_icon);
        } else if (paramLiveRewardListModel.beans > 0.0D) {
          this.L.setText(CommonStringUtils.d(Double.toString(paramLiveRewardListModel.beans)));
          this.H.setImageResource(R.drawable.live_reward_list_header_bean_icon);
        } 
        this.ac.beans = paramLiveRewardListModel.beans;
        this.ac.is_prize = paramLiveRewardListModel.is_prize;
        if (LiveFloatManager.a().B()) {
          this.u.setVisibility(8);
          this.s.setVisibility(0);
          this.t.setVisibility(0);
          this.E.setVisibility(0);
        } else {
          q();
        } 
        this.ae.b();
        LiveRewardStatusObserver.a().a(1);
      } else {
        Logger.a("rrrb", new Object[] { "抢红包完成 showAlreadyGoneView" });
        r();
        LiveRewardStatusObserver.a().a(2);
      }  
    if (this.Q.getVisibility() == 0)
      EventTrackLive.a(LiveProtos.Event.LIVE_REDVERIFY_CONFIRM_RED_RESULT, String.valueOf(this.k), this.af, true); 
    this.d.setVisibility(0);
    this.Q.setVisibility(8);
  }
  
  public void a(OnPopEventCallBack paramOnPopEventCallBack) {
    this.ah = paramOnPopEventCallBack;
  }
  
  public void a(String paramString1, String paramString2) {
    Logger.a("rrrb", new Object[] { "关注结束 onFollowComplete" });
    if (CommonStringUtils.c(paramString1) == LiveRoomManager.a().d()) {
      if ("1".equals(paramString2) || "3".equals(paramString2)) {
        LiveMsgSendManager.a().j();
        LiveRelationshipObserver.a().a(paramString2, paramString1);
        (new LiveGrabRewardPresenter(this, (IRequestHost)this.i)).a(this.ac.hongbao_id, this.k, "", this.ac.pwd);
        Logger.a("rrrb", new Object[] { "关注结束 开始抢红包" });
        return;
      } 
      Logger.a("rrrb", new Object[] { "关注结束 状态不对" });
      return;
    } 
    Logger.a("rrrb", new Object[] { "关注结束 uid不同" });
  }
  
  public void a(Throwable paramThrowable, int paramInt, String paramString) {
    if (this.Q.getVisibility() == 0)
      EventTrackLive.a(LiveProtos.Event.LIVE_REDVERIFY_CONFIRM_RED_RESULT, String.valueOf(this.k), this.af, false); 
    this.B.setVisibility(8);
    Pair pair = BluedHttpUtils.a(paramThrowable, paramInt, paramString);
    if (((Integer)pair.first).intValue() == 4032014) {
      this.u.setVisibility(0);
      this.z.setVisibility(0);
      this.A.setVisibility(0);
      this.d.setVisibility(0);
      this.Q.setVisibility(8);
      return;
    } 
    if (((Integer)pair.first).intValue() == 4032015) {
      m();
      AppMethods.a(this.e.getString(R.string.live_live_receive_conditions_toast), true);
      return;
    } 
    if (((Integer)pair.first).intValue() == 4032021) {
      EventTrackLive.a(LiveProtos.Event.LIVE_REDVERIFY_SHOW, String.valueOf(this.k), this.af);
      AppInfo.n().postDelayed(new Runnable(this) {
            public void run() {
              PopRewardListView.d(this.a).setVisibility(8);
              PopRewardListView.e(this.a).setVisibility(0);
              PopRewardListView.f(this.a);
            }
          },  300L);
      return;
    } 
    if (((Integer)pair.first).intValue() == 4032022) {
      this.d.setVisibility(8);
      this.Q.setVisibility(0);
      this.T.reloadCaptcha();
      AppMethods.a(this.e.getString(R.string.live_reward_identify_fail), true);
      return;
    } 
    Logger.a("rrrb", new Object[] { "抢红包失败 onGrabRewardFailed" });
    if (this.Q.getVisibility() == 0) {
      n();
    } else {
      m();
    } 
    BluedHttpUtils.b(paramThrowable, paramInt, paramString);
  }
  
  public void a(List<LiveRewardListModel> paramList, boolean paramBoolean) {
    Logger.a("rrrb", new Object[] { "红包详情 notifyListUpdate" });
    this.d.setVisibility(0);
    if (paramList != null) {
      Logger.a("rrrb", new Object[] { "红包详情 notifyListUpdate = ", Integer.valueOf(paramList.size()) });
      if (!paramBoolean) {
        if (!this.j) {
          InstantLog.a("view_history_from_red_envelope", 0);
        } else {
          InstantLog.a("view_history_from_red_envelope", 1);
        } 
        this.ab.a(paramList);
        return;
      } 
      this.ab.b(paramList);
      return;
    } 
    Logger.a("rrrb", new Object[] { "红包详情 notifyListUpdate = null" });
    this.ab.notifyDataSetChanged();
  }
  
  public void b() {
    RewardDetailsCommonModel rewardDetailsCommonModel = this.ad;
    rewardDetailsCommonModel.page++;
    LiveRewardExtraModel liveRewardExtraModel = this.ag;
    if (liveRewardExtraModel != null)
      this.ad.last_record_id = liveRewardExtraModel.last_record_id; 
    this.ae.b();
  }
  
  public void c() {
    this.n.p();
  }
  
  public void d() {
    this.n.q();
  }
  
  public void e() {
    this.n.o();
  }
  
  public void f() {
    this.B.setVisibility(0);
  }
  
  public void g() {
    m();
  }
  
  public void h() {}
  
  public void i() {
    if (this.e == null)
      return; 
    if (LiveFloatManager.a().B()) {
      this.a = this.b.inflate(R.layout.pop_reward_list_center, null);
      return;
    } 
    this.a = this.b.inflate(R.layout.pop_reward_list, null);
  }
  
  public void j() {
    if (LiveRoomManager.a().h() != null && (LiveRoomManager.a().h()).profile != null)
      this.af = LiveRoomManager.a().e(); 
    BaseFragment baseFragment = this.f;
    if (baseFragment instanceof RecordingOnliveFragment) {
      this.j = true;
      this.g = (RecordingOnliveFragment)baseFragment;
      this.i = this.g.w_();
      this.k = this.g.u;
      this.r.setVisibility(0);
      this.I.setText(String.format(this.e.getString(R.string.live_reward_master_name), new Object[] { LiveRoomInfo.a().c() }));
      ImageLoader.a(null, LiveRoomInfo.a().d()).a(R.drawable.user_bg_round).c().a(this.F);
      LiveRoomInfo.a().a(this.G, LiveRoomInfo.a().r());
    } else if (baseFragment instanceof PlayingOnliveBaseModeFragment) {
      this.j = false;
      this.h = (PlayingOnliveBaseModeFragment)baseFragment;
      this.i = this.h.w_();
      this.k = this.h.y;
      if (!LiveRoomManager.a().l()) {
        this.y.setText(String.format(this.e.getString(R.string.live_reward_master_name), new Object[] { (LiveRoomManager.a().h()).profile.name }));
        this.I.setText(String.format(this.e.getString(R.string.live_reward_master_name), new Object[] { (LiveRoomManager.a().h()).profile.name }));
        ImageLoader.a(null, (LiveRoomManager.a().h()).profile.avatar).a(R.drawable.user_bg_round).c().a(this.w);
        ImageLoader.a(null, (LiveRoomManager.a().h()).profile.avatar).a(R.drawable.user_bg_round).c().a(this.F);
        LiveRoomInfo.a().a(this.x, (LiveRoomManager.a().h()).profile.vbadge);
        LiveRoomInfo.a().a(this.G, (LiveRoomManager.a().h()).profile.vbadge);
      } 
    } 
    this.ad = new RewardDetailsCommonModel();
    this.ae = new LiveRewardDetailsPresenter(this.e, this, (IRequestHost)this.i, this.ad, String.valueOf(this.ac.hongbao_id), this.k);
    LiveKeyboardObserver.a().a(this);
  }
  
  public void k() {
    this.c.clearAnimation();
    this.d.clearAnimation();
    if (this.l.isShowing())
      this.l.a(); 
    this.l.showAtLocation(this.d, 81, 0, 0);
    l();
  }
  
  public void l() {
    this.d.startAnimation(AnimationUtils.loadAnimation(this.e, R.anim.push_center_in));
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {}
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.c.startAnimation((Animation)alphaAnimation);
  }
  
  public void m() {
    LiveKeyboardObserver.a().b(this);
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            PopRewardListView.b(this.a).a();
          }
        },  320L);
    o();
    this.d.setVisibility(8);
  }
  
  public void n() {
    LiveKeyboardObserver.a().b(this);
    this.l.a();
  }
  
  public void o() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.c.startAnimation((Animation)alphaAnimation);
    this.d.startAnimation(AnimationUtils.loadAnimation(this.e, R.anim.push_center_out));
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.live_reward_close) {
      m();
      return;
    } 
    if (paramView.getId() == R.id.reward_get_btn) {
      if (!LiveRoomManager.a().l()) {
        f();
        (new LiveFollowPresenter(this, (IRequestHost)this.i, this.k)).a(LiveRoomManager.a().e());
        return;
      } 
    } else {
      if (paramView.getId() == R.id.live_reward_get_details_layout) {
        if (LiveFloatManager.a().B()) {
          this.u.setVisibility(8);
          this.s.setVisibility(0);
          this.t.setVisibility(0);
          this.E.setVisibility(0);
        } else {
          q();
        } 
        this.ae.b();
        return;
      } 
      if (paramView.getId() == R.id.iv_close) {
        AppMethods.a(this.e.getString(R.string.live_reward_identify_fail), true);
        n();
        return;
      } 
      if (paramView.getId() == R.id.sm_refresh) {
        t();
        return;
      } 
      if (paramView.getId() == R.id.iv_word_tip_close) {
        EventTrackLive.e(LiveProtos.Event.RED_BAG_GET_POP_CANCEL_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e(), this.ac.pwd);
        this.ac.hasAgreePwd = false;
        m();
        return;
      } 
      if (paramView.getId() == R.id.tv_word_tip_ok) {
        EventTrackLive.e(LiveProtos.Event.RED_BAG_GET_POP_CONFIRM_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e(), this.ac.pwd);
        this.ac.hasAgreePwd = true;
        m();
      } 
    } 
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(PopRewardListView this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1View, param1Int1, param1Int2, param1Boolean);
    }
    
    public void a() {
      if (PopRewardListView.g(this.a) != null && PopRewardListView.g(this.a).getActivity() != null && !PopRewardListView.g(this.a).getActivity().isFinishing()) {
        super.dismiss();
        if (PopRewardListView.h(this.a) != null) {
          if (!TextUtils.isEmpty((PopRewardListView.i(this.a)).pwd) && !(PopRewardListView.i(this.a)).hasPwdTip) {
            if ((PopRewardListView.i(this.a)).hasAgreePwd) {
              (PopRewardListView.i(this.a)).hasPwdTip = true;
              PopRewardListView.h(this.a).a(true);
              return;
            } 
            PopRewardListView.h(this.a).a(false);
            return;
          } 
          PopRewardListView.h(this.a).a(false);
        } 
      } 
    }
    
    public void dismiss() {
      try {
        this.a.m();
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
  
  public static interface OnPopEventCallBack {
    void a(boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopRewardListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */