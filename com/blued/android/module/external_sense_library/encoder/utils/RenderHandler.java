package com.blued.android.module.external_sense_library.encoder.utils;

import android.opengl.EGLContext;
import android.opengl.Matrix;

public final class RenderHandler implements Runnable {
  private final Object a = new Object();
  
  private EGLContext b;
  
  private boolean c;
  
  private Object d;
  
  private int e = -1;
  
  private float[] f = new float[32];
  
  private boolean g;
  
  private boolean h;
  
  private int i;
  
  private EGLBase j;
  
  private EGLBase.EglSurface k;
  
  private GLDrawer2D l;
  
  private final void b() {
    c();
    this.j = new EGLBase(this.b, false, this.c);
    this.k = this.j.a(this.d);
    this.k.a();
    this.l = new GLDrawer2D();
    this.d = null;
    this.a.notifyAll();
  }
  
  private final void c() {
    EGLBase.EglSurface eglSurface = this.k;
    if (eglSurface != null) {
      eglSurface.c();
      this.k = null;
    } 
    GLDrawer2D gLDrawer2D = this.l;
    if (gLDrawer2D != null) {
      gLDrawer2D.a();
      this.l = null;
    } 
    EGLBase eGLBase = this.j;
    if (eGLBase != null) {
      eGLBase.a();
      this.j = null;
    } 
  }
  
  public final void a() {
    synchronized (this.a) {
      if (this.h)
        return; 
      this.h = true;
      this.a.notifyAll();
      try {
        this.a.wait();
      } catch (InterruptedException interruptedException) {}
      return;
    } 
  }
  
  public final void a(int paramInt, float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
    synchronized (this.a) {
      if (this.h)
        return; 
      this.e = paramInt;
      if (paramArrayOffloat1 != null && paramArrayOffloat1.length >= 16) {
        System.arraycopy(paramArrayOffloat1, 0, this.f, 0, 16);
      } else {
        Matrix.setIdentityM(this.f, 0);
      } 
      if (paramArrayOffloat2 != null && paramArrayOffloat2.length >= 16) {
        System.arraycopy(paramArrayOffloat2, 0, this.f, 16, 16);
      } else {
        Matrix.setIdentityM(this.f, 16);
      } 
      this.i++;
      this.a.notifyAll();
      return;
    } 
  }
  
  public final void a(EGLContext paramEGLContext, int paramInt, Object paramObject, boolean paramBoolean) {
    if (paramObject instanceof android.view.Surface || paramObject instanceof android.graphics.SurfaceTexture || paramObject instanceof android.view.SurfaceHolder)
      synchronized (this.a) {
        if (this.h)
          return; 
        this.b = paramEGLContext;
        this.e = paramInt;
        this.d = paramObject;
        this.c = paramBoolean;
        this.g = true;
        Matrix.setIdentityM(this.f, 0);
        Matrix.setIdentityM(this.f, 16);
        this.a.notifyAll();
        try {
          this.a.wait();
        } catch (InterruptedException interruptedException) {}
        return;
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("unsupported window type:");
    stringBuilder.append(paramObject);
    throw new RuntimeException(stringBuilder.toString());
  }
  
  public final void a(float[] paramArrayOffloat) {
    a(this.e, paramArrayOffloat, null);
  }
  
  public final void run() {
    // Byte code:
    //   0: aload_0
    //   1: getfield a : Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield h : Z
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield g : Z
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield i : I
    //   22: aload_0
    //   23: getfield a : Ljava/lang/Object;
    //   26: invokevirtual notifyAll : ()V
    //   29: aload_2
    //   30: monitorexit
    //   31: aload_0
    //   32: getfield a : Ljava/lang/Object;
    //   35: astore_2
    //   36: aload_2
    //   37: monitorenter
    //   38: aload_0
    //   39: getfield h : Z
    //   42: ifeq -> 50
    //   45: aload_2
    //   46: monitorexit
    //   47: goto -> 191
    //   50: aload_0
    //   51: getfield g : Z
    //   54: ifeq -> 66
    //   57: aload_0
    //   58: iconst_0
    //   59: putfield g : Z
    //   62: aload_0
    //   63: invokespecial b : ()V
    //   66: aload_0
    //   67: getfield i : I
    //   70: ifle -> 240
    //   73: iconst_1
    //   74: istore_1
    //   75: goto -> 78
    //   78: iload_1
    //   79: ifeq -> 92
    //   82: aload_0
    //   83: aload_0
    //   84: getfield i : I
    //   87: iconst_1
    //   88: isub
    //   89: putfield i : I
    //   92: aload_2
    //   93: monitorexit
    //   94: iload_1
    //   95: ifeq -> 170
    //   98: aload_0
    //   99: getfield j : Lcom/blued/android/module/external_sense_library/encoder/utils/EGLBase;
    //   102: ifnull -> 31
    //   105: aload_0
    //   106: getfield e : I
    //   109: iflt -> 31
    //   112: aload_0
    //   113: getfield k : Lcom/blued/android/module/external_sense_library/encoder/utils/EGLBase$EglSurface;
    //   116: invokevirtual a : ()V
    //   119: fconst_1
    //   120: fconst_1
    //   121: fconst_0
    //   122: fconst_1
    //   123: invokestatic glClearColor : (FFFF)V
    //   126: sipush #16384
    //   129: invokestatic glClear : (I)V
    //   132: aload_0
    //   133: getfield l : Lcom/blued/android/module/external_sense_library/encoder/utils/GLDrawer2D;
    //   136: aload_0
    //   137: getfield f : [F
    //   140: bipush #16
    //   142: invokevirtual a : ([FI)V
    //   145: aload_0
    //   146: getfield l : Lcom/blued/android/module/external_sense_library/encoder/utils/GLDrawer2D;
    //   149: aload_0
    //   150: getfield e : I
    //   153: aload_0
    //   154: getfield f : [F
    //   157: invokevirtual a : (I[F)V
    //   160: aload_0
    //   161: getfield k : Lcom/blued/android/module/external_sense_library/encoder/utils/EGLBase$EglSurface;
    //   164: invokevirtual b : ()V
    //   167: goto -> 31
    //   170: aload_0
    //   171: getfield a : Ljava/lang/Object;
    //   174: astore_2
    //   175: aload_2
    //   176: monitorenter
    //   177: aload_0
    //   178: getfield a : Ljava/lang/Object;
    //   181: invokevirtual wait : ()V
    //   184: aload_2
    //   185: monitorexit
    //   186: goto -> 31
    //   189: aload_2
    //   190: monitorexit
    //   191: aload_0
    //   192: getfield a : Ljava/lang/Object;
    //   195: astore_2
    //   196: aload_2
    //   197: monitorenter
    //   198: aload_0
    //   199: iconst_1
    //   200: putfield h : Z
    //   203: aload_0
    //   204: invokespecial c : ()V
    //   207: aload_0
    //   208: getfield a : Ljava/lang/Object;
    //   211: invokevirtual notifyAll : ()V
    //   214: aload_2
    //   215: monitorexit
    //   216: return
    //   217: astore_3
    //   218: aload_2
    //   219: monitorexit
    //   220: aload_3
    //   221: athrow
    //   222: aload_2
    //   223: monitorexit
    //   224: aload_3
    //   225: athrow
    //   226: astore_3
    //   227: aload_2
    //   228: monitorexit
    //   229: aload_3
    //   230: athrow
    //   231: astore_3
    //   232: aload_2
    //   233: monitorexit
    //   234: aload_3
    //   235: athrow
    //   236: astore_3
    //   237: goto -> 189
    //   240: iconst_0
    //   241: istore_1
    //   242: goto -> 78
    //   245: astore_3
    //   246: goto -> 222
    // Exception table:
    //   from	to	target	type
    //   7	31	231	finally
    //   38	47	226	finally
    //   50	66	226	finally
    //   66	73	226	finally
    //   82	92	226	finally
    //   92	94	226	finally
    //   177	184	236	java/lang/InterruptedException
    //   177	184	245	finally
    //   184	186	245	finally
    //   189	191	245	finally
    //   198	216	217	finally
    //   218	220	217	finally
    //   222	224	245	finally
    //   227	229	226	finally
    //   232	234	231	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\encode\\utils\RenderHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */