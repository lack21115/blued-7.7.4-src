package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import java.security.MessageDigest;
import java.util.Set;
import java.util.concurrent.TimeUnit;

final class BitmapPreFillRunner implements Runnable {
  static final long a;
  
  private static final Clock b = new Clock();
  
  private final BitmapPool c;
  
  private final MemoryCache d;
  
  private final PreFillQueue e;
  
  private final Clock f;
  
  private final Set<PreFillType> g;
  
  private final Handler h;
  
  private long i;
  
  private boolean j;
  
  static {
    a = TimeUnit.SECONDS.toMillis(1L);
  }
  
  private boolean a(long paramLong) {
    return (this.f.a() - paramLong >= 32L);
  }
  
  private long b() {
    return this.d.b() - this.d.a();
  }
  
  private long c() {
    long l = this.i;
    this.i = Math.min(4L * l, a);
    return l;
  }
  
  boolean a() {
    long l = this.f.a();
    while (!this.e.b() && !a(l)) {
      Bitmap bitmap;
      PreFillType preFillType = this.e.a();
      if (!this.g.contains(preFillType)) {
        this.g.add(preFillType);
        bitmap = this.c.b(preFillType.a(), preFillType.b(), preFillType.c());
      } else {
        bitmap = Bitmap.createBitmap(preFillType.a(), preFillType.b(), preFillType.c());
      } 
      int i = Util.a(bitmap);
      if (b() >= i) {
        UniqueKey uniqueKey = new UniqueKey();
        this.d.b(uniqueKey, (Resource)BitmapResource.a(bitmap, this.c));
      } else {
        this.c.a(bitmap);
      } 
      if (Log.isLoggable("PreFillRunner", 3)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("allocated [");
        stringBuilder.append(preFillType.a());
        stringBuilder.append("x");
        stringBuilder.append(preFillType.b());
        stringBuilder.append("] ");
        stringBuilder.append(preFillType.c());
        stringBuilder.append(" size: ");
        stringBuilder.append(i);
        Log.d("PreFillRunner", stringBuilder.toString());
      } 
    } 
    return (!this.j && !this.e.b());
  }
  
  public void run() {
    if (a())
      this.h.postDelayed(this, c()); 
  }
  
  static class Clock {
    long a() {
      return SystemClock.currentThreadTimeMillis();
    }
  }
  
  static final class UniqueKey implements Key {
    public void a(MessageDigest param1MessageDigest) {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\prefill\BitmapPreFillRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */