package com.blued.android.module.live_china.zegoVideoCapture;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.Surface;
import com.blued.android.module.external_sense_library.contract.ISenseTimeProcessor;
import com.blued.android.module.external_sense_library.display.STGLRender;
import com.blued.android.module.external_sense_library.glutils.GlUtil;
import com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase;
import com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase14;
import com.zego.zegoavkit2.videofilter.ZegoVideoFilter;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;

public class VideoFilterSurfaceTexture extends ZegoVideoFilter implements SurfaceTexture.OnFrameAvailableListener {
  private ZegoVideoFilter.Client a = null;
  
  private ISenseTimeProcessor b;
  
  private HandlerThread c = null;
  
  private volatile Handler d = null;
  
  private EglBase e = null;
  
  private EglBase f = null;
  
  private int g = 0;
  
  private int h = 0;
  
  private int i = 0;
  
  private int j = 0;
  
  private SurfaceTexture k = null;
  
  private int l = 0;
  
  private int m = 0;
  
  private Surface n = null;
  
  private boolean o = false;
  
  private boolean p = false;
  
  private STGLRender q = null;
  
  private ByteBuffer r;
  
  private boolean s = false;
  
  VideoFilterSurfaceTexture(Context paramContext, ISenseTimeProcessor paramISenseTimeProcessor) {
    this.b = paramISenseTimeProcessor;
  }
  
  private void a() {
    if (this.s)
      return; 
    this.k.release();
    this.k = null;
    this.q.destroyFrameBuffers();
    this.e.f();
    int i = this.l;
    if (i != 0) {
      GLES20.glDeleteTextures(1, new int[] { i }, 0);
      this.l = 0;
    } 
    this.e.e();
    this.e = null;
    if (this.f.c()) {
      this.f.f();
      i = this.m;
      if (i != 0) {
        GLES20.glDeleteTextures(1, new int[] { i }, 0);
        this.m = 0;
      } 
    } 
    this.f.e();
    this.f = null;
    Surface surface = this.n;
    if (surface != null) {
      surface.release();
      this.n = null;
    } 
  }
  
  private void a(int paramInt1, int paramInt2) {
    if (this.s)
      return; 
    this.i = paramInt1;
    this.j = paramInt2;
    this.g = paramInt1;
    this.h = paramInt2;
    GLES20.glViewport(0, 0, this.i, this.j);
    this.q.calculateZegoVertexBuffer(this.i, this.j, this.g, this.h);
  }
  
  private void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {
    if (this.s)
      return; 
    this.p = true;
    if (this.f.c()) {
      this.f.f();
      int i = this.m;
      if (i != 0) {
        GLES20.glDeleteTextures(1, new int[] { i }, 0);
        this.m = 0;
        this.k.detachFromGLContext();
      } 
      this.f.h();
      this.f.d();
      this.f.g();
    } 
    Surface surface = this.n;
    if (surface != null) {
      surface.release();
      this.n = null;
    } 
    if (Build.VERSION.SDK_INT >= 15)
      paramSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2); 
    this.n = new Surface(paramSurfaceTexture);
    this.i = paramInt1;
    this.j = paramInt2;
    this.f.a(this.n);
    this.f.f();
    this.q.destroyFrameBuffers();
    this.q.destroyResizeFrameBuffers();
    this.q.adjustZegoTextureBuffer(0, false, true);
    a(paramInt1, paramInt2);
    this.q.init(this.g, this.h);
    this.f.g();
    this.p = false;
  }
  
  public void allocateAndStart(ZegoVideoFilter.Client paramClient) {
    STGLRender sTGLRender = this.q;
    if (sTGLRender != null)
      sTGLRender.destroyFrameBuffers(); 
    this.q = new STGLRender(false);
    this.a = paramClient;
    this.c = new HandlerThread("video-filter");
    this.c.start();
    this.d = new Handler(this.c.getLooper());
    this.g = 0;
    this.h = 0;
    CountDownLatch countDownLatch = new CountDownLatch(1);
    this.d.post(new Runnable(this, countDownLatch) {
          public void run() {
            try {
              VideoFilterSurfaceTexture.a(this.b, EglBase.a(null, EglBase.f));
              VideoFilterSurfaceTexture.a(this.b).a();
              VideoFilterSurfaceTexture.a(this.b).f();
              VideoFilterSurfaceTexture.a(this.b, false);
              VideoFilterSurfaceTexture.a(this.b, GlUtil.a(36197));
              VideoFilterSurfaceTexture videoFilterSurfaceTexture = this.b;
              VideoFilterSurfaceTexture.a(videoFilterSurfaceTexture, new SurfaceTexture(VideoFilterSurfaceTexture.b(videoFilterSurfaceTexture)));
              VideoFilterSurfaceTexture.c(this.b).setOnFrameAvailableListener(this.b);
              VideoFilterSurfaceTexture.c(this.b).detachFromGLContext();
              VideoFilterSurfaceTexture.d(this.b).adjustZegoTextureBuffer(0, false, true);
              videoFilterSurfaceTexture = this.b;
              VideoFilterSurfaceTexture.b(videoFilterSurfaceTexture, EglBase.a(VideoFilterSurfaceTexture.a(videoFilterSurfaceTexture).b(), EglBase.h));
              VideoFilterSurfaceTexture.b(this.b, EglBase14.i());
              Log.i("==record", "onSurfaceCreated");
              VideoFilterSurfaceTexture.e(this.b).onSurfaceCreated();
              this.a.countDown();
              return;
            } catch (RuntimeException runtimeException) {
              VideoFilterSurfaceTexture.a(this.b).d();
              VideoFilterSurfaceTexture.a(this.b, true);
              return;
            } 
          }
        });
    try {
      countDownLatch.await();
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
    } 
    this.p = false;
  }
  
  public int dequeueInputBuffer(int paramInt1, int paramInt2, int paramInt3) {
    if (this.s)
      return -1; 
    if (paramInt3 != paramInt1 * 4)
      return -1; 
    if (this.g != paramInt1 || this.h != paramInt2) {
      if (this.a.dequeueInputBuffer(paramInt1, paramInt2, paramInt3) < 0)
        return -1; 
      this.g = paramInt1;
      this.h = paramInt2;
      SurfaceTexture surfaceTexture = this.a.getSurfaceTexture();
      CountDownLatch countDownLatch = new CountDownLatch(1);
      this.d.post(new Runnable(this, surfaceTexture, paramInt1, paramInt2, countDownLatch) {
            public void run() {
              VideoFilterSurfaceTexture.a(this.e, this.a, this.b, this.c);
              VideoFilterSurfaceTexture.e(this.e).adjustViewPort(this.b, this.c);
              this.d.countDown();
            }
          });
      try {
        countDownLatch.await();
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      } 
    } 
    return 0;
  }
  
  public ByteBuffer getInputBuffer(int paramInt) {
    return null;
  }
  
  public SurfaceTexture getSurfaceTexture() {
    return this.k;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {
    if (this.s)
      return; 
    if (this.p)
      return; 
    this.f.f();
    if (this.m == 0) {
      this.m = GlUtil.a(36197);
      paramSurfaceTexture.attachToGLContext(this.m);
    } 
    SurfaceTexture surfaceTexture = this.k;
    if (surfaceTexture != null) {
      if (this.p)
        return; 
      surfaceTexture.updateTexImage();
      long l = paramSurfaceTexture.getTimestamp();
      if (this.r == null)
        this.r = ByteBuffer.allocate(this.h * this.g * 4); 
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16640);
      this.r.rewind();
      int i = this.q.preProcess(this.m, this.r);
      this.b.handlePreviewFrame(this.r.array(), this.i, this.j, 0);
      i = this.b.drawFrame(i, this.i, this.j, false);
      if (i > 0) {
        GLES20.glViewport(0, 0, this.i, this.j);
        this.q.onDrawFrame(i);
        if (this.o) {
          ((EglBase14)this.f).a(l);
        } else {
          this.f.h();
        } 
        this.f.g();
      } 
    } 
  }
  
  public void onProcessCallback(int paramInt1, int paramInt2, int paramInt3, long paramLong) {}
  
  public void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {}
  
  public void stopAndDeAllocate() {
    this.p = true;
    CountDownLatch countDownLatch = new CountDownLatch(1);
    this.d.post(new Runnable(this, countDownLatch) {
          public void run() {
            VideoFilterSurfaceTexture.e(this.b).onSurfaceDestroyed();
            VideoFilterSurfaceTexture.f(this.b);
            this.a.countDown();
          }
        });
    try {
      countDownLatch.await();
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
    } 
    this.d = null;
    this.c.quit();
    this.c = null;
    this.a.destroy();
    this.a = null;
  }
  
  public int supportBufferType() {
    return 8;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\zegoVideoCapture\VideoFilterSurfaceTexture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */