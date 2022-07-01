package com.blued.android.module.live_china.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.UserMedalsAdapter;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.AnchorMedal;
import com.blued.android.module.live_china.model.LiveMsgReportModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveRelationshipObserver;
import com.blued.android.module.live_china.same.LiveBitmapUtils;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.List;

public class PopUserCard implements View.OnClickListener, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone {
  public TextView A;
  
  public TextView B;
  
  public TextView C;
  
  public TextView D;
  
  public LinearLayout E;
  
  public ImageView F;
  
  public View G;
  
  public ImageView H;
  
  public View I;
  
  public ImageView J;
  
  public ImageView K;
  
  public ShapeTextView L;
  
  public boolean M = false;
  
  public boolean N = false;
  
  public BluedUIHttpResponse O = new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(this, this.U) {
      protected void a(BluedEntityA<LiveRoomUserModel> param1BluedEntityA) {
        this.a.N = true;
        if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
          this.a.e = param1BluedEntityA.data.get(0);
          if (this.a.e != null) {
            this.a.l();
            PopUserCard.b(this.a).clear();
            if (this.a.e.badge != null && this.a.e.badge.size() > 0) {
              PopUserCard.c(this.a).setVisibility(0);
              PopUserCard.b(this.a).addAll(this.a.e.badge);
              PopUserCard popUserCard = this.a;
              PopUserCard.a(popUserCard, new PopUserCard.UserMedalAdapterForCard(popUserCard, popUserCard.c, PopUserCard.b(this.a)));
              PopUserCard.e(this.a).a(new UserMedalsAdapter.RecyclerViewItemClickListener(this) {
                    public void a(View param2View, int param2Int) {
                      if (PopUserCard.d(this.a.a) == 0) {
                        this.a.a.r();
                        this.a.a.a(((AnchorMedal)PopUserCard.b(this.a.a).get(param2Int)).bid, this.a.a.e.uid);
                      } 
                    }
                  });
              LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a.c);
              linearLayoutManager.setOrientation(0);
              PopUserCard.c(this.a).setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
              PopUserCard.c(this.a).setHasFixedSize(true);
              PopUserCard.c(this.a).setAdapter((RecyclerView.Adapter)PopUserCard.e(this.a));
              return;
            } 
            PopUserCard.c(this.a).setVisibility(8);
          } 
        } 
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a.N = false;
        AppMethods.a(param1String);
        return true;
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        this.a.p.setVisibility(8);
        this.a.q.setVisibility(0);
        if (!this.a.N)
          this.a.q(); 
      }
      
      public void onUIStart() {
        super.onUIStart();
        this.a.p.setVisibility(0);
      }
    };
  
  private MyPopupWindow P;
  
  private List<String> Q;
  
  private int R = 0;
  
  private LoadOptions S;
  
  private String T = " | ";
  
  private IRequestHost U;
  
  private UserCardOnclickListner V;
  
  private Long W;
  
  private Short X;
  
  private ImageView Y;
  
  private RecyclerView Z;
  
  public View a;
  
  private List<AnchorMedal> aa = new ArrayList<AnchorMedal>();
  
  private UserMedalAdapterForCard ab;
  
  private int ac = 0;
  
  private ImageView ad;
  
  private TextView ae;
  
  private int af = 0;
  
  private LiveMsgReportModel ag;
  
  public View b;
  
  public Context c;
  
  public LayoutInflater d;
  
  public LiveRoomUserModel e = new LiveRoomUserModel();
  
  public View f;
  
  public View g;
  
  public View h;
  
  public View i;
  
  public TextView j;
  
  public LinearLayout k;
  
  public LinearLayout l;
  
  public LinearLayout m;
  
  public LinearLayout n;
  
  public TextView o;
  
  public LinearLayout p;
  
  public LinearLayout q;
  
  public LinearLayout r;
  
  public TextView s;
  
  public TextView t;
  
  public TextView u;
  
  public ImageView v;
  
  public ImageView w;
  
  public ImageView x;
  
  public View y;
  
  public LinearLayout z;
  
  public PopUserCard(Context paramContext, IRequestHost paramIRequestHost, String paramString, Long paramLong, Short paramShort, UserCardOnclickListner paramUserCardOnclickListner) {
    this.c = paramContext;
    c(paramString);
    this.U = paramIRequestHost;
    this.W = paramLong;
    this.X = paramShort;
    this.V = paramUserCardOnclickListner;
    f();
  }
  
  private void t() {
    if (TextUtils.equals(LiveRoomInfo.a().f(), b())) {
      this.R = 1;
      return;
    } 
    Logger.a("rrb", new Object[] { "isCurrentUserAManager = ", Integer.valueOf(this.R) });
    if (LiveFloatManager.a().w()) {
      this.R = 2;
      return;
    } 
    this.R = 0;
  }
  
  private boolean u() {
    // Byte code:
    //   0: aload_0
    //   1: getfield e : Lcom/blued/android/module/live_china/model/LiveRoomUserModel;
    //   4: getfield relationship : Ljava/lang/String;
    //   7: astore_2
    //   8: aload_2
    //   9: invokevirtual hashCode : ()I
    //   12: istore_1
    //   13: iload_1
    //   14: bipush #52
    //   16: if_icmpeq -> 63
    //   19: iload_1
    //   20: bipush #56
    //   22: if_icmpeq -> 49
    //   25: iload_1
    //   26: sipush #1569
    //   29: if_icmpeq -> 35
    //   32: goto -> 77
    //   35: aload_2
    //   36: ldc '12'
    //   38: invokevirtual equals : (Ljava/lang/Object;)Z
    //   41: ifeq -> 77
    //   44: iconst_1
    //   45: istore_1
    //   46: goto -> 79
    //   49: aload_2
    //   50: ldc '8'
    //   52: invokevirtual equals : (Ljava/lang/Object;)Z
    //   55: ifeq -> 77
    //   58: iconst_2
    //   59: istore_1
    //   60: goto -> 79
    //   63: aload_2
    //   64: ldc '4'
    //   66: invokevirtual equals : (Ljava/lang/Object;)Z
    //   69: ifeq -> 77
    //   72: iconst_0
    //   73: istore_1
    //   74: goto -> 79
    //   77: iconst_m1
    //   78: istore_1
    //   79: iload_1
    //   80: ifeq -> 126
    //   83: iload_1
    //   84: iconst_1
    //   85: if_icmpeq -> 119
    //   88: iload_1
    //   89: iconst_2
    //   90: if_icmpeq -> 112
    //   93: aload_0
    //   94: getfield u : Landroid/widget/TextView;
    //   97: bipush #8
    //   99: invokevirtual setVisibility : (I)V
    //   102: aload_0
    //   103: getfield n : Landroid/widget/LinearLayout;
    //   106: iconst_0
    //   107: invokevirtual setVisibility : (I)V
    //   110: iconst_1
    //   111: ireturn
    //   112: aload_0
    //   113: invokespecial v : ()V
    //   116: goto -> 160
    //   119: aload_0
    //   120: invokespecial v : ()V
    //   123: goto -> 160
    //   126: aload_0
    //   127: getfield u : Landroid/widget/TextView;
    //   130: aload_0
    //   131: getfield c : Landroid/content/Context;
    //   134: getstatic com/blued/android/module/live_china/R$string.liveVideo_livingView_label_inBlackList : I
    //   137: invokevirtual getString : (I)Ljava/lang/String;
    //   140: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   143: aload_0
    //   144: getfield u : Landroid/widget/TextView;
    //   147: iconst_0
    //   148: invokevirtual setVisibility : (I)V
    //   151: aload_0
    //   152: getfield n : Landroid/widget/LinearLayout;
    //   155: bipush #8
    //   157: invokevirtual setVisibility : (I)V
    //   160: iconst_0
    //   161: ireturn
  }
  
  private void v() {
    this.f.setVisibility(0);
    this.n.setVisibility(8);
    this.u.setVisibility(0);
    this.u.setText(this.c.getString(R.string.liveVideo_livingView_label_userBlockYou));
    this.r.setVisibility(8);
  }
  
  private void w() {
    t();
    this.f.setVisibility(0);
    int i = this.R;
    if (i != 0) {
      if (i != 1) {
        if (i == 2) {
          if (this.e.is_manager == 1 || this.e.uid.equalsIgnoreCase(b())) {
            this.j.setVisibility(8);
          } else {
            this.j.setVisibility(0);
          } 
          this.i.setVisibility(0);
          this.k.setVisibility(0);
          this.g.setVisibility(0);
          this.l.setVisibility(0);
          this.h.setVisibility(8);
          this.m.setVisibility(8);
          this.z.setVisibility(0);
          this.A.setVisibility(0);
          this.D.setVisibility(8);
          this.E.setVisibility(8);
        } 
      } else {
        this.i.setVisibility(0);
        this.k.setVisibility(8);
        this.g.setVisibility(8);
        this.l.setVisibility(0);
        this.h.setVisibility(0);
        this.m.setVisibility(0);
        this.z.setVisibility(8);
        this.A.setVisibility(8);
        this.D.setVisibility(0);
        this.E.setVisibility(0);
        this.j.setVisibility(8);
      } 
    } else {
      List<String> list = this.Q;
      if (list != null && list.contains(this.e.uid)) {
        this.i.setVisibility(8);
        this.k.setVisibility(8);
        this.g.setVisibility(8);
        this.l.setVisibility(0);
        this.h.setVisibility(8);
        this.m.setVisibility(8);
        this.z.setVisibility(0);
        this.A.setVisibility(0);
        this.D.setVisibility(8);
        this.E.setVisibility(8);
        this.j.setVisibility(8);
      } else {
        this.i.setVisibility(0);
        this.k.setVisibility(0);
        this.g.setVisibility(0);
        this.l.setVisibility(0);
        this.h.setVisibility(8);
        this.m.setVisibility(8);
        this.z.setVisibility(0);
        this.A.setVisibility(0);
        this.D.setVisibility(8);
        this.E.setVisibility(8);
        this.j.setVisibility(8);
      } 
    } 
    i = this.af;
    if (i != 1) {
      if (i != 2) {
        if (i != 3)
          return; 
        if (this.N)
          EventTrackLive.a(LiveProtos.Event.PK_LIVE_PROFILE_FOLLOW_BTN_SHOW, LiveRoomManager.a().b(), this.e.uid, EventTrackLive.b(this.e.relationship)); 
        x();
        return;
      } 
      x();
      return;
    } 
    y();
    this.n.setVisibility(0);
    if (this.R == 1) {
      this.h.setVisibility(8);
      this.m.setVisibility(8);
      this.D.setVisibility(8);
      this.E.setVisibility(8);
      return;
    } 
    this.k.setVisibility(8);
    this.A.setVisibility(8);
  }
  
  private void x() {
    this.i.setVisibility(4);
    this.u.setVisibility(8);
    this.h.setVisibility(8);
    this.j.setVisibility(8);
    this.m.setVisibility(8);
    this.D.setVisibility(8);
    this.E.setVisibility(8);
  }
  
  private void y() {
    this.f.setVisibility(8);
    this.i.setVisibility(4);
    this.n.setVisibility(8);
    this.u.setVisibility(8);
    this.j.setVisibility(8);
  }
  
  public void R_() {}
  
  public void a(LiveRoomUserModel paramLiveRoomUserModel) {
    a(paramLiveRoomUserModel, 0, null);
  }
  
  public void a(LiveRoomUserModel paramLiveRoomUserModel, int paramInt) {
    if (PlayingOnliveFragment.T) {
      KeyboardUtils.a((Activity)this.c);
      AppInfo.n().postDelayed(new Runnable(this, paramLiveRoomUserModel, paramInt) {
            public void run() {
              this.c.a(this.a, this.b, null);
            }
          }500L);
      return;
    } 
    a(paramLiveRoomUserModel, paramInt, null);
  }
  
  public void a(LiveRoomUserModel paramLiveRoomUserModel, int paramInt, LiveMsgReportModel paramLiveMsgReportModel) {
    if (paramLiveRoomUserModel != null) {
      this.ag = paramLiveMsgReportModel;
      this.af = paramInt;
      if (this.V == null)
        this.V = new UserCardOnclickListner(this) {
            public void a() {}
            
            public void a(LiveRoomUserModel param1LiveRoomUserModel) {}
            
            public void a(String param1String) {}
            
            public void a(String param1String, LiveMsgReportModel param1LiveMsgReportModel) {}
            
            public void a(String param1String1, String param1String2) {}
            
            public void b() {}
            
            public void b(String param1String1, String param1String2) {}
            
            public void c() {}
            
            public void c(String param1String1, String param1String2) {}
            
            public void d() {}
          }; 
      this.V.b();
      this.q.setVisibility(4);
      this.p.setVisibility(0);
      this.G.setVisibility(4);
      this.e = paramLiveRoomUserModel;
      this.a.clearAnimation();
      this.b.clearAnimation();
      if (this.P.isShowing())
        this.P.a(); 
      View view = this.y;
      if (view != null) {
        this.P.showAtLocation(view, 81, 0, 0);
      } else {
        this.P.showAtLocation(this.b, 81, 0, 0);
      } 
      this.b.setVisibility(0);
      p();
      l();
    } 
  }
  
  public void a(String paramString) {
    LiveRoomUserModel liveRoomUserModel = this.e;
    liveRoomUserModel.relationship = paramString;
    if (liveRoomUserModel.uid.equals(b()))
      LiveMsgSendManager.a().j(); 
    LiveRoomData liveRoomData = LiveRoomManager.a().h();
    if (liveRoomData != null)
      EventTrackLive.a(LiveProtos.Event.USER_PROFILE_FOLLOW_BTN_CLICK, String.valueOf(liveRoomData.lid), LiveRoomManager.a().e(), this.e.uid, liveRoomData.liveFrom, liveRoomData.recommendType, liveRoomData.livePosition); 
    LiveUserRelationshipUtils.a(this.c, paramString, this.o, null);
    d(paramString);
    LiveRelationshipObserver.a().a(paramString, this.e.uid);
  }
  
  public void a(String paramString, int paramInt) {
    LiveRoomUserModel liveRoomUserModel = this.e;
    liveRoomUserModel.uid = paramString;
    liveRoomUserModel.name = "";
    liveRoomUserModel.avatar = "";
    a(liveRoomUserModel, paramInt);
  }
  
  public void a(String paramString, LiveMsgReportModel paramLiveMsgReportModel) {
    LiveRoomUserModel liveRoomUserModel = this.e;
    liveRoomUserModel.uid = paramString;
    liveRoomUserModel.name = "";
    liveRoomUserModel.avatar = "";
    a(liveRoomUserModel, 0, paramLiveMsgReportModel);
  }
  
  public void a(String paramString1, String paramString2) {
    PopAnchorBadge.a(this.c, paramString2, b(), paramString1, new PopAnchorBadge.DismissLisnter(this) {
          public void a() {
            PopUserCard.a(this.a).a();
          }
          
          public void b() {
            PopUserCard.a(this.a).c();
          }
        },  this.U);
  }
  
  public void a(List<String> paramList) {
    List<String> list = this.Q;
    if (list == null) {
      this.Q = new ArrayList<String>();
    } else {
      list.clear();
    } 
    if (paramList != null)
      this.Q.addAll(paramList); 
  }
  
  public String b() {
    List<String> list = this.Q;
    return (list != null && list.size() > 0) ? this.Q.get(0) : "";
  }
  
  public void b(String paramString) {
    this.e.relationship = paramString;
    LiveUserRelationshipUtils.a(this.c, paramString, this.o, null);
    d(paramString);
    LiveRelationshipObserver.a().a(paramString, this.e.uid);
  }
  
  public void b(String paramString, LiveMsgReportModel paramLiveMsgReportModel) {
    LiveRoomUserModel liveRoomUserModel = this.e;
    liveRoomUserModel.name = paramString;
    liveRoomUserModel.uid = "fromname";
    liveRoomUserModel.avatar = "";
    this.y = null;
    a(liveRoomUserModel, 0, paramLiveMsgReportModel);
  }
  
  public void c() {
    this.y = this.d.inflate(R.layout.item_pop_usercard, null);
  }
  
  public void c(String paramString) {
    List<String> list = this.Q;
    if (list == null) {
      this.Q = new ArrayList<String>();
    } else {
      list.clear();
    } 
    this.Q.add(paramString);
  }
  
  public void d() {}
  
  public void d(String paramString) {
    if ("0".equals(paramString)) {
      this.o.setTextColor(Color.parseColor("#1A7EFF"));
      return;
    } 
    if ("2".equals(paramString)) {
      this.o.setTextColor(Color.parseColor("#1A7EFF"));
      return;
    } 
    this.o.setTextColor(Color.parseColor("#767676"));
  }
  
  public void e() {}
  
  public void e(String paramString) {
    a(paramString, 0);
  }
  
  public void f() {
    int i = (this.c.getResources().getDisplayMetrics()).widthPixels;
    this.S = new LoadOptions();
    LoadOptions loadOptions = this.S;
    loadOptions.l = false;
    loadOptions.b = R.drawable.user_bg_round;
    this.S.d = R.drawable.user_bg_round;
    loadOptions = this.S;
    i >>= 1;
    loadOptions.a(i, i);
    this.d = LayoutInflater.from(this.c);
    c();
    this.ae = (TextView)this.y.findViewById(R.id.tv_avatar_gold_border);
    this.ad = (ImageView)this.y.findViewById(R.id.img_manager_icon);
    this.G = this.y.findViewById(R.id.view_over30_ribbon);
    this.H = (ImageView)this.y.findViewById(R.id.img_ribbon);
    this.I = this.y.findViewById(R.id.ll_liang);
    this.J = (ImageView)this.y.findViewById(R.id.img_liang);
    this.K = (ImageView)this.y.findViewById(R.id.iv_liang_icon);
    this.L = (ShapeTextView)this.y.findViewById(R.id.tv_liang_id);
    this.i = this.y.findViewById(R.id.tv_report);
    this.i.setOnClickListener(this);
    this.j = (TextView)this.y.findViewById(R.id.tv_silence);
    this.j.setOnClickListener(this);
    this.p = (LinearLayout)this.y.findViewById(R.id.ll_loading);
    this.k = (LinearLayout)this.y.findViewById(R.id.ll_reply);
    this.k.setOnClickListener(this);
    this.l = (LinearLayout)this.y.findViewById(R.id.ll_attention);
    this.l.setOnClickListener(this);
    this.m = (LinearLayout)this.y.findViewById(R.id.ll_manage);
    this.m.setOnClickListener(this);
    this.n = (LinearLayout)this.y.findViewById(R.id.ll_bottom_button);
    this.q = (LinearLayout)this.y.findViewById(R.id.ll_userinfo);
    this.z = (LinearLayout)this.y.findViewById(R.id.ll_view_profile);
    this.z.setOnClickListener(this);
    this.r = (LinearLayout)this.y.findViewById(R.id.ll_description);
    this.f = this.y.findViewById(R.id.tv_cut_bottom);
    this.g = this.y.findViewById(R.id.tv_cut_attention);
    this.h = this.y.findViewById(R.id.tv_cut_silence);
    this.o = (TextView)this.y.findViewById(R.id.tv_attention);
    this.j = (TextView)this.y.findViewById(R.id.tv_silence);
    this.B = (TextView)this.y.findViewById(R.id.tv_description);
    this.A = (TextView)this.y.findViewById(R.id.tv_cut_chat);
    this.D = (TextView)this.y.findViewById(R.id.tv_cut_connect);
    this.E = (LinearLayout)this.y.findViewById(R.id.ll_connect);
    this.E.setOnClickListener(this);
    this.s = (TextView)this.y.findViewById(R.id.tv_name);
    this.v = (ImageView)this.y.findViewById(R.id.header_view);
    this.F = (ImageView)this.y.findViewById(R.id.img_rich_rank);
    this.Y = (ImageView)this.y.findViewById(R.id.img_anchor_lvl);
    this.w = (ImageView)this.y.findViewById(R.id.img_verify);
    this.x = (ImageView)this.y.findViewById(R.id.img_vip_icon);
    this.t = (TextView)this.y.findViewById(R.id.tv_userinfo_line1);
    this.u = (TextView)this.y.findViewById(R.id.tv_block);
    this.a = this.y.findViewById(R.id.tv_bg);
    this.C = (TextView)this.y.findViewById(R.id.tv_distance);
    this.Z = (RecyclerView)this.y.findViewById(R.id.lv_medals);
    this.a.setBackgroundColor(this.c.getResources().getColor(R.color.transparent));
    this.a.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.q();
          }
        });
    this.b = this.y.findViewById(R.id.ll_content);
    this.b.setBackgroundColor(this.c.getResources().getColor(R.color.transparent));
    this.b.setVisibility(8);
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    this.P = new MyPopupWindow(this, this.y, -1, -1, true);
    this.P.setBackgroundDrawable(this.c.getResources().getDrawable(17170445));
    this.P.setTouchable(true);
    this.P.setOutsideTouchable(true);
    this.P.setFocusable(true);
    this.P.update();
  }
  
  public void f(String paramString) {
    LiveRoomUserModel liveRoomUserModel = this.e;
    liveRoomUserModel.name = paramString;
    liveRoomUserModel.uid = "fromname";
    liveRoomUserModel.avatar = "";
    this.y = null;
    a(liveRoomUserModel, 0);
  }
  
  public String g() {
    return this.e.uid;
  }
  
  public String h() {
    return this.e.name;
  }
  
  public void i() {
    ArrayList<String> arrayList = new ArrayList();
    if (this.e.allow_active == 1) {
      if (this.e.is_manager == 1) {
        arrayList.add(this.c.getString(R.string.live_cancel_manage));
      } else {
        arrayList.add(this.c.getString(R.string.live_set_manager));
      } 
      arrayList.add(this.c.getString(R.string.live_manager_list));
      arrayList.add(this.c.getString(R.string.live_temp_banned));
      arrayList.add(this.c.getString(R.string.live_perm_banned));
    } else {
      if (this.e.is_manager == 1) {
        arrayList.add(this.c.getString(R.string.live_cancel_manage));
      } else {
        arrayList.add(this.c.getString(R.string.live_set_manager));
      } 
      arrayList.add(this.c.getString(R.string.live_manager_list));
      arrayList.add(this.c.getString(R.string.liveVideo_livingView_label_cancelForbidToSpeak));
    } 
    int[] arrayOfInt = new int[arrayList.size()];
    for (int i = 0; i < arrayOfInt.length; i++)
      arrayOfInt[i] = R.color.syc_a; 
    String[] arrayOfString = arrayList.<String>toArray(new String[arrayList.size()]);
    Context context = this.c;
    PopActionSheet.a(context, arrayOfString, arrayOfInt, DensityUtils.a(context, 200.0F), true, new PopActionSheet.PopSheetClickListner(this) {
          public void onClick(int param1Int, String param1String) {
            if (param1String.equalsIgnoreCase(this.a.c.getString(R.string.live_set_manager))) {
              this.a.j();
            } else if (param1String.equalsIgnoreCase(this.a.c.getString(R.string.live_cancel_manage))) {
              this.a.k();
            } else if (param1String.equalsIgnoreCase(this.a.c.getString(R.string.live_manager_list))) {
              PopUserCard.a(this.a).d();
            } else if (param1String.equalsIgnoreCase(this.a.c.getString(R.string.live_temp_banned))) {
              this.a.e.allow_active = 0;
              this.a.m();
              PopUserCard.a(this.a).a(this.a.g(), this.a.h());
              InstantLog.b("live_banned_option_click", 0);
              AppMethods.d(R.string.live_forbid_to_speak_tip);
            } else if (param1String.equalsIgnoreCase(this.a.c.getString(R.string.live_perm_banned))) {
              this.a.e.allow_active = 0;
              this.a.m();
              PopUserCard.a(this.a).a(this.a.g());
              InstantLog.b("live_banned_option_click", 1);
              AppMethods.d(R.string.live_forbid_to_speak_tip);
            } else if (param1String.equalsIgnoreCase(this.a.c.getString(R.string.liveVideo_livingView_label_cancelForbidToSpeak))) {
              this.a.e.allow_active = 1;
              this.a.m();
              PopUserCard.a(this.a).c(this.a.g(), this.a.h());
              InstantLog.b("live_banned_option_click", 2);
              AppMethods.d(R.string.live_released_to_speak_tip);
            } 
            this.a.q();
          }
        });
  }
  
  public void j() {
    LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(this, this.U) {
          boolean a = false;
          
          String b;
          
          protected void a(BluedEntityA<LiveRoomUserModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData())
              AppMethods.a(this.c.c.getResources().getString(R.string.live_manager_settled)); 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (param1Int == 403903) {
              this.b = param1String;
              this.a = true;
              return true;
            } 
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            if (this.a) {
              CommonAlertDialog.a(this.c.c, null, "", this.b, this.c.c.getString(R.string.live_manager_manage), this.c.c.getString(R.string.live_ok), null, new DialogInterface.OnClickListener(this) {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                      PopUserCard.a(this.a.c).d();
                    }
                  },  null, true);
              this.a = false;
            } 
          }
        }this.U, String.valueOf(this.W), this.e.uid);
  }
  
  public void k() {
    LiveRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(this, this.U) {
          protected void a(BluedEntityA<LiveRoomUserModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData())
              AppMethods.a(this.a.c.getResources().getString(R.string.live_manager_removed)); 
          }
        }this.U, String.valueOf(this.W), this.e.uid);
  }
  
  public void l() {
    LiveRoomUserModel liveRoomUserModel = this.e;
    if (liveRoomUserModel != null) {
      int i;
      if (!TextUtils.isEmpty(liveRoomUserModel.name))
        if (!TextUtils.isEmpty(this.e.note)) {
          TextView textView = this.s;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(this.e.note);
          stringBuilder1.append("(");
          stringBuilder1.append(this.e.name);
          stringBuilder1.append(")");
          textView.setText(stringBuilder1.toString());
        } else {
          this.s.setText(this.e.name);
        }  
      LiveRoomInfo.a().a(this.c, this.s, this.e, R.color.syc_dark_0a0a0a);
      if (this.e.is_manager == 1) {
        this.ad.setVisibility(0);
      } else {
        this.ad.setVisibility(8);
      } 
      LiveUtils.a(this.c, this.Y, this.e.anchor_level, true);
      LiveBitmapUtils.a(this.c, this.F, this.e.rich_level);
      if (this.e.rich_level >= 1) {
        this.ae.setVisibility(0);
        i = this.c.getResources().getColor(R.color.syc_r);
        this.G.setVisibility(0);
        if (this.e.rich_level >= 30) {
          switch (this.e.rich_level) {
            case 34:
              this.H.setImageResource(R.drawable.bg_lv34_usercard);
              break;
            case 33:
              this.H.setImageResource(R.drawable.bg_lv33_usercard);
              break;
            case 32:
              this.H.setImageResource(R.drawable.bg_lv32_usercard);
              break;
            case 31:
              this.H.setImageResource(R.drawable.bg_lv31_usercard);
              break;
            case 30:
              this.H.setImageResource(R.drawable.bg_lv30_usercard);
              break;
          } 
        } else if (this.e.rich_level >= 26) {
          this.H.setImageResource(R.drawable.bg_lv26_usercard);
        } else if (this.e.rich_level >= 21) {
          this.H.setImageResource(R.drawable.bg_lv21_usercard);
        } else if (this.e.rich_level >= 11) {
          this.H.setImageResource(R.drawable.bg_lv11_usercard);
        } else {
          this.G.setVisibility(4);
        } 
      } else {
        this.ae.setVisibility(8);
        i = this.c.getResources().getColor(R.color.nafio_b);
        this.G.setVisibility(4);
      } 
      if (this.e.liang_type == 1) {
        if (TextUtils.equals(this.e.uid, LiveRoomInfo.a().f())) {
          this.J.setVisibility(0);
          this.J.setImageResource(R.drawable.live_liang_gray);
        } else {
          this.J.setVisibility(8);
        } 
        this.L.setTextColor(this.c.getResources().getColor(R.color.syc_dark_767676));
        this.L.setVisibility(0);
        ShapeTextView shapeTextView = this.L;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("ID: ");
        stringBuilder1.append(this.e.liang_id);
        shapeTextView.setText(stringBuilder1.toString());
        this.I.setVisibility(0);
        this.K.setVisibility(8);
      } else if (this.e.liang_type >= 2) {
        this.J.setVisibility(0);
        this.J.setImageResource(R.drawable.live_liang);
        this.L.setTextColor(this.c.getResources().getColor(R.color.syc_w_465CF2));
        this.L.setVisibility(0);
        ShapeTextView shapeTextView = this.L;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(" : ");
        stringBuilder1.append(this.e.liang_id);
        shapeTextView.setText(stringBuilder1.toString());
        this.I.setVisibility(0);
        this.K.setVisibility(0);
      } else {
        this.J.setVisibility(8);
        this.I.setVisibility(8);
      } 
      if (TextUtils.equals(this.e.uid, LiveRoomInfo.a().f()))
        this.J.setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param1View) {
                LiveRoomInfo.a().b(this.a.c, LiveRoomInfo.a().E());
              }
            }); 
      ImageLoader.a(this.U, this.e.avatar).a(R.drawable.user_bg_round).a(2.0F, i).a(this.v);
      if (!TextUtils.isEmpty(this.e.location))
        this.C.setText(this.e.location); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.e.age);
      stringBuilder.append(this.c.getResources().getString(R.string.age_unit));
      stringBuilder.append(this.T);
      stringBuilder.append(LiveRoomInfo.a().a(this.e.height, true));
      stringBuilder.append(this.T);
      stringBuilder.append(LiveRoomInfo.a().b(this.e.weight, true));
      stringBuilder.append(this.T);
      stringBuilder.append(LiveRoomInfo.a().a(this.c, null, this.e.role));
      String str = stringBuilder.toString();
      this.t.setText(str);
      if (this.Q != null && b() != null && b().equals(this.e.uid) && !TextUtils.isEmpty(this.e.description)) {
        str = this.e.description;
        this.B.setText(str);
        this.r.setVisibility(0);
      } else {
        this.r.setVisibility(8);
      } 
      LiveRoomInfo.a().a(this.w, this.e.vbadge);
      LiveRoomInfo.a().a(this.x, this.e);
    } 
    if (TextUtils.equals(LiveRoomInfo.a().f(), this.e.uid)) {
      y();
    } else {
      m();
      if (u())
        if (this.ac != 1) {
          w();
        } else {
          this.i.setVisibility(4);
          this.k.setVisibility(8);
          this.g.setVisibility(8);
          this.l.setVisibility(0);
          this.h.setVisibility(8);
          this.m.setVisibility(8);
          this.j.setVisibility(8);
          this.z.setVisibility(0);
          this.A.setVisibility(0);
          this.D.setVisibility(8);
          this.E.setVisibility(8);
          this.f.setVisibility(0);
        }  
    } 
    LiveUserRelationshipUtils.a(this.c, this.e.relationship, this.o, null);
    d(this.e.relationship);
  }
  
  public void m() {
    if (this.e.allow_active == 0) {
      this.j.setText(this.c.getString(R.string.liveVideo_livingView_label_cancelForbidToSpeak));
      return;
    } 
    this.j.setText(this.c.getString(R.string.liveVideo_livingView_label_forbidToSpeakButton));
  }
  
  public void n() {
    if ("fromname".equals(this.e.uid)) {
      LiveRoomHttpUtils.a(this.c, this.O, this.e.uid, this.e.name, this.W, this.X, this.U);
      return;
    } 
    LiveRoomHttpUtils.a(this.c, this.O, this.e.uid, "", this.W, this.X, this.U);
  }
  
  public void o() {
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.5F, 0.0F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    this.a.startAnimation((Animation)alphaAnimation);
    this.b.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_bottom_out));
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.ll_view_profile) {
      if (LiveRoomManager.a().h() != null && (LiveRoomManager.a().h()).link_type == 4)
        EventTrackLive.b(LiveProtos.Event.USER_MIKE_USER_PHOTO_CARD_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e(), this.e.uid); 
      if (!LiveRefreshUIObserver.a().e())
        return; 
      q();
      this.V.c();
      if (this.Q.contains(this.e.uid)) {
        LiveRoomInfo.a().a(this.c, this.e.uid, this.e.name, this.e.avatar, this.e.is_show_vip_page, 1);
        return;
      } 
      LiveRoomInfo.a().a(this.c, this.e.uid, this.e.name, this.e.avatar, this.e.is_show_vip_page, 2);
      return;
    } 
    if (paramView.getId() == R.id.tv_report) {
      q();
      this.V.a(this.e.uid, this.ag);
      return;
    } 
    if (paramView.getId() == R.id.ll_reply) {
      if (!LiveRoomInfo.a().a(this.c, null)) {
        q();
        this.V.b(this.e.uid, this.e.name);
        return;
      } 
    } else {
      String str;
      if (paramView.getId() == R.id.ll_attention) {
        if (this.af == 3)
          EventTrackLive.a(LiveProtos.Event.PK_LIVE_PROFILE_FOLLOW_BTN_CLICK, LiveRoomManager.a().b(), this.e.uid, EventTrackLive.b(this.e.relationship)); 
        if (b() != null && b().equalsIgnoreCase(this.e.uid)) {
          str = "liveanchor_";
        } else {
          str = "live_";
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.W);
        str = stringBuilder.toString();
        LiveRoomInfo.a().a(this.c, this, this.e.uid, this.e.relationship, str, this.U, false);
        return;
      } 
      if (str.getId() == R.id.ll_connect) {
        q();
        this.V.a(this.e);
        return;
      } 
      if (str.getId() == R.id.ll_manage) {
        EventTrackLive.a(LiveProtos.Event.LIVE_MANAGE_BTN_CLICK, LiveRoomManager.a().c(), this.e.uid);
        i();
        InstantLog.a("live_manage_btn_click");
        return;
      } 
      if (str.getId() == R.id.tv_silence) {
        if (this.e.allow_active != 1) {
          this.e.allow_active = 1;
          m();
          this.V.c(this.e.uid, this.e.name);
          InstantLog.b("live_banned_option_click", 2);
          AppMethods.d(R.string.live_released_to_speak_tip);
          return;
        } 
        InstantLog.b("live_banned_option_click", 0);
        this.e.allow_active = 0;
        m();
        this.V.a(g(), h());
        AppMethods.d(R.string.live_forbid_to_speak_tip);
      } 
    } 
  }
  
  public void p() {
    this.b.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_bottom_in));
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0F, 0.5F);
    alphaAnimation.setDuration(300L);
    alphaAnimation.setFillAfter(true);
    alphaAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.n();
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.a.startAnimation((Animation)alphaAnimation);
  }
  
  public void q() {
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            PopUserCard.f(this.a).a();
            PopUserCard.a(this.a).a();
            this.a.G.setVisibility(4);
          }
        },  320L);
    o();
    this.b.setVisibility(8);
  }
  
  public void r() {
    this.b.setVisibility(8);
    o();
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            PopUserCard.f(this.a).a();
            this.a.G.setVisibility(4);
          }
        },  320L);
  }
  
  public boolean s() {
    MyPopupWindow myPopupWindow = this.P;
    return (myPopupWindow == null) ? false : myPopupWindow.isShowing();
  }
  
  public static interface FROM_SOURCE {}
  
  class MyPopupWindow extends PopupWindow {
    public MyPopupWindow(PopUserCard this$0, View param1View, int param1Int1, int param1Int2, boolean param1Boolean) {
      super(param1View, param1Int1, param1Int2, param1Boolean);
    }
    
    public void a() {
      super.dismiss();
    }
    
    public void dismiss() {
      try {
        this.a.q();
        return;
      } catch (Exception exception) {
        a();
        return;
      } 
    }
  }
  
  public static interface USER_PRIVILLAGE {}
  
  public static interface UserCardOnclickListner {
    void a();
    
    void a(LiveRoomUserModel param1LiveRoomUserModel);
    
    void a(String param1String);
    
    void a(String param1String, LiveMsgReportModel param1LiveMsgReportModel);
    
    void a(String param1String1, String param1String2);
    
    void b();
    
    void b(String param1String1, String param1String2);
    
    void c();
    
    void c(String param1String1, String param1String2);
    
    void d();
  }
  
  class UserMedalAdapterForCard extends UserMedalsAdapter {
    public UserMedalAdapterForCard(PopUserCard this$0, Context param1Context, List<AnchorMedal> param1List) {
      super(param1Context, param1List);
    }
    
    public View a() {
      return this.a.d.inflate(R.layout.item_user_anchor_medal4card, null);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\PopUserCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */