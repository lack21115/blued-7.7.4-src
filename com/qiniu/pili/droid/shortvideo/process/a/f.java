package com.qiniu.pili.droid.shortvideo.process.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaExtractor;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.PLVideoMixSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.core.q;
import com.qiniu.pili.droid.shortvideo.d.b;
import com.qiniu.pili.droid.shortvideo.f.d;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.g;
import com.qiniu.pili.droid.shortvideo.f.j;
import com.qiniu.pili.droid.shortvideo.gl.c.a;
import com.qiniu.pili.droid.shortvideo.gl.c.j;
import com.qiniu.pili.droid.shortvideo.gl.c.k;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.a;
import java.io.IOException;
import java.nio.ByteBuffer;

public class f {
  private static String a = "VideoMixer";
  
  private Context b;
  
  private q c;
  
  private PLVideoMixSetting d;
  
  private PLVideoEncodeSetting e;
  
  private String f;
  
  private String g;
  
  private b h;
  
  private MediaExtractor i;
  
  private SurfaceTexture j;
  
  private a k;
  
  private j l;
  
  private k m;
  
  private int n;
  
  private volatile long o;
  
  private volatile long p;
  
  private volatile boolean q;
  
  private volatile boolean r;
  
  private Object s = new Object();
  
  private float[] t = new float[16];
  
  private a u;
  
  private int v;
  
  private int w;
  
  private PLVideoFilterListener x = new PLVideoFilterListener(this) {
      public int onDrawFrame(int param1Int1, int param1Int2, int param1Int3, long param1Long, float[] param1ArrayOffloat) {
        f.c(this.a);
        synchronized (f.d(this.a)) {
          while (!f.e(this.a) && !f.f(this.a)) {
            f.d(this.a).notify();
            try {
              f.d(this.a).wait();
            } catch (InterruptedException interruptedException) {
              interruptedException.printStackTrace();
            } 
          } 
          param1Int2 = f.g(this.a);
          param1Int1 = f.i(this.a).a(param1Int1, param1Int2, f.h(this.a).isCameraAboveSample());
          synchronized (f.d(this.a)) {
            f.a(this.a, param1Long / 1000L);
            f f1 = this.a;
            if (f.j(this.a) >= f.k(this.a)) {
              boolean bool1 = true;
              f.a(f1, bool1);
              return param1Int1;
            } 
          } 
        } 
        boolean bool = false;
        f.a((f)SYNTHETIC_LOCAL_VARIABLE_8, bool);
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{F, dimension=1}, name=param1ArrayOffloat} */
        return param1Int1;
      }
      
      public void onSurfaceChanged(int param1Int1, int param1Int2) {}
      
      public void onSurfaceCreated() {
        f.a(this.a);
      }
      
      public void onSurfaceDestroy() {
        f.b(this.a);
      }
    };
  
  private b.c y = new b.c(this) {
      public void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long1, long param1Long2, boolean param1Boolean) {
        // Byte code:
        //   0: aload_0
        //   1: getfield a : Lcom/qiniu/pili/droid/shortvideo/process/a/f;
        //   4: invokestatic f : (Lcom/qiniu/pili/droid/shortvideo/process/a/f;)Z
        //   7: ifeq -> 11
        //   10: return
        //   11: aload_0
        //   12: getfield a : Lcom/qiniu/pili/droid/shortvideo/process/a/f;
        //   15: invokestatic d : (Lcom/qiniu/pili/droid/shortvideo/process/a/f;)Ljava/lang/Object;
        //   18: astore_1
        //   19: aload_1
        //   20: monitorenter
        //   21: iconst_1
        //   22: istore #8
        //   24: iload #7
        //   26: ifeq -> 51
        //   29: aload_0
        //   30: getfield a : Lcom/qiniu/pili/droid/shortvideo/process/a/f;
        //   33: iconst_1
        //   34: invokestatic b : (Lcom/qiniu/pili/droid/shortvideo/process/a/f;Z)Z
        //   37: pop
        //   38: aload_0
        //   39: getfield a : Lcom/qiniu/pili/droid/shortvideo/process/a/f;
        //   42: invokestatic d : (Lcom/qiniu/pili/droid/shortvideo/process/a/f;)Ljava/lang/Object;
        //   45: invokevirtual notify : ()V
        //   48: aload_1
        //   49: monitorexit
        //   50: return
        //   51: aload_0
        //   52: getfield a : Lcom/qiniu/pili/droid/shortvideo/process/a/f;
        //   55: lload #5
        //   57: invokestatic b : (Lcom/qiniu/pili/droid/shortvideo/process/a/f;J)J
        //   60: pop2
        //   61: aload_0
        //   62: getfield a : Lcom/qiniu/pili/droid/shortvideo/process/a/f;
        //   65: astore #9
        //   67: aload_0
        //   68: getfield a : Lcom/qiniu/pili/droid/shortvideo/process/a/f;
        //   71: invokestatic j : (Lcom/qiniu/pili/droid/shortvideo/process/a/f;)J
        //   74: aload_0
        //   75: getfield a : Lcom/qiniu/pili/droid/shortvideo/process/a/f;
        //   78: invokestatic k : (Lcom/qiniu/pili/droid/shortvideo/process/a/f;)J
        //   81: lcmp
        //   82: iflt -> 150
        //   85: iload #8
        //   87: istore #7
        //   89: goto -> 92
        //   92: aload #9
        //   94: iload #7
        //   96: invokestatic a : (Lcom/qiniu/pili/droid/shortvideo/process/a/f;Z)Z
        //   99: pop
        //   100: aload_0
        //   101: getfield a : Lcom/qiniu/pili/droid/shortvideo/process/a/f;
        //   104: invokestatic e : (Lcom/qiniu/pili/droid/shortvideo/process/a/f;)Z
        //   107: ifeq -> 140
        //   110: aload_0
        //   111: getfield a : Lcom/qiniu/pili/droid/shortvideo/process/a/f;
        //   114: invokestatic d : (Lcom/qiniu/pili/droid/shortvideo/process/a/f;)Ljava/lang/Object;
        //   117: invokevirtual notify : ()V
        //   120: aload_0
        //   121: getfield a : Lcom/qiniu/pili/droid/shortvideo/process/a/f;
        //   124: invokestatic d : (Lcom/qiniu/pili/droid/shortvideo/process/a/f;)Ljava/lang/Object;
        //   127: invokevirtual wait : ()V
        //   130: goto -> 140
        //   133: astore #9
        //   135: aload #9
        //   137: invokevirtual printStackTrace : ()V
        //   140: aload_1
        //   141: monitorexit
        //   142: return
        //   143: astore #9
        //   145: aload_1
        //   146: monitorexit
        //   147: aload #9
        //   149: athrow
        //   150: iconst_0
        //   151: istore #7
        //   153: goto -> 92
        // Exception table:
        //   from	to	target	type
        //   29	50	143	finally
        //   51	85	143	finally
        //   92	120	143	finally
        //   120	130	133	java/lang/InterruptedException
        //   120	130	143	finally
        //   135	140	143	finally
        //   140	142	143	finally
        //   145	147	143	finally
      }
    };
  
  public f(Context paramContext, PLVideoMixSetting paramPLVideoMixSetting, PLVideoEncodeSetting paramPLVideoEncodeSetting, String paramString1, String paramString2) {
    this.b = paramContext;
    this.d = paramPLVideoMixSetting;
    this.f = paramString1;
    this.g = paramString2;
    this.e = paramPLVideoEncodeSetting;
  }
  
  private int b() {
    d();
    e();
    try {
      this.j.updateTexImage();
      this.j.getTransformMatrix(this.t);
      int i = this.k.b(this.n, this.t);
      return this.m.a(i);
    } catch (Exception exception) {
      return 0;
    } 
  }
  
  private void c() {
    if (this.l == null) {
      this.l = new j();
      this.l.a(this.d);
      this.l.a(this.e.getVideoEncodingWidth(), this.e.getVideoEncodingHeight());
      this.l.b();
    } 
  }
  
  private void d() {
    if (this.k == null) {
      this.k = new a();
      this.k.a(this.v, this.w);
      this.k.b();
    } 
  }
  
  private void e() {
    if (this.m == null) {
      this.m = new k();
      this.m.a(this.d.getSampleVideoRect().width(), this.d.getSampleVideoRect().height());
      int i = j.b(g.d(this.d.getSampleVideoPath()));
      if (i == 90 || i == 270) {
        this.m.a(this.w, this.v, this.d.getSampleDisplayMode());
        return;
      } 
      this.m.a(this.v, this.w, this.d.getSampleDisplayMode());
      return;
    } 
  }
  
  private void f() {
    e.g.c(a, "startSampleExtractor +");
    this.n = d.c();
    this.j = new SurfaceTexture(this.n);
    Surface surface = new Surface(this.j);
    int i = g.b(this.i, "video/");
    if (i >= 0) {
      this.i.selectTrack(i);
      MediaExtractor mediaExtractor = this.i;
      this.h = new b(mediaExtractor, mediaExtractor.getTrackFormat(i));
      this.h.a(this.y);
      this.h.a(surface);
      this.h.a(false);
      this.h.a(new b.b(this) {
            public void a() {
              if (f.l(this.a) != null) {
                f.l(this.a).release();
                f.a(this.a, (SurfaceTexture)null);
              } 
            }
          });
      this.h.a();
    } 
    e.g.c(a, "startSampleExtractor -");
  }
  
  private void g() {
    e.g.c(a, "releaseSampleExtractor +");
    this.r = true;
    synchronized (this.s) {
      this.s.notify();
      null = this.h;
      if (null != null) {
        null.c();
        this.h = null;
      } 
      null = this.l;
      if (null != null) {
        null.f();
        this.l = null;
      } 
      null = this.k;
      if (null != null) {
        null.f();
        this.k = null;
      } 
      null = this.m;
      if (null != null) {
        null.f();
        this.m = null;
      } 
      this.p = 0L;
      this.o = 0L;
      this.q = false;
      e.g.c(a, "releaseSampleExtractor -");
      return;
    } 
  }
  
  public void a() {
    this.c.a();
  }
  
  public void a(PLVideoSaveListener paramPLVideoSaveListener) {
    e.g.c(a, "save +");
    this.r = false;
    this.q = false;
    this.o = 0L;
    this.p = 0L;
    this.v = g.b(this.d.getSampleVideoPath());
    this.w = g.c(this.d.getSampleVideoPath());
    this.i = new MediaExtractor();
    try {
      this.i.setDataSource(this.d.getSampleVideoPath());
      this.c = new q(this.b, this.f, this.g);
      this.c.a(this.e);
      this.c.a(this.x, false);
      a a1 = this.u;
      if (a1 != null)
        this.c.a(a1); 
      this.c.a(this.e.getVideoEncodingWidth(), this.e.getVideoEncodingHeight(), this.e.getEncodingBitrate(), paramPLVideoSaveListener);
      e.g.c(a, "save -");
      return;
    } catch (IOException iOException) {
      e e = e.g;
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sample media extractor setDataSource error , path is : ");
      stringBuilder.append(this.d.getSampleVideoPath());
      e.e(str, stringBuilder.toString());
      e.g.e(a, iOException.getMessage());
      return;
    } 
  }
  
  public void a(a parama) {
    this.u = parama;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\process\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */