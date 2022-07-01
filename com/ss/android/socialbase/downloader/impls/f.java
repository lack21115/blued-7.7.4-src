package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.g.e;
import com.ss.android.socialbase.downloader.i.c;
import com.ss.android.socialbase.downloader.i.d;
import com.ss.android.socialbase.downloader.m.c;
import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class f implements d {
  public c a(String paramString, List<e> paramList) throws IOException {
    OkHttpClient okHttpClient = b.n();
    if (okHttpClient != null) {
      Request.Builder builder = (new Request.Builder()).a(paramString).b();
      if (paramList != null && paramList.size() > 0)
        for (e e : paramList)
          builder.b(e.a(), com.ss.android.socialbase.downloader.m.f.f(e.b()));  
      Call call = okHttpClient.a(builder.d());
      Response response = call.b();
      if (response != null) {
        if (c.a(2097152))
          response.close(); 
        return new c(this, response, call) {
            public String a(String param1String) {
              return this.a.a(param1String);
            }
            
            public int b() throws IOException {
              return this.a.c();
            }
            
            public void c() {
              Call call = this.b;
              if (call != null && !call.d())
                this.b.c(); 
            }
          };
      } 
      throw new IOException("can't get response");
    } 
    throw new IOException("can't get httpClient");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\impls\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */