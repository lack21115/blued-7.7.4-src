package com.blued.android.core.imagecache;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.collection.LruCache;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.drawable.IRecyclingDrawable;
import com.blued.android.core.imagecache.glide.LruBitmapPool;
import com.blued.android.core.imagecache.view.RecyclingImageView;
import com.blued.android.core.utils.Log;

public class RecyclingImageLoader {
  public static final ImageLoadingListener a = new BaseImageLoadingListener();
  
  public LruBitmapPool b;
  
  private LruCache<String, IRecyclingDrawable> c;
  
  private RecyclingImageLoader() {
    e();
  }
  
  public static Drawable a(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      IRecyclingDrawable iRecyclingDrawable = (IRecyclingDrawable)(a()).c.get(paramString);
      if (iRecyclingDrawable != null && iRecyclingDrawable.c())
        return (Drawable)iRecyclingDrawable; 
    } 
    return null;
  }
  
  public static LoadJob a(RecyclingImageView paramRecyclingImageView, String paramString, LoadOptions paramLoadOptions, ImageLoadingListener paramImageLoadingListener) {
    if (ImageLoaderUtils.a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("RecyclingImageLoader.loadImage(), uri:");
      stringBuilder.append(paramString);
      Log.a("IMAGE_LOADER", stringBuilder.toString());
    } 
    LoadOptions loadOptions = paramLoadOptions;
    if (paramLoadOptions == null)
      loadOptions = LoadOptions.c(); 
    ImageLoadingListener imageLoadingListener = paramImageLoadingListener;
    if (paramImageLoadingListener == null)
      imageLoadingListener = a; 
    if (loadOptions.i && !AppMethods.b()) {
      if (!AppInfo.m())
        return null; 
      throw new RuntimeException("loadImage() must be called in UI thread");
    } 
    imageLoadingListener.a(paramString, paramRecyclingImageView, loadOptions);
    if (TextUtils.isEmpty(paramString)) {
      ImageLoadEngine.a((ImageView)paramRecyclingImageView);
      imageLoadingListener.a(paramString, paramRecyclingImageView, loadOptions, new FailReason(FailReason.FailType.h, null));
      return null;
    } 
    ImageLoadEngine.a((ImageView)paramRecyclingImageView, "");
    if (paramRecyclingImageView != null && !a(paramRecyclingImageView, paramString)) {
      if (ImageLoaderUtils.a) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("not need reload, uri:");
        stringBuilder.append(paramString);
        Log.a("IMAGE_LOADER", stringBuilder.toString());
      } 
      imageLoadingListener.a(paramString, paramRecyclingImageView, loadOptions, paramRecyclingImageView.getDrawable(), true);
      return null;
    } 
    String str = RecyclingUtils.a(paramString, loadOptions);
    Drawable drawable = a(str);
    if (drawable != null) {
      imageLoadingListener.a(paramString, paramRecyclingImageView, loadOptions, drawable, true);
      return null;
    } 
    RecyclingUtils.Scheme scheme = RecyclingUtils.Scheme.a(paramString);
    if (loadOptions.g && RecyclingUtils.Scheme.f == scheme) {
      a(paramRecyclingImageView, RecyclingUtils.a(RecyclingUtils.Scheme.f.c(paramString)), loadOptions);
      imageLoadingListener.a(paramString, paramRecyclingImageView, loadOptions, paramRecyclingImageView.getDrawable(), true);
      return null;
    } 
    if (paramRecyclingImageView != null) {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (!TextUtils.isEmpty(loadOptions.c)) {
        Drawable drawable1 = a(RecyclingUtils.a(loadOptions.c, loadOptions));
        bool1 = bool2;
        if (drawable1 != null) {
          paramRecyclingImageView.setImageDrawable(drawable1);
          bool1 = true;
        } 
      } 
      if (!bool1 && loadOptions.b > 0)
        if (loadOptions.e) {
          paramRecyclingImageView.setImageResourceInner(loadOptions.b);
        } else {
          paramRecyclingImageView.setImageResource(loadOptions.b);
        }  
    } 
    ImageLoadEngine.a((ImageView)paramRecyclingImageView, str);
    LoadJobImpl loadJobImpl = new LoadJobImpl(paramRecyclingImageView, paramString, loadOptions, imageLoadingListener, str);
    if (loadOptions.g) {
      loadJobImpl.run();
      return null;
    } 
    return ImageLoadEngine.a(loadJobImpl);
  }
  
  public static RecyclingImageLoader a() {
    return SingletonCreator.a();
  }
  
  public static void a(int paramInt) {
    if (paramInt >= 40) {
      (a()).c.trimToSize(0);
    } else if (paramInt >= 20) {
      (a()).c.trimToSize((a()).c.maxSize() / 2);
    } 
    synchronized ((a()).b) {
      (a()).b.a(paramInt);
      return;
    } 
  }
  
  public static void a(Bitmap paramBitmap) {
    if (paramBitmap != null && !paramBitmap.isRecycled()) {
      if (!paramBitmap.isMutable())
        return; 
      if (RecyclingUtils.b())
        synchronized ((a()).b) {
          (a()).b.a(paramBitmap);
          return;
        }  
    } 
  }
  
  public static void a(RecyclingImageView paramRecyclingImageView, int paramInt, LoadOptions paramLoadOptions) {
    if (ImageLoaderUtils.a) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("RecyclingImageLoader.loadLocalResSync(), resId:");
      stringBuilder.append(paramInt);
      Log.a("IMAGE_LOADER", stringBuilder.toString());
    } 
    if (paramInt <= 0)
      return; 
    if (!AppMethods.b()) {
      if (!AppInfo.m())
        return; 
      throw new RuntimeException("loadLocalResSync() must be called in UI thread");
    } 
    if (paramLoadOptions != null)
      try {
        if (paramLoadOptions.e) {
          paramRecyclingImageView.setImageResourceInner(paramInt);
          return;
        } 
      } catch (OutOfMemoryError outOfMemoryError) {
        outOfMemoryError.printStackTrace();
      }  
    String str1 = RecyclingUtils.Scheme.f.b(RecyclingUtils.a(paramInt));
    if (!a(paramRecyclingImageView, str1))
      return; 
    LoadOptions loadOptions = paramLoadOptions;
    if (paramLoadOptions == null)
      loadOptions = LoadOptions.c(); 
    String str2 = RecyclingUtils.a(str1, loadOptions);
    Drawable drawable2 = a(str2);
    Drawable drawable1 = drawable2;
    if (drawable2 == null) {
      drawable2 = RecyclingUtils.a(paramRecyclingImageView.getContext(), str1, loadOptions);
      drawable1 = drawable2;
      if (drawable2 instanceof IRecyclingDrawable) {
        a(str2, (IRecyclingDrawable)drawable2);
        drawable1 = drawable2;
      } 
    } 
    if (drawable1 != null) {
      paramRecyclingImageView.setImageDrawable(drawable1);
      return;
    } 
    if (loadOptions.d > 0) {
      paramRecyclingImageView.setImageResource(loadOptions.d);
      return;
    } 
    if (loadOptions.d == 0)
      paramRecyclingImageView.setImageBitmap(null); 
  }
  
  public static void a(String paramString, IRecyclingDrawable paramIRecyclingDrawable) {
    if ((a()).c != null && paramIRecyclingDrawable != null && paramIRecyclingDrawable.a()) {
      if (Looper.getMainLooper() == Looper.myLooper()) {
        paramIRecyclingDrawable.b(true);
        (a()).c.put(paramString, paramIRecyclingDrawable);
        return;
      } 
      AppInfo.n().post(new Runnable(paramIRecyclingDrawable, paramString) {
            public void run() {
              this.a.b(true);
              RecyclingImageLoader.a(RecyclingImageLoader.a()).put(this.b, this.a);
            }
          });
    } 
  }
  
  public static boolean a(RecyclingImageView paramRecyclingImageView, String paramString) {
    Drawable drawable = paramRecyclingImageView.getDrawable();
    if (drawable != null && drawable instanceof IRecyclingDrawable) {
      IRecyclingDrawable iRecyclingDrawable = (IRecyclingDrawable)drawable;
      if (iRecyclingDrawable.c() && paramString.equals(iRecyclingDrawable.b()))
        return false; 
    } 
    return true;
  }
  
  public static void b() {
    ImageLoadEngine.a();
  }
  
  public static void c() {
    ImageLoadEngine.b();
  }
  
  public static void d() {
    (a()).c.evictAll();
    synchronized ((a()).b) {
      (a()).b.a();
      return;
    } 
  }
  
  private void e() {
    float f = AppInfo.s / 2.0F;
    int i = RecyclingUtils.a(f);
    int j = RecyclingUtils.a(f);
    if (this.b == null)
      this.b = new LruBitmapPool(j); 
    this.c = new LruCache<String, IRecyclingDrawable>(this, i) {
        protected int a(String param1String, IRecyclingDrawable param1IRecyclingDrawable) {
          int j = param1IRecyclingDrawable.e();
          int i = j;
          if (j == 0)
            i = 1; 
          return i;
        }
        
        protected void a(boolean param1Boolean, String param1String, IRecyclingDrawable param1IRecyclingDrawable1, IRecyclingDrawable param1IRecyclingDrawable2) {
          param1IRecyclingDrawable1.b(false);
        }
      };
  }
  
  static class SingletonCreator {
    private static final RecyclingImageLoader a = new RecyclingImageLoader();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\RecyclingImageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */