package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveFansPrivilegeAdapater;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveFansGoodsModel;
import com.blued.android.module.live_china.model.LiveFansInfoModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.observer.LiveFansObserver;
import com.blued.android.module.live_china.presenter.LiveFansGuestPresent;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class LiveFansGuestFragment extends MvpFragment<LiveFansGuestPresent> implements View.OnClickListener {
  ImageView A;
  
  TextView B;
  
  TextView C;
  
  TextView D;
  
  TextView E;
  
  TextView F;
  
  ProgressBar G;
  
  TextView H;
  
  View I;
  
  TextView J;
  
  TextView K;
  
  View L;
  
  TextView M;
  
  TextView N;
  
  View O;
  
  TextView P;
  
  TextView Q;
  
  View R;
  
  TextView S;
  
  TextView T;
  
  View U;
  
  TextView V;
  
  TextView W;
  
  View X;
  
  TextView Y;
  
  TextView Z;
  
  ProgressBar aa;
  
  private long ab;
  
  private String ac;
  
  private int ad;
  
  private short ae;
  
  private LiveFansInfoModel af;
  
  private LiveGiftModel ag;
  
  private Context ah;
  
  View d;
  
  View e;
  
  View f;
  
  View g;
  
  TextView h;
  
  View i;
  
  View j;
  
  View n;
  
  View o;
  
  View p;
  
  View q;
  
  ImageView r;
  
  RecyclerView s;
  
  View t;
  
  TextView u;
  
  TextView v;
  
  View w;
  
  View x;
  
  View y;
  
  View z;
  
  private void E() {
    this.f.setVisibility(8);
    this.g.setVisibility(8);
    this.h.setVisibility(8);
    this.i.setVisibility(8);
    this.j.setVisibility(0);
    this.o.setVisibility(8);
    this.q.setVisibility(8);
    this.y.setVisibility(8);
    this.w.setVisibility(8);
    this.n.setVisibility(0);
  }
  
  private void F() {
    if (this.af.is_take_gift == 1) {
      this.Z.setText(getString(R.string.live_fans_has_get));
      this.Z.setTextColor(getResources().getColor(R.color.syc_dark_w));
      this.Z.setBackground(null);
      return;
    } 
    this.Z.setText(getString(R.string.live_fans_to_get));
    this.Z.setTextColor(getResources().getColor(R.color.syc_dark_b));
    this.Z.setBackgroundResource(R.drawable.shape_fans_bg_b);
  }
  
  private void b(LiveFansInfoModel paramLiveFansInfoModel) {
    EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_NO_JOIN_PAGE_SHOW, String.valueOf(this.ab), LiveRoomInfo.a().f());
    this.h.setText(String.format(getString(R.string.live_fans_not_add_tip_1), new Object[] { paramLiveFansInfoModel.anchor_name, Integer.valueOf(paramLiveFansInfoModel.member_total) }));
    this.o.setVisibility(8);
    this.q.setVisibility(0);
    this.y.setVisibility(8);
    this.w.setVisibility(8);
    this.n.setVisibility(8);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.ah, 3);
    this.s.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    LiveFansPrivilegeAdapater liveFansPrivilegeAdapater = new LiveFansPrivilegeAdapater(this.ah, 1);
    this.s.setAdapter((RecyclerView.Adapter)liveFansPrivilegeAdapater);
    this.t.setOnClickListener(this);
  }
  
  private void c(LiveFansInfoModel paramLiveFansInfoModel) {
    this.h.setText(String.format(getString(R.string.live_fans_not_add_tip_1), new Object[] { paramLiveFansInfoModel.anchor_name, Integer.valueOf(paramLiveFansInfoModel.member_total) }));
    TextView textView = this.D;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLiveFansInfoModel.level);
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    this.E.setText(paramLiveFansInfoModel.name);
    this.o.setVisibility(8);
    this.q.setVisibility(8);
    this.y.setVisibility(8);
    this.w.setVisibility(0);
    this.n.setVisibility(8);
    this.x.setOnClickListener(this);
  }
  
  private void d(LiveFansInfoModel paramLiveFansInfoModel) {
    long l;
    EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_SHOW, String.valueOf(this.ab), LiveRoomInfo.a().f());
    this.h.setText(String.format(getString(R.string.live_fans_not_add_tip_1), new Object[] { paramLiveFansInfoModel.anchor_name, Integer.valueOf(paramLiveFansInfoModel.member_total) }));
    this.o.setVisibility(8);
    this.q.setVisibility(8);
    this.y.setVisibility(0);
    this.w.setVisibility(8);
    this.n.setVisibility(8);
    TextView textView = this.B;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramLiveFansInfoModel.level);
    stringBuilder1.append("");
    textView.setText(stringBuilder1.toString());
    this.C.setText(paramLiveFansInfoModel.name);
    this.F.setText(String.format(getString(R.string.live_fans_relation_day_top), new Object[] { Integer.valueOf(paramLiveFansInfoModel.relation_limit) }));
    if (paramLiveFansInfoModel.level < 6) {
      this.U.setVisibility(8);
    } else {
      this.U.setVisibility(0);
    } 
    try {
      float f = paramLiveFansInfoModel.relation;
      int i = paramLiveFansInfoModel.next_level_relation;
      l = (long)(f * 1.0F * 100.0F / i);
    } catch (ArithmeticException arithmeticException) {
      l = 0L;
    } 
    this.G.setProgress((int)l);
    this.H.setText(String.format(getString(R.string.live_fans_relation_all_level_info), new Object[] { Integer.valueOf(paramLiveFansInfoModel.relation), Integer.valueOf(paramLiveFansInfoModel.next_level_relation - paramLiveFansInfoModel.relation) }));
    this.J.setText(String.format(getString(R.string.live_fans_add_toady_get), new Object[] { Integer.valueOf(paramLiveFansInfoModel.normal_gift_relation) }));
    this.M.setText(String.format(getString(R.string.live_fans_add_toady_get), new Object[] { Integer.valueOf(paramLiveFansInfoModel.watch_relation) }));
    this.P.setText(String.format(getString(R.string.live_fans_add_toady_get), new Object[] { Integer.valueOf(paramLiveFansInfoModel.gift_relation) }));
    textView = this.S;
    String str = getString(R.string.live_fans_add_toady_get_str);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramLiveFansInfoModel.share_relation);
    stringBuilder2.append("/20");
    textView.setText(String.format(str, new Object[] { stringBuilder2.toString() }));
    this.V.setText(String.format(getString(R.string.live_fans_add_toady_get), new Object[] { Integer.valueOf(paramLiveFansInfoModel.ar_gift_relation) }));
    this.Y.setText(String.format(getString(R.string.live_fans_add_tip_6), new Object[] { Integer.valueOf(paramLiveFansInfoModel.gift_count) }));
    F();
  }
  
  private void l() {
    if (getArguments() != null) {
      this.ac = getArguments().getString("uid");
      this.ab = getArguments().getLong("lid");
      this.ad = getArguments().getInt("level");
      this.ae = getArguments().getShort("session_type");
    } 
  }
  
  private void m() {
    this.d = this.l.findViewById(R.id.ll_fans_title);
    this.e = this.l.findViewById(R.id.empty_view);
    this.f = this.l.findViewById(R.id.iv_fans_member);
    this.g = this.l.findViewById(R.id.iv_fans_member_back);
    this.h = (TextView)this.l.findViewById(R.id.tv_fans_title);
    this.i = this.l.findViewById(R.id.iv_fans_edit);
    this.j = this.l.findViewById(R.id.iv_fans_qa);
    this.n = this.l.findViewById(R.id.ll_fans_error);
    this.o = this.l.findViewById(R.id.ll_fans_disopen);
    this.p = this.l.findViewById(R.id.tv_fans_open);
    this.q = this.l.findViewById(R.id.ll_not_add);
    this.r = (ImageView)this.l.findViewById(R.id.iv_ticket);
    this.s = (RecyclerView)this.l.findViewById(R.id.rv_privilege);
    this.t = this.l.findViewById(R.id.tv_fans_add);
    this.u = (TextView)this.l.findViewById(R.id.tv_ticket_num);
    this.v = (TextView)this.l.findViewById(R.id.tv_ticket_name);
    this.w = this.l.findViewById(R.id.ll_re_open);
    this.x = this.l.findViewById(R.id.tv_fans_re_open);
    this.y = this.l.findViewById(R.id.ll_fans_added);
    this.z = this.l.findViewById(R.id.ll_level);
    this.A = (ImageView)this.l.findViewById(R.id.iv_heart);
    this.B = (TextView)this.l.findViewById(R.id.tv_level_num);
    this.C = (TextView)this.l.findViewById(R.id.tv_fans_name);
    this.D = (TextView)this.l.findViewById(R.id.tv_disopen_level_num);
    this.E = (TextView)this.l.findViewById(R.id.tv_disopen_fans_name);
    this.F = (TextView)this.l.findViewById(R.id.tv_bar_day_tip);
    this.G = (ProgressBar)this.l.findViewById(R.id.bar_fans);
    this.H = (TextView)this.l.findViewById(R.id.tv_bar_tip);
    this.I = this.l.findViewById(R.id.ll_to_wandou);
    this.J = (TextView)this.l.findViewById(R.id.tv_get_wandou);
    this.K = (TextView)this.l.findViewById(R.id.tv_to_wandou);
    this.L = this.l.findViewById(R.id.ll_to_look);
    this.M = (TextView)this.l.findViewById(R.id.tv_get_look);
    this.N = (TextView)this.l.findViewById(R.id.tv_to_look);
    this.O = this.l.findViewById(R.id.ll_to_yingguang);
    this.P = (TextView)this.l.findViewById(R.id.tv_get_yingguang);
    this.Q = (TextView)this.l.findViewById(R.id.tv_to_yingguang);
    this.R = this.l.findViewById(R.id.ll_to_share);
    this.S = (TextView)this.l.findViewById(R.id.tv_get_share);
    this.T = (TextView)this.l.findViewById(R.id.tv_to_share);
    this.U = this.l.findViewById(R.id.ll_to_gift);
    this.V = (TextView)this.l.findViewById(R.id.tv_get_gift);
    this.W = (TextView)this.l.findViewById(R.id.tv_to_gift);
    this.X = this.l.findViewById(R.id.ll_receive_yingguang);
    this.Y = (TextView)this.l.findViewById(R.id.tv_receive_yingguang);
    this.Z = (TextView)this.l.findViewById(R.id.tv_to_receive_yingguang);
    this.aa = (ProgressBar)this.l.findViewById(R.id.loading_view);
    this.f.setVisibility(0);
    this.f.setOnClickListener(this);
    this.g.setVisibility(8);
    this.o.setVisibility(8);
    this.q.setVisibility(8);
    this.y.setVisibility(8);
    this.w.setVisibility(8);
    this.n.setVisibility(8);
    this.K.setOnClickListener(this);
    this.T.setOnClickListener(this);
    this.W.setOnClickListener(this);
    this.N.setOnClickListener(this);
    this.Q.setOnClickListener(this);
    this.Z.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.e.setOnClickListener(this);
    if (!LiveRoomManager.a().k()) {
      EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_NO_FIVE_PAGE_SHOW, String.valueOf(this.ab), LiveRoomInfo.a().f());
      n();
      return;
    } 
    ((LiveFansGuestPresent)s()).a(this.ac, this.ab);
    ((LiveFansGuestPresent)s()).m();
  }
  
  private void n() {
    this.f.setVisibility(8);
    this.g.setVisibility(8);
    this.h.setVisibility(8);
    this.i.setVisibility(8);
    this.j.setVisibility(0);
    this.o.setVisibility(0);
    this.q.setVisibility(8);
    this.y.setVisibility(8);
    this.w.setVisibility(8);
    this.n.setVisibility(8);
    this.p.setOnClickListener(this);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    m();
  }
  
  public void a(LiveFansGoodsModel paramLiveFansGoodsModel) {
    Log.i("ddrb", "setLiveFansGoodsReceived");
    this.af.is_take_gift = 1;
    F();
    LiveEventBus.get("live_refresh_gift_list").post(Boolean.valueOf(true));
  }
  
  public void a(LiveFansInfoModel paramLiveFansInfoModel) {
    if (paramLiveFansInfoModel == null)
      return; 
    this.af = paramLiveFansInfoModel;
    if (paramLiveFansInfoModel.fans_status == 0) {
      b(paramLiveFansInfoModel);
    } else if (paramLiveFansInfoModel.fans_status == 1) {
      d(paramLiveFansInfoModel);
    } else if (paramLiveFansInfoModel.fans_status == 2) {
      c(paramLiveFansInfoModel);
    } 
    if (k() != null)
      for (Fragment fragment : k().getChildFragmentManager().getFragments()) {
        if (fragment instanceof LiveFansMemberFragment)
          ((LiveFansMemberFragment)fragment).a(paramLiveFansInfoModel); 
      }  
  }
  
  public void a(LiveGiftModel paramLiveGiftModel) {
    this.ag = paramLiveGiftModel;
    if (this.ag == null)
      return; 
    ImageLoader.a((IRequestHost)w_(), paramLiveGiftModel.images_static).a(R.color.syc_dark_a_l).a(this.r);
    this.v.setText(paramLiveGiftModel.name);
    TextView textView = this.u;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append((int)paramLiveGiftModel.beans);
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    this.aa.setVisibility(8);
    if (paramString == "LIVE_FANS_INFO" && !paramBoolean)
      E(); 
  }
  
  public void b(LiveGiftModel paramLiveGiftModel) {
    Log.i("ddrb", "setLiveFansAdded");
    LiveEventBus.get("live_fans_added").post("");
    ((LiveFansGuestPresent)s()).a(this.ac, this.ab);
  }
  
  public void b(String paramString) {
    super.b(paramString);
    this.aa.setVisibility(0);
  }
  
  public LiveFansGuestDialogFragment k() {
    return (getParentFragment() instanceof LiveFansGuestDialogFragment) ? (LiveFansGuestDialogFragment)getParentFragment() : null;
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == R.id.iv_fans_member) {
      if (getParentFragment() instanceof LiveFansGuestDialogFragment) {
        LiveFansGuestDialogFragment liveFansGuestDialogFragment = (LiveFansGuestDialogFragment)getParentFragment();
        if (liveFansGuestDialogFragment != null) {
          liveFansGuestDialogFragment.a(1);
          return;
        } 
      } 
    } else {
      if (i == R.id.tv_to_wandou) {
        EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_BTN_CLICK, LiveProtos.BtnType.SEND_WANDOU, String.valueOf(this.ab), LiveRoomInfo.a().f());
        ((LiveFansGuestPresent)s()).a(this.ac, LiveRoomInfo.a().f(), "1");
        if (k() != null)
          k().dismiss(); 
        LiveFansObserver.a().c();
        return;
      } 
      if (i == R.id.tv_to_look) {
        EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_BTN_CLICK, LiveProtos.BtnType.LOOK_LIVE, String.valueOf(this.ab), LiveRoomInfo.a().f());
        ((LiveFansGuestPresent)s()).a(this.ac, LiveRoomInfo.a().f(), "2");
        if (k() != null) {
          k().dismiss();
          return;
        } 
      } else {
        if (i == R.id.tv_to_yingguang) {
          EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_BTN_CLICK, LiveProtos.BtnType.SEND_GLOW_STICK, String.valueOf(this.ab), LiveRoomInfo.a().f());
          ((LiveFansGuestPresent)s()).a(this.ac, LiveRoomInfo.a().f(), "3");
          if (k() != null)
            k().dismiss(); 
          LiveFansObserver.a().c();
          return;
        } 
        if (i == R.id.tv_to_share) {
          EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_BTN_CLICK, LiveProtos.BtnType.SHARE_LIVE, String.valueOf(this.ab), LiveRoomInfo.a().f());
          ((LiveFansGuestPresent)s()).a(this.ac, LiveRoomInfo.a().f(), "4");
          if (k() != null)
            k().dismiss(); 
          LiveFansObserver.a().b();
          return;
        } 
        if (i == R.id.tv_to_gift) {
          EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_BTN_CLICK, LiveProtos.BtnType.SEND_CLUB_GIFT, String.valueOf(this.ab), LiveRoomInfo.a().f());
          ((LiveFansGuestPresent)s()).a(this.ac, LiveRoomInfo.a().f(), "5");
          if (k() != null)
            k().dismiss(); 
          LiveFansObserver.a().c();
          return;
        } 
        if (i == R.id.tv_to_receive_yingguang) {
          EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_BTN_CLICK, LiveProtos.BtnType.GET_GLOW_STICK, String.valueOf(this.ab), LiveRoomInfo.a().f());
          LiveFansInfoModel liveFansInfoModel = this.af;
          if (liveFansInfoModel != null && liveFansInfoModel.is_take_gift == 0) {
            ((LiveFansGuestPresent)s()).d(this.ac);
            return;
          } 
        } else {
          if (i == R.id.tv_fans_open) {
            EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_NO_FIVE_PAGE_GLOW_STICK_CLICK, String.valueOf(this.ab), LiveRoomInfo.a().f());
            if (k() != null)
              k().dismiss(); 
            LiveFansObserver.a().c();
            return;
          } 
          if (i == R.id.tv_fans_add) {
            EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_NO_JOIN_PAGE_SEND_JOIN_CLICK, String.valueOf(this.ab), LiveRoomInfo.a().f());
            if (this.ag != null) {
              ((LiveFansGuestPresent)s()).a(this.ab, this.ae, this.ac, this.ag);
              return;
            } 
          } else {
            if (i == R.id.tv_fans_re_open) {
              if (k() != null)
                k().dismiss(); 
              LiveFansObserver.a().c();
              return;
            } 
            if (i == R.id.iv_fans_qa) {
              if (k() != null) {
                k().f();
                return;
              } 
            } else if (i == R.id.empty_view && k() != null) {
              k().dismiss();
            } 
          } 
        } 
      } 
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.ah = getContext();
    l();
  }
  
  public int p() {
    return R.layout.live_fans_view;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveFansGuestFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */