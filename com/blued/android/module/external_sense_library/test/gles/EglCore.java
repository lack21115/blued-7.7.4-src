package com.blued.android.module.external_sense_library.test.gles;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Log;

public final class EglCore {
  private EGLDisplay a = EGL14.EGL_NO_DISPLAY;
  
  private EGLContext b = EGL14.EGL_NO_CONTEXT;
  
  private EGLConfig c = null;
  
  private int d = -1;
  
  public EglCore() {
    this(null, 0);
  }
  
  public EglCore(EGLContext paramEGLContext, int paramInt) {
    if (this.a == EGL14.EGL_NO_DISPLAY) {
      EGLContext eGLContext = paramEGLContext;
      if (paramEGLContext == null)
        eGLContext = EGL14.EGL_NO_CONTEXT; 
      this.a = EGL14.eglGetDisplay(0);
      if (this.a != EGL14.EGL_NO_DISPLAY) {
        int[] arrayOfInt = new int[2];
        if (EGL14.eglInitialize(this.a, arrayOfInt, 0, arrayOfInt, 1)) {
          if ((paramInt & 0x2) != 0) {
            EGLConfig eGLConfig = b(paramInt, 3);
            if (eGLConfig != null) {
              EGLContext eGLContext1 = EGL14.eglCreateContext(this.a, eGLConfig, eGLContext, new int[] { 12440, 3, 12344 }, 0);
              if (EGL14.eglGetError() == 12288) {
                this.c = eGLConfig;
                this.b = eGLContext1;
                this.d = 3;
              } 
            } 
          } 
          if (this.b == EGL14.EGL_NO_CONTEXT) {
            EGLConfig eGLConfig = b(paramInt, 2);
            if (eGLConfig != null) {
              eGLContext = EGL14.eglCreateContext(this.a, eGLConfig, eGLContext, new int[] { 12440, 2, 12344 }, 0);
              a("eglCreateContext");
              this.c = eGLConfig;
              this.b = eGLContext;
              this.d = 2;
            } else {
              throw new RuntimeException("Unable to find a suitable EGLConfig");
            } 
          } 
          arrayOfInt = new int[1];
          EGL14.eglQueryContext(this.a, this.b, 12440, arrayOfInt, 0);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("EGLContext created, client version ");
          stringBuilder.append(arrayOfInt[0]);
          Log.d("Grafika", stringBuilder.toString());
          return;
        } 
        this.a = null;
        throw new RuntimeException("unable to initialize EGL14");
      } 
      throw new RuntimeException("unable to get EGL14 display");
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
  
  private EGLConfig b(int paramInt1, int paramInt2) {
    byte b;
    if (paramInt2 >= 3) {
      b = 68;
    } else {
      b = 4;
    } 
    int[] arrayOfInt1 = new int[13];
    arrayOfInt1[0] = 12324;
    arrayOfInt1[1] = 8;
    arrayOfInt1[2] = 12323;
    arrayOfInt1[3] = 8;
    arrayOfInt1[4] = 12322;
    arrayOfInt1[5] = 8;
    arrayOfInt1[6] = 12321;
    arrayOfInt1[7] = 8;
    arrayOfInt1[8] = 12352;
    arrayOfInt1[9] = b;
    arrayOfInt1[10] = 12344;
    arrayOfInt1[11] = 0;
    arrayOfInt1[12] = 12344;
    if ((paramInt1 & 0x1) != 0) {
      arrayOfInt1[arrayOfInt1.length - 3] = 12610;
      arrayOfInt1[arrayOfInt1.length - 2] = 1;
    } 
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt2 = new int[1];
    if (!EGL14.eglChooseConfig(this.a, arrayOfInt1, 0, arrayOfEGLConfig, 0, arrayOfEGLConfig.length, arrayOfInt2, 0)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unable to find RGB8888 / ");
      stringBuilder.append(paramInt2);
      stringBuilder.append(" EGLConfig");
      Log.w("Grafika", stringBuilder.toString());
      return null;
    } 
    return arrayOfEGLConfig[0];
  }
  
  public int a(EGLSurface paramEGLSurface, int paramInt) {
    int[] arrayOfInt = new int[1];
    EGL14.eglQuerySurface(this.a, paramEGLSurface, paramInt, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  public EGLSurface a(int paramInt1, int paramInt2) {
    EGLSurface eGLSurface = EGL14.eglCreatePbufferSurface(this.a, this.c, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 }, 0);
    a("eglCreatePbufferSurface");
    if (eGLSurface != null)
      return eGLSurface; 
    throw new RuntimeException("surface was null");
  }
  
  public void a() {
    if (this.a != EGL14.EGL_NO_DISPLAY) {
      EGL14.eglMakeCurrent(this.a, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroyContext(this.a, this.b);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.a);
    } 
    this.a = EGL14.EGL_NO_DISPLAY;
    this.b = EGL14.EGL_NO_CONTEXT;
    this.c = null;
  }
  
  public void a(EGLSurface paramEGLSurface) {
    EGL14.eglDestroySurface(this.a, paramEGLSurface);
  }
  
  public void b(EGLSurface paramEGLSurface) {
    if (this.a == EGL14.EGL_NO_DISPLAY)
      Log.d("Grafika", "NOTE: makeCurrent w/o display"); 
    if (EGL14.eglMakeCurrent(this.a, paramEGLSurface, paramEGLSurface, this.b))
      return; 
    throw new RuntimeException("eglMakeCurrent failed");
  }
  
  public boolean c(EGLSurface paramEGLSurface) {
    return (this.b.equals(EGL14.eglGetCurrentContext()) && paramEGLSurface.equals(EGL14.eglGetCurrentSurface(12377)));
  }
  
  protected void finalize() throws Throwable {
    try {
      if (this.a != EGL14.EGL_NO_DISPLAY) {
        Log.w("Grafika", "WARNING: EglCore was not explicitly released -- state may be leaked");
        a();
      } 
      return;
    } finally {
      super.finalize();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\test\gles\EglCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */