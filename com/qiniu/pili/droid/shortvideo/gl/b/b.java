package com.qiniu.pili.droid.shortvideo.gl.b;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.qiniu.pili.droid.beauty.a;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLFaceBeautySetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.f.d;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.gl.c.a;
import com.qiniu.pili.droid.shortvideo.gl.c.g;
import com.qiniu.pili.droid.shortvideo.gl.c.i;
import com.qiniu.pili.droid.shortvideo.gl.c.k;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class b implements GLSurfaceView.Renderer {
  private WeakReference<GLSurfaceView> a;
  
  private a b;
  
  private k c;
  
  private a d;
  
  private g e = new g();
  
  private i f;
  
  private SurfaceTexture g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private float[] m = new float[16];
  
  private PLVideoFilterListener n;
  
  private PLDisplayMode o;
  
  private volatile boolean p;
  
  private volatile boolean q;
  
  public b(GLSurfaceView paramGLSurfaceView, PLFaceBeautySetting paramPLFaceBeautySetting, PLDisplayMode paramPLDisplayMode) {
    this.a = new WeakReference<GLSurfaceView>(paramGLSurfaceView);
    paramGLSurfaceView.setEGLContextClientVersion(2);
    paramGLSurfaceView.setRenderer(this);
    paramGLSurfaceView.setRenderMode(0);
    this.b = new a(paramGLSurfaceView.getContext(), paramPLFaceBeautySetting);
    this.o = paramPLDisplayMode;
  }
  
  public void a() {
    GLSurfaceView gLSurfaceView = this.a.get();
    if (gLSurfaceView != null)
      gLSurfaceView.onResume(); 
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    this.e.c(paramFloat1, paramFloat2);
  }
  
  public void a(int paramInt) {
    this.e.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.h = paramInt1;
    this.i = paramInt2;
    this.j = paramInt3;
    this.k = paramInt4;
    GLSurfaceView gLSurfaceView = this.a.get();
    if (gLSurfaceView != null)
      gLSurfaceView.requestRender(); 
  }
  
  public void a(PLFaceBeautySetting paramPLFaceBeautySetting) {
    this.b.a(paramPLFaceBeautySetting);
    GLES20.glGetError();
  }
  
  public final void a(PLVideoFilterListener paramPLVideoFilterListener) {
    this.n = paramPLVideoFilterListener;
  }
  
  public void a(boolean paramBoolean) {
    this.p = paramBoolean;
  }
  
  public void b() {
    GLSurfaceView gLSurfaceView = this.a.get();
    if (gLSurfaceView != null) {
      gLSurfaceView.queueEvent(new Runnable(this) {
            public void run() {
              b.a(this.a).b();
              GLES20.glGetError();
              if (b.b(this.a) != null)
                b.b(this.a).release(); 
              if (b.c(this.a) != null)
                b.c(this.a).onSurfaceDestroy(); 
            }
          });
      gLSurfaceView.onPause();
    } 
  }
  
  public void b(boolean paramBoolean) {
    this.q = paramBoolean;
  }
  
  public SurfaceTexture c() {
    return this.g;
  }
  
  public void onDrawFrame(GL10 paramGL10) {
    // Byte code:
    //   0: aload_0
    //   1: getfield g : Landroid/graphics/SurfaceTexture;
    //   4: invokevirtual updateTexImage : ()V
    //   7: aload_0
    //   8: getfield g : Landroid/graphics/SurfaceTexture;
    //   11: aload_0
    //   12: getfield m : [F
    //   15: invokevirtual getTransformMatrix : ([F)V
    //   18: aload_0
    //   19: getfield g : Landroid/graphics/SurfaceTexture;
    //   22: invokevirtual getTimestamp : ()J
    //   25: lstore #4
    //   27: getstatic com/qiniu/pili/droid/shortvideo/f/e.j : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   30: astore_1
    //   31: new java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: astore #6
    //   40: aload #6
    //   42: ldc 'onDrawFrame: '
    //   44: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload #6
    //   50: lload #4
    //   52: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_1
    //   57: ldc 'PreviewRenderer'
    //   59: aload #6
    //   61: invokevirtual toString : ()Ljava/lang/String;
    //   64: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_0
    //   68: getfield d : Lcom/qiniu/pili/droid/shortvideo/gl/c/a;
    //   71: ifnonnull -> 190
    //   74: aload_0
    //   75: getfield j : I
    //   78: istore_2
    //   79: iload_2
    //   80: ifeq -> 179
    //   83: aload_0
    //   84: getfield k : I
    //   87: istore_3
    //   88: iload_3
    //   89: ifeq -> 179
    //   92: aload_0
    //   93: getfield e : Lcom/qiniu/pili/droid/shortvideo/gl/c/g;
    //   96: iload_2
    //   97: iload_3
    //   98: aload_0
    //   99: getfield o : Lcom/qiniu/pili/droid/shortvideo/PLDisplayMode;
    //   102: invokevirtual a : (IILcom/qiniu/pili/droid/shortvideo/PLDisplayMode;)Z
    //   105: pop
    //   106: aload_0
    //   107: new com/qiniu/pili/droid/shortvideo/gl/c/a
    //   110: dup
    //   111: invokespecial <init> : ()V
    //   114: putfield d : Lcom/qiniu/pili/droid/shortvideo/gl/c/a;
    //   117: aload_0
    //   118: getfield d : Lcom/qiniu/pili/droid/shortvideo/gl/c/a;
    //   121: invokevirtual b : ()Z
    //   124: pop
    //   125: aload_0
    //   126: getfield d : Lcom/qiniu/pili/droid/shortvideo/gl/c/a;
    //   129: aload_0
    //   130: getfield j : I
    //   133: aload_0
    //   134: getfield k : I
    //   137: invokevirtual a : (II)Z
    //   140: pop
    //   141: aload_0
    //   142: new com/qiniu/pili/droid/shortvideo/gl/c/k
    //   145: dup
    //   146: invokespecial <init> : ()V
    //   149: putfield c : Lcom/qiniu/pili/droid/shortvideo/gl/c/k;
    //   152: aload_0
    //   153: getfield c : Lcom/qiniu/pili/droid/shortvideo/gl/c/k;
    //   156: invokevirtual b : ()Z
    //   159: pop
    //   160: aload_0
    //   161: getfield c : Lcom/qiniu/pili/droid/shortvideo/gl/c/k;
    //   164: aload_0
    //   165: getfield j : I
    //   168: aload_0
    //   169: getfield k : I
    //   172: invokevirtual a : (II)Z
    //   175: pop
    //   176: goto -> 190
    //   179: getstatic com/qiniu/pili/droid/shortvideo/f/e.j : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   182: ldc 'PreviewRenderer'
    //   184: ldc 'waiting for first render() to set texture size'
    //   186: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   189: return
    //   190: iconst_0
    //   191: istore_2
    //   192: aload_0
    //   193: getfield p : Z
    //   196: ifeq -> 236
    //   199: aload_0
    //   200: getfield n : Lcom/qiniu/pili/droid/shortvideo/PLVideoFilterListener;
    //   203: astore_1
    //   204: aload_1
    //   205: ifnull -> 403
    //   208: aload_1
    //   209: aload_0
    //   210: getfield l : I
    //   213: aload_0
    //   214: getfield h : I
    //   217: aload_0
    //   218: getfield i : I
    //   221: lload #4
    //   223: aload_0
    //   224: getfield m : [F
    //   227: invokeinterface onDrawFrame : (IIIJ[F)I
    //   232: istore_2
    //   233: goto -> 403
    //   236: aload_0
    //   237: getfield b : Lcom/qiniu/pili/droid/beauty/a;
    //   240: invokevirtual a : ()Z
    //   243: ifeq -> 292
    //   246: aload_0
    //   247: getfield b : Lcom/qiniu/pili/droid/beauty/a;
    //   250: aload_0
    //   251: getfield l : I
    //   254: aload_0
    //   255: getfield h : I
    //   258: aload_0
    //   259: getfield i : I
    //   262: lload #4
    //   264: aload_0
    //   265: getfield m : [F
    //   268: invokevirtual onDrawFrame : (IIIJ[F)I
    //   271: istore_2
    //   272: invokestatic glGetError : ()I
    //   275: pop
    //   276: aload_0
    //   277: getfield c : Lcom/qiniu/pili/droid/shortvideo/gl/c/k;
    //   280: iload_2
    //   281: aload_0
    //   282: getfield m : [F
    //   285: invokevirtual b : (I[F)I
    //   288: istore_2
    //   289: goto -> 308
    //   292: aload_0
    //   293: getfield d : Lcom/qiniu/pili/droid/shortvideo/gl/c/a;
    //   296: aload_0
    //   297: getfield l : I
    //   300: aload_0
    //   301: getfield m : [F
    //   304: invokevirtual b : (I[F)I
    //   307: istore_2
    //   308: iload_2
    //   309: istore_3
    //   310: aload_0
    //   311: getfield q : Z
    //   314: ifeq -> 368
    //   317: aload_0
    //   318: getfield f : Lcom/qiniu/pili/droid/shortvideo/gl/c/i;
    //   321: ifnonnull -> 359
    //   324: aload_0
    //   325: new com/qiniu/pili/droid/shortvideo/gl/c/i
    //   328: dup
    //   329: invokespecial <init> : ()V
    //   332: putfield f : Lcom/qiniu/pili/droid/shortvideo/gl/c/i;
    //   335: aload_0
    //   336: getfield f : Lcom/qiniu/pili/droid/shortvideo/gl/c/i;
    //   339: aload_0
    //   340: getfield h : I
    //   343: aload_0
    //   344: getfield i : I
    //   347: invokevirtual a : (II)Z
    //   350: pop
    //   351: aload_0
    //   352: getfield f : Lcom/qiniu/pili/droid/shortvideo/gl/c/i;
    //   355: invokevirtual b : ()Z
    //   358: pop
    //   359: aload_0
    //   360: getfield f : Lcom/qiniu/pili/droid/shortvideo/gl/c/i;
    //   363: iload_2
    //   364: invokevirtual a : (I)I
    //   367: istore_3
    //   368: aload_0
    //   369: getfield n : Lcom/qiniu/pili/droid/shortvideo/PLVideoFilterListener;
    //   372: astore_1
    //   373: aload_1
    //   374: ifnull -> 401
    //   377: aload_1
    //   378: iload_3
    //   379: aload_0
    //   380: getfield j : I
    //   383: aload_0
    //   384: getfield k : I
    //   387: lload #4
    //   389: getstatic com/qiniu/pili/droid/shortvideo/f/d.f : [F
    //   392: invokeinterface onDrawFrame : (IIIJ[F)I
    //   397: istore_2
    //   398: goto -> 403
    //   401: iload_3
    //   402: istore_2
    //   403: aload_0
    //   404: getfield e : Lcom/qiniu/pili/droid/shortvideo/gl/c/g;
    //   407: iload_2
    //   408: invokevirtual b : (I)V
    //   411: return
    //   412: getstatic com/qiniu/pili/droid/shortvideo/f/e.j : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   415: ldc 'PreviewRenderer'
    //   417: ldc 'update surface texture failed !!!'
    //   419: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   422: return
    //   423: astore_1
    //   424: goto -> 412
    // Exception table:
    //   from	to	target	type
    //   0	7	423	java/lang/Exception
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2) {
    e e = e.j;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onSurfaceChanged width:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" height:");
    stringBuilder.append(paramInt2);
    e.c("PreviewRenderer", stringBuilder.toString());
    this.b.onSurfaceChanged(paramInt1, paramInt2);
    GLES20.glGetError();
    this.e.a(paramInt1, paramInt2);
    PLVideoFilterListener pLVideoFilterListener = this.n;
    if (pLVideoFilterListener != null)
      pLVideoFilterListener.onSurfaceChanged(paramInt1, paramInt2); 
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig) {
    e.j.c("PreviewRenderer", "onSurfaceCreated");
    this.b.onSurfaceCreated();
    GLES20.glGetError();
    this.j = 0;
    this.k = 0;
    this.d = null;
    this.c = null;
    this.f = null;
    this.l = d.c();
    this.g = new SurfaceTexture(this.l);
    PLVideoFilterListener pLVideoFilterListener = this.n;
    if (pLVideoFilterListener != null)
      pLVideoFilterListener.onSurfaceCreated(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */