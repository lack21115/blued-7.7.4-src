package com.blued.android.core.imagecache;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.pool.ExecutorFactory;
import com.blued.android.core.utils.AsyncViewChecker;
import com.blued.android.core.utils.Log;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ImageLoadEngine {
  protected static final AsyncViewChecker<String> a = new AsyncViewChecker();
  
  protected static final Map<String, ReentrantLock> b = new WeakHashMap<String, ReentrantLock>();
  
  protected static final AtomicBoolean c = new AtomicBoolean(false);
  
  private static final ThreadPoolExecutor d = ExecutorFactory.a().b();
  
  private static final ThreadPoolExecutor e = ExecutorFactory.a().c();
  
  private static final ExecutorService f = ExecutorFactory.a().d();
  
  public static LoadJob a(LoadJobImpl paramLoadJobImpl) {
    Future<?> future;
    if (paramLoadJobImpl.a == LoadJobImpl.LoadType.a) {
      future = d.submit(paramLoadJobImpl);
    } else if (paramLoadJobImpl.b == null) {
      future = f.submit(paramLoadJobImpl);
    } else {
      future = e.submit(paramLoadJobImpl);
    } 
    paramLoadJobImpl.a(future);
    return paramLoadJobImpl;
  }
  
  static ReentrantLock a(String paramString) {
    ReentrantLock reentrantLock2 = b.get(paramString);
    ReentrantLock reentrantLock1 = reentrantLock2;
    if (reentrantLock2 == null) {
      reentrantLock1 = new ReentrantLock();
      b.put(paramString, reentrantLock1);
    } 
    return reentrantLock1;
  }
  
  public static void a() {
    c.set(true);
  }
  
  static void a(ImageView paramImageView) {
    if (paramImageView != null)
      a.a((View)paramImageView); 
  }
  
  static void a(ImageView paramImageView, String paramString) {
    if (paramImageView != null)
      a.a((View)paramImageView, paramString); 
  }
  
  protected static void a(LoadJobImpl paramLoadJobImpl, Drawable paramDrawable) {
    if (ImageLoaderUtils.a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("image load success, uri:");
      stringBuilder.append(paramLoadJobImpl.d);
      Log.a("IMAGE_LOADER", stringBuilder.toString());
    } 
    if (!Thread.interrupted())
      a(paramLoadJobImpl, new Runnable(paramLoadJobImpl, paramDrawable) {
            public void run() {
              if (!ImageLoadEngine.d(this.a)) {
                ImageLoadEngine.a((ImageView)this.a.b);
                this.a.f.a(this.a.d, this.a.b, this.a.e, this.b, this.a.e.g);
              } 
            }
          }); 
  }
  
  protected static void a(LoadJobImpl paramLoadJobImpl, FailReason.FailType paramFailType, Throwable paramThrowable) {
    if (ImageLoaderUtils.a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("image load failed, uri:");
      stringBuilder.append(paramLoadJobImpl.d);
      stringBuilder.append(", failType:");
      stringBuilder.append(paramFailType);
      stringBuilder.append(", failCause:");
      stringBuilder.append(paramThrowable);
      Log.a("IMAGE_LOADER", stringBuilder.toString());
    } 
    if (!Thread.interrupted())
      a(paramLoadJobImpl, new Runnable(paramLoadJobImpl, paramFailType, paramThrowable) {
            public void run() {
              if (!ImageLoadEngine.d(this.a)) {
                ImageLoadEngine.a((ImageView)this.a.b);
                this.a.f.a(this.a.d, this.a.b, this.a.e, new FailReason(this.b, this.c));
              } 
            }
          }); 
  }
  
  private static void a(LoadJobImpl paramLoadJobImpl, Runnable paramRunnable) {
    if (paramRunnable != null) {
      if (AppMethods.b() || paramLoadJobImpl.g == null) {
        paramRunnable.run();
        return;
      } 
      paramLoadJobImpl.g.post(paramRunnable);
      return;
    } 
  }
  
  public static void b() {
    synchronized (c) {
      c.set(false);
      c.notifyAll();
      return;
    } 
  }
  
  protected static boolean b(LoadJobImpl paramLoadJobImpl) {
    if (c.get())
      synchronized (c) {
        c.wait();
        return e(paramLoadJobImpl);
      }  
    return e(paramLoadJobImpl);
  }
  
  protected static void c(LoadJobImpl paramLoadJobImpl) {
    if (ImageLoaderUtils.a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("image load cancel, uri:");
      stringBuilder.append(paramLoadJobImpl.d);
      Log.a("IMAGE_LOADER", stringBuilder.toString());
    } 
    if (!Thread.interrupted())
      a(paramLoadJobImpl, new Runnable(paramLoadJobImpl) {
            public void run() {
              if (this.a.f != null)
                this.a.f.b(this.a.d, this.a.b, this.a.e); 
            }
          }); 
  }
  
  private static boolean e(LoadJobImpl paramLoadJobImpl) {
    return (paramLoadJobImpl.b == null) ? false : (a.b((View)paramLoadJobImpl.b, paramLoadJobImpl.c) ^ true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\ImageLoadEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */