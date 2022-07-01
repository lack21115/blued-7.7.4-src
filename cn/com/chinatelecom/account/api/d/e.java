package cn.com.chinatelecom.account.api.d;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.ClientUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

public class e {
  private String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private String h;
  
  private String i;
  
  private String j;
  
  private String k;
  
  private String l;
  
  private String m;
  
  private String n;
  
  private int o;
  
  private String p;
  
  private long q;
  
  private long r;
  
  private String s;
  
  private int t;
  
  private StringBuffer u;
  
  private long v;
  
  private long w;
  
  public e(String paramString) {
    String str;
    this.r = -1L;
    this.u = new StringBuffer();
    this.c = "";
    this.e = "";
    this.n = "";
    this.m = "";
    this.p = "";
    this.a = "1.2";
    this.v = SystemClock.uptimeMillis();
    this.b = a(System.currentTimeMillis());
    this.d = CtAuth.mAppId;
    this.f = "";
    this.g = Build.BRAND;
    this.h = Build.MODEL;
    this.i = "Android";
    this.j = Build.VERSION.RELEASE;
    if (ClientUtils.getSdkType() == 1) {
      str = "SDK-HY-v3.7.3";
    } else {
      str = "SDK-API-v3.7.3";
    } 
    this.k = str;
    this.l = paramString;
    this.s = "0";
  }
  
  public static String a(long paramLong) {
    try {
      return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA)).format(new Date(paramLong));
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  public e a(int paramInt) {
    this.o = paramInt;
    return this;
  }
  
  public e a(String paramString) {
    this.e = paramString;
    return this;
  }
  
  public String a() {
    return this.l;
  }
  
  public e b(int paramInt) {
    this.t = paramInt;
    return this;
  }
  
  public e b(long paramLong) {
    if (paramLong >= 0L)
      this.q = paramLong; 
    return this;
  }
  
  public e b(String paramString) {
    this.f = paramString;
    return this;
  }
  
  public void b() {
    this.w = SystemClock.uptimeMillis();
    if (this.r == -1L)
      this.r = this.w - this.v; 
  }
  
  public e c(String paramString) {
    this.m = paramString;
    return this;
  }
  
  public e d(String paramString) {
    this.n = paramString;
    return this;
  }
  
  public e e(String paramString) {
    this.p = paramString;
    return this;
  }
  
  public e f(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      this.s = paramString; 
    return this;
  }
  
  public e g(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      StringBuffer stringBuffer = this.u;
      stringBuffer.append(paramString);
      stringBuffer.append(";");
    } 
    return this;
  }
  
  public String toString() {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("v", this.a);
      jSONObject.put("t", this.b);
      jSONObject.put("tag", this.c);
      jSONObject.put("ai", this.d);
      jSONObject.put("di", this.e);
      jSONObject.put("ns", this.f);
      jSONObject.put("br", this.g);
      jSONObject.put("ml", this.h);
      jSONObject.put("os", this.i);
      jSONObject.put("ov", this.j);
      jSONObject.put("sv", this.k);
      jSONObject.put("ri", this.l);
      jSONObject.put("api", this.m);
      jSONObject.put("p", this.n);
      jSONObject.put("rt", this.o);
      jSONObject.put("msg", this.p);
      jSONObject.put("st", this.q);
      jSONObject.put("tt", this.r);
      jSONObject.put("ot", this.s);
      return jSONObject.toString();
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */