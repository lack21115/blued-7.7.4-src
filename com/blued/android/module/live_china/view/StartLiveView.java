package com.blued.android.module.live_china.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.utils.AnimationUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveRoomAnchorModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveShareTextModel;
import com.blued.android.module.live_china.model.StartLiveDialog;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.model.InstantLogBody;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.share.Constants;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import java.io.File;

public class StartLiveView extends FrameLayout implements View.OnClickListener {
  private View A;
  
  private LinearLayout B;
  
  private ImageView C;
  
  private TextView D;
  
  private View E;
  
  private View F;
  
  private Button G;
  
  private TextView H;
  
  private View I;
  
  private RecordingOnliveFragment J;
  
  private LoadOptions K;
  
  private String L;
  
  private boolean M;
  
  private boolean N;
  
  private boolean O;
  
  private boolean P;
  
  private int Q = 15;
  
  private CountDownTimer R;
  
  private String[] S;
  
  private String[] T;
  
  private boolean U;
  
  private boolean V;
  
  private String W;
  
  private Context a;
  
  private Dialog aa;
  
  private ViewGroup ab;
  
  private ViewGroup ac;
  
  private TextView ad;
  
  private View ae;
  
  private View af;
  
  private View ag;
  
  private View ah;
  
  private View ai;
  
  private View aj;
  
  private TextView ak;
  
  private TextView al;
  
  private boolean am;
  
  private boolean an;
  
  private TextWatcher ao = new TextWatcher(this) {
      private int b;
      
      private int c;
      
      public void afterTextChanged(Editable param1Editable) {
        this.b = StartLiveView.f(this.a).getSelectionStart();
        this.c = StartLiveView.f(this.a).getSelectionEnd();
        StartLiveView.f(this.a).removeTextChangedListener(StartLiveView.n(this.a));
        String str = StartLiveView.f(this.a).getText().toString().trim();
        int i = 0;
        int j;
        for (j = 20; i < str.length(); j = k) {
          int k = str.charAt(i);
          if (k >= 32 && k <= 122) {
            k = j;
          } else {
            k = j;
            if (j > 10)
              k = j - 1; 
          } 
          i++;
        } 
        Logger.a("drb", new Object[] { "mTextMaxLength - ", Integer.valueOf(j) });
        while (param1Editable.length() > j) {
          param1Editable.delete(this.b - 1, this.c);
          this.b--;
          this.c--;
        } 
        StartLiveView.f(this.a).setSelection(this.b);
        StartLiveView.f(this.a).addTextChangedListener(StartLiveView.n(this.a));
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  private String ap;
  
  private LayoutInflater b;
  
  private View c;
  
  private LinearLayout d;
  
  private RelativeLayout e;
  
  private TextView f;
  
  private RelativeLayout g;
  
  private TextView h;
  
  private ImageView i;
  
  private ImageView j;
  
  private EditText k;
  
  private View l;
  
  private View m;
  
  private LinearLayout n;
  
  private LinearLayout o;
  
  private ImageView p;
  
  private Button q;
  
  private ImageView r;
  
  private ImageView s;
  
  private ImageView t;
  
  private ImageView u;
  
  private ImageView v;
  
  private Button w;
  
  private TextView x;
  
  private TextView y;
  
  private ImageView z;
  
  public StartLiveView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public StartLiveView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public StartLiveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
  }
  
  private void a(long paramLong) {
    String[] arrayOfString = this.S;
    if (arrayOfString != null && arrayOfString.length > 0) {
      arrayOfString = this.T;
      if (arrayOfString != null && arrayOfString.length > 0)
        LiveMsgSendManager.a().a(Long.valueOf(paramLong).longValue(), this.S, this.T, this.ap); 
    } 
  }
  
  private void a(LiveRoomData paramLiveRoomData) {
    paramLiveRoomData.live_type = LiveRoomManager.a().A();
    paramLiveRoomData.profile = new LiveRoomAnchorModel(LiveRoomInfo.a().f(), LiveRoomInfo.a().c(), LiveRoomInfo.a().d(), LiveRoomInfo.a().r(), LiveRoomInfo.a().q());
    this.J.u = paramLiveRoomData.lid;
    this.W = paramLiveRoomData.description;
    LiveRoomManager.a().a(paramLiveRoomData);
    LiveMsgSendManager.a().a(paramLiveRoomData.lid);
    this.J.a(new Runnable(this) {
          public void run() {
            this.a.getLiveShareContent();
          }
        });
  }
  
  private void a(String paramString1, String paramString2) {
    AppInfo.n().post(new Runnable(this, paramString2, paramString1) {
          public void run() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("showErrorLayout title:");
            stringBuilder.append(this.a);
            stringBuilder.append(" -- failedMessage:");
            stringBuilder.append(this.b);
            Logger.a("pk", new Object[] { stringBuilder.toString() });
            if (StartLiveView.h(this.c).w_() != null) {
              String str;
              if (!StartLiveView.h(this.c).w_().isActive())
                return; 
              StartLiveView.i(this.c).setVisibility(8);
              TextView textView = StartLiveView.j(this.c);
              if (!TextUtils.isEmpty(this.a)) {
                str = this.a;
              } else {
                str = this.c.getResources().getString(R.string.Live_applyHost_wormNotice);
              } 
              textView.setText(str);
              textView = StartLiveView.k(this.c);
              if (!TextUtils.isEmpty(this.b)) {
                str = this.b;
              } else {
                str = this.c.getResources().getString(R.string.unknown_error);
              } 
              textView.setText(str);
              StartLiveView.l(this.c).setVisibility(0);
              AnimationUtils.a(StartLiveView.l(this.c));
            } 
          }
        });
  }
  
  private void i() {
    this.aa = DialogUtils.a(this.a);
    this.b = LayoutInflater.from(this.a);
    this.c = this.b.inflate(R.layout.live_start_view, (ViewGroup)this);
    this.d = (LinearLayout)this.c.findViewById(R.id.lay_live_ori_switch);
    this.e = (RelativeLayout)this.c.findViewById(R.id.lay_portrait);
    this.f = (TextView)this.c.findViewById(R.id.portrait);
    this.g = (RelativeLayout)this.c.findViewById(R.id.lay_landscape);
    this.h = (TextView)this.c.findViewById(R.id.landscape);
    this.i = (ImageView)this.c.findViewById(R.id.live_start_switch_camera_btn);
    this.j = (ImageView)this.c.findViewById(R.id.live_start_close_btn);
    this.k = (EditText)this.c.findViewById(R.id.live_start_edit_view);
    this.l = this.c.findViewById(R.id.live_start_edit_layout);
    this.m = this.c.findViewById(R.id.keyboard_view);
    this.n = (LinearLayout)this.c.findViewById(R.id.bottom_layout);
    this.o = (LinearLayout)this.c.findViewById(R.id.blued_layout);
    this.p = (ImageView)this.c.findViewById(R.id.blued_btn);
    this.q = (Button)this.c.findViewById(R.id.call_friend_num);
    this.r = (ImageView)this.c.findViewById(R.id.weixin_btn);
    this.s = (ImageView)this.c.findViewById(R.id.friends_btn);
    this.t = (ImageView)this.c.findViewById(R.id.qq_btn);
    this.u = (ImageView)this.c.findViewById(R.id.weibo_btn);
    this.v = (ImageView)this.c.findViewById(R.id.live_start_beauty_btn);
    this.w = (Button)this.c.findViewById(R.id.start_live_btn);
    this.x = (TextView)this.c.findViewById(R.id.live_game_details);
    this.z = (ImageView)this.c.findViewById(R.id.live_game_details_icon);
    this.y = (TextView)this.c.findViewById(R.id.live_lover_details);
    this.A = this.c.findViewById(R.id.live_lover_details_icon);
    this.B = (LinearLayout)this.c.findViewById(R.id.live_nearby_layout);
    this.C = (ImageView)this.c.findViewById(R.id.live_nearby_btn);
    this.D = (TextView)this.c.findViewById(R.id.tv_show_in_nearby);
    this.E = this.c.findViewById(R.id.live_create_layout);
    this.F = this.c.findViewById(R.id.live_start_error_layout_tips);
    this.ad = (TextView)this.F.findViewById(R.id.error_tips_title);
    this.G = (Button)this.F.findViewById(R.id.error_tips_btn);
    this.H = (TextView)this.F.findViewById(R.id.error_tips_message);
    this.I = this.c.findViewById(R.id.live_start_beauty_layout);
    this.ae = this.c.findViewById(R.id.ll_live_show);
    this.af = this.c.findViewById(R.id.ll_live_lover);
    this.ag = this.c.findViewById(R.id.tv_line_show);
    this.ah = this.c.findViewById(R.id.tv_line_lover);
    this.ak = (TextView)this.c.findViewById(R.id.tv_live_show);
    this.al = (TextView)this.c.findViewById(R.id.tv_live_lover);
    this.ai = this.c.findViewById(R.id.rl_show_tip);
    this.aj = this.c.findViewById(R.id.rl_lover_tip);
    this.c.setBackgroundResource(R.drawable.live_start_game_bg);
    this.ab = (ViewGroup)this.c.findViewById(R.id.live_start_gesture_guide_layout);
    this.ac = (ViewGroup)this.c.findViewById(R.id.live_start_beauty_guide_layout);
    if (LiveRoomInfo.a().i()) {
      this.D.setText(R.string.live_show_up_with_hidden);
    } else {
      this.D.setText(R.string.live_show_up);
    } 
    TextView textView = this.x;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("<u>");
    stringBuilder.append(this.a.getString(R.string.live_game_details));
    stringBuilder.append("</u>");
    textView.setText((CharSequence)Html.fromHtml(stringBuilder.toString()));
    textView = this.y;
    stringBuilder = new StringBuilder();
    stringBuilder.append("<u>");
    stringBuilder.append(this.a.getString(R.string.live_lover_title));
    stringBuilder.append("</u>");
    textView.setText((CharSequence)Html.fromHtml(stringBuilder.toString()));
    if (LiveRoomPreferences.f() == 0)
      this.z.setVisibility(0); 
    this.U = LiveRoomPreferences.u();
    if (this.U) {
      this.C.setVisibility(0);
    } else {
      this.C.setVisibility(8);
    } 
    if (this.J.ca == 0) {
      this.d.setVisibility(8);
      this.an = false;
    } else if (this.J.ca == 1) {
      this.d.setVisibility(0);
      this.an = true;
    } 
    if (AppInfo.m()) {
      this.d.setVisibility(0);
      this.an = true;
    } 
    this.f.setSelected(true);
    this.h.setSelected(false);
    if (TextUtils.isEmpty(LiveRoomPreferences.e()))
      LiveRoomPreferences.d(Constants.WechatMomentsNAME); 
    String str = LiveRoomPreferences.e();
    if (str.equals(Constants.SinaWeiboNAME)) {
      this.u.setImageResource(R.drawable.share_weibo_selected);
      this.L = Constants.SinaWeiboNAME;
      this.M = true;
    } else if (str.equals(Constants.WechatNAME)) {
      this.r.setImageResource(R.drawable.share_weixin_selected);
      this.L = Constants.WechatNAME;
      this.N = true;
    } else if (str.equals(Constants.WechatMomentsNAME)) {
      this.s.setImageResource(R.drawable.share_friends_selected);
      this.L = Constants.WechatMomentsNAME;
      this.O = true;
    } else if (str.equals(Constants.QQNAME)) {
      this.t.setImageResource(R.drawable.share_qq_selected);
      this.L = Constants.QQNAME;
      this.P = true;
    } else {
      this.L = "";
    } 
    this.K = new LoadOptions();
    this.K.d = R.drawable.user_bg_round;
    this.K.b = R.drawable.user_bg_round;
    if (LiveRoomManager.a().B()) {
      int i;
      this.c.setBackgroundResource(R.drawable.live_start_game_bg);
      this.l.setVisibility(4);
      this.k.setHint("");
      this.k.setEnabled(false);
      this.B.setVisibility(4);
      this.w.setEnabled(false);
      this.w.setBackgroundResource(R.drawable.shape_start_live_btn_enabled);
      this.I.setVisibility(8);
      this.i.setVisibility(8);
      if (this.J.cb != 0) {
        i = this.J.cb;
      } else {
        i = this.Q;
      } 
      Logger.a("drb", new Object[] { "countdown = ", Integer.valueOf(i) });
      this.R = (new CountDownTimer(this, (i * 1000), 500L) {
          public void onFinish() {
            StartLiveView.a(this.a).setEnabled(true);
            StartLiveView.a(this.a).setBackgroundResource(R.drawable.live_start_btn_bg);
            StartLiveView.a(this.a).setText(R.string.liveVideo_createLive_label_startToLiveButton);
          }
          
          public void onTick(long param1Long) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(param1Long / 1000L + 1L);
            stringBuilder1.append("");
            String str = stringBuilder1.toString();
            Button button = StartLiveView.a(this.a);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("s");
            button.setText(stringBuilder2.toString());
          }
        }).start();
    } else {
      g();
      LiveRoomInfo.a().a(new PermissionCallbacks(this) {
            public void a(String[] param1ArrayOfString) {
              StartLiveView.b(this.a).setBackgroundResource(R.drawable.live_start_game_bg);
            }
            
            public void aa_() {
              StartLiveView.b(this.a).setBackgroundResource(R.color.transparent);
            }
          });
    } 
    this.e.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.w.setOnClickListener(this);
    this.G.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.B.setOnClickListener(this);
    this.x.setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.ac.setOnClickListener(this);
    this.ae.setOnClickListener(this);
    this.af.setOnClickListener(this);
    this.k.addTextChangedListener(this.ao);
  }
  
  private void j() {
    this.V = true;
    ImageFileLoader.a((IRequestHost)this.J.w_()).b(LiveRoomInfo.a().d()).a(new ImageFileLoader.OnLoadFileListener(this) {
          public void onUIFinish(File param1File, Exception param1Exception) {
            String str;
            if (param1File != null && param1File.exists()) {
              Bitmap bitmap = BitmapFactory.decodeFile(param1File.getPath());
            } else {
              param1Exception = null;
            } 
            if (LiveRoomManager.a().B()) {
              if (!TextUtils.isEmpty(StartLiveView.c(this.a))) {
                str = StartLiveView.c(this.a);
              } else {
                str = StartLiveView.d(this.a).getString(R.string.live_game_share);
              } 
            } else {
              str = "";
            } 
            LiveRoomInfo.a().a(StartLiveView.d(this.a), LiveRoomManager.a().h(), StartLiveView.e(this.a), str, StartLiveView.f(this.a).getText().toString(), StartLiveView.g(this.a), (Bitmap)param1Exception);
          }
        }).a();
  }
  
  private void k() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void l() {
    LiveRoomData liveRoomData = LiveRoomManager.a().h();
    boolean bool = false;
    if (liveRoomData == null || TextUtils.isEmpty((LiveRoomManager.a().h()).publish_url)) {
      Logger.a("pk", new Object[] { "startLive failed" });
      a((String)null, (String)null);
      return;
    } 
    this.E.setVisibility(8);
    this.V = false;
    a(this.J.u);
    setVisibility(8);
    this.J.X();
    Observable observable = LiveEventBus.get("live_luck_turning_btn");
    if ((LiveRoomManager.a().h()).entrance_status == 1)
      bool = true; 
    observable.post(Boolean.valueOf(bool));
    if (LiveRoomManager.a().B()) {
      this.J.T();
      return;
    } 
    this.J.d(this.am);
  }
  
  private void m() {
    this.f.setSelected(true);
    this.h.setSelected(false);
    this.J.be = false;
  }
  
  private void n() {
    this.f.setSelected(false);
    this.h.setSelected(true);
    this.J.be = true;
  }
  
  private void o() {
    if (!TextUtils.isEmpty(this.L)) {
      j();
      return;
    } 
    l();
  }
  
  public void a() {
    if (this.V && !TextUtils.isEmpty(this.L))
      l(); 
  }
  
  public void a(int paramInt) {
    if (paramInt != -3) {
      if (paramInt != -2)
        return; 
      Logger.a("pk", new Object[] { "键盘隐藏" });
      this.m.setVisibility(8);
      return;
    } 
    Logger.a("pk", new Object[] { "键盘打开" });
    AppInfo.n().post(new Runnable(this) {
          public void run() {
            StartLiveView.m(this.a).setVisibility(0);
            StartLiveView.m(this.a).setOnTouchListener(new View.OnTouchListener(this) {
                  public boolean onTouch(View param2View, MotionEvent param2MotionEvent) {
                    KeyboardUtils.a((Activity)StartLiveView.h(this.a.a).getActivity());
                    return true;
                  }
                });
          }
        });
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1) {
      if (paramInt1 != 10111)
        return; 
      this.S = paramIntent.getStringArrayExtra("CHOOSED_UID");
      this.T = paramIntent.getStringArrayExtra("CHOOSED_TYPE");
      String[] arrayOfString = this.S;
      if (arrayOfString != null && arrayOfString.length > 0) {
        this.p.setImageResource(R.drawable.share_blued_selected);
        Button button = this.q;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.S.length);
        stringBuilder.append("");
        button.setText(stringBuilder.toString());
        this.q.setVisibility(0);
        return;
      } 
      this.p.setImageResource(R.drawable.share_blued_default);
      this.q.setVisibility(8);
    } 
  }
  
  public void a(RecordingOnliveFragment paramRecordingOnliveFragment) {
    this.J = paramRecordingOnliveFragment;
    i();
    d();
  }
  
  public void b() {
    CountDownTimer countDownTimer = this.R;
    if (countDownTimer != null)
      countDownTimer.cancel(); 
  }
  
  public boolean c() {
    boolean bool;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" start onBackPressed:");
    if (this.E.getVisibility() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder.append(bool);
    stringBuilder.append("--");
    if (this.F.getVisibility() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder.append(bool);
    Logger.a("pk", new Object[] { stringBuilder.toString() });
    if (this.E.getVisibility() == 0)
      return true; 
    if (this.F.getVisibility() == 0) {
      this.G.performClick();
      return true;
    } 
    if (this.ab.getVisibility() == 0) {
      h();
      return true;
    } 
    if (getVisibility() == 0) {
      Logger.a("pk", new Object[] { "finish" });
      this.J.ak();
      return true;
    } 
    return false;
  }
  
  public void d() {
    if (LiveRoomManager.a().h() != null)
      EventTrackLive.b(LiveProtos.Event.LIVE_PREPARE, LiveRoomManager.a().e()); 
    InstantLogBody instantLogBody = new InstantLogBody();
    instantLogBody.service = "live_prepare";
    instantLogBody.event = 20001;
    InstantLog.a(instantLogBody);
  }
  
  public void e() {
    this.n.setVisibility(8);
  }
  
  public void f() {
    this.n.setVisibility(0);
  }
  
  public void g() {
    if (LiveRoomPreferences.i() == 0) {
      LiveRoomPreferences.d(1);
      this.ab.setVisibility(0);
      this.ac.setVisibility(0);
    } 
  }
  
  public void getLiveShareContent() {
    LiveRoomHttpUtils.a(LiveRoomInfo.a().f(), new BluedUIHttpResponse<BluedEntityA<LiveShareTextModel>>(this, (IRequestHost)this.J.w_()) {
          protected void a(BluedEntityA<LiveShareTextModel> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0)
              StartLiveView.a(this.a, ((LiveShareTextModel)param1BluedEntityA.data.get(0)).copywriting); 
            StartLiveView.s(this.a);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            StartLiveView.s(this.a);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
          }
          
          public void onUIStart() {
            super.onUIStart();
          }
        }(IRequestHost)this.J.w_());
  }
  
  public void h() {
    this.ab.setVisibility(8);
    this.ac.setVisibility(8);
  }
  
  public void onClick(View paramView) {
    LiveProtos.LiveType liveType;
    if (paramView.getId() == R.id.live_start_close_btn) {
      this.J.ak();
      return;
    } 
    if (paramView.getId() == R.id.blued_btn) {
      EventTrackLive.b(LiveProtos.Event.LIVE_START_SHARE_FEED, LiveRoomInfo.a().f());
      InstantLog.a("live_start_share_feed");
      LiveRoomInfo.a().a(this.J, 10111, 8, this.a.getResources().getString(R.string.liveVideo_selectFriends_label_description), this.S);
      return;
    } 
    if (paramView.getId() == R.id.blued_layout) {
      LiveRoomInfo.a().a(this.J, 10111, 8, this.a.getResources().getString(R.string.liveVideo_selectFriends_label_description), this.S);
      return;
    } 
    if (paramView.getId() == R.id.error_tips_btn) {
      this.F.setVisibility(8);
      return;
    } 
    if (paramView.getId() == R.id.start_live_btn) {
      LiveProtos.Event event = LiveProtos.Event.ANCHOR_SETTING_START_CLICK;
      if (this.am) {
        liveType = LiveProtos.LiveType.BLIND_DATING_LIVE;
      } else {
        liveType = LiveProtos.LiveType.SHOW_LIVE;
      } 
      EventTrackLive.a(event, liveType);
      LiveRoomInfo.a().a(new PermissionCallbacks(this) {
            public void a(String[] param1ArrayOfString) {}
            
            public void aa_() {
              LiveRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<StartLiveDialog>>(this, (IRequestHost)StartLiveView.h(this.a).w_()) {
                    protected void a(BluedEntityA<StartLiveDialog> param2BluedEntityA) {
                      if (param2BluedEntityA != null && param2BluedEntityA.hasData()) {
                        String str;
                        StartLiveDialog startLiveDialog = (StartLiveDialog)param2BluedEntityA.getSingleData();
                        if (startLiveDialog.need_popup == 1) {
                          String str1 = startLiveDialog.confirm_url;
                          String str2 = startLiveDialog.confirm_text;
                          String str3 = startLiveDialog.cancel_text;
                          str = startLiveDialog.popup_title;
                          CommonAlertDialog.a(StartLiveView.d(this.a.a), null, StartLiveView.d(this.a.a).getResources().getString(R.string.hint), str, str3, str2, new DialogInterface.OnClickListener(this, str1) {
                                public void onClick(DialogInterface param3DialogInterface, int param3Int) {
                                  LiveRoomInfo.a().b(StartLiveView.d(this.b.a.a), this.a);
                                }
                              }new DialogInterface.OnClickListener(this) {
                                public void onClick(DialogInterface param3DialogInterface, int param3Int) {
                                  LiveFloatManager.a().m();
                                  StartLiveView.p(this.a.a.a);
                                }
                              },  new DialogInterface.OnCancelListener(this) {
                                public void onCancel(DialogInterface param3DialogInterface) {}
                              },  true);
                          return;
                        } 
                        if (((StartLiveDialog)str).need_popup == 2) {
                          String str1 = ((StartLiveDialog)str).popup_title;
                          str = ((StartLiveDialog)str).popup_content;
                          StartLiveView.a(this.a.a, str, str1);
                          return;
                        } 
                        LiveFloatManager.a().m();
                        StartLiveView.p(this.a.a);
                        return;
                      } 
                      LiveFloatManager.a().m();
                      StartLiveView.p(this.a.a);
                    }
                    
                    public void onUIFinish() {
                      super.onUIFinish();
                      DialogUtils.b(StartLiveView.o(this.a.a));
                    }
                    
                    public void onUIStart() {
                      super.onUIStart();
                      DialogUtils.a(StartLiveView.o(this.a.a));
                    }
                  }(IRequestHost)StartLiveView.h(this.a).w_());
            }
          });
      return;
    } 
    if (liveType.getId() == R.id.weibo_btn) {
      if (this.M) {
        this.u.setImageResource(R.drawable.share_weibo_default);
        this.M = false;
        this.L = "";
        LiveRoomPreferences.d("null");
        return;
      } 
      this.u.setImageResource(R.drawable.share_weibo_selected);
      this.r.setImageResource(R.drawable.share_weixin_default);
      this.s.setImageResource(R.drawable.share_friends_default);
      this.t.setImageResource(R.drawable.share_qq_default);
      this.M = true;
      this.N = false;
      this.O = false;
      this.P = false;
      this.L = Constants.SinaWeiboNAME;
      LiveRoomPreferences.d(this.L);
      return;
    } 
    if (liveType.getId() == R.id.weixin_btn) {
      if (this.N) {
        this.r.setImageResource(R.drawable.share_weixin_default);
        this.N = false;
        this.L = "";
        LiveRoomPreferences.d("null");
        return;
      } 
      this.u.setImageResource(R.drawable.share_weibo_default);
      this.r.setImageResource(R.drawable.share_weixin_selected);
      this.s.setImageResource(R.drawable.share_friends_default);
      this.t.setImageResource(R.drawable.share_qq_default);
      this.M = false;
      this.N = true;
      this.O = false;
      this.P = false;
      this.L = Constants.WechatNAME;
      LiveRoomPreferences.d(this.L);
      return;
    } 
    if (liveType.getId() == R.id.friends_btn) {
      if (this.O) {
        this.s.setImageResource(R.drawable.share_friends_default);
        this.O = false;
        this.L = "";
        LiveRoomPreferences.d("null");
        return;
      } 
      this.u.setImageResource(R.drawable.share_weibo_default);
      this.r.setImageResource(R.drawable.share_weixin_default);
      this.s.setImageResource(R.drawable.share_friends_selected);
      this.t.setImageResource(R.drawable.share_qq_default);
      this.M = false;
      this.N = false;
      this.O = true;
      this.P = false;
      this.L = Constants.WechatMomentsNAME;
      LiveRoomPreferences.d(this.L);
      return;
    } 
    if (liveType.getId() == R.id.qq_btn) {
      if (this.P) {
        this.t.setImageResource(R.drawable.share_qq_default);
        this.P = false;
        this.L = "";
        LiveRoomPreferences.d("null");
        return;
      } 
      this.u.setImageResource(R.drawable.share_weibo_default);
      this.r.setImageResource(R.drawable.share_weixin_default);
      this.s.setImageResource(R.drawable.share_friends_default);
      this.t.setImageResource(R.drawable.share_qq_selected);
      this.M = false;
      this.N = false;
      this.O = false;
      this.P = true;
      this.L = Constants.QQNAME;
      LiveRoomPreferences.d(this.L);
      return;
    } 
    if (liveType.getId() == R.id.lay_portrait) {
      if (this.am)
        return; 
      m();
      return;
    } 
    if (liveType.getId() == R.id.lay_landscape) {
      if (this.am)
        return; 
      n();
      return;
    } 
    if (liveType.getId() == R.id.live_nearby_layout) {
      if (this.U) {
        CommonAlertDialog.a((Context)this.J.getActivity(), "", this.a.getString(R.string.live_show_up_details), this.a.getString(R.string.biao_v4_ok), new DialogInterface.OnClickListener(this) {
              public void onClick(DialogInterface param1DialogInterface, int param1Int) {
                StartLiveView.q(this.a).setVisibility(8);
                LiveRoomPreferences.a(false);
                StartLiveView.a(this.a, false);
              }
            }this.a.getString(R.string.cancel), null, null);
        return;
      } 
      this.C.setVisibility(0);
      LiveRoomPreferences.a(true);
      this.U = true;
      return;
    } 
    if (liveType.getId() == R.id.live_game_details) {
      LiveRoomPreferences.a(1);
      this.z.setVisibility(4);
      LiveRoomInfo.a().b((Context)this.J.getActivity(), "https://activity.blued.cn/hd/2018-game-live#/");
      return;
    } 
    if (liveType.getId() == R.id.live_lover_details) {
      EventTrackLive.a(LiveProtos.Event.ANCHOR_SETTING_BLIND_DATING_CLICK);
      this.A.setVisibility(4);
      LiveRoomInfo.a().b((Context)this.J.getActivity(), LiveRoomInfo.a().D());
      return;
    } 
    if (liveType.getId() == R.id.live_start_switch_camera_btn) {
      this.J.switchCamera((View)liveType);
      return;
    } 
    if (liveType.getId() == R.id.live_start_beauty_btn) {
      this.J.am();
      EventTrackLive.a(LiveProtos.Event.START_LIVE_BEAUTY_BTN_CLICK);
      return;
    } 
    if (liveType.getId() == R.id.live_start_beauty_guide_layout) {
      h();
      return;
    } 
    if (liveType.getId() == R.id.ll_live_show) {
      this.am = false;
      if (this.an)
        this.d.setVisibility(0); 
      this.aj.setVisibility(8);
      this.ai.setVisibility(0);
      this.ag.setVisibility(0);
      this.ah.setVisibility(4);
      this.ak.setTextColor(getResources().getColor(R.color.syc_dark_b));
      this.al.setTextColor(getResources().getColor(R.color.syc_dark_z));
      return;
    } 
    if (liveType.getId() == R.id.ll_live_lover) {
      this.am = true;
      m();
      this.d.setVisibility(4);
      this.aj.setVisibility(0);
      this.ai.setVisibility(8);
      this.ag.setVisibility(4);
      this.ah.setVisibility(0);
      this.ak.setTextColor(getResources().getColor(R.color.syc_dark_z));
      this.al.setTextColor(getResources().getColor(R.color.syc_dark_b));
      if (LiveRoomPreferences.g() == 0) {
        LiveRoomPreferences.b(1);
        this.A.setVisibility(0);
        this.A.postDelayed(new Runnable(this) {
              public void run() {
                if (StartLiveView.r(this.a) != null)
                  StartLiveView.r(this.a).setVisibility(4); 
              }
            },  5000L);
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\StartLiveView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */