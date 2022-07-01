package com.blued.android.core.image.apng.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.GlideApp;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.apng.executor.FrameDecoderExecutor;
import com.blued.android.core.image.apng.io.Reader;
import com.blued.android.core.image.apng.io.Writer;
import com.blued.android.core.image.apng.loader.ByteBufferLoader;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public abstract class FrameSeqDecoder<R extends Reader, W extends Writer> {
  private static final Rect l = new Rect();
  
  protected List<Frame> a = new ArrayList<Frame>();
  
  protected int b = -1;
  
  protected int c = 1;
  
  protected Map<Bitmap, Canvas> d = new WeakHashMap<Bitmap, Canvas>();
  
  protected ByteBuffer e;
  
  protected volatile Rect f;
  
  private ByteBufferLoader g;
  
  private int h;
  
  private Integer i = null;
  
  private RenderListener j;
  
  private AtomicBoolean k = new AtomicBoolean(true);
  
  private Runnable m = null;
  
  private BitmapPool n;
  
  private W o = d();
  
  private R p = null;
  
  private boolean q = false;
  
  private volatile State r = State.a;
  
  public FrameSeqDecoder(ByteBufferLoader paramByteBufferLoader, RenderListener paramRenderListener) {
    this.g = paramByteBufferLoader;
    this.j = paramRenderListener;
    this.n = GlideApp.a(AppInfo.d()).a();
  }
  
  private int a() {
    List<Frame> list = this.a;
    return (list == null) ? 0 : list.size();
  }
  
  private void a(Rect paramRect) {
    this.f = paramRect;
    int i = paramRect.width();
    int j = paramRect.height();
    int k = this.c;
    this.e = ByteBuffer.allocate((i * j / k * k + 1) * 4);
    if (this.o == null)
      this.o = d(); 
  }
  
  private Frame b(int paramInt) {
    return (paramInt < 0 || paramInt >= a()) ? null : this.a.get(paramInt);
  }
  
  private void m() {
    this.k.compareAndSet(true, false);
    long l = System.currentTimeMillis();
    try {
      int i = a();
      if (i == 0)
        try {
          if (this.p == null) {
            this.p = c(this.g.b());
          } else {
            this.p.reset();
          } 
        } finally {
          Exception exception = null;
        }  
      if (ImageLoader.a()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("innerStart\n");
        stringBuilder.append(o());
        stringBuilder.append(", set state to RUNNING, cost ");
        stringBuilder.append(System.currentTimeMillis() - l);
        Log.i("IMAGE", stringBuilder.toString());
      } 
      this.r = State.b;
      return;
    } finally {
      if (ImageLoader.a()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("innerStart\n");
        stringBuilder.append(o());
        stringBuilder.append(", set state to RUNNING, cost ");
        stringBuilder.append(System.currentTimeMillis() - l);
        Log.i("IMAGE", stringBuilder.toString());
      } 
      this.r = State.b;
    } 
  }
  
  private void n() {
    FrameDecoderExecutor.a().a(this.m);
    this.m = null;
    List<Frame> list = this.a;
    if (list != null)
      list.clear(); 
    ByteBuffer byteBuffer = this.e;
    if (byteBuffer != null)
      byteBuffer.clear(); 
    Map<Bitmap, Canvas> map = this.d;
    if (map != null)
      map.clear(); 
    try {
      if (this.p != null) {
        this.p.close();
        this.p = null;
      } 
      if (this.o != null) {
        this.o.c();
        this.o = null;
      } 
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    c();
    if (ImageLoader.a()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("innerStop\n");
      stringBuilder.append(o());
      stringBuilder.append(" release and set state to IDLE");
      Log.i("IMAGE", stringBuilder.toString());
    } 
    this.r = State.a;
    j();
    RenderListener renderListener = this.j;
    if (renderListener != null)
      renderListener.b(); 
  }
  
  private String o() {
    return String.format("Thread is %s, Decoder is %s, state is %s", new Object[] { Thread.currentThread().getName(), toString(), this.r.toString() });
  }
  
  private int p() {
    Integer integer = this.i;
    return (integer != null) ? integer.intValue() : b();
  }
  
  private boolean q() {
    if (!i())
      return false; 
    if (a() == 0)
      return false; 
    if (p() <= 0)
      return true; 
    if (this.h < p() - 1)
      return true; 
    if (this.h == p() - 1 && this.b < a() - 1) {
      if (ImageLoader.a()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("canStep playCount = ");
        stringBuilder.append(this.h);
        stringBuilder.append(", frameIndex = ");
        stringBuilder.append(this.b);
        Log.v("IMAGE", stringBuilder.toString());
      } 
      return true;
    } 
    this.q = true;
    return false;
  }
  
  private long r() {
    this.b++;
    if (this.b >= a()) {
      this.b = 0;
      this.h++;
    } 
    Frame frame = b(this.b);
    if (frame == null)
      return 0L; 
    if (ImageLoader.a()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("step renderFrame, frameIndex=");
      stringBuilder.append(this.b);
      Log.v("IMAGE", stringBuilder.toString());
    } 
    a(frame);
    return frame.l;
  }
  
  private Runnable s() {
    if (this.m == null)
      this.m = new Runnable(this) {
          public void run() {
            if (FrameSeqDecoder.e(this.a).get())
              return; 
            if (FrameSeqDecoder.f(this.a)) {
              long l2 = System.currentTimeMillis();
              long l1 = FrameSeqDecoder.g(this.a);
              l2 = System.currentTimeMillis() - l2;
              if (ImageLoader.a()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("renderTask, delay=");
                stringBuilder.append(l1);
                stringBuilder.append(", cost=");
                stringBuilder.append(l2);
                Log.v("IMAGE", stringBuilder.toString());
              } 
              FrameDecoderExecutor.a().a(this, Math.max(0L, l1 - l2));
              if (FrameSeqDecoder.h(this.a) != null) {
                FrameSeqDecoder.h(this.a).a(this.a.e);
                return;
              } 
            } else {
              this.a.g();
            } 
          }
        }; 
    return this.m;
  }
  
  protected Bitmap a(int paramInt1, int paramInt2) {
    return this.n.b(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
  }
  
  public void a(int paramInt) {
    this.i = Integer.valueOf(paramInt);
  }
  
  protected void a(Bitmap paramBitmap) {
    if (paramBitmap != null)
      this.n.a(paramBitmap); 
  }
  
  protected abstract void a(Frame paramFrame);
  
  protected abstract int b();
  
  protected abstract Rect b(R paramR) throws IOException;
  
  public void b(int paramInt1, int paramInt2) {
    paramInt1 = c(paramInt1, paramInt2);
    if (paramInt1 != this.c) {
      this.c = paramInt1;
      boolean bool = i();
      FrameDecoderExecutor.a().a(this.m);
      FrameDecoderExecutor.a().b(new Runnable(this, bool) {
            public void run() {
              FrameSeqDecoder.d(this.b);
              try {
                FrameSeqDecoder.a(this.b, this.b.b(this.b.c(FrameSeqDecoder.b(this.b).b())));
                if (this.a)
                  return; 
              } finally {
                Exception exception = null;
              } 
            }
          });
    } 
  }
  
  protected int c(int paramInt1, int paramInt2) {
    int i = 1;
    boolean bool = true;
    if (paramInt1 != 0) {
      if (paramInt2 == 0)
        return 1; 
      int j = Math.min(e().width() / paramInt1, e().height() / paramInt2);
      paramInt1 = bool;
      while (true) {
        paramInt2 = paramInt1 * 2;
        i = paramInt1;
        if (paramInt2 <= j) {
          paramInt1 = paramInt2;
          continue;
        } 
        break;
      } 
    } 
    return i;
  }
  
  protected abstract R c(Reader paramReader);
  
  protected abstract void c();
  
  protected abstract W d();
  
  public Rect e() {
    if (this.f == null) {
      if (this.r == State.d && ImageLoader.a())
        Log.e("IMAGE", "getBounds, In Finishing, do not interrupt."); 
      Thread thread = Thread.currentThread();
      FrameDecoderExecutor.a().b(new Runnable(this, thread) {
            public void run() {
              try {
                if (this.b.f == null) {
                  if (FrameSeqDecoder.a(this.b) == null) {
                    FrameSeqDecoder.a(this.b, (Reader)this.b.c(FrameSeqDecoder.b(this.b).b()));
                  } else {
                    FrameSeqDecoder.a(this.b).reset();
                  } 
                  FrameSeqDecoder.a(this.b, this.b.b(FrameSeqDecoder.a(this.b)));
                } 
                return;
              } finally {
                null = null;
              } 
            }
          });
      LockSupport.park(thread);
    } 
    return this.f;
  }
  
  public void f() {
    if (this.f == l)
      return; 
    if (this.r == State.b || this.r == State.c) {
      if (ImageLoader.a()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("start\n");
        stringBuilder.append(o());
        stringBuilder.append(" Already started.");
        Log.i("IMAGE", stringBuilder.toString());
      } 
      return;
    } 
    if (ImageLoader.a()) {
      if (this.r == State.d) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("start\n");
        stringBuilder1.append(o());
        stringBuilder1.append(" Processing, wait for finish at ");
        stringBuilder1.append(this.r);
        Log.e("IMAGE", stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("start\n");
      stringBuilder.append(o());
      stringBuilder.append(", set state to INITIALIZING.");
      Log.i("IMAGE", stringBuilder.toString());
    } 
    this.r = State.c;
    if (FrameDecoderExecutor.a().c()) {
      m();
      return;
    } 
    FrameDecoderExecutor.a().b(new Runnable(this) {
          public void run() {
            FrameSeqDecoder.c(this.a);
          }
        });
  }
  
  public void g() {
    if (this.f == l)
      return; 
    if (this.r == State.d || this.r == State.a) {
      if (ImageLoader.a()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stop\n");
        stringBuilder.append(o());
        stringBuilder.append(" no need to stop");
        Log.i("IMAGE", stringBuilder.toString());
      } 
      return;
    } 
    if (ImageLoader.a()) {
      if (this.r == State.c) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("stop\n");
        stringBuilder1.append(o());
        stringBuilder1.append(" Processing, wait for finish at ");
        stringBuilder1.append(this.r);
        Log.e("IMAGE", stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("stop\n");
      stringBuilder.append(o());
      stringBuilder.append(" set state to FINISHING");
      Log.i("IMAGE", stringBuilder.toString());
    } 
    this.r = State.d;
    if (FrameDecoderExecutor.a().c()) {
      n();
      return;
    } 
    FrameDecoderExecutor.a().b(new Runnable(this) {
          public void run() {
            FrameSeqDecoder.d(this.a);
          }
        });
  }
  
  public void h() {
    this.g.a().clear();
    this.g = null;
    this.a = null;
    this.d = null;
    this.j = null;
  }
  
  public boolean i() {
    return (this.r == State.b || this.r == State.c);
  }
  
  public void j() {
    this.h = 0;
    this.b = -1;
    this.q = false;
  }
  
  public int k() {
    return this.c;
  }
  
  public static interface RenderListener {
    void a();
    
    void a(ByteBuffer param1ByteBuffer);
    
    void b();
  }
  
  enum State {
    a, b, c, d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\decode\FrameSeqDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */