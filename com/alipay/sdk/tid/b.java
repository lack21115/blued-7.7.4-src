package com.alipay.sdk.tid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.sdk.util.c;
import java.util.Random;
import org.json.JSONObject;

public class b {
  public static final String a = "alipay_tid_storage";
  
  public static final String b = "tidinfo";
  
  public static final String c = "upgraded_from_db";
  
  public static final String d = "tid";
  
  public static final String e = "client_key";
  
  public static final String f = "timestamp";
  
  public static final String g = "vimei";
  
  public static final String h = "vimsi";
  
  private static Context i;
  
  private static b o;
  
  private String j;
  
  private String k;
  
  private long l;
  
  private String m;
  
  private String n;
  
  private boolean p = false;
  
  public static b a(Context paramContext) {
    // Byte code:
    //   0: ldc com/alipay/sdk/tid/b
    //   2: monitorenter
    //   3: getstatic com/alipay/sdk/tid/b.o : Lcom/alipay/sdk/tid/b;
    //   6: ifnonnull -> 19
    //   9: new com/alipay/sdk/tid/b
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/alipay/sdk/tid/b.o : Lcom/alipay/sdk/tid/b;
    //   19: getstatic com/alipay/sdk/tid/b.i : Landroid/content/Context;
    //   22: ifnonnull -> 32
    //   25: getstatic com/alipay/sdk/tid/b.o : Lcom/alipay/sdk/tid/b;
    //   28: aload_0
    //   29: invokespecial b : (Landroid/content/Context;)V
    //   32: getstatic com/alipay/sdk/tid/b.o : Lcom/alipay/sdk/tid/b;
    //   35: astore_0
    //   36: ldc com/alipay/sdk/tid/b
    //   38: monitorexit
    //   39: aload_0
    //   40: areturn
    //   41: astore_0
    //   42: ldc com/alipay/sdk/tid/b
    //   44: monitorexit
    //   45: aload_0
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	41	finally
    //   19	32	41	finally
    //   32	36	41	finally
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong) {
    if (a(paramString1, paramString2, paramString3, paramString4))
      return; 
    this.j = paramString1;
    this.k = paramString2;
    this.m = paramString3;
    this.n = paramString4;
    if (paramLong == null) {
      this.l = System.currentTimeMillis();
    } else {
      this.l = paramLong.longValue();
    } 
    p();
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3, String paramString4) {
    return (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2) || TextUtils.isEmpty(paramString3) || TextUtils.isEmpty(paramString4));
  }
  
  private void b(Context paramContext) {
    if (paramContext != null)
      i = paramContext.getApplicationContext(); 
    if (this.p)
      return; 
    this.p = true;
    k();
    l();
  }
  
  private void k() {
    // Byte code:
    //   0: getstatic com/alipay/sdk/tid/b.i : Landroid/content/Context;
    //   3: astore #4
    //   5: aload #4
    //   7: ifnonnull -> 11
    //   10: return
    //   11: ldc 'alipay_tid_storage'
    //   13: ldc 'upgraded_from_db'
    //   15: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)Z
    //   18: ifeq -> 29
    //   21: ldc 'mspl'
    //   23: ldc 'tid_mig: pass'
    //   25: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   28: return
    //   29: ldc 'mspl'
    //   31: ldc 'tid_mig: from db'
    //   33: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   36: new com/alipay/sdk/tid/a
    //   39: dup
    //   40: aload #4
    //   42: invokespecial <init> : (Landroid/content/Context;)V
    //   45: astore_2
    //   46: aload #4
    //   48: invokestatic a : (Landroid/content/Context;)Lcom/alipay/sdk/util/a;
    //   51: invokevirtual b : ()Ljava/lang/String;
    //   54: astore_1
    //   55: aload #4
    //   57: invokestatic a : (Landroid/content/Context;)Lcom/alipay/sdk/util/a;
    //   60: invokevirtual a : ()Ljava/lang/String;
    //   63: astore #5
    //   65: aload_2
    //   66: aload_1
    //   67: aload #5
    //   69: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_3
    //   73: aload_2
    //   74: aload_1
    //   75: aload #5
    //   77: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: astore #5
    //   82: aload_2
    //   83: astore_1
    //   84: aload_3
    //   85: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   88: ifne -> 110
    //   91: aload_2
    //   92: astore_1
    //   93: aload #5
    //   95: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   98: ifne -> 110
    //   101: aload_0
    //   102: aload_3
    //   103: aload #5
    //   105: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_2
    //   109: astore_1
    //   110: aload_1
    //   111: invokevirtual close : ()V
    //   114: aload_1
    //   115: astore_2
    //   116: goto -> 143
    //   119: astore_3
    //   120: aload_2
    //   121: astore_1
    //   122: goto -> 130
    //   125: astore_2
    //   126: aconst_null
    //   127: astore_1
    //   128: aload_2
    //   129: astore_3
    //   130: aload_3
    //   131: invokestatic a : (Ljava/lang/Throwable;)V
    //   134: aload_1
    //   135: astore_2
    //   136: aload_1
    //   137: ifnull -> 143
    //   140: goto -> 110
    //   143: ldc 'mspl'
    //   145: ldc 'tid_mig: db purge'
    //   147: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   150: new com/alipay/sdk/tid/a
    //   153: dup
    //   154: aload #4
    //   156: invokespecial <init> : (Landroid/content/Context;)V
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual a : ()V
    //   164: aload_1
    //   165: invokevirtual close : ()V
    //   168: goto -> 192
    //   171: astore_3
    //   172: aload_1
    //   173: astore_2
    //   174: aload_3
    //   175: astore_1
    //   176: goto -> 180
    //   179: astore_1
    //   180: aload_1
    //   181: invokestatic a : (Ljava/lang/Throwable;)V
    //   184: aload_2
    //   185: ifnull -> 192
    //   188: aload_2
    //   189: invokevirtual close : ()V
    //   192: ldc 'alipay_tid_storage'
    //   194: ldc 'upgraded_from_db'
    //   196: ldc 'updated'
    //   198: iconst_0
    //   199: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   202: return
    //   203: astore_1
    //   204: aload_2
    //   205: ifnull -> 212
    //   208: aload_2
    //   209: invokevirtual close : ()V
    //   212: aload_1
    //   213: athrow
    //   214: astore_2
    //   215: aload_1
    //   216: ifnull -> 223
    //   219: aload_1
    //   220: invokevirtual close : ()V
    //   223: aload_2
    //   224: athrow
    // Exception table:
    //   from	to	target	type
    //   29	46	125	finally
    //   46	82	119	finally
    //   84	91	119	finally
    //   93	108	119	finally
    //   130	134	214	finally
    //   143	160	179	finally
    //   160	164	171	finally
    //   180	184	203	finally
  }
  
  private void l() {
    Exception exception1;
    Long long_1 = Long.valueOf(System.currentTimeMillis());
    String str2 = null;
    try {
      String str = a.a("alipay_tid_storage", "tidinfo", true);
      if (!TextUtils.isEmpty(str)) {
        JSONObject jSONObject = new JSONObject(str);
        str = jSONObject.optString("tid", "");
        try {
          String str3 = jSONObject.optString("client_key", "");
          try {
            exception1 = (Exception)Long.valueOf(jSONObject.optLong("timestamp", System.currentTimeMillis()));
            long_1 = (Long)exception1;
            str2 = jSONObject.optString("vimei", "");
            try {
              String str4 = jSONObject.optString("vimsi", "");
              String str5 = str;
              str = str2;
            } catch (Exception null) {
              long_1 = (Long)exception1;
              String str4 = str;
              str = str2;
            } 
          } catch (Exception null) {
            str2 = null;
            exception1 = (Exception)str;
            str = str2;
          } 
        } catch (Exception null) {
          exception1 = (Exception)str;
          Object object = null;
          str = null;
        } 
      } else {
        String str3 = null;
        str = str3;
        exception1 = (Exception)str;
        Long long_ = long_1;
        String str4 = (String)exception1;
        c.a("mspl", "tid_str: load");
      } 
    } catch (Exception exception2) {
      exception1 = null;
      Object object2 = null;
      Object object1 = null;
    } 
    c.a(exception2);
    str2 = null;
    exception2 = exception1;
    Long long_2 = long_1;
    String str1 = str2;
  }
  
  private void m() {
    this.j = "";
    this.k = f();
    this.l = System.currentTimeMillis();
    this.m = n();
    this.n = n();
    a.b("alipay_tid_storage", "tidinfo");
  }
  
  private String n() {
    String str = Long.toHexString(System.currentTimeMillis());
    Random random = new Random();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(random.nextInt(9000) + 1000);
    return stringBuilder.toString();
  }
  
  private void o() {}
  
  private void p() {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("tid", this.j);
      jSONObject.put("client_key", this.k);
      jSONObject.put("timestamp", this.l);
      jSONObject.put("vimei", this.m);
      jSONObject.put("vimsi", this.n);
      a.a("alipay_tid_storage", "tidinfo", jSONObject.toString(), true);
      return;
    } catch (Exception exception) {
      c.a(exception);
      return;
    } 
  }
  
  public String a() {
    return this.j;
  }
  
  public void a(String paramString1, String paramString2) {
    c.a("mspl", "tid_str: save");
    if (!TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2))
        return; 
      this.j = paramString1;
      this.k = paramString2;
      this.l = System.currentTimeMillis();
      p();
      o();
    } 
  }
  
  public String b() {
    return this.k;
  }
  
  public String c() {
    return this.m;
  }
  
  public String d() {
    return this.n;
  }
  
  public boolean e() {
    return (TextUtils.isEmpty(this.j) || TextUtils.isEmpty(this.k) || TextUtils.isEmpty(this.m) || TextUtils.isEmpty(this.n));
  }
  
  public String f() {
    String str2 = Long.toHexString(System.currentTimeMillis());
    String str1 = str2;
    if (str2.length() > 10)
      str1 = str2.substring(str2.length() - 10); 
    return str1;
  }
  
  public void g() {
    c.a("mspl", "tid_str: del");
    m();
  }
  
  public boolean h() {
    return e();
  }
  
  public Long i() {
    return Long.valueOf(this.l);
  }
  
  public static class a {
    private static String a() {
      return "!@#23457";
    }
    
    public static String a(String param1String1, String param1String2, boolean param1Boolean) {
      if (b.j() == null)
        return null; 
      String str2 = b.j().getSharedPreferences(param1String1, 0).getString(param1String2, null);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        str1 = str2;
        if (param1Boolean) {
          String str = com.alipay.sdk.encrypt.b.b(str2, b());
          str1 = str;
          if (TextUtils.isEmpty(str)) {
            str2 = com.alipay.sdk.encrypt.b.b(str2, a());
            str1 = str2;
            if (!TextUtils.isEmpty(str2)) {
              a(param1String1, param1String2, str2, true);
              str1 = str2;
            } 
          } 
          param1String1 = str1;
          str1 = param1String1;
          if (TextUtils.isEmpty(param1String1)) {
            c.a("mspl", "tid_str: pref failed");
            str1 = param1String1;
          } 
        } 
      } 
      c.a("mspl", "tid_str: from local");
      return str1;
    }
    
    public static void a(String param1String1, String param1String2, String param1String3) {
      a(param1String1, param1String2, param1String3, true);
    }
    
    public static void a(String param1String1, String param1String2, String param1String3, boolean param1Boolean) {
      if (b.j() == null)
        return; 
      SharedPreferences sharedPreferences = b.j().getSharedPreferences(param1String1, 0);
      param1String1 = param1String3;
      if (param1Boolean) {
        String str = b();
        param1String1 = com.alipay.sdk.encrypt.b.a(param1String3, str);
        if (TextUtils.isEmpty(param1String1))
          String.format("LocalPreference::putLocalPreferences failed %s，%s", new Object[] { param1String3, str }); 
      } 
      sharedPreferences.edit().putString(param1String2, param1String1).apply();
    }
    
    public static boolean a(String param1String1, String param1String2) {
      return (b.j() == null) ? false : b.j().getSharedPreferences(param1String1, 0).contains(param1String2);
    }
    
    private static String b() {
      String str1;
      String str2;
      try {
        str1 = b.j().getApplicationContext().getPackageName();
      } finally {
        Exception exception = null;
        c.a(exception);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str2);
      stringBuilder.append("00000000");
      return stringBuilder.toString().substring(0, 8);
    }
    
    public static void b(String param1String1, String param1String2) {
      if (b.j() == null)
        return; 
      b.j().getSharedPreferences(param1String1, 0).edit().remove(param1String2).apply();
    }
    
    public static String c(String param1String1, String param1String2) {
      return a(param1String1, param1String2, true);
    }
    
    public static boolean d(String param1String1, String param1String2) {
      return (b.j() == null) ? false : b.j().getSharedPreferences(param1String1, 0).contains(param1String2);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\tid\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */