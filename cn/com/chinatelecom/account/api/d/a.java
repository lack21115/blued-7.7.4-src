package cn.com.chinatelecom.account.api.d;

import android.content.Context;
import android.net.Network;
import android.os.Build;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.a.d;
import cn.com.chinatelecom.account.api.c.b;
import cn.com.chinatelecom.account.api.c.d;
import cn.com.chinatelecom.account.api.c.f;
import cn.com.chinatelecom.account.api.c.g;
import cn.com.chinatelecom.account.api.c.h;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
  private static final String a = a.class.getSimpleName();
  
  private static HashMap<String, String> b = new HashMap<String, String>();
  
  public static long a(Context paramContext) {
    return c.b(paramContext, "key_difference_time", 0L);
  }
  
  public static d a(Context paramContext, HttpURLConnection paramHttpURLConnection, boolean paramBoolean) {
    // Byte code:
    //   0: iload_2
    //   1: ifne -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new cn/com/chinatelecom/account/api/c/d
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore #4
    //   15: aload_1
    //   16: invokevirtual getHeaderFields : ()Ljava/util/Map;
    //   19: astore_1
    //   20: aload_1
    //   21: ldc 'p'
    //   23: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast java/util/List
    //   31: astore #5
    //   33: aload #5
    //   35: ifnull -> 112
    //   38: aload #5
    //   40: invokeinterface size : ()I
    //   45: ifle -> 112
    //   48: aload #5
    //   50: iconst_0
    //   51: invokeinterface get : (I)Ljava/lang/Object;
    //   56: checkcast java/lang/String
    //   59: astore #5
    //   61: getstatic cn/com/chinatelecom/account/api/d/a.a : Ljava/lang/String;
    //   64: astore #6
    //   66: new java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial <init> : ()V
    //   73: astore #7
    //   75: aload #7
    //   77: ldc 'request protocol : '
    //   79: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload #7
    //   85: aload #5
    //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload #6
    //   93: aload #7
    //   95: invokevirtual toString : ()Ljava/lang/String;
    //   98: invokestatic info : (Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload #4
    //   103: aload_0
    //   104: aload #5
    //   106: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   109: putfield b : Z
    //   112: aload_1
    //   113: ldc 'Set-Cookie'
    //   115: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   120: checkcast java/util/List
    //   123: astore #5
    //   125: aload #5
    //   127: ifnull -> 199
    //   130: aload #5
    //   132: invokeinterface size : ()I
    //   137: ifle -> 199
    //   140: iconst_0
    //   141: istore_3
    //   142: iload_3
    //   143: aload #5
    //   145: invokeinterface size : ()I
    //   150: if_icmpge -> 199
    //   153: aload #5
    //   155: iconst_0
    //   156: invokeinterface get : (I)Ljava/lang/Object;
    //   161: checkcast java/lang/String
    //   164: astore #6
    //   166: aload #6
    //   168: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   171: ifne -> 389
    //   174: aload #6
    //   176: ldc 'gw_auth'
    //   178: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   181: ifeq -> 389
    //   184: aload #4
    //   186: aload #6
    //   188: ldc 'gw_auth'
    //   190: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   193: putfield a : Ljava/lang/String;
    //   196: goto -> 199
    //   199: aload_1
    //   200: ldc 'Log-Level'
    //   202: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   207: checkcast java/util/List
    //   210: astore #5
    //   212: aload #5
    //   214: ifnull -> 270
    //   217: aload #5
    //   219: invokeinterface isEmpty : ()Z
    //   224: ifne -> 270
    //   227: iconst_0
    //   228: istore_3
    //   229: iload_3
    //   230: aload #5
    //   232: invokeinterface size : ()I
    //   237: if_icmpge -> 270
    //   240: aload #5
    //   242: iconst_0
    //   243: invokeinterface get : (I)Ljava/lang/Object;
    //   248: checkcast java/lang/String
    //   251: astore #6
    //   253: aload #6
    //   255: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   258: ifne -> 396
    //   261: aload_0
    //   262: aload #6
    //   264: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   267: goto -> 396
    //   270: aload_1
    //   271: ldc 'p-reset'
    //   273: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   278: checkcast java/util/List
    //   281: astore #5
    //   283: aload #5
    //   285: ifnull -> 325
    //   288: aload #5
    //   290: invokeinterface isEmpty : ()Z
    //   295: ifne -> 325
    //   298: aload #5
    //   300: iconst_0
    //   301: invokeinterface get : (I)Ljava/lang/Object;
    //   306: checkcast java/lang/String
    //   309: astore #5
    //   311: aload #5
    //   313: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   316: ifne -> 325
    //   319: aload_0
    //   320: aload #5
    //   322: invokestatic b : (Landroid/content/Context;Ljava/lang/String;)V
    //   325: aload_1
    //   326: ldc 'p-ikgx'
    //   328: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   333: checkcast java/util/List
    //   336: astore_0
    //   337: aload_0
    //   338: ifnull -> 386
    //   341: aload_0
    //   342: invokeinterface isEmpty : ()Z
    //   347: ifne -> 386
    //   350: aload_0
    //   351: iconst_0
    //   352: invokeinterface get : (I)Ljava/lang/Object;
    //   357: checkcast java/lang/String
    //   360: astore_0
    //   361: aload_0
    //   362: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   365: ifne -> 386
    //   368: aload #4
    //   370: aload_0
    //   371: putfield c : Ljava/lang/String;
    //   374: aload_0
    //   375: putstatic cn/com/chinatelecom/account/api/d/g.d : Ljava/lang/String;
    //   378: aload #4
    //   380: areturn
    //   381: astore_0
    //   382: aload_0
    //   383: invokevirtual printStackTrace : ()V
    //   386: aload #4
    //   388: areturn
    //   389: iload_3
    //   390: iconst_1
    //   391: iadd
    //   392: istore_3
    //   393: goto -> 142
    //   396: iload_3
    //   397: iconst_1
    //   398: iadd
    //   399: istore_3
    //   400: goto -> 229
    // Exception table:
    //   from	to	target	type
    //   15	33	381	finally
    //   38	112	381	finally
    //   112	125	381	finally
    //   130	140	381	finally
    //   142	196	381	finally
    //   199	212	381	finally
    //   217	227	381	finally
    //   229	267	381	finally
    //   270	283	381	finally
    //   288	325	381	finally
    //   325	337	381	finally
    //   341	378	381	finally
  }
  
  public static d a(HttpURLConnection paramHttpURLConnection) {
    d d = new d();
    try {
      Map<String, List<String>> map = paramHttpURLConnection.getHeaderFields();
      List<String> list2 = map.get("rdt_allow");
      if (list2 != null && list2.size() > 0) {
        d.d = list2.get(0);
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("request method : ");
        stringBuilder.append(d.d);
        CtAuth.info(str, stringBuilder.toString());
      } 
      List<String> list1 = map.get("p-ikgx");
    } finally {
      paramHttpURLConnection = null;
    } 
    return d;
  }
  
  public static String a(Context paramContext, h paramh, String paramString1, Network paramNetwork, boolean paramBoolean, String paramString2) {
    int i;
    ArrayList<String> arrayList;
    if (paramh == null || TextUtils.isEmpty(paramh.b))
      return j.b(); 
    if (paramh.a == -1)
      return paramh.b; 
    try {
      JSONObject jSONObject = new JSONObject(paramh.b);
      i = jSONObject.optInt("result");
      String str = jSONObject.optString("data");
      if ((i == 0 || i == 30002) && !TextUtils.isEmpty(str)) {
        str = h.a(str, paramString1);
        boolean bool = TextUtils.isEmpty(str);
        if (!bool) {
          try {
            JSONObject jSONObject1 = new JSONObject(str);
            jSONObject.put("data", jSONObject1);
            jSONObject1.put("gwAuth", paramh.d);
          } catch (JSONException jSONException) {
            jSONException.printStackTrace();
            jSONObject.put("data", null);
          } 
          if (i == 30002 && paramBoolean) {
            JSONObject jSONObject1 = (JSONObject)jSONObject.opt("data");
            arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject1.optJSONArray("urls");
            if (jSONArray != null)
              for (i = 0; i < jSONArray.length(); i++)
                arrayList.add(jSONArray.getString(i));  
            return arrayList.isEmpty() ? null : a(paramContext, arrayList, paramString1, paramNetwork, paramString2);
          } 
          return arrayList.toString();
        } 
        return paramh.b;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return paramh.b;
    } 
    if (i == -10009 || i == -30001) {
      long l = arrayList.optLong("timeStamp", -1L);
      if (l == -1L) {
        d((Context)exception);
      } else {
        a((Context)exception, l);
      } 
    } 
    return paramh.b;
  }
  
  private static String a(Context paramContext, List<String> paramList, String paramString1, Network paramNetwork, String paramString2) {
    int i;
    for (i = 0; i < paramList.size(); i++) {
      Exception exception;
      try {
        String str = paramList.get(i);
        if (TextUtils.isEmpty(str))
          continue; 
        if (!g.c(paramContext) && Build.VERSION.SDK_INT < 21)
          f.a(paramContext, str); 
        g.a a1 = new g.a();
        try {
          a1.b(paramString2);
          try {
            a1.a(paramNetwork);
            g g = a1.a();
            str = a(paramContext, (new b(paramContext)).a(str, "", 0, g), paramString1, paramNetwork, false, paramString2);
            try {
              int j = (new JSONObject(str)).optInt("result");
              if (j == 0)
                return str; 
            } catch (Exception null) {
              exception.printStackTrace();
            } 
          } finally {}
        } finally {}
      } finally {}
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(d.a(j.b));
    stringBuilder.append("- redirect 30002 ");
    return j.a(80001, stringBuilder.toString());
  }
  
  private static String a(String paramString1, String paramString2) {
    try {
      String[] arrayOfString = paramString1.split(";");
      for (int i = 0; i < arrayOfString.length; i++) {
        if (arrayOfString[i].contains(paramString2))
          return arrayOfString[i].split("=")[1]; 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return "";
  }
  
  private static void a(Context paramContext, int paramInt) {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{cn/com/chinatelecom/account/api/d/a}} */
    try {
      c.a(paramContext, "key_p_a_p_v3.7.3", paramInt);
    } catch (Exception exception) {
      exception.printStackTrace();
    } finally {}
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{cn/com/chinatelecom/account/api/d/a}} */
  }
  
  private static void a(Context paramContext, long paramLong) {
    if (paramLong > 0L)
      c.a(paramContext, "key_difference_time", paramLong - System.currentTimeMillis()); 
  }
  
  public static boolean a(Context paramContext, String paramString) {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{cn/com/chinatelecom/account/api/d/a}} */
    if (paramString == null) {
      /* monitor exit TypeReferenceDotClassExpression{ObjectType{cn/com/chinatelecom/account/api/d/a}} */
      return false;
    } 
    try {
      String str;
      if (!"http".equals(paramString.toLowerCase())) {
        boolean bool2 = "https".equals(paramString.toLowerCase());
        if (!bool2) {
          /* monitor exit TypeReferenceDotClassExpression{ObjectType{cn/com/chinatelecom/account/api/d/a}} */
          return false;
        } 
      } 
      if (e(paramContext) == 1) {
        str = "https";
      } else {
        str = "http";
      } 
      boolean bool1 = str.equals(paramString.toLowerCase());
      if (bool1) {
        /* monitor exit TypeReferenceDotClassExpression{ObjectType{cn/com/chinatelecom/account/api/d/a}} */
        return false;
      } 
      if (paramString.toLowerCase().equals("https")) {
        boolean bool2 = true;
        a(paramContext, bool2);
        /* monitor exit TypeReferenceDotClassExpression{ObjectType{cn/com/chinatelecom/account/api/d/a}} */
        return true;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      /* monitor exit TypeReferenceDotClassExpression{ObjectType{cn/com/chinatelecom/account/api/d/a}} */
      return false;
    } finally {}
    boolean bool = false;
    a(paramContext, bool);
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{cn/com/chinatelecom/account/api/d/a}} */
    return true;
  }
  
  private static void b(Context paramContext, String paramString) {
    c.a(paramContext, "key_p_rset_v3.7.3", paramString);
  }
  
  public static boolean b(Context paramContext) {
    /* monitor enter TypeReferenceDotClassExpression{ObjectType{cn/com/chinatelecom/account/api/d/a}} */
    try {
      int i = e(paramContext);
      if (i == 0) {
        boolean bool1 = true;
        /* monitor exit TypeReferenceDotClassExpression{ObjectType{cn/com/chinatelecom/account/api/d/a}} */
        return bool1;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } finally {}
    boolean bool = false;
    /* monitor exit TypeReferenceDotClassExpression{ObjectType{cn/com/chinatelecom/account/api/d/a}} */
    return bool;
  }
  
  public static String c(Context paramContext) {
    // Byte code:
    //   0: ldc cn/com/chinatelecom/account/api/d/a
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic b : (Landroid/content/Context;)Z
    //   7: ifeq -> 17
    //   10: ldc cn/com/chinatelecom/account/api/d/a
    //   12: monitorexit
    //   13: ldc_w 'pe'
    //   16: areturn
    //   17: ldc cn/com/chinatelecom/account/api/d/a
    //   19: monitorexit
    //   20: ldc_w 'presdk'
    //   23: areturn
    //   24: astore_0
    //   25: ldc cn/com/chinatelecom/account/api/d/a
    //   27: monitorexit
    //   28: aload_0
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   3	10	24	finally
  }
  
  private static void d(Context paramContext) {
    String str1 = d.a();
    g.a a1 = new g.a();
    a1.a("reqTimestamp");
    a1.b(str1);
    g g = a1.a();
    String str2 = ((new b(paramContext)).a(g.b(), "", 1, g)).b;
    if (!TextUtils.isEmpty(str2)) {
      JSONObject jSONObject;
      g = null;
      try {
        JSONObject jSONObject1 = new JSONObject(str2);
        jSONObject = jSONObject1;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      if (jSONObject != null)
        a(paramContext, jSONObject.optLong("msg", -1L)); 
    } 
  }
  
  private static int e(Context paramContext) {
    // Byte code:
    //   0: ldc cn/com/chinatelecom/account/api/d/a
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc_w 'key_p_a_p_v3.7.3'
    //   7: iconst_1
    //   8: invokestatic b : (Landroid/content/Context;Ljava/lang/String;I)I
    //   11: istore_1
    //   12: ldc cn/com/chinatelecom/account/api/d/a
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: astore_0
    //   18: ldc cn/com/chinatelecom/account/api/d/a
    //   20: monitorexit
    //   21: aload_0
    //   22: athrow
    // Exception table:
    //   from	to	target	type
    //   3	12	17	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */