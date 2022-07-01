package com.qq.e.comm.plugin.t.a;

import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.b.f;
import com.qq.e.comm.plugin.t.j;
import com.qq.e.comm.plugin.util.ad;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class b implements a {
  private HttpURLConnection a(e parame, HttpURLConnection paramHttpURLConnection) {
    for (Map.Entry entry : parame.d().entrySet())
      paramHttpURLConnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue()); 
    paramHttpURLConnection.setRequestProperty("User-Agent", j.a);
    if (parame.g() > 0) {
      paramHttpURLConnection.setConnectTimeout(parame.g());
    } else {
      paramHttpURLConnection.setConnectTimeout(30000);
    } 
    if (parame.h() > 0) {
      paramHttpURLConnection.setReadTimeout(parame.h());
      return paramHttpURLConnection;
    } 
    paramHttpURLConnection.setReadTimeout(30000);
    return paramHttpURLConnection;
  }
  
  private HttpURLConnection a(e parame, URL paramURL, HttpURLConnection paramHttpURLConnection) throws Exception {
    int i = null.a[parame.b().ordinal()];
    if (i != 1) {
      if (i != 2)
        return paramHttpURLConnection; 
      GDTLogger.d(paramURL.toString());
      boolean bool = parame.i();
      paramHttpURLConnection.setInstanceFollowRedirects(bool);
      if (bool)
        return ad.a(paramHttpURLConnection); 
    } else {
      paramHttpURLConnection.setDoOutput(true);
      paramHttpURLConnection.setChunkedStreamingMode(0);
      byte[] arrayOfByte = parame.a();
      if (arrayOfByte != null && arrayOfByte.length > 0) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(paramHttpURLConnection.getOutputStream());
        bufferedOutputStream.write(arrayOfByte);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
      } 
    } 
    return paramHttpURLConnection;
  }
  
  public f a(a.a parama) throws Exception {
    e e = parama.a();
    URL uRL = new URL(e.f());
    return e.a(a(e, uRL, a(e, (HttpURLConnection)uRL.openConnection())));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\t\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */