package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

class GifFrameLoader {
  final RequestManager a;
  
  private final GifDecoder b;
  
  private final Handler c;
  
  private final List<FrameCallback> d = new ArrayList<FrameCallback>();
  
  private final BitmapPool e;
  
  private boolean f;
  
  private boolean g;
  
  private boolean h;
  
  private RequestBuilder<Bitmap> i;
  
  private DelayTarget j;
  
  private boolean k;
  
  private DelayTarget l;
  
  private Bitmap m;
  
  private Transformation<Bitmap> n;
  
  private DelayTarget o;
  
  private OnEveryFrameListener p;
  
  private int q;
  
  private int r;
  
  private int s;
  
  GifFrameLoader(Glide paramGlide, GifDecoder paramGifDecoder, int paramInt1, int paramInt2, Transformation<Bitmap> paramTransformation, Bitmap paramBitmap) {
    this(paramGlide.a(), Glide.b(paramGlide.c()), paramGifDecoder, null, a(Glide.b(paramGlide.c()), paramInt1, paramInt2), paramTransformation, paramBitmap);
  }
  
  GifFrameLoader(BitmapPool paramBitmapPool, RequestManager paramRequestManager, GifDecoder paramGifDecoder, Handler paramHandler, RequestBuilder<Bitmap> paramRequestBuilder, Transformation<Bitmap> paramTransformation, Bitmap paramBitmap) {
    this.a = paramRequestManager;
    Handler handler = paramHandler;
    if (paramHandler == null)
      handler = new Handler(Looper.getMainLooper(), new FrameLoaderCallback(this)); 
    this.e = paramBitmapPool;
    this.c = handler;
    this.i = paramRequestBuilder;
    this.b = paramGifDecoder;
    a(paramTransformation, paramBitmap);
  }
  
  private static RequestBuilder<Bitmap> a(RequestManager paramRequestManager, int paramInt1, int paramInt2) {
    return paramRequestManager.f().c(((RequestOptions)((RequestOptions)RequestOptions.c(DiskCacheStrategy.b).f(true)).d(true)).b(paramInt1, paramInt2));
  }
  
  private void k() {
    if (this.f)
      return; 
    this.f = true;
    this.k = false;
    m();
  }
  
  private void l() {
    this.f = false;
  }
  
  private void m() {
    if (this.f) {
      if (this.g)
        return; 
      if (this.h) {
        boolean bool;
        if (this.o == null) {
          bool = true;
        } else {
          bool = false;
        } 
        Preconditions.a(bool, "Pending target must be null when starting from the first frame");
        this.b.f();
        this.h = false;
      } 
      DelayTarget delayTarget = this.o;
      if (delayTarget != null) {
        this.o = null;
        a(delayTarget);
        return;
      } 
      this.g = true;
      int i = this.b.c();
      long l1 = SystemClock.uptimeMillis();
      long l2 = i;
      this.b.b();
      this.l = new DelayTarget(this.c, this.b.e(), l1 + l2);
      this.i.c((BaseRequestOptions)RequestOptions.c(o())).b(this.b).a((Target)this.l);
    } 
  }
  
  private void n() {
    Bitmap bitmap = this.m;
    if (bitmap != null) {
      this.e.a(bitmap);
      this.m = null;
    } 
  }
  
  private static Key o() {
    return (Key)new ObjectKey(Double.valueOf(Math.random()));
  }
  
  Bitmap a() {
    return this.m;
  }
  
  void a(Transformation<Bitmap> paramTransformation, Bitmap paramBitmap) {
    this.n = (Transformation<Bitmap>)Preconditions.a(paramTransformation);
    this.m = (Bitmap)Preconditions.a(paramBitmap);
    this.i = this.i.c((new RequestOptions()).b(paramTransformation));
    this.q = Util.a(paramBitmap);
    this.r = paramBitmap.getWidth();
    this.s = paramBitmap.getHeight();
  }
  
  void a(DelayTarget paramDelayTarget) {
    OnEveryFrameListener onEveryFrameListener = this.p;
    if (onEveryFrameListener != null)
      onEveryFrameListener.a(); 
    this.g = false;
    if (this.k) {
      this.c.obtainMessage(2, paramDelayTarget).sendToTarget();
      return;
    } 
    if (!this.f) {
      this.o = paramDelayTarget;
      return;
    } 
    if (paramDelayTarget.e() != null) {
      n();
      DelayTarget delayTarget = this.j;
      this.j = paramDelayTarget;
      for (int i = this.d.size() - 1; i >= 0; i--)
        ((FrameCallback)this.d.get(i)).f(); 
      if (delayTarget != null)
        this.c.obtainMessage(2, delayTarget).sendToTarget(); 
    } 
    m();
  }
  
  void a(FrameCallback paramFrameCallback) {
    if (!this.k) {
      if (!this.d.contains(paramFrameCallback)) {
        boolean bool = this.d.isEmpty();
        this.d.add(paramFrameCallback);
        if (bool)
          k(); 
        return;
      } 
      throw new IllegalStateException("Cannot subscribe twice in a row");
    } 
    throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
  }
  
  int b() {
    return this.r;
  }
  
  void b(FrameCallback paramFrameCallback) {
    this.d.remove(paramFrameCallback);
    if (this.d.isEmpty())
      l(); 
  }
  
  int c() {
    return this.s;
  }
  
  int d() {
    return this.b.h() + this.q;
  }
  
  int e() {
    DelayTarget delayTarget = this.j;
    return (delayTarget != null) ? delayTarget.a : -1;
  }
  
  ByteBuffer f() {
    return this.b.a().asReadOnlyBuffer();
  }
  
  int g() {
    return this.b.d();
  }
  
  int h() {
    return this.b.g();
  }
  
  void i() {
    this.d.clear();
    n();
    l();
    DelayTarget delayTarget = this.j;
    if (delayTarget != null) {
      this.a.a((Target)delayTarget);
      this.j = null;
    } 
    delayTarget = this.l;
    if (delayTarget != null) {
      this.a.a((Target)delayTarget);
      this.l = null;
    } 
    delayTarget = this.o;
    if (delayTarget != null) {
      this.a.a((Target)delayTarget);
      this.o = null;
    } 
    this.b.j();
    this.k = true;
  }
  
  Bitmap j() {
    DelayTarget delayTarget = this.j;
    return (delayTarget != null) ? delayTarget.e() : this.m;
  }
  
  static class DelayTarget extends CustomTarget<Bitmap> {
    final int a;
    
    private final Handler b;
    
    private final long c;
    
    private Bitmap d;
    
    DelayTarget(Handler param1Handler, int param1Int, long param1Long) {
      this.b = param1Handler;
      this.a = param1Int;
      this.c = param1Long;
    }
    
    public void a(Bitmap param1Bitmap, Transition<? super Bitmap> param1Transition) {
      this.d = param1Bitmap;
      Message message = this.b.obtainMessage(1, this);
      this.b.sendMessageAtTime(message, this.c);
    }
    
    public void c(Drawable param1Drawable) {
      this.d = null;
    }
    
    Bitmap e() {
      return this.d;
    }
  }
  
  public static interface FrameCallback {
    void f();
  }
  
  class FrameLoaderCallback implements Handler.Callback {
    FrameLoaderCallback(GifFrameLoader this$0) {}
    
    public boolean handleMessage(Message param1Message) {
      GifFrameLoader.DelayTarget delayTarget;
      if (param1Message.what == 1) {
        delayTarget = (GifFrameLoader.DelayTarget)param1Message.obj;
        this.a.a(delayTarget);
        return true;
      } 
      if (((Message)delayTarget).what == 2) {
        delayTarget = (GifFrameLoader.DelayTarget)((Message)delayTarget).obj;
        this.a.a.a((Target)delayTarget);
      } 
      return false;
    }
  }
  
  static interface OnEveryFrameListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\gif\GifFrameLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */