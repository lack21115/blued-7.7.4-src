package com.qiniu.pili.droid.shortvideo.gl.c;

import android.graphics.SurfaceTexture;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.d.b;
import com.qiniu.pili.droid.shortvideo.f.d;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.g;
import java.io.IOException;
import java.nio.ByteBuffer;

public class c extends g {
  private volatile boolean A;
  
  private final Object B = new Object();
  
  private volatile boolean C = false;
  
  private volatile boolean D = false;
  
  private final Object E = new Object();
  
  private final Object F = new Object();
  
  private HandlerThread G;
  
  private volatile long H;
  
  private volatile long I;
  
  private volatile long J;
  
  private boolean K = true;
  
  private b.c L = new b.c(this) {
      public void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long1, long param1Long2, boolean param1Boolean) {
        synchronized (c.d(this.a)) {
          if (param1Long2 >= c.e(this.a)) {
            param1Int = 1;
          } else {
            param1Int = 0;
          } 
          e e = e.e;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("MV timestampUs:");
          stringBuilder.append(param1Long2);
          stringBuilder.append(", prev video timestamp:");
          stringBuilder.append(c.e(this.a));
          stringBuilder.append(", first frame:");
          stringBuilder.append(c.f(this.a));
          e.c("MVEffect", stringBuilder.toString());
          if (c.f(this.a) || param1Int != 0) {
            c.b(this.a, true);
            c.a(this.a, param1Long2);
            try {
              synchronized (c.g(this.a)) {
                c.g(this.a).notify();
                c.d(this.a).wait();
              } 
            } catch (InterruptedException interruptedException) {
              interruptedException.printStackTrace();
            } 
          } 
          return;
        } 
      }
    };
  
  private b.c M = new b.c(this) {
      public void a(ByteBuffer param1ByteBuffer, int param1Int, long param1Long1, long param1Long2, boolean param1Boolean) {
        synchronized (c.d(this.a)) {
          if (param1Long2 >= c.e(this.a)) {
            param1Int = 1;
          } else {
            param1Int = 0;
          } 
          param1Boolean = c.f(this.a);
          if (param1Boolean || param1Int != 0)
            try {
              c.c(this.a, true);
              synchronized (c.g(this.a)) {
                c.g(this.a).notify();
                c.d(this.a).wait();
              } 
            } catch (InterruptedException interruptedException) {
              interruptedException.printStackTrace();
            }  
          return;
        } 
      }
    };
  
  private int a;
  
  private float[] b = new float[16];
  
  private int c;
  
  private int d;
  
  private k e;
  
  private String f;
  
  private b o;
  
  private SurfaceTexture p;
  
  private a q;
  
  private int r;
  
  private int s;
  
  private String t;
  
  private b u;
  
  private SurfaceTexture v;
  
  private a w;
  
  private int x;
  
  private int y;
  
  private int z;
  
  public c(String paramString1, String paramString2) {
    this.f = paramString1;
    this.t = paramString2;
  }
  
  private int a(int paramInt) {
    paramInt = this.e.a(paramInt);
    GLES20.glBlendEquationSeparate(32774, 32774);
    GLES20.glBlendFuncSeparate(1, 771, 1, 1);
    GLES20.glEnable(3042);
    GLES20.glBindFramebuffer(36160, this.a);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt, 0);
    b(this.s);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDisable(3042);
    return paramInt;
  }
  
  private int a(MediaExtractor paramMediaExtractor, String paramString) {
    int j = paramMediaExtractor.getTrackCount();
    for (int i = 0; i < j; i++) {
      MediaFormat mediaFormat = paramMediaExtractor.getTrackFormat(i);
      String str = mediaFormat.getString("mime");
      if (str.startsWith(paramString)) {
        e e = e.e;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Extractor selected track ");
        stringBuilder.append(i);
        stringBuilder.append(" (");
        stringBuilder.append(str);
        stringBuilder.append("): ");
        stringBuilder.append(mediaFormat);
        e.c("MVEffect", stringBuilder.toString());
        return i;
      } 
    } 
    return -1;
  }
  
  private void h() {
    this.p = new SurfaceTexture(this.r);
    Surface surface = new Surface(this.p);
    MediaExtractor mediaExtractor = new MediaExtractor();
    try {
      mediaExtractor.setDataSource(this.f);
      int i = a(mediaExtractor, "video/");
      if (i >= 0) {
        mediaExtractor.selectTrack(i);
        this.o = new b(mediaExtractor, mediaExtractor.getTrackFormat(i));
        this.o.a(this.f);
        this.o.a(this.L);
        this.o.a(surface);
        this.o.a(true);
        this.o.a();
        return;
      } 
    } catch (IOException iOException) {
      e.e.e("MVEffect", iOException.getMessage());
    } 
  }
  
  private void t() {
    this.v = new SurfaceTexture(this.y);
    Surface surface = new Surface(this.v);
    MediaExtractor mediaExtractor = new MediaExtractor();
    try {
      mediaExtractor.setDataSource(this.t);
      int i = a(mediaExtractor, "video/");
      if (i >= 0) {
        mediaExtractor.selectTrack(i);
        this.u = new b(mediaExtractor, mediaExtractor.getTrackFormat(i));
        this.u.a(this.M);
        this.u.a(surface);
        this.u.a(true);
        this.u.a();
        return;
      } 
    } catch (IOException iOException) {
      e.e.e("MVEffect", iOException.getMessage());
    } 
  }
  
  private boolean u() {
    if (this.q == null) {
      this.q = new a();
      this.q.a(this.c, this.d);
      this.q.b();
    } 
    if (this.w == null) {
      this.w = new a();
      this.w.a(this.c, this.d);
      this.w.b();
    } 
    try {
      this.p.updateTexImage();
      this.v.updateTexImage();
      this.p.getTransformMatrix(this.b);
      this.s = this.q.b(this.r, this.b);
      this.v.getTransformMatrix(this.b);
      this.z = this.w.b(this.y, this.b);
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private void v() {
    synchronized (this.E) {
      while (true) {
        if (!this.C || !this.D) {
          try {
            this.E.wait();
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
          } 
          continue;
        } 
        return;
      } 
    } 
  }
  
  private void w() {
    synchronized (this.F) {
      this.C = false;
      this.D = false;
      this.F.notifyAll();
      return;
    } 
  }
  
  public int a(int paramInt, long paramLong) {
    boolean bool1 = this.K;
    boolean bool = false;
    if (bool1) {
      v();
      if (!u())
        return paramInt; 
      this.K = false;
      this.H = paramLong;
    } else {
      if (paramLong == -1L) {
        this.I = this.J + 1L;
      } else if (this.H == 0L) {
        this.H = paramLong;
      } else {
        this.I = paramLong - this.H;
      } 
      if (this.I > this.J)
        bool = true; 
      if (bool) {
        w();
        v();
        if (!u())
          return paramInt; 
      } 
    } 
    paramInt = a(paramInt);
    e e = e.e;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Current video frame:");
    stringBuilder.append(this.I);
    stringBuilder.append(" with mv:");
    stringBuilder.append(this.J);
    e.c("MVEffect", stringBuilder.toString());
    return paramInt;
  }
  
  protected String[] a() {
    return new String[] { "attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform sampler2D u_tex_mv;\nuniform sampler2D u_tex_mask;\nvarying vec2 v_tex_coord;\nvoid main() {\n   vec4 mv_color = texture2D(u_tex_mv, v_tex_coord);\n   vec4 mask_color = texture2D(u_tex_mask, v_tex_coord);\n   float new_alpha = dot(mask_color.rgb, vec3(.33333334, .33333334, .33333334)) * mask_color.a;\n   gl_FragColor = mv_color * new_alpha;\n}\n" };
  }
  
  public int b(int paramInt, long paramLong) {
    this.I = paramLong;
    boolean bool1 = this.K;
    boolean bool = false;
    if (bool1) {
      v();
      if (!u())
        return paramInt; 
      this.K = false;
    } else {
      if (this.I > this.J)
        bool = true; 
      if (bool) {
        w();
        v();
        if (!u())
          return paramInt; 
      } 
    } 
    return a(paramInt);
  }
  
  public boolean b(int paramInt1, int paramInt2) {
    this.a = d.e();
    this.r = d.c();
    this.y = d.c();
    this.c = g.b(this.f);
    this.d = g.c(this.f);
    this.e = new k();
    this.e.a(this.c, this.d);
    this.e.a(paramInt1, paramInt2, PLDisplayMode.FIT);
    this.G = new HandlerThread("MVEffect");
    this.G.start();
    if ((new Handler(this.G.getLooper())).post(new Runnable(this) {
          public void run() {
            c.a(this.a);
            c.b(this.a);
            synchronized (c.c(this.a)) {
              c.a(this.a, true);
              c.c(this.a).notify();
              return;
            } 
          }
        }))
      synchronized (this.B) {
        while (true) {
          boolean bool = this.A;
          if (!bool) {
            try {
              this.B.wait();
            } catch (InterruptedException interruptedException) {
              interruptedException.printStackTrace();
            } 
            continue;
          } 
          break;
        } 
      }  
    return b();
  }
  
  protected boolean c() {
    this.x = GLES20.glGetUniformLocation(this.l, "u_tex_mask");
    return super.c();
  }
  
  protected void d() {
    super.d();
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.z);
    GLES20.glUniform1i(this.x, 1);
  }
  
  protected void e() {
    super.e();
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, 0);
  }
  
  public void f() {
    super.f();
    b b1 = this.o;
    if (b1 != null) {
      b1.c();
      this.o = null;
    } 
    b1 = this.u;
    if (b1 != null) {
      b1.c();
      this.u = null;
    } 
    synchronized (this.F) {
      this.C = false;
      this.D = false;
      this.F.notifyAll();
      null = this.G;
      if (null != null) {
        null.quitSafely();
        this.G = null;
      } 
      null = this.p;
      if (null != null) {
        null.release();
        this.p = null;
      } 
      null = this.v;
      if (null != null) {
        null.release();
        this.v = null;
      } 
      null = this.q;
      if (null != null) {
        null.f();
        this.q = null;
      } 
      null = this.w;
      if (null != null) {
        null.f();
        this.w = null;
      } 
      null = this.e;
      if (null != null) {
        null.f();
        this.e = null;
      } 
      this.H = 0L;
      this.I = 0L;
      this.J = 0L;
      this.K = true;
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\gl\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */