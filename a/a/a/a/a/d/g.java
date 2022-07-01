package a.a.a.a.a.d;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import org.json.JSONObject;

public class g {
  public String a;
  
  public long b;
  
  public boolean a() {
    return (System.currentTimeMillis() - this.b > a.a);
  }
  
  public void b() {
    if ((new b(null)).a().intValue() == 200) {
      this.b = System.currentTimeMillis();
      return;
    } 
    this.a = "null";
  }
  
  public String c() {
    return this.a;
  }
  
  public class b implements Callable<Integer> {
    public int a = 0;
    
    public b(g this$0) {}
    
    public Integer a() {
      try {
        HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL("https://shortvideo.qiniuapi.com/shortvideo/log/token")).openConnection();
        httpURLConnection.setRequestMethod("GET");
        int i = httpURLConnection.getResponseCode();
        if (i == 200) {
          this.a = 0;
          InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
          char[] arrayOfChar = new char[1024];
          StringBuilder stringBuilder = new StringBuilder();
          while (inputStreamReader.read(arrayOfChar) != -1)
            stringBuilder.append(arrayOfChar); 
          inputStreamReader.close();
          String str = stringBuilder.toString();
          httpURLConnection.disconnect();
          JSONObject jSONObject = new JSONObject(str);
          g.a(this.b, jSONObject.optString("token"));
          return Integer.valueOf(i);
        } 
        return (i >= 500) ? b() : Integer.valueOf(i);
      } catch (UnknownHostException unknownHostException) {
        return b();
      } catch (Exception exception) {
        return Integer.valueOf(400);
      } 
    }
    
    public final Integer b() {
      int i = this.a + 1;
      this.a = i;
      if (i > 2) {
        this.a = 0;
        return Integer.valueOf(400);
      } 
      long l = i;
      try {
        Thread.sleep(l * 5000L);
      } catch (InterruptedException interruptedException) {}
      return a();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\d\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */