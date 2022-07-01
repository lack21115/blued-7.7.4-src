package a.a.a.a.a.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import com.qiniu.pili.droid.streaming.FrameCapturedCallback;
import com.qiniu.pili.droid.streaming.PreviewAppearance;
import com.qiniu.pili.droid.streaming.StreamingPreviewCallback;
import com.qiniu.pili.droid.streaming.StreamingState;
import com.qiniu.pili.droid.streaming.SurfaceTextureCallback;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import com.qiniu.pili.droid.streaming.widget.AspectFrameLayout;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class c implements g.a, SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback {
  public boolean A = false;
  
  public boolean B = false;
  
  public boolean C = false;
  
  public Camera.Parameters D;
  
  public boolean E = false;
  
  public boolean F = false;
  
  public boolean G = false;
  
  public boolean H = false;
  
  public boolean I = false;
  
  public long J = 0L;
  
  public long K = 0L;
  
  public final h L = new h(null);
  
  public final Object M;
  
  public volatile boolean N;
  
  public volatile boolean O;
  
  public FrameCapturedCallback P;
  
  public int Q;
  
  public int R;
  
  public boolean S;
  
  public boolean T;
  
  public a.a.a.a.a.a.b U;
  
  public j V;
  
  public j W;
  
  public List<SurfaceTextureCallback> X;
  
  public GLSurfaceView a;
  
  public e b;
  
  public b.d c;
  
  public final Object d = new Object();
  
  public AspectFrameLayout e;
  
  public ViewGroup f;
  
  public View g;
  
  public Context h;
  
  public g i;
  
  public CameraStreamingSetting j;
  
  public PreviewAppearance k;
  
  public WatermarkSetting l;
  
  public m m;
  
  public l n;
  
  public StreamingPreviewCallback o;
  
  public boolean p;
  
  public i q;
  
  public boolean r = false;
  
  public boolean s = false;
  
  public boolean t;
  
  public volatile boolean u = false;
  
  public boolean v = false;
  
  public boolean w = false;
  
  public boolean x = false;
  
  public ByteBuffer y = null;
  
  public int z = 0;
  
  public c(Context paramContext, AspectFrameLayout paramAspectFrameLayout, GLSurfaceView paramGLSurfaceView, j paramj) {
    if (Build.VERSION.SDK_INT >= 16) {
      this.M = new a(new a(this));
    } else {
      this.M = null;
    } 
    this.N = false;
    this.O = false;
    this.Q = 0;
    this.R = 0;
    this.S = false;
    this.T = false;
    b b1 = new b(this);
    this.V = b1;
    this.W = b1;
    this.X = new ArrayList<SurfaceTextureCallback>();
    this.h = paramContext.getApplicationContext();
    this.e = paramAspectFrameLayout;
    this.a = paramGLSurfaceView;
    HandlerThread handlerThread = new HandlerThread("CameraManagerHt");
    handlerThread.start();
    this.q = new i(handlerThread.getLooper(), this);
    if (paramj != null)
      this.W = paramj; 
    b.a().a(new k(this));
  }
  
  public final void A() {
    w();
    this.c.a(this.z);
    if (!this.A)
      this.j.a(this.z); 
    g g1 = this.i;
    if (g1 != null) {
      g1.a(this.z);
      AspectFrameLayout aspectFrameLayout = this.e;
      if (aspectFrameLayout != null) {
        this.i.a(aspectFrameLayout.getWidth(), this.e.getHeight());
        return;
      } 
      this.i.a(this.a.getWidth(), this.a.getHeight());
    } 
  }
  
  public final boolean B() {
    boolean bool = a.a.a.a.a.e.c.a().c();
    boolean bool1 = false;
    if (!bool)
      return false; 
    synchronized (this.d) {
      a.a.a.a.a.e.e.g.c("CameraManager", "isSupportedTorch getParameters");
      Camera.Parameters parameters = this.c.d();
      bool = bool1;
      if (parameters.getSupportedFlashModes() != null) {
        bool = bool1;
        if (parameters.getSupportedFlashModes().contains("torch"))
          bool = true; 
      } 
      return bool;
    } 
  }
  
  public final void C() {
    synchronized (this.d) {
      if (this.c != null) {
        this.v = false;
        this.c.a();
        this.u = true;
        this.c = null;
        this.D = null;
        this.r = false;
        a.a.a.a.a.e.e.g.c("CameraManager", "releaseCamera -- done");
      } 
      if (this.i != null)
        this.i.c(); 
      return;
    } 
  }
  
  public final void D() {
    a.a.a.a.a.e.e.g.c("CameraManager", "handleCameraPreviewReady");
    this.n = null;
    if (!this.u) {
      F();
      if (this.v)
        this.W.onStateChanged(StreamingState.CAMERA_SWITCHED, Integer.valueOf(this.j.getReqCameraId())); 
      try {
        boolean bool = B();
        this.W.onStateChanged(StreamingState.TORCH_INFO, Boolean.valueOf(bool));
        this.s = true;
        if (bool && this.t)
          (new Thread(new g(this))).start(); 
        this.v = false;
        return;
      } catch (NullPointerException nullPointerException) {
        a.a.a.a.a.e.e.g.e("CameraManager", "parameter is null");
        return;
      } 
    } 
    a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.g;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Error occurs in handleCameraPreviewReady, mIsCameraReleased=");
    stringBuilder.append(this.u);
    stringBuilder.append(",mCameraManagerListener=");
    stringBuilder.append(this.W);
    e1.e("CameraManager", stringBuilder.toString());
  }
  
  public final void E() {
    boolean bool = b.a().c();
    CameraStreamingSetting cameraStreamingSetting = this.j;
    ViewGroup viewGroup = this.f;
    Camera.Parameters parameters = this.c.d();
    Looper looper = this.h.getMainLooper();
    View view = this.g;
    this.i = new g(cameraStreamingSetting, new String[] { "auto", "continuous-picture", "continuous-video" }, viewGroup, parameters, this, bool, looper, view);
  }
  
  public final void F() {
    g g1 = this.i;
    if (g1 == null) {
      E();
    } else {
      g1.a(b.a().c());
      this.i.a(this.c.d());
    } 
    AspectFrameLayout aspectFrameLayout = this.e;
    if (aspectFrameLayout != null) {
      this.i.a(aspectFrameLayout.getWidth(), this.e.getHeight());
      return;
    } 
    this.i.a(this.a.getWidth(), this.a.getHeight());
  }
  
  public final void G() {
    b.d d1 = this.c;
    if (d1 == null)
      return; 
    Camera.Parameters parameters = d1.d();
    if (parameters == null) {
      a.a.a.a.a.e.e.g.d("CameraManager", "param is null while getParameters");
      return;
    } 
    if (this.G)
      parameters.setAutoExposureLock(this.i.j()); 
    if (this.H)
      parameters.setAutoWhiteBalanceLock(this.i.j()); 
    if (this.E)
      parameters.setFocusAreas(this.i.e()); 
    if (this.F)
      parameters.setMeteringAreas(this.i.f()); 
    parameters.setFocusMode(this.i.d());
    c(parameters);
    this.c.a(parameters);
  }
  
  public final boolean H() {
    return (this.j.isPreviewSizeOptimize() && this.A);
  }
  
  public final Bitmap a(Bitmap paramBitmap, boolean paramBoolean) {
    // Byte code:
    //   0: new android/graphics/Matrix
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #12
    //   9: aload #12
    //   11: aload_0
    //   12: getfield z : I
    //   15: i2f
    //   16: invokevirtual preRotate : (F)Z
    //   19: pop
    //   20: invokestatic a : ()La/a/a/a/a/b/b;
    //   23: invokevirtual c : ()Z
    //   26: ifeq -> 39
    //   29: aload #12
    //   31: ldc_w -1.0
    //   34: fconst_1
    //   35: invokevirtual preScale : (FF)Z
    //   38: pop
    //   39: iload_2
    //   40: ifeq -> 262
    //   43: aload_0
    //   44: getfield Q : I
    //   47: istore #9
    //   49: aload_0
    //   50: getfield R : I
    //   53: istore #10
    //   55: aload_1
    //   56: invokevirtual getWidth : ()I
    //   59: istore #7
    //   61: aload_1
    //   62: invokevirtual getHeight : ()I
    //   65: istore #5
    //   67: aload_0
    //   68: getfield z : I
    //   71: istore #11
    //   73: iload #11
    //   75: bipush #90
    //   77: if_icmpeq -> 96
    //   80: iload #7
    //   82: istore #8
    //   84: iload #5
    //   86: istore #6
    //   88: iload #11
    //   90: sipush #270
    //   93: if_icmpne -> 104
    //   96: iload #7
    //   98: istore #6
    //   100: iload #5
    //   102: istore #8
    //   104: aload_0
    //   105: getfield Q : I
    //   108: i2f
    //   109: iload #8
    //   111: i2f
    //   112: fdiv
    //   113: fstore_3
    //   114: aload_0
    //   115: getfield R : I
    //   118: i2f
    //   119: iload #6
    //   121: i2f
    //   122: fdiv
    //   123: fstore #4
    //   125: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   128: astore #13
    //   130: new java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial <init> : ()V
    //   137: astore #14
    //   139: aload #14
    //   141: ldc_w 'scaleWidth:'
    //   144: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload #14
    //   150: fload_3
    //   151: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload #14
    //   157: ldc_w ',scaleHeight:'
    //   160: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload #14
    //   166: fload #4
    //   168: invokevirtual append : (F)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload #14
    //   174: ldc_w ',reqW:'
    //   177: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload #14
    //   183: iload #9
    //   185: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload #14
    //   191: ldc_w ',reqH:'
    //   194: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload #14
    //   200: iload #10
    //   202: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload #14
    //   208: ldc_w ',srcW:'
    //   211: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload #14
    //   217: iload #8
    //   219: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload #14
    //   225: ldc_w ',srcH:'
    //   228: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload #14
    //   234: iload #6
    //   236: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload #13
    //   242: ldc_w 'CameraManager'
    //   245: aload #14
    //   247: invokevirtual toString : ()Ljava/lang/String;
    //   250: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload #12
    //   255: fload_3
    //   256: fload #4
    //   258: invokevirtual postScale : (FF)Z
    //   261: pop
    //   262: aload_1
    //   263: iconst_0
    //   264: iconst_0
    //   265: aload_1
    //   266: invokevirtual getWidth : ()I
    //   269: aload_1
    //   270: invokevirtual getHeight : ()I
    //   273: aload #12
    //   275: iconst_1
    //   276: invokestatic createBitmap : (Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   279: areturn
  }
  
  public final Camera.Size a(Camera.Parameters paramParameters, int paramInt) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getSupportedPreviewSizes : ()Ljava/util/List;
    //   4: aload_0
    //   5: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   8: invokevirtual getPrvSizeRatio : ()Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO;
    //   11: invokestatic a : (Ljava/util/List;Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO;)Ljava/util/List;
    //   14: invokestatic a : (Ljava/util/List;)Ljava/util/List;
    //   17: invokeinterface iterator : ()Ljava/util/Iterator;
    //   22: astore #4
    //   24: aload #4
    //   26: invokeinterface hasNext : ()Z
    //   31: ifeq -> 61
    //   34: aload #4
    //   36: invokeinterface next : ()Ljava/lang/Object;
    //   41: checkcast android/hardware/Camera$Size
    //   44: astore_3
    //   45: aload_3
    //   46: getfield width : I
    //   49: aload_3
    //   50: getfield height : I
    //   53: imul
    //   54: iload_2
    //   55: if_icmplt -> 24
    //   58: goto -> 63
    //   61: aconst_null
    //   62: astore_3
    //   63: aload_3
    //   64: astore #4
    //   66: aload_3
    //   67: ifnonnull -> 152
    //   70: aload_1
    //   71: invokevirtual getSupportedPreviewSizes : ()Ljava/util/List;
    //   74: invokestatic a : (Ljava/util/List;)Ljava/util/List;
    //   77: astore #5
    //   79: aload #5
    //   81: invokeinterface iterator : ()Ljava/util/Iterator;
    //   86: astore #4
    //   88: aload_3
    //   89: astore_1
    //   90: aload #4
    //   92: invokeinterface hasNext : ()Z
    //   97: ifeq -> 124
    //   100: aload #4
    //   102: invokeinterface next : ()Ljava/lang/Object;
    //   107: checkcast android/hardware/Camera$Size
    //   110: astore_1
    //   111: aload_1
    //   112: getfield width : I
    //   115: aload_1
    //   116: getfield height : I
    //   119: imul
    //   120: iload_2
    //   121: if_icmplt -> 88
    //   124: aload_1
    //   125: astore #4
    //   127: aload_1
    //   128: ifnonnull -> 152
    //   131: aload #5
    //   133: aload #5
    //   135: invokeinterface size : ()I
    //   140: iconst_1
    //   141: isub
    //   142: invokeinterface get : (I)Ljava/lang/Object;
    //   147: checkcast android/hardware/Camera$Size
    //   150: astore #4
    //   152: aload_0
    //   153: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   156: aload #4
    //   158: getfield width : I
    //   161: aload #4
    //   163: getfield height : I
    //   166: invokestatic a : (II)Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO;
    //   169: invokevirtual a : (Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO;)V
    //   172: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   175: astore_1
    //   176: new java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial <init> : ()V
    //   183: astore_3
    //   184: aload_3
    //   185: ldc_w 'adjust preview size to '
    //   188: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_3
    //   193: aload #4
    //   195: getfield width : I
    //   198: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_3
    //   203: ldc_w 'x'
    //   206: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload_3
    //   211: aload #4
    //   213: getfield height : I
    //   216: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_1
    //   221: ldc_w 'CameraManager'
    //   224: aload_3
    //   225: invokevirtual toString : ()Ljava/lang/String;
    //   228: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload #4
    //   233: areturn
  }
  
  public PreviewAppearance a() {
    return this.k;
  }
  
  public void a(int paramInt) {
    synchronized (this.d) {
      if (this.c == null || !this.r) {
        a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.g;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mCamera:");
        stringBuilder.append(this.c);
        stringBuilder.append(",mIsPreviewReady:");
        stringBuilder.append(this.r);
        e1.e("CameraManager", stringBuilder.toString());
        return;
      } 
      Camera.Parameters parameters = this.c.d();
      if (parameters == null) {
        a.a.a.a.a.e.e.g.e("CameraManager", "parameters is null");
        return;
      } 
      if (parameters.getMinExposureCompensation() == 0 && parameters.getMaxExposureCompensation() == 0) {
        a.a.a.a.a.e.e.g.e("CameraManager", "Exposure compensation is not supported");
        return;
      } 
      parameters.setExposureCompensation(paramInt);
      this.c.a(parameters);
      return;
    } 
  }
  
  public void a(int paramInt1, int paramInt2) {
    if (this.c != null) {
      if (!this.r)
        return; 
      if (!this.E && !this.F)
        return; 
      g g1 = this.i;
      if (g1 != null)
        g1.b(paramInt1, paramInt2); 
    } 
  }
  
  public final void a(m paramm) {
    synchronized (this.d) {
      a.a.a.a.a.e.e.g.c("CameraManager", "handleSetSurfaceTexture");
      if (paramm == null || this.c == null || paramm.a == null) {
        a.a.a.a.a.e.e.g.d("CameraManager", "st/camera is null while handleSetSurfaceTexture");
        return;
      } 
      this.m = paramm;
      F();
      this.i.h();
      this.c.c();
      this.m.a.setOnFrameAvailableListener(this);
      this.c.a(this.m.a);
      this.c.b();
      q();
      this.i.a();
      return;
    } 
  }
  
  public final void a(Bitmap paramBitmap) {
    FrameCapturedCallback frameCapturedCallback = this.P;
    if (frameCapturedCallback != null)
      frameCapturedCallback.onFrameCaptured(paramBitmap); 
  }
  
  public final void a(Camera.Parameters paramParameters) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 17
    //   4: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   7: ldc_w 'CameraManager'
    //   10: ldc_w 'updateCameraPrvSize paras is null'
    //   13: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   16: return
    //   17: aload_0
    //   18: invokevirtual H : ()Z
    //   21: istore #7
    //   23: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   26: astore #8
    //   28: new java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: astore #9
    //   37: aload #9
    //   39: ldc_w 'level:'
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload #9
    //   48: aload_0
    //   49: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   52: invokevirtual getPrvSizeLevel : ()Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_LEVEL;
    //   55: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload #9
    //   61: ldc_w ',ratio:'
    //   64: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload #9
    //   70: aload_0
    //   71: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   74: invokevirtual getPrvSizeRatio : ()Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO;
    //   77: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload #9
    //   83: ldc_w ',prvSizeOptEnabled:'
    //   86: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload #9
    //   92: iload #7
    //   94: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload #8
    //   100: ldc_w 'CameraManager'
    //   103: aload #9
    //   105: invokevirtual toString : ()Ljava/lang/String;
    //   108: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   111: iload #7
    //   113: ifne -> 211
    //   116: aload_0
    //   117: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   120: invokevirtual g : ()Z
    //   123: ifeq -> 157
    //   126: aload_0
    //   127: getfield W : La/a/a/a/a/b/c$j;
    //   130: aload_1
    //   131: invokevirtual getSupportedPreviewSizes : ()Ljava/util/List;
    //   134: aload_0
    //   135: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   138: invokevirtual getPrvSizeRatio : ()Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO;
    //   141: invokestatic a : (Ljava/util/List;Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO;)Ljava/util/List;
    //   144: invokestatic a : (Ljava/util/List;)Ljava/util/List;
    //   147: invokeinterface onPreviewSizeSelected : (Ljava/util/List;)Landroid/hardware/Camera$Size;
    //   152: astore #9
    //   154: goto -> 214
    //   157: aload_0
    //   158: getfield W : La/a/a/a/a/b/c$j;
    //   161: aload_1
    //   162: invokevirtual getSupportedPreviewSizes : ()Ljava/util/List;
    //   165: invokestatic a : (Ljava/util/List;)Ljava/util/List;
    //   168: invokeinterface onPreviewSizeSelected : (Ljava/util/List;)Landroid/hardware/Camera$Size;
    //   173: astore #8
    //   175: aload #8
    //   177: astore #9
    //   179: aload #8
    //   181: ifnull -> 214
    //   184: aload_0
    //   185: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   188: aload #8
    //   190: getfield width : I
    //   193: aload #8
    //   195: getfield height : I
    //   198: invokestatic a : (II)Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO;
    //   201: invokevirtual a : (Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO;)V
    //   204: aload #8
    //   206: astore #9
    //   208: goto -> 214
    //   211: aconst_null
    //   212: astore #9
    //   214: aload #9
    //   216: astore #8
    //   218: aload #9
    //   220: ifnonnull -> 705
    //   223: aload_0
    //   224: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   227: invokevirtual g : ()Z
    //   230: ifne -> 243
    //   233: aload_0
    //   234: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   237: getstatic a/a/a/a/a/e/d.c : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO;
    //   240: invokevirtual a : (Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO;)V
    //   243: aload_1
    //   244: aload_0
    //   245: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   248: invokevirtual getPrvSizeRatio : ()Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO;
    //   251: aload_0
    //   252: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   255: invokevirtual getPrvSizeLevel : ()Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_LEVEL;
    //   258: invokestatic a : (Landroid/hardware/Camera$Parameters;Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO;Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_LEVEL;)Landroid/hardware/Camera$Size;
    //   261: astore #10
    //   263: aload #10
    //   265: astore #8
    //   267: iload #7
    //   269: ifeq -> 705
    //   272: aload #10
    //   274: astore #9
    //   276: aload #10
    //   278: ifnull -> 395
    //   281: aload #10
    //   283: astore #9
    //   285: aload #10
    //   287: getfield height : I
    //   290: sipush #480
    //   293: if_icmple -> 395
    //   296: aload_1
    //   297: invokevirtual getSupportedPreviewSizes : ()Ljava/util/List;
    //   300: aload_0
    //   301: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   304: invokevirtual getPrvSizeRatio : ()Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO;
    //   307: sipush #480
    //   310: invokestatic b : (Ljava/util/List;Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO;I)Landroid/hardware/Camera$Size;
    //   313: astore #8
    //   315: aload #8
    //   317: astore #9
    //   319: aload #8
    //   321: ifnull -> 395
    //   324: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   327: astore #9
    //   329: new java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial <init> : ()V
    //   336: astore #10
    //   338: aload #10
    //   340: ldc_w 'optimized preview size to width: '
    //   343: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload #10
    //   349: aload #8
    //   351: getfield width : I
    //   354: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload #10
    //   360: ldc_w ' height: '
    //   363: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload #10
    //   369: aload #8
    //   371: getfield height : I
    //   374: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload #9
    //   380: ldc_w 'CameraManager'
    //   383: aload #10
    //   385: invokevirtual toString : ()Ljava/lang/String;
    //   388: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   391: aload #8
    //   393: astore #9
    //   395: aload #9
    //   397: astore #8
    //   399: aload #9
    //   401: ifnonnull -> 705
    //   404: aload_1
    //   405: invokevirtual getSupportedPreviewSizes : ()Ljava/util/List;
    //   408: aload_0
    //   409: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   412: invokevirtual getPrvSizeRatio : ()Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO;
    //   415: sipush #480
    //   418: invokestatic a : (Ljava/util/List;Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO;I)Landroid/hardware/Camera$Size;
    //   421: astore #8
    //   423: aload #8
    //   425: astore #9
    //   427: aload #8
    //   429: ifnonnull -> 530
    //   432: aload_1
    //   433: invokevirtual getSupportedPreviewSizes : ()Ljava/util/List;
    //   436: sipush #480
    //   439: invokestatic a : (Ljava/util/List;I)Ljava/util/List;
    //   442: invokestatic a : (Ljava/util/List;)Ljava/util/List;
    //   445: astore #9
    //   447: aload_1
    //   448: invokevirtual getSupportedPreviewSizes : ()Ljava/util/List;
    //   451: sipush #480
    //   454: invokestatic b : (Ljava/util/List;I)Ljava/util/List;
    //   457: invokestatic a : (Ljava/util/List;)Ljava/util/List;
    //   460: astore #10
    //   462: aload #9
    //   464: invokeinterface isEmpty : ()Z
    //   469: ifne -> 492
    //   472: aload #9
    //   474: iconst_0
    //   475: invokeinterface get : (I)Ljava/lang/Object;
    //   480: checkcast android/hardware/Camera$Size
    //   483: astore #8
    //   485: aload #8
    //   487: astore #9
    //   489: goto -> 530
    //   492: aload #8
    //   494: astore #9
    //   496: aload #10
    //   498: invokeinterface isEmpty : ()Z
    //   503: ifne -> 530
    //   506: aload #10
    //   508: aload #10
    //   510: invokeinterface size : ()I
    //   515: iconst_1
    //   516: isub
    //   517: invokeinterface get : (I)Ljava/lang/Object;
    //   522: checkcast android/hardware/Camera$Size
    //   525: astore #8
    //   527: goto -> 485
    //   530: aload #9
    //   532: astore #8
    //   534: aload #9
    //   536: ifnull -> 705
    //   539: aload_1
    //   540: aload #9
    //   542: getfield width : I
    //   545: aload #9
    //   547: getfield height : I
    //   550: invokevirtual setPreviewSize : (II)V
    //   553: aload_0
    //   554: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   557: invokevirtual getPrvSizeRatio : ()Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO;
    //   560: invokestatic a : (Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting$PREVIEW_SIZE_RATIO;)D
    //   563: dstore_2
    //   564: aload #9
    //   566: getfield width : I
    //   569: istore #4
    //   571: iload #4
    //   573: i2d
    //   574: dload_2
    //   575: ddiv
    //   576: d2i
    //   577: istore #5
    //   579: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   582: astore #8
    //   584: new java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial <init> : ()V
    //   591: astore #10
    //   593: aload #10
    //   595: ldc_w 'crop optimized preview size width: '
    //   598: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload #10
    //   604: aload #9
    //   606: getfield width : I
    //   609: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload #10
    //   615: ldc_w ' height: '
    //   618: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: aload #10
    //   624: aload #9
    //   626: getfield height : I
    //   629: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload #10
    //   635: ldc_w ' to width:'
    //   638: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: pop
    //   642: aload #10
    //   644: iload #4
    //   646: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload #10
    //   652: ldc_w ' height: '
    //   655: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: pop
    //   659: aload #10
    //   661: iload #5
    //   663: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: aload #8
    //   669: ldc_w 'CameraManager'
    //   672: aload #10
    //   674: invokevirtual toString : ()Ljava/lang/String;
    //   677: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   680: aload_0
    //   681: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   684: iload #4
    //   686: iload #5
    //   688: invokevirtual a : (II)Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   691: pop
    //   692: aload_0
    //   693: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   696: iconst_1
    //   697: invokevirtual a : (Z)Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   700: pop
    //   701: aload #9
    //   703: astore #8
    //   705: aload_0
    //   706: iconst_0
    //   707: putfield T : Z
    //   710: aload #8
    //   712: astore #9
    //   714: aload #8
    //   716: ifnonnull -> 811
    //   719: aload_1
    //   720: invokevirtual getPreviewSize : ()Landroid/hardware/Camera$Size;
    //   723: astore #9
    //   725: aload_0
    //   726: iconst_1
    //   727: putfield T : Z
    //   730: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   733: astore #8
    //   735: new java/lang/StringBuilder
    //   738: dup
    //   739: invokespecial <init> : ()V
    //   742: astore #10
    //   744: aload #10
    //   746: ldc_w 'Error! Didn't find the specific preview size. Choose the default size:'
    //   749: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: pop
    //   753: aload #10
    //   755: aload #9
    //   757: getfield width : I
    //   760: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   763: pop
    //   764: aload #10
    //   766: ldc_w 'x'
    //   769: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: pop
    //   773: aload #10
    //   775: aload #9
    //   777: getfield height : I
    //   780: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   783: pop
    //   784: aload #8
    //   786: ldc_w 'CameraManager'
    //   789: aload #10
    //   791: invokevirtual toString : ()Ljava/lang/String;
    //   794: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   797: aload_0
    //   798: getfield W : La/a/a/a/a/b/c$j;
    //   801: getstatic com/qiniu/pili/droid/streaming/StreamingState.NO_SUPPORTED_PREVIEW_SIZE : Lcom/qiniu/pili/droid/streaming/StreamingState;
    //   804: aload #9
    //   806: invokeinterface onStateChanged : (Lcom/qiniu/pili/droid/streaming/StreamingState;Ljava/lang/Object;)V
    //   811: aload_0
    //   812: getfield U : La/a/a/a/a/a/b;
    //   815: invokevirtual a : ()La/a/a/a/a/e/f;
    //   818: astore #10
    //   820: aload #9
    //   822: astore #8
    //   824: aload #10
    //   826: ifnull -> 998
    //   829: aload #10
    //   831: invokevirtual a : ()I
    //   834: aload #10
    //   836: invokevirtual b : ()I
    //   839: imul
    //   840: istore #4
    //   842: aload #9
    //   844: getfield width : I
    //   847: istore #5
    //   849: aload #9
    //   851: getfield height : I
    //   854: istore #6
    //   856: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   859: astore #8
    //   861: new java/lang/StringBuilder
    //   864: dup
    //   865: invokespecial <init> : ()V
    //   868: astore #11
    //   870: aload #11
    //   872: ldc_w 'preview size '
    //   875: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: pop
    //   879: aload #11
    //   881: aload #9
    //   883: getfield width : I
    //   886: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   889: pop
    //   890: aload #11
    //   892: ldc_w 'x'
    //   895: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: pop
    //   899: aload #11
    //   901: aload #9
    //   903: getfield height : I
    //   906: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   909: pop
    //   910: aload #11
    //   912: ldc_w ' encoding size '
    //   915: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: pop
    //   919: aload #11
    //   921: aload #10
    //   923: invokevirtual a : ()I
    //   926: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   929: pop
    //   930: aload #11
    //   932: ldc_w 'x'
    //   935: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   938: pop
    //   939: aload #11
    //   941: aload #10
    //   943: invokevirtual b : ()I
    //   946: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   949: pop
    //   950: aload #8
    //   952: ldc_w 'CameraManager'
    //   955: aload #11
    //   957: invokevirtual toString : ()Ljava/lang/String;
    //   960: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   963: aload #9
    //   965: astore #8
    //   967: iload #5
    //   969: iload #6
    //   971: imul
    //   972: iload #4
    //   974: if_icmpge -> 998
    //   977: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   980: ldc_w 'CameraManager'
    //   983: ldc_w 'preview size smaller than encoding size, adjust now.'
    //   986: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   989: aload_0
    //   990: aload_1
    //   991: iload #4
    //   993: invokevirtual a : (Landroid/hardware/Camera$Parameters;I)Landroid/hardware/Camera$Size;
    //   996: astore #8
    //   998: aload_0
    //   999: getfield T : Z
    //   1002: ifeq -> 1063
    //   1005: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   1008: astore_1
    //   1009: new java/lang/StringBuilder
    //   1012: dup
    //   1013: invokespecial <init> : ()V
    //   1016: astore #9
    //   1018: aload #9
    //   1020: ldc_w 'notifyNoSupportedPrvSize mIsCameraSwitched:'
    //   1023: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: pop
    //   1027: aload #9
    //   1029: aload_0
    //   1030: getfield v : Z
    //   1033: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   1036: pop
    //   1037: aload_1
    //   1038: ldc_w 'CameraManager'
    //   1041: aload #9
    //   1043: invokevirtual toString : ()Ljava/lang/String;
    //   1046: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   1049: aload_0
    //   1050: getfield W : La/a/a/a/a/b/c$j;
    //   1053: aload #8
    //   1055: invokeinterface a : (Landroid/hardware/Camera$Size;)V
    //   1060: goto -> 1073
    //   1063: aload_0
    //   1064: getfield W : La/a/a/a/a/b/c$j;
    //   1067: aconst_null
    //   1068: invokeinterface a : (Landroid/hardware/Camera$Size;)V
    //   1073: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   1076: astore_1
    //   1077: new java/lang/StringBuilder
    //   1080: dup
    //   1081: invokespecial <init> : ()V
    //   1084: astore #9
    //   1086: aload #9
    //   1088: ldc_w 'setCameraPreviewSize size.width:'
    //   1091: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1094: pop
    //   1095: aload #9
    //   1097: aload #8
    //   1099: getfield width : I
    //   1102: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1105: pop
    //   1106: aload #9
    //   1108: ldc_w ',size.height:'
    //   1111: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1114: pop
    //   1115: aload #9
    //   1117: aload #8
    //   1119: getfield height : I
    //   1122: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1125: pop
    //   1126: aload_1
    //   1127: ldc_w 'CameraManager'
    //   1130: aload #9
    //   1132: invokevirtual toString : ()Ljava/lang/String;
    //   1135: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   1138: aload_0
    //   1139: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   1142: aload #8
    //   1144: getfield width : I
    //   1147: aload #8
    //   1149: getfield height : I
    //   1152: invokevirtual b : (II)Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   1155: pop
    //   1156: aload_0
    //   1157: getfield e : Lcom/qiniu/pili/droid/streaming/widget/AspectFrameLayout;
    //   1160: astore_1
    //   1161: aload_1
    //   1162: ifnull -> 1173
    //   1165: aload_1
    //   1166: aload_0
    //   1167: invokevirtual y : ()D
    //   1170: invokevirtual setAspectRatio : (D)V
    //   1173: return
  }
  
  public void a(ViewGroup paramViewGroup, View paramView) {
    g g1 = this.i;
    if (g1 != null) {
      g1.a(paramViewGroup, paramView);
      return;
    } 
    this.f = paramViewGroup;
    this.g = paramView;
  }
  
  public void a(CameraStreamingSetting paramCameraStreamingSetting, WatermarkSetting paramWatermarkSetting, PreviewAppearance paramPreviewAppearance, boolean paramBoolean, StreamingPreviewCallback paramStreamingPreviewCallback) {
    this.j = paramCameraStreamingSetting;
    this.l = paramWatermarkSetting;
    this.A = paramBoolean;
    this.k = paramPreviewAppearance;
    this.o = paramStreamingPreviewCallback;
    u();
  }
  
  public void a(StreamingPreviewCallback paramStreamingPreviewCallback, boolean paramBoolean) {
    this.p = paramBoolean;
    this.o = paramStreamingPreviewCallback;
    q();
    e e1 = this.b;
    if (e1 != null) {
      if (!paramBoolean)
        paramStreamingPreviewCallback = null; 
      e1.a(paramStreamingPreviewCallback);
    } 
  }
  
  public void a(SurfaceTextureCallback paramSurfaceTextureCallback) {
    e e1 = this.b;
    if (e1 != null) {
      e1.a(paramSurfaceTextureCallback);
      return;
    } 
    a.a.a.a.a.e.e.g.c("CameraManager", "mRenderer is null, save for latter use");
    this.X.add(paramSurfaceTextureCallback);
  }
  
  public void a(WatermarkSetting paramWatermarkSetting) {
    WatermarkSetting watermarkSetting = this.l;
    if (watermarkSetting != null)
      watermarkSetting.release(); 
    this.l = paramWatermarkSetting;
    e e1 = this.b;
    if (e1 != null)
      e1.a(paramWatermarkSetting); 
  }
  
  public final void a(ByteBuffer paramByteBuffer) {
    synchronized (this.d) {
      a.a.a.a.a.e.e e1;
      boolean bool;
      if (this.P == null || this.c == null) {
        e1 = a.a.a.a.a.e.e.g;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("mCamera : ");
        stringBuilder1.append(this.c);
        stringBuilder1.append(", mFrameCapturedCallback : ");
        stringBuilder1.append(this.P);
        e1.e("CameraManager", stringBuilder1.toString());
        return;
      } 
      long l1 = System.currentTimeMillis();
      Camera.Parameters parameters = this.c.d();
      if (parameters == null) {
        this.P.onFrameCaptured(null);
        return;
      } 
      Camera.Size size = parameters.getPreviewSize();
      if (size == null) {
        this.P.onFrameCaptured(null);
        return;
      } 
      int k = size.width;
      int n = size.height;
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      (new YuvImage(e1.array(), parameters.getPreviewFormat(), k, n, null)).compressToJpeg(new Rect(0, 0, k, n), 80, byteArrayOutputStream);
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
      if (this.Q > 0 && this.R > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      if (!bool) {
        bitmap = a.a.a.a.a.e.h.a(arrayOfByte, 0, arrayOfByte.length, k, n, this.z);
      } else {
        bitmap = a.a.a.a.a.e.h.a((byte[])bitmap, 0, bitmap.length, this.Q, this.R, this.z);
      } 
      Bitmap bitmap = a(bitmap, bool);
      a.a.a.a.a.e.e e2 = a.a.a.a.a.e.e.g;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("reqBitmap.w:");
      stringBuilder.append(bitmap.getWidth());
      stringBuilder.append(",reqBitmap.h:");
      stringBuilder.append(bitmap.getHeight());
      e2.c("CameraManager", stringBuilder.toString());
      e2 = a.a.a.a.a.e.e.g;
      stringBuilder = new StringBuilder();
      stringBuilder.append("end capturing cost:");
      stringBuilder.append(System.currentTimeMillis() - l1);
      e2.c("CameraManager", stringBuilder.toString());
      this.P.onFrameCaptured(bitmap);
      this.y = null;
      return;
    } 
  }
  
  public void a(boolean paramBoolean) {
    a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.g;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("changeRecordingState: was ");
    stringBuilder.append(this.O);
    stringBuilder.append(",now:");
    stringBuilder.append(paramBoolean);
    e1.b("CameraManager", stringBuilder.toString());
    this.O = paramBoolean;
    if (!paramBoolean) {
      this.B = false;
      this.C = false;
    } 
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, FrameCapturedCallback paramFrameCapturedCallback) {
    this.P = paramFrameCapturedCallback;
    this.Q = paramInt1;
    this.R = paramInt2;
    a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.g;
    null = new StringBuilder();
    null.append("mCaptureWidth:");
    null.append(this.Q);
    null.append(",mCaptureHeight:");
    null.append(this.R);
    null.append(",isNeedPreviewFrameCb:");
    null.append(v());
    e1.c("CameraManager", null.toString());
    synchronized (this.d) {
      if (v()) {
        this.S = true;
      } else {
        this.c.b(new d(this));
      } 
      return;
    } 
  }
  
  public final void a(byte[] paramArrayOfbyte) {
    if (this.y == null) {
      ByteBuffer byteBuffer = ByteBuffer.allocate(paramArrayOfbyte.length);
      this.y = byteBuffer;
      byteBuffer.clear();
      this.y.put(paramArrayOfbyte);
      i i1 = this.q;
      if (i1 != null) {
        i1.removeMessages(4);
        i1 = this.q;
        i1.sendMessage(i1.obtainMessage(4, this.y));
        return;
      } 
      this.y.clear();
      this.y = null;
      return;
    } 
    a.a.a.a.a.e.e.g.d("CameraManager", "capture request arrived. So ignore this req");
  }
  
  public final void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, long paramLong) {
    if (this.S) {
      this.S = false;
      a(paramArrayOfbyte);
    } 
    if (this.O && !this.A && !this.C && !this.B) {
      this.B = true;
      this.W.e();
    } 
    if (!this.p) {
      boolean bool;
      j j1 = this.W;
      int k = h();
      if (!this.A && this.O && this.C) {
        bool = true;
      } else {
        bool = false;
      } 
      j1.a(paramArrayOfbyte, paramInt1, paramInt2, k, paramInt3, paramLong, bool);
    } 
  }
  
  public final boolean a(int paramInt, a.a.a.a.a.a.b paramb) {
    // Byte code:
    //   0: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   3: astore #5
    //   5: new java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial <init> : ()V
    //   12: astore #6
    //   14: aload #6
    //   16: ldc_w 'openCameraInternal id:'
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload #6
    //   25: iload_1
    //   26: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload #6
    //   32: ldc_w ',tid:'
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload #6
    //   41: invokestatic currentThread : ()Ljava/lang/Thread;
    //   44: invokevirtual getId : ()J
    //   47: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload #5
    //   53: ldc_w 'CameraManager'
    //   56: aload #6
    //   58: invokevirtual toString : ()Ljava/lang/String;
    //   61: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_0
    //   65: aload_2
    //   66: putfield U : La/a/a/a/a/a/b;
    //   69: aload_0
    //   70: getfield d : Ljava/lang/Object;
    //   73: astore #5
    //   75: aload #5
    //   77: monitorenter
    //   78: iconst_0
    //   79: istore #4
    //   81: invokestatic a : ()La/a/a/a/a/b/b;
    //   84: iload_1
    //   85: invokevirtual b : (I)La/a/a/a/a/b/b$d;
    //   88: astore #6
    //   90: aload_0
    //   91: aload #6
    //   93: putfield c : La/a/a/a/a/b/b$d;
    //   96: aload #6
    //   98: ifnonnull -> 157
    //   101: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   104: astore_2
    //   105: new java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial <init> : ()V
    //   112: astore #6
    //   114: aload #6
    //   116: ldc_w 'Unable to open camera, id:'
    //   119: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload #6
    //   125: iload_1
    //   126: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_2
    //   131: ldc_w 'CameraManager'
    //   134: aload #6
    //   136: invokevirtual toString : ()Ljava/lang/String;
    //   139: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_0
    //   143: getfield W : La/a/a/a/a/b/c$j;
    //   146: iload_1
    //   147: invokeinterface a : (I)V
    //   152: aload #5
    //   154: monitorexit
    //   155: iconst_0
    //   156: ireturn
    //   157: aload_0
    //   158: iconst_0
    //   159: putfield u : Z
    //   162: aload_0
    //   163: getfield c : La/a/a/a/a/b/b$d;
    //   166: invokevirtual d : ()Landroid/hardware/Camera$Parameters;
    //   169: astore #6
    //   171: aload #6
    //   173: ifnonnull -> 193
    //   176: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   179: ldc_w 'CameraManager'
    //   182: ldc_w 'camera released'
    //   185: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload #5
    //   190: monitorexit
    //   191: iconst_0
    //   192: ireturn
    //   193: aload_0
    //   194: aload #6
    //   196: putfield D : Landroid/hardware/Camera$Parameters;
    //   199: aload_0
    //   200: aload #6
    //   202: invokevirtual b : (Landroid/hardware/Camera$Parameters;)V
    //   205: aload_0
    //   206: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   209: invokevirtual isCAFEnabled : ()Z
    //   212: ifeq -> 280
    //   215: aload #6
    //   217: invokevirtual getSupportedFocusModes : ()Ljava/util/List;
    //   220: ldc_w 'continuous-picture'
    //   223: invokeinterface contains : (Ljava/lang/Object;)Z
    //   228: ifeq -> 242
    //   231: aload #6
    //   233: ldc_w 'continuous-picture'
    //   236: invokevirtual setFocusMode : (Ljava/lang/String;)V
    //   239: goto -> 274
    //   242: aload #6
    //   244: invokevirtual getSupportedFocusModes : ()Ljava/util/List;
    //   247: aload_0
    //   248: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   251: invokevirtual getFocusMode : ()Ljava/lang/String;
    //   254: invokeinterface contains : (Ljava/lang/Object;)Z
    //   259: ifeq -> 274
    //   262: aload #6
    //   264: aload_0
    //   265: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   268: invokevirtual getFocusMode : ()Ljava/lang/String;
    //   271: invokevirtual setFocusMode : (Ljava/lang/String;)V
    //   274: aload_0
    //   275: aload #6
    //   277: invokevirtual c : (Landroid/hardware/Camera$Parameters;)V
    //   280: aload_0
    //   281: getfield W : La/a/a/a/a/b/c$j;
    //   284: ifnull -> 930
    //   287: aload #6
    //   289: invokevirtual getSupportedPreviewFpsRange : ()Ljava/util/List;
    //   292: astore #7
    //   294: aload_0
    //   295: getfield W : La/a/a/a/a/b/c$j;
    //   298: aload #7
    //   300: invokeinterface onPreviewFpsSelected : (Ljava/util/List;)I
    //   305: istore_1
    //   306: iload_1
    //   307: iflt -> 930
    //   310: iload_1
    //   311: aload #7
    //   313: invokeinterface size : ()I
    //   318: if_icmpge -> 930
    //   321: aload #7
    //   323: iload_1
    //   324: invokeinterface get : (I)Ljava/lang/Object;
    //   329: checkcast [I
    //   332: astore #7
    //   334: aload #6
    //   336: aload #7
    //   338: iconst_0
    //   339: iaload
    //   340: aload #7
    //   342: iconst_1
    //   343: iaload
    //   344: invokevirtual setPreviewFpsRange : (II)V
    //   347: aload #7
    //   349: iconst_1
    //   350: iaload
    //   351: istore_1
    //   352: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   355: astore #8
    //   357: new java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial <init> : ()V
    //   364: astore #9
    //   366: aload #9
    //   368: ldc_w 'chose external fps: '
    //   371: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload #9
    //   377: aload #7
    //   379: iconst_0
    //   380: iaload
    //   381: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload #9
    //   387: ldc_w ' - '
    //   390: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload #9
    //   396: aload #7
    //   398: iconst_1
    //   399: iaload
    //   400: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload #8
    //   406: ldc_w 'CameraManager'
    //   409: aload #9
    //   411: invokevirtual toString : ()Ljava/lang/String;
    //   414: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   417: goto -> 932
    //   420: aload #6
    //   422: aload_2
    //   423: invokevirtual q : ()I
    //   426: invokestatic a : (Landroid/hardware/Camera$Parameters;I)I
    //   429: istore_1
    //   430: aload_2
    //   431: iload_1
    //   432: invokevirtual b : (I)V
    //   435: aload_0
    //   436: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   439: invokevirtual a : ()Z
    //   442: istore_3
    //   443: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   446: astore_2
    //   447: new java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial <init> : ()V
    //   454: astore #7
    //   456: aload #7
    //   458: ldc_w 'hint:'
    //   461: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload #7
    //   467: iload_3
    //   468: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload_2
    //   473: ldc_w 'CameraManager'
    //   476: aload #7
    //   478: invokevirtual toString : ()Ljava/lang/String;
    //   481: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   484: aload #6
    //   486: iload_3
    //   487: invokevirtual setRecordingHint : (Z)V
    //   490: aload #6
    //   492: invokevirtual getSupportedPreviewFormats : ()Ljava/util/List;
    //   495: astore_2
    //   496: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   499: astore #7
    //   501: new java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial <init> : ()V
    //   508: astore #8
    //   510: aload #8
    //   512: ldc_w 'TOTAL SUPPORTED FORMATS: '
    //   515: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload #8
    //   521: aload_2
    //   522: invokeinterface size : ()I
    //   527: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: aload #7
    //   533: ldc_w 'CameraManager'
    //   536: aload #8
    //   538: invokevirtual toString : ()Ljava/lang/String;
    //   541: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   544: aload_2
    //   545: invokeinterface iterator : ()Ljava/util/Iterator;
    //   550: astore_2
    //   551: aload_2
    //   552: invokeinterface hasNext : ()Z
    //   557: ifeq -> 637
    //   560: aload_2
    //   561: invokeinterface next : ()Ljava/lang/Object;
    //   566: checkcast java/lang/Integer
    //   569: astore #7
    //   571: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   574: astore #8
    //   576: new java/lang/StringBuilder
    //   579: dup
    //   580: invokespecial <init> : ()V
    //   583: astore #9
    //   585: aload #9
    //   587: ldc_w 'SUPPORTED FORMAT: '
    //   590: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload #9
    //   596: aload #7
    //   598: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload #8
    //   604: ldc_w 'CameraManager'
    //   607: aload #9
    //   609: invokevirtual toString : ()Ljava/lang/String;
    //   612: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   615: aload #7
    //   617: invokevirtual intValue : ()I
    //   620: bipush #17
    //   622: if_icmpne -> 551
    //   625: aload #6
    //   627: bipush #17
    //   629: invokevirtual setPreviewFormat : (I)V
    //   632: aload_0
    //   633: iconst_1
    //   634: putfield w : Z
    //   637: aload_0
    //   638: aload #6
    //   640: invokevirtual a : (Landroid/hardware/Camera$Parameters;)V
    //   643: aload #6
    //   645: aload_0
    //   646: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   649: invokevirtual getCameraPreviewWidth : ()I
    //   652: aload_0
    //   653: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   656: invokevirtual getCameraPreviewHeight : ()I
    //   659: invokevirtual setPreviewSize : (II)V
    //   662: aload_0
    //   663: getfield c : La/a/a/a/a/b/b$d;
    //   666: aload #6
    //   668: invokevirtual a : (Landroid/hardware/Camera$Parameters;)V
    //   671: aload_0
    //   672: getfield c : La/a/a/a/a/b/b$d;
    //   675: invokevirtual d : ()Landroid/hardware/Camera$Parameters;
    //   678: astore_2
    //   679: aload_2
    //   680: ifnull -> 799
    //   683: aload_2
    //   684: invokevirtual getPreviewSize : ()Landroid/hardware/Camera$Size;
    //   687: astore_2
    //   688: aload_2
    //   689: getfield width : I
    //   692: aload_2
    //   693: getfield height : I
    //   696: imul
    //   697: aload_0
    //   698: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   701: invokevirtual getCameraPreviewWidth : ()I
    //   704: aload_0
    //   705: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   708: invokevirtual getCameraPreviewHeight : ()I
    //   711: imul
    //   712: if_icmpeq -> 811
    //   715: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   718: astore #6
    //   720: new java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial <init> : ()V
    //   727: astore #7
    //   729: aload #7
    //   731: ldc_w 'updatePrvSize size.width:'
    //   734: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: aload #7
    //   740: aload_2
    //   741: getfield width : I
    //   744: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload #7
    //   750: ldc_w ',size.height:'
    //   753: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: aload #7
    //   759: aload_2
    //   760: getfield height : I
    //   763: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   766: pop
    //   767: aload #6
    //   769: ldc_w 'CameraManager'
    //   772: aload #7
    //   774: invokevirtual toString : ()Ljava/lang/String;
    //   777: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   780: aload_0
    //   781: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   784: aload_2
    //   785: getfield width : I
    //   788: aload_2
    //   789: getfield height : I
    //   792: invokevirtual b : (II)Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   795: pop
    //   796: goto -> 811
    //   799: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   802: ldc_w 'CameraManager'
    //   805: ldc_w 'param is null'
    //   808: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   811: aload_0
    //   812: getfield b : La/a/a/a/a/b/e;
    //   815: ifnull -> 877
    //   818: aload_0
    //   819: getfield b : La/a/a/a/a/b/e;
    //   822: aload_0
    //   823: getfield l : Lcom/qiniu/pili/droid/streaming/WatermarkSetting;
    //   826: invokevirtual a : (Lcom/qiniu/pili/droid/streaming/WatermarkSetting;)V
    //   829: aload_0
    //   830: getfield x : Z
    //   833: ifne -> 877
    //   836: iload #4
    //   838: istore_3
    //   839: invokestatic a : ()La/a/a/a/a/b/b;
    //   842: invokevirtual c : ()Z
    //   845: ifeq -> 863
    //   848: iload #4
    //   850: istore_3
    //   851: aload_0
    //   852: getfield j : Lcom/qiniu/pili/droid/streaming/CameraStreamingSetting;
    //   855: invokevirtual isFrontCameraPreviewMirror : ()Z
    //   858: ifeq -> 863
    //   861: iconst_1
    //   862: istore_3
    //   863: aload_0
    //   864: getfield b : La/a/a/a/a/b/e;
    //   867: iload_3
    //   868: invokevirtual a : (Z)Z
    //   871: pop
    //   872: aload_0
    //   873: iconst_1
    //   874: putfield x : Z
    //   877: aload_0
    //   878: invokevirtual A : ()V
    //   881: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   884: ldc_w 'CameraManager'
    //   887: ldc_w 'openCameraInternal onResume'
    //   890: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   893: aload_0
    //   894: getfield a : Landroid/opengl/GLSurfaceView;
    //   897: invokevirtual onResume : ()V
    //   900: aload #5
    //   902: monitorexit
    //   903: iconst_1
    //   904: ireturn
    //   905: astore_2
    //   906: aload_2
    //   907: invokevirtual printStackTrace : ()V
    //   910: aload_0
    //   911: getfield W : La/a/a/a/a/b/c$j;
    //   914: iload_1
    //   915: invokeinterface a : (I)V
    //   920: aload #5
    //   922: monitorexit
    //   923: iconst_0
    //   924: ireturn
    //   925: aload #5
    //   927: monitorexit
    //   928: aload_2
    //   929: athrow
    //   930: iconst_0
    //   931: istore_1
    //   932: iload_1
    //   933: ifle -> 420
    //   936: goto -> 430
    //   939: astore_2
    //   940: goto -> 925
    // Exception table:
    //   from	to	target	type
    //   81	96	905	java/lang/Exception
    //   81	96	939	finally
    //   101	105	939	finally
    //   105	155	939	finally
    //   157	171	939	finally
    //   176	191	939	finally
    //   193	239	939	finally
    //   242	274	939	finally
    //   274	280	939	finally
    //   280	306	939	finally
    //   310	347	939	finally
    //   352	357	939	finally
    //   357	417	939	finally
    //   420	430	939	finally
    //   430	447	939	finally
    //   447	501	939	finally
    //   501	551	939	finally
    //   551	576	939	finally
    //   576	637	939	finally
    //   637	679	939	finally
    //   683	720	939	finally
    //   720	796	939	finally
    //   799	811	939	finally
    //   811	836	939	finally
    //   839	848	939	finally
    //   851	861	939	finally
    //   863	877	939	finally
    //   877	903	939	finally
    //   906	923	939	finally
    //   925	928	939	finally
  }
  
  public boolean a(a.a.a.a.a.a.b paramb) {
    if (!a.a.a.a.a.e.h.e(this.h)) {
      a.a.a.a.a.e.e.g.e("CameraManager", "Fatal error. No camera!");
      return false;
    } 
    this.a.onPause();
    b(paramb);
    return true;
  }
  
  public boolean a(a.a.a.a.a.a.b paramb, CameraStreamingSetting.CAMERA_FACING_ID paramCAMERA_FACING_ID) {
    a.a.a.a.a.e.e e1;
    StringBuilder stringBuilder1;
    int k = b.a().d();
    if (paramCAMERA_FACING_ID == null) {
      a.a.a.a.a.e.e.g.e("CameraManager", "Invalid camera facing id");
      b(false);
      return false;
    } 
    if (k < 2) {
      e1 = a.a.a.a.a.e.e.g;
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Cannot switch camera as number of cameras is :");
      stringBuilder1.append(k);
      e1.e("CameraManager", stringBuilder1.toString());
      b(false);
      return false;
    } 
    if (this.n != null) {
      a.a.a.a.a.e.e.g.e("CameraManager", "Cannot switch camera since camera switching.");
      b(false);
      return false;
    } 
    g g1 = this.i;
    if (g1 != null)
      g1.i(); 
    a.a.a.a.a.e.e e2 = a.a.a.a.a.e.e.g;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("switchCamera current cameraid:");
    stringBuilder2.append(this.j.getReqCameraId());
    stringBuilder2.append(",mRecordingEnabled=");
    stringBuilder2.append(this.O);
    e2.c("CameraManager", stringBuilder2.toString());
    this.r = false;
    if (this.N)
      this.W.b(); 
    this.a.queueEvent(new c(this));
    this.a.onPause();
    this.j.setCameraFacingId((CameraStreamingSetting.CAMERA_FACING_ID)stringBuilder1);
    this.v = true;
    this.x = false;
    b((a.a.a.a.a.a.b)e1);
    return true;
  }
  
  public void b(int paramInt) {
    this.b.a(paramInt);
  }
  
  public final void b(a.a.a.a.a.a.b paramb) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   5: astore_2
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc_w 'launchCameraStartUpThread mCameraStartUpThread:'
    //   18: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_3
    //   23: aload_0
    //   24: getfield n : La/a/a/a/a/b/c$l;
    //   27: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_2
    //   32: ldc_w 'CameraManager'
    //   35: aload_3
    //   36: invokevirtual toString : ()Ljava/lang/String;
    //   39: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   42: new a/a/a/a/a/b/c$l
    //   45: dup
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial <init> : (La/a/a/a/a/b/c;La/a/a/a/a/a/b;)V
    //   51: astore_1
    //   52: aload_0
    //   53: aload_1
    //   54: putfield n : La/a/a/a/a/b/c$l;
    //   57: aload_1
    //   58: invokevirtual start : ()V
    //   61: getstatic a/a/a/a/a/e/e.g : La/a/a/a/a/e/e;
    //   64: ldc_w 'CameraManager'
    //   67: ldc_w 'launchCameraStartUpThread -'
    //   70: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Exception table:
    //   from	to	target	type
    //   2	73	76	finally
  }
  
  public final void b(Camera.Parameters paramParameters) {
    boolean bool1;
    int k = paramParameters.getMaxNumFocusAreas();
    boolean bool2 = true;
    if (k > 0 && a.a.a.a.a.e.h.a("auto", paramParameters.getSupportedFocusModes())) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.E = bool1;
    if (paramParameters.getMaxNumMeteringAreas() > 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    this.F = bool1;
    this.G = paramParameters.isAutoExposureLockSupported();
    this.H = paramParameters.isAutoWhiteBalanceLockSupported();
    this.I = paramParameters.getSupportedFocusModes().contains("continuous-picture");
  }
  
  public void b(boolean paramBoolean) {
    this.N = paramBoolean;
  }
  
  public boolean b() {
    return this.r;
  }
  
  public void c(int paramInt) {
    synchronized (this.d) {
      if (this.D != null) {
        this.D.setZoom(paramInt);
        this.c.a(this.D);
      } 
      return;
    } 
  }
  
  public final void c(Camera.Parameters paramParameters) {
    if (this.I) {
      String str = paramParameters.getFocusMode();
      if (this.M != null && ("continuous-video".equals(str) || "continuous-picture".equals(str))) {
        this.c.a((a)this.M);
        return;
      } 
      this.c.a((Camera.AutoFocusMoveCallback)null);
    } 
  }
  
  public void c(boolean paramBoolean) {
    this.C = paramBoolean;
  }
  
  public boolean c() {
    return this.v;
  }
  
  public void d(int paramInt) {}
  
  public void d(boolean paramBoolean) {
    if (paramBoolean != this.A) {
      this.A = paramBoolean;
      q();
    } 
  }
  
  public boolean d() {
    if (!a.a.a.a.a.e.c.a().c())
      return false; 
    synchronized (this.d) {
      if (this.t) {
        if (this.c == null || !this.r) {
          a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.g;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("mCamera:");
          stringBuilder.append(this.c);
          stringBuilder.append(",mIsPreviewReady=");
          stringBuilder.append(this.r);
          e1.e("CameraManager", stringBuilder.toString());
          return false;
        } 
        Camera.Parameters parameters = this.c.d();
        if (parameters == null) {
          a.a.a.a.a.e.e.g.e("CameraManager", "camera parameters is null");
          return false;
        } 
        List list = parameters.getSupportedFlashModes();
        String str = parameters.getFlashMode();
        if (list == null) {
          a.a.a.a.a.e.e.g.e("CameraManager", "getSupportedFlashModes is null");
          return false;
        } 
        if (!"off".equals(str))
          if (list.contains("off")) {
            if (a.a.a.a.a.e.c.a().b())
              parameters.setFocusMode("continuous-video"); 
            parameters.setFlashMode("off");
            this.c.a(parameters);
            this.t = false;
          } else {
            a.a.a.a.a.e.e.g.e("CameraManager", "FLASH_MODE_OFF not supported");
            return false;
          }  
        return true;
      } 
      return false;
    } 
  }
  
  public boolean e() {
    if (!a.a.a.a.a.e.c.a().c())
      return false; 
    synchronized (this.d) {
      if (this.c == null || !this.r) {
        a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.g;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mCamera:");
        stringBuilder.append(this.c);
        stringBuilder.append(",mIsPreviewReady:");
        stringBuilder.append(this.r);
        stringBuilder.append(", mIsLightOn:");
        stringBuilder.append(this.t);
        e1.e("CameraManager", stringBuilder.toString());
        return false;
      } 
      Camera.Parameters parameters = this.c.d();
      if (parameters == null) {
        a.a.a.a.a.e.e.g.e("CameraManager", "parameters is null");
        return false;
      } 
      List list = parameters.getSupportedFlashModes();
      if (list == null) {
        a.a.a.a.a.e.e.g.e("CameraManager", "getSupportedFlashModes is null");
        return false;
      } 
      if (!"torch".equals(parameters.getFlashMode()))
        if (list.contains("torch")) {
          if (a.a.a.a.a.e.c.a().b())
            parameters.setFocusMode("macro"); 
          parameters.setFlashMode("torch");
          this.c.a(parameters);
          this.t = true;
        } else {
          a.a.a.a.a.e.e.g.e("CameraManager", "FLASH_MODE_TORCH not supported");
          return false;
        }  
      return true;
    } 
  }
  
  public boolean e(boolean paramBoolean) {
    e e1 = this.b;
    if (e1 != null)
      return e1.a(paramBoolean); 
    a.a.a.a.a.e.e.g.e("CameraManager", "setMirror while mRenderer is null");
    return false;
  }
  
  public int f() {
    a.a.a.a.a.e.e e1;
    b.d d1 = this.c;
    if (d1 == null || !this.r) {
      e1 = a.a.a.a.a.e.e.g;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("mCamera:");
      stringBuilder.append(this.c);
      stringBuilder.append(",mIsPreviewReady:");
      stringBuilder.append(this.r);
      e1.e("CameraManager", stringBuilder.toString());
      return 0;
    } 
    Camera.Parameters parameters = e1.d();
    if (parameters == null) {
      a.a.a.a.a.e.e.g.e("CameraManager", "parameters is null");
      return 0;
    } 
    return parameters.getMinExposureCompensation();
  }
  
  public int g() {
    a.a.a.a.a.e.e e1;
    b.d d1 = this.c;
    if (d1 == null || !this.r) {
      e1 = a.a.a.a.a.e.e.g;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("mCamera:");
      stringBuilder.append(this.c);
      stringBuilder.append(",mIsPreviewReady:");
      stringBuilder.append(this.r);
      e1.e("CameraManager", stringBuilder.toString());
      return 0;
    } 
    Camera.Parameters parameters = e1.d();
    if (parameters == null) {
      a.a.a.a.a.e.e.g.e("CameraManager", "parameters is null");
      return 0;
    } 
    return parameters.getMaxExposureCompensation();
  }
  
  public int h() {
    w();
    synchronized (this.d) {
      int k;
      if (b.a().c()) {
        k = (360 - this.z) % 360;
      } else {
        k = this.z;
      } 
      return k;
    } 
  }
  
  public WatermarkSetting i() {
    return this.l;
  }
  
  public m j() {
    return this.m;
  }
  
  public void k() {
    boolean bool = this.q.hasMessages(4);
    this.q.removeCallbacksAndMessages(null);
    if (this.S || bool) {
      this.S = false;
      this.P.onFrameCaptured(null);
    } 
    C();
    this.a.queueEvent(new e(this));
    this.a.onPause();
  }
  
  public void l() {
    i i1 = this.q;
    if (i1 != null)
      i1.a(); 
    WatermarkSetting watermarkSetting = this.l;
    if (watermarkSetting != null) {
      watermarkSetting.release();
      this.l = null;
    } 
    this.W = this.V;
    this.x = false;
  }
  
  public void m() {
    AspectFrameLayout aspectFrameLayout = this.e;
    if (aspectFrameLayout != null) {
      aspectFrameLayout.a(a.a.a.a.a.e.h.d(this.h));
      this.e.setAspectRatio(y());
    } 
  }
  
  public boolean n() {
    Camera.Parameters parameters = this.D;
    return (parameters != null) ? parameters.isZoomSupported() : false;
  }
  
  public int o() {
    Camera.Parameters parameters = this.D;
    return (parameters != null) ? parameters.getMaxZoom() : 0;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {
    a.a.a.a.a.e.e.g.a("CameraManager", "ST onFrameAvailable");
    if (this.u) {
      a.a.a.a.a.e.e.g.e("CameraManager", "camera have been closed!!");
      return;
    } 
    this.a.requestRender();
    if (!this.b.a())
      return; 
    boolean bool = this.s;
    boolean bool1 = false;
    if (bool) {
      this.s = false;
      this.W.c();
    } 
    if (this.O) {
      if (!this.C) {
        if (!this.B) {
          this.B = true;
          this.W.e();
        } 
        a.a.a.a.a.e.e.g.c("CameraManager", "ignore the frame.");
        return;
      } 
      int k = this.m.b;
      bool = bool1;
      if (this.b != null)
        synchronized (a.a.a.a.a.a.h.f.d) {
          int n = this.b.b();
          bool = bool1;
          k = n;
          if (n != this.m.b) {
            bool = true;
            k = n;
          } 
        }  
      this.W.a(k, System.nanoTime(), bool);
    } 
  }
  
  public void onPreviewFrame(byte[] paramArrayOfbyte, Camera paramCamera) {
    if (paramArrayOfbyte != null) {
      if (this.u)
        return; 
      a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.g;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onPreviewFrame + length:");
      stringBuilder.append(paramArrayOfbyte.length);
      stringBuilder.append(",mRecordingEnabled:");
      stringBuilder.append(this.O);
      e1.a("CameraManager", stringBuilder.toString());
      a(paramArrayOfbyte, this.j.getCameraPreviewWidth(), this.j.getCameraPreviewHeight(), PLFourCC.FOURCC_NV21, System.nanoTime());
      if (!this.u)
        paramCamera.addCallbackBuffer(paramArrayOfbyte); 
    } 
  }
  
  public int p() {
    Camera.Parameters parameters = this.D;
    return (parameters != null) ? parameters.getZoom() : 0;
  }
  
  public void q() {
    if (!v()) {
      a.a.a.a.a.e.e.g.d("CameraManager", "no need addCallbackBuffer and uninstall the preview callback");
      synchronized (this.d) {
        if (this.c != null)
          this.c.a((Camera.PreviewCallback)null); 
        return;
      } 
    } 
    synchronized (this.d) {
      if (this.c == null) {
        a.a.a.a.a.e.e.g.d("CameraManager", "mCamera is null in preparePreviewCallback");
        return;
      } 
      Camera.Parameters parameters = this.c.d();
      if (parameters == null) {
        a.a.a.a.a.e.e.g.d("CameraManager", "params is null");
        return;
      } 
      if (this.w) {
        Camera.Size size = parameters.getPreviewSize();
        int k = ImageFormat.getBitsPerPixel(parameters.getPreviewFormat());
        int n = size.width * size.height * k / 8;
        a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.g;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("preview format:");
        stringBuilder.append(parameters.getPreviewFormat());
        stringBuilder.append(",bitsPerPixel:");
        stringBuilder.append(k);
        e1.c("CameraManager", stringBuilder.toString());
        ArrayList<byte[]> arrayList = new ArrayList();
        for (k = 0; k < 2; k++) {
          e1 = a.a.a.a.a.e.e.g;
          stringBuilder = new StringBuilder();
          stringBuilder.append("addCallbackBuffer size:");
          stringBuilder.append(n);
          e1.c("CameraManager", stringBuilder.toString());
          arrayList.add(new byte[n]);
        } 
        this.c.a(this);
        this.c.a((List<byte[]>)arrayList);
      } else {
        this.W.f();
      } 
      return;
    } 
  }
  
  public void r() {
    if (this.c != null) {
      this.K = System.currentTimeMillis();
      this.c.a(this.L);
    } 
  }
  
  public void s() {
    b.d d1 = this.c;
    if (d1 != null) {
      d1.e();
      G();
    } 
  }
  
  public void t() {
    G();
  }
  
  public final void u() {
    StreamingPreviewCallback streamingPreviewCallback;
    this.a.setEGLContextClientVersion(2);
    this.b = new e(this.q);
    for (SurfaceTextureCallback surfaceTextureCallback : this.X)
      this.b.a(surfaceTextureCallback); 
    this.X.clear();
    e e1 = this.b;
    if (this.p) {
      streamingPreviewCallback = this.o;
    } else {
      streamingPreviewCallback = null;
    } 
    e1.a(streamingPreviewCallback);
    this.b.a(this.k);
    this.b.a(this.l);
    this.a.setRenderer(this.b);
    this.a.setRenderMode(0);
  }
  
  public final boolean v() {
    return a.a.a.a.a.f.e.a().e();
  }
  
  public final void w() {
    int k = a.a.a.a.a.e.h.b(this.h);
    a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.g;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("handle setting camera orientation, mCameraInfo.facing:");
    stringBuilder.append((b.a().b()).facing);
    stringBuilder.append(",degrees:");
    stringBuilder.append(k);
    stringBuilder.append(",orientation:");
    stringBuilder.append((b.a().b()).orientation);
    e1.b("CameraManager", stringBuilder.toString());
    if (b.a().c()) {
      k = (360 - ((b.a().b()).orientation + k) % 360) % 360;
    } else {
      k = ((b.a().b()).orientation - k + 360) % 360;
    } 
    this.z = k;
  }
  
  public final void x() {
    boolean bool;
    boolean bool1 = this.j.d();
    int k = this.j.c();
    int n = this.j.b();
    int i1 = this.j.getCameraPreviewWidth();
    int i2 = this.j.getCameraPreviewHeight();
    if ((b.a().b()).facing == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    int i3 = this.z;
    boolean bool2 = this.j.isPreviewAdaptToEncodingSize();
    a.a.a.a.a.e.f f = this.U.a();
    int i4 = f.a();
    int i5 = f.b();
    e e1 = this.b;
    if (e1 != null)
      e1.a(bool1, k, n, i1, i2, i4, i5, bool2, bool, i3); 
  }
  
  public final double y() {
    int k = this.j.getCameraPreviewWidth();
    int n = this.j.getCameraPreviewHeight();
    int i1 = this.j.c();
    int i2 = this.j.b();
    if (a.a.a.a.a.e.h.c(this.h)) {
      if (this.j.d()) {
        double d1 = i1;
        double d2 = i2;
        return d1 / d2;
      } 
      return k / n;
    } 
    if (this.j.d()) {
      double d1 = i2;
      double d2 = i1;
      return d1 / d2;
    } 
    return n / k;
  }
  
  public final void z() {
    synchronized (this.d) {
      if (this.c == null) {
        a.a.a.a.a.e.e.g.d("CameraManager", "Camera have been closed");
        return;
      } 
      A();
      if (!this.r) {
        this.r = true;
        if (a.a.a.a.a.f.e.a().e() || a.a.a.a.a.f.e.a().c()) {
          this.j.b(PLFourCC.FOURCC_NV21);
        } else if (a.a.a.a.a.f.e.a().d() || a.a.a.a.a.f.e.a().b()) {
          this.j.b(PLFourCC.FOURCC_I420);
        } else {
          a.a.a.a.a.e.e.g.e("CameraManager", "Never go here! Never");
        } 
        this.q.removeMessages(2);
        this.q.sendMessage(this.q.obtainMessage(2));
      } 
      this.a.queueEvent(new f(this));
      return;
    } 
  }
  
  public class a implements a.a {
    public a(c this$0) {}
    
    public void a(boolean param1Boolean, Camera param1Camera) {
      if (c.a(this.a) == null)
        c.b(this.a); 
      c.a(this.a).c(param1Boolean);
    }
  }
  
  public class b implements j {
    public b(c this$0) {}
    
    public void a(int param1Int) {}
    
    public void a(int param1Int, long param1Long, boolean param1Boolean) {}
    
    public void a(Camera.Size param1Size) {}
    
    public void a(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, int param1Int3, int param1Int4, long param1Long, boolean param1Boolean) {}
    
    public void b() {}
    
    public void c() {}
    
    public void e() {}
    
    public void f() {}
    
    public int onPreviewFpsSelected(List<int[]> param1List) {
      return -1;
    }
    
    public Camera.Size onPreviewSizeSelected(List<Camera.Size> param1List) {
      return null;
    }
    
    public void onStateChanged(StreamingState param1StreamingState, Object param1Object) {}
  }
  
  public class c implements Runnable {
    public c(c this$0) {}
    
    public void run() {
      if (c.c(this.a) != null)
        c.c(this.a).d(); 
    }
  }
  
  public class d implements Camera.PreviewCallback {
    public d(c this$0) {}
    
    public void onPreviewFrame(byte[] param1ArrayOfbyte, Camera param1Camera) {
      if (param1ArrayOfbyte != null) {
        c.a(this.a, param1ArrayOfbyte);
        return;
      } 
      c.d(this.a).onFrameCaptured(null);
    }
  }
  
  public class e implements Runnable {
    public e(c this$0) {}
    
    public void run() {
      if (c.c(this.a) != null)
        c.c(this.a).c(); 
    }
  }
  
  public class f implements Runnable {
    public f(c this$0) {}
    
    public void run() {
      c.e(this.a);
    }
  }
  
  public class g implements Runnable {
    public g(c this$0) {}
    
    public void run() {
      this.a.e();
    }
  }
  
  public final class h implements Camera.AutoFocusCallback {
    public h(c this$0) {}
    
    public void onAutoFocus(boolean param1Boolean, Camera param1Camera) {
      c.a(this.a, System.currentTimeMillis() - c.h(this.a));
      a.a.a.a.a.e.e e = a.a.a.a.a.e.e.g;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("mAutoFocusTime = ");
      stringBuilder.append(c.i(this.a));
      stringBuilder.append("ms");
      e.a("CameraManager", stringBuilder.toString());
      c.a(this.a).b(param1Boolean);
    }
  }
  
  public static class i extends Handler {
    public WeakReference<c> a;
    
    public i(Looper param1Looper, c param1c) {
      super(param1Looper);
      this.a = new WeakReference<c>(param1c);
    }
    
    public void a() {
      getLooper().quit();
      this.a.clear();
    }
    
    public void handleMessage(Message param1Message) {
      StringBuilder stringBuilder1;
      a.a.a.a.a.e.e e = a.a.a.a.a.e.e.g;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("CameraHandler [");
      stringBuilder2.append(this);
      stringBuilder2.append("]: what=");
      stringBuilder2.append(param1Message.what);
      e.b("CameraManager", stringBuilder2.toString());
      c c = this.a.get();
      if (c == null) {
        a.a.a.a.a.e.e.g.d("CameraManager", "CameraHandler.handleMessage: mananger is null");
        return;
      } 
      int j = param1Message.what;
      if (j != 0) {
        if (j != 1) {
          if (j != 2) {
            if (j != 3) {
              if (j == 4) {
                c.a(c, (ByteBuffer)param1Message.obj);
                return;
              } 
              stringBuilder1 = new StringBuilder();
              stringBuilder1.append("unknown msg ");
              stringBuilder1.append(param1Message.what);
              throw new RuntimeException(stringBuilder1.toString());
            } 
            c.a((c)stringBuilder1, (Bitmap)param1Message.obj);
            return;
          } 
          c.k((c)stringBuilder1);
          return;
        } 
        c.j((c)stringBuilder1);
        return;
      } 
      c.a((c)stringBuilder1, (c.m)param1Message.obj);
    }
  }
  
  public static interface j {
    void a(int param1Int);
    
    void a(int param1Int, long param1Long, boolean param1Boolean);
    
    void a(Camera.Size param1Size);
    
    void a(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, int param1Int3, int param1Int4, long param1Long, boolean param1Boolean);
    
    void b();
    
    void c();
    
    void e();
    
    void f();
    
    int onPreviewFpsSelected(List<int[]> param1List);
    
    Camera.Size onPreviewSizeSelected(List<Camera.Size> param1List);
    
    void onStateChanged(StreamingState param1StreamingState, Object param1Object);
  }
  
  public static class k implements b.e {
    public WeakReference<c> a;
    
    public k(c param1c) {
      this.a = new WeakReference<c>(param1c);
    }
    
    public void a(Camera.Parameters param1Parameters) {
      c c = this.a.get();
      if (c == null) {
        a.a.a.a.a.e.e.g.d("CameraManager", "onParametersChanged: mananger is null");
        return;
      } 
      c.a(c, param1Parameters);
    }
  }
  
  public class l extends Thread {
    public a.a.a.a.a.a.b a;
    
    public l(c this$0, a.a.a.a.a.a.b param1b) {
      this.a = param1b;
      setName("CameraStartUp");
    }
    
    public void run() {
      c.f(this.b).removeCallbacksAndMessages(null);
      c.f(this.b).post(new a(this));
    }
    
    public class a implements Runnable {
      public a(c.l this$0) {}
      
      public void run() {
        c c = this.a.b;
        c.a(c, c.g(c).getReqCameraId(), c.l.a(this.a));
      }
    }
  }
  
  public class a implements Runnable {
    public a(c this$0) {}
    
    public void run() {
      c c = this.a.b;
      c.a(c, c.g(c).getReqCameraId(), c.l.a(this.a));
    }
  }
  
  public static class m {
    public SurfaceTexture a;
    
    public int b;
    
    public Object c;
    
    public m(SurfaceTexture param1SurfaceTexture, int param1Int, Object param1Object) {
      this.a = param1SurfaceTexture;
      this.b = param1Int;
      this.c = param1Object;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */