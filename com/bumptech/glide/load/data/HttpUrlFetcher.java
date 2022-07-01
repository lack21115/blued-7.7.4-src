package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class HttpUrlFetcher implements DataFetcher<InputStream> {
  static final HttpUrlConnectionFactory a = new DefaultHttpUrlConnectionFactory();
  
  private final GlideUrl b;
  
  private final int c;
  
  private final HttpUrlConnectionFactory d;
  
  private HttpURLConnection e;
  
  private InputStream f;
  
  private volatile boolean g;
  
  public HttpUrlFetcher(GlideUrl paramGlideUrl, int paramInt) {
    this(paramGlideUrl, paramInt, a);
  }
  
  HttpUrlFetcher(GlideUrl paramGlideUrl, int paramInt, HttpUrlConnectionFactory paramHttpUrlConnectionFactory) {
    this.b = paramGlideUrl;
    this.c = paramInt;
    this.d = paramHttpUrlConnectionFactory;
  }
  
  private InputStream a(HttpURLConnection paramHttpURLConnection) throws IOException {
    if (TextUtils.isEmpty(paramHttpURLConnection.getContentEncoding())) {
      int i = paramHttpURLConnection.getContentLength();
      this.f = ContentLengthInputStream.a(paramHttpURLConnection.getInputStream(), i);
    } else {
      if (Log.isLoggable("HttpUrlFetcher", 3)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Got non empty content encoding: ");
        stringBuilder.append(paramHttpURLConnection.getContentEncoding());
        Log.d("HttpUrlFetcher", stringBuilder.toString());
      } 
      this.f = paramHttpURLConnection.getInputStream();
    } 
    return this.f;
  }
  
  private InputStream a(URL paramURL1, int paramInt, URL paramURL2, Map<String, String> paramMap) throws IOException {
    if (paramInt < 5) {
      if (paramURL2 != null)
        try {
          if (paramURL1.toURI().equals(paramURL2.toURI()))
            throw new HttpException("In re-direct loop"); 
        } catch (URISyntaxException uRISyntaxException) {} 
      this.e = this.d.a(paramURL1);
      for (Map.Entry<String, String> entry : paramMap.entrySet())
        this.e.addRequestProperty((String)entry.getKey(), (String)entry.getValue()); 
      this.e.setConnectTimeout(this.c);
      this.e.setReadTimeout(this.c);
      this.e.setUseCaches(false);
      this.e.setDoInput(true);
      this.e.setInstanceFollowRedirects(false);
      this.e.connect();
      this.f = this.e.getInputStream();
      if (this.g)
        return null; 
      int i = this.e.getResponseCode();
      if (a(i))
        return a(this.e); 
      if (b(i)) {
        String str = this.e.getHeaderField("Location");
        if (!TextUtils.isEmpty(str)) {
          URL uRL = new URL(paramURL1, str);
          a();
          return a(uRL, paramInt + 1, paramURL1, paramMap);
        } 
        throw new HttpException("Received empty or null redirect url");
      } 
      if (i == -1)
        throw new HttpException(i); 
      throw new HttpException(this.e.getResponseMessage(), i);
    } 
    throw new HttpException("Too many (> 5) redirects!");
  }
  
  private static boolean a(int paramInt) {
    return (paramInt / 100 == 2);
  }
  
  private static boolean b(int paramInt) {
    return (paramInt / 100 == 3);
  }
  
  public void a() {
    InputStream inputStream = this.f;
    if (inputStream != null)
      try {
        inputStream.close();
      } catch (IOException iOException) {} 
    HttpURLConnection httpURLConnection = this.e;
    if (httpURLConnection != null)
      httpURLConnection.disconnect(); 
    this.e = null;
  }
  
  public void a(Priority paramPriority, DataFetcher.DataCallback<? super InputStream> paramDataCallback) {
    long l = LogTime.a();
    try {
      paramDataCallback.a(a(this.b.a(), 0, null, this.b.c()));
      if (Log.isLoggable("HttpUrlFetcher", 2)) {
        StringBuilder stringBuilder = new StringBuilder();
      } else {
        return;
      } 
    } catch (IOException iOException) {
      if (Log.isLoggable("HttpUrlFetcher", 3))
        Log.d("HttpUrlFetcher", "Failed to load data for url", iOException); 
      paramDataCallback.a(iOException);
      if (Log.isLoggable("HttpUrlFetcher", 2)) {
        StringBuilder stringBuilder = new StringBuilder();
      } else {
        return;
      } 
    } finally {}
    paramPriority.append("Finished http url fetcher fetch in ");
    paramPriority.append(LogTime.a(l));
    Log.v("HttpUrlFetcher", paramPriority.toString());
  }
  
  public void b() {
    this.g = true;
  }
  
  public Class<InputStream> c() {
    return InputStream.class;
  }
  
  public DataSource d() {
    return DataSource.b;
  }
  
  static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
    public HttpURLConnection a(URL param1URL) throws IOException {
      return (HttpURLConnection)param1URL.openConnection();
    }
  }
  
  static interface HttpUrlConnectionFactory {
    HttpURLConnection a(URL param1URL) throws IOException;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\data\HttpUrlFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */