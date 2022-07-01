package com.blued.android.core.net.http;

import android.os.AsyncTask;
import android.util.Log;
import com.blued.android.core.net.HttpManager;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class HttpDnsUtils {
  private static Set<String> a = new HashSet<String>();
  
  public static String a(String paramString) {
    if (HttpManager.d() != null) {
      String[] arrayOfString;
      if (HttpManager.e()) {
        try {
          arrayOfString = HttpManager.d().query(paramString);
        } catch (IOException iOException) {
          iOException.printStackTrace();
          iOException = null;
        } 
      } else {
        String[] arrayOfString1 = HttpManager.d().queryFromCache(paramString);
        arrayOfString = arrayOfString1;
        if (arrayOfString1 == null) {
          b(paramString);
          arrayOfString = arrayOfString1;
        } 
      } 
      if (arrayOfString != null && arrayOfString.length > 0) {
        if (HttpManager.c()) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("get HttpDns from cache, ");
          stringBuilder.append(paramString);
          stringBuilder.append(" -> ");
          stringBuilder.append(arrayOfString[0]);
          Log.v("HttpManager", stringBuilder.toString());
        } 
        return arrayOfString[0];
      } 
    } 
    return null;
  }
  
  private static void b(String paramString) {
    synchronized (a) {
      if (!a.contains(paramString)) {
        a.add(paramString);
        (new HttpDnsTask(paramString)).execute(new Object[0]);
      } 
      return;
    } 
  }
  
  public static class HttpDnsResult {
    public String a;
    
    public String b;
    
    public String c;
    
    public String d;
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[oriUrl:");
      stringBuilder.append(this.a);
      stringBuilder.append(", ipUrl:");
      stringBuilder.append(this.b);
      stringBuilder.append(", hostName:");
      stringBuilder.append(this.c);
      stringBuilder.append(", ipAddr:");
      stringBuilder.append(this.d);
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
  
  static class HttpDnsTask extends AsyncTask {
    private String a;
    
    public HttpDnsTask(String param1String) {
      this.a = param1String;
    }
    
    protected Object doInBackground(Object[] param1ArrayOfObject) {
      if (HttpManager.d() != null)
        try {
          HttpManager.d().query(this.a);
          if (HttpManager.c()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("finish update HttpDns for ");
            stringBuilder.append(this.a);
            Log.v("HttpManager", stringBuilder.toString());
          } 
        } catch (IOException iOException) {
          iOException.printStackTrace();
        }  
      return null;
    }
    
    protected void onCancelled() {
      super.onCancelled();
      synchronized (HttpDnsUtils.a()) {
        HttpDnsUtils.a().remove(this.a);
        return;
      } 
    }
    
    protected void onPostExecute(Object param1Object) {
      super.onPostExecute(param1Object);
      synchronized (HttpDnsUtils.a()) {
        HttpDnsUtils.a().remove(this.a);
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\http\HttpDnsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */