package com.blued.android.module.video_gift;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

class GLTextureView extends TextureView implements TextureView.SurfaceTextureListener, View.OnLayoutChangeListener {
  private static final GLThreadManager a = new GLThreadManager();
  
  private final WeakReference<GLTextureView> b = new WeakReference<GLTextureView>(this);
  
  private GLThread c;
  
  private Renderer d;
  
  private boolean e;
  
  private EGLConfigChooser f;
  
  private EGLContextFactory g;
  
  private EGLWindowSurfaceFactory h;
  
  private GLWrapper i;
  
  private int j;
  
  private int k;
  
  private boolean l;
  
  public GLTextureView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private void c() {
    setSurfaceTextureListener(this);
  }
  
  private void d() {
    if (this.c == null)
      return; 
    throw new IllegalStateException("setRenderer has already been called for this instance.");
  }
  
  public void a() {
    this.c.g();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    setEGLConfigChooser(new ComponentSizeChooser(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6));
  }
  
  public void a(SurfaceTexture paramSurfaceTexture) {
    this.c.e();
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3) {
    this.c.a(paramInt2, paramInt3);
  }
  
  public void b() {
    this.c.f();
  }
  
  public void b(SurfaceTexture paramSurfaceTexture) {
    this.c.d();
  }
  
  protected void finalize() throws Throwable {
    try {
      if (this.c != null)
        this.c.h(); 
      return;
    } finally {
      super.finalize();
    } 
  }
  
  public int getDebugFlags() {
    return this.j;
  }
  
  public boolean getPreserveEGLContextOnPause() {
    return this.l;
  }
  
  public int getRenderMode() {
    return this.c.b();
  }
  
  public void h() {
    this.c.c();
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onAttachedToWindow reattach =");
    stringBuilder.append(this.e);
    Log.d("GLTextureView", stringBuilder.toString());
    if (this.e && this.d != null) {
      boolean bool;
      GLThread gLThread = this.c;
      if (gLThread != null) {
        bool = gLThread.b();
      } else {
        bool = true;
      } 
      this.c = new GLThread(this.b);
      if (bool != true)
        this.c.a(bool); 
      this.c.start();
    } 
    this.e = false;
  }
  
  protected void onDetachedFromWindow() {
    Log.d("GLTextureView", "onDetachedFromWindow");
    GLThread gLThread = this.c;
    if (gLThread != null)
      gLThread.h(); 
    this.e = true;
    super.onDetachedFromWindow();
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
    a(getSurfaceTexture(), 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {
    b(paramSurfaceTexture);
    a(paramSurfaceTexture, 0, paramInt1, paramInt2);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture) {
    a(paramSurfaceTexture);
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {
    a(paramSurfaceTexture, 0, paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {
    h();
  }
  
  public void setDebugFlags(int paramInt) {
    this.j = paramInt;
  }
  
  public void setEGLConfigChooser(EGLConfigChooser paramEGLConfigChooser) {
    d();
    this.f = paramEGLConfigChooser;
  }
  
  public void setEGLConfigChooser(boolean paramBoolean) {
    setEGLConfigChooser(new SimpleEGLConfigChooser(this, paramBoolean));
  }
  
  public void setEGLContextClientVersion(int paramInt) {
    d();
    this.k = paramInt;
  }
  
  public void setEGLContextFactory(EGLContextFactory paramEGLContextFactory) {
    d();
    this.g = paramEGLContextFactory;
  }
  
  public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory paramEGLWindowSurfaceFactory) {
    d();
    this.h = paramEGLWindowSurfaceFactory;
  }
  
  public void setGLWrapper(GLWrapper paramGLWrapper) {
    this.i = paramGLWrapper;
  }
  
  public void setPreserveEGLContextOnPause(boolean paramBoolean) {
    this.l = paramBoolean;
  }
  
  public void setRenderMode(int paramInt) {
    this.c.a(paramInt);
  }
  
  public void setRenderer(Renderer paramRenderer) {
    d();
    if (this.f == null)
      this.f = new SimpleEGLConfigChooser(this, true); 
    if (this.g == null)
      this.g = new DefaultContextFactory(); 
    if (this.h == null)
      this.h = new DefaultWindowSurfaceFactory(); 
    this.d = paramRenderer;
    this.c = new GLThread(this.b);
    this.c.start();
  }
  
  abstract class BaseConfigChooser implements EGLConfigChooser {
    protected int[] a;
    
    public BaseConfigChooser(GLTextureView this$0, int[] param1ArrayOfint) {
      this.a = a(param1ArrayOfint);
    }
    
    private int[] a(int[] param1ArrayOfint) {
      if (GLTextureView.a(this.b) != 2)
        return param1ArrayOfint; 
      int i = param1ArrayOfint.length;
      int[] arrayOfInt = new int[i + 2];
      int j = i - 1;
      System.arraycopy(param1ArrayOfint, 0, arrayOfInt, 0, j);
      arrayOfInt[j] = 12352;
      arrayOfInt[i] = 4;
      arrayOfInt[i + 1] = 12344;
      return arrayOfInt;
    }
    
    public EGLConfig a(EGL10 param1EGL10, EGLDisplay param1EGLDisplay) {
      int[] arrayOfInt = new int[1];
      if (param1EGL10.eglChooseConfig(param1EGLDisplay, this.a, null, 0, arrayOfInt)) {
        int i = arrayOfInt[0];
        if (i > 0) {
          EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
          if (param1EGL10.eglChooseConfig(param1EGLDisplay, this.a, arrayOfEGLConfig, i, arrayOfInt)) {
            EGLConfig eGLConfig = a(param1EGL10, param1EGLDisplay, arrayOfEGLConfig);
            if (eGLConfig != null)
              return eGLConfig; 
            throw new IllegalArgumentException("No config chosen");
          } 
          throw new IllegalArgumentException("eglChooseConfig#2 failed");
        } 
        throw new IllegalArgumentException("No configs match configSpec");
      } 
      throw new IllegalArgumentException("eglChooseConfig failed");
    }
    
    abstract EGLConfig a(EGL10 param1EGL10, EGLDisplay param1EGLDisplay, EGLConfig[] param1ArrayOfEGLConfig);
  }
  
  class ComponentSizeChooser extends BaseConfigChooser {
    protected int c;
    
    protected int d;
    
    protected int e;
    
    protected int f;
    
    protected int g;
    
    protected int h;
    
    private int[] j = new int[1];
    
    public ComponentSizeChooser(GLTextureView this$0, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6) {
      super(this$0, new int[] { 
            12324, param1Int1, 12323, param1Int2, 12322, param1Int3, 12321, param1Int4, 12325, param1Int5, 
            12326, param1Int6, 12344 });
      this.c = param1Int1;
      this.d = param1Int2;
      this.e = param1Int3;
      this.f = param1Int4;
      this.g = param1Int5;
      this.h = param1Int6;
    }
    
    private int a(EGL10 param1EGL10, EGLDisplay param1EGLDisplay, EGLConfig param1EGLConfig, int param1Int1, int param1Int2) {
      return param1EGL10.eglGetConfigAttrib(param1EGLDisplay, param1EGLConfig, param1Int1, this.j) ? this.j[0] : param1Int2;
    }
    
    public EGLConfig a(EGL10 param1EGL10, EGLDisplay param1EGLDisplay, EGLConfig[] param1ArrayOfEGLConfig) {
      int j = param1ArrayOfEGLConfig.length;
      int i;
      for (i = 0; i < j; i++) {
        EGLConfig eGLConfig = param1ArrayOfEGLConfig[i];
        int k = a(param1EGL10, param1EGLDisplay, eGLConfig, 12325, 0);
        int m = a(param1EGL10, param1EGLDisplay, eGLConfig, 12326, 0);
        if (k >= this.g && m >= this.h) {
          k = a(param1EGL10, param1EGLDisplay, eGLConfig, 12324, 0);
          m = a(param1EGL10, param1EGLDisplay, eGLConfig, 12323, 0);
          int n = a(param1EGL10, param1EGLDisplay, eGLConfig, 12322, 0);
          int i1 = a(param1EGL10, param1EGLDisplay, eGLConfig, 12321, 0);
          if (k == this.c && m == this.d && n == this.e && i1 == this.f)
            return eGLConfig; 
        } 
      } 
      return null;
    }
  }
  
  class DefaultContextFactory implements EGLContextFactory {
    private int b = 12440;
    
    private DefaultContextFactory(GLTextureView this$0) {}
    
    public EGLContext a(EGL10 param1EGL10, EGLDisplay param1EGLDisplay, EGLConfig param1EGLConfig) {
      int[] arrayOfInt = new int[3];
      arrayOfInt[0] = this.b;
      arrayOfInt[1] = GLTextureView.a(this.a);
      arrayOfInt[2] = 12344;
      EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
      if (GLTextureView.a(this.a) == 0)
        arrayOfInt = null; 
      return param1EGL10.eglCreateContext(param1EGLDisplay, param1EGLConfig, eGLContext, arrayOfInt);
    }
    
    public void a(EGL10 param1EGL10, EGLDisplay param1EGLDisplay, EGLContext param1EGLContext) {
      if (!param1EGL10.eglDestroyContext(param1EGLDisplay, param1EGLContext)) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("display:");
        stringBuilder2.append(param1EGLDisplay);
        stringBuilder2.append(" context: ");
        stringBuilder2.append(param1EGLContext);
        Log.e("DefaultContextFactory", stringBuilder2.toString());
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("tid=");
        stringBuilder1.append(Thread.currentThread().getId());
        Log.i("DefaultContextFactory", stringBuilder1.toString());
        GLTextureView.EglHelper.a("eglDestroyContex", param1EGL10.eglGetError());
      } 
    }
  }
  
  static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
    private DefaultWindowSurfaceFactory() {}
    
    public EGLSurface a(EGL10 param1EGL10, EGLDisplay param1EGLDisplay, EGLConfig param1EGLConfig, Object param1Object) {
      try {
        return param1EGL10.eglCreateWindowSurface(param1EGLDisplay, param1EGLConfig, param1Object, null);
      } catch (IllegalArgumentException illegalArgumentException) {
        Log.e("GLTextureView", "eglCreateWindowSurface", illegalArgumentException);
        return null;
      } 
    }
    
    public void a(EGL10 param1EGL10, EGLDisplay param1EGLDisplay, EGLSurface param1EGLSurface) {
      param1EGL10.eglDestroySurface(param1EGLDisplay, param1EGLSurface);
    }
  }
  
  public static interface EGLConfigChooser {
    EGLConfig a(EGL10 param1EGL10, EGLDisplay param1EGLDisplay);
  }
  
  public static interface EGLContextFactory {
    EGLContext a(EGL10 param1EGL10, EGLDisplay param1EGLDisplay, EGLConfig param1EGLConfig);
    
    void a(EGL10 param1EGL10, EGLDisplay param1EGLDisplay, EGLContext param1EGLContext);
  }
  
  public static interface EGLWindowSurfaceFactory {
    EGLSurface a(EGL10 param1EGL10, EGLDisplay param1EGLDisplay, EGLConfig param1EGLConfig, Object param1Object);
    
    void a(EGL10 param1EGL10, EGLDisplay param1EGLDisplay, EGLSurface param1EGLSurface);
  }
  
  static class EglHelper {
    EGL10 a;
    
    EGLDisplay b;
    
    EGLSurface c;
    
    EGLConfig d;
    
    EGLContext e;
    
    private WeakReference<GLTextureView> f;
    
    public EglHelper(WeakReference<GLTextureView> param1WeakReference) {
      this.f = param1WeakReference;
    }
    
    private void a(String param1String) {
      a(param1String, this.a.eglGetError());
    }
    
    public static void a(String param1String, int param1Int) {
      param1String = b(param1String, param1Int);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("throwEglException tid=");
      stringBuilder.append(Thread.currentThread().getId());
      stringBuilder.append(" ");
      stringBuilder.append(param1String);
      Log.e("EglHelper", stringBuilder.toString());
      throw new RuntimeException(param1String);
    }
    
    public static void a(String param1String1, String param1String2, int param1Int) {
      Log.w(param1String1, b(param1String2, param1Int));
    }
    
    public static String b(String param1String, int param1Int) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1String);
      stringBuilder.append(" failed: ");
      stringBuilder.append(param1Int);
      return stringBuilder.toString();
    }
    
    private void g() {
      EGLSurface eGLSurface = this.c;
      if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
        this.a.eglMakeCurrent(this.b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        GLTextureView gLTextureView = this.f.get();
        if (gLTextureView != null)
          GLTextureView.d(gLTextureView).a(this.a, this.b, this.c); 
        this.c = null;
      } 
    }
    
    public void a() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("start() tid=");
      stringBuilder.append(Thread.currentThread().getId());
      Log.w("EglHelper", stringBuilder.toString());
      this.a = (EGL10)EGLContext.getEGL();
      this.b = this.a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      if (this.b != EGL10.EGL_NO_DISPLAY) {
        int[] arrayOfInt = new int[2];
        if (this.a.eglInitialize(this.b, arrayOfInt)) {
          GLTextureView gLTextureView = this.f.get();
          if (gLTextureView == null) {
            this.d = null;
            this.e = null;
          } else {
            this.d = GLTextureView.b(gLTextureView).a(this.a, this.b);
            this.e = GLTextureView.c(gLTextureView).a(this.a, this.b, this.d);
          } 
          EGLContext eGLContext = this.e;
          if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
            this.e = null;
            a("createContext");
          } 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("createContext ");
          stringBuilder1.append(this.e);
          stringBuilder1.append(" tid=");
          stringBuilder1.append(Thread.currentThread().getId());
          Log.w("EglHelper", stringBuilder1.toString());
          this.c = null;
          return;
        } 
        throw new RuntimeException("eglInitialize failed");
      } 
      throw new RuntimeException("eglGetDisplay failed");
    }
    
    public boolean b() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("createSurface()  tid=");
      stringBuilder.append(Thread.currentThread().getId());
      Log.w("EglHelper", stringBuilder.toString());
      if (this.a != null) {
        if (this.b != null) {
          if (this.d != null) {
            g();
            GLTextureView gLTextureView = this.f.get();
            if (gLTextureView != null) {
              this.c = GLTextureView.d(gLTextureView).a(this.a, this.b, this.d, gLTextureView.getSurfaceTexture());
            } else {
              this.c = null;
            } 
            EGLSurface eGLSurface1 = this.c;
            if (eGLSurface1 == null || eGLSurface1 == EGL10.EGL_NO_SURFACE) {
              if (this.a.eglGetError() == 12299)
                Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW."); 
              return false;
            } 
            EGL10 eGL10 = this.a;
            EGLDisplay eGLDisplay = this.b;
            EGLSurface eGLSurface2 = this.c;
            if (!eGL10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.e)) {
              a("EGLHelper", "eglMakeCurrent", this.a.eglGetError());
              return false;
            } 
            return true;
          } 
          throw new RuntimeException("mEglConfig not initialized");
        } 
        throw new RuntimeException("eglDisplay not initialized");
      } 
      throw new RuntimeException("egl not initialized");
    }
    
    GL c() {
      GL gL2 = this.e.getGL();
      GLTextureView gLTextureView = this.f.get();
      GL gL1 = gL2;
      if (gLTextureView != null) {
        GL gL = gL2;
        if (GLTextureView.e(gLTextureView) != null)
          gL = GLTextureView.e(gLTextureView).a(gL2); 
        gL1 = gL;
        if ((GLTextureView.f(gLTextureView) & 0x3) != 0) {
          GLTextureView.LogWriter logWriter;
          boolean bool = false;
          gL1 = null;
          if ((GLTextureView.f(gLTextureView) & 0x1) != 0)
            bool = true; 
          if ((GLTextureView.f(gLTextureView) & 0x2) != 0)
            logWriter = new GLTextureView.LogWriter(); 
          gL1 = GLDebugHelper.wrap(gL, bool, logWriter);
        } 
      } 
      return gL1;
    }
    
    public int d() {
      return !this.a.eglSwapBuffers(this.b, this.c) ? this.a.eglGetError() : 12288;
    }
    
    public void e() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("destroySurface()  tid=");
      stringBuilder.append(Thread.currentThread().getId());
      Log.w("EglHelper", stringBuilder.toString());
      g();
    }
    
    public void f() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("finish() tid=");
      stringBuilder.append(Thread.currentThread().getId());
      Log.w("EglHelper", stringBuilder.toString());
      if (this.e != null) {
        GLTextureView gLTextureView = this.f.get();
        if (gLTextureView != null)
          GLTextureView.c(gLTextureView).a(this.a, this.b, this.e); 
        this.e = null;
      } 
      EGLDisplay eGLDisplay = this.b;
      if (eGLDisplay != null) {
        this.a.eglTerminate(eGLDisplay);
        this.b = null;
      } 
    }
  }
  
  static class GLThread extends Thread {
    private boolean a;
    
    private boolean b;
    
    private boolean c;
    
    private boolean d;
    
    private boolean e;
    
    private boolean f;
    
    private boolean g;
    
    private boolean h;
    
    private boolean i;
    
    private boolean j;
    
    private int k = 0;
    
    private int l = 0;
    
    private int m = 1;
    
    private boolean n = true;
    
    private boolean o;
    
    private ArrayList<Runnable> p = new ArrayList<Runnable>();
    
    private boolean q = true;
    
    private GLTextureView.EglHelper r;
    
    private WeakReference<GLTextureView> s;
    
    GLThread(WeakReference<GLTextureView> param1WeakReference) {
      this.s = param1WeakReference;
    }
    
    private void j() {
      if (this.i) {
        this.i = false;
        this.r.e();
      } 
    }
    
    private void k() {
      if (this.h) {
        this.r.f();
        this.h = false;
        GLTextureView.j().c(this);
      } 
    }
    
    private void l() throws InterruptedException {
      // Byte code:
      //   0: aload_0
      //   1: astore #22
      //   3: aload #22
      //   5: new com/blued/android/module/video_gift/GLTextureView$EglHelper
      //   8: dup
      //   9: aload #22
      //   11: getfield s : Ljava/lang/ref/WeakReference;
      //   14: invokespecial <init> : (Ljava/lang/ref/WeakReference;)V
      //   17: putfield r : Lcom/blued/android/module/video_gift/GLTextureView$EglHelper;
      //   20: aload #22
      //   22: iconst_0
      //   23: putfield h : Z
      //   26: aload #22
      //   28: iconst_0
      //   29: putfield i : Z
      //   32: iconst_0
      //   33: istore #10
      //   35: iconst_0
      //   36: istore #11
      //   38: aconst_null
      //   39: astore #21
      //   41: iconst_0
      //   42: istore #9
      //   44: aconst_null
      //   45: astore #23
      //   47: iconst_0
      //   48: istore #6
      //   50: iconst_0
      //   51: istore_3
      //   52: iconst_0
      //   53: istore #5
      //   55: iconst_0
      //   56: istore_2
      //   57: iconst_0
      //   58: istore #4
      //   60: iconst_0
      //   61: istore #8
      //   63: iconst_0
      //   64: istore_1
      //   65: aload #22
      //   67: astore #24
      //   69: invokestatic j : ()Lcom/blued/android/module/video_gift/GLTextureView$GLThreadManager;
      //   72: astore #25
      //   74: aload #22
      //   76: astore #24
      //   78: aload #25
      //   80: monitorenter
      //   81: iload_1
      //   82: istore #12
      //   84: iload #4
      //   86: istore_1
      //   87: iload_2
      //   88: istore #15
      //   90: iload #5
      //   92: istore_2
      //   93: iload_3
      //   94: istore #4
      //   96: iload #11
      //   98: istore #5
      //   100: iload #10
      //   102: istore_3
      //   103: aload #22
      //   105: getfield a : Z
      //   108: ifeq -> 142
      //   111: aload #25
      //   113: monitorexit
      //   114: invokestatic j : ()Lcom/blued/android/module/video_gift/GLTextureView$GLThreadManager;
      //   117: astore #21
      //   119: aload #21
      //   121: monitorenter
      //   122: aload_0
      //   123: invokespecial j : ()V
      //   126: aload_0
      //   127: invokespecial k : ()V
      //   130: aload #21
      //   132: monitorexit
      //   133: return
      //   134: astore #22
      //   136: aload #21
      //   138: monitorexit
      //   139: aload #22
      //   141: athrow
      //   142: aload #22
      //   144: getfield p : Ljava/util/ArrayList;
      //   147: invokevirtual isEmpty : ()Z
      //   150: ifne -> 200
      //   153: aload #22
      //   155: getfield p : Ljava/util/ArrayList;
      //   158: iconst_0
      //   159: invokevirtual remove : (I)Ljava/lang/Object;
      //   162: checkcast java/lang/Runnable
      //   165: astore #23
      //   167: iload_3
      //   168: istore #10
      //   170: iload #5
      //   172: istore #11
      //   174: iload #9
      //   176: istore #13
      //   178: iload #6
      //   180: istore_3
      //   181: iload #4
      //   183: istore #7
      //   185: iload_2
      //   186: istore #5
      //   188: iload #15
      //   190: istore_2
      //   191: iload_1
      //   192: istore #4
      //   194: iload #12
      //   196: istore_1
      //   197: goto -> 1171
      //   200: aload #22
      //   202: getfield d : Z
      //   205: aload #22
      //   207: getfield c : Z
      //   210: if_icmpeq -> 2063
      //   213: aload #22
      //   215: getfield c : Z
      //   218: istore #19
      //   220: aload #22
      //   222: aload #22
      //   224: getfield c : Z
      //   227: putfield d : Z
      //   230: invokestatic j : ()Lcom/blued/android/module/video_gift/GLTextureView$GLThreadManager;
      //   233: invokevirtual notifyAll : ()V
      //   236: new java/lang/StringBuilder
      //   239: dup
      //   240: invokespecial <init> : ()V
      //   243: astore #24
      //   245: aload #24
      //   247: ldc 'mPaused is now '
      //   249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   252: pop
      //   253: aload #24
      //   255: aload #22
      //   257: getfield d : Z
      //   260: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   263: pop
      //   264: aload #24
      //   266: ldc ' tid='
      //   268: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   271: pop
      //   272: aload #24
      //   274: aload_0
      //   275: invokevirtual getId : ()J
      //   278: invokevirtual append : (J)Ljava/lang/StringBuilder;
      //   281: pop
      //   282: ldc 'GLThread'
      //   284: aload #24
      //   286: invokevirtual toString : ()Ljava/lang/String;
      //   289: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
      //   292: pop
      //   293: goto -> 296
      //   296: iload #5
      //   298: istore #13
      //   300: aload #22
      //   302: getfield j : Z
      //   305: ifeq -> 2069
      //   308: new java/lang/StringBuilder
      //   311: dup
      //   312: invokespecial <init> : ()V
      //   315: astore #24
      //   317: aload #24
      //   319: ldc 'releasing EGL context because asked to tid='
      //   321: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   324: pop
      //   325: aload #24
      //   327: aload_0
      //   328: invokevirtual getId : ()J
      //   331: invokevirtual append : (J)Ljava/lang/StringBuilder;
      //   334: pop
      //   335: ldc 'GLThread'
      //   337: aload #24
      //   339: invokevirtual toString : ()Ljava/lang/String;
      //   342: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
      //   345: pop
      //   346: aload_0
      //   347: invokespecial j : ()V
      //   350: aload_0
      //   351: invokespecial k : ()V
      //   354: aload #22
      //   356: iconst_0
      //   357: putfield j : Z
      //   360: iconst_1
      //   361: istore #7
      //   363: goto -> 366
      //   366: iload #15
      //   368: istore #10
      //   370: iload #15
      //   372: ifeq -> 386
      //   375: aload_0
      //   376: invokespecial j : ()V
      //   379: aload_0
      //   380: invokespecial k : ()V
      //   383: iconst_0
      //   384: istore #10
      //   386: iload #19
      //   388: ifeq -> 2075
      //   391: aload #22
      //   393: getfield i : Z
      //   396: ifeq -> 2075
      //   399: new java/lang/StringBuilder
      //   402: dup
      //   403: invokespecial <init> : ()V
      //   406: astore #24
      //   408: aload #24
      //   410: ldc 'releasing EGL surface because paused tid='
      //   412: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   415: pop
      //   416: aload #24
      //   418: aload_0
      //   419: invokevirtual getId : ()J
      //   422: invokevirtual append : (J)Ljava/lang/StringBuilder;
      //   425: pop
      //   426: ldc 'GLThread'
      //   428: aload #24
      //   430: invokevirtual toString : ()Ljava/lang/String;
      //   433: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
      //   436: pop
      //   437: aload_0
      //   438: invokespecial j : ()V
      //   441: goto -> 444
      //   444: iload #19
      //   446: ifeq -> 544
      //   449: aload #22
      //   451: getfield h : Z
      //   454: ifeq -> 544
      //   457: aload #22
      //   459: getfield s : Ljava/lang/ref/WeakReference;
      //   462: invokevirtual get : ()Ljava/lang/Object;
      //   465: checkcast com/blued/android/module/video_gift/GLTextureView
      //   468: astore #24
      //   470: aload #24
      //   472: ifnonnull -> 481
      //   475: iconst_0
      //   476: istore #20
      //   478: goto -> 488
      //   481: aload #24
      //   483: invokestatic g : (Lcom/blued/android/module/video_gift/GLTextureView;)Z
      //   486: istore #20
      //   488: iload #20
      //   490: ifeq -> 502
      //   493: invokestatic j : ()Lcom/blued/android/module/video_gift/GLTextureView$GLThreadManager;
      //   496: invokevirtual a : ()Z
      //   499: ifeq -> 544
      //   502: aload_0
      //   503: invokespecial k : ()V
      //   506: new java/lang/StringBuilder
      //   509: dup
      //   510: invokespecial <init> : ()V
      //   513: astore #24
      //   515: aload #24
      //   517: ldc 'releasing EGL context because paused tid='
      //   519: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   522: pop
      //   523: aload #24
      //   525: aload_0
      //   526: invokevirtual getId : ()J
      //   529: invokevirtual append : (J)Ljava/lang/StringBuilder;
      //   532: pop
      //   533: ldc 'GLThread'
      //   535: aload #24
      //   537: invokevirtual toString : ()Ljava/lang/String;
      //   540: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
      //   543: pop
      //   544: iload #19
      //   546: ifeq -> 604
      //   549: invokestatic j : ()Lcom/blued/android/module/video_gift/GLTextureView$GLThreadManager;
      //   552: invokevirtual b : ()Z
      //   555: ifeq -> 604
      //   558: aload #22
      //   560: getfield r : Lcom/blued/android/module/video_gift/GLTextureView$EglHelper;
      //   563: invokevirtual f : ()V
      //   566: new java/lang/StringBuilder
      //   569: dup
      //   570: invokespecial <init> : ()V
      //   573: astore #24
      //   575: aload #24
      //   577: ldc 'terminating EGL because paused tid='
      //   579: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   582: pop
      //   583: aload #24
      //   585: aload_0
      //   586: invokevirtual getId : ()J
      //   589: invokevirtual append : (J)Ljava/lang/StringBuilder;
      //   592: pop
      //   593: ldc 'GLThread'
      //   595: aload #24
      //   597: invokevirtual toString : ()Ljava/lang/String;
      //   600: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
      //   603: pop
      //   604: aload #22
      //   606: getfield e : Z
      //   609: ifne -> 688
      //   612: aload #22
      //   614: getfield g : Z
      //   617: ifne -> 688
      //   620: new java/lang/StringBuilder
      //   623: dup
      //   624: invokespecial <init> : ()V
      //   627: astore #24
      //   629: aload #24
      //   631: ldc 'noticed surfaceView surface lost tid='
      //   633: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   636: pop
      //   637: aload #24
      //   639: aload_0
      //   640: invokevirtual getId : ()J
      //   643: invokevirtual append : (J)Ljava/lang/StringBuilder;
      //   646: pop
      //   647: ldc 'GLThread'
      //   649: aload #24
      //   651: invokevirtual toString : ()Ljava/lang/String;
      //   654: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
      //   657: pop
      //   658: aload #22
      //   660: getfield i : Z
      //   663: ifeq -> 670
      //   666: aload_0
      //   667: invokespecial j : ()V
      //   670: aload #22
      //   672: iconst_1
      //   673: putfield g : Z
      //   676: aload #22
      //   678: iconst_0
      //   679: putfield f : Z
      //   682: invokestatic j : ()Lcom/blued/android/module/video_gift/GLTextureView$GLThreadManager;
      //   685: invokevirtual notifyAll : ()V
      //   688: aload #22
      //   690: getfield e : Z
      //   693: ifeq -> 754
      //   696: aload #22
      //   698: getfield g : Z
      //   701: ifeq -> 754
      //   704: new java/lang/StringBuilder
      //   707: dup
      //   708: invokespecial <init> : ()V
      //   711: astore #24
      //   713: aload #24
      //   715: ldc 'noticed surfaceView surface acquired tid='
      //   717: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   720: pop
      //   721: aload #24
      //   723: aload_0
      //   724: invokevirtual getId : ()J
      //   727: invokevirtual append : (J)Ljava/lang/StringBuilder;
      //   730: pop
      //   731: ldc 'GLThread'
      //   733: aload #24
      //   735: invokevirtual toString : ()Ljava/lang/String;
      //   738: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
      //   741: pop
      //   742: aload #22
      //   744: iconst_0
      //   745: putfield g : Z
      //   748: invokestatic j : ()Lcom/blued/android/module/video_gift/GLTextureView$GLThreadManager;
      //   751: invokevirtual notifyAll : ()V
      //   754: iload #8
      //   756: istore #14
      //   758: iload #12
      //   760: istore #11
      //   762: iload #12
      //   764: ifeq -> 823
      //   767: new java/lang/StringBuilder
      //   770: dup
      //   771: invokespecial <init> : ()V
      //   774: astore #24
      //   776: aload #24
      //   778: ldc 'sending render notification tid='
      //   780: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   783: pop
      //   784: aload #24
      //   786: aload_0
      //   787: invokevirtual getId : ()J
      //   790: invokevirtual append : (J)Ljava/lang/StringBuilder;
      //   793: pop
      //   794: ldc 'GLThread'
      //   796: aload #24
      //   798: invokevirtual toString : ()Ljava/lang/String;
      //   801: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
      //   804: pop
      //   805: aload #22
      //   807: iconst_1
      //   808: putfield o : Z
      //   811: invokestatic j : ()Lcom/blued/android/module/video_gift/GLTextureView$GLThreadManager;
      //   814: invokevirtual notifyAll : ()V
      //   817: iconst_0
      //   818: istore #14
      //   820: iconst_0
      //   821: istore #11
      //   823: aload_0
      //   824: invokespecial m : ()Z
      //   827: istore #19
      //   829: iload #7
      //   831: istore #12
      //   833: iload #6
      //   835: istore #15
      //   837: iload #4
      //   839: istore #17
      //   841: iload_2
      //   842: istore #18
      //   844: iload_1
      //   845: istore #16
      //   847: iload #19
      //   849: ifeq -> 1747
      //   852: aload #22
      //   854: getfield h : Z
      //   857: istore #19
      //   859: iload #7
      //   861: istore #5
      //   863: iload #6
      //   865: istore_3
      //   866: iload #19
      //   868: ifne -> 949
      //   871: iload #7
      //   873: ifeq -> 885
      //   876: iconst_0
      //   877: istore #5
      //   879: iload #6
      //   881: istore_3
      //   882: goto -> 949
      //   885: invokestatic j : ()Lcom/blued/android/module/video_gift/GLTextureView$GLThreadManager;
      //   888: aload #22
      //   890: invokevirtual b : (Lcom/blued/android/module/video_gift/GLTextureView$GLThread;)Z
      //   893: istore #19
      //   895: iload #7
      //   897: istore #5
      //   899: iload #6
      //   901: istore_3
      //   902: iload #19
      //   904: ifeq -> 949
      //   907: aload #22
      //   909: getfield r : Lcom/blued/android/module/video_gift/GLTextureView$EglHelper;
      //   912: invokevirtual a : ()V
      //   915: aload #22
      //   917: iconst_1
      //   918: putfield h : Z
      //   921: invokestatic j : ()Lcom/blued/android/module/video_gift/GLTextureView$GLThreadManager;
      //   924: invokevirtual notifyAll : ()V
      //   927: iconst_1
      //   928: istore_3
      //   929: iload #7
      //   931: istore #5
      //   933: goto -> 949
      //   936: astore #21
      //   938: invokestatic j : ()Lcom/blued/android/module/video_gift/GLTextureView$GLThreadManager;
      //   941: aload #22
      //   943: invokevirtual c : (Lcom/blued/android/module/video_gift/GLTextureView$GLThread;)V
      //   946: aload #21
      //   948: athrow
      //   949: aload #22
      //   951: getfield h : Z
      //   954: istore #19
      //   956: iload #4
      //   958: istore #8
      //   960: iload_2
      //   961: istore #6
      //   963: iload_1
      //   964: istore #7
      //   966: iload #19
      //   968: ifeq -> 1004
      //   971: iload #4
      //   973: istore #8
      //   975: iload_2
      //   976: istore #6
      //   978: iload_1
      //   979: istore #7
      //   981: aload #22
      //   983: getfield i : Z
      //   986: ifne -> 1004
      //   989: aload #22
      //   991: iconst_1
      //   992: putfield i : Z
      //   995: iconst_1
      //   996: istore #8
      //   998: iconst_1
      //   999: istore #6
      //   1001: iconst_1
      //   1002: istore #7
      //   1004: iload #5
      //   1006: istore #12
      //   1008: iload_3
      //   1009: istore #15
      //   1011: iload #8
      //   1013: istore #17
      //   1015: iload #6
      //   1017: istore #18
      //   1019: iload #7
      //   1021: istore #16
      //   1023: aload #22
      //   1025: getfield i : Z
      //   1028: ifeq -> 1747
      //   1031: aload #22
      //   1033: getfield q : Z
      //   1036: istore #19
      //   1038: iload #19
      //   1040: ifeq -> 1113
      //   1043: aload #22
      //   1045: getfield k : I
      //   1048: istore #9
      //   1050: aload #22
      //   1052: getfield l : I
      //   1055: istore #12
      //   1057: new java/lang/StringBuilder
      //   1060: dup
      //   1061: invokespecial <init> : ()V
      //   1064: astore #24
      //   1066: aload #24
      //   1068: ldc 'noticing that we want render notification tid='
      //   1070: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1073: pop
      //   1074: aload #24
      //   1076: aload_0
      //   1077: invokevirtual getId : ()J
      //   1080: invokevirtual append : (J)Ljava/lang/StringBuilder;
      //   1083: pop
      //   1084: ldc 'GLThread'
      //   1086: aload #24
      //   1088: invokevirtual toString : ()Ljava/lang/String;
      //   1091: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
      //   1094: pop
      //   1095: aload #22
      //   1097: iconst_0
      //   1098: putfield q : Z
      //   1101: iconst_1
      //   1102: istore #7
      //   1104: iconst_1
      //   1105: istore #4
      //   1107: iconst_1
      //   1108: istore #14
      //   1110: goto -> 1129
      //   1113: iload #7
      //   1115: istore #4
      //   1117: iload #8
      //   1119: istore #7
      //   1121: iload #9
      //   1123: istore #12
      //   1125: iload #13
      //   1127: istore #9
      //   1129: aload #22
      //   1131: iconst_0
      //   1132: putfield n : Z
      //   1135: invokestatic j : ()Lcom/blued/android/module/video_gift/GLTextureView$GLThreadManager;
      //   1138: invokevirtual notifyAll : ()V
      //   1141: iload #5
      //   1143: istore #15
      //   1145: iload #11
      //   1147: istore_1
      //   1148: iload #14
      //   1150: istore #8
      //   1152: iload #10
      //   1154: istore_2
      //   1155: iload #6
      //   1157: istore #5
      //   1159: iload #12
      //   1161: istore #13
      //   1163: iload #9
      //   1165: istore #11
      //   1167: iload #15
      //   1169: istore #10
      //   1171: aload #25
      //   1173: monitorexit
      //   1174: aload #23
      //   1176: ifnull -> 1206
      //   1179: aload #22
      //   1181: astore #24
      //   1183: aload #23
      //   1185: invokeinterface run : ()V
      //   1190: aconst_null
      //   1191: astore #23
      //   1193: iload #13
      //   1195: istore #9
      //   1197: iload_3
      //   1198: istore #6
      //   1200: iload #7
      //   1202: istore_3
      //   1203: goto -> 65
      //   1206: iload #7
      //   1208: istore #12
      //   1210: iload #7
      //   1212: ifeq -> 1298
      //   1215: aload #22
      //   1217: astore #24
      //   1219: ldc 'GLThread'
      //   1221: ldc 'egl createSurface'
      //   1223: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
      //   1226: pop
      //   1227: aload #22
      //   1229: astore #24
      //   1231: aload #22
      //   1233: getfield r : Lcom/blued/android/module/video_gift/GLTextureView$EglHelper;
      //   1236: invokevirtual b : ()Z
      //   1239: ifne -> 2078
      //   1242: aload #22
      //   1244: astore #24
      //   1246: invokestatic j : ()Lcom/blued/android/module/video_gift/GLTextureView$GLThreadManager;
      //   1249: astore #25
      //   1251: aload #22
      //   1253: astore #24
      //   1255: aload #25
      //   1257: monitorenter
      //   1258: aload #22
      //   1260: iconst_1
      //   1261: putfield f : Z
      //   1264: invokestatic j : ()Lcom/blued/android/module/video_gift/GLTextureView$GLThreadManager;
      //   1267: invokevirtual notifyAll : ()V
      //   1270: aload #25
      //   1272: monitorexit
      //   1273: iload #13
      //   1275: istore #9
      //   1277: iload_3
      //   1278: istore #6
      //   1280: iload #7
      //   1282: istore_3
      //   1283: goto -> 65
      //   1286: astore #21
      //   1288: aload #25
      //   1290: monitorexit
      //   1291: aload #22
      //   1293: astore #24
      //   1295: aload #21
      //   1297: athrow
      //   1298: iload #5
      //   1300: ifeq -> 2084
      //   1303: aload #22
      //   1305: astore #24
      //   1307: aload #22
      //   1309: getfield r : Lcom/blued/android/module/video_gift/GLTextureView$EglHelper;
      //   1312: invokevirtual c : ()Ljavax/microedition/khronos/opengles/GL;
      //   1315: checkcast javax/microedition/khronos/opengles/GL10
      //   1318: astore #21
      //   1320: aload #22
      //   1322: astore #24
      //   1324: invokestatic j : ()Lcom/blued/android/module/video_gift/GLTextureView$GLThreadManager;
      //   1327: aload #21
      //   1329: invokevirtual a : (Ljavax/microedition/khronos/opengles/GL10;)V
      //   1332: iconst_0
      //   1333: istore #5
      //   1335: goto -> 1338
      //   1338: iload_3
      //   1339: istore #6
      //   1341: iload_3
      //   1342: ifeq -> 1406
      //   1345: aload #22
      //   1347: astore #24
      //   1349: ldc 'GLThread'
      //   1351: ldc 'onSurfaceCreated'
      //   1353: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
      //   1356: pop
      //   1357: aload #22
      //   1359: astore #24
      //   1361: aload #22
      //   1363: getfield s : Ljava/lang/ref/WeakReference;
      //   1366: invokevirtual get : ()Ljava/lang/Object;
      //   1369: checkcast com/blued/android/module/video_gift/GLTextureView
      //   1372: astore #25
      //   1374: aload #25
      //   1376: ifnull -> 2087
      //   1379: aload #22
      //   1381: astore #24
      //   1383: aload #25
      //   1385: invokestatic h : (Lcom/blued/android/module/video_gift/GLTextureView;)Lcom/blued/android/module/video_gift/GLTextureView$Renderer;
      //   1388: aload #21
      //   1390: aload #22
      //   1392: getfield r : Lcom/blued/android/module/video_gift/GLTextureView$EglHelper;
      //   1395: getfield d : Ljavax/microedition/khronos/egl/EGLConfig;
      //   1398: invokeinterface a : (Ljavax/microedition/khronos/opengles/GL10;Ljavax/microedition/khronos/egl/EGLConfig;)V
      //   1403: goto -> 2087
      //   1406: iload #4
      //   1408: istore #7
      //   1410: iload #4
      //   1412: ifeq -> 1548
      //   1415: aload #22
      //   1417: astore #24
      //   1419: new java/lang/StringBuilder
      //   1422: dup
      //   1423: invokespecial <init> : ()V
      //   1426: astore #25
      //   1428: aload #22
      //   1430: astore #24
      //   1432: aload #25
      //   1434: ldc 'onSurfaceChanged('
      //   1436: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1439: pop
      //   1440: aload #22
      //   1442: astore #24
      //   1444: aload #25
      //   1446: iload #11
      //   1448: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   1451: pop
      //   1452: aload #22
      //   1454: astore #24
      //   1456: aload #25
      //   1458: ldc ', '
      //   1460: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1463: pop
      //   1464: aload #22
      //   1466: astore #24
      //   1468: aload #25
      //   1470: iload #13
      //   1472: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   1475: pop
      //   1476: aload #22
      //   1478: astore #24
      //   1480: aload #25
      //   1482: ldc ')'
      //   1484: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1487: pop
      //   1488: aload #22
      //   1490: astore #24
      //   1492: ldc 'GLThread'
      //   1494: aload #25
      //   1496: invokevirtual toString : ()Ljava/lang/String;
      //   1499: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
      //   1502: pop
      //   1503: aload #22
      //   1505: astore #24
      //   1507: aload #22
      //   1509: getfield s : Ljava/lang/ref/WeakReference;
      //   1512: invokevirtual get : ()Ljava/lang/Object;
      //   1515: checkcast com/blued/android/module/video_gift/GLTextureView
      //   1518: astore #25
      //   1520: aload #25
      //   1522: ifnull -> 1545
      //   1525: aload #22
      //   1527: astore #24
      //   1529: aload #25
      //   1531: invokestatic h : (Lcom/blued/android/module/video_gift/GLTextureView;)Lcom/blued/android/module/video_gift/GLTextureView$Renderer;
      //   1534: aload #21
      //   1536: iload #11
      //   1538: iload #13
      //   1540: invokeinterface a : (Ljavax/microedition/khronos/opengles/GL10;II)V
      //   1545: iconst_0
      //   1546: istore #7
      //   1548: aload #22
      //   1550: getfield s : Ljava/lang/ref/WeakReference;
      //   1553: invokevirtual get : ()Ljava/lang/Object;
      //   1556: checkcast com/blued/android/module/video_gift/GLTextureView
      //   1559: astore #25
      //   1561: aload #25
      //   1563: ifnull -> 1582
      //   1566: aload #22
      //   1568: astore #24
      //   1570: aload #25
      //   1572: invokestatic h : (Lcom/blued/android/module/video_gift/GLTextureView;)Lcom/blued/android/module/video_gift/GLTextureView$Renderer;
      //   1575: aload #21
      //   1577: invokeinterface a : (Ljavax/microedition/khronos/opengles/GL10;)V
      //   1582: aload #22
      //   1584: getfield r : Lcom/blued/android/module/video_gift/GLTextureView$EglHelper;
      //   1587: invokevirtual d : ()I
      //   1590: istore_3
      //   1591: iload_2
      //   1592: istore #4
      //   1594: iload_3
      //   1595: sipush #12288
      //   1598: if_icmpeq -> 1710
      //   1601: iload_3
      //   1602: sipush #12302
      //   1605: if_icmpeq -> 1669
      //   1608: aload #22
      //   1610: astore #24
      //   1612: ldc 'GLThread'
      //   1614: ldc 'eglSwapBuffers'
      //   1616: iload_3
      //   1617: invokestatic a : (Ljava/lang/String;Ljava/lang/String;I)V
      //   1620: aload #22
      //   1622: astore #24
      //   1624: invokestatic j : ()Lcom/blued/android/module/video_gift/GLTextureView$GLThreadManager;
      //   1627: astore #25
      //   1629: aload #22
      //   1631: astore #24
      //   1633: aload #25
      //   1635: monitorenter
      //   1636: aload #22
      //   1638: iconst_1
      //   1639: putfield f : Z
      //   1642: invokestatic j : ()Lcom/blued/android/module/video_gift/GLTextureView$GLThreadManager;
      //   1645: invokevirtual notifyAll : ()V
      //   1648: aload #25
      //   1650: monitorexit
      //   1651: iload_2
      //   1652: istore #4
      //   1654: goto -> 1710
      //   1657: astore #21
      //   1659: aload #25
      //   1661: monitorexit
      //   1662: aload #22
      //   1664: astore #24
      //   1666: aload #21
      //   1668: athrow
      //   1669: new java/lang/StringBuilder
      //   1672: dup
      //   1673: invokespecial <init> : ()V
      //   1676: astore #22
      //   1678: aload #22
      //   1680: ldc 'egl context lost tid='
      //   1682: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1685: pop
      //   1686: aload #22
      //   1688: aload_0
      //   1689: invokevirtual getId : ()J
      //   1692: invokevirtual append : (J)Ljava/lang/StringBuilder;
      //   1695: pop
      //   1696: ldc 'GLThread'
      //   1698: aload #22
      //   1700: invokevirtual toString : ()Ljava/lang/String;
      //   1703: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
      //   1706: pop
      //   1707: iconst_1
      //   1708: istore #4
      //   1710: iload #8
      //   1712: ifeq -> 1717
      //   1715: iconst_1
      //   1716: istore_1
      //   1717: aload_0
      //   1718: astore #22
      //   1720: iload #13
      //   1722: istore #9
      //   1724: iload #12
      //   1726: istore_3
      //   1727: iload #4
      //   1729: istore_2
      //   1730: iload #7
      //   1732: istore #4
      //   1734: goto -> 65
      //   1737: astore #21
      //   1739: goto -> 2033
      //   1742: astore #21
      //   1744: goto -> 2015
      //   1747: iload #12
      //   1749: istore_3
      //   1750: new java/lang/StringBuilder
      //   1753: dup
      //   1754: invokespecial <init> : ()V
      //   1757: astore #22
      //   1759: aload #22
      //   1761: ldc 'waiting tid='
      //   1763: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1766: pop
      //   1767: aload #22
      //   1769: aload_0
      //   1770: invokevirtual getId : ()J
      //   1773: invokevirtual append : (J)Ljava/lang/StringBuilder;
      //   1776: pop
      //   1777: aload #22
      //   1779: ldc ' mHaveEglContext: '
      //   1781: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1784: pop
      //   1785: aload #22
      //   1787: aload_0
      //   1788: getfield h : Z
      //   1791: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   1794: pop
      //   1795: aload #22
      //   1797: ldc ' mHaveEglSurface: '
      //   1799: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1802: pop
      //   1803: aload #22
      //   1805: aload_0
      //   1806: getfield i : Z
      //   1809: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   1812: pop
      //   1813: aload #22
      //   1815: ldc ' mPaused: '
      //   1817: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1820: pop
      //   1821: aload #22
      //   1823: aload_0
      //   1824: getfield d : Z
      //   1827: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   1830: pop
      //   1831: aload #22
      //   1833: ldc ' mHasSurface: '
      //   1835: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1838: pop
      //   1839: aload #22
      //   1841: aload_0
      //   1842: getfield e : Z
      //   1845: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   1848: pop
      //   1849: aload #22
      //   1851: ldc ' mSurfaceIsBad: '
      //   1853: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1856: pop
      //   1857: aload #22
      //   1859: aload_0
      //   1860: getfield f : Z
      //   1863: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   1866: pop
      //   1867: aload #22
      //   1869: ldc_w ' mWaitingForSurface: '
      //   1872: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1875: pop
      //   1876: aload #22
      //   1878: aload_0
      //   1879: getfield g : Z
      //   1882: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   1885: pop
      //   1886: aload #22
      //   1888: ldc_w ' mWidth: '
      //   1891: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1894: pop
      //   1895: aload #22
      //   1897: aload_0
      //   1898: getfield k : I
      //   1901: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   1904: pop
      //   1905: aload #22
      //   1907: ldc_w ' mHeight: '
      //   1910: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1913: pop
      //   1914: aload #22
      //   1916: aload_0
      //   1917: getfield l : I
      //   1920: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   1923: pop
      //   1924: aload #22
      //   1926: ldc_w ' mRequestRender: '
      //   1929: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1932: pop
      //   1933: aload #22
      //   1935: aload_0
      //   1936: getfield n : Z
      //   1939: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   1942: pop
      //   1943: aload #22
      //   1945: ldc_w ' mRenderMode: '
      //   1948: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1951: pop
      //   1952: aload #22
      //   1954: aload_0
      //   1955: getfield m : I
      //   1958: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   1961: pop
      //   1962: ldc 'GLThread'
      //   1964: aload #22
      //   1966: invokevirtual toString : ()Ljava/lang/String;
      //   1969: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
      //   1972: pop
      //   1973: invokestatic j : ()Lcom/blued/android/module/video_gift/GLTextureView$GLThreadManager;
      //   1976: invokevirtual wait : ()V
      //   1979: aload_0
      //   1980: astore #22
      //   1982: iload #13
      //   1984: istore #5
      //   1986: iload #15
      //   1988: istore #6
      //   1990: iload #17
      //   1992: istore #4
      //   1994: iload #18
      //   1996: istore_2
      //   1997: iload #10
      //   1999: istore #15
      //   2001: iload #16
      //   2003: istore_1
      //   2004: iload #14
      //   2006: istore #8
      //   2008: iload #11
      //   2010: istore #12
      //   2012: goto -> 103
      //   2015: aload #25
      //   2017: monitorexit
      //   2018: aload #21
      //   2020: athrow
      //   2021: astore #21
      //   2023: goto -> 2033
      //   2026: astore #21
      //   2028: goto -> 2015
      //   2031: astore #21
      //   2033: invokestatic j : ()Lcom/blued/android/module/video_gift/GLTextureView$GLThreadManager;
      //   2036: astore #22
      //   2038: aload #22
      //   2040: monitorenter
      //   2041: aload_0
      //   2042: invokespecial j : ()V
      //   2045: aload_0
      //   2046: invokespecial k : ()V
      //   2049: aload #22
      //   2051: monitorexit
      //   2052: aload #21
      //   2054: athrow
      //   2055: astore #21
      //   2057: aload #22
      //   2059: monitorexit
      //   2060: aload #21
      //   2062: athrow
      //   2063: iconst_0
      //   2064: istore #19
      //   2066: goto -> 296
      //   2069: iload_3
      //   2070: istore #7
      //   2072: goto -> 366
      //   2075: goto -> 444
      //   2078: iconst_0
      //   2079: istore #12
      //   2081: goto -> 1298
      //   2084: goto -> 1338
      //   2087: iconst_0
      //   2088: istore #6
      //   2090: goto -> 1406
      //   2093: astore #21
      //   2095: goto -> 2015
      // Exception table:
      //   from	to	target	type
      //   69	74	2031	finally
      //   78	81	2031	finally
      //   103	114	2093	finally
      //   122	133	134	finally
      //   136	139	134	finally
      //   142	167	2093	finally
      //   200	236	2093	finally
      //   236	293	2093	finally
      //   300	360	2093	finally
      //   375	383	2093	finally
      //   391	441	2093	finally
      //   449	470	2093	finally
      //   481	488	2093	finally
      //   493	502	2093	finally
      //   502	544	2093	finally
      //   549	604	2093	finally
      //   604	670	2093	finally
      //   670	688	2093	finally
      //   688	754	2093	finally
      //   767	817	2093	finally
      //   823	829	2093	finally
      //   852	859	1742	finally
      //   885	895	2093	finally
      //   907	915	936	java/lang/RuntimeException
      //   907	915	2093	finally
      //   915	927	2093	finally
      //   938	949	2093	finally
      //   949	956	1742	finally
      //   981	995	2093	finally
      //   1023	1038	1742	finally
      //   1043	1101	2093	finally
      //   1129	1141	1742	finally
      //   1171	1174	1742	finally
      //   1183	1190	2031	finally
      //   1219	1227	2031	finally
      //   1231	1242	2031	finally
      //   1246	1251	2031	finally
      //   1255	1258	2031	finally
      //   1258	1273	1286	finally
      //   1288	1291	1286	finally
      //   1295	1298	2031	finally
      //   1307	1320	2031	finally
      //   1324	1332	2031	finally
      //   1349	1357	2031	finally
      //   1361	1374	2031	finally
      //   1383	1403	2031	finally
      //   1419	1428	2031	finally
      //   1432	1440	2031	finally
      //   1444	1452	2031	finally
      //   1456	1464	2031	finally
      //   1468	1476	2031	finally
      //   1480	1488	2031	finally
      //   1492	1503	2031	finally
      //   1507	1520	2031	finally
      //   1529	1545	2031	finally
      //   1548	1561	1737	finally
      //   1570	1582	2031	finally
      //   1582	1591	1737	finally
      //   1612	1620	2031	finally
      //   1624	1629	2031	finally
      //   1633	1636	2031	finally
      //   1636	1651	1657	finally
      //   1659	1662	1657	finally
      //   1666	1669	2031	finally
      //   1669	1707	1737	finally
      //   1750	1785	1742	finally
      //   1785	1979	2026	finally
      //   2015	2018	2026	finally
      //   2018	2021	2021	finally
      //   2041	2052	2055	finally
      //   2057	2060	2055	finally
    }
    
    private boolean m() {
      boolean bool = this.d;
      null = true;
      if (!bool && this.e && !this.f && this.k > 0 && this.l > 0)
        if (!this.n) {
          if (this.m == 1)
            return true; 
        } else {
          return null;
        }  
      return false;
    }
    
    public void a(int param1Int) {
      if (param1Int >= 0 && param1Int <= 1)
        synchronized (GLTextureView.j()) {
          this.m = param1Int;
          GLTextureView.j().notifyAll();
          return;
        }  
      throw new IllegalArgumentException("renderMode");
    }
    
    public void a(int param1Int1, int param1Int2) {
      synchronized (GLTextureView.j()) {
        this.k = param1Int1;
        this.l = param1Int2;
        this.q = true;
        this.n = true;
        this.o = false;
        GLTextureView.j().notifyAll();
        while (true) {
          if (!this.b && !this.d && !this.o && a()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onWindowResize waiting for render complete from tid=");
            stringBuilder.append(getId());
            Log.i("Main thread", stringBuilder.toString());
            try {
              GLTextureView.j().wait();
            } catch (InterruptedException interruptedException) {
              Thread.currentThread().interrupt();
            } 
            continue;
          } 
          return;
        } 
      } 
    }
    
    public boolean a() {
      return (this.h && this.i && m());
    }
    
    public int b() {
      synchronized (GLTextureView.j()) {
        return this.m;
      } 
    }
    
    public void c() {
      synchronized (GLTextureView.j()) {
        this.n = true;
        GLTextureView.j().notifyAll();
        return;
      } 
    }
    
    public void d() {
      synchronized (GLTextureView.j()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("surfaceCreated tid=");
        stringBuilder.append(getId());
        Log.i("GLThread", stringBuilder.toString());
        this.e = true;
        GLTextureView.j().notifyAll();
        while (true) {
          if (this.g) {
            boolean bool = this.b;
            if (!bool) {
              try {
                GLTextureView.j().wait();
              } catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
              } 
              continue;
            } 
          } 
          return;
        } 
      } 
    }
    
    public void e() {
      synchronized (GLTextureView.j()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("surfaceDestroyed tid=");
        stringBuilder.append(getId());
        Log.i("GLThread", stringBuilder.toString());
        this.e = false;
        GLTextureView.j().notifyAll();
        while (true) {
          if (!this.g) {
            boolean bool = this.b;
            if (!bool) {
              try {
                GLTextureView.j().wait();
              } catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
              } 
              continue;
            } 
          } 
          return;
        } 
      } 
    }
    
    public void f() {
      synchronized (GLTextureView.j()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onPause tid=");
        stringBuilder.append(getId());
        Log.i("GLThread", stringBuilder.toString());
        this.c = true;
        GLTextureView.j().notifyAll();
        while (true) {
          if (!this.b && !this.d) {
            Log.i("Main thread", "onPause waiting for mPaused.");
            try {
              GLTextureView.j().wait();
            } catch (InterruptedException interruptedException) {
              Thread.currentThread().interrupt();
            } 
            continue;
          } 
          return;
        } 
      } 
    }
    
    public void g() {
      synchronized (GLTextureView.j()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onResume tid=");
        stringBuilder.append(getId());
        Log.i("GLThread", stringBuilder.toString());
        this.c = false;
        this.n = true;
        this.o = false;
        GLTextureView.j().notifyAll();
        while (true) {
          if (!this.b && this.d && !this.o) {
            Log.i("Main thread", "onResume waiting for !mPaused.");
            try {
              GLTextureView.j().wait();
            } catch (InterruptedException interruptedException) {
              Thread.currentThread().interrupt();
            } 
            continue;
          } 
          return;
        } 
      } 
    }
    
    public void h() {
      synchronized (GLTextureView.j()) {
        this.a = true;
        GLTextureView.j().notifyAll();
        while (true) {
          boolean bool = this.b;
          if (!bool) {
            try {
              GLTextureView.j().wait();
            } catch (InterruptedException interruptedException) {
              Thread.currentThread().interrupt();
            } 
            continue;
          } 
          return;
        } 
      } 
    }
    
    public void i() {
      this.j = true;
      GLTextureView.j().notifyAll();
    }
    
    public void run() {
      null = new StringBuilder();
      null.append("GLThread ");
      null.append(getId());
      setName(null.toString());
      null = new StringBuilder();
      null.append("starting tid=");
      null.append(getId());
      Log.i("GLThread", null.toString());
      try {
      
      } catch (InterruptedException interruptedException) {
      
      } finally {
        GLTextureView.j().a(this);
      } 
      GLTextureView.j().a(this);
    }
  }
  
  static class GLThreadManager {
    private static String a = "GLThreadManager";
    
    private boolean b;
    
    private int c;
    
    private boolean d;
    
    private boolean e;
    
    private boolean f;
    
    private GLTextureView.GLThread g;
    
    private GLThreadManager() {}
    
    private void c() {
      if (!this.b)
        this.b = true; 
    }
    
    public void a(GLTextureView.GLThread param1GLThread) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: new java/lang/StringBuilder
      //   5: dup
      //   6: invokespecial <init> : ()V
      //   9: astore_2
      //   10: aload_2
      //   11: ldc 'exiting tid='
      //   13: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   16: pop
      //   17: aload_2
      //   18: aload_1
      //   19: invokevirtual getId : ()J
      //   22: invokevirtual append : (J)Ljava/lang/StringBuilder;
      //   25: pop
      //   26: ldc 'GLThread'
      //   28: aload_2
      //   29: invokevirtual toString : ()Ljava/lang/String;
      //   32: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
      //   35: pop
      //   36: aload_1
      //   37: iconst_1
      //   38: invokestatic a : (Lcom/blued/android/module/video_gift/GLTextureView$GLThread;Z)Z
      //   41: pop
      //   42: aload_0
      //   43: getfield g : Lcom/blued/android/module/video_gift/GLTextureView$GLThread;
      //   46: aload_1
      //   47: if_acmpne -> 55
      //   50: aload_0
      //   51: aconst_null
      //   52: putfield g : Lcom/blued/android/module/video_gift/GLTextureView$GLThread;
      //   55: aload_0
      //   56: invokevirtual notifyAll : ()V
      //   59: aload_0
      //   60: monitorexit
      //   61: return
      //   62: astore_1
      //   63: aload_0
      //   64: monitorexit
      //   65: aload_1
      //   66: athrow
      // Exception table:
      //   from	to	target	type
      //   2	55	62	finally
      //   55	59	62	finally
    }
    
    public void a(GL10 param1GL10) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield d : Z
      //   6: ifne -> 158
      //   9: aload_0
      //   10: invokespecial c : ()V
      //   13: aload_1
      //   14: sipush #7937
      //   17: invokeinterface glGetString : (I)Ljava/lang/String;
      //   22: astore_1
      //   23: aload_0
      //   24: getfield c : I
      //   27: istore_2
      //   28: iconst_0
      //   29: istore #4
      //   31: iload_2
      //   32: ldc 131072
      //   34: if_icmpge -> 60
      //   37: aload_1
      //   38: ldc 'Q3Dimension MSM7500 '
      //   40: invokevirtual startsWith : (Ljava/lang/String;)Z
      //   43: ifne -> 166
      //   46: iconst_1
      //   47: istore_3
      //   48: goto -> 51
      //   51: aload_0
      //   52: iload_3
      //   53: putfield e : Z
      //   56: aload_0
      //   57: invokevirtual notifyAll : ()V
      //   60: iload #4
      //   62: istore_3
      //   63: aload_0
      //   64: getfield e : Z
      //   67: ifne -> 72
      //   70: iconst_1
      //   71: istore_3
      //   72: aload_0
      //   73: iload_3
      //   74: putfield f : Z
      //   77: getstatic com/blued/android/module/video_gift/GLTextureView$GLThreadManager.a : Ljava/lang/String;
      //   80: astore #5
      //   82: new java/lang/StringBuilder
      //   85: dup
      //   86: invokespecial <init> : ()V
      //   89: astore #6
      //   91: aload #6
      //   93: ldc 'checkGLDriver renderer = "'
      //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   98: pop
      //   99: aload #6
      //   101: aload_1
      //   102: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   105: pop
      //   106: aload #6
      //   108: ldc '" multipleContextsAllowed = '
      //   110: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   113: pop
      //   114: aload #6
      //   116: aload_0
      //   117: getfield e : Z
      //   120: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   123: pop
      //   124: aload #6
      //   126: ldc ' mLimitedGLESContexts = '
      //   128: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   131: pop
      //   132: aload #6
      //   134: aload_0
      //   135: getfield f : Z
      //   138: invokevirtual append : (Z)Ljava/lang/StringBuilder;
      //   141: pop
      //   142: aload #5
      //   144: aload #6
      //   146: invokevirtual toString : ()Ljava/lang/String;
      //   149: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
      //   152: pop
      //   153: aload_0
      //   154: iconst_1
      //   155: putfield d : Z
      //   158: aload_0
      //   159: monitorexit
      //   160: return
      //   161: astore_1
      //   162: aload_0
      //   163: monitorexit
      //   164: aload_1
      //   165: athrow
      //   166: iconst_0
      //   167: istore_3
      //   168: goto -> 51
      // Exception table:
      //   from	to	target	type
      //   2	28	161	finally
      //   37	46	161	finally
      //   51	60	161	finally
      //   63	70	161	finally
      //   72	158	161	finally
    }
    
    public boolean a() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield f : Z
      //   6: istore_1
      //   7: aload_0
      //   8: monitorexit
      //   9: iload_1
      //   10: ireturn
      //   11: astore_2
      //   12: aload_0
      //   13: monitorexit
      //   14: aload_2
      //   15: athrow
      // Exception table:
      //   from	to	target	type
      //   2	7	11	finally
    }
    
    public boolean b() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokespecial c : ()V
      //   6: aload_0
      //   7: getfield e : Z
      //   10: istore_1
      //   11: aload_0
      //   12: monitorexit
      //   13: iload_1
      //   14: iconst_1
      //   15: ixor
      //   16: ireturn
      //   17: astore_2
      //   18: aload_0
      //   19: monitorexit
      //   20: aload_2
      //   21: athrow
      // Exception table:
      //   from	to	target	type
      //   2	11	17	finally
    }
    
    public boolean b(GLTextureView.GLThread param1GLThread) {
      GLTextureView.GLThread gLThread = this.g;
      if (gLThread == param1GLThread || gLThread == null) {
        this.g = param1GLThread;
        notifyAll();
        return true;
      } 
      c();
      if (this.e)
        return true; 
      param1GLThread = this.g;
      if (param1GLThread != null)
        param1GLThread.i(); 
      return false;
    }
    
    public void c(GLTextureView.GLThread param1GLThread) {
      if (this.g == param1GLThread)
        this.g = null; 
      notifyAll();
    }
  }
  
  public static interface GLWrapper {
    GL a(GL param1GL);
  }
  
  static class LogWriter extends Writer {
    private StringBuilder a = new StringBuilder();
    
    private void a() {
      if (this.a.length() > 0) {
        Log.v("GLTextureView", this.a.toString());
        StringBuilder stringBuilder = this.a;
        stringBuilder.delete(0, stringBuilder.length());
      } 
    }
    
    public void close() {
      a();
    }
    
    public void flush() {
      a();
    }
    
    public void write(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
      int i;
      for (i = 0; i < param1Int2; i++) {
        char c = param1ArrayOfchar[param1Int1 + i];
        if (c == '\n') {
          a();
        } else {
          this.a.append(c);
        } 
      } 
    }
  }
  
  public static interface Renderer {
    void a(GL10 param1GL10);
    
    void a(GL10 param1GL10, int param1Int1, int param1Int2);
    
    void a(GL10 param1GL10, EGLConfig param1EGLConfig);
  }
  
  class SimpleEGLConfigChooser extends ComponentSizeChooser {
    public SimpleEGLConfigChooser(GLTextureView this$0, boolean param1Boolean) {
      super(this$0, 8, 8, 8, 0, bool, 0);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\video_gift\GLTextureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */