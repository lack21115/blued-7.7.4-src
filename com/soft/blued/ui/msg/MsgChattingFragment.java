package com.soft.blued.ui.msg;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.listener.RetractionListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.SessionProfileModel;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinObserver;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.activity.keyboardpage.SwitchPanelRelativeLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.CustomDialog;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.common.utils.AnimationUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.media.audio.audio_manager.BLAudioManager;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.das.message.MessageProtos;
import com.blued.das.profile.PersonalProfileProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.constant.ChatConstants;
import com.soft.blued.customview.RiskyMsgDeletedHint;
import com.soft.blued.customview.smartrefresh.BluedRefreshView;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.emoticon.manager.EmotionManager;
import com.soft.blued.emoticon.manager.EmotionPackListener;
import com.soft.blued.emoticon.model.EmoticonModel;
import com.soft.blued.emoticon.ui.EmoticonsIndicatorView;
import com.soft.blued.emoticon.ui.EmoticonsPageView;
import com.soft.blued.emoticon.ui.EmoticonsToolBarView;
import com.soft.blued.emoticon.ui.IViewStateListener;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.model.UserInfoBasicModel;
import com.soft.blued.push.PushChecker;
import com.soft.blued.ui.circle.fragment.CircleDetailsFragment;
import com.soft.blued.ui.circle.model.CircleConstants;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.msg.adapter.BaseListAdapter;
import com.soft.blued.ui.msg.adapter.HelloExpressionAdapter;
import com.soft.blued.ui.msg.adapter.MessageChatAdapter;
import com.soft.blued.ui.msg.contract.IMsgChatAdapterCallback;
import com.soft.blued.ui.msg.contract.IMsgChatAdapterOperationCallback;
import com.soft.blued.ui.msg.contract.IMsgChattingView;
import com.soft.blued.ui.msg.contract.IRecentPhotoAdapterCallback;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.controller.tools.IMV4Constant;
import com.soft.blued.ui.msg.controller.tools.IMV4Method;
import com.soft.blued.ui.msg.customview.Emotion;
import com.soft.blued.ui.msg.customview.RecentPhotoView;
import com.soft.blued.ui.msg.customview.RecordButton;
import com.soft.blued.ui.msg.event.FuGiftListEvent;
import com.soft.blued.ui.msg.event.KeepScreenEvent;
import com.soft.blued.ui.msg.event.OpenGiftPackageEvent;
import com.soft.blued.ui.msg.fragment.UserGiftFragment;
import com.soft.blued.ui.msg.manager.GiftPlayer;
import com.soft.blued.ui.msg.manager.UserPagerGiftManager;
import com.soft.blued.ui.msg.model.FuGiftModel;
import com.soft.blued.ui.msg.model.HelloExpressionData;
import com.soft.blued.ui.msg.model.MsgRecentPhotoInfo;
import com.soft.blued.ui.msg.pop.CenterGuidePop;
import com.soft.blued.ui.msg.pop.FuGiftPop;
import com.soft.blued.ui.msg.pop.GiftVoucherHelpPop;
import com.soft.blued.ui.msg.pop.GiftVoucherPop;
import com.soft.blued.ui.msg.pop.UserGiftDialogFragment;
import com.soft.blued.ui.msg.presenter.MsgChattingPresent;
import com.soft.blued.ui.msg.util.ScreenUtils;
import com.soft.blued.ui.msg_group.model.GroupInfoModel;
import com.soft.blued.ui.msg_group.model.GroupMemberModel;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.user.manager.VipBubbleManager;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.AtChooseUserHelper;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.click.SingleClickProxy;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.dialog.BluedAlertDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import skin.support.observe.SkinObservable;

public class MsgChattingFragment extends KeyBoardFragment implements View.OnClickListener, Observer<FuGiftListEvent>, RetractionListener, BluedSkinObserver, EmotionPackListener, IMsgChatAdapterOperationCallback, IMsgChattingView, RecentPhotoView.IRecentPhotoOperationCallback {
  private static final String w = MsgChattingFragment.class.getSimpleName();
  
  private ImageView A;
  
  private ImageView B;
  
  private ImageView C;
  
  private TextView D;
  
  private ImageView E;
  
  private ImageView F;
  
  private TextView G;
  
  private TextView H;
  
  private TextView I;
  
  private SmartRefreshLayout J;
  
  private ListView K;
  
  private MessageChatAdapter L;
  
  private CustomDialog M;
  
  private RecordButton N;
  
  private LinearLayout O;
  
  private ImageView P;
  
  private ImageView Q;
  
  private ImageView R;
  
  private ImageView S;
  
  private View T;
  
  private ImageView U;
  
  private TextView V;
  
  private View W;
  
  private View X;
  
  private View Y;
  
  private View Z;
  
  private RecentPhotoView aA;
  
  private boolean aB;
  
  private boolean aC = false;
  
  private BluedAlertDialog aD;
  
  private ViewStub aE;
  
  private RiskyMsgDeletedHint aF;
  
  private CenterGuidePop aG;
  
  private boolean aH = false;
  
  private View aI;
  
  private ShapeTextView aJ;
  
  private ViewStub aK;
  
  private View aL;
  
  private RiskyMsgDeletedHint aM;
  
  private View aN;
  
  private TextView aO;
  
  private ViewPropertyAnimator aP;
  
  private boolean aQ;
  
  private TextWatcher aR = new TextWatcher(this) {
      private CharSequence b;
      
      private int c;
      
      private int d;
      
      private String e;
      
      private String f;
      
      public void afterTextChanged(Editable param1Editable) {
        try {
          Object object;
          if (!MsgChattingFragment.u(this.a) && param1Editable != null && param1Editable.toString().length() >= MsgChattingFragment.m(this.a))
            ToastUtils.a(this.a.getResources().getString(2131757958)); 
          this.a.o.removeTextChangedListener(MsgChattingFragment.v(this.a));
          this.c = this.a.o.getSelectionStart();
          this.d = this.a.o.getSelectionEnd();
          while (param1Editable.length() > MsgChattingFragment.m(this.a)) {
            param1Editable.delete(this.c - 1, this.d);
            this.c--;
            this.d--;
          } 
          AtChooseUserHelper atChooseUserHelper = MsgChattingFragment.w(this.a);
          if (this.a.t.c()) {
            object = this.a;
          } else {
            object = null;
          } 
          if (!atChooseUserHelper.a(object, this.e, this.f, param1Editable, this.d))
            this.a.o.setSelection(this.c); 
          if (!TextUtils.isEmpty(this.a.o.getText().toString())) {
            MsgChattingFragment.x(this.a).setVisibility(0);
          } else {
            MsgChattingFragment.x(this.a).setVisibility(8);
          } 
          this.a.o.addTextChangedListener(MsgChattingFragment.v(this.a));
          return;
        } catch (Exception exception) {
          exception.printStackTrace();
          return;
        } catch (StackOverflowError stackOverflowError) {
          stackOverflowError.printStackTrace();
          return;
        } 
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
        this.b = param1CharSequence;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(param1CharSequence);
        stringBuilder.append("");
        this.e = stringBuilder.toString();
      }
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(param1CharSequence);
        stringBuilder.append("");
        this.f = stringBuilder.toString();
      }
    };
  
  private View aa;
  
  private View ab;
  
  private TextView ac;
  
  private ImageView ad;
  
  private TextView ae;
  
  private LinearLayout af;
  
  private SwitchPanelRelativeLayout ag;
  
  private View ah;
  
  private TextView ai;
  
  private TextView aj;
  
  private View ak;
  
  private ImageView al;
  
  private TextView am;
  
  private LinearLayout an;
  
  private ImageView ao;
  
  private String ap;
  
  private AtChooseUserHelper aq;
  
  private KeyboardListenLinearLayout ar;
  
  private View as;
  
  private int at = 256;
  
  private EmoticonsPageView au;
  
  private EmoticonsIndicatorView av;
  
  private EmoticonsToolBarView aw;
  
  private Emotion ax;
  
  private View ay;
  
  private boolean az;
  
  public List<ChattingModel> e = new ArrayList<ChattingModel>();
  
  public Dialog f;
  
  public EditText o;
  
  public TextView p;
  
  public TextView q;
  
  public boolean r = false;
  
  public View s;
  
  public MsgChattingPresent t;
  
  public GiftPlayer u;
  
  public Handler v = new MsgHandler((Fragment)this);
  
  private View x;
  
  private Context y;
  
  private View z;
  
  private void X() {
    try {
      if (this.L.g != null && IMV4Constant.b) {
        this.L.h = "";
        this.L.notifyDataSetChanged();
        this.L.g.b();
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private void Y() {
    this.L = new MessageChatAdapter((IMsgChatAdapterCallback)this.t, this, this.e, this.aq, this.aR, this);
    this.K.setAdapter((ListAdapter)this.L);
    SessionSettingModel sessionSettingModel = this.t.ae();
    if (sessionSettingModel != null)
      this.L.a(sessionSettingModel.bubbleThemeId); 
    a(this.t.X(), this.t.e(), this.t.x());
    v();
    a(new Runnable(this) {
          public void run() {
            if (MsgChattingFragment.c(this.a).getCount() == 0)
              this.a.t.af(); 
          }
        },  300L);
  }
  
  private void Z() {
    View view = this.aL;
    if (view != null && view.isShown()) {
      this.aL.setVisibility(8);
      Logger.c(w, new Object[] { "hideHelloExpression=====" });
    } 
  }
  
  private void a(String paramString, short paramShort) {
    if (this.t != null) {
      boolean bool;
      if (TextUtils.isEmpty(paramString)) {
        paramString = this.o.getText().toString();
        paramString = this.aq.b(paramString);
        bool = true;
      } else {
        bool = false;
      } 
      if (TextUtils.isEmpty(StringUtils.k(paramString))) {
        ToastUtils.a(2131755810);
        return;
      } 
      ChattingModel chattingModel = this.t.a(paramShort, paramString);
      if (this.L.getCount() <= 0 && bool)
        this.t.b(chattingModel); 
      this.t.v();
      if (chattingModel == null)
        return; 
      this.t.a(chattingModel, false);
      if (paramShort == 1) {
        this.o.setText("");
        this.P.setVisibility(0);
        this.V.setVisibility(8);
      } 
    } 
  }
  
  private void a(boolean... paramVarArgs) {
    if (!this.aQ) {
      boolean bool;
      if (this.t.c())
        return; 
      this.aQ = true;
      if (paramVarArgs.length > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      a(new Runnable(this) {
            public void run() {
              String str = MsgChattingFragment.W();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("showHelloExpression====");
              stringBuilder.append(MsgChattingFragment.d(this.a).getVisibility());
              Logger.c(str, new Object[] { stringBuilder.toString() });
              if (!this.a.r && MsgChattingFragment.d(this.a).getVisibility() == 8 && MsgChattingFragment.e(this.a) != null && MsgChattingFragment.c(this.a).getCount() == 0) {
                if (MsgChattingFragment.f(this.a) != null)
                  MsgChattingFragment.f(this.a).cancel(); 
                MsgChattingFragment.e(this.a).setVisibility(0);
                MsgChattingFragment.e(this.a).setAlpha(0.0F);
                MsgChattingFragment msgChattingFragment = this.a;
                MsgChattingFragment.a(msgChattingFragment, MsgChattingFragment.e(msgChattingFragment).animate().alpha(1.0F).setDuration(300L));
                MsgChattingFragment.f(this.a).start();
              } 
              MsgChattingFragment.a(this.a, false);
            }
          }bool);
    } 
  }
  
  private void aa() {
    View view = this.ay;
    if (view != null && view.getVisibility() == 0) {
      AnimationUtils.a(this.ay, 400L);
      if (this.t.j() != null)
        BluedPreferences.a((this.t.j()).group_id, System.currentTimeMillis() + (GroupUtil.a * 60 * 1000)); 
    } 
  }
  
  private void ab() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void ac() {
    byte b;
    this.aq = new AtChooseUserHelper(this.y);
    this.f = DialogUtils.a(this.y);
    this.J = (SmartRefreshLayout)this.x.findViewById(2131299239);
    this.J.findViewById(2131297158).setBackgroundColor(0);
    ((BluedRefreshView)this.x.findViewById(2131299615)).setShowText(false);
    this.K = (ListView)this.x.findViewById(2131299180);
    this.K.setTranscriptMode(1);
    this.K.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            if (KeyboardUtils.b((Activity)this.a.getActivity()))
              this.a.u(); 
            return false;
          }
        });
    this.J.a(new OnRefreshListener(this) {
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            if (this.a.t != null) {
              this.a.t.h(true);
              this.a.t.f(false);
            } 
            AppInfo.n().postDelayed(new Runnable(this) {
                  public void run() {
                    if (this.a.a.t != null)
                      this.a.a.t.a(this.a.a.v); 
                  }
                },  200L);
          }
        });
    this.J.a(new OnLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            if (this.a.t != null && (MsgChattingFragment.c(this.a)).a.size() > 0) {
              ChattingModel chattingModel = (MsgChattingFragment.c(this.a)).a.get((MsgChattingFragment.c(this.a)).a.size() - 1);
              if (chattingModel == null)
                return; 
              this.a.t.g(false);
              this.a.t.a(chattingModel.msgId, chattingModel.msgLocalId, this.a.v);
            } 
          }
        });
    this.ao = (ImageView)this.x.findViewById(2131299237);
    this.ao.post(new Runnable(this) {
          public void run() {
            ViewGroup.LayoutParams layoutParams = MsgChattingFragment.i(this.a).getLayoutParams();
            layoutParams.width = ((ViewGroup)MsgChattingFragment.i(this.a).getParent()).getWidth();
            layoutParams.height = ((ViewGroup)MsgChattingFragment.i(this.a).getParent()).getHeight();
            MsgChattingFragment.i(this.a).setLayoutParams(layoutParams);
          }
        });
    this.Q = (ImageView)this.x.findViewById(2131296562);
    this.N = (RecordButton)this.x.findViewById(2131296561);
    this.o = (EditText)this.x.findViewById(2131297015);
    this.o.requestFocus();
    this.o.addTextChangedListener(this.aR);
    this.R = (ImageView)this.x.findViewById(2131296565);
    this.P = (ImageView)this.x.findViewById(2131296572);
    this.S = (ImageView)this.x.findViewById(2131296566);
    this.T = this.x.findViewById(2131297780);
    this.U = (ImageView)this.x.findViewById(2131296568);
    this.V = (TextView)this.x.findViewById(2131299294);
    this.O = (LinearLayout)this.x.findViewById(2131298997);
    this.s = this.x.findViewById(2131296983);
    this.ag = (SwitchPanelRelativeLayout)this.x.findViewById(2131296554);
    this.ag.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131100733));
    this.W = this.x.findViewById(2131298815);
    this.X = this.x.findViewById(2131298812);
    this.Y = this.x.findViewById(2131298816);
    this.Z = this.x.findViewById(2131298814);
    this.aa = this.x.findViewById(2131298817);
    this.ab = this.x.findViewById(2131298813);
    this.ac = (TextView)this.x.findViewById(2131300774);
    this.af = (LinearLayout)this.x.findViewById(2131298833);
    this.ad = (ImageView)this.x.findViewById(2131297873);
    this.ae = (TextView)this.x.findViewById(2131300850);
    this.p = (TextView)this.x.findViewById(2131300680);
    this.q = (TextView)this.x.findViewById(2131300678);
    this.q.setOnClickListener(this);
    this.al = (ImageView)this.x.findViewById(2131297927);
    this.an = (LinearLayout)this.x.findViewById(2131299021);
    this.am = (TextView)this.x.findViewById(2131301113);
    this.am.setText(String.format(getResources().getString(2131758055), new Object[] { String.valueOf(this.t.I()) }));
    int i = TextUtils.isEmpty((BluedConfig.b().h()).link) ^ true;
    this.H = (TextView)this.x.findViewById(2131301402);
    this.I = (TextView)this.x.findViewById(2131301399);
    this.H.setText((BluedConfig.b().h()).text);
    TextView textView = this.I;
    if (i != 0 && !this.t.c()) {
      b = 0;
    } else {
      b = 8;
    } 
    textView.setVisibility(b);
    this.aA = (RecentPhotoView)this.x.findViewById(2131299583);
    this.aA.a((IRequestHost)w_(), this);
    if (this.t.c())
      this.aA.a(); 
    if (PopMenuUtils.a()) {
      this.q.setVisibility(0);
    } else {
      this.q.setVisibility(8);
    } 
    if (this.t.w() == 3) {
      this.ab.setVisibility(0);
      this.Y.setVisibility(8);
      this.aa.setVisibility(8);
      this.p.setVisibility(8);
    } else {
      this.aa.setVisibility(0);
      this.Y.setVisibility(0);
      this.ab.setVisibility(8);
      this.p.setVisibility(8);
    } 
    this.ar = (KeyboardListenLinearLayout)this.x.findViewById(2131297981);
    this.as = this.x.findViewById(2131297985);
    this.aE = (ViewStub)this.x.findViewById(2131300040);
    this.u = new GiftPlayer(this.aE, this.t.f());
    UserPagerGiftManager.a().a(this.u);
    this.as.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            this.a.u();
            return false;
          }
        });
    this.aF = (RiskyMsgDeletedHint)this.x.findViewById(2131299390);
    this.aF.setHintTipsHeight(56);
    this.aF.setHint(getString(2131758047));
    this.aM = (RiskyMsgDeletedHint)this.x.findViewById(2131299831);
    this.aM.setHintTipsHeight(56);
    this.aM.setHint(getString(2131758070));
    this.af.setOnClickListener(this);
    this.V.setOnClickListener(this);
    this.Q.setOnClickListener(this);
    this.R.setOnClickListener(this);
    this.P.setOnClickListener(this);
    if (this.t.c()) {
      this.S.setVisibility(8);
    } else {
      this.S.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this) {
              public void onClick(View param1View) {
                String str1;
                KeyboardUtils.a((Activity)this.a.getActivity());
                if (!TextUtils.isEmpty(BluedConfig.b().F()) && !BluedPreferences.e().contains(BluedConfig.b().F())) {
                  BluedPreferences.e().edit().putBoolean(BluedConfig.b().F(), true).apply();
                  MsgChattingFragment.j(this.a).setVisibility(8);
                } 
                Context context = this.a.getContext();
                ActivityFragmentActive activityFragmentActive = this.a.w_();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.a.t.f());
                String str2 = "";
                stringBuilder.append("");
                String str3 = stringBuilder.toString();
                UserGiftDialogFragment.BuySucceedListener buySucceedListener = new UserGiftDialogFragment.BuySucceedListener(this) {
                    public void a(UserGiftDialogFragment param2UserGiftDialogFragment, GiftGivingOptionForJsonParse param2GiftGivingOptionForJsonParse) {
                      param2UserGiftDialogFragment.dismiss();
                      if (this.a.a.t != null)
                        this.a.a.t.a(param2GiftGivingOptionForJsonParse); 
                    }
                  };
                if (this.a.t.N() == null) {
                  str1 = "0";
                } else {
                  str1 = (this.a.t.N()).relationship;
                } 
                if (this.a.t.N() != null)
                  str2 = (this.a.t.N()).name; 
                UserGiftDialogFragment.a(context, activityFragmentActive, str3, "chat_page_gift", buySucceedListener, str1, str2, new int[0]);
              }
            }));
    } 
    this.U.setOnClickListener(this);
    this.W.setOnClickListener(this);
    this.X.setOnClickListener(this);
    this.Y.setOnClickListener(this);
    this.Z.setOnClickListener(this);
    this.aa.setOnClickListener(this);
    this.ab.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.an.setOnClickListener(this);
    this.ax = new Emotion(this.y);
    EmotionManager.a(this);
    this.au = (EmoticonsPageView)this.s.findViewById(2131301643);
    this.av = (EmoticonsIndicatorView)this.s.findViewById(2131301642);
    this.aw = (EmoticonsToolBarView)this.s.findViewById(2131301644);
    this.aw.setModel(false);
    EmoticonsToolBarView emoticonsToolBarView = this.aw;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.t.f());
    stringBuilder.append("");
    emoticonsToolBarView.setTargetUid(stringBuilder.toString());
    BluedPreferences.d(System.currentTimeMillis());
    this.aw.a((IRequestHost)w_(), EmotionManager.e());
    this.au.a((IRequestHost)w_(), EmotionManager.e());
    this.au.setOnIndicatorListener(new EmoticonsPageView.OnEmoticonsPageViewListener(this) {
          public void a(int param1Int) {
            MsgChattingFragment.k(this.a).a(param1Int);
          }
          
          public void a(int param1Int1, int param1Int2) {
            MsgChattingFragment.k(this.a).a(param1Int1, param1Int2);
          }
          
          public void b(int param1Int) {
            MsgChattingFragment.k(this.a).setIndicatorCount(param1Int);
          }
          
          public void c(int param1Int) {
            MsgChattingFragment.k(this.a).b(param1Int);
          }
        });
    this.au.setIViewListener(new IViewStateListener(this) {
          public void a(EmoticonModel param1EmoticonModel) {
            if (this.a.o != null) {
              KeyEvent keyEvent;
              SpannableString spannableString;
              this.a.o.setFocusable(true);
              this.a.o.setFocusableInTouchMode(true);
              this.a.o.requestFocus();
              if (param1EmoticonModel.eventType == 1L) {
                keyEvent = new KeyEvent(0, 67);
                this.a.o.onKeyDown(67, keyEvent);
                return;
              } 
              if (((EmoticonModel)keyEvent).eventType == 2L)
                return; 
              if (((EmoticonModel)keyEvent).emoticonType == 0) {
                if (((EmoticonModel)keyEvent).emoji != null) {
                  this.a.o.append(((EmoticonModel)keyEvent).emoji.a());
                  return;
                } 
                spannableString = MsgChattingFragment.l(this.a).a(((EmoticonModel)keyEvent).code);
                if (this.a.i.getText().length() + spannableString.length() <= MsgChattingFragment.m(this.a)) {
                  this.a.o.getText().insert(this.a.o.getSelectionStart(), (CharSequence)spannableString);
                  return;
                } 
              } else {
                MsgChattingFragment msgChattingFragment = this.a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(((EmoticonModel)spannableString).packageCode);
                stringBuilder.append("_");
                stringBuilder.append(((EmoticonModel)spannableString).code);
                msgChattingFragment.a(stringBuilder.toString());
              } 
            } 
          }
          
          public void c(int param1Int) {
            MsgChattingFragment.a(this.a).setToolBtnSelect(param1Int);
          }
        });
    this.aw.setOnToolBarItemClickListener(new EmoticonsToolBarView.OnToolBarItemClickListener(this) {
          public void a(int param1Int) {
            MsgChattingFragment.b(this.a).setPageSelect(param1Int);
          }
        });
    this.ah = this.x.findViewById(2131299284);
    this.ah.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            Animation animation = AnimationUtils.loadAnimation(MsgChattingFragment.n(this.a), 2130772064);
            animation.setFillAfter(true);
            MsgChattingFragment.o(this.a).startAnimation(animation);
            MsgChattingFragment.o(this.a).setVisibility(8);
          }
        });
    this.ai = (TextView)this.ah.findViewById(2131297590);
    this.ai.setText(this.y.getResources().getText(2131755516));
    this.ak = this.x.findViewById(2131297160);
    this.ay = this.x.findViewById(2131299292);
    this.ay.setOnClickListener(new View.OnClickListener(this, i) {
          public void onClick(View param1View) {
            if (this.b.t.c())
              return; 
            MsgChattingFragment.h(this.b);
            if (this.a) {
              String str = (BluedConfig.b().h()).link;
              WebViewShowInfoFragment.show(MsgChattingFragment.n(this.b), str, -1);
            } 
          }
        });
    this.aj = (TextView)this.x.findViewById(2131301313);
    ae();
    if (!this.t.c() && !TextUtils.isEmpty(BluedConfig.b().F()) && !BluedPreferences.e().contains(BluedConfig.b().F()))
      this.T.setVisibility(0); 
    this.aI = this.x.findViewById(2131296551);
    ad();
    Logger.c(w, new Object[] { "无实体虚拟按键底部加间距" });
    this.aK = (ViewStub)this.x.findViewById(2131300041);
    this.aN = this.x.findViewById(2131297298);
    this.aO = (TextView)this.x.findViewById(2131300845);
  }
  
  private void ad() {
    if (!this.r && this.ag.getVisibility() == 8 && !ScreenUtils.a((Context)getActivity())) {
      this.aI.setVisibility(0);
      Logger.c(w, new Object[] { "showBottomGap" });
    } 
  }
  
  private void ae() {
    this.aB = BluedPreferences.cq();
    this.o.setHorizontallyScrolling(false);
    if (this.aB) {
      this.o.setImeOptions(4);
      this.o.setInputType(262144);
      this.o.setSingleLine(false);
      this.o.setMaxLines(4);
      this.o.setOnEditorActionListener(new -$$Lambda$MsgChattingFragment$CK4sbGcm0D4Z0gz9ndxsdMWrfpw(this));
      return;
    } 
    this.o.setImeOptions(0);
    this.o.setInputType(131072);
    this.o.setSingleLine(false);
    this.o.setMaxLines(4);
  }
  
  private void af() {
    SmartRefreshLayout smartRefreshLayout = this.J;
    if (smartRefreshLayout != null) {
      smartRefreshLayout.g();
      this.J.h();
    } 
  }
  
  private void ag() {
    this.K.setOnScrollListener(new MyOnScrollListener());
    this.N.a = 60;
    AudioChannelManager.e().h();
    this.N.setOnRecordListener(new RecordButton.OnRecordListener(this) {
          String a = "";
          
          private void b() {
            MsgChattingFragment.F(this.b).setBackground(BluedSkinUtils.b(MsgChattingFragment.n(this.b), 2131233927));
            IMV4Constant.a = true;
            BLAudioManager.a(MsgChattingFragment.n(this.b)).c();
            MsgChattingFragment.F(this.b).setText(2131758555);
          }
          
          private void c() {
            MsgChattingFragment.F(this.b).setBackground(BluedSkinUtils.b(MsgChattingFragment.n(this.b), 2131233926));
            IMV4Constant.a = false;
            BLAudioManager.a(MsgChattingFragment.n(this.b)).d();
            MsgChattingFragment.F(this.b).setText(2131758422);
          }
          
          public BaseFragment a() {
            return (BaseFragment)this.b;
          }
          
          public void a(int param1Int) {
            if (this.b.t != null)
              this.b.t.b(this.a, param1Int, 0); 
          }
          
          public void a(MotionEvent param1MotionEvent) {
            MsgChattingFragment.E(this.b);
            LiveFloatManager.a().j();
            b();
            short s = this.b.t.w();
            long l = this.b.t.f();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(System.currentTimeMillis());
            stringBuilder.append("");
            this.a = IMV4Method.a(s, l, stringBuilder.toString());
            Logger.b(MsgChattingFragment.W(), new Object[] { "==recordPath===", this.a });
            MsgChattingFragment.F(this.b).setRecordPath(this.a);
          }
          
          public void b(MotionEvent param1MotionEvent) {
            LiveFloatManager.a().i();
            c();
          }
        });
    this.L.a(Integer.valueOf(2131296727), new BaseListAdapter.onInternalClickListener(this) {
          public void a(View param1View1, View param1View2, Integer param1Integer, Object param1Object) {
            this.a.a(param1View1, param1View2, param1Object);
          }
        });
    LiveEventBus.get("refresh_im_bubble", Void.class).observe((LifecycleOwner)this, new Observer<Void>(this) {
          public void a(Void param1Void) {
            MsgChattingFragment.c(this.a).notifyDataSetChanged();
            if (this.a.t != null && this.a.t.Q())
              MsgChattingFragment.g(this.a).setSelection(MsgChattingFragment.c(this.a).getCount()); 
          }
        });
    LiveEventBus.get("open_gift_package", OpenGiftPackageEvent.class).observe((LifecycleOwner)this, new Observer<OpenGiftPackageEvent>(this) {
          public void a(OpenGiftPackageEvent param1OpenGiftPackageEvent) {
            if (param1OpenGiftPackageEvent.a != null) {
              if (!param1OpenGiftPackageEvent.a.equals(this.a.w_()))
                return; 
              Context context = this.a.getContext();
              ActivityFragmentActive activityFragmentActive = this.a.w_();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(this.a.t.f());
              String str1 = "";
              stringBuilder.append("");
              String str2 = stringBuilder.toString();
              UserGiftDialogFragment.BuySucceedListener buySucceedListener = new UserGiftDialogFragment.BuySucceedListener(this) {
                  public void a(UserGiftDialogFragment param2UserGiftDialogFragment, GiftGivingOptionForJsonParse param2GiftGivingOptionForJsonParse) {
                    param2UserGiftDialogFragment.dismiss();
                    if (this.a.a.t != null)
                      this.a.a.t.a(param2GiftGivingOptionForJsonParse); 
                  }
                };
              String str3 = (this.a.t.N()).relationship;
              if (this.a.t.N() != null)
                str1 = (this.a.t.N()).name; 
              UserGiftDialogFragment.a(context, activityFragmentActive, str2, "chat_page_gift", buySucceedListener, str3, str1, new int[] { 1 });
            } 
          }
        });
    LiveEventBus.get("keep_screen", KeepScreenEvent.class).observe((LifecycleOwner)this, new Observer<KeepScreenEvent>(this) {
          public void a(KeepScreenEvent param1KeepScreenEvent) {
            if (param1KeepScreenEvent.a) {
              this.a.getActivity().getWindow().addFlags(128);
              return;
            } 
            this.a.getActivity().getWindow().clearFlags(128);
          }
        });
    LiveEventBus.get("check_show_hello_expression", Void.class).observe((LifecycleOwner)this, new Observer<Void>(this) {
          public void a(Void param1Void) {
            if (MsgChattingFragment.e(this.a) == null) {
              this.a.t.af();
              return;
            } 
            MsgChattingFragment.a(this.a, new boolean[0]);
          }
        });
    LiveEventBus.get("choose_at_user", GroupMemberModel.class).observe((LifecycleOwner)this, new Observer<GroupMemberModel>(this) {
          public void a(GroupMemberModel param1GroupMemberModel) {
            this.a.a(param1GroupMemberModel.uid, param1GroupMemberModel.name);
          }
        });
    LiveEventBus.get("exit_group", Integer.class).observe((LifecycleOwner)this, new Observer<Integer>(this) {
          public void a(Integer param1Integer) {
            if (this.a.t.j() != null && param1Integer.intValue() == (this.a.t.j()).group_id && this.a.getActivity() != null)
              this.a.getActivity().finish(); 
          }
        });
  }
  
  private void ah() {
    MsgGroupHttpUtils.a((IRequestHost)w_(), String.valueOf(this.t.f()), new BluedUIHttpResponse<BluedEntityA<GroupInfoModel>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<GroupInfoModel> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              GroupInfoModel groupInfoModel = param1BluedEntityA.data.get(0);
              if (groupInfoModel != null) {
                if (groupInfoModel.group_status == 2) {
                  MsgChattingFragment msgChattingFragment = this.a;
                  MsgChattingFragment.a(msgChattingFragment, msgChattingFragment.getString(2131756702));
                } else if (groupInfoModel.group_role == 0) {
                  MsgChattingFragment msgChattingFragment = this.a;
                  MsgChattingFragment.a(msgChattingFragment, msgChattingFragment.getString(2131756693));
                } 
                this.a.t.a(groupInfoModel);
                String str = ChatHelperV4.a().a(groupInfoModel.admin);
                SessionSettingModel sessionSettingModel = this.a.t.G();
                if (sessionSettingModel != null) {
                  if (!StringUtils.e(str))
                    sessionSettingModel.setGroupAdiminIDs(str); 
                  if (groupInfoModel.admin != null && groupInfoModel.admin.size() > 0 && ((GroupMemberModel)groupInfoModel.admin.get(0)).group_role == 1)
                    sessionSettingModel.setGroupCreateId(Long.valueOf(((GroupMemberModel)groupInfoModel.admin.get(0)).uid).longValue()); 
                  ChatManager.getInstance().setSessionSetting(this.a.t.w(), this.a.t.f(), (SessionSettingBaseModel)sessionSettingModel);
                } 
                SessionProfileModel sessionProfileModel = new SessionProfileModel();
                sessionProfileModel.nickname = groupInfoModel.group_title;
                sessionProfileModel.avatar = groupInfoModel.group_cover;
                ChatManager.getInstance().updateSessionInfoData(this.a.t.w(), this.a.t.f(), sessionProfileModel);
                SessionModel sessionModel = this.a.t.H();
                if (sessionModel != null)
                  if (groupInfoModel.group_status == 2 && sessionModel.sessionStatus != 1) {
                    ChatManager.getInstance().updateSesssionStatus(this.a.t.w(), this.a.t.f(), 1);
                  } else if (groupInfoModel.group_status == 1 && sessionModel.sessionStatus == 1) {
                    ChatManager.getInstance().updateSesssionStatus(this.a.t.w(), this.a.t.f(), 0);
                  }  
              } 
              if (this.a.v != null) {
                Message message = new Message();
                message.what = 301;
                message.obj = groupInfoModel;
                this.a.v.sendMessage(message);
              } 
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (param1Int == 40319010) {
              MsgChattingFragment msgChattingFragment = this.a;
              MsgChattingFragment.a(msgChattingFragment, msgChattingFragment.getString(2131756661));
              MsgChattingFragment.G(this.a).setVisibility(4);
              MsgChattingFragment.H(this.a).setVisibility(4);
            } 
            return true;
          }
        });
  }
  
  private void ai() {
    MsgChattingPresent msgChattingPresent = this.t;
    if (msgChattingPresent != null) {
      UserInfoBasicModel userInfoBasicModel = msgChattingPresent.N();
      if (userInfoBasicModel != null) {
        if (userInfoBasicModel.live.longValue() != 0L) {
          this.ak.setVisibility(0);
          this.al.setImageResource(2131232671);
          MessageProtos.Event event = MessageProtos.Event.MSG_LIVE_SHOW;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(userInfoBasicModel.live);
          stringBuilder1.append("");
          String str = stringBuilder1.toString();
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(this.t.f());
          stringBuilder2.append("");
          EventTrackMessage.b(event, str, stringBuilder2.toString());
          this.ak.setOnClickListener(new -$$Lambda$MsgChattingFragment$1swd0Y8h2gLxELz1EScEZPoCflA(this, userInfoBasicModel));
          return;
        } 
        this.ak.setVisibility(8);
        return;
      } 
      this.ak.setVisibility(8);
    } 
  }
  
  private void aj() {
    if (this.t != null) {
      VideoChatDialogFragment videoChatDialogFragment = new VideoChatDialogFragment();
      videoChatDialogFragment.a(this.t.f());
      videoChatDialogFragment.show(getActivity().getSupportFragmentManager(), VideoChatDialogFragment.class.getSimpleName());
    } 
  }
  
  private void ak() {
    MsgChattingPresent msgChattingPresent = this.t;
    if (msgChattingPresent != null && !msgChattingPresent.O() && this.t.H() != null)
      b(false); 
  }
  
  private void al() {
    if (this.ay.getVisibility() == 0)
      aa(); 
    if (this.aF.a())
      this.aF.c(); 
    this.aM.b();
  }
  
  private void b(View paramView1, KeyboardListenLinearLayout paramKeyboardListenLinearLayout, EditText paramEditText, View paramView2, View paramView3, View paramView4) {
    a(paramView1, paramKeyboardListenLinearLayout, paramEditText, paramView2, paramView3, paramView4);
  }
  
  private void b(boolean paramBoolean) {
    MsgChattingPresent msgChattingPresent = this.t;
    if (msgChattingPresent != null) {
      if (!msgChattingPresent.O() && this.L != null && !paramBoolean) {
        this.t.d(true);
        a(new Runnable(this, paramBoolean) {
              public void run() {
                if (this.b.t != null) {
                  if (MsgChattingFragment.c(this.b).getCount() - MsgChattingFragment.g(this.b).getFirstVisiblePosition() < this.b.t.I() && !this.a) {
                    this.b.t.c(true);
                    if (this.b.t.t())
                      this.b.t.a(this.b.t.K()); 
                    MsgChattingFragment.g(this.b).setSelection(MsgChattingFragment.c(this.b).getCount() - 1);
                    TranslateAnimation translateAnimation = new TranslateAnimation(MsgChattingFragment.p(this.b).getMeasuredWidth(), 0.0F, 0.0F, 0.0F);
                    translateAnimation.setAnimationListener(new Animation.AnimationListener(this) {
                          public void onAnimationEnd(Animation param2Animation) {
                            MsgChattingFragment.p(this.a.b).setVisibility(0);
                            MsgChattingFragment.g(this.a.b).setOnScrollListener(new AbsListView.OnScrollListener(this) {
                                  public void onScroll(AbsListView param3AbsListView, int param3Int1, int param3Int2, int param3Int3) {
                                    try {
                                      if (this.a.a.b.t != null && !this.a.a.b.t.L() && this.a.a.b.t.M() && ((ChattingModel)(MsgChattingFragment.c(this.a.a.b)).a.get(param3Int1)).msgId <= this.a.a.b.t.J()) {
                                        this.a.a.b.t.b(true);
                                        MsgChattingFragment.r(this.a.a.b).g();
                                        MsgChattingFragment.r(this.a.a.b).h();
                                        MsgChattingFragment.b(this.a.a.b, true);
                                        return;
                                      } 
                                    } catch (Exception exception) {
                                      exception.printStackTrace();
                                    } 
                                  }
                                  
                                  public void onScrollStateChanged(AbsListView param3AbsListView, int param3Int) {
                                    if (param3Int != 0) {
                                      if (param3Int != 1) {
                                        if (param3Int != 2)
                                          return; 
                                        this.a.a.b.u();
                                        return;
                                      } 
                                    } else if (this.a.a.b.t != null) {
                                      if (this.a.a.b.t.P() && MsgChattingFragment.g(this.a.a.b).getFirstVisiblePosition() != this.a.a.b.t.K())
                                        MsgChattingFragment.g(this.a.a.b).smoothScrollToPosition(this.a.a.b.t.K()); 
                                      if (param3AbsListView.getLastVisiblePosition() == param3AbsListView.getCount() - 1) {
                                        MsgChattingFragment.q(this.a.a.b).setVisibility(8);
                                        this.a.a.b.t.f(true);
                                        return;
                                      } 
                                      this.a.a.b.t.f(false);
                                    } 
                                  }
                                });
                          }
                          
                          public void onAnimationRepeat(Animation param2Animation) {}
                          
                          public void onAnimationStart(Animation param2Animation) {}
                        });
                    translateAnimation.setDuration(500L);
                    MsgChattingFragment.p(this.b).startAnimation((Animation)translateAnimation);
                    return;
                  } 
                  Logger.c(MsgChattingFragment.W(), new Object[] { "checkShowPopNoRead====updateInfo" });
                } 
              }
            }300L);
      } 
      if (this.t.O() && paramBoolean) {
        this.t.e(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0F, this.an.getMeasuredWidth(), 0.0F, 0.0F);
        translateAnimation.setAnimationListener(new Animation.AnimationListener(this) {
              public void onAnimationEnd(Animation param1Animation) {
                if (this.a.t != null)
                  this.a.t.f(false); 
                MsgChattingFragment.g(this.a).setOnScrollListener(new MsgChattingFragment.MyOnScrollListener());
                MsgChattingFragment.p(this.a).setVisibility(8);
                MsgChattingFragment.s(this.a);
              }
              
              public void onAnimationRepeat(Animation param1Animation) {}
              
              public void onAnimationStart(Animation param1Animation) {}
            });
        translateAnimation.setDuration(500L);
        this.an.startAnimation((Animation)translateAnimation);
      } 
    } 
  }
  
  private void c(String paramString) {
    this.aN.setVisibility(0);
    this.aN.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            return true;
          }
        });
    this.aO.setText(paramString);
  }
  
  private void c(List<FuGiftModel> paramList) {
    BluedPreferences.V(true);
    if (paramList == null)
      return; 
    (new XPopup.Builder(getContext())).a(Boolean.valueOf(false)).b(Boolean.valueOf(false)).a((BasePopupView)new FuGiftPop(getContext(), paramList, UserGiftFragment.n, w_())).h();
  }
  
  private void c(boolean paramBoolean) {
    ObjectAnimator objectAnimator;
    if (paramBoolean) {
      objectAnimator = ObjectAnimator.ofFloat(this.P, "rotation", new float[] { 45.0F });
    } else {
      objectAnimator = ObjectAnimator.ofFloat(this.P, "rotation", new float[] { 0.0F });
    } 
    objectAnimator.setDuration(300L);
    objectAnimator.start();
  }
  
  public void A() {
    if (this.L.getCount() != 0 && this.L.getCount() <= 2)
      this.t.ad(); 
  }
  
  public void B() {
    MessageChatAdapter messageChatAdapter = this.L;
    if (messageChatAdapter != null)
      messageChatAdapter.notifyDataSetChanged(); 
  }
  
  public void C() {
    this.R.setTag("emotion");
    this.R.setImageDrawable(BluedSkinUtils.b(this.y, 2131232476));
    this.U.setTag("image");
    this.U.setImageDrawable(BluedSkinUtils.b(this.y, 2131232543));
    this.Q.setTag("audio");
    this.Q.setImageDrawable(BluedSkinUtils.b(this.y, 2131231179));
    this.o.setVisibility(0);
    this.o.requestFocus();
    this.R.setVisibility(0);
    if (!TextUtils.isEmpty(this.o.getText().toString())) {
      this.V.setVisibility(0);
    } else {
      this.V.setVisibility(8);
    } 
    this.N.setVisibility(8);
    this.ag.setVisibility(8);
    c(false);
    a(new boolean[0]);
  }
  
  public void D() {
    RecentPhotoView recentPhotoView = this.aA;
    if (recentPhotoView != null)
      recentPhotoView.b(); 
  }
  
  public void E() {
    a("", (short)1);
  }
  
  public void F() {
    PermissionHelper.c(new PermissionCallbacks(this) {
          public void a(String[] param1ArrayOfString) {}
          
          public void aa_() {
            Intent intent = new Intent(MsgChattingFragment.n(this.a), SendPositionActivity.class);
            this.a.startActivityForResult(intent, 604);
          }
        });
  }
  
  public void G() {
    D();
    if (this.t.N() != null && (this.t.N()).has_screenshot == 1)
      al(); 
  }
  
  public void H() {
    boolean bool;
    if (AudioChannelManager.e().h()) {
      AppMethods.a(getActivity().getResources().getText(2131759450));
      return;
    } 
    ShortVideoProxy shortVideoProxy = ShortVideoProxy.e();
    if (this.t.c()) {
      bool = true;
    } else {
      bool = true;
    } 
    shortVideoProxy.b(this, bool, 23);
  }
  
  public void I() {
    MsgChattingPresent msgChattingPresent = this.t;
    if (msgChattingPresent != null)
      msgChattingPresent.o(); 
  }
  
  public void J() {
    if (getActivity() != null && !getActivity().isFinishing()) {
      Handler handler = this.v;
      if (handler != null)
        handler.sendEmptyMessage(306); 
    } 
  }
  
  public void K() {
    if (this.y == null)
      return; 
    if (!BluedPreferences.aW()) {
      this.ah.setVisibility(8);
      return;
    } 
    this.ah.setVisibility(0);
    Animation animation = AnimationUtils.loadAnimation(this.y, 2130772063);
    animation.setFillAfter(true);
    animation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            AppInfo.n().postDelayed(new Runnable(this) {
                  public void run() {
                    if (MsgChattingFragment.o(this.a.a).getVisibility() == 0) {
                      Animation animation = AnimationUtils.loadAnimation(MsgChattingFragment.n(this.a.a), 2130772064);
                      animation.setFillAfter(true);
                      MsgChattingFragment.o(this.a.a).startAnimation(animation);
                    } 
                  }
                }2000L);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.ah.startAnimation(animation);
  }
  
  public BaseFragment L() {
    return (BaseFragment)this;
  }
  
  public EditText M() {
    return this.o;
  }
  
  public void N() {
    if (!this.r)
      KeyboardUtils.c((Activity)getActivity()); 
    C();
  }
  
  public void O() {
    this.S.performClick();
  }
  
  public MessageChatAdapter P() {
    return this.L;
  }
  
  public List<MsgRecentPhotoInfo> Q() {
    MsgChattingPresent msgChattingPresent = this.t;
    return (msgChattingPresent != null) ? msgChattingPresent.l() : new ArrayList<MsgRecentPhotoInfo>();
  }
  
  public void R() {
    RecentPhotoView recentPhotoView = this.aA;
    if (recentPhotoView != null)
      recentPhotoView.a(false); 
  }
  
  public void S() {
    MsgChattingPresent msgChattingPresent = this.t;
    if (msgChattingPresent != null)
      msgChattingPresent.m(); 
  }
  
  public String T() {
    EditText editText = this.o;
    return (editText != null) ? editText.getText().toString() : "";
  }
  
  public boolean V_() {
    if (GiftVoucherHelpPop.b != null) {
      GiftVoucherHelpPop.b.p();
      return true;
    } 
    if (GiftVoucherPop.b != null) {
      GiftVoucherPop.b.p();
      return true;
    } 
    if (this.ag.getVisibility() == 0) {
      this.ag.setVisibility(8);
      return true;
    } 
    BluedPreferences.av();
    this.t.q();
    return super.V_();
  }
  
  public String X_() {
    MsgChattingPresent msgChattingPresent = this.t;
    return (msgChattingPresent != null) ? msgChattingPresent.W() : "私聊页";
  }
  
  public void a() {
    Logger.a("ddrb", new Object[] { "EmotionManager.getEmotionPacks() = ", Integer.valueOf(EmotionManager.e().size()) });
    a(new Runnable(this) {
          public void run() {
            if (this.a.getActivity() != null && !this.a.getActivity().isFinishing()) {
              MsgChattingFragment.a(this.a).setModel(false);
              MsgChattingFragment.a(this.a).a((IRequestHost)this.a.w_(), EmotionManager.e());
              MsgChattingFragment.b(this.a).a((IRequestHost)this.a.w_(), EmotionManager.e());
              MsgChattingFragment.b(this.a).f();
            } 
          }
        });
  }
  
  public void a(int paramInt, String paramString) {
    long l = BluedPreferences.dR();
    if (paramInt == 1 && l != 0L && System.currentTimeMillis() - l <= 604800000L) {
      if ((this.t.i()).is_gift_new != 0 && !BluedPreferences.B((this.t.i()).is_gift_new))
        a(2, (this.t.i()).is_gift_new_content); 
      return;
    } 
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      if (paramInt != 0) {
        if (paramInt != 1) {
          if (paramInt != 2) {
            str = paramString;
          } else {
            str = getString(2131757990);
          } 
        } else {
          str = getString(2131757988);
        } 
      } else {
        str = getString(2131757989);
      }  
    a(new Runnable(this, str, paramInt) {
          public void run() {
            if (MsgChattingFragment.C(this.c) != null) {
              if (MsgChattingFragment.B(this.c) != null)
                return; 
              MsgChattingFragment msgChattingFragment = this.c;
              MsgChattingFragment.a(msgChattingFragment, new CenterGuidePop(msgChattingFragment.getContext(), this.a));
              MsgChattingFragment.B(this.c).a((View)MsgChattingFragment.C(this.c), (XPopupCallback)new SimpleCallback(this) {
                    public void c(BasePopupView param2BasePopupView) {
                      PersonalProfileProtos.Event event;
                      if (this.a.b == 1) {
                        event = PersonalProfileProtos.Event.GIFT_BUY_FREE_BUBBLE_SHOW;
                      } else {
                        event = PersonalProfileProtos.Event.GIFT_BUY_NEW_BUBBLE_SHOW;
                      } 
                      EventTrackPersonalProfile.a(event);
                      if (this.a.b == 1) {
                        BluedPreferences.p(System.currentTimeMillis());
                        return;
                      } 
                      if (this.a.b == 2 && this.a.c.t.i() != null)
                        BluedPreferences.C((this.a.c.t.i()).is_gift_new); 
                    }
                    
                    public void d(BasePopupView param2BasePopupView) {
                      MsgChattingFragment.a(this.a.c, (CenterGuidePop)null);
                    }
                  });
            } 
          }
        }200L);
  }
  
  public void a(int paramInt, String paramString1, String paramString2) {
    TextView textView;
    if (StringUtils.e(paramString1)) {
      textView = this.D;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.t.f());
      stringBuilder.append("");
      textView.setText(stringBuilder.toString());
    } else {
      this.D.setText((CharSequence)textView);
    } 
    if (!TextUtils.isEmpty(paramString2))
      this.D.setText(paramString2); 
    if (GroupUtil.a(paramInt)) {
      this.E.setVisibility(0);
      return;
    } 
    this.E.setVisibility(8);
  }
  
  public void a(int paramInt, boolean paramBoolean) {
    this.L.a(paramInt);
    if (paramBoolean) {
      this.L.notifyDataSetChanged();
      this.K.setSelection(this.L.getCount());
    } 
  }
  
  public void a(Message paramMessage) {
    MsgChattingPresent msgChattingPresent;
    UserInfoBasicModel userInfoBasicModel;
    switch (paramMessage.what) {
      default:
        return;
      case 306:
        msgChattingPresent = this.t;
        if (msgChattingPresent != null) {
          msgChattingPresent.g(true);
          return;
        } 
        return;
      case 305:
        if (this.t != null) {
          List<ChattingModel> list = ((LocalMsg)((Message)msgChattingPresent).obj).a;
          if (list == null || list.size() == 0) {
            this.K.setOnScrollListener(new MyOnScrollListener());
            this.t.c(false);
            this.an.setVisibility(8);
            ai();
            this.L.a = new ArrayList();
            this.L.notifyDataSetChanged();
            this.t.b(0);
            return;
          } 
          this.L.a = list;
          if (this.t.H() != null)
            if ((this.t.H()).sessionStatus == 1) {
              this.p.setVisibility(0);
            } else if ((this.t.H()).sessionStatus == 0) {
              this.p.setVisibility(8);
            }  
          this.L.notifyDataSetChanged();
          ak();
          this.t.s();
          y();
          if (!this.t.P()) {
            af();
            if (this.t.T() == 0 || this.t.T() != list.size())
              if (this.t.Q()) {
                if (!this.aH)
                  this.K.setSelection(this.L.getCount()); 
              } else if (this.t.S()) {
                int m = this.L.getCount();
                int n = this.t.T();
                int i1 = (int)((this.y.getResources().getDisplayMetrics()).density * 37.0F + 0.5F);
                this.K.setSelectionFromTop(m - n + 1, i1);
              } else {
                this.t.c();
              }  
            if (this.t.Q() && this.t.R() && !this.aH) {
              this.K.setSelection(this.L.getCount());
              this.K.smoothScrollToPosition(this.L.getCount());
            } 
            this.t.b(list.size());
            this.t.r();
            this.aH = false;
            return;
          } 
          int i = this.L.getCount();
          int j = this.t.T();
          int k = (int)((this.y.getResources().getDisplayMetrics()).density * 37.0F + 0.5F);
          this.K.setSelectionFromTop(i - j + 1, k);
          this.t.a(this.v, this.L.getCount());
          return;
        } 
        return;
      case 304:
        msgChattingPresent = this.t;
        if (msgChattingPresent != null && !msgChattingPresent.P()) {
          af();
          ToastUtils.a(2131755472);
          this.t.r();
          return;
        } 
        return;
      case 303:
        msgChattingPresent = this.t;
        if (msgChattingPresent != null && !msgChattingPresent.P()) {
          af();
          this.t.r();
          return;
        } 
        return;
      case 302:
        userInfoBasicModel = (UserInfoBasicModel)((Message)msgChattingPresent).obj;
        if (this.t != null && userInfoBasicModel != null) {
          if (userInfoBasicModel.vbadge == 3) {
            this.G.setVisibility(8);
          } else {
            if (!StringUtils.e(userInfoBasicModel.distance)) {
              this.G.setText(DistanceUtils.a(userInfoBasicModel.distance, BlueAppLocal.c(), false));
              this.G.setVisibility(0);
            } 
            DistanceUtils.a(this.y, this.G, userInfoBasicModel.is_hide_distance, 1);
          } 
          UserRelationshipUtils.a(this.F, (UserBasicModel)userInfoBasicModel);
          UserRelationshipUtils.a(this.y, this.D, (UserBasicModel)userInfoBasicModel);
          a(this.t.X(), userInfoBasicModel.name, "");
          this.t.a(userInfoBasicModel);
          a(this.t.X(), userInfoBasicModel.name, userInfoBasicModel.note);
          return;
        } 
        return;
      case 301:
        break;
    } 
    if (this.t != null) {
      GroupInfoModel groupInfoModel = (GroupInfoModel)((Message)userInfoBasicModel).obj;
      if (groupInfoModel != null) {
        a(this.t.X(), groupInfoModel.group_title, "");
        if (groupInfoModel.belong_circle != 0) {
          this.C.setVisibility(0);
          this.C.setOnClickListener(new View.OnClickListener(this, groupInfoModel) {
                public void onClick(View param1View) {
                  Context context = this.b.getContext();
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(this.a.belong_circle);
                  stringBuilder.append("");
                  CircleDetailsFragment.a(context, stringBuilder.toString(), CircleConstants.CIRCLE_FROM_PAGE.GROUP);
                }
              });
        } else {
          this.C.setVisibility(8);
        } 
        if (groupInfoModel.group_status == 2) {
          this.p.setVisibility(0);
        } else {
          this.p.setVisibility(8);
        } 
        this.t.c(ChatHelperV4.a().a(groupInfoModel.admin));
        if (groupInfoModel.admin != null && groupInfoModel.admin.size() > 0 && ((GroupMemberModel)groupInfoModel.admin.get(0)).group_role == 1)
          this.t.b(((GroupMemberModel)groupInfoModel.admin.get(0)).uid); 
        this.t.b(groupInfoModel);
        this.L.notifyDataSetChanged();
        if (System.currentTimeMillis() > BluedPreferences.s(groupInfoModel.group_id)) {
          if (groupInfoModel.report_reason != null && groupInfoModel.report_reason.size() > 0) {
            this.H.setText(String.format(getString(2131756777), new Object[] { GroupUtil.a(groupInfoModel.report_reason) }));
          } else {
            this.H.setText(getString(2131756778));
          } 
          z();
        } 
      } 
    } 
  }
  
  public void a(View paramView) {
    this.R.setTag("emotion");
    this.R.setImageDrawable(BluedSkinUtils.b(this.y, 2131232476));
    this.U.setTag("img");
    this.U.setImageDrawable(BluedSkinUtils.b(this.y, 2131232543));
    if ("audio".equals(paramView.getTag())) {
      PermissionHelper.d(new PermissionCallbacks(this, paramView) {
            public void a(String[] param1ArrayOfString) {}
            
            public void aa_() {
              this.a.setTag("keyboard");
              ((ImageView)this.a).setImageDrawable(BluedSkinUtils.b(MsgChattingFragment.n(this.b), 2131231173));
              MsgChattingFragment.F(this.b).setVisibility(0);
              MsgChattingFragment.x(this.b).setVisibility(8);
              MsgChattingFragment.d(this.b).setVisibility(8);
              MsgChattingFragment.I(this.b).setVisibility(8);
              KeyboardUtils.a((Activity)this.b.getActivity());
            }
          });
      return;
    } 
    paramView.setTag("audio");
    ((ImageView)paramView).setImageDrawable(BluedSkinUtils.b(this.y, 2131231179));
    this.o.setVisibility(0);
    if (!TextUtils.isEmpty(this.o.getText().toString())) {
      this.V.setVisibility(0);
    } else {
      this.V.setVisibility(8);
    } 
    this.N.setVisibility(8);
    this.ag.setVisibility(8);
    this.as.setVisibility(0);
    this.o.requestFocus();
    KeyboardUtils.c((Activity)getActivity());
  }
  
  public void a(View paramView1, View paramView2, Object paramObject) {
    Context context = this.y;
    CommonAlertDialog.a(context, null, context.getResources().getString(2131755598), this.y.getResources().getString(2131756086), new DialogInterface.OnClickListener(this, paramObject) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (this.b.t != null)
              this.b.t.a(this.a); 
          }
        }this.y.getResources().getString(2131756057), null, null);
  }
  
  public void a(SessionModel paramSessionModel) {
    GiftPlayer giftPlayer = this.u;
    if (giftPlayer != null)
      giftPlayer.a(paramSessionModel); 
  }
  
  public void a(UserInfoBasicModel paramUserInfoBasicModel) {
    ai();
    if (this.v != null) {
      Message message = new Message();
      message.what = 302;
      message.obj = paramUserInfoBasicModel;
      this.v.sendMessage(message);
    } 
  }
  
  public void a(IRecentPhotoAdapterCallback.IGetPhotoListCallback paramIGetPhotoListCallback) {
    MsgChattingPresent msgChattingPresent = this.t;
    if (msgChattingPresent != null)
      msgChattingPresent.a(paramIGetPhotoListCallback); 
  }
  
  public void a(FuGiftListEvent paramFuGiftListEvent) {
    b(paramFuGiftListEvent);
  }
  
  public void a(MsgRecentPhotoInfo paramMsgRecentPhotoInfo) {
    MsgChattingPresent msgChattingPresent = this.t;
    if (msgChattingPresent != null)
      msgChattingPresent.b(paramMsgRecentPhotoInfo); 
  }
  
  public void a(GiftGivingOptionForJsonParse paramGiftGivingOptionForJsonParse) {
    GiftPlayer giftPlayer = this.u;
    if (giftPlayer != null)
      giftPlayer.a(paramGiftGivingOptionForJsonParse); 
  }
  
  public void a(String paramString) {
    a(paramString, (short)6);
  }
  
  public void a(String paramString1, String paramString2) {
    UserBasicModel userBasicModel = new UserBasicModel();
    userBasicModel.uid = paramString1;
    userBasicModel.name = paramString2;
    this.aq.a(this.o, userBasicModel, this.aR, true);
  }
  
  public void a(List<ChattingModel> paramList) {
    if (this.v != null) {
      Message message = new Message();
      message.what = 305;
      LocalMsg localMsg = new LocalMsg(this);
      localMsg.a = paramList;
      message.obj = localMsg;
      this.v.sendMessage(message);
      a(new Runnable(this, paramList) {
            public void run() {
              List<ChattingModel> list = this.a;
              if (list != null) {
                if (list.isEmpty())
                  return; 
                list = this.a;
                ChattingModel chattingModel = list.get(list.size() - 1);
                if (chattingModel.msgType != -1 && chattingModel.isFromSelf() && System.currentTimeMillis() - chattingModel.msgTimestamp < 500L)
                  PushChecker.a().a(this.b.getContext(), 1, MessageProtos.WarnTime.CHAT_FIRST); 
              } 
            }
          });
    } 
    if (this.t.H() == null)
      a(new Runnable(this) {
            public void run() {
              this.a.t.Y();
            }
          }); 
  }
  
  public void a(SkinObservable paramSkinObservable, Object paramObject) {
    Logger.c(w, new Object[] { "updateSkin======" });
    VipBubbleManager.a().b();
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            MsgChattingFragment.c(this.a).notifyDataSetChanged();
          }
        },  200L);
  }
  
  public void a(boolean paramBoolean) {
    MsgChattingPresent msgChattingPresent = this.t;
    if (msgChattingPresent != null)
      msgChattingPresent.a(paramBoolean); 
  }
  
  public void b(int paramInt) {
    ImageView imageView = this.E;
    if (imageView != null)
      imageView.setVisibility(paramInt); 
  }
  
  public void b(IRecentPhotoAdapterCallback.IGetPhotoListCallback paramIGetPhotoListCallback) {
    MsgChattingPresent msgChattingPresent = this.t;
    if (msgChattingPresent != null)
      msgChattingPresent.b(paramIGetPhotoListCallback); 
  }
  
  public void b(FuGiftListEvent paramFuGiftListEvent) {
    if (paramFuGiftListEvent.a == null)
      return; 
    c(paramFuGiftListEvent.a);
  }
  
  public void b(MsgRecentPhotoInfo paramMsgRecentPhotoInfo) {
    MsgChattingPresent msgChattingPresent = this.t;
    if (msgChattingPresent != null)
      msgChattingPresent.a(paramMsgRecentPhotoInfo); 
  }
  
  public void b(String paramString) {
    CustomDialog customDialog = this.M;
    if (customDialog != null && customDialog.isShowing())
      return; 
    View view = LayoutInflater.from(this.y).inflate(2131493743, null);
    view.findViewById(2131301409).setVisibility(8);
    TextView textView2 = (TextView)view.findViewById(2131300611);
    textView2.setText(getString(2131755577));
    textView2.setVisibility(8);
    view.findViewById(2131300719).setVisibility(8);
    ((TextView)view.findViewById(2131300703)).setText(paramString);
    TextView textView1 = (TextView)view.findViewById(2131301130);
    textView1.setText(getString(2131757775));
    textView1.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            BluedPreferences.av();
            MsgChattingFragment.J(this.a);
            MsgChattingFragment.K(this.a).dismiss();
          }
        });
    this.M = new CustomDialog(this.y, 2131821111);
    this.M.a(view, null);
  }
  
  public void b(List<HelloExpressionData> paramList) {
    if (this.aL == null) {
      ViewStub viewStub = this.aK;
      if (viewStub != null) {
        this.aL = viewStub.inflate();
        this.aL.setVisibility(8);
        RecyclerView recyclerView = (RecyclerView)this.aL.findViewById(2131299601);
        Context context = getContext();
        int i = 0;
        recyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(context, 0, false));
        HelloExpressionAdapter helloExpressionAdapter = new HelloExpressionAdapter((IRequestHost)w_());
        recyclerView.setAdapter((RecyclerView.Adapter)helloExpressionAdapter);
        helloExpressionAdapter.c(paramList);
        helloExpressionAdapter.a(new BaseQuickAdapter.OnItemClickListener(this) {
              public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
                HelloExpressionData helloExpressionData = param1BaseQuickAdapter.n().get(param1Int);
                this.a.t.a(helloExpressionData);
                MsgChattingFragment.D(this.a);
                MessageProtos.Event event = MessageProtos.Event.MSG_SAY_HI_ONE_CLICK;
                String str = helloExpressionData.id;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.a.t.f());
                stringBuilder.append("");
                EventTrackMessage.a(event, str, stringBuilder.toString());
              }
            });
        a(new boolean[0]);
        StringBuilder stringBuilder1 = new StringBuilder();
        while (i < paramList.size()) {
          stringBuilder1.append(((HelloExpressionData)paramList.get(i)).id);
          if (i != paramList.size() - 1)
            stringBuilder1.append(","); 
          i++;
        } 
        MessageProtos.Event event = MessageProtos.Event.MSG_SAY_HI_LIST_SHOW;
        String str = stringBuilder1.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.t.f());
        stringBuilder2.append("");
        EventTrackMessage.a(event, str, stringBuilder2.toString());
      } 
    } 
  }
  
  public void c(int paramInt) {
    this.K.post(new Runnable(this, paramInt) {
          public void run() {
            MsgChattingFragment.g(this.b).smoothScrollToPosition(this.a);
          }
        });
  }
  
  public void d() {
    MsgChattingPresent msgChattingPresent = this.t;
    if (msgChattingPresent != null)
      msgChattingPresent.k(); 
  }
  
  public void d(View paramView) {
    if (this.t.N() != null && (this.t.N()).has_screenshot == 1)
      al(); 
    c(true);
    this.U.setTag("image");
    this.U.setImageDrawable(BluedSkinUtils.b(this.y, 2131232543));
    if (this.aA.getVisibility() == 8) {
      this.R.setTag("emotion");
      this.R.setImageDrawable(BluedSkinUtils.b(this.y, 2131232476));
      if (this.ag.getVisibility() == 8) {
        Z();
        this.Q.setTag("audio");
        this.Q.setImageDrawable(BluedSkinUtils.b(this.y, 2131231179));
        this.o.setVisibility(0);
        this.R.setVisibility(0);
        if (!TextUtils.isEmpty(this.o.getText().toString())) {
          this.V.setVisibility(0);
        } else {
          this.V.setVisibility(8);
        } 
        this.N.setVisibility(8);
        this.aA.c();
      } 
    } 
    P_();
  }
  
  public void e() {
    MsgChattingPresent msgChattingPresent = this.t;
    if (msgChattingPresent != null)
      msgChattingPresent.a((BaseFragment)this); 
  }
  
  public void e(View paramView) {
    c(false);
    this.Q.setTag("audio");
    this.Q.setImageResource(2131231179);
    this.N.setVisibility(8);
    this.o.setVisibility(0);
    this.U.setImageDrawable(BluedSkinUtils.b(this.y, 2131232543));
    this.U.setTag("");
    String str = (String)paramView.getTag();
    if (StringUtils.e(str) || "emotion".equals(str)) {
      paramView.setTag("keyboard");
      ((ImageView)paramView).setImageDrawable(BluedSkinUtils.b(this.y, 2131231173));
      Z();
    } else {
      paramView.setTag("emotion");
      ((ImageView)paramView).setImageDrawable(BluedSkinUtils.b(this.y, 2131232476));
    } 
    q();
  }
  
  public void e_(int paramInt) {
    this.K.setTranscriptMode(2);
    a(new Runnable(this) {
          public void run() {
            MsgChattingFragment.g(this.a).setTranscriptMode(1);
          }
        },  300L);
    if (paramInt != -6) {
      if (paramInt != -5) {
        if (paramInt != -4) {
          if (paramInt != -3) {
            if (paramInt != -2)
              return; 
            try {
              this.r = false;
              if (this.ag.getVisibility() != 0)
                this.as.setVisibility(8); 
              a(new boolean[] { true });
              return;
            } catch (Exception exception) {
              exception.printStackTrace();
              return;
            } 
          } 
          Z();
          aa();
          this.r = true;
          C();
          ae();
          this.o.setSelection(this.o.getText().toString().length());
          a(new Runnable(this) {
                public void run() {
                  this.a.o.requestFocus();
                }
              },  200L);
          return;
        } 
        a(new Runnable(this) {
              public void run() {
                MsgChattingFragment.h(this.a);
              }
            });
        return;
      } 
      a(new Runnable(this) {
            public void run() {
              MsgChattingFragment.h(this.a);
            }
          });
    } 
    a(new Runnable(this) {
          public void run() {
            MsgChattingFragment.h(this.a);
          }
        });
  }
  
  public void f(View paramView) {
    G();
    c(false);
    this.R.setImageDrawable(BluedSkinUtils.b(this.y, 2131232476));
    this.R.setTag("");
    String str = (String)paramView.getTag();
    if (StringUtils.e(str) || "image".equals(str)) {
      paramView.setTag("keyboard");
      ((ImageView)paramView).setImageDrawable(BluedSkinUtils.b(this.y, 2131231173));
    } else {
      paramView.setTag("image");
      ((ImageView)paramView).setImageDrawable(BluedSkinUtils.b(this.y, 2131232543));
    } 
    Q_();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    MsgChattingPresent msgChattingPresent = this.t;
    if (msgChattingPresent != null)
      msgChattingPresent.a(paramInt1, paramInt2, paramIntent); 
  }
  
  public void onClick(View paramView) {
    StringBuilder stringBuilder;
    String str1;
    MsgChattingPresent msgChattingPresent;
    String str2;
    MessageProtos.StrangerSource strangerSource;
    Context context;
    ActivityFragmentActive activityFragmentActive;
    String str3;
    UserGiftDialogFragment.BuySucceedListener buySucceedListener;
    String str4;
    int i = paramView.getId();
    switch (i) {
      default:
        str2 = "";
        switch (i) {
          default:
            switch (i) {
              default:
                return;
              case 2131298817:
                if (this.t.N() != null) {
                  MessageProtos.Event event = MessageProtos.Event.CHAT_VIDEO_CLICK;
                  strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append((this.t.N()).uid);
                  stringBuilder1.append("");
                  EventTrackMessage.a(event, strangerSource, stringBuilder1.toString());
                } 
                InstantLog.a("chat_video_click", Integer.valueOf(0));
                H();
                return;
              case 2131298816:
                this.ag.setVisibility(8);
                c(false);
                if (BluedPreferences.au()) {
                  b(this.y.getResources().getString(2131755762));
                  return;
                } 
                aj();
                return;
              case 2131298815:
                if (!this.t.c() || !BluedConfig.b().l()) {
                  G();
                  return;
                } 
                return;
              case 2131298814:
                F();
                return;
              case 2131298813:
                if (this.t.N() != null) {
                  MessageProtos.Event event = MessageProtos.Event.CHAT_VIDEO_CLICK;
                  strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append((this.t.N()).uid);
                  stringBuilder1.append("");
                  EventTrackMessage.a(event, strangerSource, stringBuilder1.toString());
                } 
                InstantLog.a("chat_video_click", Integer.valueOf(1));
                H();
                return;
              case 2131298812:
                break;
            } 
            I();
            return;
          case 2131296566:
            KeyboardUtils.a((Activity)getActivity());
            if (!TextUtils.isEmpty(BluedConfig.b().F()) && !BluedPreferences.e().contains(BluedConfig.b().F())) {
              BluedPreferences.e().edit().putBoolean(BluedConfig.b().F(), true).apply();
              this.T.setVisibility(8);
            } 
            context = getContext();
            activityFragmentActive = w_();
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.t.f());
            stringBuilder.append("");
            str3 = stringBuilder.toString();
            buySucceedListener = new UserGiftDialogFragment.BuySucceedListener(this) {
                public void a(UserGiftDialogFragment param1UserGiftDialogFragment, GiftGivingOptionForJsonParse param1GiftGivingOptionForJsonParse) {
                  param1UserGiftDialogFragment.dismiss();
                  if (this.a.t != null)
                    this.a.t.a(param1GiftGivingOptionForJsonParse); 
                }
              };
            str4 = (this.t.N()).relationship;
            if (this.t.N() == null) {
              MessageProtos.StrangerSource strangerSource1 = strangerSource;
            } else {
              str1 = (this.t.N()).name;
            } 
            UserGiftDialogFragment.a(context, activityFragmentActive, str3, "chat_page_gift", buySucceedListener, str4, str1, new int[0]);
            return;
          case 2131296565:
            break;
        } 
        e((View)str1);
        return;
      case 2131300680:
        AppMethods.d(2131756720);
        return;
      case 2131300678:
        PopMenuUtils.a(this.y);
        return;
      case 2131299294:
        E();
        return;
      case 2131299021:
        msgChattingPresent = this.t;
        if (msgChattingPresent != null)
          msgChattingPresent.e(true); 
        msgChattingPresent = this.t;
        if (msgChattingPresent != null) {
          msgChattingPresent.s();
          this.t.a(this.v, this.L.getCount());
          return;
        } 
        return;
      case 2131298833:
        this.K.setSelection(this.L.a.size() - 1);
        this.af.setVisibility(8);
        msgChattingPresent = this.t;
        if (msgChattingPresent != null) {
          msgChattingPresent.f(true);
          return;
        } 
        return;
      case 2131296867:
        EventTrackMessage.a(MessageProtos.Event.MSG_SETTINGS_ICON_CLICK);
        msgChattingPresent = this.t;
        if (msgChattingPresent != null)
          msgChattingPresent.p(); 
        if (!BluedPreferences.cm()) {
          this.aJ.setVisibility(8);
          BluedPreferences.cn();
          return;
        } 
        return;
      case 2131296863:
        msgChattingPresent = this.t;
        if (msgChattingPresent != null) {
          msgChattingPresent.q();
          return;
        } 
        return;
      case 2131296572:
        EventTrackMessage.a(MessageProtos.Event.MSG_ADD_BTN_CLICK);
        d((View)msgChattingPresent);
        return;
      case 2131296568:
        f((View)msgChattingPresent);
        return;
      case 2131296562:
        break;
    } 
    a((View)msgChattingPresent);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.y = (Context)getActivity();
    getActivity().getWindow().setSoftInputMode(19);
    this.t = new MsgChattingPresent(paramBundle, this);
    View view = this.x;
    if (view == null) {
      this.x = paramLayoutInflater.inflate(2131493234, paramViewGroup, false);
      if (!this.t.U()) {
        getActivity().finish();
        return null;
      } 
      ab();
      ac();
      b((View)this.ag, this.ar, this.o, this.s, (View)this.O, (View)this.aA);
      Y();
      ag();
      if (!this.t.V()) {
        this.aH = true;
      } else {
        this.J.b(false);
      } 
      this.t.b(this.v);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.x.getParent()).removeView(this.x);
    } 
    return this.x;
  }
  
  public void onDestroy() {
    EmotionManager.b(this);
    MsgChattingPresent msgChattingPresent = this.t;
    if (msgChattingPresent != null)
      msgChattingPresent.ab(); 
    Handler handler = this.v;
    if (handler != null)
      ((MsgHandler)handler).a(); 
    super.onDestroy();
    BluedSkinUtils.b(this);
  }
  
  public void onMsgRetractedTimeout() {
    Context context = this.y;
    CommonAlertDialog.a(context, null, null, context.getResources().getString(2131758689), this.y.getResources().getString(2131758968), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
        },  null, true);
  }
  
  public void onPause() {
    super.onPause();
    X();
    ChatConstants.a = 0L;
    MsgChattingPresent msgChattingPresent = this.t;
    if (msgChattingPresent != null)
      msgChattingPresent.aa(); 
    LiveEventBus.get("buy_fu", FuGiftListEvent.class).removeObserver(this);
  }
  
  public void onResume() {
    super.onResume();
    if (this.u != null && this.t.H() != null) {
      UserPagerGiftManager.a().a(this.u);
      this.u.a(this.t.H());
    } 
    MsgChattingPresent msgChattingPresent = this.t;
    if (msgChattingPresent != null)
      msgChattingPresent.Z(); 
    if (this.q != null)
      if (PopMenuUtils.a()) {
        this.q.setVisibility(0);
      } else {
        this.q.setVisibility(8);
      }  
    LiveEventBus.get("buy_fu", FuGiftListEvent.class).observeForever(this);
    BluedSkinUtils.a(this);
  }
  
  public void onRetractFailed() {
    Context context = this.y;
    CommonAlertDialog.a(context, null, null, context.getResources().getString(2131758627), this.y.getResources().getString(2131758968), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
        },  null, true);
  }
  
  public void onRetractSuccess() {}
  
  public void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    MsgChattingPresent msgChattingPresent = this.t;
    if (msgChattingPresent != null)
      msgChattingPresent.a(paramBundle); 
  }
  
  public void onStop() {
    super.onStop();
    UserPagerGiftManager.a().b(this.u);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    try {
      if (this.t != null && !TextUtils.isEmpty(this.t.y())) {
        this.aC = true;
        CharSequence charSequence = StringUtils.a(this.t.y(), (int)this.o.getTextSize(), 1);
        this.o.setText(charSequence);
        this.o.setSelection(charSequence.toString().length());
        this.aC = false;
      } 
    } finally {}
    this.aC = false;
  }
  
  public void t() {
    Logger.c(w, new Object[] { "updateInfo==========" });
    try {
      if (this.t.c()) {
        ah();
        return;
      } 
      this.t.n();
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void u() {
    KeyboardUtils.a((Activity)getActivity());
    this.as.setVisibility(8);
    C();
  }
  
  public void v() {
    a(new Runnable(this) {
          public void run() {
            // Byte code:
            //   0: aload_0
            //   1: getfield a : Lcom/soft/blued/ui/msg/MsgChattingFragment;
            //   4: invokestatic i : (Lcom/soft/blued/ui/msg/MsgChattingFragment;)Landroid/widget/ImageView;
            //   7: ifnull -> 233
            //   10: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
            //   13: invokevirtual i : ()Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
            //   16: getfield vip_grade : I
            //   19: istore_1
            //   20: iconst_1
            //   21: istore_2
            //   22: iload_1
            //   23: ifne -> 31
            //   26: iconst_0
            //   27: istore_1
            //   28: goto -> 111
            //   31: aload_0
            //   32: getfield a : Lcom/soft/blued/ui/msg/MsgChattingFragment;
            //   35: getfield t : Lcom/soft/blued/ui/msg/presenter/MsgChattingPresent;
            //   38: invokevirtual E : ()Ljava/lang/String;
            //   41: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
            //   44: ifeq -> 90
            //   47: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
            //   50: invokevirtual i : ()Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
            //   53: invokevirtual getUid : ()Ljava/lang/String;
            //   56: invokestatic w : (Ljava/lang/String;)Ljava/lang/String;
            //   59: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
            //   62: ifne -> 26
            //   65: aload_0
            //   66: getfield a : Lcom/soft/blued/ui/msg/MsgChattingFragment;
            //   69: getfield t : Lcom/soft/blued/ui/msg/presenter/MsgChattingPresent;
            //   72: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
            //   75: invokevirtual i : ()Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
            //   78: invokevirtual getUid : ()Ljava/lang/String;
            //   81: invokestatic w : (Ljava/lang/String;)Ljava/lang/String;
            //   84: invokevirtual a : (Ljava/lang/String;)V
            //   87: goto -> 109
            //   90: aload_0
            //   91: getfield a : Lcom/soft/blued/ui/msg/MsgChattingFragment;
            //   94: getfield t : Lcom/soft/blued/ui/msg/presenter/MsgChattingPresent;
            //   97: invokevirtual E : ()Ljava/lang/String;
            //   100: invokestatic b : (Ljava/lang/String;)Z
            //   103: ifeq -> 109
            //   106: goto -> 26
            //   109: iconst_1
            //   110: istore_1
            //   111: iload_1
            //   112: ifeq -> 221
            //   115: aload_0
            //   116: getfield a : Lcom/soft/blued/ui/msg/MsgChattingFragment;
            //   119: invokestatic t : (Lcom/soft/blued/ui/msg/MsgChattingFragment;)Ljava/lang/String;
            //   122: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
            //   125: ifeq -> 133
            //   128: iload_2
            //   129: istore_1
            //   130: goto -> 163
            //   133: aload_0
            //   134: getfield a : Lcom/soft/blued/ui/msg/MsgChattingFragment;
            //   137: getfield t : Lcom/soft/blued/ui/msg/presenter/MsgChattingPresent;
            //   140: invokevirtual E : ()Ljava/lang/String;
            //   143: aload_0
            //   144: getfield a : Lcom/soft/blued/ui/msg/MsgChattingFragment;
            //   147: invokestatic t : (Lcom/soft/blued/ui/msg/MsgChattingFragment;)Ljava/lang/String;
            //   150: invokevirtual equals : (Ljava/lang/Object;)Z
            //   153: ifne -> 161
            //   156: iload_2
            //   157: istore_1
            //   158: goto -> 163
            //   161: iconst_0
            //   162: istore_1
            //   163: iload_1
            //   164: ifeq -> 233
            //   167: aload_0
            //   168: getfield a : Lcom/soft/blued/ui/msg/MsgChattingFragment;
            //   171: invokevirtual w_ : ()Lcom/blued/android/core/ui/ActivityFragmentActive;
            //   174: aload_0
            //   175: getfield a : Lcom/soft/blued/ui/msg/MsgChattingFragment;
            //   178: getfield t : Lcom/soft/blued/ui/msg/presenter/MsgChattingPresent;
            //   181: invokevirtual E : ()Ljava/lang/String;
            //   184: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;Ljava/lang/String;)Lcom/blued/android/core/image/ImageWrapper;
            //   187: ldc 2131100609
            //   189: invokevirtual a : (I)Lcom/blued/android/core/image/ImageWrapper;
            //   192: new com/soft/blued/ui/msg/MsgChattingFragment$22$1
            //   195: dup
            //   196: aload_0
            //   197: aload_0
            //   198: getfield a : Lcom/soft/blued/ui/msg/MsgChattingFragment;
            //   201: invokevirtual w_ : ()Lcom/blued/android/core/ui/ActivityFragmentActive;
            //   204: invokespecial <init> : (Lcom/soft/blued/ui/msg/MsgChattingFragment$22;Lcom/blued/android/core/net/IRequestHost;)V
            //   207: invokevirtual a : (Lcom/blued/android/core/image/ImageLoadResult;)Lcom/blued/android/core/image/ImageWrapper;
            //   210: aload_0
            //   211: getfield a : Lcom/soft/blued/ui/msg/MsgChattingFragment;
            //   214: invokestatic i : (Lcom/soft/blued/ui/msg/MsgChattingFragment;)Landroid/widget/ImageView;
            //   217: invokevirtual a : (Landroid/widget/ImageView;)V
            //   220: return
            //   221: aload_0
            //   222: getfield a : Lcom/soft/blued/ui/msg/MsgChattingFragment;
            //   225: invokestatic i : (Lcom/soft/blued/ui/msg/MsgChattingFragment;)Landroid/widget/ImageView;
            //   228: bipush #8
            //   230: invokevirtual setVisibility : (I)V
            //   233: return
          }
        });
  }
  
  public void w() {
    RecentPhotoView recentPhotoView = this.aA;
    if (recentPhotoView != null)
      recentPhotoView.a(true); 
  }
  
  public void x() {
    BluedAlertDialog bluedAlertDialog = this.aD;
    if (bluedAlertDialog == null || !bluedAlertDialog.isShowing())
      this.aD = CommonAlertDialog.a(getContext(), 0, "", getResources().getString(2131758082), null, getContext().getString(2131755609), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              if (this.a.t != null)
                this.a.t.ac(); 
            }
          },  null, null, null, false, 1, 0, false, false); 
  }
  
  public void y() {
    MsgChattingPresent msgChattingPresent = this.t;
    if (msgChattingPresent == null)
      return; 
    if (msgChattingPresent.N() != null) {
      if ((this.t.N()).is_un_disturb != 1)
        return; 
      if (this.t.H() != null && (this.t.H()).hasReply == 1)
        return; 
      MessageChatAdapter messageChatAdapter = this.L;
      if (messageChatAdapter == null)
        return; 
      int i = messageChatAdapter.getCount();
      if (i <= 0)
        return; 
      ChattingModel chattingModel = (ChattingModel)this.L.getItem(0);
      if (chattingModel == null)
        return; 
      if (i > 2)
        return; 
      if (i == 1 && chattingModel.msgType == -2)
        return; 
      if (i == 2 && chattingModel.msgType != -2)
        return; 
      this.aF.b();
      this.aF.setEnabled(false);
    } 
  }
  
  public void z() {
    a(new Runnable(this) {
          public void run() {
            if (!MsgChattingFragment.y(this.a) && this.a.t != null) {
              MsgChattingFragment.c(this.a, true);
              if ((this.a.t.c() || (MsgChattingFragment.c(this.a)).a == null || (MsgChattingFragment.c(this.a)).a.size() == 0) && MsgChattingFragment.z(this.a) != null) {
                MsgChattingFragment.z(this.a).setVisibility(0);
                MsgChattingFragment.z(this.a).postDelayed(new Runnable(this) {
                      public void run() {
                        MsgChattingFragment.h(this.a.a);
                      }
                    },  2000L);
              } 
            } 
          }
        }200L);
  }
  
  class LocalMsg {
    public List<ChattingModel> a;
    
    LocalMsg(MsgChattingFragment this$0) {}
  }
  
  static class MsgHandler extends Handler {
    private WeakReference<Fragment> a;
    
    MsgHandler(Fragment param1Fragment) {
      this.a = new WeakReference<Fragment>(param1Fragment);
    }
    
    public void a() {
      WeakReference<Fragment> weakReference = this.a;
      if (weakReference != null)
        weakReference.clear(); 
    }
    
    public void handleMessage(Message param1Message) {
      MsgChattingFragment msgChattingFragment = (MsgChattingFragment)this.a.get();
      if (msgChattingFragment == null || msgChattingFragment.getActivity() == null || msgChattingFragment.getActivity().isFinishing()) {
        Logger.b(MsgChattingFragment.W(), new Object[] { "fragment == null || getActivity() == null || getActivity().isFinishing()" });
        return;
      } 
      msgChattingFragment.a(param1Message);
    }
  }
  
  class MyOnScrollListener implements AbsListView.OnScrollListener {
    private MyOnScrollListener(MsgChattingFragment this$0) {}
    
    public void onScroll(AbsListView param1AbsListView, int param1Int1, int param1Int2, int param1Int3) {}
    
    public void onScrollStateChanged(AbsListView param1AbsListView, int param1Int) {
      if (param1Int != 0) {
        if (param1Int != 1) {
          if (param1Int != 2)
            return; 
          this.a.u();
          return;
        } 
      } else if (this.a.t != null) {
        if (param1AbsListView.getLastVisiblePosition() == param1AbsListView.getCount() - 1) {
          MsgChattingFragment.q(this.a).setVisibility(8);
          this.a.t.f(true);
          return;
        } 
        this.a.t.f(false);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\MsgChattingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */