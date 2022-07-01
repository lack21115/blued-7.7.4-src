package com.tencent.tbs.sdk.extension.partner.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.tencent.tbs.sdk.extension.partner.c.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;

public class a {
  private static a c;
  
  int a;
  
  boolean b = false;
  
  private Context d;
  
  private long e;
  
  private String f;
  
  private String g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private String l;
  
  private int m;
  
  private int n;
  
  private long o;
  
  private long p;
  
  private int q;
  
  private String r;
  
  private String s;
  
  private long t;
  
  private int u;
  
  private a(Context paramContext) {
    this.d = paramContext.getApplicationContext();
    b();
  }
  
  public static a a(Context paramContext) {
    // Byte code:
    //   0: ldc com/tencent/tbs/sdk/extension/partner/a/a
    //   2: monitorenter
    //   3: getstatic com/tencent/tbs/sdk/extension/partner/a/a.c : Lcom/tencent/tbs/sdk/extension/partner/a/a;
    //   6: ifnonnull -> 20
    //   9: new com/tencent/tbs/sdk/extension/partner/a/a
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Landroid/content/Context;)V
    //   17: putstatic com/tencent/tbs/sdk/extension/partner/a/a.c : Lcom/tencent/tbs/sdk/extension/partner/a/a;
    //   20: getstatic com/tencent/tbs/sdk/extension/partner/a/a.c : Lcom/tencent/tbs/sdk/extension/partner/a/a;
    //   23: astore_0
    //   24: ldc com/tencent/tbs/sdk/extension/partner/a/a
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: astore_0
    //   30: ldc com/tencent/tbs/sdk/extension/partner/a/a
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	29	finally
    //   20	24	29	finally
  }
  
  public static int b(Context paramContext) {
    try {
      String str = paramContext.getPackageName();
      return (paramContext.getPackageManager().getPackageInfo(str, 0)).versionCode;
    } catch (Exception exception) {
      return 0;
    } 
  }
  
  private String b(long paramLong) {
    try {
      return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())).format(new Date(paramLong));
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private String b(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    String str = paramString;
    if (paramString == null)
      str = ""; 
    stringBuilder.append(str);
    stringBuilder.append("|");
    return stringBuilder.toString();
  }
  
  private void b() {
    this.e = 0L;
    this.f = null;
    this.g = null;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.k = 2;
    this.l = "unknown";
    this.m = 0;
    this.n = 2;
    this.o = 0L;
    this.p = 0L;
    this.q = 1;
    this.a = 0;
    this.r = null;
    this.s = null;
    this.t = 0L;
    this.u = 0;
  }
  
  private String c() {
    return "https://log.tbs.qq.com/ajax?c=dl&v=2&k=";
  }
  
  private String c(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("|");
    return stringBuilder.toString();
  }
  
  private String c(long paramLong) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramLong);
    stringBuilder.append("|");
    return stringBuilder.toString();
  }
  
  public int a() {
    return this.u;
  }
  
  public void a(int paramInt) {
    this.u = paramInt;
  }
  
  public void a(int paramInt1, String paramString, int paramInt2) {
    b(paramInt1);
    a(System.currentTimeMillis());
    a(paramString);
    a(paramInt2);
    a(a.c);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setLoadErrorCode(");
    stringBuilder.append(paramInt1);
    stringBuilder.append(", ");
    stringBuilder.append(paramString);
    stringBuilder.append(", ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(")");
    stringBuilder.toString();
  }
  
  public void a(long paramLong) {
    this.e = paramLong;
  }
  
  public void a(a parama) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(c(parama.i));
    stringBuilder.append(b("imei"));
    stringBuilder.append(b("qua2"));
    stringBuilder.append(c(a()));
    String str = Build.MODEL;
    try {
      String str1 = new String(str.getBytes("UTF-8"), "ISO8859-1");
      str = str1;
    } catch (Exception exception) {}
    stringBuilder.append(b(str));
    stringBuilder.append(b(this.d.getPackageName()));
    stringBuilder.append(c(b(this.d)));
    stringBuilder.append(b(b(this.e)));
    stringBuilder.append(b(this.f));
    stringBuilder.append(b(this.g));
    stringBuilder.append(c(this.h));
    stringBuilder.append(c(this.i));
    stringBuilder.append(c(this.j));
    stringBuilder.append(c(this.k));
    stringBuilder.append(b(this.l));
    stringBuilder.append(c(this.m));
    stringBuilder.append(c(this.n));
    stringBuilder.append(c(this.t));
    stringBuilder.append(c(this.o));
    stringBuilder.append(c(this.p));
    stringBuilder.append(c(this.q));
    stringBuilder.append(c(this.a));
    stringBuilder.append(b(this.r));
    stringBuilder.append(b(this.s));
    stringBuilder.append(a());
    JSONArray jSONArray = new JSONArray();
    jSONArray.put(stringBuilder.toString());
    b();
    (new Thread(new Runnable(this, jSONArray) {
          public void run() {
            boolean bool = this.b.a(this.a);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("reportStatData:");
            stringBuilder.append(this.a);
            stringBuilder.append("; ret: ");
            stringBuilder.append(bool);
            com.tencent.tbs.sdk.extension.partner.incrupdate.a.a(stringBuilder.toString());
          }
        })).start();
  }
  
  public void a(String paramString) {
    String str = paramString;
    if (paramString.length() > 1024)
      str = paramString.substring(0, 1024); 
    this.s = str;
  }
  
  public boolean a(JSONArray paramJSONArray) {
    this.b = false;
    if (Looper.getMainLooper() == Looper.myLooper())
      return this.b; 
    if (paramJSONArray == null || paramJSONArray.length() == 0)
      return this.b; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[reportStatData] jsonArray:");
    stringBuilder.append(paramJSONArray);
    stringBuilder.toString();
    try {
      String str = e.a(c(), paramJSONArray.toString().getBytes("utf-8"), new e.a(this) {
            public void a(int param1Int) {
              boolean bool;
              Context context;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("[reportStatData] onHttpResponseCode:");
              stringBuilder.append(param1Int);
              stringBuilder.toString();
              if (param1Int < 300) {
                a a1 = this.a;
                bool = true;
                a1.b = true;
                context = a.a(a1);
              } else {
                context = a.a(this.a);
                bool = false;
              } 
              com.tencent.tbs.sdk.extension.partner.a.a(context, bool);
            }
          }false);
      stringBuilder = new StringBuilder();
      stringBuilder.append("[reportStatData] response:");
      stringBuilder.append(str);
      stringBuilder.toString();
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
    return this.b;
  }
  
  public void b(int paramInt) {
    if (paramInt != 100 && paramInt != 110 && paramInt != 120 && paramInt != 111 && paramInt < 400) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setErrorCode -- errorCode:");
      stringBuilder.append(paramInt);
      stringBuilder.toString();
    } 
    this.a = paramInt;
  }
  
  public void b(int paramInt1, String paramString, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setIncurUpdateErrorCode:");
    stringBuilder.append(paramInt1);
    com.tencent.tbs.sdk.extension.partner.incrupdate.a.a(stringBuilder.toString());
    b(paramInt1);
    a(System.currentTimeMillis());
    a(paramString);
    a(paramInt2);
    a(a.h);
    stringBuilder = new StringBuilder();
    stringBuilder.append("setLoadErrorCode(");
    stringBuilder.append(paramInt1);
    stringBuilder.append(", ");
    stringBuilder.append(paramString);
    stringBuilder.append(", ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(")");
    stringBuilder.toString();
  }
  
  public enum a {
    a(0),
    b(1),
    c(2),
    d(3),
    e(4),
    f(5),
    g(6),
    h(100);
    
    int i;
    
    static {
      throw new VerifyError("bad dex opcode");
    }
    
    a(int param1Int1) {
      this.i = param1Int1;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */