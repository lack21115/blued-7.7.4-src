package com.bytedance.sdk.openadsdk.h.g;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.h.b.a;
import com.bytedance.sdk.openadsdk.h.b.c;
import com.bytedance.sdk.openadsdk.h.e;
import com.bytedance.sdk.openadsdk.h.e.a;
import com.bytedance.sdk.openadsdk.h.e.f;
import com.bytedance.sdk.openadsdk.h.i;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class d {
  public static final Charset a;
  
  private static final Handler b = new Handler(Looper.getMainLooper());
  
  private static final ExecutorService c;
  
  static {
    a = Charset.forName("UTF-8");
    c = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
  }
  
  public static int a() {
    int i = Build.VERSION.SDK_INT;
    boolean bool = true;
    if (i >= 17)
      return Math.max(Runtime.getRuntime().availableProcessors(), 1); 
    try {
      File file = new File("/sys/devices/system/cpu/");
      i = bool;
      return i;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static int a(a parama) {
    if (parama == null)
      return -1; 
    if (parama.a() == 200)
      return a(parama.a("Content-Length", null), -1); 
    if (parama.a() == 206) {
      String str = parama.a("Content-Range", null);
      if (!TextUtils.isEmpty(str)) {
        int i = str.lastIndexOf("/");
        if (i >= 0 && i < str.length() - 1)
          return a(str.substring(i + 1), -1); 
      } 
    } 
    return -1;
  }
  
  public static int a(String paramString, int paramInt) {
    if (TextUtils.isEmpty(paramString))
      return paramInt; 
    try {
      return Integer.parseInt(paramString);
    } catch (NumberFormatException numberFormatException) {
      return paramInt;
    } 
  }
  
  public static a a(a parama, c paramc, String paramString, int paramInt) {
    String str;
    a a1 = paramc.a(paramString, paramInt);
    if (a1 == null) {
      int i = a(parama);
      String str1 = parama.a("Content-Type", null);
      if (i > 0 && !TextUtils.isEmpty(str1)) {
        a a2;
        String str3;
        f f = parama.g();
        if (f != null) {
          str3 = f.b;
          str = b(f.e);
        } else {
          str = "";
          str3 = str;
        } 
        String str2 = b(parama.c());
        try {
          JSONObject jSONObject = new JSONObject();
          jSONObject.put("requestUrl", str3);
          jSONObject.put("requestHeaders", str);
          jSONObject.put("responseHeaders", str2);
          str2 = jSONObject.toString();
        } finally {
          str2 = null;
        } 
        paramc.a(a2);
        return a2;
      } 
    } 
    return (a)str;
  }
  
  public static String a(int paramInt1, int paramInt2) {
    String str = b(paramInt1, paramInt2);
    if (str == null)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bytes=");
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
  
  public static String a(a parama, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    if (paramInt <= 0) {
      stringBuilder.append("HTTP/1.1 200 OK");
      stringBuilder.append("\r\n");
    } else {
      stringBuilder.append("HTTP/1.1 206 Partial Content");
      stringBuilder.append("\r\n");
    } 
    stringBuilder.append("Accept-Ranges: bytes");
    stringBuilder.append("\r\n");
    stringBuilder.append("Content-Type: ");
    stringBuilder.append(parama.b);
    stringBuilder.append("\r\n");
    if (paramInt <= 0) {
      stringBuilder.append("Content-Length: ");
      stringBuilder.append(parama.c);
      stringBuilder.append("\r\n");
    } else {
      stringBuilder.append("Content-Range: bytes ");
      stringBuilder.append(paramInt);
      stringBuilder.append("-");
      stringBuilder.append(parama.c - 1);
      stringBuilder.append("/");
      stringBuilder.append(parama.c);
      stringBuilder.append("\r\n");
      stringBuilder.append("Content-Length: ");
      stringBuilder.append(parama.c - paramInt);
      stringBuilder.append("\r\n");
    } 
    stringBuilder.append("Connection: close");
    stringBuilder.append("\r\n");
    stringBuilder.append("\r\n");
    String str = stringBuilder.toString();
    if (e.c)
      Log.i("TAG_PROXY_WRITE_TO_MP", str); 
    return str;
  }
  
  public static String a(a parama, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 435
    //   4: aload_0
    //   5: invokevirtual b : ()Z
    //   8: ifne -> 14
    //   11: goto -> 435
    //   14: new java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: astore #6
    //   23: aload #6
    //   25: aload_0
    //   26: invokevirtual e : ()Ljava/lang/String;
    //   29: invokevirtual toUpperCase : ()Ljava/lang/String;
    //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload #6
    //   38: bipush #32
    //   40: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload #6
    //   46: aload_0
    //   47: invokevirtual a : ()I
    //   50: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload #6
    //   56: bipush #32
    //   58: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload #6
    //   64: aload_0
    //   65: invokevirtual f : ()Ljava/lang/String;
    //   68: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload #6
    //   74: ldc '\\r\\n'
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   83: ifeq -> 158
    //   86: new java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial <init> : ()V
    //   93: astore #7
    //   95: aload #7
    //   97: aload_0
    //   98: invokevirtual e : ()Ljava/lang/String;
    //   101: invokevirtual toUpperCase : ()Ljava/lang/String;
    //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload #7
    //   110: ldc_w ' '
    //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload #7
    //   119: aload_0
    //   120: invokevirtual a : ()I
    //   123: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload #7
    //   129: ldc_w ' '
    //   132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload #7
    //   138: aload_0
    //   139: invokevirtual f : ()Ljava/lang/String;
    //   142: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: ldc_w 'TAG_PROXY_headers'
    //   149: aload #7
    //   151: invokevirtual toString : ()Ljava/lang/String;
    //   154: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   157: pop
    //   158: aload_0
    //   159: invokevirtual c : ()Ljava/util/List;
    //   162: invokestatic a : (Ljava/util/List;)Ljava/util/List;
    //   165: astore #7
    //   167: iconst_1
    //   168: istore_2
    //   169: aload #7
    //   171: ifnull -> 318
    //   174: aload #7
    //   176: invokeinterface size : ()I
    //   181: istore #5
    //   183: iconst_0
    //   184: istore_3
    //   185: iconst_1
    //   186: istore_2
    //   187: iload_3
    //   188: iload #5
    //   190: if_icmpge -> 318
    //   193: aload #7
    //   195: iload_3
    //   196: invokeinterface get : (I)Ljava/lang/Object;
    //   201: checkcast com/bytedance/sdk/openadsdk/h/i$b
    //   204: astore #9
    //   206: iload_2
    //   207: istore #4
    //   209: aload #9
    //   211: ifnull -> 308
    //   214: aload #9
    //   216: getfield a : Ljava/lang/String;
    //   219: astore #8
    //   221: aload #9
    //   223: getfield b : Ljava/lang/String;
    //   226: astore #9
    //   228: aload #6
    //   230: aload #8
    //   232: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload #6
    //   238: ldc_w ': '
    //   241: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload #6
    //   247: aload #9
    //   249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload #6
    //   255: ldc '\\r\\n'
    //   257: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: ldc 'Content-Range'
    //   263: aload #8
    //   265: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   268: ifeq -> 277
    //   271: iconst_0
    //   272: istore #4
    //   274: goto -> 308
    //   277: iload_2
    //   278: istore #4
    //   280: ldc_w 'Accept-Ranges'
    //   283: aload #8
    //   285: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   288: ifeq -> 308
    //   291: iload_2
    //   292: istore #4
    //   294: ldc_w 'bytes'
    //   297: aload #9
    //   299: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   302: ifeq -> 308
    //   305: goto -> 271
    //   308: iload_3
    //   309: iconst_1
    //   310: iadd
    //   311: istore_3
    //   312: iload #4
    //   314: istore_2
    //   315: goto -> 187
    //   318: iload_2
    //   319: ifeq -> 390
    //   322: aload_0
    //   323: invokestatic a : (Lcom/bytedance/sdk/openadsdk/h/e/a;)I
    //   326: istore_2
    //   327: iload_2
    //   328: ifle -> 390
    //   331: aload #6
    //   333: ldc 'Content-Range: bytes '
    //   335: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload #6
    //   341: iload_1
    //   342: iconst_0
    //   343: invokestatic max : (II)I
    //   346: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload #6
    //   352: ldc '-'
    //   354: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload #6
    //   360: iload_2
    //   361: iconst_1
    //   362: isub
    //   363: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload #6
    //   369: ldc '/'
    //   371: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload #6
    //   377: iload_2
    //   378: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload #6
    //   384: ldc '\\r\\n'
    //   386: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload #6
    //   392: ldc 'Connection: close'
    //   394: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload #6
    //   400: ldc '\\r\\n'
    //   402: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload #6
    //   408: ldc '\\r\\n'
    //   410: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload #6
    //   416: invokevirtual toString : ()Ljava/lang/String;
    //   419: astore_0
    //   420: getstatic com/bytedance/sdk/openadsdk/h/e.c : Z
    //   423: ifeq -> 433
    //   426: ldc 'TAG_PROXY_WRITE_TO_MP'
    //   428: aload_0
    //   429: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   432: pop
    //   433: aload_0
    //   434: areturn
    //   435: aconst_null
    //   436: areturn
  }
  
  public static String a(a parama, boolean paramBoolean1, boolean paramBoolean2) {
    StringBuilder stringBuilder;
    if (parama == null) {
      if (e.c)
        Log.e("TAG_PROXY_Response", "response null"); 
      return "response null";
    } 
    if (!parama.b()) {
      if (e.c) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("response code: ");
        stringBuilder2.append(parama.a());
        Log.e("TAG_PROXY_Response", stringBuilder2.toString());
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("response code: ");
      stringBuilder1.append(parama.a());
      return stringBuilder1.toString();
    } 
    String str = parama.a("Content-Type", null);
    if (!c(str)) {
      if (e.c) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Content-Type: ");
        stringBuilder1.append(str);
        Log.e("TAG_PROXY_Response", stringBuilder1.toString());
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("Content-Type: ");
      stringBuilder.append(str);
      return stringBuilder.toString();
    } 
    int i = a((a)stringBuilder);
    if (i <= 0) {
      if (e.c) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Content-Length: ");
        stringBuilder.append(i);
        Log.e("TAG_PROXY_Response", stringBuilder.toString());
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("Content-Length: ");
      stringBuilder.append(i);
      return stringBuilder.toString();
    } 
    if (paramBoolean1) {
      str = stringBuilder.a("Accept-Ranges", null);
      if (str == null || !str.contains("bytes")) {
        if (e.c) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Accept-Ranges: ");
          stringBuilder.append(str);
          Log.e("TAG_PROXY_Response", stringBuilder.toString());
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append("Accept-Ranges: ");
        stringBuilder.append(str);
        return stringBuilder.toString();
      } 
    } 
    if (paramBoolean2 && stringBuilder.d() == null) {
      if (e.c)
        Log.e("TAG_PROXY_Response", "response body null"); 
      return "response body null";
    } 
    return null;
  }
  
  public static List<i.b> a(List<i.b> paramList) {
    if (paramList == null || paramList.size() == 0)
      return null; 
    boolean bool = e.c;
    byte b = 0;
    if (bool) {
      int j = paramList.size();
      for (int i = 0; i < j; i++) {
        i.b b1 = paramList.get(i);
        if (b1 != null) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(b1.a);
          stringBuilder.append(": ");
          stringBuilder.append(b1.a);
          Log.i("TAG_PROXY_PRE_FILTER", stringBuilder.toString());
        } 
      } 
    } 
    ArrayList<i.b> arrayList = new ArrayList();
    for (i.b b1 : paramList) {
      if ("Host".equals(b1.a) || "Keep-Alive".equals(b1.a) || "Connection".equals(b1.a) || "Proxy-Connection".equals(b1.a))
        arrayList.add(b1); 
    } 
    paramList.removeAll(arrayList);
    if (e.c) {
      int j = paramList.size();
      for (int i = b; i < j; i++) {
        i.b b1 = paramList.get(i);
        if (b1 != null) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(b1.a);
          stringBuilder.append(": ");
          stringBuilder.append(b1.b);
          Log.i("TAG_PROXY_POST_FILTER", stringBuilder.toString());
        } 
      } 
    } 
    return paramList;
  }
  
  public static List<i.b> a(Map<String, String> paramMap) {
    if (paramMap != null) {
      if (paramMap.isEmpty())
        return null; 
      try {
        Set<Map.Entry<String, String>> set = paramMap.entrySet();
        ArrayList<i.b> arrayList = new ArrayList();
        return arrayList;
      } finally {
        paramMap = null;
      } 
    } 
    return null;
  }
  
  public static List<String> a(String... paramVarArgs) {
    ArrayList<String> arrayList = null;
    if (paramVarArgs != null) {
      if (paramVarArgs.length == 0)
        return null; 
      arrayList = new ArrayList(paramVarArgs.length);
      int j = paramVarArgs.length;
      for (int i = 0; i < j; i++) {
        String str = paramVarArgs[i];
        if (a(str))
          arrayList.add(str); 
      } 
      if (arrayList.isEmpty())
        return null; 
    } 
    return arrayList;
  }
  
  public static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        return;
      } finally {
        paramCloseable = null;
      }  
  }
  
  public static void a(RandomAccessFile paramRandomAccessFile) {
    if (paramRandomAccessFile != null)
      try {
        paramRandomAccessFile.getFD().sync();
        return;
      } finally {
        paramRandomAccessFile = null;
      }  
  }
  
  public static void a(Runnable paramRunnable) {
    if (paramRunnable != null)
      if (b()) {
        c.execute(paramRunnable);
        if (e.c) {
          Log.e("TAG_PROXY_UTIL", "invoke in pool thread");
          return;
        } 
      } else {
        paramRunnable.run();
        if (e.c)
          Log.e("TAG_PROXY_UTIL", "invoke calling thread"); 
      }  
  }
  
  public static void a(ServerSocket paramServerSocket) {
    if (paramServerSocket != null)
      try {
        return;
      } finally {
        paramServerSocket = null;
      }  
  }
  
  public static void a(Socket paramSocket) {
    if (paramSocket != null)
      try {
        return;
      } finally {
        paramSocket = null;
      }  
  }
  
  public static boolean a(String paramString) {
    return (paramString != null && (paramString.startsWith("http://") || paramString.startsWith("https://")));
  }
  
  public static int b(String paramString) {
    return a(paramString, 0);
  }
  
  public static String b(int paramInt1, int paramInt2) {
    if (paramInt1 >= 0 && paramInt2 > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt1);
      stringBuilder.append("-");
      stringBuilder.append(paramInt2);
      return stringBuilder.toString();
    } 
    if (paramInt1 > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt1);
      stringBuilder.append("-");
      return stringBuilder.toString();
    } 
    if (paramInt1 < 0 && paramInt2 > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("-");
      stringBuilder.append(paramInt2);
      return stringBuilder.toString();
    } 
    return null;
  }
  
  public static String b(List<i.b> paramList) {
    if (paramList == null || paramList.size() == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    int j = paramList.size();
    for (int i = 0; i < j; i++) {
      i.b b = paramList.get(0);
      if (b != null) {
        stringBuilder.append(b.a);
        stringBuilder.append(": ");
        stringBuilder.append(b.b);
        stringBuilder.append("\r\n");
      } 
    } 
    return stringBuilder.toString();
  }
  
  public static String b(Map<String, String> paramMap) {
    if (paramMap == null || paramMap.size() == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry<String, String> entry : paramMap.entrySet()) {
      stringBuilder.append(entry.getKey());
      stringBuilder.append(": ");
      stringBuilder.append(entry.getValue());
      stringBuilder.append("\r\n");
    } 
    return stringBuilder.toString();
  }
  
  public static void b(Runnable paramRunnable) {
    if (paramRunnable != null) {
      if (b()) {
        paramRunnable.run();
        return;
      } 
      b.post(paramRunnable);
    } 
  }
  
  public static boolean b() {
    return (Thread.currentThread() == Looper.getMainLooper().getThread());
  }
  
  public static boolean c(String paramString) {
    return (paramString != null && (paramString.startsWith("video/") || "application/octet-stream".equals(paramString) || "binary/octet-stream".equals(paramString)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */