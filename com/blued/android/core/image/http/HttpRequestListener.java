package com.blued.android.core.image.http;

import android.os.Looper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.http.StatusCode;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import java.io.IOException;

public class HttpRequestListener implements RequestListener {
  private ImageLoadResult a;
  
  public HttpRequestListener(ImageLoadResult paramImageLoadResult) {
    this.a = paramImageLoadResult;
  }
  
  private void a() {
    ImageLoadResult imageLoadResult = this.a;
    if (imageLoadResult != null && imageLoadResult.c()) {
      this.a.a();
      this.a.b();
    } 
  }
  
  private void a(GlideException paramGlideException) {
    ImageLoadResult imageLoadResult = this.a;
    if (imageLoadResult != null && imageLoadResult.c()) {
      Exception exception2;
      byte b = 0;
      imageLoadResult = null;
      int i = b;
      if (paramGlideException != null) {
        Exception exception = paramGlideException.a();
        if (exception != null) {
          i = b;
          exception2 = exception;
          if (exception instanceof IOException) {
            i = StatusCode.a((IOException)exception);
            exception2 = exception;
          } 
        } else {
          exception2 = new Exception(paramGlideException.getMessage());
          i = b;
        } 
      } 
      Exception exception1 = exception2;
      if (exception2 == null)
        exception1 = new Exception("unknown"); 
      if (ImageLoader.a()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onLoadFailed : ");
        stringBuilder.append(i);
        stringBuilder.append(", ");
        stringBuilder.append(exception1);
        Log.e("IMAGE", stringBuilder.toString());
      } 
      this.a.a(i, exception1);
      this.a.b();
    } 
  }
  
  public boolean a(GlideException paramGlideException, Object paramObject, Target paramTarget, boolean paramBoolean) {
    if (ImageLoader.a())
      Log.e("IMAGE", "HttpRequestListener onLoadFailed"); 
    if (Looper.getMainLooper() == Looper.myLooper()) {
      a(paramGlideException);
    } else {
      AppInfo.n().post(new Runnable(this, paramGlideException) {
            public void run() {
              HttpRequestListener.a(this.b, this.a);
            }
          });
    } 
    return false;
  }
  
  public boolean a(Object paramObject1, Object paramObject2, Target paramTarget, DataSource paramDataSource, boolean paramBoolean) {
    if (ImageLoader.a())
      Log.c("IMAGE", "HttpRequestListener onResourceReady"); 
    if (Looper.getMainLooper() == Looper.myLooper()) {
      a();
    } else {
      AppInfo.n().post(new Runnable(this) {
            public void run() {
              HttpRequestListener.a(this.a);
            }
          });
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\http\HttpRequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */