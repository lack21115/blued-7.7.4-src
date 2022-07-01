package a.a.a.a.a.d;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

public class d implements Runnable {
  public int a = 0;
  
  public g b = new g();
  
  public final String a() {
    if (this.b.c() == null || this.b.a())
      this.b.b(); 
    if (this.b.c().equals("null"))
      b(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("https://pandora-express-sdk.qiniu.com/api/v1/data?host=sdkTest&sourcetype=json&repo=sdk&token=");
    stringBuilder.append(this.b.c());
    return stringBuilder.toString();
  }
  
  public final void a(HttpURLConnection paramHttpURLConnection) {
    paramHttpURLConnection.setRequestProperty("Content-Type", "application/json");
  }
  
  public final void b() {
    int i = this.a + 1;
    this.a = i;
    if (i > 2) {
      this.a = 0;
      return;
    } 
    long l = i;
    try {
      Thread.sleep(l * 5000L);
    } catch (InterruptedException interruptedException) {}
    run();
  }
  
  public void run() {
    try {
      if (!c.a().b())
        return; 
      HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(a())).openConnection();
      httpURLConnection.setDoOutput(true);
      httpURLConnection.setDoInput(true);
      httpURLConnection.setRequestMethod("POST");
      a(httpURLConnection);
      String str = e.a();
      OutputStream outputStream = httpURLConnection.getOutputStream();
      outputStream.write(str.getBytes());
      outputStream.flush();
      outputStream.close();
      int i = httpURLConnection.getResponseCode();
      httpURLConnection.disconnect();
      if (i >= 500) {
        b();
        return;
      } 
      if (i == 200)
        this.a = 0; 
    } catch (UnknownHostException unknownHostException) {
      b();
      return;
    } catch (Exception exception) {}
    f.a().d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */