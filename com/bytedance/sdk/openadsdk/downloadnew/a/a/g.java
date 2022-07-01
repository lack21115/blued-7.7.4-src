package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.d.b;
import com.ss.android.socialbase.downloader.g.e;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.i.f;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class g implements f {
  protected final WeakReference<Context> a;
  
  public g(Context paramContext) {
    this.a = new WeakReference<Context>(paramContext);
  }
  
  private HttpURLConnection a(String paramString, List<e> paramList) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    try {
      if (!TextUtils.isEmpty(paramString) && paramString.startsWith("https"))
        b.a(); 
      HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(paramString)).openConnection();
      try {
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("accept", "*/*");
        httpURLConnection.setRequestProperty("connection", "Keep-Alive");
        if (paramList != null && !paramList.isEmpty())
          for (e e : paramList)
            httpURLConnection.setRequestProperty(e.a(), e.b());  
        httpURLConnection.connect();
        int i = httpURLConnection.getResponseCode();
        if (i >= 200 && i < 300)
          return httpURLConnection; 
        HttpURLConnection httpURLConnection1 = httpURLConnection;
        if (i >= 300) {
          httpURLConnection1 = httpURLConnection;
          if (i < 400)
            return a(httpURLConnection.getHeaderField("Location"), paramList); 
        } 
        return httpURLConnection1;
      } catch (Exception null) {
        return httpURLConnection;
      } 
    } catch (Exception exception) {
      exception = null;
    } 
    return (HttpURLConnection)exception;
  }
  
  private Map<String, String> a(HttpURLConnection paramHttpURLConnection) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int j = paramHttpURLConnection.getHeaderFields().size();
    for (int i = 0; i < j; i++)
      hashMap.put(paramHttpURLConnection.getHeaderFieldKey(i), paramHttpURLConnection.getHeaderField(i)); 
    return (Map)hashMap;
  }
  
  public e a(int paramInt, String paramString, List<e> paramList) throws IOException {
    e e;
    HttpURLConnection httpURLConnection = a(paramString, paramList);
    paramList = null;
    if (httpURLConnection == null)
      return null; 
    paramInt = httpURLConnection.getResponseCode();
    List<e> list = paramList;
    if (paramInt >= 200) {
      list = paramList;
      if (paramInt < 300) {
        Map<String, String> map = a(httpURLConnection);
        InputStream inputStream = httpURLConnection.getInputStream();
        String str = httpURLConnection.getContentEncoding();
        if (!TextUtils.isEmpty(str) && str.contains("gzip"))
          inputStream = new GZIPInputStream(inputStream); 
        e = new e(this, inputStream, map, paramInt, httpURLConnection) {
            public InputStream a() {
              return this.a;
            }
            
            public String a(String param1String) {
              return (String)this.b.get(param1String);
            }
            
            public int b() {
              return this.c;
            }
            
            public void c() {}
            
            public void d() {
              try {
                this.d.disconnect();
                return;
              } catch (Exception exception) {
                return;
              } 
            }
          };
      } 
    } 
    return e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\downloadnew\a\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */