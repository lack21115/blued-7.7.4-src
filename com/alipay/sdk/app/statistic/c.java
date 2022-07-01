package com.alipay.sdk.app.statistic;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.tid.b;
import com.alipay.sdk.util.a;
import com.alipay.sdk.util.n;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

public class c {
  public static final String A = "ClientBindException";
  
  public static final String B = "SaveTradeTokenError";
  
  public static final String C = "ClientBindServiceFailed";
  
  public static final String D = "TryStartServiceEx";
  
  public static final String E = "BindWaitTimeoutEx";
  
  public static final String F = "CheckClientExistEx";
  
  public static final String G = "CheckClientSignEx";
  
  public static final String H = "GetInstalledAppEx";
  
  public static final String I = "ParserTidClientKeyEx";
  
  public static final String J = "PgApiInvoke";
  
  public static final String K = "PgBindStarting";
  
  public static final String L = "PgBinded";
  
  public static final String M = "PgBindEnd";
  
  public static final String N = "PgBindPay";
  
  public static final String O = "PgReturn";
  
  public static final String P = "PgWltVer";
  
  public static final String Q = "PgOpenStarting";
  
  public static final String R = "ErrIntentEx";
  
  public static final String S = "ErrActNull";
  
  public static final String T = "ErrActNull";
  
  public static final String U = "GetInstalledAppEx";
  
  public static final String V = "StartLaunchAppTransEx";
  
  public static final String W = "CheckLaunchAppExistEx";
  
  public static final String X = "LogCurrentAppLaunchSwitch";
  
  public static final String Y = "LogCurrentQueryTime";
  
  public static final String Z = "LogCalledPackage";
  
  public static final String a = "net";
  
  public static final String aa = "LogBindCalledH5";
  
  public static final String ab = "LogCalledH5";
  
  public static final String ac = "LogHkLoginByIntent";
  
  public static final String ad = "SchemePayWrongHashEx";
  
  public static final String ae = "LogAppLaunchSwitchEnabled";
  
  public static final String af = "H5CbUrlEmpty";
  
  public static final String ag = "H5CbEx";
  
  public static final String ah = "BuildSchemePayUriError";
  
  public static final String ai = "StartActivityEx";
  
  public static final String aj = "JSONEx";
  
  public static final String ak = "ParseBundleSerializableError";
  
  public static final String al = "ParseSchemeQueryError";
  
  public static final String am = "tid_context_null";
  
  public static final String an = "partner";
  
  public static final String ao = "out_trade_no";
  
  public static final String ap = "trade_no";
  
  public static final String aq = "biz_content";
  
  public static final String ar = "app_id";
  
  public static final String b = "biz";
  
  public static final String c = "cp";
  
  public static final String d = "auth";
  
  public static final String e = "third";
  
  public static final String f = "tid";
  
  public static final String g = "FormatResultEx";
  
  public static final String h = "GetApdidEx";
  
  public static final String i = "GetApdidNull";
  
  public static final String j = "GetApdidTimeout";
  
  public static final String k = "GetUtdidEx";
  
  public static final String l = "GetPackageInfoEx";
  
  public static final String m = "NotIncludeSignatures";
  
  public static final String n = "GetInstalledPackagesEx";
  
  public static final String o = "GetPublicKeyFromSignEx";
  
  public static final String p = "H5PayNetworkError";
  
  public static final String q = "H5AuthNetworkError";
  
  public static final String r = "SSLError";
  
  public static final String s = "SSLProceed";
  
  public static final String t = "SSLDenied";
  
  public static final String u = "H5PayDataAnalysisError";
  
  public static final String v = "H5AuthDataAnalysisError";
  
  public static final String w = "PublicKeyUnmatch";
  
  public static final String x = "ClientBindFailed";
  
  public static final String y = "TriDesEncryptError";
  
  public static final String z = "TriDesDecryptError";
  
  private String aA;
  
  private String aB;
  
  private String as;
  
  private String at;
  
  private String au;
  
  private String av;
  
  private String aw;
  
  private String ax;
  
  private String ay;
  
  private String az;
  
  public c(Context paramContext, boolean paramBoolean) {
    long l;
    this.az = "";
    this.aA = "";
    Context context = paramContext;
    if (paramContext != null)
      context = paramContext.getApplicationContext(); 
    this.as = c();
    this.au = a(context);
    if (paramBoolean) {
      l = 0L;
    } else {
      l = a.c.a(context);
    } 
    this.av = a(l);
    this.aw = d();
    this.ax = b(context);
    this.ay = "-";
    this.aB = "-";
  }
  
  private static String a(long paramLong) {
    String str1 = b("15.7.4");
    String str2 = b("h.a.3.7.4");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("~");
    stringBuilder.append(paramLong);
    return String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,%s,-", new Object[] { str1, str2, stringBuilder.toString() });
  }
  
  private static String a(Context paramContext) {
    String str3 = "-";
    if (paramContext != null)
      try {
        String str4;
        paramContext = paramContext.getApplicationContext();
        String str5 = paramContext.getPackageName();
        try {
          PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(str5, 64);
          str4 = packageInfo.versionName;
          String str = a(packageInfo);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str4);
          stringBuilder.append("|");
          stringBuilder.append(str);
          str4 = stringBuilder.toString();
        } finally {
          paramContext = null;
        } 
      } finally {} 
    String str2 = "-";
    String str1 = str3;
    return String.format("%s,%s,-,-,-", new Object[] { b(str2), b(str1) });
  }
  
  private static String a(PackageInfo paramPackageInfo) {
    if (paramPackageInfo == null || paramPackageInfo.signatures == null || paramPackageInfo.signatures.length == 0)
      return "0"; 
    try {
      int i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramPackageInfo.signatures.length);
      Signature[] arrayOfSignature = paramPackageInfo.signatures;
      int j = arrayOfSignature.length;
    } finally {
      paramPackageInfo = null;
    } 
  }
  
  private static String a(Throwable paramThrowable) {
    if (paramThrowable == null)
      return ""; 
    StringBuffer stringBuffer = new StringBuffer();
    try {
      stringBuffer.append(paramThrowable.getClass().getName());
      stringBuffer.append(":");
      stringBuffer.append(paramThrowable.getMessage());
      stringBuffer.append(" 》 ");
      StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
      if (arrayOfStackTraceElement != null) {
        int k = arrayOfStackTraceElement.length;
        int i = 0;
        int j = 0;
        while (i < k) {
          stringBuffer.append(arrayOfStackTraceElement[i].toString());
          stringBuffer.append(" 》 ");
          if (++j > 5)
            break; 
          i++;
        } 
      } 
    } finally {}
    return stringBuffer.toString();
  }
  
  private boolean a() {
    return TextUtils.isEmpty(this.aA);
  }
  
  private static String b() {
    return (new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault())).format(new Date());
  }
  
  private static String b(Context paramContext) {
    return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", new Object[] { b(a.d(paramContext)), "android", b(Build.VERSION.RELEASE), b(Build.MODEL), "-", b(a.a(paramContext).a()), b(a.b(paramContext).b()), "gw", b(a.a(paramContext).b()) });
  }
  
  private static String b(String paramString) {
    return TextUtils.isEmpty(paramString) ? "" : paramString.replace("[", "【").replace("]", "】").replace("(", "（").replace(")", "）").replace(",", "，").replace("^", "~").replace("#", "＃");
  }
  
  private static String c() {
    return String.format("123456789,%s", new Object[] { (new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss")).format(new Date()) });
  }
  
  private static String c(String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = "-"; 
    return str;
  }
  
  private void c(String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 'mspl'
    //   5: ldc_w 'err %s %s %s'
    //   8: iconst_3
    //   9: anewarray java/lang/Object
    //   12: dup
    //   13: iconst_0
    //   14: aload_1
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: aload_2
    //   19: aastore
    //   20: dup
    //   21: iconst_2
    //   22: aload_3
    //   23: aastore
    //   24: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   27: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   30: ldc ''
    //   32: astore #4
    //   34: aload_0
    //   35: getfield aA : Ljava/lang/String;
    //   38: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   41: ifne -> 77
    //   44: new java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial <init> : ()V
    //   51: astore #4
    //   53: aload #4
    //   55: ldc ''
    //   57: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload #4
    //   63: ldc_w '^'
    //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload #4
    //   72: invokevirtual toString : ()Ljava/lang/String;
    //   75: astore #4
    //   77: new java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial <init> : ()V
    //   84: astore #5
    //   86: aload #5
    //   88: aload #4
    //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_3
    //   95: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   98: ifeq -> 108
    //   101: ldc_w '-'
    //   104: astore_3
    //   105: goto -> 113
    //   108: aload_3
    //   109: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   112: astore_3
    //   113: aload #5
    //   115: ldc_w '%s,%s,%s,%s'
    //   118: iconst_4
    //   119: anewarray java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: aload_1
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: aload_2
    //   129: aastore
    //   130: dup
    //   131: iconst_2
    //   132: aload_3
    //   133: aastore
    //   134: dup
    //   135: iconst_3
    //   136: invokestatic b : ()Ljava/lang/String;
    //   139: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   142: aastore
    //   143: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   146: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload #5
    //   152: invokevirtual toString : ()Ljava/lang/String;
    //   155: astore_1
    //   156: new java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial <init> : ()V
    //   163: astore_2
    //   164: aload_2
    //   165: aload_0
    //   166: getfield aA : Ljava/lang/String;
    //   169: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_2
    //   174: aload_1
    //   175: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_0
    //   180: aload_2
    //   181: invokevirtual toString : ()Ljava/lang/String;
    //   184: putfield aA : Ljava/lang/String;
    //   187: aload_0
    //   188: monitorexit
    //   189: return
    //   190: astore_1
    //   191: aload_0
    //   192: monitorexit
    //   193: aload_1
    //   194: athrow
    // Exception table:
    //   from	to	target	type
    //   2	30	190	finally
    //   34	77	190	finally
    //   77	101	190	finally
    //   108	113	190	finally
    //   113	187	190	finally
  }
  
  private static String d() {
    return String.format("%s,%s,-,-,-", new Object[] { b(b.a(b.a().b()).a()), b(b.a().e()) });
  }
  
  private static String d(String paramString) {
    String str1 = paramString;
    if (paramString == null)
      str1 = ""; 
    String[] arrayOfString = str1.split("&");
    str1 = null;
    if (arrayOfString != null) {
      int j = arrayOfString.length;
      String str = null;
      paramString = str;
      str1 = paramString;
      int i = 0;
      while (true) {
        JSONObject jSONObject;
        if (i < j) {
          JSONObject jSONObject1;
          String[] arrayOfString1 = arrayOfString[i].split("=");
          String str3 = str;
          String str4 = paramString;
          String str5 = str1;
          if (arrayOfString1 != null) {
            str3 = str;
            str4 = paramString;
            str5 = str1;
            if (arrayOfString1.length == 2)
              if (arrayOfString1[0].equalsIgnoreCase("partner")) {
                str3 = arrayOfString1[1].replace("\"", "");
                str4 = paramString;
                str5 = str1;
              } else if (arrayOfString1[0].equalsIgnoreCase("out_trade_no")) {
                str4 = arrayOfString1[1].replace("\"", "");
                str3 = str;
                str5 = str1;
              } else if (arrayOfString1[0].equalsIgnoreCase("trade_no")) {
                str5 = arrayOfString1[1].replace("\"", "");
                str3 = str;
                str4 = paramString;
              } else {
                JSONObject jSONObject2;
                if (arrayOfString1[0].equalsIgnoreCase("biz_content")) {
                  try {
                    jSONObject2 = new JSONObject(n.b(a.a(), arrayOfString1[1]));
                    str3 = str;
                  } finally {
                    str3 = null;
                    str3 = str;
                    str4 = paramString;
                  } 
                } else {
                  str3 = str;
                  str4 = paramString;
                  str5 = str1;
                  if (jSONObject2[0].equalsIgnoreCase("app_id")) {
                    str3 = str;
                    str4 = paramString;
                    str5 = str1;
                    if (TextUtils.isEmpty(str)) {
                      jSONObject1 = jSONObject2[1];
                      str5 = str1;
                      str4 = paramString;
                    } 
                  } 
                } 
              }  
          } 
          i++;
          jSONObject = jSONObject1;
          paramString = str4;
          str1 = str5;
          continue;
        } 
        return String.format("%s,%s,-,%s,-,-,-", new Object[] { b(str1), b(paramString), b((String)jSONObject) });
      } 
    } 
    String str2 = null;
    paramString = str2;
    return String.format("%s,%s,-,%s,-,-,-", new Object[] { b(str1), b(paramString), b(str2) });
  }
  
  private void d(String paramString1, String paramString2, String paramString3) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 'mspl'
    //   5: ldc_w 'event %s %s %s'
    //   8: iconst_3
    //   9: anewarray java/lang/Object
    //   12: dup
    //   13: iconst_0
    //   14: aload_1
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: aload_2
    //   19: aastore
    //   20: dup
    //   21: iconst_2
    //   22: aload_3
    //   23: aastore
    //   24: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   27: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   30: ldc ''
    //   32: astore #4
    //   34: aload_0
    //   35: getfield az : Ljava/lang/String;
    //   38: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   41: ifne -> 77
    //   44: new java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial <init> : ()V
    //   51: astore #4
    //   53: aload #4
    //   55: ldc ''
    //   57: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload #4
    //   63: ldc_w '^'
    //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload #4
    //   72: invokevirtual toString : ()Ljava/lang/String;
    //   75: astore #4
    //   77: new java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial <init> : ()V
    //   84: astore #5
    //   86: aload #5
    //   88: aload #4
    //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_1
    //   95: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   98: ifeq -> 108
    //   101: ldc_w '-'
    //   104: astore_1
    //   105: goto -> 113
    //   108: aload_1
    //   109: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   112: astore_1
    //   113: aload #5
    //   115: ldc_w '%s,%s,%s,-,-,-,-,-,-,-,-,-,-,%s'
    //   118: iconst_4
    //   119: anewarray java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: aload_1
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: aload_2
    //   129: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   132: aastore
    //   133: dup
    //   134: iconst_2
    //   135: aload_3
    //   136: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   139: aastore
    //   140: dup
    //   141: iconst_3
    //   142: invokestatic b : ()Ljava/lang/String;
    //   145: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   148: aastore
    //   149: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload #5
    //   158: invokevirtual toString : ()Ljava/lang/String;
    //   161: astore_1
    //   162: new java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial <init> : ()V
    //   169: astore_2
    //   170: aload_2
    //   171: aload_0
    //   172: getfield az : Ljava/lang/String;
    //   175: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_2
    //   180: aload_1
    //   181: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_0
    //   186: aload_2
    //   187: invokevirtual toString : ()Ljava/lang/String;
    //   190: putfield az : Ljava/lang/String;
    //   193: aload_0
    //   194: monitorexit
    //   195: return
    //   196: astore_1
    //   197: aload_0
    //   198: monitorexit
    //   199: aload_1
    //   200: athrow
    // Exception table:
    //   from	to	target	type
    //   2	30	196	finally
    //   34	77	196	finally
    //   77	101	196	finally
    //   108	113	196	finally
    //   113	193	196	finally
  }
  
  public String a(String paramString) {
    this.at = d(paramString);
    return String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", new Object[] { this.as, this.at, this.au, this.av, this.aw, this.ax, this.ay, c(this.az), c(this.aA), this.aB });
  }
  
  void a(String paramString1, String paramString2) {
    d("", paramString1, paramString2);
  }
  
  void a(String paramString1, String paramString2, String paramString3) {
    c(paramString1, paramString2, paramString3);
  }
  
  void a(String paramString1, String paramString2, Throwable paramThrowable) {
    c(paramString1, paramString2, a(paramThrowable));
  }
  
  void a(String paramString1, String paramString2, Throwable paramThrowable, String paramString3) {
    String str = a(paramThrowable);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString3);
    stringBuilder.append(": ");
    stringBuilder.append(str);
    c(paramString1, paramString2, stringBuilder.toString());
  }
  
  void b(String paramString1, String paramString2, String paramString3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append("|");
    stringBuilder.append(paramString3);
    d("", paramString1, stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\app\statistic\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */