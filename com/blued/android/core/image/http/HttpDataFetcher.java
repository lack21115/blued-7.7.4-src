package com.blued.android.core.image.http;

import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpRequestWrapper;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class HttpDataFetcher implements DataFetcher<InputStream> {
  private GlideUrl a;
  
  private DataFetcher.DataCallback<? super InputStream> b;
  
  private InputStream c;
  
  private HttpRequestWrapper d;
  
  private InputStreamHttpResponseHandler e;
  
  public HttpDataFetcher(GlideUrl paramGlideUrl) {
    if (ImageLoader.a()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("-- HttpDataFetcher :");
      stringBuilder.append(paramGlideUrl);
      Log.e("IMAGE", stringBuilder.toString());
    } 
    this.a = paramGlideUrl;
  }
  
  public void a() {
    if (ImageLoader.a())
      Log.e("IMAGE", "-- HttpDataFetcher cleanup"); 
    try {
      if (this.c != null) {
        this.c.close();
        this.c = null;
      } 
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    InputStreamHttpResponseHandler inputStreamHttpResponseHandler = this.e;
    if (inputStreamHttpResponseHandler != null) {
      inputStreamHttpResponseHandler.a();
      this.e = null;
    } 
    this.b = null;
  }
  
  public void a(Priority paramPriority, DataFetcher.DataCallback<? super InputStream> paramDataCallback) {
    if (ImageLoader.a()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("-- HttpDataFetcher loadData ");
      stringBuilder.append(Thread.currentThread().getName());
      Log.e("IMAGE", stringBuilder.toString());
    } 
    this.b = paramDataCallback;
    this.e = new InputStreamHttpResponseHandler(this) {
        public void a(InputStream param1InputStream) {
          if (ImageLoader.a()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("-- HttpDataFetcher loadData ++ onSuccess ");
            stringBuilder.append(Thread.currentThread().getName());
            Log.e("IMAGE", stringBuilder.toString());
          } 
          long l = b(param1InputStream);
          HttpDataFetcher.a(this.a, ContentLengthInputStream.a(param1InputStream, l));
          if (HttpDataFetcher.a(this.a) != null)
            HttpDataFetcher.a(this.a).a(HttpDataFetcher.b(this.a)); 
        }
        
        public void a(Throwable param1Throwable, int param1Int, InputStream param1InputStream) {
          if (ImageLoader.a()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("-- HttpDataFetcher loadData ++ onFailure ");
            stringBuilder.append(Thread.currentThread().getName());
            Log.e("IMAGE", stringBuilder.toString());
          } 
          super.onFailure(param1Throwable, param1Int, param1InputStream);
          if (HttpDataFetcher.a(this.a) != null)
            HttpDataFetcher.a(this.a).a(new Exception(param1Throwable)); 
        }
      };
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (Map.Entry entry : this.a.c().entrySet())
      hashMap.put(entry.getKey(), entry.getValue()); 
    hashMap.put("Accept", "image/webp, */*");
    this.d = HttpManager.a(this.a.b(), this.e).b(hashMap).g().i();
  }
  
  public void b() {
    if (ImageLoader.a())
      Log.e("IMAGE", "-- HttpDataFetcher cancel"); 
    HttpRequestWrapper httpRequestWrapper = this.d;
    if (httpRequestWrapper != null) {
      httpRequestWrapper.j();
      this.d = null;
    } 
  }
  
  public Class<InputStream> c() {
    return InputStream.class;
  }
  
  public DataSource d() {
    return DataSource.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\http\HttpDataFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */