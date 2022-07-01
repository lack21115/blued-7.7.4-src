package com.blued.android.module.live_china.pop;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.UserMedalsAdapter;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.AnchorMedal;
import com.blued.android.module.live_china.model.LiveMsgReportModel;
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
import com.blued.android.module.live_china.view.PopActionSheet;
import com.blued.android.module.live_china.view.PopAnchorBadge;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.List;

public class LiveUserCardPop extends BottomPopupView implements View.OnClickListener, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone {
  public LinearLayout A;
  
  public TextView B;
  
  public TextView C;
  
  public TextView D;
  
  public ImageView E;
  
  public ImageView F;
  
  public ImageView G;
  
  public View H;
  
  public LinearLayout I;
  
  public TextView J;
  
  public TextView K;
  
  public TextView L;
  
  public TextView M;
  
  public LinearLayout N;
  
  public ImageView O;
  
  public View P;
  
  public ImageView Q;
  
  public View R;
  
  public ImageView S;
  
  public ImageView T;
  
  public TextView U;
  
  public boolean V = false;
  
  public boolean W = false;
  
  public BluedUIHttpResponse aa = new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(this, this.af) {
      protected void a(BluedEntityA<LiveRoomUserModel> param1BluedEntityA) {
        this.a.W = true;
        if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
          this.a.f = param1BluedEntityA.data.get(0);
          if (this.a.f != null) {
            this.a.B();
            LiveUserCardPop.b(this.a).clear();
            if (this.a.f.badge != null && this.a.f.badge.size() > 0) {
              LiveUserCardPop.c(this.a).setVisibility(0);
              LiveUserCardPop.b(this.a).addAll(this.a.f.badge);
              LiveUserCardPop liveUserCardPop = this.a;
              LiveUserCardPop.a(liveUserCardPop, new LiveUserCardPop.UserMedalAdapterForCard(liveUserCardPop, liveUserCardPop.d, LiveUserCardPop.b(this.a)));
              LiveUserCardPop.e(this.a).a(new UserMedalsAdapter.RecyclerViewItemClickListener(this) {
                    public void a(View param2View, int param2Int) {
                      if (LiveUserCardPop.d(this.a.a) == 0) {
                        this.a.a.D();
                        this.a.a.a(((AnchorMedal)LiveUserCardPop.b(this.a.a).get(param2Int)).bid, this.a.a.f.uid);
                      } 
                    }
                  });
              LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a.d);
              linearLayoutManager.setOrientation(0);
              LiveUserCardPop.c(this.a).setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
              LiveUserCardPop.c(this.a).setHasFixedSize(true);
              LiveUserCardPop.c(this.a).setAdapter((RecyclerView.Adapter)LiveUserCardPop.e(this.a));
              return;
            } 
            LiveUserCardPop.c(this.a).setVisibility(8);
          } 
        } 
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a.W = false;
        AppMethods.a(param1String);
        return true;
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        this.a.y.setVisibility(8);
        this.a.z.setVisibility(0);
        if (!this.a.W)
          this.a.D(); 
      }
      
      public void onUIStart() {
        super.onUIStart();
        this.a.y.setVisibility(0);
      }
    };
  
  private List<String> ab;
  
  private int ac = 0;
  
  private LoadOptions ad;
  
  private String ae = " | ";
  
  private IRequestHost af;
  
  private UserCardOnclickListner ag;
  
  private Long ah;
  
  private Short ai;
  
  private ImageView aj;
  
  private RecyclerView ak;
  
  private List<AnchorMedal> al = new ArrayList<AnchorMedal>();
  
  private UserMedalAdapterForCard am;
  
  private int an = 0;
  
  private ImageView ao;
  
  private TextView ap;
  
  private int aq = 0;
  
  private LiveMsgReportModel ar;
  
  public View b;
  
  public View c;
  
  public Context d;
  
  public LayoutInflater e;
  
  public LiveRoomUserModel f = new LiveRoomUserModel();
  
  public View g;
  
  public View h;
  
  public View i;
  
  public View j;
  
  public TextView k;
  
  public LinearLayout t;
  
  public LinearLayout u;
  
  public LinearLayout v;
  
  public LinearLayout w;
  
  public TextView x;
  
  public LinearLayout y;
  
  public LinearLayout z;
  
  public LiveUserCardPop(Context paramContext, IRequestHost paramIRequestHost, String paramString, Long paramLong, Short paramShort, UserCardOnclickListner paramUserCardOnclickListner) {
    super(paramContext);
    this.d = paramContext;
    setUserCardHostId(paramString);
    this.af = paramIRequestHost;
    this.ah = paramLong;
    this.ai = paramShort;
    this.ag = paramUserCardOnclickListner;
  }
  
  private void E() {
    if (TextUtils.equals(LiveRoomInfo.a().f(), getCurrentAnchor())) {
      this.ac = 1;
      return;
    } 
    Logger.a("rrb", new Object[] { "isCurrentUserAManager = ", Integer.valueOf(this.ac) });
    if (LiveFloatManager.a().w()) {
      this.ac = 2;
      return;
    } 
    this.ac = 0;
  }
  
  private boolean F() {
    // Byte code:
    //   0: aload_0
    //   1: getfield f : Lcom/blued/android/module/live_china/model/LiveRoomUserModel;
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
    //   94: getfield D : Landroid/widget/TextView;
    //   97: bipush #8
    //   99: invokevirtual setVisibility : (I)V
    //   102: aload_0
    //   103: getfield w : Landroid/widget/LinearLayout;
    //   106: iconst_0
    //   107: invokevirtual setVisibility : (I)V
    //   110: iconst_1
    //   111: ireturn
    //   112: aload_0
    //   113: invokespecial G : ()V
    //   116: goto -> 160
    //   119: aload_0
    //   120: invokespecial G : ()V
    //   123: goto -> 160
    //   126: aload_0
    //   127: getfield D : Landroid/widget/TextView;
    //   130: aload_0
    //   131: getfield d : Landroid/content/Context;
    //   134: getstatic com/blued/android/module/live_china/R$string.liveVideo_livingView_label_inBlackList : I
    //   137: invokevirtual getString : (I)Ljava/lang/String;
    //   140: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   143: aload_0
    //   144: getfield D : Landroid/widget/TextView;
    //   147: iconst_0
    //   148: invokevirtual setVisibility : (I)V
    //   151: aload_0
    //   152: getfield w : Landroid/widget/LinearLayout;
    //   155: bipush #8
    //   157: invokevirtual setVisibility : (I)V
    //   160: iconst_0
    //   161: ireturn
  }
  
  private void G() {
    this.g.setVisibility(0);
    this.w.setVisibility(8);
    this.D.setVisibility(0);
    this.D.setText(this.d.getString(R.string.liveVideo_livingView_label_userBlockYou));
    this.A.setVisibility(8);
  }
  
  private void H() {
    E();
    this.g.setVisibility(0);
    int i = this.ac;
    if (i != 0) {
      if (i != 1) {
        if (i == 2) {
          if (this.f.is_manager == 1 || this.f.uid.equalsIgnoreCase(getCurrentAnchor())) {
            this.k.setVisibility(8);
          } else {
            this.k.setVisibility(0);
          } 
          this.j.setVisibility(0);
          this.t.setVisibility(0);
          this.h.setVisibility(0);
          this.u.setVisibility(0);
          this.i.setVisibility(8);
          this.v.setVisibility(8);
          this.I.setVisibility(0);
          this.J.setVisibility(0);
          this.M.setVisibility(8);
          this.N.setVisibility(8);
        } 
      } else {
        this.j.setVisibility(0);
        this.t.setVisibility(8);
        this.h.setVisibility(8);
        this.u.setVisibility(0);
        this.i.setVisibility(0);
        this.v.setVisibility(0);
        this.I.setVisibility(8);
        this.J.setVisibility(8);
        this.M.setVisibility(0);
        this.N.setVisibility(0);
        this.k.setVisibility(8);
      } 
    } else {
      List<String> list = this.ab;
      if (list != null && list.contains(this.f.uid)) {
        this.j.setVisibility(8);
        this.t.setVisibility(8);
        this.h.setVisibility(8);
        this.u.setVisibility(0);
        this.i.setVisibility(8);
        this.v.setVisibility(8);
        this.I.setVisibility(0);
        this.J.setVisibility(0);
        this.M.setVisibility(8);
        this.N.setVisibility(8);
        this.k.setVisibility(8);
      } else {
        this.j.setVisibility(0);
        this.t.setVisibility(0);
        this.h.setVisibility(0);
        this.u.setVisibility(0);
        this.i.setVisibility(8);
        this.v.setVisibility(8);
        this.I.setVisibility(0);
        this.J.setVisibility(0);
        this.M.setVisibility(8);
        this.N.setVisibility(8);
        this.k.setVisibility(8);
      } 
    } 
    i = this.aq;
    if (i != 1) {
      if (i != 2) {
        if (i != 3)
          return; 
        if (this.W)
          EventTrackLive.a(LiveProtos.Event.PK_LIVE_PROFILE_FOLLOW_BTN_SHOW, LiveRoomManager.a().b(), this.f.uid, EventTrackLive.b(this.f.relationship)); 
        I();
        return;
      } 
      I();
      return;
    } 
    J();
    this.w.setVisibility(0);
    if (this.ac == 1) {
      this.i.setVisibility(8);
      this.v.setVisibility(8);
      this.M.setVisibility(8);
      this.N.setVisibility(8);
      return;
    } 
    this.t.setVisibility(8);
    this.J.setVisibility(8);
  }
  
  private void I() {
    this.j.setVisibility(4);
    this.D.setVisibility(8);
    this.i.setVisibility(8);
    this.k.setVisibility(8);
    this.v.setVisibility(8);
    this.M.setVisibility(8);
    this.N.setVisibility(8);
  }
  
  private void J() {
    this.g.setVisibility(8);
    this.j.setVisibility(4);
    this.w.setVisibility(8);
    this.D.setVisibility(8);
    this.k.setVisibility(8);
  }
  
  public static void a(Context paramContext, IRequestHost paramIRequestHost, String paramString) {
    LiveUserCardPop liveUserCardPop = new LiveUserCardPop(paramContext, paramIRequestHost, "", Long.valueOf(0L), Short.valueOf((short)0), new UserCardOnclickListner() {
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
        });
    liveUserCardPop.f.uid = paramString;
    (new XPopup.Builder(paramContext)).a((BasePopupView)liveUserCardPop).h();
  }
  
  public void A() {
    LiveRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(this, this.af) {
          protected void a(BluedEntityA<LiveRoomUserModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData())
              AppMethods.a(this.a.d.getResources().getString(R.string.live_manager_removed)); 
          }
        }this.af, String.valueOf(this.ah), this.f.uid);
  }
  
  public void B() {
    LiveRoomUserModel liveRoomUserModel = this.f;
    if (liveRoomUserModel != null) {
      int i;
      if (!TextUtils.isEmpty(liveRoomUserModel.name))
        if (!TextUtils.isEmpty(this.f.note)) {
          TextView textView = this.B;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(this.f.note);
          stringBuilder1.append("(");
          stringBuilder1.append(this.f.name);
          stringBuilder1.append(")");
          textView.setText(stringBuilder1.toString());
        } else {
          this.B.setText(this.f.name);
        }  
      LiveRoomInfo.a().a(this.d, this.B, this.f, R.color.syc_dark_h);
      if (this.f.is_manager == 1) {
        this.ao.setVisibility(0);
      } else {
        this.ao.setVisibility(8);
      } 
      LiveUtils.a(this.d, this.aj, this.f.anchor_level, true);
      LiveBitmapUtils.a(this.d, this.O, this.f.rich_level);
      if (this.f.rich_level >= 1) {
        this.ap.setVisibility(0);
        i = this.d.getResources().getColor(R.color.syc_r);
        this.P.setVisibility(0);
        if (this.f.rich_level >= 30) {
          switch (this.f.rich_level) {
            case 34:
              this.Q.setImageResource(R.drawable.bg_lv34_usercard);
              break;
            case 33:
              this.Q.setImageResource(R.drawable.bg_lv33_usercard);
              break;
            case 32:
              this.Q.setImageResource(R.drawable.bg_lv32_usercard);
              break;
            case 31:
              this.Q.setImageResource(R.drawable.bg_lv31_usercard);
              break;
            case 30:
              this.Q.setImageResource(R.drawable.bg_lv30_usercard);
              break;
          } 
        } else if (this.f.rich_level >= 26) {
          this.Q.setImageResource(R.drawable.bg_lv26_usercard);
        } else if (this.f.rich_level >= 21) {
          this.Q.setImageResource(R.drawable.bg_lv21_usercard);
        } else if (this.f.rich_level >= 11) {
          this.Q.setImageResource(R.drawable.bg_lv11_usercard);
        } else {
          this.P.setVisibility(4);
        } 
      } else {
        this.ap.setVisibility(8);
        i = this.d.getResources().getColor(R.color.nafio_b);
        this.P.setVisibility(4);
      } 
      if (this.f.liang_type == 1) {
        if (TextUtils.equals(this.f.uid, LiveRoomInfo.a().f())) {
          this.S.setVisibility(0);
          this.S.setImageResource(R.drawable.live_liang_gray);
        } else {
          this.S.setVisibility(8);
        } 
        this.U.setTextColor(this.d.getResources().getColor(R.color.syc_dark_79818D));
        this.U.setVisibility(0);
        TextView textView = this.U;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("ID: ");
        stringBuilder1.append(this.f.liang_id);
        textView.setText(stringBuilder1.toString());
        this.R.setVisibility(0);
        this.T.setVisibility(8);
      } else if (this.f.liang_type >= 2) {
        this.S.setVisibility(0);
        this.S.setImageResource(R.drawable.live_liang);
        this.U.setTextColor(this.d.getResources().getColor(R.color.syc_w_465CF2));
        this.U.setVisibility(0);
        TextView textView = this.U;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(" : ");
        stringBuilder1.append(this.f.liang_id);
        textView.setText(stringBuilder1.toString());
        this.R.setVisibility(0);
        this.T.setVisibility(0);
      } else {
        this.S.setVisibility(8);
        this.R.setVisibility(8);
      } 
      if (TextUtils.equals(this.f.uid, LiveRoomInfo.a().f()))
        this.S.setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param1View) {
                EventTrackLive.a(LiveProtos.Event.BETTER_ID_MY_PROFILE_BATTER_CLICK);
                LiveRoomInfo.a().b(this.a.d, LiveRoomInfo.a().E());
              }
            }); 
      ImageLoader.a(this.af, this.f.avatar).a(R.drawable.user_bg_round).a(2.0F, i).a(this.E);
      if (!TextUtils.isEmpty(this.f.location))
        this.L.setText(this.f.location); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.f.age);
      stringBuilder.append(this.d.getResources().getString(R.string.age_unit));
      stringBuilder.append(this.ae);
      stringBuilder.append(LiveRoomInfo.a().a(this.f.height, true));
      stringBuilder.append(this.ae);
      stringBuilder.append(LiveRoomInfo.a().b(this.f.weight, true));
      stringBuilder.append(this.ae);
      stringBuilder.append(LiveRoomInfo.a().a(this.d, null, this.f.role));
      String str = stringBuilder.toString();
      this.C.setText(str);
      if (this.ab != null && getCurrentAnchor() != null && getCurrentAnchor().equals(this.f.uid) && !TextUtils.isEmpty(this.f.description)) {
        str = this.f.description;
        this.K.setText(str);
        this.A.setVisibility(0);
      } else {
        this.A.setVisibility(8);
      } 
      LiveRoomInfo.a().a(this.F, this.f.vbadge);
      LiveRoomInfo.a().a(this.G, this.f);
    } 
    if (TextUtils.equals(LiveRoomInfo.a().f(), this.f.uid)) {
      J();
    } else {
      C();
      if (F())
        if (this.an != 1) {
          H();
        } else {
          this.j.setVisibility(4);
          this.t.setVisibility(8);
          this.h.setVisibility(8);
          this.u.setVisibility(0);
          this.i.setVisibility(8);
          this.v.setVisibility(8);
          this.k.setVisibility(8);
          this.I.setVisibility(0);
          this.J.setVisibility(0);
          this.M.setVisibility(8);
          this.N.setVisibility(8);
          this.g.setVisibility(0);
        }  
    } 
    LiveUserRelationshipUtils.a(this.d, this.f.relationship, this.x, null);
  }
  
  public void C() {
    if (this.f.allow_active == 0) {
      this.k.setText(this.d.getString(R.string.liveVideo_livingView_label_cancelForbidToSpeak));
      return;
    } 
    this.k.setText(this.d.getString(R.string.liveVideo_livingView_label_forbidToSpeakButton));
  }
  
  public void D() {
    p();
  }
  
  public void R_() {}
  
  public void a(LiveRoomUserModel paramLiveRoomUserModel, int paramInt) {
    if (PlayingOnliveFragment.T) {
      KeyboardUtils.a((Activity)this.d);
      AppInfo.n().postDelayed(new Runnable(this, paramLiveRoomUserModel, paramInt) {
            public void run() {
              this.c.a(this.a, this.b, (LiveMsgReportModel)null);
            }
          }500L);
      return;
    } 
    a(paramLiveRoomUserModel, paramInt, (LiveMsgReportModel)null);
  }
  
  public void a(LiveRoomUserModel paramLiveRoomUserModel, int paramInt, LiveMsgReportModel paramLiveMsgReportModel) {
    if (paramLiveRoomUserModel != null) {
      this.ar = paramLiveMsgReportModel;
      this.aq = paramInt;
      if (this.ag == null)
        this.ag = new UserCardOnclickListner(this) {
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
      this.ag.b();
      this.z.setVisibility(4);
      this.y.setVisibility(0);
      this.P.setVisibility(4);
      this.f = paramLiveRoomUserModel;
      B();
      getUserinfo();
    } 
  }
  
  public void a(String paramString) {
    LiveRoomUserModel liveRoomUserModel = this.f;
    liveRoomUserModel.relationship = paramString;
    if (liveRoomUserModel.uid.equals(getCurrentAnchor()))
      LiveMsgSendManager.a().j(); 
    LiveUserRelationshipUtils.a(this.d, paramString, this.x, null);
    LiveRelationshipObserver.a().a(paramString, this.f.uid);
  }
  
  public void a(String paramString, int paramInt) {
    LiveRoomUserModel liveRoomUserModel = this.f;
    liveRoomUserModel.uid = paramString;
    liveRoomUserModel.name = "";
    liveRoomUserModel.avatar = "";
    a(liveRoomUserModel, paramInt);
  }
  
  public void a(String paramString1, String paramString2) {
    PopAnchorBadge.a(this.d, paramString2, getCurrentAnchor(), paramString1, new PopAnchorBadge.DismissLisnter(this) {
          public void a() {
            LiveUserCardPop.a(this.a).a();
          }
          
          public void b() {
            LiveUserCardPop.a(this.a).c();
          }
        },  this.af);
  }
  
  public void b() {
    super.b();
    c();
    c(this.f.uid);
  }
  
  public void b(String paramString) {
    this.f.relationship = paramString;
    LiveUserRelationshipUtils.a(this.d, paramString, this.x, null);
    LiveRelationshipObserver.a().a(paramString, this.f.uid);
  }
  
  public void c() {
    int i = (this.d.getResources().getDisplayMetrics()).widthPixels;
    this.ad = new LoadOptions();
    LoadOptions loadOptions = this.ad;
    loadOptions.l = false;
    loadOptions.b = R.drawable.user_bg_round;
    this.ad.d = R.drawable.user_bg_round;
    loadOptions = this.ad;
    i >>= 1;
    loadOptions.a(i, i);
    this.e = LayoutInflater.from(this.d);
    this.H = (View)this;
    this.ap = (TextView)this.H.findViewById(R.id.tv_avatar_gold_border);
    this.ao = (ImageView)this.H.findViewById(R.id.img_manager_icon);
    this.P = this.H.findViewById(R.id.view_over30_ribbon);
    this.Q = (ImageView)this.H.findViewById(R.id.img_ribbon);
    this.R = this.H.findViewById(R.id.ll_liang);
    this.S = (ImageView)this.H.findViewById(R.id.img_liang);
    this.T = (ImageView)this.H.findViewById(R.id.iv_liang_icon);
    this.U = (TextView)this.H.findViewById(R.id.tv_liang_id);
    this.j = this.H.findViewById(R.id.tv_report);
    this.j.setOnClickListener(this);
    this.k = (TextView)this.H.findViewById(R.id.tv_silence);
    this.k.setOnClickListener(this);
    this.y = (LinearLayout)this.H.findViewById(R.id.ll_loading);
    this.t = (LinearLayout)this.H.findViewById(R.id.ll_reply);
    this.t.setOnClickListener(this);
    this.u = (LinearLayout)this.H.findViewById(R.id.ll_attention);
    this.u.setOnClickListener(this);
    this.v = (LinearLayout)this.H.findViewById(R.id.ll_manage);
    this.v.setOnClickListener(this);
    this.w = (LinearLayout)this.H.findViewById(R.id.ll_bottom_button);
    this.z = (LinearLayout)this.H.findViewById(R.id.ll_userinfo);
    this.I = (LinearLayout)this.H.findViewById(R.id.ll_view_profile);
    this.I.setOnClickListener(this);
    this.A = (LinearLayout)this.H.findViewById(R.id.ll_description);
    this.g = this.H.findViewById(R.id.tv_cut_bottom);
    this.h = this.H.findViewById(R.id.tv_cut_attention);
    this.i = this.H.findViewById(R.id.tv_cut_silence);
    this.x = (TextView)this.H.findViewById(R.id.tv_attention);
    this.k = (TextView)this.H.findViewById(R.id.tv_silence);
    this.K = (TextView)this.H.findViewById(R.id.tv_description);
    this.J = (TextView)this.H.findViewById(R.id.tv_cut_chat);
    this.M = (TextView)this.H.findViewById(R.id.tv_cut_connect);
    this.N = (LinearLayout)this.H.findViewById(R.id.ll_connect);
    this.N.setOnClickListener(this);
    this.B = (TextView)this.H.findViewById(R.id.tv_name);
    this.E = (ImageView)this.H.findViewById(R.id.header_view);
    this.O = (ImageView)this.H.findViewById(R.id.img_rich_rank);
    this.aj = (ImageView)this.H.findViewById(R.id.img_anchor_lvl);
    this.F = (ImageView)this.H.findViewById(R.id.img_verify);
    this.G = (ImageView)this.H.findViewById(R.id.img_vip_icon);
    this.C = (TextView)this.H.findViewById(R.id.tv_userinfo_line1);
    this.D = (TextView)this.H.findViewById(R.id.tv_block);
    this.b = this.H.findViewById(R.id.tv_bg);
    this.L = (TextView)this.H.findViewById(R.id.tv_distance);
    this.ak = (RecyclerView)this.H.findViewById(R.id.lv_medals);
    this.b.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.D();
          }
        });
    this.c = this.H.findViewById(R.id.ll_content);
    this.c.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
  }
  
  public void c(String paramString) {
    a(paramString, 0);
  }
  
  public void d() {}
  
  public void e() {}
  
  public String getCurrentAnchor() {
    List<String> list = this.ab;
    return (list != null && list.size() > 0) ? this.ab.get(0) : "";
  }
  
  public int getImplLayoutId() {
    return R.layout.item_pop_usercard;
  }
  
  public String getUid() {
    return this.f.uid;
  }
  
  public String getUserName() {
    return this.f.name;
  }
  
  public void getUserinfo() {
    if ("fromname".equals(this.f.uid)) {
      LiveRoomHttpUtils.b(this.aa, this.f.uid, this.f.name, this.af);
      return;
    } 
    LiveRoomHttpUtils.b(this.aa, this.f.uid, this.f.name, this.af);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.ll_view_profile) {
      if (LiveRoomManager.a().h() != null && (LiveRoomManager.a().h()).link_type == 4)
        EventTrackLive.b(LiveProtos.Event.USER_MIKE_USER_PHOTO_CARD_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e(), this.f.uid); 
      if (!LiveRefreshUIObserver.a().e())
        return; 
      D();
      this.ag.c();
      if (this.ab.contains(this.f.uid)) {
        LiveRoomInfo.a().a(this.d, this.f.uid, this.f.name, this.f.avatar, this.f.is_show_vip_page, 1);
        return;
      } 
      LiveRoomInfo.a().a(this.d, this.f.uid, this.f.name, this.f.avatar, this.f.is_show_vip_page, 2);
      return;
    } 
    if (paramView.getId() == R.id.tv_report) {
      D();
      this.ag.a(this.f.uid, this.ar);
      return;
    } 
    if (paramView.getId() == R.id.ll_reply) {
      if (!LiveRoomInfo.a().a(this.d, null)) {
        D();
        this.ag.b(this.f.uid, this.f.name);
        return;
      } 
    } else {
      String str;
      if (paramView.getId() == R.id.ll_attention) {
        if (this.aq == 3)
          EventTrackLive.a(LiveProtos.Event.PK_LIVE_PROFILE_FOLLOW_BTN_CLICK, LiveRoomManager.a().b(), this.f.uid, EventTrackLive.b(this.f.relationship)); 
        if (getCurrentAnchor() != null && getCurrentAnchor().equalsIgnoreCase(this.f.uid)) {
          str = "liveanchor_";
        } else {
          str = "live_";
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.ah);
        str = stringBuilder.toString();
        LiveRoomInfo.a().a(this.d, this, this.f.uid, this.f.relationship, str, this.af, false);
        return;
      } 
      if (str.getId() == R.id.ll_connect) {
        D();
        this.ag.a(this.f);
        return;
      } 
      if (str.getId() == R.id.ll_manage) {
        EventTrackLive.a(LiveProtos.Event.LIVE_MANAGE_BTN_CLICK, LiveRoomManager.a().c(), this.f.uid);
        y();
        InstantLog.a("live_manage_btn_click");
        return;
      } 
      if (str.getId() == R.id.tv_silence) {
        if (this.f.allow_active != 1) {
          this.f.allow_active = 1;
          C();
          this.ag.c(this.f.uid, this.f.name);
          InstantLog.b("live_banned_option_click", 2);
          AppMethods.d(R.string.live_released_to_speak_tip);
          return;
        } 
        InstantLog.b("live_banned_option_click", 0);
        this.f.allow_active = 0;
        C();
        this.ag.a(getUid(), getUserName());
        AppMethods.d(R.string.live_forbid_to_speak_tip);
      } 
    } 
  }
  
  public void setFromSource(int paramInt) {
    this.an = paramInt;
  }
  
  public void setUserCardHostId(String paramString) {
    List<String> list = this.ab;
    if (list == null) {
      this.ab = new ArrayList<String>();
    } else {
      list.clear();
    } 
    this.ab.add(paramString);
  }
  
  public void setUserCardHostId(List<String> paramList) {
    List<String> list = this.ab;
    if (list == null) {
      this.ab = new ArrayList<String>();
    } else {
      list.clear();
    } 
    if (paramList != null)
      this.ab.addAll(paramList); 
  }
  
  public void y() {
    ArrayList<String> arrayList = new ArrayList();
    if (this.f.allow_active == 1) {
      if (this.f.is_manager == 1) {
        arrayList.add(this.d.getString(R.string.live_cancel_manage));
      } else {
        arrayList.add(this.d.getString(R.string.live_set_manager));
      } 
      arrayList.add(this.d.getString(R.string.live_manager_list));
      arrayList.add(this.d.getString(R.string.live_temp_banned));
      arrayList.add(this.d.getString(R.string.live_perm_banned));
    } else {
      if (this.f.is_manager == 1) {
        arrayList.add(this.d.getString(R.string.live_cancel_manage));
      } else {
        arrayList.add(this.d.getString(R.string.live_set_manager));
      } 
      arrayList.add(this.d.getString(R.string.live_manager_list));
      arrayList.add(this.d.getString(R.string.liveVideo_livingView_label_cancelForbidToSpeak));
    } 
    int[] arrayOfInt = new int[arrayList.size()];
    for (int i = 0; i < arrayOfInt.length; i++)
      arrayOfInt[i] = R.color.syc_a; 
    String[] arrayOfString = arrayList.<String>toArray(new String[arrayList.size()]);
    Context context = this.d;
    PopActionSheet.a(context, arrayOfString, arrayOfInt, DensityUtils.a(context, 200.0F), true, new PopActionSheet.PopSheetClickListner(this) {
          public void onClick(int param1Int, String param1String) {
            if (param1String.equalsIgnoreCase(this.a.d.getString(R.string.live_set_manager))) {
              this.a.z();
            } else if (param1String.equalsIgnoreCase(this.a.d.getString(R.string.live_cancel_manage))) {
              this.a.A();
            } else if (param1String.equalsIgnoreCase(this.a.d.getString(R.string.live_manager_list))) {
              LiveUserCardPop.a(this.a).d();
            } else if (param1String.equalsIgnoreCase(this.a.d.getString(R.string.live_temp_banned))) {
              this.a.f.allow_active = 0;
              this.a.C();
              LiveUserCardPop.a(this.a).a(this.a.getUid(), this.a.getUserName());
              InstantLog.b("live_banned_option_click", 0);
              AppMethods.d(R.string.live_forbid_to_speak_tip);
            } else if (param1String.equalsIgnoreCase(this.a.d.getString(R.string.live_perm_banned))) {
              this.a.f.allow_active = 0;
              this.a.C();
              LiveUserCardPop.a(this.a).a(this.a.getUid());
              InstantLog.b("live_banned_option_click", 1);
              AppMethods.d(R.string.live_forbid_to_speak_tip);
            } else if (param1String.equalsIgnoreCase(this.a.d.getString(R.string.liveVideo_livingView_label_cancelForbidToSpeak))) {
              this.a.f.allow_active = 1;
              this.a.C();
              LiveUserCardPop.a(this.a).c(this.a.getUid(), this.a.getUserName());
              InstantLog.b("live_banned_option_click", 2);
              AppMethods.d(R.string.live_released_to_speak_tip);
            } 
            this.a.D();
          }
        });
  }
  
  public void z() {
    LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(this, this.af) {
          boolean a = false;
          
          String b;
          
          protected void a(BluedEntityA<LiveRoomUserModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData())
              AppMethods.a(this.c.d.getResources().getString(R.string.live_manager_settled)); 
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
              CommonAlertDialog.a(this.c.d, null, "", this.b, this.c.d.getString(R.string.live_manager_manage), this.c.d.getString(R.string.live_ok), null, new DialogInterface.OnClickListener(this) {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                      LiveUserCardPop.a(this.a.c).d();
                    }
                  },  null, true);
              this.a = false;
            } 
          }
        }this.af, String.valueOf(this.ah), this.f.uid);
  }
  
  public static interface FROM_SOURCE {}
  
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
    public UserMedalAdapterForCard(LiveUserCardPop this$0, Context param1Context, List<AnchorMedal> param1List) {
      super(param1Context, param1List);
    }
    
    public View a() {
      return this.a.e.inflate(R.layout.item_user_anchor_medal4card, null);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\pop\LiveUserCardPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */