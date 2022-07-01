package com.blued.android.module.external_sense_library.encoder.utils;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Build;
import android.util.Log;

public class EGLBase {
  private EGLConfig a = null;
  
  private EGLContext b = EGL14.EGL_NO_CONTEXT;
  
  private EGLDisplay c = EGL14.EGL_NO_DISPLAY;
  
  private EGLContext d = EGL14.EGL_NO_CONTEXT;
  
  public EGLBase(EGLContext paramEGLContext, boolean paramBoolean1, boolean paramBoolean2) {
    a(paramEGLContext, paramBoolean1, paramBoolean2);
  }
  
  private EGLConfig a(boolean paramBoolean1, boolean paramBoolean2) {
    int[] arrayOfInt1 = new int[17];
    arrayOfInt1[0] = 12352;
    arrayOfInt1[1] = 4;
    arrayOfInt1[2] = 12324;
    arrayOfInt1[3] = 8;
    arrayOfInt1[4] = 12323;
    arrayOfInt1[5] = 8;
    arrayOfInt1[6] = 12322;
    arrayOfInt1[7] = 8;
    arrayOfInt1[8] = 12321;
    arrayOfInt1[9] = 8;
    arrayOfInt1[10] = 12344;
    arrayOfInt1[11] = 12344;
    arrayOfInt1[12] = 12344;
    arrayOfInt1[13] = 12344;
    arrayOfInt1[14] = 12344;
    arrayOfInt1[15] = 12344;
    arrayOfInt1[16] = 12344;
    int i = 10;
    if (paramBoolean1) {
      arrayOfInt1[10] = 12325;
      i = 12;
      arrayOfInt1[11] = 16;
    } 
    int j = i;
    if (paramBoolean2) {
      j = i;
      if (Build.VERSION.SDK_INT >= 18) {
        int k = i + 1;
        arrayOfInt1[i] = 12610;
        j = k + 1;
        arrayOfInt1[k] = 1;
      } 
    } 
    for (i = arrayOfInt1.length - 1; i >= j; i--)
      arrayOfInt1[i] = 12344; 
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt2 = new int[1];
    if (!EGL14.eglChooseConfig(this.c, arrayOfInt1, 0, arrayOfEGLConfig, 0, arrayOfEGLConfig.length, arrayOfInt2, 0)) {
      Log.w("EGLBase", "unable to find RGBA8888 /  EGLConfig");
      return null;
    } 
    return arrayOfEGLConfig[0];
  }
  
  private EGLContext a(EGLContext paramEGLContext) {
    paramEGLContext = EGL14.eglCreateContext(this.c, this.a, paramEGLContext, new int[] { 12440, 2, 12344 }, 0);
    a("eglCreateContext");
    return paramEGLContext;
  }
  
  private void a(EGLContext paramEGLContext, boolean paramBoolean1, boolean paramBoolean2) {
    if (this.c == EGL14.EGL_NO_DISPLAY) {
      this.c = EGL14.eglGetDisplay(0);
      if (this.c != EGL14.EGL_NO_DISPLAY) {
        int[] arrayOfInt = new int[2];
        if (EGL14.eglInitialize(this.c, arrayOfInt, 0, arrayOfInt, 1)) {
          if (paramEGLContext == null)
            paramEGLContext = EGL14.EGL_NO_CONTEXT; 
          if (this.b == EGL14.EGL_NO_CONTEXT) {
            this.a = a(paramBoolean1, paramBoolean2);
            if (this.a != null) {
              this.b = a(paramEGLContext);
            } else {
              throw new RuntimeException("chooseConfig failed");
            } 
          } 
          int[] arrayOfInt1 = new int[1];
          EGL14.eglQueryContext(this.c, this.b, 12440, arrayOfInt1, 0);
          b();
          return;
        } 
        this.c = null;
        throw new RuntimeException("eglInitialize failed");
      } 
      throw new RuntimeException("eglGetDisplay failed");
    } 
    throw new RuntimeException("EGL already set up");
  }
  
  private void a(String paramString) {
    int i = EGL14.eglGetError();
    if (i == 12288)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(": EGL error: 0x");
    stringBuilder.append(Integer.toHexString(i));
    throw new RuntimeException(stringBuilder.toString());
  }
  
  private boolean a(EGLSurface paramEGLSurface) {
    EGLDisplay eGLDisplay = this.c;
    if (paramEGLSurface == null || paramEGLSurface == EGL14.EGL_NO_SURFACE) {
      if (EGL14.eglGetError() == 12299)
        Log.e("EGLBase", "makeCurrent:returned EGL_BAD_NATIVE_WINDOW."); 
      return false;
    } 
    if (!EGL14.eglMakeCurrent(this.c, paramEGLSurface, paramEGLSurface, this.b)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("eglMakeCurrent:");
      stringBuilder.append(EGL14.eglGetError());
      Log.w("EGLBase", stringBuilder.toString());
      return false;
    } 
    return true;
  }
  
  private int b(EGLSurface paramEGLSurface) {
    return !EGL14.eglSwapBuffers(this.c, paramEGLSurface) ? EGL14.eglGetError() : 12288;
  }
  
  private EGLSurface b(Object paramObject) {
    try {
      return EGL14.eglCreateWindowSurface(this.c, this.a, paramObject, new int[] { 12344 }, 0);
    } catch (IllegalArgumentException illegalArgumentException) {
      Log.e("EGLBase", "eglCreateWindowSurface", illegalArgumentException);
      return null;
    } 
  }
  
  private void b() {
    if (!EGL14.eglMakeCurrent(this.c, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("makeDefault");
      stringBuilder.append(EGL14.eglGetError());
      Log.w("TAG", stringBuilder.toString());
    } 
  }
  
  private void c() {
    if (!EGL14.eglDestroyContext(this.c, this.b)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("display:");
      stringBuilder.append(this.c);
      stringBuilder.append(" context: ");
      stringBuilder.append(this.b);
      Log.e("destroyContext", stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("eglDestroyContex:");
      stringBuilder.append(EGL14.eglGetError());
      Log.e("EGLBase", stringBuilder.toString());
    } 
    this.b = EGL14.EGL_NO_CONTEXT;
    if (this.d != EGL14.EGL_NO_CONTEXT) {
      if (!EGL14.eglDestroyContext(this.c, this.d)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("display:");
        stringBuilder.append(this.c);
        stringBuilder.append(" context: ");
        stringBuilder.append(this.d);
        Log.e("destroyContext", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("eglDestroyContex:");
        stringBuilder.append(EGL14.eglGetError());
        Log.e("EGLBase", stringBuilder.toString());
      } 
      this.d = EGL14.EGL_NO_CONTEXT;
    } 
  }
  
  private void c(EGLSurface paramEGLSurface) {
    if (paramEGLSurface != EGL14.EGL_NO_SURFACE) {
      EGL14.eglMakeCurrent(this.c, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroySurface(this.c, paramEGLSurface);
    } 
    paramEGLSurface = EGL14.EGL_NO_SURFACE;
  }
  
  public int a(EGLSurface paramEGLSurface, int paramInt) {
    int[] arrayOfInt = new int[1];
    EGL14.eglQuerySurface(this.c, paramEGLSurface, paramInt, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  public EglSurface a(Object paramObject) {
    paramObject = new EglSurface(this, paramObject);
    paramObject.a();
    return (EglSurface)paramObject;
  }
  
  public void a() {
    if (this.c != EGL14.EGL_NO_DISPLAY) {
      c();
      EGL14.eglTerminate(this.c);
      EGL14.eglReleaseThread();
    } 
    this.c = EGL14.EGL_NO_DISPLAY;
    this.b = EGL14.EGL_NO_CONTEXT;
  }
  
  public static class EglSurface {
    private final EGLBase a;
    
    private EGLSurface b = EGL14.EGL_NO_SURFACE;
    
    private final int c;
    
    private final int d;
    
    EglSurface(EGLBase param1EGLBase, Object param1Object) {
      if (param1Object instanceof android.view.SurfaceView || param1Object instanceof android.view.Surface || param1Object instanceof android.view.SurfaceHolder || param1Object instanceof android.graphics.SurfaceTexture) {
        this.a = param1EGLBase;
        this.b = EGLBase.a(this.a, param1Object);
        this.c = this.a.a(this.b, 12375);
        this.d = this.a.a(this.b, 12374);
        return;
      } 
      throw new IllegalArgumentException("unsupported surface");
    }
    
    public void a() {
      EGLBase.a(this.a, this.b);
    }
    
    public void b() {
      EGLBase.b(this.a, this.b);
    }
    
    public void c() {
      EGLBase.a(this.a);
      EGLBase.c(this.a, this.b);
      this.b = EGL14.EGL_NO_SURFACE;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\encode\\utils\EGLBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */