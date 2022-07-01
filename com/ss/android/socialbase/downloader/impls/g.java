package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.g.e;
import com.ss.android.socialbase.downloader.i.e;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.m.f;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class g implements f {
  public e a(int paramInt, String paramString, List<e> paramList) throws IOException {
    OkHttpClient okHttpClient = b.n();
    if (okHttpClient != null) {
      Request.Builder builder = (new Request.Builder()).a(paramString);
      if (paramList != null && paramList.size() > 0)
        for (e e : paramList)
          builder.b(e.a(), f.f(e.b()));  
      Call call = okHttpClient.a(builder.d());
      Response response = call.b();
      if (response != null) {
        ResponseBody responseBody = response.h();
        if (responseBody != null) {
          InputStream inputStream = responseBody.d();
          String str = response.a("Content-Encoding");
          if (str != null && "gzip".equalsIgnoreCase(str) && !(inputStream instanceof GZIPInputStream))
            inputStream = new GZIPInputStream(inputStream); 
          return new e(this, inputStream, response, call, responseBody) {
              public InputStream a() throws IOException {
                return this.a;
              }
              
              public String a(String param1String) {
                return this.b.a(param1String);
              }
              
              public int b() throws IOException {
                return this.b.c();
              }
              
              public void c() {
                Call call = this.c;
                if (call != null && !call.d())
                  this.c.c(); 
              }
              
              public void d() {
                try {
                  if (this.d != null)
                    this.d.close(); 
                  return;
                } finally {
                  Exception exception = null;
                } 
              }
            };
        } 
        return null;
      } 
      throw new IOException("can't get response");
    } 
    throw new IOException("can't get httpClient");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\impls\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */