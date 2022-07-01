package com.blued.android.core.net.http.ssl;

import android.os.Build;
import android.text.TextUtils;
import com.blued.android.core.net.http.HttpDnsUtils;
import com.blued.android.core.utils.Log;
import java.io.IOException;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.conscrypt.Conscrypt;

public class HttpsIPAccessUtils {
  private static ConcurrentHashMap<String, String> a = new ConcurrentHashMap<String, String>();
  
  public static String a(String paramString) {
    ConcurrentHashMap<String, String> concurrentHashMap = a;
    if (concurrentHashMap != null && concurrentHashMap.containsValue(paramString))
      for (Map.Entry<String, String> entry : a.entrySet()) {
        if (((String)entry.getValue()).equals(paramString))
          return (String)entry.getKey(); 
      }  
    return null;
  }
  
  public static void a(List<String> paramList) {
    if (paramList != null)
      for (String str : paramList)
        a.put(str, "");  
  }
  
  public static void a(OkHttpClient.Builder paramBuilder) {
    boolean bool1;
    boolean bool2;
    ConcurrentHashMap<String, String> concurrentHashMap = a;
    if (concurrentHashMap != null && concurrentHashMap.size() > 0 && Build.VERSION.SDK_INT >= 22) {
      paramBuilder.a(b()).a(c());
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (Build.VERSION.SDK_INT >= 29) {
      bool2 = false;
    } else {
      bool2 = true;
    } 
    if (bool2) {
      try {
        Security.insertProviderAt(Conscrypt.newProvider(), 1);
        if (Conscrypt.isAvailable()) {
          X509TrustManager x509TrustManager = Conscrypt.getDefaultX509TrustManager();
          SSLContext sSLContext = SSLContext.getInstance("TLS", "Conscrypt");
          sSLContext.init(null, new TrustManager[] { x509TrustManager }, null);
          if (!bool1) {
            paramBuilder.a(new InternalSSLSocketFactoryDefault(sSLContext), x509TrustManager);
            return;
          } 
          paramBuilder.a(new InternalSSLSocketFactory22(sSLContext), x509TrustManager);
          return;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } else if (bool1) {
      exception.a(new InternalSSLSocketFactory29(), d());
      return;
    } 
  }
  
  private static HostnameVerifier b() {
    return new HostnameVerifier() {
        public boolean verify(String param1String, SSLSession param1SSLSession) {
          String str = HttpsIPAccessUtils.a(param1String);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("HostnameVerifier hostname: ");
          stringBuilder.append(param1String);
          stringBuilder.append(" >> ");
          stringBuilder.append(str);
          Log.c("HttpsIPAccessUtils", stringBuilder.toString());
          if (!TextUtils.isEmpty(str))
            param1String = str; 
          return HttpsURLConnection.getDefaultHostnameVerifier().verify(param1String, param1SSLSession);
        }
      };
  }
  
  private static Interceptor c() {
    return new Interceptor() {
        public Response intercept(Interceptor.Chain param1Chain) throws IOException {
          String str1;
          Request request = param1Chain.a();
          HttpUrl httpUrl = request.a();
          String str2 = httpUrl.f();
          if (HttpsIPAccessUtils.a().containsKey(str2)) {
            String str = HttpDnsUtils.a(str2);
            str1 = str;
            if (!TextUtils.isEmpty(str)) {
              HttpsIPAccessUtils.a().put(str2, str);
              str1 = str;
            } 
          } else {
            str1 = "";
          } 
          if (!TextUtils.isEmpty(str1)) {
            String str = httpUrl.toString();
            str1 = str.replaceFirst(str2, str1);
            Headers.Builder builder = request.c().b().a("host", str2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("intercept host: ");
            stringBuilder.append(str);
            stringBuilder.append(" >> ");
            stringBuilder.append(str1);
            Log.c("HttpsIPAccessUtils", stringBuilder.toString());
            return param1Chain.a(request.f().a(str1).a(builder.a()).d());
          } 
          return param1Chain.a(request);
        }
      };
  }
  
  private static X509TrustManager d() {
    return new X509TrustManager() {
        public void checkClientTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {}
        
        public void checkServerTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {}
        
        public X509Certificate[] getAcceptedIssuers() {
          return new X509Certificate[0];
        }
      };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\http\ssl\HttpsIPAccessUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */