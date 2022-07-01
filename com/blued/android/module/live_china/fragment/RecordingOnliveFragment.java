package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.chat.data.BadgeData;
import com.blued.android.chat.data.EntranceData;
import com.blued.android.chat.data.LiveChatStatistics;
import com.blued.android.chat.data.LiveCloseReason;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.AnimationUtils;
import com.blued.android.module.common.utils.AssetsUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.external_sense_library.contract.ISetStickerListener;
import com.blued.android.module.external_sense_library.model.ErrorCode;
import com.blued.android.module.external_sense_library.utils.STLicenseUtils;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live.base.view.animation.AnimationListenerAdapter;
import com.blued.android.module.live.base.view.animation.LiveAnimationListener;
import com.blued.android.module.live.base.view.animation.LiveAnimationView;
import com.blued.android.module.live.base.view.animation.LiveAnimationViewFactory;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.activity.PlayingOnliveActivity;
import com.blued.android.module.live_china.common.ZegoCommonHelper;
import com.blued.android.module.live_china.liveForMsg.LiveMsgManager;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.live_interface.IScreenManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.manager.PlayARObserver;
import com.blued.android.module.live_china.manager.PlayGifObserver;
import com.blued.android.module.live_china.manager.RecordingMakeFriendManager;
import com.blued.android.module.live_china.manager.RecordingMakeLoverManager;
import com.blued.android.module.live_china.manager.RecordingMsgManager;
import com.blued.android.module.live_china.manager.RecordingOnliveManager;
import com.blued.android.module.live_china.manager.RecordingPlayerManager;
import com.blued.android.module.live_china.manager.RecordingScreenManager;
import com.blued.android.module.live_china.mine.LiveRouteUtil;
import com.blued.android.module.live_china.model.BluedLiveTopCard;
import com.blued.android.module.live_china.model.GrabBoxDetailModel;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveHornModel;
import com.blued.android.module.live_china.model.LiveLiangModel;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.model.LiveMusicModel;
import com.blued.android.module.live_china.model.LiveMusicSongModel;
import com.blued.android.module.live_china.model.LivePkBannerModel;
import com.blued.android.module.live_china.model.LiveRecordLevelStickerModel;
import com.blued.android.module.live_china.model.LiveRecordRecommendModel;
import com.blued.android.module.live_china.model.LiveRewardModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.LiveShopStatusExtra;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.model.RankingExtra;
import com.blued.android.module.live_china.model.ShopStatusModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.BeansRefreshObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.observer.ZanRefreshObserver;
import com.blued.android.module.live_china.pop.LiveOfficalRecommendPop;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.LiveRoomUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.model.LogData;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.GrabRewardView;
import com.blued.android.module.live_china.view.HornView;
import com.blued.android.module.live_china.view.LiveAnchorTaskView;
import com.blued.android.module.live_china.view.LiveConnectionInviteView;
import com.blued.android.module.live_china.view.LiveConnectionView;
import com.blued.android.module.live_china.view.LiveCueView;
import com.blued.android.module.live_china.view.LiveMakeFriendListView;
import com.blued.android.module.live_china.view.LiveMakeFriendManageView;
import com.blued.android.module.live_china.view.LiveMakeFriendSettingView;
import com.blued.android.module.live_china.view.LiveMakeLoverManagerRecordView;
import com.blued.android.module.live_china.view.LiveMakeLoverRootRecordView;
import com.blued.android.module.live_china.view.LiveMultiFunctionView;
import com.blued.android.module.live_china.view.LiveMusicFloatView;
import com.blued.android.module.live_china.view.LivePKBubbleLayout;
import com.blued.android.module.live_china.view.LivePKCountDownView;
import com.blued.android.module.live_china.view.LivePKProgressView;
import com.blued.android.module.live_china.view.LivePKResult;
import com.blued.android.module.live_china.view.LivePKUserBanner;
import com.blued.android.module.live_china.view.LiveRankingButtonView;
import com.blued.android.module.live_china.view.LiveRecordLevelView;
import com.blued.android.module.live_china.view.LiveRecordStickerViewLayout;
import com.blued.android.module.live_china.view.LiveTitleView;
import com.blued.android.module.live_china.view.LiveViewerListView;
import com.blued.android.module.live_china.view.MedalView;
import com.blued.android.module.live_china.view.PKDoubleAnimView;
import com.blued.android.module.live_china.view.PopBeautyNewView;
import com.blued.android.module.live_china.view.PopGestureView;
import com.blued.android.module.live_china.view.PopLiveActivityWebView;
import com.blued.android.module.live_china.view.PopLiveCallView;
import com.blued.android.module.live_china.view.PopPKListView;
import com.blued.android.module.live_china.view.PopRankingListView;
import com.blued.android.module.live_china.view.PopRecordLevelView;
import com.blued.android.module.live_china.view.PopRewardConfigView;
import com.blued.android.module.live_china.view.PopStickerView;
import com.blued.android.module.live_china.view.StartLiveView;
import com.blued.android.module.player.live.view.BLVideoView;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.File;
import java.util.List;

public class RecordingOnliveFragment extends LiveBaseFragment implements View.OnClickListener, View.OnTouchListener, Chronometer.OnChronometerTickListener, LiveFansRecordDialogFragment.ILiveFansRecordDialog, LiveRankGuestDialogFragment.ILiveGuestDialog, PlayARObserver.IPlayARObserver, PlayGifObserver.IPlayGifObserver, BeansRefreshObserver.IBeansRefreshObserver, LiveSetDataObserver.ILiveSetDataObserver, ZanRefreshObserver.IZanRefreshObserver {
  public static boolean cx = false;
  
  public FrameLayout A;
  
  public KeyboardListenLinearLayout B;
  
  public FrameLayout C;
  
  public FrameLayout D;
  
  public TextureView E;
  
  protected ImageView F;
  
  public ImageView G;
  
  public ImageView H;
  
  public boolean I = false;
  
  public ImageView J;
  
  public View K;
  
  public boolean L = false;
  
  public boolean M;
  
  public ImageView N;
  
  public boolean O;
  
  public boolean P;
  
  public LinearLayout Q;
  
  public ImageView R;
  
  public RecordingOnliveManager S;
  
  public RecordingMsgManager T;
  
  public PowerManager.WakeLock U;
  
  public long V = 0L;
  
  public Chronometer W;
  
  public View X;
  
  public View Y;
  
  public RelativeLayout Z;
  
  public FrameLayout aA;
  
  public FrameLayout aB;
  
  public FrameLayout aC;
  
  public FrameLayout aD;
  
  public TextureView aE;
  
  public TextureView aF;
  
  public TextureView aG;
  
  public TextureView aH;
  
  public TextureView aI;
  
  public TextureView aJ;
  
  public ImageView aK;
  
  public ImageView aL;
  
  public TextView aM;
  
  public TextView aN;
  
  public TextView aO;
  
  public TextView aP;
  
  public FrameLayout aQ;
  
  public FrameLayout aR;
  
  public FrameLayout aS;
  
  public ImageView aT;
  
  public ImageView aU;
  
  public ImageView aV;
  
  public View aW;
  
  public View aX;
  
  public View aY;
  
  public LiveMakeLoverRootRecordView aZ;
  
  public TextView aa;
  
  public TextView ab;
  
  public Button ac;
  
  public TextView ad;
  
  public LiveViewerListView ae;
  
  public TextView af;
  
  public double ag;
  
  public double ah;
  
  public ProgressBar ai;
  
  public PopBeautyNewView aj;
  
  public MedalView ak;
  
  public HornView al;
  
  public LiveRankGuestDialogFragment am;
  
  public LiveFansRecordDialogFragment an;
  
  public LiveRegularEventRanklistDialogFragment ao;
  
  public LiveManagerDialogFragment ap;
  
  public ImageView aq;
  
  public ImageView ar;
  
  public FrameLayout as;
  
  public FrameLayout at;
  
  public FrameLayout au;
  
  public FrameLayout av;
  
  public FrameLayout aw;
  
  public FrameLayout ax;
  
  public FrameLayout ay;
  
  public FrameLayout az;
  
  public ImageView bA;
  
  public LivePKBubbleLayout bB;
  
  public LivePKBubbleLayout bC;
  
  public LivePKCountDownView bD;
  
  public View bE;
  
  public View bF;
  
  public View bG;
  
  public View bH;
  
  public View bI;
  
  public View bJ;
  
  public View bK;
  
  public View bL;
  
  public TextView bM;
  
  public TextView bN;
  
  public TextView bO;
  
  public PopLiveCallView bP;
  
  public ImageView bQ;
  
  public ImageView bR;
  
  public LiveAnimationView bS;
  
  public LivePKResult bT;
  
  public LiveConnectionInviteView bU;
  
  public boolean bV;
  
  public boolean bW;
  
  public ImageView bX;
  
  public LiveMakeFriendListView bY;
  
  public ImageView bZ;
  
  public LiveMakeLoverManagerRecordView ba;
  
  public RecordingMakeLoverManager bb;
  
  public LiveMakeLoverDialogFragment bc;
  
  public LiveAnchorTaskView bd;
  
  public boolean be;
  
  public boolean bf;
  
  public boolean bg = false;
  
  public boolean bh;
  
  public LiveAnimationView bi;
  
  public ViewGroup bj;
  
  public GrabRewardView bk;
  
  public FrameLayout bl;
  
  public IScreenManager bm;
  
  public int bn;
  
  public ImageView bo;
  
  public ImageView bp;
  
  public ImageView bq;
  
  public LiveConnectionView br;
  
  public FrameLayout bs;
  
  public FrameLayout bt;
  
  public LivePKProgressView bu;
  
  public LivePKUserBanner bv;
  
  public LinearLayout bw;
  
  public ImageView bx;
  
  public TextView by;
  
  public LinearLayout bz;
  
  public long cA;
  
  public CountDownTimer cB;
  
  public long cC = 6000L;
  
  GestureDetector cD = new GestureDetector(this.y, (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
        public boolean onDoubleTap(MotionEvent param1MotionEvent) {
          Logger.a("drb", new Object[] { "双击事件" });
          return super.onDoubleTap(param1MotionEvent);
        }
        
        public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
          Logger.a("drb", new Object[] { "单击事件" });
          return super.onSingleTapConfirmed(param1MotionEvent);
        }
      });
  
  public PopStickerView cE;
  
  public PopGestureView cF;
  
  public LiveMsgManager cG;
  
  LiveOfficalRecommendPop cH = null;
  
  private ImageView cI;
  
  private ImageView cJ;
  
  private ImageView cK;
  
  private LiveRankingButtonView cL;
  
  private BLVideoView cM;
  
  private PKDoubleAnimView cN;
  
  private RecordingMakeFriendManager cO;
  
  private View cP;
  
  private TextView cQ;
  
  private LinearLayout cR;
  
  private ImageView cS;
  
  private LiveRecordLevelView cT;
  
  private View cU;
  
  private Chronometer cV;
  
  private ListView cW;
  
  private View cX;
  
  private PopRankingListView cY;
  
  private PopPKListView cZ;
  
  public int ca;
  
  public int cb;
  
  public int cc;
  
  public String cd;
  
  public StartLiveView ce;
  
  public LiveMakeFriendSettingView cf;
  
  public View cg;
  
  public ImageView ch;
  
  public ImageView ci;
  
  public LiveTitleView cj;
  
  public LiveMultiFunctionView ck;
  
  public ImageView cl;
  
  public ShapeTextView cm;
  
  public View cn;
  
  public View co;
  
  public ImageView cp;
  
  public TextView cq;
  
  public ImageView cr;
  
  public LiveRecordStickerViewLayout cs;
  
  public View ct;
  
  public LiveMusicFloatView cu;
  
  public ImageView cv;
  
  public PopLiveActivityWebView cw;
  
  public boolean cy;
  
  public RecordingPlayerManager cz;
  
  private LiveMusicFragment da;
  
  private PopRewardConfigView db;
  
  private boolean dc;
  
  private long dd;
  
  private LiveLiangWebDialogFragment de;
  
  private LiveHostFinishDlgFragment df;
  
  private LiveActivityWebDialogFragment dg;
  
  private CountDownTimer dh;
  
  private boolean di = false;
  
  public Context y;
  
  public PopupWindow z;
  
  private void a(int paramInt, String paramString) {
    View view = LayoutInflater.from(this.y).inflate(R.layout.pop_top_card, null);
    TextView textView1 = (TextView)view.findViewById(R.id.tv_receive);
    TextView textView2 = (TextView)view.findViewById(R.id.tv_card_count);
    String str2 = this.y.getResources().getString(R.string.live_title_topcard);
    String str1 = str2;
    if (paramInt > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str2);
      stringBuilder.append("x");
      stringBuilder.append(paramInt);
      str1 = stringBuilder.toString();
    } 
    textView2.setText(str1);
    textView1.setOnClickListener(new View.OnClickListener(this, paramString) {
          public void onClick(View param1View) {
            RecordingOnliveFragment.a(this.b, LiveProtos.Event.LIVE_PRE_TOP_CARD_GET_CLICK);
            this.b.k(this.a);
          }
        });
    ((ImageView)view.findViewById(R.id.live_iv_close)).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.z.dismiss();
          }
        });
    if (this.z == null) {
      this.z = new PopupWindow(view, -1, -1);
      this.z.setBackgroundDrawable((Drawable)new ColorDrawable(0));
      this.z.setOutsideTouchable(true);
      this.z.setFocusable(true);
    } 
    a(LiveProtos.Event.LIVE_PRE_TOP_CARD_POP_SHOW);
    this.z.showAtLocation(getActivity().getWindow().getDecorView(), 17, 0, 0);
  }
  
  public static void a(Context paramContext, int paramInt) {
    LiveRoomInfo.a().a(new PermissionCallbacks(paramInt, paramContext) {
          public void a(String[] param1ArrayOfString) {}
          
          public void aa_() {
            Bundle bundle = new Bundle();
            bundle.putInt("official", this.a);
            TerminalActivity.a(bundle);
            PlayingOnliveActivity.b(this.b, RecordingOnliveFragment.class, bundle);
          }
        });
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, String paramString1, int paramInt3, String paramString2) {
    LiveRoomInfo.a().a(new PermissionCallbacks(paramInt1, paramInt2, paramInt3, paramString2, paramContext) {
          public void a(String[] param1ArrayOfString) {}
          
          public void aa_() {
            Bundle bundle = new Bundle();
            bundle.putInt("live_type", this.a);
            bundle.putInt("live_screen_orientation", this.b);
            bundle.putInt("live_countdown", this.c);
            bundle.putString("live_from_source", this.d);
            TerminalActivity.a(bundle);
            PlayingOnliveActivity.b(this.e, RecordingOnliveFragment.class, bundle);
          }
        });
  }
  
  private void a(LiveProtos.Event paramEvent) {
    LiveProtos.CardFrom cardFrom;
    if (TextUtils.equals("message_upcard", this.cd)) {
      cardFrom = LiveProtos.CardFrom.MSG_PREP_PAGE;
    } else {
      cardFrom = LiveProtos.CardFrom.DIRECT_PREP_PAGE;
    } 
    EventTrackLive.a(paramEvent, cardFrom);
  }
  
  private void bj() {
    LiveEventBus.get("live_luck_turning_btn", Boolean.class).observe((LifecycleOwner)this, new -$$Lambda$RecordingOnliveFragment$uEdRexfFXUg9mfHeiz6CspRnAs8(this));
    LiveEventBus.get("live_show_dialog", Boolean.class).observe((LifecycleOwner)this, new -$$Lambda$RecordingOnliveFragment$8yMqp-z_F2Szx3cm_vRM2I2zwGs(this));
    LiveEventBus.get("live_ranking_msg", RankingExtra.class).observe((LifecycleOwner)this, new -$$Lambda$RecordingOnliveFragment$uLmS4PBEs3m9hU5YMmTZ3Pynwcw(this));
    LiveEventBus.get("live_ranking_dialog", Integer.class).observe((LifecycleOwner)this, new -$$Lambda$RecordingOnliveFragment$BbU05FRHX4AjLtfSNdpuztYJJsM(this));
    LiveEventBus.get("live_pk_dialog", LivePkBannerModel.class).observe((LifecycleOwner)this, new Observer<LivePkBannerModel>(this) {
          public void a(LivePkBannerModel param1LivePkBannerModel) {
            if (param1LivePkBannerModel == null)
              return; 
            if (LiveRoomManager.a().h() == null)
              return; 
            if (RecordingOnliveFragment.a(this.a) == null) {
              RecordingOnliveFragment recordingOnliveFragment = this.a;
              RecordingOnliveFragment.a(recordingOnliveFragment, new PopPKListView((BaseFragment)recordingOnliveFragment));
            } 
            param1LivePkBannerModel.from = 1;
            RecordingOnliveFragment.a(this.a).a(param1LivePkBannerModel);
          }
        });
    LiveEventBus.get("live_used_top_card", String.class).observe((LifecycleOwner)this, new -$$Lambda$RecordingOnliveFragment$yuYK0KdKSRZItLzXP6lrM6GRQwU(this));
    LiveEventBus.get(LiveEventBusUtil.b, ChattingModel.class).observe((LifecycleOwner)this, new -$$Lambda$RecordingOnliveFragment$bhk-l34_ls_O59PXKgJDfQRd2eo(this));
    LiveEventBus.get(LiveEventBusUtil.c, EntranceData.class).observe((LifecycleOwner)this, new -$$Lambda$RecordingOnliveFragment$LeF22D-kvR9VHydXXgml9K6se1s(this));
  }
  
  private void bk() {
    this.dh = (new CountDownTimer(this, 60000L, 1000L) {
        public void onFinish() {
          Logger.d("RecordingOnliveFragment", new Object[] { "run timmer_1 onFinish ... " });
          this.a.R.setVisibility(8);
        }
        
        public void onTick(long param1Long) {}
      }).start();
  }
  
  private void bl() {
    ImageView imageView = this.aq;
    if (imageView == null)
      return; 
    boolean bool = this.be;
    byte b = 8;
    if (bool) {
      imageView.setVisibility(8);
      return;
    } 
    if (cx)
      b = 0; 
    imageView.setVisibility(b);
  }
  
  private void bm() {
    this.br.a(this);
    this.bU.a(this);
    this.bY.a(0, null, this.u, (BaseFragment)this);
    this.q.a(true, new LiveMakeFriendManageView.LiveManageOnClickListener(this) {
          public void a() {
            this.a.bY.b(true);
          }
        });
    this.ba.a(true, new LiveMakeLoverManagerRecordView.LiveMakeLoverOnClickListener(this) {
          public void a() {
            EventTrackLive.a(LiveProtos.Event.ANCHOR_MIKE_MANAGE_CLICK, String.valueOf(this.a.u));
            this.a.ah();
          }
        });
    this.bk.a((BaseFragment)this);
    this.bP = new PopLiveCallView((BaseFragment)this);
    this.cE = new PopStickerView(this, this.S);
    this.cE.a();
    this.cF = new PopGestureView(this, this.S);
    this.cF.a();
  }
  
  private void bn() {
    if (this.be) {
      h(4);
    } else {
      g(4);
    } 
    this.cG.a(4);
  }
  
  private void bo() {
    if (this.be) {
      h(0);
    } else {
      g(0);
    } 
    this.cG.a(0);
    C();
  }
  
  private void bp() {
    if (LiveRoomPreferences.l() == 0 && !this.be)
      this.H.setVisibility(0); 
  }
  
  private void bq() {
    LiveRoomPreferences.g(1);
    this.H.setVisibility(8);
  }
  
  private void br() {
    LiveRouteUtil.a((BaseFragment)this, 0, aQ());
  }
  
  private void bs() {
    LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<ShopStatusModel, LiveShopStatusExtra>>(this, (IRequestHost)w_()) {
          public void onUIUpdate(BluedEntity<ShopStatusModel, LiveShopStatusExtra> param1BluedEntity) {
            if (param1BluedEntity.getSingleData() != null && this.a.ck != null) {
              LiveMultiFunctionView liveMultiFunctionView = this.a.ck;
              int i = ((ShopStatusModel)param1BluedEntity.getSingleData()).status;
              boolean bool = true;
              if (i != 1)
                bool = false; 
              liveMultiFunctionView.a(bool);
            } 
            LiveShopStatusExtra liveShopStatusExtra = (LiveShopStatusExtra)param1BluedEntity.extra;
            if (liveShopStatusExtra != null && this.a.ck != null)
              this.a.ck.a(liveShopStatusExtra.top_card_count); 
          }
        }(IRequestHost)w_());
    a(new Runnable(this) {
          public void run() {
            this.a.ba();
          }
        },  500L);
  }
  
  private void bt() {
    if (this.df != null) {
      LogUtils.c("finishFragment is showing");
      return;
    } 
    FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
    this.df = new LiveHostFinishDlgFragment();
    fragmentTransaction.add(this.A.getId(), (Fragment)this.df, "finishFragment");
    fragmentTransaction.commitAllowingStateLoss();
  }
  
  private void bu() {
    String str = AssetsUtils.a("live_pk_start.png", false);
    str = RecyclingUtils.Scheme.c.b(str);
    this.bS.a((IRequestHost)w_(), "", str, "", "", null);
  }
  
  private void bv() {
    LiveMultiFunctionView liveMultiFunctionView = this.ck;
    if (liveMultiFunctionView != null)
      liveMultiFunctionView.f(); 
    ShapeTextView shapeTextView = this.cm;
    if (shapeTextView != null)
      shapeTextView.setVisibility(0); 
  }
  
  public void D() {
    super.D();
    this.aZ.d();
  }
  
  public void D_() {
    bo();
  }
  
  public void E() {
    a(new Runnable(this) {
          public void run() {
            this.a.ae.a();
          }
        });
  }
  
  public void E_() {}
  
  public void F() {
    a(new -$$Lambda$RecordingOnliveFragment$UcyDUwd0kpJjz_wLuQJMGQEuMtQ(this));
  }
  
  public void F_() {
    Logger.d("RecordingOnliveFragment", new Object[] { "IM消息点击领取奖励。。。" });
    this.bd.getTaskList();
  }
  
  public void G() {}
  
  public void G_() {
    LiveLiangModel liveLiangModel = LiveRoomManager.a().j();
    if (liveLiangModel != null) {
      if (liveLiangModel.liang_type == 1) {
        boolean bool;
        View view = this.co;
        if (LiveFloatManager.a().B()) {
          bool = true;
        } else {
          bool = false;
        } 
        view.setVisibility(bool);
        this.cp.setImageResource(R.drawable.live_liang_gray);
        this.cp.setVisibility(0);
      } else if (liveLiangModel.liang_type >= 2) {
        boolean bool;
        View view = this.co;
        if (LiveFloatManager.a().B()) {
          bool = true;
        } else {
          bool = false;
        } 
        view.setVisibility(bool);
        this.cp.setImageResource(R.drawable.live_liang);
        this.cp.setVisibility(0);
      } else {
        this.co.setVisibility(8);
      } 
      if (!TextUtils.isEmpty(liveLiangModel.liang_id)) {
        this.cq.setVisibility(0);
        this.cq.setText(liveLiangModel.liang_id);
        return;
      } 
      this.cq.setVisibility(8);
    } 
  }
  
  public void H() {}
  
  public void H_() {}
  
  public void I() {
    Logger.a("drb", new Object[] { "notifyPlayGif isPlayFullScreen = ", Boolean.valueOf(this.O) });
    if (!this.O)
      a(new Runnable(this) {
            public void run() {
              this.a.az();
            }
          }); 
  }
  
  public void I_() {}
  
  public void J() {
    this.bh = true;
    this.bd.c();
    ap();
    this.ai.setVisibility(0);
    if (this.X.getVisibility() == 0) {
      long l1 = System.currentTimeMillis();
      long l2 = this.cA;
      RecordingOnliveManager recordingOnliveManager = this.S;
      if (recordingOnliveManager != null)
        recordingOnliveManager.b((l1 - l2) / 1000L); 
    } 
  }
  
  public void J_() {
    AppInfo.n().post(new Runnable(this) {
          public void run() {
            this.a.W.start();
          }
        });
  }
  
  public void K() {
    if (aQ()) {
      this.ak.setVisibility(8);
      return;
    } 
    if (LiveRoomManager.a().h() != null && (LiveRoomManager.a().h()).badges != null) {
      if ((LiveRoomManager.a().h()).badges.size() > 0) {
        this.ak.setVisibility(0);
        return;
      } 
      this.ak.setVisibility(8);
      return;
    } 
    this.ak.setVisibility(8);
  }
  
  public void K_() {
    a(new Runnable(this) {
          public void run() {
            this.a.W.stop();
          }
        });
  }
  
  public void L() {}
  
  public void M() {}
  
  public void N() {
    this.bE.setVisibility(0);
    aC();
    aA();
    if (this.be) {
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DensityUtils.a(this.y, 157.0F), DensityUtils.a(this.y, 280.0F));
      layoutParams.gravity = 85;
      layoutParams.setMargins(0, 0, DensityUtils.a(this.y, 50.0F), DensityUtils.a(this.y, 10.0F));
      this.bE.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } else {
      FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DensityUtils.a(this.y, 105.0F), DensityUtils.a(this.y, 187.0F));
      layoutParams.gravity = 85;
      layoutParams.setMargins(0, 0, 0, DensityUtils.a(this.y, 64.0F));
      this.bE.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
    l(3);
    this.br.h();
  }
  
  public void O() {
    Log.v("==record", "stopRTCModel");
    this.bE.setVisibility(8);
    aB();
    aV();
    RecordingOnliveManager recordingOnliveManager = this.S;
    if (recordingOnliveManager != null)
      recordingOnliveManager.h(); 
  }
  
  public void P() {}
  
  public void Q() {
    this.ce.e();
  }
  
  public void R() {
    this.ce.f();
  }
  
  public void S() {}
  
  public void T() {
    if (this.be)
      getActivity().setRequestedOrientation(0); 
    this.bl.setVisibility(0);
    a(new Runnable(this) {
          public void run() {
            this.a.M_();
            this.a.a((LiveRoomManager.a().h()).beans_count, (LiveRoomManager.a().h()).beans_current_count);
            this.a.ak.a(LiveRoomInfo.a().f(), LiveRoomInfo.a().f(), (BaseFragment)this.a);
            this.a.a((LiveRoomManager.a().h()).badges);
            LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("勋章数据：");
            stringBuilder.append((LiveRoomManager.a().h()).badges.size());
            liveMsgSendManager.b(stringBuilder.toString());
            liveMsgSendManager = LiveMsgSendManager.a();
            stringBuilder = new StringBuilder();
            stringBuilder.append("活动排行：");
            stringBuilder.append((LiveRoomManager.a().h()).rank);
            liveMsgSendManager.b(stringBuilder.toString());
            liveMsgSendManager = LiveMsgSendManager.a();
            stringBuilder = new StringBuilder();
            stringBuilder.append("活动图标：");
            stringBuilder.append((LiveRoomManager.a().h()).icon);
            liveMsgSendManager.b(stringBuilder.toString());
            this.a.a((LiveRoomManager.a().h()).elapse_time);
            this.a.J_();
            this.a.cz.a((LiveRoomManager.a().h()).live_url);
            RecordingOnliveFragment.c(this.a);
            this.a.ad();
            this.a.cG.n();
          }
        }1000L);
  }
  
  public void U() {
    Bundle bundle = new Bundle();
    bundle.putLong("KEY_LID", this.u);
    this.ap = new LiveManagerDialogFragment();
    this.ap.a(new LiveRankGuestDialogFragment.ILiveGuestDialog(this) {
          public void y_() {
            this.a.a(new Runnable(this) {
                  public void run() {
                    this.a.a.y_();
                  }
                },  500L);
          }
          
          public void z_() {
            this.a.z_();
          }
        });
    this.ap.setArguments(bundle);
    this.ap.show(getFragmentManager(), "managerListDialog");
  }
  
  public void V() {
    this.A = (FrameLayout)this.e.findViewById(R.id.live_host_content_fl);
    this.B = (KeyboardListenLinearLayout)this.e.findViewById(R.id.keyboardLinearLayout);
    this.C = (FrameLayout)this.e.findViewById(R.id.cameraPreview_afl);
    this.D = (FrameLayout)this.e.findViewById(R.id.camera_preview_container);
    this.E = (TextureView)this.e.findViewById(R.id.cameraPreview_surfaceView);
    this.cM = (BLVideoView)this.e.findViewById(R.id.VideoView);
    this.bl = (FrameLayout)this.e.findViewById(R.id.switch_orientation_layout);
    if (StatusBarHelper.a())
      this.bl.setPadding(0, StatusBarHelper.a((Context)getActivity()), 0, 0); 
    this.X = this.e.findViewById(R.id.live_loading_layout);
    this.Y = this.e.findViewById(R.id.live_interrupt_layout);
    this.aa = (TextView)this.Y.findViewById(R.id.error_tips_title);
    this.ab = (TextView)this.Y.findViewById(R.id.error_tips_message);
    this.ac = (Button)this.Y.findViewById(R.id.error_tips_btn);
    this.as = (FrameLayout)this.e.findViewById(R.id.RemoteWindowA);
    this.at = (FrameLayout)this.e.findViewById(R.id.RemoteWindowB);
    this.au = (FrameLayout)this.e.findViewById(R.id.RemoteWindowC);
    this.av = (FrameLayout)this.e.findViewById(R.id.RemoteWindowD);
    this.aw = (FrameLayout)this.e.findViewById(R.id.RemoteWindowE);
    this.ax = (FrameLayout)this.e.findViewById(R.id.RemoteWindowF);
    this.ay = (FrameLayout)this.e.findViewById(R.id.fl_RemoteGLSurfaceViewA);
    this.az = (FrameLayout)this.e.findViewById(R.id.fl_RemoteGLSurfaceViewB);
    this.aA = (FrameLayout)this.e.findViewById(R.id.fl_RemoteGLSurfaceViewC);
    this.aB = (FrameLayout)this.e.findViewById(R.id.fl_RemoteGLSurfaceViewD);
    this.aC = (FrameLayout)this.e.findViewById(R.id.fl_RemoteGLSurfaceViewE);
    this.aD = (FrameLayout)this.e.findViewById(R.id.fl_RemoteGLSurfaceViewF);
    this.aE = (TextureView)this.e.findViewById(R.id.RemoteGLSurfaceViewA);
    this.aF = (TextureView)this.e.findViewById(R.id.RemoteGLSurfaceViewB);
    this.aG = (TextureView)this.e.findViewById(R.id.RemoteGLSurfaceViewC);
    this.aH = (TextureView)this.e.findViewById(R.id.RemoteGLSurfaceViewD);
    this.aI = (TextureView)this.e.findViewById(R.id.RemoteGLSurfaceViewE);
    this.aJ = (TextureView)this.e.findViewById(R.id.RemoteGLSurfaceViewF);
    this.aK = (ImageView)this.e.findViewById(R.id.out_userA_btn);
    this.aL = (ImageView)this.e.findViewById(R.id.out_userB_btn);
    this.aM = (TextView)this.e.findViewById(R.id.remote_nameA);
    this.aN = (TextView)this.e.findViewById(R.id.remote_nameB);
    this.aO = (TextView)this.e.findViewById(R.id.remote_nameC);
    this.aP = (TextView)this.e.findViewById(R.id.remote_nameD);
    this.aQ = (FrameLayout)this.e.findViewById(R.id.remote_loading_layoutB);
    this.aR = (FrameLayout)this.e.findViewById(R.id.remote_loading_layoutC);
    this.aS = (FrameLayout)this.e.findViewById(R.id.remote_loading_layoutD);
    this.cI = (ImageView)this.e.findViewById(R.id.live_make_friend_num_B);
    this.cJ = (ImageView)this.e.findViewById(R.id.live_make_friend_num_C);
    this.cK = (ImageView)this.e.findViewById(R.id.live_make_friend_num_D);
    this.aT = (ImageView)this.e.findViewById(R.id.live_make_friend_mic_B);
    this.aU = (ImageView)this.e.findViewById(R.id.live_make_friend_mic_C);
    this.aV = (ImageView)this.e.findViewById(R.id.live_make_friend_mic_D);
    this.aW = this.e.findViewById(R.id.live_make_friend_free_B);
    this.aX = this.e.findViewById(R.id.live_make_friend_free_C);
    this.aY = this.e.findViewById(R.id.live_make_friend_free_D);
    this.bZ = (ImageView)this.e.findViewById(R.id.live_make_friend_num_host);
    this.bX = (ImageView)this.e.findViewById(R.id.live_make_friends_close_btn);
    this.ci = (ImageView)this.e.findViewById(R.id.live_make_friend_photo_A);
    this.bq = (ImageView)this.e.findViewById(R.id.live_switch_screen);
    this.bs = (FrameLayout)this.e.findViewById(R.id.live_window_root_layout);
    this.bt = (FrameLayout)this.e.findViewById(R.id.live_window_layout);
    this.bu = (LivePKProgressView)this.e.findViewById(R.id.live_pk_progress);
    this.bv = (LivePKUserBanner)this.e.findViewById(R.id.live_pk_banner);
    this.bw = (LinearLayout)this.e.findViewById(R.id.live_pk_operate_layout);
    this.bx = (ImageView)this.e.findViewById(R.id.live_pk_operate_close);
    this.by = (TextView)this.e.findViewById(R.id.live_pk_operate_text);
    this.bB = (LivePKBubbleLayout)this.e.findViewById(R.id.live_pk_my_bubble);
    this.bC = (LivePKBubbleLayout)this.e.findViewById(R.id.live_pk_your_bubble);
    this.bS = (LiveAnimationView)this.e.findViewById(R.id.live_pk_start_anim);
    this.cN = (PKDoubleAnimView)this.e.findViewById(R.id.pk_double_anim_view);
    this.cN.setVisibility(8);
    this.bT = (LivePKResult)this.e.findViewById(R.id.pk_result);
    this.bD = (LivePKCountDownView)this.e.findViewById(R.id.live_pk_count_down_view);
    this.bD.setData((BaseFragment)this);
    this.bE = this.e.findViewById(R.id.live_window_layout_B);
    this.bF = this.e.findViewById(R.id.live_window_layoutC);
    this.bG = this.e.findViewById(R.id.live_window_layoutD);
    this.bH = this.e.findViewById(R.id.live_window_layoutE);
    this.bI = this.e.findViewById(R.id.live_window_layoutF);
    this.bJ = this.e.findViewById(R.id.live_make_friend_windows_B);
    this.bK = this.e.findViewById(R.id.live_make_friend_windows_C);
    this.bL = this.e.findViewById(R.id.live_make_friend_windows_D);
    this.bM = (TextView)this.e.findViewById(R.id.live_make_friend_name_B);
    this.bN = (TextView)this.e.findViewById(R.id.live_make_friend_name_C);
    this.bO = (TextView)this.e.findViewById(R.id.live_make_friend_name_D);
    this.aZ = (LiveMakeLoverRootRecordView)this.e.findViewById(R.id.live_make_lover_record_root_view);
    this.aZ.a(this);
    this.ba = (LiveMakeLoverManagerRecordView)this.e.findViewById(R.id.live_make_lover_manage_view);
    this.br = (LiveConnectionView)this.e.findViewById(R.id.live_connection_view);
    this.bQ = (ImageView)this.e.findViewById(R.id.live_pk_my_result_icon);
    this.bR = (ImageView)this.e.findViewById(R.id.live_pk_your_result_icon);
    this.bU = (LiveConnectionInviteView)this.e.findViewById(R.id.live_connection_invite_view);
    this.bY = (LiveMakeFriendListView)this.e.findViewById(R.id.live_make_friend_list_view);
    this.ce = (StartLiveView)this.e.findViewById(R.id.start_live_view);
    this.ce.a(this);
    this.bl.setVisibility(8);
    this.cg = this.e.findViewById(R.id.live_my_header_layout);
    this.ch = (ImageView)this.e.findViewById(R.id.live_my_header_view);
    ImageLoader.a((IRequestHost)w_(), LiveRoomInfo.a().d()).a(this.ch);
    this.cn = this.e.findViewById(R.id.live_pk_tips);
    this.cP = this.cn.findViewById(R.id.live_pk_tips_btn);
    this.cQ = (TextView)this.cn.findViewById(R.id.live_pk_tips_text);
    this.cQ.setText(R.string.live_pk_tips_record);
    this.cs = (LiveRecordStickerViewLayout)this.e.findViewById(R.id.live_record_sticker_layout);
    this.ct = this.e.findViewById(R.id.live_record_sticker_bottom_view);
    this.cs.a(this);
    this.ac.setOnClickListener(this);
    this.Y.setOnClickListener(this);
    this.aK.setOnClickListener(this);
    this.aL.setOnClickListener(this);
    this.bq.setOnTouchListener(this);
    this.bx.setOnClickListener(this);
    this.bX.setOnClickListener(this);
    this.bJ.setOnClickListener(this);
    this.bK.setOnClickListener(this);
    this.bL.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.cP.setOnClickListener(this);
  }
  
  public boolean V_() {
    if (this.Y.getVisibility() == 0) {
      this.ac.performClick();
      return true;
    } 
    if (this.ai.getVisibility() == 0)
      return false; 
    if (this.br.g()) {
      this.br.h();
      return true;
    } 
    PopLiveCallView popLiveCallView = this.bP;
    if (popLiveCallView != null && popLiveCallView.c()) {
      this.bP.a();
      return true;
    } 
    if (A() == 1) {
      this.bD.a(true);
      return true;
    } 
    LiveMakeFriendListView liveMakeFriendListView = this.bY;
    if (liveMakeFriendListView != null && liveMakeFriendListView.c()) {
      this.bY.b();
      return true;
    } 
    if (aP()) {
      g(true);
      return true;
    } 
    if (this.ce.c())
      return true; 
    LiveMultiFunctionView liveMultiFunctionView = this.ck;
    if (liveMultiFunctionView != null && liveMultiFunctionView.b()) {
      this.ck.a();
      return true;
    } 
    LiveTitleView liveTitleView = this.cj;
    if (liveTitleView != null && liveTitleView.b()) {
      this.cj.a();
      return true;
    } 
    PopLiveActivityWebView popLiveActivityWebView = this.cw;
    if (popLiveActivityWebView != null && popLiveActivityWebView.e()) {
      this.cw.f();
      return true;
    } 
    PopRankingListView popRankingListView = this.cY;
    if (popRankingListView != null && popRankingListView.a()) {
      this.cY.c();
      return true;
    } 
    LiveMusicFragment liveMusicFragment = this.da;
    if (liveMusicFragment != null && !liveMusicFragment.isHidden()) {
      bc();
      return true;
    } 
    LiveHostFinishDlgFragment liveHostFinishDlgFragment = this.df;
    if (liveHostFinishDlgFragment != null && liveHostFinishDlgFragment.V_())
      return true; 
    LiveRouteUtil.b((BaseFragment)this);
    return true;
  }
  
  public void W() {
    View view = this.e.findViewById(R.id.live_container);
    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
    this.e.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, layoutParams, view) {
          public void onGlobalLayout() {
            int i = this.c.e.getHeight();
            if (i != 0) {
              this.c.e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
              this.a.height = i;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("params.height:");
              stringBuilder.append(this.a.height);
              Log.i("==xpf", stringBuilder.toString());
              this.b.setLayoutParams(this.a);
            } 
          }
        });
    u();
    this.aq = (ImageView)this.e.findViewById(R.id.lucky_turning);
    ImageView imageView = this.aq;
    if (imageView != null) {
      imageView.setOnClickListener(this);
      bl();
    } 
    this.cw = (PopLiveActivityWebView)this.e.findViewById(R.id.live_activity_web_view);
    PopLiveActivityWebView popLiveActivityWebView = this.cw;
    if (popLiveActivityWebView != null)
      popLiveActivityWebView.a((Fragment)this); 
    Logger.a("drb", new Object[] { "reInitView LiveBeautyBtn" });
    this.cX = this.e.findViewById(R.id.ll_btm_btn);
    this.ar = (ImageView)this.e.findViewById(R.id.live_like_view);
    this.G = (ImageView)this.e.findViewById(R.id.live_reward_view);
    this.H = (ImageView)this.e.findViewById(R.id.live_pk_new);
    this.K = this.e.findViewById(R.id.close_btn);
    this.J = (ImageView)this.e.findViewById(R.id.rank_showing);
    this.F = (ImageView)this.e.findViewById(R.id.header_view);
    this.Q = (LinearLayout)this.e.findViewById(R.id.live_activity_layout);
    this.R = (ImageView)this.e.findViewById(R.id.live_room_topcard_using);
    this.cu = (LiveMusicFloatView)this.e.findViewById(R.id.music_float_view);
    this.ak = (MedalView)this.e.findViewById(R.id.medal_view);
    this.ai = (ProgressBar)this.e.findViewById(R.id.loading_view);
    this.N = (ImageView)this.e.findViewById(R.id.all_gif_view);
    this.ad = (TextView)this.e.findViewById(R.id.onlive_all_count);
    this.af = (TextView)this.e.findViewById(R.id.onlive_current_beans);
    this.Z = (RelativeLayout)this.e.findViewById(R.id.live_bottom_root);
    this.W = (Chronometer)this.e.findViewById(R.id.chronometer);
    this.ae = (LiveViewerListView)this.e.findViewById(R.id.live_viewer);
    this.bi = (LiveAnimationView)this.e.findViewById(R.id.live_animation_layou);
    this.bj = (ViewGroup)this.e.findViewById(R.id.live_rank_btn);
    this.cL = (LiveRankingButtonView)this.e.findViewById(R.id.ranking_button_view);
    this.al = (HornView)this.e.findViewById(R.id.horn_view);
    this.bo = (ImageView)this.e.findViewById(R.id.switch_horizontal_view);
    this.bp = (ImageView)this.e.findViewById(R.id.switch_vertical_view);
    this.bz = (LinearLayout)this.e.findViewById(R.id.live_pk_rank_layout);
    this.bA = (ImageView)this.e.findViewById(R.id.live_pk_rank_icon);
    this.bk = (GrabRewardView)this.e.findViewById(R.id.grab_reward_view);
    this.cj = (LiveTitleView)this.e.findViewById(R.id.live_title_view);
    this.ck = (LiveMultiFunctionView)this.e.findViewById(R.id.live_multi_function_view);
    this.ck.setLiveEventListener(new -$$Lambda$RecordingOnliveFragment$NpinzKsI9xE1RL5On5ML1DjJSKw(this));
    this.cj.a(this.be, this);
    this.ck.a(this.be, this);
    this.cl = (ImageView)this.e.findViewById(R.id.live_multi_function_btn);
    this.cm = (ShapeTextView)this.e.findViewById(R.id.live_multi_function_dot);
    this.cR = (LinearLayout)this.e.findViewById(R.id.live_anchor_layout);
    this.cS = (ImageView)this.e.findViewById(R.id.header_level_bg);
    this.cT = (LiveRecordLevelView)this.e.findViewById(R.id.live_record_relevel_view);
    this.co = this.e.findViewById(R.id.ll_liang);
    this.cp = (ImageView)this.e.findViewById(R.id.iv_liang);
    this.cq = (TextView)this.e.findViewById(R.id.tv_liang_id);
    this.cr = (ImageView)this.e.findViewById(R.id.liang_enter_view);
    this.cU = this.e.findViewById(R.id.ll_recommend);
    this.cV = (Chronometer)this.e.findViewById(R.id.tv_recommend_time);
    this.cW = (ListView)this.e.findViewById(R.id.live_msg_content_pullrefresh);
    this.cv = (ImageView)this.e.findViewById(R.id.live_fans_btn);
    this.bd = (LiveAnchorTaskView)this.e.findViewById(R.id.live_new_anchor_task_view);
    this.bd.a((BaseFragment)this, this.be);
    this.cl.setOnClickListener(this);
    this.W.setOnChronometerTickListener(this);
    this.ar.setOnClickListener(this);
    this.J.setOnClickListener(this);
    this.K.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.bj.setOnClickListener(this);
    this.bo.setOnClickListener(this);
    this.bp.setOnClickListener(this);
    this.cT.setOnClickListener(this);
    this.cv.setOnClickListener(this);
    this.cu.setOnClickListener(this);
    this.cr.setOnClickListener(this);
    this.co.setOnClickListener(this);
    ImageLoader.a((IRequestHost)w_(), LiveRoomInfo.a().d()).c().a(R.drawable.user_bg_round).a(this.F);
  }
  
  public void X() {
    if (LiveRoomManager.a().h() == null)
      return; 
    int i = (LiveRoomManager.a().h()).level;
    int j = (LiveRoomManager.a().h()).next_level;
    float f1 = (LiveRoomManager.a().h()).percent;
    float f2 = CommonStringUtils.b((LiveRoomManager.a().h()).gap_exp);
    a(i, j, (int)f1, f2);
  }
  
  public void Y() {
    if (LiveRoomPreferences.j() == 0)
      this.cn.setVisibility(0); 
  }
  
  public void Z() {
    if (!this.be) {
      if (!LiveRoomPreferences.I()) {
        LiveRoomPreferences.J();
        br();
      } 
      if (LiveRoomManager.a().k() && !LiveRoomPreferences.K()) {
        LiveRoomPreferences.L();
        br();
      } 
    } 
  }
  
  public void a() {
    bn();
  }
  
  public void a(double paramDouble1, double paramDouble2) {
    Logger.a("rrrb", new Object[] { "notifyUpdateBeans beans = ", Double.valueOf(paramDouble1), " -- beans_current_count = ", Double.valueOf(paramDouble2) });
    if (paramDouble1 >= 0.0D) {
      if (paramDouble2 < this.ah)
        return; 
      LiveRoomManager.a().a(paramDouble1, paramDouble2);
      this.ag = paramDouble1;
      this.ah = paramDouble2;
      this.af.setText(CommonStringUtils.d(String.valueOf(paramDouble2)));
    } 
  }
  
  public void a(int paramInt1, int paramInt2) {
    RecordingPlayerManager recordingPlayerManager = this.cz;
    if (recordingPlayerManager != null)
      recordingPlayerManager.a(paramInt1, paramInt2); 
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat) {
    this.cc = paramInt1;
    this.cT.a(paramInt1, paramInt2, paramInt3, paramFloat);
    i(paramInt1);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(long paramLong) {
    this.V = paramLong;
  }
  
  protected void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.y = (Context)getActivity();
    if (!STLicenseUtils.a(getContext()))
      AppMethods.d(R.string.sense_license_is_overdue); 
    this.U = ((PowerManager)getActivity().getSystemService("power")).newWakeLock(536870938, "RecordingOnliveFragment");
    this.bm = (IScreenManager)new RecordingScreenManager(this);
    b(this.B);
    if (paramBundle != null && paramBundle.getBoolean("unexpectedly_exit"))
      h(true); 
    bs();
  }
  
  public void a(EditText paramEditText) {}
  
  public void a(LiveChatStatistics paramLiveChatStatistics) {
    this.bf = true;
    a(new Runnable(this, paramLiveChatStatistics) {
          public void run() {
            Logger.d("RecordingOnliveFragment", new Object[] { "中断直播 ... " });
            this.b.aK();
            if (this.b.bd != null)
              this.b.bd.c(); 
            this.b.J();
            if (!TextUtils.isEmpty(this.a.title)) {
              this.b.aa.setText(this.a.title);
            } else {
              this.b.aa.setText(R.string.Live_applyHost_wormNotice);
            } 
            if (!TextUtils.isEmpty(this.a.message)) {
              this.b.ab.setText(this.a.message);
            } else {
              this.b.ab.setText(this.b.getString(R.string.liveVideo_livingView_tips_interrupted));
            } 
            this.b.Y.setVisibility(0);
            AnimationUtils.a(this.b.Y);
          }
        });
  }
  
  public void a(ChattingModel paramChattingModel) {
    this.cG.c(paramChattingModel);
  }
  
  public void a(LiveFriendModel paramLiveFriendModel) {
    this.br.a(paramLiveFriendModel);
    b_(7);
    RecordingOnliveManager recordingOnliveManager = this.S;
    if (recordingOnliveManager != null)
      recordingOnliveManager.a(0, paramLiveFriendModel.target_stream); 
  }
  
  public void a(LiveGiftModel paramLiveGiftModel) {
    this.cG.d(paramLiveGiftModel);
  }
  
  public void a(LiveHornModel paramLiveHornModel, boolean paramBoolean) {
    if (this.al == null)
      this.al = (HornView)this.e.findViewById(R.id.horn_view); 
    HornView hornView = this.al;
    if (hornView != null)
      hornView.a(paramLiveHornModel, paramBoolean); 
  }
  
  public void a(LiveMakeLoverFansModel paramLiveMakeLoverFansModel) {}
  
  public void a(LiveMusicModel paramLiveMusicModel) {
    if (!this.dc) {
      this.dc = true;
      AppMethods.d(R.string.live_music_volume);
    } 
    this.cu.setVisibility(0);
    this.cu.setData(paramLiveMusicModel);
    LiveMusicFragment liveMusicFragment = this.da;
    if (liveMusicFragment != null)
      liveMusicFragment.G(); 
    ZegoCommonHelper.b().b(paramLiveMusicModel);
  }
  
  public void a(LiveMusicSongModel paramLiveMusicSongModel) {
    Log.i("==record", "getMusicInfo");
    if (ZegoCommonHelper.b().d(paramLiveMusicSongModel.music_id)) {
      Log.i("==record", "getMusicInfo has file url");
      if (ZegoCommonHelper.b().c(paramLiveMusicSongModel.music_id)) {
        this.cu.c();
        ZegoCommonHelper.b().d(1);
        ZegoCommonHelper.b().i();
        return;
      } 
      ZegoCommonHelper.b().j();
      return;
    } 
    if (this.di) {
      Log.i("==record", "getMusicInfo isMusicFileUrlRequesting true");
      return;
    } 
    LiveMusicModel liveMusicModel = new LiveMusicModel();
    liveMusicModel.music_id = paramLiveMusicSongModel.music_id;
    liveMusicModel.name = paramLiveMusicSongModel.music_name;
    liveMusicModel.artist = paramLiveMusicSongModel.artist;
    liveMusicModel.cover = paramLiveMusicSongModel.cover;
    liveMusicModel.duration = paramLiveMusicSongModel.duration;
    ZegoCommonHelper.b().a(liveMusicModel);
    LiveRoomHttpUtils.d(paramLiveMusicSongModel.music_id, new BluedUIHttpResponse<BluedEntityA<LiveMusicModel>>(this, (IRequestHost)w_(), paramLiveMusicSongModel) {
          protected void a(BluedEntityA<LiveMusicModel> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              LiveMusicModel liveMusicModel = param1BluedEntityA.data.get(0);
              liveMusicModel.name = this.a.music_name;
              liveMusicModel.artist = this.a.artist;
              liveMusicModel.duration = this.a.duration;
              liveMusicModel.cover = this.a.cover;
              this.b.a(liveMusicModel);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            AppMethods.a(param1String);
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            RecordingOnliveFragment.a(this.b, false);
          }
          
          public void onUIStart() {
            super.onUIStart();
            RecordingOnliveFragment.a(this.b, true);
          }
        });
  }
  
  public void a(LiveRecordLevelStickerModel paramLiveRecordLevelStickerModel) {
    PopStickerView popStickerView = this.cE;
    if (popStickerView != null)
      popStickerView.a(paramLiveRecordLevelStickerModel); 
  }
  
  public void a(LiveRewardModel paramLiveRewardModel) {}
  
  public void a(LiveRoomData paramLiveRoomData) {}
  
  public void a(LiveRoomUserModel paramLiveRoomUserModel) {
    this.cG.a(paramLiveRoomUserModel);
  }
  
  public void a(LiveZanExtraModel.Danmaku paramDanmaku) {}
  
  public void a(String paramString) {
    Bundle bundle = new Bundle();
    bundle.putLong(LiveRankGuestDialogFragment.a, this.u);
    bundle.putString("activity_id", paramString);
    this.ao = new LiveRegularEventRanklistDialogFragment();
    this.ao.a(new LiveRegularEventRanklistDialogFragment.ILiveHostDialog(this) {
          public void a() {
            if (this.a.be) {
              this.a.h(4);
            } else {
              this.a.g(4);
            } 
            this.a.cG.a(4);
          }
          
          public void b() {
            if (this.a.be) {
              this.a.h(0);
            } else {
              this.a.g(0);
            } 
            this.a.cG.a(0);
            this.a.C();
          }
        });
    this.ao.setArguments(bundle);
    this.ao.show(getFragmentManager(), "eventRankDialog");
  }
  
  public void a(String paramString, int paramInt) {
    this.cG.a(paramString, paramInt);
  }
  
  public void a(String paramString1, String paramString2) {
    if (this.bz == null)
      return; 
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
      this.bz.setVisibility(0);
      ImageLoader.a((IRequestHost)w_(), paramString1).a(this.bA);
      this.bz.setOnClickListener(new View.OnClickListener(this, paramString2) {
            public void onClick(View param1View) {
              LiveBottomWebDialogFragment.a((Context)this.b.getActivity(), this.b.getFragmentManager(), this.a);
            }
          });
      return;
    } 
    this.bz.setVisibility(8);
  }
  
  public void a(List<BadgeData> paramList) {
    if (aQ()) {
      this.ak.setVisibility(8);
      return;
    } 
    if (LiveRoomManager.a().h() != null)
      (LiveRoomManager.a().h()).badges = paramList; 
    if (LiveRoomManager.a().h() != null && (LiveRoomManager.a().h()).badges != null) {
      if ((LiveRoomManager.a().h()).badges.size() > 0) {
        this.ak.setVisibility(0);
      } else {
        this.ak.setVisibility(8);
      } 
    } else {
      this.ak.setVisibility(8);
    } 
    this.ak.setMedalData(paramList);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(String[] paramArrayOfString) {
    if (this.f != null)
      this.f.a(paramArrayOfString); 
  }
  
  public void aA() {
    this.at.setVisibility(0);
    this.aF.setVisibility(0);
  }
  
  public void aB() {
    if (this.at.getVisibility() == 0) {
      this.at.setVisibility(8);
      aF();
    } 
    this.aF.setVisibility(8);
    this.aN.setVisibility(8);
  }
  
  public void aC() {
    if (aP() || aQ()) {
      Log.i("drb", "showRTCLoading ignore when make friend or make lover");
      return;
    } 
    this.aQ.setVisibility(0);
  }
  
  public void aD() {
    this.aQ.setVisibility(8);
  }
  
  public TextureView aE() {
    this.E = new TextureView(getContext());
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.gravity = 17;
    this.D.removeAllViews();
    this.D.addView((View)this.E, (ViewGroup.LayoutParams)layoutParams);
    return this.E;
  }
  
  public void aF() {
    this.aF = new TextureView(getContext());
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.gravity = 17;
    this.az.removeAllViews();
    this.az.addView((View)this.aF, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public void aG() {
    this.aG = new TextureView(getContext());
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.gravity = 17;
    this.aA.removeAllViews();
    this.aA.addView((View)this.aG, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public void aH() {
    this.aH = new TextureView(getContext());
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.gravity = 17;
    this.aB.removeAllViews();
    this.aB.addView((View)this.aH, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public void aI() {
    this.aI = new TextureView(getContext());
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.gravity = 17;
    this.aC.removeAllViews();
    this.aC.addView((View)this.aI, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public void aJ() {
    this.aJ = new TextureView(getContext());
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.gravity = 17;
    this.aD.removeAllViews();
    this.aD.addView((View)this.aJ, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public void aK() {
    Logger.a("drb", new Object[] { "setScreenOrientation = " });
    a(new Runnable(this) {
          public void run() {
            if (this.a.getActivity() != null && this.a.getActivity().getResources() != null) {
              Logger.a("drb", new Object[] { "setScreenOrientation = 111" });
              Configuration configuration = this.a.getActivity().getResources().getConfiguration();
              if (configuration != null && (configuration.orientation == 2 || this.a.be))
                this.a.getActivity().setRequestedOrientation(1); 
            } 
          }
        });
  }
  
  public void aL() {
    this.cN.clearAnimation();
    this.cN.setVisibility(8);
  }
  
  public boolean aM() {
    return (A() == 7);
  }
  
  public boolean aN() {
    return (A() == 2);
  }
  
  public boolean aO() {
    return (A() == 3);
  }
  
  public boolean aP() {
    return (A() == 5);
  }
  
  public boolean aQ() {
    return (A() == 8);
  }
  
  public boolean aR() {
    return (A() == 0);
  }
  
  public boolean aS() {
    return (B() || aM() || aN() || aO() || aP() || aQ());
  }
  
  public void aT() {
    if (!B())
      return; 
    b_(0);
    RecordingOnliveManager recordingOnliveManager2 = this.S;
    if (recordingOnliveManager2 != null)
      recordingOnliveManager2.d(); 
    PopPKListView popPKListView = this.cZ;
    if (popPKListView != null && popPKListView.a())
      this.cZ.b(); 
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.bs.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = (FrameLayout.LayoutParams)this.bt.getLayoutParams();
    layoutParams.width = -1;
    layoutParams.height = -1;
    this.bt.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.C.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.bu.setVisibility(8);
    aU();
    aV();
    M_();
    this.bw.setVisibility(8);
    this.bD.c();
    this.bD.setVisibility(8);
    this.bQ.setVisibility(8);
    this.bR.setVisibility(8);
    this.bT.a();
    this.bv.a();
    this.bv.setVisibility(8);
    aL();
    Log.v("pk", "stopPK");
    RecordingOnliveManager recordingOnliveManager1 = this.S;
    if (recordingOnliveManager1 != null)
      recordingOnliveManager1.h(); 
    this.bE.setVisibility(8);
    aB();
    e(false);
  }
  
  public void aU() {
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.addRule(9);
    layoutParams.addRule(10);
    layoutParams.leftMargin = DensityUtils.a(this.y, 10.0F);
    layoutParams.topMargin = DensityUtils.a(this.y, 107.0F);
    layoutParams.bottomMargin = 0;
    LinearLayout linearLayout = this.Q;
    if (linearLayout != null)
      linearLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams); 
  }
  
  public void aV() {
    a(new Runnable(this) {
          public void run() {
            this.a.bd.a(0);
          }
        },  300L);
  }
  
  public void aW() {
    this.bb.f();
  }
  
  public void aX() {
    this.bb.g();
  }
  
  public void aY() {
    LiveRoomHttpUtils.e(new BluedUIHttpResponse<BluedEntity<LiveFriendModel, GrabBoxDetailModel>>(this, (IRequestHost)w_()) {
          public void onUIUpdate(BluedEntity<LiveFriendModel, GrabBoxDetailModel> param1BluedEntity) {
            if (param1BluedEntity != null && param1BluedEntity.hasData()) {
              LiveFriendModel liveFriendModel = param1BluedEntity.data.get(0);
              if (this.a.B() && !TextUtils.isEmpty(liveFriendModel.letter)) {
                this.a.bw.setVisibility(0);
                this.a.by.setText(liveFriendModel.letter);
                return;
              } 
              this.a.bw.setVisibility(8);
            } 
          }
        });
  }
  
  public void aZ() {
    if (this.cG == null)
      this.cG = new LiveMsgManager((BaseFragment)this); 
  }
  
  protected void a_(ChattingModel paramChattingModel) {
    this.T.a(paramChattingModel);
  }
  
  public void a_(String paramString) {
    this.cG.b(paramString);
  }
  
  public void a_(List<String> paramList) {}
  
  public void aa() {
    if (aQ())
      return; 
    LiveMultiFunctionView liveMultiFunctionView = this.ck;
    if (liveMultiFunctionView == null)
      return; 
    liveMultiFunctionView.e();
  }
  
  public void ab() {
    this.ck.d();
  }
  
  public void ac() {
    if (LiveRoomManager.a().A() == 1) {
      this.E.setVisibility(8);
      LiveRoomInfo.a().v();
      VideoPlayConfig.c(1);
      this.cz = new RecordingPlayerManager(this.cM, this.X);
    } else {
      this.S = new RecordingOnliveManager(this, this.be);
    } 
    this.cO = new RecordingMakeFriendManager(this);
    this.T = new RecordingMsgManager(this, this.S);
    this.bb = new RecordingMakeLoverManager(this);
  }
  
  public void ad() {
    LiveMsgSendManager.a().a(this.t, this.u, this);
    LiveRoomUtils.a((IRequestHost)w_(), "1");
  }
  
  public void ae() {
    LiveMsgSendManager.a().b(this.t, this.u, this);
  }
  
  public void af() {
    if (LiveRoomManager.a().h() == null)
      return; 
    if ((LiveRoomManager.a().h()).link_type != 1)
      return; 
    if ((LiveRoomManager.a().h()).pk != null)
      c((LiveRoomManager.a().h()).pk.buff_countdown); 
  }
  
  public void ag() {
    LiveFansRecordDialogFragment liveFansRecordDialogFragment = this.an;
    if (liveFansRecordDialogFragment != null && liveFansRecordDialogFragment.isVisible())
      return; 
    if ((LiveRoomManager.a().h()).profile != null)
      EventTrackLive.a(LiveProtos.Event.LIVE_FANS_CLUB_BTN_CLICK, String.valueOf(this.u), LiveRoomManager.a().e()); 
    if (!LiveRoomManager.a().k()) {
      AppMethods.d(R.string.live_fans_open_level_tip);
      return;
    } 
    this.an = new LiveFansRecordDialogFragment();
    Bundle bundle = new Bundle();
    bundle.putLong("lid", this.u);
    bundle.putString("uid", LiveRoomInfo.a().f());
    this.an.setArguments(bundle);
    this.an.a(this);
    this.an.show(getFragmentManager(), "liveFansDialog");
  }
  
  public void ah() {
    LiveMakeLoverDialogFragment liveMakeLoverDialogFragment = this.bc;
    if (liveMakeLoverDialogFragment != null && liveMakeLoverDialogFragment.isVisible())
      return; 
    this.bc = new LiveMakeLoverDialogFragment();
    Bundle bundle = new Bundle();
    bundle.putLong("lid", this.u);
    bundle.putString("uid", LiveRoomInfo.a().f());
    bundle.putInt("from", 1);
    this.bc.setArguments(bundle);
    this.bc.a(new LiveMakeLoverDialogFragment.ILiveMakeLoverDialog(this) {
          public void a() {
            this.a.C();
          }
        });
    this.bc.show(getFragmentManager(), "liveMakeLoverApplyDialog");
  }
  
  public void ai() {
    LiveMakeLoverDialogFragment liveMakeLoverDialogFragment = this.bc;
    if (liveMakeLoverDialogFragment != null && liveMakeLoverDialogFragment.isVisible())
      this.bc.dismiss(); 
  }
  
  public void aj() {
    Context context = this.y;
    CommonAlertDialog.a(context, "", context.getString(R.string.live_connection_close), null, new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (this.a.S != null) {
              this.a.S.b(R.id.RemoteGLSurfaceViewB);
              this.a.aB();
              Log.v("pk", "showCloseConnection");
              this.a.S.h();
              this.a.S.i();
              AppMethods.d(R.string.live_connection_over);
            } 
          }
        }this.y.getString(R.string.filter_off), null, null);
  }
  
  public void ak() {
    getActivity().finish();
    al();
  }
  
  public void al() {
    if (LiveRoomManager.a().B())
      LiveRoomInfo.a().a(this.y); 
  }
  
  public void am() {
    if (LiveRoomManager.a().B())
      AppMethods.d(R.string.live_game_tips); 
    if (!this.M) {
      InstantLog.a("beauty_view");
      this.M = true;
    } 
    PopBeautyNewView popBeautyNewView = this.aj;
    if (popBeautyNewView != null)
      popBeautyNewView.a(); 
  }
  
  public void an() {
    if (LiveRoomManager.a().B())
      AppMethods.d(R.string.live_game_tips); 
    if (this.L) {
      RecordingOnliveManager recordingOnliveManager1 = this.S;
      if (recordingOnliveManager1 != null)
        recordingOnliveManager1.x(); 
      this.L = false;
      this.ck.setFlashLightBtnState(false);
      return;
    } 
    RecordingOnliveManager recordingOnliveManager = this.S;
    if (recordingOnliveManager != null)
      recordingOnliveManager.w(); 
    this.L = true;
    this.ck.setFlashLightBtnState(true);
  }
  
  public void ao() {
    if (LiveRoomManager.a().B())
      AppMethods.d(R.string.live_game_tips); 
    if (this.S == null)
      return; 
    this.I ^= 0x1;
    if (this.I) {
      InstantLog.a("live_mirror_image", 1);
      this.ck.setMirrorBtnState(true);
      AppMethods.d(R.string.live_mirror_open);
    } else {
      InstantLog.a("live_mirror_image", 0);
      this.ck.setMirrorBtnState(false);
      AppMethods.d(R.string.live_mirror_close);
    } 
    this.S.b(this.I);
  }
  
  public void ap() {
    Log.v("==record", "stopOnlive");
    RecordingOnliveManager recordingOnliveManager = this.S;
    if (recordingOnliveManager != null)
      recordingOnliveManager.s(); 
    h(false);
    if (this.aj != null)
      EventTrackLive.a(LiveProtos.Event.LIVE_FILTER_USE, this.aj.e(), LiveProtos.Status.END); 
  }
  
  public void aq() {
    if (!this.P)
      a(new Runnable(this) {
            public void run() {
              if (this.a.cF != null)
                this.a.cF.e(); 
              this.a.as();
            }
          }); 
  }
  
  public void ar() {
    CountDownTimer countDownTimer = this.cB;
    if (countDownTimer != null)
      countDownTimer.cancel(); 
  }
  
  public void as() {
    if (!this.bg)
      return; 
    List<LiveGiftModel> list = this.cG.j();
    if (list.size() > 0) {
      LiveGiftModel liveGiftModel = list.get(0);
      if (this.S != null) {
        this.P = true;
        Log.v("pk", "isPlayAR true ------- ");
        this.S.a(liveGiftModel, new ISetStickerListener(this, liveGiftModel) {
              public void onFailed(ErrorCode.PlayStickerCode param1PlayStickerCode, String param1String) {
                try {
                  String str;
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("onFailed() | playStickerCode:");
                  stringBuilder1.append(param1PlayStickerCode);
                  if (stringBuilder1.toString() != null) {
                    str = String.valueOf(param1PlayStickerCode.a());
                  } else {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("");
                    stringBuilder2.append(param1String);
                    str = stringBuilder2.toString();
                  } 
                  Log.v("pk", str);
                } catch (Exception exception) {
                  exception.printStackTrace();
                } 
                LiveMsgSendManager liveMsgSendManager = LiveMsgSendManager.a();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("贴纸失败：");
                stringBuilder.append(param1String);
                liveMsgSendManager.b(stringBuilder.toString());
                this.b.c(this.a);
              }
              
              public void onSetSticker() {
                Log.v("pk", "onSetSticker");
                LiveMsgSendManager.a().b("贴纸开始播放");
                this.b.a(new -$$Lambda$RecordingOnliveFragment$22$wqKJr5Pr90fST-nN0ZifENHE76k(this, this.a));
              }
            });
        return;
      } 
    } else {
      PopGestureView popGestureView = this.cF;
      if (popGestureView != null)
        popGestureView.f(); 
    } 
  }
  
  public void at() {
    this.bU.a();
  }
  
  public void au() {
    this.cf.c();
    RecordingOnliveManager recordingOnliveManager = this.S;
    if (recordingOnliveManager != null)
      recordingOnliveManager.g(); 
    this.ci.setVisibility(0);
    ImageLoader.a((IRequestHost)w_(), LiveRoomInfo.a().d()).a(this.ci);
  }
  
  public void av() {
    this.cf.b();
    RecordingOnliveManager recordingOnliveManager = this.S;
    if (recordingOnliveManager != null)
      recordingOnliveManager.g(); 
    this.ci.setVisibility(8);
  }
  
  public void aw() {
    if (this.cF == null)
      this.cF = new PopGestureView(this, this.S); 
    this.cF.b();
  }
  
  public void ax() {
    if (this.cE == null)
      this.cE = new PopStickerView(this, this.S); 
    this.cE.b();
  }
  
  public void ay() {
    LiveRegularEventRanklistDialogFragment liveRegularEventRanklistDialogFragment = this.ao;
    if (liveRegularEventRanklistDialogFragment != null) {
      Dialog dialog = liveRegularEventRanklistDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.ao.dismiss(); 
    } 
    PopRankingListView popRankingListView = this.cY;
    if (popRankingListView != null && popRankingListView.a())
      this.cY.c(); 
  }
  
  public void az() {
    List<LiveGiftModel> list = this.cG.i();
    if (list.size() > 0) {
      this.O = true;
      d(list.get(0));
    } 
  }
  
  public void b(int paramInt) {}
  
  public void b(long paramLong) {}
  
  public void b(ChattingModel paramChattingModel) {}
  
  public void b(KeyboardListenLinearLayout paramKeyboardListenLinearLayout) {
    a(paramKeyboardListenLinearLayout);
  }
  
  public void b(LiveFriendModel paramLiveFriendModel) {
    b_(1);
    RecordingOnliveManager recordingOnliveManager2 = this.S;
    if (recordingOnliveManager2 != null)
      recordingOnliveManager2.d(); 
    int i = this.cc;
    i = AppInfo.l / 2;
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
    layoutParams.setMargins(0, DensityUtils.a(this.y, ''), 0, 0);
    this.bs.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = (FrameLayout.LayoutParams)this.bt.getLayoutParams();
    layoutParams.width = -1;
    int j = i / 3 * 4;
    layoutParams.height = j;
    this.bt.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = new FrameLayout.LayoutParams(i, j);
    this.C.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    layoutParams = new FrameLayout.LayoutParams(i, j);
    layoutParams.gravity = 5;
    this.bE.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    l(1);
    layoutParams = (FrameLayout.LayoutParams)this.bw.getLayoutParams();
    layoutParams.topMargin = DensityUtils.a(this.y, 170.0F) + j - DensityUtils.a(this.y, 25.0F);
    this.bw.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.bu.setVisibility(0);
    this.bu.b();
    if (paramLiveFriendModel != null)
      this.bv.a(paramLiveFriendModel.lid); 
    this.bv.setVisibility(0);
    RecordingOnliveManager recordingOnliveManager1 = this.S;
    if (recordingOnliveManager1 != null)
      recordingOnliveManager1.k(); 
    this.bD.setVisibility(0);
    this.bD.a(paramLiveFriendModel);
    bu();
    aY();
    this.bE.setVisibility(0);
    j("");
    this.aL.setVisibility(8);
    this.br.h();
    Y();
  }
  
  public void b(LiveGiftModel paramLiveGiftModel) {}
  
  public void b(LiveRecordLevelStickerModel paramLiveRecordLevelStickerModel) {
    LiveRecordStickerViewLayout liveRecordStickerViewLayout = this.cs;
    if (liveRecordStickerViewLayout != null)
      liveRecordStickerViewLayout.a(paramLiveRecordLevelStickerModel); 
  }
  
  public void b(String paramString) {
    LiveCueView.a(this.y, paramString);
  }
  
  public void b(String paramString, int paramInt) {
    if (this.cw != null && !TextUtils.isEmpty(paramString)) {
      LiveSetDataObserver.a().s();
      this.cw.b(paramString, paramInt);
    } 
  }
  
  public void b(boolean paramBoolean) {}
  
  public void b_(String paramString) {}
  
  public void b_(List<LiveFriendModel> paramList) {
    this.cO.a(paramList);
  }
  
  public void ba() {
    LiveRoomHttpUtils.f(new BluedUIHttpResponse<BluedEntityA<BluedLiveTopCard>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<BluedLiveTopCard> param1BluedEntityA) {
            Logger.d("RecordingOnliveFragment", new Object[] { "onUIUpdate is token ... " });
            if (param1BluedEntityA != null && param1BluedEntityA.data != null) {
              if (param1BluedEntityA.data.isEmpty())
                return; 
              BluedLiveTopCard bluedLiveTopCard = param1BluedEntityA.data.get(0);
              if (bluedLiveTopCard.token_status == 0)
                RecordingOnliveFragment.a(this.a, bluedLiveTopCard.count, bluedLiveTopCard.task_id); 
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            Logger.d("RecordingOnliveFragment", new Object[] { "onUIFailure is token ... " });
            return super.onUIFailure(param1Int, param1String);
          }
        }(IRequestHost)w_());
  }
  
  public void bb() {
    FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
    LiveMusicFragment liveMusicFragment = this.da;
    if (liveMusicFragment == null) {
      this.da = new LiveMusicFragment();
      fragmentTransaction.add(R.id.live_music_container_layout_id, (Fragment)this.da, "LiveMusic");
      fragmentTransaction.commitNowAllowingStateLoss();
      return;
    } 
    if (liveMusicFragment.isHidden()) {
      this.da.H();
      fragmentTransaction.show((Fragment)this.da);
      fragmentTransaction.commitNowAllowingStateLoss();
    } 
  }
  
  public void bc() {
    if (this.da != null && !isHidden()) {
      this.da.H();
      getChildFragmentManager().beginTransaction().hide((Fragment)this.da).commitNowAllowingStateLoss();
    } 
    C();
  }
  
  public void bd() {
    this.cu.setPlaying(true);
    ZegoCommonHelper.b().j();
  }
  
  public void be() {
    this.cu.setPlaying(false);
    ZegoCommonHelper.b().k();
  }
  
  public void bf() {
    this.cu.a();
    ZegoCommonHelper.b().h();
    bc();
  }
  
  public void bg() {
    this.cu.b();
  }
  
  public void bh() {
    LiveRecordRecommendModel liveRecordRecommendModel = (LiveRoomManager.a().h()).recommend;
    if (liveRecordRecommendModel != null && liveRecordRecommendModel.icon_show) {
      LiveOfficalRecommendPop.a(this.y, 0);
      this.cU.setVisibility(0);
      if (liveRecordRecommendModel.timeout) {
        this.cV.setVisibility(0);
        this.dd = liveRecordRecommendModel.end_time;
        this.cV.setText(LiveTimeAndDateUtils.a(liveRecordRecommendModel.end_time, false));
        this.cV.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener(this) {
              public void onChronometerTick(Chronometer param1Chronometer) {
                if (RecordingOnliveFragment.h(this.a) == 30L) {
                  RecordingOnliveFragment recordingOnliveFragment = this.a;
                  recordingOnliveFragment.cH = LiveOfficalRecommendPop.a(recordingOnliveFragment.y, 1);
                } 
                if (RecordingOnliveFragment.h(this.a) >= 0L) {
                  param1Chronometer.setText(LiveTimeAndDateUtils.a(RecordingOnliveFragment.h(this.a), false));
                } else {
                  RecordingOnliveFragment.i(this.a).stop();
                  RecordingOnliveFragment.j(this.a).setVisibility(8);
                  if (this.a.cH != null && this.a.cH.r())
                    this.a.cH.p(); 
                } 
                RecordingOnliveFragment.k(this.a);
              }
            });
        this.cV.start();
        return;
      } 
      this.cV.setVisibility(8);
      return;
    } 
    this.cU.setVisibility(8);
  }
  
  public void bi() {
    LogUtils.c(LiveRoomInfo.a().d());
    ImageFileLoader.a((IRequestHost)w_()).b(LiveRoomInfo.a().d()).a(new ImageFileLoader.OnLoadFileListener(this) {
          public void onUIFinish(File param1File, Exception param1Exception) {
            if (param1File != null && param1File.exists()) {
              Bitmap bitmap = BitmapFactory.decodeFile(param1File.getPath());
            } else {
              param1File = null;
            } 
            LiveRoomInfo.a().a((Bitmap)param1File, this.a.u, this.a.y, this.a.B);
          }
        }).a();
  }
  
  public void c(int paramInt) {}
  
  public void c(long paramLong) {
    PKDoubleAnimView pKDoubleAnimView = this.cN;
    if (pKDoubleAnimView == null)
      return; 
    if (paramLong <= 0L) {
      pKDoubleAnimView.a();
      return;
    } 
    pKDoubleAnimView.a(w_(), paramLong);
  }
  
  public void c(ChattingModel paramChattingModel) {}
  
  public void c(LiveFriendModel paramLiveFriendModel) {
    this.cO.a(paramLiveFriendModel);
  }
  
  public void c(LiveGiftModel paramLiveGiftModel) {
    a(new -$$Lambda$RecordingOnliveFragment$YsbR8WgSvrbGMipceaRJqhsDVqA(this, paramLiveGiftModel));
  }
  
  public void c(String paramString) {
    this.aZ.a(paramString);
  }
  
  public void c(String paramString, int paramInt) {
    if (!B())
      return; 
    this.bQ.setVisibility(0);
    this.bQ.setImageResource(paramInt);
  }
  
  public void c(List<LiveZanExtraModel.HotWords> paramList) {}
  
  public void c(boolean paramBoolean) {}
  
  public void d(int paramInt) {}
  
  public void d(long paramLong) {
    LiveMusicFragment liveMusicFragment = this.da;
    if (liveMusicFragment != null)
      liveMusicFragment.a(paramLong); 
  }
  
  public void d(LiveGiftModel paramLiveGiftModel) {
    Logger.a("drb", new Object[] { "gift_pic_apng2 = ", paramLiveGiftModel.images_apng2 });
    Logger.a("drb", new Object[] { "gift_pic_url = ", paramLiveGiftModel.images_static });
    Logger.a("drb", new Object[] { "anim_code = ", paramLiveGiftModel.anim_code });
    Logger.a("drb", new Object[] { "gift_pic_gif = ", paramLiveGiftModel.images_gif });
    Logger.a("drb", new Object[] { "gift_pic_mp4 = ", paramLiveGiftModel.images_mp4 });
    LiveAnimationViewFactory.ScaleType scaleType = LiveAnimationViewFactory.ScaleType.a;
    if (this.be) {
      scaleType = LiveAnimationViewFactory.ScaleType.b;
    } else if (LiveRoomInfo.a().w()) {
      scaleType = LiveAnimationViewFactory.ScaleType.a;
    } else {
      scaleType = LiveAnimationViewFactory.ScaleType.c;
    } 
    this.bi.a((IRequestHost)w_(), paramLiveGiftModel.images_gif, paramLiveGiftModel.images_apng2, paramLiveGiftModel.images_mp4, paramLiveGiftModel.anim_code, scaleType, (LiveAnimationListener)new AnimationListenerAdapter(this, paramLiveGiftModel) {
          public void b() {
            this.b.e(this.a);
          }
        });
  }
  
  public void d(String paramString, int paramInt) {
    if (!B())
      return; 
    this.bR.setVisibility(0);
    this.bR.setImageResource(paramInt);
  }
  
  public void d(List<LiveMakeLoverFansModel> paramList) {
    this.bb.b(paramList);
  }
  
  public void d(boolean paramBoolean) {
    J_();
    if (paramBoolean) {
      View view = this.cX;
      if (view != null)
        view.setVisibility(8); 
      this.cm.setVisibility(8);
      aW();
    } else {
      b_(0);
      this.cm.setVisibility(0);
    } 
    RecordingOnliveManager recordingOnliveManager = this.S;
    if (recordingOnliveManager != null)
      recordingOnliveManager.a((LiveRoomManager.a().h()).stream, paramBoolean); 
    if (this.be) {
      this.f.setShakeWidth(DensityUtils.a(this.y, 50.0F));
    } else {
      this.f.setShakeWidth(DensityUtils.a(this.y, 65.0F));
    } 
    this.bl.setVisibility(0);
    a(new Runnable(this, paramBoolean) {
          public void run() {
            if (LiveRoomManager.a().h() == null)
              return; 
            this.b.M_();
            this.b.af();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setLiveData :");
            stringBuilder.append((LiveRoomManager.a().h()).beans_count);
            Log.v("beans", stringBuilder.toString());
            this.b.a((LiveRoomManager.a().h()).beans_count, (LiveRoomManager.a().h()).beans_current_count);
            this.b.ak.a(LiveRoomInfo.a().f(), LiveRoomInfo.a().f(), (BaseFragment)this.b);
            this.b.a((LiveRoomManager.a().h()).badges);
            if (this.b.V != 0L) {
              RecordingOnliveFragment recordingOnliveFragment1 = this.b;
              recordingOnliveFragment1.a(recordingOnliveFragment1.V);
              this.b.J_();
            } else {
              this.b.W.setText("00:00:00");
            } 
            this.b.Z();
            if (!this.a)
              RecordingOnliveFragment.b(this.b); 
            if (!this.b.be) {
              this.b.cr.setVisibility(0);
              ImageLoader.c((IRequestHost)this.b.w_(), "live_liang_enter_anim.png").d((int)this.b.u).e(-1).a(this.b.cr);
            } else {
              this.b.cr.setVisibility(8);
            } 
            this.b.G_();
            RecordingOnliveFragment.c(this.b);
            RecordingOnliveFragment recordingOnliveFragment = this.b;
            recordingOnliveFragment.cf = new LiveMakeFriendSettingView((BaseFragment)recordingOnliveFragment, recordingOnliveFragment.u);
            this.b.cf.a(2);
            this.b.ad();
            this.b.cG.n();
            RecordingOnliveFragment.d(this.b).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
                  public void onGlobalLayout() {
                    int i = RecordingOnliveFragment.d(this.a.b).getHeight();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("height = ");
                    stringBuilder.append(i);
                    Log.v("pk", stringBuilder.toString());
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.a.b.ct.getLayoutParams();
                    layoutParams.height = i + DensityUtils.a(this.a.b.y, 55.0F);
                    this.a.b.ct.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                    RecordingOnliveFragment.d(this.a.b).getViewTreeObserver().removeOnGlobalLayoutListener(this);
                  }
                });
            this.b.bh();
          }
        }1000L);
  }
  
  public void e(int paramInt) {}
  
  public void e(LiveGiftModel paramLiveGiftModel) {
    a(new Runnable(this, paramLiveGiftModel) {
          public void run() {
            RecordingOnliveFragment recordingOnliveFragment = this.b;
            recordingOnliveFragment.O = false;
            recordingOnliveFragment.cG.b(this.a);
            this.b.az();
          }
        });
  }
  
  public void e(String paramString) {}
  
  public void e(boolean paramBoolean) {
    if (paramBoolean)
      LiveRoomPreferences.e(1); 
    this.cn.setVisibility(8);
  }
  
  public void e_(int paramInt) {
    if (paramInt != -3) {
      if (paramInt == -2) {
        this.cy = false;
        PopRewardConfigView popRewardConfigView = this.db;
        if (popRewardConfigView != null)
          popRewardConfigView.k(); 
      } 
    } else {
      this.cy = true;
      PopRewardConfigView popRewardConfigView = this.db;
      if (popRewardConfigView != null)
        popRewardConfigView.j(); 
    } 
    this.ce.a(paramInt);
    this.cj.a(paramInt);
  }
  
  public void f(int paramInt) {}
  
  public void f(String paramString) {}
  
  public boolean f(boolean paramBoolean) {
    if (B()) {
      AppMethods.d(R.string.live_pk_unavailable);
      return false;
    } 
    if (aN() || aO() || this.br.i()) {
      AppMethods.d(R.string.connecting);
      return false;
    } 
    if (aP()) {
      AppMethods.d(R.string.live_make_friend_unavailable);
      return false;
    } 
    if (aQ()) {
      AppMethods.d(R.string.live_make_lover_unavailable);
      return false;
    } 
    return true;
  }
  
  public void g(int paramInt) {
    this.Z.setVisibility(paramInt);
  }
  
  public void g(String paramString) {
    LiveActivityWebDialogFragment liveActivityWebDialogFragment = this.dg;
    if (liveActivityWebDialogFragment != null && liveActivityWebDialogFragment.isVisible())
      return; 
    this.dg = new LiveActivityWebDialogFragment();
    Bundle bundle = new Bundle();
    bundle.putString("url", paramString);
    this.dg.setArguments(bundle);
    this.dg.show(getFragmentManager(), "liveActivityWebDialogFragment");
  }
  
  public void g(boolean paramBoolean) {
    String str;
    if (paramBoolean) {
      str = this.y.getString(R.string.live_make_friend_out_exit_tips);
    } else {
      str = this.y.getString(R.string.live_make_friend_out_tips);
    } 
    Context context = this.y;
    CommonAlertDialog.a(context, "", str, context.getString(R.string.filter_off), new DialogInterface.OnClickListener(this, paramBoolean) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (RecordingOnliveFragment.e(this.b) != null)
              RecordingOnliveFragment.e(this.b).a(this.a); 
          }
        }null, null, null);
  }
  
  public void h(int paramInt) {
    this.e.findViewById(R.id.gift_lay).setVisibility(paramInt);
    this.e.findViewById(R.id.multi_barrage).setVisibility(paramInt);
  }
  
  public void h(String paramString) {
    this.bU.a(paramString);
  }
  
  public void h(boolean paramBoolean) {
    this.bf = true;
    AppInfo.n().post(new Runnable(this, paramBoolean) {
          public void run() {
            if (this.b.w_() != null) {
              if (!this.b.w_().isActive())
                return; 
              this.b.aK();
              if (this.b.ce.getVisibility() == 0)
                return; 
              if (this.b.bd != null)
                this.b.bd.c(); 
              if (this.a) {
                LiveRouteUtil.c((BaseFragment)this.b);
                return;
              } 
              this.b.ai.setVisibility(8);
              RecordingOnliveFragment.f(this.b);
            } 
          }
        });
  }
  
  public void i(int paramInt) {
    if (paramInt < 30)
      return; 
    if (paramInt >= 90) {
      this.cS.setImageResource(R.drawable.live_anchor_head_bg_90);
    } else if (paramInt >= 60) {
      this.cS.setImageResource(R.drawable.live_anchor_head_bg_60);
    } else if (paramInt >= 30) {
      this.cS.setImageResource(R.drawable.live_anchor_head_bg_30);
    } 
    this.cS.setVisibility(0);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.cR.getLayoutParams();
    layoutParams.leftMargin = DensityUtils.a(this.y, 6.0F);
    this.cR.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void i(String paramString) {
    LiveRoomHttpUtils.c(paramString, new BluedUIHttpResponse(this, (IRequestHost)w_()) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        });
  }
  
  public void i(boolean paramBoolean) {
    this.T.a(paramBoolean);
  }
  
  public void j(int paramInt) {
    a(new Runnable(this, paramInt) {
          public void run() {
            if (this.a == 0)
              this.b.cA = System.currentTimeMillis(); 
            if (this.a == 8) {
              long l1 = System.currentTimeMillis();
              long l2 = this.b.cA;
              if (this.b.S != null)
                this.b.S.b((l1 - l2) / 1000L); 
            } 
            this.b.X.setVisibility(this.a);
          }
        });
  }
  
  public void j(String paramString) {
    this.at.setVisibility(0);
    this.aF.setVisibility(0);
    if (!TextUtils.isEmpty(paramString)) {
      this.aN.setText(paramString);
      return;
    } 
    this.aN.setText("");
  }
  
  public boolean j() {
    return false;
  }
  
  public void k(int paramInt) {
    this.ck.setFlashLightVisibility(paramInt);
  }
  
  public void k(String paramString) {
    LiveRoomHttpUtils.f(paramString, new BluedUIHttpResponse<BluedEntityA<BluedLiveTopCard>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<BluedLiveTopCard> param1BluedEntityA) {
            if (this.a.z != null)
              this.a.z.dismiss(); 
            ToastUtils.a(this.a.y.getResources().getString(R.string.live_take_topcard_ok), 0);
            if (this.a.ck != null && param1BluedEntityA != null && param1BluedEntityA.data != null && !param1BluedEntityA.data.isEmpty())
              this.a.ck.a(((BluedLiveTopCard)param1BluedEntityA.data.get(0)).count); 
            RecordingOnliveFragment.g(this.a);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (this.a.z != null)
              this.a.z.dismiss(); 
            return super.onUIFailure(param1Int, param1String);
          }
        }(IRequestHost)w_());
  }
  
  public void l(int paramInt) {
    a(new Runnable(this, paramInt) {
          public void run() {
            int j = DensityUtils.a(this.b.getContext(), 55.0F);
            int i = j;
            if (this.b.q.getVisibility() == 0) {
              Logger.d("RecordingOnliveFragment", new Object[] { "上麦管理 " });
              i = j + DensityUtils.a(this.b.getContext(), 45.0F);
            } 
            j = this.a;
            if (j != 2 && j != 3) {
              RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
              layoutParams.addRule(12);
              layoutParams.addRule(11);
              layoutParams.rightMargin = DensityUtils.a(this.b.y, 10.0F);
              layoutParams.topMargin = 0;
              layoutParams.bottomMargin = i;
              this.b.Q.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
              Logger.d("RecordingOnliveFragment", new Object[] { "活动icon " });
            } 
            this.b.bd.a(this.a);
          }
        }300L);
  }
  
  public void m(int paramInt) {
    this.cO.a(paramInt);
  }
  
  public void n(int paramInt) {
    this.ba.a(paramInt);
  }
  
  public void o() {}
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    this.ce.a(paramInt1, paramInt2, paramIntent);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 100014)
      J(); 
  }
  
  public void onChronometerTick(Chronometer paramChronometer) {
    this.V++;
    paramChronometer.setText(LiveTimeAndDateUtils.a(this.V, true));
  }
  
  public void onClick(View paramView) {
    if (ClickUtils.a(paramView.getId(), 1000L))
      return; 
    if (paramView.getId() == R.id.live_like_view) {
      if (f(false)) {
        if (!this.be) {
          this.br.a(true);
          bq();
          return;
        } 
        AppMethods.d(R.string.no_landscape_mode);
        return;
      } 
    } else {
      Bundle bundle;
      RecordingOnliveManager recordingOnliveManager;
      if (paramView.getId() == R.id.rank_showing || paramView.getId() == R.id.live_rank_btn) {
        EventTrackLive.a(LiveProtos.Event.LIVE_WANDOU_NUM_CLICK, String.valueOf(this.u), LiveRoomInfo.a().f());
        bundle = new Bundle();
        bundle.putLong(LiveRankGuestDialogFragment.a, this.u);
        bundle.putString("UID", LiveRoomInfo.a().f());
        bundle.putBoolean(LiveRankGuestDialogFragment.d, true);
        bundle.putBoolean("isMakeLover", aQ());
        this.am = new LiveRankGuestDialogFragment();
        this.am.a(this);
        this.am.setArguments(bundle);
        this.am.show(getFragmentManager(), "liveShowDialog");
        return;
      } 
      if (bundle.getId() == R.id.close_btn) {
        if (B()) {
          this.bD.a(true);
          return;
        } 
        if (aP()) {
          g(true);
          return;
        } 
        LiveRouteUtil.b((BaseFragment)this);
        return;
      } 
      if (bundle.getId() == R.id.error_tips_btn) {
        this.Y.setVisibility(8);
        return;
      } 
      if (bundle.getId() == R.id.out_userA_btn) {
        recordingOnliveManager = this.S;
        if (recordingOnliveManager != null) {
          recordingOnliveManager.b(R.id.RemoteGLSurfaceViewA);
          return;
        } 
      } else {
        LogData logData;
        LiveMakeFriendSettingView liveMakeFriendSettingView;
        if (recordingOnliveManager.getId() == R.id.out_userB_btn) {
          aj();
          return;
        } 
        if (recordingOnliveManager.getId() == R.id.live_reward_view) {
          this.db = PopRewardConfigView.a((BaseFragment)this);
          return;
        } 
        if (recordingOnliveManager.getId() == R.id.switch_vertical_view) {
          getActivity().setRequestedOrientation(1);
          logData = new LogData();
          logData.D = "live_change_to_vertical";
          logData.n = String.valueOf(this.u);
          logData.k = String.valueOf(1);
          InstantLog.a(logData);
          return;
        } 
        if (logData.getId() == R.id.switch_horizontal_view) {
          getActivity().setRequestedOrientation(0);
          logData = new LogData();
          logData.D = "live_change_to_horizontal";
          logData.n = String.valueOf(this.u);
          logData.k = String.valueOf(1);
          InstantLog.a(logData);
          return;
        } 
        if (logData.getId() == R.id.live_pk_operate_close) {
          this.bw.setVisibility(8);
          return;
        } 
        if (logData.getId() == R.id.live_make_friends_close_btn) {
          g(false);
          return;
        } 
        if (logData.getId() == R.id.cameraPreview_afl) {
          if (aP() && this.T.a()) {
            liveMakeFriendSettingView = this.cf;
            if (liveMakeFriendSettingView != null) {
              liveMakeFriendSettingView.e();
              return;
            } 
          } 
        } else {
          ShapeTextView shapeTextView;
          if (liveMakeFriendSettingView.getId() == R.id.live_make_friend_windows_B) {
            m(0);
            return;
          } 
          if (liveMakeFriendSettingView.getId() == R.id.live_make_friend_windows_C) {
            m(1);
            return;
          } 
          if (liveMakeFriendSettingView.getId() == R.id.live_make_friend_windows_D) {
            m(2);
            return;
          } 
          if (liveMakeFriendSettingView.getId() == R.id.live_multi_function_btn) {
            EventTrackLive.a(LiveProtos.Event.ANCHOR_FEATURE_CLICK, String.valueOf(this.u));
            if (LiveRoomManager.a().B()) {
              AppMethods.d(R.string.no_landscape_mode);
              return;
            } 
            if (this.q != null && this.q.c)
              this.q.setVisibility(8); 
            this.ck.c();
            shapeTextView = this.cm;
            if (shapeTextView != null) {
              shapeTextView.setVisibility(8);
              return;
            } 
          } else {
            Bundle bundle1;
            if (shapeTextView.getId() == R.id.live_pk_tips_btn) {
              e(true);
              return;
            } 
            if (shapeTextView.getId() == R.id.live_record_relevel_view) {
              (new PopRecordLevelView(this)).a();
              return;
            } 
            if (shapeTextView.getId() == R.id.lucky_turning) {
              if (LiveRoomInfo.a().j()) {
                b("https://activity.blued.cn/hd/2020/lucky-turning?blued_mode=hide_nav", 0);
                return;
              } 
              b("https://activity-test.blued.cn/hd/2020/lucky-turning?blued_mode=hide_nav", 0);
              return;
            } 
            if (shapeTextView.getId() == R.id.live_fans_btn) {
              ag();
              return;
            } 
            if (shapeTextView.getId() == R.id.music_float_view) {
              bb();
              return;
            } 
            if (shapeTextView.getId() == R.id.liang_enter_view) {
              EventTrackLive.a(LiveProtos.Event.BETTER_ID_ANCHOR_POP_BATTER_CLICK);
              LiveLiangWebDialogFragment liveLiangWebDialogFragment = this.de;
              if (liveLiangWebDialogFragment != null && liveLiangWebDialogFragment.isVisible())
                return; 
              this.de = new LiveLiangWebDialogFragment();
              bundle1 = new Bundle();
              bundle1.putInt("flag", 1);
              this.de.setArguments(bundle1);
              this.de.show(getFragmentManager(), "webLiangDialog");
              return;
            } 
            if (bundle1.getId() == R.id.ll_liang) {
              EventTrackLive.a(LiveProtos.Event.BETTER_ID_ANCHOR_PHOTO_BATTER_CLICK);
              LiveLiangWebDialogFragment liveLiangWebDialogFragment = this.de;
              if (liveLiangWebDialogFragment != null && liveLiangWebDialogFragment.isVisible())
                return; 
              this.de = new LiveLiangWebDialogFragment();
              Bundle bundle2 = new Bundle();
              bundle2.putInt("flag", 1);
              this.de.setArguments(bundle2);
              this.de.show(getFragmentManager(), "webLiangDialog");
              return;
            } 
          } 
        } 
      } 
    } 
  }
  
  public void onClose(LiveCloseReason paramLiveCloseReason, LiveChatStatistics paramLiveChatStatistics) {
    a(new -$$Lambda$RecordingOnliveFragment$c3XsmJ_YXyOjDS3lrjDhVEQiADw(this, paramLiveCloseReason, paramLiveChatStatistics));
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    int i = paramConfiguration.orientation;
    if (i != 1) {
      if (i == 2) {
        Logger.a("drb", new Object[] { "切换为横屏" });
        this.be = true;
        this.bm.a();
      } 
    } else {
      Logger.a("drb", new Object[] { "切换为竖屏" });
      this.be = false;
      this.bm.b();
    } 
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle) {
    this.bg = true;
    this.v = true;
    LiveRoomManager.a().b(true);
    getActivity().getWindow().setSoftInputMode(16);
    super.onCreate(paramBundle);
  }
  
  public void onDestroy() {
    super.onDestroy();
    LiveRoomManager.a().b(false);
    InstantLog.a(LiveRoomPreferences.m(), LiveRoomPreferences.n(), LiveRoomPreferences.o());
    RecordingOnliveManager recordingOnliveManager = this.S;
    if (recordingOnliveManager != null) {
      recordingOnliveManager.t();
      this.S.r();
    } 
    RecordingPlayerManager recordingPlayerManager = this.cz;
    if (recordingPlayerManager != null)
      recordingPlayerManager.c(); 
    ae();
    this.cG.b();
    ar();
    this.ce.b();
    ZanRefreshObserver.a().b(this);
    PlayGifObserver.a().b(this);
    BeansRefreshObserver.a().b(this);
    PlayARObserver.a().b(this);
    LiveSetDataObserver.a().b(this);
    if (LiveRoomManager.a().b() == this.u)
      LiveRoomManager.a().g(); 
    CountDownTimer countDownTimer = this.dh;
    if (countDownTimer != null)
      countDownTimer.cancel(); 
    LiveMultiFunctionView liveMultiFunctionView = this.ck;
    if (liveMultiFunctionView != null)
      liveMultiFunctionView.g(); 
    LiveRecordLevelView liveRecordLevelView = this.cT;
    if (liveRecordLevelView != null)
      liveRecordLevelView.c(); 
    LiveLiangWebDialogFragment liveLiangWebDialogFragment = this.de;
    if (liveLiangWebDialogFragment != null) {
      Dialog dialog = liveLiangWebDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.de.dismiss(); 
    } 
    LiveActivityWebDialogFragment liveActivityWebDialogFragment = this.dg;
    if (liveActivityWebDialogFragment != null) {
      Dialog dialog = liveActivityWebDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.dg.dismiss(); 
    } 
  }
  
  public void onPause() {
    super.onPause();
    RecordingOnliveManager recordingOnliveManager = this.S;
    if (recordingOnliveManager != null)
      recordingOnliveManager.q(); 
    RecordingPlayerManager recordingPlayerManager = this.cz;
    if (recordingPlayerManager != null)
      recordingPlayerManager.b(); 
    LiveRankGuestDialogFragment liveRankGuestDialogFragment = this.am;
    if (liveRankGuestDialogFragment != null) {
      Dialog dialog = liveRankGuestDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.am.dismiss(); 
    } 
    LiveFansRecordDialogFragment liveFansRecordDialogFragment = this.an;
    if (liveFansRecordDialogFragment != null) {
      Dialog dialog = liveFansRecordDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.an.dismiss(); 
    } 
    LiveMakeLoverDialogFragment liveMakeLoverDialogFragment = this.bc;
    if (liveMakeLoverDialogFragment != null) {
      Dialog dialog = liveMakeLoverDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.bc.dismiss(); 
    } 
    if (this.r != null) {
      Dialog dialog = this.r.getDialog();
      if (dialog != null && dialog.isShowing())
        this.r.dismiss(); 
    } 
    LiveRegularEventRanklistDialogFragment liveRegularEventRanklistDialogFragment = this.ao;
    if (liveRegularEventRanklistDialogFragment != null) {
      Dialog dialog = liveRegularEventRanklistDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.ao.dismiss(); 
    } 
    LiveManagerDialogFragment liveManagerDialogFragment = this.ap;
    if (liveManagerDialogFragment != null) {
      Dialog dialog = liveManagerDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.ap.dismiss(); 
    } 
    this.bg = false;
  }
  
  public void onRecvNewMsg(ChattingModel paramChattingModel) {
    LiveEventBusUtil.a(paramChattingModel, false);
  }
  
  public void onResume() {
    super.onResume();
    Configuration configuration = getActivity().getResources().getConfiguration();
    if (this.bf && configuration != null && configuration.orientation == 2)
      getActivity().setRequestedOrientation(1); 
    RecordingOnliveManager recordingOnliveManager = this.S;
    if (recordingOnliveManager != null)
      recordingOnliveManager.p(); 
    RecordingPlayerManager recordingPlayerManager = this.cz;
    if (recordingPlayerManager != null)
      recordingPlayerManager.a(); 
    LiveMsgManager liveMsgManager = this.cG;
    if (liveMsgManager != null)
      liveMsgManager.c(0); 
    if (this.aj != null)
      EventTrackLive.a(LiveProtos.Event.LIVE_FILTER_USE, this.aj.e(), LiveProtos.Status.START); 
    this.ce.a();
    this.P = false;
    this.bg = true;
    aq();
    PopLiveActivityWebView popLiveActivityWebView = this.cw;
    if (popLiveActivityWebView != null)
      popLiveActivityWebView.c(); 
  }
  
  public void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("unexpectedly_exit", true);
  }
  
  public void onStart() {
    super.onStart();
    RecordingOnliveManager recordingOnliveManager = this.S;
    if (recordingOnliveManager != null) {
      recordingOnliveManager.t();
      this.S.n();
    } 
  }
  
  public void onStop() {
    super.onStop();
    if (this.S != null) {
      if (this.ce.getVisibility() != 0)
        this.S.a(15000L); 
      this.S.o();
    } 
    if (!aQ()) {
      RecordingOnliveManager recordingOnliveManager = this.S;
      if (recordingOnliveManager != null) {
        recordingOnliveManager.h();
        if (aN() || aO())
          this.S.i(); 
      } 
      this.cO.b();
      LiveConnectionView liveConnectionView = this.br;
      if (liveConnectionView != null)
        liveConnectionView.k(); 
      LivePKCountDownView livePKCountDownView = this.bD;
      if (livePKCountDownView != null)
        livePKCountDownView.f(); 
    } 
    PopBeautyNewView popBeautyNewView = this.aj;
    if (popBeautyNewView != null && !popBeautyNewView.d())
      EventTrackLive.a(LiveProtos.Event.LIVE_FILTER_USE, this.aj.e(), LiveProtos.Status.END); 
    Log.v("pk", "isPlayAR onStop false ------- ");
    this.P = false;
    this.bg = false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    this.cD.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void p() {}
  
  public void r() {}
  
  public void s() {}
  
  public void switchCamera(View paramView) {
    if (LiveRoomManager.a().B())
      AppMethods.d(R.string.live_game_tips); 
    if (this.S != null && !ClickUtils.a(paramView.getId(), 1500L))
      this.S.v(); 
  }
  
  protected int t() {
    return R.layout.fragment_recording_onlive;
  }
  
  protected void v() {
    super.v();
    boolean bool = false;
    LiveRankGuestDialogFragment.e = 0;
    this.ca = this.s.getInt("official", 0);
    LiveRoomManager.a().a(this.s.getInt("live_type", 0));
    this.cb = this.s.getInt("live_countdown", 0);
    if (this.s.getInt("live_screen_orientation", 0) == 1)
      bool = true; 
    this.be = bool;
    this.cd = this.s.getString("live_from_source");
  }
  
  protected void w() {
    super.w();
    ZanRefreshObserver.a().a(this);
    PlayGifObserver.a().a(this);
    PlayARObserver.a().a(this);
    BeansRefreshObserver.a().a(this);
    LiveSetDataObserver.a().a(this);
    bj();
  }
  
  public void x() {}
  
  public void y() {
    this.cO.a();
  }
  
  public void y_() {
    bn();
  }
  
  public void z_() {
    bo();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\RecordingOnliveFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */