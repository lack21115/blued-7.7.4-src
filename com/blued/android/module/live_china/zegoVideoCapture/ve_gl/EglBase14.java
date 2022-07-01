package com.blued.android.module.live_china.zegoVideoCapture.ve_gl;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Build;
import android.util.Log;
import android.view.Surface;

public final class EglBase14 extends EglBase {
  private static final int i = Build.VERSION.SDK_INT;
  
  private EGLContext j;
  
  private EGLConfig k;
  
  private EGLDisplay l = l();
  
  private EGLSurface m = EGL14.EGL_NO_SURFACE;
  
  public EglBase14(Context paramContext, int[] paramArrayOfint) {
    this.k = a(this.l, paramArrayOfint);
    this.j = a(paramContext, this.l, this.k);
  }
  
  private static EGLConfig a(EGLDisplay paramEGLDisplay, int[] paramArrayOfint) {
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    if (!EGL14.eglChooseConfig(paramEGLDisplay, paramArrayOfint, 0, arrayOfEGLConfig, 0, arrayOfEGLConfig.length, arrayOfInt, 0)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("eglChooseConfig failed: 0x");
      stringBuilder.append(Integer.toHexString(EGL14.eglGetError()));
      Log.e("EglBase14", stringBuilder.toString());
      return null;
    } 
    if (arrayOfInt[0] <= 0) {
      Log.e("EglBase14", "Unable to find any matching EGL config");
      return null;
    } 
    EGLConfig eGLConfig = arrayOfEGLConfig[0];
    if (eGLConfig == null) {
      Log.e("EglBase14", "eglChooseConfig returned null");
      return null;
    } 
    return eGLConfig;
  }
  
  private static EGLContext a(Context paramContext, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig) {
    if (paramContext != null && Context.a(paramContext) == EGL14.EGL_NO_CONTEXT) {
      Log.e("EglBase14", "Invalid sharedContext");
      return null;
    } 
    if (paramContext == null) {
      null = EGL14.EGL_NO_CONTEXT;
    } else {
      null = Context.a((Context)null);
    } 
    synchronized (EglBase.c) {
      StringBuilder stringBuilder;
      null = EGL14.eglCreateContext(paramEGLDisplay, paramEGLConfig, null, new int[] { 12440, 2, 12344 }, 0);
      if (null == EGL14.EGL_NO_CONTEXT) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to create EGL context: 0x");
        stringBuilder.append(Integer.toHexString(EGL14.eglGetError()));
        Log.e("EglBase14", stringBuilder.toString());
        return null;
      } 
      return (EGLContext)stringBuilder;
    } 
  }
  
  private void a(Object paramObject) {
    if (!(paramObject instanceof Surface) && !(paramObject instanceof android.graphics.SurfaceTexture)) {
      this.b = true;
      return;
    } 
    k();
    if (this.m != EGL14.EGL_NO_SURFACE) {
      this.b = true;
      return;
    } 
    this.m = EGL14.eglCreateWindowSurface(this.l, this.k, paramObject, new int[] { 12344 }, 0);
    int i = EGL14.eglGetError();
    if (this.m == EGL14.EGL_NO_SURFACE || i != 12288) {
      this.b = true;
      return;
    } 
  }
  
  public static boolean i() {
    boolean bool;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("SDK version: ");
    stringBuilder.append(i);
    stringBuilder.append(". isEGL14Supported: ");
    if (i >= 18) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder.append(bool);
    Log.d("EglBase14", stringBuilder.toString());
    return (i >= 18);
  }
  
  private void k() {
    if (this.l == EGL14.EGL_NO_DISPLAY || this.j == EGL14.EGL_NO_CONTEXT || this.k == null)
      this.b = true; 
  }
  
  private static EGLDisplay l() {
    EGLDisplay eGLDisplay = EGL14.eglGetDisplay(0);
    if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to get EGL14 display: 0x");
      stringBuilder.append(Integer.toHexString(EGL14.eglGetError()));
      Log.e("EglBase14", stringBuilder.toString());
      return eGLDisplay;
    } 
    int[] arrayOfInt = new int[2];
    if (!EGL14.eglInitialize(eGLDisplay, arrayOfInt, 0, arrayOfInt, 1)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to initialize EGL14: 0x");
      stringBuilder.append(Integer.toHexString(EGL14.eglGetError()));
      Log.e("EglBase14", stringBuilder.toString());
    } 
    return eGLDisplay;
  }
  
  public void a() {
    a(1, 1);
  }
  
  public void a(int paramInt1, int paramInt2) {
    k();
    if (this.m != EGL14.EGL_NO_SURFACE) {
      this.b = true;
      return;
    } 
    this.m = EGL14.eglCreatePbufferSurface(this.l, this.k, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 }, 0);
    paramInt1 = EGL14.eglGetError();
    if (this.m == EGL14.EGL_NO_SURFACE || paramInt1 != 12288) {
      this.b = true;
      return;
    } 
  }
  
  public void a(long paramLong) {
    k();
    if (this.m == EGL14.EGL_NO_SURFACE) {
      this.b = true;
      Log.e("EglBase14", "No EGLSurface - can't swap buffers");
      return;
    } 
    synchronized (EglBase.c) {
      EGLExt.eglPresentationTimeANDROID(this.l, this.m, paramLong);
      EGL14.eglSwapBuffers(this.l, this.m);
      return;
    } 
  }
  
  public void a(Surface paramSurface) {
    a(paramSurface);
  }
  
  public boolean c() {
    return (this.m != EGL14.EGL_NO_SURFACE);
  }
  
  public void d() {
    if (this.b)
      return; 
    if (this.m != EGL14.EGL_NO_SURFACE) {
      EGL14.eglDestroySurface(this.l, this.m);
      this.m = EGL14.EGL_NO_SURFACE;
    } 
  }
  
  public void e() {
    if (this.b)
      return; 
    k();
    d();
    g();
    EGL14.eglDestroyContext(this.l, this.j);
    EGL14.eglReleaseThread();
    EGL14.eglTerminate(this.l);
    this.j = EGL14.EGL_NO_CONTEXT;
    this.l = EGL14.EGL_NO_DISPLAY;
    this.k = null;
  }
  
  public void f() {
    k();
    if (this.m == EGL14.EGL_NO_SURFACE) {
      this.b = true;
      Log.e("EglBase14", "No EGLSurface - can't make current");
      return;
    } 
    synchronized (EglBase.c) {
      EGLContext eGLContext = EGL14.eglGetCurrentContext();
      EGLSurface eGLSurface = EGL14.eglGetCurrentSurface(12377);
      if (eGLContext == this.j && eGLSurface == this.m)
        return; 
      if (!EGL14.eglMakeCurrent(this.l, this.m, this.m, this.j)) {
        this.b = true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("eglMakeCurrent failed: 0x");
        stringBuilder.append(Integer.toHexString(EGL14.eglGetError()));
        Log.e("EglBase14", stringBuilder.toString());
        return;
      } 
      return;
    } 
  }
  
  public void g() {
    synchronized (EglBase.c) {
      if (!EGL14.eglMakeCurrent(this.l, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
        this.b = true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("eglDetachCurrent failed: 0x");
        stringBuilder.append(Integer.toHexString(EGL14.eglGetError()));
        Log.e("EglBase14", stringBuilder.toString());
        return;
      } 
      return;
    } 
  }
  
  public void h() {
    k();
    if (this.m == EGL14.EGL_NO_SURFACE) {
      this.b = true;
      Log.e("EglBase14", "No EGLSurface - can't swap buffers");
      return;
    } 
    synchronized (EglBase.c) {
      EGL14.eglSwapBuffers(this.l, this.m);
      return;
    } 
  }
  
  public Context j() {
    return new Context(this.j);
  }
  
  public static class Context extends EglBase.Context {
    private final EGLContext a;
    
    public Context(EGLContext param1EGLContext) {
      this.a = param1EGLContext;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\zegoVideoCapture\ve_gl\EglBase14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */