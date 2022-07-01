package a.a.a.a.a.a.h;

import a.a.a.a.a.e.e;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class a implements c {
  public EGLDisplay a = EGL10.EGL_NO_DISPLAY;
  
  public EGLContext b = EGL10.EGL_NO_CONTEXT;
  
  public EGLConfig c = null;
  
  public EGL10 d = (EGL10)EGLContext.getEGL();
  
  public a(Object paramObject, int paramInt) {
    if (this.a == EGL10.EGL_NO_DISPLAY) {
      Object object = paramObject;
      if (paramObject == null)
        object = EGL10.EGL_NO_CONTEXT; 
      paramObject = this.d.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
      this.a = (EGLDisplay)paramObject;
      if (paramObject != EGL10.EGL_NO_DISPLAY) {
        int[] arrayOfInt = new int[2];
        if (this.d.eglInitialize((EGLDisplay)paramObject, arrayOfInt)) {
          if (this.b == EGL10.EGL_NO_CONTEXT) {
            paramObject = b(paramInt, 2);
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
  
  public static Object a() {
    return ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
  }
  
  public int a(Object paramObject, int paramInt) {
    int[] arrayOfInt = new int[1];
    this.d.eglQuerySurface(this.a, (EGLSurface)paramObject, paramInt, arrayOfInt);
    return arrayOfInt[0];
  }
  
  public Object a(int paramInt1, int paramInt2) {
    EGLSurface eGLSurface = this.d.eglCreatePbufferSurface(this.a, this.c, new int[] { 12375, paramInt1, 12374, paramInt2, 12344 });
    a("eglCreatePbufferSurface");
    if (eGLSurface != null)
      return eGLSurface; 
    throw new RuntimeException("surface was null");
  }
  
  public void a(Object paramObject) {
    this.d.eglDestroySurface(this.a, (EGLSurface)paramObject);
  }
  
  public void a(Object paramObject, long paramLong) {}
  
  public final void a(String paramString) {
    int i = this.d.eglGetError();
    if (i == 12288)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(": EGL error: 0x");
    stringBuilder.append(Integer.toHexString(i));
    throw new RuntimeException(stringBuilder.toString());
  }
  
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
  
  public final EGLConfig b(int paramInt1, int paramInt2) {
    StringBuilder stringBuilder;
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
      arrayOfInt1[8] = 12610;
      arrayOfInt1[9] = 1;
    } 
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[1];
    int[] arrayOfInt2 = new int[1];
    if (!this.d.eglChooseConfig(this.a, arrayOfInt1, arrayOfEGLConfig, 1, arrayOfInt2)) {
      e e = e.c;
      stringBuilder = new StringBuilder();
      stringBuilder.append("unable to find RGB8888 / ");
      stringBuilder.append(paramInt2);
      stringBuilder.append(" EGLConfig");
      e.d("EGL10", stringBuilder.toString());
      return null;
    } 
    return (EGLConfig)stringBuilder[0];
  }
  
  public void b() {
    EGLDisplay eGLDisplay = this.a;
    if (eGLDisplay != EGL10.EGL_NO_DISPLAY) {
      EGL10 eGL10 = this.d;
      EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
      eGL10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
      this.d.eglDestroyContext(this.a, this.b);
      this.d.eglTerminate(this.a);
    } 
    this.a = EGL10.EGL_NO_DISPLAY;
    this.b = EGL10.EGL_NO_CONTEXT;
    this.c = null;
  }
  
  public void c(Object paramObject) {
    if (this.a == EGL10.EGL_NO_DISPLAY)
      e.c.b("EGL10", "NOTE: makeCurrent w/o display"); 
    EGL10 eGL10 = this.d;
    EGLDisplay eGLDisplay = this.a;
    paramObject = paramObject;
    if (eGL10.eglMakeCurrent(eGLDisplay, (EGLSurface)paramObject, (EGLSurface)paramObject, this.b))
      return; 
    throw new RuntimeException("eglMakeCurrent failed");
  }
  
  public boolean d(Object paramObject) {
    return this.d.eglSwapBuffers(this.a, (EGLSurface)paramObject);
  }
  
  public boolean e(Object paramObject) {
    return (this.b.equals(this.d.eglGetCurrentContext()) && paramObject.equals(this.d.eglGetCurrentSurface(12377)));
  }
  
  public void finalize() {
    if (this.a != EGL10.EGL_NO_DISPLAY) {
      e.c.d("EGL10", "WARNING: EglCore was not explicitly released -- state may be leaked");
      b();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */