package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import com.amap.api.interfaces.MapCameraMessage;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdate;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.Projection;
import com.amap.api.maps2d.UiSettings;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.Circle;
import com.amap.api.maps2d.model.CircleOptions;
import com.amap.api.maps2d.model.GroundOverlay;
import com.amap.api.maps2d.model.GroundOverlayOptions;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.amap.api.maps2d.model.Polygon;
import com.amap.api.maps2d.model.PolygonOptions;
import com.amap.api.maps2d.model.Polyline;
import com.amap.api.maps2d.model.PolylineOptions;
import com.amap.api.maps2d.model.Text;
import com.amap.api.maps2d.model.TextOptions;
import com.amap.api.maps2d.model.TileOverlay;
import com.amap.api.maps2d.model.TileOverlayOptions;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

class b extends View implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, bb.b, bm.a, l.a, n.a, y {
  private static int aH = Color.rgb(222, 215, 214);
  
  private static Paint aI = null;
  
  private static Bitmap aJ = null;
  
  private d A;
  
  private AMap.OnMyLocationChangeListener B;
  
  private boolean C = true;
  
  private bc D;
  
  private cd E;
  
  private bk F;
  
  private LocationSource G;
  
  private p H;
  
  private a I = null;
  
  private boolean J = false;
  
  private boolean K = false;
  
  private AMap.OnCameraChangeListener L;
  
  private k M;
  
  private AMap.CancelableCallback N = null;
  
  private av O;
  
  private boolean P = false;
  
  private boolean Q = false;
  
  private View R;
  
  private AMap.OnInfoWindowClickListener S;
  
  private AMap.InfoWindowAdapter T;
  
  private ay U;
  
  private AMap.OnMarkerClickListener V;
  
  private Drawable W = null;
  
  private ah Z;
  
  az a;
  
  private float aA;
  
  private float aB;
  
  private int aC;
  
  private int aD;
  
  private long aE = 0L;
  
  private int aF = 0;
  
  private int aG = 0;
  
  private int aK = 0;
  
  private boolean aL = false;
  
  private a aM = null;
  
  private boolean aa = false;
  
  private boolean ab = false;
  
  private boolean ac = false;
  
  private AMap.OnMarkerDragListener ad;
  
  private AMap.OnMapTouchListener ae;
  
  private AMap.OnMapLongClickListener af;
  
  private AMap.OnMapLoadedListener ag;
  
  private AMap.OnMapClickListener ah;
  
  private boolean ai = false;
  
  private AMap.OnMapScreenShotListener aj = null;
  
  private Timer ak = null;
  
  private Thread al = null;
  
  private TimerTask am = new TimerTask(this) {
      public void run() {
        try {
          return;
        } finally {
          Exception exception = null;
          cm.a(exception, "AMapDelegateImpGLSurfaceView", "TimerTask run");
        } 
      }
    };
  
  private Handler an = new Handler();
  
  private Handler ao = new Handler(this) {
      String a = "onTouchHandler";
      
      public void handleMessage(Message param1Message) {
        super.handleMessage(param1Message);
        try {
          if (b.a(this.b) != null)
            return; 
        } finally {
          param1Message = null;
        } 
      }
    };
  
  private Point ap;
  
  private GestureDetector aq;
  
  private bb.a ar;
  
  private ArrayList<GestureDetector.OnGestureListener> as = new ArrayList<GestureDetector.OnGestureListener>();
  
  private ArrayList<bb.b> at = new ArrayList<bb.b>();
  
  private Scroller au;
  
  private int av = 0;
  
  private int aw = 0;
  
  private Matrix ax = new Matrix();
  
  private float ay = 1.0F;
  
  private boolean az = false;
  
  public aq b;
  
  float[] c = new float[2];
  
  boolean d = false;
  
  as e = new as(this);
  
  ce f;
  
  public au g;
  
  protected al h;
  
  public bu i;
  
  public at j;
  
  final Handler k = new Handler(this) {
      String a = "handleMessage";
      
      public void handleMessage(Message param1Message) {
        if (param1Message != null && this.b.a != null) {
          if (this.b.a.c == null)
            return; 
          try {
          
          } finally {
            param1Message = null;
            cm.a((Throwable)param1Message, "AMapDelegateImpGLSurfaceView", "handle_handleMessage");
          } 
        } else {
          return;
        } 
      }
    };
  
  int l = 0;
  
  float m = -1.0F;
  
  private Context n;
  
  private boolean o = false;
  
  private boolean p = true;
  
  private Marker q;
  
  private ab r;
  
  private final int[] s = new int[] { 
      10000000, 5000000, 2000000, 1000000, 500000, 200000, 100000, 50000, 30000, 20000, 
      10000, 5000, 2000, 1000, 500, 200, 100, 50, 25, 10, 
      5 };
  
  private boolean t = true;
  
  private int u = 1;
  
  private CameraUpdate v;
  
  private long w;
  
  private AMap.CancelableCallback x;
  
  private ap y;
  
  private Location z;
  
  public b(Context paramContext) {
    super(paramContext);
    x();
    setClickable(true);
    a(paramContext, (AttributeSet)null);
  }
  
  private void A() {
    if (this.P)
      this.P = false; 
    if (this.ac) {
      this.ac = false;
      m m = m.a();
      m.isChangeFinished = true;
      this.e.a(m);
    } 
    if (this.Q) {
      this.Q = false;
      m m = m.a();
      m.isChangeFinished = true;
      this.e.a(m);
    } 
    this.ab = false;
    Marker marker = this.q;
    if (marker != null) {
      AMap.OnMarkerDragListener onMarkerDragListener = this.ad;
      if (onMarkerDragListener != null)
        onMarkerDragListener.onMarkerDragEnd(marker); 
      this.q = null;
      this.r = null;
    } 
  }
  
  private void B() {
    Point point = this.ap;
    if (point == null)
      return; 
    int i = point.x;
    int j = this.aF;
    int m = this.ap.y;
    int n = this.aG;
    point = this.ap;
    point.x = this.aF;
    point.y = n;
    this.b.d(i - j, m - n);
  }
  
  private CameraPosition C() {
    w w = h();
    return (w == null) ? null : CameraPosition.fromLatLngZoom(new LatLng(w.b() / 1000000.0D, w.a() / 1000000.0D), getZoomLevel());
  }
  
  private void D() {
    // Byte code:
    //   0: aload_0
    //   1: getfield F : Lcom/amap/api/mapcore2d/bk;
    //   4: ifnonnull -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield m : F
    //   12: ldc_w -1.0
    //   15: fcmpl
    //   16: ifne -> 164
    //   19: aload_0
    //   20: invokevirtual getWidth : ()I
    //   23: istore #6
    //   25: aload_0
    //   26: invokevirtual getHeight : ()I
    //   29: istore #7
    //   31: aload_0
    //   32: getfield n : Landroid/content/Context;
    //   35: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   38: invokevirtual getDisplayMetrics : ()Landroid/util/DisplayMetrics;
    //   41: getfield densityDpi : I
    //   44: istore #8
    //   46: bipush #50
    //   48: istore #5
    //   50: iload #8
    //   52: bipush #120
    //   54: if_icmpgt -> 64
    //   57: bipush #100
    //   59: istore #5
    //   61: goto -> 153
    //   64: iload #8
    //   66: sipush #160
    //   69: if_icmpgt -> 92
    //   72: iload #6
    //   74: iload #7
    //   76: invokestatic max : (II)I
    //   79: sipush #480
    //   82: if_icmpgt -> 57
    //   85: bipush #120
    //   87: istore #5
    //   89: goto -> 153
    //   92: iload #8
    //   94: sipush #240
    //   97: if_icmpgt -> 127
    //   100: iload #6
    //   102: iload #7
    //   104: invokestatic min : (II)I
    //   107: sipush #1000
    //   110: if_icmplt -> 120
    //   113: bipush #60
    //   115: istore #5
    //   117: goto -> 153
    //   120: bipush #70
    //   122: istore #5
    //   124: goto -> 153
    //   127: iload #8
    //   129: sipush #320
    //   132: if_icmpgt -> 138
    //   135: goto -> 153
    //   138: iload #8
    //   140: sipush #480
    //   143: if_icmpgt -> 149
    //   146: goto -> 153
    //   149: bipush #40
    //   151: istore #5
    //   153: aload_0
    //   154: iload #5
    //   156: i2f
    //   157: ldc_w 100.0
    //   160: fdiv
    //   161: putfield m : F
    //   164: aload_0
    //   165: invokespecial E : ()Lcom/amap/api/maps2d/model/LatLng;
    //   168: astore #9
    //   170: aload #9
    //   172: ifnonnull -> 176
    //   175: return
    //   176: aload_0
    //   177: invokevirtual getZoomLevel : ()F
    //   180: fstore_3
    //   181: aload_0
    //   182: getfield m : F
    //   185: fstore #4
    //   187: aload #9
    //   189: getfield latitude : D
    //   192: ldc2_w 3.141592653589793
    //   195: dmul
    //   196: ldc2_w 180.0
    //   199: ddiv
    //   200: invokestatic cos : (D)D
    //   203: ldc2_w 2.0
    //   206: dmul
    //   207: ldc2_w 3.141592653589793
    //   210: dmul
    //   211: ldc2_w 6378137.0
    //   214: dmul
    //   215: ldc2_w 2.0
    //   218: fload_3
    //   219: f2d
    //   220: invokestatic pow : (DD)D
    //   223: ldc2_w 256.0
    //   226: dmul
    //   227: ddiv
    //   228: d2f
    //   229: f2d
    //   230: dstore_1
    //   231: aload_0
    //   232: getfield s : [I
    //   235: astore #9
    //   237: fload_3
    //   238: f2i
    //   239: istore #5
    //   241: aload #9
    //   243: iload #5
    //   245: iaload
    //   246: i2d
    //   247: dload_1
    //   248: fload #4
    //   250: f2d
    //   251: dmul
    //   252: ddiv
    //   253: d2i
    //   254: istore #6
    //   256: aload #9
    //   258: iload #5
    //   260: iaload
    //   261: invokestatic a : (I)Ljava/lang/String;
    //   264: astore #9
    //   266: aload_0
    //   267: getfield F : Lcom/amap/api/mapcore2d/bk;
    //   270: iload #6
    //   272: invokevirtual a : (I)V
    //   275: aload_0
    //   276: getfield F : Lcom/amap/api/mapcore2d/bk;
    //   279: aload #9
    //   281: invokevirtual a : (Ljava/lang/String;)V
    //   284: aload_0
    //   285: getfield F : Lcom/amap/api/mapcore2d/bk;
    //   288: invokevirtual postInvalidate : ()V
    //   291: return
  }
  
  private LatLng E() {
    w w = h();
    return (w == null) ? null : new LatLng(r.a(w.b()), r.a(w.a()));
  }
  
  private ae F() {
    w w = h();
    if (w == null)
      return null; 
    ae ae = new ae();
    ae.a = (int)w.e();
    ae.b = (int)w.f();
    return ae;
  }
  
  private static float a(float paramFloat1, float paramFloat2, double paramDouble) {
    return (float)(paramDouble / Math.pow(2.0D, (paramFloat1 - paramFloat2)));
  }
  
  private LatLng a(LatLng paramLatLng) {
    ae ae = new ae();
    b(paramLatLng.latitude, paramLatLng.longitude, ae);
    ae.b -= 60;
    s s = new s();
    a(ae.a, ae.b, s);
    return new LatLng(s.b, s.a);
  }
  
  private void a(float paramFloat1, PointF paramPointF, float paramFloat2, float paramFloat3) {
    try {
      boolean bool = this.h.isZoomGesturesEnabled();
      if (!bool)
        return; 
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "AMapDelegateImpGLSurfaceView", "doScale");
    } 
    az az1 = this.a;
    if (az1 != null) {
      if (az1.c == null)
        return; 
      this.aK = 2;
      int i = this.a.c.c() / 2;
      int j = this.a.c.d() / 2;
      double d1 = Math.log(paramFloat1) / Math.log(2.0D);
      paramFloat1 = a((float)(this.a.c.e() + d1));
      if (paramFloat1 != this.a.c.e()) {
        float[] arrayOfFloat = this.c;
        arrayOfFloat[0] = arrayOfFloat[1];
        arrayOfFloat[1] = paramFloat1;
        if (arrayOfFloat[0] != arrayOfFloat[1]) {
          w w = this.a.b.a(i, j);
          this.a.c.a(paramFloat1);
          this.a.c.a(w);
          D();
        } 
      } 
    } 
  }
  
  private void a(int paramInt1, int paramInt2, ae paramae) {
    getZoomLevel();
    PointF pointF = new PointF(paramInt1, paramInt2);
    av av1 = this.O;
    w w = av1.a(pointF, av1.l, this.O.n, this.O.k, this.O.o);
    if (paramae != null) {
      paramae.a = (int)w.e();
      paramae.b = (int)w.f();
    } 
  }
  
  private void a(Context paramContext) {
    this.ap = null;
    this.aq = new GestureDetector(paramContext, this);
    this.ar = bb.a(paramContext, this);
    this.au = new Scroller(paramContext);
    new DisplayMetrics();
    DisplayMetrics displayMetrics = paramContext.getApplicationContext().getResources().getDisplayMetrics();
    this.aC = displayMetrics.widthPixels;
    this.aD = displayMetrics.heightPixels;
    this.av = displayMetrics.widthPixels / 2;
    this.aw = displayMetrics.heightPixels / 2;
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet) {
    q.b = cq.c(paramContext);
    this.n = paramContext;
    try {
      this.al = new g(this.n, this);
      this.Z = new bi(this);
      setBackgroundColor(Color.rgb(222, 215, 214));
      n.a().a(this);
      l.a().a(this);
      this.I = new a(this);
      this.A = new d(this);
      this.M = new k(paramContext);
      this.i = new bu(this.n, this);
      this.a = new az(this.n, this, q.j);
      this.i.a(true);
      this.O = this.a.h;
      this.b = new aq(this.a);
      this.h = new ca(this);
      this.f = new ce(this.n, this.b, this);
      this.g = new au(this.n, this);
      this.y = new ap(this.n, this.e, this);
      this.E = new cd(this.n, this);
      this.F = new bk(this.n, this);
      this.H = new p(this.n, this.e, this);
      this.j = new at(this.n, paramAttributeSet, this);
      ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
      y();
      this.g.addView(this.i, layoutParams);
      this.g.addView(this.E, layoutParams);
      this.g.addView(this.F, layoutParams);
      layoutParams = new au.a(layoutParams);
      this.g.addView(this.j, layoutParams);
      layoutParams = new au.a(-2, -2, new LatLng(0.0D, 0.0D), 0, 0, 83);
      this.g.addView((View)this.f, layoutParams);
      layoutParams = new au.a(-2, -2, new LatLng(0.0D, 0.0D), 0, 0, 83);
      this.g.addView((View)this.y, layoutParams);
      try {
        if (!c().isMyLocationButtonEnabled())
          this.y.setVisibility(8); 
      } catch (RemoteException remoteException) {
        cm.a((Throwable)remoteException, "AMapDelegateImpGLSurfaceView", "initEnviornment");
      } 
      this.H.setVisibility(8);
      layoutParams = new au.a(-2, -2, new LatLng(0.0D, 0.0D), 0, 0, 51);
      this.g.addView((View)this.H, layoutParams);
      this.D = new bc(this, this.n);
      this.f.setId(h.a);
      this.al.setName("AuthThread");
      this.al.start();
      return;
    } finally {
      paramContext = null;
      cm.a((Throwable)paramContext, "AMapDelegateImpGLSurfaceView", "initEnviornment");
    } 
  }
  
  private void a(MotionEvent paramMotionEvent) {
    if (this.ab && this.r != null && this.q != null) {
      int i = (int)paramMotionEvent.getX();
      int j = (int)(paramMotionEvent.getY() - 60.0F);
      s s = new s();
      a(i, j, s);
      LatLng latLng = new LatLng(s.b, s.a);
      ab ab1 = this.r;
      if (ab1 != null && ab1.isDraggable()) {
        this.r.a(latLng);
        AMap.OnMarkerDragListener onMarkerDragListener = this.ad;
        if (onMarkerDragListener != null)
          onMarkerDragListener.onMarkerDrag(this.q); 
      } 
    } 
  }
  
  private void a(boolean paramBoolean, CameraPosition paramCameraPosition) {
    if (this.L == null)
      return; 
    if (!this.M.a())
      return; 
    if (!isEnabled())
      return; 
    CameraPosition cameraPosition = paramCameraPosition;
    if (paramCameraPosition == null)
      try {
        cameraPosition = getCameraPosition();
      } catch (RemoteException remoteException) {
        cm.a((Throwable)remoteException, "AMapDelegateImpGLSurfaceView", "cameraChangeFinish");
        cameraPosition = paramCameraPosition;
      }  
    try {
      return;
    } finally {
      paramCameraPosition = null;
      paramCameraPosition.printStackTrace();
    } 
  }
  
  private void b(int paramInt1, int paramInt2) {
    if (this.ap == null)
      return; 
    this.aF = paramInt1;
    this.aG = paramInt2;
    B();
  }
  
  private boolean b(MotionEvent paramMotionEvent) {
    boolean bool2;
    boolean bool1 = false;
    try {
      bool2 = this.ar.a(paramMotionEvent, getWidth(), getHeight());
      boolean bool = bool2;
      if (!bool2) {
        bool1 = bool2;
        bool = this.aq.onTouchEvent(paramMotionEvent);
      } 
      bool1 = bool;
      if (paramMotionEvent.getAction() == 1) {
        bool1 = bool;
        if (this.ac) {
          bool1 = bool;
          l.a().b();
        } 
      } 
      bool1 = bool;
      if (paramMotionEvent.getAction() == 2) {
        bool1 = bool;
        a(paramMotionEvent);
      } 
      bool1 = bool;
    } finally {
      paramMotionEvent = null;
      cm.a((Throwable)paramMotionEvent, "AMapDelegateImpGLSurfaceView", "handleTouch");
    } 
    return bool2;
  }
  
  public static int m() {
    return aH;
  }
  
  public static Paint n() {
    // Byte code:
    //   0: ldc com/amap/api/mapcore2d/b
    //   2: monitorenter
    //   3: getstatic com/amap/api/mapcore2d/b.aI : Landroid/graphics/Paint;
    //   6: ifnonnull -> 66
    //   9: new android/graphics/Paint
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/amap/api/mapcore2d/b.aI : Landroid/graphics/Paint;
    //   19: getstatic com/amap/api/mapcore2d/b.aI : Landroid/graphics/Paint;
    //   22: ldc_w -7829368
    //   25: invokevirtual setColor : (I)V
    //   28: getstatic com/amap/api/mapcore2d/b.aI : Landroid/graphics/Paint;
    //   31: bipush #90
    //   33: invokevirtual setAlpha : (I)V
    //   36: new android/graphics/DashPathEffect
    //   39: dup
    //   40: iconst_2
    //   41: newarray float
    //   43: dup
    //   44: iconst_0
    //   45: fconst_2
    //   46: fastore
    //   47: dup
    //   48: iconst_1
    //   49: ldc_w 2.5
    //   52: fastore
    //   53: fconst_1
    //   54: invokespecial <init> : ([FF)V
    //   57: astore_0
    //   58: getstatic com/amap/api/mapcore2d/b.aI : Landroid/graphics/Paint;
    //   61: aload_0
    //   62: invokevirtual setPathEffect : (Landroid/graphics/PathEffect;)Landroid/graphics/PathEffect;
    //   65: pop
    //   66: getstatic com/amap/api/mapcore2d/b.aI : Landroid/graphics/Paint;
    //   69: astore_0
    //   70: ldc com/amap/api/mapcore2d/b
    //   72: monitorexit
    //   73: aload_0
    //   74: areturn
    //   75: astore_0
    //   76: ldc com/amap/api/mapcore2d/b
    //   78: monitorexit
    //   79: aload_0
    //   80: athrow
    // Exception table:
    //   from	to	target	type
    //   3	66	75	finally
    //   66	70	75	finally
  }
  
  private void w() {
    try {
      if (this.v != null) {
        animateCameraWithDurationAndCallback(this.v, this.w, this.x);
        this.v = null;
        this.w = 0L;
        return;
      } 
    } finally {
      Exception exception = null;
    } 
  }
  
  private void x() {
    // Byte code:
    //   0: ldc android/view/View
    //   2: invokevirtual getMethods : ()[Ljava/lang/reflect/Method;
    //   5: astore #4
    //   7: aload #4
    //   9: arraylength
    //   10: istore_2
    //   11: iconst_0
    //   12: istore_1
    //   13: iload_1
    //   14: iload_2
    //   15: if_icmpge -> 50
    //   18: aload #4
    //   20: iload_1
    //   21: aaload
    //   22: astore_3
    //   23: aload_3
    //   24: ifnull -> 43
    //   27: aload_3
    //   28: invokevirtual getName : ()Ljava/lang/String;
    //   31: ldc_w 'setLayerType'
    //   34: invokevirtual equals : (Ljava/lang/Object;)Z
    //   37: ifeq -> 43
    //   40: goto -> 52
    //   43: iload_1
    //   44: iconst_1
    //   45: iadd
    //   46: istore_1
    //   47: goto -> 13
    //   50: aconst_null
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull -> 100
    //   56: aload_3
    //   57: aload_0
    //   58: iconst_2
    //   59: anewarray java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: ldc android/view/View
    //   66: ldc_w 'LAYER_TYPE_SOFTWARE'
    //   69: invokevirtual getField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   72: aconst_null
    //   73: invokevirtual getInt : (Ljava/lang/Object;)I
    //   76: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   79: aastore
    //   80: dup
    //   81: iconst_1
    //   82: aconst_null
    //   83: aastore
    //   84: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: return
    //   89: astore_3
    //   90: aload_3
    //   91: ldc_w 'AMapDelegateImpGLSurfaceView'
    //   94: ldc_w 'setLayerType'
    //   97: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   100: return
    // Exception table:
    //   from	to	target	type
    //   56	88	89	java/lang/Exception
  }
  
  private void y() {
    a(this.n);
    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.g.addView(this, 0, layoutParams);
  }
  
  private void z() {
    this.a.a();
    aq aq1 = this.b;
    if (aq1 != null) {
      aq1.b(true);
      this.b.e();
    } 
    this.b = null;
    this.a = null;
  }
  
  public void AMapInvalidate() {
    postInvalidate();
    this.g.postInvalidate();
  }
  
  public float a(float paramFloat) {
    az az1 = this.a;
    float f = paramFloat;
    if (az1 != null) {
      if (az1.c == null)
        return paramFloat; 
      float f1 = paramFloat;
      if (paramFloat < this.a.c.b())
        f1 = this.a.c.b(); 
      f = f1;
      if (f1 > this.a.c.a())
        f = this.a.c.a(); 
    } 
    return f;
  }
  
  public az a() {
    return this.a;
  }
  
  public void a(double paramDouble1, double paramDouble2, ae paramae) {
    av av1 = this.O;
    if (av1 == null)
      return; 
    w w = av1.b(new w((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D)));
    paramae.a = w.a();
    paramae.b = w.b();
  }
  
  public void a(double paramDouble1, double paramDouble2, s params) {
    getZoomLevel();
    w w = new w((int)r.a(paramDouble1), (int)r.a(paramDouble2));
    av av1 = this.O;
    PointF pointF = av1.b(w, av1.l, this.O.n, this.O.k);
    if (params != null) {
      params.a = pointF.x;
      params.b = pointF.y;
    } 
  }
  
  public void a(float paramFloat, Point paramPoint, boolean paramBoolean, long paramLong) {
    if (this.b != null) {
      if (this.a == null)
        return; 
      float f1 = getZoomLevel();
      float f2 = cm.b(f1 + paramFloat);
      if (f2 - f1 <= 0.0F)
        return; 
      new ae();
      ae ae = F();
      if (paramPoint != null && ae != null) {
        ae ae1 = new ae();
        a(paramPoint.x, paramPoint.y, ae1);
        int m = ae.a;
        int n = ae1.a;
        int i = ae.b;
        int j = ae1.b;
        double d2 = (m - n);
        double d1 = paramFloat;
        m = (int)(d2 / Math.pow(2.0D, d1) - d2);
        d2 = (i - j);
        i = (int)(d2 / Math.pow(2.0D, d1) - d2);
        ae1.a += m;
        ae1.b += i;
        w w = new w(ae.b, ae.a, false);
        w = this.a.h.b(w);
        if (paramBoolean) {
          this.b.a(f2, paramPoint.x, paramPoint.y, (int)paramLong);
          return;
        } 
        this.b.a(w);
        l.a().b();
      } 
    } 
  }
  
  public void a(int paramInt1, int paramInt2) {
    cd cd1 = this.E;
    if (cd1 != null) {
      cd1.a(paramInt1, paramInt2, getMapWidth(), getMapHeight());
      this.E.postInvalidate();
      if (this.F.getVisibility() == 0)
        this.F.postInvalidate(); 
    } 
  }
  
  public void a(int paramInt1, int paramInt2, s params) {
    PointF pointF = new PointF(paramInt1, paramInt2);
    av av1 = this.O;
    w w = av1.a(pointF, av1.l, this.O.n, this.O.k, this.O.o);
    if (params != null) {
      double d1 = r.a(w.b());
      double d2 = r.a(w.a());
      params.b = d1;
      params.a = d2;
    } 
  }
  
  protected void a(MapCameraMessage paramMapCameraMessage, boolean paramBoolean, long paramLong) {
    float f2;
    float f3;
    LatLngBounds latLngBounds;
    if (this.b == null)
      return; 
    try {
      latLngBounds = paramMapCameraMessage.bounds;
      if (latLngBounds != null && latLngBounds.northeast != null) {
        if (latLngBounds.southwest == null)
          return; 
        if (paramMapCameraMessage.width == 0)
          paramMapCameraMessage.width = this.a.c.c(); 
        if (paramMapCameraMessage.height == 0)
          paramMapCameraMessage.height = this.a.c.d(); 
        f1 = (float)(latLngBounds.northeast.latitude * 1000000.0D - latLngBounds.southwest.latitude * 1000000.0D);
        f2 = (float)(latLngBounds.northeast.longitude * 1000000.0D - latLngBounds.southwest.longitude * 1000000.0D);
        if (f1 == 0.0F)
          f1 = 1.0F; 
      } else {
        return;
      } 
    } catch (Exception exception) {
      cm.a(exception, "AMapDelegateImpGLSurfaceView", "newLatLngBoundsWithSize");
      return;
    } 
    if (f2 == 0.0F)
      f2 = 1.0F; 
    int i = ((MapCameraMessage)exception).paddingLeft;
    int j = ((MapCameraMessage)exception).paddingRight;
    int m = ((MapCameraMessage)exception).paddingTop;
    int n = ((MapCameraMessage)exception).paddingBottom;
    Pair<Float, Boolean> pair = this.b.a(f1, f2, ((MapCameraMessage)exception).width, ((MapCameraMessage)exception).height, i + j, m + n);
    if (pair != null) {
      f3 = ((Float)pair.first).floatValue();
      ((Boolean)pair.second).booleanValue();
      ae ae1 = new ae();
      b(latLngBounds.northeast.latitude, latLngBounds.northeast.longitude, ae1);
      ae ae2 = new ae();
      b(latLngBounds.southwest.latitude, latLngBounds.southwest.longitude, ae2);
      m = Math.abs(ae1.a - ae2.a);
      j = Math.abs(ae2.b - ae1.b);
      i = j;
      if (j == 0)
        i = 1; 
    } else {
      i = (int)((latLngBounds.northeast.latitude * 1000000.0D + latLngBounds.southwest.latitude * 1000000.0D) / 2.0D);
      j = (int)((latLngBounds.northeast.longitude * 1000000.0D + latLngBounds.southwest.longitude * 1000000.0D) / 2.0D);
      f1 = -1.0F;
      w = new w(i, j);
    } 
    j = m;
    if (m == 0)
      j = 1; 
    j = (int)a(getZoomLevel(), f3, j);
    i = (int)a(getZoomLevel(), f3, i);
    i = (int)(latLngBounds.southwest.latitude * 1000000.0D + ((((MapCameraMessage)w).paddingTop - ((MapCameraMessage)w).paddingBottom + i) * f1 / (i * 2)));
    j = (int)(latLngBounds.southwest.longitude * 1000000.0D + ((((MapCameraMessage)w).paddingRight - ((MapCameraMessage)w).paddingLeft + j) * f2 / (j * 2)));
    float f1 = f3;
    w w = new w(i, j);
  }
  
  public void a(ab paramab) throws RemoteException {
    byte b1;
    byte b2;
    if (paramab == null)
      return; 
    if (paramab.getTitle() == null && paramab.getSnippet() == null)
      return; 
    e();
    Marker marker = new Marker(paramab);
    AMap.InfoWindowAdapter infoWindowAdapter = this.T;
    if (infoWindowAdapter != null)
      this.R = infoWindowAdapter.getInfoWindow(marker); 
    try {
      if (this.W == null)
        this.W = bd.a(this.n, "infowindow_bg2d.9.png"); 
    } catch (Exception exception) {
      cm.a(exception, "AMapDelegateImpGLSurfaceView", "showInfoWindow");
    } 
    if (this.R == null) {
      infoWindowAdapter = this.T;
      if (infoWindowAdapter != null)
        this.R = infoWindowAdapter.getInfoContents(marker); 
    } 
    View view = this.R;
    if (view != null) {
      if (view.getBackground() == null)
        this.R.setBackgroundDrawable(this.W); 
    } else {
      LinearLayout linearLayout = new LinearLayout(this.n);
      linearLayout.setBackgroundDrawable(this.W);
      TextView textView1 = new TextView(this.n);
      textView1.setText(paramab.getTitle());
      textView1.setTextColor(-16777216);
      TextView textView2 = new TextView(this.n);
      textView2.setTextColor(-16777216);
      textView2.setText(paramab.getSnippet());
      linearLayout.setOrientation(1);
      linearLayout.addView((View)textView1);
      linearLayout.addView((View)textView2);
      this.R = (View)linearLayout;
    } 
    ViewGroup.LayoutParams layoutParams = this.R.getLayoutParams();
    this.R.setDrawingCacheEnabled(true);
    this.R.setDrawingCacheQuality(0);
    s s = paramab.b();
    if (layoutParams != null) {
      b1 = layoutParams.width;
      b2 = layoutParams.height;
    } else {
      b1 = -2;
      b2 = -2;
    } 
    layoutParams = new au.a(b1, b2, paramab.getRealPosition(), -((int)s.a) + paramab.getWidth() / 2, -((int)s.b) + 2, 81);
    this.U = (ay)paramab;
    au au1 = this.g;
    if (au1 != null)
      au1.addView(this.R, layoutParams); 
  }
  
  public void a(boolean paramBoolean) {
    if (j() == paramBoolean)
      return; 
    if (this.a == null)
      return; 
    if (!paramBoolean) {
      (a()).e.a((a()).e.h, false);
      (a()).e.a((a()).e.g, true);
      (a()).c.a(false, false);
      return;
    } 
    if ((a()).e.b((a()).e.h) != null) {
      (a()).e.a((a()).e.h, true);
      (a()).c.a(false, false);
      return;
    } 
    an an = new an(this.O);
    an.q = new bv(this.a, an);
    an.j = new cb(this) {
        public String a(int param1Int1, int param1Int2, int param1Int3) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(ax.a().e());
          stringBuilder.append("/appmaptile?z=");
          stringBuilder.append(param1Int3);
          stringBuilder.append("&x=");
          stringBuilder.append(param1Int1);
          stringBuilder.append("&y=");
          stringBuilder.append(param1Int2);
          stringBuilder.append("&lang=zh_cn&size=1&scale=1&style=6");
          return stringBuilder.toString();
        }
      };
    an.b = (a()).e.h;
    an.e = true;
    an.a(true);
    an.f = true;
    an.c = q.c;
    an.d = q.d;
    (a()).e.a(an, this.n);
    (a()).e.a((a()).e.h, true);
    (a()).c.a(false, false);
  }
  
  public boolean a(float paramFloat1, float paramFloat2) {
    aq aq1 = this.b;
    if (aq1 != null)
      aq1.b(true); 
    if (this.az) {
      this.aA += paramFloat1;
      this.aB += paramFloat2;
    } 
    postInvalidate();
    return this.az;
  }
  
  public boolean a(float paramFloat, PointF paramPointF) {
    try {
      boolean bool = this.h.isZoomGesturesEnabled();
      if (!bool)
        return false; 
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "AMapDelegateImpGLSurfaceView", "onScale");
    } 
    az az1 = this.a;
    if (az1 != null && az1.e != null)
      this.a.e.c = false; 
    r();
    a(paramFloat, paramPointF, this.aA, this.aB);
    this.az = false;
    postInvalidateDelayed(8L);
    this.a.a(true);
    return true;
  }
  
  public boolean a(Matrix paramMatrix) {
    return false;
  }
  
  public boolean a(PointF paramPointF) {
    try {
      boolean bool = this.h.isZoomGesturesEnabled();
      if (!bool)
        return false; 
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "AMapDelegateImpGLSurfaceView", "startScale");
    } 
    try {
      boolean bool = c().isZoomGesturesEnabled();
      if (!bool)
        return false; 
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "AMapDelegateImpGLSurfaceView", "startScale");
    } 
    az az1 = this.a;
    if (az1 != null && az1.e != null) {
      this.a.a(this.p);
      this.a.e.a(true);
      this.a.e.c = true;
    } 
    this.az = true;
    return true;
  }
  
  public Circle addCircle(CircleOptions paramCircleOptions) throws RemoteException {
    try {
      if (this.a == null)
        return null; 
      z z = this.a.f.a(paramCircleOptions);
      postInvalidate();
    } finally {
      paramCircleOptions = null;
    } 
    return null;
  }
  
  public GroundOverlay addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions) throws RemoteException {
    try {
      if (this.a == null)
        return null; 
      aa aa = this.a.f.a(paramGroundOverlayOptions);
      postInvalidate();
    } finally {
      paramGroundOverlayOptions = null;
    } 
    return null;
  }
  
  public Marker addMarker(MarkerOptions paramMarkerOptions) throws RemoteException {
    if (paramMarkerOptions == null)
      return null; 
    try {
      ay ay1 = new ay(paramMarkerOptions, this.j);
      return new Marker(ay1);
    } finally {
      paramMarkerOptions = null;
      cm.a((Throwable)paramMarkerOptions, "AMapDelegateImpGLSurfaceView", "addMarker");
    } 
  }
  
  public Polygon addPolygon(PolygonOptions paramPolygonOptions) throws RemoteException {
    try {
    
    } finally {
      paramPolygonOptions = null;
    } 
    return null;
  }
  
  public Polyline addPolyline(PolylineOptions paramPolylineOptions) throws RemoteException {
    try {
      if (this.a == null)
        return null; 
      ag ag = (a()).f.a(paramPolylineOptions);
      postInvalidate();
    } finally {
      paramPolylineOptions = null;
    } 
    return null;
  }
  
  public Text addText(TextOptions paramTextOptions) throws RemoteException {
    bp bp = new bp(this, paramTextOptions, this.j);
    this.j.a(bp);
    postInvalidate();
    return new Text(bp);
  }
  
  public TileOverlay addTileOverlay(TileOverlayOptions paramTileOverlayOptions) throws RemoteException {
    az az1 = this.a;
    if (az1 == null)
      return null; 
    bt bt = new bt(paramTileOverlayOptions, this.i, az1.h, this.a, this.n);
    this.i.a(bt);
    postInvalidate();
    return new TileOverlay(bt);
  }
  
  public void animateCamera(CameraUpdate paramCameraUpdate) throws RemoteException {
    if (paramCameraUpdate == null)
      return; 
    animateCameraWithCallback(paramCameraUpdate, (AMap.CancelableCallback)null);
  }
  
  public void animateCameraWithCallback(CameraUpdate paramCameraUpdate, AMap.CancelableCallback paramCancelableCallback) throws RemoteException {
    if (paramCameraUpdate == null)
      return; 
    try {
      return;
    } finally {
      paramCameraUpdate = null;
      paramCameraUpdate.printStackTrace();
    } 
  }
  
  public void animateCameraWithDurationAndCallback(CameraUpdate paramCameraUpdate, long paramLong, AMap.CancelableCallback paramCancelableCallback) throws RemoteException {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 5
    //   4: return
    //   5: aload_1
    //   6: invokevirtual getCameraUpdateFactoryDelegate : ()Lcom/amap/api/interfaces/MapCameraMessage;
    //   9: astore #8
    //   11: aload #8
    //   13: getfield nowType : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   16: getstatic com/amap/api/interfaces/MapCameraMessage$Type.j : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   19: if_acmpne -> 53
    //   22: aload_0
    //   23: invokevirtual getWidth : ()I
    //   26: aload_0
    //   27: invokevirtual getHeight : ()I
    //   30: invokestatic a : (II)Z
    //   33: ifne -> 53
    //   36: aload_0
    //   37: aload_1
    //   38: putfield v : Lcom/amap/api/maps2d/CameraUpdate;
    //   41: aload_0
    //   42: lload_2
    //   43: putfield w : J
    //   46: aload_0
    //   47: aload #4
    //   49: putfield x : Lcom/amap/api/maps2d/AMap$CancelableCallback;
    //   52: return
    //   53: aload_0
    //   54: getfield b : Lcom/amap/api/mapcore2d/aq;
    //   57: ifnonnull -> 61
    //   60: return
    //   61: aload #4
    //   63: ifnull -> 72
    //   66: aload_0
    //   67: aload #4
    //   69: putfield N : Lcom/amap/api/maps2d/AMap$CancelableCallback;
    //   72: aload_0
    //   73: getfield b : Lcom/amap/api/mapcore2d/aq;
    //   76: invokevirtual f : ()Z
    //   79: ifeq -> 89
    //   82: aload_0
    //   83: getfield b : Lcom/amap/api/mapcore2d/aq;
    //   86: invokevirtual g : ()V
    //   89: aload #4
    //   91: ifnull -> 100
    //   94: aload_0
    //   95: aload #4
    //   97: putfield N : Lcom/amap/api/maps2d/AMap$CancelableCallback;
    //   100: aload_0
    //   101: getfield J : Z
    //   104: ifeq -> 112
    //   107: aload_0
    //   108: iconst_1
    //   109: putfield K : Z
    //   112: aload #8
    //   114: getfield nowType : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   117: getstatic com/amap/api/interfaces/MapCameraMessage$Type.h : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   120: if_acmpne -> 169
    //   123: aload_0
    //   124: invokevirtual r : ()V
    //   127: aload_0
    //   128: getfield a : Lcom/amap/api/mapcore2d/az;
    //   131: ifnonnull -> 135
    //   134: return
    //   135: aload_0
    //   136: getfield o : Z
    //   139: ifne -> 143
    //   142: return
    //   143: aload_0
    //   144: getfield b : Lcom/amap/api/mapcore2d/aq;
    //   147: aload #8
    //   149: getfield xPixel : F
    //   152: f2i
    //   153: aload #8
    //   155: getfield yPixel : F
    //   158: f2i
    //   159: lload_2
    //   160: l2i
    //   161: invokevirtual a : (III)V
    //   164: aload_0
    //   165: invokevirtual postInvalidate : ()V
    //   168: return
    //   169: aload #8
    //   171: getfield nowType : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   174: getstatic com/amap/api/interfaces/MapCameraMessage$Type.b : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   177: if_acmpne -> 191
    //   180: aload_0
    //   181: getfield b : Lcom/amap/api/mapcore2d/aq;
    //   184: lload_2
    //   185: l2i
    //   186: invokevirtual a : (I)Z
    //   189: pop
    //   190: return
    //   191: aload #8
    //   193: getfield nowType : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   196: getstatic com/amap/api/interfaces/MapCameraMessage$Type.e : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   199: if_acmpne -> 213
    //   202: aload_0
    //   203: getfield b : Lcom/amap/api/mapcore2d/aq;
    //   206: lload_2
    //   207: l2i
    //   208: invokevirtual b : (I)Z
    //   211: pop
    //   212: return
    //   213: aload #8
    //   215: getfield nowType : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   218: getstatic com/amap/api/interfaces/MapCameraMessage$Type.f : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   221: if_acmpne -> 244
    //   224: aload #8
    //   226: getfield zoom : F
    //   229: fstore #5
    //   231: aload_0
    //   232: getfield b : Lcom/amap/api/mapcore2d/aq;
    //   235: fload #5
    //   237: lload_2
    //   238: l2i
    //   239: invokevirtual a : (FI)F
    //   242: pop
    //   243: return
    //   244: aload #8
    //   246: getfield nowType : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   249: getstatic com/amap/api/interfaces/MapCameraMessage$Type.g : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   252: if_acmpne -> 319
    //   255: aload #8
    //   257: getfield amount : F
    //   260: fstore #5
    //   262: aload #8
    //   264: getfield focus : Landroid/graphics/Point;
    //   267: astore #4
    //   269: aload #4
    //   271: astore_1
    //   272: aload #4
    //   274: ifnonnull -> 309
    //   277: new android/graphics/Point
    //   280: dup
    //   281: aload_0
    //   282: getfield a : Lcom/amap/api/mapcore2d/az;
    //   285: getfield c : Lcom/amap/api/mapcore2d/az$c;
    //   288: invokevirtual c : ()I
    //   291: iconst_2
    //   292: idiv
    //   293: aload_0
    //   294: getfield a : Lcom/amap/api/mapcore2d/az;
    //   297: getfield c : Lcom/amap/api/mapcore2d/az$c;
    //   300: invokevirtual d : ()I
    //   303: iconst_2
    //   304: idiv
    //   305: invokespecial <init> : (II)V
    //   308: astore_1
    //   309: aload_0
    //   310: fload #5
    //   312: aload_1
    //   313: iconst_1
    //   314: lload_2
    //   315: invokevirtual a : (FLandroid/graphics/Point;ZJ)V
    //   318: return
    //   319: aload #8
    //   321: getfield nowType : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   324: getstatic com/amap/api/interfaces/MapCameraMessage$Type.i : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   327: if_acmpne -> 397
    //   330: aload #8
    //   332: getfield cameraPosition : Lcom/amap/api/maps2d/model/CameraPosition;
    //   335: astore_1
    //   336: aload_0
    //   337: getfield b : Lcom/amap/api/mapcore2d/aq;
    //   340: aload_1
    //   341: getfield zoom : F
    //   344: invokevirtual c : (F)F
    //   347: pop
    //   348: aload_1
    //   349: getfield target : Lcom/amap/api/maps2d/model/LatLng;
    //   352: getfield latitude : D
    //   355: ldc2_w 1000000.0
    //   358: dmul
    //   359: d2i
    //   360: istore #6
    //   362: aload_1
    //   363: getfield target : Lcom/amap/api/maps2d/model/LatLng;
    //   366: getfield longitude : D
    //   369: ldc2_w 1000000.0
    //   372: dmul
    //   373: d2i
    //   374: istore #7
    //   376: aload_0
    //   377: getfield b : Lcom/amap/api/mapcore2d/aq;
    //   380: new com/amap/api/mapcore2d/w
    //   383: dup
    //   384: iload #6
    //   386: iload #7
    //   388: invokespecial <init> : (II)V
    //   391: lload_2
    //   392: l2i
    //   393: invokevirtual a : (Lcom/amap/api/mapcore2d/w;I)V
    //   396: return
    //   397: aload #8
    //   399: getfield nowType : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   402: getstatic com/amap/api/interfaces/MapCameraMessage$Type.c : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   405: if_acmpne -> 463
    //   408: aload #8
    //   410: getfield cameraPosition : Lcom/amap/api/maps2d/model/CameraPosition;
    //   413: astore_1
    //   414: aload_1
    //   415: getfield target : Lcom/amap/api/maps2d/model/LatLng;
    //   418: getfield latitude : D
    //   421: ldc2_w 1000000.0
    //   424: dmul
    //   425: d2i
    //   426: istore #6
    //   428: aload_1
    //   429: getfield target : Lcom/amap/api/maps2d/model/LatLng;
    //   432: getfield longitude : D
    //   435: ldc2_w 1000000.0
    //   438: dmul
    //   439: d2i
    //   440: istore #7
    //   442: aload_0
    //   443: getfield b : Lcom/amap/api/mapcore2d/aq;
    //   446: new com/amap/api/mapcore2d/w
    //   449: dup
    //   450: iload #6
    //   452: iload #7
    //   454: invokespecial <init> : (II)V
    //   457: lload_2
    //   458: l2i
    //   459: invokevirtual a : (Lcom/amap/api/mapcore2d/w;I)V
    //   462: return
    //   463: aload #8
    //   465: getfield nowType : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   468: getstatic com/amap/api/interfaces/MapCameraMessage$Type.j : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   471: if_acmpeq -> 507
    //   474: aload #8
    //   476: getfield nowType : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   479: getstatic com/amap/api/interfaces/MapCameraMessage$Type.k : Lcom/amap/api/interfaces/MapCameraMessage$Type;
    //   482: if_acmpne -> 488
    //   485: goto -> 507
    //   488: aload #8
    //   490: iconst_1
    //   491: putfield isChangeFinished : Z
    //   494: aload_0
    //   495: getfield e : Lcom/amap/api/mapcore2d/as;
    //   498: aload #8
    //   500: checkcast com/amap/api/mapcore2d/m
    //   503: invokevirtual a : (Lcom/amap/api/mapcore2d/m;)V
    //   506: return
    //   507: aload_0
    //   508: invokevirtual r : ()V
    //   511: aload_0
    //   512: aload #8
    //   514: iconst_1
    //   515: lload_2
    //   516: invokevirtual a : (Lcom/amap/api/interfaces/MapCameraMessage;ZJ)V
    //   519: return
    //   520: astore_1
    //   521: aload_1
    //   522: ldc_w 'AMapDelegateImpGLSurfaceView'
    //   525: ldc_w 'animateCameraWithDurationAndCallback'
    //   528: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   531: return
    // Exception table:
    //   from	to	target	type
    //   66	72	520	finally
    //   72	89	520	finally
    //   94	100	520	finally
    //   100	112	520	finally
    //   112	134	520	finally
    //   135	142	520	finally
    //   143	168	520	finally
    //   169	190	520	finally
    //   191	212	520	finally
    //   213	243	520	finally
    //   244	269	520	finally
    //   277	309	520	finally
    //   309	318	520	finally
    //   319	396	520	finally
    //   397	462	520	finally
    //   463	485	520	finally
    //   488	506	520	finally
    //   507	519	520	finally
  }
  
  protected PointF b(PointF paramPointF) {
    PointF pointF = new PointF();
    int j = getWidth();
    int i = getHeight();
    float f1 = paramPointF.x;
    j >>= 1;
    float f2 = j;
    float f3 = paramPointF.y;
    i >>= 1;
    double d2 = (f3 - i);
    double d3 = (f1 - f2);
    double d1 = Math.atan2(d2, d3);
    d2 = Math.sqrt(Math.pow(d3, 2.0D) + Math.pow(d2, 2.0D));
    d1 -= q() * Math.PI / 180.0D;
    pointF.x = (float)(Math.cos(d1) * d2 + j);
    pointF.y = (float)(d2 * Math.sin(d1) + i);
    return pointF;
  }
  
  public bc b() {
    return this.D;
  }
  
  public void b(double paramDouble1, double paramDouble2, ae paramae) {
    if (this.O == null)
      return; 
    getZoomLevel();
    w w = new w((int)r.a(paramDouble1), (int)r.a(paramDouble2));
    av av1 = this.O;
    PointF pointF = av1.b(w, av1.l, this.O.n, this.O.k);
    if (paramae != null) {
      paramae.a = (int)pointF.x;
      paramae.b = (int)pointF.y;
    } 
  }
  
  public void b(float paramFloat) {
    this.ay = paramFloat;
  }
  
  public void b(int paramInt1, int paramInt2, s params) {
    if (params != null) {
      params.a = r.a(paramInt1);
      params.b = r.a(paramInt2);
    } 
  }
  
  public void b(boolean paramBoolean) {
    if (paramBoolean == k())
      return; 
    if (this.a == null)
      return; 
    String str = (a()).e.i;
    if (!paramBoolean) {
      (a()).e.a(str, false);
      (a()).c.a(false, false);
      return;
    } 
    if ((a()).e.b(str) != null) {
      (a()).e.a(str, true);
      (a()).c.a(false, false);
      return;
    } 
    an an = new an(this.O);
    an.q = new bv(this.a, an);
    an.g = true;
    an.i = 120000L;
    an.j = new cb(this) {
        public String a(int param1Int1, int param1Int2, int param1Int3) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(ax.a().c());
          stringBuilder.append("/trafficengine/mapabc/traffictile?v=w2.61&zoom=");
          stringBuilder.append(17 - param1Int3);
          stringBuilder.append("&x=");
          stringBuilder.append(param1Int1);
          stringBuilder.append("&y=");
          stringBuilder.append(param1Int2);
          return stringBuilder.toString();
        }
      };
    an.b = str;
    an.e = false;
    an.a(true);
    an.f = false;
    an.c = 18;
    an.d = 9;
    (a()).e.a(an, getContext());
    (a()).e.a(str, true);
    (a()).c.a(false, false);
  }
  
  public boolean b(float paramFloat, PointF paramPointF) {
    this.az = false;
    try {
      boolean bool = this.h.isZoomGesturesEnabled();
      if (!bool)
        return false; 
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "AMapDelegateImpGLSurfaceView", "endScale");
    } 
    l.a().b();
    return true;
  }
  
  public boolean b(Matrix paramMatrix) {
    try {
      boolean bool = this.h.isZoomGesturesEnabled();
      if (!bool)
        return false; 
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "AMapDelegateImpGLSurfaceView", "onScale");
    } 
    this.ax.set(paramMatrix);
    postInvalidate();
    return true;
  }
  
  public boolean b(ab paramab) {
    ay ay1 = this.U;
    return (ay1 != null && this.R != null && paramab != null) ? ay1.getId().equals(paramab.getId()) : false;
  }
  
  protected PointF c(PointF paramPointF) {
    PointF pointF = new PointF();
    int j = getWidth();
    int i = getHeight();
    float f1 = paramPointF.x;
    j >>= 1;
    float f2 = j;
    float f3 = paramPointF.y;
    i >>= 1;
    double d2 = (f3 - i);
    double d3 = (f1 - f2);
    double d1 = Math.atan2(d2, d3);
    d2 = Math.sqrt(Math.pow(d3, 2.0D) + Math.pow(d2, 2.0D));
    d1 += q() * Math.PI / 180.0D;
    pointF.x = (float)(Math.cos(d1) * d2 + j);
    pointF.y = (float)(d2 * Math.sin(d1) + i);
    return pointF;
  }
  
  public al c() throws RemoteException {
    return this.h;
  }
  
  public boolean c(float paramFloat) {
    try {
      boolean bool = this.h.isZoomGesturesEnabled();
      if (!bool)
        return false; 
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "AMapDelegateImpGLSurfaceView", "onScale");
    } 
    b(paramFloat);
    return false;
  }
  
  public void clear() throws RemoteException {
    try {
      e();
      if (this.a == null)
        return; 
      this.a.f.a();
      this.j.c();
      this.i.b();
      return;
    } catch (Exception exception) {
      cm.a(exception, "AMapDelegateImpGLSurfaceView", "clear");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("AMapDelegateImpGLSurfaceView clear erro");
      return;
    } finally {
      Exception exception = null;
      cm.a(exception, "AMapDelegateImpGLSurfaceView", "clear");
    } 
  }
  
  public void computeScroll() {
    if (this.au.computeScrollOffset() && this.au.isFinished()) {
      int i = this.au.getCurrX();
      int j = this.av;
      int m = this.au.getCurrY();
      int n = this.aw;
      this.av = this.au.getCurrX();
      this.aw = this.au.getCurrY();
      w w = this.a.b.a(this.a.h.n.x + i - j, this.a.h.n.y + m - n);
      if (this.au.isFinished()) {
        l.a().b();
        if (this.L != null)
          a(true, C()); 
        this.a.c.a(false, false);
        return;
      } 
      this.a.c.b(w);
      return;
    } 
    super.computeScroll();
  }
  
  public bh d() {
    az az1 = this.a;
    return (bh)((az1 == null) ? null : az1.b);
  }
  
  public void destroy() {
    try {
      if (this.ak != null) {
        this.ak.cancel();
        this.ak = null;
      } 
      if (this.am != null) {
        this.am.cancel();
        this.am = null;
      } 
      if (this.ao != null)
        this.ao.removeCallbacksAndMessages(null); 
      if (this.k != null)
        this.k.removeCallbacksAndMessages(null); 
      if (this.al != null) {
        this.al.interrupt();
        this.al = null;
      } 
      if (this.G != null) {
        this.G.deactivate();
        this.G = null;
      } 
      n.a().b(this);
      bm.a().a(this);
      l.a().b(this);
      this.f.a();
      this.F.a();
      this.E.b();
      this.y.a();
      this.H.a();
      this.a.f.b();
      this.j.f();
      if (this.W != null)
        this.W.setCallback(null); 
      this.g.removeAllViews();
      e();
      if (this.i != null)
        this.i.f(); 
      if (this.a != null) {
        this.a.d.b();
        z();
      } 
      this.G = null;
      this.ah = null;
      q.h = null;
      return;
    } finally {
      Exception exception = null;
      cm.a(exception, "AMapDelegateImpGLSurfaceView", "destroy");
    } 
  }
  
  public void e() {
    View view = this.R;
    if (view != null) {
      view.clearFocus();
      this.R.destroyDrawingCache();
      au au1 = this.g;
      if (au1 != null)
        au1.removeView(this.R); 
      Drawable drawable = this.R.getBackground();
      if (drawable != null)
        drawable.setCallback(null); 
      this.R = null;
    } 
    this.U = null;
  }
  
  Point f() {
    return this.E.d();
  }
  
  public boolean g() {
    return this.p;
  }
  
  public Projection getAMapProjection() throws RemoteException {
    return new Projection(this.Z);
  }
  
  public UiSettings getAMapUiSettings() throws RemoteException {
    return new UiSettings(this.h);
  }
  
  public CameraPosition getCameraPosition() throws RemoteException {
    LatLng latLng = E();
    if (latLng == null)
      return null; 
    float f = getZoomLevel();
    return CameraPosition.builder().target(latLng).zoom(f).build();
  }
  
  public int getLogoPosition() {
    return this.E.a();
  }
  
  public Handler getMainHandler() {
    return this.k;
  }
  
  public LatLngBounds getMapBounds() {
    return null;
  }
  
  public int getMapHeight() {
    az az1 = this.a;
    return (az1 == null || az1.c == null) ? 0 : this.a.c.d();
  }
  
  public List<Marker> getMapScreenMarkers() {
    return !cm.a(getWidth(), getHeight()) ? new ArrayList<Marker>() : this.j.g();
  }
  
  public void getMapScreenShot(AMap.OnMapScreenShotListener paramOnMapScreenShotListener) {
    this.aj = paramOnMapScreenShotListener;
    this.aa = true;
  }
  
  public int getMapType() throws RemoteException {
    return this.u;
  }
  
  public int getMapWidth() {
    az az1 = this.a;
    return (az1 == null || az1.c == null) ? 0 : this.a.c.c();
  }
  
  public float getMaxZoomLevel() {
    az az1 = this.a;
    if (az1 == null || az1.c == null) {
      int j = q.c;
      return j;
    } 
    int i = this.a.c.a();
    return i;
  }
  
  public float getMinZoomLevel() {
    az az1 = this.a;
    if (az1 == null || az1.c == null) {
      int j = q.d;
      return j;
    } 
    int i = this.a.c.b();
    return i;
  }
  
  public Location getMyLocation() throws RemoteException {
    if (this.G != null) {
      d d1 = this.A;
      if (d1 != null)
        return d1.a; 
    } 
    return null;
  }
  
  public AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException {
    return this.L;
  }
  
  public float getScalePerPixel() {
    int i = getWidth();
    s s1 = new s();
    s s2 = new s();
    a(0, 0, s1);
    a(i, 0, s2);
    return (float)(cm.a(new LatLng(s1.b, s1.a), new LatLng(s2.b, s2.a)) / i);
  }
  
  public View getView() throws RemoteException {
    return (View)this.g;
  }
  
  public float getZoomLevel() {
    az az1 = this.a;
    if (az1 != null) {
      if (az1.c == null)
        return 0.0F; 
      try {
        return this.a.c.e();
      } catch (Exception exception) {
        cm.a(exception, "AMapDelegateImpGLSurfaceView", "getZoomLevel");
      } 
    } 
    return 0.0F;
  }
  
  public w h() {
    az az1 = this.a;
    return (az1 == null || az1.c == null) ? null : this.a.c.f();
  }
  
  public aq i() {
    return this.b;
  }
  
  public boolean isMyLocationEnabled() throws RemoteException {
    return this.C;
  }
  
  public boolean isTrafficEnabled() throws RemoteException {
    return k();
  }
  
  public boolean j() {
    az az1 = this.a;
    if (az1 != null) {
      if (az1.e == null)
        return false; 
      an an = (a()).e.b((a()).e.h);
      if (an != null)
        return an.a(); 
    } 
    return false;
  }
  
  public boolean k() {
    if (a() == null)
      return false; 
    String str = (a()).e.i;
    an an = (a()).e.b(str);
    return (an != null) ? an.a() : false;
  }
  
  public bb l() {
    return this.ar;
  }
  
  public void moveCamera(CameraUpdate paramCameraUpdate) throws RemoteException {
    if (paramCameraUpdate == null)
      return; 
    this.I.a(paramCameraUpdate.getCameraUpdateFactoryDelegate());
  }
  
  public float o() {
    return this.ay;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent) {
    try {
      boolean bool = this.h.isZoomGesturesEnabled();
      if (!bool)
        return true; 
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "AMapDelegateImpGLSurfaceView", "onDoubleTap");
    } 
    if (this.t)
      if (this.h.isZoomInByScreenCenter()) {
        this.b.c();
      } else {
        this.b.c((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      }  
    if (this.aK > 1)
      return true; 
    this.aL = true;
    az az1 = this.a;
    if (az1 != null && az1.c != null)
      this.f.a(this.a.c.e() + 1.0F); 
    return true;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent) {
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent) {
    this.ac = false;
    if (!this.aL && !this.M.a()) {
      this.M.a(true);
      AMap.CancelableCallback cancelableCallback = this.N;
      if (cancelableCallback != null)
        cancelableCallback.onCancel(); 
      this.N = null;
    } 
    this.aL = false;
    this.aK = 0;
    Point point = this.ap;
    if (point == null) {
      this.ap = new Point((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      return true;
    } 
    point.set((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    try {
      Paint paint = n();
      paramCanvas.drawColor(m());
      int i = getWidth();
      int j = getHeight();
      if (i <= j)
        i = j; 
      float f1 = getLeft();
      float f2 = getTop();
      for (j = 0; j < i; j += 256) {
        float f = j;
        paramCanvas.drawLine(f1, f, f1 + getWidth(), f, paint);
        paramCanvas.drawLine(f, f2, f, f2 + getHeight(), paint);
      } 
      if (this.aa) {
        setDrawingCacheEnabled(true);
        buildDrawingCache();
        Bitmap bitmap = getDrawingCache();
        Message message = this.k.obtainMessage();
        message.what = 16;
        message.obj = bitmap;
        this.k.sendMessage(message);
        this.aa = false;
      } 
      if (this.a != null && this.a.c != null)
        this.a.c.a(getWidth(), getHeight()); 
      if (this.a != null && this.a.e != null)
        this.a.e.a(paramCanvas, this.ax, this.aA, this.aB); 
      if (!this.M.a())
        this.k.sendEmptyMessage(13); 
    } finally {
      paramCanvas = null;
    } 
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
    if (!this.ar.k) {
      if (paramMotionEvent1.getEventTime() - this.ar.o < 30L)
        return true; 
      postInvalidate();
      this.ac = false;
      try {
        boolean bool = this.h.isScrollGesturesEnabled();
        if (!bool)
          return true; 
      } catch (RemoteException remoteException) {
        cm.a((Throwable)remoteException, "AMapDelegateImpGLSurfaceView", "onFling");
      } 
      this.N = null;
      Scroller scroller = this.au;
      int i = this.av;
      int j = this.aw;
      int m = (int)-paramFloat1 * 3 / 5;
      int n = (int)-paramFloat2 * 3 / 5;
      int i1 = this.aC;
      int i2 = -i1;
      int i3 = this.aD;
      scroller.fling(i, j, m, n, i2, i1, -i3, i3);
    } 
    return true;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    az az1 = this.a;
    boolean bool = true;
    if (az1 == null)
      return true; 
    if (!this.o)
      return false; 
    if (!az1.e.a(paramInt, paramKeyEvent)) {
      if (this.b.onKey(this, paramInt, paramKeyEvent))
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    az az1 = this.a;
    boolean bool = true;
    if (az1 == null)
      return true; 
    if (!this.o)
      return false; 
    if (!az1.e.b(paramInt, paramKeyEvent)) {
      if (this.b.onKey(this, paramInt, paramKeyEvent))
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {
    try {
      this.ac = false;
      if (this.af != null) {
        s s = new s();
        a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY(), s);
        this.af.onMapLongClick(new LatLng(s.b, s.a));
        this.P = true;
      } 
      this.r = this.j.a(paramMotionEvent);
      if (this.r == null)
        return; 
      this.q = new Marker(this.r);
    } finally {
      paramMotionEvent = null;
    } 
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onPause() {
    az az1 = this.a;
    if (az1 != null && az1.d != null)
      this.a.d.d(); 
    bu bu1 = this.i;
    if (bu1 != null)
      bu1.d(); 
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    super.onRestoreInstanceState(paramParcelable);
  }
  
  public void onResume() {
    az az1 = this.a;
    if (az1 != null && az1.d != null)
      this.a.d.c(); 
    bu bu1 = this.i;
    if (bu1 != null)
      bu1.e(); 
  }
  
  protected Parcelable onSaveInstanceState() {
    return super.onSaveInstanceState();
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2) {
    if (!this.ar.k) {
      if (paramMotionEvent2.getEventTime() - this.ar.o < 30L)
        return true; 
      try {
        if (!this.h.isScrollGesturesEnabled()) {
          this.ac = false;
          return true;
        } 
      } catch (RemoteException remoteException) {
        cm.a((Throwable)remoteException, "AMapDelegateImpGLSurfaceView", "onScroll");
      } 
      if (this.aK > 1) {
        this.ac = false;
        return true;
      } 
      this.ac = true;
      b((int)paramMotionEvent2.getX(), (int)paramMotionEvent2.getY());
      postInvalidate();
      r();
    } 
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent) {
    if (this.b != null) {
      az az1 = this.a;
      if (az1 == null)
        return false; 
      az1.e.b(paramMotionEvent);
      Iterator<GestureDetector.OnGestureListener> iterator = this.as.iterator();
      while (iterator.hasNext())
        ((GestureDetector.OnGestureListener)iterator.next()).onSingleTapUp(paramMotionEvent); 
      this.ac = false;
      if (this.P) {
        this.P = false;
        return true;
      } 
      try {
      
      } finally {
        paramMotionEvent = null;
        cm.a((Throwable)paramMotionEvent, "AMapDelegateImpGLSurfaceView", "onSingleTapConfirmed");
      } 
    } else {
      return false;
    } 
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent) {
    return false;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Point point = new Point(paramInt1 / 2, paramInt2 / 2);
    this.a.h.a(point);
    this.a.c.a(paramInt1, paramInt2);
    if (this.b.a() != 0.0F && this.b.b() != 0.0F) {
      aq aq1 = this.b;
      aq1.a(aq1.a(), this.b.b());
      this.b.a(0.0F);
      this.b.b(0.0F);
    } 
    redrawInfoWindow();
    a a1 = this.aM;
    if (a1 != null)
      a1.a(paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (!q.r)
      return true; 
    if (this.a == null)
      return true; 
    if (!this.o)
      return false; 
    if (this.ae != null) {
      this.ao.removeMessages(1);
      Message message = this.ao.obtainMessage();
      message.what = 1;
      message.obj = MotionEvent.obtain(paramMotionEvent);
      message.sendToTarget();
    } 
    if (this.a.e.a(paramMotionEvent))
      return true; 
    b(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void p() {
    this.aA = 0.0F;
    this.aB = 0.0F;
  }
  
  public int q() {
    return 0;
  }
  
  protected void r() {
    this.k.sendEmptyMessage(10);
  }
  
  public void redrawInfoWindow() {
    View view = this.R;
    if (view != null && this.U != null) {
      au.a a1 = (au.a)view.getLayoutParams();
      if (a1 != null)
        a1.b = this.U.getRealPosition(); 
      this.g.a();
    } 
  }
  
  public boolean removeGLOverlay(String paramString) throws RemoteException {
    az az1 = this.a;
    if (az1 == null)
      return false; 
    try {
      return az1.f.b(paramString);
    } finally {
      paramString = null;
    } 
  }
  
  public boolean removeMarker(String paramString) {
    try {
      ab ab1 = this.j.a(paramString);
    } catch (RemoteException remoteException) {
      cm.a((Throwable)remoteException, "AMapDelegateImpGLSurfaceView", "removeMarker");
      remoteException = null;
    } 
    return (remoteException != null) ? this.j.b((ab)remoteException) : false;
  }
  
  public void removecache() {
    removecache((AMap.OnCacheRemoveListener)null);
  }
  
  public void removecache(AMap.OnCacheRemoveListener paramOnCacheRemoveListener) {
    if (this.an != null)
      try {
        b b1 = new b(this, this.n, paramOnCacheRemoveListener);
        return;
      } finally {
        paramOnCacheRemoveListener = null;
        do.c((Throwable)paramOnCacheRemoveListener, "AMapDelegateImpGLSurfaceView", "removecache");
      }  
  }
  
  void s() {
    this.k.sendEmptyMessage(15);
  }
  
  public void setClickable(boolean paramBoolean) {
    this.o = paramBoolean;
    super.setClickable(paramBoolean);
  }
  
  public void setInfoWindowAdapter(AMap.InfoWindowAdapter paramInfoWindowAdapter) throws RemoteException {
    this.T = paramInfoWindowAdapter;
  }
  
  public void setLocationSource(LocationSource paramLocationSource) throws RemoteException {
    if (this.y == null)
      return; 
    LocationSource locationSource = this.G;
    if (locationSource != null && locationSource instanceof c)
      locationSource.deactivate(); 
    this.G = paramLocationSource;
    if (paramLocationSource != null) {
      this.y.a(true);
      return;
    } 
    this.y.a(false);
  }
  
  public void setLogoPosition(int paramInt) {
    cd cd1 = this.E;
    if (cd1 != null) {
      cd1.a(paramInt);
      this.E.postInvalidate();
      if (this.F.getVisibility() == 0)
        this.F.postInvalidate(); 
    } 
  }
  
  public void setMapLanguage(String paramString) throws RemoteException {
    az az1 = this.a;
    if (az1 != null) {
      if (az1.e == null)
        return; 
      if (j())
        return; 
      this.a.e.a(paramString);
    } 
  }
  
  public void setMapType(int paramInt) throws RemoteException {
    if (paramInt == 2) {
      this.u = 2;
      a(true);
      this.E.a(true);
    } else {
      this.u = 1;
      a(false);
      this.E.a(false);
    } 
    postInvalidate();
  }
  
  public void setMyLocationEnabled(boolean paramBoolean) throws RemoteException {
    try {
      return;
    } finally {
      Exception exception = null;
      do.c(exception, "AMapDelegateImpGLSurfaceView", "setMyLocationEnabled");
      exception.printStackTrace();
    } 
  }
  
  public void setMyLocationRotateAngle(float paramFloat) throws RemoteException {
    bc bc1 = this.D;
    if (bc1 != null)
      bc1.a(paramFloat); 
  }
  
  public void setMyLocationStyle(MyLocationStyle paramMyLocationStyle) throws RemoteException {
    if (b() == null)
      this.D = new bc(this, this.n); 
    if (this.D != null) {
      if (paramMyLocationStyle.getInterval() < 1000L)
        paramMyLocationStyle.interval(1000L); 
      LocationSource locationSource = this.G;
      if (locationSource != null && locationSource instanceof c) {
        ((c)locationSource).a(paramMyLocationStyle.getInterval());
        ((c)this.G).a(paramMyLocationStyle.getMyLocationType());
      } 
      this.D.a(paramMyLocationStyle);
    } 
  }
  
  public void setMyLocationType(int paramInt) {
    bc bc1 = this.D;
    if (bc1 != null)
      bc1.a(paramInt); 
  }
  
  public void setOnCameraChangeListener(AMap.OnCameraChangeListener paramOnCameraChangeListener) throws RemoteException {
    this.L = paramOnCameraChangeListener;
  }
  
  public void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener paramOnInfoWindowClickListener) throws RemoteException {
    this.S = paramOnInfoWindowClickListener;
  }
  
  public void setOnMapClickListener(AMap.OnMapClickListener paramOnMapClickListener) throws RemoteException {
    this.ah = paramOnMapClickListener;
  }
  
  public void setOnMapLongClickListener(AMap.OnMapLongClickListener paramOnMapLongClickListener) throws RemoteException {
    this.af = paramOnMapLongClickListener;
  }
  
  public void setOnMapTouchListener(AMap.OnMapTouchListener paramOnMapTouchListener) throws RemoteException {
    this.ae = paramOnMapTouchListener;
  }
  
  public void setOnMaploadedListener(AMap.OnMapLoadedListener paramOnMapLoadedListener) throws RemoteException {
    this.ag = paramOnMapLoadedListener;
  }
  
  public void setOnMarkerClickListener(AMap.OnMarkerClickListener paramOnMarkerClickListener) throws RemoteException {
    this.V = paramOnMarkerClickListener;
  }
  
  public void setOnMarkerDragListener(AMap.OnMarkerDragListener paramOnMarkerDragListener) throws RemoteException {
    this.ad = paramOnMarkerDragListener;
  }
  
  public void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener paramOnMyLocationChangeListener) throws RemoteException {
    this.B = paramOnMyLocationChangeListener;
  }
  
  public void setTrafficEnabled(boolean paramBoolean) throws RemoteException {
    b(paramBoolean);
    postInvalidate();
  }
  
  public void setZOrderOnTop(boolean paramBoolean) throws RemoteException {}
  
  public void setZoomPosition(int paramInt) {
    ce ce1 = this.f;
    if (ce1 != null) {
      ce1.a(paramInt);
      this.f.postInvalidate();
    } 
  }
  
  public void showCompassEnabled(boolean paramBoolean) {
    if (paramBoolean) {
      this.H.setVisibility(0);
      return;
    } 
    this.H.setVisibility(8);
  }
  
  public void showMyLocationButtonEnabled(boolean paramBoolean) {
    if (paramBoolean) {
      this.y.setVisibility(0);
      return;
    } 
    this.y.setVisibility(8);
  }
  
  public void showMyLocationOverlay(Location paramLocation) {
    if (paramLocation == null)
      return; 
    try {
      if (!isMyLocationEnabled() || this.G == null)
        return; 
      if (this.D == null)
        this.D = new bc(this, this.n); 
      if (this.D != null && paramLocation.getLongitude() != 0.0D && paramLocation.getLatitude() != 0.0D)
        this.D.a(paramLocation); 
      return;
    } finally {
      paramLocation = null;
      paramLocation.printStackTrace();
    } 
  }
  
  public void showScaleEnabled(boolean paramBoolean) {
    if (paramBoolean) {
      this.F.setVisibility(0);
      s();
      return;
    } 
    this.F.a("");
    this.F.a(0);
    this.F.setVisibility(8);
  }
  
  public void showZoomControlsEnabled(boolean paramBoolean) {
    if (paramBoolean) {
      this.f.setVisibility(0);
      return;
    } 
    this.f.setVisibility(8);
  }
  
  public void stopAnimation() throws RemoteException {
    if (this.b == null)
      return; 
    if (!this.M.a()) {
      this.M.a(true);
      l.a().b();
      AMap.CancelableCallback cancelableCallback = this.N;
      if (cancelableCallback != null)
        cancelableCallback.onCancel(); 
      this.N = null;
    } 
    this.b.b(true);
  }
  
  public void t() {
    AMap.CancelableCallback cancelableCallback = this.N;
    if (cancelableCallback != null) {
      cancelableCallback.onCancel();
      this.N = null;
    } 
  }
  
  public void u() {}
  
  public void v() {
    this.k.sendEmptyMessage(17);
  }
  
  static abstract class a {
    public abstract void a(int param1Int1, int param1Int2, int param1Int3, int param1Int4);
  }
  
  class b implements Runnable {
    private Context b;
    
    private AMap.OnCacheRemoveListener c;
    
    public b(b this$0, Context param1Context, AMap.OnCacheRemoveListener param1OnCacheRemoveListener) {
      this.b = param1Context;
      this.c = param1OnCacheRemoveListener;
    }
    
    public void run() {
      try {
        cm.a(new File(cm.b(this.b)));
      } finally {
        null = null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */