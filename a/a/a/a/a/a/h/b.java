package a.a.a.a.a.a.h;

import a.a.a.a.a.e.e;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;

public class b implements c {
  public EGLDisplay a;
  
  public EGLContext b;
  
  public EGLConfig c;
  
  public b(Object paramObject, int paramInt) {
    EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
    this.a = eGLDisplay;
    this.b = EGL14.EGL_NO_CONTEXT;
    this.c = null;
    if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
      Object object = paramObject;
      if (paramObject == null)
        object = EGL14.EGL_NO_CONTEXT; 
      paramObject = EGL14.eglGetDisplay(0);
      this.a = (EGLDisplay)paramObject;
      if (paramObject != EGL14.EGL_NO_DISPLAY) {
        int[] arrayOfInt = new int[2];
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 1;
        if (EGL14.eglInitialize((EGLDisplay)paramObject, arrayOfInt, 0, arrayOfInt, 1)) {
          if (this.b == EGL14.EGL_NO_CONTEXT) {
            paramObject = b(paramInt, 2);
            if (paramObject != null) {
              object = EGL14.eglCreateContext(this.a, (EGLConfig)paramObject, (EGLContext)object, new int[] { 12440, 2, 12344 }, 0);
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
        throw new RuntimeException("unable to initialize EGL14");
      } 
      throw new RuntimeException("unable to get EGL14 display");
    } 
    throw new RuntimeException("EGL already set up");
  }
  
  public static Object a() {
    return EGL14.eglGetCurrentContext();
  }
  
  public int a(Object paramObject, int paramInt) {
    int[] arrayOfInt = new int[1];
    EGL14.eglQuerySurface(this.a, (EGLSurface)paramObject, paramInt, arrayOfInt, 0);
    return arrayOfInt[0];
  }
  
  public Object a(int paramInt1, int paramInt2) {
    EGLSurface eGLSurface = EGL14.eglCreatePbufferSurface(this.a, this.c, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 }, 0);
    a("eglCreatePbufferSurface");
    if (eGLSurface != null)
      return eGLSurface; 
    throw new RuntimeException("surface was null");
  }
  
  public void a(Object paramObject) {
    EGL14.eglDestroySurface(this.a, (EGLSurface)paramObject);
  }
  
  public void a(Object paramObject, long paramLong) {
    EGLExt.eglPresentationTimeANDROID(this.a, (EGLSurface)paramObject, paramLong);
  }
  
  public final void a(String paramString) {
    int i = EGL14.eglGetError();
    if (i == 12288)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(": EGL error: 0x");
    stringBuilder.append(Integer.toHexString(i));
    throw new RuntimeException(stringBuilder.toString());
  }
  
  public final EGLConfig b(int paramInt1, int paramInt2) {
    byte b1;
    StringBuilder stringBuilder;
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
      arrayOfInt1[10] = 12610;
      arrayOfInt1[11] = 1;
    } 
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt2 = new int[1];
    if (!EGL14.eglChooseConfig(this.a, arrayOfInt1, 0, arrayOfEGLConfig, 0, 1, arrayOfInt2, 0)) {
      e e = e.c;
      stringBuilder = new StringBuilder();
      stringBuilder.append("unable to find RGB8888 / ");
      stringBuilder.append(paramInt2);
      stringBuilder.append(" EGLConfig");
      e.d("EGL14", stringBuilder.toString());
      return null;
    } 
    return (EGLConfig)stringBuilder[0];
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
  
  public void b() {
    EGLDisplay eGLDisplay = this.a;
    if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
      EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
      EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
      EGL14.eglDestroyContext(this.a, this.b);
      EGL14.eglReleaseThread();
      EGL14.eglTerminate(this.a);
    } 
    this.a = EGL14.EGL_NO_DISPLAY;
    this.b = EGL14.EGL_NO_CONTEXT;
    this.c = null;
  }
  
  public void c(Object paramObject) {
    if (this.a == EGL14.EGL_NO_DISPLAY)
      e.c.b("EGL14", "NOTE: makeCurrent w/o display"); 
    EGLDisplay eGLDisplay = this.a;
    paramObject = paramObject;
    if (EGL14.eglMakeCurrent(eGLDisplay, (EGLSurface)paramObject, (EGLSurface)paramObject, this.b))
      return; 
    throw new RuntimeException("eglMakeCurrent failed");
  }
  
  public boolean d(Object paramObject) {
    return EGL14.eglSwapBuffers(this.a, (EGLSurface)paramObject);
  }
  
  public boolean e(Object paramObject) {
    return (this.b.equals(EGL14.eglGetCurrentContext()) && paramObject.equals(EGL14.eglGetCurrentSurface(12377)));
  }
  
  public void finalize() {
    if (this.a != EGL14.EGL_NO_DISPLAY) {
      e.c.d("EGL14", "WARNING: EglCore was not explicitly released -- state may be leaked");
      b();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */