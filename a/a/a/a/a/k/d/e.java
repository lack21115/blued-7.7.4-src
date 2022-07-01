package a.a.a.a.a.k.d;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

public final class e {
  public static boolean a = false;
  
  public static int b = 120000;
  
  public static int c = 60000;
  
  public static int d = 30000;
  
  public boolean e = false;
  
  public Handler f;
  
  public HandlerThread g;
  
  public b h;
  
  public Object i = new Object();
  
  public Handler.Callback j = new a(this);
  
  public static int a() {
    return d;
  }
  
  public final void a(int paramInt, String paramString) {
    synchronized (this.i) {
      if (this.g == null || this.f == null)
        return; 
      Message message = this.f.obtainMessage(paramInt, paramString);
      this.f.sendMessage(message);
      return;
    } 
  }
  
  public void a(Context paramContext) {
    if (this.g != null)
      return; 
    b b1 = new b();
    this.h = b1;
    b1.a(paramContext.getApplicationContext());
    HandlerThread handlerThread = new HandlerThread("QosReporter");
    this.g = handlerThread;
    handlerThread.start();
    Handler handler = new Handler(this.g.getLooper(), this.j);
    this.f = handler;
    handler.sendEmptyMessageDelayed(1, b);
  }
  
  public void a(String paramString) {
    a(3, paramString);
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2) {
    if (paramInt1 >= 10000) {
      if (paramInt2 < 10000)
        return; 
      if (paramString.equals("http://misc-pili-qos-report.qiniuapi.com/raw/log/misc-v5")) {
        if (paramInt1 != b) {
          b = paramInt1;
          return;
        } 
      } else if (paramString.equals("http://stream-pili-qos-report.qiniuapi.com/raw/log/stream-v5") && paramInt1 != c) {
        c = paramInt1;
        d = paramInt2;
      } 
    } 
  }
  
  public final void a(boolean paramBoolean) {
    String str = this.h.c();
    if (str != null && a("http://misc-pili-qos-report.qiniuapi.com/raw/log/misc-v5", str))
      this.h.b(); 
    if (paramBoolean) {
      Handler handler = this.f;
      if (handler != null)
        handler.sendEmptyMessageDelayed(1, b); 
    } 
  }
  
  public final boolean a(String paramString1, String paramString2) {
    if (a) {
      a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.c;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("url: \n");
      stringBuilder.append(paramString1);
      stringBuilder.append("\ncontent: \n");
      stringBuilder.append(paramString2);
      e1.b("QosReporter", stringBuilder.toString());
    } 
    try {
      HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(paramString1)).openConnection();
      httpURLConnection.setConnectTimeout(3000);
      httpURLConnection.setReadTimeout(10000);
      try {
        String str;
        httpURLConnection.setRequestMethod("POST");
        if (a) {
          str = "application/octet-stream";
        } else {
          str = "application/x-gzip";
        } 
        httpURLConnection.setRequestProperty("Content-Type", str);
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        try {
          byte[] arrayOfByte = paramString2.getBytes();
          if (arrayOfByte == null)
            return false; 
          if (a) {
            httpURLConnection.getOutputStream().write(arrayOfByte);
          } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(arrayOfByte);
            gZIPOutputStream.close();
            httpURLConnection.getOutputStream().write(byteArrayOutputStream.toByteArray());
          } 
          httpURLConnection.getOutputStream().flush();
          try {
            int i = httpURLConnection.getResponseCode();
            if (a) {
              a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.c;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("response code = ");
              stringBuilder.append(i);
              e1.b("QosReporter", stringBuilder.toString());
            } 
            if (i != 200)
              return false; 
            int j = httpURLConnection.getContentLength();
            if (j == 0)
              return false; 
            i = j;
            if (j < 0)
              i = 16384; 
            try {
              JSONObject jSONObject;
              InputStream inputStream = httpURLConnection.getInputStream();
              byte[] arrayOfByte1 = new byte[i];
              try {
                i = inputStream.read(arrayOfByte1);
                try {
                  inputStream.close();
                  if (i <= 0)
                    return false; 
                  String str1 = (new String(arrayOfByte1)).trim();
                  if (a)
                    a.a.a.a.a.e.e.c.b("QosReporter", str1); 
                  try {
                    jSONObject = new JSONObject(str1);
                    a(paramString1, jSONObject.optInt("reportInterval") * 1000, jSONObject.optInt("sampleInterval") * 1000);
                  } catch (Exception exception) {
                    exception.printStackTrace();
                  } 
                  return true;
                } catch (IOException iOException) {
                  if (a)
                    iOException.printStackTrace(); 
                  return false;
                } 
              } catch (IOException iOException) {
                if (a)
                  iOException.printStackTrace(); 
                try {
                  jSONObject.close();
                  return false;
                } catch (IOException iOException1) {
                  if (a)
                    iOException1.printStackTrace(); 
                  return false;
                } 
              } finally {}
              try {
                jSONObject.close();
                throw paramString1;
              } catch (IOException iOException) {
                if (a)
                  iOException.printStackTrace(); 
                return false;
              } 
            } catch (IOException iOException) {
              if (a)
                iOException.printStackTrace(); 
              return false;
            } catch (Exception exception) {
              if (a)
                exception.printStackTrace(); 
              return false;
            } 
          } catch (IOException iOException) {
            if (a)
              iOException.printStackTrace(); 
            return false;
          } 
        } catch (IOException iOException) {
          if (a)
            iOException.printStackTrace(); 
          return false;
        } catch (Exception exception) {
          return false;
        } 
      } catch (ProtocolException protocolException) {
        if (a)
          protocolException.printStackTrace(); 
        return false;
      } 
    } catch (IOException iOException) {
      if (a)
        iOException.printStackTrace(); 
      return false;
    } catch (Exception exception) {
      if (a)
        exception.printStackTrace(); 
      return false;
    } 
  }
  
  public void b() {
    if (this.g == null)
      return; 
    this.f.removeCallbacksAndMessages(null);
    this.f.sendEmptyMessageDelayed(2, 10L);
  }
  
  public void b(String paramString) {
    a(0, paramString);
  }
  
  public final void b(boolean paramBoolean) {
    String str = c.a().c();
    if (str != null && a("http://stream-pili-qos-report.qiniuapi.com/raw/log/stream-v5", str))
      c.a().b(); 
    if (paramBoolean && this.f != null) {
      c();
      this.f.sendEmptyMessageDelayed(5, c);
    } 
  }
  
  public final void c() {
    Intent intent = new Intent("pldroid-qos-filter");
    intent.putExtra("pldroid-qos-msg-type", 162);
    a.a.a.a.a.k.a.a().a(intent);
  }
  
  public final void c(String paramString) {
    this.h.a(paramString);
  }
  
  public final void d() {
    if (this.g == null)
      return; 
    this.f.removeCallbacksAndMessages(null);
    synchronized (this.i) {
      this.f = null;
      a(false);
      if (this.e)
        b(false); 
      this.g.quit();
      this.g = null;
      this.h.a();
      return;
    } 
  }
  
  public final void d(String paramString) {
    if (c.a().a(paramString) && !this.e) {
      Handler handler = this.f;
      if (handler != null) {
        this.e = true;
        handler.sendEmptyMessageDelayed(5, c);
      } 
    } 
  }
  
  public class a implements Handler.Callback {
    public a(e this$0) {}
    
    public boolean handleMessage(Message param1Message) {
      int i = param1Message.what;
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 5)
                return true; 
              e.b(this.a, true);
              return true;
            } 
            e.b(this.a, (String)param1Message.obj);
            return true;
          } 
          e.a(this.a);
          return true;
        } 
        e.a(this.a, true);
        return true;
      } 
      e.a(this.a, (String)param1Message.obj);
      return true;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\k\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */