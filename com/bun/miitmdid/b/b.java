package com.bun.miitmdid.b;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class b {
  private static boolean h;
  
  private String a = null;
  
  private b b = null;
  
  private Object c = null;
  
  private Map<String, String> d = new HashMap<String, String>();
  
  private Map<String, String> e = new HashMap<String, String>();
  
  private Map<String, String> f = new HashMap<String, String>();
  
  private String g = "GET";
  
  private b(Context paramContext) {}
  
  public static b a(@NonNull Context paramContext) {
    return new b(paramContext);
  }
  
  private void a(HttpURLConnection paramHttpURLConnection) {
    if (paramHttpURLConnection == null)
      return; 
    paramHttpURLConnection.setConnectTimeout(20000);
    paramHttpURLConnection.setReadTimeout(10000);
  }
  
  private c b() {
    try {
      String str = d();
      if (h)
        b("Making Get url call to " + str); 
      HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(str)).openConnection();
      a(httpURLConnection);
      httpURLConnection.setRequestMethod("GET");
      httpURLConnection.setRequestProperty("User-Agent", a.a());
      for (String str1 : this.d.keySet()) {
        if (!str1.isEmpty())
          httpURLConnection.setRequestProperty(str1, this.d.get(str1)); 
      } 
    } catch (Exception exception) {
      if (h)
        exception.printStackTrace(); 
      return new c(this, null, exception, -1);
    } 
    int i = exception.getResponseCode();
    System.out.println("\nSending 'GET' request to URL : " + this.a);
    System.out.println("Response Code : " + i);
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exception.getInputStream()));
    StringBuilder stringBuilder = new StringBuilder();
    while (true) {
      String str = bufferedReader.readLine();
      if (str != null) {
        stringBuilder.append(str);
        continue;
      } 
      bufferedReader.close();
      return new c(this, stringBuilder.toString(), null, i);
    } 
  }
  
  private static void b(@NonNull String paramString) {
    com.bun.lib.a.b(b.class.getSimpleName(), paramString);
  }
  
  private c c() {
    // Byte code:
    //   0: new java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial d : ()Ljava/lang/String;
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   14: checkcast java/net/HttpURLConnection
    //   17: astore_3
    //   18: aload_0
    //   19: aload_3
    //   20: invokespecial a : (Ljava/net/HttpURLConnection;)V
    //   23: aload_3
    //   24: ldc 'POST'
    //   26: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   29: aload_3
    //   30: ldc 'User-Agent'
    //   32: invokestatic a : ()Ljava/lang/String;
    //   35: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_3
    //   39: ldc 'Accept-Language'
    //   41: ldc 'en-US,en;q=0.5'
    //   43: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   46: new java/lang/StringBuilder
    //   49: dup
    //   50: ldc ''
    //   52: invokespecial <init> : (Ljava/lang/String;)V
    //   55: astore #4
    //   57: aload_0
    //   58: getfield e : Ljava/util/Map;
    //   61: invokeinterface isEmpty : ()Z
    //   66: ifne -> 179
    //   69: aload_0
    //   70: getfield e : Ljava/util/Map;
    //   73: invokeinterface keySet : ()Ljava/util/Set;
    //   78: invokeinterface iterator : ()Ljava/util/Iterator;
    //   83: astore_2
    //   84: aload_2
    //   85: invokeinterface hasNext : ()Z
    //   90: ifeq -> 221
    //   93: aload_2
    //   94: invokeinterface next : ()Ljava/lang/Object;
    //   99: checkcast java/lang/String
    //   102: astore #5
    //   104: aload #4
    //   106: aload #5
    //   108: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload #4
    //   114: ldc '='
    //   116: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload #4
    //   122: aload_0
    //   123: getfield e : Ljava/util/Map;
    //   126: aload #5
    //   128: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   133: checkcast java/lang/String
    //   136: ldc 'UTF-8'
    //   138: invokestatic encode : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   141: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload #4
    //   147: ldc '&'
    //   149: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: goto -> 84
    //   156: astore_2
    //   157: getstatic com/bun/miitmdid/b/b.h : Z
    //   160: ifeq -> 167
    //   163: aload_2
    //   164: invokevirtual printStackTrace : ()V
    //   167: new com/bun/miitmdid/b/b$c
    //   170: dup
    //   171: aload_0
    //   172: aconst_null
    //   173: aload_2
    //   174: iconst_m1
    //   175: invokespecial <init> : (Lcom/bun/miitmdid/b/b;Ljava/lang/String;Ljava/lang/Exception;I)V
    //   178: areturn
    //   179: aload_0
    //   180: getfield c : Ljava/lang/Object;
    //   183: ifnull -> 221
    //   186: aload_0
    //   187: getfield c : Ljava/lang/Object;
    //   190: instanceof org/json/JSONObject
    //   193: ifne -> 206
    //   196: aload_0
    //   197: getfield c : Ljava/lang/Object;
    //   200: instanceof org/json/JSONArray
    //   203: ifeq -> 287
    //   206: aload_0
    //   207: getfield c : Ljava/lang/Object;
    //   210: invokevirtual toString : ()Ljava/lang/String;
    //   213: astore_2
    //   214: aload #4
    //   216: aload_2
    //   217: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload_0
    //   222: getfield d : Ljava/util/Map;
    //   225: invokeinterface keySet : ()Ljava/util/Set;
    //   230: invokeinterface iterator : ()Ljava/util/Iterator;
    //   235: astore_2
    //   236: aload_2
    //   237: invokeinterface hasNext : ()Z
    //   242: ifeq -> 308
    //   245: aload_2
    //   246: invokeinterface next : ()Ljava/lang/Object;
    //   251: checkcast java/lang/String
    //   254: astore #5
    //   256: aload #5
    //   258: invokevirtual isEmpty : ()Z
    //   261: ifne -> 236
    //   264: aload_3
    //   265: aload #5
    //   267: aload_0
    //   268: getfield d : Ljava/util/Map;
    //   271: aload #5
    //   273: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   278: checkcast java/lang/String
    //   281: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   284: goto -> 236
    //   287: aload_0
    //   288: getfield c : Ljava/lang/Object;
    //   291: instanceof java/lang/String
    //   294: ifeq -> 221
    //   297: aload_0
    //   298: getfield c : Ljava/lang/Object;
    //   301: checkcast java/lang/String
    //   304: astore_2
    //   305: goto -> 214
    //   308: aload #4
    //   310: invokevirtual toString : ()Ljava/lang/String;
    //   313: astore_2
    //   314: aload_3
    //   315: iconst_1
    //   316: invokevirtual setDoOutput : (Z)V
    //   319: new java/io/DataOutputStream
    //   322: dup
    //   323: aload_3
    //   324: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   327: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   330: astore #4
    //   332: aload #4
    //   334: aload_2
    //   335: invokevirtual writeBytes : (Ljava/lang/String;)V
    //   338: aload #4
    //   340: invokevirtual flush : ()V
    //   343: aload #4
    //   345: invokevirtual close : ()V
    //   348: aload_3
    //   349: invokevirtual getResponseCode : ()I
    //   352: istore_1
    //   353: getstatic com/bun/miitmdid/b/b.h : Z
    //   356: ifeq -> 428
    //   359: new java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial <init> : ()V
    //   366: ldc '\\nSending 'POST' request to URL : '
    //   368: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload_0
    //   372: getfield a : Ljava/lang/String;
    //   375: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual toString : ()Ljava/lang/String;
    //   381: invokestatic b : (Ljava/lang/String;)V
    //   384: new java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial <init> : ()V
    //   391: ldc 'Post parameters : '
    //   393: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_2
    //   397: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual toString : ()Ljava/lang/String;
    //   403: invokestatic b : (Ljava/lang/String;)V
    //   406: new java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial <init> : ()V
    //   413: ldc 'Response Code : '
    //   415: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: iload_1
    //   419: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   422: invokevirtual toString : ()Ljava/lang/String;
    //   425: invokestatic b : (Ljava/lang/String;)V
    //   428: new java/io/BufferedReader
    //   431: dup
    //   432: new java/io/InputStreamReader
    //   435: dup
    //   436: aload_3
    //   437: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   440: invokespecial <init> : (Ljava/io/InputStream;)V
    //   443: invokespecial <init> : (Ljava/io/Reader;)V
    //   446: astore_2
    //   447: new java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial <init> : ()V
    //   454: astore_3
    //   455: aload_2
    //   456: invokevirtual readLine : ()Ljava/lang/String;
    //   459: astore #4
    //   461: aload #4
    //   463: ifnull -> 476
    //   466: aload_3
    //   467: aload #4
    //   469: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: goto -> 455
    //   476: aload_2
    //   477: invokevirtual close : ()V
    //   480: aload_3
    //   481: invokevirtual toString : ()Ljava/lang/String;
    //   484: astore_2
    //   485: new java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial <init> : ()V
    //   492: ldc '\\nPOST RESPONSE : '
    //   494: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload_2
    //   498: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual toString : ()Ljava/lang/String;
    //   504: invokestatic b : (Ljava/lang/String;)V
    //   507: new com/bun/miitmdid/b/b$c
    //   510: dup
    //   511: aload_0
    //   512: aload_2
    //   513: aconst_null
    //   514: iload_1
    //   515: invokespecial <init> : (Lcom/bun/miitmdid/b/b;Ljava/lang/String;Ljava/lang/Exception;I)V
    //   518: astore_2
    //   519: aload_2
    //   520: areturn
    // Exception table:
    //   from	to	target	type
    //   0	29	156	java/lang/Exception
    //   29	84	156	java/lang/Exception
    //   84	153	156	java/lang/Exception
    //   179	206	156	java/lang/Exception
    //   206	214	156	java/lang/Exception
    //   214	221	156	java/lang/Exception
    //   221	236	156	java/lang/Exception
    //   236	284	156	java/lang/Exception
    //   287	305	156	java/lang/Exception
    //   308	428	156	java/lang/Exception
    //   428	455	156	java/lang/Exception
    //   455	461	156	java/lang/Exception
    //   466	473	156	java/lang/Exception
    //   476	519	156	java/lang/Exception
  }
  
  private String d() {
    if (this.a != null) {
      StringBuilder stringBuilder = new StringBuilder("");
      try {
        if (!this.a.trim().endsWith("?")) {
          stringBuilder.append("?");
        } else {
          stringBuilder.append("&");
        } 
        for (String str1 : this.f.keySet()) {
          if (!str1.isEmpty()) {
            stringBuilder.append(str1.trim());
            stringBuilder.append("=");
            stringBuilder.append(URLEncoder.encode(this.f.get(str1), "UTF-8"));
            stringBuilder.append("&");
          } 
        } 
      } catch (Exception exception) {}
      if (stringBuilder.toString().contains("&")) {
        str = stringBuilder.substring(0, stringBuilder.lastIndexOf("&"));
        return this.a + str;
      } 
      String str = str.toString();
      return this.a + str;
    } 
    throw new NullPointerException("URL IS NULL");
  }
  
  public b a() {
    (new a(this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
    return this;
  }
  
  public b a(b paramb) {
    this.b = paramb;
    return this;
  }
  
  public b a(Object paramObject) {
    this.c = paramObject;
    return this;
  }
  
  public b a(@NonNull String paramString) {
    this.a = paramString;
    this.g = "POST";
    return this;
  }
  
  public b a(@NonNull String paramString1, @NonNull String paramString2) {
    this.f.put(paramString1, paramString2);
    return this;
  }
  
  public b a(Map<String, String> paramMap) {
    if (paramMap != null && !paramMap.isEmpty())
      this.f.putAll(paramMap); 
    return this;
  }
  
  class a extends AsyncTask<Void, Void, c> {
    b a = this.b;
    
    a(b this$0) {}
    
    protected b.c a(Void... param1VarArgs) {
      return b.a(this.a).equalsIgnoreCase("GET") ? b.b(this.b) : b.c(this.b);
    }
    
    protected void a(b.c param1c) {
      super.onPostExecute(param1c);
      if (b.d(this.b) != null) {
        if (param1c == null) {
          b.d(this.b).a(new Exception("Unknown Error"), -1, null);
          return;
        } 
      } else {
        return;
      } 
      if (b.c.a(param1c) != null) {
        b.d(this.b).a(b.c.a(param1c), -1, null);
        return;
      } 
      try {
        b.d(this.b).a(null, b.c.b(param1c), b.c.c(param1c));
        return;
      } catch (Exception exception) {
        b.d(this.b).a(exception, -1, null);
        return;
      } 
    }
  }
  
  public static interface b {
    void a(Exception param1Exception, int param1Int, String param1String);
  }
  
  private class c {
    private String a;
    
    private int b;
    
    private Exception c;
    
    public c(b this$0, String param1String, Exception param1Exception, int param1Int) {
      this.a = param1String;
      this.c = param1Exception;
      this.b = param1Int;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */