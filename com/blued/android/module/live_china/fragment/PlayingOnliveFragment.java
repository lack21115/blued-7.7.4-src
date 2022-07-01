package com.blued.android.module.live_china.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.chat.data.LiveChatStatistics;
import com.blued.android.chat.data.LiveCloseReason;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.QueueFileDownloader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.utils.AssetsUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live.base.view.animation.AnimationListenerAdapter;
import com.blued.android.module.live.base.view.animation.LiveAnimationListener;
import com.blued.android.module.live.base.view.animation.LiveAnimationView;
import com.blued.android.module.live.base.view.animation.LiveAnimationViewFactory;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveModePagerAdapter;
import com.blued.android.module.live_china.constant.LiveRoomConstants;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.live_interface.IScreenManager;
import com.blued.android.module.live_china.manager.LiveDataListManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveGiftManager;
import com.blued.android.module.live_china.manager.LiveGuideManager;
import com.blued.android.module.live_china.manager.LiveMakeLoverManager;
import com.blued.android.module.live_china.manager.LivePlayExitTipManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.manager.PlayingMakeFriendManager;
import com.blued.android.module.live_china.manager.PlayingMakeLoverManager;
import com.blued.android.module.live_china.manager.PlayingOnlineManager;
import com.blued.android.module.live_china.manager.PlayingRTCManager;
import com.blued.android.module.live_china.manager.PlayingScreenManager;
import com.blued.android.module.live_china.mine.LiveGiftFragment;
import com.blued.android.module.live_china.mine.LiveRouteUtil;
import com.blued.android.module.live_china.model.GrabBoxModel;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.model.LiveOneKissModel;
import com.blued.android.module.live_china.model.LivePKProgressModel;
import com.blued.android.module.live_china.model.LivePkBannerModel;
import com.blued.android.module.live_china.model.LiveRoomCloseReason;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveListPositionObserver;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.observer.ZanRefreshObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.same.loadingIndicator.AVLoadingIndicatorView;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.same.tip.model.DialogWith6PW;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.android.module.live_china.utils.LivePreferencesUtils;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BarrageViewMultiOneRow;
import com.blued.android.module.live_china.view.GrabBoxNumView;
import com.blued.android.module.live_china.view.LiveAnchorTaskView;
import com.blued.android.module.live_china.view.LiveDragViewLayout;
import com.blued.android.module.live_china.view.LiveMakeFriendListView;
import com.blued.android.module.live_china.view.LiveMakeFriendManageView;
import com.blued.android.module.live_china.view.LiveMakeFriendSettingView;
import com.blued.android.module.live_china.view.LiveMakeLoverManageGuestView;
import com.blued.android.module.live_china.view.LiveMakeLoverRootGuestView;
import com.blued.android.module.live_china.view.LivePKBubbleLayout;
import com.blued.android.module.live_china.view.LivePKCountDownView;
import com.blued.android.module.live_china.view.LivePKProgressView;
import com.blued.android.module.live_china.view.LivePKResult;
import com.blued.android.module.live_china.view.LivePKUserBanner;
import com.blued.android.module.live_china.view.PKDoubleAnimView;
import com.blued.android.module.live_china.view.PopLiveActivityWebView;
import com.blued.android.module.live_china.view.PopLiveCallView;
import com.blued.android.module.live_china.view.PopPKListView;
import com.blued.android.module.live_china.view.PopPlayExitView;
import com.blued.android.module.live_china.view.PopRankingListView;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlayingOnliveFragment extends LiveBaseFragment implements View.OnClickListener, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone, LiveFansGuestDialogFragment.ILiveFansGuestDialog, LiveRankGuestDialogFragment.ILiveGuestDialog, LiveRefreshUIObserver.ILiveRefreshUIObserver, ZanRefreshObserver.IZanRefreshObserver {
  public static boolean T;
  
  public static int co;
  
  public ImageView A;
  
  public ImageView B;
  
  public GrabBoxNumView C;
  
  public long D = 0L;
  
  public PlayingOnlineManager E;
  
  public PlayingRTCManager F;
  
  public String G;
  
  public FrameLayout H;
  
  public LiveAnimationView I;
  
  public KeyboardListenLinearLayout J;
  
  public View K;
  
  public TextView L;
  
  public String M;
  
  public String[] N;
  
  public String[] O;
  
  public String P;
  
  public boolean Q;
  
  public int R;
  
  public boolean S;
  
  public boolean U;
  
  public LiveRankGuestDialogFragment V;
  
  public LiveRegularEventRanklistDialogFragment W;
  
  public LiveFansGuestDialogFragment X;
  
  public Dialog Y;
  
  public FrameLayout Z;
  
  public FrameLayout aA;
  
  public FrameLayout aB;
  
  public FrameLayout aC;
  
  public AVLoadingIndicatorView aD;
  
  public AVLoadingIndicatorView aE;
  
  public AVLoadingIndicatorView aF;
  
  public FrameLayout aG;
  
  public ViewPager aH;
  
  public LiveModePagerAdapter aI;
  
  public boolean aJ;
  
  public boolean aK;
  
  public boolean aL = true;
  
  public FrameLayout aM;
  
  public LiveDragViewLayout aN;
  
  public boolean aO = true;
  
  public boolean aP = false;
  
  public int aQ = -1;
  
  public Dialog aR;
  
  public int aS;
  
  public LiveGuideManager aT;
  
  public IScreenManager aU;
  
  public LinearLayout aV;
  
  public boolean aW;
  
  public FrameLayout aX;
  
  public LinearLayout aY;
  
  public LivePKProgressView aZ;
  
  public TextureView aa;
  
  public FrameLayout ab;
  
  public FrameLayout ac;
  
  public FrameLayout ad;
  
  public FrameLayout ae;
  
  public FrameLayout af;
  
  public FrameLayout ag;
  
  public FrameLayout ah;
  
  public FrameLayout ai;
  
  public FrameLayout aj;
  
  public FrameLayout ak;
  
  public FrameLayout al;
  
  public FrameLayout am;
  
  public TextureView an;
  
  public TextureView ao;
  
  public TextureView ap;
  
  public TextureView aq;
  
  public TextureView ar;
  
  public TextureView as;
  
  public ImageView at;
  
  public ImageView au;
  
  public TextView av;
  
  public TextView aw;
  
  public TextView ax;
  
  public TextView ay;
  
  public FrameLayout az;
  
  public View bA;
  
  public ImageView bB;
  
  public ImageView bC;
  
  public ImageView bD;
  
  public View bE;
  
  public View bF;
  
  public View bG;
  
  public TextView bH;
  
  public TextView bI;
  
  public TextView bJ;
  
  public LiveMakeLoverRootGuestView bK;
  
  public LiveMakeLoverManageGuestView bL;
  
  public PlayingMakeLoverManager bM;
  
  public LiveMakeLoverDialogFragment bN;
  
  public LiveMakeFriendSettingView bO;
  
  public LiveMakeFriendListView bP;
  
  public LiveAnchorTaskView bQ;
  
  public View bR;
  
  public PlayingMakeFriendManager bS;
  
  public ImageView bT;
  
  public PopLiveActivityWebView bU;
  
  public View bV;
  
  public ImageView bW;
  
  public LivePlayExitTipManager bX;
  
  public int bY = 0;
  
  public String bZ = "";
  
  public LivePKUserBanner ba;
  
  public LivePKResult bb;
  
  public LivePKBubbleLayout bc;
  
  public LivePKBubbleLayout bd;
  
  public FrameLayout be;
  
  public LivePKCountDownView bf;
  
  public ImageView bg;
  
  public ImageView bh;
  
  public LiveAnimationView bi;
  
  public PopLiveCallView bj;
  
  public FrameLayout bk;
  
  public FrameLayout bl;
  
  public FrameLayout bm;
  
  public FrameLayout bn;
  
  public FrameLayout bo;
  
  public FrameLayout bp;
  
  public ImageView bq;
  
  public ImageView br;
  
  public ImageView bs;
  
  public ImageView bt;
  
  public ImageView bu;
  
  public ImageView bv;
  
  public ImageView bw;
  
  public ImageView bx;
  
  public View by;
  
  public View bz;
  
  public String ca;
  
  public int cb;
  
  Runnable cc = new -$$Lambda$PlayingOnliveFragment$9A_PIiJQZUsvNDBv_tksTx38PRs(this);
  
  LiveDragViewLayout.OnLayoutStateListener cd = new LiveDragViewLayout.OnLayoutStateListener(this) {
      public void a() {}
      
      public void a(int param1Int) {
        if (this.a.aJ) {
          if (this.a.aR != null && this.a.aR.isShowing())
            return; 
          PlayingOnliveFragment playingOnliveFragment = this.a;
          playingOnliveFragment.aR = (Dialog)CommonAlertDialog.a(playingOnliveFragment.y, "", this.a.y.getString(R.string.live_rtc_model_tip), this.a.y.getString(R.string.biao_version_exit), new DialogInterface.OnClickListener(this) {
                public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                  if (this.a.a.aE()) {
                    if (this.a.a.bS != null) {
                      this.a.a.bS.f();
                      return;
                    } 
                  } else if (this.a.a.aG()) {
                    if (this.a.a.bM != null) {
                      this.a.a.bM.a(false);
                      return;
                    } 
                  } else {
                    this.a.a.f(true);
                  } 
                }
              },  this.a.y.getString(R.string.cancel), null, null);
        } 
      }
      
      public void b() {
        InstantLog.a("live_room_slide");
        this.a.aM.setVisibility(8);
        LiveFloatManager.a().b(false);
        if (!LiveDataListManager.a(this.a.y, this.a.u, 1, this.a.P))
          LiveFloatManager.a().n(); 
        this.a.aa();
        this.a.getActivity().overridePendingTransition(0, 0);
      }
      
      public void c() {
        InstantLog.a("live_room_slide");
        this.a.aM.setVisibility(8);
        LiveFloatManager.a().b(false);
        if (!LiveDataListManager.a(this.a.y, this.a.u, 0, this.a.P))
          LiveFloatManager.a().n(); 
        this.a.aa();
        this.a.getActivity().overridePendingTransition(0, 0);
      }
    };
  
  public boolean ce;
  
  ViewPager.OnPageChangeListener cf = new ViewPager.OnPageChangeListener(this) {
      public void onPageScrollStateChanged(int param1Int) {}
      
      public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
      
      public void onPageSelected(int param1Int) {
        if (param1Int != 0) {
          if (param1Int != 1)
            return; 
          this.a.U = true;
          PlayingOnliveFragment.co = 1;
          LiveSetDataObserver.a().c(1);
          this.a.aV.setVisibility(8);
          return;
        } 
        this.a.U = false;
        PlayingOnliveFragment.co = 0;
        LiveSetDataObserver.a().c(0);
        if (!this.a.aF())
          this.a.aV.setVisibility(0); 
      }
    };
  
  public long cg;
  
  public boolean ch;
  
  public boolean ci;
  
  LiveGiftFragment cj;
  
  public AlertDialog ck;
  
  int cl = 0;
  
  Runnable cm = new -$$Lambda$PlayingOnliveFragment$9XN4Tcu7_iHoY7BCq-Hb9Y7_jJM(this);
  
  public int cn = 2;
  
  private int cp;
  
  private PKDoubleAnimView cq;
  
  private ImageView cr;
  
  private PopRankingListView cs;
  
  private PopPKListView ct;
  
  private LiveActivityWebDialogFragment cu;
  
  private LiveKissDialogFragment cv;
  
  private long cw = 0L;
  
  private boolean cx = true;
  
  public Context y;
  
  public ImageView z;
  
  public static void a(Context paramContext, LiveRoomData paramLiveRoomData) {
    // Byte code:
    //   0: ldc com/blued/android/module/live_china/fragment/PlayingOnliveFragment
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: iconst_m1
    //   6: new java/util/ArrayList
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: invokestatic a : (Landroid/content/Context;Lcom/blued/android/module/live_china/model/LiveRoomData;ILjava/util/List;)V
    //   16: ldc com/blued/android/module/live_china/fragment/PlayingOnliveFragment
    //   18: monitorexit
    //   19: return
    //   20: astore_0
    //   21: ldc com/blued/android/module/live_china/fragment/PlayingOnliveFragment
    //   23: monitorexit
    //   24: aload_0
    //   25: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	20	finally
  }
  
  public static void a(Context paramContext, LiveRoomData paramLiveRoomData, int paramInt, List<LiveRoomData> paramList) {
    // Byte code:
    //   0: ldc com/blued/android/module/live_china/fragment/PlayingOnliveFragment
    //   2: monitorenter
    //   3: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveFloatManager;
    //   6: invokevirtual y : ()Z
    //   9: ifeq -> 46
    //   12: aload_1
    //   13: getfield comeCode : Ljava/lang/String;
    //   16: ldc_w 'web'
    //   19: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   22: ifne -> 46
    //   25: aload_1
    //   26: getfield comeCode : Ljava/lang/String;
    //   29: ldc_w 'live_room_ranking'
    //   32: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   35: istore #4
    //   37: iload #4
    //   39: ifne -> 46
    //   42: ldc com/blued/android/module/live_china/fragment/PlayingOnliveFragment
    //   44: monitorexit
    //   45: return
    //   46: aload_3
    //   47: ifnull -> 67
    //   50: aload_3
    //   51: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveDataListManager;
    //   54: invokevirtual b : ()Ljava/util/List;
    //   57: if_acmpeq -> 67
    //   60: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveDataListManager;
    //   63: aload_3
    //   64: invokevirtual a : (Ljava/util/List;)V
    //   67: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveFloatManager;
    //   70: invokevirtual K : ()V
    //   73: invokestatic a : ()Lcom/blued/android/framework/utils/AudioManagerUtils;
    //   76: invokevirtual b : ()V
    //   79: new android/os/Bundle
    //   82: dup
    //   83: invokespecial <init> : ()V
    //   86: astore #6
    //   88: iconst_0
    //   89: istore #5
    //   91: aload_1
    //   92: getfield lid : J
    //   95: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveFloatManager;
    //   98: invokevirtual v : ()J
    //   101: lcmp
    //   102: ifne -> 127
    //   105: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveRoomManager;
    //   108: invokevirtual h : ()Lcom/blued/android/module/live_china/model/LiveRoomData;
    //   111: ifnull -> 127
    //   114: iconst_1
    //   115: istore #4
    //   117: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveRoomManager;
    //   120: invokevirtual h : ()Lcom/blued/android/module/live_china/model/LiveRoomData;
    //   123: astore_3
    //   124: goto -> 178
    //   127: iload #5
    //   129: istore #4
    //   131: aload_1
    //   132: astore_3
    //   133: aload_1
    //   134: getfield lid : J
    //   137: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveFloatManager;
    //   140: invokevirtual v : ()J
    //   143: lcmp
    //   144: ifeq -> 178
    //   147: iload #5
    //   149: istore #4
    //   151: aload_1
    //   152: astore_3
    //   153: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveFloatManager;
    //   156: invokevirtual v : ()J
    //   159: ldc2_w -1
    //   162: lcmp
    //   163: ifeq -> 178
    //   166: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveFloatManager;
    //   169: invokevirtual n : ()V
    //   172: aload_1
    //   173: astore_3
    //   174: iload #5
    //   176: istore #4
    //   178: aload #6
    //   180: ldc_w 'live_anchor_model'
    //   183: aload_3
    //   184: invokevirtual putSerializable : (Ljava/lang/String;Ljava/io/Serializable;)V
    //   187: aload #6
    //   189: ldc_w 'live_list_position'
    //   192: iload_2
    //   193: invokevirtual putInt : (Ljava/lang/String;I)V
    //   196: aload #6
    //   198: ldc_w 'live_window'
    //   201: iload #4
    //   203: invokevirtual putBoolean : (Ljava/lang/String;Z)V
    //   206: aload #6
    //   208: invokestatic a : (Landroid/os/Bundle;)Landroid/os/Bundle;
    //   211: pop
    //   212: aload #6
    //   214: invokestatic b : (Landroid/os/Bundle;)Landroid/os/Bundle;
    //   217: pop
    //   218: aload_0
    //   219: ldc com/blued/android/module/live_china/fragment/PlayingOnliveFragment
    //   221: aload #6
    //   223: invokestatic b : (Landroid/content/Context;Ljava/lang/Class;Landroid/os/Bundle;)V
    //   226: ldc com/blued/android/module/live_china/fragment/PlayingOnliveFragment
    //   228: monitorexit
    //   229: return
    //   230: astore_0
    //   231: ldc com/blued/android/module/live_china/fragment/PlayingOnliveFragment
    //   233: monitorexit
    //   234: aload_0
    //   235: athrow
    // Exception table:
    //   from	to	target	type
    //   3	37	230	finally
    //   50	67	230	finally
    //   67	88	230	finally
    //   91	114	230	finally
    //   117	124	230	finally
    //   133	147	230	finally
    //   153	172	230	finally
    //   178	226	230	finally
  }
  
  private void bb() {
    LiveEventBus.get("live_playing_hide_activity_pop", Boolean.class).observe((LifecycleOwner)this, new Observer<Boolean>(this) {
          public void a(Boolean param1Boolean) {
            this.a.aV();
          }
        });
    LiveEventBus.get("live_show_dialog", Boolean.class).observe((LifecycleOwner)this, new Observer<Boolean>(this) {
          public void a(Boolean param1Boolean) {
            if (param1Boolean.booleanValue()) {
              this.a.y_();
              return;
            } 
            this.a.z_();
          }
        });
    LiveEventBus.get("live_ranking_dialog", Integer.class).observe((LifecycleOwner)this, new Observer<Integer>(this) {
          public void a(Integer param1Integer) {
            if (LiveRoomManager.a().h() == null)
              return; 
            if (PlayingOnliveFragment.a(this.a) == null) {
              PlayingOnliveFragment playingOnliveFragment = this.a;
              PlayingOnliveFragment.a(playingOnliveFragment, new PopRankingListView((BaseFragment)playingOnliveFragment));
            } 
            PlayingOnliveFragment.a(this.a).a(param1Integer.intValue());
          }
        });
    LiveEventBus.get("live_pk_dialog", LivePkBannerModel.class).observe((LifecycleOwner)this, new Observer<LivePkBannerModel>(this) {
          public void a(LivePkBannerModel param1LivePkBannerModel) {
            if (param1LivePkBannerModel == null)
              return; 
            if (LiveRoomManager.a().h() == null)
              return; 
            if (PlayingOnliveFragment.b(this.a) == null) {
              PlayingOnliveFragment playingOnliveFragment = this.a;
              PlayingOnliveFragment.a(playingOnliveFragment, new PopPKListView((BaseFragment)playingOnliveFragment));
            } 
            param1LivePkBannerModel.from = 0;
            PlayingOnliveFragment.b(this.a).a(param1LivePkBannerModel);
          }
        });
    LiveEventBus.get("live_gift_zan_model", LiveZanExtraModel.class).observe((LifecycleOwner)this, new Observer<LiveZanExtraModel>(this) {
          public void a(LiveZanExtraModel param1LiveZanExtraModel) {
            if (param1LiveZanExtraModel != null) {
              this.a.a(param1LiveZanExtraModel.danmu);
              this.a.b(param1LiveZanExtraModel.danmu_count);
              if (param1LiveZanExtraModel.hot_words != null && param1LiveZanExtraModel.hot_words.size() > 0)
                LiveSetDataObserver.a().b(param1LiveZanExtraModel.hot_words); 
            } 
          }
        });
    LiveEventBus.get(LiveEventBusUtil.e, Integer.class).observe((LifecycleOwner)this, new -$$Lambda$PlayingOnliveFragment$CisN7bLhjw39iYlZNpGn0Gm6iTI(this));
  }
  
  private void bc() {
    int i = LiveRoomPreferences.w();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("state = ");
    stringBuilder.append(i);
    LogUtils.c(stringBuilder.toString());
    if (i > 0)
      aV(); 
  }
  
  private void bd() {
    this.e.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
          public void onGlobalLayout() {
            int i = this.a.e.getHeight();
            if (i != 0) {
              this.a.e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
              this.a.bY = i;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("realWindowHeight:");
              stringBuilder.append(this.a.bY);
              Log.i("==xpf", stringBuilder.toString());
              if (!this.a.aF() && !this.a.aD() && !this.a.B())
                LiveFloatManager.a().a(AppInfo.l, this.a.aZ()); 
            } 
          }
        });
    this.J = (KeyboardListenLinearLayout)this.e.findViewById(R.id.keyboardLinearLayout);
    this.Z = (FrameLayout)this.e.findViewById(R.id.cameraPreview_afl);
    this.aa = (TextureView)this.e.findViewById(R.id.cameraPreview_surfaceView);
    this.ab = (FrameLayout)this.e.findViewById(R.id.RemoteWindowA);
    this.ac = (FrameLayout)this.e.findViewById(R.id.RemoteWindowB);
    this.ad = (FrameLayout)this.e.findViewById(R.id.RemoteWindowC);
    this.ae = (FrameLayout)this.e.findViewById(R.id.RemoteWindowD);
    this.af = (FrameLayout)this.e.findViewById(R.id.RemoteWindowE);
    this.ag = (FrameLayout)this.e.findViewById(R.id.RemoteWindowF);
    this.bk = (FrameLayout)this.e.findViewById(R.id.live_window_layout_A);
    this.bl = (FrameLayout)this.e.findViewById(R.id.live_window_layout_B);
    this.bm = (FrameLayout)this.e.findViewById(R.id.live_window_layout_C);
    this.bn = (FrameLayout)this.e.findViewById(R.id.live_window_layout_D);
    this.bo = (FrameLayout)this.e.findViewById(R.id.live_window_layout_E);
    this.bp = (FrameLayout)this.e.findViewById(R.id.live_window_layout_F);
    this.ah = (FrameLayout)this.e.findViewById(R.id.fl_RemoteGLSurfaceViewA);
    this.ai = (FrameLayout)this.e.findViewById(R.id.fl_RemoteGLSurfaceViewB);
    this.aj = (FrameLayout)this.e.findViewById(R.id.fl_RemoteGLSurfaceViewC);
    this.ak = (FrameLayout)this.e.findViewById(R.id.fl_RemoteGLSurfaceViewD);
    this.al = (FrameLayout)this.e.findViewById(R.id.fl_RemoteGLSurfaceViewE);
    this.am = (FrameLayout)this.e.findViewById(R.id.fl_RemoteGLSurfaceViewF);
    this.an = (TextureView)this.e.findViewById(R.id.RemoteGLSurfaceViewA);
    this.ao = (TextureView)this.e.findViewById(R.id.RemoteGLSurfaceViewB);
    this.ap = (TextureView)this.e.findViewById(R.id.RemoteGLSurfaceViewC);
    this.aq = (TextureView)this.e.findViewById(R.id.RemoteGLSurfaceViewD);
    this.ar = (TextureView)this.e.findViewById(R.id.RemoteGLSurfaceViewE);
    this.as = (TextureView)this.e.findViewById(R.id.RemoteGLSurfaceViewF);
    this.at = (ImageView)this.e.findViewById(R.id.out_userA_btn);
    this.au = (ImageView)this.e.findViewById(R.id.out_userB_btn);
    this.av = (TextView)this.e.findViewById(R.id.remote_nameA);
    this.aw = (TextView)this.e.findViewById(R.id.remote_nameB);
    this.ax = (TextView)this.e.findViewById(R.id.remote_nameC);
    this.ay = (TextView)this.e.findViewById(R.id.remote_nameD);
    this.bq = (ImageView)this.e.findViewById(R.id.live_make_friend_num_A);
    this.br = (ImageView)this.e.findViewById(R.id.live_make_friend_num_B);
    this.bs = (ImageView)this.e.findViewById(R.id.live_make_friend_num_C);
    this.bt = (ImageView)this.e.findViewById(R.id.live_make_friend_num_D);
    this.bu = (ImageView)this.e.findViewById(R.id.live_make_friend_mic_A);
    this.bv = (ImageView)this.e.findViewById(R.id.live_make_friend_mic_B);
    this.bw = (ImageView)this.e.findViewById(R.id.live_make_friend_mic_C);
    this.bx = (ImageView)this.e.findViewById(R.id.live_make_friend_mic_D);
    this.by = this.e.findViewById(R.id.live_make_friend_free_A);
    this.bz = this.e.findViewById(R.id.live_make_friend_free_C);
    this.bA = this.e.findViewById(R.id.live_make_friend_free_D);
    this.bB = (ImageView)this.e.findViewById(R.id.live_make_friend_photo_A);
    this.bC = (ImageView)this.e.findViewById(R.id.live_make_friend_photo_C);
    this.bD = (ImageView)this.e.findViewById(R.id.live_make_friend_photo_D);
    this.aA = (FrameLayout)this.e.findViewById(R.id.remote_loading_layoutB);
    this.aB = (FrameLayout)this.e.findViewById(R.id.remote_loading_layoutC);
    this.aC = (FrameLayout)this.e.findViewById(R.id.remote_loading_layoutD);
    this.aD = (AVLoadingIndicatorView)this.e.findViewById(R.id.remote_loading_viewB);
    this.aE = (AVLoadingIndicatorView)this.e.findViewById(R.id.remote_loading_viewC);
    this.aF = (AVLoadingIndicatorView)this.e.findViewById(R.id.remote_loading_viewD);
    this.az = (FrameLayout)this.e.findViewById(R.id.WindowB_click_view);
    this.aG = (FrameLayout)this.e.findViewById(R.id.live_window_layout);
    this.bR = this.e.findViewById(R.id.live_make_friend_float_layout);
    this.bE = this.e.findViewById(R.id.live_make_friend_windows_A);
    this.bF = this.e.findViewById(R.id.live_make_friend_windows_C);
    this.bG = this.e.findViewById(R.id.live_make_friend_windows_D);
    this.bH = (TextView)this.e.findViewById(R.id.live_make_friend_name_A);
    this.bI = (TextView)this.e.findViewById(R.id.live_make_friend_name_C);
    this.bJ = (TextView)this.e.findViewById(R.id.live_make_friend_name_D);
    this.bK = (LiveMakeLoverRootGuestView)this.e.findViewById(R.id.live_make_lover_root_view);
    this.bK.a(this);
    this.bL = (LiveMakeLoverManageGuestView)this.e.findViewById(R.id.live_make_lover_manage_view);
    ImageView imageView = this.at;
    if (imageView != null)
      imageView.setOnClickListener(this); 
    if (this.au != null) {
      Logger.a("drb", new Object[] { "mOutUserB setOnClickListener---------------" });
      this.au.setOnClickListener(this);
    } 
    if (this.az != null) {
      Logger.a("drb", new Object[] { "setOnClickListener" });
      this.az.setOnClickListener(this);
    } 
    this.H = (FrameLayout)this.e.findViewById(R.id.aspectLayout);
    u();
    if (this.Q)
      this.f.setShakeWidth(DensityUtils.a(this.y, 50.0F)); 
    this.z = (ImageView)this.e.findViewById(R.id.img_header_bg);
    this.K = this.e.findViewById(R.id.live_loading_layout);
    this.L = (TextView)this.e.findViewById(R.id.live_loading_text);
    this.Y = DialogUtils.a((Context)getActivity());
    this.aV = (LinearLayout)this.e.findViewById(R.id.live_activity_layout);
    this.A = (ImageView)this.e.findViewById(R.id.all_gif_view);
    this.B = (ImageView)this.e.findViewById(R.id.grab_box_gif_view);
    this.C = (GrabBoxNumView)this.e.findViewById(R.id.grab_box_num_view);
    this.aH = (ViewPager)this.e.findViewById(R.id.live_view_pager);
    this.I = (LiveAnimationView)this.e.findViewById(R.id.live_animation_layou);
    this.aX = (FrameLayout)this.e.findViewById(R.id.live_pk_root_layout);
    this.aY = (LinearLayout)this.e.findViewById(R.id.live_pk_screen_layout);
    this.aZ = (LivePKProgressView)this.e.findViewById(R.id.live_pk_progress);
    this.ba = (LivePKUserBanner)this.e.findViewById(R.id.live_pk_banner);
    this.bf = (LivePKCountDownView)this.e.findViewById(R.id.live_pk_count_down_view);
    this.bf.setData((BaseFragment)this);
    this.bc = (LivePKBubbleLayout)this.e.findViewById(R.id.live_pk_my_bubble);
    this.bd = (LivePKBubbleLayout)this.e.findViewById(R.id.live_pk_your_bubble);
    this.be = (FrameLayout)this.e.findViewById(R.id.live_pk_your_layout);
    this.bg = (ImageView)this.e.findViewById(R.id.live_pk_my_result_icon);
    this.bh = (ImageView)this.e.findViewById(R.id.live_pk_your_result_icon);
    this.bi = (LiveAnimationView)this.e.findViewById(R.id.live_pk_start_anim);
    this.cq = (PKDoubleAnimView)this.e.findViewById(R.id.pk_double_anim_view);
    this.cq.setVisibility(8);
    this.bb = (LivePKResult)this.e.findViewById(R.id.pk_result);
    this.p.a((BaseFragment)this);
    this.aN = (LiveDragViewLayout)this.e.findViewById(R.id.view_drag_layout);
    this.aM = (FrameLayout)this.e.findViewById(R.id.root_layout);
    LiveDragViewLayout liveDragViewLayout = this.aN;
    if (liveDragViewLayout != null)
      liveDragViewLayout.setOnLayoutStateListener(this.cd); 
    this.bj = new PopLiveCallView((BaseFragment)this);
    this.bO = new LiveMakeFriendSettingView((BaseFragment)this, this.u);
    this.bP = (LiveMakeFriendListView)this.e.findViewById(R.id.live_make_friend_list_view);
    this.bP.a(1, new LiveMakeFriendListView.LiveSettingClickListener(this) {
          public void a() {
            this.a.bO.a(0);
            this.a.bO.e();
          }
        },  this.u, (BaseFragment)this);
    this.q.a(false, new LiveMakeFriendManageView.LiveManageOnClickListener(this) {
          public void a() {
            int i = this.a.q.b;
            if (i != 0 && i != 1 && i != 2) {
              if (i != 3)
                return; 
              this.a.bO.a(1);
              this.a.bO.e();
              return;
            } 
            this.a.bP.b(true);
          }
        },  this);
    this.bQ = (LiveAnchorTaskView)this.e.findViewById(R.id.live_new_anchor_task_view);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mIsLandLayout = ");
    stringBuilder.append(this.Q);
    Logger.d("task", new Object[] { stringBuilder.toString() });
    this.bQ.a((BaseFragment)this, this.Q);
    this.bL.a(this, new LiveMakeLoverManageGuestView.LiveMakeLoverOnClickListener(this) {
          public void a() {
            EventTrackLive.a(LiveProtos.Event.USER_CONNECT_APPLY_CLICK, String.valueOf(this.a.u), LiveRoomManager.a().e());
            this.a.V();
          }
        });
    this.bT = (ImageView)this.e.findViewById(R.id.first_charge_pop);
    this.bU = (PopLiveActivityWebView)this.e.findViewById(R.id.live_activity_web_view);
    this.bU.a((Fragment)this);
    this.bV = this.e.findViewById(R.id.live_my_header_layout);
    this.bW = (ImageView)this.e.findViewById(R.id.live_my_header_view);
    ImageLoader.a((IRequestHost)w_(), LiveRoomInfo.a().d()).a(this.bW);
    this.cr = (ImageView)this.e.findViewById(R.id.live_record_sticker_image);
  }
  
  private void be() {
    String str = AssetsUtils.a("live_pk_start.png", false);
    str = RecyclingUtils.Scheme.c.b(str);
    this.bi.a((IRequestHost)w_(), "", str, "", "", null);
  }
  
  private void bf() {
    if (this.Q) {
      e(4);
    } else {
      d(4);
    } 
    LiveSetDataObserver.a().e(4);
  }
  
  private void bg() {
    if (this.Q) {
      e(0);
    } else {
      d(0);
    } 
    C();
    LiveSetDataObserver.a().e(0);
  }
  
  private void bh() {
    FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
    this.cj = (LiveGiftFragment)getChildFragmentManager().findFragmentByTag("LiveGift");
    LiveGiftFragment liveGiftFragment = this.cj;
    if (liveGiftFragment == null) {
      this.cj = new LiveGiftFragment();
      this.cj.a((BaseFragment)this);
      fragmentTransaction.add(R.id.live_gift_container_layout_id, (Fragment)this.cj, "LiveGift");
    } else {
      fragmentTransaction.show((Fragment)liveGiftFragment);
    } 
    fragmentTransaction.commitAllowingStateLoss();
  }
  
  private boolean bi() {
    return (this.E.k() && LiveRoomManager.a().h() != null && !(LiveRoomManager.a().h()).isFollow) ? this.bX.d() : false;
  }
  
  private void j(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("liveType = ");
    stringBuilder.append(paramInt);
    Logger.d("PlayingOnliveFragment", new Object[] { stringBuilder.toString() });
    a(new Runnable(this, paramInt) {
          public void run() {
            if (this.b.bT.getVisibility() == 0) {
              this.b.q.b();
              this.b.bL.a();
            } 
            int i = DensityUtils.a(this.b.getContext(), 55.0F);
            int j = i;
            if (this.b.bT.getVisibility() == 0) {
              Logger.d("PlayingOnliveFragment", new Object[] { "首充礼包 " });
              j = i + this.b.bT.getHeight();
            } 
            i = j;
            if (this.b.q.getVisibility() == 0) {
              Logger.d("PlayingOnliveFragment", new Object[] { "上麦管理 " });
              i = j + DensityUtils.a(this.b.getContext(), 45.0F);
            } 
            j = i;
            if (this.b.bL.getVisibility() == 0) {
              Logger.d("PlayingOnliveFragment", new Object[] { "相亲管理 " });
              if (this.b.bL.a.getVisibility() == 0) {
                j = DensityUtils.a(this.b.getContext(), 90.0F);
              } else {
                j = DensityUtils.a(this.b.getContext(), 40.0F);
              } 
              j = i + j;
            } 
            i = this.a;
            if (i != 2 && i != 3) {
              FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.b.aV.getLayoutParams();
              layoutParams.gravity = 85;
              layoutParams.rightMargin = DensityUtils.a(this.b.y, 10.0F);
              layoutParams.topMargin = 0;
              layoutParams.bottomMargin = j;
              this.b.aV.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
              Logger.d("PlayingOnliveFragment", new Object[] { "活动icon " });
            } 
            this.b.bQ.b(this.a);
          }
        }300L);
  }
  
  public void A_() {
    bf();
  }
  
  public void B_() {
    bg();
  }
  
  public void F() {
    LogUtils.c("showFirstCharge");
    AppInfo.n().removeCallbacks(this.cc);
    aU();
    Date date = new Date(System.currentTimeMillis());
    int i = date.getYear() * 10000 + (date.getMonth() + 1) * 100 + date.getDate();
    if (i > LiveRoomPreferences.y()) {
      LiveRoomPreferences.m(i);
      AppInfo.n().postDelayed(this.cc, 15000L);
    } 
  }
  
  public void G() {
    a(new Runnable(this) {
          public void run() {
            if (LiveRoomManager.a().h() != null) {
              LiveRoomData liveRoomData = LiveRoomManager.a().h();
              int i = (int)((System.currentTimeMillis() - PlayingOnliveFragment.c(this.a)) / 1000L);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("stopPK time:");
              stringBuilder.append(i);
              Log.i("===ppp", stringBuilder.toString());
              EventTrackLive.b(LiveProtos.Event.LIVE_PK_AUDIENCE_DURATION, String.valueOf(liveRoomData.lid), LiveRoomManager.a().e(), i);
            } 
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            this.a.aX.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            this.a.aY.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            LiveFloatManager.a().a(AppInfo.l, this.a.aZ());
            FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams1.gravity = 17;
            this.a.H.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
            this.a.ad();
            this.a.ae();
            this.a.be.setVisibility(8);
            this.a.aZ.setVisibility(8);
            if (PlayingOnliveFragment.b(this.a) != null && PlayingOnliveFragment.b(this.a).a())
              PlayingOnliveFragment.b(this.a).b(); 
            this.a.bf.setVisibility(8);
            this.a.H();
            this.a.M_();
            this.a.bg.setVisibility(8);
            this.a.bh.setVisibility(8);
            this.a.bf.c();
            this.a.bf.setVisibility(8);
            this.a.az.setVisibility(8);
            LiveSetDataObserver.a().d();
            this.a.bb.a();
            this.a.ba.a();
            this.a.ba.setVisibility(8);
            this.a.b_(0);
          }
        }500L);
  }
  
  public void H() {
    this.cq.clearAnimation();
    this.cq.setVisibility(8);
  }
  
  public void I() {
    this.bS = new PlayingMakeFriendManager(this);
    this.bM = new PlayingMakeLoverManager(this);
    this.aU = (IScreenManager)new PlayingScreenManager(this);
    this.E = new PlayingOnlineManager(this, this.aP, this.t, this.u, this.P, this.R, this.H, this.M);
    LiveMsgSendManager.a().a(this.u);
    LiveMsgSendManager.a().a(this.t, this.u, this);
    this.F = new PlayingRTCManager(this, this.aa);
    this.bX = new LivePlayExitTipManager();
  }
  
  public void J() {
    LiveGuideManager liveGuideManager = this.aT;
    if (liveGuideManager != null)
      liveGuideManager.a(); 
  }
  
  public boolean K() {
    PKDoubleAnimView pKDoubleAnimView = this.cq;
    return (pKDoubleAnimView != null && pKDoubleAnimView.getVisibility() == 0);
  }
  
  public void L() {
    if (LiveRoomManager.a().h() != null) {
      this.aS = (LiveRoomManager.a().h()).live_type;
      if (this.aP && LiveRoomManager.a().h() != null && (LiveRoomManager.a().h()).link_type != 4)
        this.bQ.a(); 
      LiveSetDataObserver.a().a(LiveRoomManager.a().h());
    } 
  }
  
  public void M() {
    if (this.aS != 1 && this.aT == null)
      this.aT = new LiveGuideManager(this); 
  }
  
  public void N() {
    if (LiveRoomManager.a().h() == null)
      return; 
    if (!LiveRoomManager.a().l())
      ImageLoader.a((IRequestHost)w_(), (LiveRoomManager.a().h()).profile.avatar).a(R.drawable.shape_live_bg).e().d().a(this.z); 
    Logger.a("rrrb", new Object[] { "使用请求网络封面" });
  }
  
  public void O() {}
  
  public void P() {
    Context context = this.y;
    CommonAlertDialog.a(context, "", context.getString(R.string.live_make_friend_out_tips), this.y.getString(R.string.filter_off), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (this.a.bS != null)
              this.a.bS.f(); 
          }
        },  null, null, null);
  }
  
  public void Q() {
    Context context = this.y;
    CommonAlertDialog.a(context, "", context.getString(R.string.live_make_lover_quit_tip), this.y.getString(R.string.live_make_lover_confirm), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (this.a.bM != null)
              this.a.bM.a(false); 
          }
        },  null, null, null);
  }
  
  public void R() {
    Context context = this.y;
    CommonAlertDialog.a(context, "", context.getString(R.string.live_make_lover_quit_room_tip), this.y.getString(R.string.live_make_lover_confirm), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (this.a.bM != null)
              this.a.bM.a(true); 
          }
        },  null, null, null);
  }
  
  public void R_() {
    DialogUtils.a(this.Y);
  }
  
  public void S() {
    a(this.y, (String)null, 20, getString(R.string.liveVideo_livingView_tips_reportReason), (String)null, getString(R.string.liveVideo_livingView_label_reportButton), "", (String)null, new TextOnClickListener(this) {
          public void a(String param1String) {
            if (this.a.E != null)
              this.a.E.a(param1String); 
          }
        },  (DialogInterface.OnClickListener)null);
  }
  
  public void T() {
    if (!LiveRoomManager.a().l()) {
      Bundle bundle = new Bundle();
      bundle.putString("UID", LiveRoomManager.a().e());
      bundle.putLong(LiveRankGuestDialogFragment.a, this.u);
      bundle.putBoolean("isMakeLover", aF());
      this.V = new LiveRankGuestDialogFragment();
      this.V.a(this);
      this.V.setArguments(bundle);
      this.V.show(getFragmentManager(), "EditNameDialog");
    } 
  }
  
  public void U() {
    LiveFansGuestDialogFragment liveFansGuestDialogFragment = this.X;
    if (liveFansGuestDialogFragment != null && liveFansGuestDialogFragment.isVisible())
      return; 
    if (!LiveRoomManager.a().l()) {
      if ((LiveRoomManager.a().h()).profile != null)
        EventTrackLive.a(LiveProtos.Event.LIVE_FANS_CLUB_BTN_CLICK, String.valueOf(this.u), LiveRoomManager.a().e()); 
      Bundle bundle = new Bundle();
      bundle.putString("uid", LiveRoomManager.a().e());
      bundle.putLong("lid", this.u);
      bundle.putShort("session_type", this.t);
      bundle.putInt("level", (LiveRoomManager.a().h()).level);
      this.X = new LiveFansGuestDialogFragment();
      this.X.a(this);
      this.X.setArguments(bundle);
      this.X.show(getFragmentManager(), "FansDialog");
    } 
  }
  
  public void V() {
    LiveMakeLoverDialogFragment liveMakeLoverDialogFragment = this.bN;
    if (liveMakeLoverDialogFragment != null && liveMakeLoverDialogFragment.isVisible())
      return; 
    this.bN = new LiveMakeLoverDialogFragment();
    Bundle bundle = new Bundle();
    bundle.putLong("lid", this.u);
    bundle.putString("uid", LiveRoomInfo.a().f());
    bundle.putInt("from", 0);
    this.bN.setArguments(bundle);
    this.bN.a(new LiveMakeLoverDialogFragment.ILiveMakeLoverDialog(this) {
          public void a() {
            this.a.C();
          }
        });
    this.bN.show(getFragmentManager(), "liveMakeLoverApplyDialog");
  }
  
  public boolean V_() {
    if (this.bj.c()) {
      this.bj.a();
      return true;
    } 
    if (this.aJ) {
      if (aE()) {
        P();
        return true;
      } 
      if (aG()) {
        R();
        return true;
      } 
      ay();
      return true;
    } 
    if (this.bU.e()) {
      this.bU.f();
      return true;
    } 
    LiveGiftFragment liveGiftFragment = this.cj;
    if (liveGiftFragment != null && liveGiftFragment.a() && this.cj.isAdded() && !this.cj.isHidden() && this.cj.V_())
      return true; 
    if (this.q.a()) {
      AppMethods.d(R.string.live_make_friend_cancel_application);
      return true;
    } 
    if (LiveMakeLoverManager.b()) {
      AppMethods.d(R.string.live_make_lover_cancel_application);
      return true;
    } 
    PopRankingListView popRankingListView = this.cs;
    if (popRankingListView != null && popRankingListView.a()) {
      this.cs.c();
      return true;
    } 
    a(true);
    return false;
  }
  
  public boolean W() {
    LiveMakeLoverDialogFragment liveMakeLoverDialogFragment = this.bN;
    return (liveMakeLoverDialogFragment != null && liveMakeLoverDialogFragment.isVisible());
  }
  
  public void X() {
    LiveMakeLoverDialogFragment liveMakeLoverDialogFragment = this.bN;
    if (liveMakeLoverDialogFragment != null && liveMakeLoverDialogFragment.isVisible())
      this.bN.dismiss(); 
  }
  
  public void Y() {
    if (this.r != null && this.r.isVisible())
      this.r.dismiss(); 
  }
  
  public void Z() {
    bh();
  }
  
  public void a(float paramFloat1, float paramFloat2, String paramString, int paramInt) {
    Animation animation;
    if (paramInt == 0) {
      this.cr.setVisibility(8);
      animation = AnimationUtils.loadAnimation(this.y, R.anim.push_center_out);
      this.cr.startAnimation(animation);
      return;
    } 
    this.cr.setVisibility(0);
    ImageLoader.a((IRequestHost)w_(), (String)animation).a(this.cr);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DensityUtils.a(this.y, 90.0F), DensityUtils.a(this.y, 45.0F));
    layoutParams.leftMargin = (int)(paramFloat1 * AppInfo.l);
    layoutParams.topMargin = (int)(paramFloat2 * AppInfo.m);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("changeSticker leftMargin:");
    stringBuilder.append(layoutParams.leftMargin);
    stringBuilder.append(" == topMargin：");
    stringBuilder.append(layoutParams.topMargin);
    Log.v("pk", stringBuilder.toString());
    layoutParams.gravity = 51;
    this.cr.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void a(int paramInt, String paramString) {
    this.C.a(paramInt, paramString);
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    a(new Runnable(this, paramInt, paramBoolean) {
          public void run() {
            if (this.a == 0) {
              if (this.c.E.a == 1) {
                this.c.L.setText(R.string.live_anchor_leave);
              } else {
                this.c.L.setText(R.string.liveVideo_livingView_tips_isConnecting);
              } 
              this.c.cg = System.currentTimeMillis();
            } else if (this.c.z.getVisibility() == 0) {
              Log.e("xkz_er", "gone");
              AppInfo.n().postDelayed(new Runnable(this) {
                    public void run() {
                      this.a.c.z.setVisibility(8);
                      AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
                      alphaAnimation.setFillAfter(false);
                      alphaAnimation.setDuration(800L);
                      this.a.c.z.setAnimation((Animation)alphaAnimation);
                      alphaAnimation.start();
                    }
                  }200L);
            } 
            if (this.a == 8 && this.b) {
              long l1 = System.currentTimeMillis();
              long l2 = this.c.cg;
              if (this.c.E != null) {
                l1 = (l1 - l2) / 1000L;
                if (l1 > 2L)
                  this.c.E.a(l1); 
              } 
            } 
            this.c.K.setVisibility(this.a);
          }
        });
  }
  
  public void a(long paramLong) {
    PKDoubleAnimView pKDoubleAnimView = this.cq;
    if (pKDoubleAnimView == null)
      return; 
    if (paramLong <= 0L) {
      pKDoubleAnimView.a();
      return;
    } 
    pKDoubleAnimView.a(w_(), paramLong);
  }
  
  public void a(AlertDialog paramAlertDialog) {
    this.ck = paramAlertDialog;
  }
  
  public void a(Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, TextOnClickListener paramTextOnClickListener, DialogInterface.OnClickListener paramOnClickListener) {
    LinearLayout linearLayout = new LinearLayout(paramContext);
    linearLayout.setOrientation(1);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
    layoutParams.setMargins(5, 20, 5, 20);
    EditText editText = new EditText(paramContext);
    editText.setText(paramString5);
    editText.setHint(paramString6);
    editText.setSelection(paramString5.length());
    editText.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    editText.requestFocus();
    editText.setSingleLine(true);
    TextView textView = new TextView(paramContext);
    layoutParams = new LinearLayout.LayoutParams(-1, -2);
    layoutParams.setMargins(0, 0, 15, 0);
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    textView.setGravity(5);
    textView.setTextColor(paramContext.getResources().getColor(R.color.common_v4_blue_frame_font));
    linearLayout.addView((View)editText);
    linearLayout.addView((View)textView);
    int i = CommonStringUtils.e(paramString5);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(i);
    stringBuilder.append("/");
    stringBuilder.append(paramInt);
    textView.setText(stringBuilder.toString());
    editText.setSelection(paramString5.length());
    editText.addTextChangedListener(new TextWatcher(this, editText, paramInt, textView) {
          public int a;
          
          public int b;
          
          public void afterTextChanged(Editable param1Editable) {
            try {
              this.c.removeTextChangedListener(this);
              this.a = this.c.getSelectionStart();
              this.b = this.c.getSelectionEnd();
              while (CommonStringUtils.a(param1Editable) > this.d) {
                param1Editable.delete(this.a - 1, this.b);
                this.a--;
                this.b--;
              } 
              TextView textView = this.e;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(CommonStringUtils.a(param1Editable));
              stringBuilder.append("/");
              stringBuilder.append(this.d);
              textView.setText(stringBuilder.toString());
              this.c.setSelection(this.a);
              this.c.addTextChangedListener(this);
              return;
            } catch (Exception exception) {
              exception.printStackTrace();
              this.e.setText("");
              return;
            } 
          }
          
          public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          
          public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        });
    AlertDialog.Builder builder2 = new AlertDialog.Builder(paramContext);
    AlertDialog.Builder builder1 = builder2.setTitle(paramString1).setView((View)linearLayout);
    if (TextUtils.isEmpty(paramString4))
      paramString4 = paramContext.getResources().getString(R.string.biao_v4_ok); 
    builder1 = builder1.setPositiveButton(paramString4, new DialogInterface.OnClickListener(this, paramTextOnClickListener, editText) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            PlayingOnliveFragment.TextOnClickListener textOnClickListener = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.b.getText());
            stringBuilder.append("");
            textOnClickListener.a(stringBuilder.toString());
          }
        });
    if (TextUtils.isEmpty(paramString3))
      paramString3 = paramContext.getResources().getString(R.string.biao_v4_cancel); 
    builder1.setNegativeButton(paramString3, paramOnClickListener).setCancelable(true).setOnCancelListener(null);
    if (!TextUtils.isEmpty(paramString2))
      builder2.setMessage(paramString2); 
    this.ck = builder2.create();
    this.ck.getWindow().setSoftInputMode(5);
    this.ck.setCanceledOnTouchOutside(true);
    this.ck.show();
  }
  
  protected void a(Bundle paramBundle) {
    super.a(paramBundle);
    bd();
    b(this.J);
    ba();
  }
  
  public void a(JoinLiveResult paramJoinLiveResult, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {
    PlayingRTCManager playingRTCManager = this.F;
    if (playingRTCManager != null && !this.Q)
      playingRTCManager.a(paramJoinLiveResult, paramString1, paramString3, paramString4, paramInt); 
  }
  
  public void a(GrabBoxModel paramGrabBoxModel) {
    if (paramGrabBoxModel == null)
      return; 
    this.B.setVisibility(0);
    ImageLoader.a((IRequestHost)w_(), paramGrabBoxModel.box_gif).a(new ImageLoadResult(this, (IRequestHost)w_()) {
          public void a(int param1Int, Exception param1Exception) {
            this.a.B.setVisibility(8);
          }
        }).a(new ImageLoader.OnAnimationStateListener(this) {
          public void a() {}
          
          public void b() {
            this.a.B.setVisibility(8);
          }
        }).a(this.B);
  }
  
  public void a(LiveFriendModel paramLiveFriendModel) {
    this.cw = System.currentTimeMillis();
    int i = AppInfo.l / 2;
    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
    layoutParams2.setMargins(0, PlayingMakeFriendManager.b, 0, 0);
    this.aX.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i / 3 * 4);
    this.aY.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    j(1);
    this.be.setVisibility(0);
    this.aZ.setVisibility(0);
    this.aZ.b();
    if (paramLiveFriendModel != null)
      this.ba.a(paramLiveFriendModel.lid); 
    this.ba.setVisibility(0);
    this.bf.setVisibility(0);
    if (paramLiveFriendModel != null) {
      this.bf.a(paramLiveFriendModel);
      be();
    } 
    this.aU.e();
    this.az.setVisibility(0);
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(AppInfo.l / 2 - DensityUtils.a(this.y, 50.0F), AppInfo.l / 2 / 3 * 4 - DensityUtils.a(this.y, 38.0F));
    layoutParams1.topMargin = DensityUtils.a(this.y, 145.0F);
    layoutParams1.rightMargin = DensityUtils.a(this.y, 50.0F);
    layoutParams1.gravity = 53;
    this.az.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    LiveSetDataObserver.a().c();
    b_(1);
  }
  
  public void a(LiveGiftModel paramLiveGiftModel) {
    Logger.a("drb", new Object[] { "gift_pic_apng2 = ", paramLiveGiftModel.images_apng2 });
    Logger.a("drb", new Object[] { "gift_pic_url = ", paramLiveGiftModel.images_static });
    Logger.a("drb", new Object[] { "anim_code = ", paramLiveGiftModel.anim_code });
    Logger.a("drb", new Object[] { "gift_pic_gif = ", paramLiveGiftModel.images_gif });
    Logger.a("drb", new Object[] { "gift_pic_mp4 = ", paramLiveGiftModel.images_mp4 });
    LiveAnimationViewFactory.ScaleType scaleType = LiveAnimationViewFactory.ScaleType.a;
    if (this.Q) {
      scaleType = LiveAnimationViewFactory.ScaleType.b;
    } else if (LiveRoomInfo.a().w()) {
      scaleType = LiveAnimationViewFactory.ScaleType.a;
    } else {
      scaleType = LiveAnimationViewFactory.ScaleType.c;
    } 
    this.I.a((IRequestHost)w_(), paramLiveGiftModel.images_gif, paramLiveGiftModel.images_apng2, paramLiveGiftModel.images_mp4, paramLiveGiftModel.anim_code, scaleType, (LiveAnimationListener)new AnimationListenerAdapter(this, paramLiveGiftModel) {
          public void b() {
            LiveSetDataObserver.a().a(this.a);
          }
        });
  }
  
  public void a(LiveMakeLoverFansModel paramLiveMakeLoverFansModel) {
    this.bM.a(paramLiveMakeLoverFansModel);
  }
  
  public void a(LiveRoomCloseReason paramLiveRoomCloseReason) {
    a(new Runnable(this, paramLiveRoomCloseReason) {
          public void run() {
            String str1;
            if (!CommonTools.a((Fragment)this.b))
              return; 
            KeyboardUtils.a((Activity)this.b.getActivity());
            LiveRoomCloseReason liveRoomCloseReason = this.a;
            if (liveRoomCloseReason != null && liveRoomCloseReason.errorCode == 400006) {
              this.b.az();
              return;
            } 
            String str2 = this.b.getString(R.string.liveVideo_livingView_tips_networkUnstable);
            liveRoomCloseReason = this.a;
            if (liveRoomCloseReason != null && !TextUtils.isEmpty(liveRoomCloseReason.errorMessage)) {
              str1 = this.a.errorMessage;
            } else {
              str1 = str2;
              if (this.b.E != null) {
                this.b.E.j();
                str1 = str2;
              } 
            } 
            LiveRouteUtil.a((BaseFragment)this.b, str1);
          }
        });
  }
  
  public void a(LiveZanExtraModel.Danmaku paramDanmaku) {
    Logger.a("drb", new Object[] { "danmaku =========== ", paramDanmaku });
    LiveSetDataObserver.a().a(paramDanmaku);
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {
    if (!B())
      return; 
    this.bg.setVisibility(0);
    this.bg.setImageResource(paramInt);
  }
  
  public void a(String paramString1, String paramString2) {
    LiveSetDataObserver.a().a(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      if (this.aJ) {
        ay();
        return;
      } 
      if (LiveFloatManager.a().z()) {
        LiveFloatManager.a().a(this.D, this.aQ);
      } else {
        LiveFloatManager.a().n();
      } 
    } 
    if (this.K.getVisibility() == 0) {
      long l1 = System.currentTimeMillis();
      long l2 = this.cg;
      PlayingOnlineManager playingOnlineManager = this.E;
      if (playingOnlineManager != null)
        playingOnlineManager.a((l1 - l2) / 1000L); 
    } 
    if (B()) {
      int i = (int)((System.currentTimeMillis() - this.cw) / 1000L);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("destroy time:");
      stringBuilder.append(i);
      Log.i("===ppp", stringBuilder.toString());
      EventTrackLive.b(LiveProtos.Event.LIVE_PK_AUDIENCE_DURATION, String.valueOf(this.u), this.G, i);
    } 
    LiveSetDataObserver.a().o();
    LiveListPositionObserver.a().a(this.aQ, this.u);
    LiveFloatManager.a().a(null);
    LiveRoomManager.a().u();
    if (getActivity() != null)
      getActivity().finish(); 
  }
  
  public void a(boolean paramBoolean, int paramInt) {
    this.bS.a(paramBoolean, paramInt);
  }
  
  public void a(String[] paramArrayOfString) {
    if (this.f != null)
      this.f.a(paramArrayOfString); 
  }
  
  public boolean aA() {
    return (A() == 2);
  }
  
  public boolean aB() {
    return (A() == 3);
  }
  
  public boolean aC() {
    return (A() == 4);
  }
  
  public boolean aD() {
    return (A() == 5 || A() == 6);
  }
  
  public boolean aE() {
    return (A() == 6);
  }
  
  public boolean aF() {
    return (A() == 8 || A() == 9);
  }
  
  public boolean aG() {
    return (A() == 9);
  }
  
  public boolean aH() {
    if (aC()) {
      AppMethods.d(R.string.connecting);
      return false;
    } 
    if (aE()) {
      AppMethods.d(R.string.connecting);
      return false;
    } 
    if (aG()) {
      AppMethods.d(R.string.connecting);
      return false;
    } 
    if (this.q.a()) {
      AppMethods.d(R.string.live_make_friend_cancel_application);
      return false;
    } 
    if (LiveMakeLoverManager.b()) {
      AppMethods.d(R.string.live_make_lover_cancel_application);
      return false;
    } 
    return true;
  }
  
  public void aI() {
    if (aH()) {
      LiveRoomInfo.a().a(this.y, 4);
      a(true);
    } 
  }
  
  public void aJ() {
    FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
    LiveGiftFragment liveGiftFragment = this.cj;
    if (liveGiftFragment != null)
      fragmentTransaction.hide((Fragment)liveGiftFragment).commitAllowingStateLoss(); 
    C();
  }
  
  public void aK() {
    if (this.cj != null) {
      getChildFragmentManager().beginTransaction().remove((Fragment)this.cj).commitAllowingStateLoss();
      this.cj = null;
    } 
  }
  
  public void aL() {}
  
  public void aM() {}
  
  public void aN() {
    if (LiveRoomInfo.a().j()) {
      d("https://activity.blued.cn/hd/2020/lucky-turning?blued_mode=hide_nav", 0);
      return;
    } 
    d("https://activity-test.blued.cn/hd/2020/lucky-turning?blued_mode=hide_nav", 0);
  }
  
  public void aO() {
    d(8);
    this.p.setVisibility(8);
    this.aV.setVisibility(8);
    this.az.setVisibility(8);
  }
  
  public void aP() {
    LiveGiftFragment liveGiftFragment = this.cj;
    if (liveGiftFragment == null || liveGiftFragment.isHidden() || this.Q)
      d(0); 
    LiveSetDataObserver.a().n();
    if (this.p.a()) {
      this.p.setVisibility(0);
    } else {
      this.p.setVisibility(8);
    } 
    if (!this.U && !aF())
      this.aV.setVisibility(0); 
    LiveSetDataObserver.a().p();
    if (B() || aA() || aB() || aC())
      this.az.setVisibility(0); 
  }
  
  public void aQ() {
    if (this.aJ) {
      if (aE()) {
        P();
        return;
      } 
      if (aG()) {
        R();
        return;
      } 
      ay();
      return;
    } 
    if (LiveMakeLoverManager.b())
      LiveRoomHttpUtils.u(null, String.valueOf(this.u)); 
    Logger.a("ddrb", new Object[] { "onClickCloseBtn" });
    if (bi()) {
      this.bX.a();
      (new PopPlayExitView(this)).b();
      return;
    } 
    LiveFloatManager.a().b(false);
    LiveFloatManager.a().n();
    aa();
  }
  
  public void aR() {
    if (LiveRoomManager.a().h() == null)
      return; 
    int i = (LiveRoomManager.a().h()).link_type;
    byte b = 1;
    if (i != 1)
      return; 
    if ((LiveRoomManager.a().h()).pk != null) {
      LivePKProgressModel livePKProgressModel = new LivePKProgressModel();
      livePKProgressModel.top = (LiveRoomManager.a().h()).pk.top;
      livePKProgressModel.target_top = (LiveRoomManager.a().h()).pk.target_top;
      if ((LiveRoomManager.a().h()).pk.winner == 0L) {
        b = 0;
      } else if ((LiveRoomManager.a().h()).pk.winner != LiveRoomManager.a().d()) {
        b = 2;
      } 
      this.ba.a(String.valueOf((LiveRoomManager.a().h()).pk.lid), b, livePKProgressModel);
      a((LiveRoomManager.a().h()).pk.buff_countdown);
    } 
  }
  
  public void aS() {
    this.bO.c();
    this.F.l();
    this.bS.i();
  }
  
  public void aT() {
    this.bO.b();
    this.F.k();
    this.bS.h();
  }
  
  public void aU() {
    AppInfo.n().removeCallbacks(this.cc);
    Date date = new Date(System.currentTimeMillis());
    int i = date.getYear() * 10000 + (date.getMonth() + 1) * 100 + date.getDate();
    if (i > LiveRoomPreferences.z()) {
      ImageLoader.a((IRequestHost)w_(), R.drawable.live_charge_icon).f().a(R.drawable.gift_default_icon).e(-1).a(this.bT);
    } else {
      ImageLoader.a((IRequestHost)w_(), R.drawable.live_charge_icon_static).a(this.bT);
    } 
    this.bT.setOnClickListener(new -$$Lambda$PlayingOnliveFragment$-gCHew0NKFNYc8U53_t3QhRRB8o(this, i));
    this.bT.setVisibility(0);
    if (aD())
      this.q.b(); 
    if (aF() && this.bT.getDrawable() != null)
      this.bL.a(); 
    if (this.x == 0) {
      ae();
      return;
    } 
    j(this.x);
  }
  
  public void aV() {
    LogUtils.c("hideActivityPop");
    AppInfo.n().removeCallbacks(this.cc);
    this.bT.setVisibility(8);
    if (aD() && this.bT.getDrawable() == null)
      this.q.c(); 
    if (aF() && this.bT.getDrawable() == null)
      this.bL.b(); 
    ae();
  }
  
  public void aW() {
    LiveRankGuestDialogFragment liveRankGuestDialogFragment = this.V;
    if (liveRankGuestDialogFragment != null) {
      Dialog dialog = liveRankGuestDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.V.dismiss(); 
    } 
    LiveRegularEventRanklistDialogFragment liveRegularEventRanklistDialogFragment = this.W;
    if (liveRegularEventRanklistDialogFragment != null) {
      Dialog dialog = liveRegularEventRanklistDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.W.dismiss(); 
    } 
    PopRankingListView popRankingListView = this.cs;
    if (popRankingListView != null && popRankingListView.a())
      this.cs.c(); 
  }
  
  public void aX() {
    AppInfo.n().removeCallbacks(this.cm);
    Log.i("==ppp", "showLiveKissDialog 0");
    if (w_() == null || !w_().isActive()) {
      Log.i("==ppp", "showLiveKissDialog 1");
      return;
    } 
    LiveKissDialogFragment liveKissDialogFragment = this.cv;
    if (liveKissDialogFragment != null && liveKissDialogFragment.isVisible()) {
      Log.i("==ppp", "showLiveKissDialog 2");
      return;
    } 
    if (LiveRoomManager.a().h() == null) {
      Log.i("==ppp", "showLiveKissDialog 3");
      return;
    } 
    LiveOneKissModel liveOneKissModel = (LiveRoomManager.a().h()).liveOneKissModel;
    if (liveOneKissModel == null) {
      Log.i("==ppp", "showLiveKissDialog 4");
      return;
    } 
    String str1 = liveOneKissModel.animation;
    String str2 = RecyclingUtils.d(liveOneKissModel.animation);
    QueueFileDownloader.QueueFileListener queueFileListener = new QueueFileDownloader.QueueFileListener(this, liveOneKissModel) {
        public void a(int param1Int1, int param1Int2, String param1String1, String param1String2) {
          AppInfo.n().post(new Runnable(this, param1Int1) {
                public void run() {
                  if (this.b.b.w_() == null || !this.b.b.w_().isActive()) {
                    Log.i("==ppp", "showLiveKissDialog 5");
                    return;
                  } 
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("showLiveKissDialog 6:");
                  stringBuilder.append(this.a);
                  Log.i("==ppp", stringBuilder.toString());
                  if (this.a >= 0) {
                    LiveOneKissModel liveOneKissModel = new LiveOneKissModel();
                    liveOneKissModel.animation = this.b.a.animation;
                    liveOneKissModel.delay = this.b.a.delay;
                    liveOneKissModel.duration = this.b.a.duration;
                    liveOneKissModel.goods_id = this.b.a.goods_id;
                    liveOneKissModel.goods_name = this.b.a.goods_name;
                    liveOneKissModel.goods_icon = this.b.a.goods_icon;
                    liveOneKissModel.pop = this.b.a.pop;
                    liveOneKissModel.isChargeTo = this.b.a.isChargeTo;
                    PlayingOnliveFragment.a(this.b.b, new LiveKissDialogFragment());
                    PlayingOnliveFragment.f(this.b.b).a(new LiveKissDialogFragment.EventCallBack(this) {
                          public void a() {
                            if (LiveRoomManager.a().h() != null)
                              (LiveRoomManager.a().h()).liveOneKissModel = this.a.b.a; 
                            this.a.b.b.a(true);
                          }
                        });
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("kissModel", (Serializable)liveOneKissModel);
                    PlayingOnliveFragment.f(this.b.b).setArguments(bundle);
                    PlayingOnliveFragment.f(this.b.b).show(this.b.b.getFragmentManager(), "liveKissDialogFragment");
                    (LiveRoomManager.a().h()).liveOneKissModel = null;
                  } 
                }
              });
        }
      };
    ActivityFragmentActive activityFragmentActive = w_();
    QueueFileDownloader.a(new String[] { str1 }, new String[] { str2 }, queueFileListener, (IRequestHost)activityFragmentActive, true);
  }
  
  public void aY() {
    if (this.f != null)
      this.f.a(true, LiveRoomInfo.a().q()); 
    LiveMsgSendManager.a().a(this.cx);
    if (this.cx) {
      this.cx = false;
      if (LiveRoomManager.a().h() != null)
        EventTrackLive.a(LiveProtos.Event.LIVE_FIRST_LIKE_MSG_SEND, String.valueOf(this.u), LiveRoomManager.a().e()); 
      InstantLog.a("live_first_like_msg_send");
    } 
  }
  
  public int aZ() {
    return Math.max(this.bY, AppInfo.m);
  }
  
  protected void a_(ChattingModel paramChattingModel) {
    if (paramChattingModel == null)
      return; 
    this.E.a(paramChattingModel);
  }
  
  public void aa() {
    a(false);
  }
  
  public void ab() {
    Logger.a("drb", new Object[] { "openConnectionMode" });
    a(new Runnable(this) {
          public void run() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.a.Z.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            this.a.Z.setVisibility(0);
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.a.aG.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.a.bl.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            this.a.bl.setVisibility(0);
            layoutParams = new FrameLayout.LayoutParams(DensityUtils.a(this.a.y, 105.0F), DensityUtils.a(this.a.y, 187.0F));
            layoutParams.gravity = 85;
            layoutParams.setMargins(0, 0, 0, DensityUtils.a(this.a.y, 64.0F));
            this.a.ac.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            (LiveFloatManager.a()).b.setVisibility(8);
            LiveFloatManager.a().h();
            PlayingOnliveFragment playingOnliveFragment = this.a;
            playingOnliveFragment.aJ = true;
            playingOnliveFragment.aN.setRTCModel(this.a.aJ);
            LiveSetDataObserver.a().g();
            PlayingOnliveFragment.a(this.a, 2);
          }
        });
  }
  
  public void ac() {
    this.Z.setVisibility(4);
    (LiveFloatManager.a()).b.setVisibility(0);
    LiveFloatManager.a().f();
    this.aJ = false;
    this.aN.setRTCModel(this.aJ);
    LiveSetDataObserver.a().h();
  }
  
  public void ad() {
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.aV.getLayoutParams();
    layoutParams.gravity = 3;
    layoutParams.rightMargin = 0;
    layoutParams.topMargin = DensityUtils.a(this.y, 148.0F);
    layoutParams.bottomMargin = 0;
    this.aV.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void ae() {
    a(new Runnable(this) {
          public void run() {
            this.a.bQ.b(0);
          }
        },  300L);
  }
  
  public void af() {
    this.bS.c();
  }
  
  public void ag() {
    this.bM.f();
    j(8);
  }
  
  public void ah() {
    this.bM.g();
  }
  
  public void ai() {
    this.bM.l();
  }
  
  public void aj() {
    this.bM.m();
  }
  
  public void ak() {
    this.bS.k();
  }
  
  public void al() {
    this.bS.l();
  }
  
  public void am() {
    Q();
  }
  
  public void an() {
    LiveMakeLoverFansModel liveMakeLoverFansModel = this.bM.a(LiveRoomInfo.a().f());
    if (liveMakeLoverFansModel != null && liveMakeLoverFansModel.lamp == 1)
      this.bK.d(); 
  }
  
  public void ao() {
    this.ac.setVisibility(0);
    this.ao.setVisibility(0);
    e(true);
  }
  
  public void ap() {
    if (this.ac.getVisibility() == 0) {
      this.ac.setVisibility(4);
      aq();
    } 
    this.ao.setVisibility(4);
    this.au.setVisibility(8);
    this.az.setVisibility(8);
    this.aw.setVisibility(8);
  }
  
  public void aq() {
    Log.i("==record", "getTextureViewB");
    if (getContext() == null)
      return; 
    this.ao = new TextureView(getContext());
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.gravity = 17;
    this.ai.removeAllViews();
    this.ai.addView((View)this.ao, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public void ar() {
    Log.i("==record", "getTextureViewC");
    if (getContext() == null)
      return; 
    this.ap = new TextureView(getContext());
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.gravity = 17;
    this.aj.removeAllViews();
    this.aj.addView((View)this.ap, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public void as() {
    Log.i("==record", "getTextureViewD");
    if (getContext() == null)
      return; 
    this.aq = new TextureView(getContext());
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.gravity = 17;
    this.ak.removeAllViews();
    this.ak.addView((View)this.aq, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public void at() {
    if (getContext() == null)
      return; 
    this.ar = new TextureView(getContext());
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.gravity = 17;
    this.al.removeAllViews();
    this.al.addView((View)this.ar, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public void au() {
    if (getContext() == null)
      return; 
    this.as = new TextureView(getContext());
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
    layoutParams.gravity = 17;
    this.am.removeAllViews();
    this.am.addView((View)this.as, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public void av() {
    this.aA.setVisibility(8);
  }
  
  public void aw() {
    if (!this.ch) {
      if (this.aJ)
        return; 
      this.ch = true;
      Context context = this.y;
      CommonAlertDialog.a(context, null, "", context.getString(R.string.invited_you_connect), this.y.getString(R.string.reject), this.y.getString(R.string.accept), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              if (this.a.F != null) {
                if (this.a.Q)
                  this.a.getActivity().setRequestedOrientation(1); 
                AppInfo.n().postDelayed(new Runnable(this) {
                      public void run() {
                        this.a.a.F.a(this.a.a.t, this.a.a.u, 1);
                      }
                    }500L);
                this.a.ci = false;
              } 
              this.a.ch = false;
            }
          }new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              if (this.a.F != null) {
                this.a.F.a(this.a.t, this.a.u, 2);
                this.a.ci = true;
              } 
              this.a.ch = false;
            }
          }new DialogInterface.OnCancelListener(this) {
            public void onCancel(DialogInterface param1DialogInterface) {
              this.a.ch = false;
            }
          },  false, false);
    } 
  }
  
  public void ax() {
    Context context = this.y;
    CommonAlertDialog.a(context, "", context.getString(R.string.close_current_connection), null, new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            this.a.f(true);
          }
        },  this.y.getString(R.string.filter_off), null, null);
  }
  
  public void ay() {
    Context context = this.y;
    CommonAlertDialog.a(context, null, "", context.getString(R.string.confirm_exit_from_live_stream), null, null, new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            LiveFloatManager.a().n();
            this.a.aa();
          }
        },  null, null, false, false);
  }
  
  public void az() {
    if (getContext() == null)
      return; 
    LiveAnchorTaskView liveAnchorTaskView = this.bQ;
    if (liveAnchorTaskView != null)
      liveAnchorTaskView.c(); 
    X();
    Y();
    LiveRouteUtil.a((BaseFragment)this);
  }
  
  public void b(long paramLong) {
    LiveSetDataObserver.a().a(paramLong);
  }
  
  public void b(KeyboardListenLinearLayout paramKeyboardListenLinearLayout) {
    a(paramKeyboardListenLinearLayout);
  }
  
  public void b(LiveFriendModel paramLiveFriendModel) {
    this.bS.a();
    j(5);
  }
  
  public void b(String paramString) {}
  
  public void b(String paramString, int paramInt) {
    if (!B())
      return; 
    this.bh.setVisibility(0);
    this.bh.setImageResource(paramInt);
  }
  
  public void b(String paramString1, String paramString2) {
    if (LiveRoomManager.a().h() != null)
      EventTrackLive.a(LiveProtos.Event.GUEST_PHOTO_UPLOAD, LiveRoomManager.a().c(), LiveRoomManager.a().e()); 
    this.bK.a(paramString1, paramString2);
  }
  
  public void b(boolean paramBoolean) {
    PlayingRTCManager playingRTCManager = this.F;
    if (playingRTCManager != null) {
      if (paramBoolean) {
        playingRTCManager.c();
        return;
      } 
      playingRTCManager.d();
    } 
  }
  
  public void b(boolean paramBoolean, int paramInt) {
    this.bM.a(paramBoolean, paramInt);
  }
  
  public void b_(List<LiveFriendModel> paramList) {
    this.bS.a(paramList);
  }
  
  public void ba() {
    if (LiveRoomManager.a().h() != null) {
      LiveOneKissModel liveOneKissModel = (LiveRoomManager.a().h()).liveOneKissModel;
      if (liveOneKissModel != null) {
        Log.i("==ppp", "from 1");
        liveOneKissModel.duration = 0;
        liveOneKissModel.isChargeTo = true;
        aX();
        return;
      } 
    } 
    LiveRoomHttpUtils.e(String.valueOf(this.u), new BluedUIHttpResponse<BluedEntityA<LiveOneKissModel>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<LiveOneKissModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.getSingleData() != null) {
              Log.i("==ppp", "from 2");
              if (((LiveOneKissModel)param1BluedEntityA.getSingleData()).pop == 1) {
                Log.i("==ppp", "from 3");
                if (LiveRoomManager.a().h() != null)
                  (LiveRoomManager.a().h()).liveOneKissModel = (LiveOneKissModel)param1BluedEntityA.getSingleData(); 
                AppInfo.n().postDelayed(this.a.cm, (((LiveOneKissModel)param1BluedEntityA.getSingleData()).delay * 1000));
                return;
              } 
            } else {
              Log.i("==ppp", "from 4");
            } 
          }
          
          public void onUIFinish() {
            super.onUIFinish();
          }
        });
  }
  
  public void c(long paramLong) {
    this.D = paramLong;
  }
  
  public void c(LiveFriendModel paramLiveFriendModel) {
    this.bS.a(paramLiveFriendModel);
  }
  
  public void c(String paramString) {
    this.bK.a(paramString);
  }
  
  public void c(String paramString, int paramInt) {
    PopLiveActivityWebView popLiveActivityWebView = this.bU;
    if (popLiveActivityWebView != null)
      popLiveActivityWebView.a(paramString, paramInt); 
  }
  
  public void c(List<LiveMakeLoverFansModel> paramList) {
    this.bM.b(paramList);
  }
  
  public void c(boolean paramBoolean) {
    this.aN.setDragEnable(paramBoolean);
  }
  
  public void d() {
    DialogUtils.b(this.Y);
  }
  
  public void d(int paramInt) {
    LiveSetDataObserver.a().b(paramInt);
  }
  
  public void d(String paramString, int paramInt) {
    if (this.bU != null && !TextUtils.isEmpty(paramString)) {
      LiveSetDataObserver.a().s();
      this.bU.b(paramString, paramInt);
    } 
  }
  
  public void d(boolean paramBoolean) {
    if (paramBoolean) {
      this.ba.b();
      return;
    } 
    this.ba.c();
  }
  
  public void e() {}
  
  public void e(int paramInt) {
    LiveSetDataObserver.a().b(paramInt);
    if (this.U) {
      BarrageViewMultiOneRow barrageViewMultiOneRow = (BarrageViewMultiOneRow)this.e.findViewById(R.id.multi_barrage);
      if (barrageViewMultiOneRow != null) {
        barrageViewMultiOneRow.setVisibility(8);
        return;
      } 
    } else {
      BarrageViewMultiOneRow barrageViewMultiOneRow = (BarrageViewMultiOneRow)this.e.findViewById(R.id.multi_barrage);
      if (barrageViewMultiOneRow != null)
        barrageViewMultiOneRow.setVisibility(0); 
    } 
  }
  
  public void e(String paramString) {
    LiveActivityWebDialogFragment liveActivityWebDialogFragment = this.cu;
    if (liveActivityWebDialogFragment != null && liveActivityWebDialogFragment.isVisible())
      return; 
    this.cu = new LiveActivityWebDialogFragment();
    Bundle bundle = new Bundle();
    bundle.putString("url", paramString);
    this.cu.setArguments(bundle);
    this.cu.show(getFragmentManager(), "liveActivityWebDialogFragment");
  }
  
  public void e(boolean paramBoolean) {
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
    if (paramBoolean) {
      if (this.R == 1) {
        layoutParams.width = DensityUtils.a(this.y, 105.0F);
        layoutParams.height = DensityUtils.a(this.y, 157.0F);
      } else {
        layoutParams.width = DensityUtils.a(this.y, 105.0F);
        layoutParams.height = DensityUtils.a(this.y, 187.0F);
      } 
      layoutParams.bottomMargin = DensityUtils.a(this.y, 64.0F);
    } else {
      int i = this.cp;
      if (i == 2) {
        layoutParams.width = DensityUtils.a(this.y, 105.0F);
        layoutParams.height = DensityUtils.a(this.y, 187.0F);
        layoutParams.rightMargin = DensityUtils.a(this.y, 60.0F);
        layoutParams.bottomMargin = DensityUtils.a(this.y, 35.0F);
      } else if (i == 1) {
        layoutParams.width = DensityUtils.a(this.y, 105.0F);
        layoutParams.height = DensityUtils.a(this.y, 187.0F);
        layoutParams.bottomMargin = AppInfo.m - DensityUtils.a(this.y, 120.0F) - DensityUtils.a(this.y, 187.0F);
        layoutParams.rightMargin = DensityUtils.a(this.y, 30.0F);
      } else {
        layoutParams.width = DensityUtils.a(this.y, 105.0F);
        layoutParams.height = DensityUtils.a(this.y, 187.0F);
        layoutParams.bottomMargin = DensityUtils.a(this.y, 64.0F);
      } 
    } 
    layoutParams.gravity = 85;
    this.az.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.az.setVisibility(0);
    j(2);
  }
  
  public void e_(int paramInt) {
    LiveKissDialogFragment liveKissDialogFragment;
    LiveGiftPayTools.a();
    DialogWith6PW dialogWith6PW = LiveGiftPayTools.b;
    boolean bool = false;
    if (paramInt != -3) {
      if (paramInt != -2)
        return; 
      Logger.a("drb", new Object[] { "隐藏键盘" });
      T = false;
      aP();
      a(new Runnable(this) {
            public void run() {
              LiveSetDataObserver.a().a(8);
            }
          });
      liveKissDialogFragment = this.cv;
      if (liveKissDialogFragment != null && liveKissDialogFragment.isVisible()) {
        this.cv.g();
        return;
      } 
    } else {
      Logger.a("drb", new Object[] { "显示键盘" });
      T = true;
      if (liveKissDialogFragment != null && ((DialogWith6PW)liveKissDialogFragment).a != null && ((DialogWith6PW)liveKissDialogFragment).a.isShowing()) {
        paramInt = bool;
        if (this.Q) {
          paramInt = bool;
          if (((DialogWith6PW)liveKissDialogFragment).e != null) {
            a(new Runnable(this, (DialogWith6PW)liveKissDialogFragment) {
                  public void run() {
                    this.a.e.fullScroll(130);
                  }
                }500L);
            paramInt = bool;
          } 
        } 
      } else {
        AlertDialog alertDialog = this.ck;
        if (alertDialog != null && alertDialog.isShowing()) {
          paramInt = bool;
        } else {
          paramInt = 1;
        } 
      } 
      if (paramInt != 0)
        a(new Runnable(this) {
              public void run() {
                LiveSetDataObserver.a().a(0);
              }
            }); 
      LiveSetDataObserver.a().d(8);
      aO();
      LiveSetDataObserver.a().c(paramInt ^ 0x1);
      liveKissDialogFragment = this.cv;
      if (liveKissDialogFragment != null && liveKissDialogFragment.isVisible())
        this.cv.f(); 
    } 
  }
  
  public void f(int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3) {
            if (paramInt != 4) {
              this.cp = paramInt;
              return;
            } 
          } else {
            LogUtils.c("SWITCH_MODEL.SIMPLE");
            aV();
          } 
          LogUtils.c("SWITCH_MODEL.CLEAR");
          LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.p.getLayoutParams();
          layoutParams.leftMargin = -200;
          this.p.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          this.aV.setVisibility(8);
          aV();
        } else {
          LogUtils.c("SWITCH_MODEL.HORIZONTAL");
          LinearLayout.LayoutParams layoutParams1 = (LinearLayout.LayoutParams)this.p.getLayoutParams();
          layoutParams1.leftMargin = 0;
          this.p.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
          if (!aF())
            this.aV.setVisibility(0); 
          FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.aV.getLayoutParams();
          layoutParams.gravity = 3;
          layoutParams.rightMargin = 0;
          layoutParams.topMargin = DensityUtils.a(this.y, 120.0F);
          layoutParams.bottomMargin = 0;
          this.aV.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          aU();
        } 
      } else {
        ad();
      } 
    } else {
      ad();
    } 
    this.cp = paramInt;
  }
  
  public void f(String paramString) {
    if (!LiveRoomManager.a().l()) {
      Bundle bundle = new Bundle();
      bundle.putLong(LiveRankGuestDialogFragment.a, this.u);
      bundle.putString("UID", LiveRoomManager.a().e());
      bundle.putString("activity_id", paramString);
      this.W = new LiveRegularEventRanklistDialogFragment();
      this.W.a(new LiveRegularEventRanklistDialogFragment.ILiveHostDialog(this) {
            public void a() {
              PlayingOnliveFragment.d(this.a);
            }
            
            public void b() {
              PlayingOnliveFragment.e(this.a);
            }
          });
      this.W.setArguments(bundle);
      this.W.show(getFragmentManager(), "eventRankDialog");
    } 
  }
  
  public void f(boolean paramBoolean) {
    PlayingRTCManager playingRTCManager = this.F;
    if (playingRTCManager != null) {
      playingRTCManager.h();
      if (paramBoolean)
        this.F.e(); 
    } 
    ap();
    ac();
  }
  
  protected void finalize() throws Throwable {
    super.finalize();
  }
  
  public void g(int paramInt) {
    this.bK.c();
    LiveMakeLoverFansModel liveMakeLoverFansModel = this.bM.a(paramInt);
    if (liveMakeLoverFansModel != null) {
      if (liveMakeLoverFansModel.isEmpty())
        return; 
      if (LiveRoomManager.a().h() != null)
        EventTrackLive.b(LiveProtos.Event.USER_MIKE_USER_PHOTO_DOUBLE_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e(), liveMakeLoverFansModel.uid); 
      String str2 = liveMakeLoverFansModel.pic;
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = liveMakeLoverFansModel.avatar; 
      if (TextUtils.isEmpty(str1)) {
        Log.i("==makelover==", "photo is empty");
        return;
      } 
      LivePictureFragment livePictureFragment = new LivePictureFragment();
      livePictureFragment.a(new LiveBaseDialogFragment.IDialogEvent(this) {
            public void a() {
              this.a.C();
            }
            
            public void a(Object param1Object) {}
          });
      ArrayList<String> arrayList = new ArrayList();
      arrayList.add(str1);
      Bundle bundle = new Bundle();
      bundle.putStringArrayList("picture_url_list", arrayList);
      livePictureFragment.setArguments(bundle);
      livePictureFragment.show(getFragmentManager(), "see_picture");
    } 
  }
  
  public void g(boolean paramBoolean) {
    LiveGiftFragment liveGiftFragment = this.cj;
    if (liveGiftFragment != null)
      liveGiftFragment.b(paramBoolean); 
  }
  
  public void h(int paramInt) {
    if (aH()) {
      LiveRoomInfo.a().a(this.y, 5);
      a(true);
    } 
  }
  
  public void h(boolean paramBoolean) {
    a(paramBoolean);
  }
  
  public void i(int paramInt) {
    if (this.Q) {
      e(paramInt);
      return;
    } 
    d(paramInt);
  }
  
  public boolean j() {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1 && paramInt1 == 10111) {
      this.N = paramIntent.getStringArrayExtra("CHOOSED_UID");
      this.O = paramIntent.getStringArrayExtra("CHOOSED_TYPE");
      String[] arrayOfString = this.N;
      if (arrayOfString != null && arrayOfString.length > 0) {
        arrayOfString = this.O;
        if (arrayOfString != null && arrayOfString.length > 0) {
          LiveMsgSendManager.a().a(this.u, this.N, this.O, "");
          AppMethods.a(getString(R.string.liveVideo_message_label_hadShare));
        } 
      } 
    } 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    ArrayList<String> arrayList;
    if (paramView.getId() == R.id.live_like_view) {
      if (this.f != null)
        this.f.a(true, LiveRoomInfo.a().q()); 
      LiveMsgSendManager.a().a(false);
      return;
    } 
    if (paramView.getId() == R.id.live_msg_send_emotion) {
      N_();
      return;
    } 
    if (paramView.getId() == R.id.rank_showing) {
      T();
      return;
    } 
    if (paramView.getId() == R.id.out_userA_btn) {
      ax();
      return;
    } 
    if (paramView.getId() == R.id.out_userB_btn) {
      Logger.a("drb", new Object[] { "out_userB_btn" });
      ax();
      return;
    } 
    if (paramView.getId() == R.id.float_window_view) {
      a(true);
      return;
    } 
    if (paramView.getId() == R.id.WindowB_click_view) {
      if (B() || aA()) {
        if (this.E.b == CommonStringUtils.c(LiveRoomInfo.a().f()) && !LiveRoomManager.a().l()) {
          LiveSetDataObserver.a().e(LiveRoomManager.a().e());
          return;
        } 
        arrayList = new ArrayList();
        if (!LiveRoomManager.a().l()) {
          arrayList.add(LiveRoomManager.a().e());
        } else {
          arrayList.add("");
        } 
        arrayList.add(String.valueOf(this.E.b));
        LiveSetDataObserver.a().a(arrayList);
        LiveSetDataObserver.a().e(String.valueOf(this.E.b));
        InstantLog.a("live_connect_area_click");
        return;
      } 
      if (this.E.b == Long.valueOf(LiveRoomInfo.a().f()).longValue() && !LiveRoomManager.a().l()) {
        LiveSetDataObserver.a().e(LiveRoomManager.a().e());
        return;
      } 
      LiveSetDataObserver.a().e(String.valueOf(this.E.b));
      InstantLog.a("live_connect_area_click");
      return;
    } 
    if (arrayList.getId() == R.id.reconnect_btn)
      LiveFloatManager.a().e(); 
  }
  
  public void onClose(LiveCloseReason paramLiveCloseReason, LiveChatStatistics paramLiveChatStatistics) {
    a(new -$$Lambda$PlayingOnliveFragment$_K8mP3lHKRZAQjNswv2v40XMKIg(this, paramLiveCloseReason, paramLiveChatStatistics));
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    int i = paramConfiguration.orientation;
    if (i != 1) {
      if (i == 2) {
        this.Q = true;
        this.aU.a();
        aK();
      } 
    } else {
      this.Q = false;
      this.aU.b();
      aK();
    } 
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle) {
    getActivity().getWindow().setSoftInputMode(19);
    Logger.a("drb", new Object[] { "onCreate" });
    if (!this.aO || this.S)
      getActivity().overridePendingTransition(0, 0); 
    super.onCreate(paramBundle);
  }
  
  public void onDestroy() {
    super.onDestroy();
    AppInfo.n().removeCallbacks(this.cc);
    LiveFloatManager.a().b(false);
    (LiveFloatManager.a()).b.setVisibility(0);
    LiveMsgSendManager.a().b(this.t, this.u, this);
    PlayingMakeLoverManager playingMakeLoverManager = this.bM;
    if (playingMakeLoverManager != null)
      playingMakeLoverManager.k(); 
    PlayingMakeFriendManager playingMakeFriendManager = this.bS;
    if (playingMakeFriendManager != null)
      playingMakeFriendManager.j(); 
    PlayingRTCManager playingRTCManager = this.F;
    if (playingRTCManager != null && !this.Q)
      playingRTCManager.g(); 
    LiveGuideManager liveGuideManager = this.aT;
    if (liveGuideManager != null)
      liveGuideManager.b(); 
    PopRankingListView popRankingListView = this.cs;
    if (popRankingListView != null)
      popRankingListView.b(); 
    ZanRefreshObserver.a().b(this);
    LiveRefreshUIObserver.a().b(this);
    FrameLayout frameLayout = this.H;
    if (frameLayout != null)
      frameLayout.removeAllViews(); 
    LivePlayExitTipManager livePlayExitTipManager = this.bX;
    if (livePlayExitTipManager != null)
      livePlayExitTipManager.c(); 
    LivePKCountDownView livePKCountDownView = this.bf;
    if (livePKCountDownView != null)
      livePKCountDownView.f(); 
    LivePKProgressView livePKProgressView = this.aZ;
    if (livePKProgressView != null)
      livePKProgressView.a(); 
    AppInfo.n().removeCallbacks(this.cm);
    Logger.a("rrb", new Object[] { "onDestroy" });
    LiveActivityWebDialogFragment liveActivityWebDialogFragment = this.cu;
    if (liveActivityWebDialogFragment != null) {
      Dialog dialog = liveActivityWebDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.cu.dismissAllowingStateLoss(); 
    } 
  }
  
  public void onPause() {
    super.onPause();
    this.aK = false;
    LiveFloatManager.a().b(false);
    this.E.g();
    LiveRankGuestDialogFragment liveRankGuestDialogFragment = this.V;
    if (liveRankGuestDialogFragment != null) {
      Dialog dialog = liveRankGuestDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.V.dismiss(); 
    } 
    LiveRegularEventRanklistDialogFragment liveRegularEventRanklistDialogFragment = this.W;
    if (liveRegularEventRanklistDialogFragment != null) {
      Dialog dialog = liveRegularEventRanklistDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.W.dismiss(); 
    } 
    LiveFansGuestDialogFragment liveFansGuestDialogFragment = this.X;
    if (liveFansGuestDialogFragment != null) {
      Dialog dialog = liveFansGuestDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.X.dismiss(); 
    } 
    LiveMakeLoverDialogFragment liveMakeLoverDialogFragment = this.bN;
    if (liveMakeLoverDialogFragment != null) {
      Dialog dialog = liveMakeLoverDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.bN.dismiss(); 
    } 
    if (this.r != null) {
      Dialog dialog = this.r.getDialog();
      if (dialog != null && dialog.isShowing())
        this.r.dismiss(); 
    } 
    LiveKissDialogFragment liveKissDialogFragment = this.cv;
    if (liveKissDialogFragment != null) {
      Dialog dialog = liveKissDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.cv.dismiss(); 
    } 
    PlayingRTCManager playingRTCManager = this.F;
    if (playingRTCManager != null && !this.Q)
      playingRTCManager.a = true; 
    Logger.a("drb", new Object[] { "onPause" });
  }
  
  public void onRecvNewMsg(ChattingModel paramChattingModel) {
    LiveEventBusUtil.a(paramChattingModel, false);
  }
  
  public void onResume() {
    super.onResume();
    this.aK = true;
    int i = (this.y.getResources().getConfiguration()).orientation;
    if (LiveFloatManager.a().A() && i == 2) {
      Logger.a("drb", new Object[] { "onResume setRequestedOrientation" });
      getActivity().setRequestedOrientation(1);
      return;
    } 
    LiveSetDataObserver.a().d(0);
    this.E.f();
    PlayingRTCManager playingRTCManager = this.F;
    if (playingRTCManager != null && !this.Q)
      playingRTCManager.a = false; 
    LiveFloatManager.a().f();
    if (this.aL) {
      this.aL = false;
      LiveFloatManager.a().g();
    } 
    PopLiveActivityWebView popLiveActivityWebView = this.bU;
    if (popLiveActivityWebView != null)
      popLiveActivityWebView.c(); 
    Logger.a("drb", new Object[] { "onResume" });
  }
  
  public void onStop() {
    super.onStop();
    if (!this.Q) {
      this.bS.g();
      this.bM.j();
      if (aC())
        f(true); 
    } 
    LivePlayExitTipManager livePlayExitTipManager = this.bX;
    if (livePlayExitTipManager != null)
      livePlayExitTipManager.a(); 
    Logger.a("drb", new Object[] { "onStop" });
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    this.Y = DialogUtils.a((Context)getActivity());
    this.aI = new LiveModePagerAdapter(getChildFragmentManager(), this);
    this.aH.setAdapter((PagerAdapter)this.aI);
    this.aH.setPageMargin(DensityUtils.a(AppInfo.d(), 20.0F));
    this.aH.addOnPageChangeListener(this.cf);
    L();
    co = 0;
    if (!TextUtils.isEmpty(this.M)) {
      ImageLoader.a((IRequestHost)w_(), this.M).a(R.drawable.shape_live_bg).e().d().a(this.z);
    } else {
      N();
    } 
    if (this.R == 1)
      this.aU.b(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mIsLandLayout--");
    stringBuilder.append(this.Q);
    Logger.a("pk", new Object[] { stringBuilder.toString() });
    LiveRoomManager.a().u();
    if (!this.Q)
      a(new Runnable(this) {
            public void run() {
              LiveRoomManager.a().a(true);
              PlayingOnlineManager.a((IRequestHost)this.a.w_(), this.a.u);
            }
          }500L); 
    LiveGiftManager.a().a(false);
    bc();
    stringBuilder = new StringBuilder();
    stringBuilder.append("mComeCode = ");
    stringBuilder.append(this.P);
    Logger.d("PlayingOnliveFragment", new Object[] { stringBuilder.toString() });
    if (!LivePreferencesUtils.f()) {
      if (!TextUtils.equals(this.P, "nearby_mix_recommend"))
        return; 
      if (!LiveRoomManager.a().l())
        EventTrackLive.c(LiveProtos.Event.LIVE_SLIDE, LiveRoomManager.a().c(), LiveRoomManager.a().e(), (LiveRoomManager.a().h()).comeCode); 
      LiveRouteUtil.a((BaseFragment)this, 2);
    } 
  }
  
  protected int t() {
    return R.layout.fragment_play_onlive;
  }
  
  protected void v() {
    super.v();
    this.y = (Context)getActivity();
    LiveRankGuestDialogFragment.e = 0;
    LiveFloatManager.a().a(this);
    LiveDataManager.a().b();
    LiveRoomData liveRoomData = (LiveRoomData)this.s.getSerializable("live_anchor_model");
    this.aP = this.s.getBoolean("live_window", false);
    LiveRoomManager.a().a(liveRoomData);
    this.u = liveRoomData.lid;
    this.P = liveRoomData.comeCode;
    this.ca = liveRoomData.liveFrom;
    this.bZ = liveRoomData.liveFrom;
    this.cb = liveRoomData.livePosition;
    if (TextUtils.equals(this.P, "two_floor_nearby") || TextUtils.equals(this.P, "two_floor_live")) {
      this.S = true;
    } else {
      this.S = false;
    } 
    this.R = liveRoomData.screen_pattern;
    Logger.a("rrrb", new Object[] { "mScreenPattern = ", Integer.valueOf(this.R) });
    this.aQ = this.s.getInt("live_list_position", -1);
    this.M = liveRoomData.profile.avatar;
    this.aO = liveRoomData.hasTransition;
    Logger.a("rrb", new Object[] { "initData mLiveListPosition = ", Integer.valueOf(this.aQ) });
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mSessionId:");
    stringBuilder.append(this.u);
    stringBuilder.append(" -- uid:");
    stringBuilder.append(LiveRoomInfo.a().f());
    Log.v("pk", stringBuilder.toString());
    LiveRoomConstants.a = 32;
  }
  
  protected void w() {
    super.w();
    ZanRefreshObserver.a().a(this);
    LiveRefreshUIObserver.a().a(this);
    if (this.S)
      LiveEventBus.get("live_back_to_two_level").post(""); 
    bb();
    I();
  }
  
  public void y() {
    this.bS.b();
    ad();
    if (this.bT.getVisibility() == 0)
      this.q.c(); 
    ae();
  }
  
  public void y_() {
    bf();
  }
  
  protected boolean z() {
    return this.U ? false : (!(this.cp == 4));
  }
  
  public void z_() {
    bg();
  }
  
  public static interface TextOnClickListener {
    void a(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\PlayingOnliveFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */