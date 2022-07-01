package a.a.a.a.a.k.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
  public static c a = new c();
  
  public final Object b = new Object();
  
  public final b c = new a();
  
  public Map<String, String[]> d = (Map)new HashMap<String, String>();
  
  public Map<String, ArrayList<e>> e = new HashMap<String, ArrayList<e>>();
  
  public String f = "";
  
  public int g = 3600;
  
  public Context h;
  
  public Map<String, Long> i = new HashMap<String, Long>();
  
  public boolean j = false;
  
  public boolean k = true;
  
  public g l = new g(null);
  
  public static c a() {
    return a;
  }
  
  public e a(String paramString, int paramInt) {
    // Byte code:
    //   0: invokestatic a : ()Ljava/lang/String;
    //   3: aload_0
    //   4: getfield f : Ljava/lang/String;
    //   7: invokevirtual equals : (Ljava/lang/Object;)Z
    //   10: ifne -> 19
    //   13: aload_0
    //   14: invokevirtual b : ()V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield e : Ljava/util/Map;
    //   25: aload_1
    //   26: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast java/util/ArrayList
    //   34: astore_1
    //   35: aload_1
    //   36: ifnull -> 95
    //   39: aload_1
    //   40: invokevirtual size : ()I
    //   43: ifne -> 49
    //   46: goto -> 95
    //   49: iload_2
    //   50: ifle -> 82
    //   53: iload_2
    //   54: aload_0
    //   55: getfield e : Ljava/util/Map;
    //   58: invokeinterface size : ()I
    //   63: if_icmple -> 69
    //   66: goto -> 82
    //   69: aload_1
    //   70: iload_2
    //   71: invokevirtual get : (I)Ljava/lang/Object;
    //   74: checkcast a/a/a/a/a/k/e/c$e
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: areturn
    //   82: aload_1
    //   83: iconst_0
    //   84: invokevirtual get : (I)Ljava/lang/Object;
    //   87: checkcast a/a/a/a/a/k/e/c$e
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: areturn
    //   95: aload_0
    //   96: monitorexit
    //   97: aconst_null
    //   98: areturn
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    // Exception table:
    //   from	to	target	type
    //   21	35	99	finally
    //   39	46	99	finally
    //   53	66	99	finally
    //   69	80	99	finally
    //   82	93	99	finally
    //   95	97	99	finally
    //   100	102	99	finally
  }
  
  public final ArrayList<e> a(String[] paramArrayOfString, ArrayList<e> paramArrayList) {
    ArrayList<e> arrayList = new ArrayList();
    int j = paramArrayOfString.length;
    for (int i = 0; i < j; i++) {
      String str = paramArrayOfString[i];
      for (e e : paramArrayList) {
        if (e.a.equals(str))
          arrayList.add(e); 
      } 
    } 
    return (arrayList.size() != paramArrayList.size()) ? paramArrayList : arrayList;
  }
  
  public final JSONObject a(String paramString, ArrayList<e> paramArrayList) {
    JSONObject jSONObject = new JSONObject();
    JSONArray jSONArray = new JSONArray();
    try {
      jSONObject.put("method", "publish");
      jSONObject.put("net", a.a.a.a.a.k.c.a.b(this.h));
    } catch (JSONException jSONException) {}
    int i = 0;
    while (true) {
      if (i < paramArrayList.size()) {
        e e = paramArrayList.get(i);
        JSONObject jSONObject1 = new JSONObject();
        try {
          String str = e.e;
          if (str == null) {
            jSONObject1.put("domain", paramString);
          } else {
            jSONObject1.put("domain", e.e);
          } 
          jSONObject1.put("serverIP", e.a);
          jSONObject1.put("sendBytes", 65536);
          jSONObject1.put("connect", e.b);
          jSONObject1.put("durationMs", e.c);
          str = e.d;
          if (str != null)
            jSONObject1.put("error", e.d); 
          jSONArray.put(jSONObject1);
        } catch (JSONException jSONException) {}
        i++;
        continue;
      } 
      try {
        jSONObject.put("speeds", jSONArray);
        return jSONObject;
      } catch (JSONException jSONException) {
        return jSONObject;
      } 
    } 
  }
  
  public void a(Context paramContext) {
    if (this.h != null)
      return; 
    this.h = paramContext.getApplicationContext();
    c();
  }
  
  public final void a(String paramString, f[] paramArrayOff, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield h : Landroid/content/Context;
    //   4: invokestatic c : (Landroid/content/Context;)Z
    //   7: ifeq -> 11
    //   10: return
    //   11: invokestatic a : ()Ljava/lang/String;
    //   14: astore #8
    //   16: invokestatic currentTimeMillis : ()J
    //   19: lstore #6
    //   21: aload_0
    //   22: getfield i : Ljava/util/Map;
    //   25: aload_1
    //   26: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast java/lang/Long
    //   34: astore #9
    //   36: aload #8
    //   38: aload_0
    //   39: getfield f : Ljava/lang/String;
    //   42: invokevirtual equals : (Ljava/lang/Object;)Z
    //   45: ifeq -> 75
    //   48: aload #9
    //   50: ifnull -> 75
    //   53: lload #6
    //   55: aload #9
    //   57: invokevirtual longValue : ()J
    //   60: lsub
    //   61: aload_0
    //   62: getfield g : I
    //   65: sipush #1000
    //   68: imul
    //   69: i2l
    //   70: lcmp
    //   71: ifge -> 75
    //   74: return
    //   75: new java/util/ArrayList
    //   78: dup
    //   79: invokespecial <init> : ()V
    //   82: astore #9
    //   84: aload_2
    //   85: arraylength
    //   86: istore #5
    //   88: iconst_0
    //   89: istore #4
    //   91: iload #4
    //   93: iload #5
    //   95: if_icmpge -> 187
    //   98: aload_2
    //   99: iload #4
    //   101: aaload
    //   102: astore #10
    //   104: invokestatic getDefault : ()Ljava/util/Locale;
    //   107: ldc 'http://%s:%d/%s'
    //   109: iconst_3
    //   110: anewarray java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: aload #10
    //   117: invokestatic a : (La/a/a/a/a/k/e/c$f;)Ljava/lang/String;
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: sipush #1230
    //   126: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   129: aastore
    //   130: dup
    //   131: iconst_2
    //   132: ldc_w 'ping'
    //   135: aastore
    //   136: invokestatic format : (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   139: astore #11
    //   141: aload_0
    //   142: getfield c : La/a/a/a/a/k/e/b;
    //   145: aload #11
    //   147: iload_3
    //   148: invokeinterface a : (Ljava/lang/String;I)La/a/a/a/a/k/e/c$e;
    //   153: astore #11
    //   155: aload #11
    //   157: ifnull -> 178
    //   160: aload #11
    //   162: aload #10
    //   164: invokestatic b : (La/a/a/a/a/k/e/c$f;)Ljava/lang/String;
    //   167: putfield e : Ljava/lang/String;
    //   170: aload #9
    //   172: aload #11
    //   174: invokevirtual add : (Ljava/lang/Object;)Z
    //   177: pop
    //   178: iload #4
    //   180: iconst_1
    //   181: iadd
    //   182: istore #4
    //   184: goto -> 91
    //   187: aload #9
    //   189: new a/a/a/a/a/k/e/c$d
    //   192: dup
    //   193: aload_0
    //   194: invokespecial <init> : (La/a/a/a/a/k/e/c;)V
    //   197: invokestatic sort : (Ljava/util/List;Ljava/util/Comparator;)V
    //   200: aload_0
    //   201: monitorenter
    //   202: aload_0
    //   203: getfield e : Ljava/util/Map;
    //   206: aload_1
    //   207: aload_0
    //   208: aload #9
    //   210: invokevirtual b : (Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   213: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   218: pop
    //   219: aload_0
    //   220: monitorexit
    //   221: aload_0
    //   222: aload_1
    //   223: aload #9
    //   225: invokevirtual b : (Ljava/lang/String;Ljava/util/ArrayList;)[Ljava/lang/String;
    //   228: astore_2
    //   229: aload_2
    //   230: ifnonnull -> 234
    //   233: return
    //   234: aload_0
    //   235: aload_2
    //   236: aload #9
    //   238: invokevirtual a : ([Ljava/lang/String;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   241: astore_2
    //   242: aload_0
    //   243: monitorenter
    //   244: aload_0
    //   245: getfield e : Ljava/util/Map;
    //   248: aload_1
    //   249: aload_0
    //   250: aload_2
    //   251: invokevirtual b : (Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   254: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   259: pop
    //   260: aload_0
    //   261: monitorexit
    //   262: aload_0
    //   263: aload #8
    //   265: putfield f : Ljava/lang/String;
    //   268: aload_0
    //   269: getfield i : Ljava/util/Map;
    //   272: aload_1
    //   273: lload #6
    //   275: invokestatic valueOf : (J)Ljava/lang/Long;
    //   278: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   283: pop
    //   284: return
    //   285: astore_1
    //   286: aload_0
    //   287: monitorexit
    //   288: aload_1
    //   289: athrow
    //   290: astore_1
    //   291: aload_0
    //   292: monitorexit
    //   293: aload_1
    //   294: athrow
    // Exception table:
    //   from	to	target	type
    //   202	221	290	finally
    //   244	262	285	finally
    //   286	288	285	finally
    //   291	293	290	finally
  }
  
  public void a(String paramString, String[] paramArrayOfString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Ljava/util/Map;
    //   6: aload_1
    //   7: aload_2
    //   8: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   13: pop
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	17	finally
    //   18	20	17	finally
  }
  
  public final void a(ArrayList<e> paramArrayList) {
    JSONObject jSONObject = a((String)null, paramArrayList);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("http://pili-zeus.qiniuapi.com");
    stringBuilder.append("/v1/quality");
    a.a.a.a.a.k.c.a.a(stringBuilder.toString(), null, jSONObject);
  }
  
  public final void a(String[] paramArrayOfString) {
    if (Build.VERSION.SDK_INT < 15)
      return; 
    if (paramArrayOfString != null) {
      if (paramArrayOfString.length == 0)
        return; 
      AsyncTask.execute(new c(this, paramArrayOfString));
    } 
  }
  
  public final f[] a(String paramString, InetAddress[] paramArrayOfInetAddress) {
    ArrayList<f> arrayList = new ArrayList();
    int j = paramArrayOfInetAddress.length;
    for (int i = 0; i < j; i++)
      arrayList.add(new f(paramString, paramArrayOfInetAddress[i].getHostAddress())); 
    if (paramArrayOfInetAddress.length <= 2)
      return arrayList.<f>toArray(new f[paramArrayOfInetAddress.length]); 
    Collections.sort(arrayList);
    return new f[] { arrayList.get(0), arrayList.get(arrayList.size() - 1) };
  }
  
  public final String[] a(String paramString) {
    String[] arrayOfString2 = null;
    if (paramString == null)
      return null; 
    String[] arrayOfString1 = arrayOfString2;
    try {
      JSONObject jSONObject = new JSONObject(paramString);
      arrayOfString1 = arrayOfString2;
      int i = jSONObject.getInt("ttl");
      if (i > 600) {
        arrayOfString1 = arrayOfString2;
        this.g = i;
      } 
      arrayOfString1 = arrayOfString2;
      String[] arrayOfString = a(jSONObject, "ips");
      arrayOfString1 = arrayOfString;
      a(a(jSONObject, "tasks"));
      return arrayOfString;
    } catch (JSONException jSONException) {
      return arrayOfString1;
    } 
  }
  
  public final String[] a(JSONObject paramJSONObject, String paramString) throws JSONException {
    JSONArray jSONArray = paramJSONObject.getJSONArray(paramString);
    if (jSONArray == null || jSONArray.length() == 0)
      return null; 
    String[] arrayOfString = new String[jSONArray.length()];
    for (int i = 0; i < jSONArray.length(); i++)
      arrayOfString[i] = jSONArray.getString(i); 
    return arrayOfString;
  }
  
  public final ArrayList<e> b(ArrayList<e> paramArrayList) {
    ArrayList<e> arrayList = new ArrayList();
    for (e e : paramArrayList) {
      if (e.d == null)
        arrayList.add(e); 
    } 
    return arrayList;
  }
  
  public void b() {
    if (Build.VERSION.SDK_INT < 15)
      return; 
    if (!this.k)
      return; 
    synchronized (this.b) {
      if (this.j)
        return; 
      this.j = true;
      AsyncTask.execute(new a(this));
      return;
    } 
  }
  
  public final f[] b(String[] paramArrayOfString) {
    int i = 0;
    if (paramArrayOfString == null || paramArrayOfString.length == 0)
      return new f[0]; 
    if (paramArrayOfString.length == 1)
      try {
        InetAddress[] arrayOfInetAddress = InetAddress.getAllByName(paramArrayOfString[0]);
        return a(paramArrayOfString[0], arrayOfInetAddress);
      } catch (UnknownHostException unknownHostException) {
        unknownHostException.printStackTrace();
        return new f[0];
      }  
    ArrayList<f> arrayList = new ArrayList();
    int j = unknownHostException.length;
    while (i < j) {
      UnknownHostException unknownHostException1 = unknownHostException[i];
      try {
        arrayList.add(new f((String)unknownHostException1, InetAddress.getByName((String)unknownHostException1).getHostAddress()));
      } catch (UnknownHostException unknownHostException2) {
        unknownHostException2.printStackTrace();
      } 
      i++;
    } 
    return arrayList.<f>toArray(new f[arrayList.size()]);
  }
  
  public final String[] b(String paramString, ArrayList<e> paramArrayList) {
    JSONObject jSONObject = a(paramString, paramArrayList);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("http://pili-zeus.qiniuapi.com");
    stringBuilder.append("/v2/query");
    return a(a.a.a.a.a.k.c.a.a(stringBuilder.toString(), null, jSONObject));
  }
  
  public final void c() {
    if (Build.VERSION.SDK_INT < 15)
      return; 
    b b1 = new b(this);
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.h.registerReceiver(b1, intentFilter);
  }
  
  public final boolean d() {
    // Byte code:
    //   0: aload_0
    //   1: getfield h : Landroid/content/Context;
    //   4: ldc_w 'connectivity'
    //   7: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   10: checkcast android/net/ConnectivityManager
    //   13: astore #4
    //   15: iconst_0
    //   16: istore_2
    //   17: aload #4
    //   19: iconst_0
    //   20: invokevirtual getNetworkInfo : (I)Landroid/net/NetworkInfo;
    //   23: astore_3
    //   24: aload #4
    //   26: iconst_1
    //   27: invokevirtual getNetworkInfo : (I)Landroid/net/NetworkInfo;
    //   30: astore #4
    //   32: aload #4
    //   34: ifnull -> 47
    //   37: iload_2
    //   38: istore_1
    //   39: aload #4
    //   41: invokevirtual isConnected : ()Z
    //   44: ifne -> 62
    //   47: aload_3
    //   48: ifnull -> 60
    //   51: iload_2
    //   52: istore_1
    //   53: aload_3
    //   54: invokevirtual isConnected : ()Z
    //   57: ifne -> 62
    //   60: iconst_1
    //   61: istore_1
    //   62: iload_1
    //   63: ireturn
  }
  
  public class a implements Runnable {
    public a(c this$0) {}
    
    public void run() {
      for (Map.Entry<?, ?> entry : (new HashMap<Object, Object>(c.a(this.a))).entrySet()) {
        c.f[] arrayOfF = c.a(this.a, (String[])entry.getValue());
        c.a(this.a, (String)entry.getKey(), arrayOfF, 65536);
      } 
      c.a(this.a, false);
      c.g.a(c.c(this.a), c.b(this.a), new a(this));
    }
    
    public class a implements Runnable {
      public a(c.a this$0) {}
      
      public void run() {
        this.a.a.b();
      }
    }
  }
  
  public class a implements Runnable {
    public a(c this$0) {}
    
    public void run() {
      this.a.a.b();
    }
  }
  
  public class b extends BroadcastReceiver {
    public b(c this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      AsyncTask.execute(new a(this));
    }
    
    public class a implements Runnable {
      public a(c.b this$0) {}
      
      public void run() {
        if (a.a.a.a.a.k.c.a.a().equals(c.d(this.a.a)))
          return; 
        if (c.e(this.a.a))
          return; 
        this.a.a.b();
      }
    }
  }
  
  public class a implements Runnable {
    public a(c this$0) {}
    
    public void run() {
      if (a.a.a.a.a.k.c.a.a().equals(c.d(this.a.a)))
        return; 
      if (c.e(this.a.a))
        return; 
      this.a.a.b();
    }
  }
  
  public class c implements Runnable {
    public c(c this$0, String[] param1ArrayOfString) {}
    
    public void run() {
      if (a.a.a.a.a.k.c.a.c(c.f(this.b)))
        return; 
      ArrayList<c.e> arrayList = new ArrayList();
      for (String str : this.a) {
        str = String.format(Locale.getDefault(), "http://%s:%d/%s", new Object[] { str, Integer.valueOf(1230), "ping" });
        arrayList.add(c.g(this.b).a(str, 65536));
      } 
      c.a(this.b, arrayList);
    }
  }
  
  public class d implements Comparator<e> {
    public d(c this$0) {}
    
    public int a(c.e param1e1, c.e param1e2) {
      int i = param1e1.c;
      int j = param1e2.c;
      return (i < j) ? -1 : ((i == j) ? 0 : 1);
    }
  }
  
  public static class e {
    public final String a;
    
    public final int b;
    
    public final int c;
    
    public final String d;
    
    public String e;
    
    public e(String param1String1, String param1String2, int param1Int1, int param1Int2, String param1String3) {
      this.e = param1String1;
      this.a = param1String2;
      this.b = param1Int1;
      this.c = param1Int2;
      this.d = param1String3;
    }
  }
  
  public static class f implements Comparable<f> {
    public String a;
    
    public String b;
    
    public f(String param1String1, String param1String2) {
      this.a = param1String1;
      this.b = param1String2;
    }
    
    public int c(f param1f) {
      return this.b.compareTo(param1f.b);
    }
  }
  
  public static class g {
    public Handler a = new Handler();
    
    public volatile boolean b = false;
    
    public g() {}
    
    public final void a(int param1Int, Runnable param1Runnable) {
      if (this.b)
        return; 
      this.b = true;
      this.a.postDelayed(new a(this), (param1Int * 1000));
    }
    
    public class a implements Runnable {
      public a(c.g this$0) {}
      
      public void run() {
        c.g.a(this.a, false);
      }
    }
  }
  
  public class a implements Runnable {
    public a(c this$0) {}
    
    public void run() {
      c.g.a(this.a, false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\k\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */