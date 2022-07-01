package com.blued.android.module.live_china.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.AnimationUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live.base.fragment.LiveBaseDialogFragment;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveDataListManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.BluedLiveRankListData;
import com.blued.android.module.live_china.model.LiveCloseRecommendExtra;
import com.blued.android.module.live_china.model.LiveCloseRecommendModel;
import com.blued.android.module.live_china.model.LiveConsumeEntity;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;

public class LiveGuestFinishDlgFragment extends LiveBaseDialogFragment {
  private ImageView A;
  
  private ImageView B;
  
  private TextView C;
  
  private TextView D;
  
  private TextView E;
  
  private TextView F;
  
  private TextView G;
  
  private TextView H;
  
  private FrameLayout I;
  
  private LinearLayout J;
  
  private ImageView K;
  
  private ImageView L;
  
  private ImageView M;
  
  private TextView N;
  
  private TextView O;
  
  private TextView P;
  
  private TextView Q;
  
  private TextView R;
  
  private TextView S;
  
  private ImageView T;
  
  private ImageView U;
  
  private ImageView V;
  
  public ProgressBar i;
  
  public View j;
  
  public Button k;
  
  public ImageView l;
  
  public String m;
  
  public int n = 0;
  
  LiveUserRelationshipUtils.IAddOrRemoveAttentionDone o = new LiveUserRelationshipUtils.IAddOrRemoveAttentionDone(this) {
      public void R_() {}
      
      public void a(String param1String) {
        LiveGuestFinishDlgFragment.a(this.a, param1String);
      }
      
      public void b(String param1String) {
        LiveGuestFinishDlgFragment.a(this.a, param1String);
      }
      
      public void d() {}
      
      public void e() {}
    };
  
  private ImageView p;
  
  private TextView q;
  
  private TextView r;
  
  private LinearLayout s;
  
  private LinearLayout t;
  
  private LinearLayout u;
  
  private LinearLayout v;
  
  private ImageView w;
  
  private ImageView x;
  
  private ImageView y;
  
  private ImageView z;
  
  private void a(BluedLiveRankListData paramBluedLiveRankListData, View paramView, ImageView paramImageView1, ImageView paramImageView2, TextView paramTextView1, TextView paramTextView2, int paramInt) {
    EventTrackLive.b(LiveProtos.Event.USER_CONTRIBUTION_LIST_USER_SHOW, LiveRoomManager.a().c(), LiveRoomManager.a().e(), paramBluedLiveRankListData.uid);
    paramView.setOnClickListener(new -$$Lambda$LiveGuestFinishDlgFragment$PZwyKcqY90SyVFNQ-uciqws1vqo(paramBluedLiveRankListData));
    ImageLoader.a((IRequestHost)a(), paramBluedLiveRankListData.avatar).a(R.drawable.user_bg_round).c().a(paramImageView1);
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt == 3)
          paramImageView2.setImageResource(R.drawable.live_close_rank_header3); 
      } else {
        paramImageView2.setImageResource(R.drawable.live_close_rank_header2);
      } 
    } else {
      paramImageView2.setImageResource(R.drawable.live_close_rank_header1);
    } 
    paramTextView1.setText(paramBluedLiveRankListData.name);
    paramTextView2.setText(CommonStringUtils.a(paramBluedLiveRankListData.beans));
  }
  
  private void a(LiveCloseRecommendModel paramLiveCloseRecommendModel, ImageView paramImageView1, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView2) {
    if (LiveRoomManager.a().h() != null)
      EventTrackLive.a(LiveProtos.Event.USER_END_PAGE_RECOMMEND_ROOM_SHOW, LiveRoomManager.a().c(), LiveRoomManager.a().e(), paramLiveCloseRecommendModel.lid, paramLiveCloseRecommendModel.uid); 
    ImageLoader.a((IRequestHost)a(), paramLiveCloseRecommendModel.pic_url).a(R.drawable.user_bg_round).a(paramImageView1);
    paramTextView1.setText(paramLiveCloseRecommendModel.anchor.name);
    paramTextView2.setText(paramLiveCloseRecommendModel.realtime_count);
    if (paramLiveCloseRecommendModel.hb > 0) {
      paramImageView2.setVisibility(0);
      paramImageView2.setImageResource(R.drawable.live_list_grab_reward_icon);
    } else if (paramLiveCloseRecommendModel.link_type == 1) {
      paramImageView2.setVisibility(0);
      paramImageView2.setImageResource(R.drawable.live_list_pk_label);
    } else if (paramLiveCloseRecommendModel.link_type == 2) {
      paramImageView2.setVisibility(0);
      paramImageView2.setImageResource(R.drawable.live_list_make_friend_icon);
    } else {
      paramImageView2.setVisibility(8);
    } 
    paramImageView1.setOnClickListener(new -$$Lambda$LiveGuestFinishDlgFragment$6MKF_bIpHmjpfCfB_kyUl0smxt0(this, paramLiveCloseRecommendModel));
  }
  
  private void b(String paramString) {
    LiveRoomInfo.a().b(getContext(), this.o, paramString, o(), (IRequestHost)a());
  }
  
  private void c(String paramString) {
    if (LiveRoomManager.a().h() != null)
      (LiveRoomManager.a().h()).relationship = paramString; 
    if ("1".equals(paramString) || "3".equals(paramString)) {
      if (LiveRoomManager.a().h() != null)
        (LiveRoomManager.a().h()).isFollow = true; 
      this.r.setText(getString(R.string.followed));
    } else {
      if (LiveRoomManager.a().h() != null)
        (LiveRoomManager.a().h()).isFollow = false; 
      this.r.setText(getString(R.string.follow));
    } 
    LiveRoomInfo.a().s();
  }
  
  private void l() {
    m();
    LiveRoomInfo.a().a(getContext(), LiveRoomManager.a().e());
  }
  
  private void m() {
    LiveFloatManager.a().b(false);
    LiveFloatManager.a().n();
    if (getTargetFragment() != null && getTargetFragment() instanceof PlayingOnliveFragment)
      ((PlayingOnliveFragment)getTargetFragment()).aa(); 
  }
  
  private void n() {
    EventTrackLive.a(LiveProtos.Event.USER_END_PAGE_RECOMMEND_ROOM_CHANGE_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e());
    k();
  }
  
  private String o() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("liveanchor_");
    stringBuilder.append(LiveRoomManager.a().b());
    return stringBuilder.toString();
  }
  
  public boolean V_() {
    m();
    return true;
  }
  
  public void a(String paramString) {
    LiveRoomInfo.a().a(getContext(), this.o, paramString, o(), (IRequestHost)a());
  }
  
  public int f() {
    return R.layout.fragment_live_guest_finish;
  }
  
  public void g() {
    this.b.setOnClickListener(-$$Lambda$LiveGuestFinishDlgFragment$Vz04CSh1eqRVprew7vo0j0hV_1Q.INSTANCE);
    this.p = (ImageView)this.b.findViewById(R.id.live_guest_finish_anchor_header);
    this.q = (TextView)this.b.findViewById(R.id.live_guest_finish_anchor_name);
    this.k = (Button)this.b.findViewById(R.id.live_guest_finish_home_page_btn);
    this.l = (ImageView)this.b.findViewById(R.id.live_guest_finish_leave_btn);
    this.i = (ProgressBar)this.b.findViewById(R.id.live_guest_finish_loading_view);
    this.j = this.b.findViewById(R.id.live_guest_finish_no_data_rank);
    this.r = (TextView)this.b.findViewById(R.id.live_guest_finish_anchor_attention);
    this.s = (LinearLayout)this.b.findViewById(R.id.live_guest_finish_rank_root);
    this.t = (LinearLayout)this.b.findViewById(R.id.live_guest_finish_rank_layout1);
    this.w = (ImageView)this.b.findViewById(R.id.live_guest_finish_rank_header1);
    this.z = (ImageView)this.b.findViewById(R.id.live_guest_finish_rank_header_bg1);
    this.C = (TextView)this.b.findViewById(R.id.live_guest_finish_rank_name1);
    this.F = (TextView)this.b.findViewById(R.id.live_guest_finish_rank_dou1);
    this.u = (LinearLayout)this.b.findViewById(R.id.live_guest_finish_rank_layout2);
    this.x = (ImageView)this.b.findViewById(R.id.live_guest_finish_rank_header2);
    this.A = (ImageView)this.b.findViewById(R.id.live_guest_finish_rank_header_bg2);
    this.D = (TextView)this.b.findViewById(R.id.live_guest_finish_rank_name2);
    this.G = (TextView)this.b.findViewById(R.id.live_guest_finish_rank_dou2);
    this.v = (LinearLayout)this.b.findViewById(R.id.live_guest_finish_rank_layout3);
    this.y = (ImageView)this.b.findViewById(R.id.live_guest_finish_rank_header3);
    this.B = (ImageView)this.b.findViewById(R.id.live_guest_finish_rank_header_bg3);
    this.E = (TextView)this.b.findViewById(R.id.live_guest_finish_rank_name3);
    this.H = (TextView)this.b.findViewById(R.id.live_guest_finish_rank_dou3);
    this.I = (FrameLayout)this.b.findViewById(R.id.live_guest_finish_recommend_layout);
    this.K = (ImageView)this.b.findViewById(R.id.live_guest_finish_recommend_header1);
    this.N = (TextView)this.b.findViewById(R.id.live_guest_finish_recommend_name1);
    this.Q = (TextView)this.b.findViewById(R.id.live_guest_finish_recommend_count1);
    this.T = (ImageView)this.b.findViewById(R.id.live_guest_finish_recommend_icon1);
    View view1 = this.b.findViewById(R.id.live_guest_finish_recommend_header_layout1);
    this.L = (ImageView)this.b.findViewById(R.id.live_guest_finish_recommend_header2);
    this.O = (TextView)this.b.findViewById(R.id.live_guest_finish_recommend_name2);
    this.R = (TextView)this.b.findViewById(R.id.live_guest_finish_recommend_count2);
    this.U = (ImageView)this.b.findViewById(R.id.live_guest_finish_recommend_icon2);
    View view2 = this.b.findViewById(R.id.live_guest_finish_recommend_header_layout2);
    this.M = (ImageView)this.b.findViewById(R.id.live_guest_finish_recommend_header3);
    this.P = (TextView)this.b.findViewById(R.id.live_guest_finish_recommend_name3);
    this.S = (TextView)this.b.findViewById(R.id.live_guest_finish_recommend_count3);
    this.V = (ImageView)this.b.findViewById(R.id.live_guest_finish_recommend_icon3);
    View view3 = this.b.findViewById(R.id.live_guest_finish_recommend_header_layout3);
    LinearLayout linearLayout = (LinearLayout)this.b.findViewById(R.id.live_guest_finish_changed_layout);
    this.J = (LinearLayout)this.b.findViewById(R.id.live_guest_finish_changed_loading);
    int i = (AppInfo.l - DensityUtils.a(getContext(), 18.0F)) / 3;
    LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams)view1.getLayoutParams();
    layoutParams1.width = i;
    layoutParams1.height = i;
    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams)view2.getLayoutParams();
    layoutParams2.width = i;
    layoutParams2.height = i;
    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams)view3.getLayoutParams();
    layoutParams3.width = i;
    layoutParams3.height = i;
    view1.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    view2.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    view3.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    this.k.setOnClickListener(new -$$Lambda$LiveGuestFinishDlgFragment$LDMGPQ3xvx4HzRRQfSiI4I5zPcg(this));
    this.l.setOnClickListener(new -$$Lambda$LiveGuestFinishDlgFragment$F54IpRe3w911DEShvE2UQuz_4Ys(this));
    linearLayout.setOnClickListener(new -$$Lambda$LiveGuestFinishDlgFragment$m1SakXA2XOsr9PcbdYkZo2OuSZc(this));
    if (!LiveRoomManager.a().l()) {
      ImageLoader.a((IRequestHost)a(), (LiveRoomManager.a().h()).profile.avatar).a(R.drawable.user_bg_round).c().a(this.p);
      this.p.setOnClickListener(new -$$Lambda$LiveGuestFinishDlgFragment$OAHQmySn3FglFpA_Mecm92rg5j0(this));
      this.q.setText((LiveRoomManager.a().h()).profile.name);
      TextView textView = this.r;
      if ((LiveRoomManager.a().h()).isFollow) {
        i = R.string.followed;
      } else {
        i = R.string.follow;
      } 
      textView.setText(getString(i));
      if (!LiveRoomManager.a().l())
        EventTrackLive.a(LiveProtos.Event.LIVE_END_PAGE_FOLLOW_BTN_SHOW, LiveRoomManager.a().b(), LiveRoomManager.a().e(), EventTrackLive.a((LiveRoomManager.a().h()).relationship)); 
      this.r.setOnClickListener(new -$$Lambda$LiveGuestFinishDlgFragment$VlVWh_sHfM2KpTop68pmSxRzC2c(this));
    } 
    AnimationUtils.a(this.b);
  }
  
  public void h() {}
  
  public void i() {
    super.i();
    j();
    k();
  }
  
  public void j() {
    this.i.setVisibility(0);
    if (LiveRoomManager.a().h() == null) {
      this.i.setVisibility(8);
      this.j.setVisibility(0);
      return;
    } 
    LiveRoomHttpUtils.a(getContext(), LiveRoomManager.a().e(), LiveRoomManager.a().b(), 1, new BluedUIHttpResponse<LiveConsumeEntity<BluedLiveRankListData>>(this, (IRequestHost)a()) {
          public void a(LiveConsumeEntity<BluedLiveRankListData> param1LiveConsumeEntity) {
            if (param1LiveConsumeEntity.data != null && param1LiveConsumeEntity.data.size() > 0) {
              BluedLiveRankListData bluedLiveRankListData;
              this.a.j.setVisibility(8);
              LiveGuestFinishDlgFragment.a(this.a).setVisibility(0);
              if (param1LiveConsumeEntity.data.size() == 1) {
                bluedLiveRankListData = param1LiveConsumeEntity.data.get(0);
                LiveGuestFinishDlgFragment.b(this.a).setVisibility(0);
                LiveGuestFinishDlgFragment.c(this.a).setVisibility(8);
                LiveGuestFinishDlgFragment.d(this.a).setVisibility(8);
                LiveGuestFinishDlgFragment liveGuestFinishDlgFragment = this.a;
                LiveGuestFinishDlgFragment.a(liveGuestFinishDlgFragment, bluedLiveRankListData, (View)LiveGuestFinishDlgFragment.b(liveGuestFinishDlgFragment), LiveGuestFinishDlgFragment.e(this.a), LiveGuestFinishDlgFragment.f(this.a), LiveGuestFinishDlgFragment.g(this.a), LiveGuestFinishDlgFragment.h(this.a), 1);
                return;
              } 
              if (((LiveConsumeEntity)bluedLiveRankListData).data.size() == 2) {
                LiveGuestFinishDlgFragment.b(this.a).setVisibility(0);
                LiveGuestFinishDlgFragment.c(this.a).setVisibility(0);
                LiveGuestFinishDlgFragment.d(this.a).setVisibility(8);
                BluedLiveRankListData bluedLiveRankListData1 = ((LiveConsumeEntity)bluedLiveRankListData).data.get(0);
                bluedLiveRankListData = ((LiveConsumeEntity)bluedLiveRankListData).data.get(1);
                LiveGuestFinishDlgFragment liveGuestFinishDlgFragment2 = this.a;
                LiveGuestFinishDlgFragment.a(liveGuestFinishDlgFragment2, bluedLiveRankListData1, (View)LiveGuestFinishDlgFragment.b(liveGuestFinishDlgFragment2), LiveGuestFinishDlgFragment.e(this.a), LiveGuestFinishDlgFragment.f(this.a), LiveGuestFinishDlgFragment.g(this.a), LiveGuestFinishDlgFragment.h(this.a), 1);
                LiveGuestFinishDlgFragment liveGuestFinishDlgFragment1 = this.a;
                LiveGuestFinishDlgFragment.a(liveGuestFinishDlgFragment1, bluedLiveRankListData, (View)LiveGuestFinishDlgFragment.c(liveGuestFinishDlgFragment1), LiveGuestFinishDlgFragment.i(this.a), LiveGuestFinishDlgFragment.j(this.a), LiveGuestFinishDlgFragment.k(this.a), LiveGuestFinishDlgFragment.l(this.a), 2);
                return;
              } 
              if (((LiveConsumeEntity)bluedLiveRankListData).data.size() >= 3) {
                LiveGuestFinishDlgFragment.b(this.a).setVisibility(0);
                LiveGuestFinishDlgFragment.c(this.a).setVisibility(0);
                LiveGuestFinishDlgFragment.d(this.a).setVisibility(0);
                BluedLiveRankListData bluedLiveRankListData2 = ((LiveConsumeEntity)bluedLiveRankListData).data.get(0);
                BluedLiveRankListData bluedLiveRankListData1 = ((LiveConsumeEntity)bluedLiveRankListData).data.get(1);
                bluedLiveRankListData = ((LiveConsumeEntity)bluedLiveRankListData).data.get(2);
                LiveGuestFinishDlgFragment liveGuestFinishDlgFragment3 = this.a;
                LiveGuestFinishDlgFragment.a(liveGuestFinishDlgFragment3, bluedLiveRankListData2, (View)LiveGuestFinishDlgFragment.b(liveGuestFinishDlgFragment3), LiveGuestFinishDlgFragment.e(this.a), LiveGuestFinishDlgFragment.f(this.a), LiveGuestFinishDlgFragment.g(this.a), LiveGuestFinishDlgFragment.h(this.a), 1);
                LiveGuestFinishDlgFragment liveGuestFinishDlgFragment2 = this.a;
                LiveGuestFinishDlgFragment.a(liveGuestFinishDlgFragment2, bluedLiveRankListData1, (View)LiveGuestFinishDlgFragment.c(liveGuestFinishDlgFragment2), LiveGuestFinishDlgFragment.i(this.a), LiveGuestFinishDlgFragment.j(this.a), LiveGuestFinishDlgFragment.k(this.a), LiveGuestFinishDlgFragment.l(this.a), 2);
                LiveGuestFinishDlgFragment liveGuestFinishDlgFragment1 = this.a;
                LiveGuestFinishDlgFragment.a(liveGuestFinishDlgFragment1, bluedLiveRankListData, (View)LiveGuestFinishDlgFragment.d(liveGuestFinishDlgFragment1), LiveGuestFinishDlgFragment.m(this.a), LiveGuestFinishDlgFragment.n(this.a), LiveGuestFinishDlgFragment.o(this.a), LiveGuestFinishDlgFragment.p(this.a), 3);
                return;
              } 
            } else {
              this.a.j.setVisibility(0);
              LiveGuestFinishDlgFragment.a(this.a).setVisibility(8);
            } 
          }
          
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
          }
          
          public void onUIFinish() {
            this.a.i.setVisibility(8);
          }
        }(IRequestHost)a());
  }
  
  public void k() {
    this.n++;
    LiveRoomHttpUtils.a(getContext(), new BluedUIHttpResponse<BluedEntity<LiveCloseRecommendModel, LiveCloseRecommendExtra>>(this, (IRequestHost)a()) {
          public void onUIFinish() {
            super.onUIFinish();
            LiveGuestFinishDlgFragment.D(this.a).setVisibility(8);
          }
          
          public void onUIStart() {
            super.onUIStart();
            LiveGuestFinishDlgFragment.D(this.a).setVisibility(0);
          }
          
          public void onUIUpdate(BluedEntity<LiveCloseRecommendModel, LiveCloseRecommendExtra> param1BluedEntity) {
            if (param1BluedEntity.data != null && param1BluedEntity.data.size() > 0)
              if (param1BluedEntity.data.size() >= 3) {
                FrameLayout frameLayout = LiveGuestFinishDlgFragment.q(this.a);
                int i = 0;
                frameLayout.setVisibility(0);
                while (i < param1BluedEntity.data.size()) {
                  if (i == 0) {
                    LiveGuestFinishDlgFragment.a(this.a, param1BluedEntity.data.get(i), LiveGuestFinishDlgFragment.r(this.a), LiveGuestFinishDlgFragment.s(this.a), LiveGuestFinishDlgFragment.t(this.a), LiveGuestFinishDlgFragment.u(this.a));
                  } else if (i == 1) {
                    LiveGuestFinishDlgFragment.a(this.a, param1BluedEntity.data.get(i), LiveGuestFinishDlgFragment.v(this.a), LiveGuestFinishDlgFragment.w(this.a), LiveGuestFinishDlgFragment.x(this.a), LiveGuestFinishDlgFragment.y(this.a));
                  } else if (i == 2) {
                    LiveGuestFinishDlgFragment.a(this.a, param1BluedEntity.data.get(i), LiveGuestFinishDlgFragment.z(this.a), LiveGuestFinishDlgFragment.A(this.a), LiveGuestFinishDlgFragment.B(this.a), LiveGuestFinishDlgFragment.C(this.a));
                  } 
                  i++;
                } 
              } else {
                LiveGuestFinishDlgFragment.q(this.a).setVisibility(8);
              }  
            if (param1BluedEntity.extra != null)
              this.a.m = ((LiveCloseRecommendExtra)param1BluedEntity.extra).last; 
          }
        }this.m, this.n);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveGuestFinishDlgFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */