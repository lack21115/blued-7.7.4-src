package cn.com.chinatelecom.account.api.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.b.c;
import cn.com.chinatelecom.account.api.d.d;
import cn.com.chinatelecom.account.api.d.g;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

public abstract class f implements e {
  private static final String b = f.class.getSimpleName();
  
  protected Context a;
  
  public f(Context paramContext) {
    this.a = paramContext;
  }
  
  public static void a(Context paramContext, String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    try {
      ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (connectivityManager.getNetworkInfo(5).getState().compareTo((Enum)NetworkInfo.State.CONNECTED) == 0) {
        int i = c.a(c.b(paramString));
        return;
      } 
    } finally {
      paramContext = null;
    } 
  }
  
  private void a(HttpsURLConnection paramHttpsURLConnection, String paramString) {
    paramHttpsURLConnection.setHostnameVerifier(new HostnameVerifier(this, paramString) {
          public boolean verify(String param1String, SSLSession param1SSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, param1SSLSession);
          }
        });
    paramHttpsURLConnection.setSSLSocketFactory(new SSLSocketFactory(this, paramString) {
          public Socket createSocket(String param1String, int param1Int) {
            return null;
          }
          
          public Socket createSocket(String param1String, int param1Int1, InetAddress param1InetAddress, int param1Int2) {
            return null;
          }
          
          public Socket createSocket(InetAddress param1InetAddress, int param1Int) {
            return null;
          }
          
          public Socket createSocket(InetAddress param1InetAddress1, int param1Int1, InetAddress param1InetAddress2, int param1Int2) {
            return null;
          }
          
          public Socket createSocket(Socket param1Socket, String param1String, int param1Int, boolean param1Boolean) {
            try {
              SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory)SSLCertificateSocketFactory.getDefault(0);
              param1Socket = sSLCertificateSocketFactory.createSocket(param1Socket, this.a, param1Int, param1Boolean);
            } finally {
              param1String = null;
            } 
            param1String.printStackTrace();
            return param1Socket;
          }
          
          public String[] getDefaultCipherSuites() {
            return new String[0];
          }
          
          public String[] getSupportedCipherSuites() {
            return new String[0];
          }
        });
  }
  
  private boolean b() {
    return g.c(this.a);
  }
  
  protected boolean a() {
    return (Build.VERSION.SDK_INT >= 21);
  }
  
  protected boolean a(String paramString) {
    return paramString.startsWith("https");
  }
  
  protected boolean a(boolean paramBoolean, String paramString) {
    return (paramBoolean && paramString != null && Build.VERSION.SDK_INT >= 17);
  }
  
  protected HttpURLConnection d(String paramString1, String paramString2, int paramInt, g paramg) {
    URL uRL = new URL(paramString1);
    if (paramg.a != null && a()) {
      uRLConnection = paramg.a.openConnection(uRL);
    } else {
      uRLConnection = uRLConnection.openConnection();
    } 
    URLConnection uRLConnection = uRLConnection;
    uRLConnection.setRequestProperty("accept", "*/*");
    if (paramInt == 0) {
      uRLConnection.setRequestMethod("GET");
    } else {
      uRLConnection.setRequestMethod("POST");
      uRLConnection.setDoOutput(true);
      uRLConnection.setDoInput(true);
    } 
    uRLConnection.setConnectTimeout(paramg.a());
    uRLConnection.setReadTimeout(paramg.b());
    uRLConnection.setUseCaches(false);
    if (!b() && !a())
      uRLConnection.setInstanceFollowRedirects(false); 
    uRLConnection.addRequestProperty("Accept-Charset", "UTF-8");
    uRLConnection.addRequestProperty("reqId", paramg.d);
    uRLConnection.addRequestProperty("deviceId", d.a(this.a));
    if (!TextUtils.isEmpty(paramString2)) {
      DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(uRLConnection.getOutputStream()));
      dataOutputStream.write(paramString2.getBytes("UTF-8"));
      dataOutputStream.flush();
      dataOutputStream.close();
      return (HttpURLConnection)uRLConnection;
    } 
    uRLConnection.connect();
    return (HttpURLConnection)uRLConnection;
  }
  
  protected HttpsURLConnection e(String paramString1, String paramString2, int paramInt, g paramg) {
    URL uRL = new URL(paramString1);
    if (paramg.a != null && a()) {
      uRLConnection = paramg.a.openConnection(uRL);
    } else {
      uRLConnection = uRLConnection.openConnection();
    } 
    URLConnection uRLConnection = uRLConnection;
    uRLConnection.setRequestProperty("accept", "*/*");
    if (a(paramg.f, paramg.g)) {
      uRLConnection.addRequestProperty("Host", paramg.h);
      a((HttpsURLConnection)uRLConnection, paramg.h);
    } 
    if (paramInt == 0) {
      uRLConnection.setRequestMethod("GET");
    } else {
      uRLConnection.setRequestMethod("POST");
      uRLConnection.setDoOutput(true);
      uRLConnection.setDoInput(true);
    } 
    uRLConnection.setConnectTimeout(paramg.a());
    uRLConnection.setReadTimeout(paramg.b());
    uRLConnection.setUseCaches(false);
    if (!b() && !a())
      uRLConnection.setInstanceFollowRedirects(false); 
    uRLConnection.addRequestProperty("Accept-Charset", "UTF-8");
    uRLConnection.addRequestProperty("reqId", paramg.d);
    uRLConnection.addRequestProperty("deviceId", d.a(this.a));
    if (!TextUtils.isEmpty(paramString2)) {
      DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(uRLConnection.getOutputStream()));
      dataOutputStream.write(paramString2.getBytes("UTF-8"));
      dataOutputStream.flush();
      dataOutputStream.close();
      return (HttpsURLConnection)uRLConnection;
    } 
    uRLConnection.connect();
    return (HttpsURLConnection)uRLConnection;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */