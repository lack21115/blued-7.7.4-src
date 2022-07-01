package com.soft.blued.ui.msg;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.chat.VideoChatHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.view.CustomDialog;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.msg.manager.ChannelManager;
import com.soft.blued.ui.msg.model.ChannelModel;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.NetworkUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import java.io.Serializable;

public class ChannelFragment extends BaseFragment implements View.OnClickListener, Chronometer.OnChronometerTickListener {
  public static final String d = ChannelFragment.class.getSimpleName();
  
  private Chronometer A;
  
  private TextView B;
  
  private LinearLayout C;
  
  private LinearLayout D;
  
  private LinearLayout E;
  
  private LinearLayout F;
  
  private LinearLayout G;
  
  private ImageView H;
  
  private ImageView I;
  
  private RelativeLayout J;
  
  private RelativeLayout K;
  
  private ImageView L;
  
  private TextView M;
  
  private TextView N;
  
  private ImageView O;
  
  private TextView P;
  
  private ImageView Q;
  
  private TextView R;
  
  private RelativeLayout S;
  
  private ImageView T;
  
  private ImageView U;
  
  private TextView V;
  
  private ImageView W;
  
  private ChannelManager X;
  
  private View Y;
  
  private boolean Z;
  
  private long aa = -1L;
  
  private int ab = -1;
  
  private boolean ac;
  
  private CustomDialog ad;
  
  private boolean ae;
  
  private String af = "";
  
  private String ag = "";
  
  public FrameLayout e;
  
  public FrameLayout f;
  
  ChannelModel g;
  
  public long h = 0L;
  
  Runnable i = new Runnable(this) {
      public void run() {
        if (this.a.h > 0L && ChannelFragment.h(this.a) != null && (ChannelFragment.h(this.a)).a != null && !(ChannelFragment.h(this.a)).a.isDestroyed()) {
          (ChannelFragment.h(this.a)).a.updateCallTime((int)this.a.h);
          ChannelFragment.i(this.a);
          Logger.b(ChannelFragment.d, new Object[] { "mTimer:", Long.valueOf(this.a.h) });
        } 
      }
    };
  
  Runnable j = new Runnable(this) {
      public void run() {
        if (!ChannelFragment.j(this.a))
          this.a.a(true); 
      }
    };
  
  Runnable k = new Runnable(this) {
      public void run() {
        if (!ChannelFragment.j(this.a))
          this.a.a(false); 
      }
    };
  
  Runnable l = new Runnable(this) {
      public void run() {
        if (this.a.g.callType == 4) {
          ChannelFragment.k(this.a).setVisibility(8);
          ChannelFragment.g(this.a).setTextColor(Color.parseColor("#00ffffff"));
          AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
          alphaAnimation.setFillAfter(false);
          alphaAnimation.setDuration(500L);
          ChannelFragment.k(this.a).setAnimation((Animation)alphaAnimation);
          alphaAnimation.start();
        } 
      }
    };
  
  Runnable m = new Runnable(this) {
      public void run() {
        if (!ChannelFragment.j(this.a))
          this.a.a(false); 
      }
    };
  
  private Context n;
  
  private RelativeLayout o;
  
  private RelativeLayout p;
  
  private ImageView q;
  
  private RelativeLayout r;
  
  private ImageView s;
  
  private TextView t;
  
  private TextView u;
  
  private TextView v;
  
  private TextView w;
  
  private TextView x;
  
  private RelativeLayout y;
  
  private View z;
  
  private void A() {
    AppInfo.n().removeCallbacks(this.i);
    AppInfo.n().removeCallbacks(this.j);
    AppInfo.n().removeCallbacks(this.m);
    AppInfo.n().removeCallbacks(this.k);
    AppInfo.n().removeCallbacks(this.l);
  }
  
  private void B() {
    int i = this.ab;
    if (i >= 0) {
      long l = i - this.h;
      i = l cmp 30L;
      if (i <= 0) {
        this.af = String.format(getString(2131755765), new Object[] { "30" });
        this.ag = String.format(getString(2131755790), new Object[] { "30" });
      } else if (i > 0 && l <= 60L) {
        this.af = String.format(getString(2131755766), new Object[] { "1" });
        this.ag = String.format(getString(2131755791), new Object[] { "1" });
      } else if (l > 60L && l <= 120L) {
        this.af = String.format(getString(2131755766), new Object[] { "2" });
        this.ag = String.format(getString(2131755791), new Object[] { "2" });
      } else if (l > 120L && l <= 180L) {
        this.af = String.format(getString(2131755766), new Object[] { "3" });
        this.ag = String.format(getString(2131755791), new Object[] { "3" });
      } else if (l > 180L && l <= 240L) {
        this.af = String.format(getString(2131755766), new Object[] { "4" });
        this.ag = String.format(getString(2131755791), new Object[] { "4" });
      } else if (l > 240L && l <= 300L) {
        this.af = String.format(getString(2131755766), new Object[] { "5" });
        this.ag = String.format(getString(2131755791), new Object[] { "5" });
      } else {
        this.af = "";
        this.ag = "";
      } 
    } else {
      this.af = "";
      this.ag = "";
    } 
    this.w.setText(this.af);
    this.x.setText(this.ag);
    this.R.setText(this.ag);
  }
  
  public static void a(Context paramContext, ChannelModel paramChannelModel) {
    // Byte code:
    //   0: ldc com/soft/blued/ui/msg/ChannelFragment
    //   2: monitorenter
    //   3: aload_1
    //   4: getfield callType : I
    //   7: ifeq -> 36
    //   10: iconst_2
    //   11: aload_1
    //   12: getfield callType : I
    //   15: if_icmpne -> 21
    //   18: goto -> 36
    //   21: new com/soft/blued/ui/msg/ChannelFragment$2
    //   24: dup
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial <init> : (Landroid/content/Context;Lcom/soft/blued/ui/msg/model/ChannelModel;)V
    //   30: invokestatic d : (Lcom/blued/android/framework/permission/PermissionCallbacks;)V
    //   33: goto -> 48
    //   36: new com/soft/blued/ui/msg/ChannelFragment$1
    //   39: dup
    //   40: aload_0
    //   41: aload_1
    //   42: invokespecial <init> : (Landroid/content/Context;Lcom/soft/blued/ui/msg/model/ChannelModel;)V
    //   45: invokestatic f : (Lcom/blued/android/framework/permission/PermissionCallbacks;)V
    //   48: ldc com/soft/blued/ui/msg/ChannelFragment
    //   50: monitorexit
    //   51: return
    //   52: astore_0
    //   53: ldc com/soft/blued/ui/msg/ChannelFragment
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Exception table:
    //   from	to	target	type
    //   3	18	52	finally
    //   21	33	52	finally
    //   36	48	52	finally
  }
  
  private static void c(Context paramContext, ChannelModel paramChannelModel) {
    if (!AppMethods.c(16)) {
      AppMethods.a(AppInfo.d().getResources().getString(2131757957));
      return;
    } 
    if (paramChannelModel == null)
      return; 
    LiveFloatManager.a().m();
    Bundle bundle = new Bundle();
    if (paramChannelModel.callType == 0 || paramChannelModel.callType == 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(System.currentTimeMillis() / 1000L);
      stringBuilder.append("_");
      stringBuilder.append(EncryptTool.b(UserInfo.a().i().getUid()));
      paramChannelModel.channelId = stringBuilder.toString();
    } 
    Logger.b(d, new Object[] { "channelId:", paramChannelModel.channelId, "remoteUid:", Integer.valueOf(paramChannelModel.remoteUid) });
    bundle.putSerializable("CHANNEL", (Serializable)paramChannelModel);
    TerminalActivity.a(bundle);
    TerminalActivity.b(bundle);
    TerminalActivity.d(paramContext, ChannelFragment.class, bundle);
  }
  
  private void p() {
    boolean bool;
    getActivity().getWindow().addFlags(128);
    this.g = (ChannelModel)getArguments().getSerializable("CHANNEL");
    if (this.g == null)
      this.g = new ChannelModel(); 
    if (this.g.callType == 0 || this.g.callType == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    this.ac = bool;
    ChannelModel channelModel = this.g;
    if (channelModel != null && channelModel.callType == 2 && this.g.has_screenshot == 1)
      ToastUtils.a(getString(2131758070)); 
  }
  
  private void q() {
    this.e = (FrameLayout)this.Y.findViewById(2131301580);
    this.f = (FrameLayout)this.Y.findViewById(2131301582);
    this.f.setOnClickListener(this);
    this.o = (RelativeLayout)this.Y.findViewById(2131299621);
    this.p = (RelativeLayout)this.Y.findViewById(2131299624);
    this.q = (ImageView)this.Y.findViewById(2131299623);
    this.r = (RelativeLayout)this.Y.findViewById(2131297359);
    this.s = (ImageView)this.Y.findViewById(2131297362);
    this.t = (TextView)this.Y.findViewById(2131299643);
    this.u = (TextView)this.Y.findViewById(2131299622);
    this.v = (TextView)this.Y.findViewById(2131300268);
    this.w = (TextView)this.Y.findViewById(2131301581);
    this.x = (TextView)this.Y.findViewById(2131299642);
    this.y = (RelativeLayout)this.Y.findViewById(2131296689);
    this.z = this.Y.findViewById(2131296553);
    this.A = (Chronometer)this.Y.findViewById(2131296740);
    this.B = (TextView)this.Y.findViewById(2131300155);
    this.C = (LinearLayout)this.Y.findViewById(2131296690);
    this.D = (LinearLayout)this.Y.findViewById(2131296696);
    this.E = (LinearLayout)this.Y.findViewById(2131296687);
    this.F = (LinearLayout)this.Y.findViewById(2131296686);
    this.G = (LinearLayout)this.Y.findViewById(2131296693);
    this.H = (ImageView)this.Y.findViewById(2131296691);
    this.I = (ImageView)this.Y.findViewById(2131296692);
    this.J = (RelativeLayout)this.Y.findViewById(2131297993);
    this.K = (RelativeLayout)this.Y.findViewById(2131297997);
    this.L = (ImageView)this.Y.findViewById(2131297998);
    this.M = (TextView)this.Y.findViewById(2131297999);
    this.N = (TextView)this.Y.findViewById(2131297996);
    this.O = (ImageView)this.Y.findViewById(2131297994);
    this.P = (TextView)this.Y.findViewById(2131301716);
    this.Q = (ImageView)this.Y.findViewById(2131297992);
    this.R = (TextView)this.Y.findViewById(2131297995);
    this.S = (RelativeLayout)this.Y.findViewById(2131296354);
    this.T = (ImageView)this.Y.findViewById(2131296353);
    this.U = (ImageView)this.Y.findViewById(2131296355);
    this.V = (TextView)this.Y.findViewById(2131296356);
    this.W = (ImageView)this.Y.findViewById(2131296352);
    this.C.setTag(Boolean.valueOf(false));
    this.G.setTag(Boolean.valueOf(true));
    this.e.setOnClickListener(this);
    this.Q.setOnClickListener(this);
    this.O.setOnClickListener(this);
    this.W.setOnClickListener(this);
    this.T.setOnClickListener(this);
    this.U.setOnClickListener(this);
    this.C.setOnClickListener(this);
    this.D.setOnClickListener(this);
    this.E.setOnClickListener(this);
    this.F.setOnClickListener(this);
    this.G.setOnClickListener(this);
    r();
    this.H.setSelected(false);
    this.I.setSelected(true);
    this.A.setText("00:00");
    this.A.setOnChronometerTickListener(this);
    AppInfo.n().postDelayed(this.j, 30000L);
    y();
    this.X = new ChannelManager(this, this.g);
    this.X.a(false);
    int i = this.g.callType;
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
          return; 
        if (NetworkUtils.a()) {
          a(getString(2131755796), 1);
          return;
        } 
      } else {
        this.X.a();
        return;
      } 
    } else {
      if (NetworkUtils.a()) {
        a(getString(2131755796), 1);
        return;
      } 
      this.X.a();
    } 
  }
  
  private void r() {
    Logger.b(d, new Object[] { "mChannelModel type:", Integer.valueOf(this.g.callType) });
    int i = this.g.callType;
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 4) {
              if (i != 5)
                return; 
              x();
              return;
            } 
            w();
            return;
          } 
          v();
          return;
        } 
        u();
        return;
      } 
      t();
      return;
    } 
    s();
  }
  
  private void s() {
    this.e.setVisibility(0);
    this.f.setVisibility(0);
    this.o.setVisibility(8);
    this.w.setVisibility(8);
    this.x.setVisibility(8);
    this.y.setVisibility(8);
    this.J.setVisibility(0);
    this.K.setVisibility(0);
    this.O.setVisibility(0);
    this.P.setVisibility(0);
    this.R.setVisibility(0);
    this.S.setVisibility(8);
  }
  
  private void t() {
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    this.o.setVisibility(0);
    this.r.setVisibility(0);
    this.w.setVisibility(8);
    this.x.setVisibility(0);
    this.y.setVisibility(8);
    this.J.setVisibility(0);
    this.K.setVisibility(8);
    this.O.setVisibility(8);
    this.P.setVisibility(8);
    this.R.setVisibility(8);
    this.S.setVisibility(8);
  }
  
  private void u() {
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    this.o.setVisibility(0);
    this.r.setVisibility(0);
    this.u.setText(this.n.getResources().getString(2131755763));
    this.w.setVisibility(8);
    this.x.setVisibility(0);
    this.y.setVisibility(8);
    this.J.setVisibility(8);
    this.R.setVisibility(8);
    this.S.setVisibility(0);
    this.V.setVisibility(0);
    this.U.setVisibility(0);
  }
  
  private void v() {
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    this.o.setVisibility(0);
    this.r.setVisibility(0);
    this.u.setText(this.n.getResources().getString(2131755764));
    this.w.setVisibility(8);
    this.x.setVisibility(0);
    this.y.setVisibility(8);
    this.J.setVisibility(8);
    this.R.setVisibility(8);
    this.S.setVisibility(0);
    this.V.setVisibility(8);
    this.U.setVisibility(8);
  }
  
  private void w() {
    this.e.setVisibility(0);
    this.f.setVisibility(0);
    this.o.setVisibility(8);
    this.r.setVisibility(8);
    this.u.setVisibility(8);
    this.w.setVisibility(0);
    this.x.setVisibility(8);
    this.y.setVisibility(0);
    this.D.setVisibility(0);
    this.E.setVisibility(0);
    this.F.setVisibility(0);
    this.G.setVisibility(8);
    this.C.setVisibility(8);
    this.J.setVisibility(8);
    this.R.setVisibility(8);
    this.S.setVisibility(8);
    this.A.setTextColor(Color.parseColor("#ffffff"));
    this.y.postDelayed(this.l, 5000L);
  }
  
  private void x() {
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    this.o.setVisibility(0);
    this.r.setVisibility(0);
    this.u.setVisibility(8);
    this.w.setVisibility(0);
    this.x.setVisibility(8);
    this.y.setVisibility(0);
    this.E.setVisibility(0);
    this.C.setVisibility(0);
    this.G.setVisibility(0);
    this.D.setVisibility(8);
    this.F.setVisibility(8);
    this.J.setVisibility(8);
    this.R.setVisibility(8);
    this.S.setVisibility(8);
    this.G.performClick();
    this.y.setBackgroundResource(0);
  }
  
  private void y() {
    BluedUIHttpResponse<BluedEntityA<UserInfoEntity>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<UserInfoEntity>>(this, (IRequestHost)w_()) {
        protected void a(BluedEntityA<UserInfoEntity> param1BluedEntityA) {
          if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
            UserInfoEntity userInfoEntity = param1BluedEntityA.data.get(0);
            if (userInfoEntity != null) {
              this.a.g.remoteUserName = userInfoEntity.name;
              this.a.g.remoteUserHead = AvatarUtils.a(0, userInfoEntity.avatar);
              ImageLoader.a((IRequestHost)this.a.w_(), this.a.g.remoteUserHead).a(2131231230).c().a(ChannelFragment.b(this.a));
              ImageLoader.a((IRequestHost)this.a.w_(), this.a.g.remoteUserHead).a(ChannelFragment.c(this.a));
              ImageLoader.a((IRequestHost)this.a.w_(), this.a.g.remoteUserHead).a(2131231230).a(2.0F).a(ChannelFragment.d(this.a));
              ChannelFragment.e(this.a).setText(this.a.g.remoteUserName);
              ChannelFragment.f(this.a).setText(this.a.g.remoteUserName);
            } 
          } 
        }
      };
    UserHttpUtils.a(this.n, bluedUIHttpResponse, String.valueOf(this.g.remoteUid), "", false, 0, 0, 0, (IRequestHost)w_());
  }
  
  private void z() {
    AppInfo.n().postDelayed(this.i, 30000L);
  }
  
  public boolean V_() {
    a(false);
    return super.V_();
  }
  
  public SurfaceView a(SurfaceView paramSurfaceView) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   6: astore_2
    //   7: aload_2
    //   8: instanceof android/view/ViewGroup
    //   11: ifeq -> 22
    //   14: aload_2
    //   15: checkcast android/view/ViewGroup
    //   18: aload_1
    //   19: invokevirtual removeView : (Landroid/view/View;)V
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	26	finally
  }
  
  public void a() {
    AppInfo.n().postDelayed(this.k, 10000L);
  }
  
  public void a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/soft/blued/ui/msg/ChannelFragment.d : Ljava/lang/String;
    //   5: iconst_2
    //   6: anewarray java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc_w 'close reason:'
    //   14: aastore
    //   15: dup
    //   16: iconst_1
    //   17: iload_1
    //   18: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   21: aastore
    //   22: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aload_0
    //   26: invokespecial A : ()V
    //   29: aload_0
    //   30: getfield Z : Z
    //   33: ifne -> 558
    //   36: aload_0
    //   37: getfield n : Landroid/content/Context;
    //   40: ifnonnull -> 46
    //   43: goto -> 558
    //   46: ldc ''
    //   48: astore_2
    //   49: iconst_2
    //   50: iload_1
    //   51: if_icmpne -> 95
    //   54: aload_0
    //   55: getfield ac : Z
    //   58: ifeq -> 78
    //   61: aload_0
    //   62: getfield n : Landroid/content/Context;
    //   65: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   68: ldc_w 2131755770
    //   71: invokevirtual getString : (I)Ljava/lang/String;
    //   74: astore_2
    //   75: goto -> 398
    //   78: aload_0
    //   79: getfield n : Landroid/content/Context;
    //   82: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   85: ldc_w 2131755761
    //   88: invokevirtual getString : (I)Ljava/lang/String;
    //   91: astore_2
    //   92: goto -> 398
    //   95: iconst_4
    //   96: iload_1
    //   97: if_icmpne -> 219
    //   100: aload_0
    //   101: getfield g : Lcom/soft/blued/ui/msg/model/ChannelModel;
    //   104: getfield callType : I
    //   107: iconst_4
    //   108: if_icmpeq -> 202
    //   111: aload_0
    //   112: getfield g : Lcom/soft/blued/ui/msg/model/ChannelModel;
    //   115: getfield callType : I
    //   118: iconst_5
    //   119: if_icmpeq -> 202
    //   122: aload_0
    //   123: getfield g : Lcom/soft/blued/ui/msg/model/ChannelModel;
    //   126: getfield callType : I
    //   129: iconst_2
    //   130: if_icmpeq -> 202
    //   133: aload_0
    //   134: getfield g : Lcom/soft/blued/ui/msg/model/ChannelModel;
    //   137: getfield callType : I
    //   140: iconst_3
    //   141: if_icmpne -> 147
    //   144: goto -> 202
    //   147: aload_0
    //   148: getfield g : Lcom/soft/blued/ui/msg/model/ChannelModel;
    //   151: getfield callType : I
    //   154: ifne -> 174
    //   157: aload_0
    //   158: getfield n : Landroid/content/Context;
    //   161: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   164: ldc_w 2131755779
    //   167: invokevirtual getString : (I)Ljava/lang/String;
    //   170: astore_2
    //   171: goto -> 398
    //   174: aload_0
    //   175: getfield g : Lcom/soft/blued/ui/msg/model/ChannelModel;
    //   178: getfield callType : I
    //   181: iconst_1
    //   182: if_icmpne -> 398
    //   185: aload_0
    //   186: getfield n : Landroid/content/Context;
    //   189: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   192: ldc_w 2131755780
    //   195: invokevirtual getString : (I)Ljava/lang/String;
    //   198: astore_2
    //   199: goto -> 398
    //   202: aload_0
    //   203: getfield n : Landroid/content/Context;
    //   206: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   209: ldc_w 2131755778
    //   212: invokevirtual getString : (I)Ljava/lang/String;
    //   215: astore_2
    //   216: goto -> 398
    //   219: iconst_5
    //   220: iload_1
    //   221: if_icmpne -> 265
    //   224: aload_0
    //   225: getfield ac : Z
    //   228: ifeq -> 248
    //   231: aload_0
    //   232: getfield n : Landroid/content/Context;
    //   235: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   238: ldc_w 2131758046
    //   241: invokevirtual getString : (I)Ljava/lang/String;
    //   244: astore_2
    //   245: goto -> 398
    //   248: aload_0
    //   249: getfield n : Landroid/content/Context;
    //   252: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   255: ldc_w 2131757948
    //   258: invokevirtual getString : (I)Ljava/lang/String;
    //   261: astore_2
    //   262: goto -> 398
    //   265: bipush #6
    //   267: iload_1
    //   268: if_icmpne -> 288
    //   271: aload_0
    //   272: getfield n : Landroid/content/Context;
    //   275: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   278: ldc_w 2131755752
    //   281: invokevirtual getString : (I)Ljava/lang/String;
    //   284: astore_2
    //   285: goto -> 398
    //   288: iconst_1
    //   289: iload_1
    //   290: if_icmpne -> 334
    //   293: aload_0
    //   294: getfield ac : Z
    //   297: ifeq -> 317
    //   300: aload_0
    //   301: getfield n : Landroid/content/Context;
    //   304: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   307: ldc_w 2131755761
    //   310: invokevirtual getString : (I)Ljava/lang/String;
    //   313: astore_2
    //   314: goto -> 398
    //   317: aload_0
    //   318: getfield n : Landroid/content/Context;
    //   321: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   324: ldc_w 2131755770
    //   327: invokevirtual getString : (I)Ljava/lang/String;
    //   330: astore_2
    //   331: goto -> 398
    //   334: iconst_3
    //   335: iload_1
    //   336: if_icmpne -> 380
    //   339: aload_0
    //   340: getfield ac : Z
    //   343: ifeq -> 363
    //   346: aload_0
    //   347: getfield n : Landroid/content/Context;
    //   350: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   353: ldc_w 2131755761
    //   356: invokevirtual getString : (I)Ljava/lang/String;
    //   359: astore_2
    //   360: goto -> 398
    //   363: aload_0
    //   364: getfield n : Landroid/content/Context;
    //   367: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   370: ldc_w 2131755770
    //   373: invokevirtual getString : (I)Ljava/lang/String;
    //   376: astore_2
    //   377: goto -> 398
    //   380: iload_1
    //   381: ifne -> 398
    //   384: aload_0
    //   385: getfield n : Landroid/content/Context;
    //   388: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   391: ldc_w 2131755776
    //   394: invokevirtual getString : (I)Ljava/lang/String;
    //   397: astore_2
    //   398: aload_0
    //   399: getfield w : Landroid/widget/TextView;
    //   402: bipush #8
    //   404: invokevirtual setVisibility : (I)V
    //   407: aload_0
    //   408: getfield x : Landroid/widget/TextView;
    //   411: bipush #8
    //   413: invokevirtual setVisibility : (I)V
    //   416: aload_0
    //   417: getfield R : Landroid/widget/TextView;
    //   420: bipush #8
    //   422: invokevirtual setVisibility : (I)V
    //   425: aload_0
    //   426: getfield g : Lcom/soft/blued/ui/msg/model/ChannelModel;
    //   429: getfield callType : I
    //   432: iconst_1
    //   433: if_icmpeq -> 491
    //   436: aload_0
    //   437: getfield g : Lcom/soft/blued/ui/msg/model/ChannelModel;
    //   440: getfield callType : I
    //   443: iconst_2
    //   444: if_icmpeq -> 491
    //   447: aload_0
    //   448: getfield g : Lcom/soft/blued/ui/msg/model/ChannelModel;
    //   451: getfield callType : I
    //   454: iconst_3
    //   455: if_icmpeq -> 491
    //   458: aload_0
    //   459: getfield g : Lcom/soft/blued/ui/msg/model/ChannelModel;
    //   462: getfield callType : I
    //   465: iconst_5
    //   466: if_icmpne -> 472
    //   469: goto -> 491
    //   472: aload_0
    //   473: getfield v : Landroid/widget/TextView;
    //   476: iconst_0
    //   477: invokevirtual setVisibility : (I)V
    //   480: aload_0
    //   481: getfield v : Landroid/widget/TextView;
    //   484: aload_2
    //   485: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   488: goto -> 507
    //   491: aload_0
    //   492: getfield u : Landroid/widget/TextView;
    //   495: iconst_0
    //   496: invokevirtual setVisibility : (I)V
    //   499: aload_0
    //   500: getfield u : Landroid/widget/TextView;
    //   503: aload_2
    //   504: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   507: aload_0
    //   508: getfield ae : Z
    //   511: ifeq -> 531
    //   514: aload_0
    //   515: invokevirtual getActivity : ()Landroidx/fragment/app/FragmentActivity;
    //   518: ifnull -> 550
    //   521: aload_0
    //   522: invokevirtual getActivity : ()Landroidx/fragment/app/FragmentActivity;
    //   525: invokevirtual finish : ()V
    //   528: goto -> 550
    //   531: aload_0
    //   532: getfield v : Landroid/widget/TextView;
    //   535: new com/soft/blued/ui/msg/ChannelFragment$4
    //   538: dup
    //   539: aload_0
    //   540: invokespecial <init> : (Lcom/soft/blued/ui/msg/ChannelFragment;)V
    //   543: ldc2_w 1000
    //   546: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   549: pop
    //   550: aload_0
    //   551: iconst_1
    //   552: putfield Z : Z
    //   555: aload_0
    //   556: monitorexit
    //   557: return
    //   558: aload_0
    //   559: monitorexit
    //   560: return
    //   561: astore_2
    //   562: aload_0
    //   563: monitorexit
    //   564: aload_2
    //   565: athrow
    // Exception table:
    //   from	to	target	type
    //   2	43	561	finally
    //   54	75	561	finally
    //   78	92	561	finally
    //   100	144	561	finally
    //   147	171	561	finally
    //   174	199	561	finally
    //   202	216	561	finally
    //   224	245	561	finally
    //   248	262	561	finally
    //   271	285	561	finally
    //   293	314	561	finally
    //   317	331	561	finally
    //   339	360	561	finally
    //   363	377	561	finally
    //   384	398	561	finally
    //   398	469	561	finally
    //   472	488	561	finally
    //   491	507	561	finally
    //   507	528	561	finally
    //   531	550	561	finally
    //   550	555	561	finally
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   6: astore #4
    //   8: aload #4
    //   10: ifnonnull -> 27
    //   13: new android/widget/FrameLayout$LayoutParams
    //   16: dup
    //   17: iload_2
    //   18: iload_3
    //   19: invokespecial <init> : (II)V
    //   22: astore #4
    //   24: goto -> 39
    //   27: aload #4
    //   29: iload_2
    //   30: putfield width : I
    //   33: aload #4
    //   35: iload_3
    //   36: putfield height : I
    //   39: aload_1
    //   40: aload #4
    //   42: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	48	finally
    //   13	24	48	finally
    //   27	39	48	finally
    //   39	45	48	finally
  }
  
  public void a(VideoChatHelper.CallFailed paramCallFailed, String paramString) {
    Logger.b(d, new Object[] { "showFailView:", paramString });
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      if (paramCallFailed != VideoChatHelper.CallFailed.NETWORK && paramCallFailed != VideoChatHelper.CallFailed.SERVER_LIMIT)
        paramCallFailed = VideoChatHelper.CallFailed.UNKNOWN; 
      str = this.n.getResources().getString(2131755756);
    } 
    a(str, 2);
  }
  
  public void a(String paramString, int paramInt) {
    CustomDialog customDialog = this.ad;
    if (customDialog != null && customDialog.isShowing())
      return; 
    View view1 = LayoutInflater.from(this.n).inflate(2131493743, null);
    TextView textView1 = (TextView)view1.findViewById(2131301409);
    textView1.setText(getString(2131756931));
    TextView textView2 = (TextView)view1.findViewById(2131300611);
    textView2.setText(getString(2131755577));
    textView2.setOnClickListener(new View.OnClickListener(this, paramInt) {
          public void onClick(View param1View) {
            if (this.a == 1)
              this.b.getActivity().finish(); 
          }
        });
    TextView textView3 = (TextView)view1.findViewById(2131301130);
    textView3.setText(2131755597);
    textView3.setOnClickListener(new View.OnClickListener(this, paramInt) {
          public void onClick(View param1View) {
            if (this.a == 2)
              this.b.a(false); 
            if (this.a == 1 && this.b.g.callType == 0 && ChannelFragment.h(this.b) != null)
              ChannelFragment.h(this.b).a(); 
            ChannelFragment.l(this.b).dismiss();
          }
        });
    View view2 = view1.findViewById(2131300719);
    ((TextView)view1.findViewById(2131300703)).setText(paramString);
    if (paramInt == 1) {
      textView3.setText(getString(2131755597));
    } else if (paramInt == 2) {
      textView1.setVisibility(8);
      textView2.setVisibility(8);
      view2.setVisibility(8);
      textView3.setText(getString(2131757775));
    } 
    this.ad = new CustomDialog(this.n, 2131821111);
    this.ad.a(view1, new CustomDialog.OnBackCallBack(this, paramInt) {
          public void a() {
            int i = this.a;
            if (i == 1) {
              this.b.getActivity().finish();
              return;
            } 
            if (i == 2)
              this.b.a(false); 
          }
        });
  }
  
  public void a(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/soft/blued/ui/msg/ChannelFragment.d : Ljava/lang/String;
    //   5: iconst_2
    //   6: anewarray java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc_w 'removeTimer:'
    //   14: aastore
    //   15: dup
    //   16: iconst_1
    //   17: iload_1
    //   18: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   21: aastore
    //   22: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aload_0
    //   26: invokevirtual n : ()V
    //   29: aload_0
    //   30: invokespecial A : ()V
    //   33: aload_0
    //   34: getfield h : J
    //   37: lconst_0
    //   38: lcmp
    //   39: ifle -> 82
    //   42: aload_0
    //   43: getfield X : Lcom/soft/blued/ui/msg/manager/ChannelManager;
    //   46: ifnull -> 74
    //   49: aload_0
    //   50: getfield X : Lcom/soft/blued/ui/msg/manager/ChannelManager;
    //   53: getfield a : Lcom/blued/android/chat/VideoChatHelper;
    //   56: ifnull -> 74
    //   59: aload_0
    //   60: getfield X : Lcom/soft/blued/ui/msg/manager/ChannelManager;
    //   63: getfield a : Lcom/blued/android/chat/VideoChatHelper;
    //   66: aload_0
    //   67: getfield h : J
    //   70: l2i
    //   71: invokevirtual hangup : (I)V
    //   74: aload_0
    //   75: lconst_0
    //   76: putfield h : J
    //   79: goto -> 110
    //   82: aload_0
    //   83: getfield X : Lcom/soft/blued/ui/msg/manager/ChannelManager;
    //   86: ifnull -> 110
    //   89: aload_0
    //   90: getfield X : Lcom/soft/blued/ui/msg/manager/ChannelManager;
    //   93: getfield a : Lcom/blued/android/chat/VideoChatHelper;
    //   96: ifnull -> 110
    //   99: aload_0
    //   100: getfield X : Lcom/soft/blued/ui/msg/manager/ChannelManager;
    //   103: getfield a : Lcom/blued/android/chat/VideoChatHelper;
    //   106: iload_1
    //   107: invokevirtual cancel : (Z)V
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: astore_2
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_2
    //   117: athrow
    // Exception table:
    //   from	to	target	type
    //   2	74	113	finally
    //   74	79	113	finally
    //   82	110	113	finally
  }
  
  public void b(int paramInt) {
    Logger.b(d, new Object[] { "leftTime:", Integer.valueOf(paramInt) });
    this.ab = paramInt;
    B();
  }
  
  public void b(boolean paramBoolean) {
    if (this.g.callType == 0) {
      this.g.callType = 1;
    } else if (this.g.callType == 2) {
      this.g.callType = 3;
    } else {
      this.g.callType = 5;
      if (paramBoolean) {
        this.B.setText(this.n.getResources().getString(2131755786));
      } else {
        this.B.setText(this.n.getResources().getString(2131755787));
      } 
      this.B.setVisibility(0);
      this.B.postDelayed(new Runnable(this) {
            public void run() {
              ChannelFragment.a(this.a).setVisibility(8);
            }
          },  5000L);
      this.z.setVisibility(0);
      this.A.setTextColor(Color.parseColor("#ffffff"));
    } 
    ChannelManager channelManager = this.X;
    if (channelManager != null)
      channelManager.c(); 
    r();
  }
  
  public void k() {
    A();
    m();
    if (this.g.callType == 0 || this.g.callType == 2) {
      this.g.callType = 4;
      r();
      return;
    } 
    if (this.g.callType == 1 || this.g.callType == 3) {
      this.g.callType = 5;
      r();
      return;
    } 
  }
  
  public void l() {
    String str = this.n.getResources().getString(2131755795);
    this.u.setText(str);
    this.N.setText(str);
  }
  
  public void m() {
    AppInfo.n().post(new Runnable(this) {
          public void run() {
            ChannelFragment.g(this.a).start();
          }
        });
    z();
  }
  
  public void n() {
    AppInfo.n().post(new Runnable(this) {
          public void run() {
            ChannelFragment.g(this.a).stop();
          }
        });
  }
  
  public void o() {}
  
  public void onChronometerTick(Chronometer paramChronometer) {
    this.h++;
    this.aa = System.currentTimeMillis();
    paramChronometer.setText(TimeAndDateUtils.a(this.h, false));
    int i = this.ab;
    if (i < this.h && i >= 0) {
      ChannelManager channelManager = this.X;
      if (channelManager != null)
        channelManager.h(); 
      n();
      AppInfo.n().removeCallbacks(this.i);
      AppInfo.n().removeCallbacks(this.j);
      a(this.n.getResources().getString(2131755775), 2);
    } 
    B();
  }
  
  public void onClick(View paramView) {
    SurfaceView surfaceView1;
    ChannelManager channelManager;
    int i;
    int j;
    int k;
    int m;
    int n;
    SurfaceView surfaceView2;
    if (ClickUtils.a(paramView.getId(), 1000L))
      return; 
    switch (paramView.getId()) {
      default:
        return;
      case 2131301582:
        surfaceView1 = (SurfaceView)this.e.getChildAt(0);
        surfaceView2 = (SurfaceView)this.f.getChildAt(0);
        i = (int)TypedValue.applyDimension(1, 105.0F, this.n.getResources().getDisplayMetrics());
        j = (int)TypedValue.applyDimension(1, 187.0F, this.n.getResources().getDisplayMetrics());
        k = LiveFloatManager.a().C();
        m = LiveFloatManager.a().D();
        Logger.b(d, new Object[] { "screenViewWidth:", Integer.valueOf(k), " screenHeight:", Integer.valueOf(m), "   windowViewWidth:", Integer.valueOf(i), "  windowViewHeight:", Integer.valueOf(j) });
        if (surfaceView1 != null && surfaceView2 != null) {
          a((View)surfaceView2, k, m);
          a((View)surfaceView1, i, j);
          this.e.addView((View)a(surfaceView2));
          this.f.addView((View)a(surfaceView1));
          surfaceView1.setZOrderOnTop(true);
          surfaceView1.setZOrderMediaOverlay(true);
          surfaceView2.setZOrderOnTop(false);
          surfaceView2.setZOrderMediaOverlay(false);
        } 
        channelManager = this.X;
        if (channelManager != null) {
          channelManager.j();
          return;
        } 
        return;
      case 2131301580:
        if (this.g.callType == 4) {
          AlphaAnimation alphaAnimation;
          this.z.removeCallbacks(this.l);
          if (this.z.getVisibility() == 0) {
            this.z.setVisibility(8);
            alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
            this.A.setTextColor(Color.parseColor("#00ffffff"));
          } else {
            this.z.setVisibility(0);
            alphaAnimation = new AlphaAnimation(0.0F, 1.0F);
            this.z.postDelayed(this.l, 5000L);
            this.A.setTextColor(Color.parseColor("#ffffff"));
          } 
          alphaAnimation.setFillAfter(false);
          alphaAnimation.setDuration(500L);
          this.z.setAnimation((Animation)alphaAnimation);
          alphaAnimation.start();
          return;
        } 
        return;
      case 2131296693:
        n = ((Boolean)this.G.getTag()).booleanValue() ^ true;
        if (n != 0) {
          this.I.setSelected(true);
          channelManager = this.X;
          if (channelManager != null)
            channelManager.b(true); 
        } else {
          this.I.setSelected(false);
          channelManager = this.X;
          if (channelManager != null)
            channelManager.b(false); 
        } 
        this.G.setTag(Boolean.valueOf(n));
        return;
      case 2131296690:
        n = ((Boolean)this.C.getTag()).booleanValue() ^ true;
        if (n != 0) {
          channelManager = this.X;
          if (channelManager != null)
            channelManager.a(true); 
          this.H.setSelected(true);
        } else {
          channelManager = this.X;
          if (channelManager != null)
            channelManager.a(false); 
          this.H.setSelected(false);
        } 
        this.C.setTag(Boolean.valueOf(n));
        return;
      case 2131296687:
        a(false);
        return;
      case 2131296686:
        channelManager = this.X;
        if (channelManager != null) {
          channelManager.i();
          return;
        } 
        return;
      case 2131296355:
      case 2131296696:
      case 2131297994:
        channelManager = this.X;
        if (channelManager != null && channelManager.a != null)
          this.X.a.switchToAudio(); 
        b(false);
        return;
      case 2131296353:
      case 2131297992:
        a(false);
        return;
      case 2131296352:
        break;
    } 
    if (this.g.callType == 2) {
      this.g.callType = 4;
      r();
      channelManager = this.X;
      if (channelManager != null) {
        channelManager.b();
        if (this.X.a != null) {
          this.X.a.answer();
          return;
        } 
      } 
    } else if (this.g.callType == 3) {
      this.g.callType = 5;
      r();
      channelManager = this.X;
      if (channelManager != null) {
        channelManager.c();
        if (this.X.a != null)
          this.X.a.answer(); 
      } 
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    p();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    if (this.g.callType == 0 || this.g.callType == 2 || this.g.callType == 4)
      getActivity().getWindow().addFlags(8192); 
    this.n = (Context)getActivity();
    View view = this.Y;
    if (view == null) {
      this.Y = paramLayoutInflater.inflate(2131493084, paramViewGroup, false);
      q();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.Y.getParent()).removeView(this.Y);
    } 
    return this.Y;
  }
  
  public void onDestroy() {
    this.h = 0L;
    A();
    ChannelManager channelManager = this.X;
    if (channelManager != null) {
      channelManager.h();
      if (this.X.a != null)
        this.X.a.destroy(); 
      this.X.c((Activity)getActivity());
    } 
    getActivity().getWindow().clearFlags(128);
    super.onDestroy();
  }
  
  public void onPause() {
    AppInfo.n().postDelayed(this.m, 30000L);
    if (this.X != null) {
      if (this.g.callType == 4)
        this.X.f(); 
      this.X.b((Activity)getActivity());
    } 
    super.onPause();
  }
  
  public void onResume() {
    if (this.aa > 0L) {
      long l = (System.currentTimeMillis() - this.aa) / 1000L;
      this.h += l;
      this.A.setText(TimeAndDateUtils.a(this.h, false));
    } 
    AppInfo.n().removeCallbacks(this.m);
    if (this.X != null) {
      if (this.g.callType == 4)
        this.X.g(); 
      this.X.a((Activity)getActivity());
    } 
    super.onResume();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\ChannelFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */