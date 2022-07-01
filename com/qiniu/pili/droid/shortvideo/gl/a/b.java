package com.qiniu.pili.droid.shortvideo.gl.a;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;

public class b implements c {
  private EGLDisplay a;
  
  private EGLContext b;
  
  private EGLConfig c;
  
  public b(Object paramObject, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_0
    //   5: getstatic android/opengl/EGL14.EGL_NO_DISPLAY : Landroid/opengl/EGLDisplay;
    //   8: putfield a : Landroid/opengl/EGLDisplay;
    //   11: aload_0
    //   12: getstatic android/opengl/EGL14.EGL_NO_CONTEXT : Landroid/opengl/EGLContext;
    //   15: putfield b : Landroid/opengl/EGLContext;
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield c : Landroid/opengl/EGLConfig;
    //   23: aload_0
    //   24: getfield a : Landroid/opengl/EGLDisplay;
    //   27: getstatic android/opengl/EGL14.EGL_NO_DISPLAY : Landroid/opengl/EGLDisplay;
    //   30: if_acmpne -> 196
    //   33: aload_1
    //   34: astore_3
    //   35: aload_1
    //   36: ifnonnull -> 43
    //   39: getstatic android/opengl/EGL14.EGL_NO_CONTEXT : Landroid/opengl/EGLContext;
    //   42: astore_3
    //   43: aload_0
    //   44: iconst_0
    //   45: invokestatic eglGetDisplay : (I)Landroid/opengl/EGLDisplay;
    //   48: putfield a : Landroid/opengl/EGLDisplay;
    //   51: aload_0
    //   52: getfield a : Landroid/opengl/EGLDisplay;
    //   55: getstatic android/opengl/EGL14.EGL_NO_DISPLAY : Landroid/opengl/EGLDisplay;
    //   58: if_acmpeq -> 186
    //   61: iconst_2
    //   62: newarray int
    //   64: astore_1
    //   65: aload_1
    //   66: dup
    //   67: iconst_0
    //   68: iconst_0
    //   69: iastore
    //   70: dup
    //   71: iconst_1
    //   72: iconst_1
    //   73: iastore
    //   74: pop
    //   75: aload_0
    //   76: getfield a : Landroid/opengl/EGLDisplay;
    //   79: aload_1
    //   80: iconst_0
    //   81: aload_1
    //   82: iconst_1
    //   83: invokestatic eglInitialize : (Landroid/opengl/EGLDisplay;[II[II)Z
    //   86: ifeq -> 171
    //   89: aload_0
    //   90: getfield b : Landroid/opengl/EGLContext;
    //   93: getstatic android/opengl/EGL14.EGL_NO_CONTEXT : Landroid/opengl/EGLContext;
    //   96: if_acmpne -> 170
    //   99: aload_0
    //   100: iload_2
    //   101: iconst_2
    //   102: invokespecial a : (II)Landroid/opengl/EGLConfig;
    //   105: astore_1
    //   106: aload_1
    //   107: ifnull -> 160
    //   110: aload_0
    //   111: getfield a : Landroid/opengl/EGLDisplay;
    //   114: aload_1
    //   115: aload_3
    //   116: checkcast android/opengl/EGLContext
    //   119: iconst_3
    //   120: newarray int
    //   122: dup
    //   123: iconst_0
    //   124: sipush #12440
    //   127: iastore
    //   128: dup
    //   129: iconst_1
    //   130: iconst_2
    //   131: iastore
    //   132: dup
    //   133: iconst_2
    //   134: sipush #12344
    //   137: iastore
    //   138: iconst_0
    //   139: invokestatic eglCreateContext : (Landroid/opengl/EGLDisplay;Landroid/opengl/EGLConfig;Landroid/opengl/EGLContext;[II)Landroid/opengl/EGLContext;
    //   142: astore_3
    //   143: aload_0
    //   144: ldc 'eglCreateContext'
    //   146: invokespecial a : (Ljava/lang/String;)V
    //   149: aload_0
    //   150: aload_1
    //   151: putfield c : Landroid/opengl/EGLConfig;
    //   154: aload_0
    //   155: aload_3
    //   156: putfield b : Landroid/opengl/EGLContext;
    //   159: return
    //   160: new java/lang/RuntimeException
    //   163: dup
    //   164: ldc 'Unable to find a suitable EGLConfig'
    //   166: invokespecial <init> : (Ljava/lang/String;)V
    //   169: athrow
    //   170: return
    //   171: aload_0
    //   172: aconst_null
    //   173: putfield a : Landroid/opengl/EGLDisplay;
    //   176: new java/lang/RuntimeException
    //   179: dup
    //   180: ldc 'unable to initialize EGL14'
    //   182: invokespecial <init> : (Ljava/lang/String;)V
    //   185: athrow
    //   186: new java/lang/RuntimeException
    //   189: dup
    //   190: ldc 'unable to get EGL14 display'
    //   192: invokespecial <init> : (Ljava/lang/String;)V
    //   195: athrow
    //   196: new java/lang/RuntimeException
    //   199: dup
    //   200: ldc 'EGL already set up'
    //   202: invokespecial <init> : (Ljava/lang/String;)V
    //   205: athrow
  }
  
  private EGLConfig a(int paramInt1, int paramInt2) {
    byte b1;
    if (paramInt2 >= 3) {
      b1 = 68;
    } else {
      b1 = 4;
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
    arrayOfInt1[9] = b1;
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
      Log.w("EGL14", stringBuilder.toString());
      return null;
    } 
    return arrayOfEGLConfig[0];
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
  
  public static Object b() {
    return EGL14.eglGetCurrentContext();
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
  
  public void a(Object paramObject) {
    EGL14.eglDestroySurface(this.a, (EGLSurface)paramObject);
  }
  
  public void a(Object paramObject, long paramLong) {
    EGLExt.eglPresentationTimeANDROID(this.a, (EGLSurface)paramObject, paramLong);
  }
  
  public Object b(Object paramObject) {
    if (paramObject instanceof android.view.Surface || paramObject instanceof android.graphics.SurfaceTexture) {
      paramObject = EGL14.eglCreateWindowSurface(this.a, this.c, paramObject, new int[] { 12344 }, 0);
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
    if (this.a == EGL14.EGL_NO_DISPLAY)
      Log.d("EGL14", "NOTE: makeCurrent w/o display"); 
    EGLDisplay eGLDisplay = this.a;
    paramObject = paramObject;
    if (EGL14.eglMakeCurrent(eGLDisplay, (EGLSurface)paramObject, (EGLSurface)paramObject, this.b))
      return; 
    throw new RuntimeException("eglMakeCurrent failed");
  }
  
  public boolean d(Object paramObject) {
    return EGL14.eglSwapBuffers(this.a, (EGLSurface)paramObject);
  }
  
  public void finalize() {
    if (this.a != EGL14.EGL_NO_DISPLAY) {
      Log.w("EGL14", "WARNING: EglCore was not explicitly released -- state may be leaked");
      a();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */