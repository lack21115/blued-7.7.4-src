package com.bytedance.sdk.openadsdk.utils;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.i.b;
import com.bytedance.sdk.openadsdk.i.c;
import com.bytedance.sdk.openadsdk.multipro.b;
import java.util.concurrent.Callable;

public class ac {
  public static boolean a = false;
  
  public static boolean b = false;
  
  private static final CharSequence c = "sony";
  
  private static final CharSequence d = "amigo";
  
  private static final CharSequence e = "funtouch";
  
  public static String a() {
    if (o())
      return p(); 
    if (e())
      return l(); 
    if (b())
      return q(); 
    if (r())
      return s(); 
    String str = m();
    if (!TextUtils.isEmpty(str))
      return str; 
    if (g())
      return f(); 
    if (h())
      return i(); 
    if (d())
      return c(); 
    str = j();
    return !TextUtils.isEmpty(str) ? str : Build.DISPLAY;
  }
  
  public static boolean a(String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = n(); 
    return ((!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || t());
  }
  
  public static boolean b() {
    return (Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme"));
  }
  
  public static String c() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(d("ro.build.uiversion"));
    stringBuilder.append("_");
    stringBuilder.append(Build.DISPLAY);
    return stringBuilder.toString();
  }
  
  private static String c(String paramString) {
    // Byte code:
    //   0: ldc ''
    //   2: astore_1
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore_2
    //   7: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   10: astore #4
    //   12: new java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial <init> : ()V
    //   19: astore #5
    //   21: aload #5
    //   23: ldc 'getprop '
    //   25: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload #5
    //   31: aload_0
    //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload #4
    //   38: aload #5
    //   40: invokevirtual toString : ()Ljava/lang/String;
    //   43: invokevirtual exec : (Ljava/lang/String;)Ljava/lang/Process;
    //   46: astore #5
    //   48: new java/io/BufferedReader
    //   51: dup
    //   52: new java/io/InputStreamReader
    //   55: dup
    //   56: aload #5
    //   58: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   61: invokespecial <init> : (Ljava/io/InputStream;)V
    //   64: sipush #1024
    //   67: invokespecial <init> : (Ljava/io/Reader;I)V
    //   70: astore #4
    //   72: aload_1
    //   73: astore_2
    //   74: aload_1
    //   75: astore_3
    //   76: aload #4
    //   78: invokevirtual readLine : ()Ljava/lang/String;
    //   81: astore_1
    //   82: aload_1
    //   83: astore_2
    //   84: aload_1
    //   85: astore_3
    //   86: aload #5
    //   88: invokevirtual exitValue : ()I
    //   91: pop
    //   92: aload_1
    //   93: astore_2
    //   94: aload #4
    //   96: invokevirtual close : ()V
    //   99: aload_1
    //   100: areturn
    //   101: astore_0
    //   102: ldc 'ToolUtils'
    //   104: ldc 'Exception while closing InputStream'
    //   106: aload_0
    //   107: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   110: aload_2
    //   111: areturn
    //   112: astore_3
    //   113: aload_2
    //   114: astore_1
    //   115: aload #4
    //   117: astore_2
    //   118: goto -> 130
    //   121: aconst_null
    //   122: astore_0
    //   123: aload #5
    //   125: astore_2
    //   126: goto -> 196
    //   129: astore_3
    //   130: new java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial <init> : ()V
    //   137: astore #4
    //   139: aload #4
    //   141: ldc 'Unable to read sysprop '
    //   143: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload #4
    //   149: aload_0
    //   150: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: ldc 'ToolUtils'
    //   156: aload #4
    //   158: invokevirtual toString : ()Ljava/lang/String;
    //   161: aload_3
    //   162: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   165: aload_2
    //   166: ifnull -> 184
    //   169: aload_2
    //   170: invokevirtual close : ()V
    //   173: aload_1
    //   174: areturn
    //   175: astore_0
    //   176: ldc 'ToolUtils'
    //   178: ldc 'Exception while closing InputStream'
    //   180: aload_0
    //   181: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: aload_1
    //   185: areturn
    //   186: astore_0
    //   187: aload_2
    //   188: astore_1
    //   189: goto -> 208
    //   192: aconst_null
    //   193: astore_0
    //   194: aload_3
    //   195: astore_2
    //   196: aload_2
    //   197: invokevirtual destroy : ()V
    //   200: goto -> 230
    //   203: astore_2
    //   204: aload_0
    //   205: astore_1
    //   206: aload_2
    //   207: astore_0
    //   208: aload_1
    //   209: ifnull -> 228
    //   212: aload_1
    //   213: invokevirtual close : ()V
    //   216: goto -> 228
    //   219: astore_1
    //   220: ldc 'ToolUtils'
    //   222: ldc 'Exception while closing InputStream'
    //   224: aload_1
    //   225: invokestatic c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   228: aload_0
    //   229: athrow
    //   230: aload_0
    //   231: ifnull -> 240
    //   234: aload_1
    //   235: astore_2
    //   236: aload_0
    //   237: invokevirtual close : ()V
    //   240: aload_1
    //   241: areturn
    //   242: astore_0
    //   243: goto -> 192
    //   246: astore_0
    //   247: goto -> 121
    //   250: astore_0
    //   251: aload_3
    //   252: astore_1
    //   253: aload #4
    //   255: astore_0
    //   256: goto -> 123
    //   259: astore_2
    //   260: goto -> 230
    // Exception table:
    //   from	to	target	type
    //   7	48	242	java/lang/IllegalThreadStateException
    //   7	48	129	finally
    //   48	72	246	java/lang/IllegalThreadStateException
    //   48	72	129	finally
    //   76	82	250	java/lang/IllegalThreadStateException
    //   76	82	112	finally
    //   86	92	250	java/lang/IllegalThreadStateException
    //   86	92	112	finally
    //   94	99	101	java/io/IOException
    //   130	165	186	finally
    //   169	173	175	java/io/IOException
    //   196	200	259	java/lang/Exception
    //   196	200	203	finally
    //   212	216	219	java/io/IOException
    //   236	240	101	java/io/IOException
  }
  
  private static String d(String paramString) {
    // Byte code:
    //   0: invokestatic u : ()Ljava/lang/String;
    //   3: astore_1
    //   4: aload_1
    //   5: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   8: ifeq -> 58
    //   11: new com/bytedance/sdk/openadsdk/i/b
    //   14: dup
    //   15: new com/bytedance/sdk/openadsdk/utils/ac$a
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Ljava/lang/String;)V
    //   23: iconst_5
    //   24: iconst_2
    //   25: invokespecial <init> : (Ljava/util/concurrent/Callable;II)V
    //   28: astore_0
    //   29: invokestatic a : ()Lcom/bytedance/sdk/openadsdk/i/a;
    //   32: new com/bytedance/sdk/openadsdk/utils/ac$1
    //   35: dup
    //   36: aload_0
    //   37: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/i/b;)V
    //   40: invokevirtual b : (Lcom/bytedance/sdk/openadsdk/i/c;)V
    //   43: aload_0
    //   44: lconst_1
    //   45: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   48: invokevirtual get : (JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   51: checkcast java/lang/String
    //   54: astore_0
    //   55: goto -> 66
    //   58: aload_1
    //   59: astore_0
    //   60: goto -> 66
    //   63: ldc ''
    //   65: astore_0
    //   66: aload_0
    //   67: ifnonnull -> 73
    //   70: ldc ''
    //   72: areturn
    //   73: aload_0
    //   74: areturn
    //   75: astore_0
    //   76: goto -> 63
    //   79: astore_0
    //   80: goto -> 58
    // Exception table:
    //   from	to	target	type
    //   0	4	75	finally
    //   4	55	79	finally
  }
  
  public static boolean d() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Build.MANUFACTURER);
    stringBuilder.append(Build.BRAND);
    String str = stringBuilder.toString();
    boolean bool1 = TextUtils.isEmpty(str);
    boolean bool = false;
    if (bool1)
      return false; 
    str = str.toLowerCase();
    if (str.contains("360") || str.contains("qiku"))
      bool = true; 
    return bool;
  }
  
  public static boolean e() {
    if (!b) {
      try {
        if (Class.forName("miui.os.Build") != null) {
          a = true;
          b = true;
          return a;
        } 
      } catch (Exception exception) {}
      b = true;
    } 
    return a;
  }
  
  public static String f() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(d("ro.vivo.os.build.display.id"));
    stringBuilder.append("_");
    stringBuilder.append(d("ro.vivo.product.version"));
    return stringBuilder.toString();
  }
  
  public static boolean g() {
    String str = d("ro.vivo.os.build.display.id");
    return (!TextUtils.isEmpty(str) && str.toLowerCase().contains(e));
  }
  
  public static boolean h() {
    return (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(d));
  }
  
  public static String i() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Build.DISPLAY);
    stringBuilder.append("_");
    stringBuilder.append(d("ro.gn.sv.version"));
    return stringBuilder.toString();
  }
  
  public static String j() {
    if (k()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("eui_");
      stringBuilder.append(d("ro.letv.release.version"));
      stringBuilder.append("_");
      stringBuilder.append(Build.DISPLAY);
      return stringBuilder.toString();
    } 
    return "";
  }
  
  public static boolean k() {
    return TextUtils.isEmpty(d("ro.letv.release.version")) ^ true;
  }
  
  public static String l() {
    if (e()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("miui_");
      stringBuilder.append(d("ro.miui.ui.version.name"));
      stringBuilder.append("_");
      stringBuilder.append(Build.VERSION.INCREMENTAL);
      return stringBuilder.toString();
    } 
    return "";
  }
  
  public static String m() {
    String str = n();
    if (str != null && str.toLowerCase().contains("emotionui")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append("_");
      stringBuilder.append(Build.DISPLAY);
      return stringBuilder.toString();
    } 
    return "";
  }
  
  public static String n() {
    return d("ro.build.version.emui");
  }
  
  public static boolean o() {
    return ("smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND));
  }
  
  public static String p() {
    if (o())
      try {
        null = d("ro.smartisan.version");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("smartisan_");
        stringBuilder.append(null);
        return stringBuilder.toString();
      } finally {
        Exception exception;
      }  
    return Build.DISPLAY;
  }
  
  public static String q() {
    String str = Build.DISPLAY;
    return (str != null && str.toLowerCase().contains("flyme")) ? str : "";
  }
  
  public static boolean r() {
    String str = Build.MANUFACTURER;
    return (!TextUtils.isEmpty(str) && str.toLowerCase().contains("oppo"));
  }
  
  public static String s() {
    if (r()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("coloros_");
      stringBuilder.append(d("ro.build.version.opporom"));
      stringBuilder.append("_");
      stringBuilder.append(Build.DISPLAY);
      return stringBuilder.toString();
    } 
    return "";
  }
  
  public static boolean t() {
    boolean bool = false;
    try {
      null = TextUtils.isEmpty(Build.BRAND);
      return true;
    } finally {
      Exception exception = null;
    } 
  }
  
  private static String u() {
    try {
      boolean bool = b.b();
      if (bool) {
        String str1 = com.bytedance.sdk.openadsdk.multipro.d.a.b("rom_info", "rom_property_info", "");
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("get Property From SPMultiHelper...");
        stringBuilder1.append(str1);
        return str1;
      } 
      String str = ad.a("rom_info", o.a()).b("rom_property_info", "");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get Property From SP...=");
      stringBuilder.append(str);
      return str;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static class a implements Callable<String> {
    private String a;
    
    public a(String param1String) {
      this.a = param1String;
    }
    
    public String a() throws Exception {
      long l1 = System.currentTimeMillis();
      String str = ac.b(this.a);
      long l2 = System.currentTimeMillis();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("property:");
      stringBuilder.append(str);
      stringBuilder.append(",getSystemProperty use time :");
      stringBuilder.append(l2 - l1);
      t.b("RomUtils", stringBuilder.toString());
      if (!TextUtils.isEmpty(str))
        try {
          boolean bool = b.b();
          if (bool) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("SPMultiHelper-getPropertyFromSPMultiHelper:");
            stringBuilder.append(str);
            t.d("RomUtils", stringBuilder.toString());
            return str;
          } 
          stringBuilder = new StringBuilder();
          stringBuilder.append("SP-getPropertyFromSP:");
          stringBuilder.append(str);
          t.d("RomUtils", stringBuilder.toString());
          return str;
        } finally {
          stringBuilder = null;
        }  
      return str;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsd\\utils\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */