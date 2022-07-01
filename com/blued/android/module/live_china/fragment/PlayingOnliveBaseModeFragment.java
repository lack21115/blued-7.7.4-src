package com.blued.android.module.live_china.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.chat.data.BadgeData;
import com.blued.android.chat.data.EntranceData;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live.base.utils.BitmapUtils;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.activity.PlayingOnliveActivity;
import com.blued.android.module.live_china.constant.LiveRoomConstants;
import com.blued.android.module.live_china.liveForMsg.LiveMsgManager;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.live_interface.IDispatchTouchEvent;
import com.blued.android.module.live_china.live_interface.IScreenManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveGiftManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.manager.PlayGifObserver;
import com.blued.android.module.live_china.manager.PlayingMakeFriendManager;
import com.blued.android.module.live_china.manager.PlayingMakeLoverManager;
import com.blued.android.module.live_china.manager.PlayingModelManager;
import com.blued.android.module.live_china.model.LiveDailyTaskExtra;
import com.blued.android.module.live_china.model.LiveDailyTaskModel;
import com.blued.android.module.live_china.model.LiveFansInfoModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveHornModel;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.model.LiveRewardModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.LiveShareTextModel;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.BeansRefreshObserver;
import com.blued.android.module.live_china.observer.LiveFansObserver;
import com.blued.android.module.live_china.observer.LiveKeyboardObserver;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveRelationshipObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.observer.LiveSysNetworkObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.model.LogData;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BackgroundTextView;
import com.blued.android.module.live_china.view.BadgeView;
import com.blued.android.module.live_china.view.GrabRewardView;
import com.blued.android.module.live_china.view.HornView;
import com.blued.android.module.live_china.view.LiveRankingButtonView;
import com.blued.android.module.live_china.view.LiveRecordLevelView;
import com.blued.android.module.live_china.view.LiveViewerListView;
import com.blued.android.module.live_china.view.MedalView;
import com.blued.android.module.live_china.view.PopTaskView;
import com.blued.android.module.live_china.view.VolumeBrightnessView;
import com.blued.android.module.live_china.view.shimmer.Shimmer;
import com.blued.android.module.live_china.view.shimmer.ShimmerTextView;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.File;
import java.util.List;

public class PlayingOnliveBaseModeFragment extends BaseFragment implements View.OnClickListener, View.OnTouchListener, Chronometer.OnChronometerTickListener, LiveUserRelationshipUtils.IAddOrRemoveAttentionDone, IDispatchTouchEvent, PlayGifObserver.IPlayGifObserver, BeansRefreshObserver.IBeansRefreshObserver, LiveFansObserver.ILiveFansObserver, LiveRelationshipObserver.ILiveRelationshipObserver, LiveSetDataObserver.ILiveSetDataObserver, LiveSysNetworkObserver.ILiveSysNetworkObserver {
  public static boolean aO = false;
  
  public boolean A;
  
  public boolean B;
  
  public ImageView C;
  
  public ImageView D;
  
  public ViewGroup E;
  
  public GrabRewardView F;
  
  public View G;
  
  public View H;
  
  public View I;
  
  public View J;
  
  public View K;
  
  public View L;
  
  public View M;
  
  public View N;
  
  public ImageView O;
  
  public ViewGroup P;
  
  public ImageView Q;
  
  public ImageView R;
  
  public BadgeView S;
  
  public ImageView T;
  
  public View U;
  
  public EditText V;
  
  public TextView W;
  
  public ImageView X;
  
  public ToggleButton Y;
  
  public BackgroundTextView Z;
  
  public View aA;
  
  public View aB;
  
  public View aC;
  
  public View aD;
  
  public LinearLayout aE;
  
  public ImageView aF;
  
  public ImageView aG;
  
  public LinearLayout aH;
  
  public ImageView aI;
  
  public LiveRecordLevelView aJ;
  
  public View aK;
  
  public ImageView aL;
  
  public TextView aM;
  
  public ImageView aN;
  
  public Dialog aP;
  
  public LiveRankingButtonView aQ;
  
  public boolean aR = false;
  
  public TextWatcher aS = new TextWatcher(this) {
      public int a;
      
      public int b;
      
      public void afterTextChanged(Editable param1Editable) {
        this.a = this.c.V.getSelectionStart();
        this.b = this.c.V.getSelectionEnd();
        this.c.V.removeTextChangedListener(this.c.aS);
        if (AppInfo.m() && TextUtils.equals("test", param1Editable.toString()))
          AppMethods.a("1012"); 
        while (param1Editable.length() > LiveRoomConstants.a) {
          int i = this.a;
          if (i == 0)
            break; 
          param1Editable.delete(i - 1, this.b);
          this.a--;
          this.b--;
        } 
        Logger.a("rrb", new Object[] { "editStart = ", Integer.valueOf(this.a) });
        if (this.a >= 0)
          this.c.V.setSelection(this.a); 
        this.c.V.addTextChangedListener(this.c.aS);
        this.c.w.d(8);
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  GestureDetector aT = new GestureDetector(this.d, (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
        public boolean onDoubleTap(MotionEvent param1MotionEvent) {
          Logger.a("drb", new Object[] { "双击事件" });
          if (LiveRoomManager.a().h() != null && !this.a.R() && this.a.ak != 4)
            LiveRefreshUIObserver.a().m(); 
          return super.onDoubleTap(param1MotionEvent);
        }
        
        public boolean onDown(MotionEvent param1MotionEvent) {
          if (PlayingOnliveBaseModeFragment.c(this.a) != null)
            PlayingOnliveBaseModeFragment.c(this.a).a(); 
          return super.onDown(param1MotionEvent);
        }
        
        public boolean onScroll(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) {
          if (this.a.ak != 1) {
            if (this.a.ak == 0)
              return false; 
            if (PlayingOnliveBaseModeFragment.c(this.a) != null)
              PlayingOnliveBaseModeFragment.c(this.a).a((Activity)this.a.getActivity(), param1MotionEvent1, param1Float1, param1Float2); 
          } 
          return false;
        }
        
        public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
          Logger.a("drb", new Object[] { "单击事件" });
          int i = this.a.ak;
          if (i != 0) {
            if (i != 1) {
              if (i != 2) {
                if (i == 3)
                  this.a.ae.a(); 
              } else {
                if (!this.a.R())
                  LiveRefreshUIObserver.a().m(); 
                if (this.a.R()) {
                  this.a.ae.c();
                  LogData logData = new LogData();
                  logData.D = "live_change_to_brief";
                  logData.n = String.valueOf(this.a.y);
                  InstantLog.a(logData);
                } 
              } 
            } else if (!this.a.R()) {
              LiveRefreshUIObserver.a().m();
            } 
          } else {
            LiveRefreshUIObserver.a().m();
          } 
          return super.onSingleTapConfirmed(param1MotionEvent);
        }
      });
  
  GestureDetector aU = new GestureDetector(getContext(), (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
        public boolean onDoubleTap(MotionEvent param1MotionEvent) {
          Log.i("==makelover==", "onDoubleTapA");
          return super.onDoubleTap(param1MotionEvent);
        }
        
        public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
          Log.i("==makelover==", "onSingleTapConfirmedA");
          if (this.a.ac()) {
            LiveRefreshUIObserver.a().b(true, 0);
          } else {
            LiveRefreshUIObserver.a().a(true, 0);
          } 
          return super.onSingleTapConfirmed(param1MotionEvent);
        }
      });
  
  GestureDetector aV = new GestureDetector(getContext(), (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
        public boolean onDoubleTap(MotionEvent param1MotionEvent) {
          Log.i("==makelover==", "onDoubleTapB");
          if (this.a.ac())
            LiveRefreshUIObserver.a().b(0); 
          return super.onDoubleTap(param1MotionEvent);
        }
        
        public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
          Log.i("==makelover==", "onSingleTapConfirmedB");
          if (this.a.ac()) {
            LiveRefreshUIObserver.a().b(false, 0);
          } else {
            LiveRefreshUIObserver.a().a(false, 0);
          } 
          return super.onSingleTapConfirmed(param1MotionEvent);
        }
      });
  
  GestureDetector aW = new GestureDetector(getContext(), (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
        public boolean onDoubleTap(MotionEvent param1MotionEvent) {
          if (this.a.ac())
            LiveRefreshUIObserver.a().b(1); 
          return super.onDoubleTap(param1MotionEvent);
        }
        
        public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
          if (this.a.ac()) {
            LiveRefreshUIObserver.a().b(false, 1);
          } else {
            LiveRefreshUIObserver.a().a(false, 1);
          } 
          return super.onSingleTapConfirmed(param1MotionEvent);
        }
      });
  
  GestureDetector aX = new GestureDetector(getContext(), (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
        public boolean onDoubleTap(MotionEvent param1MotionEvent) {
          if (this.a.ac())
            LiveRefreshUIObserver.a().b(2); 
          return super.onDoubleTap(param1MotionEvent);
        }
        
        public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
          if (this.a.ac()) {
            LiveRefreshUIObserver.a().b(false, 2);
          } else {
            LiveRefreshUIObserver.a().a(false, 2);
          } 
          return super.onSingleTapConfirmed(param1MotionEvent);
        }
      });
  
  GestureDetector aY = new GestureDetector(getContext(), (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
        public boolean onDoubleTap(MotionEvent param1MotionEvent) {
          if (this.a.ac())
            LiveRefreshUIObserver.a().b(3); 
          return super.onDoubleTap(param1MotionEvent);
        }
        
        public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
          if (this.a.ac())
            LiveRefreshUIObserver.a().b(false, 3); 
          return super.onSingleTapConfirmed(param1MotionEvent);
        }
      });
  
  GestureDetector aZ = new GestureDetector(getContext(), (GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener(this) {
        public boolean onDoubleTap(MotionEvent param1MotionEvent) {
          if (this.a.ac())
            LiveRefreshUIObserver.a().b(4); 
          return super.onDoubleTap(param1MotionEvent);
        }
        
        public boolean onSingleTapConfirmed(MotionEvent param1MotionEvent) {
          if (this.a.ac())
            LiveRefreshUIObserver.a().b(false, 4); 
          return super.onSingleTapConfirmed(param1MotionEvent);
        }
      });
  
  public ViewGroup aa;
  
  public boolean ab;
  
  public long ac;
  
  public FrameLayout ad;
  
  public IScreenManager ae;
  
  public ImageView af;
  
  public ImageView ag;
  
  public ImageView ah;
  
  public ImageView ai;
  
  public ImageView aj;
  
  public int ak;
  
  public boolean al;
  
  public View am;
  
  public LinearLayout an;
  
  public int ao;
  
  public int ap;
  
  public int aq;
  
  public int ar;
  
  public SimpleScreen as = new SimpleScreen(this);
  
  public boolean at;
  
  public FrameLayout au;
  
  public View av;
  
  public View aw;
  
  public View ax;
  
  public View ay;
  
  public View az;
  
  Runnable ba = new Runnable(this) {
      public void run() {
        PlayingOnliveBaseModeFragment.d(this.a);
      }
    };
  
  private VolumeBrightnessView bb;
  
  private ShimmerTextView bc;
  
  private Shimmer bd;
  
  private View be;
  
  private ImageView bf;
  
  private ImageView bg;
  
  private ImageView bh;
  
  private View bi;
  
  private PopTaskView bj;
  
  private View bk;
  
  private boolean bl;
  
  private PopupWindow bm;
  
  private LiveLiangWebDialogFragment bn;
  
  private Observer bo = new Observer<String>(this) {
      public void a(String param1String) {
        this.a.ae();
      }
    };
  
  private double bp;
  
  private String bq;
  
  private CountDownTimer br;
  
  public Context d;
  
  public View e;
  
  public ViewGroup f;
  
  public View g;
  
  public TextView h;
  
  public Chronometer i;
  
  public ViewGroup j;
  
  public FrameLayout k;
  
  public ImageView l;
  
  public ViewGroup m;
  
  public TextView n;
  
  public TextView o;
  
  public ImageView p;
  
  public LiveViewerListView q;
  
  public MedalView r;
  
  public HornView s;
  
  public View t;
  
  public ImageView u;
  
  public FrameLayout v;
  
  public LiveMsgManager w;
  
  public short x = 4;
  
  public long y;
  
  public long z;
  
  private void af() {
    LiveEventBus.get("live_luck_turning_btn", Boolean.class).observe((LifecycleOwner)this, new Observer<Boolean>(this) {
          public void a(Boolean param1Boolean) {
            PlayingOnliveBaseModeFragment.aO = param1Boolean.booleanValue();
            PlayingOnliveBaseModeFragment.a(this.a);
          }
        });
    LiveEventBus.get(LiveEventBusUtil.c, EntranceData.class).observe((LifecycleOwner)this, new -$$Lambda$PlayingOnliveBaseModeFragment$aG-GXR31HawnFdOj91QFKeRX7fU(this));
  }
  
  private void ag() {
    ImageView imageView = this.R;
    if (imageView == null)
      return; 
    boolean bool = this.A;
    byte b = 8;
    if (bool) {
      imageView.setVisibility(8);
      return;
    } 
    if (aO)
      b = 0; 
    imageView.setVisibility(b);
    aj();
  }
  
  private void ah() {
    if (LiveRoomManager.a().h() != null) {
      if ((LiveRoomManager.a().h()).rankingExtra == null)
        return; 
      LiveEventBus.get("live_ranking_msg").post((LiveRoomManager.a().h()).rankingExtra);
    } 
  }
  
  private void ai() {
    if (this.bk != null) {
      if (LiveRoomManager.a().h() == null)
        return; 
      if ((LiveRoomManager.a().h()).link_type == 4 || (LiveRoomManager.a().h()).live_type == 1 || (LiveRoomManager.a().h()).screen_pattern == 1) {
        this.bk.setVisibility(8);
      } else {
        this.bk.setVisibility(0);
      } 
      this.bk.setOnClickListener(this);
      aj();
    } 
  }
  
  private void aj() {
    if (this.be == null)
      return; 
    if (this.bc.getLineCount() > 1) {
      this.bc.setVisibility(8);
      this.be.setVisibility(0);
    } 
  }
  
  private void ak() {
    this.w = new LiveMsgManager(this);
  }
  
  private void al() {
    if (!LiveRoomManager.a().l()) {
      this.h.setText((LiveRoomManager.a().h()).profile.name);
      ImageLoader.a((IRequestHost)w_(), (LiveRoomManager.a().h()).profile.avatar).c().a(R.drawable.user_bg_round).a(this.l);
    } 
  }
  
  private void am() {
    if (!LiveRoomInfo.a().a(this.d, new View.OnClickListener(this) {
          public void onClick(View param1View) {
            LiveRefreshUIObserver.a().b(true);
          }
        }))
      M(); 
  }
  
  private void an() {
    if (!this.A && !R() && PlayingOnliveFragment.co != 1) {
      if (!TextUtils.isEmpty(this.V.getText().toString()))
        return; 
      this.w.d(0);
    } 
  }
  
  private void ao() {
    Log.i("xpp", "getLiveDailyTask");
    LiveRoomHttpUtils.e(new BluedUIHttpResponse<BluedEntity<LiveDailyTaskModel, LiveDailyTaskExtra>>(this, (IRequestHost)w_()) {
          public boolean onUIFailure(int param1Int, String param1String) {
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
          }
          
          public void onUIStart() {
            super.onUIStart();
          }
          
          public void onUIUpdate(BluedEntity<LiveDailyTaskModel, LiveDailyTaskExtra> param1BluedEntity) {
            if (param1BluedEntity.extra != null)
              if (((LiveDailyTaskExtra)param1BluedEntity.extra).login_task_status == 1 && LiveRoomPreferences.O()) {
                LiveMsgSendManager.a().g();
                if (LiveRoomManager.a().h() != null && (LiveRoomManager.a().h()).profile != null) {
                  EventTrackLive.a(LiveProtos.Event.LIVE_TODAY_WELFARE_TOAST_SHOW, String.valueOf(this.a.y), LiveRoomManager.a().e());
                  return;
                } 
              } else if (((LiveDailyTaskExtra)param1BluedEntity.extra).exist_not_receive_task == 1 && LiveRoomPreferences.Q()) {
                LiveMsgSendManager.a().f();
                if (LiveRoomManager.a().h() != null && (LiveRoomManager.a().h()).profile != null)
                  EventTrackLive.a(LiveProtos.Event.LIVE_GLOW_STICK_TOAST_SHOW, String.valueOf(this.a.y), LiveRoomManager.a().e()); 
              }  
          }
        }(IRequestHost)w_());
  }
  
  private void ap() {
    this.br = (new CountDownTimer(this, 5000L, 1000L) {
        public void onFinish() {
          if (PlayingOnliveBaseModeFragment.e(this.a) != null)
            PlayingOnliveBaseModeFragment.e(this.a).dismiss(); 
        }
        
        public void onTick(long param1Long) {}
      }).start();
  }
  
  public void D() {
    Shimmer shimmer = this.bd;
    if (shimmer != null && shimmer.b()) {
      this.bd.a();
      ShimmerTextView shimmerTextView = this.bc;
      if (shimmerTextView != null)
        shimmerTextView.setTextColor(-1); 
    } 
  }
  
  public void E() {
    a(new Runnable(this) {
          public void run() {
            if (!this.a.al)
              this.a.q.a(); 
          }
        });
  }
  
  public void E_() {
    if (this.aR) {
      if (LiveRoomManager.a().l())
        return; 
      if (this.bj == null)
        this.bj = new PopTaskView(getContext()); 
      this.bj.a(this.y, LiveRoomManager.a().e());
    } 
  }
  
  public void F() {
    a(new Runnable(this) {
          public void run() {
            long l = LiveRoomManager.a().o();
            Logger.a("drb", new Object[] { "refreshAllCount count = ", Long.valueOf(l) });
            if (this.a.w_() != null && this.a.w_().isActive()) {
              Logger.a("drb", new Object[] { "isActive refreshAllCount count = ", Long.valueOf(l) });
              if (l >= 0L) {
                TextView textView = this.a.n;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(CommonStringUtils.d(String.valueOf(l)));
                stringBuilder.append(this.a.getString(R.string.live_share_viewersCount));
                textView.setText(stringBuilder.toString());
              } 
            } 
          }
        });
  }
  
  public void F_() {}
  
  public void G() {
    this.at = false;
    LiveKeyboardObserver.a().c();
    this.w.d(8);
  }
  
  public void G_() {
    LiveRoomData liveRoomData = LiveRoomManager.a().h();
    if (liveRoomData != null) {
      int i = liveRoomData.anchor_liang_type;
      byte b = 8;
      if (i == 1) {
        View view = this.aK;
        if (LiveFloatManager.a().B()) {
          b = 8;
        } else {
          b = 0;
        } 
        view.setVisibility(b);
        this.aL.setVisibility(8);
        this.aM.setVisibility(0);
        TextView textView = this.aM;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ID: ");
        stringBuilder.append(liveRoomData.anchor_liang_id);
        textView.setText(stringBuilder.toString());
        return;
      } 
      if (liveRoomData.anchor_liang_type >= 2) {
        View view = this.aK;
        if (!LiveFloatManager.a().B())
          b = 0; 
        view.setVisibility(b);
        this.aL.setImageResource(R.drawable.live_liang);
        this.aL.setVisibility(0);
        this.aM.setVisibility(0);
        this.aM.setText(liveRoomData.anchor_liang_id);
        return;
      } 
      this.aK.setVisibility(8);
    } 
  }
  
  public void H() {
    this.w.f();
  }
  
  public void H_() {
    if (this.bd == null)
      this.bd = new Shimmer(); 
    ShimmerTextView shimmerTextView = this.bc;
    if (shimmerTextView != null) {
      this.bd.a((View)shimmerTextView);
      this.bc.setTextColor(Color.parseColor("#444444"));
    } 
  }
  
  public void I() {
    if (PlayingOnliveFragment.co == 0) {
      Logger.a("drb", new Object[] { "INDEX_FULL_MODE 通知播放全屏动画 当前是否在播放动画 = ", Boolean.valueOf(this.B) });
      if (!this.B) {
        a(new Runnable(this) {
              public void run() {
                this.a.J();
              }
            });
        return;
      } 
    } else {
      Logger.a("drb", new Object[] { "通知播放全屏动画 当前是否在播放动画 = ", Boolean.valueOf(this.B) });
      if (!this.B)
        a(new Runnable(this) {
              public void run() {
                this.a.J();
              }
            }); 
    } 
  }
  
  public void I_() {
    int i = AppInfo.l / 2;
    int j = PlayingMakeFriendManager.a;
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-1, j * 2);
    layoutParams1.setMargins(0, PlayingMakeFriendManager.c, 0, 0);
    this.au.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    layoutParams1 = new FrameLayout.LayoutParams(i, j);
    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, j);
    layoutParams2.leftMargin = i;
    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i, j);
    layoutParams3.topMargin = j;
    FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i, j);
    layoutParams4.leftMargin = i;
    layoutParams4.topMargin = j;
    this.av.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.aw.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.ax.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    this.ay.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
    this.au.setVisibility(0);
    this.av.setVisibility(0);
    this.aw.setVisibility(0);
    this.ax.setVisibility(0);
    this.ay.setVisibility(0);
    this.az.setVisibility(8);
    this.aA.setVisibility(8);
  }
  
  public void J() {
    List<LiveGiftModel> list = this.w.i();
    if (list.size() > 0) {
      this.B = true;
      LiveGiftModel liveGiftModel = list.get(0);
      Logger.a("drb", new Object[] { "播放全屏动画 playFullScreenAnim Observer notify " });
      if (this.ak == 4 && liveGiftModel.anim_code != "hongbao") {
        b(liveGiftModel);
        return;
      } 
      LiveRefreshUIObserver.a().a(liveGiftModel);
    } 
  }
  
  public void J_() {
    a(new Runnable(this) {
          public void run() {
            if (this.a.z != 0L)
              this.a.i.start(); 
          }
        });
  }
  
  public void K() {}
  
  public void K_() {
    a(new Runnable(this) {
          public void run() {
            this.a.i.stop();
          }
        });
  }
  
  public void L() {}
  
  public void M() {
    this.V.setFocusableInTouchMode(true);
    this.V.setFocusable(true);
    this.V.requestFocus();
    ((InputMethodManager)getActivity().getSystemService("input_method")).showSoftInput((View)this.V, 0);
  }
  
  public void N() {
    if (LiveRoomManager.a().h() != null && (LiveRoomManager.a().h()).screen_pattern == 1) {
      if (this.A) {
        this.bh.setVisibility(0);
        return;
      } 
      this.bg.setVisibility(0);
    } 
  }
  
  public void O() {
    if (LiveRoomManager.a().h() != null && (LiveRoomManager.a().h()).screen_pattern == 1) {
      if (this.A) {
        this.bh.setVisibility(8);
        return;
      } 
      this.bg.setVisibility(8);
    } 
  }
  
  public void P() {}
  
  public void Q() {
    LiveMsgManager liveMsgManager = this.w;
    if (liveMsgManager != null)
      liveMsgManager.e(false); 
  }
  
  public boolean R() {
    return (LiveRoomManager.a().h() != null && (LiveRoomManager.a().h()).live_type == 1);
  }
  
  public void R_() {}
  
  public void S() {
    IScreenManager iScreenManager = this.ae;
    if (iScreenManager != null)
      iScreenManager.b(); 
  }
  
  public void T() {
    if (this.aR) {
      Log.i("xpp", "openShare");
      Y();
    } 
  }
  
  public void U() {
    if (this.aR) {
      Log.i("xpp", "openGif");
      LiveRefreshUIObserver.a().i();
    } 
  }
  
  public void V() {
    if (this.aR) {
      Log.i("xpp", "requestLiveFansData");
      Z();
    } 
  }
  
  public boolean V_() {
    LiveRefreshUIObserver.a().n();
    return true;
  }
  
  public void W() {
    this.P.setVisibility(8);
    this.an.setVisibility(8);
    this.G.setVisibility(0);
    this.H.setVisibility(8);
    this.I.setVisibility(0);
    this.J.setVisibility(0);
    this.O.setVisibility(8);
    this.K.setVisibility(8);
    this.L.setVisibility(8);
    this.M.setVisibility(0);
    this.N.setVisibility(0);
    this.r.setVisibility(8);
    if (this.aN.getParent() instanceof ViewGroup)
      ((ViewGroup)this.aN.getParent()).removeView((View)this.aN); 
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DensityUtils.a(this.d, 50.0F), DensityUtils.a(this.d, 50.0F));
    layoutParams.gravity = 53;
    layoutParams.topMargin = PlayingMakeLoverManager.e + PlayingMakeLoverManager.c * 2;
    layoutParams.bottomMargin = 0;
    this.v.addView((View)this.aN, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public void X() {
    if (!LiveRefreshUIObserver.a().e())
      return; 
    if (LiveRoomManager.a().l())
      return; 
    ImageFileLoader.a((IRequestHost)w_()).a((LiveRoomManager.a().h()).profile.avatar).a();
    ImageFileLoader.a((IRequestHost)w_()).b((LiveRoomManager.a().h()).profile.avatar).a(new ImageFileLoader.OnLoadFileListener(this) {
          public void onUIFinish(File param1File, Exception param1Exception) {
            if (param1File != null && param1File.exists()) {
              Bitmap bitmap = BitmapFactory.decodeFile(param1File.getPath());
            } else {
              param1File = null;
            } 
            this.a.a((Bitmap)param1File);
          }
        }).a();
  }
  
  public void Y() {
    if (LiveRoomManager.a().l())
      return; 
    LiveRoomHttpUtils.a(LiveRoomManager.a().e(), new BluedUIHttpResponse<BluedEntityA<LiveShareTextModel>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<LiveShareTextModel> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0)
              PlayingOnliveBaseModeFragment.a(this.a, ((LiveShareTextModel)param1BluedEntityA.data.get(0)).copywriting); 
            this.a.X();
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.a.X();
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(this.a.aP);
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(this.a.aP);
          }
        }(IRequestHost)w_());
  }
  
  public void Z() {
    String str1;
    Log.i("xpp", "getLiveFansInfo");
    LiveRoomData liveRoomData = LiveRoomManager.a().h();
    String str2 = "";
    if (liveRoomData != null) {
      str1 = LiveRoomManager.a().e();
    } else {
      str1 = "";
    } 
    if (LiveRoomManager.a().h() != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(LiveRoomManager.a().b());
      stringBuilder.append("");
      str2 = stringBuilder.toString();
    } 
    if (TextUtils.isEmpty(str1)) {
      Log.i("xpp", "getLiveFansInfo uid is empty");
      return;
    } 
    if (TextUtils.isEmpty(str2)) {
      Log.i("xpp", "getLiveFansInfo lid is empty");
      return;
    } 
    LiveRoomHttpUtils.a(str1, str2, new BluedUIHttpResponse<BluedEntityA<LiveFansInfoModel>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<LiveFansInfoModel> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              LiveRoomManager.a().a(param1BluedEntityA.data.get(0));
              if (this.a.w != null && PlayingOnliveFragment.co == 0 && !LiveFloatManager.a().B()) {
                this.a.w.d();
                if (((LiveFansInfoModel)param1BluedEntityA.data.get(0)).fans_status == 2)
                  this.a.w.c(); 
              } 
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
          }
          
          public void onUIStart() {
            super.onUIStart();
          }
        }(IRequestHost)w_());
  }
  
  public void a(double paramDouble1, double paramDouble2) {
    if (paramDouble1 >= 0.0D) {
      if (paramDouble2 < 0.0D)
        return; 
      LiveRoomManager.a().a(paramDouble1, paramDouble2);
      Logger.a("drb", new Object[] { "notifyUpdateBeans beans = ", Double.toString(paramDouble1), "-- beans_current_count = ", Double.toString(paramDouble2) });
      this.o.setText(CommonStringUtils.d(String.valueOf(paramDouble2)));
      LiveRoomData liveRoomData = LiveRoomManager.a().h();
      if (liveRoomData != null) {
        if (paramDouble1 >= this.bp)
          liveRoomData.beans_count = paramDouble1; 
        liveRoomData.beans_current_count = paramDouble2;
      } 
      this.bp = paramDouble1;
    } 
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("refreshRecordLevel mLiveRoomData:");
    stringBuilder.append(LiveRoomManager.a().h());
    Log.v("pk", stringBuilder.toString());
    this.aJ.a(paramInt1, paramInt2, paramInt3, paramFloat);
    a(paramInt1);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.ao = paramInt1;
    this.aq = paramInt2;
    this.ap = paramInt3;
    this.ar = paramInt4;
  }
  
  public void a(long paramLong) {
    a(new Runnable(this, paramLong) {
          public void run() {
            this.b.z = this.a;
          }
        });
  }
  
  public void a(Bitmap paramBitmap) {
    LiveRoomInfo.a().a(this.d, this.A, LiveRoomManager.a().h(), paramBitmap, this.bq);
  }
  
  public void a(MotionEvent paramMotionEvent) {
    if (this.ak == 2) {
      AppInfo.n().removeCallbacks(this.as);
      AppInfo.n().postDelayed(this.as, 3000L);
    } 
  }
  
  public void a(EditText paramEditText) {}
  
  public void a(ChattingModel paramChattingModel) {}
  
  public void a(LiveGiftModel paramLiveGiftModel) {}
  
  public void a(LiveHornModel paramLiveHornModel, boolean paramBoolean) {}
  
  public void a(LiveMakeLoverFansModel paramLiveMakeLoverFansModel) {
    this.bl = false;
    this.H.setVisibility(0);
    this.I.setVisibility(0);
    this.O.setVisibility(0);
    this.O.setImageResource(R.drawable.live_make_lover_mic_close);
    this.K.setVisibility(0);
    this.L.setVisibility(0);
    this.N.setVisibility(0);
    this.J.setVisibility(8);
    this.M.setVisibility(8);
    if (paramLiveMakeLoverFansModel != null && paramLiveMakeLoverFansModel.index == 1) {
      this.L.setVisibility(8);
      return;
    } 
    this.L.setVisibility(0);
  }
  
  public void a(LiveRewardModel paramLiveRewardModel) {
    Logger.a("drb", new Object[] { "setGrabRewardData" });
    this.F.a(paramLiveRewardModel, new GrabRewardView.IGrabRewardListener(this) {
        
        });
  }
  
  public void a(LiveRoomData paramLiveRoomData) {
    if (LiveRoomManager.a().h() != null && this.y == LiveRoomManager.a().b()) {
      al();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setData更新弯豆：");
      stringBuilder.append((LiveRoomManager.a().h()).beans_count);
      stringBuilder.append(" ：");
      stringBuilder.append((LiveRoomManager.a().h()).beans_current_count);
      Log.v("beans", stringBuilder.toString());
      a((LiveRoomManager.a().h()).beans_count, (LiveRoomManager.a().h()).beans_current_count);
      this.r.a(LiveRoomManager.a().e(), LiveRoomManager.a().e(), this);
      a((LiveRoomManager.a().h()).badges);
      this.w.c(LiveRoomManager.a().e());
      ai();
      v();
    } 
  }
  
  public void a(LiveRoomUserModel paramLiveRoomUserModel) {}
  
  public void a(LiveZanExtraModel.Danmaku paramDanmaku) {
    if (paramDanmaku != null && paramDanmaku.beans != 0L && paramDanmaku.goods_id != 0L) {
      String str = AvatarUtils.a(1, LiveRoomInfo.a().d());
      ImageFileLoader.a((IRequestHost)w_()).a(str).a();
      this.Y.setVisibility(0);
      this.ac = paramDanmaku.goods_id;
      this.Y.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this, paramDanmaku) {
            public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
              if (param1Boolean) {
                Logger.a("drb", new Object[] { this.b.aG_(), "-打开弹幕" });
                PlayingOnliveBaseModeFragment playingOnliveBaseModeFragment = this.b;
                playingOnliveBaseModeFragment.ab = true;
                String str = String.format(playingOnliveBaseModeFragment.getResources().getString(R.string.LiveVideo_danmaku_hint), new Object[] { Long.valueOf(this.a.beans) });
                this.b.V.setHint(str);
                this.b.W.setEnabled(true);
                LiveRoomConstants.a = 20;
                this.b.Z.setVisibility(0);
                this.b.w.d(8);
                return;
              } 
              Logger.a("drb", new Object[] { this.b.aG_(), "-关闭弹幕" });
              this.b.Z.setVisibility(8);
              if (PlayingOnliveFragment.co == 1) {
                this.b.V.setHint(this.b.getString(R.string.simple_model_danmaku));
                PlayingOnliveBaseModeFragment playingOnliveBaseModeFragment = this.b;
                playingOnliveBaseModeFragment.ab = false;
                LiveRoomConstants.a = 0;
                playingOnliveBaseModeFragment.W.setEnabled(false);
              } else {
                this.b.V.setHint(this.b.getString(R.string.write_text));
                PlayingOnliveBaseModeFragment playingOnliveBaseModeFragment = this.b;
                playingOnliveBaseModeFragment.ab = false;
                LiveRoomConstants.a = 32;
                playingOnliveBaseModeFragment.W.setEnabled(true);
              } 
              PlayingOnliveBaseModeFragment.b(this.b);
            }
          });
      return;
    } 
    this.V.setHint(getString(R.string.write_text));
    this.ab = false;
    LiveRoomConstants.a = 32;
    this.Y.setVisibility(8);
    this.Y.setChecked(false);
  }
  
  public void a(String paramString) {
    if (LiveRoomManager.a().l())
      return; 
    LiveMsgSendManager.a().j();
    LiveRelationshipObserver.a().a(paramString, LiveRoomManager.a().e());
    if (this.w != null) {
      if ("1".equals(paramString) || "3".equals(paramString)) {
        this.w.d(true);
        return;
      } 
      this.w.d(false);
      return;
    } 
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(List<BadgeData> paramList) {}
  
  public void a(boolean paramBoolean) {
    this.at = true;
    this.t.setVisibility(0);
    this.t.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            KeyboardUtils.a((Activity)this.a.getActivity());
            this.a.t.setVisibility(8);
            return true;
          }
        });
    LiveKeyboardObserver.a().b();
    if (PlayingOnliveFragment.co == 0 && !paramBoolean && !this.ab)
      an(); 
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {
    this.bl = paramBoolean1;
    d(paramBoolean2);
  }
  
  public void a_(String paramString) {}
  
  public void a_(List<String> paramList) {
    LiveMsgManager liveMsgManager = this.w;
    if (liveMsgManager != null)
      liveMsgManager.a(paramList); 
  }
  
  public void aa() {
    AppInfo.n().postDelayed(this.ba, 30000L);
  }
  
  public void ab() {
    AppInfo.n().removeCallbacks(this.ba);
  }
  
  public boolean ac() {
    PlayingOnliveFragment playingOnliveFragment = ad();
    return (playingOnliveFragment != null) ? playingOnliveFragment.aF() : false;
  }
  
  public PlayingOnliveFragment ad() {
    return (getParentFragment() instanceof PlayingOnliveFragment) ? (PlayingOnliveFragment)getParentFragment() : null;
  }
  
  public void ae() {
    PopupWindow popupWindow = this.bm;
    if (popupWindow != null && popupWindow.isShowing()) {
      this.bm.dismiss();
      return;
    } 
    int[] arrayOfInt = new int[2];
    this.N.getLocationOnScreen(arrayOfInt);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("offestY = ");
    stringBuilder2.append(arrayOfInt[1]);
    Logger.d("PlayingOnliveBaseModeFragment", new Object[] { stringBuilder2.toString() });
    this.bm = new PopupWindow(this.d);
    this.bm.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    this.bm.setOutsideTouchable(true);
    ImageView imageView = new ImageView(this.d);
    imageView.setImageResource(R.drawable.live_fans_guide_icon);
    imageView.measure(0, 0);
    int i = AppInfo.l - imageView.getMeasuredWidth() - DensityUtils.a(this.d, 10.0F);
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("guideView width = ");
    stringBuilder3.append(i);
    stringBuilder3.append(" ; guideView height = ");
    stringBuilder3.append(imageView.getMeasuredHeight());
    Logger.d("PlayingOnliveBaseModeFragment", new Object[] { stringBuilder3.toString() });
    int j = arrayOfInt[1] - imageView.getMeasuredHeight() - DensityUtils.a(this.d, 5.0F);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("offestY = ");
    stringBuilder1.append(j);
    Logger.d("PlayingOnliveBaseModeFragment", new Object[] { stringBuilder1.toString() });
    this.bm.setContentView((View)imageView);
    this.bm.showAtLocation(this.N, 0, i, j);
    ap();
  }
  
  public void b(int paramInt) {}
  
  public void b(long paramLong) {
    if (paramLong > 99L) {
      this.Z.setBadgeCount("99+");
      return;
    } 
    BackgroundTextView backgroundTextView = this.Z;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("");
    backgroundTextView.setBadgeCount(stringBuilder.toString());
  }
  
  public void b(ChattingModel paramChattingModel) {}
  
  public void b(LiveGiftModel paramLiveGiftModel) {
    a(new Runnable(this, paramLiveGiftModel) {
          public void run() {
            PlayingOnliveBaseModeFragment playingOnliveBaseModeFragment = this.b;
            playingOnliveBaseModeFragment.B = false;
            playingOnliveBaseModeFragment.w.b(this.a);
            this.b.J();
          }
        });
  }
  
  public void b(String paramString) {}
  
  public void b(String paramString1, String paramString2) {
    Logger.a("drb", new Object[] { "notifyRelationshipState = ", aG_(), " -- ", paramString1 });
    if (this.C == null)
      return; 
    if (LiveRoomManager.a().l())
      return; 
    (LiveRoomManager.a().h()).relationship = paramString1;
    if (CommonStringUtils.c(paramString2) == LiveRoomManager.a().d()) {
      if ("1".equals(paramString1) || "3".equals(paramString1)) {
        (LiveRoomManager.a().h()).isFollow = true;
        this.C.setVisibility(8);
        if (LiveFloatManager.a().B()) {
          this.D.setVisibility(8);
        } else {
          this.D.setVisibility(0);
        } 
        this.w.d(true);
        return;
      } 
      (LiveRoomManager.a().h()).isFollow = false;
      if (LiveRoomManager.a().i() != null && (LiveRoomManager.a().i()).fans_status != 0) {
        this.C.setVisibility(8);
        this.D.setVisibility(0);
      } else {
        this.C.setVisibility(0);
        this.D.setVisibility(8);
      } 
      this.w.d(false);
      return;
    } 
  }
  
  public void b(boolean paramBoolean) {
    if (this.A) {
      Logger.a("ddrb", new Object[] { " base setSimpleModelGift = ", Integer.valueOf(PlayingOnliveFragment.co) });
      this.w.c(paramBoolean);
    } 
  }
  
  public void b_(String paramString) {
    if (this.aG != null)
      ImageLoader.a((IRequestHost)w_(), paramString).a(this.aG); 
  }
  
  public void c(int paramInt) {
    this.w.c(paramInt);
  }
  
  public void c(ChattingModel paramChattingModel) {
    this.w.b(paramChattingModel);
  }
  
  public void c(List<LiveZanExtraModel.HotWords> paramList) {
    this.w.b(paramList);
  }
  
  public void c(boolean paramBoolean) {}
  
  public void d() {}
  
  public void d(int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 1)
        return; 
      if (!this.ab) {
        this.V.setHint(getString(R.string.simple_model_danmaku));
        this.W.setEnabled(false);
        LiveRoomConstants.a = 0;
        return;
      } 
      this.W.setEnabled(true);
      LiveRoomConstants.a = 20;
      return;
    } 
    if (!this.ab) {
      this.V.setHint(getString(R.string.write_text));
      this.W.setEnabled(true);
      LiveRoomConstants.a = 32;
    } 
  }
  
  public void d(boolean paramBoolean) {
    int i;
    ImageView imageView = this.O;
    if (this.bl) {
      i = R.drawable.live_make_lover_mic_open;
    } else {
      i = R.drawable.live_make_lover_mic_close;
    } 
    imageView.setImageResource(i);
    if (paramBoolean) {
      if (this.bl) {
        i = R.string.live_make_lover_mic_close;
      } else {
        i = R.string.live_make_lover_mic_open;
      } 
      AppMethods.d(i);
    } 
    LiveRefreshUIObserver.a().a(this.bl);
  }
  
  public void e() {}
  
  public void e(int paramInt) {
    Logger.a("drb", new Object[] { "setBottomLayoutVisible = ", Integer.valueOf(paramInt) });
    int i = this.ak;
    if (i != 3) {
      if (i == 4)
        return; 
      Logger.a("drb", new Object[] { "setBottomLayoutVisible ============= " });
      this.aa.setVisibility(paramInt);
    } 
  }
  
  public void e(String paramString) {}
  
  public void f(int paramInt) {
    this.U.setVisibility(paramInt);
  }
  
  public void f(String paramString) {}
  
  public void g(int paramInt) {
    Log.i("xpp", "updateLiveFansLevel");
    if (LiveRoomManager.a().i() != null)
      (LiveRoomManager.a().i()).level = paramInt; 
    if (this.w != null && PlayingOnliveFragment.co == 0 && !LiveFloatManager.a().B()) {
      Log.i("xpp", "refreshLiveMsgList");
      this.w.d();
    } 
  }
  
  public boolean j() {
    return false;
  }
  
  protected boolean k() {
    return true;
  }
  
  public void l() {
    if (getActivity() instanceof BaseFragmentActivity)
      ((BaseFragmentActivity)getActivity()).a((BaseFragmentActivity.IOnBackPressedListener)this); 
  }
  
  public void m() {
    this.am = this.e.findViewById(R.id.header_lay);
    this.an = (LinearLayout)this.e.findViewById(R.id.bottom_lay);
    this.f = (ViewGroup)this.e.findViewById(R.id.live_top_root);
    this.h = (TextView)this.e.findViewById(R.id.name_view);
    this.g = this.e.findViewById(R.id.simple_model_name_left);
    this.i = (Chronometer)this.e.findViewById(R.id.chronometer);
    this.j = (ViewGroup)this.e.findViewById(R.id.chronometer_layout);
    this.k = (FrameLayout)this.e.findViewById(R.id.live_header_layout);
    this.l = (ImageView)this.e.findViewById(R.id.header_view);
    this.m = (ViewGroup)this.e.findViewById(R.id.onlive_count_layout);
    this.n = (TextView)this.e.findViewById(R.id.onlive_all_count);
    this.o = (TextView)this.e.findViewById(R.id.onlive_current_beans);
    this.p = (ImageView)this.e.findViewById(R.id.close_btn);
    this.q = (LiveViewerListView)this.e.findViewById(R.id.live_viewer);
    this.r = (MedalView)this.e.findViewById(R.id.medal_view);
    this.s = (HornView)this.e.findViewById(R.id.horn_view);
    this.t = this.e.findViewById(R.id.keyboard_view);
    this.u = (ImageView)this.e.findViewById(R.id.live_zan_view);
    this.C = (ImageView)this.e.findViewById(R.id.live_follow_btn);
    this.D = (ImageView)this.e.findViewById(R.id.live_fans_btn);
    this.E = (ViewGroup)this.e.findViewById(R.id.live_rank_btn);
    this.F = (GrabRewardView)this.e.findViewById(R.id.grab_reward_view);
    this.v = (FrameLayout)this.e.findViewById(R.id.fl_liang);
    this.P = (ViewGroup)this.e.findViewById(R.id.chat_view);
    this.Q = (ImageView)this.e.findViewById(R.id.share_view);
    this.bk = this.e.findViewById(R.id.task_view);
    this.R = (ImageView)this.e.findViewById(R.id.lucky_turning);
    ag();
    this.T = (ImageView)this.e.findViewById(R.id.live_gift_view);
    this.aG = (ImageView)this.e.findViewById(R.id.top_up_view);
    this.U = this.e.findViewById(R.id.live_msg_edit);
    this.W = (TextView)this.e.findViewById(R.id.live_msg_send_to);
    this.X = (ImageView)this.e.findViewById(R.id.live_msg_send_emotion);
    this.V = (EditText)this.e.findViewById(R.id.live_msg_send_edit);
    this.V.setFocusableInTouchMode(false);
    this.Z = (BackgroundTextView)this.e.findViewById(R.id.danmaku_count_view);
    this.aa = (ViewGroup)this.e.findViewById(R.id.bottom_layout);
    this.S = (BadgeView)this.e.findViewById(R.id.approach_gift_view);
    this.Y = (ToggleButton)this.e.findViewById(R.id.toggle_danmaku_btn);
    this.G = this.e.findViewById(R.id.ll_make_lover_btn);
    this.H = this.e.findViewById(R.id.iv_make_lover_hold_off);
    this.I = this.e.findViewById(R.id.iv_make_lover_keyboard);
    this.J = this.e.findViewById(R.id.iv_make_lover_share);
    this.O = (ImageView)this.e.findViewById(R.id.iv_make_lover_mic);
    this.K = this.e.findViewById(R.id.iv_make_lover_bao_zhao);
    this.L = this.e.findViewById(R.id.iv_make_lover_mie_deng);
    this.M = this.e.findViewById(R.id.iv_make_lover_top_up);
    this.N = this.e.findViewById(R.id.iv_make_lover_gift);
    this.af = (ImageView)this.e.findViewById(R.id.switch_horizontal_view);
    this.ag = (ImageView)this.e.findViewById(R.id.switch_vertical_view);
    this.ah = (ImageView)this.e.findViewById(R.id.switch_clear_view);
    this.ai = (ImageView)this.e.findViewById(R.id.switch_normal_view);
    this.aj = (ImageView)this.e.findViewById(R.id.float_window_view);
    this.bc = (ShimmerTextView)this.e.findViewById(R.id.say_something_view);
    this.be = this.e.findViewById(R.id.say_something_icon_view);
    this.bf = (ImageView)this.e.findViewById(R.id.live_chat_light);
    this.bg = (ImageView)this.e.findViewById(R.id.no_switch_horizontal_view);
    this.bh = (ImageView)this.e.findViewById(R.id.no_switch_vertical_view);
    this.bb = (VolumeBrightnessView)this.e.findViewById(R.id.volume_brightness_view);
    this.au = (FrameLayout)this.e.findViewById(R.id.live_window_click_layout);
    this.av = this.e.findViewById(R.id.live_window_1_click_view);
    this.aw = this.e.findViewById(R.id.live_window_2_click_view);
    this.ax = this.e.findViewById(R.id.live_window_3_click_view);
    this.ay = this.e.findViewById(R.id.live_window_4_click_view);
    this.az = this.e.findViewById(R.id.live_window_5_click_view);
    this.aA = this.e.findViewById(R.id.live_window_6_click_view);
    this.aB = this.e.findViewById(R.id.ll_pk_banner_click_view);
    this.aC = this.e.findViewById(R.id.pk_banner_left);
    this.aD = this.e.findViewById(R.id.pk_banner_right);
    this.aE = (LinearLayout)this.e.findViewById(R.id.live_pk_rank);
    this.aF = (ImageView)this.e.findViewById(R.id.live_pk_rank_icon);
    this.aH = (LinearLayout)this.e.findViewById(R.id.live_anchor_layout);
    this.aI = (ImageView)this.e.findViewById(R.id.header_level_bg);
    this.aJ = (LiveRecordLevelView)this.e.findViewById(R.id.live_record_relevel_view);
    this.aK = this.e.findViewById(R.id.ll_liang);
    this.aL = (ImageView)this.e.findViewById(R.id.iv_liang);
    this.aM = (TextView)this.e.findViewById(R.id.tv_liang_id);
    this.aN = (ImageView)this.e.findViewById(R.id.liang_enter_view);
    if (!this.al && !LiveFloatManager.a().B()) {
      this.aN.setVisibility(0);
      ImageLoader.c((IRequestHost)w_(), "live_liang_enter_anim.png").d((int)this.y).e(-1).a(this.aN);
    } else {
      this.aN.setVisibility(8);
    } 
    this.bi = this.e.findViewById(R.id.live_report);
    this.bi.setOnClickListener(this);
    this.aQ = (LiveRankingButtonView)this.e.findViewById(R.id.ranking_button_view);
    this.F.a(this);
    y();
    this.i.setText("00:00:00");
    this.S.a(9, Color.parseColor("#ffffff"));
    this.Z.a(9, Color.parseColor("#abd2ff"));
    if (!"en".equals(BlueAppLocal.a())) {
      ViewGroup.LayoutParams layoutParams = this.Y.getLayoutParams();
      layoutParams.width = DensityUtils.a(this.d, 60.0F);
      this.Y.setLayoutParams(layoutParams);
    } 
    this.p.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.i.setOnChronometerTickListener(this);
    this.C.setOnClickListener(this);
    this.D.setOnClickListener(this);
    this.E.setOnClickListener(this);
    this.P.setOnClickListener(this);
    this.Q.setOnClickListener(this);
    this.R.setOnClickListener(this);
    this.T.setOnClickListener(this);
    this.W.setOnClickListener(this);
    this.X.setOnClickListener(this);
    this.V.addTextChangedListener(this.aS);
    this.aN.setOnClickListener(this);
    this.af.setOnClickListener(this);
    this.ag.setOnClickListener(this);
    this.ah.setOnClickListener(this);
    this.ai.setOnClickListener(this);
    this.aj.setOnClickListener(this);
    this.U.setOnClickListener(this);
    this.u.setOnTouchListener(this);
    this.av.setOnClickListener(this);
    this.aw.setOnClickListener(this);
    this.ax.setOnClickListener(this);
    this.ay.setOnClickListener(this);
    this.az.setOnClickListener(this);
    this.aA.setOnClickListener(this);
    this.av.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return this.a.aU.onTouchEvent(param1MotionEvent);
          }
        });
    this.aw.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return this.a.aV.onTouchEvent(param1MotionEvent);
          }
        });
    this.ax.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return this.a.aW.onTouchEvent(param1MotionEvent);
          }
        });
    this.ay.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return this.a.aX.onTouchEvent(param1MotionEvent);
          }
        });
    this.az.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return this.a.aY.onTouchEvent(param1MotionEvent);
          }
        });
    this.aA.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return this.a.aZ.onTouchEvent(param1MotionEvent);
          }
        });
    this.aC.setOnClickListener(this);
    this.aD.setOnClickListener(this);
    this.aE.setOnClickListener(this);
    this.aG.setOnClickListener(this);
    this.H.setOnClickListener(this);
    this.I.setOnClickListener(this);
    this.J.setOnClickListener(this);
    this.O.setOnClickListener(this);
    this.K.setOnClickListener(this);
    this.L.setOnClickListener(this);
    this.M.setOnClickListener(this);
    this.N.setOnClickListener(this);
    aj();
    ah();
    F();
    E();
    G_();
    if (LiveGiftManager.a().b() != null) {
      a((LiveGiftManager.a().b()).danmu);
      b((LiveGiftManager.a().b()).danmu_count);
    } 
  }
  
  public void o() {
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, AppInfo.l / 2 / 3 * 4);
    layoutParams.topMargin = PlayingMakeFriendManager.c;
    this.aB.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.aB.setVisibility(0);
  }
  
  public void onChronometerTick(Chronometer paramChronometer) {
    this.z++;
    paramChronometer.setText(LiveTimeAndDateUtils.a(this.z, true));
    LiveRefreshUIObserver.a().a(this.z);
  }
  
  public void onClick(View paramView) {
    LiveRoomData liveRoomData3;
    LogData logData;
    LiveGiftModel liveGiftModel;
    LiveRoomData liveRoomData2;
    PlayingOnliveFragment playingOnliveFragment;
    LiveSelectPhotoDialogFragment liveSelectPhotoDialogFragment;
    LiveRoomData liveRoomData1;
    Bundle bundle;
    if (paramView.getId() == R.id.close_btn) {
      LiveRefreshUIObserver.a().p();
      return;
    } 
    if (paramView.getId() == R.id.live_follow_btn) {
      liveRoomData3 = LiveRoomManager.a().h();
      if (liveRoomData3 != null)
        EventTrackLive.a(LiveProtos.Event.USER_ANCHOR_FOLLOW_BTN_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e(), liveRoomData3.liveFrom, liveRoomData3.recommendType, liveRoomData3.livePosition); 
      P();
      InstantLog.a("live_followed");
      return;
    } 
    int i = liveRoomData3.getId();
    int j = R.id.header_view;
    boolean bool = false;
    if (i == j) {
      if (LiveRoomManager.a().l())
        return; 
      this.w.a(LiveRoomManager.a().e());
      if (this.r.getVisibility() == 0)
        bool = true; 
      Logger.a("drb", new Object[] { "media = ", Boolean.valueOf(bool) });
      return;
    } 
    if (liveRoomData3.getId() == R.id.live_rank_btn) {
      LiveRefreshUIObserver.a().j();
      return;
    } 
    if (liveRoomData3.getId() == R.id.chat_view) {
      if (getActivity() == null)
        return; 
      am();
      D();
      return;
    } 
    if (liveRoomData3.getId() == R.id.live_gift_view) {
      if (LiveRoomManager.a().h() != null)
        EventTrackLive.a(LiveProtos.Event.GUEST_USER_GIFT_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e()); 
      LiveRefreshUIObserver.a().i();
      return;
    } 
    if (liveRoomData3.getId() == R.id.switch_normal_view) {
      this.ae.a();
      return;
    } 
    if (liveRoomData3.getId() == R.id.switch_clear_view) {
      this.ae.d();
      logData = new LogData();
      logData.D = "live_change_to_min";
      logData.n = String.valueOf(this.y);
      InstantLog.a(logData);
      return;
    } 
    if (logData.getId() == R.id.switch_vertical_view) {
      if (this.bh.getVisibility() == 0)
        return; 
      AppInfo.n().removeCallbacks(this.as);
      getActivity().setRequestedOrientation(1);
      logData = new LogData();
      logData.D = "live_change_to_vertical";
      logData.n = String.valueOf(this.y);
      logData.k = String.valueOf(0);
      InstantLog.a(logData);
      return;
    } 
    if (logData.getId() == R.id.switch_horizontal_view) {
      if (this.bg.getVisibility() == 0)
        return; 
      getActivity().setRequestedOrientation(0);
      logData = new LogData();
      logData.D = "live_change_to_horizontal";
      logData.n = String.valueOf(this.y);
      logData.k = String.valueOf(0);
      InstantLog.a(logData);
      return;
    } 
    if (logData.getId() == R.id.float_window_view) {
      LiveRefreshUIObserver.a().b(true);
      return;
    } 
    if (logData.getId() == R.id.share_view) {
      if (LiveRoomManager.a().h() != null)
        EventTrackLive.a(LiveProtos.Event.USER_SHARE_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e()); 
      Y();
      return;
    } 
    if (logData.getId() == R.id.task_view) {
      E_();
      return;
    } 
    if (logData.getId() == R.id.live_msg_send_to) {
      liveRoomData2 = LiveRoomManager.a().h();
      if (liveRoomData2 != null)
        EventTrackLive.a(LiveProtos.Event.LIVE_USER_MSG_SEND, LiveRoomManager.a().c(), LiveRoomManager.a().e(), liveRoomData2.liveFrom, liveRoomData2.recommendType, liveRoomData2.livePosition); 
      if (this.ab) {
        if (TextUtils.isEmpty(this.V.getText().toString())) {
          AppMethods.d(R.string.chat_send_alert);
          return;
        } 
        if (LiveRoomManager.a().l())
          return; 
        this.W.setEnabled(false);
        liveGiftModel = new LiveGiftModel();
        liveGiftModel.contents = CommonStringUtils.f(this.V.getText().toString());
        liveGiftModel.goods_id = String.valueOf(this.ac);
        LiveGiftPayTools.a().a(this.d, this.x, this.y, (IRequestHost)w_(), liveGiftModel, LiveRoomManager.a().e(), "", 1, new LiveGiftPayTools.BackGiftStatusListener(this) {
              public void a() {
                LiveRefreshUIObserver.a().b(true);
              }
              
              public void a(LiveGiftModel param1LiveGiftModel1, LiveGiftModel param1LiveGiftModel2, List<LiveGiftModel> param1List) {
                AppInfo.n().post(new Runnable(this, param1LiveGiftModel2, param1LiveGiftModel1) {
                      public void run() {
                        this.c.a.W.setEnabled(true);
                        if (this.a.sendGiftStatus == 3) {
                          String str = LiveRoomInfo.a().f();
                          int i = LiveRoomInfo.a().r();
                          ChattingModel chattingModel = new ChattingModel();
                          chattingModel.fromId = Long.valueOf(str).longValue();
                          chattingModel.fromVBadge = i;
                          chattingModel.fromAvatar = LiveRoomInfo.a().d();
                          chattingModel.fromNickName = LiveRoomInfo.a().c();
                          chattingModel.msgContent = this.b.contents;
                          chattingModel.msgType = 37;
                          chattingModel.fromRichLevel = LiveRoomInfo.a().q();
                          if (LiveFloatManager.a().w())
                            chattingModel.fromLiveManager = 1; 
                          LiveSetDataObserver.a().b(chattingModel);
                          this.c.a.V.setText("");
                          LiveRefreshUIObserver.a().o();
                          this.c.a.b(this.a.danmu_count);
                        } 
                      }
                    });
              }
            });
        return;
      } 
      LiveSetDataObserver.a().a(this.V);
      return;
    } 
    if (liveGiftModel.getId() == R.id.top_up_view) {
      EventTrackLive.a(LiveProtos.Event.LIVE_RECHARGE_BTN_CLICK);
      liveRoomData2 = LiveRoomManager.a().h();
      if (liveRoomData2 != null)
        EventTrackLive.a(LiveProtos.Event.USER_RECHARGE_CLICK, String.valueOf(liveRoomData2.lid), LiveRoomManager.a().e(), liveRoomData2.liveFrom, liveRoomData2.recommendType, liveRoomData2.livePosition); 
      LiveRefreshUIObserver.a().d();
      return;
    } 
    if (liveRoomData2.getId() == R.id.lucky_turning) {
      LiveRefreshUIObserver.a().q();
      return;
    } 
    if (liveRoomData2.getId() == R.id.live_report) {
      this.w.m();
      return;
    } 
    if (liveRoomData2.getId() == R.id.live_fans_btn) {
      LiveRefreshUIObserver.a().k();
      return;
    } 
    if (liveRoomData2.getId() == R.id.iv_make_lover_hold_off) {
      if (LiveRoomManager.a().h() != null)
        EventTrackLive.a(LiveProtos.Event.GUEST_HANG_UP_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e()); 
      LiveRefreshUIObserver.a().f();
      return;
    } 
    if (liveRoomData2.getId() == R.id.iv_make_lover_keyboard) {
      if (getActivity() == null)
        return; 
      if (LiveRoomManager.a().h() != null)
        EventTrackLive.a(LiveProtos.Event.GUEST_USER_KEYBOARD_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e()); 
      am();
      return;
    } 
    if (liveRoomData2.getId() == R.id.iv_make_lover_share) {
      if (LiveRoomManager.a().h() != null)
        EventTrackLive.a(LiveProtos.Event.USER_SHARE_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e()); 
      Y();
      return;
    } 
    if (liveRoomData2.getId() == R.id.iv_make_lover_mic) {
      playingOnliveFragment = ad();
      if (playingOnliveFragment != null && playingOnliveFragment.bM.d()) {
        AppMethods.d(R.string.live_make_lover_open_mic_tip);
        return;
      } 
      if (LiveRoomManager.a().h() != null)
        EventTrackLive.b(LiveProtos.Event.GUEST_CLOSE_MIKE_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e(), this.bl); 
      this.bl ^= 0x1;
      if (LiveRoomManager.a().h() != null)
        EventTrackLive.b(LiveProtos.Event.GUEST_CLOSE_MIKE_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e(), this.bl); 
      d(true);
      return;
    } 
    if (playingOnliveFragment.getId() == R.id.iv_make_lover_bao_zhao) {
      if (LiveRoomManager.a().h() != null)
        EventTrackLive.a(LiveProtos.Event.GUEST_SHOW_PHOTO_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e()); 
      liveSelectPhotoDialogFragment = new LiveSelectPhotoDialogFragment();
      liveSelectPhotoDialogFragment.a(new LiveBaseDialogFragment.IDialogEvent<LiveMakeLoverFansModel>(this) {
            public void a() {
              this.a.l();
            }
            
            public void a(LiveMakeLoverFansModel param1LiveMakeLoverFansModel) {
              if (param1LiveMakeLoverFansModel == null)
                return; 
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("onOkDialog result = ");
              stringBuilder.append(param1LiveMakeLoverFansModel.avatar);
              stringBuilder.append("  : ");
              stringBuilder.append(param1LiveMakeLoverFansModel.pic);
              Logger.d("PlayingOnliveBaseModeFragment", new Object[] { stringBuilder.toString() });
              LiveRefreshUIObserver.a().a(param1LiveMakeLoverFansModel.avatar, param1LiveMakeLoverFansModel.pic);
            }
          });
      liveSelectPhotoDialogFragment.show(getFragmentManager(), "select_photo");
      return;
    } 
    if (liveSelectPhotoDialogFragment.getId() == R.id.iv_make_lover_mie_deng) {
      if (LiveRoomManager.a().h() != null)
        EventTrackLive.a(LiveProtos.Event.GUEST_LIGHT_OFF_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e()); 
      LiveRefreshUIObserver.a().g();
      return;
    } 
    if (liveSelectPhotoDialogFragment.getId() == R.id.iv_make_lover_top_up) {
      EventTrackLive.a(LiveProtos.Event.LIVE_RECHARGE_BTN_CLICK);
      liveRoomData1 = LiveRoomManager.a().h();
      if (liveRoomData1 != null)
        EventTrackLive.a(LiveProtos.Event.USER_RECHARGE_CLICK, String.valueOf(liveRoomData1.lid), LiveRoomManager.a().e(), liveRoomData1.liveFrom, liveRoomData1.recommendType, liveRoomData1.livePosition); 
      LiveRefreshUIObserver.a().d();
      return;
    } 
    if (liveRoomData1.getId() == R.id.iv_make_lover_gift) {
      if (LiveRoomManager.a().h() != null)
        EventTrackLive.a(LiveProtos.Event.GUEST_USER_GIFT_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e()); 
      LiveRefreshUIObserver.a().i();
      return;
    } 
    if (liveRoomData1.getId() == R.id.liang_enter_view) {
      if (LiveRoomManager.a().h() != null)
        EventTrackLive.a(LiveProtos.Event.BETTER_ID_USER_POP_BATTER_CLICK); 
      LiveLiangWebDialogFragment liveLiangWebDialogFragment = this.bn;
      if (liveLiangWebDialogFragment != null && liveLiangWebDialogFragment.isVisible())
        return; 
      this.bn = new LiveLiangWebDialogFragment();
      this.bn.a(new LiveLiangWebDialogFragment.ILiveWebDialog(this) {
            public void a() {}
            
            public void b() {
              ThreadManager.a().a(new ThreadExecutor(this, "share") {
                    public void execute() {
                      String str = BitmapUtils.a(BitmapFactory.decodeResource(AppInfo.d().getResources(), R.drawable.live_liang_share_icon), true);
                      AppInfo.n().post(new Runnable(this, str) {
                            public void run() {
                              LiveRoomInfo.a().a(this.b.a.a.d, this.a, LiveRoomInfo.a().E(), AppInfo.d().getString(R.string.live_id_web_share_title), AppInfo.d().getString(R.string.live_id_web_share_text));
                            }
                          });
                    }
                  });
            }
          });
      bundle = new Bundle();
      bundle.putInt("flag", 0);
      this.bn.setArguments(bundle);
      this.bn.show(getFragmentManager(), "webLiangDialog");
      return;
    } 
    if (bundle.getId() == R.id.pk_banner_left) {
      LiveRefreshUIObserver.a().d(true);
      return;
    } 
    if (bundle.getId() == R.id.pk_banner_right)
      LiveRefreshUIObserver.a().d(false); 
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    int i = paramConfiguration.orientation;
    if (i != 1) {
      if (i == 2) {
        Logger.a("drb", new Object[] { "切换为横屏 -- " });
        this.A = true;
        this.ae.a();
      } 
    } else {
      Logger.a("drb", new Object[] { "切换为竖屏 -- " });
      this.A = false;
      this.ae.b();
    } 
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    if (LiveRoomManager.a().h() != null)
      this.y = LiveRoomManager.a().b(); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.aP = DialogUtils.a((Context)getActivity());
    this.A = LiveFloatManager.a().B();
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(R.layout.fragment_onlive_base_mode, paramViewGroup, false);
      this.ae = (IScreenManager)new PlayingModelManager(this);
      af();
      ak();
      BeansRefreshObserver.a().a(this);
      LiveSetDataObserver.a().a(this);
      PlayGifObserver.a().a(this);
      LiveSysNetworkObserver.a().a(this);
      LiveRelationshipObserver.a().a(this);
      LiveFansObserver.a().a(this);
      ((PlayingOnliveActivity)getActivity()).a(this);
      Logger.a("drb", new Object[] { aG_(), "++++++++++++ onCreateView ++++++++++++" });
      a(LiveRoomManager.a().h());
      if (ac() && this.G.getVisibility() != 0)
        r(); 
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
    BeansRefreshObserver.a().b(this);
    LiveSetDataObserver.a().b(this);
    PlayGifObserver.a().b(this);
    LiveSysNetworkObserver.a().b(this);
    LiveRelationshipObserver.a().b(this);
    LiveFansObserver.a().b(this);
    ((PlayingOnliveActivity)getActivity()).b(this);
    this.w.b();
    D();
    LiveRankingButtonView liveRankingButtonView = this.aQ;
    if (liveRankingButtonView != null)
      liveRankingButtonView.a(); 
    LiveRecordLevelView liveRecordLevelView = this.aJ;
    if (liveRecordLevelView != null)
      liveRecordLevelView.c(); 
    PopupWindow popupWindow = this.bm;
    if (popupWindow != null && popupWindow.isShowing())
      this.bm.dismiss(); 
    CountDownTimer countDownTimer = this.br;
    if (countDownTimer != null)
      countDownTimer.cancel(); 
    LiveLiangWebDialogFragment liveLiangWebDialogFragment = this.bn;
    if (liveLiangWebDialogFragment != null) {
      Dialog dialog = liveLiangWebDialogFragment.getDialog();
      if (dialog != null && dialog.isShowing())
        this.bn.dismiss(); 
    } 
    Logger.a("drb", new Object[] { aG_(), "------------PlayingOnliveBaseModeFragment onDestroy-----------" });
    Logger.a("rrb", new Object[] { aG_(), " onDestroy -- liveMsgManager = ", this.w });
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    this.aT.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void p() {
    this.aB.setVisibility(8);
  }
  
  public void q() {
    int i = PlayingMakeLoverManager.b;
    int j = PlayingMakeLoverManager.c;
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-1, j * 2);
    layoutParams1.setMargins(0, PlayingMakeLoverManager.e, 0, 0);
    this.au.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    layoutParams1 = new FrameLayout.LayoutParams(i, j);
    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i, j);
    layoutParams2.leftMargin = i;
    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i, j);
    int k = i * 2;
    layoutParams3.leftMargin = k;
    FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i, j);
    layoutParams4.topMargin = j;
    FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(i, j);
    layoutParams5.leftMargin = i;
    layoutParams5.topMargin = j;
    FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(i, j);
    layoutParams6.leftMargin = k;
    layoutParams6.topMargin = j;
    this.av.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.aw.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.ax.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    this.ay.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
    this.az.setLayoutParams((ViewGroup.LayoutParams)layoutParams5);
    this.aA.setLayoutParams((ViewGroup.LayoutParams)layoutParams6);
    this.au.setVisibility(0);
    this.av.setVisibility(0);
    this.aw.setVisibility(0);
    this.ax.setVisibility(0);
    this.ay.setVisibility(0);
    this.az.setVisibility(0);
    this.aA.setVisibility(0);
  }
  
  public void r() {
    W();
    q();
  }
  
  public void s() {
    this.H.setVisibility(8);
    this.O.setVisibility(8);
    this.K.setVisibility(8);
    this.L.setVisibility(8);
    this.I.setVisibility(0);
    this.J.setVisibility(0);
    this.M.setVisibility(0);
    this.N.setVisibility(0);
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    this.aR = paramBoolean;
    if (this.aR) {
      LiveEventBus.get("live_fans_added", String.class).observeForever(this.bo);
      return;
    } 
    LiveEventBus.get("live_fans_added", String.class).removeObserver(this.bo);
  }
  
  public void v() {
    if (LiveRoomManager.a().h() == null)
      return; 
    int i = (LiveRoomManager.a().h()).level;
    int j = (LiveRoomManager.a().h()).next_level;
    float f1 = (LiveRoomManager.a().h()).percent;
    float f2 = CommonStringUtils.b((LiveRoomManager.a().h()).gap_exp);
    a(i, j, (int)f1, f2);
  }
  
  public void x() {}
  
  public void y() {
    if (LiveRoomInfo.a().u()) {
      this.j.setVisibility(0);
      return;
    } 
    this.j.setVisibility(8);
  }
  
  public void z() {
    this.j.setVisibility(8);
  }
  
  public class SimpleScreen implements Runnable {
    public SimpleScreen(PlayingOnliveBaseModeFragment this$0) {}
    
    public void run() {
      if (this.a.ae != null && LiveFloatManager.a().B() && this.a.ak != 4) {
        this.a.ae.c();
        LogData logData = new LogData();
        logData.D = "live_change_to_brief";
        logData.n = String.valueOf(this.a.y);
        InstantLog.a(logData);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\PlayingOnliveBaseModeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */