package com.blued.android.module.live_china.manager;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import com.blued.android.chat.data.EntranceData;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.chat.data.LiveChatStatistics;
import com.blued.android.chat.data.LiveCloseReason;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.listener.LiveChatInfoListener;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveRoomCloseReason;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.player.live.manager.LiveMediaPlayerManager;
import com.blued.android.module.player.live.manager.OnMediaPlayerListener;
import com.blued.android.module.player.live.view.BLVideoView;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.txplayer.view.BlLiveView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.List;

public class LiveFloatManager implements LiveChatInfoListener {
  private static volatile LiveFloatManager i;
  
  private boolean A = false;
  
  private boolean B = false;
  
  private boolean C;
  
  private WindowManager.LayoutParams D;
  
  private WindowManager E;
  
  private FrameLayout F;
  
  private View G;
  
  private View H;
  
  private View I;
  
  private View J;
  
  private View K;
  
  private ImageView L;
  
  private ImageView M;
  
  private boolean N = false;
  
  private boolean O = false;
  
  private boolean P = false;
  
  private boolean Q = false;
  
  private float R;
  
  private float S;
  
  private float T;
  
  private float U;
  
  private float V;
  
  private float W;
  
  private float X = 0.0F;
  
  private float Y = 0.0F;
  
  private int Z;
  
  public SurfaceView a;
  
  private int aa;
  
  private int ab;
  
  private int ac;
  
  private int ad;
  
  private int ae;
  
  private int af;
  
  private int ag;
  
  private int ah;
  
  private int ai;
  
  private int aj;
  
  private int ak;
  
  private int al;
  
  private boolean am = true;
  
  private boolean an;
  
  private boolean ao;
  
  private int ap = 105;
  
  private int aq = 187;
  
  private boolean ar;
  
  private String as;
  
  private int at = -1;
  
  private OnMediaPlayerListener au = new OnMediaPlayerListener(this) {
      public void a() {
        this.a.O();
        if (LiveFloatManager.a(this.a) != null)
          LiveFloatManager.a(this.a).a(); 
      }
      
      public void a(int param1Int1, int param1Int2) {
        if (LiveFloatManager.c(this.a) == param1Int1 && LiveFloatManager.d(this.a) == param1Int2)
          return; 
        LiveFloatManager.a(this.a, param1Int1);
        LiveFloatManager.b(this.a, param1Int2);
        this.a.I();
      }
      
      public void b() {
        this.a.Q();
        if (LiveFloatManager.a(this.a) != null)
          LiveFloatManager.a(this.a).b(); 
      }
      
      public void c() {
        if (Build.VERSION.SDK_INT >= 26)
          AppInfo.n().post(new -$$Lambda$LiveFloatManager$1$PJKM35--bYcEbfJC3ZGsVUkxWeg(this)); 
        this.a.Q();
        if (LiveFloatManager.a(this.a) != null)
          LiveFloatManager.a(this.a).c(); 
      }
      
      public void d() {
        if (!LiveFloatManager.b(this.a))
          this.a.d(); 
      }
      
      public void e() {
        if (!LiveFloatManager.b(this.a))
          this.a.d(); 
      }
    };
  
  private SurfaceHolder.Callback av = new SurfaceHolder.Callback(this) {
      int a;
      
      int b;
      
      public void surfaceChanged(SurfaceHolder param1SurfaceHolder, int param1Int1, int param1Int2, int param1Int3) {
        if (this.b != param1Int3 || this.a != param1Int2) {
          this.b = param1Int3;
          this.a = param1Int2;
          LiveFloatManager.h(this.c).j();
        } 
        Log.v("ddrb", "surfaceChanged");
      }
      
      public void surfaceCreated(SurfaceHolder param1SurfaceHolder) {
        Logger.b("ddrb", new Object[] { "surfaceCreated" });
        if (param1SurfaceHolder != null) {
          this.b = LiveFloatManager.f(this.c);
          this.a = LiveFloatManager.g(this.c);
          this.c.b();
        } 
      }
      
      public void surfaceDestroyed(SurfaceHolder param1SurfaceHolder) {
        this.c.o();
        Log.v("ddrb", "surfaceDestroyed");
      }
    };
  
  public BlLiveView b;
  
  public CardView c;
  
  public CardView d;
  
  public boolean e = false;
  
  PlayingOnliveFragment f;
  
  public LiveRoomCloseReason g;
  
  Handler h = new Handler(Looper.getMainLooper());
  
  private LiveMediaPlayerManager j = new LiveMediaPlayerManager();
  
  private String k;
  
  private short l = 4;
  
  private long m = -1L;
  
  private String n;
  
  private String o;
  
  private OnMediaPlayerConnectListener p;
  
  private int q = 1;
  
  private Reconnect r = new Reconnect();
  
  private EnterLiveResult s = new EnterLiveResult();
  
  private boolean t = false;
  
  private boolean u = false;
  
  private boolean v = false;
  
  private boolean w = false;
  
  private boolean x = false;
  
  private long y;
  
  private int z = -1;
  
  public static boolean S() {
    return "Xiaomi".equals(Build.MANUFACTURER);
  }
  
  private void T() {
    LiveMsgSendManager.a().b(this.l, this.m, this);
    LiveMsgSendManager.a().a(this.l, this.m, this);
  }
  
  private void U() {
    j();
    if (LiveRoomCloseReason.isCloseByNormal(this.g)) {
      R();
    } else {
      P();
    } 
    OnMediaPlayerConnectListener onMediaPlayerConnectListener = this.p;
    if (onMediaPlayerConnectListener != null) {
      this.v = true;
      onMediaPlayerConnectListener.a(this.g);
    } 
  }
  
  private void V() {
    LiveRoomInfo.a().v();
    VideoPlayConfig.c(1);
    this.b.a();
    if (VideoPlayConfig.c() == 1) {
      b();
      return;
    } 
    if (this.a == null && this.b.getChildAt(0) instanceof SurfaceView)
      this.a = (SurfaceView)this.b.getChildAt(0); 
    SurfaceView surfaceView = this.a;
    if (surfaceView != null && surfaceView.getHolder() != null)
      this.a.getHolder().addCallback(this.av); 
  }
  
  private void W() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Landroid/os/Handler;
    //   6: new com/blued/android/module/live_china/manager/LiveFloatManager$5
    //   9: dup
    //   10: aload_0
    //   11: invokespecial <init> : (Lcom/blued/android/module/live_china/manager/LiveFloatManager;)V
    //   14: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   17: pop
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	21	finally
  }
  
  private void X() {
    M();
    W();
    if (this.e) {
      long l;
      if (LiveRoomManager.a().h() != null) {
        l = (LiveRoomManager.a().h()).elapse_time;
      } else {
        l = 0L;
      } 
      a(l, this.at);
      return;
    } 
    if (this.p != null)
      K(); 
  }
  
  private void Y() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic n : ()Landroid/os/Handler;
    //   5: new com/blued/android/module/live_china/manager/LiveFloatManager$6
    //   8: dup
    //   9: aload_0
    //   10: invokespecial <init> : (Lcom/blued/android/module/live_china/manager/LiveFloatManager;)V
    //   13: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   16: pop
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	20	finally
  }
  
  private void Z() {
    try {
      if (!LiveRoomInfo.a().b(AppInfo.d()))
        return; 
      Point point = new Point();
      ((WindowManager)AppInfo.d().getSystemService("window")).getDefaultDisplay().getSize(point);
      this.aa = point.x;
      this.ab = point.y;
      this.ac = this.aa;
      this.ad = this.ab;
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public static LiveFloatManager a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/live_china/manager/LiveFloatManager.i : Lcom/blued/android/module/live_china/manager/LiveFloatManager;
    //   3: ifnonnull -> 43
    //   6: ldc com/blued/android/module/live_china/manager/LiveFloatManager
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/live_china/manager/LiveFloatManager.i : Lcom/blued/android/module/live_china/manager/LiveFloatManager;
    //   12: ifnonnull -> 31
    //   15: new com/blued/android/module/live_china/manager/LiveFloatManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/live_china/manager/LiveFloatManager.i : Lcom/blued/android/module/live_china/manager/LiveFloatManager;
    //   25: getstatic com/blued/android/module/live_china/manager/LiveFloatManager.i : Lcom/blued/android/module/live_china/manager/LiveFloatManager;
    //   28: invokevirtual H : ()V
    //   31: ldc com/blued/android/module/live_china/manager/LiveFloatManager
    //   33: monitorexit
    //   34: goto -> 43
    //   37: astore_0
    //   38: ldc com/blued/android/module/live_china/manager/LiveFloatManager
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    //   43: getstatic com/blued/android/module/live_china/manager/LiveFloatManager.i : Lcom/blued/android/module/live_china/manager/LiveFloatManager;
    //   46: areturn
    // Exception table:
    //   from	to	target	type
    //   9	31	37	finally
    //   31	34	37	finally
    //   38	41	37	finally
  }
  
  public static boolean a(Context paramContext) {
    return (paramContext == null) ? true : ((Build.VERSION.SDK_INT >= 19) ? a(paramContext, 24) : ((((paramContext.getApplicationInfo()).flags & 0x8000000) == 134217728)));
  }
  
  public static boolean a(Context paramContext, int paramInt) {
    if (Build.VERSION.SDK_INT >= 19) {
      AppOpsManager appOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
      try {
        Class.forName(appOpsManager.getClass().getName());
        paramInt = ((Integer)appOpsManager.getClass().getDeclaredMethod("checkOp", new Class[] { int.class, int.class, String.class }).invoke(appOpsManager, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(Binder.getCallingUid()), paramContext.getPackageName() })).intValue();
        Logger.d("xpf", new Object[] { " invoke property:", Integer.valueOf(paramInt) });
        return (paramInt == 0);
      } catch (Exception exception) {
        Logger.d("xpf", new Object[] { exception.getMessage() });
        return false;
      } 
    } 
    Logger.d("xpf", new Object[] { "Below API 19 cannot invoke!" });
    return false;
  }
  
  public boolean A() {
    return this.v;
  }
  
  public boolean B() {
    return this.A;
  }
  
  public int C() {
    return this.aa;
  }
  
  public int D() {
    return this.ab;
  }
  
  public boolean E() {
    return this.B;
  }
  
  public boolean F() {
    return this.C;
  }
  
  public void G() {
    this.an = true;
  }
  
  public void H() {
    try {
      Context context = AppInfo.d();
      if (this.D != null)
        return; 
      this.D = new WindowManager.LayoutParams();
      this.E = (WindowManager)context.getSystemService("window");
      Logger.b("ddrb", new Object[] { "sdk api version:", Integer.valueOf(Build.VERSION.SDK_INT) });
      if (Build.VERSION.SDK_INT >= 26) {
        this.D.type = 2038;
      } else if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 23) {
        this.D.type = 2005;
      } else {
        this.D.type = 2003;
      } 
      this.D.format = 1;
      this.D.flags = 8;
      this.D.gravity = 51;
      this.D.width = -2;
      this.D.height = -2;
      View view = LayoutInflater.from(context).inflate(R.layout.live_float_surface_view, null);
      LiveRoomInfo.a().v();
      VideoPlayConfig.c(1);
      this.b = (BlLiveView)view.findViewById(R.id.live_float_player_live_view);
      this.b.a();
      if (this.b.getChildAt(0) != null && this.b.getChildAt(0) instanceof SurfaceView)
        this.a = (SurfaceView)this.b.getChildAt(0); 
      if (this.a != null) {
        this.a.getHolder().addCallback(this.av);
      } else {
        b();
      } 
      Z();
      W();
      return;
    } catch (SecurityException securityException) {
      securityException.printStackTrace();
      return;
    } 
  }
  
  public void I() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield ae : I
    //   6: ifeq -> 372
    //   9: aload_0
    //   10: getfield af : I
    //   13: ifeq -> 372
    //   16: aload_0
    //   17: getfield ag : I
    //   20: ifeq -> 372
    //   23: aload_0
    //   24: getfield ah : I
    //   27: ifeq -> 372
    //   30: ldc_w 'ddrb'
    //   33: bipush #8
    //   35: anewarray java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: ldc_w '111111 data: mVideoWidth:'
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: aload_0
    //   47: getfield ae : I
    //   50: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   53: aastore
    //   54: dup
    //   55: iconst_2
    //   56: ldc_w '   mVideoHeight:'
    //   59: aastore
    //   60: dup
    //   61: iconst_3
    //   62: aload_0
    //   63: getfield af : I
    //   66: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   69: aastore
    //   70: dup
    //   71: iconst_4
    //   72: ldc_w ' mSurfaceWidth:'
    //   75: aastore
    //   76: dup
    //   77: iconst_5
    //   78: aload_0
    //   79: getfield ag : I
    //   82: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   85: aastore
    //   86: dup
    //   87: bipush #6
    //   89: ldc_w '   mSurfaceHeight:'
    //   92: aastore
    //   93: dup
    //   94: bipush #7
    //   96: aload_0
    //   97: getfield ah : I
    //   100: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   103: aastore
    //   104: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: aload_0
    //   108: getfield ae : I
    //   111: i2f
    //   112: aload_0
    //   113: getfield ag : I
    //   116: i2f
    //   117: fdiv
    //   118: fstore_2
    //   119: aload_0
    //   120: getfield af : I
    //   123: i2f
    //   124: aload_0
    //   125: getfield ah : I
    //   128: i2f
    //   129: fdiv
    //   130: fstore_3
    //   131: aload_0
    //   132: getfield N : Z
    //   135: ifeq -> 156
    //   138: fload_2
    //   139: fstore_1
    //   140: aload_0
    //   141: getfield ag : I
    //   144: aload_0
    //   145: getfield ah : I
    //   148: if_icmple -> 225
    //   151: fload_3
    //   152: fstore_1
    //   153: goto -> 225
    //   156: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveRoomManager;
    //   159: invokevirtual h : ()Lcom/blued/android/module/live_china/model/LiveRoomData;
    //   162: ifnull -> 196
    //   165: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveRoomManager;
    //   168: invokevirtual h : ()Lcom/blued/android/module/live_china/model/LiveRoomData;
    //   171: getfield live_type : I
    //   174: iconst_1
    //   175: if_icmpne -> 196
    //   178: fload_2
    //   179: fstore_1
    //   180: aload_0
    //   181: getfield A : Z
    //   184: ifeq -> 225
    //   187: fload_2
    //   188: fload_3
    //   189: invokestatic max : (FF)F
    //   192: fstore_1
    //   193: goto -> 225
    //   196: fload_2
    //   197: fload_3
    //   198: invokestatic min : (FF)F
    //   201: fstore_1
    //   202: ldc_w 'ddrb'
    //   205: iconst_2
    //   206: anewarray java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: ldc_w 'Math.min: ratio ='
    //   214: aastore
    //   215: dup
    //   216: iconst_1
    //   217: fload_1
    //   218: invokestatic valueOf : (F)Ljava/lang/Float;
    //   221: aastore
    //   222: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: ldc_w 'ddrb'
    //   228: bipush #10
    //   230: anewarray java/lang/Object
    //   233: dup
    //   234: iconst_0
    //   235: ldc_w 'before data: mVideoWidth:'
    //   238: aastore
    //   239: dup
    //   240: iconst_1
    //   241: aload_0
    //   242: getfield ae : I
    //   245: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   248: aastore
    //   249: dup
    //   250: iconst_2
    //   251: ldc_w '   mVideoHeight:'
    //   254: aastore
    //   255: dup
    //   256: iconst_3
    //   257: aload_0
    //   258: getfield af : I
    //   261: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   264: aastore
    //   265: dup
    //   266: iconst_4
    //   267: ldc_w ' mSurfaceWidth:'
    //   270: aastore
    //   271: dup
    //   272: iconst_5
    //   273: aload_0
    //   274: getfield ag : I
    //   277: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   280: aastore
    //   281: dup
    //   282: bipush #6
    //   284: ldc_w '   mSurfaceHeight:'
    //   287: aastore
    //   288: dup
    //   289: bipush #7
    //   291: aload_0
    //   292: getfield ah : I
    //   295: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   298: aastore
    //   299: dup
    //   300: bipush #8
    //   302: ldc_w '   ratio = '
    //   305: aastore
    //   306: dup
    //   307: bipush #9
    //   309: fload_1
    //   310: invokestatic valueOf : (F)Ljava/lang/Float;
    //   313: aastore
    //   314: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   317: ldc_w 'ddrb'
    //   320: iconst_2
    //   321: anewarray java/lang/Object
    //   324: dup
    //   325: iconst_0
    //   326: ldc_w '====ratio:'
    //   329: aastore
    //   330: dup
    //   331: iconst_1
    //   332: fload_1
    //   333: invokestatic valueOf : (F)Ljava/lang/Float;
    //   336: aastore
    //   337: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   340: aload_0
    //   341: aload_0
    //   342: getfield ae : I
    //   345: i2f
    //   346: fload_1
    //   347: fdiv
    //   348: f2d
    //   349: invokestatic ceil : (D)D
    //   352: d2i
    //   353: putfield ag : I
    //   356: aload_0
    //   357: aload_0
    //   358: getfield af : I
    //   361: i2f
    //   362: fload_1
    //   363: fdiv
    //   364: f2d
    //   365: invokestatic ceil : (D)D
    //   368: d2i
    //   369: putfield ah : I
    //   372: ldc_w 'ddrb'
    //   375: bipush #8
    //   377: anewarray java/lang/Object
    //   380: dup
    //   381: iconst_0
    //   382: ldc_w 'after data: mVideoWidth:'
    //   385: aastore
    //   386: dup
    //   387: iconst_1
    //   388: aload_0
    //   389: getfield ae : I
    //   392: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   395: aastore
    //   396: dup
    //   397: iconst_2
    //   398: ldc_w '   mVideoHeight:'
    //   401: aastore
    //   402: dup
    //   403: iconst_3
    //   404: aload_0
    //   405: getfield af : I
    //   408: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   411: aastore
    //   412: dup
    //   413: iconst_4
    //   414: ldc_w ' mSurfaceWidth:'
    //   417: aastore
    //   418: dup
    //   419: iconst_5
    //   420: aload_0
    //   421: getfield ag : I
    //   424: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   427: aastore
    //   428: dup
    //   429: bipush #6
    //   431: ldc_w '   mSurfaceHeight:'
    //   434: aastore
    //   435: dup
    //   436: bipush #7
    //   438: aload_0
    //   439: getfield ah : I
    //   442: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   445: aastore
    //   446: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   449: aload_0
    //   450: invokespecial Y : ()V
    //   453: aload_0
    //   454: monitorexit
    //   455: return
    //   456: astore #4
    //   458: aload_0
    //   459: monitorexit
    //   460: aload #4
    //   462: athrow
    // Exception table:
    //   from	to	target	type
    //   2	138	456	finally
    //   140	151	456	finally
    //   156	178	456	finally
    //   180	193	456	finally
    //   196	225	456	finally
    //   225	372	456	finally
    //   372	453	456	finally
  }
  
  public int J() {
    try {
      Class<?> clazz = Class.forName("com.android.internal.R$dimen");
      Object object = clazz.newInstance();
      int i = Integer.parseInt(clazz.getField("status_bar_height").get(object).toString());
      this.Z = AppInfo.d().getResources().getDimensionPixelSize(i);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return this.Z;
  }
  
  public void K() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield O : Z
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield e : Z
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield P : Z
    //   17: aload_0
    //   18: invokevirtual M : ()V
    //   21: aload_0
    //   22: getfield h : Landroid/os/Handler;
    //   25: new com/blued/android/module/live_china/manager/LiveFloatManager$7
    //   28: dup
    //   29: aload_0
    //   30: invokespecial <init> : (Lcom/blued/android/module/live_china/manager/LiveFloatManager;)V
    //   33: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   36: pop
    //   37: aload_0
    //   38: monitorexit
    //   39: return
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   2	37	40	finally
  }
  
  public void L() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Landroid/os/Handler;
    //   6: new com/blued/android/module/live_china/manager/LiveFloatManager$8
    //   9: dup
    //   10: aload_0
    //   11: invokespecial <init> : (Lcom/blued/android/module/live_china/manager/LiveFloatManager;)V
    //   14: ldc2_w 300
    //   17: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   20: pop
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: astore_1
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	24	finally
  }
  
  public void M() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Landroid/os/Handler;
    //   6: new com/blued/android/module/live_china/manager/LiveFloatManager$9
    //   9: dup
    //   10: aload_0
    //   11: invokespecial <init> : (Lcom/blued/android/module/live_china/manager/LiveFloatManager;)V
    //   14: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   17: pop
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	21	finally
  }
  
  public BlLiveView N() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Lcom/blued/android/module/player/txplayer/view/BlLiveView;
    //   6: ifnull -> 35
    //   9: aload_0
    //   10: getfield b : Lcom/blued/android/module/player/txplayer/view/BlLiveView;
    //   13: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   16: astore_1
    //   17: aload_1
    //   18: instanceof android/view/ViewGroup
    //   21: ifeq -> 35
    //   24: aload_1
    //   25: checkcast android/view/ViewGroup
    //   28: aload_0
    //   29: getfield b : Lcom/blued/android/module/player/txplayer/view/BlLiveView;
    //   32: invokevirtual removeView : (Landroid/view/View;)V
    //   35: ldc_w 'pk'
    //   38: ldc_w 'getSurafceView'
    //   41: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   44: pop
    //   45: aload_0
    //   46: getfield b : Lcom/blued/android/module/player/txplayer/view/BlLiveView;
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: areturn
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Exception table:
    //   from	to	target	type
    //   2	35	54	finally
    //   35	50	54	finally
  }
  
  public void O() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield w : Z
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield x : Z
    //   12: aload_0
    //   13: getfield h : Landroid/os/Handler;
    //   16: new com/blued/android/module/live_china/manager/LiveFloatManager$10
    //   19: dup
    //   20: aload_0
    //   21: invokespecial <init> : (Lcom/blued/android/module/live_china/manager/LiveFloatManager;)V
    //   24: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   27: pop
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   2	28	31	finally
  }
  
  public void P() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield w : Z
    //   7: aload_0
    //   8: iconst_1
    //   9: putfield x : Z
    //   12: aload_0
    //   13: getfield h : Landroid/os/Handler;
    //   16: aload_0
    //   17: getfield r : Lcom/blued/android/module/live_china/manager/LiveFloatManager$Reconnect;
    //   20: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   23: aload_0
    //   24: getfield h : Landroid/os/Handler;
    //   27: new com/blued/android/module/live_china/manager/LiveFloatManager$11
    //   30: dup
    //   31: aload_0
    //   32: invokespecial <init> : (Lcom/blued/android/module/live_china/manager/LiveFloatManager;)V
    //   35: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   38: pop
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   2	39	42	finally
  }
  
  public void Q() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield J : Landroid/view/View;
    //   6: invokevirtual getVisibility : ()I
    //   9: ifeq -> 94
    //   12: aload_0
    //   13: getfield I : Landroid/view/View;
    //   16: invokevirtual getVisibility : ()I
    //   19: ifne -> 25
    //   22: goto -> 94
    //   25: invokestatic a : ()Lcom/blued/android/module/live_china/live_info/LiveRoomInfo;
    //   28: invokevirtual t : ()Z
    //   31: ifne -> 38
    //   34: aload_0
    //   35: invokevirtual h : ()V
    //   38: aload_0
    //   39: iconst_1
    //   40: putfield w : Z
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield x : Z
    //   48: aload_0
    //   49: iconst_1
    //   50: putfield q : I
    //   53: aload_0
    //   54: getfield h : Landroid/os/Handler;
    //   57: aload_0
    //   58: getfield s : Lcom/blued/android/module/live_china/manager/LiveFloatManager$EnterLiveResult;
    //   61: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   64: aload_0
    //   65: getfield h : Landroid/os/Handler;
    //   68: aload_0
    //   69: getfield r : Lcom/blued/android/module/live_china/manager/LiveFloatManager$Reconnect;
    //   72: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   75: aload_0
    //   76: getfield h : Landroid/os/Handler;
    //   79: new com/blued/android/module/live_china/manager/LiveFloatManager$12
    //   82: dup
    //   83: aload_0
    //   84: invokespecial <init> : (Lcom/blued/android/module/live_china/manager/LiveFloatManager;)V
    //   87: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   90: pop
    //   91: aload_0
    //   92: monitorexit
    //   93: return
    //   94: aload_0
    //   95: invokevirtual h : ()V
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	101	finally
    //   25	38	101	finally
    //   38	91	101	finally
    //   94	98	101	finally
  }
  
  public void R() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield w : Z
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield x : Z
    //   12: aload_0
    //   13: getfield h : Landroid/os/Handler;
    //   16: aload_0
    //   17: getfield r : Lcom/blued/android/module/live_china/manager/LiveFloatManager$Reconnect;
    //   20: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   23: aload_0
    //   24: getfield h : Landroid/os/Handler;
    //   27: new com/blued/android/module/live_china/manager/LiveFloatManager$13
    //   30: dup
    //   31: aload_0
    //   32: invokespecial <init> : (Lcom/blued/android/module/live_china/manager/LiveFloatManager;)V
    //   35: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   38: pop
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   2	39	42	finally
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.ag = paramInt1;
    this.ah = paramInt2;
    Logger.a("drb", new Object[] { "setSurfaceWidthHeight width = ", Integer.valueOf(paramInt1), " -- height = ", Integer.valueOf(paramInt2) });
    I();
  }
  
  public void a(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aconst_null
    //   4: invokevirtual a : (Lcom/blued/android/module/live_china/fragment/PlayingOnliveFragment;)V
    //   7: aload_0
    //   8: aconst_null
    //   9: invokevirtual a : (Lcom/blued/android/module/live_china/manager/LiveFloatManager$OnMediaPlayerConnectListener;)V
    //   12: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveRoomManager;
    //   15: invokevirtual h : ()Lcom/blued/android/module/live_china/model/LiveRoomData;
    //   18: ifnull -> 31
    //   21: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveRoomManager;
    //   24: invokevirtual h : ()Lcom/blued/android/module/live_china/model/LiveRoomData;
    //   27: lload_1
    //   28: putfield elapse_time : J
    //   31: aload_0
    //   32: invokestatic currentTimeMillis : ()J
    //   35: putfield y : J
    //   38: aload_0
    //   39: invokevirtual L : ()V
    //   42: invokestatic t : ()I
    //   45: ifne -> 105
    //   48: invokestatic S : ()Z
    //   51: ifeq -> 105
    //   54: invokestatic d : ()Landroid/content/Context;
    //   57: invokestatic a : (Landroid/content/Context;)Z
    //   60: ifne -> 105
    //   63: new android/content/Intent
    //   66: dup
    //   67: invokestatic d : ()Landroid/content/Context;
    //   70: ldc_w com/blued/android/module/live_china/activity/LiveFloatDialogActivity
    //   73: invokespecial <init> : (Landroid/content/Context;Ljava/lang/Class;)V
    //   76: astore_3
    //   77: aload_3
    //   78: ldc_w 'flag'
    //   81: iconst_1
    //   82: invokevirtual putExtra : (Ljava/lang/String;I)Landroid/content/Intent;
    //   85: pop
    //   86: aload_3
    //   87: ldc_w 268435456
    //   90: invokevirtual addFlags : (I)Landroid/content/Intent;
    //   93: pop
    //   94: invokestatic d : ()Landroid/content/Context;
    //   97: aload_3
    //   98: invokevirtual startActivity : (Landroid/content/Intent;)V
    //   101: iconst_1
    //   102: invokestatic j : (I)V
    //   105: aload_0
    //   106: monitorexit
    //   107: return
    //   108: astore_3
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_3
    //   112: athrow
    // Exception table:
    //   from	to	target	type
    //   2	31	108	finally
    //   31	105	108	finally
  }
  
  public void a(long paramLong, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_3
    //   4: putfield at : I
    //   7: aload_0
    //   8: iconst_1
    //   9: putfield e : Z
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield P : Z
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield O : Z
    //   22: getstatic android/os/Build$VERSION.SDK_INT : I
    //   25: bipush #23
    //   27: if_icmplt -> 169
    //   30: invokestatic d : ()Landroid/content/Context;
    //   33: invokestatic canDrawOverlays : (Landroid/content/Context;)Z
    //   36: ifeq -> 47
    //   39: aload_0
    //   40: lload_1
    //   41: invokevirtual a : (J)V
    //   44: goto -> 174
    //   47: new java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial <init> : ()V
    //   54: astore #4
    //   56: aload #4
    //   58: ldc_w 'package:'
    //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload #4
    //   67: invokestatic d : ()Landroid/content/Context;
    //   70: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   73: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: new android/content/Intent
    //   80: dup
    //   81: ldc_w 'android.settings.action.MANAGE_OVERLAY_PERMISSION'
    //   84: aload #4
    //   86: invokevirtual toString : ()Ljava/lang/String;
    //   89: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   92: invokespecial <init> : (Ljava/lang/String;Landroid/net/Uri;)V
    //   95: invokestatic a : (Landroid/content/Intent;)Z
    //   98: ifeq -> 156
    //   101: new android/content/Intent
    //   104: dup
    //   105: invokestatic d : ()Landroid/content/Context;
    //   108: ldc_w com/blued/android/module/live_china/activity/LiveFloatDialogActivity
    //   111: invokespecial <init> : (Landroid/content/Context;Ljava/lang/Class;)V
    //   114: astore #4
    //   116: aload #4
    //   118: ldc_w 'flag'
    //   121: iconst_2
    //   122: invokevirtual putExtra : (Ljava/lang/String;I)Landroid/content/Intent;
    //   125: pop
    //   126: aload #4
    //   128: ldc_w 'timer'
    //   131: lload_1
    //   132: invokevirtual putExtra : (Ljava/lang/String;J)Landroid/content/Intent;
    //   135: pop
    //   136: aload #4
    //   138: ldc_w 268435456
    //   141: invokevirtual addFlags : (I)Landroid/content/Intent;
    //   144: pop
    //   145: invokestatic d : ()Landroid/content/Context;
    //   148: aload #4
    //   150: invokevirtual startActivity : (Landroid/content/Intent;)V
    //   153: goto -> 174
    //   156: aload_0
    //   157: invokevirtual n : ()V
    //   160: getstatic com/blued/android/module/live_china/R$string.live_float_toast : I
    //   163: invokestatic d : (I)V
    //   166: goto -> 174
    //   169: aload_0
    //   170: lload_1
    //   171: invokevirtual a : (J)V
    //   174: aload_0
    //   175: monitorexit
    //   176: return
    //   177: astore #4
    //   179: aload_0
    //   180: monitorexit
    //   181: aload #4
    //   183: athrow
    // Exception table:
    //   from	to	target	type
    //   2	44	177	finally
    //   47	153	177	finally
    //   156	166	177	finally
    //   169	174	177	finally
  }
  
  public void a(PlayingOnliveFragment paramPlayingOnliveFragment) {
    this.f = paramPlayingOnliveFragment;
    if (this.f != null)
      this.an = false; 
  }
  
  public void a(OnMediaPlayerConnectListener paramOnMediaPlayerConnectListener) {
    this.p = paramOnMediaPlayerConnectListener;
    if (this.p != null) {
      if (this.v) {
        r();
        return;
      } 
      if (this.t) {
        if (this.u && LiveRoomManager.a().h() != null) {
          this.p.a(false);
          return;
        } 
        r();
      } 
    } 
  }
  
  public void a(String paramString1, short paramShort, long paramLong, String paramString2, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload #6
    //   5: putfield z : I
    //   8: aload_0
    //   9: getfield aa : I
    //   12: ifne -> 19
    //   15: aload_0
    //   16: invokespecial Z : ()V
    //   19: aload_0
    //   20: getfield z : I
    //   23: iconst_1
    //   24: if_icmpne -> 50
    //   27: aload_0
    //   28: iconst_1
    //   29: putfield A : Z
    //   32: aload_0
    //   33: getfield ai : I
    //   36: aload_0
    //   37: getfield aj : I
    //   40: if_icmpge -> 70
    //   43: aload_0
    //   44: invokespecial X : ()V
    //   47: goto -> 70
    //   50: aload_0
    //   51: iconst_0
    //   52: putfield A : Z
    //   55: aload_0
    //   56: getfield ai : I
    //   59: aload_0
    //   60: getfield aj : I
    //   63: if_icmple -> 70
    //   66: aload_0
    //   67: invokespecial X : ()V
    //   70: aload_0
    //   71: getfield k : Ljava/lang/String;
    //   74: aload_1
    //   75: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   78: istore #7
    //   80: iload #7
    //   82: ifeq -> 88
    //   85: aload_0
    //   86: monitorexit
    //   87: return
    //   88: aload_0
    //   89: getfield j : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManager;
    //   92: invokevirtual a : ()Z
    //   95: ifeq -> 102
    //   98: aload_0
    //   99: invokevirtual n : ()V
    //   102: aload_0
    //   103: aload_1
    //   104: putfield k : Ljava/lang/String;
    //   107: aload_0
    //   108: iconst_1
    //   109: putfield q : I
    //   112: aload_0
    //   113: iconst_0
    //   114: putfield w : Z
    //   117: aload_0
    //   118: iconst_0
    //   119: putfield x : Z
    //   122: aload_0
    //   123: iconst_0
    //   124: putfield v : Z
    //   127: aload_0
    //   128: iconst_1
    //   129: putfield P : Z
    //   132: aload_0
    //   133: iconst_0
    //   134: putfield Q : Z
    //   137: aload_0
    //   138: getfield h : Landroid/os/Handler;
    //   141: aload_0
    //   142: getfield r : Lcom/blued/android/module/live_china/manager/LiveFloatManager$Reconnect;
    //   145: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   148: aload_0
    //   149: invokespecial V : ()V
    //   152: aload_0
    //   153: invokevirtual O : ()V
    //   156: aload_0
    //   157: invokespecial T : ()V
    //   160: invokestatic a : ()Lcom/blued/android/framework/utils/AudioManagerUtils;
    //   163: invokevirtual b : ()V
    //   166: aload_0
    //   167: monitorexit
    //   168: return
    //   169: astore_1
    //   170: aload_0
    //   171: monitorexit
    //   172: aload_1
    //   173: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	169	finally
    //   19	47	169	finally
    //   50	70	169	finally
    //   70	80	169	finally
    //   88	102	169	finally
    //   102	166	169	finally
  }
  
  public void a(short paramShort, long paramLong, String paramString) {
    Logger.b("rrrb", new Object[] { "enterLiveChat start" });
    this.as = paramString;
    LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<LiveRoomData>>(this, paramLong, paramShort) {
          protected void a(BluedEntityA<LiveRoomData> param1BluedEntityA) {
            Logger.b("rrrb", new Object[] { "enterLiveChat success:", Long.valueOf(this.a) });
            if (!LiveFloatManager.l(this.c)) {
              Logger.b("rrrb", new Object[] { "live room has close" });
              return;
            } 
            if (LiveRoomManager.a().b() != this.a)
              return; 
            LiveUploadTimerManager.a(LiveRoomManager.a().c());
            LiveRoomData liveRoomData = (LiveRoomData)param1BluedEntityA.getSingleData();
            if (TextUtils.isEmpty(LiveFloatManager.m(this.c)) && liveRoomData != null && liveRoomData.screen_pattern == 1)
              try {
                Thread.sleep(1000L);
              } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
              }  
            LiveFloatManager.a(this.c, true);
            if (liveRoomData == null) {
              LiveFloatManager.b(this.c, false);
              this.c.g = new LiveRoomCloseReason(0, "");
              this.c.r();
              Logger.b("rrrb", new Object[] { "mLiveRoomData null" });
            } else {
              Logger.a("rrrb", new Object[] { "enterLiveChat videoPath = ", LiveFloatManager.m(this.c) });
              liveRoomData.lid = this.a;
              if (LiveRoomManager.a().h() != null) {
                liveRoomData.rankingExtra = (LiveRoomManager.a().h()).rankingExtra;
                liveRoomData.isFollow = (LiveRoomManager.a().h()).isFollow;
                liveRoomData.relationship = (LiveRoomManager.a().h()).relationship;
                liveRoomData.comeCode = (LiveRoomManager.a().h()).comeCode;
                liveRoomData.liveOneKissModel = (LiveRoomManager.a().h()).liveOneKissModel;
              } 
              if (this.c.f != null) {
                liveRoomData.recommendType = this.c.f.bZ;
                liveRoomData.liveFrom = this.c.f.ca;
                liveRoomData.livePosition = this.c.f.cb;
              } 
              LiveRoomManager.a().a(liveRoomData);
              if (TextUtils.isEmpty(LiveFloatManager.m(this.c)) || LiveFloatManager.n(this.c) != this.a) {
                if (this.c.f == null)
                  return; 
                Logger.a("rrrb", new Object[] { "enterLiveChat videoPath = ", LiveFloatManager.m(this.c) });
                this.c.a(liveRoomData.live_url, this.b, this.a, LiveFloatManager.o(this.c), liveRoomData.screen_pattern);
                Log.v("onInfo", "onEnterSuccess");
                this.c.b();
              } 
              LiveFloatManager.b(this.c, true);
            } 
            if (LiveFloatManager.a(this.c) != null) {
              LiveFloatManager.a(this.c).a(true);
              return;
            } 
            LiveFloatManager.c(this.c, true);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            Logger.b("ddrb", new Object[] { "enterLiveChat failed:", Long.valueOf(this.a) });
            if (!LiveFloatManager.l(this.c)) {
              Logger.b("ddrb", new Object[] { "live room has close" });
              return true;
            } 
            if (LiveRoomManager.a().b() != this.a)
              return true; 
            this.c.g = new LiveRoomCloseReason(param1Int, param1String);
            LiveFloatManager.a(this.c, true);
            LiveFloatManager.b(this.c, false);
            this.c.r();
            if (LiveFloatManager.a(this.c) != null)
              LiveFloatManager.a(this.c).b(this.c.g); 
            return true;
          }
        }paramLong, paramString, 1);
  }
  
  public void a(short paramShort, long paramLong, String paramString1, int paramInt, String paramString2) {
    this.C = true;
    this.n = paramString1;
    this.o = paramString2;
    this.m = paramLong;
    if (LiveRoomManager.a().h() != null) {
      paramString1 = (LiveRoomManager.a().h()).live_url;
      if (!TextUtils.isEmpty(paramString1))
        try {
          a(AesCrypto.e(paramString1), paramShort, paramLong, this.n, paramInt);
        } catch (Exception exception) {
          exception.printStackTrace();
        }  
    } 
    LiveEventBus.get("live_open_close").post(Boolean.valueOf(true));
  }
  
  public void a(boolean paramBoolean) {
    this.ao = paramBoolean;
  }
  
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 'rrrb'
    //   5: iconst_2
    //   6: anewarray java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc_w 'prepare mVideoPath = '
    //   14: aastore
    //   15: dup
    //   16: iconst_1
    //   17: aload_0
    //   18: getfield k : Ljava/lang/String;
    //   21: aastore
    //   22: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aload_0
    //   26: getfield k : Ljava/lang/String;
    //   29: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   32: ifeq -> 54
    //   35: ldc_w 'rrrb'
    //   38: iconst_1
    //   39: anewarray java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: ldc_w 'prepare mVideoPath empty'
    //   47: aastore
    //   48: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: invokestatic a : ()Lcom/blued/android/module/live_china/live_info/LiveRoomInfo;
    //   57: invokevirtual v : ()Z
    //   60: pop
    //   61: iconst_1
    //   62: invokestatic c : (I)V
    //   65: aload_0
    //   66: getfield j : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManager;
    //   69: aload_0
    //   70: getfield k : Ljava/lang/String;
    //   73: aload_0
    //   74: getfield b : Lcom/blued/android/module/player/txplayer/view/BlLiveView;
    //   77: invokevirtual a : (Ljava/lang/String;Lcom/blued/android/module/player/txplayer/view/BlLiveView;)V
    //   80: aload_0
    //   81: getfield j : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManager;
    //   84: aload_0
    //   85: getfield au : Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;
    //   88: invokevirtual a : (Lcom/blued/android/module/player/live/manager/OnMediaPlayerListener;)V
    //   91: ldc_w 'pk'
    //   94: ldc_w 'prepare prepareAsync'
    //   97: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   100: pop
    //   101: goto -> 113
    //   104: astore_1
    //   105: aload_0
    //   106: invokevirtual n : ()V
    //   109: aload_1
    //   110: invokevirtual printStackTrace : ()V
    //   113: aload_0
    //   114: monitorexit
    //   115: return
    //   116: astore_1
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    // Exception table:
    //   from	to	target	type
    //   2	51	116	finally
    //   54	101	104	java/lang/Exception
    //   54	101	116	finally
    //   105	113	116	finally
  }
  
  public void b(boolean paramBoolean) {
    this.O = paramBoolean;
  }
  
  public void c() {
    if (!this.j.a()) {
      O();
      OnMediaPlayerConnectListener onMediaPlayerConnectListener = this.p;
      if (onMediaPlayerConnectListener != null)
        onMediaPlayerConnectListener.d(); 
      return;
    } 
    this.q = 1;
    T();
    LiveRoomHttpUtils.a(String.valueOf(this.m), this.n);
    a(this.l, this.m, this.n);
    d();
  }
  
  public void c(boolean paramBoolean) {
    this.A = paramBoolean;
    BLVideoView.a = paramBoolean;
    if (LiveDataManager.a().f() != paramBoolean) {
      LiveDataManager.a().a(paramBoolean);
      LiveEventBus.get("screen_orientation_changed").post(Boolean.valueOf(true));
    } 
  }
  
  public void d() {
    O();
    OnMediaPlayerConnectListener onMediaPlayerConnectListener = this.p;
    if (onMediaPlayerConnectListener != null)
      onMediaPlayerConnectListener.d(); 
    int i = this.q;
    if (i < 10) {
      this.q = i + 1;
      e();
      return;
    } 
    P();
    onMediaPlayerConnectListener = this.p;
    if (onMediaPlayerConnectListener != null)
      onMediaPlayerConnectListener.e(); 
  }
  
  public void d(boolean paramBoolean) {
    this.B = paramBoolean;
  }
  
  public void e() {
    this.h.removeCallbacks(this.r);
    this.h.postDelayed(this.r, 3000L);
  }
  
  public void f() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManager;
    //   6: invokevirtual c : ()V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
  }
  
  public void g() {
    if (Build.VERSION.SDK_INT >= 26)
      AppInfo.n().postDelayed(new Runnable(this) {
            public void run() {
              ViewParent viewParent = this.a.b.getParent();
              if (viewParent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup)viewParent;
                viewGroup.removeView((View)this.a.b);
                viewGroup.addView((View)this.a.b);
              } 
              if (this.a.a != null && this.a.a.getHolder() != null) {
                this.a.a.getHolder().addCallback(LiveFloatManager.e(this.a));
                return;
              } 
              this.a.b.a();
            }
          },  500L); 
  }
  
  public void h() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManager;
    //   6: invokevirtual d : ()V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
  }
  
  public void i() {
    this.j.e();
    this.j.c();
  }
  
  public void j() {
    this.j.f();
  }
  
  public void k() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield ar : Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic d : ()V
    //   17: ldc_w 'ddrb'
    //   20: iconst_4
    //   21: anewarray java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: ldc_w 'startAndShowFloatWindow mIsLiveRoomInit = '
    //   29: aastore
    //   30: dup
    //   31: iconst_1
    //   32: aload_0
    //   33: getfield C : Z
    //   36: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   39: aastore
    //   40: dup
    //   41: iconst_2
    //   42: ldc_w '-- mIsInterruptLiveClose = '
    //   45: aastore
    //   46: dup
    //   47: iconst_3
    //   48: aload_0
    //   49: getfield an : Z
    //   52: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   55: aastore
    //   56: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aload_0
    //   60: getfield C : Z
    //   63: ifeq -> 104
    //   66: aload_0
    //   67: getfield an : Z
    //   70: ifne -> 87
    //   73: aload_0
    //   74: getfield f : Lcom/blued/android/module/live_china/fragment/PlayingOnliveFragment;
    //   77: ifnonnull -> 87
    //   80: aload_0
    //   81: getfield e : Z
    //   84: ifeq -> 104
    //   87: aload_0
    //   88: invokevirtual i : ()V
    //   91: invokestatic a : ()Lcom/blued/android/framework/utils/AudioManagerUtils;
    //   94: invokevirtual b : ()V
    //   97: aload_0
    //   98: invokevirtual L : ()V
    //   101: goto -> 108
    //   104: aload_0
    //   105: invokevirtual m : ()V
    //   108: aload_0
    //   109: monitorexit
    //   110: return
    //   111: astore_2
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_2
    //   115: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	111	finally
    //   14	87	111	finally
    //   87	101	111	finally
    //   104	108	111	finally
  }
  
  public void l() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield ar : Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic c : ()V
    //   17: aload_0
    //   18: getfield C : Z
    //   21: ifeq -> 61
    //   24: aload_0
    //   25: getfield f : Lcom/blued/android/module/live_china/fragment/PlayingOnliveFragment;
    //   28: ifnull -> 46
    //   31: aload_0
    //   32: getfield f : Lcom/blued/android/module/live_china/fragment/PlayingOnliveFragment;
    //   35: getfield aK : Z
    //   38: istore_1
    //   39: iload_1
    //   40: ifeq -> 46
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: aload_0
    //   47: invokevirtual h : ()V
    //   50: invokestatic a : ()Lcom/blued/android/framework/utils/AudioManagerUtils;
    //   53: iconst_0
    //   54: invokevirtual a : (Z)V
    //   57: aload_0
    //   58: invokevirtual M : ()V
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: astore_2
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_2
    //   68: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	64	finally
    //   14	39	64	finally
    //   46	61	64	finally
  }
  
  public void m() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 'ddrb'
    //   5: iconst_1
    //   6: anewarray java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc_w 'closeFloatWindow'
    //   14: aastore
    //   15: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield O : Z
    //   23: aload_0
    //   24: invokevirtual M : ()V
    //   27: aload_0
    //   28: invokevirtual n : ()V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   2	31	34	finally
  }
  
  public void n() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 'ddrb'
    //   5: iconst_1
    //   6: anewarray java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc_w 'close'
    //   14: aastore
    //   15: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_0
    //   19: invokevirtual p : ()V
    //   22: invokestatic a : ()Lcom/blued/android/framework/utils/AudioManagerUtils;
    //   25: iconst_0
    //   26: invokevirtual a : (Z)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   2	29	32	finally
  }
  
  public void o() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManager;
    //   6: invokevirtual g : ()V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
  }
  
  public void onClose(LiveCloseReason paramLiveCloseReason, LiveChatStatistics paramLiveChatStatistics) {
    this.v = true;
    this.g = new LiveRoomCloseReason(400006, "");
    R();
  }
  
  public void onJoinLive(JoinLiveResult paramJoinLiveResult, String paramString1, String paramString2, String paramString3) {}
  
  public void onRecvNewMsg(ChattingModel paramChattingModel) {}
  
  public void onViewerDataChanged(long paramLong, List<ProfileData> paramList) {}
  
  public void onViewerEntrance(EntranceData paramEntranceData, long paramLong) {}
  
  public void p() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield ar : Z
    //   6: ifeq -> 249
    //   9: aload_0
    //   10: getfield m : J
    //   13: ldc2_w -1
    //   16: lcmp
    //   17: ifne -> 23
    //   20: goto -> 249
    //   23: invokestatic b : ()V
    //   26: aload_0
    //   27: invokevirtual q : ()V
    //   30: invokestatic a : ()Lcom/blued/android/module/live_china/msg/LiveMsgSendManager;
    //   33: aload_0
    //   34: getfield l : S
    //   37: aload_0
    //   38: getfield m : J
    //   41: aload_0
    //   42: invokevirtual b : (SJLcom/blued/android/chat/listener/LiveChatInfoListener;)V
    //   45: aload_0
    //   46: getfield m : J
    //   49: invokestatic valueOf : (J)Ljava/lang/String;
    //   52: aload_0
    //   53: getfield n : Ljava/lang/String;
    //   56: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield h : Landroid/os/Handler;
    //   63: aload_0
    //   64: getfield r : Lcom/blued/android/module/live_china/manager/LiveFloatManager$Reconnect;
    //   67: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   70: aload_0
    //   71: aconst_null
    //   72: invokevirtual a : (Lcom/blued/android/module/live_china/manager/LiveFloatManager$OnMediaPlayerConnectListener;)V
    //   75: aload_0
    //   76: invokevirtual O : ()V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield g : Lcom/blued/android/module/live_china/model/LiveRoomCloseReason;
    //   84: aload_0
    //   85: getfield j : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManager;
    //   88: invokevirtual h : ()V
    //   91: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveRoomManager;
    //   94: invokevirtual g : ()V
    //   97: aload_0
    //   98: aconst_null
    //   99: putfield n : Ljava/lang/String;
    //   102: aload_0
    //   103: ldc2_w -1
    //   106: putfield m : J
    //   109: aload_0
    //   110: iconst_0
    //   111: putfield ao : Z
    //   114: aload_0
    //   115: iconst_1
    //   116: putfield q : I
    //   119: aload_0
    //   120: iconst_0
    //   121: putfield w : Z
    //   124: aload_0
    //   125: iconst_0
    //   126: putfield x : Z
    //   129: aload_0
    //   130: iconst_0
    //   131: putfield u : Z
    //   134: aload_0
    //   135: iconst_0
    //   136: putfield t : Z
    //   139: aload_0
    //   140: iconst_0
    //   141: putfield v : Z
    //   144: aload_0
    //   145: iconst_1
    //   146: putfield P : Z
    //   149: aload_0
    //   150: iconst_0
    //   151: putfield Q : Z
    //   154: aload_0
    //   155: iconst_0
    //   156: putfield B : Z
    //   159: aload_0
    //   160: iconst_m1
    //   161: putfield z : I
    //   164: aload_0
    //   165: iconst_0
    //   166: putfield A : Z
    //   169: aload_0
    //   170: iconst_0
    //   171: putfield e : Z
    //   174: aload_0
    //   175: aconst_null
    //   176: putfield k : Ljava/lang/String;
    //   179: aload_0
    //   180: iconst_0
    //   181: putfield ae : I
    //   184: aload_0
    //   185: iconst_0
    //   186: putfield af : I
    //   189: aload_0
    //   190: iconst_0
    //   191: putfield an : Z
    //   194: aload_0
    //   195: iconst_0
    //   196: putfield C : Z
    //   199: aload_0
    //   200: getfield f : Lcom/blued/android/module/live_china/fragment/PlayingOnliveFragment;
    //   203: ifnull -> 231
    //   206: aload_0
    //   207: getfield f : Lcom/blued/android/module/live_china/fragment/PlayingOnliveFragment;
    //   210: invokevirtual getActivity : ()Landroidx/fragment/app/FragmentActivity;
    //   213: ifnull -> 226
    //   216: aload_0
    //   217: getfield f : Lcom/blued/android/module/live_china/fragment/PlayingOnliveFragment;
    //   220: invokevirtual getActivity : ()Landroidx/fragment/app/FragmentActivity;
    //   223: invokevirtual finish : ()V
    //   226: aload_0
    //   227: aconst_null
    //   228: putfield f : Lcom/blued/android/module/live_china/fragment/PlayingOnliveFragment;
    //   231: ldc_w 'live_open_close'
    //   234: invokestatic get : (Ljava/lang/String;)Lcom/jeremyliao/liveeventbus/core/Observable;
    //   237: iconst_0
    //   238: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   241: invokeinterface post : (Ljava/lang/Object;)V
    //   246: aload_0
    //   247: monitorexit
    //   248: return
    //   249: aload_0
    //   250: monitorexit
    //   251: return
    //   252: astore_1
    //   253: aload_0
    //   254: monitorexit
    //   255: aload_1
    //   256: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	252	finally
    //   23	226	252	finally
    //   226	231	252	finally
    //   231	246	252	finally
  }
  
  public void q() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Lcom/blued/android/module/player/live/manager/LiveMediaPlayerManager;
    //   6: invokevirtual i : ()V
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	12	finally
  }
  
  public void r() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 'ddrb'
    //   5: iconst_2
    //   6: anewarray java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: ldc_w 'live miss reason:'
    //   14: aastore
    //   15: dup
    //   16: iconst_1
    //   17: aload_0
    //   18: getfield g : Lcom/blued/android/module/live_china/model/LiveRoomCloseReason;
    //   21: aastore
    //   22: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: aload_0
    //   26: getfield v : Z
    //   29: ifne -> 74
    //   32: aload_0
    //   33: getfield g : Lcom/blued/android/module/live_china/model/LiveRoomCloseReason;
    //   36: invokestatic isCloseByNormal : (Lcom/blued/android/module/live_china/model/LiveRoomCloseReason;)Z
    //   39: ifne -> 45
    //   42: goto -> 74
    //   45: aload_0
    //   46: getfield h : Landroid/os/Handler;
    //   49: aload_0
    //   50: getfield s : Lcom/blued/android/module/live_china/manager/LiveFloatManager$EnterLiveResult;
    //   53: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   56: aload_0
    //   57: getfield h : Landroid/os/Handler;
    //   60: aload_0
    //   61: getfield s : Lcom/blued/android/module/live_china/manager/LiveFloatManager$EnterLiveResult;
    //   64: ldc2_w 3000
    //   67: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   70: pop
    //   71: aload_0
    //   72: monitorexit
    //   73: return
    //   74: aload_0
    //   75: invokespecial U : ()V
    //   78: aload_0
    //   79: monitorexit
    //   80: return
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Exception table:
    //   from	to	target	type
    //   2	42	81	finally
    //   45	71	81	finally
    //   74	78	81	finally
  }
  
  public void s() {
    if (this.j.a() && this.z == 1) {
      Logger.a("ddrb", new Object[] { "PlayingOnliveFragment.show" });
      if (LiveRoomManager.a().h() != null)
        PlayingOnliveFragment.a(AppInfo.d(), LiveRoomManager.a().h(), -1, LiveDataListManager.a().b()); 
    } 
  }
  
  public boolean t() {
    return this.w;
  }
  
  public boolean u() {
    return this.x;
  }
  
  public long v() {
    return this.m;
  }
  
  public boolean w() {
    return this.ao;
  }
  
  public boolean x() {
    return this.N;
  }
  
  public boolean y() {
    return this.O;
  }
  
  public boolean z() {
    return this.u;
  }
  
  class EnterLiveResult implements Runnable {
    private EnterLiveResult(LiveFloatManager this$0) {}
    
    public void run() {
      if (!LiveRoomCloseReason.isCloseByNormal(this.a.g)) {
        LiveFloatManager.i(this.a);
        return;
      } 
      if (!LiveFloatManager.j(this.a) && !LiveFloatManager.k(this.a))
        LiveFloatManager.i(this.a); 
    }
  }
  
  public static interface OnMediaPlayerConnectListener {
    void a();
    
    void a(LiveRoomCloseReason param1LiveRoomCloseReason);
    
    void a(boolean param1Boolean);
    
    void b();
    
    void b(LiveRoomCloseReason param1LiveRoomCloseReason);
    
    void c();
    
    void d();
    
    void e();
  }
  
  class Reconnect implements Runnable {
    private Reconnect(LiveFloatManager this$0) {}
    
    public void run() {
      LiveFloatManager.h(this.a).b();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\LiveFloatManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */