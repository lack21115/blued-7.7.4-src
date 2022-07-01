package com.qiniu.pili.droid.shortvideo.e;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.f.d;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.gl.c.a;
import com.qiniu.pili.droid.shortvideo.gl.c.g;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class b implements SurfaceTexture.OnFrameAvailableListener, MediaPlayer.OnCompletionListener, GLSurfaceView.Renderer {
  private Queue<Runnable> A = new LinkedList<Runnable>();
  
  private boolean B;
  
  private WeakReference<GLSurfaceView> a;
  
  private MediaPlayer b;
  
  private int c;
  
  private int d;
  
  private float e = 1.0F;
  
  private double f = 1.0D;
  
  private Surface g;
  
  private SurfaceTexture h;
  
  private int i;
  
  private float[] j = new float[16];
  
  private String k;
  
  private boolean l = true;
  
  private boolean m = false;
  
  private long n = -1L;
  
  private a o;
  
  private g p = new g();
  
  private PLVideoFilterListener q;
  
  private MediaPlayer.OnCompletionListener r;
  
  private PLDisplayMode s = PLDisplayMode.FIT;
  
  private volatile boolean t;
  
  private volatile boolean u;
  
  private int v;
  
  private int w;
  
  private volatile boolean x;
  
  private int y = 0;
  
  private Object z = new Object();
  
  public b(GLSurfaceView paramGLSurfaceView) {
    this.a = new WeakReference<GLSurfaceView>(paramGLSurfaceView);
    paramGLSurfaceView.setEGLContextClientVersion(2);
    paramGLSurfaceView.setRenderer(this);
    paramGLSurfaceView.setRenderMode(0);
  }
  
  private void b(int paramInt1, int paramInt2) {
    synchronized (this.z) {
      if (this.b != null) {
        this.p = new g();
        this.p.a(this.v, this.w);
        int i = paramInt1;
        if (paramInt1 == 0)
          if (q()) {
            i = this.b.getVideoHeight();
          } else {
            i = this.b.getVideoWidth();
          }  
        paramInt1 = paramInt2;
        if (paramInt2 == 0)
          if (q()) {
            paramInt1 = this.b.getVideoWidth();
          } else {
            paramInt1 = this.b.getVideoHeight();
          }  
        this.p.a(i, paramInt1, this.s);
      } 
      return;
    } 
  }
  
  private void c(int paramInt1, int paramInt2) {
    this.c = paramInt1;
    this.d = paramInt2;
    this.o.a(paramInt1, paramInt2);
    e e = e.k;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("video size: ");
    stringBuilder.append(paramInt1);
    stringBuilder.append("x");
    stringBuilder.append(paramInt2);
    e.c("FilterVideoPlayer", stringBuilder.toString());
  }
  
  private void k() {
    this.b.stop();
    this.b.release();
    this.b = null;
  }
  
  private void l() {
    this.i = d.c();
    this.h = new SurfaceTexture(this.i);
    this.h.setOnFrameAvailableListener(this);
    this.o = new a();
    this.o.b();
  }
  
  private void m() {
    n();
    SurfaceTexture surfaceTexture = this.h;
    if (surfaceTexture != null) {
      surfaceTexture.release();
      this.h = null;
    } 
    a a1 = this.o;
    if (a1 != null) {
      a1.f();
      this.o = null;
    } 
    this.g = null;
  }
  
  private void n() {
    this.p.f();
  }
  
  private void o() {
    synchronized (this.z) {
      this.b = new MediaPlayer();
      this.b.setOnCompletionListener(this);
      this.b.setSurface(p());
      this.b.setOnPreparedListener(new MediaPlayer.OnPreparedListener(this) {
            public void onPrepared(MediaPlayer param1MediaPlayer) {
              if (b.a(this.a))
                b.b(this.a).seekTo(1); 
            }
          });
      try {
        int i;
        int j;
        this.b.setDataSource(this.k);
        this.b.prepare();
        a(this.e);
        if (q()) {
          i = this.b.getVideoHeight();
        } else {
          i = this.b.getVideoWidth();
        } 
        if (q()) {
          j = this.b.getVideoWidth();
        } else {
          j = this.b.getVideoHeight();
        } 
        c(i, j);
        this.n = -1L;
        if (this.u) {
          this.u = false;
          this.b.start();
          a(this.f);
        } 
      } catch (Exception exception) {
        e.k.e("FilterVideoPlayer", "init or start media player failed, set to null.");
        this.b = null;
      } 
      return;
    } 
  }
  
  private Surface p() {
    if (this.g == null) {
      SurfaceTexture surfaceTexture = this.h;
      if (surfaceTexture != null)
        this.g = new Surface(surfaceTexture); 
    } 
    return this.g;
  }
  
  private boolean q() {
    int i = this.y;
    return (i == 90 || i == 270);
  }
  
  public void a() {
    e.k.c("FilterVideoPlayer", "start +");
    if (this.x)
      d(); 
    synchronized (this.z) {
      if (this.b != null) {
        if (this.b.isPlaying()) {
          e.k.d("FilterVideoPlayer", "already started !");
        } else {
          this.b.start();
        } 
        return;
      } 
      this.u = true;
      null = this.a.get();
      if (null == null) {
        e.k.d("FilterVideoPlayer", "glSurfaceView released !");
        return;
      } 
      null.onResume();
      e.k.c("FilterVideoPlayer", "start -");
      return;
    } 
  }
  
  public void a(double paramDouble) {
    if (Build.VERSION.SDK_INT >= 23) {
      PlaybackParams playbackParams = new PlaybackParams();
      playbackParams.setSpeed((float)paramDouble);
      try {
        this.b.setPlaybackParams(playbackParams);
        this.f = paramDouble;
      } catch (Exception exception) {
        e e1 = e.k;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("the player can't support this params : speed is ");
        stringBuilder1.append(paramDouble);
        e1.e("FilterVideoPlayer", stringBuilder1.toString());
        e.k.e("FilterVideoPlayer", exception.getMessage());
      } 
      e e = e.k;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setSpeed ");
      stringBuilder.append(paramDouble);
      e.c("FilterVideoPlayer", stringBuilder.toString());
    } 
  }
  
  public void a(float paramFloat) {
    synchronized (this.z) {
      this.e = paramFloat;
      if (this.b == null) {
        e.k.d("FilterVideoPlayer", "not playing !");
        return;
      } 
      this.b.setVolume(paramFloat, paramFloat);
      null = e.k;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("set volume: ");
      stringBuilder.append(paramFloat);
      null.b("FilterVideoPlayer", stringBuilder.toString());
      return;
    } 
  }
  
  public void a(int paramInt) {
    int i;
    this.y = paramInt;
    if (q()) {
      paramInt = this.b.getVideoHeight();
    } else {
      paramInt = this.b.getVideoWidth();
    } 
    if (q()) {
      i = this.b.getVideoWidth();
    } else {
      i = this.b.getVideoHeight();
    } 
    f();
    a(paramInt, i);
    a();
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.A.add(new Runnable(this, paramInt1, paramInt2) {
          public void run() {
            e e = e.k;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("content resize width: ");
            stringBuilder.append(this.a);
            stringBuilder.append(" height: ");
            stringBuilder.append(this.b);
            e.c("FilterVideoPlayer", stringBuilder.toString());
            b.k(this.c);
            b.a(this.c, this.a, this.b);
          }
        });
  }
  
  public void a(MediaPlayer.OnCompletionListener paramOnCompletionListener) {
    this.r = paramOnCompletionListener;
  }
  
  public void a(PLDisplayMode paramPLDisplayMode) {
    this.s = paramPLDisplayMode;
  }
  
  public void a(PLVideoFilterListener paramPLVideoFilterListener) {
    this.q = paramPLVideoFilterListener;
  }
  
  public void a(String paramString) {
    this.k = paramString;
  }
  
  public void a(boolean paramBoolean) {
    this.t = paramBoolean;
  }
  
  public void b() {
    e.k.c("FilterVideoPlayer", "pause +");
    synchronized (this.z) {
      if (this.b == null || !this.b.isPlaying()) {
        e.k.d("FilterVideoPlayer", "not playing !");
        return;
      } 
      this.b.pause();
      e.k.c("FilterVideoPlayer", "pause -");
      return;
    } 
  }
  
  public void b(int paramInt) {
    e.k.c("FilterVideoPlayer", "seekTo +");
    synchronized (this.z) {
      if (this.b == null) {
        e.k.d("FilterVideoPlayer", "not playing !");
        return;
      } 
      this.m = true;
      if (Build.VERSION.SDK_INT < 26) {
        this.b.seekTo(paramInt);
      } else {
        this.b.seekTo(paramInt, 3);
      } 
      e.k.c("FilterVideoPlayer", "seekTo -");
      return;
    } 
  }
  
  public void b(String paramString) {
    e.k.c("FilterVideoPlayer", "resetDataSource");
    this.k = paramString;
    synchronized (this.z) {
      if (this.b != null) {
        if (this.b.isPlaying())
          this.b.stop(); 
        this.b.reset();
        try {
          this.b.setDataSource(this.k);
          this.b.prepare();
          this.b.setOnPreparedListener(new MediaPlayer.OnPreparedListener(this) {
                public void onPrepared(MediaPlayer param1MediaPlayer) {
                  this.a.a(0, 0);
                  if (b.a(this.a))
                    b.b(this.a).seekTo(1); 
                }
              });
        } catch (Exception exception) {
          e.k.e("FilterVideoPlayer", "reset data source error !");
        } 
      } 
      return;
    } 
  }
  
  public void b(boolean paramBoolean) {
    this.l = paramBoolean;
  }
  
  public void c() {
    e.k.c("FilterVideoPlayer", "resume +");
    synchronized (this.z) {
      if (this.b == null || this.b.isPlaying()) {
        e.k.d("FilterVideoPlayer", "not in pause state !");
        return;
      } 
      this.b.start();
      e.k.c("FilterVideoPlayer", "resume -");
      return;
    } 
  }
  
  public void d() {
    e.k.c("FilterVideoPlayer", "startMediaPlayer");
    GLSurfaceView gLSurfaceView = this.a.get();
    if (gLSurfaceView == null) {
      e.k.d("FilterVideoPlayer", "glSurfaceView released !");
      return;
    } 
    gLSurfaceView.queueEvent(new Runnable(this) {
          public void run() {
            if (b.c(this.a) != null) {
              b.c(this.a).release();
              b.a(this.a, (SurfaceTexture)null);
            } 
            if (b.d(this.a) != null) {
              b.d(this.a).release();
              b.a(this.a, (Surface)null);
            } 
            b.a(this.a, d.c());
            b b1 = this.a;
            b.a(b1, new SurfaceTexture(b.e(b1)));
            b.c(this.a).setOnFrameAvailableListener(this.a);
            b1 = this.a;
            b.a(b1, new Surface(b.c(b1)));
            b.a(this.a, true);
            synchronized (b.f(this.a)) {
              if (b.b(this.a) != null)
                b.g(this.a); 
              b.h(this.a);
              b.b(this.a, false);
              return;
            } 
          }
        });
  }
  
  public void e() {
    e.k.c("FilterVideoPlayer", "stopMediaPlayer");
    synchronized (this.z) {
      if (this.b != null) {
        k();
        this.x = true;
      } 
      return;
    } 
  }
  
  public void f() {
    e.k.c("FilterVideoPlayer", "stop +");
    GLSurfaceView gLSurfaceView = this.a.get();
    if (!this.x) {
      synchronized (this.z) {
        if (this.b == null || gLSurfaceView == null)
          return; 
        k();
      } 
    } else {
      this.x = false;
    } 
    this.c = 0;
    this.d = 0;
    gLSurfaceView.queueEvent(new Runnable(this) {
          public void run() {
            b.i(this.a);
            if (b.j(this.a) != null)
              b.j(this.a).onSurfaceDestroy(); 
          }
        });
    gLSurfaceView.onPause();
    e.k.c("FilterVideoPlayer", "stop -");
  }
  
  public int g() {
    return this.p.l();
  }
  
  public int h() {
    return this.p.m();
  }
  
  public int i() {
    synchronized (this.z) {
      if (this.b == null) {
        e.k.d("FilterVideoPlayer", "not playing !");
        return -1;
      } 
      return this.b.getCurrentPosition();
    } 
  }
  
  public float j() {
    return this.e;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer) {
    this.m = true;
    synchronized (this.z) {
      if (this.l && this.b != null)
        this.b.start(); 
      null = this.r;
      if (null != null)
        null.onCompletion(paramMediaPlayer); 
      return;
    } 
  }
  
  public void onDrawFrame(GL10 paramGL10) {
    try {
      this.h.updateTexImage();
      long l1 = this.h.getTimestamp();
      long l2 = this.n;
      int i = 0;
      if (l1 < l2) {
        if (!this.m) {
          e e = e.k;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("timestamp, this frame: ");
          stringBuilder.append(l1);
          stringBuilder.append(" smaller than last frame: ");
          stringBuilder.append(this.n);
          stringBuilder.append(", dropped.");
          e.d("FilterVideoPlayer", stringBuilder.toString());
          return;
        } 
        this.m = false;
      } 
      this.n = l1;
      this.h.getTransformMatrix(this.j);
      if (this.t) {
        PLVideoFilterListener pLVideoFilterListener = this.q;
        if (pLVideoFilterListener != null)
          i = pLVideoFilterListener.onDrawFrame(this.i, this.c, this.d, l1, this.j); 
      } else {
        int j = this.o.c(this.i, this.j, this.y);
        PLVideoFilterListener pLVideoFilterListener = this.q;
        i = j;
        if (pLVideoFilterListener != null)
          i = pLVideoFilterListener.onDrawFrame(j, this.c, this.d, l1, d.f); 
      } 
      while (!this.A.isEmpty())
        ((Runnable)this.A.remove()).run(); 
      GLES20.glClear(16384);
      this.p.b(i);
      return;
    } catch (Exception exception) {
      e.k.e("FilterVideoPlayer", "update surface texture failed !!!");
      return;
    } 
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {
    GLSurfaceView gLSurfaceView = this.a.get();
    if (gLSurfaceView != null)
      gLSurfaceView.requestRender(); 
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2) {
    e e = e.k;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onSurfaceChanged width:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" height:");
    stringBuilder.append(paramInt2);
    e.c("FilterVideoPlayer", stringBuilder.toString());
    this.v = paramInt1;
    this.w = paramInt2;
    n();
    b(0, 0);
    PLVideoFilterListener pLVideoFilterListener = this.q;
    if (pLVideoFilterListener != null)
      pLVideoFilterListener.onSurfaceChanged(paramInt1, paramInt2); 
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig) {
    e.k.c("FilterVideoPlayer", "onSurfaceCreated");
    this.n = -1L;
    l();
    o();
    PLVideoFilterListener pLVideoFilterListener = this.q;
    if (pLVideoFilterListener != null)
      pLVideoFilterListener.onSurfaceCreated(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */