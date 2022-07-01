package com.huawei.updatesdk.a.b.d;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.updatesdk.a.a.b.a.a.a;
import com.huawei.updatesdk.a.a.c.g;
import com.huawei.updatesdk.a.b.d.c.a;
import com.huawei.updatesdk.a.b.d.c.c;
import com.huawei.updatesdk.a.b.d.c.d;
import com.huawei.updatesdk.b.e.a.a;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends AsyncTask<c, Void, d> {
  protected c a = null;
  
  private d b = null;
  
  private a c = null;
  
  private com.huawei.updatesdk.a.a.a.b d = null;
  
  private int e = 0;
  
  public b(c paramc, a parama) {
    this.a = paramc;
    this.c = parama;
  }
  
  private d a(String paramString1, String paramString2, d paramd) {
    try {
      paramd.fromJson(new JSONObject(paramString2));
      paramd.b(0);
      return paramd;
    } catch (JSONException jSONException) {
    
    } catch (ClassNotFoundException classNotFoundException) {
    
    } catch (InstantiationException instantiationException) {
    
    } catch (IllegalAccessException illegalAccessException) {}
    a.a("StoreTask", "parse json error", illegalAccessException);
    return paramd;
  }
  
  private void a(d paramd, int paramInt, d.a parama, Throwable paramThrowable) {
    if (paramd != null) {
      paramd.b(paramInt);
      paramd.a(parama);
      paramd.a(paramThrowable.toString());
    } 
  }
  
  private void a(d paramd, Throwable paramThrowable, String paramString) {
    d.a a1;
    boolean bool = paramThrowable instanceof java.net.ConnectException;
    byte b1 = 1;
    if (bool) {
      a1 = d.a.f;
    } else if (paramThrowable instanceof java.net.SocketTimeoutException || paramThrowable instanceof org.apache.http.conn.ConnectTimeoutException) {
      a1 = d.a.f;
      b1 = 2;
    } else if (paramThrowable instanceof IllegalArgumentException) {
      a1 = d.a.d;
      b1 = 5;
    } else if (paramThrowable instanceof IllegalAccessException) {
      a1 = d.a.g;
    } else if (paramThrowable instanceof ArrayIndexOutOfBoundsException) {
      a1 = d.a.h;
      b1 = 6;
    } else {
      if (paramThrowable instanceof InterruptedException || paramThrowable instanceof java.io.InterruptedIOException) {
        a(paramd, 0, d.a.a, paramThrowable);
        Log.e("StoreTask", "UpdateSDK task is canceled");
      } else {
        if (paramThrowable instanceof java.io.IOException) {
          a1 = d.a.e;
        } else {
          if (paramd != null)
            paramd.a(paramThrowable.toString()); 
          a(paramString, paramThrowable);
        } 
        a(paramd, b1, a1, paramThrowable);
      } 
      a(paramString, paramThrowable);
    } 
    a(paramd, b1, a1, paramThrowable);
  }
  
  private void a(String paramString, Throwable paramThrowable) {
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("invoke store error");
    stringBuilder3.append(", exceptionType:");
    stringBuilder3.append(paramThrowable.getClass().getName());
    stringBuilder3.append(", url:");
    stringBuilder3.append(paramString);
    stringBuilder3.append(", method:");
    stringBuilder3.append(this.a.b());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(", retryTimes:");
    stringBuilder1.append(this.e);
    stringBuilder3.append(stringBuilder1.toString());
    String str = stringBuilder3.toString();
    a.a("StoreTask", str, paramThrowable);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("UpdateSDK call store error: ");
    stringBuilder2.append(str);
    Log.e("StoreTask", stringBuilder2.toString());
  }
  
  private boolean a(String paramString) {
    return (TextUtils.isEmpty(paramString) || !g.d(paramString));
  }
  
  private void b(String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "UpdateSDK response error, resData == null";
    } else {
      paramString = "UpdateSDK response error, resData is not json string";
    } 
    Log.e("StoreTask", paramString);
  }
  
  private void c(d paramd) {
    if (!isCancelled() && this.c != null) {
      d d1 = paramd;
      if (paramd == null) {
        d.a a1;
        a.b("StoreTask", "notifyResult, response is null");
        try {
          d1 = a.a(this.a.b());
          paramd = d1;
        } catch (InstantiationException instantiationException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("notifyResult, create response error, method:");
          stringBuilder.append(this.a.b());
          a.a("StoreTask", stringBuilder.toString(), instantiationException);
        } catch (IllegalAccessException illegalAccessException) {
          StringBuilder stringBuilder = new StringBuilder();
        } 
        if (paramd == null) {
          paramd = new d();
          a1 = d.a.d;
        } else {
          a1 = d.a.g;
        } 
        paramd.a(a1);
        paramd.b(1);
        d1 = paramd;
      } 
      this.c.b(this.a, d1);
    } 
  }
  
  private boolean d(d paramd) {
    if (isCancelled())
      return false; 
    if (paramd.d() != 1 && paramd.d() != 2)
      return false; 
    int i = this.e;
    this.e = i + 1;
    if (i >= 3) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("retry completed total times = ");
      stringBuilder1.append(this.e);
      stringBuilder1.append(",response.responseCode = ");
      stringBuilder1.append(paramd.d());
      a.a("StoreTask", stringBuilder1.toString());
      return false;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("retry times = ");
    stringBuilder.append(this.e);
    stringBuilder.append(",response.responseCode = ");
    stringBuilder.append(paramd.d());
    a.a("StoreTask", stringBuilder.toString());
    return true;
  }
  
  private void e() {
    c(this.b);
  }
  
  protected d a() {
    d d1;
    Exception exception;
    String str1 = null;
    String str2 = null;
    try {
      d d2 = a.a(this.a.b());
      str1 = str2;
      d1 = d2;
    } finally {
      exception = null;
    } 
    a(d1, exception, str1);
  }
  
  protected d a(c... paramVarArgs) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("doInBackground, method:");
    stringBuilder.append(this.a.b());
    a.a("StoreTask", stringBuilder.toString());
    com.huawei.updatesdk.b.e.a.b.a(this);
    d d1 = c();
    a a1 = this.c;
    if (a1 != null)
      a1.a(this.a, d1); 
    return d1;
  }
  
  public void a(d paramd) {}
  
  public final void a(Executor paramExecutor) {
    executeOnExecutor(paramExecutor, (Object[])new c[] { this.a });
  }
  
  public void b() {
    com.huawei.updatesdk.a.a.a.b b1 = this.d;
    if (b1 != null) {
      b1.a();
      this.d = null;
    } 
  }
  
  protected void b(d paramd) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onPostExecute, method:");
    stringBuilder.append(this.a.b());
    a.a("StoreTask", stringBuilder.toString());
    com.huawei.updatesdk.b.e.a.b.a().remove(this);
    e();
  }
  
  public final d c() {
    d d1 = null;
    while (true) {
      if (this.e > 0 && d1 != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("call store error! responseCode:");
        stringBuilder.append(d1.d());
        stringBuilder.append(", retryTimes:");
        stringBuilder.append(this.e);
        a.a("StoreTask", stringBuilder.toString());
      } 
      d d2 = a();
      a(d2);
      d1 = d2;
      if (!d(d2)) {
        this.b = d2;
        return this.b;
      } 
    } 
  }
  
  protected String d() {
    String str2 = a.a();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = "Android/1.0"; 
    return str1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\b\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */