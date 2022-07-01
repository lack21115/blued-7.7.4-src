package c.t.maploc.lite.tsa;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.telephony.CellLocation;
import android.util.SparseArray;
import com.tencent.map.geoloclite.tsa.TencentLiteLocationListener;
import java.util.List;

public final class c implements l, Runnable {
  private static SparseArray c;
  
  private int A = 404;
  
  public volatile TencentLiteLocationListener a;
  
  public final byte[] b = new byte[0];
  
  private BroadcastReceiver d = new e(this);
  
  private g e;
  
  private f f;
  
  private HandlerThread g;
  
  private final j h;
  
  private k i;
  
  private volatile int j = 0;
  
  private ab k = null;
  
  private af l = null;
  
  private ai m = null;
  
  private ae n = null;
  
  private v o = null;
  
  private h p;
  
  private n q;
  
  private s r;
  
  private m s;
  
  private List t = null;
  
  private s u;
  
  private Location v = null;
  
  private long w;
  
  private q x;
  
  private long y = 5000L;
  
  private q z;
  
  static {
    SparseArray sparseArray = new SparseArray();
    c = sparseArray;
    sparseArray.put(0, "OK");
    c.put(1, "ERROR_NETWORK");
    c.put(2, "ERROR_NO_CELL&WIFI");
    c.put(404, "ERROR_SERVER_NOT_LOCATION");
  }
  
  public c(j paramj) {
    this.j = 0;
    this.h = paramj;
    this.i = this.h.b;
    if (Looper.myLooper() == null)
      Looper.prepare(); 
    this.p = new h(this.h);
    if (this.h.c()) {
      ae ae1 = new ae(this.h, this);
    } else {
      paramj = null;
    } 
    this.n = (ae)paramj;
    if (this.h.b()) {
      ai ai1 = new ai(this.h, this);
    } else {
      paramj = null;
    } 
    this.m = (ai)paramj;
    if (Build.VERSION.SDK_INT >= 18) {
      this.k = null;
      if (this.h.a()) {
        af af1 = new af(this.h, this);
      } else {
        paramj = null;
      } 
      this.l = (af)paramj;
    } else {
      this.l = null;
      if (this.h.a()) {
        ab ab1 = new ab(this.h, this);
      } else {
        paramj = null;
      } 
      this.k = (ab)paramj;
    } 
    try {
      this.o = new v(this.h);
    } finally {
      paramj = null;
    } 
  }
  
  private void a(int paramInt, q paramq) {
    if (paramq == null)
      return; 
    boolean bool = d();
    boolean bool2 = false;
    if (bool) {
      boolean bool3;
      if (this.A != 0 && paramInt == 0) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      this.A = paramInt;
      this.z = paramq;
      if (this.a != null)
        e(); 
      if (bool3) {
        a(this.e, 1002, null, 0L);
        return;
      } 
    } 
    boolean bool1 = bool2;
    if (this.A != 0) {
      bool1 = bool2;
      if (paramInt == 0)
        bool1 = true; 
    } 
    bool2 = bool1;
    if (this.A == 0) {
      q q1 = this.z;
      bool2 = bool1;
      if (q1 != null) {
        bool2 = bool1;
        if (q1.getProvider().equals("network")) {
          bool2 = bool1;
          if (paramInt == 0) {
            bool2 = bool1;
            if (paramq != null) {
              bool2 = bool1;
              if (paramq.getProvider().equals("gps"))
                bool2 = true; 
            } 
          } 
        } 
      } 
    } 
    bool1 = bool2;
    if (this.A == 0) {
      q q1 = this.z;
      bool1 = bool2;
      if (q1 != null) {
        bool1 = bool2;
        if (q1.getProvider().equals("gps")) {
          bool1 = bool2;
          if (paramInt == 0) {
            bool1 = bool2;
            if (paramq != null) {
              bool1 = bool2;
              if (paramq.getProvider().equals("network"))
                bool1 = true; 
            } 
          } 
        } 
      } 
    } 
    this.A = paramInt;
    this.z = paramq;
    if (this.a == null || (!bool1 && this.y != 0L))
      return; 
    a(this.e, 1002, null, 0L);
  }
  
  private static void a(Handler paramHandler, int paramInt, Bundle paramBundle, long paramLong) {
    if (paramHandler == null)
      return; 
    Message message = paramHandler.obtainMessage(paramInt);
    message.setData(paramBundle);
    if (paramLong == 0L) {
      message.sendToTarget();
      return;
    } 
    paramHandler.removeMessages(paramInt);
    paramHandler.sendMessageDelayed(message, paramLong);
  }
  
  private static void a(u paramu) {
    if (paramu != null && paramu.h)
      try {
        return;
      } finally {
        Exception exception = null;
        StringBuilder stringBuilder = new StringBuilder("shutdown ");
        stringBuilder.append(paramu.b());
      }  
  }
  
  private static void a(u paramu, Handler paramHandler) {
    if (paramu != null && !paramu.h)
      try {
        return;
      } finally {
        paramHandler = null;
        StringBuilder stringBuilder = new StringBuilder("starup ");
        stringBuilder.append(paramu.b());
      }  
  }
  
  private static boolean a(Object... paramVarArgs) {
    int i1 = paramVarArgs.length;
    for (int i = 0; i < i1; i++) {
      if (paramVarArgs[i] != null)
        return false; 
    } 
    return true;
  }
  
  private boolean d() {
    return (this.A == 404);
  }
  
  private void e() {
    long l1 = this.y;
    if (l1 > 0L)
      a(this.e, 1001, null, l1); 
  }
  
  private boolean f() {
    ae ae1 = this.n;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (ae1 != null) {
      bool1 = bool2;
      if (ae1.d()) {
        boolean bool;
        ae1 = this.n;
        if (System.currentTimeMillis() - ae1.a < 30000L) {
          bool = true;
        } else {
          bool = false;
        } 
        bool1 = bool2;
        if (bool)
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  private void g() {
    if (this.q != null) {
      if (this.o == null)
        return; 
      List list = this.t;
      if (list == null || list.size() == 0)
        this.t = ab.a(this.h.e); 
      list = this.t;
      if (list != null && list.size() != 0) {
        this.o.a(this.q, null, this.t);
        this.v = new Location(this.q.b);
      } 
    } 
  }
  
  public final int a(long paramLong, TencentLiteLocationListener paramTencentLiteLocationListener, Looper paramLooper) {
    // Byte code:
    //   0: aload_0
    //   1: getfield j : I
    //   4: ifeq -> 12
    //   7: aload_0
    //   8: getfield j : I
    //   11: ireturn
    //   12: aload_0
    //   13: invokevirtual c : ()V
    //   16: aload_0
    //   17: sipush #404
    //   20: putfield A : I
    //   23: aconst_null
    //   24: astore #5
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield z : Lc/t/maploc/lite/tsa/q;
    //   31: aload_0
    //   32: getfield b : [B
    //   35: astore #6
    //   37: aload #6
    //   39: monitorenter
    //   40: aload_0
    //   41: aload_3
    //   42: putfield a : Lcom/tencent/map/geoloclite/tsa/TencentLiteLocationListener;
    //   45: aload #6
    //   47: monitorexit
    //   48: aload_0
    //   49: getfield i : Lc/t/maploc/lite/tsa/k;
    //   52: ifnull -> 78
    //   55: invokestatic d : ()Ljava/lang/String;
    //   58: aload_0
    //   59: getfield i : Lc/t/maploc/lite/tsa/k;
    //   62: invokevirtual g : ()Ljava/lang/String;
    //   65: invokevirtual equals : (Ljava/lang/Object;)Z
    //   68: ifeq -> 78
    //   71: aload_0
    //   72: getfield i : Lc/t/maploc/lite/tsa/k;
    //   75: invokevirtual e : ()V
    //   78: aload_0
    //   79: lload_1
    //   80: putfield y : J
    //   83: aload_0
    //   84: getfield i : Lc/t/maploc/lite/tsa/k;
    //   87: aload_0
    //   88: getfield y : J
    //   91: ldc2_w 8000
    //   94: invokestatic max : (JJ)J
    //   97: putfield e : J
    //   100: invokestatic myLooper : ()Landroid/os/Looper;
    //   103: ifnonnull -> 109
    //   106: invokestatic prepare : ()V
    //   109: aload_0
    //   110: getfield e : Lc/t/maploc/lite/tsa/g;
    //   113: astore_3
    //   114: aload_3
    //   115: ifnonnull -> 137
    //   118: new c/t/maploc/lite/tsa/g
    //   121: dup
    //   122: aload_0
    //   123: aload #4
    //   125: invokespecial <init> : (Lc/t/maploc/lite/tsa/c;Landroid/os/Looper;)V
    //   128: astore_3
    //   129: aload_0
    //   130: aload_3
    //   131: putfield e : Lc/t/maploc/lite/tsa/g;
    //   134: goto -> 168
    //   137: aload_3
    //   138: aconst_null
    //   139: invokevirtual removeCallbacksAndMessages : (Ljava/lang/Object;)V
    //   142: aload_0
    //   143: getfield e : Lc/t/maploc/lite/tsa/g;
    //   146: invokevirtual getLooper : ()Landroid/os/Looper;
    //   149: aload #4
    //   151: if_acmpeq -> 168
    //   154: new c/t/maploc/lite/tsa/g
    //   157: dup
    //   158: aload_0
    //   159: aload #4
    //   161: invokespecial <init> : (Lc/t/maploc/lite/tsa/c;Landroid/os/Looper;)V
    //   164: astore_3
    //   165: goto -> 129
    //   168: aload_0
    //   169: invokevirtual b : ()V
    //   172: aload_0
    //   173: getfield g : Landroid/os/HandlerThread;
    //   176: ifnull -> 189
    //   179: aload_0
    //   180: getfield g : Landroid/os/HandlerThread;
    //   183: invokevirtual isAlive : ()Z
    //   186: ifne -> 257
    //   189: aload_0
    //   190: new android/os/HandlerThread
    //   193: dup
    //   194: ldc_w 'loc_mgr_impl'
    //   197: invokespecial <init> : (Ljava/lang/String;)V
    //   200: putfield g : Landroid/os/HandlerThread;
    //   203: aload_0
    //   204: getfield g : Landroid/os/HandlerThread;
    //   207: invokevirtual start : ()V
    //   210: aload_0
    //   211: getfield g : Landroid/os/HandlerThread;
    //   214: ifnonnull -> 223
    //   217: aload #5
    //   219: astore_3
    //   220: goto -> 231
    //   223: aload_0
    //   224: getfield g : Landroid/os/HandlerThread;
    //   227: invokevirtual getLooper : ()Landroid/os/Looper;
    //   230: astore_3
    //   231: aload_3
    //   232: ifnull -> 257
    //   235: aload_0
    //   236: new c/t/maploc/lite/tsa/f
    //   239: dup
    //   240: aload_0
    //   241: aload_3
    //   242: invokespecial <init> : (Lc/t/maploc/lite/tsa/c;Landroid/os/Looper;)V
    //   245: putfield f : Lc/t/maploc/lite/tsa/f;
    //   248: aload_0
    //   249: getfield f : Lc/t/maploc/lite/tsa/f;
    //   252: aload_0
    //   253: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   256: pop
    //   257: iconst_0
    //   258: ireturn
    //   259: astore_3
    //   260: aload #6
    //   262: monitorexit
    //   263: aload_3
    //   264: athrow
    //   265: astore_3
    //   266: goto -> 257
    // Exception table:
    //   from	to	target	type
    //   40	48	259	finally
    //   172	189	265	finally
    //   189	217	265	finally
    //   223	231	265	finally
    //   235	257	265	finally
    //   260	263	259	finally
  }
  
  public final void a(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: ldc_w 'location permission denied'
    //   3: astore #5
    //   5: ldc_w 'unknown'
    //   8: astore_3
    //   9: ldc_w 'wifi'
    //   12: astore #4
    //   14: iload_1
    //   15: iconst_1
    //   16: if_icmpeq -> 88
    //   19: iload_1
    //   20: iconst_2
    //   21: if_icmpeq -> 34
    //   24: ldc_w ''
    //   27: astore_3
    //   28: aload_3
    //   29: astore #4
    //   31: goto -> 137
    //   34: iload_2
    //   35: iconst_1
    //   36: if_icmpne -> 46
    //   39: ldc_w 'cell enabled'
    //   42: astore_3
    //   43: goto -> 61
    //   46: iload_2
    //   47: ifne -> 57
    //   50: ldc_w 'cell disabled'
    //   53: astore_3
    //   54: goto -> 61
    //   57: ldc_w 'unknown'
    //   60: astore_3
    //   61: getstatic c/t/maploc/lite/tsa/ab.a : Z
    //   64: ifeq -> 80
    //   67: ldc_w 'cell'
    //   70: astore #4
    //   72: iconst_2
    //   73: istore_2
    //   74: aload #5
    //   76: astore_3
    //   77: goto -> 137
    //   80: ldc_w 'cell'
    //   83: astore #4
    //   85: goto -> 137
    //   88: iload_2
    //   89: ifeq -> 119
    //   92: iload_2
    //   93: iconst_1
    //   94: if_icmpeq -> 112
    //   97: iload_2
    //   98: iconst_5
    //   99: if_icmpeq -> 105
    //   102: goto -> 123
    //   105: ldc_w 'location service switch is off'
    //   108: astore_3
    //   109: goto -> 123
    //   112: ldc_w 'wifi enabled'
    //   115: astore_3
    //   116: goto -> 123
    //   119: ldc_w 'wifi disabled'
    //   122: astore_3
    //   123: iload_2
    //   124: iconst_5
    //   125: if_icmpeq -> 137
    //   128: getstatic c/t/maploc/lite/tsa/ai.a : Z
    //   131: ifeq -> 137
    //   134: goto -> 72
    //   137: new android/os/Bundle
    //   140: dup
    //   141: invokespecial <init> : ()V
    //   144: astore #5
    //   146: aload #5
    //   148: ldc_w 'name'
    //   151: aload #4
    //   153: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload #5
    //   158: ldc_w 'status'
    //   161: iload_2
    //   162: invokevirtual putInt : (Ljava/lang/String;I)V
    //   165: aload #5
    //   167: ldc_w 'desc'
    //   170: aload_3
    //   171: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload_0
    //   175: getfield e : Lc/t/maploc/lite/tsa/g;
    //   178: sipush #1003
    //   181: aload #5
    //   183: lconst_0
    //   184: invokestatic a : (Landroid/os/Handler;ILandroid/os/Bundle;J)V
    //   187: return
  }
  
  public final void a(p paramp) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 517
    //   4: aload_1
    //   5: instanceof c/t/maploc/lite/tsa/n
    //   8: istore #4
    //   10: iconst_0
    //   11: istore_3
    //   12: iload #4
    //   14: ifeq -> 161
    //   17: aload_1
    //   18: checkcast c/t/maploc/lite/tsa/n
    //   21: astore_1
    //   22: aload_1
    //   23: ifnull -> 110
    //   26: aload_1
    //   27: getfield b : Landroid/location/Location;
    //   30: getstatic c/t/maploc/lite/tsa/n.a : Landroid/location/Location;
    //   33: if_acmpne -> 39
    //   36: goto -> 110
    //   39: aload_0
    //   40: aload_1
    //   41: putfield q : Lc/t/maploc/lite/tsa/n;
    //   44: aload_0
    //   45: getfield x : Lc/t/maploc/lite/tsa/q;
    //   48: astore #5
    //   50: new c/t/maploc/lite/tsa/r
    //   53: dup
    //   54: invokespecial <init> : ()V
    //   57: astore #6
    //   59: aload #6
    //   61: aload #5
    //   63: putfield a : Lc/t/maploc/lite/tsa/q;
    //   66: aload #6
    //   68: ldc 'gps'
    //   70: putfield c : Ljava/lang/String;
    //   73: aload #6
    //   75: new android/location/Location
    //   78: dup
    //   79: aload_1
    //   80: getfield b : Landroid/location/Location;
    //   83: invokespecial <init> : (Landroid/location/Location;)V
    //   86: invokevirtual a : (Landroid/location/Location;)Lc/t/maploc/lite/tsa/r;
    //   89: invokevirtual a : ()Lc/t/maploc/lite/tsa/q;
    //   92: astore #5
    //   94: aload #5
    //   96: aload_1
    //   97: getfield b : Landroid/location/Location;
    //   100: invokevirtual a : (Landroid/location/Location;)V
    //   103: aload_0
    //   104: iconst_0
    //   105: aload #5
    //   107: invokespecial a : (ILc/t/maploc/lite/tsa/q;)V
    //   110: aload_0
    //   111: getfield o : Lc/t/maploc/lite/tsa/v;
    //   114: aload_0
    //   115: getfield f : Lc/t/maploc/lite/tsa/f;
    //   118: invokestatic a : (Lc/t/maploc/lite/tsa/u;Landroid/os/Handler;)V
    //   121: aload_0
    //   122: getfield v : Landroid/location/Location;
    //   125: ifnull -> 156
    //   128: aload_0
    //   129: getfield q : Lc/t/maploc/lite/tsa/n;
    //   132: ifnull -> 517
    //   135: aload_0
    //   136: getfield q : Lc/t/maploc/lite/tsa/n;
    //   139: getfield b : Landroid/location/Location;
    //   142: aload_0
    //   143: getfield v : Landroid/location/Location;
    //   146: invokevirtual distanceTo : (Landroid/location/Location;)F
    //   149: ldc_w 50.0
    //   152: fcmpl
    //   153: iflt -> 517
    //   156: aload_0
    //   157: invokespecial g : ()V
    //   160: return
    //   161: aload_1
    //   162: instanceof c/t/maploc/lite/tsa/s
    //   165: ifeq -> 286
    //   168: aload_1
    //   169: checkcast c/t/maploc/lite/tsa/s
    //   172: astore_1
    //   173: aload_0
    //   174: getfield r : Lc/t/maploc/lite/tsa/s;
    //   177: ifnull -> 228
    //   180: aload_1
    //   181: getstatic c/t/maploc/lite/tsa/s.a : Lc/t/maploc/lite/tsa/s;
    //   184: if_acmpeq -> 228
    //   187: aload_0
    //   188: getfield w : J
    //   191: ldc2_w -1
    //   194: lcmp
    //   195: ifeq -> 228
    //   198: aload_0
    //   199: getfield u : Lc/t/maploc/lite/tsa/s;
    //   202: ifnull -> 228
    //   205: aload_0
    //   206: getfield u : Lc/t/maploc/lite/tsa/s;
    //   209: astore #5
    //   211: aload_1
    //   212: getfield b : Ljava/util/List;
    //   215: aload #5
    //   217: getfield b : Ljava/util/List;
    //   220: invokestatic a : (Ljava/util/List;Ljava/util/List;)Z
    //   223: iconst_1
    //   224: ixor
    //   225: ifne -> 240
    //   228: aload_0
    //   229: getfield f : Lc/t/maploc/lite/tsa/f;
    //   232: sipush #2002
    //   235: aconst_null
    //   236: lconst_0
    //   237: invokestatic a : (Landroid/os/Handler;ILandroid/os/Bundle;J)V
    //   240: aload_0
    //   241: aload_1
    //   242: putfield r : Lc/t/maploc/lite/tsa/s;
    //   245: aload_0
    //   246: getfield q : Lc/t/maploc/lite/tsa/n;
    //   249: ifnull -> 517
    //   252: aload_0
    //   253: getfield r : Lc/t/maploc/lite/tsa/s;
    //   256: ifnull -> 517
    //   259: aload_0
    //   260: getfield o : Lc/t/maploc/lite/tsa/v;
    //   263: ifnull -> 517
    //   266: aload_0
    //   267: getfield o : Lc/t/maploc/lite/tsa/v;
    //   270: aload_0
    //   271: getfield q : Lc/t/maploc/lite/tsa/n;
    //   274: aload_0
    //   275: getfield r : Lc/t/maploc/lite/tsa/s;
    //   278: aload_0
    //   279: getfield t : Ljava/util/List;
    //   282: invokevirtual a : (Lc/t/maploc/lite/tsa/n;Lc/t/maploc/lite/tsa/s;Ljava/util/List;)V
    //   285: return
    //   286: aload_1
    //   287: instanceof c/t/maploc/lite/tsa/m
    //   290: ifeq -> 517
    //   293: aload_1
    //   294: checkcast c/t/maploc/lite/tsa/m
    //   297: astore_1
    //   298: aload_0
    //   299: getfield s : Lc/t/maploc/lite/tsa/m;
    //   302: ifnull -> 525
    //   305: aload_0
    //   306: getfield s : Lc/t/maploc/lite/tsa/m;
    //   309: invokevirtual a : ()Ljava/lang/String;
    //   312: aload_1
    //   313: invokevirtual a : ()Ljava/lang/String;
    //   316: invokevirtual equals : (Ljava/lang/Object;)Z
    //   319: ifne -> 520
    //   322: goto -> 525
    //   325: aload_0
    //   326: aload_1
    //   327: putfield s : Lc/t/maploc/lite/tsa/m;
    //   330: aload_0
    //   331: aload_0
    //   332: getfield h : Lc/t/maploc/lite/tsa/j;
    //   335: getfield e : Landroid/telephony/TelephonyManager;
    //   338: invokestatic a : (Landroid/telephony/TelephonyManager;)Ljava/util/List;
    //   341: putfield t : Ljava/util/List;
    //   344: aload_0
    //   345: getfield m : Lc/t/maploc/lite/tsa/ai;
    //   348: ifnull -> 530
    //   351: aload_0
    //   352: getfield m : Lc/t/maploc/lite/tsa/ai;
    //   355: invokevirtual c : ()Z
    //   358: ifeq -> 530
    //   361: goto -> 364
    //   364: iload_3
    //   365: ifeq -> 373
    //   368: aload_0
    //   369: aconst_null
    //   370: putfield r : Lc/t/maploc/lite/tsa/s;
    //   373: aload_0
    //   374: getfield h : Lc/t/maploc/lite/tsa/j;
    //   377: invokevirtual b : ()Z
    //   380: ifeq -> 397
    //   383: aload_0
    //   384: getfield h : Lc/t/maploc/lite/tsa/j;
    //   387: getfield f : Landroid/net/wifi/WifiManager;
    //   390: invokestatic a : (Landroid/net/wifi/WifiManager;)Ljava/util/List;
    //   393: astore_1
    //   394: goto -> 401
    //   397: getstatic java/util/Collections.EMPTY_LIST : Ljava/util/List;
    //   400: astore_1
    //   401: aload_1
    //   402: invokeinterface size : ()I
    //   407: pop
    //   408: iload_3
    //   409: iconst_1
    //   410: if_icmpeq -> 447
    //   413: aload_1
    //   414: invokeinterface size : ()I
    //   419: ifeq -> 447
    //   422: aload_0
    //   423: getfield w : J
    //   426: lconst_0
    //   427: lcmp
    //   428: ifle -> 459
    //   431: invokestatic currentTimeMillis : ()J
    //   434: aload_0
    //   435: getfield w : J
    //   438: lsub
    //   439: aload_0
    //   440: getfield y : J
    //   443: lcmp
    //   444: ifle -> 459
    //   447: aload_0
    //   448: getfield f : Lc/t/maploc/lite/tsa/f;
    //   451: sipush #2002
    //   454: aconst_null
    //   455: lconst_0
    //   456: invokestatic a : (Landroid/os/Handler;ILandroid/os/Bundle;J)V
    //   459: iload_2
    //   460: ifeq -> 467
    //   463: aload_0
    //   464: invokespecial g : ()V
    //   467: new java/lang/StringBuilder
    //   470: dup
    //   471: ldc_w 'cell change run prepare json,because status:'
    //   474: invokespecial <init> : (Ljava/lang/String;)V
    //   477: astore_1
    //   478: aload_1
    //   479: iload_3
    //   480: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload_1
    //   485: ldc_w ',mLastWF:'
    //   488: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload_1
    //   493: aload_0
    //   494: getfield w : J
    //   497: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload_1
    //   502: ldc_w ',current:'
    //   505: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload_1
    //   510: invokestatic currentTimeMillis : ()J
    //   513: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: return
    //   518: astore_1
    //   519: return
    //   520: iconst_0
    //   521: istore_2
    //   522: goto -> 325
    //   525: iconst_1
    //   526: istore_2
    //   527: goto -> 325
    //   530: iconst_1
    //   531: istore_3
    //   532: goto -> 364
    // Exception table:
    //   from	to	target	type
    //   4	10	518	finally
    //   17	22	518	finally
    //   26	36	518	finally
    //   39	110	518	finally
    //   110	156	518	finally
    //   156	160	518	finally
    //   161	228	518	finally
    //   228	240	518	finally
    //   240	285	518	finally
    //   286	322	518	finally
    //   325	361	518	finally
    //   368	373	518	finally
    //   373	394	518	finally
    //   397	401	518	finally
    //   401	408	518	finally
    //   413	447	518	finally
    //   447	459	518	finally
    //   463	467	518	finally
    //   467	517	518	finally
  }
  
  public final void b() {
    ab.a = false;
    a(this.n);
    a(this.k);
    a(this.l);
    a(this.m);
    a(this.o);
    y.a().f();
    try {
      this.h.a.unregisterReceiver(this.d);
    } finally {
      Exception exception;
    } 
    h h1 = this.p;
    if (h1 != null)
      h1.a(); 
    HandlerThread handlerThread = this.g;
    if (handlerThread != null && handlerThread.isAlive()) {
      f f1 = this.f;
      if (f1 != null) {
        f1.removeCallbacksAndMessages(null);
        this.f = null;
      } 
      this.g.quit();
      this.g = null;
    } 
  }
  
  public final void c() {
    this.q = null;
    this.s = null;
    this.r = null;
    this.u = null;
    this.w = 0L;
    o.a = 0;
  }
  
  public final void run() {
    f f1 = this.f;
    if (f1 != null) {
      h h1 = this.p;
      if (h1 != null && !h1.a) {
        h1.a = true;
        h1.b.clear();
        h1.d = f1;
        h1.c.c.execute(h1);
        h1.e = SystemClock.elapsedRealtime();
      } 
      a(this.m, f1);
      a(this.k, f1);
      a(this.l, f1);
      a(this.n, f1);
      f1.postDelayed(new d(this, f1), 3000L);
      ai ai1 = this.m;
      if (ai1 != null)
        ai1.b = this.i.e; 
      try {
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        return;
      } finally {
        f1 = null;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */