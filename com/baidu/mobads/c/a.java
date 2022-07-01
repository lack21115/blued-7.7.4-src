package com.baidu.mobads.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.mobads.interfaces.download.IXAdStaticImgDownloader;
import com.baidu.mobads.openad.b.d;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observer;

public class a {
  private static final Handler b = new Handler(Looper.getMainLooper());
  
  private static final HandlerThread c = new HandlerThread("XAdSimpleImageLoader");
  
  private static final Handler d = new Handler(c.getLooper());
  
  private static a e;
  
  private LruCache<String, Bitmap> a = new b(this, (int)Runtime.getRuntime().maxMemory() / 32);
  
  private static int a(BitmapFactory.Options paramOptions, ImageView paramImageView) {
    a a1 = a(paramImageView);
    int i = paramOptions.outWidth;
    int j = paramOptions.outHeight;
    return (i > a1.a || j > a1.b) ? Math.max(Math.round(i * 1.0F / a1.a), Math.round(j * 1.0F / a1.b)) : 1;
  }
  
  private Bitmap a(String paramString, ImageView paramImageView, boolean paramBoolean) {
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, options);
    a(paramImageView);
    options.inSampleSize = a(options, paramImageView);
    options.inJustDecodeBounds = false;
    Bitmap bitmap = BitmapFactory.decodeFile(paramString, options);
    if (paramBoolean)
      paramImageView.setImageBitmap(bitmap); 
    return bitmap;
  }
  
  private static a a(ImageView paramImageView) {
    a a1 = new a(null);
    DisplayMetrics displayMetrics = paramImageView.getContext().getResources().getDisplayMetrics();
    ViewGroup.LayoutParams layoutParams = paramImageView.getLayoutParams();
    int j = paramImageView.getWidth();
    int i = j;
    if (j <= 0)
      i = layoutParams.width; 
    j = i;
    if (i <= 0)
      j = paramImageView.getMaxWidth(); 
    int k = j;
    if (j <= 0)
      k = displayMetrics.widthPixels; 
    j = paramImageView.getHeight();
    i = j;
    if (j <= 0)
      i = layoutParams.height; 
    j = i;
    if (i <= 0)
      j = paramImageView.getMaxHeight(); 
    i = j;
    if (j <= 0)
      i = displayMetrics.heightPixels; 
    a1.a = k;
    a1.b = i;
    return a1;
  }
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/baidu/mobads/c/a.e : Lcom/baidu/mobads/c/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/baidu/mobads/c/a
    //   8: monitorenter
    //   9: getstatic com/baidu/mobads/c/a.e : Lcom/baidu/mobads/c/a;
    //   12: ifnonnull -> 25
    //   15: new com/baidu/mobads/c/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/baidu/mobads/c/a.e : Lcom/baidu/mobads/c/a;
    //   25: ldc com/baidu/mobads/c/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/baidu/mobads/c/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/baidu/mobads/c/a.e : Lcom/baidu/mobads/c/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(String paramString, Bitmap paramBitmap) {
    if (this.a.get(paramString) == null && paramString != null && paramBitmap != null)
      this.a.put(paramString, paramBitmap); 
  }
  
  public static String b(String paramString) {
    String str = XAdSDKFoundationFacade.getInstance().getIoUtils().getStoreagePath(XAdSDKFoundationFacade.getInstance().getApplicationContext());
    paramString = XAdSDKFoundationFacade.getInstance().getCommonUtils().md5(paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(paramString);
    stringBuilder.append(".temp");
    return stringBuilder.toString();
  }
  
  private void b(String paramString, Observer paramObserver) {
    Context context = XAdSDKFoundationFacade.getInstance().getApplicationContext();
    try {
      URL uRL = new URL(paramString);
      d d = d.a(context);
      String str = d(paramString);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(e(paramString));
      stringBuilder.append(".temp");
      IXAdStaticImgDownloader iXAdStaticImgDownloader = d.createImgHttpDownloader(uRL, str, stringBuilder.toString());
      iXAdStaticImgDownloader.addObserver(paramObserver);
      iXAdStaticImgDownloader.start();
      return;
    } catch (MalformedURLException malformedURLException) {
      return;
    } 
  }
  
  private Bitmap c(String paramString) {
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = false;
    return BitmapFactory.decodeFile(paramString, options);
  }
  
  private static String d(String paramString) {
    return XAdSDKFoundationFacade.getInstance().getIoUtils().getStoreagePath(XAdSDKFoundationFacade.getInstance().getApplicationContext());
  }
  
  private static String e(String paramString) {
    return XAdSDKFoundationFacade.getInstance().getCommonUtils().md5(paramString);
  }
  
  public void a(ImageView paramImageView, String paramString) {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      if (paramImageView != null) {
        if (paramString == null)
          return; 
        Bitmap bitmap = (Bitmap)this.a.get(paramString);
        if (bitmap != null) {
          paramImageView.setImageBitmap(bitmap);
          return;
        } 
        bitmap = a(b(paramString), paramImageView, true);
        if (bitmap != null) {
          a(paramString, bitmap);
          return;
        } 
        b(paramString, new c(this, paramString, paramImageView));
      } 
      return;
    } 
    throw new IllegalThreadStateException("please invoke in main thread!");
  }
  
  public void a(String paramString, Observer paramObserver) {
    if (paramString != null && paramObserver != null)
      try {
        return;
      } finally {
        paramString = null;
      }  
  }
  
  public boolean a(String paramString) {
    if (!TextUtils.isEmpty(paramString) && (Bitmap)this.a.get(paramString) == null) {
      Bitmap bitmap = c(b(paramString));
      if (bitmap == null)
        return true; 
      a(paramString, bitmap);
    } 
    return false;
  }
  
  static {
    c.start();
  }
  
  static class a {
    int a;
    
    int b;
    
    private a() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */