package com.blued.android.module.live_china.zegoVideoCapture.ve_gl;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public final class EglBase10 extends EglBase {
  private final EGL10 i = (EGL10)EGLContext.getEGL();
  
  private EGLContext j;
  
  private EGLConfig k;
  
  private EGLDisplay l = j();
  
  private EGLSurface m = EGL10.EGL_NO_SURFACE;
  
  public EglBase10(Context paramContext, int[] paramArrayOfint) {
    this.k = a(this.l, paramArrayOfint);
    this.j = a(paramContext, this.l, this.k);
  }
  
  private EGLConfig a(EGLDisplay paramEGLDisplay, int[] paramArrayOfint) {
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    if (!this.i.eglChooseConfig(paramEGLDisplay, paramArrayOfint, arrayOfEGLConfig, arrayOfEGLConfig.length, arrayOfInt)) {
      this.b = true;
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("eglChooseConfig failed: 0x");
      stringBuilder.append(Integer.toHexString(this.i.eglGetError()));
      Log.e(str, stringBuilder.toString());
      return null;
    } 
    if (arrayOfInt[0] <= 0) {
      this.b = true;
      Log.e(a, "Unable to find any matching EGL config");
      return null;
    } 
    EGLConfig eGLConfig = arrayOfEGLConfig[0];
    if (eGLConfig == null) {
      this.b = true;
      Log.e(a, "eglChooseConfig returned null");
      return null;
    } 
    return eGLConfig;
  }
  
  private EGLContext a(Context paramContext, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig) {
    if (paramContext != null && Context.a(paramContext) == EGL10.EGL_NO_CONTEXT) {
      this.b = true;
      Log.e(a, "Invalid sharedContext");
      return null;
    } 
    if (paramContext == null) {
      null = EGL10.EGL_NO_CONTEXT;
    } else {
      null = Context.a((Context)null);
    } 
    synchronized (EglBase.c) {
      null = this.i.eglCreateContext(paramEGLDisplay, paramEGLConfig, null, new int[] { 12440, 2, 12344 });
      if (null == EGL10.EGL_NO_CONTEXT) {
        this.b = true;
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to create EGL context: 0x");
        stringBuilder.append(Integer.toHexString(this.i.eglGetError()));
        Log.e(str, stringBuilder.toString());
      } 
      return null;
    } 
  }
  
  private void a(Object paramObject) {
    if (!(paramObject instanceof SurfaceHolder) && !(paramObject instanceof android.graphics.SurfaceTexture)) {
      this.b = true;
      Log.e(a, "Input must be either a SurfaceHolder or SurfaceTexture");
      return;
    } 
    i();
    if (this.m != EGL10.EGL_NO_SURFACE) {
      this.b = true;
      Log.e(a, "Already has an EGLSurface");
      return;
    } 
    this.m = this.i.eglCreateWindowSurface(this.l, this.k, paramObject, new int[] { 12344 });
    int i = this.i.eglGetError();
    if (this.m == EGL10.EGL_NO_SURFACE || i != 12288) {
      this.b = true;
      paramObject = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to create window surface: 0x");
      stringBuilder.append(Integer.toHexString(i));
      Log.e((String)paramObject, stringBuilder.toString());
      return;
    } 
  }
  
  private void i() {
    if (this.l == EGL10.EGL_NO_DISPLAY || this.j == EGL10.EGL_NO_CONTEXT || this.k == null) {
      this.b = true;
      Log.e(a, "This object has been released");
    } 
  }
  
  private EGLDisplay j() {
    EGLDisplay eGLDisplay = this.i.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
    if (eGLDisplay == EGL10.EGL_NO_DISPLAY) {
      this.b = true;
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to get EGL10 display: 0x");
      stringBuilder.append(Integer.toHexString(this.i.eglGetError()));
      Log.e(str, stringBuilder.toString());
      return eGLDisplay;
    } 
    int[] arrayOfInt = new int[2];
    if (!this.i.eglInitialize(eGLDisplay, arrayOfInt)) {
      this.b = true;
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to initialize EGL10: 0x");
      stringBuilder.append(Integer.toHexString(this.i.eglGetError()));
      Log.e(str, stringBuilder.toString());
    } 
    return eGLDisplay;
  }
  
  public void a() {
    a(1, 1);
  }
  
  public void a(int paramInt1, int paramInt2) {
    i();
    if (this.m != EGL10.EGL_NO_SURFACE) {
      this.b = true;
      Log.e(a, "Already has an EGLSurface");
      return;
    } 
    this.m = this.i.eglCreatePbufferSurface(this.l, this.k, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 });
    int i = this.i.eglGetError();
    if (this.m == EGL10.EGL_NO_SURFACE || i != 12288) {
      this.b = true;
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to create pixel buffer surface with size ");
      stringBuilder.append(paramInt1);
      stringBuilder.append("x");
      stringBuilder.append(paramInt2);
      stringBuilder.append(": 0x");
      stringBuilder.append(Integer.toHexString(i));
      Log.e(str, stringBuilder.toString());
      return;
    } 
  }
  
  public void a(Surface paramSurface) {
    class FakeSurfaceHolder implements SurfaceHolder {
      private final Surface b;
      
      FakeSurfaceHolder(EglBase10 this$0, Surface param1Surface) {
        this.b = param1Surface;
      }
      
      public void addCallback(SurfaceHolder.Callback param1Callback) {}
      
      public Surface getSurface() {
        return this.b;
      }
      
      public Rect getSurfaceFrame() {
        return null;
      }
      
      public boolean isCreating() {
        return false;
      }
      
      public Canvas lockCanvas() {
        return null;
      }
      
      public Canvas lockCanvas(Rect param1Rect) {
        return null;
      }
      
      public void removeCallback(SurfaceHolder.Callback param1Callback) {}
      
      public void setFixedSize(int param1Int1, int param1Int2) {}
      
      public void setFormat(int param1Int) {}
      
      public void setKeepScreenOn(boolean param1Boolean) {}
      
      public void setSizeFromLayout() {}
      
      @Deprecated
      public void setType(int param1Int) {}
      
      public void unlockCanvasAndPost(Canvas param1Canvas) {}
    };
    a(new FakeSurfaceHolder(this, paramSurface));
  }
  
  public EglBase.Context b() {
    return new Context(this.j);
  }
  
  public boolean c() {
    return (this.m != EGL10.EGL_NO_SURFACE);
  }
  
  public void d() {
    if (this.b)
      return; 
    if (this.m != EGL10.EGL_NO_SURFACE) {
      this.i.eglDestroySurface(this.l, this.m);
      this.m = EGL10.EGL_NO_SURFACE;
    } 
  }
  
  public void e() {
    if (this.b)
      return; 
    i();
    d();
    g();
    this.i.eglDestroyContext(this.l, this.j);
    this.i.eglTerminate(this.l);
    this.j = EGL10.EGL_NO_CONTEXT;
    this.l = EGL10.EGL_NO_DISPLAY;
    this.k = null;
  }
  
  public void f() {
    i();
    if (this.m == EGL10.EGL_NO_SURFACE) {
      this.b = true;
      Log.e(a, "No EGLSurface - can't make current");
      return;
    } 
    synchronized (EglBase.c) {
      EGLContext eGLContext = this.i.eglGetCurrentContext();
      EGLSurface eGLSurface = this.i.eglGetCurrentSurface(12377);
      if (eGLContext == this.j && eGLSurface == this.m)
        return; 
      if (!this.i.eglMakeCurrent(this.l, this.m, this.m, this.j)) {
        this.b = true;
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("eglMakeCurrent failed: 0x");
        stringBuilder.append(Integer.toHexString(this.i.eglGetError()));
        Log.e(str, stringBuilder.toString());
        return;
      } 
      return;
    } 
  }
  
  public void g() {
    synchronized (EglBase.c) {
      if (!this.i.eglMakeCurrent(this.l, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT)) {
        this.b = true;
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("eglDetachCurrent failed: 0x");
        stringBuilder.append(Integer.toHexString(this.i.eglGetError()));
        Log.e(str, stringBuilder.toString());
      } 
      return;
    } 
  }
  
  public void h() {
    i();
    if (this.m == EGL10.EGL_NO_SURFACE) {
      this.b = true;
      Log.e(a, "No EGLSurface - can't swap buffers");
      return;
    } 
    synchronized (EglBase.c) {
      this.i.eglSwapBuffers(this.l, this.m);
      return;
    } 
  }
  
  public static class Context extends EglBase.Context {
    private final EGLContext a;
    
    public Context(EGLContext param1EGLContext) {
      this.a = param1EGLContext;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\zegoVideoCapture\ve_gl\EglBase10.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */