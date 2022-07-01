package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.live_interface.IRewardConfigView;
import com.blued.android.module.live_china.manager.GrabRewardPayManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveRewardConfigModel;
import com.blued.android.module.live_china.model.LiveRewardConfigSumModel;
import com.blued.android.module.live_china.model.LiveRewardDescribe;
import com.blued.android.module.live_china.model.LiveRewardModel;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.module.live_china.presenter.LiveRewardConfigPresenter;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.InstantLog;
import java.util.HashMap;

public class PopRewardConfigView implements View.OnClickListener, IRewardConfigView {
  private ImageView A;
  
  private ImageView B;
  
  private ImageView C;
  
  private View D;
  
  private View E;
  
  private ImageView F;
  
  private ImageView G;
  
  private TextView H;
  
  private View I;
  
  private TextView J;
  
  private View K;
  
  private View L;
  
  private View M;
  
  private EditText N;
  
  private View O;
  
  private LinearLayout P;
  
  private LinearLayout Q;
  
  private ViewGroup R;
  
  private ViewGroup S;
  
  private ViewGroup T;
  
  private ImageView U;
  
  private ScaleAnimation V = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 2, 0.5F, 2, 0.5F);
  
  private ScaleAnimation W = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 2, 0.5F, 2, 0.5F);
  
  private boolean X;
  
  private LiveRewardConfigModel Y = new LiveRewardConfigModel();
  
  private HashMap<Integer, LiveRewardConfigSumModel> Z = new HashMap<Integer, LiveRewardConfigSumModel>();
  
  public View a;
  
  private TextWatcher aa = new TextWatcher(this) {
      private int b;
      
      private int c;
      
      public void afterTextChanged(Editable param1Editable) {
        this.b = PopRewardConfigView.f(this.a).getSelectionStart();
        this.c = PopRewardConfigView.f(this.a).getSelectionEnd();
        PopRewardConfigView.f(this.a).removeTextChangedListener(PopRewardConfigView.g(this.a));
        while (param1Editable.length() > 20) {
          param1Editable.delete(this.b - 1, this.c);
          this.b--;
          this.c--;
        } 
        PopRewardConfigView.f(this.a).setSelection(this.b);
        PopRewardConfigView.f(this.a).addTextChangedListener(PopRewardConfigView.g(this.a));
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  public View b;
  
  public View c;
  
  public Context d;
  
  public BaseFragment e;
  
  public LayoutInflater f;
  
  public RecordingOnliveFragment g;
  
  private MyPopupWindow h;
  
  private LinearLayout i;
  
  private ImageView j;
  
  private TextView k;
  
  private LinearLayout l;
  
  private ImageView m;
  
  private TextView n;
  
  private LinearLayout o;
  
  private ImageView p;
  
  private TextView q;
  
  private Button r;
  
  private Button s;
  
  private Button t;
  
  private ImageView u;
  
  private ImageView v;
  
  private ShapeFrameLayout w;
  
  private TextView x;
  
  private TextView y;
  
  private TextView z;
  
  public PopRewardConfigView(BaseFragment paramBaseFragment) {
    this.e = paramBaseFragment;
    this.d = paramBaseFragment.getContext();
    l();
    c();
    m();
  }
  
  public static PopRewardConfigView a(BaseFragment paramBaseFragment) {
    PopRewardConfigView popRewardConfigView;
    if (LiveFloatManager.a().B()) {
      popRewardConfigView = new PopRewardConfigCenterView(paramBaseFragment);
    } else {
      popRewardConfigView = new PopRewardConfigView((BaseFragment)popRewardConfigView);
    } 
    popRewardConfigView.d();
    return popRewardConfigView;
  }
  
  private void a(View paramView) {
    if (paramView.getId() == R.id.live_reward_num1) {
      this.Y.count = Integer.valueOf(this.r.getText().toString()).intValue();
    } else if (paramView.getId() == R.id.live_reward_num2) {
      this.Y.count = Integer.valueOf(this.s.getText().toString()).intValue();
    } else if (paramView.getId() == R.id.live_reward_num3) {
      this.Y.count = Integer.valueOf(this.t.getText().toString()).intValue();
    } 
    s();
  }
  
  private void b(View paramView) {
    LiveRewardConfigSumModel liveRewardConfigSumModel = this.Z.get(Integer.valueOf(paramView.getId()));
    if (liveRewardConfigSumModel != null) {
      this.Y.beans = liveRewardConfigSumModel.beans;
      this.Y.size = liveRewardConfigSumModel.size;
      this.Y.hb_beans_id = liveRewardConfigSumModel.hb_beans_id;
    } 
  }
  
  private void c(View paramView) {
    if (paramView.getId() == R.id.live_reward_sum_layout1) {
      this.i.setBackgroundResource(R.drawable.shape_live_round_red_solid);
      this.l.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
      this.o.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
      this.k.setTextColor(this.d.getResources().getColor(R.color.live_reward_bg));
      this.n.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
      this.q.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
      this.j.setImageResource(R.drawable.live_red_bean_icon);
      this.m.setImageResource(R.drawable.live_white_bean_icon);
      this.p.setImageResource(R.drawable.live_white_bean_icon);
      return;
    } 
    if (paramView.getId() == R.id.live_reward_sum_layout2) {
      this.i.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
      this.l.setBackgroundResource(R.drawable.shape_live_round_red_solid);
      this.o.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
      this.k.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
      this.n.setTextColor(this.d.getResources().getColor(R.color.live_reward_bg));
      this.q.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
      this.j.setImageResource(R.drawable.live_white_bean_icon);
      this.m.setImageResource(R.drawable.live_red_bean_icon);
      this.p.setImageResource(R.drawable.live_white_bean_icon);
      return;
    } 
    if (paramView.getId() == R.id.live_reward_sum_layout3) {
      this.i.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
      this.l.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
      this.o.setBackgroundResource(R.drawable.shape_live_round_red_solid);
      this.k.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
      this.n.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
      this.q.setTextColor(this.d.getResources().getColor(R.color.live_reward_bg));
      this.j.setImageResource(R.drawable.live_white_bean_icon);
      this.m.setImageResource(R.drawable.live_white_bean_icon);
      this.p.setImageResource(R.drawable.live_red_bean_icon);
      return;
    } 
    if (paramView.getId() == R.id.live_reward_num1) {
      this.r.setBackgroundResource(R.drawable.shape_live_round_red_solid);
      this.s.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
      this.t.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
      this.r.setTextColor(this.d.getResources().getColor(R.color.live_reward_bg));
      this.s.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
      this.t.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
      return;
    } 
    if (paramView.getId() == R.id.live_reward_num2) {
      this.r.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
      this.s.setBackgroundResource(R.drawable.shape_live_round_red_solid);
      this.t.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
      this.r.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
      this.s.setTextColor(this.d.getResources().getColor(R.color.live_reward_bg));
      this.t.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
      return;
    } 
    if (paramView.getId() == R.id.live_reward_num3) {
      this.r.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
      this.s.setBackgroundResource(R.drawable.shape_live_round_frame_lightwhite);
      this.t.setBackgroundResource(R.drawable.shape_live_round_red_solid);
      this.r.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
      this.s.setTextColor(this.d.getResources().getColor(R.color.nafio_b));
      this.t.setTextColor(this.d.getResources().getColor(R.color.live_reward_bg));
    } 
  }
  
  private void l() {
    this.f = LayoutInflater.from(this.d);
    b();
    this.b = this.a.findViewById(R.id.tv_bg);
    this.b.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.c = this.a.findViewById(R.id.ll_content);
    this.c.setVisibility(8);
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.h = new MyPopupWindow(this, this.a, -1, -1, true);
    this.h.setBackgroundDrawable(this.d.getResources().getDrawable(17170445));
    this.h.setTouchable(true);
    this.h.setOutsideTouchable(true);
    this.h.setFocusable(true);
    this.h.update();
    this.i = (LinearLayout)this.a.findViewById(R.id.live_reward_sum_layout1);
    this.j = (ImageView)this.a.findViewById(R.id.live_reward_sum_image1);
    this.k = (TextView)this.a.findViewById(R.id.live_reward_sum1);
    this.l = (LinearLayout)this.a.findViewById(R.id.live_reward_sum_layout2);
    this.m = (ImageView)this.a.findViewById(R.id.live_reward_sum_image2);
    this.n = (TextView)this.a.findViewById(R.id.live_reward_sum2);
    this.o = (LinearLayout)this.a.findViewById(R.id.live_reward_sum_layout3);
    this.p = (ImageView)this.a.findViewById(R.id.live_reward_sum_image3);
    this.q = (TextView)this.a.findViewById(R.id.live_reward_sum3);
    this.r = (Button)this.a.findViewById(R.id.live_reward_num1);
    this.s = (Button)this.a.findViewById(R.id.live_reward_num2);
    this.t = (Button)this.a.findViewById(R.id.live_reward_num3);
    this.u = (ImageView)this.a.findViewById(R.id.live_reward_condition);
    this.v = (ImageView)this.a.findViewById(R.id.live_fans_condition);
    this.w = (ShapeFrameLayout)this.a.findViewById(R.id.live_reward_send_btn);
    this.x = (TextView)this.a.findViewById(R.id.price_view);
    this.y = (TextView)this.a.findViewById(R.id.give_price_view);
    this.z = (TextView)this.a.findViewById(R.id.top_up_btn);
    this.A = (ImageView)this.a.findViewById(R.id.top_up_icon);
    this.B = (ImageView)this.a.findViewById(R.id.live_reward_help);
    this.C = (ImageView)this.a.findViewById(R.id.live_reward_close);
    this.R = (ViewGroup)this.a.findViewById(R.id.live_reward_loading);
    this.S = (ViewGroup)this.a.findViewById(R.id.live_reward_help_layout);
    this.T = (ViewGroup)this.a.findViewById(R.id.live_reward_config_layout);
    this.U = (ImageView)this.a.findViewById(R.id.live_reward_help_close);
    this.P = (LinearLayout)this.a.findViewById(R.id.ll_reward_condition);
    this.Q = (LinearLayout)this.a.findViewById(R.id.ll_fans_condition);
    this.D = this.a.findViewById(R.id.ll_gift);
    this.E = this.a.findViewById(R.id.ll_gift_tip);
    this.F = (ImageView)this.a.findViewById(R.id.iv_gift_delete);
    this.G = (ImageView)this.a.findViewById(R.id.iv_gift_add);
    this.H = (TextView)this.a.findViewById(R.id.tv_reward_gift_num);
    this.I = this.a.findViewById(R.id.ll_word);
    this.J = (TextView)this.a.findViewById(R.id.tv_word);
    this.K = this.a.findViewById(R.id.iv_word_icon);
    this.L = this.a.findViewById(R.id.ll_reward_word);
    this.M = this.a.findViewById(R.id.tv_word_cancel);
    this.N = (EditText)this.a.findViewById(R.id.et_word);
    this.N.setOnEditorActionListener(new TextView.OnEditorActionListener(this) {
          public boolean onEditorAction(TextView param1TextView, int param1Int, KeyEvent param1KeyEvent) {
            return (param1KeyEvent != null && param1KeyEvent.getKeyCode() == 66);
          }
        });
    this.O = this.a.findViewById(R.id.tv_word_ok);
    this.b.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.A.setOnClickListener(this);
    this.B.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.U.setOnClickListener(this);
    this.P.setOnClickListener(this);
    this.Q.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.J.setOnClickListener(this);
    this.M.setOnClickListener(this);
    this.O.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.K.setOnClickListener(this);
    s();
    this.K.setOnClickListener(this);
  }
  
  private void m() {
    this.V.setDuration(300L);
    this.W.setDuration(300L);
    this.V.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            if (PopRewardConfigView.b(this.a).getVisibility() == 0) {
              PopRewardConfigView.b(this.a).setAnimation(null);
              PopRewardConfigView.b(this.a).setVisibility(8);
              PopRewardConfigView.c(this.a).setVisibility(0);
              PopRewardConfigView.c(this.a).startAnimation((Animation)PopRewardConfigView.d(this.a));
              return;
            } 
            PopRewardConfigView.c(this.a).setAnimation(null);
            PopRewardConfigView.b(this.a).setVisibility(0);
            PopRewardConfigView.c(this.a).setVisibility(8);
            PopRewardConfigView.b(this.a).startAnimation((Animation)PopRewardConfigView.d(this.a));
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
  }
  
  private void n() {
    this.N.setText(this.J.getText());
    this.L.setVisibility(0);
    this.L.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_in));
    h();
  }
  
  private void o() {
    this.L.setVisibility(8);
    this.L.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_out));
    i();
  }
  
  private void p() {
    LiveCustomViewDialog liveCustomViewDialog = new LiveCustomViewDialog(this.d);
    View view = LayoutInflater.from(AppInfo.d()).inflate(R.layout.live_reward_gift_tip_view, null);
    ((TextView)view.findViewById(R.id.tv_reward_region_content)).setText(String.format(this.d.getString(R.string.live_reward_envelop), new Object[] { LiveRoomInfo.a().c() }));
    view.findViewById(R.id.iv_reward_region_close).setOnClickListener(new View.OnClickListener(this, liveCustomViewDialog) {
          public void onClick(View param1View) {
            this.a.dismiss();
          }
        });
    ((TextView)view.findViewById(R.id.tv_agree)).setOnClickListener(new View.OnClickListener(this, liveCustomViewDialog) {
          public void onClick(View param1View) {
            PopRewardConfigView.h(this.b);
            LiveRoomPreferences.U();
            this.a.dismiss();
          }
        });
    liveCustomViewDialog.a(view, null);
  }
  
  private void q() {
    if (t())
      return; 
    LiveRewardConfigModel liveRewardConfigModel = this.Y;
    liveRewardConfigModel.prize_total++;
    s();
  }
  
  private void r() {
    if (this.Y.prize_total <= 0)
      return; 
    LiveRewardConfigModel liveRewardConfigModel = this.Y;
    liveRewardConfigModel.prize_total--;
    s();
  }
  
  private void s() {
    int i = (int)(this.Y.count * 0.1F);
    LiveRewardConfigModel liveRewardConfigModel = this.Y;
    if (liveRewardConfigModel != null && liveRewardConfigModel.prize_total > i)
      this.Y.prize_total = i; 
    this.H.setText(String.valueOf(this.Y.prize_total));
    if (this.Y.prize_total == i) {
      this.G.setImageResource(R.drawable.live_reward_add_gray);
    } else {
      this.G.setImageResource(R.drawable.live_reward_add);
    } 
    if (this.Y.prize_total == 0) {
      this.F.setImageResource(R.drawable.live_reward_delete_gray);
      return;
    } 
    this.F.setImageResource(R.drawable.live_reward_delete);
  }
  
  private boolean t() {
    LiveRewardConfigModel liveRewardConfigModel = this.Y;
    return (liveRewardConfigModel != null && liveRewardConfigModel.prize_total >= this.Y.count * 0.1F);
  }
  
  public void a() {
    this.R.setVisibility(0);
  }
  
  public void a(double paramDouble1, double paramDouble2) {
    TextView textView = this.x;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("：");
    stringBuilder.append(CommonStringUtils.d(String.valueOf(paramDouble1 + paramDouble2)));
    stringBuilder.append(this.d.getString(R.string.Live_SendPresent_wandou));
    textView.setText(stringBuilder.toString());
    if (paramDouble2 > 0.0D) {
      this.y.setVisibility(0);
      textView = this.y;
      stringBuilder = new StringBuilder();
      stringBuilder.append("(");
      stringBuilder.append(String.format(this.d.getString(R.string.live_contain), new Object[] { CommonStringUtils.d(String.valueOf(paramDouble2)) }));
      stringBuilder.append(")");
      textView.setText(stringBuilder.toString());
    } 
  }
  
  public void a(LiveRewardConfigModel paramLiveRewardConfigModel) {
    this.R.setVisibility(8);
    if (paramLiveRewardConfigModel != null) {
      if (paramLiveRewardConfigModel.hb_beans != null)
        for (int i = 0; i < paramLiveRewardConfigModel.hb_beans.size(); i++) {
          LiveRewardConfigSumModel liveRewardConfigSumModel = paramLiveRewardConfigModel.hb_beans.get(i);
          if (i == 0) {
            this.i.setVisibility(0);
            TextView textView = this.k;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(liveRewardConfigSumModel.beans);
            stringBuilder.append("");
            textView.setText(stringBuilder.toString());
            this.Z.put(Integer.valueOf(this.i.getId()), liveRewardConfigSumModel);
            this.i.performClick();
          } else if (i == 1) {
            this.l.setVisibility(0);
            TextView textView = this.n;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(liveRewardConfigSumModel.beans);
            stringBuilder.append("");
            textView.setText(stringBuilder.toString());
            this.Z.put(Integer.valueOf(this.l.getId()), liveRewardConfigSumModel);
          } else if (i == 2) {
            this.o.setVisibility(0);
            TextView textView = this.q;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(liveRewardConfigSumModel.beans);
            stringBuilder.append("");
            textView.setText(stringBuilder.toString());
            this.Z.put(Integer.valueOf(this.o.getId()), liveRewardConfigSumModel);
          } 
        }  
      if (paramLiveRewardConfigModel.hb_count != null) {
        int i;
        for (i = 0; i < paramLiveRewardConfigModel.hb_count.length; i++) {
          int j = paramLiveRewardConfigModel.hb_count[i];
          if (i == 0) {
            this.r.setVisibility(0);
            Button button = this.r;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            stringBuilder.append("");
            button.setText(stringBuilder.toString());
          } else if (i == 1) {
            this.s.setVisibility(0);
            Button button = this.s;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            stringBuilder.append("");
            button.setText(stringBuilder.toString());
          } else if (i == 2) {
            this.t.setVisibility(0);
            Button button = this.t;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j);
            stringBuilder.append("");
            button.setText(stringBuilder.toString());
          } 
        } 
        i = paramLiveRewardConfigModel.hb_count.length;
        if (i != 1 && i != 2) {
          if (i != 3) {
            this.r.performClick();
          } else {
            this.s.performClick();
          } 
        } else {
          this.r.performClick();
        } 
      } 
      if (paramLiveRewardConfigModel.users_beans != null)
        a(paramLiveRewardConfigModel.users_beans.beans, paramLiveRewardConfigModel.users_beans.bonus); 
      if (paramLiveRewardConfigModel.hb_type == 1 || paramLiveRewardConfigModel.hb_type == 3)
        this.I.setVisibility(0); 
      if (paramLiveRewardConfigModel.hb_type == 2 || paramLiveRewardConfigModel.hb_type == 3) {
        this.D.setVisibility(0);
        this.E.setVisibility(0);
      } 
    } 
  }
  
  public void b() {
    this.a = this.f.inflate(R.layout.pop_reward, null);
  }
  
  public void c() {
    BaseFragment baseFragment = this.e;
    if (baseFragment instanceof RecordingOnliveFragment)
      this.g = (RecordingOnliveFragment)baseFragment; 
  }
  
  public void d() {
    this.b.clearAnimation();
    this.c.clearAnimation();
    if (this.h.isShowing())
      this.h.a(); 
    this.h.showAtLocation(this.c, 80, 0, 0);
    this.c.setVisibility(0);
    e();
  }
  
  public void e() {
    Logger.a("drb", new Object[] { "showAnim" });
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_in));
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            Logger.a("drb", new Object[] { "onAnimationEnd" });
            PopRewardConfigView popRewardConfigView = this.a;
            (new LiveRewardConfigPresenter(popRewardConfigView, (IRequestHost)popRewardConfigView.e.w_())).a();
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.b.startAnimation((Animation)alphaAnimation);
  }
  
  public void f() {
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            PopRewardConfigView.a(this.a).a();
          }
        },  320L);
    g();
    this.c.setVisibility(8);
  }
  
  public void g() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.b.startAnimation((Animation)alphaAnimation);
    this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_out));
  }
  
  public void h() {
    this.N.setFocusableInTouchMode(true);
    this.N.setFocusable(true);
    this.N.requestFocus();
    ((InputMethodManager)this.e.getActivity().getSystemService("input_method")).showSoftInput((View)this.N, 0);
  }
  
  public void i() {
    ((InputMethodManager)this.e.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.N.getWindowToken(), 0);
  }
  
  public void j() {}
  
  public void k() {}
  
  public void onClick(View paramView) {
    ShapeModel shapeModel;
    if (paramView.getId() == R.id.ll_reward_condition) {
      this.X = true;
      this.u.setImageResource(R.drawable.live_condition_select);
      this.v.setImageResource(R.drawable.live_reward_condition_default);
      this.Y.condition = "1|2";
      if (LiveRoomPreferences.h() == 0) {
        AppMethods.d(R.string.live_receive_conditions_details);
        LiveRoomPreferences.c(1);
      } 
      shapeModel = new ShapeModel();
      shapeModel.H = DensityUtils.a(this.d, 40.0F);
      shapeModel.k = ContextCompat.getColor(this.d, R.color.syc_dark_FFD4A3);
      this.w.setShapeModel(shapeModel);
      return;
    } 
    if (shapeModel.getId() == R.id.ll_fans_condition) {
      if (!LiveRoomManager.a().k()) {
        AppMethods.d(R.string.live_fans_reward_level_tip);
        return;
      } 
      this.X = true;
      this.u.setImageResource(R.drawable.live_reward_condition_default);
      this.v.setImageResource(R.drawable.live_condition_select);
      this.Y.condition = "3";
      shapeModel = new ShapeModel();
      shapeModel.H = DensityUtils.a(this.d, 40.0F);
      shapeModel.k = ContextCompat.getColor(this.d, R.color.syc_dark_FFD4A3);
      this.w.setShapeModel(shapeModel);
      return;
    } 
    if (shapeModel.getId() == R.id.live_reward_send_btn) {
      if (!this.X)
        return; 
      this.R.setVisibility(0);
      GrabRewardPayManager.a().a(this.d, (IRequestHost)this.g.w_(), this.Y, String.valueOf(this.g.u), LiveRoomInfo.a().f(), false, this.N.getText().toString(), new GrabRewardPayManager.BackGiftStatusListener(this) {
            public void a() {
              PopRewardConfigView.e(this.a).setVisibility(8);
            }
            
            public void a(PayRemaining param1PayRemaining, LiveRewardDescribe param1LiveRewardDescribe, LiveRewardConfigModel param1LiveRewardConfigModel) {
              this.a.g.a(new Runnable(this, param1PayRemaining, param1LiveRewardConfigModel, param1LiveRewardDescribe) {
                    public void run() {
                      PopRewardConfigView.e(this.d.a).setVisibility(8);
                      if (this.a.sendGiftStatus == 3) {
                        String str;
                        Logger.a("drb", new Object[] { "支付成功" });
                        LiveRewardConfigModel liveRewardConfigModel = this.b;
                        if (liveRewardConfigModel != null) {
                          str = liveRewardConfigModel.condition;
                        } else {
                          str = "";
                        } 
                        LiveRewardModel liveRewardModel = new LiveRewardModel(this.a.hongbao_id, this.a.start_second, this.a.end_second, this.a.is_anim, str);
                        this.d.a.g.bk.setData(liveRewardModel);
                        this.d.a.f();
                        if (this.a.is_anim == 1) {
                          LiveGiftModel liveGiftModel = new LiveGiftModel();
                          liveGiftModel.anim_code = "hongbao";
                          this.d.a.g.cG.d(liveGiftModel);
                          if (TextUtils.equals(this.b.size, "L")) {
                            liveGiftModel = new LiveGiftModel();
                            liveGiftModel.anim_code = this.a.ar_name;
                            liveGiftModel.resource_url = this.a.resource_url;
                            this.d.a.g.cG.a(liveGiftModel);
                          } 
                        } 
                        LiveRewardDescribe liveRewardDescribe = this.c;
                        if (liveRewardDescribe != null && liveRewardDescribe.m_hb_activity != null) {
                          if (this.c.m_hb_activity.stage == 1) {
                            RecordingOnliveFragment recordingOnliveFragment = this.d.a.g;
                            String str1 = this.d.a.d.getString(R.string.live_reward_special);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(this.c.m_hb_activity.need_count);
                            stringBuilder.append("");
                            recordingOnliveFragment.b(String.format(str1, new Object[] { stringBuilder.toString(), CommonStringUtils.d(Double.toString(this.c.m_hb_activity.beans)) }));
                            return;
                          } 
                          if (this.c.m_hb_activity.stage == 2) {
                            RecordingOnliveFragment recordingOnliveFragment = this.d.a.g;
                            String str1 = this.d.a.d.getString(R.string.live_reward_horn);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(this.c.m_hb_activity.need_count);
                            stringBuilder.append("");
                            recordingOnliveFragment.b(String.format(str1, new Object[] { stringBuilder.toString(), CommonStringUtils.d(Double.toString(this.c.m_hb_activity.beans)) }));
                          } 
                        } 
                      } 
                    }
                  });
            }
          });
      return;
    } 
    if (shapeModel.getId() == R.id.top_up_btn || shapeModel.getId() == R.id.top_up_icon) {
      if (this.g.f(true)) {
        f();
        InstantLog.a("charge_from_red_envelope");
        LiveRoomInfo.a().a(this.d, 3);
      } 
      return;
    } 
    if (shapeModel.getId() == R.id.live_reward_help) {
      this.T.startAnimation((Animation)this.V);
      return;
    } 
    if (shapeModel.getId() == R.id.live_reward_close) {
      f();
      return;
    } 
    if (shapeModel.getId() == R.id.live_reward_help_close) {
      this.S.startAnimation((Animation)this.V);
      return;
    } 
    if (shapeModel.getId() == R.id.live_reward_sum_layout1) {
      c((View)shapeModel);
      b((View)shapeModel);
      return;
    } 
    if (shapeModel.getId() == R.id.live_reward_sum_layout2) {
      c((View)shapeModel);
      b((View)shapeModel);
      return;
    } 
    if (shapeModel.getId() == R.id.live_reward_sum_layout3) {
      c((View)shapeModel);
      b((View)shapeModel);
      return;
    } 
    if (shapeModel.getId() == R.id.live_reward_num1) {
      c((View)shapeModel);
      a((View)shapeModel);
      return;
    } 
    if (shapeModel.getId() == R.id.live_reward_num2) {
      c((View)shapeModel);
      a((View)shapeModel);
      return;
    } 
    if (shapeModel.getId() == R.id.live_reward_num3) {
      c((View)shapeModel);
      a((View)shapeModel);
      return;
    } 
    if (shapeModel.getId() == R.id.tv_word) {
      n();
      return;
    } 
    if (shapeModel.getId() == R.id.iv_word_icon) {
      n();
      return;
    } 
    if (shapeModel.getId() == R.id.tv_bg) {
      if (this.L.getVisibility() == 0) {
        o();
        return;
      } 
      f();
      return;
    } 
    if (shapeModel.getId() == R.id.tv_word_cancel) {
      o();
      return;
    } 
    if (shapeModel.getId() == R.id.tv_word_ok) {
      if (this.N.length() > 20) {
        AppMethods.d(R.string.live_reward_word_hint);
        return;
      } 
      o();
      this.J.setText((CharSequence)this.N.getText());
      if (TextUtils.isEmpty(this.J.getText().toString())) {
        this.K.setVisibility(8);
        return;
      } 
      this.K.setVisibility(0);
      return;
    } 
    if (shapeModel.getId() == R.id.iv_gift_add) {
      if (!LiveRoomPreferences.T()) {
        p();
        return;
      } 
      q();
      return;
    } 
    if (shapeModel.getId() == R.id.iv_gift_delete) {
      r();
      return;
    } 
  }
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(PopRewardConfigView this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1View, param1Int1, param1Int2, param1Boolean);
    }
    
    public void a() {
      super.dismiss();
    }
    
    public void dismiss() {
      try {
        this.a.f();
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopRewardConfigView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */