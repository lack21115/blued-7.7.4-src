package com.qiniu.pili.droid.shortvideo.gl.a;

import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class a implements c {
  private EGLDisplay a = EGL10.EGL_NO_DISPLAY;
  
  private EGLContext b = EGL10.EGL_NO_CONTEXT;
  
  private EGLConfig c = null;
  
  private EGL10 d = (EGL10)EGLContext.getEGL();
  
  public a(Object paramObject, int paramInt) {
    if (this.a == EGL10.EGL_NO_DISPLAY) {
      Object object = paramObject;
      if (paramObject == null)
        object = EGL10.EGL_NO_CONTEXT; 
      this.a = this.d.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      if (this.a != EGL10.EGL_NO_DISPLAY) {
        paramObject = new int[2];
        if (this.d.eglInitialize(this.a, (int[])paramObject)) {
          if (this.b == EGL10.EGL_NO_CONTEXT) {
            paramObject = a(paramInt, 2);
            if (paramObject != null) {
              object = this.d.eglCreateContext(this.a, (EGLConfig)paramObject, (EGLContext)object, new int[] { 12440, 2, 12344 });
              a("eglCreateContext");
              this.c = (EGLConfig)paramObject;
              this.b = (EGLContext)object;
              return;
            } 
            throw new RuntimeException("Unable to find a suitable EGLConfig");
          } 
          return;
        } 
        this.a = null;
        throw new RuntimeException("unable to initialize EGL10");
      } 
      throw new RuntimeException("unable to get EGL10 display");
    } 
    throw new RuntimeException("EGL already set up");
  }
  
  private EGLConfig a(int paramInt1, int paramInt2) {
    int[] arrayOfInt1 = new int[11];
    arrayOfInt1[0] = 12324;
    arrayOfInt1[1] = 8;
    arrayOfInt1[2] = 12323;
    arrayOfInt1[3] = 8;
    arrayOfInt1[4] = 12322;
    arrayOfInt1[5] = 8;
    arrayOfInt1[6] = 12352;
    arrayOfInt1[7] = 4;
    arrayOfInt1[8] = 12344;
    arrayOfInt1[9] = 0;
    arrayOfInt1[10] = 12344;
    if ((paramInt1 & 0x1) != 0) {
      arrayOfInt1[arrayOfInt1.length - 3] = 12610;
      arrayOfInt1[arrayOfInt1.length - 2] = 1;
    } 
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt2 = new int[1];
    if (!this.d.eglChooseConfig(this.a, arrayOfInt1, arrayOfEGLConfig, arrayOfEGLConfig.length, arrayOfInt2)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unable to find RGB8888 / ");
      stringBuilder.append(paramInt2);
      stringBuilder.append(" EGLConfig");
      Log.w("EGL10", stringBuilder.toString());
      return null;
    } 
    return arrayOfEGLConfig[0];
  }
  
  private void a(String paramString) {
    int i = this.d.eglGetError();
    if (i == 12288)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(": EGL error: 0x");
    stringBuilder.append(Integer.toHexString(i));
    throw new RuntimeException(stringBuilder.toString());
  }
  
  public static Object b() {
    return ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
  }
  
  public void a() {
    if (this.a != EGL10.EGL_NO_DISPLAY) {
      this.d.eglMakeCurrent(this.a, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
      this.d.eglDestroyContext(this.a, this.b);
      this.d.eglTerminate(this.a);
    } 
    this.a = EGL10.EGL_NO_DISPLAY;
    this.b = EGL10.EGL_NO_CONTEXT;
    this.c = null;
  }
  
  public void a(Object paramObject) {
    this.d.eglDestroySurface(this.a, (EGLSurface)paramObject);
  }
  
  public void a(Object paramObject, long paramLong) {}
  
  public Object b(Object paramObject) {
    if (paramObject instanceof android.view.Surface || paramObject instanceof android.graphics.SurfaceTexture) {
      paramObject = this.d.eglCreateWindowSurface(this.a, this.c, paramObject, new int[] { 12344 });
      a("eglCreateWindowSurface");
      if (paramObject != null)
        return paramObject; 
      throw new RuntimeException("surface was null");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("invalid surface: ");
    stringBuilder.append(paramObject);
    throw new RuntimeException(stringBuilder.toString());
  }
  
  public void c(Object paramObject) {
    EGLDisplay eGLDisplay1 = this.a;
    EGL10 eGL102 = this.d;
    if (eGLDisplay1 == EGL10.EGL_NO_DISPLAY)
      Log.d("EGL10", "NOTE: makeCurrent w/o display"); 
    EGL10 eGL101 = this.d;
    EGLDisplay eGLDisplay2 = this.a;
    paramObject = paramObject;
    if (eGL101.eglMakeCurrent(eGLDisplay2, (EGLSurface)paramObject, (EGLSurface)paramObject, this.b))
      return; 
    throw new RuntimeException("eglMakeCurrent failed");
  }
  
  public boolean d(Object paramObject) {
    return this.d.eglSwapBuffers(this.a, (EGLSurface)paramObject);
  }
  
  public void finalize() {
    if (this.a != EGL10.EGL_NO_DISPLAY) {
      Log.w("EGL10", "WARNING: EglCore was not explicitly released -- state may be leaked");
      a();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */