package com.blued.android.core.imagecache;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.drawable.IRecyclingDrawable;
import com.blued.android.core.imagecache.view.RecyclingImageView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

public class LoadJobImpl extends LoadJob implements Runnable {
  protected LoadType a = LoadType.a;
  
  protected final RecyclingImageView b;
  
  protected final String c;
  
  protected final String d;
  
  protected final LoadOptions e;
  
  protected final ImageLoadingListener f;
  
  protected final Handler g;
  
  protected Future h;
  
  private final ReentrantLock i;
  
  public LoadJobImpl(RecyclingImageView paramRecyclingImageView, String paramString1, LoadOptions paramLoadOptions, ImageLoadingListener paramImageLoadingListener, String paramString2) {
    this.b = paramRecyclingImageView;
    this.d = paramString1;
    this.e = paramLoadOptions;
    this.f = paramImageLoadingListener;
    this.c = paramString2;
    this.i = ImageLoadEngine.a(paramString1);
    if (AppMethods.b()) {
      this.g = new Handler();
      return;
    } 
    this.g = null;
  }
  
  private boolean b() {
    try {
      this.i.lockInterruptibly();
      return true;
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
      return false;
    } 
  }
  
  private void c() {
    this.i.unlock();
  }
  
  private Drawable d() throws SwitchJobLoadType, LoadDrawableException {
    FailReason.FailType failType = FailReason.FailType.a;
    Throwable throwable = null;
    try {
      Drawable drawable;
      FailReason.FailType failType1;
      Throwable throwable1;
      RecyclingUtils.Scheme scheme = RecyclingUtils.Scheme.a(this.d);
      switch (null.a[scheme.ordinal()]) {
        case 6:
          drawable = RecyclingUtils.b(this.d, this.e);
          failType1 = failType;
          throwable1 = throwable;
          if (throwable1 == null)
            return drawable; 
          throw new LoadDrawableException(failType1, throwable1);
        case 5:
          drawable = RecyclingUtils.a(this.d, RecyclingUtils.c(this.d), this.e);
          failType1 = failType;
          throwable1 = throwable;
          if (throwable1 == null)
            return drawable; 
          throw new LoadDrawableException(failType1, throwable1);
        case 4:
          drawable = RecyclingUtils.a(this.d, RecyclingUtils.b(this.d), this.e);
          failType1 = failType;
          throwable1 = throwable;
          if (throwable1 == null)
            return drawable; 
          throw new LoadDrawableException(failType1, throwable1);
        case 3:
          drawable = RecyclingUtils.c(Uri.decode(this.d), this.e);
          failType1 = failType;
          throwable1 = throwable;
          if (throwable1 == null)
            return drawable; 
          throw new LoadDrawableException(failType1, throwable1);
        case 1:
        case 2:
          if (this.a == LoadType.a && !this.e.g) {
            LoadOptions loadOptions = new LoadOptions(this.e);
            loadOptions.h = false;
            Drawable drawable2 = RecyclingUtils.a(this.d, loadOptions, this.g, this.f);
            failType1 = failType;
            throwable1 = throwable;
            Drawable drawable1 = drawable2;
            if (drawable2 == null)
              try {
              
              } catch (LoadDrawableException loadDrawableException) {
                drawable1 = drawable2;
                throwable1 = loadDrawableException.b;
              } catch (FileNotFoundException fileNotFoundException) {
              
              } catch (IOException iOException) {
              
              } catch (OutOfMemoryError outOfMemoryError) {
              
              } catch (UnsupportedOperationException unsupportedOperationException) {
              
              } finally {
                failType1 = null;
              }  
          } else {
            drawable = RecyclingUtils.a(this.d, this.e, this.g, this.f);
            failType1 = failType;
            throwable1 = throwable;
          } 
          if (throwable1 == null)
            return drawable; 
          throw new LoadDrawableException(failType1, throwable1);
      } 
      throw new LoadDrawableException(FailReason.FailType.i, null);
    } catch (SwitchJobLoadType switchJobLoadType) {
      throw switchJobLoadType;
    } catch (LoadDrawableException loadDrawableException) {
    
    } catch (FileNotFoundException fileNotFoundException1) {
      Drawable drawable = null;
      FileNotFoundException fileNotFoundException2 = fileNotFoundException1;
      fileNotFoundException2.printStackTrace();
      FailReason.FailType failType1 = FailReason.FailType.j;
      if (fileNotFoundException2 == null)
        return drawable; 
      throw new LoadDrawableException(failType1, fileNotFoundException2);
    } catch (IOException iOException1) {
      FailReason.FailType failType1;
      Drawable drawable = null;
      IOException iOException2 = iOException1;
      iOException2.printStackTrace();
      if (FailReason.a(iOException2)) {
        failType1 = FailReason.FailType.c;
      } else {
        failType1 = FailReason.FailType.b;
      } 
      if (iOException2 == null)
        return drawable; 
      throw new LoadDrawableException(failType1, iOException2);
    } catch (OutOfMemoryError outOfMemoryError1) {
      Drawable drawable = null;
      OutOfMemoryError outOfMemoryError2 = outOfMemoryError1;
      outOfMemoryError2.printStackTrace();
      FailReason.FailType failType1 = FailReason.FailType.g;
      if (outOfMemoryError2 == null)
        return drawable; 
      throw new LoadDrawableException(failType1, outOfMemoryError2);
    } catch (UnsupportedOperationException unsupportedOperationException1) {
      Drawable drawable = null;
      UnsupportedOperationException unsupportedOperationException2 = unsupportedOperationException1;
      unsupportedOperationException2.printStackTrace();
      FailReason.FailType failType1 = FailReason.FailType.j;
      if (unsupportedOperationException2 == null)
        return drawable; 
      throw new LoadDrawableException(failType1, unsupportedOperationException2);
    } finally {
      Exception exception1 = null;
      Drawable drawable = null;
      Exception exception2 = exception1;
      exception2.printStackTrace();
      FailReason.FailType failType1 = FailReason.FailType.j;
      if (exception2 == null)
        return drawable; 
    } 
  }
  
  public void a() {
    Future future = this.h;
    if (future != null)
      future.cancel(false); 
  }
  
  protected void a(Future paramFuture) {
    this.h = paramFuture;
  }
  
  public void run() {
    if (ImageLoadEngine.b(this)) {
      ImageLoadEngine.c(this);
      return;
    } 
    if (!b())
      return; 
    FailReason.FailType failType1 = FailReason.FailType.a;
    Drawable drawable = null;
    try {
      Drawable drawable1 = d();
      c();
      Object object = null;
    } catch (SwitchJobLoadType switchJobLoadType) {
      if (this.a != LoadType.b) {
        this.a = LoadType.b;
        ImageLoadEngine.a(this);
        return;
      } 
      c();
    } catch (LoadDrawableException loadDrawableException) {
      loadDrawableException.printStackTrace();
      failType1 = loadDrawableException.a;
      Throwable throwable = loadDrawableException.b;
    } finally {
      c();
    } 
    FailReason.FailType failType2 = failType1;
    if (failType1 == FailReason.FailType.a) {
      failType2 = failType1;
      if (drawable == null) {
        failType2 = failType1;
        if (this.e.i)
          if (!this.e.h) {
            failType2 = FailReason.FailType.e;
          } else {
            failType2 = FailReason.FailType.j;
          }  
      } 
    } 
    if (drawable != null && drawable instanceof IRecyclingDrawable) {
      IRecyclingDrawable iRecyclingDrawable = (IRecyclingDrawable)drawable;
      RecyclingImageLoader.a(this.c, iRecyclingDrawable);
    } 
    if (ImageLoadEngine.b(this)) {
      ImageLoadEngine.c(this);
      return;
    } 
    if (failType2 != FailReason.FailType.a) {
      ImageLoadEngine.a(this, failType2, (Throwable)SYNTHETIC_LOCAL_VARIABLE_1);
      return;
    } 
    ImageLoadEngine.a(this, drawable);
  }
  
  public enum LoadType {
    a, b;
  }
  
  class SwitchJobLoadType extends RuntimeException {
    private SwitchJobLoadType(LoadJobImpl this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\LoadJobImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */