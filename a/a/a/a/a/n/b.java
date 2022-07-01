package a.a.a.a.a.n;

import a.a.a.a.a.e.h;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import com.qiniu.android.dns.DnsManager;
import com.qiniu.pili.droid.streaming.PLAuthenticationResultCallback;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
  public static boolean a = true;
  
  public static boolean b = false;
  
  public static b c = new b("https://pili-zeus.qiniuapi.com");
  
  public final ArrayList<g> d;
  
  public String e;
  
  public c f = new c();
  
  public Context g = null;
  
  public e h = e.a;
  
  public long i = 0L;
  
  public CountDownLatch j;
  
  public b(String paramString) {
    this.e = paramString;
    this.d = new ArrayList<g>();
  }
  
  public static b a() {
    return c;
  }
  
  public static String a(Context paramContext, String paramString) throws Exception {
    FileInputStream fileInputStream = paramContext.openFileInput(paramString);
    try {
      int i = fileInputStream.available();
      if (i > 131072) {
        fileInputStream.close();
        return "";
      } 
      byte[] arrayOfByte = new byte[i];
      String str = new String(arrayOfByte, 0, fileInputStream.read(arrayOfByte));
      fileInputStream.close();
      return str;
    } catch (IOException iOException) {
      throw iOException;
    } finally {}
    fileInputStream.close();
    throw paramString;
  }
  
  public static String a(String paramString) throws URISyntaxException, a.a.a.a.a.f.d {
    URI uRI = new URI(paramString);
    paramString = uRI.getHost();
    if (DnsManager.validIP(paramString)) {
      Map map = h.a(uRI);
      if (map != null && !map.isEmpty()) {
        int j = c.a.length;
        for (int i = 0; i < j; i++) {
          String str = (String)map.get(c.a[i]);
          if (h.c(str))
            return str; 
        } 
      } 
    } 
    return paramString;
  }
  
  public static String a(String paramString, a parama) throws URISyntaxException {
    String str1;
    URI uRI = new URI(paramString);
    String str3 = uRI.getHost();
    a.a.a.a.a.k.e.c.a().a(str3, parama.a);
    a.a.a.a.a.k.e.c.e e2 = a.a.a.a.a.k.e.c.a().a(str3, 0);
    String str2 = "";
    if (e2 != null) {
      String str = e2.a;
      if (str != null && !str.equals("")) {
        a.a.a.a.a.e.e e3 = a.a.a.a.a.e.e.c;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("the fasetest server ");
        stringBuilder1.append(str3);
        stringBuilder1.append(" ");
        stringBuilder1.append(e2.a);
        stringBuilder1.append(" time ");
        stringBuilder1.append(e2.c);
        e3.b("SpeedMeasure", stringBuilder1.toString());
        str1 = str2;
        if (uRI.getPort() > 0) {
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(":");
          stringBuilder2.append(Integer.toString(uRI.getPort()));
          str1 = stringBuilder2.toString();
        } 
        return String.format("rtmp://%s%s%s?%s&domain=%s", new Object[] { e2.a, str1, uRI.getPath(), uRI.getQuery(), str3 });
      } 
    } 
    a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.c;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(e2);
    e1.b("SpeedMeasure failed", stringBuilder.toString());
    return str1;
  }
  
  public static String a(String paramString1, String paramString2, JSONObject paramJSONObject) {
    // Byte code:
    //   0: new java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial <init> : (Ljava/lang/String;)V
    //   8: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   11: checkcast java/net/HttpURLConnection
    //   14: astore_0
    //   15: goto -> 52
    //   18: astore_0
    //   19: aload_0
    //   20: invokevirtual printStackTrace : ()V
    //   23: aload_1
    //   24: ifnull -> 50
    //   27: new java/net/URL
    //   30: dup
    //   31: aload_1
    //   32: invokespecial <init> : (Ljava/lang/String;)V
    //   35: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   38: checkcast java/net/HttpURLConnection
    //   41: astore_0
    //   42: goto -> 52
    //   45: astore_0
    //   46: aload_0
    //   47: invokevirtual printStackTrace : ()V
    //   50: aconst_null
    //   51: astore_0
    //   52: aload_0
    //   53: ifnonnull -> 59
    //   56: ldc ''
    //   58: areturn
    //   59: aload_0
    //   60: sipush #3000
    //   63: invokevirtual setConnectTimeout : (I)V
    //   66: aload_0
    //   67: sipush #10000
    //   70: invokevirtual setReadTimeout : (I)V
    //   73: aload_0
    //   74: ldc 'POST'
    //   76: invokevirtual setRequestMethod : (Ljava/lang/String;)V
    //   79: goto -> 87
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual printStackTrace : ()V
    //   87: aload_0
    //   88: ldc_w 'Content-Type'
    //   91: ldc_w 'application/json'
    //   94: invokevirtual setRequestProperty : (Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_0
    //   98: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   101: astore_1
    //   102: aload_1
    //   103: aload_2
    //   104: invokevirtual toString : ()Ljava/lang/String;
    //   107: invokevirtual getBytes : ()[B
    //   110: invokevirtual write : ([B)V
    //   113: aload_1
    //   114: invokevirtual flush : ()V
    //   117: aload_0
    //   118: invokevirtual getResponseCode : ()I
    //   121: istore_3
    //   122: goto -> 132
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual printStackTrace : ()V
    //   130: iconst_0
    //   131: istore_3
    //   132: iload_3
    //   133: sipush #200
    //   136: if_icmpeq -> 142
    //   139: ldc ''
    //   141: areturn
    //   142: aload_0
    //   143: invokevirtual getContentLength : ()I
    //   146: istore #4
    //   148: iload #4
    //   150: ifne -> 156
    //   153: ldc ''
    //   155: areturn
    //   156: iload #4
    //   158: istore_3
    //   159: iload #4
    //   161: ifge -> 168
    //   164: sipush #16384
    //   167: istore_3
    //   168: aload_0
    //   169: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   172: astore_0
    //   173: iload_3
    //   174: newarray byte
    //   176: astore_1
    //   177: aload_0
    //   178: aload_1
    //   179: invokevirtual read : ([B)I
    //   182: istore_3
    //   183: aload_0
    //   184: invokevirtual close : ()V
    //   187: goto -> 195
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual printStackTrace : ()V
    //   195: iload_3
    //   196: ifgt -> 202
    //   199: ldc ''
    //   201: areturn
    //   202: new java/lang/String
    //   205: dup
    //   206: aload_1
    //   207: iconst_0
    //   208: iload_3
    //   209: invokespecial <init> : ([BII)V
    //   212: areturn
    //   213: astore_1
    //   214: goto -> 237
    //   217: astore_1
    //   218: aload_1
    //   219: invokevirtual printStackTrace : ()V
    //   222: aload_0
    //   223: invokevirtual close : ()V
    //   226: ldc ''
    //   228: areturn
    //   229: astore_0
    //   230: aload_0
    //   231: invokevirtual printStackTrace : ()V
    //   234: ldc ''
    //   236: areturn
    //   237: aload_0
    //   238: invokevirtual close : ()V
    //   241: goto -> 249
    //   244: astore_0
    //   245: aload_0
    //   246: invokevirtual printStackTrace : ()V
    //   249: aload_1
    //   250: athrow
    //   251: astore_0
    //   252: aload_0
    //   253: invokevirtual printStackTrace : ()V
    //   256: ldc ''
    //   258: areturn
    //   259: astore_0
    //   260: aload_0
    //   261: invokevirtual printStackTrace : ()V
    //   264: ldc ''
    //   266: areturn
    //   267: astore_0
    //   268: aload_0
    //   269: invokevirtual printStackTrace : ()V
    //   272: ldc ''
    //   274: areturn
    // Exception table:
    //   from	to	target	type
    //   0	15	18	java/io/IOException
    //   27	42	45	java/io/IOException
    //   73	79	82	java/net/ProtocolException
    //   97	117	267	java/io/IOException
    //   97	117	259	java/lang/Exception
    //   117	122	125	java/io/IOException
    //   168	173	251	java/io/IOException
    //   177	183	217	java/io/IOException
    //   177	183	213	finally
    //   183	187	190	java/io/IOException
    //   218	222	213	finally
    //   222	226	229	java/io/IOException
    //   237	241	244	java/io/IOException
  }
  
  public static void a(Context paramContext) {
    if (b)
      return; 
    b = true;
    a().b(paramContext);
    a().e();
    for (String str : a.a.a.a.a.e.d.a) {
      if (h.h(paramContext).contains(str)) {
        a().a(false);
        break;
      } 
    } 
    a().f();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) throws IOException {
    FileOutputStream fileOutputStream = paramContext.openFileOutput(paramString1, 0);
    try {
      fileOutputStream.write(paramString2.getBytes());
      fileOutputStream.flush();
      fileOutputStream.close();
      return;
    } catch (IOException iOException) {
      throw iOException;
    } finally {}
    fileOutputStream.close();
    throw paramString1;
  }
  
  public void a(g paramg) {
    synchronized (this.d) {
      if (!this.d.contains(paramg))
        this.d.add(paramg); 
      return;
    } 
  }
  
  public void a(PLAuthenticationResultCallback paramPLAuthenticationResultCallback) {
    (new Thread(new c(this, paramPLAuthenticationResultCallback))).start();
  }
  
  public final void a(boolean paramBoolean) {
    a = paramBoolean;
  }
  
  public String b(String paramString) throws URISyntaxException, a.a.a.a.a.f.d {
    String str = a(paramString);
    a a = this.f.a(str);
    if (a == null) {
      (new Thread(new a(this, str))).start();
      return paramString;
    } 
    if (!a.a()) {
      StringBuilder stringBuilder1;
      if (a.b()) {
        PrintStream printStream = System.out;
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("PublishLines external ");
        stringBuilder1.append(paramString);
        printStream.println(stringBuilder1.toString());
        return paramString;
      } 
      return a(paramString, (a)stringBuilder1);
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Url is invalid => ");
    stringBuilder.append(paramString);
    throw new a.a.a.a.a.f.d(stringBuilder.toString());
  }
  
  public void b(g paramg) {
    synchronized (this.d) {
      this.d.remove(paramg);
      return;
    } 
  }
  
  public final void b(Context paramContext) {
    if (paramContext != null)
      this.g = paramContext.getApplicationContext(); 
  }
  
  public final void b(PLAuthenticationResultCallback paramPLAuthenticationResultCallback) {
    String str = c(this.g);
    if ("".equals(str)) {
      a.a.a.a.a.e.e.c.e("Zeus", "Invalid package name!");
      countDownLatch = this.j;
      if (countDownLatch != null)
        countDownLatch.countDown(); 
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("https://shortvideo.qiniuapi.com/v1/pstream/license?package=");
    stringBuilder.append(str);
    str = stringBuilder.toString();
    try {
      HttpsURLConnection httpsURLConnection = (HttpsURLConnection)(new URL(str)).openConnection();
      httpsURLConnection.setRequestMethod("GET");
      httpsURLConnection.setConnectTimeout(3000);
      int i = httpsURLConnection.getResponseCode();
      if (i == 200) {
        this.h = e.b;
      } else if (i == 401) {
        this.h = e.c;
        a.a.a.a.a.e.e.c.e("Zeus", "鉴权失败! ! ! 请参阅 https://developer.qiniu.com/pili/sdk/3716/PLDroidMediaStreaming-preparation-before-development#2 前置条件说明并按照流程获取相应鉴权！");
      } else {
        this.h = e.a;
      } 
      if (countDownLatch != null)
        c((PLAuthenticationResultCallback)countDownLatch); 
      g();
    } catch (IOException iOException) {
      if (countDownLatch != null)
        c((PLAuthenticationResultCallback)countDownLatch); 
      iOException.printStackTrace();
    } 
    CountDownLatch countDownLatch = this.j;
    if (countDownLatch != null)
      countDownLatch.countDown(); 
  }
  
  public boolean b() {
    boolean bool = h();
    boolean bool2 = false;
    boolean bool1 = false;
    if (!bool) {
      if (this.h == e.c)
        a.a.a.a.a.e.e.c.e("Zeus", "鉴权失败! ! ! 请参阅 https://developer.qiniu.com/pili/sdk/3716/PLDroidMediaStreaming-preparation-before-development#2 前置条件说明并按照流程获取相应鉴权！"); 
      if (this.h != e.c)
        bool1 = true; 
      return bool1;
    } 
    this.j = new CountDownLatch(1);
    a((PLAuthenticationResultCallback)null);
    try {
      this.j.await();
    } catch (InterruptedException interruptedException) {
      a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.c;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Authorize failed : ");
      stringBuilder.append(interruptedException.getMessage());
      e1.e("Zeus", stringBuilder.toString());
    } 
    this.j = null;
    bool1 = bool2;
    if (this.h != e.c)
      bool1 = true; 
    return bool1;
  }
  
  public final String c(Context paramContext) {
    return (paramContext != null) ? h.l(paramContext) : "";
  }
  
  public final void c() {
    Context context = this.g;
    if (context == null)
      return; 
    try {
      f f = d(a(context, "pili_config.json"));
      this.f.a(f.a, f.b, f.c, f.d);
    } catch (Exception exception) {}
    d();
  }
  
  public final void c(PLAuthenticationResultCallback paramPLAuthenticationResultCallback) {
    (new Handler(Looper.getMainLooper())).post(new d(this, paramPLAuthenticationResultCallback));
  }
  
  public Integer[] c(String paramString) {
    return this.f.b(paramString);
  }
  
  public f d(String paramString) throws JSONException {
    JSONObject jSONObject1 = new JSONObject(paramString);
    f f = new f();
    f.d = jSONObject1.optInt("ttl", 3600);
    JSONArray jSONArray = jSONObject1.optJSONArray("forbiddenDomains");
    if (jSONArray != null && jSONArray.length() != 0)
      for (int i = 0; i < jSONArray.length(); i++)
        f.a.add(jSONArray.getString(i));  
    JSONObject jSONObject2 = jSONObject1.optJSONObject("publishLines");
    if (jSONObject2 != null) {
      Iterator<String> iterator = jSONObject2.keys();
      while (iterator.hasNext()) {
        String str = iterator.next();
        JSONArray jSONArray1 = jSONObject2.getJSONArray(str);
        ArrayList<String> arrayList = new ArrayList();
        if (jSONArray1 != null && jSONArray1.length() != 0)
          for (int i = 0; i < jSONArray1.length(); i++) {
            String str1 = jSONArray1.getString(i);
            if (str1 != null && !str1.equals(""))
              arrayList.add(str1); 
          }  
        f.b.put(str, arrayList);
      } 
    } 
    jSONObject1 = jSONObject1.optJSONObject("config");
    if (jSONObject1 != null) {
      Iterator<String> iterator = jSONObject1.keys();
      while (iterator.hasNext()) {
        String str = iterator.next();
        JSONObject jSONObject = jSONObject1.optJSONObject(str);
        if (jSONObject != null) {
          int i = jSONObject.optInt("publishQuic", 2);
          JSONArray jSONArray1 = jSONObject.optJSONArray("quicPort");
          if (jSONArray1 != null && jSONArray1.length() == 2) {
            int j = h.d(jSONArray1.optInt(0), jSONArray1.optInt(1));
            f.c.put(str, new Integer[] { Integer.valueOf(i), Integer.valueOf(j) });
          } 
        } 
      } 
    } 
    return f;
  }
  
  public final void d() {
    ArrayList<g> arrayList;
    Iterator<g> iterator;
    synchronized (this.d) {
      ArrayList<g> arrayList1 = new ArrayList<g>(this.d);
      iterator = arrayList1.iterator();
      while (iterator.hasNext())
        ((g)iterator.next()).a(); 
      return;
    } 
  }
  
  public final void e() {
    (new Thread(new b(this))).start();
  }
  
  public final void e(String paramString) {
    Context context = this.g;
    if (context == null)
      return; 
    try {
      a(context, "pili_config.json", paramString);
      return;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return;
    } 
  }
  
  public final JSONObject f(String paramString) {
    ArrayList<String> arrayList = this.f.a();
    if (paramString != null && !arrayList.contains(paramString))
      arrayList.add(paramString); 
    if (arrayList.size() == 0)
      return null; 
    JSONObject jSONObject = new JSONObject();
    JSONArray jSONArray = new JSONArray(arrayList);
    try {
      String str;
      jSONObject.put("publishDomains", jSONArray);
      if (this.g == null) {
        str = h.i();
      } else {
        str = h.k(this.g);
      } 
      jSONObject.put("deviceID", str);
      jSONObject.put("osPlatform", "Android");
      jSONObject.put("osVersion", h.j());
      jSONObject.put("sdkName", "pili-android-streaming-kit");
      jSONObject.put("sdkVersion", "3.0.0");
      Context context = this.g;
      if (context != null) {
        jSONObject.put("appPackageName", h.g(this.g));
        return jSONObject;
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject;
  }
  
  public final void f() {
    SharedPreferences sharedPreferences = this.g.getSharedPreferences("PLDroidStreaming", 0);
    String str = sharedPreferences.getString("ts", "");
    if (!"".equals(str))
      this.i = Long.valueOf(new String(Base64.decode(str, 0))).longValue(); 
    int i = sharedPreferences.getInt("authStatus", 0);
    if (i != 1) {
      if (i != 2) {
        this.h = e.a;
      } else {
        this.h = e.c;
      } 
    } else {
      this.h = e.b;
    } 
    if (h()) {
      a((PLAuthenticationResultCallback)null);
      return;
    } 
    if (this.h == e.c)
      a.a.a.a.a.e.e.c.e("Zeus", "鉴权失败! ! ! 请参阅 https://developer.qiniu.com/pili/sdk/3716/PLDroidMediaStreaming-preparation-before-development#2 前置条件说明并按照流程获取相应鉴权！"); 
  }
  
  public final void g() {
    this.i = System.currentTimeMillis();
    Context context = this.g;
    if (context != null) {
      SharedPreferences.Editor editor = context.getSharedPreferences("PLDroidStreaming", 0).edit();
      editor.putString("ts", Base64.encodeToString(String.valueOf(this.i).getBytes(), 0));
      editor.putInt("authStatus", this.h.ordinal());
      editor.apply();
    } 
  }
  
  public final void g(String paramString) {
    JSONObject jSONObject = f(paramString);
    if (jSONObject == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.e);
    stringBuilder.append("/v2/config");
    String str = a(stringBuilder.toString(), (String)null, jSONObject);
    try {
      f f = d(str);
      e(str);
      this.f.a(f.a, f.b, f.c, f.d);
      d();
      return;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return;
    } 
  }
  
  public final boolean h() {
    long l = System.currentTimeMillis() - this.i;
    e e1 = this.h;
    return (e1 == e.a || (e1 == e.b && l > 86400000L) || (this.h == e.c && l > 300000L));
  }
  
  public class a implements Runnable {
    public a(b this$0, String param1String) {}
    
    public void run() {
      b.a(this.b, this.a);
    }
  }
  
  public class b implements Runnable {
    public b(b this$0) {}
    
    public void run() {
      b.a(this.a);
      b.a(this.a, (String)null);
    }
  }
  
  public class c implements Runnable {
    public c(b this$0, PLAuthenticationResultCallback param1PLAuthenticationResultCallback) {}
    
    public void run() {
      b.a(this.b, this.a);
    }
  }
  
  public class d implements Runnable {
    public d(b this$0, PLAuthenticationResultCallback param1PLAuthenticationResultCallback) {}
    
    public void run() {
      if (b.b(this.b) == b.e.b) {
        this.a.onAuthorizationResult(1);
        return;
      } 
      if (b.b(this.b) == b.e.c) {
        this.a.onAuthorizationResult(0);
        return;
      } 
      this.a.onAuthorizationResult(-1);
    }
  }
  
  public enum e {
    a, b, c;
    
    static {
      e e1 = new e("UnAuthorized", 2);
      c = e1;
      d = new e[] { a, b, e1 };
    }
  }
  
  public static class f {
    public final ArrayList<String> a = new ArrayList<String>();
    
    public final HashMap<String, ArrayList<String>> b = new HashMap<String, ArrayList<String>>();
    
    public final HashMap<String, Integer[]> c = (HashMap)new HashMap<String, Integer>();
    
    public int d = 3600;
  }
  
  public static interface g {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\n\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */